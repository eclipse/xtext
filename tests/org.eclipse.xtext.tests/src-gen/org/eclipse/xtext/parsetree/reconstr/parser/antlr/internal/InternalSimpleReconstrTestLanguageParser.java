package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
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

@SuppressWarnings("all")
public class InternalSimpleReconstrTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'", "'#3'", "'.'", "'#4'", "'myoption'", "'kw'", "'#5'", "'*'", "','", "'#6'", "'v1'", "'v2'", "'#7'", "'kw0'", "'#8'", "'kw1'", "'kw2'", "'kw30'", "'#9'", "'kw3'", "'kw4'", "'kw5'", "'kw6'", "'#10'", "'#11'", "'kw7'", "'#12'", "'interface'", "'class'", "'#13'", "'static'", "'final'", "'transient'", "'#14'", "'item'", "'#15'", "'#16'", "'refs'", "'#17'", "'#18'", "'ka'", "'kb'", "'#19'", "'kx'", "'ky'", "'kz'", "'#20'", "'#21'", "'lit1'", "'lit2'"
    };
    public static final int T__42=42;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__57=57;
    public static final int T__23=23;
    public static final int T__51=51;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__69=69;
    public static final int T__47=47;
    public static final int T__50=50;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__19=19;
    public static final int T__67=67;
    public static final int T__39=39;
    public static final int T__30=30;
    public static final int T__52=52;
    public static final int T__46=46;
    public static final int T__68=68;
    public static final int T__17=17;
    public static final int T__62=62;
    public static final int RULE_INT=5;
    public static final int T__27=27;
    public static final int T__24=24;
    public static final int T__49=49;
    public static final int T__61=61;
    public static final int T__59=59;
    public static final int T__54=54;
    public static final int T__48=48;
    public static final int T__34=34;
    public static final int T__56=56;
    public static final int T__15=15;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__35=35;
    public static final int RULE_ID=4;
    public static final int T__36=36;
    public static final int T__20=20;
    public static final int T__58=58;
    public static final int T__64=64;
    public static final int T__44=44;
    public static final int T__66=66;
    public static final int T__14=14;
    public static final int T__33=33;
    public static final int T__22=22;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__29=29;
    public static final int T__45=45;
    public static final int RULE_WS=9;
    public static final int T__63=63;
    public static final int T__43=43;
    public static final int T__31=31;
    public static final int T__40=40;
    public static final int EOF=-1;
    public static final int T__53=53;
    public static final int T__16=16;
    public static final int T__32=32;
    public static final int T__38=38;
    public static final int T__37=37;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__60=60;
    public static final int T__41=41;
    public static final int T__18=18;

    // delegates
    // delegators


        public InternalSimpleReconstrTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleReconstrTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g"; }



     	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, IAstFactory factory, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Op";	
       	}
       	
       	@Override
       	protected SimpleReconstrTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleOp"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:72:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:73:2: (iv_ruleOp= ruleOp EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:74:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOpRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_entryRuleOp75);
            iv_ruleOp=ruleOp();

            state._fsp--;

             current =iv_ruleOp; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOp85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:81:1: ruleOp returns [EObject current=null] : (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term_0 = null;

        EObject lv_values_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:86:6: ( (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:87:1: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:87:1: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:88:5: this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getOpAccess().getTermParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp132);
            this_Term_0=ruleTerm();

            state._fsp--;

             
                    current = this_Term_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:1: ( () ( (lv_values_2_0= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||LA1_0==21||LA1_0==23||LA1_0==26||LA1_0==29||(LA1_0>=32 && LA1_0<=36)||(LA1_0>=38 && LA1_0<=39)||LA1_0==44||LA1_0==46||LA1_0==49||LA1_0==53||(LA1_0>=55 && LA1_0<=56)||(LA1_0>=58 && LA1_0<=59)||LA1_0==62||(LA1_0>=66 && LA1_0<=67)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:2: () ( (lv_values_2_0= ruleTerm ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:96:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:97:5: 
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

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:112:2: ( (lv_values_2_0= ruleTerm ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:113:1: (lv_values_2_0= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:113:1: (lv_values_2_0= ruleTerm )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:114:3: lv_values_2_0= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOpAccess().getValuesTermParserRuleCall_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp162);
            	    lv_values_2_0=ruleTerm();

            	    state._fsp--;


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
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:144:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:145:2: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:146:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTermRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_entryRuleTerm200);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerm210); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:153:1: ruleTerm returns [EObject current=null] : (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom_0 = null;

        EObject this_TwoNumbers_1 = null;

        EObject this_ManyStrings_2 = null;

        EObject this_Type_3 = null;

        EObject this_Ref2_4 = null;

        EObject this_Spare_5 = null;

        EObject this_Boolean_6 = null;

        EObject this_Transient1_7 = null;

        EObject this_Consumed1_8 = null;

        EObject this_Consumed2_9 = null;

        EObject this_Loop1_10 = null;

        EObject this_Loop2_11 = null;

        EObject this_Loop3_12 = null;

        EObject this_Loop4_13 = null;

        EObject this_LoopBug285452_14 = null;

        EObject this_DuplicateBug284491_15 = null;

        EObject this_EmptyObjectBug284850_16 = null;

        EObject this_MultiInheritanceBug280439_17 = null;

        EObject this_EObjectRef_18 = null;

        EObject this_TypeBug305577_1_19 = null;

        EObject this_TypeBug305577_2_20 = null;

        EObject this_Parens_21 = null;

        EObject this_Bug305171_22 = null;

        EObject this_Bug310435Val_23 = null;

        EObject this_Bug310435Enum_24 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:158:6: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:159:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:159:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum )
            int alt2=25;
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
            case 16:
                {
                alt2=4;
                }
                break;
            case 18:
                {
                alt2=5;
                }
                break;
            case 21:
                {
                alt2=6;
                }
                break;
            case 23:
                {
                alt2=7;
                }
                break;
            case 26:
                {
                alt2=8;
                }
                break;
            case 29:
                {
                alt2=9;
                }
                break;
            case 32:
                {
                alt2=10;
                }
                break;
            case 33:
            case 34:
                {
                alt2=11;
                }
                break;
            case 38:
                {
                alt2=12;
                }
                break;
            case 35:
            case 36:
            case 39:
                {
                alt2=13;
                }
                break;
            case 44:
                {
                alt2=14;
                }
                break;
            case 46:
                {
                alt2=15;
                }
                break;
            case 49:
                {
                alt2=16;
                }
                break;
            case 53:
                {
                alt2=17;
                }
                break;
            case 55:
                {
                alt2=18;
                }
                break;
            case 56:
                {
                alt2=19;
                }
                break;
            case 58:
                {
                alt2=20;
                }
                break;
            case 59:
                {
                alt2=21;
                }
                break;
            case 11:
                {
                alt2=22;
                }
                break;
            case 62:
                {
                alt2=23;
                }
                break;
            case 67:
                {
                alt2=24;
                }
                break;
            case 66:
                {
                alt2=25;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:160:5: this_Atom_0= ruleAtom
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getAtomParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleTerm257);
                    this_Atom_0=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:170:5: this_TwoNumbers_1= ruleTwoNumbers
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTwoNumbersParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTwoNumbers_in_ruleTerm284);
                    this_TwoNumbers_1=ruleTwoNumbers();

                    state._fsp--;

                     
                            current = this_TwoNumbers_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:180:5: this_ManyStrings_2= ruleManyStrings
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getManyStringsParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleManyStrings_in_ruleTerm311);
                    this_ManyStrings_2=ruleManyStrings();

                    state._fsp--;

                     
                            current = this_ManyStrings_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:190:5: this_Type_3= ruleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTypeParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleTerm338);
                    this_Type_3=ruleType();

                    state._fsp--;

                     
                            current = this_Type_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:200:5: this_Ref2_4= ruleRef2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getRef2ParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRef2_in_ruleTerm365);
                    this_Ref2_4=ruleRef2();

                    state._fsp--;

                     
                            current = this_Ref2_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:210:5: this_Spare_5= ruleSpare
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getSpareParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpare_in_ruleTerm392);
                    this_Spare_5=ruleSpare();

                    state._fsp--;

                     
                            current = this_Spare_5; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:220:5: this_Boolean_6= ruleBoolean
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getBooleanParserRuleCall_6(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_ruleTerm419);
                    this_Boolean_6=ruleBoolean();

                    state._fsp--;

                     
                            current = this_Boolean_6; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:230:5: this_Transient1_7= ruleTransient1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTransient1ParserRuleCall_7(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTransient1_in_ruleTerm446);
                    this_Transient1_7=ruleTransient1();

                    state._fsp--;

                     
                            current = this_Transient1_7; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:240:5: this_Consumed1_8= ruleConsumed1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getConsumed1ParserRuleCall_8(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConsumed1_in_ruleTerm473);
                    this_Consumed1_8=ruleConsumed1();

                    state._fsp--;

                     
                            current = this_Consumed1_8; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 10 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:250:5: this_Consumed2_9= ruleConsumed2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getConsumed2ParserRuleCall_9(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConsumed2_in_ruleTerm500);
                    this_Consumed2_9=ruleConsumed2();

                    state._fsp--;

                     
                            current = this_Consumed2_9; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 11 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:260:5: this_Loop1_10= ruleLoop1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop1ParserRuleCall_10(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop1_in_ruleTerm527);
                    this_Loop1_10=ruleLoop1();

                    state._fsp--;

                     
                            current = this_Loop1_10; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 12 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:270:5: this_Loop2_11= ruleLoop2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop2ParserRuleCall_11(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop2_in_ruleTerm554);
                    this_Loop2_11=ruleLoop2();

                    state._fsp--;

                     
                            current = this_Loop2_11; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 13 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:280:5: this_Loop3_12= ruleLoop3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop3ParserRuleCall_12(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop3_in_ruleTerm581);
                    this_Loop3_12=ruleLoop3();

                    state._fsp--;

                     
                            current = this_Loop3_12; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 14 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:290:5: this_Loop4_13= ruleLoop4
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoop4ParserRuleCall_13(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoop4_in_ruleTerm608);
                    this_Loop4_13=ruleLoop4();

                    state._fsp--;

                     
                            current = this_Loop4_13; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 15 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:300:5: this_LoopBug285452_14= ruleLoopBug285452
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getLoopBug285452ParserRuleCall_14(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLoopBug285452_in_ruleTerm635);
                    this_LoopBug285452_14=ruleLoopBug285452();

                    state._fsp--;

                     
                            current = this_LoopBug285452_14; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 16 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:310:5: this_DuplicateBug284491_15= ruleDuplicateBug284491
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getDuplicateBug284491ParserRuleCall_15(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDuplicateBug284491_in_ruleTerm662);
                    this_DuplicateBug284491_15=ruleDuplicateBug284491();

                    state._fsp--;

                     
                            current = this_DuplicateBug284491_15; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 17 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:320:5: this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getEmptyObjectBug284850ParserRuleCall_16(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm689);
                    this_EmptyObjectBug284850_16=ruleEmptyObjectBug284850();

                    state._fsp--;

                     
                            current = this_EmptyObjectBug284850_16; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 18 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:330:5: this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getMultiInheritanceBug280439ParserRuleCall_17(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm716);
                    this_MultiInheritanceBug280439_17=ruleMultiInheritanceBug280439();

                    state._fsp--;

                     
                            current = this_MultiInheritanceBug280439_17; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 19 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:340:5: this_EObjectRef_18= ruleEObjectRef
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getEObjectRefParserRuleCall_18(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEObjectRef_in_ruleTerm743);
                    this_EObjectRef_18=ruleEObjectRef();

                    state._fsp--;

                     
                            current = this_EObjectRef_18; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 20 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:350:5: this_TypeBug305577_1_19= ruleTypeBug305577_1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTypeBug305577_1ParserRuleCall_19(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_1_in_ruleTerm770);
                    this_TypeBug305577_1_19=ruleTypeBug305577_1();

                    state._fsp--;

                     
                            current = this_TypeBug305577_1_19; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 21 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:360:5: this_TypeBug305577_2_20= ruleTypeBug305577_2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getTypeBug305577_2ParserRuleCall_20(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_2_in_ruleTerm797);
                    this_TypeBug305577_2_20=ruleTypeBug305577_2();

                    state._fsp--;

                     
                            current = this_TypeBug305577_2_20; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 22 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:370:5: this_Parens_21= ruleParens
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getParensParserRuleCall_21(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleParens_in_ruleTerm824);
                    this_Parens_21=ruleParens();

                    state._fsp--;

                     
                            current = this_Parens_21; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 23 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:380:5: this_Bug305171_22= ruleBug305171
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getBug305171ParserRuleCall_22(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug305171_in_ruleTerm851);
                    this_Bug305171_22=ruleBug305171();

                    state._fsp--;

                     
                            current = this_Bug305171_22; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 24 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:390:5: this_Bug310435Val_23= ruleBug310435Val
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getBug310435ValParserRuleCall_23(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug310435Val_in_ruleTerm878);
                    this_Bug310435Val_23=ruleBug310435Val();

                    state._fsp--;

                     
                            current = this_Bug310435Val_23; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 25 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:400:5: this_Bug310435Enum_24= ruleBug310435Enum
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTermAccess().getBug310435EnumParserRuleCall_24(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBug310435Enum_in_ruleTerm905);
                    this_Bug310435Enum_24=ruleBug310435Enum();

                    state._fsp--;

                     
                            current = this_Bug310435Enum_24; 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:416:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:417:2: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:418:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAtomRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom940);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom950); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:425:1: ruleAtom returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:430:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:431:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:431:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:432:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:432:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:433:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAtom991); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:464:2: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:465:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParensRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParens_in_entryRuleParens1031);
            iv_ruleParens=ruleParens();

            state._fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParens1041); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:472:1: ruleParens returns [EObject current=null] : (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;
        EObject this_Op_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:477:6: ( (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:478:1: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:478:1: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:478:3: otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleParens1078); 

                	createLeafNode(otherlv_0, grammarAccess.getParensAccess().getLeftParenthesisKeyword_0(), null);
                
             
                    currentNode=createCompositeNode(grammarAccess.getParensAccess().getOpParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_ruleParens1100);
            this_Op_1=ruleOp();

            state._fsp--;

             
                    current = this_Op_1; 
                    currentNode = currentNode.getParent();
                
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleParens1111); 

                	createLeafNode(otherlv_2, grammarAccess.getParensAccess().getRightParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:495:1: ( (lv_em_3_0= '!' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:496:1: (lv_em_3_0= '!' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:496:1: (lv_em_3_0= '!' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:497:3: lv_em_3_0= '!'
                    {
                    lv_em_3_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParens1129); 

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


    // $ANTLR start "entryRuleTwoNumbers"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:524:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:525:2: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:526:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTwoNumbersRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers1179);
            iv_ruleTwoNumbers=ruleTwoNumbers();

            state._fsp--;

             current =iv_ruleTwoNumbers; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoNumbers1189); 

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
    // $ANTLR end "entryRuleTwoNumbers"


    // $ANTLR start "ruleTwoNumbers"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:533:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1_0_0=null;
        Token lv_num2_1_0=null;
        Token otherlv_2=null;
        Token lv_num3_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:538:6: ( ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:539:1: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:539:1: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:539:2: ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:539:2: ( (lv_num1_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:1: (lv_num1_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:1: (lv_num1_0_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:541:3: lv_num1_0_0= RULE_INT
            {
            lv_num1_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTwoNumbers1231); 

            			createLeafNode(lv_num1_0_0, grammarAccess.getTwoNumbersAccess().getNum1INTTerminalRuleCall_0_0(), "num1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:563:2: ( (lv_num2_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:564:1: (lv_num2_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:564:1: (lv_num2_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:565:3: lv_num2_1_0= RULE_INT
            {
            lv_num2_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTwoNumbers1253); 

            			createLeafNode(lv_num2_1_0, grammarAccess.getTwoNumbersAccess().getNum2INTTerminalRuleCall_1_0(), "num2"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:587:2: (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:587:4: otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) )
            	    {
            	    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTwoNumbers1271); 

            	        	createLeafNode(otherlv_2, grammarAccess.getTwoNumbersAccess().getNumberSignKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:591:1: ( (lv_num3_3_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:592:1: (lv_num3_3_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:592:1: (lv_num3_3_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:593:3: lv_num3_3_0= RULE_INT
            	    {
            	    lv_num3_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTwoNumbers1288); 

            	    			createLeafNode(lv_num3_3_0, grammarAccess.getTwoNumbersAccess().getNum3INTTerminalRuleCall_2_1_0(), "num3"); 
            	    		

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
    // $ANTLR end "ruleTwoNumbers"


    // $ANTLR start "entryRuleManyStrings"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:623:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:624:2: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:625:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode(grammarAccess.getManyStringsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleManyStrings_in_entryRuleManyStrings1331);
            iv_ruleManyStrings=ruleManyStrings();

            state._fsp--;

             current =iv_ruleManyStrings; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleManyStrings1341); 

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
    // $ANTLR end "entryRuleManyStrings"


    // $ANTLR start "ruleManyStrings"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:632:1: ruleManyStrings returns [EObject current=null] : (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_str1_1_0=null;
        Token lv_str2_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:637:6: ( (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:638:1: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:638:1: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:638:3: otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleManyStrings1378); 

                	createLeafNode(otherlv_0, grammarAccess.getManyStringsAccess().getEqualsSignKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:642:1: ( (lv_str1_1_0= RULE_STRING ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:643:1: (lv_str1_1_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:643:1: (lv_str1_1_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:644:3: lv_str1_1_0= RULE_STRING
            	    {
            	    lv_str1_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleManyStrings1395); 

            	    			createLeafNode(lv_str1_1_0, grammarAccess.getManyStringsAccess().getStr1STRINGTerminalRuleCall_1_0(), "str1"); 
            	    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:666:3: ( (lv_str2_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:667:1: (lv_str2_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:667:1: (lv_str2_2_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:668:3: lv_str2_2_0= RULE_STRING
            {
            lv_str2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleManyStrings1418); 

            			createLeafNode(lv_str2_2_0, grammarAccess.getManyStringsAccess().getStr2STRINGTerminalRuleCall_2_0(), "str2"); 
            		

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
    // $ANTLR end "ruleManyStrings"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:698:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:699:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:700:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType1459);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType1469); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:707:1: ruleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:712:6: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:713:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:713:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:713:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleType1506); 

                	createLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:717:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:718:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:718:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:719:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType1523); 

            			createLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleType1540); 

                	createLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:745:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:746:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:746:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:747:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType1560); 

            		createLeafNode(otherlv_3, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0(), "extends"); 
            	

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleRef2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:767:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:768:2: (iv_ruleRef2= ruleRef2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:769:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRef2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRef2_in_entryRuleRef21596);
            iv_ruleRef2=ruleRef2();

            state._fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRef21606); 

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
    // $ANTLR end "entryRuleRef2"


    // $ANTLR start "ruleRef2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:776:1: ruleRef2 returns [EObject current=null] : (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ref2_1_1=null;
        Token lv_ref2_1_2=null;
        Token lv_ref2_1_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:781:6: ( (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:782:1: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:782:1: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:782:3: otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleRef21643); 

                	createLeafNode(otherlv_0, grammarAccess.getRef2Access().getNumberSignDigitTwoKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:786:1: ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:787:1: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:787:1: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:788:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:788:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
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
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:789:3: lv_ref2_1_1= 'mykeyword1'
                    {
                    lv_ref2_1_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleRef21663); 

                            createLeafNode(lv_ref2_1_1, grammarAccess.getRef2Access().getRef2Mykeyword1Keyword_1_0_0(), "ref2");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:807:8: lv_ref2_1_2= RULE_STRING
                    {
                    lv_ref2_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRef21691); 

                    			createLeafNode(lv_ref2_1_2, grammarAccess.getRef2Access().getRef2STRINGTerminalRuleCall_1_0_1(), "ref2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:828:8: lv_ref2_1_3= 'mykeyword2'
                    {
                    lv_ref2_1_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRef21712); 

                            createLeafNode(lv_ref2_1_3, grammarAccess.getRef2Access().getRef2Mykeyword2Keyword_1_0_2(), "ref2");
                        

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
    // $ANTLR end "ruleRef2"


    // $ANTLR start "entryRuleSpare"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:857:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:858:2: (iv_ruleSpare= ruleSpare EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:859:2: iv_ruleSpare= ruleSpare EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSpareRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSpare_in_entryRuleSpare1764);
            iv_ruleSpare=ruleSpare();

            state._fsp--;

             current =iv_ruleSpare; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpare1774); 

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
    // $ANTLR end "entryRuleSpare"


    // $ANTLR start "ruleSpare"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:866:1: ruleSpare returns [EObject current=null] : (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:871:6: ( (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:872:1: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:872:1: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:872:3: otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSpare1811); 

                	createLeafNode(otherlv_0, grammarAccess.getSpareAccess().getNumberSignDigitThreeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:876:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:877:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:877:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:878:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpare1828); 

            			createLeafNode(lv_id_1_0, grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_1_0(), "id"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:900:2: (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:900:4: otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSpare1846); 

            	        	createLeafNode(otherlv_2, grammarAccess.getSpareAccess().getFullStopKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:904:1: ( (lv_id_3_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:905:1: (lv_id_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:905:1: (lv_id_3_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:906:3: lv_id_3_0= RULE_ID
            	    {
            	    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpare1863); 

            	    			createLeafNode(lv_id_3_0, grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_2_1_0(), "id"); 
            	    		

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
    // $ANTLR end "ruleSpare"


    // $ANTLR start "entryRuleBoolean"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:936:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:937:2: (iv_ruleBoolean= ruleBoolean EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:938:2: iv_ruleBoolean= ruleBoolean EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_entryRuleBoolean1906);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolean1916); 

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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:945:1: ruleBoolean returns [EObject current=null] : (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_bool_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:950:6: ( (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:951:1: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:951:1: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:951:3: otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleBoolean1953); 

                	createLeafNode(otherlv_0, grammarAccess.getBooleanAccess().getNumberSignDigitFourKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:955:1: ( (lv_bool_1_0= 'myoption' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:956:1: (lv_bool_1_0= 'myoption' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:956:1: (lv_bool_1_0= 'myoption' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:957:3: lv_bool_1_0= 'myoption'
                    {
                    lv_bool_1_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBoolean1971); 

                            createLeafNode(lv_bool_1_0, grammarAccess.getBooleanAccess().getBoolMyoptionKeyword_1_0(), "bool");
                        

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

            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBoolean1997); 

                	createLeafNode(otherlv_2, grammarAccess.getBooleanAccess().getKwKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:980:1: ( (lv_value_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:981:1: (lv_value_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:981:1: (lv_value_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:982:3: lv_value_3_0= RULE_ID
            {
            lv_value_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBoolean2014); 

            			createLeafNode(lv_value_3_0, grammarAccess.getBooleanAccess().getValueIDTerminalRuleCall_3_0(), "value"); 
            		

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleTransient1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1012:1: entryRuleTransient1 returns [EObject current=null] : iv_ruleTransient1= ruleTransient1 EOF ;
    public final EObject entryRuleTransient1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransient1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1013:2: (iv_ruleTransient1= ruleTransient1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1014:2: iv_ruleTransient1= ruleTransient1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransient1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTransient1_in_entryRuleTransient12055);
            iv_ruleTransient1=ruleTransient1();

            state._fsp--;

             current =iv_ruleTransient1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransient12065); 

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
    // $ANTLR end "entryRuleTransient1"


    // $ANTLR start "ruleTransient1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1021:1: ruleTransient1 returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) ;
    public final EObject ruleTransient1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_precStar_1_0=null;
        Token lv_prec_2_0=null;
        Token otherlv_3=null;
        Token lv_scaleStar_4_0=null;
        Token lv_scale_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1026:6: ( (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1027:1: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1027:1: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1027:3: otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTransient12102); 

                	createLeafNode(otherlv_0, grammarAccess.getTransient1Access().getNumberSignDigitFiveKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1031:1: ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) )
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
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1031:2: ( (lv_precStar_1_0= '*' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1031:2: ( (lv_precStar_1_0= '*' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1032:1: (lv_precStar_1_0= '*' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1032:1: (lv_precStar_1_0= '*' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1033:3: lv_precStar_1_0= '*'
                    {
                    lv_precStar_1_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTransient12121); 

                            createLeafNode(lv_precStar_1_0, grammarAccess.getTransient1Access().getPrecStarAsteriskKeyword_1_0_0(), "precStar");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1053:6: ( (lv_prec_2_0= RULE_INT ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1053:6: ( (lv_prec_2_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1054:1: (lv_prec_2_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1054:1: (lv_prec_2_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1055:3: lv_prec_2_0= RULE_INT
                    {
                    lv_prec_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransient12157); 

                    			createLeafNode(lv_prec_2_0, grammarAccess.getTransient1Access().getPrecINTTerminalRuleCall_1_1_0(), "prec"); 
                    		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1077:3: (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1077:5: otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
                    {
                    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTransient12176); 

                        	createLeafNode(otherlv_3, grammarAccess.getTransient1Access().getCommaKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1081:1: ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
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
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1081:2: ( (lv_scaleStar_4_0= '*' ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1081:2: ( (lv_scaleStar_4_0= '*' ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1082:1: (lv_scaleStar_4_0= '*' )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1082:1: (lv_scaleStar_4_0= '*' )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1083:3: lv_scaleStar_4_0= '*'
                            {
                            lv_scaleStar_4_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTransient12195); 

                                    createLeafNode(lv_scaleStar_4_0, grammarAccess.getTransient1Access().getScaleStarAsteriskKeyword_2_1_0_0(), "scaleStar");
                                

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
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1103:6: ( (lv_scale_5_0= RULE_INT ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1103:6: ( (lv_scale_5_0= RULE_INT ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1104:1: (lv_scale_5_0= RULE_INT )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1104:1: (lv_scale_5_0= RULE_INT )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1105:3: lv_scale_5_0= RULE_INT
                            {
                            lv_scale_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransient12231); 

                            			createLeafNode(lv_scale_5_0, grammarAccess.getTransient1Access().getScaleINTTerminalRuleCall_2_1_1_0(), "scale"); 
                            		

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
    // $ANTLR end "ruleTransient1"


    // $ANTLR start "entryRuleConsumed1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1135:1: entryRuleConsumed1 returns [EObject current=null] : iv_ruleConsumed1= ruleConsumed1 EOF ;
    public final EObject entryRuleConsumed1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1136:2: (iv_ruleConsumed1= ruleConsumed1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1137:2: iv_ruleConsumed1= ruleConsumed1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConsumed1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConsumed1_in_entryRuleConsumed12275);
            iv_ruleConsumed1=ruleConsumed1();

            state._fsp--;

             current =iv_ruleConsumed1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConsumed12285); 

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
    // $ANTLR end "entryRuleConsumed1"


    // $ANTLR start "ruleConsumed1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1144:1: ruleConsumed1 returns [EObject current=null] : (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) ;
    public final EObject ruleConsumed1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_v1_2_0=null;
        Token lv_v2_3_0=null;
        Token otherlv_4=null;
        Token lv_v2_5_0=null;
        Token lv_v1_6_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1149:6: ( (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1150:1: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1150:1: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1150:3: otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleConsumed12322); 

                	createLeafNode(otherlv_0, grammarAccess.getConsumed1Access().getNumberSignDigitSixKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1154:1: ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
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
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1154:2: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1154:2: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1154:4: otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleConsumed12336); 

                        	createLeafNode(otherlv_1, grammarAccess.getConsumed1Access().getV1Keyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1158:1: ( (lv_v1_2_0= RULE_INT ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_INT) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1159:1: (lv_v1_2_0= RULE_INT )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1159:1: (lv_v1_2_0= RULE_INT )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1160:3: lv_v1_2_0= RULE_INT
                    	    {
                    	    lv_v1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleConsumed12353); 

                    	    			createLeafNode(lv_v1_2_0, grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_0_1_0(), "v1"); 
                    	    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1182:3: ( (lv_v2_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1183:1: (lv_v2_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1183:1: (lv_v2_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1184:3: lv_v2_3_0= RULE_ID
                    {
                    lv_v2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConsumed12376); 

                    			createLeafNode(lv_v2_3_0, grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_0_2_0(), "v2"); 
                    		

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1207:6: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1207:6: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1207:8: otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) )
                    {
                    otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleConsumed12401); 

                        	createLeafNode(otherlv_4, grammarAccess.getConsumed1Access().getV2Keyword_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1211:1: ( (lv_v2_5_0= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1212:1: (lv_v2_5_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1212:1: (lv_v2_5_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1213:3: lv_v2_5_0= RULE_ID
                    	    {
                    	    lv_v2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConsumed12418); 

                    	    			createLeafNode(lv_v2_5_0, grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_1_1_0(), "v2"); 
                    	    		

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

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1235:3: ( (lv_v1_6_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1236:1: (lv_v1_6_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1236:1: (lv_v1_6_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1237:3: lv_v1_6_0= RULE_INT
                    {
                    lv_v1_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleConsumed12441); 

                    			createLeafNode(lv_v1_6_0, grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_1_2_0(), "v1"); 
                    		

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
    // $ANTLR end "ruleConsumed1"


    // $ANTLR start "entryRuleConsumed2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1267:1: entryRuleConsumed2 returns [EObject current=null] : iv_ruleConsumed2= ruleConsumed2 EOF ;
    public final EObject entryRuleConsumed2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1268:2: (iv_ruleConsumed2= ruleConsumed2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1269:2: iv_ruleConsumed2= ruleConsumed2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConsumed2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConsumed2_in_entryRuleConsumed22484);
            iv_ruleConsumed2=ruleConsumed2();

            state._fsp--;

             current =iv_ruleConsumed2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConsumed22494); 

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
    // $ANTLR end "entryRuleConsumed2"


    // $ANTLR start "ruleConsumed2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1276:1: ruleConsumed2 returns [EObject current=null] : (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) ;
    public final EObject ruleConsumed2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1281:6: ( (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1282:1: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1282:1: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1282:3: otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleConsumed22531); 

                	createLeafNode(otherlv_0, grammarAccess.getConsumed2Access().getNumberSignDigitSevenKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1286:1: ( (lv_child_1_0= ruleConsumed1 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1287:1: (lv_child_1_0= ruleConsumed1 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1287:1: (lv_child_1_0= ruleConsumed1 )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1288:3: lv_child_1_0= ruleConsumed1
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConsumed2Access().getChildConsumed1ParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConsumed1_in_ruleConsumed22552);
            lv_child_1_0=ruleConsumed1();

            state._fsp--;


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
    // $ANTLR end "ruleConsumed2"


    // $ANTLR start "entryRuleLoop1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1318:1: entryRuleLoop1 returns [EObject current=null] : iv_ruleLoop1= ruleLoop1 EOF ;
    public final EObject entryRuleLoop1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1319:2: (iv_ruleLoop1= ruleLoop1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1320:2: iv_ruleLoop1= ruleLoop1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop1_in_entryRuleLoop12588);
            iv_ruleLoop1=ruleLoop1();

            state._fsp--;

             current =iv_ruleLoop1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop12598); 

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
    // $ANTLR end "entryRuleLoop1"


    // $ANTLR start "ruleLoop1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1327:1: ruleLoop1 returns [EObject current=null] : ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) ;
    public final EObject ruleLoop1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1332:6: ( ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1333:1: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1333:1: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1333:2: (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1333:2: (otherlv_0= 'kw0' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==33) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1333:4: otherlv_0= 'kw0'
                    {
                    otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleLoop12636); 

                        	createLeafNode(otherlv_0, grammarAccess.getLoop1Access().getKw0Keyword_0(), null);
                        

                    }
                    break;

            }

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLoop12650); 

                	createLeafNode(otherlv_1, grammarAccess.getLoop1Access().getNumberSignDigitEightKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1341:1: ( (lv_id_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:1: (lv_id_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1342:1: (lv_id_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1343:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop12667); 

            			createLeafNode(lv_id_2_0, grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1365:2: (otherlv_3= 'kw1' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1365:4: otherlv_3= 'kw1'
                    {
                    otherlv_3=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLoop12685); 

                        	createLeafNode(otherlv_3, grammarAccess.getLoop1Access().getKw1Keyword_3(), null);
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1369:3: ( (lv_id_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1370:1: (lv_id_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1370:1: (lv_id_4_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1371:3: lv_id_4_0= RULE_ID
            {
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop12704); 

            			createLeafNode(lv_id_4_0, grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_4_0(), "id"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1393:2: ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1393:3: (otherlv_5= 'kw2' )* otherlv_6= 'kw30'
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1393:3: (otherlv_5= 'kw2' )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==36) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1393:5: otherlv_5= 'kw2'
            	    	    {
            	    	    otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLoop12723); 

            	    	        	createLeafNode(otherlv_5, grammarAccess.getLoop1Access().getKw2Keyword_5_0(), null);
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLoop12737); 

            	        	createLeafNode(otherlv_6, grammarAccess.getLoop1Access().getKw30Keyword_5_1(), null);
            	        

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
    // $ANTLR end "ruleLoop1"


    // $ANTLR start "entryRuleLoop2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1409:1: entryRuleLoop2 returns [EObject current=null] : iv_ruleLoop2= ruleLoop2 EOF ;
    public final EObject entryRuleLoop2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1410:2: (iv_ruleLoop2= ruleLoop2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1411:2: iv_ruleLoop2= ruleLoop2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop2_in_entryRuleLoop22775);
            iv_ruleLoop2=ruleLoop2();

            state._fsp--;

             current =iv_ruleLoop2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop22785); 

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
    // $ANTLR end "entryRuleLoop2"


    // $ANTLR start "ruleLoop2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1418:1: ruleLoop2 returns [EObject current=null] : (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) ;
    public final EObject ruleLoop2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1423:6: ( (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1424:1: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1424:1: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1424:3: otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLoop22822); 

                	createLeafNode(otherlv_0, grammarAccess.getLoop2Access().getNumberSignDigitNineKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1428:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1429:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1430:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop22839); 

            			createLeafNode(lv_id_1_0, grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_1_0(), "id"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1452:2: (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) )
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
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1452:4: otherlv_2= 'kw1'
                    {
                    otherlv_2=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLoop22857); 

                        	createLeafNode(otherlv_2, grammarAccess.getLoop2Access().getKw1Keyword_2_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1457:6: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1457:6: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1457:7: ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1457:7: ( (lv_id_3_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1458:1: (lv_id_3_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1458:1: (lv_id_3_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1459:3: lv_id_3_0= RULE_ID
                    {
                    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop22881); 

                    			createLeafNode(lv_id_3_0, grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_2_1_0_0(), "id"); 
                    		

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

                    otherlv_4=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLoop22898); 

                        	createLeafNode(otherlv_4, grammarAccess.getLoop2Access().getKw2Keyword_2_1_1(), null);
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1485:3: (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )?
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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1485:5: otherlv_5= 'kw3'
                    {
                    otherlv_5=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLoop22913); 

                        	createLeafNode(otherlv_5, grammarAccess.getLoop2Access().getKw3Keyword_3_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1490:6: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1490:6: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1490:7: ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4'
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1490:7: ( (lv_id_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1491:1: (lv_id_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1491:1: (lv_id_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1492:3: lv_id_6_0= RULE_ID
                    {
                    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop22937); 

                    			createLeafNode(lv_id_6_0, grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_3_1_0_0(), "id"); 
                    		

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

                    otherlv_7=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleLoop22954); 

                        	createLeafNode(otherlv_7, grammarAccess.getLoop2Access().getKw4Keyword_3_1_1(), null);
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1518:4: (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
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
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1518:6: otherlv_8= 'kw5'
                    {
                    otherlv_8=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLoop22970); 

                        	createLeafNode(otherlv_8, grammarAccess.getLoop2Access().getKw5Keyword_4_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1523:7: otherlv_9= 'kw6'
                    {
                    otherlv_9=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLoop22988); 

                        	createLeafNode(otherlv_9, grammarAccess.getLoop2Access().getKw6Keyword_4_1(), null);
                        

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
    // $ANTLR end "ruleLoop2"


    // $ANTLR start "entryRuleLoop3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1535:1: entryRuleLoop3 returns [EObject current=null] : iv_ruleLoop3= ruleLoop3 EOF ;
    public final EObject entryRuleLoop3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1536:2: (iv_ruleLoop3= ruleLoop3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1537:2: iv_ruleLoop3= ruleLoop3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop3_in_entryRuleLoop33025);
            iv_ruleLoop3=ruleLoop3();

            state._fsp--;

             current =iv_ruleLoop3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop33035); 

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
    // $ANTLR end "entryRuleLoop3"


    // $ANTLR start "ruleLoop3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1544:1: ruleLoop3 returns [EObject current=null] : ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) ;
    public final EObject ruleLoop3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1549:6: ( ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1550:1: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1550:1: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1550:2: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1550:2: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' )
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
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1550:4: otherlv_0= 'kw1'
                    {
                    otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLoop33073); 

                        	createLeafNode(otherlv_0, grammarAccess.getLoop3Access().getKw1Keyword_0_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1555:7: otherlv_1= 'kw2'
                    {
                    otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLoop33091); 

                        	createLeafNode(otherlv_1, grammarAccess.getLoop3Access().getKw2Keyword_0_1(), null);
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1560:7: otherlv_2= 'kw3'
                    {
                    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLoop33109); 

                        	createLeafNode(otherlv_2, grammarAccess.getLoop3Access().getKw3Keyword_0_2(), null);
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLoop33122); 

                	createLeafNode(otherlv_3, grammarAccess.getLoop3Access().getNumberSignDigitOneDigitZeroKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1568:1: ( (lv_id_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1569:1: (lv_id_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1569:1: (lv_id_4_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1570:3: lv_id_4_0= RULE_ID
            {
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop33139); 

            			createLeafNode(lv_id_4_0, grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1592:2: (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==40) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1592:4: otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5'
            	    {
            	    otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleLoop33157); 

            	        	createLeafNode(otherlv_5, grammarAccess.getLoop3Access().getKw4Keyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1596:1: ( (lv_id_6_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1597:1: (lv_id_6_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1597:1: (lv_id_6_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1598:3: lv_id_6_0= RULE_ID
            	    {
            	    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop33174); 

            	    			createLeafNode(lv_id_6_0, grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_3_1_0(), "id"); 
            	    		

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

            	    otherlv_7=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLoop33191); 

            	        	createLeafNode(otherlv_7, grammarAccess.getLoop3Access().getKw5Keyword_3_2(), null);
            	        

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
    // $ANTLR end "ruleLoop3"


    // $ANTLR start "entryRuleLoop4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1632:1: entryRuleLoop4 returns [EObject current=null] : iv_ruleLoop4= ruleLoop4 EOF ;
    public final EObject entryRuleLoop4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop4 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1633:2: (iv_ruleLoop4= ruleLoop4 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1634:2: iv_ruleLoop4= ruleLoop4 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoop4Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop4_in_entryRuleLoop43229);
            iv_ruleLoop4=ruleLoop4();

            state._fsp--;

             current =iv_ruleLoop4; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop43239); 

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
    // $ANTLR end "entryRuleLoop4"


    // $ANTLR start "ruleLoop4"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1641:1: ruleLoop4 returns [EObject current=null] : (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) ;
    public final EObject ruleLoop4() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_id_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1646:6: ( (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1647:1: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1647:1: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1647:3: otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleLoop43276); 

                	createLeafNode(otherlv_0, grammarAccess.getLoop4Access().getNumberSignDigitOneDigitOneKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1651:1: (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) )
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
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1651:3: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLoop43289); 

                        	createLeafNode(otherlv_1, grammarAccess.getLoop4Access().getKw1Keyword_1_0(), null);
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1656:7: otherlv_2= 'kw2'
                    {
                    otherlv_2=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLoop43307); 

                        	createLeafNode(otherlv_2, grammarAccess.getLoop4Access().getKw2Keyword_1_1(), null);
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1661:6: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1661:6: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1661:8: otherlv_3= 'kw3' otherlv_4= 'kw4'
                    {
                    otherlv_3=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLoop43326); 

                        	createLeafNode(otherlv_3, grammarAccess.getLoop4Access().getKw3Keyword_1_2_0(), null);
                        
                    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleLoop43338); 

                        	createLeafNode(otherlv_4, grammarAccess.getLoop4Access().getKw4Keyword_1_2_1(), null);
                        

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1669:3: ( (lv_id_5_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1670:1: (lv_id_5_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1670:1: (lv_id_5_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1671:3: lv_id_5_0= RULE_ID
            {
            lv_id_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop43357); 

            			createLeafNode(lv_id_5_0, grammarAccess.getLoop4Access().getIdIDTerminalRuleCall_2_0(), "id"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1693:2: (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1693:4: otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    {
            	    otherlv_6=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLoop43375); 

            	        	createLeafNode(otherlv_6, grammarAccess.getLoop4Access().getKw5Keyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1697:1: (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==42) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1697:3: otherlv_7= 'kw6' (otherlv_8= 'kw7' )?
            	            {
            	            otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLoop43388); 

            	                	createLeafNode(otherlv_7, grammarAccess.getLoop4Access().getKw6Keyword_3_1_0(), null);
            	                
            	            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1701:1: (otherlv_8= 'kw7' )?
            	            int alt25=2;
            	            int LA25_0 = input.LA(1);

            	            if ( (LA25_0==45) ) {
            	                alt25=1;
            	            }
            	            switch (alt25) {
            	                case 1 :
            	                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1701:3: otherlv_8= 'kw7'
            	                    {
            	                    otherlv_8=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleLoop43401); 

            	                        	createLeafNode(otherlv_8, grammarAccess.getLoop4Access().getKw7Keyword_3_1_1(), null);
            	                        

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
    // $ANTLR end "ruleLoop4"


    // $ANTLR start "entryRuleLoopBug285452"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1713:1: entryRuleLoopBug285452 returns [EObject current=null] : iv_ruleLoopBug285452= ruleLoopBug285452 EOF ;
    public final EObject entryRuleLoopBug285452() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopBug285452 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1714:2: (iv_ruleLoopBug285452= ruleLoopBug285452 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1715:2: iv_ruleLoopBug285452= ruleLoopBug285452 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getLoopBug285452Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523443);
            iv_ruleLoopBug285452=ruleLoopBug285452();

            state._fsp--;

             current =iv_ruleLoopBug285452; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopBug2854523453); 

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
    // $ANTLR end "entryRuleLoopBug285452"


    // $ANTLR start "ruleLoopBug285452"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1722:1: ruleLoopBug285452 returns [EObject current=null] : (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleLoopBug285452() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_interface_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1727:6: ( (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1728:1: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1728:1: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1728:3: otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleLoopBug2854523490); 

                	createLeafNode(otherlv_0, grammarAccess.getLoopBug285452Access().getNumberSignDigitOneDigitTwoKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1732:1: ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' )
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
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1732:2: ( (lv_interface_1_0= 'interface' ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1732:2: ( (lv_interface_1_0= 'interface' ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1733:1: (lv_interface_1_0= 'interface' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1733:1: (lv_interface_1_0= 'interface' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1734:3: lv_interface_1_0= 'interface'
                    {
                    lv_interface_1_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleLoopBug2854523509); 

                            createLeafNode(lv_interface_1_0, grammarAccess.getLoopBug285452Access().getInterfaceInterfaceKeyword_1_0_0(), "interface");
                        

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
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1754:7: otherlv_2= 'class'
                    {
                    otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleLoopBug2854523540); 

                        	createLeafNode(otherlv_2, grammarAccess.getLoopBug285452Access().getClassKeyword_1_1(), null);
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1758:2: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1759:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1759:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1760:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopBug2854523558); 

            			createLeafNode(lv_name_3_0, grammarAccess.getLoopBug285452Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

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
    // $ANTLR end "ruleLoopBug285452"


    // $ANTLR start "entryRuleDuplicateBug284491"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1790:1: entryRuleDuplicateBug284491 returns [EObject current=null] : iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF ;
    public final EObject entryRuleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDuplicateBug284491 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1791:2: (iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1792:2: iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDuplicateBug284491Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913599);
            iv_ruleDuplicateBug284491=ruleDuplicateBug284491();

            state._fsp--;

             current =iv_ruleDuplicateBug284491; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDuplicateBug2844913609); 

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
    // $ANTLR end "entryRuleDuplicateBug284491"


    // $ANTLR start "ruleDuplicateBug284491"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1799:1: ruleDuplicateBug284491 returns [EObject current=null] : (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) ;
    public final EObject ruleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_final_2_0=null;
        Token lv_transient_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1804:6: ( (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1805:1: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1805:1: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1805:3: otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
            {
            otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleDuplicateBug2844913646); 

                	createLeafNode(otherlv_0, grammarAccess.getDuplicateBug284491Access().getNumberSignDigitOneDigitThreeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1809:1: ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1809:2: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1809:2: ( (lv_static_1_0= 'static' ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1810:1: (lv_static_1_0= 'static' )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1810:1: (lv_static_1_0= 'static' )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1811:3: lv_static_1_0= 'static'
            	    {
            	    lv_static_1_0=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleDuplicateBug2844913665); 

            	            createLeafNode(lv_static_1_0, grammarAccess.getDuplicateBug284491Access().getStaticStaticKeyword_1_0_0(), "static");
            	        

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1831:6: ( (lv_final_2_0= 'final' ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1831:6: ( (lv_final_2_0= 'final' ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1832:1: (lv_final_2_0= 'final' )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1832:1: (lv_final_2_0= 'final' )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1833:3: lv_final_2_0= 'final'
            	    {
            	    lv_final_2_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleDuplicateBug2844913702); 

            	            createLeafNode(lv_final_2_0, grammarAccess.getDuplicateBug284491Access().getFinalFinalKeyword_1_1_0(), "final");
            	        

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1853:6: ( (lv_transient_3_0= 'transient' ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1853:6: ( (lv_transient_3_0= 'transient' ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1854:1: (lv_transient_3_0= 'transient' )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1854:1: (lv_transient_3_0= 'transient' )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1855:3: lv_transient_3_0= 'transient'
            	    {
            	    lv_transient_3_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleDuplicateBug2844913739); 

            	            createLeafNode(lv_transient_3_0, grammarAccess.getDuplicateBug284491Access().getTransientTransientKeyword_1_2_0(), "transient");
            	        

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
    // $ANTLR end "ruleDuplicateBug284491"


    // $ANTLR start "entryRuleEmptyObjectBug284850"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1882:1: entryRuleEmptyObjectBug284850 returns [EObject current=null] : iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF ;
    public final EObject entryRuleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectBug284850 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1883:2: (iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1884:2: iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectBug284850Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848503790);
            iv_ruleEmptyObjectBug284850=ruleEmptyObjectBug284850();

            state._fsp--;

             current =iv_ruleEmptyObjectBug284850; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmptyObjectBug2848503800); 

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
    // $ANTLR end "entryRuleEmptyObjectBug284850"


    // $ANTLR start "ruleEmptyObjectBug284850"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1891:1: ruleEmptyObjectBug284850 returns [EObject current=null] : (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) ;
    public final EObject ruleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_items_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1896:6: ( (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1897:1: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1897:1: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1897:3: otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) )
            {
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEmptyObjectBug2848503837); 

                	createLeafNode(otherlv_0, grammarAccess.getEmptyObjectBug284850Access().getNumberSignDigitOneDigitFourKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1901:1: ( (lv_items_1_0= ruleEmptyObjectItems ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1902:1: (lv_items_1_0= ruleEmptyObjectItems )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1902:1: (lv_items_1_0= ruleEmptyObjectItems )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1903:3: lv_items_1_0= ruleEmptyObjectItems
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEmptyObjectBug284850Access().getItemsEmptyObjectItemsParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848503858);
            lv_items_1_0=ruleEmptyObjectItems();

            state._fsp--;


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
    // $ANTLR end "ruleEmptyObjectBug284850"


    // $ANTLR start "entryRuleEmptyObjectItems"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1933:1: entryRuleEmptyObjectItems returns [EObject current=null] : iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF ;
    public final EObject entryRuleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItems = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1934:2: (iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1935:2: iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectItemsRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems3894);
            iv_ruleEmptyObjectItems=ruleEmptyObjectItems();

            state._fsp--;

             current =iv_ruleEmptyObjectItems; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmptyObjectItems3904); 

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
    // $ANTLR end "entryRuleEmptyObjectItems"


    // $ANTLR start "ruleEmptyObjectItems"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1942:1: ruleEmptyObjectItems returns [EObject current=null] : ( (lv_list_0_0= ruleEmptyObjectItem ) )* ;
    public final EObject ruleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject lv_list_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1947:6: ( ( (lv_list_0_0= ruleEmptyObjectItem ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1948:1: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1948:1: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==54) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1949:1: (lv_list_0_0= ruleEmptyObjectItem )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1949:1: (lv_list_0_0= ruleEmptyObjectItem )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1950:3: lv_list_0_0= ruleEmptyObjectItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEmptyObjectItemsAccess().getListEmptyObjectItemParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems3949);
            	    lv_list_0_0=ruleEmptyObjectItem();

            	    state._fsp--;


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
    // $ANTLR end "ruleEmptyObjectItems"


    // $ANTLR start "entryRuleEmptyObjectItem"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1980:1: entryRuleEmptyObjectItem returns [EObject current=null] : iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF ;
    public final EObject entryRuleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItem = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1981:2: (iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1982:2: iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEmptyObjectItemRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem3985);
            iv_ruleEmptyObjectItem=ruleEmptyObjectItem();

            state._fsp--;

             current =iv_ruleEmptyObjectItem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmptyObjectItem3995); 

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
    // $ANTLR end "entryRuleEmptyObjectItem"


    // $ANTLR start "ruleEmptyObjectItem"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1989:1: ruleEmptyObjectItem returns [EObject current=null] : (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1994:6: ( (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1995:1: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1995:1: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1995:3: otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleEmptyObjectItem4032); 

                	createLeafNode(otherlv_0, grammarAccess.getEmptyObjectItemAccess().getItemKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:1999:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2000:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2000:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2001:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEmptyObjectItem4049); 

            			createLeafNode(lv_name_1_0, grammarAccess.getEmptyObjectItemAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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
    // $ANTLR end "ruleEmptyObjectItem"


    // $ANTLR start "entryRuleMultiInheritanceBug280439"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2031:1: entryRuleMultiInheritanceBug280439 returns [EObject current=null] : iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF ;
    public final EObject entryRuleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiInheritanceBug280439 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2032:2: (iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2033:2: iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMultiInheritanceBug280439Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804394090);
            iv_ruleMultiInheritanceBug280439=ruleMultiInheritanceBug280439();

            state._fsp--;

             current =iv_ruleMultiInheritanceBug280439; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804394100); 

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
    // $ANTLR end "entryRuleMultiInheritanceBug280439"


    // $ANTLR start "ruleMultiInheritanceBug280439"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2040:1: ruleMultiInheritanceBug280439 returns [EObject current=null] : (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) ;
    public final EObject ruleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_val_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2045:6: ( (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2046:1: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2046:1: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2046:3: otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) )
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMultiInheritanceBug2804394137); 

                	createLeafNode(otherlv_0, grammarAccess.getMultiInheritanceBug280439Access().getNumberSignDigitOneDigitFiveKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2050:1: ( (lv_val_1_0= ruleConcreteMulti ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2051:1: (lv_val_1_0= ruleConcreteMulti )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2051:1: (lv_val_1_0= ruleConcreteMulti )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2052:3: lv_val_1_0= ruleConcreteMulti
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getMultiInheritanceBug280439Access().getValConcreteMultiParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804394158);
            lv_val_1_0=ruleConcreteMulti();

            state._fsp--;


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
    // $ANTLR end "ruleMultiInheritanceBug280439"


    // $ANTLR start "entryRuleConcreteMulti"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2086:1: entryRuleConcreteMulti returns [EObject current=null] : iv_ruleConcreteMulti= ruleConcreteMulti EOF ;
    public final EObject entryRuleConcreteMulti() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteMulti = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2087:2: (iv_ruleConcreteMulti= ruleConcreteMulti EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2088:2: iv_ruleConcreteMulti= ruleConcreteMulti EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteMultiRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti4198);
            iv_ruleConcreteMulti=ruleConcreteMulti();

            state._fsp--;

             current =iv_ruleConcreteMulti; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteMulti4208); 

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
    // $ANTLR end "entryRuleConcreteMulti"


    // $ANTLR start "ruleConcreteMulti"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2095:1: ruleConcreteMulti returns [EObject current=null] : ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleConcreteMulti() throws RecognitionException {
        EObject current = null;

        Token lv_m1_0_0=null;
        Token lv_m2_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2100:6: ( ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2101:1: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2101:1: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2101:2: ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2101:2: ( (lv_m1_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2102:1: (lv_m1_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2102:1: (lv_m1_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2103:3: lv_m1_0_0= RULE_ID
            {
            lv_m1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConcreteMulti4250); 

            			createLeafNode(lv_m1_0_0, grammarAccess.getConcreteMultiAccess().getM1IDTerminalRuleCall_0_0(), "m1"); 
            		

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2125:2: ( (lv_m2_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2126:1: (lv_m2_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2126:1: (lv_m2_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2127:3: lv_m2_1_0= RULE_ID
            {
            lv_m2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConcreteMulti4272); 

            			createLeafNode(lv_m2_1_0, grammarAccess.getConcreteMultiAccess().getM2IDTerminalRuleCall_1_0(), "m2"); 
            		

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
    // $ANTLR end "ruleConcreteMulti"


    // $ANTLR start "entryRuleEObjectRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2157:1: entryRuleEObjectRef returns [EObject current=null] : iv_ruleEObjectRef= ruleEObjectRef EOF ;
    public final EObject entryRuleEObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObjectRef = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2158:2: (iv_ruleEObjectRef= ruleEObjectRef EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2159:2: iv_ruleEObjectRef= ruleEObjectRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEObjectRefRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEObjectRef_in_entryRuleEObjectRef4313);
            iv_ruleEObjectRef=ruleEObjectRef();

            state._fsp--;

             current =iv_ruleEObjectRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObjectRef4323); 

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
    // $ANTLR end "entryRuleEObjectRef"


    // $ANTLR start "ruleEObjectRef"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2166:1: ruleEObjectRef returns [EObject current=null] : (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleEObjectRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_obj_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2171:6: ( (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2172:1: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2172:1: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2172:3: otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleEObjectRef4360); 

                	createLeafNode(otherlv_0, grammarAccess.getEObjectRefAccess().getNumberSignDigitOneDigitSixKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2176:1: ( (lv_obj_1_0= ruleEObjectElement ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2177:1: (lv_obj_1_0= ruleEObjectElement )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2177:1: (lv_obj_1_0= ruleEObjectElement )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2178:3: lv_obj_1_0= ruleEObjectElement
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEObjectRefAccess().getObjEObjectElementParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEObjectElement_in_ruleEObjectRef4381);
            lv_obj_1_0=ruleEObjectElement();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEObjectRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"obj",
            	        		lv_obj_1_0, 
            	        		"EObjectElement", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_2=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleEObjectRef4393); 

                	createLeafNode(otherlv_2, grammarAccess.getEObjectRefAccess().getRefsKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2204:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2205:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2205:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2206:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getEObjectRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEObjectRef4413); 

            		createLeafNode(otherlv_3, grammarAccess.getEObjectRefAccess().getRefEObjectCrossReference_3_0(), "ref"); 
            	

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
    // $ANTLR end "ruleEObjectRef"


    // $ANTLR start "entryRuleEObjectElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2226:1: entryRuleEObjectElement returns [EObject current=null] : iv_ruleEObjectElement= ruleEObjectElement EOF ;
    public final EObject entryRuleEObjectElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObjectElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2227:2: (iv_ruleEObjectElement= ruleEObjectElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2228:2: iv_ruleEObjectElement= ruleEObjectElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEObjectElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEObjectElement_in_entryRuleEObjectElement4449);
            iv_ruleEObjectElement=ruleEObjectElement();

            state._fsp--;

             current =iv_ruleEObjectElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObjectElement4459); 

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
    // $ANTLR end "entryRuleEObjectElement"


    // $ANTLR start "ruleEObjectElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2235:1: ruleEObjectElement returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEObjectElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2240:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2241:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2241:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2242:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2242:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2243:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEObjectElement4500); 

            			createLeafNode(lv_name_0_0, grammarAccess.getEObjectElementAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEObjectElementRule().getType().getClassifier());
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
    // $ANTLR end "ruleEObjectElement"


    // $ANTLR start "entryRuleTypeBug305577_1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2273:1: entryRuleTypeBug305577_1 returns [EObject current=null] : iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF ;
    public final EObject entryRuleTypeBug305577_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug305577_1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2274:2: (iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2275:2: iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeBug305577_1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_1_in_entryRuleTypeBug305577_14540);
            iv_ruleTypeBug305577_1=ruleTypeBug305577_1();

            state._fsp--;

             current =iv_ruleTypeBug305577_1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug305577_14550); 

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
    // $ANTLR end "entryRuleTypeBug305577_1"


    // $ANTLR start "ruleTypeBug305577_1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2282:1: ruleTypeBug305577_1 returns [EObject current=null] : (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) ) ;
    public final EObject ruleTypeBug305577_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TypeBug1A_1 = null;

        EObject this_TypeBug1B_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2287:6: ( (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2288:1: (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2288:1: (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2288:3: otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B )
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleTypeBug305577_14587); 

                	createLeafNode(otherlv_0, grammarAccess.getTypeBug305577_1Access().getNumberSignDigitOneDigitSevenKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2292:1: (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==60) ) {
                alt31=1;
            }
            else if ( (LA31_0==61) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2293:5: this_TypeBug1A_1= ruleTypeBug1A
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeBug305577_1Access().getTypeBug1AParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug1A_in_ruleTypeBug305577_14610);
                    this_TypeBug1A_1=ruleTypeBug1A();

                    state._fsp--;

                     
                            current = this_TypeBug1A_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2303:5: this_TypeBug1B_2= ruleTypeBug1B
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeBug305577_1Access().getTypeBug1BParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug1B_in_ruleTypeBug305577_14637);
                    this_TypeBug1B_2=ruleTypeBug1B();

                    state._fsp--;

                     
                            current = this_TypeBug1B_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleTypeBug305577_1"


    // $ANTLR start "entryRuleTypeBug305577_2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2319:1: entryRuleTypeBug305577_2 returns [EObject current=null] : iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF ;
    public final EObject entryRuleTypeBug305577_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug305577_2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2320:2: (iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2321:2: iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeBug305577_2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_2_in_entryRuleTypeBug305577_24673);
            iv_ruleTypeBug305577_2=ruleTypeBug305577_2();

            state._fsp--;

             current =iv_ruleTypeBug305577_2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug305577_24683); 

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
    // $ANTLR end "entryRuleTypeBug305577_2"


    // $ANTLR start "ruleTypeBug305577_2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2328:1: ruleTypeBug305577_2 returns [EObject current=null] : (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) ) ;
    public final EObject ruleTypeBug305577_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TypeBug2B_1 = null;

        EObject this_TypeBug2A_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2333:6: ( (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2334:1: (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2334:1: (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2334:3: otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A )
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleTypeBug305577_24720); 

                	createLeafNode(otherlv_0, grammarAccess.getTypeBug305577_2Access().getNumberSignDigitOneDigitEightKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2338:1: (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==61) ) {
                alt32=1;
            }
            else if ( (LA32_0==60) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2339:5: this_TypeBug2B_1= ruleTypeBug2B
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeBug305577_2Access().getTypeBug2BParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug2B_in_ruleTypeBug305577_24743);
                    this_TypeBug2B_1=ruleTypeBug2B();

                    state._fsp--;

                     
                            current = this_TypeBug2B_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2349:5: this_TypeBug2A_2= ruleTypeBug2A
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeBug305577_2Access().getTypeBug2AParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug2A_in_ruleTypeBug305577_24770);
                    this_TypeBug2A_2=ruleTypeBug2A();

                    state._fsp--;

                     
                            current = this_TypeBug2A_2; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleTypeBug305577_2"


    // $ANTLR start "entryRuleTypeBug1A"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2367:1: entryRuleTypeBug1A returns [EObject current=null] : iv_ruleTypeBug1A= ruleTypeBug1A EOF ;
    public final EObject entryRuleTypeBug1A() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug1A = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2368:2: (iv_ruleTypeBug1A= ruleTypeBug1A EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2369:2: iv_ruleTypeBug1A= ruleTypeBug1A EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeBug1ARule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug1A_in_entryRuleTypeBug1A4808);
            iv_ruleTypeBug1A=ruleTypeBug1A();

            state._fsp--;

             current =iv_ruleTypeBug1A; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug1A4818); 

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
    // $ANTLR end "entryRuleTypeBug1A"


    // $ANTLR start "ruleTypeBug1A"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2376:1: ruleTypeBug1A returns [EObject current=null] : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug1A() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2381:6: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2382:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2382:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2382:2: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2382:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2383:5: 
            {
             
                    temp=factory.create(grammarAccess.getTypeBug1AAccess().getTypeBug1AAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTypeBug1AAccess().getTypeBug1AAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleTypeBug1A4864); 

                	createLeafNode(otherlv_1, grammarAccess.getTypeBug1AAccess().getKaKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2397:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2398:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2398:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2399:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug1A4881); 

            			createLeafNode(lv_name_2_0, grammarAccess.getTypeBug1AAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeBug1ARule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
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
    // $ANTLR end "ruleTypeBug1A"


    // $ANTLR start "entryRuleTypeBug1B"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2429:1: entryRuleTypeBug1B returns [EObject current=null] : iv_ruleTypeBug1B= ruleTypeBug1B EOF ;
    public final EObject entryRuleTypeBug1B() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug1B = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2430:2: (iv_ruleTypeBug1B= ruleTypeBug1B EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2431:2: iv_ruleTypeBug1B= ruleTypeBug1B EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeBug1BRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug1B_in_entryRuleTypeBug1B4922);
            iv_ruleTypeBug1B=ruleTypeBug1B();

            state._fsp--;

             current =iv_ruleTypeBug1B; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug1B4932); 

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
    // $ANTLR end "entryRuleTypeBug1B"


    // $ANTLR start "ruleTypeBug1B"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2438:1: ruleTypeBug1B returns [EObject current=null] : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug1B() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2443:6: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2444:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2444:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2444:2: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2444:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2445:5: 
            {
             
                    temp=factory.create(grammarAccess.getTypeBug1BAccess().getTypeBug1BAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTypeBug1BAccess().getTypeBug1BAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleTypeBug1B4978); 

                	createLeafNode(otherlv_1, grammarAccess.getTypeBug1BAccess().getKbKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2459:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2460:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2460:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2461:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug1B4995); 

            			createLeafNode(lv_name_2_0, grammarAccess.getTypeBug1BAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeBug1BRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
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
    // $ANTLR end "ruleTypeBug1B"


    // $ANTLR start "entryRuleTypeBug2A"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2493:1: entryRuleTypeBug2A returns [EObject current=null] : iv_ruleTypeBug2A= ruleTypeBug2A EOF ;
    public final EObject entryRuleTypeBug2A() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug2A = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2494:2: (iv_ruleTypeBug2A= ruleTypeBug2A EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2495:2: iv_ruleTypeBug2A= ruleTypeBug2A EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeBug2ARule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug2A_in_entryRuleTypeBug2A5038);
            iv_ruleTypeBug2A=ruleTypeBug2A();

            state._fsp--;

             current =iv_ruleTypeBug2A; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug2A5048); 

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
    // $ANTLR end "entryRuleTypeBug2A"


    // $ANTLR start "ruleTypeBug2A"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2502:1: ruleTypeBug2A returns [EObject current=null] : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug2A() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2507:6: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2508:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2508:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2508:2: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2508:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2509:5: 
            {
             
                    temp=factory.create(grammarAccess.getTypeBug2AAccess().getTypeBug2AAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTypeBug2AAccess().getTypeBug2AAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleTypeBug2A5094); 

                	createLeafNode(otherlv_1, grammarAccess.getTypeBug2AAccess().getKaKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2523:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2524:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2524:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2525:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug2A5111); 

            			createLeafNode(lv_name_2_0, grammarAccess.getTypeBug2AAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeBug2ARule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
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
    // $ANTLR end "ruleTypeBug2A"


    // $ANTLR start "entryRuleTypeBug2B"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2555:1: entryRuleTypeBug2B returns [EObject current=null] : iv_ruleTypeBug2B= ruleTypeBug2B EOF ;
    public final EObject entryRuleTypeBug2B() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug2B = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2556:2: (iv_ruleTypeBug2B= ruleTypeBug2B EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2557:2: iv_ruleTypeBug2B= ruleTypeBug2B EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeBug2BRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug2B_in_entryRuleTypeBug2B5152);
            iv_ruleTypeBug2B=ruleTypeBug2B();

            state._fsp--;

             current =iv_ruleTypeBug2B; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug2B5162); 

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
    // $ANTLR end "entryRuleTypeBug2B"


    // $ANTLR start "ruleTypeBug2B"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2564:1: ruleTypeBug2B returns [EObject current=null] : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug2B() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2569:6: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2570:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2570:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2570:2: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2570:2: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2571:5: 
            {
             
                    temp=factory.create(grammarAccess.getTypeBug2BAccess().getTypeBug2BAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTypeBug2BAccess().getTypeBug2BAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleTypeBug2B5208); 

                	createLeafNode(otherlv_1, grammarAccess.getTypeBug2BAccess().getKbKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2585:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2586:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2586:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2587:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug2B5225); 

            			createLeafNode(lv_name_2_0, grammarAccess.getTypeBug2BAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeBug2BRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
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
    // $ANTLR end "ruleTypeBug2B"


    // $ANTLR start "entryRuleBug305171"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2617:1: entryRuleBug305171 returns [EObject current=null] : iv_ruleBug305171= ruleBug305171 EOF ;
    public final EObject entryRuleBug305171() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug305171 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2618:2: (iv_ruleBug305171= ruleBug305171 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2619:2: iv_ruleBug305171= ruleBug305171 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug305171Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug305171_in_entryRuleBug3051715266);
            iv_ruleBug305171=ruleBug305171();

            state._fsp--;

             current =iv_ruleBug305171; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug3051715276); 

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
    // $ANTLR end "entryRuleBug305171"


    // $ANTLR start "ruleBug305171"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2626:1: ruleBug305171 returns [EObject current=null] : (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) ;
    public final EObject ruleBug305171() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_x_2_0=null;
        Token otherlv_3=null;
        Token lv_x_4_0=null;
        Token otherlv_5=null;
        Token lv_y_6_0=null;
        Token otherlv_7=null;
        Token lv_y_8_0=null;
        Token otherlv_9=null;
        Token lv_z_10_0=null;
        Token otherlv_11=null;
        Token lv_z_12_0=null;
        Token lv_name_13_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2631:6: ( (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2632:1: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2632:1: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2632:3: otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleBug3051715313); 

                	createLeafNode(otherlv_0, grammarAccess.getBug305171Access().getNumberSignDigitOneDigitNineKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2636:1: ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2636:2: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2636:2: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==63) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2636:4: otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    {
                    otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleBug3051715327); 

                        	createLeafNode(otherlv_1, grammarAccess.getBug305171Access().getKxKeyword_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2640:1: ( (lv_x_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2641:1: (lv_x_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2641:1: (lv_x_2_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2642:3: lv_x_2_0= RULE_ID
                    {
                    lv_x_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715344); 

                    			createLeafNode(lv_x_2_0, grammarAccess.getBug305171Access().getXIDTerminalRuleCall_1_0_1_0(), "x"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"x",
                    	        		lv_x_2_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2664:2: (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==28) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2664:4: otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBug3051715362); 

                    	        	createLeafNode(otherlv_3, grammarAccess.getBug305171Access().getCommaKeyword_1_0_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2668:1: ( (lv_x_4_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2669:1: (lv_x_4_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2669:1: (lv_x_4_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2670:3: lv_x_4_0= RULE_ID
                    	    {
                    	    lv_x_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715379); 

                    	    			createLeafNode(lv_x_4_0, grammarAccess.getBug305171Access().getXIDTerminalRuleCall_1_0_2_1_0(), "x"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"x",
                    	    	        		lv_x_4_0, 
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
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2692:6: ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2692:7: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2692:7: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==64) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2692:9: otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    {
                    otherlv_5=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleBug3051715402); 

                        	createLeafNode(otherlv_5, grammarAccess.getBug305171Access().getKyKeyword_1_1_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2696:1: ( (lv_y_6_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2697:1: (lv_y_6_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2697:1: (lv_y_6_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2698:3: lv_y_6_0= RULE_ID
                    {
                    lv_y_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715419); 

                    			createLeafNode(lv_y_6_0, grammarAccess.getBug305171Access().getYIDTerminalRuleCall_1_1_0_1_0(), "y"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"y",
                    	        		lv_y_6_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2720:2: (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==28) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2720:4: otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) )
                    	    {
                    	    otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBug3051715437); 

                    	        	createLeafNode(otherlv_7, grammarAccess.getBug305171Access().getCommaKeyword_1_1_0_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2724:1: ( (lv_y_8_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2725:1: (lv_y_8_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2725:1: (lv_y_8_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2726:3: lv_y_8_0= RULE_ID
                    	    {
                    	    lv_y_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715454); 

                    	    			createLeafNode(lv_y_8_0, grammarAccess.getBug305171Access().getYIDTerminalRuleCall_1_1_0_2_1_0(), "y"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"y",
                    	    	        		lv_y_8_0, 
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
                    	    break loop35;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2748:6: (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==65) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2748:8: otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    {
                    otherlv_9=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleBug3051715476); 

                        	createLeafNode(otherlv_9, grammarAccess.getBug305171Access().getKzKeyword_1_1_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2752:1: ( (lv_z_10_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2753:1: (lv_z_10_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2753:1: (lv_z_10_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2754:3: lv_z_10_0= RULE_ID
                    {
                    lv_z_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715493); 

                    			createLeafNode(lv_z_10_0, grammarAccess.getBug305171Access().getZIDTerminalRuleCall_1_1_1_1_0(), "z"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"z",
                    	        		lv_z_10_0, 
                    	        		"ID", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2776:2: (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==28) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2776:4: otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBug3051715511); 

                    	        	createLeafNode(otherlv_11, grammarAccess.getBug305171Access().getCommaKeyword_1_1_1_2_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2780:1: ( (lv_z_12_0= RULE_ID ) )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2781:1: (lv_z_12_0= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2781:1: (lv_z_12_0= RULE_ID )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2782:3: lv_z_12_0= RULE_ID
                    	    {
                    	    lv_z_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715528); 

                    	    			createLeafNode(lv_z_12_0, grammarAccess.getBug305171Access().getZIDTerminalRuleCall_1_1_1_2_1_0(), "z"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"z",
                    	    	        		lv_z_12_0, 
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
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2804:8: ( (lv_name_13_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2805:1: (lv_name_13_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2805:1: (lv_name_13_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2806:3: lv_name_13_0= RULE_ID
            {
            lv_name_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715556); 

            			createLeafNode(lv_name_13_0, grammarAccess.getBug305171Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBug305171Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_13_0, 
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
    // $ANTLR end "ruleBug305171"


    // $ANTLR start "entryRuleBug310435Enum"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2836:1: entryRuleBug310435Enum returns [EObject current=null] : iv_ruleBug310435Enum= ruleBug310435Enum EOF ;
    public final EObject entryRuleBug310435Enum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug310435Enum = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2837:2: (iv_ruleBug310435Enum= ruleBug310435Enum EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2838:2: iv_ruleBug310435Enum= ruleBug310435Enum EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug310435EnumRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug310435Enum_in_entryRuleBug310435Enum5597);
            iv_ruleBug310435Enum=ruleBug310435Enum();

            state._fsp--;

             current =iv_ruleBug310435Enum; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug310435Enum5607); 

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
    // $ANTLR end "entryRuleBug310435Enum"


    // $ANTLR start "ruleBug310435Enum"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2845:1: ruleBug310435Enum returns [EObject current=null] : (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) ;
    public final EObject ruleBug310435Enum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_lits_2_0 = null;

        Enumerator lv_lits_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2850:6: ( (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2851:1: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2851:1: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2851:3: otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
            {
            otherlv_0=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleBug310435Enum5644); 

                	createLeafNode(otherlv_0, grammarAccess.getBug310435EnumAccess().getNumberSignDigitTwoDigitZeroKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2855:1: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
            loop39:
            do {
                int alt39=3;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==35) ) {
                    int LA39_2 = input.LA(2);

                    if ( (LA39_2==68) ) {
                        alt39=1;
                    }


                }
                else if ( (LA39_0==36) ) {
                    int LA39_3 = input.LA(2);

                    if ( (LA39_3==69) ) {
                        alt39=2;
                    }


                }


                switch (alt39) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2855:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2855:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2855:4: otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleBug310435Enum5658); 

            	        	createLeafNode(otherlv_1, grammarAccess.getBug310435EnumAccess().getKw1Keyword_1_0_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2859:1: ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2860:1: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2860:1: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2861:3: lv_lits_2_0= ruleEnumBug310435Lit1
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBug310435EnumAccess().getLitsEnumBug310435Lit1EnumRuleCall_1_0_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumBug310435Lit1_in_ruleBug310435Enum5679);
            	    lv_lits_2_0=ruleEnumBug310435Lit1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug310435EnumRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"lits",
            	    	        		lv_lits_2_0, 
            	    	        		"EnumBug310435Lit1", 
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2884:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2884:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2884:8: otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    {
            	    otherlv_3=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleBug310435Enum5699); 

            	        	createLeafNode(otherlv_3, grammarAccess.getBug310435EnumAccess().getKw2Keyword_1_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2888:1: ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2889:1: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2889:1: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2890:3: lv_lits_4_0= ruleEnumBug310435Lit2
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBug310435EnumAccess().getLitsEnumBug310435Lit2EnumRuleCall_1_1_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumBug310435Lit2_in_ruleBug310435Enum5720);
            	    lv_lits_4_0=ruleEnumBug310435Lit2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug310435EnumRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"lits",
            	    	        		lv_lits_4_0, 
            	    	        		"EnumBug310435Lit2", 
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
            	    break loop39;
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
    // $ANTLR end "ruleBug310435Enum"


    // $ANTLR start "entryRuleBug310435Val"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2920:1: entryRuleBug310435Val returns [EObject current=null] : iv_ruleBug310435Val= ruleBug310435Val EOF ;
    public final EObject entryRuleBug310435Val() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug310435Val = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2921:2: (iv_ruleBug310435Val= ruleBug310435Val EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2922:2: iv_ruleBug310435Val= ruleBug310435Val EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBug310435ValRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBug310435Val_in_entryRuleBug310435Val5759);
            iv_ruleBug310435Val=ruleBug310435Val();

            state._fsp--;

             current =iv_ruleBug310435Val; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug310435Val5769); 

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
    // $ANTLR end "entryRuleBug310435Val"


    // $ANTLR start "ruleBug310435Val"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2929:1: ruleBug310435Val returns [EObject current=null] : (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) ;
    public final EObject ruleBug310435Val() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_lits_2_0=null;
        Token otherlv_3=null;
        Token lv_lits_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2934:6: ( (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2935:1: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2935:1: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2935:3: otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
            {
            otherlv_0=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleBug310435Val5806); 

                	createLeafNode(otherlv_0, grammarAccess.getBug310435ValAccess().getNumberSignDigitTwoDigitOneKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2939:1: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
            loop40:
            do {
                int alt40=3;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==35) ) {
                    int LA40_2 = input.LA(2);

                    if ( (LA40_2==RULE_ID) ) {
                        alt40=1;
                    }


                }
                else if ( (LA40_0==36) ) {
                    int LA40_3 = input.LA(2);

                    if ( (LA40_3==RULE_STRING) ) {
                        alt40=2;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2939:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2939:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2939:4: otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleBug310435Val5820); 

            	        	createLeafNode(otherlv_1, grammarAccess.getBug310435ValAccess().getKw1Keyword_1_0_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2943:1: ( (lv_lits_2_0= RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2944:1: (lv_lits_2_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2944:1: (lv_lits_2_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2945:3: lv_lits_2_0= RULE_ID
            	    {
            	    lv_lits_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug310435Val5837); 

            	    			createLeafNode(lv_lits_2_0, grammarAccess.getBug310435ValAccess().getLitsIDTerminalRuleCall_1_0_1_0(), "lits"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug310435ValRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"lits",
            	    	        		lv_lits_2_0, 
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2968:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2968:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2968:8: otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleBug310435Val5862); 

            	        	createLeafNode(otherlv_3, grammarAccess.getBug310435ValAccess().getKw2Keyword_1_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2972:1: ( (lv_lits_4_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2973:1: (lv_lits_4_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2973:1: (lv_lits_4_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:2974:3: lv_lits_4_0= RULE_STRING
            	    {
            	    lv_lits_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug310435Val5879); 

            	    			createLeafNode(lv_lits_4_0, grammarAccess.getBug310435ValAccess().getLitsSTRINGTerminalRuleCall_1_1_1_0(), "lits"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBug310435ValRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"lits",
            	    	        		lv_lits_4_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // $ANTLR end "ruleBug310435Val"


    // $ANTLR start "ruleEnumBug310435Lit1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3004:1: ruleEnumBug310435Lit1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleEnumBug310435Lit1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3008:6: ( (enumLiteral_0= 'lit1' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3009:1: (enumLiteral_0= 'lit1' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3009:1: (enumLiteral_0= 'lit1' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3009:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleEnumBug310435Lit15936); 

                    current = grammarAccess.getEnumBug310435Lit1Access().getLit1EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    createLeafNode(enumLiteral_0, grammarAccess.getEnumBug310435Lit1Access().getLit1EnumLiteralDeclaration(), null); 
                

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
    // $ANTLR end "ruleEnumBug310435Lit1"


    // $ANTLR start "ruleEnumBug310435Lit2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3019:1: ruleEnumBug310435Lit2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleEnumBug310435Lit2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3023:6: ( (enumLiteral_0= 'lit2' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3024:1: (enumLiteral_0= 'lit2' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3024:1: (enumLiteral_0= 'lit2' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:3024:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleEnumBug310435Lit25979); 

                    current = grammarAccess.getEnumBug310435Lit2Access().getLit2EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    createLeafNode(enumLiteral_0, grammarAccess.getEnumBug310435Lit2Access().getLit2EnumLiteralDeclaration(), null); 
                

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
    // $ANTLR end "ruleEnumBug310435Lit2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleOp_in_entryRuleOp75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOp85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp132 = new BitSet(new long[]{0x4DA250DF24A58832L,0x000000000000000CL});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp162 = new BitSet(new long[]{0x4DA250DF24A58832L,0x000000000000000CL});
        public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm200 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerm210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleTerm257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleTerm338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRef2_in_ruleTerm365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpare_in_ruleTerm392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_ruleTerm419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransient1_in_ruleTerm446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed1_in_ruleTerm473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed2_in_ruleTerm500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop1_in_ruleTerm527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop2_in_ruleTerm554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop3_in_ruleTerm581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop4_in_ruleTerm608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopBug285452_in_ruleTerm635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDuplicateBug284491_in_ruleTerm662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObjectRef_in_ruleTerm743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_1_in_ruleTerm770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_2_in_ruleTerm797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_ruleTerm824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug305171_in_ruleTerm851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug310435Val_in_ruleTerm878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug310435Enum_in_ruleTerm905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom940 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAtom991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_entryRuleParens1031 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParens1041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleParens1078 = new BitSet(new long[]{0x4DA250DF24A58830L,0x000000000000000CL});
        public static final BitSet FOLLOW_ruleOp_in_ruleParens1100 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleParens1111 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleParens1129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers1179 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers1189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1231 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1253 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleTwoNumbers1271 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1288 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings1331 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings1341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleManyStrings1378 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1395 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType1459 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType1469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleType1506 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType1523 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleType1540 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType1560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21596 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRef21606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleRef21643 = new BitSet(new long[]{0x0000000000180040L});
        public static final BitSet FOLLOW_19_in_ruleRef21663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRef21712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpare_in_entryRuleSpare1764 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpare1774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleSpare1811 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1828 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleSpare1846 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1863 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1906 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleBoolean1953 = new BitSet(new long[]{0x0000000003000000L});
        public static final BitSet FOLLOW_24_in_ruleBoolean1971 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleBoolean1997 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean2014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransient1_in_entryRuleTransient12055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransient12065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleTransient12102 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_27_in_ruleTransient12121 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransient12157 = new BitSet(new long[]{0x0000000010000002L});
        public static final BitSet FOLLOW_28_in_ruleTransient12176 = new BitSet(new long[]{0x0000000008000020L});
        public static final BitSet FOLLOW_27_in_ruleTransient12195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransient12231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed1_in_entryRuleConsumed12275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConsumed12285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleConsumed12322 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleConsumed12336 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12353 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleConsumed12401 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12418 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed2_in_entryRuleConsumed22484 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConsumed22494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleConsumed22531 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleConsumed1_in_ruleConsumed22552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop1_in_entryRuleLoop12588 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop12598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleLoop12636 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleLoop12650 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12667 = new BitSet(new long[]{0x0000000800000010L});
        public static final BitSet FOLLOW_35_in_ruleLoop12685 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12704 = new BitSet(new long[]{0x0000003000000000L});
        public static final BitSet FOLLOW_36_in_ruleLoop12723 = new BitSet(new long[]{0x0000003000000000L});
        public static final BitSet FOLLOW_37_in_ruleLoop12737 = new BitSet(new long[]{0x0000003000000002L});
        public static final BitSet FOLLOW_ruleLoop2_in_entryRuleLoop22775 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop22785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleLoop22822 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22839 = new BitSet(new long[]{0x0000000800000010L});
        public static final BitSet FOLLOW_35_in_ruleLoop22857 = new BitSet(new long[]{0x0000068000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22881 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleLoop22898 = new BitSet(new long[]{0x0000068000000010L});
        public static final BitSet FOLLOW_39_in_ruleLoop22913 = new BitSet(new long[]{0x0000060000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22937 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleLoop22954 = new BitSet(new long[]{0x0000060000000000L});
        public static final BitSet FOLLOW_41_in_ruleLoop22970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleLoop22988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop3_in_entryRuleLoop33025 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop33035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLoop33073 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_36_in_ruleLoop33091 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_39_in_ruleLoop33109 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleLoop33122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop33139 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleLoop33157 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop33174 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleLoop33191 = new BitSet(new long[]{0x0000010000000002L});
        public static final BitSet FOLLOW_ruleLoop4_in_entryRuleLoop43229 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop43239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleLoop43276 = new BitSet(new long[]{0x0000009800000000L});
        public static final BitSet FOLLOW_35_in_ruleLoop43289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_36_in_ruleLoop43307 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_39_in_ruleLoop43326 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleLoop43338 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop43357 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleLoop43375 = new BitSet(new long[]{0x0000060000000002L});
        public static final BitSet FOLLOW_42_in_ruleLoop43388 = new BitSet(new long[]{0x0000220000000002L});
        public static final BitSet FOLLOW_45_in_ruleLoop43401 = new BitSet(new long[]{0x0000020000000002L});
        public static final BitSet FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopBug2854523453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleLoopBug2854523490 = new BitSet(new long[]{0x0001800000000000L});
        public static final BitSet FOLLOW_47_in_ruleLoopBug2854523509 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_48_in_ruleLoopBug2854523540 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopBug2854523558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913599 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDuplicateBug2844913609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleDuplicateBug2844913646 = new BitSet(new long[]{0x001C000000000002L});
        public static final BitSet FOLLOW_50_in_ruleDuplicateBug2844913665 = new BitSet(new long[]{0x001C000000000002L});
        public static final BitSet FOLLOW_51_in_ruleDuplicateBug2844913702 = new BitSet(new long[]{0x001C000000000002L});
        public static final BitSet FOLLOW_52_in_ruleDuplicateBug2844913739 = new BitSet(new long[]{0x001C000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848503790 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectBug2848503800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEmptyObjectBug2848503837 = new BitSet(new long[]{0x0040000000000000L});
        public static final BitSet FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848503858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems3894 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItems3904 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems3949 = new BitSet(new long[]{0x0040000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem3985 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItem3995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleEmptyObjectItem4032 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEmptyObjectItem4049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804394090 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804394100 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleMultiInheritanceBug2804394137 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804394158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti4198 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteMulti4208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti4250 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti4272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObjectRef_in_entryRuleEObjectRef4313 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObjectRef4323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleEObjectRef4360 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEObjectElement_in_ruleEObjectRef4381 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleEObjectRef4393 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEObjectRef4413 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObjectElement_in_entryRuleEObjectElement4449 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObjectElement4459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEObjectElement4500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_1_in_entryRuleTypeBug305577_14540 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug305577_14550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleTypeBug305577_14587 = new BitSet(new long[]{0x3000000000000000L});
        public static final BitSet FOLLOW_ruleTypeBug1A_in_ruleTypeBug305577_14610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug1B_in_ruleTypeBug305577_14637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_2_in_entryRuleTypeBug305577_24673 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug305577_24683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleTypeBug305577_24720 = new BitSet(new long[]{0x3000000000000000L});
        public static final BitSet FOLLOW_ruleTypeBug2B_in_ruleTypeBug305577_24743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug2A_in_ruleTypeBug305577_24770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug1A_in_entryRuleTypeBug1A4808 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug1A4818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleTypeBug1A4864 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug1A4881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug1B_in_entryRuleTypeBug1B4922 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug1B4932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleTypeBug1B4978 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug1B4995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug2A_in_entryRuleTypeBug2A5038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug2A5048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleTypeBug2A5094 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug2A5111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug2B_in_entryRuleTypeBug2B5152 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug2B5162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleTypeBug2B5208 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug2B5225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug305171_in_entryRuleBug3051715266 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug3051715276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleBug3051715313 = new BitSet(new long[]{0x8000000000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_63_in_ruleBug3051715327 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715344 = new BitSet(new long[]{0x0000000010000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_28_in_ruleBug3051715362 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715379 = new BitSet(new long[]{0x0000000010000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_64_in_ruleBug3051715402 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715419 = new BitSet(new long[]{0x0000000010000010L,0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleBug3051715437 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715454 = new BitSet(new long[]{0x0000000010000010L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleBug3051715476 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715493 = new BitSet(new long[]{0x0000000010000010L});
        public static final BitSet FOLLOW_28_in_ruleBug3051715511 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715528 = new BitSet(new long[]{0x0000000010000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715556 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug310435Enum_in_entryRuleBug310435Enum5597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug310435Enum5607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleBug310435Enum5644 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_35_in_ruleBug310435Enum5658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEnumBug310435Lit1_in_ruleBug310435Enum5679 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_36_in_ruleBug310435Enum5699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_ruleEnumBug310435Lit2_in_ruleBug310435Enum5720 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_ruleBug310435Val_in_entryRuleBug310435Val5759 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug310435Val5769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleBug310435Val5806 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_35_in_ruleBug310435Val5820 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug310435Val5837 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_36_in_ruleBug310435Val5862 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug310435Val5879 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_68_in_ruleEnumBug310435Lit15936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleEnumBug310435Lit25979 = new BitSet(new long[]{0x0000000000000002L});
    }


}
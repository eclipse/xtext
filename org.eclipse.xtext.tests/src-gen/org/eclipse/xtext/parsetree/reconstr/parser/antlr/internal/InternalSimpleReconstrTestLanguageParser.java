package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSimpleReconstrTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ID1", "RULE_ID2", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'", "'#3'", "'.'", "'#4'", "'myoption'", "'kw'", "'#5'", "'*'", "','", "'#6'", "'v1'", "'v2'", "'#7'", "'kw0'", "'#8'", "'kw1'", "'kw2'", "'kw30'", "'#9'", "'kw3'", "'kw4'", "'kw5'", "'kw6'", "'#10'", "'#11'", "'kw7'", "'#12'", "'interface'", "'class'", "'#13'", "'static'", "'final'", "'transient'", "'#14'", "'item'", "'#15'", "'#16'", "'refs'", "'#17'", "'#18'", "'ka'", "'kb'", "'#19'", "'kx'", "'ky'", "'kz'", "'#20'", "'#21'", "'#22'", "'lit1'", "'lit2'"
    };
    public static final int T__50=50;
    public static final int RULE_ID1=7;
    public static final int RULE_ID2=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalSimpleReconstrTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSimpleReconstrTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSimpleReconstrTestLanguage.g"; }



     	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalSimpleReconstrTestLanguage.g:68:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:69:2: (iv_ruleOp= ruleOp EOF )
            // InternalSimpleReconstrTestLanguage.g:70:2: iv_ruleOp= ruleOp EOF
            {
             newCompositeNode(grammarAccess.getOpRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOp=ruleOp();

            state._fsp--;

             current =iv_ruleOp; 
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
    // $ANTLR end "entryRuleOp"


    // $ANTLR start "ruleOp"
    // InternalSimpleReconstrTestLanguage.g:77:1: ruleOp returns [EObject current=null] : (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term_0 = null;

        EObject lv_values_2_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:80:28: ( (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:81:1: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:81:1: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:82:5: this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getOpAccess().getTermParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_3);
            this_Term_0=ruleTerm();

            state._fsp--;

             
                    current = this_Term_0; 
                    afterParserOrEnumRuleCall();
                
            // InternalSimpleReconstrTestLanguage.g:90:1: ( () ( (lv_values_2_0= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==13||(LA1_0>=17 && LA1_0<=18)||LA1_0==20||LA1_0==23||LA1_0==25||LA1_0==28||LA1_0==31||(LA1_0>=34 && LA1_0<=38)||(LA1_0>=40 && LA1_0<=41)||LA1_0==46||LA1_0==48||LA1_0==51||LA1_0==55||(LA1_0>=57 && LA1_0<=58)||(LA1_0>=60 && LA1_0<=61)||LA1_0==64||(LA1_0>=68 && LA1_0<=70)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:90:2: () ( (lv_values_2_0= ruleTerm ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:90:2: ()
            	    // InternalSimpleReconstrTestLanguage.g:91:5: 
            	    {

            	            current = forceCreateModelElementAndAdd(
            	                grammarAccess.getOpAccess().getOpValuesAction_1_0(),
            	                current);
            	        

            	    }

            	    // InternalSimpleReconstrTestLanguage.g:96:2: ( (lv_values_2_0= ruleTerm ) )
            	    // InternalSimpleReconstrTestLanguage.g:97:1: (lv_values_2_0= ruleTerm )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:97:1: (lv_values_2_0= ruleTerm )
            	    // InternalSimpleReconstrTestLanguage.g:98:3: lv_values_2_0= ruleTerm
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getOpAccess().getValuesTermParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_values_2_0=ruleTerm();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getOpRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_2_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.Term");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // InternalSimpleReconstrTestLanguage.g:122:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:123:2: (iv_ruleTerm= ruleTerm EOF )
            // InternalSimpleReconstrTestLanguage.g:124:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalSimpleReconstrTestLanguage.g:131:1: ruleTerm returns [EObject current=null] : (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest ) ;
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

        EObject this_CrossRefNameTest_25 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:134:28: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest ) )
            // InternalSimpleReconstrTestLanguage.g:135:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest )
            {
            // InternalSimpleReconstrTestLanguage.g:135:1: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest )
            int alt2=26;
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
            case 17:
                {
                alt2=3;
                }
                break;
            case 18:
                {
                alt2=4;
                }
                break;
            case 20:
                {
                alt2=5;
                }
                break;
            case 23:
                {
                alt2=6;
                }
                break;
            case 25:
                {
                alt2=7;
                }
                break;
            case 28:
                {
                alt2=8;
                }
                break;
            case 31:
                {
                alt2=9;
                }
                break;
            case 34:
                {
                alt2=10;
                }
                break;
            case 35:
            case 36:
                {
                alt2=11;
                }
                break;
            case 40:
                {
                alt2=12;
                }
                break;
            case 37:
            case 38:
            case 41:
                {
                alt2=13;
                }
                break;
            case 46:
                {
                alt2=14;
                }
                break;
            case 48:
                {
                alt2=15;
                }
                break;
            case 51:
                {
                alt2=16;
                }
                break;
            case 55:
                {
                alt2=17;
                }
                break;
            case 57:
                {
                alt2=18;
                }
                break;
            case 58:
                {
                alt2=19;
                }
                break;
            case 60:
                {
                alt2=20;
                }
                break;
            case 61:
                {
                alt2=21;
                }
                break;
            case 13:
                {
                alt2=22;
                }
                break;
            case 64:
                {
                alt2=23;
                }
                break;
            case 69:
                {
                alt2=24;
                }
                break;
            case 68:
                {
                alt2=25;
                }
                break;
            case 70:
                {
                alt2=26;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:136:5: this_Atom_0= ruleAtom
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getAtomParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Atom_0=ruleAtom();

                    state._fsp--;

                     
                            current = this_Atom_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:146:5: this_TwoNumbers_1= ruleTwoNumbers
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getTwoNumbersParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoNumbers_1=ruleTwoNumbers();

                    state._fsp--;

                     
                            current = this_TwoNumbers_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalSimpleReconstrTestLanguage.g:156:5: this_ManyStrings_2= ruleManyStrings
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getManyStringsParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ManyStrings_2=ruleManyStrings();

                    state._fsp--;

                     
                            current = this_ManyStrings_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalSimpleReconstrTestLanguage.g:166:5: this_Type_3= ruleType
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Type_3=ruleType();

                    state._fsp--;

                     
                            current = this_Type_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalSimpleReconstrTestLanguage.g:176:5: this_Ref2_4= ruleRef2
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getRef2ParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Ref2_4=ruleRef2();

                    state._fsp--;

                     
                            current = this_Ref2_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalSimpleReconstrTestLanguage.g:186:5: this_Spare_5= ruleSpare
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getSpareParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Spare_5=ruleSpare();

                    state._fsp--;

                     
                            current = this_Spare_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalSimpleReconstrTestLanguage.g:196:5: this_Boolean_6= ruleBoolean
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getBooleanParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Boolean_6=ruleBoolean();

                    state._fsp--;

                     
                            current = this_Boolean_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalSimpleReconstrTestLanguage.g:206:5: this_Transient1_7= ruleTransient1
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getTransient1ParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Transient1_7=ruleTransient1();

                    state._fsp--;

                     
                            current = this_Transient1_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // InternalSimpleReconstrTestLanguage.g:216:5: this_Consumed1_8= ruleConsumed1
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getConsumed1ParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Consumed1_8=ruleConsumed1();

                    state._fsp--;

                     
                            current = this_Consumed1_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // InternalSimpleReconstrTestLanguage.g:226:5: this_Consumed2_9= ruleConsumed2
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getConsumed2ParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Consumed2_9=ruleConsumed2();

                    state._fsp--;

                     
                            current = this_Consumed2_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // InternalSimpleReconstrTestLanguage.g:236:5: this_Loop1_10= ruleLoop1
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getLoop1ParserRuleCall_10()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop1_10=ruleLoop1();

                    state._fsp--;

                     
                            current = this_Loop1_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // InternalSimpleReconstrTestLanguage.g:246:5: this_Loop2_11= ruleLoop2
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getLoop2ParserRuleCall_11()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop2_11=ruleLoop2();

                    state._fsp--;

                     
                            current = this_Loop2_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 13 :
                    // InternalSimpleReconstrTestLanguage.g:256:5: this_Loop3_12= ruleLoop3
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getLoop3ParserRuleCall_12()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop3_12=ruleLoop3();

                    state._fsp--;

                     
                            current = this_Loop3_12; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 14 :
                    // InternalSimpleReconstrTestLanguage.g:266:5: this_Loop4_13= ruleLoop4
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getLoop4ParserRuleCall_13()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop4_13=ruleLoop4();

                    state._fsp--;

                     
                            current = this_Loop4_13; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 15 :
                    // InternalSimpleReconstrTestLanguage.g:276:5: this_LoopBug285452_14= ruleLoopBug285452
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getLoopBug285452ParserRuleCall_14()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LoopBug285452_14=ruleLoopBug285452();

                    state._fsp--;

                     
                            current = this_LoopBug285452_14; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 16 :
                    // InternalSimpleReconstrTestLanguage.g:286:5: this_DuplicateBug284491_15= ruleDuplicateBug284491
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getDuplicateBug284491ParserRuleCall_15()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DuplicateBug284491_15=ruleDuplicateBug284491();

                    state._fsp--;

                     
                            current = this_DuplicateBug284491_15; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 17 :
                    // InternalSimpleReconstrTestLanguage.g:296:5: this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getEmptyObjectBug284850ParserRuleCall_16()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EmptyObjectBug284850_16=ruleEmptyObjectBug284850();

                    state._fsp--;

                     
                            current = this_EmptyObjectBug284850_16; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 18 :
                    // InternalSimpleReconstrTestLanguage.g:306:5: this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getMultiInheritanceBug280439ParserRuleCall_17()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MultiInheritanceBug280439_17=ruleMultiInheritanceBug280439();

                    state._fsp--;

                     
                            current = this_MultiInheritanceBug280439_17; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 19 :
                    // InternalSimpleReconstrTestLanguage.g:316:5: this_EObjectRef_18= ruleEObjectRef
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getEObjectRefParserRuleCall_18()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EObjectRef_18=ruleEObjectRef();

                    state._fsp--;

                     
                            current = this_EObjectRef_18; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 20 :
                    // InternalSimpleReconstrTestLanguage.g:326:5: this_TypeBug305577_1_19= ruleTypeBug305577_1
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getTypeBug305577_1ParserRuleCall_19()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug305577_1_19=ruleTypeBug305577_1();

                    state._fsp--;

                     
                            current = this_TypeBug305577_1_19; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 21 :
                    // InternalSimpleReconstrTestLanguage.g:336:5: this_TypeBug305577_2_20= ruleTypeBug305577_2
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getTypeBug305577_2ParserRuleCall_20()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug305577_2_20=ruleTypeBug305577_2();

                    state._fsp--;

                     
                            current = this_TypeBug305577_2_20; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 22 :
                    // InternalSimpleReconstrTestLanguage.g:346:5: this_Parens_21= ruleParens
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getParensParserRuleCall_21()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Parens_21=ruleParens();

                    state._fsp--;

                     
                            current = this_Parens_21; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 23 :
                    // InternalSimpleReconstrTestLanguage.g:356:5: this_Bug305171_22= ruleBug305171
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getBug305171ParserRuleCall_22()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug305171_22=ruleBug305171();

                    state._fsp--;

                     
                            current = this_Bug305171_22; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 24 :
                    // InternalSimpleReconstrTestLanguage.g:366:5: this_Bug310435Val_23= ruleBug310435Val
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getBug310435ValParserRuleCall_23()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug310435Val_23=ruleBug310435Val();

                    state._fsp--;

                     
                            current = this_Bug310435Val_23; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 25 :
                    // InternalSimpleReconstrTestLanguage.g:376:5: this_Bug310435Enum_24= ruleBug310435Enum
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getBug310435EnumParserRuleCall_24()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug310435Enum_24=ruleBug310435Enum();

                    state._fsp--;

                     
                            current = this_Bug310435Enum_24; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 26 :
                    // InternalSimpleReconstrTestLanguage.g:386:5: this_CrossRefNameTest_25= ruleCrossRefNameTest
                    {
                     
                            newCompositeNode(grammarAccess.getTermAccess().getCrossRefNameTestParserRuleCall_25()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CrossRefNameTest_25=ruleCrossRefNameTest();

                    state._fsp--;

                     
                            current = this_CrossRefNameTest_25; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // InternalSimpleReconstrTestLanguage.g:402:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:403:2: (iv_ruleAtom= ruleAtom EOF )
            // InternalSimpleReconstrTestLanguage.g:404:2: iv_ruleAtom= ruleAtom EOF
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
    // InternalSimpleReconstrTestLanguage.g:411:1: ruleAtom returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:414:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:415:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:415:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:416:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:416:1: (lv_name_0_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:417:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAtomAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAtomRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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


    // $ANTLR start "entryRuleParens"
    // InternalSimpleReconstrTestLanguage.g:441:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:442:2: (iv_ruleParens= ruleParens EOF )
            // InternalSimpleReconstrTestLanguage.g:443:2: iv_ruleParens= ruleParens EOF
            {
             newCompositeNode(grammarAccess.getParensRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParens=ruleParens();

            state._fsp--;

             current =iv_ruleParens; 
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
    // $ANTLR end "entryRuleParens"


    // $ANTLR start "ruleParens"
    // InternalSimpleReconstrTestLanguage.g:450:1: ruleParens returns [EObject current=null] : (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;
        EObject this_Op_1 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:453:28: ( (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // InternalSimpleReconstrTestLanguage.g:454:1: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // InternalSimpleReconstrTestLanguage.g:454:1: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // InternalSimpleReconstrTestLanguage.g:454:3: otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getParensAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getParensAccess().getOpParserRuleCall_1()); 
                
            pushFollow(FollowSets000.FOLLOW_5);
            this_Op_1=ruleOp();

            state._fsp--;

             
                    current = this_Op_1; 
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getParensAccess().getRightParenthesisKeyword_2());
                
            // InternalSimpleReconstrTestLanguage.g:471:1: ( (lv_em_3_0= '!' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:472:1: (lv_em_3_0= '!' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:472:1: (lv_em_3_0= '!' )
                    // InternalSimpleReconstrTestLanguage.g:473:3: lv_em_3_0= '!'
                    {
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_em_3_0, grammarAccess.getParensAccess().getEmExclamationMarkKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getParensRule());
                    	        }
                           		setWithLastConsumed(current, "em", lv_em_3_0, "!");
                    	    

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
    // $ANTLR end "ruleParens"


    // $ANTLR start "entryRuleTwoNumbers"
    // InternalSimpleReconstrTestLanguage.g:494:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:495:2: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // InternalSimpleReconstrTestLanguage.g:496:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             newCompositeNode(grammarAccess.getTwoNumbersRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoNumbers=ruleTwoNumbers();

            state._fsp--;

             current =iv_ruleTwoNumbers; 
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
    // $ANTLR end "entryRuleTwoNumbers"


    // $ANTLR start "ruleTwoNumbers"
    // InternalSimpleReconstrTestLanguage.g:503:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1_0_0=null;
        Token lv_num2_1_0=null;
        Token otherlv_2=null;
        Token lv_num3_3_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:506:28: ( ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:507:1: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:507:1: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:507:2: ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            {
            // InternalSimpleReconstrTestLanguage.g:507:2: ( (lv_num1_0_0= RULE_INT ) )
            // InternalSimpleReconstrTestLanguage.g:508:1: (lv_num1_0_0= RULE_INT )
            {
            // InternalSimpleReconstrTestLanguage.g:508:1: (lv_num1_0_0= RULE_INT )
            // InternalSimpleReconstrTestLanguage.g:509:3: lv_num1_0_0= RULE_INT
            {
            lv_num1_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_num1_0_0, grammarAccess.getTwoNumbersAccess().getNum1INTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTwoNumbersRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"num1",
                    		lv_num1_0_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:525:2: ( (lv_num2_1_0= RULE_INT ) )
            // InternalSimpleReconstrTestLanguage.g:526:1: (lv_num2_1_0= RULE_INT )
            {
            // InternalSimpleReconstrTestLanguage.g:526:1: (lv_num2_1_0= RULE_INT )
            // InternalSimpleReconstrTestLanguage.g:527:3: lv_num2_1_0= RULE_INT
            {
            lv_num2_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            			newLeafNode(lv_num2_1_0, grammarAccess.getTwoNumbersAccess().getNum2INTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTwoNumbersRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"num2",
                    		lv_num2_1_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:543:2: (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:543:4: otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) )
            	    {
            	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_7); 

            	        	newLeafNode(otherlv_2, grammarAccess.getTwoNumbersAccess().getNumberSignKeyword_2_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:547:1: ( (lv_num3_3_0= RULE_INT ) )
            	    // InternalSimpleReconstrTestLanguage.g:548:1: (lv_num3_3_0= RULE_INT )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:548:1: (lv_num3_3_0= RULE_INT )
            	    // InternalSimpleReconstrTestLanguage.g:549:3: lv_num3_3_0= RULE_INT
            	    {
            	    lv_num3_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            	    			newLeafNode(lv_num3_3_0, grammarAccess.getTwoNumbersAccess().getNum3INTTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTwoNumbersRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"num3",
            	            		lv_num3_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

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
    // $ANTLR end "ruleTwoNumbers"


    // $ANTLR start "entryRuleManyStrings"
    // InternalSimpleReconstrTestLanguage.g:573:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:574:2: (iv_ruleManyStrings= ruleManyStrings EOF )
            // InternalSimpleReconstrTestLanguage.g:575:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             newCompositeNode(grammarAccess.getManyStringsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleManyStrings=ruleManyStrings();

            state._fsp--;

             current =iv_ruleManyStrings; 
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
    // $ANTLR end "entryRuleManyStrings"


    // $ANTLR start "ruleManyStrings"
    // InternalSimpleReconstrTestLanguage.g:582:1: ruleManyStrings returns [EObject current=null] : (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_str1_1_0=null;
        Token lv_str2_2_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:585:28: ( (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:586:1: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:586:1: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            // InternalSimpleReconstrTestLanguage.g:586:3: otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_9); 

                	newLeafNode(otherlv_0, grammarAccess.getManyStringsAccess().getEqualsSignKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:590:1: ( (lv_str1_1_0= RULE_STRING ) )*
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
            	    // InternalSimpleReconstrTestLanguage.g:591:1: (lv_str1_1_0= RULE_STRING )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:591:1: (lv_str1_1_0= RULE_STRING )
            	    // InternalSimpleReconstrTestLanguage.g:592:3: lv_str1_1_0= RULE_STRING
            	    {
            	    lv_str1_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_9); 

            	    			newLeafNode(lv_str1_1_0, grammarAccess.getManyStringsAccess().getStr1STRINGTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getManyStringsRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"str1",
            	            		lv_str1_1_0, 
            	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalSimpleReconstrTestLanguage.g:608:3: ( (lv_str2_2_0= RULE_STRING ) )
            // InternalSimpleReconstrTestLanguage.g:609:1: (lv_str2_2_0= RULE_STRING )
            {
            // InternalSimpleReconstrTestLanguage.g:609:1: (lv_str2_2_0= RULE_STRING )
            // InternalSimpleReconstrTestLanguage.g:610:3: lv_str2_2_0= RULE_STRING
            {
            lv_str2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_str2_2_0, grammarAccess.getManyStringsAccess().getStr2STRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getManyStringsRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"str2",
                    		lv_str2_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

            }


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
    // $ANTLR end "ruleManyStrings"


    // $ANTLR start "entryRuleType"
    // InternalSimpleReconstrTestLanguage.g:634:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:635:2: (iv_ruleType= ruleType EOF )
            // InternalSimpleReconstrTestLanguage.g:636:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalSimpleReconstrTestLanguage.g:643:1: ruleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:646:28: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:647:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:647:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:647:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:651:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:652:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:652:1: (lv_name_1_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:653:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_2());
                
            // InternalSimpleReconstrTestLanguage.g:673:1: ( (otherlv_3= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:674:1: (otherlv_3= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:674:1: (otherlv_3= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:675:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_0()); 
            	

            }


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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleRef2"
    // InternalSimpleReconstrTestLanguage.g:694:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:695:2: (iv_ruleRef2= ruleRef2 EOF )
            // InternalSimpleReconstrTestLanguage.g:696:2: iv_ruleRef2= ruleRef2 EOF
            {
             newCompositeNode(grammarAccess.getRef2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRef2=ruleRef2();

            state._fsp--;

             current =iv_ruleRef2; 
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
    // $ANTLR end "entryRuleRef2"


    // $ANTLR start "ruleRef2"
    // InternalSimpleReconstrTestLanguage.g:703:1: ruleRef2 returns [EObject current=null] : (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_ref2_1_1=null;
        Token lv_ref2_1_2=null;
        Token lv_ref2_1_3=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:706:28: ( (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:707:1: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:707:1: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:707:3: otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_12); 

                	newLeafNode(otherlv_0, grammarAccess.getRef2Access().getNumberSignDigitTwoKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:711:1: ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            // InternalSimpleReconstrTestLanguage.g:712:1: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            {
            // InternalSimpleReconstrTestLanguage.g:712:1: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            // InternalSimpleReconstrTestLanguage.g:713:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
            {
            // InternalSimpleReconstrTestLanguage.g:713:1: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt6=1;
                }
                break;
            case RULE_STRING:
                {
                alt6=2;
                }
                break;
            case 22:
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
                    // InternalSimpleReconstrTestLanguage.g:714:3: lv_ref2_1_1= 'mykeyword1'
                    {
                    lv_ref2_1_1=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_ref2_1_1, grammarAccess.getRef2Access().getRef2Mykeyword1Keyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRef2Rule());
                    	        }
                           		setWithLastConsumed(current, "ref2", lv_ref2_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:726:8: lv_ref2_1_2= RULE_STRING
                    {
                    lv_ref2_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_ref2_1_2, grammarAccess.getRef2Access().getRef2STRINGTerminalRuleCall_1_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRef2Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"ref2",
                            		lv_ref2_1_2, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }
                    break;
                case 3 :
                    // InternalSimpleReconstrTestLanguage.g:741:8: lv_ref2_1_3= 'mykeyword2'
                    {
                    lv_ref2_1_3=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                            newLeafNode(lv_ref2_1_3, grammarAccess.getRef2Access().getRef2Mykeyword2Keyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRef2Rule());
                    	        }
                           		setWithLastConsumed(current, "ref2", lv_ref2_1_3, null);
                    	    

                    }
                    break;

            }


            }


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
    // $ANTLR end "ruleRef2"


    // $ANTLR start "entryRuleSpare"
    // InternalSimpleReconstrTestLanguage.g:764:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:765:2: (iv_ruleSpare= ruleSpare EOF )
            // InternalSimpleReconstrTestLanguage.g:766:2: iv_ruleSpare= ruleSpare EOF
            {
             newCompositeNode(grammarAccess.getSpareRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpare=ruleSpare();

            state._fsp--;

             current =iv_ruleSpare; 
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
    // $ANTLR end "entryRuleSpare"


    // $ANTLR start "ruleSpare"
    // InternalSimpleReconstrTestLanguage.g:773:1: ruleSpare returns [EObject current=null] : (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:776:28: ( (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:777:1: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:777:1: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:777:3: otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getSpareAccess().getNumberSignDigitThreeKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:781:1: ( (lv_id_1_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:782:1: (lv_id_1_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:782:1: (lv_id_1_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:783:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            			newLeafNode(lv_id_1_0, grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpareRule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:799:2: (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:799:4: otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_10); 

            	        	newLeafNode(otherlv_2, grammarAccess.getSpareAccess().getFullStopKeyword_2_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:803:1: ( (lv_id_3_0= RULE_ID ) )
            	    // InternalSimpleReconstrTestLanguage.g:804:1: (lv_id_3_0= RULE_ID )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:804:1: (lv_id_3_0= RULE_ID )
            	    // InternalSimpleReconstrTestLanguage.g:805:3: lv_id_3_0= RULE_ID
            	    {
            	    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    			newLeafNode(lv_id_3_0, grammarAccess.getSpareAccess().getIdIDTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getSpareRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"id",
            	            		lv_id_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

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
    // $ANTLR end "ruleSpare"


    // $ANTLR start "entryRuleBoolean"
    // InternalSimpleReconstrTestLanguage.g:829:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:830:2: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalSimpleReconstrTestLanguage.g:831:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalSimpleReconstrTestLanguage.g:838:1: ruleBoolean returns [EObject current=null] : (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_bool_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:841:28: ( (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:842:1: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:842:1: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:842:3: otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getBooleanAccess().getNumberSignDigitFourKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:846:1: ( (lv_bool_1_0= 'myoption' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:847:1: (lv_bool_1_0= 'myoption' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:847:1: (lv_bool_1_0= 'myoption' )
                    // InternalSimpleReconstrTestLanguage.g:848:3: lv_bool_1_0= 'myoption'
                    {
                    lv_bool_1_0=(Token)match(input,26,FollowSets000.FOLLOW_15); 

                            newLeafNode(lv_bool_1_0, grammarAccess.getBooleanAccess().getBoolMyoptionKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanRule());
                    	        }
                           		setWithLastConsumed(current, "bool", true, "myoption");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getBooleanAccess().getKwKeyword_2());
                
            // InternalSimpleReconstrTestLanguage.g:865:1: ( (lv_value_3_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:866:1: (lv_value_3_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:866:1: (lv_value_3_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:867:3: lv_value_3_0= RULE_ID
            {
            lv_value_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_3_0, grammarAccess.getBooleanAccess().getValueIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBooleanRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleTransient1"
    // InternalSimpleReconstrTestLanguage.g:891:1: entryRuleTransient1 returns [EObject current=null] : iv_ruleTransient1= ruleTransient1 EOF ;
    public final EObject entryRuleTransient1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransient1 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:892:2: (iv_ruleTransient1= ruleTransient1 EOF )
            // InternalSimpleReconstrTestLanguage.g:893:2: iv_ruleTransient1= ruleTransient1 EOF
            {
             newCompositeNode(grammarAccess.getTransient1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransient1=ruleTransient1();

            state._fsp--;

             current =iv_ruleTransient1; 
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
    // $ANTLR end "entryRuleTransient1"


    // $ANTLR start "ruleTransient1"
    // InternalSimpleReconstrTestLanguage.g:900:1: ruleTransient1 returns [EObject current=null] : (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) ;
    public final EObject ruleTransient1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_precStar_1_0=null;
        Token lv_prec_2_0=null;
        Token otherlv_3=null;
        Token lv_scaleStar_4_0=null;
        Token lv_scale_5_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:903:28: ( (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) )
            // InternalSimpleReconstrTestLanguage.g:904:1: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            {
            // InternalSimpleReconstrTestLanguage.g:904:1: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            // InternalSimpleReconstrTestLanguage.g:904:3: otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_16); 

                	newLeafNode(otherlv_0, grammarAccess.getTransient1Access().getNumberSignDigitFiveKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:908:1: ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==29) ) {
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
                    // InternalSimpleReconstrTestLanguage.g:908:2: ( (lv_precStar_1_0= '*' ) )
                    {
                    // InternalSimpleReconstrTestLanguage.g:908:2: ( (lv_precStar_1_0= '*' ) )
                    // InternalSimpleReconstrTestLanguage.g:909:1: (lv_precStar_1_0= '*' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:909:1: (lv_precStar_1_0= '*' )
                    // InternalSimpleReconstrTestLanguage.g:910:3: lv_precStar_1_0= '*'
                    {
                    lv_precStar_1_0=(Token)match(input,29,FollowSets000.FOLLOW_17); 

                            newLeafNode(lv_precStar_1_0, grammarAccess.getTransient1Access().getPrecStarAsteriskKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransient1Rule());
                    	        }
                           		setWithLastConsumed(current, "precStar", true, "*");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:924:6: ( (lv_prec_2_0= RULE_INT ) )
                    {
                    // InternalSimpleReconstrTestLanguage.g:924:6: ( (lv_prec_2_0= RULE_INT ) )
                    // InternalSimpleReconstrTestLanguage.g:925:1: (lv_prec_2_0= RULE_INT )
                    {
                    // InternalSimpleReconstrTestLanguage.g:925:1: (lv_prec_2_0= RULE_INT )
                    // InternalSimpleReconstrTestLanguage.g:926:3: lv_prec_2_0= RULE_INT
                    {
                    lv_prec_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_17); 

                    			newLeafNode(lv_prec_2_0, grammarAccess.getTransient1Access().getPrecINTTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTransient1Rule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"prec",
                            		lv_prec_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalSimpleReconstrTestLanguage.g:942:3: (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:942:5: otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
                    {
                    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_16); 

                        	newLeafNode(otherlv_3, grammarAccess.getTransient1Access().getCommaKeyword_2_0());
                        
                    // InternalSimpleReconstrTestLanguage.g:946:1: ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==29) ) {
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
                            // InternalSimpleReconstrTestLanguage.g:946:2: ( (lv_scaleStar_4_0= '*' ) )
                            {
                            // InternalSimpleReconstrTestLanguage.g:946:2: ( (lv_scaleStar_4_0= '*' ) )
                            // InternalSimpleReconstrTestLanguage.g:947:1: (lv_scaleStar_4_0= '*' )
                            {
                            // InternalSimpleReconstrTestLanguage.g:947:1: (lv_scaleStar_4_0= '*' )
                            // InternalSimpleReconstrTestLanguage.g:948:3: lv_scaleStar_4_0= '*'
                            {
                            lv_scaleStar_4_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                                    newLeafNode(lv_scaleStar_4_0, grammarAccess.getTransient1Access().getScaleStarAsteriskKeyword_2_1_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTransient1Rule());
                            	        }
                                   		setWithLastConsumed(current, "scaleStar", true, "*");
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalSimpleReconstrTestLanguage.g:962:6: ( (lv_scale_5_0= RULE_INT ) )
                            {
                            // InternalSimpleReconstrTestLanguage.g:962:6: ( (lv_scale_5_0= RULE_INT ) )
                            // InternalSimpleReconstrTestLanguage.g:963:1: (lv_scale_5_0= RULE_INT )
                            {
                            // InternalSimpleReconstrTestLanguage.g:963:1: (lv_scale_5_0= RULE_INT )
                            // InternalSimpleReconstrTestLanguage.g:964:3: lv_scale_5_0= RULE_INT
                            {
                            lv_scale_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                            			newLeafNode(lv_scale_5_0, grammarAccess.getTransient1Access().getScaleINTTerminalRuleCall_2_1_1_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTransient1Rule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"scale",
                                    		lv_scale_5_0, 
                                    		"org.eclipse.xtext.common.Terminals.INT");
                            	    

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
    // $ANTLR end "ruleTransient1"


    // $ANTLR start "entryRuleConsumed1"
    // InternalSimpleReconstrTestLanguage.g:988:1: entryRuleConsumed1 returns [EObject current=null] : iv_ruleConsumed1= ruleConsumed1 EOF ;
    public final EObject entryRuleConsumed1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed1 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:989:2: (iv_ruleConsumed1= ruleConsumed1 EOF )
            // InternalSimpleReconstrTestLanguage.g:990:2: iv_ruleConsumed1= ruleConsumed1 EOF
            {
             newCompositeNode(grammarAccess.getConsumed1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConsumed1=ruleConsumed1();

            state._fsp--;

             current =iv_ruleConsumed1; 
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
    // $ANTLR end "entryRuleConsumed1"


    // $ANTLR start "ruleConsumed1"
    // InternalSimpleReconstrTestLanguage.g:997:1: ruleConsumed1 returns [EObject current=null] : (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) ;
    public final EObject ruleConsumed1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_v1_2_0=null;
        Token lv_v2_3_0=null;
        Token otherlv_4=null;
        Token lv_v2_5_0=null;
        Token lv_v1_6_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1000:28: ( (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1001:1: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1001:1: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1001:3: otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_18); 

                	newLeafNode(otherlv_0, grammarAccess.getConsumed1Access().getNumberSignDigitSixKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1005:1: ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            else if ( (LA14_0==33) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1005:2: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1005:2: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    // InternalSimpleReconstrTestLanguage.g:1005:4: otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_19); 

                        	newLeafNode(otherlv_1, grammarAccess.getConsumed1Access().getV1Keyword_1_0_0());
                        
                    // InternalSimpleReconstrTestLanguage.g:1009:1: ( (lv_v1_2_0= RULE_INT ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_INT) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSimpleReconstrTestLanguage.g:1010:1: (lv_v1_2_0= RULE_INT )
                    	    {
                    	    // InternalSimpleReconstrTestLanguage.g:1010:1: (lv_v1_2_0= RULE_INT )
                    	    // InternalSimpleReconstrTestLanguage.g:1011:3: lv_v1_2_0= RULE_INT
                    	    {
                    	    lv_v1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_19); 

                    	    			newLeafNode(lv_v1_2_0, grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_0_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConsumed1Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"v1",
                    	            		lv_v1_2_0, 
                    	            		"org.eclipse.xtext.common.Terminals.INT");
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // InternalSimpleReconstrTestLanguage.g:1027:3: ( (lv_v2_3_0= RULE_ID ) )
                    // InternalSimpleReconstrTestLanguage.g:1028:1: (lv_v2_3_0= RULE_ID )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1028:1: (lv_v2_3_0= RULE_ID )
                    // InternalSimpleReconstrTestLanguage.g:1029:3: lv_v2_3_0= RULE_ID
                    {
                    lv_v2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_v2_3_0, grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConsumed1Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"v2",
                            		lv_v2_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1046:6: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1046:6: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    // InternalSimpleReconstrTestLanguage.g:1046:8: otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) )
                    {
                    otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_19); 

                        	newLeafNode(otherlv_4, grammarAccess.getConsumed1Access().getV2Keyword_1_1_0());
                        
                    // InternalSimpleReconstrTestLanguage.g:1050:1: ( (lv_v2_5_0= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalSimpleReconstrTestLanguage.g:1051:1: (lv_v2_5_0= RULE_ID )
                    	    {
                    	    // InternalSimpleReconstrTestLanguage.g:1051:1: (lv_v2_5_0= RULE_ID )
                    	    // InternalSimpleReconstrTestLanguage.g:1052:3: lv_v2_5_0= RULE_ID
                    	    {
                    	    lv_v2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

                    	    			newLeafNode(lv_v2_5_0, grammarAccess.getConsumed1Access().getV2IDTerminalRuleCall_1_1_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConsumed1Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"v2",
                    	            		lv_v2_5_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // InternalSimpleReconstrTestLanguage.g:1068:3: ( (lv_v1_6_0= RULE_INT ) )
                    // InternalSimpleReconstrTestLanguage.g:1069:1: (lv_v1_6_0= RULE_INT )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1069:1: (lv_v1_6_0= RULE_INT )
                    // InternalSimpleReconstrTestLanguage.g:1070:3: lv_v1_6_0= RULE_INT
                    {
                    lv_v1_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_v1_6_0, grammarAccess.getConsumed1Access().getV1INTTerminalRuleCall_1_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConsumed1Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"v1",
                            		lv_v1_6_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


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
    // $ANTLR end "ruleConsumed1"


    // $ANTLR start "entryRuleConsumed2"
    // InternalSimpleReconstrTestLanguage.g:1094:1: entryRuleConsumed2 returns [EObject current=null] : iv_ruleConsumed2= ruleConsumed2 EOF ;
    public final EObject entryRuleConsumed2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConsumed2 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1095:2: (iv_ruleConsumed2= ruleConsumed2 EOF )
            // InternalSimpleReconstrTestLanguage.g:1096:2: iv_ruleConsumed2= ruleConsumed2 EOF
            {
             newCompositeNode(grammarAccess.getConsumed2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConsumed2=ruleConsumed2();

            state._fsp--;

             current =iv_ruleConsumed2; 
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
    // $ANTLR end "entryRuleConsumed2"


    // $ANTLR start "ruleConsumed2"
    // InternalSimpleReconstrTestLanguage.g:1103:1: ruleConsumed2 returns [EObject current=null] : (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) ;
    public final EObject ruleConsumed2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_child_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1106:28: ( (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1107:1: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1107:1: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            // InternalSimpleReconstrTestLanguage.g:1107:3: otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_20); 

                	newLeafNode(otherlv_0, grammarAccess.getConsumed2Access().getNumberSignDigitSevenKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1111:1: ( (lv_child_1_0= ruleConsumed1 ) )
            // InternalSimpleReconstrTestLanguage.g:1112:1: (lv_child_1_0= ruleConsumed1 )
            {
            // InternalSimpleReconstrTestLanguage.g:1112:1: (lv_child_1_0= ruleConsumed1 )
            // InternalSimpleReconstrTestLanguage.g:1113:3: lv_child_1_0= ruleConsumed1
            {
             
            	        newCompositeNode(grammarAccess.getConsumed2Access().getChildConsumed1ParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_child_1_0=ruleConsumed1();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConsumed2Rule());
            	        }
                   		set(
                   			current, 
                   			"child",
                    		lv_child_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.Consumed1");
            	        afterParserOrEnumRuleCall();
            	    

            }


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
    // $ANTLR end "ruleConsumed2"


    // $ANTLR start "entryRuleLoop1"
    // InternalSimpleReconstrTestLanguage.g:1137:1: entryRuleLoop1 returns [EObject current=null] : iv_ruleLoop1= ruleLoop1 EOF ;
    public final EObject entryRuleLoop1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop1 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1138:2: (iv_ruleLoop1= ruleLoop1 EOF )
            // InternalSimpleReconstrTestLanguage.g:1139:2: iv_ruleLoop1= ruleLoop1 EOF
            {
             newCompositeNode(grammarAccess.getLoop1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop1=ruleLoop1();

            state._fsp--;

             current =iv_ruleLoop1; 
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
    // $ANTLR end "entryRuleLoop1"


    // $ANTLR start "ruleLoop1"
    // InternalSimpleReconstrTestLanguage.g:1146:1: ruleLoop1 returns [EObject current=null] : ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) ;
    public final EObject ruleLoop1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1149:28: ( ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) )
            // InternalSimpleReconstrTestLanguage.g:1150:1: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            {
            // InternalSimpleReconstrTestLanguage.g:1150:1: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            // InternalSimpleReconstrTestLanguage.g:1150:2: (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
            {
            // InternalSimpleReconstrTestLanguage.g:1150:2: (otherlv_0= 'kw0' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1150:4: otherlv_0= 'kw0'
                    {
                    otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_21); 

                        	newLeafNode(otherlv_0, grammarAccess.getLoop1Access().getKw0Keyword_0());
                        

                    }
                    break;

            }

            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getLoop1Access().getNumberSignDigitEightKeyword_1());
                
            // InternalSimpleReconstrTestLanguage.g:1158:1: ( (lv_id_2_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1159:1: (lv_id_2_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1159:1: (lv_id_2_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1160:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            			newLeafNode(lv_id_2_0, grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoop1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:1176:2: (otherlv_3= 'kw1' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1176:4: otherlv_3= 'kw1'
                    {
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_3, grammarAccess.getLoop1Access().getKw1Keyword_3());
                        

                    }
                    break;

            }

            // InternalSimpleReconstrTestLanguage.g:1180:3: ( (lv_id_4_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1181:1: (lv_id_4_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1181:1: (lv_id_4_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1182:3: lv_id_4_0= RULE_ID
            {
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

            			newLeafNode(lv_id_4_0, grammarAccess.getLoop1Access().getIdIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoop1Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_4_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:1198:2: ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==38) ) {
                    int LA18_2 = input.LA(2);

                    if ( ((LA18_2>=38 && LA18_2<=39)) ) {
                        alt18=1;
                    }


                }
                else if ( (LA18_0==39) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:1198:3: (otherlv_5= 'kw2' )* otherlv_6= 'kw30'
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1198:3: (otherlv_5= 'kw2' )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==38) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // InternalSimpleReconstrTestLanguage.g:1198:5: otherlv_5= 'kw2'
            	    	    {
            	    	    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_23); 

            	    	        	newLeafNode(otherlv_5, grammarAccess.getLoop1Access().getKw2Keyword_5_0());
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);

            	    otherlv_6=(Token)match(input,39,FollowSets000.FOLLOW_24); 

            	        	newLeafNode(otherlv_6, grammarAccess.getLoop1Access().getKw30Keyword_5_1());
            	        

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
    // $ANTLR end "ruleLoop1"


    // $ANTLR start "entryRuleLoop2"
    // InternalSimpleReconstrTestLanguage.g:1214:1: entryRuleLoop2 returns [EObject current=null] : iv_ruleLoop2= ruleLoop2 EOF ;
    public final EObject entryRuleLoop2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop2 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1215:2: (iv_ruleLoop2= ruleLoop2 EOF )
            // InternalSimpleReconstrTestLanguage.g:1216:2: iv_ruleLoop2= ruleLoop2 EOF
            {
             newCompositeNode(grammarAccess.getLoop2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop2=ruleLoop2();

            state._fsp--;

             current =iv_ruleLoop2; 
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
    // $ANTLR end "entryRuleLoop2"


    // $ANTLR start "ruleLoop2"
    // InternalSimpleReconstrTestLanguage.g:1223:1: ruleLoop2 returns [EObject current=null] : (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) ;
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

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1226:28: ( (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) )
            // InternalSimpleReconstrTestLanguage.g:1227:1: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1227:1: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            // InternalSimpleReconstrTestLanguage.g:1227:3: otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getLoop2Access().getNumberSignDigitNineKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1231:1: ( (lv_id_1_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1232:1: (lv_id_1_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1232:1: (lv_id_1_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1233:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            			newLeafNode(lv_id_1_0, grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoop2Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:1249:2: (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
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
                    // InternalSimpleReconstrTestLanguage.g:1249:4: otherlv_2= 'kw1'
                    {
                    otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_25); 

                        	newLeafNode(otherlv_2, grammarAccess.getLoop2Access().getKw1Keyword_2_0());
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1254:6: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1254:6: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    // InternalSimpleReconstrTestLanguage.g:1254:7: ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2'
                    {
                    // InternalSimpleReconstrTestLanguage.g:1254:7: ( (lv_id_3_0= RULE_ID ) )
                    // InternalSimpleReconstrTestLanguage.g:1255:1: (lv_id_3_0= RULE_ID )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1255:1: (lv_id_3_0= RULE_ID )
                    // InternalSimpleReconstrTestLanguage.g:1256:3: lv_id_3_0= RULE_ID
                    {
                    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

                    			newLeafNode(lv_id_3_0, grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_2_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLoop2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"id",
                            		lv_id_3_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_4=(Token)match(input,38,FollowSets000.FOLLOW_25); 

                        	newLeafNode(otherlv_4, grammarAccess.getLoop2Access().getKw2Keyword_2_1_1());
                        

                    }


                    }
                    break;

            }

            // InternalSimpleReconstrTestLanguage.g:1276:3: (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )?
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==41) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
                alt20=2;
            }
            switch (alt20) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1276:5: otherlv_5= 'kw3'
                    {
                    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_27); 

                        	newLeafNode(otherlv_5, grammarAccess.getLoop2Access().getKw3Keyword_3_0());
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1281:6: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1281:6: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    // InternalSimpleReconstrTestLanguage.g:1281:7: ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4'
                    {
                    // InternalSimpleReconstrTestLanguage.g:1281:7: ( (lv_id_6_0= RULE_ID ) )
                    // InternalSimpleReconstrTestLanguage.g:1282:1: (lv_id_6_0= RULE_ID )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1282:1: (lv_id_6_0= RULE_ID )
                    // InternalSimpleReconstrTestLanguage.g:1283:3: lv_id_6_0= RULE_ID
                    {
                    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

                    			newLeafNode(lv_id_6_0, grammarAccess.getLoop2Access().getIdIDTerminalRuleCall_3_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLoop2Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"id",
                            		lv_id_6_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_27); 

                        	newLeafNode(otherlv_7, grammarAccess.getLoop2Access().getKw4Keyword_3_1_1());
                        

                    }


                    }
                    break;

            }

            // InternalSimpleReconstrTestLanguage.g:1303:4: (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==43) ) {
                alt21=1;
            }
            else if ( (LA21_0==44) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1303:6: otherlv_8= 'kw5'
                    {
                    otherlv_8=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getLoop2Access().getKw5Keyword_4_0());
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1308:7: otherlv_9= 'kw6'
                    {
                    otherlv_9=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                        	newLeafNode(otherlv_9, grammarAccess.getLoop2Access().getKw6Keyword_4_1());
                        

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
    // $ANTLR end "ruleLoop2"


    // $ANTLR start "entryRuleLoop3"
    // InternalSimpleReconstrTestLanguage.g:1320:1: entryRuleLoop3 returns [EObject current=null] : iv_ruleLoop3= ruleLoop3 EOF ;
    public final EObject entryRuleLoop3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop3 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1321:2: (iv_ruleLoop3= ruleLoop3 EOF )
            // InternalSimpleReconstrTestLanguage.g:1322:2: iv_ruleLoop3= ruleLoop3 EOF
            {
             newCompositeNode(grammarAccess.getLoop3Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop3=ruleLoop3();

            state._fsp--;

             current =iv_ruleLoop3; 
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
    // $ANTLR end "entryRuleLoop3"


    // $ANTLR start "ruleLoop3"
    // InternalSimpleReconstrTestLanguage.g:1329:1: ruleLoop3 returns [EObject current=null] : ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) ;
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

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1332:28: ( ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) )
            // InternalSimpleReconstrTestLanguage.g:1333:1: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            {
            // InternalSimpleReconstrTestLanguage.g:1333:1: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            // InternalSimpleReconstrTestLanguage.g:1333:2: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            {
            // InternalSimpleReconstrTestLanguage.g:1333:2: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt22=1;
                }
                break;
            case 38:
                {
                alt22=2;
                }
                break;
            case 41:
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
                    // InternalSimpleReconstrTestLanguage.g:1333:4: otherlv_0= 'kw1'
                    {
                    otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_29); 

                        	newLeafNode(otherlv_0, grammarAccess.getLoop3Access().getKw1Keyword_0_0());
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1338:7: otherlv_1= 'kw2'
                    {
                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_29); 

                        	newLeafNode(otherlv_1, grammarAccess.getLoop3Access().getKw2Keyword_0_1());
                        

                    }
                    break;
                case 3 :
                    // InternalSimpleReconstrTestLanguage.g:1343:7: otherlv_2= 'kw3'
                    {
                    otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_29); 

                        	newLeafNode(otherlv_2, grammarAccess.getLoop3Access().getKw3Keyword_0_2());
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,45,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_3, grammarAccess.getLoop3Access().getNumberSignDigitOneDigitZeroKeyword_1());
                
            // InternalSimpleReconstrTestLanguage.g:1351:1: ( (lv_id_4_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1352:1: (lv_id_4_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1352:1: (lv_id_4_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1353:3: lv_id_4_0= RULE_ID
            {
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

            			newLeafNode(lv_id_4_0, grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoop3Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_4_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:1369:2: (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==42) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:1369:4: otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5'
            	    {
            	    otherlv_5=(Token)match(input,42,FollowSets000.FOLLOW_10); 

            	        	newLeafNode(otherlv_5, grammarAccess.getLoop3Access().getKw4Keyword_3_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:1373:1: ( (lv_id_6_0= RULE_ID ) )
            	    // InternalSimpleReconstrTestLanguage.g:1374:1: (lv_id_6_0= RULE_ID )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1374:1: (lv_id_6_0= RULE_ID )
            	    // InternalSimpleReconstrTestLanguage.g:1375:3: lv_id_6_0= RULE_ID
            	    {
            	    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            	    			newLeafNode(lv_id_6_0, grammarAccess.getLoop3Access().getIdIDTerminalRuleCall_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getLoop3Rule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"id",
            	            		lv_id_6_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }

            	    otherlv_7=(Token)match(input,43,FollowSets000.FOLLOW_30); 

            	        	newLeafNode(otherlv_7, grammarAccess.getLoop3Access().getKw5Keyword_3_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "ruleLoop3"


    // $ANTLR start "entryRuleLoop4"
    // InternalSimpleReconstrTestLanguage.g:1403:1: entryRuleLoop4 returns [EObject current=null] : iv_ruleLoop4= ruleLoop4 EOF ;
    public final EObject entryRuleLoop4() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoop4 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1404:2: (iv_ruleLoop4= ruleLoop4 EOF )
            // InternalSimpleReconstrTestLanguage.g:1405:2: iv_ruleLoop4= ruleLoop4 EOF
            {
             newCompositeNode(grammarAccess.getLoop4Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop4=ruleLoop4();

            state._fsp--;

             current =iv_ruleLoop4; 
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
    // $ANTLR end "entryRuleLoop4"


    // $ANTLR start "ruleLoop4"
    // InternalSimpleReconstrTestLanguage.g:1412:1: ruleLoop4 returns [EObject current=null] : (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) ;
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

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1415:28: ( (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) )
            // InternalSimpleReconstrTestLanguage.g:1416:1: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            {
            // InternalSimpleReconstrTestLanguage.g:1416:1: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            // InternalSimpleReconstrTestLanguage.g:1416:3: otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_32); 

                	newLeafNode(otherlv_0, grammarAccess.getLoop4Access().getNumberSignDigitOneDigitOneKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1420:1: (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt24=1;
                }
                break;
            case 38:
                {
                alt24=2;
                }
                break;
            case 41:
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
                    // InternalSimpleReconstrTestLanguage.g:1420:3: otherlv_1= 'kw1'
                    {
                    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_1, grammarAccess.getLoop4Access().getKw1Keyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1425:7: otherlv_2= 'kw2'
                    {
                    otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_2, grammarAccess.getLoop4Access().getKw2Keyword_1_1());
                        

                    }
                    break;
                case 3 :
                    // InternalSimpleReconstrTestLanguage.g:1430:6: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1430:6: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    // InternalSimpleReconstrTestLanguage.g:1430:8: otherlv_3= 'kw3' otherlv_4= 'kw4'
                    {
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_28); 

                        	newLeafNode(otherlv_3, grammarAccess.getLoop4Access().getKw3Keyword_1_2_0());
                        
                    otherlv_4=(Token)match(input,42,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_4, grammarAccess.getLoop4Access().getKw4Keyword_1_2_1());
                        

                    }


                    }
                    break;

            }

            // InternalSimpleReconstrTestLanguage.g:1438:3: ( (lv_id_5_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1439:1: (lv_id_5_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1439:1: (lv_id_5_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1440:3: lv_id_5_0= RULE_ID
            {
            lv_id_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            			newLeafNode(lv_id_5_0, grammarAccess.getLoop4Access().getIdIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoop4Rule());
            	        }
                   		addWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_5_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:1456:2: (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==43) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:1456:4: otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    {
            	    otherlv_6=(Token)match(input,43,FollowSets000.FOLLOW_33); 

            	        	newLeafNode(otherlv_6, grammarAccess.getLoop4Access().getKw5Keyword_3_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:1460:1: (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==44) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // InternalSimpleReconstrTestLanguage.g:1460:3: otherlv_7= 'kw6' (otherlv_8= 'kw7' )?
            	            {
            	            otherlv_7=(Token)match(input,44,FollowSets000.FOLLOW_34); 

            	                	newLeafNode(otherlv_7, grammarAccess.getLoop4Access().getKw6Keyword_3_1_0());
            	                
            	            // InternalSimpleReconstrTestLanguage.g:1464:1: (otherlv_8= 'kw7' )?
            	            int alt25=2;
            	            int LA25_0 = input.LA(1);

            	            if ( (LA25_0==47) ) {
            	                alt25=1;
            	            }
            	            switch (alt25) {
            	                case 1 :
            	                    // InternalSimpleReconstrTestLanguage.g:1464:3: otherlv_8= 'kw7'
            	                    {
            	                    otherlv_8=(Token)match(input,47,FollowSets000.FOLLOW_35); 

            	                        	newLeafNode(otherlv_8, grammarAccess.getLoop4Access().getKw7Keyword_3_1_1());
            	                        

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
    // $ANTLR end "ruleLoop4"


    // $ANTLR start "entryRuleLoopBug285452"
    // InternalSimpleReconstrTestLanguage.g:1476:1: entryRuleLoopBug285452 returns [EObject current=null] : iv_ruleLoopBug285452= ruleLoopBug285452 EOF ;
    public final EObject entryRuleLoopBug285452() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopBug285452 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1477:2: (iv_ruleLoopBug285452= ruleLoopBug285452 EOF )
            // InternalSimpleReconstrTestLanguage.g:1478:2: iv_ruleLoopBug285452= ruleLoopBug285452 EOF
            {
             newCompositeNode(grammarAccess.getLoopBug285452Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoopBug285452=ruleLoopBug285452();

            state._fsp--;

             current =iv_ruleLoopBug285452; 
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
    // $ANTLR end "entryRuleLoopBug285452"


    // $ANTLR start "ruleLoopBug285452"
    // InternalSimpleReconstrTestLanguage.g:1485:1: ruleLoopBug285452 returns [EObject current=null] : (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleLoopBug285452() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_interface_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1488:28: ( (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1489:1: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1489:1: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:1489:3: otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_36); 

                	newLeafNode(otherlv_0, grammarAccess.getLoopBug285452Access().getNumberSignDigitOneDigitTwoKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1493:1: ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==49) ) {
                alt28=1;
            }
            else if ( (LA28_0==50) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1493:2: ( (lv_interface_1_0= 'interface' ) )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1493:2: ( (lv_interface_1_0= 'interface' ) )
                    // InternalSimpleReconstrTestLanguage.g:1494:1: (lv_interface_1_0= 'interface' )
                    {
                    // InternalSimpleReconstrTestLanguage.g:1494:1: (lv_interface_1_0= 'interface' )
                    // InternalSimpleReconstrTestLanguage.g:1495:3: lv_interface_1_0= 'interface'
                    {
                    lv_interface_1_0=(Token)match(input,49,FollowSets000.FOLLOW_10); 

                            newLeafNode(lv_interface_1_0, grammarAccess.getLoopBug285452Access().getInterfaceInterfaceKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getLoopBug285452Rule());
                    	        }
                           		setWithLastConsumed(current, "interface", true, "interface");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1509:7: otherlv_2= 'class'
                    {
                    otherlv_2=(Token)match(input,50,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_2, grammarAccess.getLoopBug285452Access().getClassKeyword_1_1());
                        

                    }
                    break;

            }

            // InternalSimpleReconstrTestLanguage.g:1513:2: ( (lv_name_3_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1514:1: (lv_name_3_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1514:1: (lv_name_3_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1515:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_3_0, grammarAccess.getLoopBug285452Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLoopBug285452Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleLoopBug285452"


    // $ANTLR start "entryRuleDuplicateBug284491"
    // InternalSimpleReconstrTestLanguage.g:1539:1: entryRuleDuplicateBug284491 returns [EObject current=null] : iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF ;
    public final EObject entryRuleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDuplicateBug284491 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1540:2: (iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF )
            // InternalSimpleReconstrTestLanguage.g:1541:2: iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF
            {
             newCompositeNode(grammarAccess.getDuplicateBug284491Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDuplicateBug284491=ruleDuplicateBug284491();

            state._fsp--;

             current =iv_ruleDuplicateBug284491; 
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
    // $ANTLR end "entryRuleDuplicateBug284491"


    // $ANTLR start "ruleDuplicateBug284491"
    // InternalSimpleReconstrTestLanguage.g:1548:1: ruleDuplicateBug284491 returns [EObject current=null] : (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) ;
    public final EObject ruleDuplicateBug284491() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_final_2_0=null;
        Token lv_transient_3_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1551:28: ( (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:1552:1: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:1552:1: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:1552:3: otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_37); 

                	newLeafNode(otherlv_0, grammarAccess.getDuplicateBug284491Access().getNumberSignDigitOneDigitThreeKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1556:1: ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
            loop29:
            do {
                int alt29=4;
                switch ( input.LA(1) ) {
                case 52:
                    {
                    alt29=1;
                    }
                    break;
                case 53:
                    {
                    alt29=2;
                    }
                    break;
                case 54:
                    {
                    alt29=3;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:1556:2: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1556:2: ( (lv_static_1_0= 'static' ) )
            	    // InternalSimpleReconstrTestLanguage.g:1557:1: (lv_static_1_0= 'static' )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1557:1: (lv_static_1_0= 'static' )
            	    // InternalSimpleReconstrTestLanguage.g:1558:3: lv_static_1_0= 'static'
            	    {
            	    lv_static_1_0=(Token)match(input,52,FollowSets000.FOLLOW_37); 

            	            newLeafNode(lv_static_1_0, grammarAccess.getDuplicateBug284491Access().getStaticStaticKeyword_1_0_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDuplicateBug284491Rule());
            	    	        }
            	           		setWithLastConsumed(current, "static", true, "static");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleReconstrTestLanguage.g:1572:6: ( (lv_final_2_0= 'final' ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1572:6: ( (lv_final_2_0= 'final' ) )
            	    // InternalSimpleReconstrTestLanguage.g:1573:1: (lv_final_2_0= 'final' )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1573:1: (lv_final_2_0= 'final' )
            	    // InternalSimpleReconstrTestLanguage.g:1574:3: lv_final_2_0= 'final'
            	    {
            	    lv_final_2_0=(Token)match(input,53,FollowSets000.FOLLOW_37); 

            	            newLeafNode(lv_final_2_0, grammarAccess.getDuplicateBug284491Access().getFinalFinalKeyword_1_1_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDuplicateBug284491Rule());
            	    	        }
            	           		setWithLastConsumed(current, "final", true, "final");
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSimpleReconstrTestLanguage.g:1588:6: ( (lv_transient_3_0= 'transient' ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1588:6: ( (lv_transient_3_0= 'transient' ) )
            	    // InternalSimpleReconstrTestLanguage.g:1589:1: (lv_transient_3_0= 'transient' )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1589:1: (lv_transient_3_0= 'transient' )
            	    // InternalSimpleReconstrTestLanguage.g:1590:3: lv_transient_3_0= 'transient'
            	    {
            	    lv_transient_3_0=(Token)match(input,54,FollowSets000.FOLLOW_37); 

            	            newLeafNode(lv_transient_3_0, grammarAccess.getDuplicateBug284491Access().getTransientTransientKeyword_1_2_0());
            	        

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getDuplicateBug284491Rule());
            	    	        }
            	           		setWithLastConsumed(current, "transient", true, "transient");
            	    	    

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
    // $ANTLR end "ruleDuplicateBug284491"


    // $ANTLR start "entryRuleEmptyObjectBug284850"
    // InternalSimpleReconstrTestLanguage.g:1611:1: entryRuleEmptyObjectBug284850 returns [EObject current=null] : iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF ;
    public final EObject entryRuleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectBug284850 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1612:2: (iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF )
            // InternalSimpleReconstrTestLanguage.g:1613:2: iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF
            {
             newCompositeNode(grammarAccess.getEmptyObjectBug284850Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEmptyObjectBug284850=ruleEmptyObjectBug284850();

            state._fsp--;

             current =iv_ruleEmptyObjectBug284850; 
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
    // $ANTLR end "entryRuleEmptyObjectBug284850"


    // $ANTLR start "ruleEmptyObjectBug284850"
    // InternalSimpleReconstrTestLanguage.g:1620:1: ruleEmptyObjectBug284850 returns [EObject current=null] : (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) ;
    public final EObject ruleEmptyObjectBug284850() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_items_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1623:28: ( (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1624:1: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1624:1: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            // InternalSimpleReconstrTestLanguage.g:1624:3: otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) )
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_38); 

                	newLeafNode(otherlv_0, grammarAccess.getEmptyObjectBug284850Access().getNumberSignDigitOneDigitFourKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1628:1: ( (lv_items_1_0= ruleEmptyObjectItems ) )
            // InternalSimpleReconstrTestLanguage.g:1629:1: (lv_items_1_0= ruleEmptyObjectItems )
            {
            // InternalSimpleReconstrTestLanguage.g:1629:1: (lv_items_1_0= ruleEmptyObjectItems )
            // InternalSimpleReconstrTestLanguage.g:1630:3: lv_items_1_0= ruleEmptyObjectItems
            {
             
            	        newCompositeNode(grammarAccess.getEmptyObjectBug284850Access().getItemsEmptyObjectItemsParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_items_1_0=ruleEmptyObjectItems();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEmptyObjectBug284850Rule());
            	        }
                   		set(
                   			current, 
                   			"items",
                    		lv_items_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.EmptyObjectItems");
            	        afterParserOrEnumRuleCall();
            	    

            }


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
    // $ANTLR end "ruleEmptyObjectBug284850"


    // $ANTLR start "entryRuleEmptyObjectItems"
    // InternalSimpleReconstrTestLanguage.g:1654:1: entryRuleEmptyObjectItems returns [EObject current=null] : iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF ;
    public final EObject entryRuleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItems = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1655:2: (iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF )
            // InternalSimpleReconstrTestLanguage.g:1656:2: iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF
            {
             newCompositeNode(grammarAccess.getEmptyObjectItemsRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEmptyObjectItems=ruleEmptyObjectItems();

            state._fsp--;

             current =iv_ruleEmptyObjectItems; 
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
    // $ANTLR end "entryRuleEmptyObjectItems"


    // $ANTLR start "ruleEmptyObjectItems"
    // InternalSimpleReconstrTestLanguage.g:1663:1: ruleEmptyObjectItems returns [EObject current=null] : ( (lv_list_0_0= ruleEmptyObjectItem ) )* ;
    public final EObject ruleEmptyObjectItems() throws RecognitionException {
        EObject current = null;

        EObject lv_list_0_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1666:28: ( ( (lv_list_0_0= ruleEmptyObjectItem ) )* )
            // InternalSimpleReconstrTestLanguage.g:1667:1: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            {
            // InternalSimpleReconstrTestLanguage.g:1667:1: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==56) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:1668:1: (lv_list_0_0= ruleEmptyObjectItem )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:1668:1: (lv_list_0_0= ruleEmptyObjectItem )
            	    // InternalSimpleReconstrTestLanguage.g:1669:3: lv_list_0_0= ruleEmptyObjectItem
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEmptyObjectItemsAccess().getListEmptyObjectItemParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_39);
            	    lv_list_0_0=ruleEmptyObjectItem();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEmptyObjectItemsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"list",
            	            		lv_list_0_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.EmptyObjectItem");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end "ruleEmptyObjectItems"


    // $ANTLR start "entryRuleEmptyObjectItem"
    // InternalSimpleReconstrTestLanguage.g:1693:1: entryRuleEmptyObjectItem returns [EObject current=null] : iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF ;
    public final EObject entryRuleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyObjectItem = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1694:2: (iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF )
            // InternalSimpleReconstrTestLanguage.g:1695:2: iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF
            {
             newCompositeNode(grammarAccess.getEmptyObjectItemRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEmptyObjectItem=ruleEmptyObjectItem();

            state._fsp--;

             current =iv_ruleEmptyObjectItem; 
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
    // $ANTLR end "entryRuleEmptyObjectItem"


    // $ANTLR start "ruleEmptyObjectItem"
    // InternalSimpleReconstrTestLanguage.g:1702:1: ruleEmptyObjectItem returns [EObject current=null] : (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEmptyObjectItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1705:28: ( (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1706:1: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1706:1: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:1706:3: otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getEmptyObjectItemAccess().getItemKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1710:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1711:1: (lv_name_1_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1711:1: (lv_name_1_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1712:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEmptyObjectItemAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEmptyObjectItemRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleEmptyObjectItem"


    // $ANTLR start "entryRuleMultiInheritanceBug280439"
    // InternalSimpleReconstrTestLanguage.g:1736:1: entryRuleMultiInheritanceBug280439 returns [EObject current=null] : iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF ;
    public final EObject entryRuleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiInheritanceBug280439 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1737:2: (iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF )
            // InternalSimpleReconstrTestLanguage.g:1738:2: iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF
            {
             newCompositeNode(grammarAccess.getMultiInheritanceBug280439Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiInheritanceBug280439=ruleMultiInheritanceBug280439();

            state._fsp--;

             current =iv_ruleMultiInheritanceBug280439; 
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
    // $ANTLR end "entryRuleMultiInheritanceBug280439"


    // $ANTLR start "ruleMultiInheritanceBug280439"
    // InternalSimpleReconstrTestLanguage.g:1745:1: ruleMultiInheritanceBug280439 returns [EObject current=null] : (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) ;
    public final EObject ruleMultiInheritanceBug280439() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_val_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1748:28: ( (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1749:1: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1749:1: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            // InternalSimpleReconstrTestLanguage.g:1749:3: otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) )
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiInheritanceBug280439Access().getNumberSignDigitOneDigitFiveKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1753:1: ( (lv_val_1_0= ruleConcreteMulti ) )
            // InternalSimpleReconstrTestLanguage.g:1754:1: (lv_val_1_0= ruleConcreteMulti )
            {
            // InternalSimpleReconstrTestLanguage.g:1754:1: (lv_val_1_0= ruleConcreteMulti )
            // InternalSimpleReconstrTestLanguage.g:1755:3: lv_val_1_0= ruleConcreteMulti
            {
             
            	        newCompositeNode(grammarAccess.getMultiInheritanceBug280439Access().getValConcreteMultiParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_1_0=ruleConcreteMulti();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiInheritanceBug280439Rule());
            	        }
                   		set(
                   			current, 
                   			"val",
                    		lv_val_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.ConcreteMulti");
            	        afterParserOrEnumRuleCall();
            	    

            }


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
    // $ANTLR end "ruleMultiInheritanceBug280439"


    // $ANTLR start "entryRuleConcreteMulti"
    // InternalSimpleReconstrTestLanguage.g:1783:1: entryRuleConcreteMulti returns [EObject current=null] : iv_ruleConcreteMulti= ruleConcreteMulti EOF ;
    public final EObject entryRuleConcreteMulti() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteMulti = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1784:2: (iv_ruleConcreteMulti= ruleConcreteMulti EOF )
            // InternalSimpleReconstrTestLanguage.g:1785:2: iv_ruleConcreteMulti= ruleConcreteMulti EOF
            {
             newCompositeNode(grammarAccess.getConcreteMultiRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConcreteMulti=ruleConcreteMulti();

            state._fsp--;

             current =iv_ruleConcreteMulti; 
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
    // $ANTLR end "entryRuleConcreteMulti"


    // $ANTLR start "ruleConcreteMulti"
    // InternalSimpleReconstrTestLanguage.g:1792:1: ruleConcreteMulti returns [EObject current=null] : ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) ;
    public final EObject ruleConcreteMulti() throws RecognitionException {
        EObject current = null;

        Token lv_m1_0_0=null;
        Token lv_m2_1_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1795:28: ( ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1796:1: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1796:1: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:1796:2: ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1796:2: ( (lv_m1_0_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1797:1: (lv_m1_0_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1797:1: (lv_m1_0_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1798:3: lv_m1_0_0= RULE_ID
            {
            lv_m1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            			newLeafNode(lv_m1_0_0, grammarAccess.getConcreteMultiAccess().getM1IDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConcreteMultiRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"m1",
                    		lv_m1_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalSimpleReconstrTestLanguage.g:1814:2: ( (lv_m2_1_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1815:1: (lv_m2_1_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1815:1: (lv_m2_1_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1816:3: lv_m2_1_0= RULE_ID
            {
            lv_m2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_m2_1_0, grammarAccess.getConcreteMultiAccess().getM2IDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConcreteMultiRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"m2",
                    		lv_m2_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleConcreteMulti"


    // $ANTLR start "entryRuleEObjectRef"
    // InternalSimpleReconstrTestLanguage.g:1840:1: entryRuleEObjectRef returns [EObject current=null] : iv_ruleEObjectRef= ruleEObjectRef EOF ;
    public final EObject entryRuleEObjectRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObjectRef = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1841:2: (iv_ruleEObjectRef= ruleEObjectRef EOF )
            // InternalSimpleReconstrTestLanguage.g:1842:2: iv_ruleEObjectRef= ruleEObjectRef EOF
            {
             newCompositeNode(grammarAccess.getEObjectRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObjectRef=ruleEObjectRef();

            state._fsp--;

             current =iv_ruleEObjectRef; 
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
    // $ANTLR end "entryRuleEObjectRef"


    // $ANTLR start "ruleEObjectRef"
    // InternalSimpleReconstrTestLanguage.g:1849:1: ruleEObjectRef returns [EObject current=null] : (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleEObjectRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_obj_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1852:28: ( (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:1853:1: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1853:1: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:1853:3: otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_0, grammarAccess.getEObjectRefAccess().getNumberSignDigitOneDigitSixKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1857:1: ( (lv_obj_1_0= ruleEObjectElement ) )
            // InternalSimpleReconstrTestLanguage.g:1858:1: (lv_obj_1_0= ruleEObjectElement )
            {
            // InternalSimpleReconstrTestLanguage.g:1858:1: (lv_obj_1_0= ruleEObjectElement )
            // InternalSimpleReconstrTestLanguage.g:1859:3: lv_obj_1_0= ruleEObjectElement
            {
             
            	        newCompositeNode(grammarAccess.getEObjectRefAccess().getObjEObjectElementParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_40);
            lv_obj_1_0=ruleEObjectElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEObjectRefRule());
            	        }
                   		set(
                   			current, 
                   			"obj",
                    		lv_obj_1_0, 
                    		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.EObjectElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,59,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_2, grammarAccess.getEObjectRefAccess().getRefsKeyword_2());
                
            // InternalSimpleReconstrTestLanguage.g:1879:1: ( (otherlv_3= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1880:1: (otherlv_3= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1880:1: (otherlv_3= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1881:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEObjectRefRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getEObjectRefAccess().getRefEObjectCrossReference_3_0()); 
            	

            }


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
    // $ANTLR end "ruleEObjectRef"


    // $ANTLR start "entryRuleEObjectElement"
    // InternalSimpleReconstrTestLanguage.g:1900:1: entryRuleEObjectElement returns [EObject current=null] : iv_ruleEObjectElement= ruleEObjectElement EOF ;
    public final EObject entryRuleEObjectElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEObjectElement = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1901:2: (iv_ruleEObjectElement= ruleEObjectElement EOF )
            // InternalSimpleReconstrTestLanguage.g:1902:2: iv_ruleEObjectElement= ruleEObjectElement EOF
            {
             newCompositeNode(grammarAccess.getEObjectElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObjectElement=ruleEObjectElement();

            state._fsp--;

             current =iv_ruleEObjectElement; 
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
    // $ANTLR end "entryRuleEObjectElement"


    // $ANTLR start "ruleEObjectElement"
    // InternalSimpleReconstrTestLanguage.g:1909:1: ruleEObjectElement returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEObjectElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1912:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:1913:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1913:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:1914:1: (lv_name_0_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:1914:1: (lv_name_0_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:1915:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getEObjectElementAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEObjectElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleEObjectElement"


    // $ANTLR start "entryRuleTypeBug305577_1"
    // InternalSimpleReconstrTestLanguage.g:1939:1: entryRuleTypeBug305577_1 returns [EObject current=null] : iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF ;
    public final EObject entryRuleTypeBug305577_1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug305577_1 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1940:2: (iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF )
            // InternalSimpleReconstrTestLanguage.g:1941:2: iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF
            {
             newCompositeNode(grammarAccess.getTypeBug305577_1Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug305577_1=ruleTypeBug305577_1();

            state._fsp--;

             current =iv_ruleTypeBug305577_1; 
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
    // $ANTLR end "entryRuleTypeBug305577_1"


    // $ANTLR start "ruleTypeBug305577_1"
    // InternalSimpleReconstrTestLanguage.g:1948:1: ruleTypeBug305577_1 returns [EObject current=null] : (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) ) ;
    public final EObject ruleTypeBug305577_1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TypeBug1A_1 = null;

        EObject this_TypeBug1B_2 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1951:28: ( (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) ) )
            // InternalSimpleReconstrTestLanguage.g:1952:1: (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1952:1: (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) )
            // InternalSimpleReconstrTestLanguage.g:1952:3: otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B )
            {
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_41); 

                	newLeafNode(otherlv_0, grammarAccess.getTypeBug305577_1Access().getNumberSignDigitOneDigitSevenKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:1956:1: (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==62) ) {
                alt31=1;
            }
            else if ( (LA31_0==63) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:1957:5: this_TypeBug1A_1= ruleTypeBug1A
                    {
                     
                            newCompositeNode(grammarAccess.getTypeBug305577_1Access().getTypeBug1AParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug1A_1=ruleTypeBug1A();

                    state._fsp--;

                     
                            current = this_TypeBug1A_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:1967:5: this_TypeBug1B_2= ruleTypeBug1B
                    {
                     
                            newCompositeNode(grammarAccess.getTypeBug305577_1Access().getTypeBug1BParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug1B_2=ruleTypeBug1B();

                    state._fsp--;

                     
                            current = this_TypeBug1B_2; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleTypeBug305577_1"


    // $ANTLR start "entryRuleTypeBug305577_2"
    // InternalSimpleReconstrTestLanguage.g:1983:1: entryRuleTypeBug305577_2 returns [EObject current=null] : iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF ;
    public final EObject entryRuleTypeBug305577_2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug305577_2 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:1984:2: (iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF )
            // InternalSimpleReconstrTestLanguage.g:1985:2: iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF
            {
             newCompositeNode(grammarAccess.getTypeBug305577_2Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug305577_2=ruleTypeBug305577_2();

            state._fsp--;

             current =iv_ruleTypeBug305577_2; 
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
    // $ANTLR end "entryRuleTypeBug305577_2"


    // $ANTLR start "ruleTypeBug305577_2"
    // InternalSimpleReconstrTestLanguage.g:1992:1: ruleTypeBug305577_2 returns [EObject current=null] : (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) ) ;
    public final EObject ruleTypeBug305577_2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TypeBug2B_1 = null;

        EObject this_TypeBug2A_2 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:1995:28: ( (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) ) )
            // InternalSimpleReconstrTestLanguage.g:1996:1: (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) )
            {
            // InternalSimpleReconstrTestLanguage.g:1996:1: (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) )
            // InternalSimpleReconstrTestLanguage.g:1996:3: otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A )
            {
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_41); 

                	newLeafNode(otherlv_0, grammarAccess.getTypeBug305577_2Access().getNumberSignDigitOneDigitEightKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:2000:1: (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==63) ) {
                alt32=1;
            }
            else if ( (LA32_0==62) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:2001:5: this_TypeBug2B_1= ruleTypeBug2B
                    {
                     
                            newCompositeNode(grammarAccess.getTypeBug305577_2Access().getTypeBug2BParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug2B_1=ruleTypeBug2B();

                    state._fsp--;

                     
                            current = this_TypeBug2B_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:2011:5: this_TypeBug2A_2= ruleTypeBug2A
                    {
                     
                            newCompositeNode(grammarAccess.getTypeBug305577_2Access().getTypeBug2AParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug2A_2=ruleTypeBug2A();

                    state._fsp--;

                     
                            current = this_TypeBug2A_2; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleTypeBug305577_2"


    // $ANTLR start "entryRuleTypeBug1A"
    // InternalSimpleReconstrTestLanguage.g:2029:1: entryRuleTypeBug1A returns [EObject current=null] : iv_ruleTypeBug1A= ruleTypeBug1A EOF ;
    public final EObject entryRuleTypeBug1A() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug1A = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2030:2: (iv_ruleTypeBug1A= ruleTypeBug1A EOF )
            // InternalSimpleReconstrTestLanguage.g:2031:2: iv_ruleTypeBug1A= ruleTypeBug1A EOF
            {
             newCompositeNode(grammarAccess.getTypeBug1ARule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug1A=ruleTypeBug1A();

            state._fsp--;

             current =iv_ruleTypeBug1A; 
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
    // $ANTLR end "entryRuleTypeBug1A"


    // $ANTLR start "ruleTypeBug1A"
    // InternalSimpleReconstrTestLanguage.g:2038:1: ruleTypeBug1A returns [EObject current=null] : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug1A() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2041:28: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:2042:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2042:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:2042:2: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2042:2: ()
            // InternalSimpleReconstrTestLanguage.g:2043:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTypeBug1AAccess().getTypeBug1AAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeBug1AAccess().getKaKeyword_1());
                
            // InternalSimpleReconstrTestLanguage.g:2052:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:2053:1: (lv_name_2_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:2053:1: (lv_name_2_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:2054:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTypeBug1AAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeBug1ARule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleTypeBug1A"


    // $ANTLR start "entryRuleTypeBug1B"
    // InternalSimpleReconstrTestLanguage.g:2078:1: entryRuleTypeBug1B returns [EObject current=null] : iv_ruleTypeBug1B= ruleTypeBug1B EOF ;
    public final EObject entryRuleTypeBug1B() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug1B = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2079:2: (iv_ruleTypeBug1B= ruleTypeBug1B EOF )
            // InternalSimpleReconstrTestLanguage.g:2080:2: iv_ruleTypeBug1B= ruleTypeBug1B EOF
            {
             newCompositeNode(grammarAccess.getTypeBug1BRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug1B=ruleTypeBug1B();

            state._fsp--;

             current =iv_ruleTypeBug1B; 
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
    // $ANTLR end "entryRuleTypeBug1B"


    // $ANTLR start "ruleTypeBug1B"
    // InternalSimpleReconstrTestLanguage.g:2087:1: ruleTypeBug1B returns [EObject current=null] : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug1B() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2090:28: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:2091:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2091:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:2091:2: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2091:2: ()
            // InternalSimpleReconstrTestLanguage.g:2092:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTypeBug1BAccess().getTypeBug1BAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeBug1BAccess().getKbKeyword_1());
                
            // InternalSimpleReconstrTestLanguage.g:2101:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:2102:1: (lv_name_2_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:2102:1: (lv_name_2_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:2103:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTypeBug1BAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeBug1BRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleTypeBug1B"


    // $ANTLR start "entryRuleTypeBug2A"
    // InternalSimpleReconstrTestLanguage.g:2129:1: entryRuleTypeBug2A returns [EObject current=null] : iv_ruleTypeBug2A= ruleTypeBug2A EOF ;
    public final EObject entryRuleTypeBug2A() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug2A = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2130:2: (iv_ruleTypeBug2A= ruleTypeBug2A EOF )
            // InternalSimpleReconstrTestLanguage.g:2131:2: iv_ruleTypeBug2A= ruleTypeBug2A EOF
            {
             newCompositeNode(grammarAccess.getTypeBug2ARule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug2A=ruleTypeBug2A();

            state._fsp--;

             current =iv_ruleTypeBug2A; 
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
    // $ANTLR end "entryRuleTypeBug2A"


    // $ANTLR start "ruleTypeBug2A"
    // InternalSimpleReconstrTestLanguage.g:2138:1: ruleTypeBug2A returns [EObject current=null] : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug2A() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2141:28: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:2142:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2142:1: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:2142:2: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2142:2: ()
            // InternalSimpleReconstrTestLanguage.g:2143:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTypeBug2AAccess().getTypeBug2AAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeBug2AAccess().getKaKeyword_1());
                
            // InternalSimpleReconstrTestLanguage.g:2152:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:2153:1: (lv_name_2_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:2153:1: (lv_name_2_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:2154:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTypeBug2AAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeBug2ARule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleTypeBug2A"


    // $ANTLR start "entryRuleTypeBug2B"
    // InternalSimpleReconstrTestLanguage.g:2178:1: entryRuleTypeBug2B returns [EObject current=null] : iv_ruleTypeBug2B= ruleTypeBug2B EOF ;
    public final EObject entryRuleTypeBug2B() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBug2B = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2179:2: (iv_ruleTypeBug2B= ruleTypeBug2B EOF )
            // InternalSimpleReconstrTestLanguage.g:2180:2: iv_ruleTypeBug2B= ruleTypeBug2B EOF
            {
             newCompositeNode(grammarAccess.getTypeBug2BRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug2B=ruleTypeBug2B();

            state._fsp--;

             current =iv_ruleTypeBug2B; 
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
    // $ANTLR end "entryRuleTypeBug2B"


    // $ANTLR start "ruleTypeBug2B"
    // InternalSimpleReconstrTestLanguage.g:2187:1: ruleTypeBug2B returns [EObject current=null] : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleTypeBug2B() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2190:28: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:2191:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2191:1: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:2191:2: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2191:2: ()
            // InternalSimpleReconstrTestLanguage.g:2192:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTypeBug2BAccess().getTypeBug2BAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_10); 

                	newLeafNode(otherlv_1, grammarAccess.getTypeBug2BAccess().getKbKeyword_1());
                
            // InternalSimpleReconstrTestLanguage.g:2201:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:2202:1: (lv_name_2_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:2202:1: (lv_name_2_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:2203:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getTypeBug2BAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeBug2BRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleTypeBug2B"


    // $ANTLR start "entryRuleBug305171"
    // InternalSimpleReconstrTestLanguage.g:2227:1: entryRuleBug305171 returns [EObject current=null] : iv_ruleBug305171= ruleBug305171 EOF ;
    public final EObject entryRuleBug305171() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug305171 = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2228:2: (iv_ruleBug305171= ruleBug305171 EOF )
            // InternalSimpleReconstrTestLanguage.g:2229:2: iv_ruleBug305171= ruleBug305171 EOF
            {
             newCompositeNode(grammarAccess.getBug305171Rule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug305171=ruleBug305171();

            state._fsp--;

             current =iv_ruleBug305171; 
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
    // $ANTLR end "entryRuleBug305171"


    // $ANTLR start "ruleBug305171"
    // InternalSimpleReconstrTestLanguage.g:2236:1: ruleBug305171 returns [EObject current=null] : (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) ;
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

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2239:28: ( (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:2240:1: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2240:1: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            // InternalSimpleReconstrTestLanguage.g:2240:3: otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,64,FollowSets000.FOLLOW_42); 

                	newLeafNode(otherlv_0, grammarAccess.getBug305171Access().getNumberSignDigitOneDigitNineKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:2244:1: ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) )
            // InternalSimpleReconstrTestLanguage.g:2244:2: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            {
            // InternalSimpleReconstrTestLanguage.g:2244:2: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==65) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:2244:4: otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    {
                    otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_1, grammarAccess.getBug305171Access().getKxKeyword_1_0_0());
                        
                    // InternalSimpleReconstrTestLanguage.g:2248:1: ( (lv_x_2_0= RULE_ID ) )
                    // InternalSimpleReconstrTestLanguage.g:2249:1: (lv_x_2_0= RULE_ID )
                    {
                    // InternalSimpleReconstrTestLanguage.g:2249:1: (lv_x_2_0= RULE_ID )
                    // InternalSimpleReconstrTestLanguage.g:2250:3: lv_x_2_0= RULE_ID
                    {
                    lv_x_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

                    			newLeafNode(lv_x_2_0, grammarAccess.getBug305171Access().getXIDTerminalRuleCall_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBug305171Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"x",
                            		lv_x_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSimpleReconstrTestLanguage.g:2266:2: (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==30) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalSimpleReconstrTestLanguage.g:2266:4: otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_10); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getBug305171Access().getCommaKeyword_1_0_2_0());
                    	        
                    	    // InternalSimpleReconstrTestLanguage.g:2270:1: ( (lv_x_4_0= RULE_ID ) )
                    	    // InternalSimpleReconstrTestLanguage.g:2271:1: (lv_x_4_0= RULE_ID )
                    	    {
                    	    // InternalSimpleReconstrTestLanguage.g:2271:1: (lv_x_4_0= RULE_ID )
                    	    // InternalSimpleReconstrTestLanguage.g:2272:3: lv_x_4_0= RULE_ID
                    	    {
                    	    lv_x_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

                    	    			newLeafNode(lv_x_4_0, grammarAccess.getBug305171Access().getXIDTerminalRuleCall_1_0_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBug305171Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"x",
                    	            		lv_x_4_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

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

            // InternalSimpleReconstrTestLanguage.g:2288:6: ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            // InternalSimpleReconstrTestLanguage.g:2288:7: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            {
            // InternalSimpleReconstrTestLanguage.g:2288:7: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==66) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:2288:9: otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    {
                    otherlv_5=(Token)match(input,66,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_5, grammarAccess.getBug305171Access().getKyKeyword_1_1_0_0());
                        
                    // InternalSimpleReconstrTestLanguage.g:2292:1: ( (lv_y_6_0= RULE_ID ) )
                    // InternalSimpleReconstrTestLanguage.g:2293:1: (lv_y_6_0= RULE_ID )
                    {
                    // InternalSimpleReconstrTestLanguage.g:2293:1: (lv_y_6_0= RULE_ID )
                    // InternalSimpleReconstrTestLanguage.g:2294:3: lv_y_6_0= RULE_ID
                    {
                    lv_y_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); 

                    			newLeafNode(lv_y_6_0, grammarAccess.getBug305171Access().getYIDTerminalRuleCall_1_1_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBug305171Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"y",
                            		lv_y_6_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSimpleReconstrTestLanguage.g:2310:2: (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==30) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalSimpleReconstrTestLanguage.g:2310:4: otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) )
                    	    {
                    	    otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_10); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getBug305171Access().getCommaKeyword_1_1_0_2_0());
                    	        
                    	    // InternalSimpleReconstrTestLanguage.g:2314:1: ( (lv_y_8_0= RULE_ID ) )
                    	    // InternalSimpleReconstrTestLanguage.g:2315:1: (lv_y_8_0= RULE_ID )
                    	    {
                    	    // InternalSimpleReconstrTestLanguage.g:2315:1: (lv_y_8_0= RULE_ID )
                    	    // InternalSimpleReconstrTestLanguage.g:2316:3: lv_y_8_0= RULE_ID
                    	    {
                    	    lv_y_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); 

                    	    			newLeafNode(lv_y_8_0, grammarAccess.getBug305171Access().getYIDTerminalRuleCall_1_1_0_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBug305171Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"y",
                    	            		lv_y_8_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

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

            // InternalSimpleReconstrTestLanguage.g:2332:6: (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==67) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:2332:8: otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    {
                    otherlv_9=(Token)match(input,67,FollowSets000.FOLLOW_10); 

                        	newLeafNode(otherlv_9, grammarAccess.getBug305171Access().getKzKeyword_1_1_1_0());
                        
                    // InternalSimpleReconstrTestLanguage.g:2336:1: ( (lv_z_10_0= RULE_ID ) )
                    // InternalSimpleReconstrTestLanguage.g:2337:1: (lv_z_10_0= RULE_ID )
                    {
                    // InternalSimpleReconstrTestLanguage.g:2337:1: (lv_z_10_0= RULE_ID )
                    // InternalSimpleReconstrTestLanguage.g:2338:3: lv_z_10_0= RULE_ID
                    {
                    lv_z_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); 

                    			newLeafNode(lv_z_10_0, grammarAccess.getBug305171Access().getZIDTerminalRuleCall_1_1_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBug305171Rule());
                    	        }
                           		addWithLastConsumed(
                           			current, 
                           			"z",
                            		lv_z_10_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // InternalSimpleReconstrTestLanguage.g:2354:2: (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==30) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // InternalSimpleReconstrTestLanguage.g:2354:4: otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_10); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getBug305171Access().getCommaKeyword_1_1_1_2_0());
                    	        
                    	    // InternalSimpleReconstrTestLanguage.g:2358:1: ( (lv_z_12_0= RULE_ID ) )
                    	    // InternalSimpleReconstrTestLanguage.g:2359:1: (lv_z_12_0= RULE_ID )
                    	    {
                    	    // InternalSimpleReconstrTestLanguage.g:2359:1: (lv_z_12_0= RULE_ID )
                    	    // InternalSimpleReconstrTestLanguage.g:2360:3: lv_z_12_0= RULE_ID
                    	    {
                    	    lv_z_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); 

                    	    			newLeafNode(lv_z_12_0, grammarAccess.getBug305171Access().getZIDTerminalRuleCall_1_1_1_2_1_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBug305171Rule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"z",
                    	            		lv_z_12_0, 
                    	            		"org.eclipse.xtext.common.Terminals.ID");
                    	    	    

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

            // InternalSimpleReconstrTestLanguage.g:2376:8: ( (lv_name_13_0= RULE_ID ) )
            // InternalSimpleReconstrTestLanguage.g:2377:1: (lv_name_13_0= RULE_ID )
            {
            // InternalSimpleReconstrTestLanguage.g:2377:1: (lv_name_13_0= RULE_ID )
            // InternalSimpleReconstrTestLanguage.g:2378:3: lv_name_13_0= RULE_ID
            {
            lv_name_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_13_0, grammarAccess.getBug305171Access().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBug305171Rule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_13_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


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
    // $ANTLR end "ruleBug305171"


    // $ANTLR start "entryRuleBug310435Enum"
    // InternalSimpleReconstrTestLanguage.g:2402:1: entryRuleBug310435Enum returns [EObject current=null] : iv_ruleBug310435Enum= ruleBug310435Enum EOF ;
    public final EObject entryRuleBug310435Enum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug310435Enum = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2403:2: (iv_ruleBug310435Enum= ruleBug310435Enum EOF )
            // InternalSimpleReconstrTestLanguage.g:2404:2: iv_ruleBug310435Enum= ruleBug310435Enum EOF
            {
             newCompositeNode(grammarAccess.getBug310435EnumRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug310435Enum=ruleBug310435Enum();

            state._fsp--;

             current =iv_ruleBug310435Enum; 
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
    // $ANTLR end "entryRuleBug310435Enum"


    // $ANTLR start "ruleBug310435Enum"
    // InternalSimpleReconstrTestLanguage.g:2411:1: ruleBug310435Enum returns [EObject current=null] : (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) ;
    public final EObject ruleBug310435Enum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Enumerator lv_lits_2_0 = null;

        Enumerator lv_lits_4_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2414:28: ( (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:2415:1: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:2415:1: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:2415:3: otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
            {
            otherlv_0=(Token)match(input,68,FollowSets000.FOLLOW_46); 

                	newLeafNode(otherlv_0, grammarAccess.getBug310435EnumAccess().getNumberSignDigitTwoDigitZeroKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:2419:1: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
            loop39:
            do {
                int alt39=3;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==37) ) {
                    int LA39_2 = input.LA(2);

                    if ( (LA39_2==71) ) {
                        alt39=1;
                    }


                }
                else if ( (LA39_0==38) ) {
                    int LA39_3 = input.LA(2);

                    if ( (LA39_3==72) ) {
                        alt39=2;
                    }


                }


                switch (alt39) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:2419:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2419:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    // InternalSimpleReconstrTestLanguage.g:2419:4: otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_47); 

            	        	newLeafNode(otherlv_1, grammarAccess.getBug310435EnumAccess().getKw1Keyword_1_0_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:2423:1: ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    // InternalSimpleReconstrTestLanguage.g:2424:1: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2424:1: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    // InternalSimpleReconstrTestLanguage.g:2425:3: lv_lits_2_0= ruleEnumBug310435Lit1
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBug310435EnumAccess().getLitsEnumBug310435Lit1EnumRuleCall_1_0_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_46);
            	    lv_lits_2_0=ruleEnumBug310435Lit1();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBug310435EnumRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lits",
            	            		lv_lits_2_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.EnumBug310435Lit1");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleReconstrTestLanguage.g:2442:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2442:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    // InternalSimpleReconstrTestLanguage.g:2442:8: otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    {
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_48); 

            	        	newLeafNode(otherlv_3, grammarAccess.getBug310435EnumAccess().getKw2Keyword_1_1_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:2446:1: ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    // InternalSimpleReconstrTestLanguage.g:2447:1: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2447:1: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    // InternalSimpleReconstrTestLanguage.g:2448:3: lv_lits_4_0= ruleEnumBug310435Lit2
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBug310435EnumAccess().getLitsEnumBug310435Lit2EnumRuleCall_1_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_46);
            	    lv_lits_4_0=ruleEnumBug310435Lit2();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBug310435EnumRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"lits",
            	            		lv_lits_4_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.EnumBug310435Lit2");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleBug310435Enum"


    // $ANTLR start "entryRuleBug310435Val"
    // InternalSimpleReconstrTestLanguage.g:2472:1: entryRuleBug310435Val returns [EObject current=null] : iv_ruleBug310435Val= ruleBug310435Val EOF ;
    public final EObject entryRuleBug310435Val() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBug310435Val = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2473:2: (iv_ruleBug310435Val= ruleBug310435Val EOF )
            // InternalSimpleReconstrTestLanguage.g:2474:2: iv_ruleBug310435Val= ruleBug310435Val EOF
            {
             newCompositeNode(grammarAccess.getBug310435ValRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug310435Val=ruleBug310435Val();

            state._fsp--;

             current =iv_ruleBug310435Val; 
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
    // $ANTLR end "entryRuleBug310435Val"


    // $ANTLR start "ruleBug310435Val"
    // InternalSimpleReconstrTestLanguage.g:2481:1: ruleBug310435Val returns [EObject current=null] : (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) ;
    public final EObject ruleBug310435Val() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_lits_2_0=null;
        Token otherlv_3=null;
        Token lv_lits_4_0=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2484:28: ( (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:2485:1: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:2485:1: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:2485:3: otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
            {
            otherlv_0=(Token)match(input,69,FollowSets000.FOLLOW_46); 

                	newLeafNode(otherlv_0, grammarAccess.getBug310435ValAccess().getNumberSignDigitTwoDigitOneKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:2489:1: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
            loop40:
            do {
                int alt40=3;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==37) ) {
                    int LA40_2 = input.LA(2);

                    if ( (LA40_2==RULE_ID) ) {
                        alt40=1;
                    }


                }
                else if ( (LA40_0==38) ) {
                    int LA40_3 = input.LA(2);

                    if ( (LA40_3==RULE_STRING) ) {
                        alt40=2;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:2489:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2489:2: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    // InternalSimpleReconstrTestLanguage.g:2489:4: otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_10); 

            	        	newLeafNode(otherlv_1, grammarAccess.getBug310435ValAccess().getKw1Keyword_1_0_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:2493:1: ( (lv_lits_2_0= RULE_ID ) )
            	    // InternalSimpleReconstrTestLanguage.g:2494:1: (lv_lits_2_0= RULE_ID )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2494:1: (lv_lits_2_0= RULE_ID )
            	    // InternalSimpleReconstrTestLanguage.g:2495:3: lv_lits_2_0= RULE_ID
            	    {
            	    lv_lits_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); 

            	    			newLeafNode(lv_lits_2_0, grammarAccess.getBug310435ValAccess().getLitsIDTerminalRuleCall_1_0_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getBug310435ValRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"lits",
            	            		lv_lits_2_0, 
            	            		"org.eclipse.xtext.common.Terminals.ID");
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleReconstrTestLanguage.g:2512:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2512:6: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    // InternalSimpleReconstrTestLanguage.g:2512:8: otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_9); 

            	        	newLeafNode(otherlv_3, grammarAccess.getBug310435ValAccess().getKw2Keyword_1_1_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:2516:1: ( (lv_lits_4_0= RULE_STRING ) )
            	    // InternalSimpleReconstrTestLanguage.g:2517:1: (lv_lits_4_0= RULE_STRING )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2517:1: (lv_lits_4_0= RULE_STRING )
            	    // InternalSimpleReconstrTestLanguage.g:2518:3: lv_lits_4_0= RULE_STRING
            	    {
            	    lv_lits_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_46); 

            	    			newLeafNode(lv_lits_4_0, grammarAccess.getBug310435ValAccess().getLitsSTRINGTerminalRuleCall_1_1_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getBug310435ValRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"lits",
            	            		lv_lits_4_0, 
            	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    

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
    // $ANTLR end "ruleBug310435Val"


    // $ANTLR start "entryRuleCrossRefNameTest"
    // InternalSimpleReconstrTestLanguage.g:2542:1: entryRuleCrossRefNameTest returns [EObject current=null] : iv_ruleCrossRefNameTest= ruleCrossRefNameTest EOF ;
    public final EObject entryRuleCrossRefNameTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossRefNameTest = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2543:2: (iv_ruleCrossRefNameTest= ruleCrossRefNameTest EOF )
            // InternalSimpleReconstrTestLanguage.g:2544:2: iv_ruleCrossRefNameTest= ruleCrossRefNameTest EOF
            {
             newCompositeNode(grammarAccess.getCrossRefNameTestRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossRefNameTest=ruleCrossRefNameTest();

            state._fsp--;

             current =iv_ruleCrossRefNameTest; 
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
    // $ANTLR end "entryRuleCrossRefNameTest"


    // $ANTLR start "ruleCrossRefNameTest"
    // InternalSimpleReconstrTestLanguage.g:2551:1: ruleCrossRefNameTest returns [EObject current=null] : (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* ) ;
    public final EObject ruleCrossRefNameTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_named_1_0 = null;


         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2554:28: ( (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* ) )
            // InternalSimpleReconstrTestLanguage.g:2555:1: (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* )
            {
            // InternalSimpleReconstrTestLanguage.g:2555:1: (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* )
            // InternalSimpleReconstrTestLanguage.g:2555:3: otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )*
            {
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_49); 

                	newLeafNode(otherlv_0, grammarAccess.getCrossRefNameTestAccess().getNumberSignDigitTwoDigitTwoKeyword_0());
                
            // InternalSimpleReconstrTestLanguage.g:2559:1: ( (lv_named_1_0= ruleCrossRefNamed ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_ID1 && LA41_0<=RULE_ID2)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:2560:1: (lv_named_1_0= ruleCrossRefNamed )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2560:1: (lv_named_1_0= ruleCrossRefNamed )
            	    // InternalSimpleReconstrTestLanguage.g:2561:3: lv_named_1_0= ruleCrossRefNamed
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCrossRefNameTestAccess().getNamedCrossRefNamedParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_49);
            	    lv_named_1_0=ruleCrossRefNamed();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCrossRefNameTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"named",
            	            		lv_named_1_0, 
            	            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.CrossRefNamed");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_50); 

                	newLeafNode(otherlv_2, grammarAccess.getCrossRefNameTestAccess().getKw1Keyword_2());
                
            // InternalSimpleReconstrTestLanguage.g:2581:1: ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )*
            loop42:
            do {
                int alt42=3;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==38) ) {
                    int LA42_2 = input.LA(2);

                    if ( (LA42_2==RULE_ID1) ) {
                        alt42=1;
                    }


                }
                else if ( (LA42_0==41) ) {
                    int LA42_3 = input.LA(2);

                    if ( (LA42_3==RULE_ID2) ) {
                        alt42=2;
                    }


                }


                switch (alt42) {
            	case 1 :
            	    // InternalSimpleReconstrTestLanguage.g:2581:2: (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2581:2: (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) )
            	    // InternalSimpleReconstrTestLanguage.g:2581:4: otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) )
            	    {
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_51); 

            	        	newLeafNode(otherlv_3, grammarAccess.getCrossRefNameTestAccess().getKw2Keyword_3_0_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:2585:1: ( (otherlv_4= RULE_ID1 ) )
            	    // InternalSimpleReconstrTestLanguage.g:2586:1: (otherlv_4= RULE_ID1 )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2586:1: (otherlv_4= RULE_ID1 )
            	    // InternalSimpleReconstrTestLanguage.g:2587:3: otherlv_4= RULE_ID1
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCrossRefNameTestRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_50); 

            	    		newLeafNode(otherlv_4, grammarAccess.getCrossRefNameTestAccess().getRefCrossRefNamedCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSimpleReconstrTestLanguage.g:2599:6: (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2599:6: (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) )
            	    // InternalSimpleReconstrTestLanguage.g:2599:8: otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) )
            	    {
            	    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_52); 

            	        	newLeafNode(otherlv_5, grammarAccess.getCrossRefNameTestAccess().getKw3Keyword_3_1_0());
            	        
            	    // InternalSimpleReconstrTestLanguage.g:2603:1: ( (otherlv_6= RULE_ID2 ) )
            	    // InternalSimpleReconstrTestLanguage.g:2604:1: (otherlv_6= RULE_ID2 )
            	    {
            	    // InternalSimpleReconstrTestLanguage.g:2604:1: (otherlv_6= RULE_ID2 )
            	    // InternalSimpleReconstrTestLanguage.g:2605:3: otherlv_6= RULE_ID2
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getCrossRefNameTestRule());
            	    	        }
            	            
            	    otherlv_6=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_50); 

            	    		newLeafNode(otherlv_6, grammarAccess.getCrossRefNameTestAccess().getRefCrossRefNamedCrossReference_3_1_1_0()); 
            	    	

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // $ANTLR end "ruleCrossRefNameTest"


    // $ANTLR start "entryRuleCrossRefNamed"
    // InternalSimpleReconstrTestLanguage.g:2624:1: entryRuleCrossRefNamed returns [EObject current=null] : iv_ruleCrossRefNamed= ruleCrossRefNamed EOF ;
    public final EObject entryRuleCrossRefNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossRefNamed = null;


        try {
            // InternalSimpleReconstrTestLanguage.g:2625:2: (iv_ruleCrossRefNamed= ruleCrossRefNamed EOF )
            // InternalSimpleReconstrTestLanguage.g:2626:2: iv_ruleCrossRefNamed= ruleCrossRefNamed EOF
            {
             newCompositeNode(grammarAccess.getCrossRefNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossRefNamed=ruleCrossRefNamed();

            state._fsp--;

             current =iv_ruleCrossRefNamed; 
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
    // $ANTLR end "entryRuleCrossRefNamed"


    // $ANTLR start "ruleCrossRefNamed"
    // InternalSimpleReconstrTestLanguage.g:2633:1: ruleCrossRefNamed returns [EObject current=null] : ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) ) ;
    public final EObject ruleCrossRefNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // InternalSimpleReconstrTestLanguage.g:2636:28: ( ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) ) )
            // InternalSimpleReconstrTestLanguage.g:2637:1: ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2637:1: ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) )
            // InternalSimpleReconstrTestLanguage.g:2638:1: ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) )
            {
            // InternalSimpleReconstrTestLanguage.g:2638:1: ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) )
            // InternalSimpleReconstrTestLanguage.g:2639:1: (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 )
            {
            // InternalSimpleReconstrTestLanguage.g:2639:1: (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID1) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID2) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalSimpleReconstrTestLanguage.g:2640:3: lv_name_0_1= RULE_ID1
                    {
                    lv_name_0_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_name_0_1, grammarAccess.getCrossRefNamedAccess().getNameID1TerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCrossRefNamedRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_1, 
                            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.ID1");
                    	    

                    }
                    break;
                case 2 :
                    // InternalSimpleReconstrTestLanguage.g:2655:8: lv_name_0_2= RULE_ID2
                    {
                    lv_name_0_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_name_0_2, grammarAccess.getCrossRefNamedAccess().getNameID2TerminalRuleCall_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCrossRefNamedRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_2, 
                            		"org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage.ID2");
                    	    

                    }
                    break;

            }


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
    // $ANTLR end "ruleCrossRefNamed"


    // $ANTLR start "ruleEnumBug310435Lit1"
    // InternalSimpleReconstrTestLanguage.g:2681:1: ruleEnumBug310435Lit1 returns [Enumerator current=null] : (enumLiteral_0= 'lit1' ) ;
    public final Enumerator ruleEnumBug310435Lit1() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // InternalSimpleReconstrTestLanguage.g:2683:28: ( (enumLiteral_0= 'lit1' ) )
            // InternalSimpleReconstrTestLanguage.g:2684:1: (enumLiteral_0= 'lit1' )
            {
            // InternalSimpleReconstrTestLanguage.g:2684:1: (enumLiteral_0= 'lit1' )
            // InternalSimpleReconstrTestLanguage.g:2684:3: enumLiteral_0= 'lit1'
            {
            enumLiteral_0=(Token)match(input,71,FollowSets000.FOLLOW_2); 

                    current = grammarAccess.getEnumBug310435Lit1Access().getLit1EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getEnumBug310435Lit1Access().getLit1EnumLiteralDeclaration()); 
                

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
    // $ANTLR end "ruleEnumBug310435Lit1"


    // $ANTLR start "ruleEnumBug310435Lit2"
    // InternalSimpleReconstrTestLanguage.g:2694:1: ruleEnumBug310435Lit2 returns [Enumerator current=null] : (enumLiteral_0= 'lit2' ) ;
    public final Enumerator ruleEnumBug310435Lit2() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;

         enterRule(); 
        try {
            // InternalSimpleReconstrTestLanguage.g:2696:28: ( (enumLiteral_0= 'lit2' ) )
            // InternalSimpleReconstrTestLanguage.g:2697:1: (enumLiteral_0= 'lit2' )
            {
            // InternalSimpleReconstrTestLanguage.g:2697:1: (enumLiteral_0= 'lit2' )
            // InternalSimpleReconstrTestLanguage.g:2697:3: enumLiteral_0= 'lit2'
            {
            enumLiteral_0=(Token)match(input,72,FollowSets000.FOLLOW_2); 

                    current = grammarAccess.getEnumBug310435Lit2Access().getLit2EnumLiteralDeclaration().getEnumLiteral().getInstance();
                    newLeafNode(enumLiteral_0, grammarAccess.getEnumBug310435Lit2Access().getLit2EnumLiteralDeclaration()); 
                

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
    // $ANTLR end "ruleEnumBug310435Lit2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x3689437C92962032L,0x0000000000000071L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x3689437C92962030L,0x0000000000000071L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000600040L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000020L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000300000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000002000000010L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000C000000000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000000C000000002L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00001A0000000010L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000180000000000L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000040000000002L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000026000000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000180000000002L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000880000000002L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0006000000000000L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0xC000000000000000L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000010L,0x000000000000000EL});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000040000010L,0x000000000000000CL});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000040000010L,0x0000000000000008L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000040000010L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000002000000180L});
        public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000024000000002L});
        public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000100L});
    }


}
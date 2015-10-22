package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalSimpleReconstrTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ID1", "RULE_ID2", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'", "'#3'", "'.'", "'#4'", "'myoption'", "'kw'", "'#5'", "'*'", "','", "'#6'", "'v1'", "'v2'", "'#7'", "'kw0'", "'#8'", "'kw1'", "'kw2'", "'kw30'", "'#9'", "'kw3'", "'kw4'", "'kw5'", "'kw6'", "'#10'", "'#11'", "'kw7'", "'#12'", "'interface'", "'class'", "'#13'", "'static'", "'final'", "'transient'", "'#14'", "'item'", "'#15'", "'#16'", "'refs'", "'#17'", "'#18'", "'ka'", "'kb'", "'#19'", "'kx'", "'ky'", "'kz'", "'#20'", "'#21'", "'#22'", "'lit1'", "'lit2'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_INT=5;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=10;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=6;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_ID1=7;
    public static final int RULE_ID2=8;
    public static final int RULE_WS=11;

    // delegates
    // delegators


        public PsiInternalSimpleReconstrTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalSimpleReconstrTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalSimpleReconstrTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalSimpleReconstrTestLanguage.g"; }



    	protected SimpleReconstrTestLanguageGrammarAccess grammarAccess;

    	protected SimpleReconstrTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalSimpleReconstrTestLanguageParser(PsiBuilder builder, TokenStream input, SimpleReconstrTestLanguageElementTypeProvider elementTypeProvider, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Op";
    	}




    // $ANTLR start "entryRuleOp"
    // PsiInternalSimpleReconstrTestLanguage.g:52:1: entryRuleOp returns [Boolean current=false] : iv_ruleOp= ruleOp EOF ;
    public final Boolean entryRuleOp() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleOp = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:52:44: (iv_ruleOp= ruleOp EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:53:2: iv_ruleOp= ruleOp EOF
            {
             markComposite(elementTypeProvider.getOpElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOp=ruleOp();

            state._fsp--;

             current =iv_ruleOp; 
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
    // $ANTLR end "entryRuleOp"


    // $ANTLR start "ruleOp"
    // PsiInternalSimpleReconstrTestLanguage.g:59:1: ruleOp returns [Boolean current=false] : (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) ;
    public final Boolean ruleOp() throws RecognitionException {
        Boolean current = false;

        Boolean this_Term_0 = null;

        Boolean lv_values_2_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:60:1: ( (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:61:2: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:61:2: (this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:62:3: this_Term_0= ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )*
            {

            			markComposite(elementTypeProvider.getOp_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_3);
            this_Term_0=ruleTerm();

            state._fsp--;


            			current = this_Term_0;
            			doneComposite();
            		
            // PsiInternalSimpleReconstrTestLanguage.g:70:3: ( () ( (lv_values_2_0= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==13||(LA1_0>=17 && LA1_0<=18)||LA1_0==20||LA1_0==23||LA1_0==25||LA1_0==28||LA1_0==31||(LA1_0>=34 && LA1_0<=38)||(LA1_0>=40 && LA1_0<=41)||LA1_0==46||LA1_0==48||LA1_0==51||LA1_0==55||(LA1_0>=57 && LA1_0<=58)||(LA1_0>=60 && LA1_0<=61)||LA1_0==64||(LA1_0>=68 && LA1_0<=70)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:71:4: () ( (lv_values_2_0= ruleTerm ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:71:4: ()
            	    // PsiInternalSimpleReconstrTestLanguage.g:72:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getOp_OpValuesAction_1_0ElementType());
            	    					doneComposite();
            	    					associateWithSemanticElement();
            	    				

            	    }

            	    // PsiInternalSimpleReconstrTestLanguage.g:78:4: ( (lv_values_2_0= ruleTerm ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:79:5: (lv_values_2_0= ruleTerm )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:79:5: (lv_values_2_0= ruleTerm )
            	    // PsiInternalSimpleReconstrTestLanguage.g:80:6: lv_values_2_0= ruleTerm
            	    {

            	    						markComposite(elementTypeProvider.getOp_ValuesTermParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_values_2_0=ruleTerm();

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
            	    break loop1;
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
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // PsiInternalSimpleReconstrTestLanguage.g:98:1: entryRuleTerm returns [Boolean current=false] : iv_ruleTerm= ruleTerm EOF ;
    public final Boolean entryRuleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTerm = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:98:46: (iv_ruleTerm= ruleTerm EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:99:2: iv_ruleTerm= ruleTerm EOF
            {
             markComposite(elementTypeProvider.getTermElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
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
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // PsiInternalSimpleReconstrTestLanguage.g:105:1: ruleTerm returns [Boolean current=false] : (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest ) ;
    public final Boolean ruleTerm() throws RecognitionException {
        Boolean current = false;

        Boolean this_Atom_0 = null;

        Boolean this_TwoNumbers_1 = null;

        Boolean this_ManyStrings_2 = null;

        Boolean this_Type_3 = null;

        Boolean this_Ref2_4 = null;

        Boolean this_Spare_5 = null;

        Boolean this_Boolean_6 = null;

        Boolean this_Transient1_7 = null;

        Boolean this_Consumed1_8 = null;

        Boolean this_Consumed2_9 = null;

        Boolean this_Loop1_10 = null;

        Boolean this_Loop2_11 = null;

        Boolean this_Loop3_12 = null;

        Boolean this_Loop4_13 = null;

        Boolean this_LoopBug285452_14 = null;

        Boolean this_DuplicateBug284491_15 = null;

        Boolean this_EmptyObjectBug284850_16 = null;

        Boolean this_MultiInheritanceBug280439_17 = null;

        Boolean this_EObjectRef_18 = null;

        Boolean this_TypeBug305577_1_19 = null;

        Boolean this_TypeBug305577_2_20 = null;

        Boolean this_Parens_21 = null;

        Boolean this_Bug305171_22 = null;

        Boolean this_Bug310435Val_23 = null;

        Boolean this_Bug310435Enum_24 = null;

        Boolean this_CrossRefNameTest_25 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:106:1: ( (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest ) )
            // PsiInternalSimpleReconstrTestLanguage.g:107:2: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:107:2: (this_Atom_0= ruleAtom | this_TwoNumbers_1= ruleTwoNumbers | this_ManyStrings_2= ruleManyStrings | this_Type_3= ruleType | this_Ref2_4= ruleRef2 | this_Spare_5= ruleSpare | this_Boolean_6= ruleBoolean | this_Transient1_7= ruleTransient1 | this_Consumed1_8= ruleConsumed1 | this_Consumed2_9= ruleConsumed2 | this_Loop1_10= ruleLoop1 | this_Loop2_11= ruleLoop2 | this_Loop3_12= ruleLoop3 | this_Loop4_13= ruleLoop4 | this_LoopBug285452_14= ruleLoopBug285452 | this_DuplicateBug284491_15= ruleDuplicateBug284491 | this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850 | this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439 | this_EObjectRef_18= ruleEObjectRef | this_TypeBug305577_1_19= ruleTypeBug305577_1 | this_TypeBug305577_2_20= ruleTypeBug305577_2 | this_Parens_21= ruleParens | this_Bug305171_22= ruleBug305171 | this_Bug310435Val_23= ruleBug310435Val | this_Bug310435Enum_24= ruleBug310435Enum | this_CrossRefNameTest_25= ruleCrossRefNameTest )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:108:3: this_Atom_0= ruleAtom
                    {

                    			markComposite(elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Atom_0=ruleAtom();

                    state._fsp--;


                    			current = this_Atom_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:117:3: this_TwoNumbers_1= ruleTwoNumbers
                    {

                    			markComposite(elementTypeProvider.getTerm_TwoNumbersParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TwoNumbers_1=ruleTwoNumbers();

                    state._fsp--;


                    			current = this_TwoNumbers_1;
                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalSimpleReconstrTestLanguage.g:126:3: this_ManyStrings_2= ruleManyStrings
                    {

                    			markComposite(elementTypeProvider.getTerm_ManyStringsParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_ManyStrings_2=ruleManyStrings();

                    state._fsp--;


                    			current = this_ManyStrings_2;
                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // PsiInternalSimpleReconstrTestLanguage.g:135:3: this_Type_3= ruleType
                    {

                    			markComposite(elementTypeProvider.getTerm_TypeParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Type_3=ruleType();

                    state._fsp--;


                    			current = this_Type_3;
                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // PsiInternalSimpleReconstrTestLanguage.g:144:3: this_Ref2_4= ruleRef2
                    {

                    			markComposite(elementTypeProvider.getTerm_Ref2ParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Ref2_4=ruleRef2();

                    state._fsp--;


                    			current = this_Ref2_4;
                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // PsiInternalSimpleReconstrTestLanguage.g:153:3: this_Spare_5= ruleSpare
                    {

                    			markComposite(elementTypeProvider.getTerm_SpareParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Spare_5=ruleSpare();

                    state._fsp--;


                    			current = this_Spare_5;
                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // PsiInternalSimpleReconstrTestLanguage.g:162:3: this_Boolean_6= ruleBoolean
                    {

                    			markComposite(elementTypeProvider.getTerm_BooleanParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Boolean_6=ruleBoolean();

                    state._fsp--;


                    			current = this_Boolean_6;
                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // PsiInternalSimpleReconstrTestLanguage.g:171:3: this_Transient1_7= ruleTransient1
                    {

                    			markComposite(elementTypeProvider.getTerm_Transient1ParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Transient1_7=ruleTransient1();

                    state._fsp--;


                    			current = this_Transient1_7;
                    			doneComposite();
                    		

                    }
                    break;
                case 9 :
                    // PsiInternalSimpleReconstrTestLanguage.g:180:3: this_Consumed1_8= ruleConsumed1
                    {

                    			markComposite(elementTypeProvider.getTerm_Consumed1ParserRuleCall_8ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Consumed1_8=ruleConsumed1();

                    state._fsp--;


                    			current = this_Consumed1_8;
                    			doneComposite();
                    		

                    }
                    break;
                case 10 :
                    // PsiInternalSimpleReconstrTestLanguage.g:189:3: this_Consumed2_9= ruleConsumed2
                    {

                    			markComposite(elementTypeProvider.getTerm_Consumed2ParserRuleCall_9ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Consumed2_9=ruleConsumed2();

                    state._fsp--;


                    			current = this_Consumed2_9;
                    			doneComposite();
                    		

                    }
                    break;
                case 11 :
                    // PsiInternalSimpleReconstrTestLanguage.g:198:3: this_Loop1_10= ruleLoop1
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop1ParserRuleCall_10ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop1_10=ruleLoop1();

                    state._fsp--;


                    			current = this_Loop1_10;
                    			doneComposite();
                    		

                    }
                    break;
                case 12 :
                    // PsiInternalSimpleReconstrTestLanguage.g:207:3: this_Loop2_11= ruleLoop2
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop2ParserRuleCall_11ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop2_11=ruleLoop2();

                    state._fsp--;


                    			current = this_Loop2_11;
                    			doneComposite();
                    		

                    }
                    break;
                case 13 :
                    // PsiInternalSimpleReconstrTestLanguage.g:216:3: this_Loop3_12= ruleLoop3
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop3ParserRuleCall_12ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop3_12=ruleLoop3();

                    state._fsp--;


                    			current = this_Loop3_12;
                    			doneComposite();
                    		

                    }
                    break;
                case 14 :
                    // PsiInternalSimpleReconstrTestLanguage.g:225:3: this_Loop4_13= ruleLoop4
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop4ParserRuleCall_13ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Loop4_13=ruleLoop4();

                    state._fsp--;


                    			current = this_Loop4_13;
                    			doneComposite();
                    		

                    }
                    break;
                case 15 :
                    // PsiInternalSimpleReconstrTestLanguage.g:234:3: this_LoopBug285452_14= ruleLoopBug285452
                    {

                    			markComposite(elementTypeProvider.getTerm_LoopBug285452ParserRuleCall_14ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_LoopBug285452_14=ruleLoopBug285452();

                    state._fsp--;


                    			current = this_LoopBug285452_14;
                    			doneComposite();
                    		

                    }
                    break;
                case 16 :
                    // PsiInternalSimpleReconstrTestLanguage.g:243:3: this_DuplicateBug284491_15= ruleDuplicateBug284491
                    {

                    			markComposite(elementTypeProvider.getTerm_DuplicateBug284491ParserRuleCall_15ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_DuplicateBug284491_15=ruleDuplicateBug284491();

                    state._fsp--;


                    			current = this_DuplicateBug284491_15;
                    			doneComposite();
                    		

                    }
                    break;
                case 17 :
                    // PsiInternalSimpleReconstrTestLanguage.g:252:3: this_EmptyObjectBug284850_16= ruleEmptyObjectBug284850
                    {

                    			markComposite(elementTypeProvider.getTerm_EmptyObjectBug284850ParserRuleCall_16ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EmptyObjectBug284850_16=ruleEmptyObjectBug284850();

                    state._fsp--;


                    			current = this_EmptyObjectBug284850_16;
                    			doneComposite();
                    		

                    }
                    break;
                case 18 :
                    // PsiInternalSimpleReconstrTestLanguage.g:261:3: this_MultiInheritanceBug280439_17= ruleMultiInheritanceBug280439
                    {

                    			markComposite(elementTypeProvider.getTerm_MultiInheritanceBug280439ParserRuleCall_17ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_MultiInheritanceBug280439_17=ruleMultiInheritanceBug280439();

                    state._fsp--;


                    			current = this_MultiInheritanceBug280439_17;
                    			doneComposite();
                    		

                    }
                    break;
                case 19 :
                    // PsiInternalSimpleReconstrTestLanguage.g:270:3: this_EObjectRef_18= ruleEObjectRef
                    {

                    			markComposite(elementTypeProvider.getTerm_EObjectRefParserRuleCall_18ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_EObjectRef_18=ruleEObjectRef();

                    state._fsp--;


                    			current = this_EObjectRef_18;
                    			doneComposite();
                    		

                    }
                    break;
                case 20 :
                    // PsiInternalSimpleReconstrTestLanguage.g:279:3: this_TypeBug305577_1_19= ruleTypeBug305577_1
                    {

                    			markComposite(elementTypeProvider.getTerm_TypeBug305577_1ParserRuleCall_19ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug305577_1_19=ruleTypeBug305577_1();

                    state._fsp--;


                    			current = this_TypeBug305577_1_19;
                    			doneComposite();
                    		

                    }
                    break;
                case 21 :
                    // PsiInternalSimpleReconstrTestLanguage.g:288:3: this_TypeBug305577_2_20= ruleTypeBug305577_2
                    {

                    			markComposite(elementTypeProvider.getTerm_TypeBug305577_2ParserRuleCall_20ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug305577_2_20=ruleTypeBug305577_2();

                    state._fsp--;


                    			current = this_TypeBug305577_2_20;
                    			doneComposite();
                    		

                    }
                    break;
                case 22 :
                    // PsiInternalSimpleReconstrTestLanguage.g:297:3: this_Parens_21= ruleParens
                    {

                    			markComposite(elementTypeProvider.getTerm_ParensParserRuleCall_21ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Parens_21=ruleParens();

                    state._fsp--;


                    			current = this_Parens_21;
                    			doneComposite();
                    		

                    }
                    break;
                case 23 :
                    // PsiInternalSimpleReconstrTestLanguage.g:306:3: this_Bug305171_22= ruleBug305171
                    {

                    			markComposite(elementTypeProvider.getTerm_Bug305171ParserRuleCall_22ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug305171_22=ruleBug305171();

                    state._fsp--;


                    			current = this_Bug305171_22;
                    			doneComposite();
                    		

                    }
                    break;
                case 24 :
                    // PsiInternalSimpleReconstrTestLanguage.g:315:3: this_Bug310435Val_23= ruleBug310435Val
                    {

                    			markComposite(elementTypeProvider.getTerm_Bug310435ValParserRuleCall_23ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug310435Val_23=ruleBug310435Val();

                    state._fsp--;


                    			current = this_Bug310435Val_23;
                    			doneComposite();
                    		

                    }
                    break;
                case 25 :
                    // PsiInternalSimpleReconstrTestLanguage.g:324:3: this_Bug310435Enum_24= ruleBug310435Enum
                    {

                    			markComposite(elementTypeProvider.getTerm_Bug310435EnumParserRuleCall_24ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Bug310435Enum_24=ruleBug310435Enum();

                    state._fsp--;


                    			current = this_Bug310435Enum_24;
                    			doneComposite();
                    		

                    }
                    break;
                case 26 :
                    // PsiInternalSimpleReconstrTestLanguage.g:333:3: this_CrossRefNameTest_25= ruleCrossRefNameTest
                    {

                    			markComposite(elementTypeProvider.getTerm_CrossRefNameTestParserRuleCall_25ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CrossRefNameTest_25=ruleCrossRefNameTest();

                    state._fsp--;


                    			current = this_CrossRefNameTest_25;
                    			doneComposite();
                    		

                    }
                    break;

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
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // PsiInternalSimpleReconstrTestLanguage.g:345:1: entryRuleAtom returns [Boolean current=false] : iv_ruleAtom= ruleAtom EOF ;
    public final Boolean entryRuleAtom() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleAtom = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:345:46: (iv_ruleAtom= ruleAtom EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:346:2: iv_ruleAtom= ruleAtom EOF
            {
             markComposite(elementTypeProvider.getAtomElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAtom=ruleAtom();

            state._fsp--;

             current =iv_ruleAtom; 
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
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // PsiInternalSimpleReconstrTestLanguage.g:352:1: ruleAtom returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleAtom() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:353:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:354:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:354:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:355:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:355:3: (lv_name_0_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:356:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_name_0_0);
            			

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
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParens"
    // PsiInternalSimpleReconstrTestLanguage.g:374:1: entryRuleParens returns [Boolean current=false] : iv_ruleParens= ruleParens EOF ;
    public final Boolean entryRuleParens() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleParens = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:374:48: (iv_ruleParens= ruleParens EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:375:2: iv_ruleParens= ruleParens EOF
            {
             markComposite(elementTypeProvider.getParensElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleParens=ruleParens();

            state._fsp--;

             current =iv_ruleParens; 
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
    // $ANTLR end "entryRuleParens"


    // $ANTLR start "ruleParens"
    // PsiInternalSimpleReconstrTestLanguage.g:381:1: ruleParens returns [Boolean current=false] : (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final Boolean ruleParens() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;
        Boolean this_Op_1 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:382:1: ( (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // PsiInternalSimpleReconstrTestLanguage.g:383:2: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:383:2: (otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // PsiInternalSimpleReconstrTestLanguage.g:384:3: otherlv_0= '(' this_Op_1= ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {

            			markLeaf(elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		

            			markComposite(elementTypeProvider.getParens_OpParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_5);
            this_Op_1=ruleOp();

            state._fsp--;


            			current = this_Op_1;
            			doneComposite();
            		

            			markLeaf(elementTypeProvider.getParens_RightParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:406:3: ( (lv_em_3_0= '!' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:407:4: (lv_em_3_0= '!' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:407:4: (lv_em_3_0= '!' )
                    // PsiInternalSimpleReconstrTestLanguage.g:408:5: lv_em_3_0= '!'
                    {

                    					markLeaf(elementTypeProvider.getParens_EmExclamationMarkKeyword_3_0ElementType());
                    				
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_em_3_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

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
    // $ANTLR end "ruleParens"


    // $ANTLR start "entryRuleTwoNumbers"
    // PsiInternalSimpleReconstrTestLanguage.g:427:1: entryRuleTwoNumbers returns [Boolean current=false] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final Boolean entryRuleTwoNumbers() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTwoNumbers = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:427:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:428:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             markComposite(elementTypeProvider.getTwoNumbersElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTwoNumbers=ruleTwoNumbers();

            state._fsp--;

             current =iv_ruleTwoNumbers; 
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
    // $ANTLR end "entryRuleTwoNumbers"


    // $ANTLR start "ruleTwoNumbers"
    // PsiInternalSimpleReconstrTestLanguage.g:434:1: ruleTwoNumbers returns [Boolean current=false] : ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) ;
    public final Boolean ruleTwoNumbers() throws RecognitionException {
        Boolean current = false;

        Token lv_num1_0_0=null;
        Token lv_num2_1_0=null;
        Token otherlv_2=null;
        Token lv_num3_3_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:435:1: ( ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:436:2: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:436:2: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:437:3: ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            {
            // PsiInternalSimpleReconstrTestLanguage.g:437:3: ( (lv_num1_0_0= RULE_INT ) )
            // PsiInternalSimpleReconstrTestLanguage.g:438:4: (lv_num1_0_0= RULE_INT )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:438:4: (lv_num1_0_0= RULE_INT )
            // PsiInternalSimpleReconstrTestLanguage.g:439:5: lv_num1_0_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getTwoNumbers_Num1INTTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_num1_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_7); 

            					doneLeaf(lv_num1_0_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:454:3: ( (lv_num2_1_0= RULE_INT ) )
            // PsiInternalSimpleReconstrTestLanguage.g:455:4: (lv_num2_1_0= RULE_INT )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:455:4: (lv_num2_1_0= RULE_INT )
            // PsiInternalSimpleReconstrTestLanguage.g:456:5: lv_num2_1_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getTwoNumbers_Num2INTTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_num2_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_num2_1_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:471:3: (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:472:4: otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) )
            	    {

            	    				markLeaf(elementTypeProvider.getTwoNumbers_NumberSignKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_7); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalSimpleReconstrTestLanguage.g:479:4: ( (lv_num3_3_0= RULE_INT ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:480:5: (lv_num3_3_0= RULE_INT )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:480:5: (lv_num3_3_0= RULE_INT )
            	    // PsiInternalSimpleReconstrTestLanguage.g:481:6: lv_num3_3_0= RULE_INT
            	    {

            	    						markLeaf(elementTypeProvider.getTwoNumbers_Num3INTTerminalRuleCall_2_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_num3_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_8); 

            	    						doneLeaf(lv_num3_3_0);
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTwoNumbers"


    // $ANTLR start "entryRuleManyStrings"
    // PsiInternalSimpleReconstrTestLanguage.g:501:1: entryRuleManyStrings returns [Boolean current=false] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final Boolean entryRuleManyStrings() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleManyStrings = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:501:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:502:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             markComposite(elementTypeProvider.getManyStringsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleManyStrings=ruleManyStrings();

            state._fsp--;

             current =iv_ruleManyStrings; 
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
    // $ANTLR end "entryRuleManyStrings"


    // $ANTLR start "ruleManyStrings"
    // PsiInternalSimpleReconstrTestLanguage.g:508:1: ruleManyStrings returns [Boolean current=false] : (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) ;
    public final Boolean ruleManyStrings() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_str1_1_0=null;
        Token lv_str2_2_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:509:1: ( (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:510:2: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:510:2: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:511:3: otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getManyStrings_EqualsSignKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:518:3: ( (lv_str1_1_0= RULE_STRING ) )*
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:519:4: (lv_str1_1_0= RULE_STRING )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:519:4: (lv_str1_1_0= RULE_STRING )
            	    // PsiInternalSimpleReconstrTestLanguage.g:520:5: lv_str1_1_0= RULE_STRING
            	    {

            	    					markLeaf(elementTypeProvider.getManyStrings_Str1STRINGTerminalRuleCall_1_0ElementType());
            	    				

            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				
            	    lv_str1_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_9); 

            	    					doneLeaf(lv_str1_1_0);
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // PsiInternalSimpleReconstrTestLanguage.g:535:3: ( (lv_str2_2_0= RULE_STRING ) )
            // PsiInternalSimpleReconstrTestLanguage.g:536:4: (lv_str2_2_0= RULE_STRING )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:536:4: (lv_str2_2_0= RULE_STRING )
            // PsiInternalSimpleReconstrTestLanguage.g:537:5: lv_str2_2_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getManyStrings_Str2STRINGTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_str2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_str2_2_0);
            				

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
    // $ANTLR end "ruleManyStrings"


    // $ANTLR start "entryRuleType"
    // PsiInternalSimpleReconstrTestLanguage.g:556:1: entryRuleType returns [Boolean current=false] : iv_ruleType= ruleType EOF ;
    public final Boolean entryRuleType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleType = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:556:46: (iv_ruleType= ruleType EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:557:2: iv_ruleType= ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalSimpleReconstrTestLanguage.g:563:1: ruleType returns [Boolean current=false] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) ;
    public final Boolean ruleType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:564:1: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:565:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:565:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:566:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:573:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:574:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:574:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:575:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_11); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getType_ExtendsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:597:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:598:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:598:4: (otherlv_3= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:599:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_3);
            				

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleRef2"
    // PsiInternalSimpleReconstrTestLanguage.g:618:1: entryRuleRef2 returns [Boolean current=false] : iv_ruleRef2= ruleRef2 EOF ;
    public final Boolean entryRuleRef2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleRef2 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:618:46: (iv_ruleRef2= ruleRef2 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:619:2: iv_ruleRef2= ruleRef2 EOF
            {
             markComposite(elementTypeProvider.getRef2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRef2=ruleRef2();

            state._fsp--;

             current =iv_ruleRef2; 
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
    // $ANTLR end "entryRuleRef2"


    // $ANTLR start "ruleRef2"
    // PsiInternalSimpleReconstrTestLanguage.g:625:1: ruleRef2 returns [Boolean current=false] : (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) ;
    public final Boolean ruleRef2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_ref2_1_1=null;
        Token lv_ref2_1_2=null;
        Token lv_ref2_1_3=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:626:1: ( (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:627:2: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:627:2: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:628:3: otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            {

            			markLeaf(elementTypeProvider.getRef2_NumberSignDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_12); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:635:3: ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:636:4: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:636:4: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            // PsiInternalSimpleReconstrTestLanguage.g:637:5: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:637:5: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:638:6: lv_ref2_1_1= 'mykeyword1'
                    {

                    						markLeaf(elementTypeProvider.getRef2_Ref2Mykeyword1Keyword_1_0_0ElementType());
                    					
                    lv_ref2_1_1=(Token)match(input,21,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_ref2_1_1);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:652:6: lv_ref2_1_2= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getRef2_Ref2STRINGTerminalRuleCall_1_0_1ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_ref2_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_ref2_1_2);
                    					

                    }
                    break;
                case 3 :
                    // PsiInternalSimpleReconstrTestLanguage.g:666:6: lv_ref2_1_3= 'mykeyword2'
                    {

                    						markLeaf(elementTypeProvider.getRef2_Ref2Mykeyword2Keyword_1_0_2ElementType());
                    					
                    lv_ref2_1_3=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_ref2_1_3);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }
                    break;

            }


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
    // $ANTLR end "ruleRef2"


    // $ANTLR start "entryRuleSpare"
    // PsiInternalSimpleReconstrTestLanguage.g:686:1: entryRuleSpare returns [Boolean current=false] : iv_ruleSpare= ruleSpare EOF ;
    public final Boolean entryRuleSpare() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSpare = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:686:47: (iv_ruleSpare= ruleSpare EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:687:2: iv_ruleSpare= ruleSpare EOF
            {
             markComposite(elementTypeProvider.getSpareElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSpare=ruleSpare();

            state._fsp--;

             current =iv_ruleSpare; 
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
    // $ANTLR end "entryRuleSpare"


    // $ANTLR start "ruleSpare"
    // PsiInternalSimpleReconstrTestLanguage.g:693:1: ruleSpare returns [Boolean current=false] : (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) ;
    public final Boolean ruleSpare() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:694:1: ( (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:695:2: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:695:2: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:696:3: otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getSpare_NumberSignDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:703:3: ( (lv_id_1_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:704:4: (lv_id_1_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:704:4: (lv_id_1_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:705:5: lv_id_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getSpare_IdIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            					doneLeaf(lv_id_1_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:720:3: (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:721:4: otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getSpare_FullStopKeyword_2_0ElementType());
            	    			
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_10); 

            	    				doneLeaf(otherlv_2);
            	    			
            	    // PsiInternalSimpleReconstrTestLanguage.g:728:4: ( (lv_id_3_0= RULE_ID ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:729:5: (lv_id_3_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:729:5: (lv_id_3_0= RULE_ID )
            	    // PsiInternalSimpleReconstrTestLanguage.g:730:6: lv_id_3_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getSpare_IdIDTerminalRuleCall_2_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_13); 

            	    						doneLeaf(lv_id_3_0);
            	    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpare"


    // $ANTLR start "entryRuleBoolean"
    // PsiInternalSimpleReconstrTestLanguage.g:750:1: entryRuleBoolean returns [Boolean current=false] : iv_ruleBoolean= ruleBoolean EOF ;
    public final Boolean entryRuleBoolean() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBoolean = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:750:49: (iv_ruleBoolean= ruleBoolean EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:751:2: iv_ruleBoolean= ruleBoolean EOF
            {
             markComposite(elementTypeProvider.getBooleanElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // PsiInternalSimpleReconstrTestLanguage.g:757:1: ruleBoolean returns [Boolean current=false] : (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleBoolean() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_bool_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:758:1: ( (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:759:2: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:759:2: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:760:3: otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getBoolean_NumberSignDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_14); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:767:3: ( (lv_bool_1_0= 'myoption' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:768:4: (lv_bool_1_0= 'myoption' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:768:4: (lv_bool_1_0= 'myoption' )
                    // PsiInternalSimpleReconstrTestLanguage.g:769:5: lv_bool_1_0= 'myoption'
                    {

                    					markLeaf(elementTypeProvider.getBoolean_BoolMyoptionKeyword_1_0ElementType());
                    				
                    lv_bool_1_0=(Token)match(input,26,FollowSets000.FOLLOW_15); 

                    					doneLeaf(lv_bool_1_0);
                    				

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getBoolean_KwKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:791:3: ( (lv_value_3_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:792:4: (lv_value_3_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:792:4: (lv_value_3_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:793:5: lv_value_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBoolean_ValueIDTerminalRuleCall_3_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_value_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_value_3_0);
            				

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
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleTransient1"
    // PsiInternalSimpleReconstrTestLanguage.g:812:1: entryRuleTransient1 returns [Boolean current=false] : iv_ruleTransient1= ruleTransient1 EOF ;
    public final Boolean entryRuleTransient1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTransient1 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:812:52: (iv_ruleTransient1= ruleTransient1 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:813:2: iv_ruleTransient1= ruleTransient1 EOF
            {
             markComposite(elementTypeProvider.getTransient1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTransient1=ruleTransient1();

            state._fsp--;

             current =iv_ruleTransient1; 
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
    // $ANTLR end "entryRuleTransient1"


    // $ANTLR start "ruleTransient1"
    // PsiInternalSimpleReconstrTestLanguage.g:819:1: ruleTransient1 returns [Boolean current=false] : (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) ;
    public final Boolean ruleTransient1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_precStar_1_0=null;
        Token lv_prec_2_0=null;
        Token otherlv_3=null;
        Token lv_scaleStar_4_0=null;
        Token lv_scale_5_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:820:1: ( (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) )
            // PsiInternalSimpleReconstrTestLanguage.g:821:2: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:821:2: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            // PsiInternalSimpleReconstrTestLanguage.g:822:3: otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            {

            			markLeaf(elementTypeProvider.getTransient1_NumberSignDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:829:3: ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:830:4: ( (lv_precStar_1_0= '*' ) )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:830:4: ( (lv_precStar_1_0= '*' ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:831:5: (lv_precStar_1_0= '*' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:831:5: (lv_precStar_1_0= '*' )
                    // PsiInternalSimpleReconstrTestLanguage.g:832:6: lv_precStar_1_0= '*'
                    {

                    						markLeaf(elementTypeProvider.getTransient1_PrecStarAsteriskKeyword_1_0_0ElementType());
                    					
                    lv_precStar_1_0=(Token)match(input,29,FollowSets000.FOLLOW_17); 

                    						doneLeaf(lv_precStar_1_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:848:4: ( (lv_prec_2_0= RULE_INT ) )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:848:4: ( (lv_prec_2_0= RULE_INT ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:849:5: (lv_prec_2_0= RULE_INT )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:849:5: (lv_prec_2_0= RULE_INT )
                    // PsiInternalSimpleReconstrTestLanguage.g:850:6: lv_prec_2_0= RULE_INT
                    {

                    						markLeaf(elementTypeProvider.getTransient1_PrecINTTerminalRuleCall_1_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_prec_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_17); 

                    						doneLeaf(lv_prec_2_0);
                    					

                    }


                    }


                    }
                    break;

            }

            // PsiInternalSimpleReconstrTestLanguage.g:866:3: (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:867:4: otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
                    {

                    				markLeaf(elementTypeProvider.getTransient1_CommaKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_16); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalSimpleReconstrTestLanguage.g:874:4: ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
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
                            // PsiInternalSimpleReconstrTestLanguage.g:875:5: ( (lv_scaleStar_4_0= '*' ) )
                            {
                            // PsiInternalSimpleReconstrTestLanguage.g:875:5: ( (lv_scaleStar_4_0= '*' ) )
                            // PsiInternalSimpleReconstrTestLanguage.g:876:6: (lv_scaleStar_4_0= '*' )
                            {
                            // PsiInternalSimpleReconstrTestLanguage.g:876:6: (lv_scaleStar_4_0= '*' )
                            // PsiInternalSimpleReconstrTestLanguage.g:877:7: lv_scaleStar_4_0= '*'
                            {

                            							markLeaf(elementTypeProvider.getTransient1_ScaleStarAsteriskKeyword_2_1_0_0ElementType());
                            						
                            lv_scaleStar_4_0=(Token)match(input,29,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_scaleStar_4_0);
                            						

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalSimpleReconstrTestLanguage.g:893:5: ( (lv_scale_5_0= RULE_INT ) )
                            {
                            // PsiInternalSimpleReconstrTestLanguage.g:893:5: ( (lv_scale_5_0= RULE_INT ) )
                            // PsiInternalSimpleReconstrTestLanguage.g:894:6: (lv_scale_5_0= RULE_INT )
                            {
                            // PsiInternalSimpleReconstrTestLanguage.g:894:6: (lv_scale_5_0= RULE_INT )
                            // PsiInternalSimpleReconstrTestLanguage.g:895:7: lv_scale_5_0= RULE_INT
                            {

                            							markLeaf(elementTypeProvider.getTransient1_ScaleINTTerminalRuleCall_2_1_1_0ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
                            lv_scale_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_scale_5_0);
                            						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransient1"


    // $ANTLR start "entryRuleConsumed1"
    // PsiInternalSimpleReconstrTestLanguage.g:916:1: entryRuleConsumed1 returns [Boolean current=false] : iv_ruleConsumed1= ruleConsumed1 EOF ;
    public final Boolean entryRuleConsumed1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleConsumed1 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:916:51: (iv_ruleConsumed1= ruleConsumed1 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:917:2: iv_ruleConsumed1= ruleConsumed1 EOF
            {
             markComposite(elementTypeProvider.getConsumed1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConsumed1=ruleConsumed1();

            state._fsp--;

             current =iv_ruleConsumed1; 
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
    // $ANTLR end "entryRuleConsumed1"


    // $ANTLR start "ruleConsumed1"
    // PsiInternalSimpleReconstrTestLanguage.g:923:1: ruleConsumed1 returns [Boolean current=false] : (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) ;
    public final Boolean ruleConsumed1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_v1_2_0=null;
        Token lv_v2_3_0=null;
        Token otherlv_4=null;
        Token lv_v2_5_0=null;
        Token lv_v1_6_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:924:1: ( (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:925:2: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:925:2: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:926:3: otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
            {

            			markLeaf(elementTypeProvider.getConsumed1_NumberSignDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:933:3: ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:934:4: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:934:4: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:935:5: otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) )
                    {

                    					markLeaf(elementTypeProvider.getConsumed1_V1Keyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_19); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSimpleReconstrTestLanguage.g:942:5: ( (lv_v1_2_0= RULE_INT ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_INT) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // PsiInternalSimpleReconstrTestLanguage.g:943:6: (lv_v1_2_0= RULE_INT )
                    	    {
                    	    // PsiInternalSimpleReconstrTestLanguage.g:943:6: (lv_v1_2_0= RULE_INT )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:944:7: lv_v1_2_0= RULE_INT
                    	    {

                    	    							markLeaf(elementTypeProvider.getConsumed1_V1INTTerminalRuleCall_1_0_1_0ElementType());
                    	    						

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						
                    	    lv_v1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_19); 

                    	    							doneLeaf(lv_v1_2_0);
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // PsiInternalSimpleReconstrTestLanguage.g:959:5: ( (lv_v2_3_0= RULE_ID ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:960:6: (lv_v2_3_0= RULE_ID )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:960:6: (lv_v2_3_0= RULE_ID )
                    // PsiInternalSimpleReconstrTestLanguage.g:961:7: lv_v2_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getConsumed1_V2IDTerminalRuleCall_1_0_2_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_v2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_v2_3_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:978:4: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:978:4: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:979:5: otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) )
                    {

                    					markLeaf(elementTypeProvider.getConsumed1_V2Keyword_1_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_19); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalSimpleReconstrTestLanguage.g:986:5: ( (lv_v2_5_0= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // PsiInternalSimpleReconstrTestLanguage.g:987:6: (lv_v2_5_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleReconstrTestLanguage.g:987:6: (lv_v2_5_0= RULE_ID )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:988:7: lv_v2_5_0= RULE_ID
                    	    {

                    	    							markLeaf(elementTypeProvider.getConsumed1_V2IDTerminalRuleCall_1_1_1_0ElementType());
                    	    						

                    	    							if(!current) {
                    	    								associateWithSemanticElement();
                    	    								current = true;
                    	    							}
                    	    						
                    	    lv_v2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_19); 

                    	    							doneLeaf(lv_v2_5_0);
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // PsiInternalSimpleReconstrTestLanguage.g:1003:5: ( (lv_v1_6_0= RULE_INT ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:1004:6: (lv_v1_6_0= RULE_INT )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1004:6: (lv_v1_6_0= RULE_INT )
                    // PsiInternalSimpleReconstrTestLanguage.g:1005:7: lv_v1_6_0= RULE_INT
                    {

                    							markLeaf(elementTypeProvider.getConsumed1_V1INTTerminalRuleCall_1_1_2_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_v1_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_v1_6_0);
                    						

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleConsumed1"


    // $ANTLR start "entryRuleConsumed2"
    // PsiInternalSimpleReconstrTestLanguage.g:1026:1: entryRuleConsumed2 returns [Boolean current=false] : iv_ruleConsumed2= ruleConsumed2 EOF ;
    public final Boolean entryRuleConsumed2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleConsumed2 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1026:51: (iv_ruleConsumed2= ruleConsumed2 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1027:2: iv_ruleConsumed2= ruleConsumed2 EOF
            {
             markComposite(elementTypeProvider.getConsumed2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConsumed2=ruleConsumed2();

            state._fsp--;

             current =iv_ruleConsumed2; 
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
    // $ANTLR end "entryRuleConsumed2"


    // $ANTLR start "ruleConsumed2"
    // PsiInternalSimpleReconstrTestLanguage.g:1033:1: ruleConsumed2 returns [Boolean current=false] : (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) ;
    public final Boolean ruleConsumed2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_child_1_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1034:1: ( (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1035:2: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1035:2: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1036:3: otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) )
            {

            			markLeaf(elementTypeProvider.getConsumed2_NumberSignDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1043:3: ( (lv_child_1_0= ruleConsumed1 ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1044:4: (lv_child_1_0= ruleConsumed1 )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1044:4: (lv_child_1_0= ruleConsumed1 )
            // PsiInternalSimpleReconstrTestLanguage.g:1045:5: lv_child_1_0= ruleConsumed1
            {

            					markComposite(elementTypeProvider.getConsumed2_ChildConsumed1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_child_1_0=ruleConsumed1();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConsumed2"


    // $ANTLR start "entryRuleLoop1"
    // PsiInternalSimpleReconstrTestLanguage.g:1062:1: entryRuleLoop1 returns [Boolean current=false] : iv_ruleLoop1= ruleLoop1 EOF ;
    public final Boolean entryRuleLoop1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLoop1 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1062:47: (iv_ruleLoop1= ruleLoop1 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1063:2: iv_ruleLoop1= ruleLoop1 EOF
            {
             markComposite(elementTypeProvider.getLoop1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop1=ruleLoop1();

            state._fsp--;

             current =iv_ruleLoop1; 
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
    // $ANTLR end "entryRuleLoop1"


    // $ANTLR start "ruleLoop1"
    // PsiInternalSimpleReconstrTestLanguage.g:1069:1: ruleLoop1 returns [Boolean current=false] : ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) ;
    public final Boolean ruleLoop1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1070:1: ( ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1071:2: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1071:2: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            // PsiInternalSimpleReconstrTestLanguage.g:1072:3: (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1072:3: (otherlv_0= 'kw0' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1073:4: otherlv_0= 'kw0'
                    {

                    				markLeaf(elementTypeProvider.getLoop1_Kw0Keyword_0ElementType());
                    			
                    otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_21); 

                    				doneLeaf(otherlv_0);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getLoop1_NumberSignDigitEightKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1088:3: ( (lv_id_2_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1089:4: (lv_id_2_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1089:4: (lv_id_2_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1090:5: lv_id_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLoop1_IdIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_id_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            					doneLeaf(lv_id_2_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:1105:3: (otherlv_3= 'kw1' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1106:4: otherlv_3= 'kw1'
                    {

                    				markLeaf(elementTypeProvider.getLoop1_Kw1Keyword_3ElementType());
                    			
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_10); 

                    				doneLeaf(otherlv_3);
                    			

                    }
                    break;

            }

            // PsiInternalSimpleReconstrTestLanguage.g:1114:3: ( (lv_id_4_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1115:4: (lv_id_4_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1115:4: (lv_id_4_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1116:5: lv_id_4_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLoop1_IdIDTerminalRuleCall_4_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_23); 

            					doneLeaf(lv_id_4_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:1131:3: ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:1132:4: (otherlv_5= 'kw2' )* otherlv_6= 'kw30'
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1132:4: (otherlv_5= 'kw2' )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==38) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // PsiInternalSimpleReconstrTestLanguage.g:1133:5: otherlv_5= 'kw2'
            	    	    {

            	    	    					markLeaf(elementTypeProvider.getLoop1_Kw2Keyword_5_0ElementType());
            	    	    				
            	    	    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_23); 

            	    	    					doneLeaf(otherlv_5);
            	    	    				

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);


            	    				markLeaf(elementTypeProvider.getLoop1_Kw30Keyword_5_1ElementType());
            	    			
            	    otherlv_6=(Token)match(input,39,FollowSets000.FOLLOW_24); 

            	    				doneLeaf(otherlv_6);
            	    			

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop1"


    // $ANTLR start "entryRuleLoop2"
    // PsiInternalSimpleReconstrTestLanguage.g:1153:1: entryRuleLoop2 returns [Boolean current=false] : iv_ruleLoop2= ruleLoop2 EOF ;
    public final Boolean entryRuleLoop2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLoop2 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1153:47: (iv_ruleLoop2= ruleLoop2 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1154:2: iv_ruleLoop2= ruleLoop2 EOF
            {
             markComposite(elementTypeProvider.getLoop2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop2=ruleLoop2();

            state._fsp--;

             current =iv_ruleLoop2; 
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
    // $ANTLR end "entryRuleLoop2"


    // $ANTLR start "ruleLoop2"
    // PsiInternalSimpleReconstrTestLanguage.g:1160:1: ruleLoop2 returns [Boolean current=false] : (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) ;
    public final Boolean ruleLoop2() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1161:1: ( (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1162:2: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1162:2: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1163:3: otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
            {

            			markLeaf(elementTypeProvider.getLoop2_NumberSignDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1170:3: ( (lv_id_1_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1171:4: (lv_id_1_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1171:4: (lv_id_1_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1172:5: lv_id_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLoop2_IdIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

            					doneLeaf(lv_id_1_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:1187:3: (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1188:4: otherlv_2= 'kw1'
                    {

                    				markLeaf(elementTypeProvider.getLoop2_Kw1Keyword_2_0ElementType());
                    			
                    otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_25); 

                    				doneLeaf(otherlv_2);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1196:4: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1196:4: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    // PsiInternalSimpleReconstrTestLanguage.g:1197:5: ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2'
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1197:5: ( (lv_id_3_0= RULE_ID ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:1198:6: (lv_id_3_0= RULE_ID )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1198:6: (lv_id_3_0= RULE_ID )
                    // PsiInternalSimpleReconstrTestLanguage.g:1199:7: lv_id_3_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getLoop2_IdIDTerminalRuleCall_2_1_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

                    							doneLeaf(lv_id_3_0);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getLoop2_Kw2Keyword_2_1_1ElementType());
                    				
                    otherlv_4=(Token)match(input,38,FollowSets000.FOLLOW_25); 

                    					doneLeaf(otherlv_4);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSimpleReconstrTestLanguage.g:1223:3: (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )?
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1224:4: otherlv_5= 'kw3'
                    {

                    				markLeaf(elementTypeProvider.getLoop2_Kw3Keyword_3_0ElementType());
                    			
                    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_27); 

                    				doneLeaf(otherlv_5);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1232:4: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1232:4: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    // PsiInternalSimpleReconstrTestLanguage.g:1233:5: ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4'
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1233:5: ( (lv_id_6_0= RULE_ID ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:1234:6: (lv_id_6_0= RULE_ID )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1234:6: (lv_id_6_0= RULE_ID )
                    // PsiInternalSimpleReconstrTestLanguage.g:1235:7: lv_id_6_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getLoop2_IdIDTerminalRuleCall_3_1_0_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_28); 

                    							doneLeaf(lv_id_6_0);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getLoop2_Kw4Keyword_3_1_1ElementType());
                    				
                    otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_27); 

                    					doneLeaf(otherlv_7);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSimpleReconstrTestLanguage.g:1259:3: (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1260:4: otherlv_8= 'kw5'
                    {

                    				markLeaf(elementTypeProvider.getLoop2_Kw5Keyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,43,FollowSets000.FOLLOW_2); 

                    				doneLeaf(otherlv_8);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1268:4: otherlv_9= 'kw6'
                    {

                    				markLeaf(elementTypeProvider.getLoop2_Kw6Keyword_4_1ElementType());
                    			
                    otherlv_9=(Token)match(input,44,FollowSets000.FOLLOW_2); 

                    				doneLeaf(otherlv_9);
                    			

                    }
                    break;

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
    // $ANTLR end "ruleLoop2"


    // $ANTLR start "entryRuleLoop3"
    // PsiInternalSimpleReconstrTestLanguage.g:1280:1: entryRuleLoop3 returns [Boolean current=false] : iv_ruleLoop3= ruleLoop3 EOF ;
    public final Boolean entryRuleLoop3() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLoop3 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1280:47: (iv_ruleLoop3= ruleLoop3 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1281:2: iv_ruleLoop3= ruleLoop3 EOF
            {
             markComposite(elementTypeProvider.getLoop3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop3=ruleLoop3();

            state._fsp--;

             current =iv_ruleLoop3; 
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
    // $ANTLR end "entryRuleLoop3"


    // $ANTLR start "ruleLoop3"
    // PsiInternalSimpleReconstrTestLanguage.g:1287:1: ruleLoop3 returns [Boolean current=false] : ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) ;
    public final Boolean ruleLoop3() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1288:1: ( ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1289:2: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1289:2: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            // PsiInternalSimpleReconstrTestLanguage.g:1290:3: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1290:3: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1291:4: otherlv_0= 'kw1'
                    {

                    				markLeaf(elementTypeProvider.getLoop3_Kw1Keyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_29); 

                    				doneLeaf(otherlv_0);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1299:4: otherlv_1= 'kw2'
                    {

                    				markLeaf(elementTypeProvider.getLoop3_Kw2Keyword_0_1ElementType());
                    			
                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_29); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1307:4: otherlv_2= 'kw3'
                    {

                    				markLeaf(elementTypeProvider.getLoop3_Kw3Keyword_0_2ElementType());
                    			
                    otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_29); 

                    				doneLeaf(otherlv_2);
                    			

                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getLoop3_NumberSignDigitOneDigitZeroKeyword_1ElementType());
            		
            otherlv_3=(Token)match(input,45,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1322:3: ( (lv_id_4_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1323:4: (lv_id_4_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1323:4: (lv_id_4_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1324:5: lv_id_4_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLoop3_IdIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_30); 

            					doneLeaf(lv_id_4_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:1339:3: (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==42) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:1340:4: otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5'
            	    {

            	    				markLeaf(elementTypeProvider.getLoop3_Kw4Keyword_3_0ElementType());
            	    			
            	    otherlv_5=(Token)match(input,42,FollowSets000.FOLLOW_10); 

            	    				doneLeaf(otherlv_5);
            	    			
            	    // PsiInternalSimpleReconstrTestLanguage.g:1347:4: ( (lv_id_6_0= RULE_ID ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1348:5: (lv_id_6_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1348:5: (lv_id_6_0= RULE_ID )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1349:6: lv_id_6_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getLoop3_IdIDTerminalRuleCall_3_1_0ElementType());
            	    					

            	    						if(!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					
            	    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            	    						doneLeaf(lv_id_6_0);
            	    					

            	    }


            	    }


            	    				markLeaf(elementTypeProvider.getLoop3_Kw5Keyword_3_2ElementType());
            	    			
            	    otherlv_7=(Token)match(input,43,FollowSets000.FOLLOW_30); 

            	    				doneLeaf(otherlv_7);
            	    			

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "ruleLoop3"


    // $ANTLR start "entryRuleLoop4"
    // PsiInternalSimpleReconstrTestLanguage.g:1376:1: entryRuleLoop4 returns [Boolean current=false] : iv_ruleLoop4= ruleLoop4 EOF ;
    public final Boolean entryRuleLoop4() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLoop4 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1376:47: (iv_ruleLoop4= ruleLoop4 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1377:2: iv_ruleLoop4= ruleLoop4 EOF
            {
             markComposite(elementTypeProvider.getLoop4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoop4=ruleLoop4();

            state._fsp--;

             current =iv_ruleLoop4; 
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
    // $ANTLR end "entryRuleLoop4"


    // $ANTLR start "ruleLoop4"
    // PsiInternalSimpleReconstrTestLanguage.g:1383:1: ruleLoop4 returns [Boolean current=false] : (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) ;
    public final Boolean ruleLoop4() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_id_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1384:1: ( (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1385:2: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1385:2: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            // PsiInternalSimpleReconstrTestLanguage.g:1386:3: otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
            {

            			markLeaf(elementTypeProvider.getLoop4_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_32); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1393:3: (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1394:4: otherlv_1= 'kw1'
                    {

                    				markLeaf(elementTypeProvider.getLoop4_Kw1Keyword_1_0ElementType());
                    			
                    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_10); 

                    				doneLeaf(otherlv_1);
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1402:4: otherlv_2= 'kw2'
                    {

                    				markLeaf(elementTypeProvider.getLoop4_Kw2Keyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_10); 

                    				doneLeaf(otherlv_2);
                    			

                    }
                    break;
                case 3 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1410:4: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1410:4: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    // PsiInternalSimpleReconstrTestLanguage.g:1411:5: otherlv_3= 'kw3' otherlv_4= 'kw4'
                    {

                    					markLeaf(elementTypeProvider.getLoop4_Kw3Keyword_1_2_0ElementType());
                    				
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_28); 

                    					doneLeaf(otherlv_3);
                    				

                    					markLeaf(elementTypeProvider.getLoop4_Kw4Keyword_1_2_1ElementType());
                    				
                    otherlv_4=(Token)match(input,42,FollowSets000.FOLLOW_10); 

                    					doneLeaf(otherlv_4);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalSimpleReconstrTestLanguage.g:1427:3: ( (lv_id_5_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1428:4: (lv_id_5_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1428:4: (lv_id_5_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1429:5: lv_id_5_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLoop4_IdIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_id_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_31); 

            					doneLeaf(lv_id_5_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:1444:3: (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:1445:4: otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    {

            	    				markLeaf(elementTypeProvider.getLoop4_Kw5Keyword_3_0ElementType());
            	    			
            	    otherlv_6=(Token)match(input,43,FollowSets000.FOLLOW_33); 

            	    				doneLeaf(otherlv_6);
            	    			
            	    // PsiInternalSimpleReconstrTestLanguage.g:1452:4: (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==44) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // PsiInternalSimpleReconstrTestLanguage.g:1453:5: otherlv_7= 'kw6' (otherlv_8= 'kw7' )?
            	            {

            	            					markLeaf(elementTypeProvider.getLoop4_Kw6Keyword_3_1_0ElementType());
            	            				
            	            otherlv_7=(Token)match(input,44,FollowSets000.FOLLOW_34); 

            	            					doneLeaf(otherlv_7);
            	            				
            	            // PsiInternalSimpleReconstrTestLanguage.g:1460:5: (otherlv_8= 'kw7' )?
            	            int alt25=2;
            	            int LA25_0 = input.LA(1);

            	            if ( (LA25_0==47) ) {
            	                alt25=1;
            	            }
            	            switch (alt25) {
            	                case 1 :
            	                    // PsiInternalSimpleReconstrTestLanguage.g:1461:6: otherlv_8= 'kw7'
            	                    {

            	                    						markLeaf(elementTypeProvider.getLoop4_Kw7Keyword_3_1_1ElementType());
            	                    					
            	                    otherlv_8=(Token)match(input,47,FollowSets000.FOLLOW_35); 

            	                    						doneLeaf(otherlv_8);
            	                    					

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoop4"


    // $ANTLR start "entryRuleLoopBug285452"
    // PsiInternalSimpleReconstrTestLanguage.g:1475:1: entryRuleLoopBug285452 returns [Boolean current=false] : iv_ruleLoopBug285452= ruleLoopBug285452 EOF ;
    public final Boolean entryRuleLoopBug285452() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleLoopBug285452 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1475:55: (iv_ruleLoopBug285452= ruleLoopBug285452 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1476:2: iv_ruleLoopBug285452= ruleLoopBug285452 EOF
            {
             markComposite(elementTypeProvider.getLoopBug285452ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleLoopBug285452=ruleLoopBug285452();

            state._fsp--;

             current =iv_ruleLoopBug285452; 
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
    // $ANTLR end "entryRuleLoopBug285452"


    // $ANTLR start "ruleLoopBug285452"
    // PsiInternalSimpleReconstrTestLanguage.g:1482:1: ruleLoopBug285452 returns [Boolean current=false] : (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final Boolean ruleLoopBug285452() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_interface_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1483:1: ( (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1484:2: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1484:2: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1485:3: otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getLoopBug285452_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_36); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1492:3: ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1493:4: ( (lv_interface_1_0= 'interface' ) )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1493:4: ( (lv_interface_1_0= 'interface' ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:1494:5: (lv_interface_1_0= 'interface' )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:1494:5: (lv_interface_1_0= 'interface' )
                    // PsiInternalSimpleReconstrTestLanguage.g:1495:6: lv_interface_1_0= 'interface'
                    {

                    						markLeaf(elementTypeProvider.getLoopBug285452_InterfaceInterfaceKeyword_1_0_0ElementType());
                    					
                    lv_interface_1_0=(Token)match(input,49,FollowSets000.FOLLOW_10); 

                    						doneLeaf(lv_interface_1_0);
                    					

                    						if (!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1511:4: otherlv_2= 'class'
                    {

                    				markLeaf(elementTypeProvider.getLoopBug285452_ClassKeyword_1_1ElementType());
                    			
                    otherlv_2=(Token)match(input,50,FollowSets000.FOLLOW_10); 

                    				doneLeaf(otherlv_2);
                    			

                    }
                    break;

            }

            // PsiInternalSimpleReconstrTestLanguage.g:1519:3: ( (lv_name_3_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1520:4: (lv_name_3_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1520:4: (lv_name_3_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1521:5: lv_name_3_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getLoopBug285452_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_3_0);
            				

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
    // $ANTLR end "ruleLoopBug285452"


    // $ANTLR start "entryRuleDuplicateBug284491"
    // PsiInternalSimpleReconstrTestLanguage.g:1540:1: entryRuleDuplicateBug284491 returns [Boolean current=false] : iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF ;
    public final Boolean entryRuleDuplicateBug284491() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDuplicateBug284491 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1540:60: (iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1541:2: iv_ruleDuplicateBug284491= ruleDuplicateBug284491 EOF
            {
             markComposite(elementTypeProvider.getDuplicateBug284491ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDuplicateBug284491=ruleDuplicateBug284491();

            state._fsp--;

             current =iv_ruleDuplicateBug284491; 
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
    // $ANTLR end "entryRuleDuplicateBug284491"


    // $ANTLR start "ruleDuplicateBug284491"
    // PsiInternalSimpleReconstrTestLanguage.g:1547:1: ruleDuplicateBug284491 returns [Boolean current=false] : (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) ;
    public final Boolean ruleDuplicateBug284491() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_final_2_0=null;
        Token lv_transient_3_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1548:1: ( (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1549:2: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1549:2: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:1550:3: otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
            {

            			markLeaf(elementTypeProvider.getDuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_37); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1557:3: ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:1558:4: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1558:4: ( (lv_static_1_0= 'static' ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1559:5: (lv_static_1_0= 'static' )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1559:5: (lv_static_1_0= 'static' )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1560:6: lv_static_1_0= 'static'
            	    {

            	    						markLeaf(elementTypeProvider.getDuplicateBug284491_StaticStaticKeyword_1_0_0ElementType());
            	    					
            	    lv_static_1_0=(Token)match(input,52,FollowSets000.FOLLOW_37); 

            	    						doneLeaf(lv_static_1_0);
            	    					

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:1576:4: ( (lv_final_2_0= 'final' ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1576:4: ( (lv_final_2_0= 'final' ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1577:5: (lv_final_2_0= 'final' )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1577:5: (lv_final_2_0= 'final' )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1578:6: lv_final_2_0= 'final'
            	    {

            	    						markLeaf(elementTypeProvider.getDuplicateBug284491_FinalFinalKeyword_1_1_0ElementType());
            	    					
            	    lv_final_2_0=(Token)match(input,53,FollowSets000.FOLLOW_37); 

            	    						doneLeaf(lv_final_2_0);
            	    					

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
            	    						}
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:1594:4: ( (lv_transient_3_0= 'transient' ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1594:4: ( (lv_transient_3_0= 'transient' ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1595:5: (lv_transient_3_0= 'transient' )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1595:5: (lv_transient_3_0= 'transient' )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1596:6: lv_transient_3_0= 'transient'
            	    {

            	    						markLeaf(elementTypeProvider.getDuplicateBug284491_TransientTransientKeyword_1_2_0ElementType());
            	    					
            	    lv_transient_3_0=(Token)match(input,54,FollowSets000.FOLLOW_37); 

            	    						doneLeaf(lv_transient_3_0);
            	    					

            	    						if (!current) {
            	    							associateWithSemanticElement();
            	    							current = true;
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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDuplicateBug284491"


    // $ANTLR start "entryRuleEmptyObjectBug284850"
    // PsiInternalSimpleReconstrTestLanguage.g:1616:1: entryRuleEmptyObjectBug284850 returns [Boolean current=false] : iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF ;
    public final Boolean entryRuleEmptyObjectBug284850() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEmptyObjectBug284850 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1616:62: (iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1617:2: iv_ruleEmptyObjectBug284850= ruleEmptyObjectBug284850 EOF
            {
             markComposite(elementTypeProvider.getEmptyObjectBug284850ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEmptyObjectBug284850=ruleEmptyObjectBug284850();

            state._fsp--;

             current =iv_ruleEmptyObjectBug284850; 
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
    // $ANTLR end "entryRuleEmptyObjectBug284850"


    // $ANTLR start "ruleEmptyObjectBug284850"
    // PsiInternalSimpleReconstrTestLanguage.g:1623:1: ruleEmptyObjectBug284850 returns [Boolean current=false] : (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) ;
    public final Boolean ruleEmptyObjectBug284850() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_items_1_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1624:1: ( (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1625:2: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1625:2: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1626:3: otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) )
            {

            			markLeaf(elementTypeProvider.getEmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_38); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1633:3: ( (lv_items_1_0= ruleEmptyObjectItems ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1634:4: (lv_items_1_0= ruleEmptyObjectItems )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1634:4: (lv_items_1_0= ruleEmptyObjectItems )
            // PsiInternalSimpleReconstrTestLanguage.g:1635:5: lv_items_1_0= ruleEmptyObjectItems
            {

            					markComposite(elementTypeProvider.getEmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_items_1_0=ruleEmptyObjectItems();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmptyObjectBug284850"


    // $ANTLR start "entryRuleEmptyObjectItems"
    // PsiInternalSimpleReconstrTestLanguage.g:1652:1: entryRuleEmptyObjectItems returns [Boolean current=false] : iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF ;
    public final Boolean entryRuleEmptyObjectItems() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEmptyObjectItems = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1652:58: (iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1653:2: iv_ruleEmptyObjectItems= ruleEmptyObjectItems EOF
            {
             markComposite(elementTypeProvider.getEmptyObjectItemsElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEmptyObjectItems=ruleEmptyObjectItems();

            state._fsp--;

             current =iv_ruleEmptyObjectItems; 
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
    // $ANTLR end "entryRuleEmptyObjectItems"


    // $ANTLR start "ruleEmptyObjectItems"
    // PsiInternalSimpleReconstrTestLanguage.g:1659:1: ruleEmptyObjectItems returns [Boolean current=false] : ( (lv_list_0_0= ruleEmptyObjectItem ) )* ;
    public final Boolean ruleEmptyObjectItems() throws RecognitionException {
        Boolean current = false;

        Boolean lv_list_0_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1660:1: ( ( (lv_list_0_0= ruleEmptyObjectItem ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:1661:2: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1661:2: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==56) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:1662:3: (lv_list_0_0= ruleEmptyObjectItem )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:1662:3: (lv_list_0_0= ruleEmptyObjectItem )
            	    // PsiInternalSimpleReconstrTestLanguage.g:1663:4: lv_list_0_0= ruleEmptyObjectItem
            	    {

            	    				markComposite(elementTypeProvider.getEmptyObjectItems_ListEmptyObjectItemParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_39);
            	    lv_list_0_0=ruleEmptyObjectItem();

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
            	    break loop30;
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
    // $ANTLR end "ruleEmptyObjectItems"


    // $ANTLR start "entryRuleEmptyObjectItem"
    // PsiInternalSimpleReconstrTestLanguage.g:1679:1: entryRuleEmptyObjectItem returns [Boolean current=false] : iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF ;
    public final Boolean entryRuleEmptyObjectItem() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEmptyObjectItem = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1679:57: (iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1680:2: iv_ruleEmptyObjectItem= ruleEmptyObjectItem EOF
            {
             markComposite(elementTypeProvider.getEmptyObjectItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEmptyObjectItem=ruleEmptyObjectItem();

            state._fsp--;

             current =iv_ruleEmptyObjectItem; 
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
    // $ANTLR end "entryRuleEmptyObjectItem"


    // $ANTLR start "ruleEmptyObjectItem"
    // PsiInternalSimpleReconstrTestLanguage.g:1686:1: ruleEmptyObjectItem returns [Boolean current=false] : (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleEmptyObjectItem() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1687:1: ( (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1688:2: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1688:2: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1689:3: otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getEmptyObjectItem_ItemKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1696:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1697:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1697:4: (lv_name_1_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1698:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEmptyObjectItem_NameIDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_1_0);
            				

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
    // $ANTLR end "ruleEmptyObjectItem"


    // $ANTLR start "entryRuleMultiInheritanceBug280439"
    // PsiInternalSimpleReconstrTestLanguage.g:1717:1: entryRuleMultiInheritanceBug280439 returns [Boolean current=false] : iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF ;
    public final Boolean entryRuleMultiInheritanceBug280439() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiInheritanceBug280439 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1717:67: (iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1718:2: iv_ruleMultiInheritanceBug280439= ruleMultiInheritanceBug280439 EOF
            {
             markComposite(elementTypeProvider.getMultiInheritanceBug280439ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiInheritanceBug280439=ruleMultiInheritanceBug280439();

            state._fsp--;

             current =iv_ruleMultiInheritanceBug280439; 
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
    // $ANTLR end "entryRuleMultiInheritanceBug280439"


    // $ANTLR start "ruleMultiInheritanceBug280439"
    // PsiInternalSimpleReconstrTestLanguage.g:1724:1: ruleMultiInheritanceBug280439 returns [Boolean current=false] : (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) ;
    public final Boolean ruleMultiInheritanceBug280439() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean lv_val_1_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1725:1: ( (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1726:2: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1726:2: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1727:3: otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) )
            {

            			markLeaf(elementTypeProvider.getMultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1734:3: ( (lv_val_1_0= ruleConcreteMulti ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1735:4: (lv_val_1_0= ruleConcreteMulti )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1735:4: (lv_val_1_0= ruleConcreteMulti )
            // PsiInternalSimpleReconstrTestLanguage.g:1736:5: lv_val_1_0= ruleConcreteMulti
            {

            					markComposite(elementTypeProvider.getMultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_2);
            lv_val_1_0=ruleConcreteMulti();

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiInheritanceBug280439"


    // $ANTLR start "entryRuleConcreteMulti"
    // PsiInternalSimpleReconstrTestLanguage.g:1753:1: entryRuleConcreteMulti returns [Boolean current=false] : iv_ruleConcreteMulti= ruleConcreteMulti EOF ;
    public final Boolean entryRuleConcreteMulti() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleConcreteMulti = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1753:55: (iv_ruleConcreteMulti= ruleConcreteMulti EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1754:2: iv_ruleConcreteMulti= ruleConcreteMulti EOF
            {
             markComposite(elementTypeProvider.getConcreteMultiElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConcreteMulti=ruleConcreteMulti();

            state._fsp--;

             current =iv_ruleConcreteMulti; 
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
    // $ANTLR end "entryRuleConcreteMulti"


    // $ANTLR start "ruleConcreteMulti"
    // PsiInternalSimpleReconstrTestLanguage.g:1760:1: ruleConcreteMulti returns [Boolean current=false] : ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleConcreteMulti() throws RecognitionException {
        Boolean current = false;

        Token lv_m1_0_0=null;
        Token lv_m2_1_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1761:1: ( ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1762:2: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1762:2: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1763:3: ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1763:3: ( (lv_m1_0_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1764:4: (lv_m1_0_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1764:4: (lv_m1_0_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1765:5: lv_m1_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getConcreteMulti_M1IDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_m1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_m1_0_0);
            				

            }


            }

            // PsiInternalSimpleReconstrTestLanguage.g:1780:3: ( (lv_m2_1_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1781:4: (lv_m2_1_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1781:4: (lv_m2_1_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1782:5: lv_m2_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getConcreteMulti_M2IDTerminalRuleCall_1_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_m2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_m2_1_0);
            				

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
    // $ANTLR end "ruleConcreteMulti"


    // $ANTLR start "entryRuleEObjectRef"
    // PsiInternalSimpleReconstrTestLanguage.g:1801:1: entryRuleEObjectRef returns [Boolean current=false] : iv_ruleEObjectRef= ruleEObjectRef EOF ;
    public final Boolean entryRuleEObjectRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEObjectRef = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1801:52: (iv_ruleEObjectRef= ruleEObjectRef EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1802:2: iv_ruleEObjectRef= ruleEObjectRef EOF
            {
             markComposite(elementTypeProvider.getEObjectRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObjectRef=ruleEObjectRef();

            state._fsp--;

             current =iv_ruleEObjectRef; 
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
    // $ANTLR end "entryRuleEObjectRef"


    // $ANTLR start "ruleEObjectRef"
    // PsiInternalSimpleReconstrTestLanguage.g:1808:1: ruleEObjectRef returns [Boolean current=false] : (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) ;
    public final Boolean ruleEObjectRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Boolean lv_obj_1_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1809:1: ( (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1810:2: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1810:2: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1811:3: otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getEObjectRef_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1818:3: ( (lv_obj_1_0= ruleEObjectElement ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1819:4: (lv_obj_1_0= ruleEObjectElement )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1819:4: (lv_obj_1_0= ruleEObjectElement )
            // PsiInternalSimpleReconstrTestLanguage.g:1820:5: lv_obj_1_0= ruleEObjectElement
            {

            					markComposite(elementTypeProvider.getEObjectRef_ObjEObjectElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_40);
            lv_obj_1_0=ruleEObjectElement();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }


            			markLeaf(elementTypeProvider.getEObjectRef_RefsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,59,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1840:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1841:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1841:4: (otherlv_3= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1842:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getEObjectRef_RefEObjectCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_3);
            				

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
    // $ANTLR end "ruleEObjectRef"


    // $ANTLR start "entryRuleEObjectElement"
    // PsiInternalSimpleReconstrTestLanguage.g:1861:1: entryRuleEObjectElement returns [Boolean current=false] : iv_ruleEObjectElement= ruleEObjectElement EOF ;
    public final Boolean entryRuleEObjectElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleEObjectElement = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1861:56: (iv_ruleEObjectElement= ruleEObjectElement EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1862:2: iv_ruleEObjectElement= ruleEObjectElement EOF
            {
             markComposite(elementTypeProvider.getEObjectElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleEObjectElement=ruleEObjectElement();

            state._fsp--;

             current =iv_ruleEObjectElement; 
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
    // $ANTLR end "entryRuleEObjectElement"


    // $ANTLR start "ruleEObjectElement"
    // PsiInternalSimpleReconstrTestLanguage.g:1868:1: ruleEObjectElement returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleEObjectElement() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1869:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1870:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1870:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1871:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1871:3: (lv_name_0_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1872:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getEObjectElement_NameIDTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_name_0_0);
            			

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
    // $ANTLR end "ruleEObjectElement"


    // $ANTLR start "entryRuleTypeBug305577_1"
    // PsiInternalSimpleReconstrTestLanguage.g:1890:1: entryRuleTypeBug305577_1 returns [Boolean current=false] : iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF ;
    public final Boolean entryRuleTypeBug305577_1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeBug305577_1 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1890:57: (iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1891:2: iv_ruleTypeBug305577_1= ruleTypeBug305577_1 EOF
            {
             markComposite(elementTypeProvider.getTypeBug305577_1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug305577_1=ruleTypeBug305577_1();

            state._fsp--;

             current =iv_ruleTypeBug305577_1; 
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
    // $ANTLR end "entryRuleTypeBug305577_1"


    // $ANTLR start "ruleTypeBug305577_1"
    // PsiInternalSimpleReconstrTestLanguage.g:1897:1: ruleTypeBug305577_1 returns [Boolean current=false] : (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) ) ;
    public final Boolean ruleTypeBug305577_1() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_TypeBug1A_1 = null;

        Boolean this_TypeBug1B_2 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1898:1: ( (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1899:2: (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1899:2: (otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1900:3: otherlv_0= '#17' (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B )
            {

            			markLeaf(elementTypeProvider.getTypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_41); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1907:3: (this_TypeBug1A_1= ruleTypeBug1A | this_TypeBug1B_2= ruleTypeBug1B )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1908:4: this_TypeBug1A_1= ruleTypeBug1A
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_1_TypeBug1AParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug1A_1=ruleTypeBug1A();

                    state._fsp--;


                    				current = this_TypeBug1A_1;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1917:4: this_TypeBug1B_2= ruleTypeBug1B
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_1_TypeBug1BParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug1B_2=ruleTypeBug1B();

                    state._fsp--;


                    				current = this_TypeBug1B_2;
                    				doneComposite();
                    			

                    }
                    break;

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
    // $ANTLR end "ruleTypeBug305577_1"


    // $ANTLR start "entryRuleTypeBug305577_2"
    // PsiInternalSimpleReconstrTestLanguage.g:1930:1: entryRuleTypeBug305577_2 returns [Boolean current=false] : iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF ;
    public final Boolean entryRuleTypeBug305577_2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeBug305577_2 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1930:57: (iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1931:2: iv_ruleTypeBug305577_2= ruleTypeBug305577_2 EOF
            {
             markComposite(elementTypeProvider.getTypeBug305577_2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug305577_2=ruleTypeBug305577_2();

            state._fsp--;

             current =iv_ruleTypeBug305577_2; 
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
    // $ANTLR end "entryRuleTypeBug305577_2"


    // $ANTLR start "ruleTypeBug305577_2"
    // PsiInternalSimpleReconstrTestLanguage.g:1937:1: ruleTypeBug305577_2 returns [Boolean current=false] : (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) ) ;
    public final Boolean ruleTypeBug305577_2() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Boolean this_TypeBug2B_1 = null;

        Boolean this_TypeBug2A_2 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1938:1: ( (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1939:2: (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1939:2: (otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1940:3: otherlv_0= '#18' (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A )
            {

            			markLeaf(elementTypeProvider.getTypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_41); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1947:3: (this_TypeBug2B_1= ruleTypeBug2B | this_TypeBug2A_2= ruleTypeBug2A )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:1948:4: this_TypeBug2B_1= ruleTypeBug2B
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_2_TypeBug2BParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug2B_1=ruleTypeBug2B();

                    state._fsp--;


                    				current = this_TypeBug2B_1;
                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:1957:4: this_TypeBug2A_2= ruleTypeBug2A
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_2_TypeBug2AParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TypeBug2A_2=ruleTypeBug2A();

                    state._fsp--;


                    				current = this_TypeBug2A_2;
                    				doneComposite();
                    			

                    }
                    break;

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
    // $ANTLR end "ruleTypeBug305577_2"


    // $ANTLR start "entryRuleTypeBug1A"
    // PsiInternalSimpleReconstrTestLanguage.g:1970:1: entryRuleTypeBug1A returns [Boolean current=false] : iv_ruleTypeBug1A= ruleTypeBug1A EOF ;
    public final Boolean entryRuleTypeBug1A() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeBug1A = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1970:51: (iv_ruleTypeBug1A= ruleTypeBug1A EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:1971:2: iv_ruleTypeBug1A= ruleTypeBug1A EOF
            {
             markComposite(elementTypeProvider.getTypeBug1AElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug1A=ruleTypeBug1A();

            state._fsp--;

             current =iv_ruleTypeBug1A; 
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
    // $ANTLR end "entryRuleTypeBug1A"


    // $ANTLR start "ruleTypeBug1A"
    // PsiInternalSimpleReconstrTestLanguage.g:1977:1: ruleTypeBug1A returns [Boolean current=false] : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleTypeBug1A() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:1978:1: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1979:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1979:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1980:3: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1980:3: ()
            // PsiInternalSimpleReconstrTestLanguage.g:1981:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug1A_TypeBug1AAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTypeBug1A_KaKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:1994:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:1995:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:1995:4: (lv_name_2_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:1996:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeBug1A_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_2_0);
            				

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
    // $ANTLR end "ruleTypeBug1A"


    // $ANTLR start "entryRuleTypeBug1B"
    // PsiInternalSimpleReconstrTestLanguage.g:2015:1: entryRuleTypeBug1B returns [Boolean current=false] : iv_ruleTypeBug1B= ruleTypeBug1B EOF ;
    public final Boolean entryRuleTypeBug1B() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeBug1B = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2015:51: (iv_ruleTypeBug1B= ruleTypeBug1B EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2016:2: iv_ruleTypeBug1B= ruleTypeBug1B EOF
            {
             markComposite(elementTypeProvider.getTypeBug1BElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug1B=ruleTypeBug1B();

            state._fsp--;

             current =iv_ruleTypeBug1B; 
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
    // $ANTLR end "entryRuleTypeBug1B"


    // $ANTLR start "ruleTypeBug1B"
    // PsiInternalSimpleReconstrTestLanguage.g:2022:1: ruleTypeBug1B returns [Boolean current=false] : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleTypeBug1B() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2023:1: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2024:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2024:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2025:3: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2025:3: ()
            // PsiInternalSimpleReconstrTestLanguage.g:2026:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug1B_TypeBug1BAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTypeBug1B_KbKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2039:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2040:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2040:4: (lv_name_2_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:2041:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeBug1B_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_2_0);
            				

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
    // $ANTLR end "ruleTypeBug1B"


    // $ANTLR start "entryRuleTypeBug2A"
    // PsiInternalSimpleReconstrTestLanguage.g:2060:1: entryRuleTypeBug2A returns [Boolean current=false] : iv_ruleTypeBug2A= ruleTypeBug2A EOF ;
    public final Boolean entryRuleTypeBug2A() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeBug2A = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2060:51: (iv_ruleTypeBug2A= ruleTypeBug2A EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2061:2: iv_ruleTypeBug2A= ruleTypeBug2A EOF
            {
             markComposite(elementTypeProvider.getTypeBug2AElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug2A=ruleTypeBug2A();

            state._fsp--;

             current =iv_ruleTypeBug2A; 
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
    // $ANTLR end "entryRuleTypeBug2A"


    // $ANTLR start "ruleTypeBug2A"
    // PsiInternalSimpleReconstrTestLanguage.g:2067:1: ruleTypeBug2A returns [Boolean current=false] : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleTypeBug2A() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2068:1: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2069:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2069:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2070:3: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2070:3: ()
            // PsiInternalSimpleReconstrTestLanguage.g:2071:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug2A_TypeBug2AAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTypeBug2A_KaKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2084:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2085:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2085:4: (lv_name_2_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:2086:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeBug2A_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_2_0);
            				

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
    // $ANTLR end "ruleTypeBug2A"


    // $ANTLR start "entryRuleTypeBug2B"
    // PsiInternalSimpleReconstrTestLanguage.g:2105:1: entryRuleTypeBug2B returns [Boolean current=false] : iv_ruleTypeBug2B= ruleTypeBug2B EOF ;
    public final Boolean entryRuleTypeBug2B() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleTypeBug2B = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2105:51: (iv_ruleTypeBug2B= ruleTypeBug2B EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2106:2: iv_ruleTypeBug2B= ruleTypeBug2B EOF
            {
             markComposite(elementTypeProvider.getTypeBug2BElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeBug2B=ruleTypeBug2B();

            state._fsp--;

             current =iv_ruleTypeBug2B; 
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
    // $ANTLR end "entryRuleTypeBug2B"


    // $ANTLR start "ruleTypeBug2B"
    // PsiInternalSimpleReconstrTestLanguage.g:2112:1: ruleTypeBug2B returns [Boolean current=false] : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final Boolean ruleTypeBug2B() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2113:1: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2114:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2114:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2115:3: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2115:3: ()
            // PsiInternalSimpleReconstrTestLanguage.g:2116:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug2B_TypeBug2BAction_0ElementType());
            				doneComposite();
            				associateWithSemanticElement();
            			

            }


            			markLeaf(elementTypeProvider.getTypeBug2B_KbKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_10); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2129:3: ( (lv_name_2_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2130:4: (lv_name_2_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2130:4: (lv_name_2_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:2131:5: lv_name_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getTypeBug2B_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_2_0);
            				

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
    // $ANTLR end "ruleTypeBug2B"


    // $ANTLR start "entryRuleBug305171"
    // PsiInternalSimpleReconstrTestLanguage.g:2150:1: entryRuleBug305171 returns [Boolean current=false] : iv_ruleBug305171= ruleBug305171 EOF ;
    public final Boolean entryRuleBug305171() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBug305171 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2150:51: (iv_ruleBug305171= ruleBug305171 EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2151:2: iv_ruleBug305171= ruleBug305171 EOF
            {
             markComposite(elementTypeProvider.getBug305171ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug305171=ruleBug305171();

            state._fsp--;

             current =iv_ruleBug305171; 
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
    // $ANTLR end "entryRuleBug305171"


    // $ANTLR start "ruleBug305171"
    // PsiInternalSimpleReconstrTestLanguage.g:2157:1: ruleBug305171 returns [Boolean current=false] : (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) ;
    public final Boolean ruleBug305171() throws RecognitionException {
        Boolean current = false;

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

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2158:1: ( (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2159:2: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2159:2: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2160:3: otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getBug305171_NumberSignDigitOneDigitNineKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,64,FollowSets000.FOLLOW_42); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2167:3: ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2168:4: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2168:4: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==65) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:2169:5: otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    {

                    					markLeaf(elementTypeProvider.getBug305171_KxKeyword_1_0_0ElementType());
                    				
                    otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_10); 

                    					doneLeaf(otherlv_1);
                    				
                    // PsiInternalSimpleReconstrTestLanguage.g:2176:5: ( (lv_x_2_0= RULE_ID ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:2177:6: (lv_x_2_0= RULE_ID )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:2177:6: (lv_x_2_0= RULE_ID )
                    // PsiInternalSimpleReconstrTestLanguage.g:2178:7: lv_x_2_0= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getBug305171_XIDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						
                    lv_x_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

                    							doneLeaf(lv_x_2_0);
                    						

                    }


                    }

                    // PsiInternalSimpleReconstrTestLanguage.g:2193:5: (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==30) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2194:6: otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) )
                    	    {

                    	    						markLeaf(elementTypeProvider.getBug305171_CommaKeyword_1_0_2_0ElementType());
                    	    					
                    	    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_10); 

                    	    						doneLeaf(otherlv_3);
                    	    					
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2201:6: ( (lv_x_4_0= RULE_ID ) )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2202:7: (lv_x_4_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2202:7: (lv_x_4_0= RULE_ID )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2203:8: lv_x_4_0= RULE_ID
                    	    {

                    	    								markLeaf(elementTypeProvider.getBug305171_XIDTerminalRuleCall_1_0_2_1_0ElementType());
                    	    							

                    	    								if(!current) {
                    	    									associateWithSemanticElement();
                    	    									current = true;
                    	    								}
                    	    							
                    	    lv_x_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_43); 

                    	    								doneLeaf(lv_x_4_0);
                    	    							

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

            // PsiInternalSimpleReconstrTestLanguage.g:2220:4: ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            // PsiInternalSimpleReconstrTestLanguage.g:2221:5: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2221:5: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==66) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:2222:6: otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    {

                    						markLeaf(elementTypeProvider.getBug305171_KyKeyword_1_1_0_0ElementType());
                    					
                    otherlv_5=(Token)match(input,66,FollowSets000.FOLLOW_10); 

                    						doneLeaf(otherlv_5);
                    					
                    // PsiInternalSimpleReconstrTestLanguage.g:2229:6: ( (lv_y_6_0= RULE_ID ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:2230:7: (lv_y_6_0= RULE_ID )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:2230:7: (lv_y_6_0= RULE_ID )
                    // PsiInternalSimpleReconstrTestLanguage.g:2231:8: lv_y_6_0= RULE_ID
                    {

                    								markLeaf(elementTypeProvider.getBug305171_YIDTerminalRuleCall_1_1_0_1_0ElementType());
                    							

                    								if(!current) {
                    									associateWithSemanticElement();
                    									current = true;
                    								}
                    							
                    lv_y_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); 

                    								doneLeaf(lv_y_6_0);
                    							

                    }


                    }

                    // PsiInternalSimpleReconstrTestLanguage.g:2246:6: (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==30) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2247:7: otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) )
                    	    {

                    	    							markLeaf(elementTypeProvider.getBug305171_CommaKeyword_1_1_0_2_0ElementType());
                    	    						
                    	    otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_10); 

                    	    							doneLeaf(otherlv_7);
                    	    						
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2254:7: ( (lv_y_8_0= RULE_ID ) )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2255:8: (lv_y_8_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2255:8: (lv_y_8_0= RULE_ID )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2256:9: lv_y_8_0= RULE_ID
                    	    {

                    	    									markLeaf(elementTypeProvider.getBug305171_YIDTerminalRuleCall_1_1_0_2_1_0ElementType());
                    	    								

                    	    									if(!current) {
                    	    										associateWithSemanticElement();
                    	    										current = true;
                    	    									}
                    	    								
                    	    lv_y_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_44); 

                    	    									doneLeaf(lv_y_8_0);
                    	    								

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

            // PsiInternalSimpleReconstrTestLanguage.g:2273:5: (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==67) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalSimpleReconstrTestLanguage.g:2274:6: otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    {

                    						markLeaf(elementTypeProvider.getBug305171_KzKeyword_1_1_1_0ElementType());
                    					
                    otherlv_9=(Token)match(input,67,FollowSets000.FOLLOW_10); 

                    						doneLeaf(otherlv_9);
                    					
                    // PsiInternalSimpleReconstrTestLanguage.g:2281:6: ( (lv_z_10_0= RULE_ID ) )
                    // PsiInternalSimpleReconstrTestLanguage.g:2282:7: (lv_z_10_0= RULE_ID )
                    {
                    // PsiInternalSimpleReconstrTestLanguage.g:2282:7: (lv_z_10_0= RULE_ID )
                    // PsiInternalSimpleReconstrTestLanguage.g:2283:8: lv_z_10_0= RULE_ID
                    {

                    								markLeaf(elementTypeProvider.getBug305171_ZIDTerminalRuleCall_1_1_1_1_0ElementType());
                    							

                    								if(!current) {
                    									associateWithSemanticElement();
                    									current = true;
                    								}
                    							
                    lv_z_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); 

                    								doneLeaf(lv_z_10_0);
                    							

                    }


                    }

                    // PsiInternalSimpleReconstrTestLanguage.g:2298:6: (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==30) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2299:7: otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) )
                    	    {

                    	    							markLeaf(elementTypeProvider.getBug305171_CommaKeyword_1_1_1_2_0ElementType());
                    	    						
                    	    otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_10); 

                    	    							doneLeaf(otherlv_11);
                    	    						
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2306:7: ( (lv_z_12_0= RULE_ID ) )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2307:8: (lv_z_12_0= RULE_ID )
                    	    {
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2307:8: (lv_z_12_0= RULE_ID )
                    	    // PsiInternalSimpleReconstrTestLanguage.g:2308:9: lv_z_12_0= RULE_ID
                    	    {

                    	    									markLeaf(elementTypeProvider.getBug305171_ZIDTerminalRuleCall_1_1_1_2_1_0ElementType());
                    	    								

                    	    									if(!current) {
                    	    										associateWithSemanticElement();
                    	    										current = true;
                    	    									}
                    	    								
                    	    lv_z_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_45); 

                    	    									doneLeaf(lv_z_12_0);
                    	    								

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

            // PsiInternalSimpleReconstrTestLanguage.g:2327:3: ( (lv_name_13_0= RULE_ID ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2328:4: (lv_name_13_0= RULE_ID )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2328:4: (lv_name_13_0= RULE_ID )
            // PsiInternalSimpleReconstrTestLanguage.g:2329:5: lv_name_13_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBug305171_NameIDTerminalRuleCall_2_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_name_13_0);
            				

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
    // $ANTLR end "ruleBug305171"


    // $ANTLR start "entryRuleBug310435Enum"
    // PsiInternalSimpleReconstrTestLanguage.g:2348:1: entryRuleBug310435Enum returns [Boolean current=false] : iv_ruleBug310435Enum= ruleBug310435Enum EOF ;
    public final Boolean entryRuleBug310435Enum() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBug310435Enum = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2348:55: (iv_ruleBug310435Enum= ruleBug310435Enum EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2349:2: iv_ruleBug310435Enum= ruleBug310435Enum EOF
            {
             markComposite(elementTypeProvider.getBug310435EnumElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug310435Enum=ruleBug310435Enum();

            state._fsp--;

             current =iv_ruleBug310435Enum; 
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
    // $ANTLR end "entryRuleBug310435Enum"


    // $ANTLR start "ruleBug310435Enum"
    // PsiInternalSimpleReconstrTestLanguage.g:2355:1: ruleBug310435Enum returns [Boolean current=false] : (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) ;
    public final Boolean ruleBug310435Enum() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Boolean lv_lits_2_0 = null;

        Boolean lv_lits_4_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2356:1: ( (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2357:2: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2357:2: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:2358:3: otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getBug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,68,FollowSets000.FOLLOW_46); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2365:3: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:2366:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2366:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2367:5: otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    {

            	    					markLeaf(elementTypeProvider.getBug310435Enum_Kw1Keyword_1_0_0ElementType());
            	    				
            	    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_47); 

            	    					doneLeaf(otherlv_1);
            	    				
            	    // PsiInternalSimpleReconstrTestLanguage.g:2374:5: ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2375:6: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2375:6: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2376:7: lv_lits_2_0= ruleEnumBug310435Lit1
            	    {

            	    							markComposite(elementTypeProvider.getBug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_46);
            	    lv_lits_2_0=ruleEnumBug310435Lit1();

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
            	    break;
            	case 2 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:2391:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2391:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2392:5: otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    {

            	    					markLeaf(elementTypeProvider.getBug310435Enum_Kw2Keyword_1_1_0ElementType());
            	    				
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_48); 

            	    					doneLeaf(otherlv_3);
            	    				
            	    // PsiInternalSimpleReconstrTestLanguage.g:2399:5: ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2400:6: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2400:6: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2401:7: lv_lits_4_0= ruleEnumBug310435Lit2
            	    {

            	    							markComposite(elementTypeProvider.getBug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_46);
            	    lv_lits_4_0=ruleEnumBug310435Lit2();

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
            	    break;

            	default :
            	    break loop39;
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
    // $ANTLR end "ruleBug310435Enum"


    // $ANTLR start "entryRuleBug310435Val"
    // PsiInternalSimpleReconstrTestLanguage.g:2420:1: entryRuleBug310435Val returns [Boolean current=false] : iv_ruleBug310435Val= ruleBug310435Val EOF ;
    public final Boolean entryRuleBug310435Val() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleBug310435Val = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2420:54: (iv_ruleBug310435Val= ruleBug310435Val EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2421:2: iv_ruleBug310435Val= ruleBug310435Val EOF
            {
             markComposite(elementTypeProvider.getBug310435ValElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleBug310435Val=ruleBug310435Val();

            state._fsp--;

             current =iv_ruleBug310435Val; 
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
    // $ANTLR end "entryRuleBug310435Val"


    // $ANTLR start "ruleBug310435Val"
    // PsiInternalSimpleReconstrTestLanguage.g:2427:1: ruleBug310435Val returns [Boolean current=false] : (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) ;
    public final Boolean ruleBug310435Val() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_lits_2_0=null;
        Token otherlv_3=null;
        Token lv_lits_4_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2428:1: ( (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2429:2: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2429:2: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:2430:3: otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getBug310435Val_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,69,FollowSets000.FOLLOW_46); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2437:3: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:2438:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2438:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2439:5: otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) )
            	    {

            	    					markLeaf(elementTypeProvider.getBug310435Val_Kw1Keyword_1_0_0ElementType());
            	    				
            	    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_10); 

            	    					doneLeaf(otherlv_1);
            	    				
            	    // PsiInternalSimpleReconstrTestLanguage.g:2446:5: ( (lv_lits_2_0= RULE_ID ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2447:6: (lv_lits_2_0= RULE_ID )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2447:6: (lv_lits_2_0= RULE_ID )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2448:7: lv_lits_2_0= RULE_ID
            	    {

            	    							markLeaf(elementTypeProvider.getBug310435Val_LitsIDTerminalRuleCall_1_0_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_lits_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); 

            	    							doneLeaf(lv_lits_2_0);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:2465:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2465:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2466:5: otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) )
            	    {

            	    					markLeaf(elementTypeProvider.getBug310435Val_Kw2Keyword_1_1_0ElementType());
            	    				
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_9); 

            	    					doneLeaf(otherlv_3);
            	    				
            	    // PsiInternalSimpleReconstrTestLanguage.g:2473:5: ( (lv_lits_4_0= RULE_STRING ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2474:6: (lv_lits_4_0= RULE_STRING )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2474:6: (lv_lits_4_0= RULE_STRING )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2475:7: lv_lits_4_0= RULE_STRING
            	    {

            	    							markLeaf(elementTypeProvider.getBug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0ElementType());
            	    						

            	    							if(!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						
            	    lv_lits_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_46); 

            	    							doneLeaf(lv_lits_4_0);
            	    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBug310435Val"


    // $ANTLR start "entryRuleCrossRefNameTest"
    // PsiInternalSimpleReconstrTestLanguage.g:2496:1: entryRuleCrossRefNameTest returns [Boolean current=false] : iv_ruleCrossRefNameTest= ruleCrossRefNameTest EOF ;
    public final Boolean entryRuleCrossRefNameTest() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossRefNameTest = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2496:58: (iv_ruleCrossRefNameTest= ruleCrossRefNameTest EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2497:2: iv_ruleCrossRefNameTest= ruleCrossRefNameTest EOF
            {
             markComposite(elementTypeProvider.getCrossRefNameTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossRefNameTest=ruleCrossRefNameTest();

            state._fsp--;

             current =iv_ruleCrossRefNameTest; 
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
    // $ANTLR end "entryRuleCrossRefNameTest"


    // $ANTLR start "ruleCrossRefNameTest"
    // PsiInternalSimpleReconstrTestLanguage.g:2503:1: ruleCrossRefNameTest returns [Boolean current=false] : (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* ) ;
    public final Boolean ruleCrossRefNameTest() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Boolean lv_named_1_0 = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2504:1: ( (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2505:2: (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2505:2: (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* )
            // PsiInternalSimpleReconstrTestLanguage.g:2506:3: otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )*
            {

            			markLeaf(elementTypeProvider.getCrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_49); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2513:3: ( (lv_named_1_0= ruleCrossRefNamed ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_ID1 && LA41_0<=RULE_ID2)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:2514:4: (lv_named_1_0= ruleCrossRefNamed )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2514:4: (lv_named_1_0= ruleCrossRefNamed )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2515:5: lv_named_1_0= ruleCrossRefNamed
            	    {

            	    					markComposite(elementTypeProvider.getCrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_49);
            	    lv_named_1_0=ruleCrossRefNamed();

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
            	    break loop41;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getCrossRefNameTest_Kw1Keyword_2ElementType());
            		
            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_50); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalSimpleReconstrTestLanguage.g:2535:3: ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )*
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
            	    // PsiInternalSimpleReconstrTestLanguage.g:2536:4: (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2536:4: (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2537:5: otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) )
            	    {

            	    					markLeaf(elementTypeProvider.getCrossRefNameTest_Kw2Keyword_3_0_0ElementType());
            	    				
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_51); 

            	    					doneLeaf(otherlv_3);
            	    				
            	    // PsiInternalSimpleReconstrTestLanguage.g:2544:5: ( (otherlv_4= RULE_ID1 ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2545:6: (otherlv_4= RULE_ID1 )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2545:6: (otherlv_4= RULE_ID1 )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2546:7: otherlv_4= RULE_ID1
            	    {

            	    							if (!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

            	    							markLeaf(elementTypeProvider.getCrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0ElementType());
            	    						
            	    otherlv_4=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_50); 

            	    							doneLeaf(otherlv_4);
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalSimpleReconstrTestLanguage.g:2563:4: (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2563:4: (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2564:5: otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) )
            	    {

            	    					markLeaf(elementTypeProvider.getCrossRefNameTest_Kw3Keyword_3_1_0ElementType());
            	    				
            	    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_52); 

            	    					doneLeaf(otherlv_5);
            	    				
            	    // PsiInternalSimpleReconstrTestLanguage.g:2571:5: ( (otherlv_6= RULE_ID2 ) )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2572:6: (otherlv_6= RULE_ID2 )
            	    {
            	    // PsiInternalSimpleReconstrTestLanguage.g:2572:6: (otherlv_6= RULE_ID2 )
            	    // PsiInternalSimpleReconstrTestLanguage.g:2573:7: otherlv_6= RULE_ID2
            	    {

            	    							if (!current) {
            	    								associateWithSemanticElement();
            	    								current = true;
            	    							}
            	    						

            	    							markLeaf(elementTypeProvider.getCrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0ElementType());
            	    						
            	    otherlv_6=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_50); 

            	    							doneLeaf(otherlv_6);
            	    						

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

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCrossRefNameTest"


    // $ANTLR start "entryRuleCrossRefNamed"
    // PsiInternalSimpleReconstrTestLanguage.g:2594:1: entryRuleCrossRefNamed returns [Boolean current=false] : iv_ruleCrossRefNamed= ruleCrossRefNamed EOF ;
    public final Boolean entryRuleCrossRefNamed() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleCrossRefNamed = null;


        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2594:55: (iv_ruleCrossRefNamed= ruleCrossRefNamed EOF )
            // PsiInternalSimpleReconstrTestLanguage.g:2595:2: iv_ruleCrossRefNamed= ruleCrossRefNamed EOF
            {
             markComposite(elementTypeProvider.getCrossRefNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCrossRefNamed=ruleCrossRefNamed();

            state._fsp--;

             current =iv_ruleCrossRefNamed; 
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
    // $ANTLR end "entryRuleCrossRefNamed"


    // $ANTLR start "ruleCrossRefNamed"
    // PsiInternalSimpleReconstrTestLanguage.g:2601:1: ruleCrossRefNamed returns [Boolean current=false] : ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) ) ;
    public final Boolean ruleCrossRefNamed() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2602:1: ( ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2603:2: ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2603:2: ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2604:3: ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2604:3: ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2605:4: (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2605:4: (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 )
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
                    // PsiInternalSimpleReconstrTestLanguage.g:2606:5: lv_name_0_1= RULE_ID1
                    {

                    					markLeaf(elementTypeProvider.getCrossRefNamed_NameID1TerminalRuleCall_0_0ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_name_0_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_name_0_1);
                    				

                    }
                    break;
                case 2 :
                    // PsiInternalSimpleReconstrTestLanguage.g:2620:5: lv_name_0_2= RULE_ID2
                    {

                    					markLeaf(elementTypeProvider.getCrossRefNamed_NameID2TerminalRuleCall_0_1ElementType());
                    				

                    					if(!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				
                    lv_name_0_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_name_0_2);
                    				

                    }
                    break;

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
    // $ANTLR end "ruleCrossRefNamed"


    // $ANTLR start "ruleEnumBug310435Lit1"
    // PsiInternalSimpleReconstrTestLanguage.g:2639:1: ruleEnumBug310435Lit1 returns [Boolean current=false] : (enumLiteral_0= 'lit1' ) ;
    public final Boolean ruleEnumBug310435Lit1() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2640:1: ( (enumLiteral_0= 'lit1' ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2641:2: (enumLiteral_0= 'lit1' )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2641:2: (enumLiteral_0= 'lit1' )
            // PsiInternalSimpleReconstrTestLanguage.g:2642:3: enumLiteral_0= 'lit1'
            {

            			markLeaf(elementTypeProvider.getEnumBug310435Lit1_Lit1EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,71,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
    // $ANTLR end "ruleEnumBug310435Lit1"


    // $ANTLR start "ruleEnumBug310435Lit2"
    // PsiInternalSimpleReconstrTestLanguage.g:2653:1: ruleEnumBug310435Lit2 returns [Boolean current=false] : (enumLiteral_0= 'lit2' ) ;
    public final Boolean ruleEnumBug310435Lit2() throws RecognitionException {
        Boolean current = false;

        Token enumLiteral_0=null;

        try {
            // PsiInternalSimpleReconstrTestLanguage.g:2654:1: ( (enumLiteral_0= 'lit2' ) )
            // PsiInternalSimpleReconstrTestLanguage.g:2655:2: (enumLiteral_0= 'lit2' )
            {
            // PsiInternalSimpleReconstrTestLanguage.g:2655:2: (enumLiteral_0= 'lit2' )
            // PsiInternalSimpleReconstrTestLanguage.g:2656:3: enumLiteral_0= 'lit2'
            {

            			markLeaf(elementTypeProvider.getEnumBug310435Lit2_Lit2EnumLiteralDeclarationElementType());
            		
            enumLiteral_0=(Token)match(input,72,FollowSets000.FOLLOW_2); 

            			doneLeaf(enumLiteral_0);
            		

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
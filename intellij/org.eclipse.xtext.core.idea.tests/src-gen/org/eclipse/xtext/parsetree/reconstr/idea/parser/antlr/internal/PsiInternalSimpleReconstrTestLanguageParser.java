package org.eclipse.xtext.parsetree.reconstr.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:50:1: entryRuleOp : ruleOp EOF ;
    public final void entryRuleOp() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:50:12: ( ruleOp EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:51:2: ruleOp EOF
            {
             markComposite(elementTypeProvider.getOpElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_entryRuleOp54);
            ruleOp();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOp60); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleOp"


    // $ANTLR start "ruleOp"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:59:1: ruleOp : ( ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) ;
    public final void ruleOp() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:59:7: ( ( ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:60:2: ( ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:60:2: ( ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:61:3: ruleTerm ( () ( (lv_values_2_0= ruleTerm ) ) )*
            {

            			markComposite(elementTypeProvider.getOp_TermParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp81);
            ruleTerm();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:68:3: ( () ( (lv_values_2_0= ruleTerm ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==13||(LA1_0>=17 && LA1_0<=18)||LA1_0==20||LA1_0==23||LA1_0==25||LA1_0==28||LA1_0==31||(LA1_0>=34 && LA1_0<=38)||(LA1_0>=40 && LA1_0<=41)||LA1_0==46||LA1_0==48||LA1_0==51||LA1_0==55||(LA1_0>=57 && LA1_0<=58)||(LA1_0>=60 && LA1_0<=61)||LA1_0==64||(LA1_0>=68 && LA1_0<=70)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:69:4: () ( (lv_values_2_0= ruleTerm ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:69:4: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:70:5: 
            	    {

            	    					precedeComposite(elementTypeProvider.getOp_OpValuesAction_1_0ElementType());
            	    					doneComposite();
            	    				

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:75:4: ( (lv_values_2_0= ruleTerm ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:76:5: (lv_values_2_0= ruleTerm )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:76:5: (lv_values_2_0= ruleTerm )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:77:6: lv_values_2_0= ruleTerm
            	    {

            	    						markComposite(elementTypeProvider.getOp_ValuesTermParserRuleCall_1_1_0ElementType());
            	    					
            	    pushFollow(FollowSets000.FOLLOW_ruleTerm_in_ruleOp132);
            	    ruleTerm();

            	    state._fsp--;


            	    						doneComposite();
            	    					

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
        return ;
    }
    // $ANTLR end "ruleOp"


    // $ANTLR start "entryRuleTerm"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:91:1: entryRuleTerm : ruleTerm EOF ;
    public final void entryRuleTerm() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:91:14: ( ruleTerm EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:92:2: ruleTerm EOF
            {
             markComposite(elementTypeProvider.getTermElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTerm_in_entryRuleTerm171);
            ruleTerm();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTerm177); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:100:1: ruleTerm : ( ruleAtom | ruleTwoNumbers | ruleManyStrings | ruleType | ruleRef2 | ruleSpare | ruleBoolean | ruleTransient1 | ruleConsumed1 | ruleConsumed2 | ruleLoop1 | ruleLoop2 | ruleLoop3 | ruleLoop4 | ruleLoopBug285452 | ruleDuplicateBug284491 | ruleEmptyObjectBug284850 | ruleMultiInheritanceBug280439 | ruleEObjectRef | ruleTypeBug305577_1 | ruleTypeBug305577_2 | ruleParens | ruleBug305171 | ruleBug310435Val | ruleBug310435Enum | ruleCrossRefNameTest ) ;
    public final void ruleTerm() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:100:9: ( ( ruleAtom | ruleTwoNumbers | ruleManyStrings | ruleType | ruleRef2 | ruleSpare | ruleBoolean | ruleTransient1 | ruleConsumed1 | ruleConsumed2 | ruleLoop1 | ruleLoop2 | ruleLoop3 | ruleLoop4 | ruleLoopBug285452 | ruleDuplicateBug284491 | ruleEmptyObjectBug284850 | ruleMultiInheritanceBug280439 | ruleEObjectRef | ruleTypeBug305577_1 | ruleTypeBug305577_2 | ruleParens | ruleBug305171 | ruleBug310435Val | ruleBug310435Enum | ruleCrossRefNameTest ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:101:2: ( ruleAtom | ruleTwoNumbers | ruleManyStrings | ruleType | ruleRef2 | ruleSpare | ruleBoolean | ruleTransient1 | ruleConsumed1 | ruleConsumed2 | ruleLoop1 | ruleLoop2 | ruleLoop3 | ruleLoop4 | ruleLoopBug285452 | ruleDuplicateBug284491 | ruleEmptyObjectBug284850 | ruleMultiInheritanceBug280439 | ruleEObjectRef | ruleTypeBug305577_1 | ruleTypeBug305577_2 | ruleParens | ruleBug305171 | ruleBug310435Val | ruleBug310435Enum | ruleCrossRefNameTest )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:101:2: ( ruleAtom | ruleTwoNumbers | ruleManyStrings | ruleType | ruleRef2 | ruleSpare | ruleBoolean | ruleTransient1 | ruleConsumed1 | ruleConsumed2 | ruleLoop1 | ruleLoop2 | ruleLoop3 | ruleLoop4 | ruleLoopBug285452 | ruleDuplicateBug284491 | ruleEmptyObjectBug284850 | ruleMultiInheritanceBug280439 | ruleEObjectRef | ruleTypeBug305577_1 | ruleTypeBug305577_2 | ruleParens | ruleBug305171 | ruleBug310435Val | ruleBug310435Enum | ruleCrossRefNameTest )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:102:3: ruleAtom
                    {

                    			markComposite(elementTypeProvider.getTerm_AtomParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleAtom_in_ruleTerm198);
                    ruleAtom();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:110:3: ruleTwoNumbers
                    {

                    			markComposite(elementTypeProvider.getTerm_TwoNumbersParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTwoNumbers_in_ruleTerm218);
                    ruleTwoNumbers();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:118:3: ruleManyStrings
                    {

                    			markComposite(elementTypeProvider.getTerm_ManyStringsParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleManyStrings_in_ruleTerm238);
                    ruleManyStrings();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:126:3: ruleType
                    {

                    			markComposite(elementTypeProvider.getTerm_TypeParserRuleCall_3ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleTerm258);
                    ruleType();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:134:3: ruleRef2
                    {

                    			markComposite(elementTypeProvider.getTerm_Ref2ParserRuleCall_4ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleRef2_in_ruleTerm278);
                    ruleRef2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:142:3: ruleSpare
                    {

                    			markComposite(elementTypeProvider.getTerm_SpareParserRuleCall_5ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleSpare_in_ruleTerm298);
                    ruleSpare();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:150:3: ruleBoolean
                    {

                    			markComposite(elementTypeProvider.getTerm_BooleanParserRuleCall_6ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_ruleTerm318);
                    ruleBoolean();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:158:3: ruleTransient1
                    {

                    			markComposite(elementTypeProvider.getTerm_Transient1ParserRuleCall_7ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTransient1_in_ruleTerm338);
                    ruleTransient1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:166:3: ruleConsumed1
                    {

                    			markComposite(elementTypeProvider.getTerm_Consumed1ParserRuleCall_8ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleConsumed1_in_ruleTerm358);
                    ruleConsumed1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 10 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:174:3: ruleConsumed2
                    {

                    			markComposite(elementTypeProvider.getTerm_Consumed2ParserRuleCall_9ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleConsumed2_in_ruleTerm378);
                    ruleConsumed2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 11 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:182:3: ruleLoop1
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop1ParserRuleCall_10ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoop1_in_ruleTerm398);
                    ruleLoop1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 12 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:190:3: ruleLoop2
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop2ParserRuleCall_11ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoop2_in_ruleTerm418);
                    ruleLoop2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 13 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:198:3: ruleLoop3
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop3ParserRuleCall_12ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoop3_in_ruleTerm438);
                    ruleLoop3();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 14 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:206:3: ruleLoop4
                    {

                    			markComposite(elementTypeProvider.getTerm_Loop4ParserRuleCall_13ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoop4_in_ruleTerm458);
                    ruleLoop4();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 15 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:214:3: ruleLoopBug285452
                    {

                    			markComposite(elementTypeProvider.getTerm_LoopBug285452ParserRuleCall_14ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleLoopBug285452_in_ruleTerm478);
                    ruleLoopBug285452();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 16 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:222:3: ruleDuplicateBug284491
                    {

                    			markComposite(elementTypeProvider.getTerm_DuplicateBug284491ParserRuleCall_15ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleDuplicateBug284491_in_ruleTerm498);
                    ruleDuplicateBug284491();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 17 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:230:3: ruleEmptyObjectBug284850
                    {

                    			markComposite(elementTypeProvider.getTerm_EmptyObjectBug284850ParserRuleCall_16ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm518);
                    ruleEmptyObjectBug284850();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 18 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:238:3: ruleMultiInheritanceBug280439
                    {

                    			markComposite(elementTypeProvider.getTerm_MultiInheritanceBug280439ParserRuleCall_17ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm538);
                    ruleMultiInheritanceBug280439();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 19 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:246:3: ruleEObjectRef
                    {

                    			markComposite(elementTypeProvider.getTerm_EObjectRefParserRuleCall_18ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEObjectRef_in_ruleTerm558);
                    ruleEObjectRef();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 20 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:254:3: ruleTypeBug305577_1
                    {

                    			markComposite(elementTypeProvider.getTerm_TypeBug305577_1ParserRuleCall_19ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_1_in_ruleTerm578);
                    ruleTypeBug305577_1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 21 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:262:3: ruleTypeBug305577_2
                    {

                    			markComposite(elementTypeProvider.getTerm_TypeBug305577_2ParserRuleCall_20ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_2_in_ruleTerm598);
                    ruleTypeBug305577_2();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 22 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:270:3: ruleParens
                    {

                    			markComposite(elementTypeProvider.getTerm_ParensParserRuleCall_21ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleParens_in_ruleTerm618);
                    ruleParens();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 23 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:278:3: ruleBug305171
                    {

                    			markComposite(elementTypeProvider.getTerm_Bug305171ParserRuleCall_22ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleBug305171_in_ruleTerm638);
                    ruleBug305171();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 24 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:286:3: ruleBug310435Val
                    {

                    			markComposite(elementTypeProvider.getTerm_Bug310435ValParserRuleCall_23ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleBug310435Val_in_ruleTerm658);
                    ruleBug310435Val();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 25 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:294:3: ruleBug310435Enum
                    {

                    			markComposite(elementTypeProvider.getTerm_Bug310435EnumParserRuleCall_24ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleBug310435Enum_in_ruleTerm678);
                    ruleBug310435Enum();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 26 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:302:3: ruleCrossRefNameTest
                    {

                    			markComposite(elementTypeProvider.getTerm_CrossRefNameTestParserRuleCall_25ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleCrossRefNameTest_in_ruleTerm698);
                    ruleCrossRefNameTest();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleAtom"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:313:1: entryRuleAtom : ruleAtom EOF ;
    public final void entryRuleAtom() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:313:14: ( ruleAtom EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:314:2: ruleAtom EOF
            {
             markComposite(elementTypeProvider.getAtomElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAtom_in_entryRuleAtom718);
            ruleAtom();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAtom724); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleAtom"


    // $ANTLR start "ruleAtom"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:322:1: ruleAtom : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleAtom() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:322:9: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:323:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:323:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:324:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:324:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:325:4: lv_name_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAtom753); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getAtom_NameIDTerminalRuleCall_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleAtom"


    // $ANTLR start "entryRuleParens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:337:1: entryRuleParens : ruleParens EOF ;
    public final void entryRuleParens() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:337:16: ( ruleParens EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:338:2: ruleParens EOF
            {
             markComposite(elementTypeProvider.getParensElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleParens_in_entryRuleParens778);
            ruleParens();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParens784); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleParens"


    // $ANTLR start "ruleParens"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:346:1: ruleParens : (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) ;
    public final void ruleParens() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_em_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:346:11: ( (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:347:2: (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:347:2: (otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:348:3: otherlv_0= '(' ruleOp otherlv_2= ')' ( (lv_em_3_0= '!' ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleParens807); 

            			doneLeaf(otherlv_0, elementTypeProvider.getParens_LeftParenthesisKeyword_0ElementType());
            		

            			markComposite(elementTypeProvider.getParens_OpParserRuleCall_1ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleOp_in_ruleParens819);
            ruleOp();

            state._fsp--;


            			doneComposite();
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleParens833); 

            			doneLeaf(otherlv_2, elementTypeProvider.getParens_RightParenthesisKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:369:3: ( (lv_em_3_0= '!' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:370:4: (lv_em_3_0= '!' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:370:4: (lv_em_3_0= '!' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:371:5: lv_em_3_0= '!'
                    {

                    					markLeaf();
                    				
                    lv_em_3_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleParens860); 

                    					doneLeaf(lv_em_3_0, elementTypeProvider.getParens_EmExclamationMarkKeyword_3_0ElementType());
                    				

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
        return ;
    }
    // $ANTLR end "ruleParens"


    // $ANTLR start "entryRuleTwoNumbers"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:384:1: entryRuleTwoNumbers : ruleTwoNumbers EOF ;
    public final void entryRuleTwoNumbers() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:384:20: ( ruleTwoNumbers EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:385:2: ruleTwoNumbers EOF
            {
             markComposite(elementTypeProvider.getTwoNumbersElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers892);
            ruleTwoNumbers();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTwoNumbers898); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTwoNumbers"


    // $ANTLR start "ruleTwoNumbers"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:393:1: ruleTwoNumbers : ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) ;
    public final void ruleTwoNumbers() throws RecognitionException {
        Token lv_num1_0_0=null;
        Token lv_num2_1_0=null;
        Token otherlv_2=null;
        Token lv_num3_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:393:15: ( ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:394:2: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:394:2: ( ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:395:3: ( (lv_num1_0_0= RULE_INT ) ) ( (lv_num2_1_0= RULE_INT ) ) (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:395:3: ( (lv_num1_0_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:396:4: (lv_num1_0_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:396:4: (lv_num1_0_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:397:5: lv_num1_0_0= RULE_INT
            {

            					markLeaf();
            				
            lv_num1_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTwoNumbers934); 

            					doneLeaf(lv_num1_0_0, elementTypeProvider.getTwoNumbers_Num1INTTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:406:3: ( (lv_num2_1_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:407:4: (lv_num2_1_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:407:4: (lv_num2_1_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:408:5: lv_num2_1_0= RULE_INT
            {

            					markLeaf();
            				
            lv_num2_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTwoNumbers972); 

            					doneLeaf(lv_num2_1_0, elementTypeProvider.getTwoNumbers_Num2INTTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:417:3: (otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:418:4: otherlv_2= '#' ( (lv_num3_3_0= RULE_INT ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleTwoNumbers1003); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getTwoNumbers_NumberSignKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:425:4: ( (lv_num3_3_0= RULE_INT ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:426:5: (lv_num3_3_0= RULE_INT )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:426:5: (lv_num3_3_0= RULE_INT )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:427:6: lv_num3_3_0= RULE_INT
            	    {

            	    						markLeaf();
            	    					
            	    lv_num3_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTwoNumbers1035); 

            	    						doneLeaf(lv_num3_3_0, elementTypeProvider.getTwoNumbers_Num3INTTerminalRuleCall_2_1_0ElementType());
            	    					

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
        return ;
    }
    // $ANTLR end "ruleTwoNumbers"


    // $ANTLR start "entryRuleManyStrings"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:441:1: entryRuleManyStrings : ruleManyStrings EOF ;
    public final void entryRuleManyStrings() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:441:21: ( ruleManyStrings EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:442:2: ruleManyStrings EOF
            {
             markComposite(elementTypeProvider.getManyStringsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleManyStrings_in_entryRuleManyStrings1074);
            ruleManyStrings();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleManyStrings1080); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleManyStrings"


    // $ANTLR start "ruleManyStrings"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:450:1: ruleManyStrings : (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) ;
    public final void ruleManyStrings() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_str1_1_0=null;
        Token lv_str2_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:450:16: ( (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:451:2: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:451:2: (otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:452:3: otherlv_0= '=' ( (lv_str1_1_0= RULE_STRING ) )* ( (lv_str2_2_0= RULE_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleManyStrings1103); 

            			doneLeaf(otherlv_0, elementTypeProvider.getManyStrings_EqualsSignKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:459:3: ( (lv_str1_1_0= RULE_STRING ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:460:4: (lv_str1_1_0= RULE_STRING )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:460:4: (lv_str1_1_0= RULE_STRING )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:461:5: lv_str1_1_0= RULE_STRING
            	    {

            	    					markLeaf();
            	    				
            	    lv_str1_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleManyStrings1130); 

            	    					doneLeaf(lv_str1_1_0, elementTypeProvider.getManyStrings_Str1STRINGTerminalRuleCall_1_0ElementType());
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:470:3: ( (lv_str2_2_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:471:4: (lv_str2_2_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:471:4: (lv_str2_2_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:472:5: lv_str2_2_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_str2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleManyStrings1169); 

            					doneLeaf(lv_str2_2_0, elementTypeProvider.getManyStrings_Str2STRINGTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleManyStrings"


    // $ANTLR start "entryRuleType"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:485:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:485:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:486:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType1200);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType1206); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:494:1: ruleType : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) ;
    public final void ruleType() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:494:9: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:495:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:495:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:496:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleType1229); 

            			doneLeaf(otherlv_0, elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:503:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:504:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:504:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:505:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType1256); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleType1281); 

            			doneLeaf(otherlv_2, elementTypeProvider.getType_ExtendsKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:521:3: ( (otherlv_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:522:4: (otherlv_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:522:4: (otherlv_3= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:523:5: otherlv_3= RULE_ID
            {

            					markLeaf();
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType1308); 

            					doneLeaf(otherlv_3, elementTypeProvider.getType_ExtendsTypeCrossReference_3_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleRef2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:536:1: entryRuleRef2 : ruleRef2 EOF ;
    public final void entryRuleRef2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:536:14: ( ruleRef2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:537:2: ruleRef2 EOF
            {
             markComposite(elementTypeProvider.getRef2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleRef2_in_entryRuleRef21339);
            ruleRef2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRef21345); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleRef2"


    // $ANTLR start "ruleRef2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:545:1: ruleRef2 : (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) ;
    public final void ruleRef2() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_ref2_1_1=null;
        Token lv_ref2_1_2=null;
        Token lv_ref2_1_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:545:9: ( (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:546:2: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:546:2: (otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:547:3: otherlv_0= '#2' ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleRef21368); 

            			doneLeaf(otherlv_0, elementTypeProvider.getRef2_NumberSignDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:554:3: ( ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:555:4: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:555:4: ( (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:556:5: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:556:5: (lv_ref2_1_1= 'mykeyword1' | lv_ref2_1_2= RULE_STRING | lv_ref2_1_3= 'mykeyword2' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:557:6: lv_ref2_1_1= 'mykeyword1'
                    {

                    						markLeaf();
                    					
                    lv_ref2_1_1=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleRef21403); 

                    						doneLeaf(lv_ref2_1_1, elementTypeProvider.getRef2_Ref2Mykeyword1Keyword_1_0_0ElementType());
                    					

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:565:6: lv_ref2_1_2= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_ref2_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRef21437); 

                    						doneLeaf(lv_ref2_1_2, elementTypeProvider.getRef2_Ref2STRINGTerminalRuleCall_1_0_1ElementType());
                    					

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:573:6: lv_ref2_1_3= 'mykeyword2'
                    {

                    						markLeaf();
                    					
                    lv_ref2_1_3=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRef21471); 

                    						doneLeaf(lv_ref2_1_3, elementTypeProvider.getRef2_Ref2Mykeyword2Keyword_1_0_2ElementType());
                    					

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
        return ;
    }
    // $ANTLR end "ruleRef2"


    // $ANTLR start "entryRuleSpare"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:587:1: entryRuleSpare : ruleSpare EOF ;
    public final void entryRuleSpare() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:587:15: ( ruleSpare EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:588:2: ruleSpare EOF
            {
             markComposite(elementTypeProvider.getSpareElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpare_in_entryRuleSpare1509);
            ruleSpare();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpare1515); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleSpare"


    // $ANTLR start "ruleSpare"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:596:1: ruleSpare : (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) ;
    public final void ruleSpare() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_id_1_0=null;
        Token otherlv_2=null;
        Token lv_id_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:596:10: ( (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:597:2: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:597:2: (otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:598:3: otherlv_0= '#3' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSpare1538); 

            			doneLeaf(otherlv_0, elementTypeProvider.getSpare_NumberSignDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:605:3: ( (lv_id_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:606:4: (lv_id_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:606:4: (lv_id_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:607:5: lv_id_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpare1565); 

            					doneLeaf(lv_id_1_0, elementTypeProvider.getSpare_IdIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:616:3: (otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==24) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:617:4: otherlv_2= '.' ( (lv_id_3_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_2=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSpare1596); 

            	    				doneLeaf(otherlv_2, elementTypeProvider.getSpare_FullStopKeyword_2_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:624:4: ( (lv_id_3_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:625:5: (lv_id_3_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:625:5: (lv_id_3_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:626:6: lv_id_3_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpare1628); 

            	    						doneLeaf(lv_id_3_0, elementTypeProvider.getSpare_IdIDTerminalRuleCall_2_1_0ElementType());
            	    					

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
        return ;
    }
    // $ANTLR end "ruleSpare"


    // $ANTLR start "entryRuleBoolean"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:640:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:640:17: ( ruleBoolean EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:641:2: ruleBoolean EOF
            {
             markComposite(elementTypeProvider.getBooleanElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBoolean_in_entryRuleBoolean1667);
            ruleBoolean();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBoolean1673); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:649:1: ruleBoolean : (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) ;
    public final void ruleBoolean() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_bool_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:649:12: ( (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:650:2: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:650:2: (otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:651:3: otherlv_0= '#4' ( (lv_bool_1_0= 'myoption' ) )? otherlv_2= 'kw' ( (lv_value_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBoolean1696); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBoolean_NumberSignDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:658:3: ( (lv_bool_1_0= 'myoption' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==26) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:659:4: (lv_bool_1_0= 'myoption' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:659:4: (lv_bool_1_0= 'myoption' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:660:5: lv_bool_1_0= 'myoption'
                    {

                    					markLeaf();
                    				
                    lv_bool_1_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBoolean1723); 

                    					doneLeaf(lv_bool_1_0, elementTypeProvider.getBoolean_BoolMyoptionKeyword_1_0ElementType());
                    				

                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBoolean1749); 

            			doneLeaf(otherlv_2, elementTypeProvider.getBoolean_KwKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:676:3: ( (lv_value_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:677:4: (lv_value_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:677:4: (lv_value_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:678:5: lv_value_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_value_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBoolean1776); 

            					doneLeaf(lv_value_3_0, elementTypeProvider.getBoolean_ValueIDTerminalRuleCall_3_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleTransient1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:691:1: entryRuleTransient1 : ruleTransient1 EOF ;
    public final void entryRuleTransient1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:691:20: ( ruleTransient1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:692:2: ruleTransient1 EOF
            {
             markComposite(elementTypeProvider.getTransient1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransient1_in_entryRuleTransient11807);
            ruleTransient1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransient11813); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTransient1"


    // $ANTLR start "ruleTransient1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:700:1: ruleTransient1 : (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) ;
    public final void ruleTransient1() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_precStar_1_0=null;
        Token lv_prec_2_0=null;
        Token otherlv_3=null;
        Token lv_scaleStar_4_0=null;
        Token lv_scale_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:700:15: ( (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:701:2: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:701:2: (otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:702:3: otherlv_0= '#5' ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) ) (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleTransient11836); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTransient1_NumberSignDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:709:3: ( ( (lv_precStar_1_0= '*' ) ) | ( (lv_prec_2_0= RULE_INT ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:710:4: ( (lv_precStar_1_0= '*' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:710:4: ( (lv_precStar_1_0= '*' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:711:5: (lv_precStar_1_0= '*' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:711:5: (lv_precStar_1_0= '*' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:712:6: lv_precStar_1_0= '*'
                    {

                    						markLeaf();
                    					
                    lv_precStar_1_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTransient11871); 

                    						doneLeaf(lv_precStar_1_0, elementTypeProvider.getTransient1_PrecStarAsteriskKeyword_1_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:722:4: ( (lv_prec_2_0= RULE_INT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:722:4: ( (lv_prec_2_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:723:5: (lv_prec_2_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:723:5: (lv_prec_2_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:724:6: lv_prec_2_0= RULE_INT
                    {

                    						markLeaf();
                    					
                    lv_prec_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransient11925); 

                    						doneLeaf(lv_prec_2_0, elementTypeProvider.getTransient1_PrecINTTerminalRuleCall_1_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:734:3: (otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==30) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:735:4: otherlv_3= ',' ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTransient11963); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getTransient1_CommaKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:742:4: ( ( (lv_scaleStar_4_0= '*' ) ) | ( (lv_scale_5_0= RULE_INT ) ) )
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:743:5: ( (lv_scaleStar_4_0= '*' ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:743:5: ( (lv_scaleStar_4_0= '*' ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:744:6: (lv_scaleStar_4_0= '*' )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:744:6: (lv_scaleStar_4_0= '*' )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:745:7: lv_scaleStar_4_0= '*'
                            {

                            							markLeaf();
                            						
                            lv_scaleStar_4_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTransient12004); 

                            							doneLeaf(lv_scaleStar_4_0, elementTypeProvider.getTransient1_ScaleStarAsteriskKeyword_2_1_0_0ElementType());
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:755:5: ( (lv_scale_5_0= RULE_INT ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:755:5: ( (lv_scale_5_0= RULE_INT ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:756:6: (lv_scale_5_0= RULE_INT )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:756:6: (lv_scale_5_0= RULE_INT )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:757:7: lv_scale_5_0= RULE_INT
                            {

                            							markLeaf();
                            						
                            lv_scale_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTransient12066); 

                            							doneLeaf(lv_scale_5_0, elementTypeProvider.getTransient1_ScaleINTTerminalRuleCall_2_1_1_0ElementType());
                            						

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
        return ;
    }
    // $ANTLR end "ruleTransient1"


    // $ANTLR start "entryRuleConsumed1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:772:1: entryRuleConsumed1 : ruleConsumed1 EOF ;
    public final void entryRuleConsumed1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:772:19: ( ruleConsumed1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:773:2: ruleConsumed1 EOF
            {
             markComposite(elementTypeProvider.getConsumed1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConsumed1_in_entryRuleConsumed12113);
            ruleConsumed1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConsumed12119); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleConsumed1"


    // $ANTLR start "ruleConsumed1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:781:1: ruleConsumed1 : (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) ;
    public final void ruleConsumed1() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_v1_2_0=null;
        Token lv_v2_3_0=null;
        Token otherlv_4=null;
        Token lv_v2_5_0=null;
        Token lv_v1_6_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:781:14: ( (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:782:2: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:782:2: (otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:783:3: otherlv_0= '#6' ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleConsumed12142); 

            			doneLeaf(otherlv_0, elementTypeProvider.getConsumed1_NumberSignDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:790:3: ( (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) ) | (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:791:4: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:791:4: (otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:792:5: otherlv_1= 'v1' ( (lv_v1_2_0= RULE_INT ) )* ( (lv_v2_3_0= RULE_ID ) )
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleConsumed12169); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getConsumed1_V1Keyword_1_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:799:5: ( (lv_v1_2_0= RULE_INT ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_INT) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:800:6: (lv_v1_2_0= RULE_INT )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:800:6: (lv_v1_2_0= RULE_INT )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:801:7: lv_v1_2_0= RULE_INT
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_v1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleConsumed12206); 

                    	    							doneLeaf(lv_v1_2_0, elementTypeProvider.getConsumed1_V1INTTerminalRuleCall_1_0_1_0ElementType());
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:810:5: ( (lv_v2_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:811:6: (lv_v2_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:811:6: (lv_v2_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:812:7: lv_v2_3_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_v2_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConsumed12259); 

                    							doneLeaf(lv_v2_3_0, elementTypeProvider.getConsumed1_V2IDTerminalRuleCall_1_0_2_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:823:4: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:823:4: (otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:824:5: otherlv_4= 'v2' ( (lv_v2_5_0= RULE_ID ) )* ( (lv_v1_6_0= RULE_INT ) )
                    {

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleConsumed12313); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getConsumed1_V2Keyword_1_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:831:5: ( (lv_v2_5_0= RULE_ID ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:832:6: (lv_v2_5_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:832:6: (lv_v2_5_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:833:7: lv_v2_5_0= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    lv_v2_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConsumed12350); 

                    	    							doneLeaf(lv_v2_5_0, elementTypeProvider.getConsumed1_V2IDTerminalRuleCall_1_1_1_0ElementType());
                    	    						

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:842:5: ( (lv_v1_6_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:843:6: (lv_v1_6_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:843:6: (lv_v1_6_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:844:7: lv_v1_6_0= RULE_INT
                    {

                    							markLeaf();
                    						
                    lv_v1_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleConsumed12403); 

                    							doneLeaf(lv_v1_6_0, elementTypeProvider.getConsumed1_V1INTTerminalRuleCall_1_1_2_0ElementType());
                    						

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
        return ;
    }
    // $ANTLR end "ruleConsumed1"


    // $ANTLR start "entryRuleConsumed2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:859:1: entryRuleConsumed2 : ruleConsumed2 EOF ;
    public final void entryRuleConsumed2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:859:19: ( ruleConsumed2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:860:2: ruleConsumed2 EOF
            {
             markComposite(elementTypeProvider.getConsumed2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConsumed2_in_entryRuleConsumed22449);
            ruleConsumed2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConsumed22455); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleConsumed2"


    // $ANTLR start "ruleConsumed2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:868:1: ruleConsumed2 : (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) ;
    public final void ruleConsumed2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:868:14: ( (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:869:2: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:869:2: (otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:870:3: otherlv_0= '#7' ( (lv_child_1_0= ruleConsumed1 ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleConsumed22478); 

            			doneLeaf(otherlv_0, elementTypeProvider.getConsumed2_NumberSignDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:877:3: ( (lv_child_1_0= ruleConsumed1 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:878:4: (lv_child_1_0= ruleConsumed1 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:878:4: (lv_child_1_0= ruleConsumed1 )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:879:5: lv_child_1_0= ruleConsumed1
            {

            					markComposite(elementTypeProvider.getConsumed2_ChildConsumed1ParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleConsumed1_in_ruleConsumed22505);
            ruleConsumed1();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleConsumed2"


    // $ANTLR start "entryRuleLoop1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:892:1: entryRuleLoop1 : ruleLoop1 EOF ;
    public final void entryRuleLoop1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:892:15: ( ruleLoop1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:893:2: ruleLoop1 EOF
            {
             markComposite(elementTypeProvider.getLoop1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop1_in_entryRuleLoop12536);
            ruleLoop1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop12542); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleLoop1"


    // $ANTLR start "ruleLoop1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:901:1: ruleLoop1 : ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) ;
    public final void ruleLoop1() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:901:10: ( ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:902:2: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:902:2: ( (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:903:3: (otherlv_0= 'kw0' )? otherlv_1= '#8' ( (lv_id_2_0= RULE_ID ) ) (otherlv_3= 'kw1' )? ( (lv_id_4_0= RULE_ID ) ) ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:903:3: (otherlv_0= 'kw0' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:904:4: otherlv_0= 'kw0'
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLoop12571); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getLoop1_Kw0Keyword_0ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLoop12591); 

            			doneLeaf(otherlv_1, elementTypeProvider.getLoop1_NumberSignDigitEightKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:919:3: ( (lv_id_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:920:4: (lv_id_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:920:4: (lv_id_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:921:5: lv_id_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop12618); 

            					doneLeaf(lv_id_2_0, elementTypeProvider.getLoop1_IdIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:930:3: (otherlv_3= 'kw1' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:931:4: otherlv_3= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLoop12649); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getLoop1_Kw1Keyword_3ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:939:3: ( (lv_id_4_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:940:4: (lv_id_4_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:940:4: (lv_id_4_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:941:5: lv_id_4_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop12682); 

            					doneLeaf(lv_id_4_0, elementTypeProvider.getLoop1_IdIDTerminalRuleCall_4_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:950:3: ( (otherlv_5= 'kw2' )* otherlv_6= 'kw30' )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:951:4: (otherlv_5= 'kw2' )* otherlv_6= 'kw30'
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:951:4: (otherlv_5= 'kw2' )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==38) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:952:5: otherlv_5= 'kw2'
            	    	    {

            	    	    					markLeaf();
            	    	    				
            	    	    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLoop12720); 

            	    	    					doneLeaf(otherlv_5, elementTypeProvider.getLoop1_Kw2Keyword_5_0ElementType());
            	    	    				

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);


            	    				markLeaf();
            	    			
            	    otherlv_6=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLoop12744); 

            	    				doneLeaf(otherlv_6, elementTypeProvider.getLoop1_Kw30Keyword_5_1ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleLoop1"


    // $ANTLR start "entryRuleLoop2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:972:1: entryRuleLoop2 : ruleLoop2 EOF ;
    public final void entryRuleLoop2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:972:15: ( ruleLoop2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:973:2: ruleLoop2 EOF
            {
             markComposite(elementTypeProvider.getLoop2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop2_in_entryRuleLoop22770);
            ruleLoop2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop22776); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleLoop2"


    // $ANTLR start "ruleLoop2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:981:1: ruleLoop2 : (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) ;
    public final void ruleLoop2() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:981:10: ( (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:982:2: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:982:2: (otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:983:3: otherlv_0= '#9' ( (lv_id_1_0= RULE_ID ) ) (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) ) (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )? (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleLoop22799); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLoop2_NumberSignDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:990:3: ( (lv_id_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:991:4: (lv_id_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:991:4: (lv_id_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:992:5: lv_id_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop22826); 

            					doneLeaf(lv_id_1_0, elementTypeProvider.getLoop2_IdIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1001:3: (otherlv_2= 'kw1' | ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1002:4: otherlv_2= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLoop22857); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getLoop2_Kw1Keyword_2_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1010:4: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1010:4: ( ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1011:5: ( (lv_id_3_0= RULE_ID ) ) otherlv_4= 'kw2'
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1011:5: ( (lv_id_3_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1012:6: (lv_id_3_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1012:6: (lv_id_3_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1013:7: lv_id_3_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_id_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop22907); 

                    							doneLeaf(lv_id_3_0, elementTypeProvider.getLoop2_IdIDTerminalRuleCall_2_1_0_0ElementType());
                    						

                    }


                    }


                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLoop22942); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getLoop2_Kw2Keyword_2_1_1ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1031:3: (otherlv_5= 'kw3' | ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' ) )?
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1032:4: otherlv_5= 'kw3'
                    {

                    				markLeaf();
                    			
                    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLoop22973); 

                    				doneLeaf(otherlv_5, elementTypeProvider.getLoop2_Kw3Keyword_3_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1040:4: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1040:4: ( ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1041:5: ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw4'
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1041:5: ( (lv_id_6_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1042:6: (lv_id_6_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1042:6: (lv_id_6_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1043:7: lv_id_6_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop23023); 

                    							doneLeaf(lv_id_6_0, elementTypeProvider.getLoop2_IdIDTerminalRuleCall_3_1_0_0ElementType());
                    						

                    }


                    }


                    					markLeaf();
                    				
                    otherlv_7=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLoop23058); 

                    					doneLeaf(otherlv_7, elementTypeProvider.getLoop2_Kw4Keyword_3_1_1ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1061:3: (otherlv_8= 'kw5' | otherlv_9= 'kw6' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1062:4: otherlv_8= 'kw5'
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLoop23090); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getLoop2_Kw5Keyword_4_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1070:4: otherlv_9= 'kw6'
                    {

                    				markLeaf();
                    			
                    otherlv_9=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleLoop23116); 

                    				doneLeaf(otherlv_9, elementTypeProvider.getLoop2_Kw6Keyword_4_1ElementType());
                    			

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
        return ;
    }
    // $ANTLR end "ruleLoop2"


    // $ANTLR start "entryRuleLoop3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1082:1: entryRuleLoop3 : ruleLoop3 EOF ;
    public final void entryRuleLoop3() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1082:15: ( ruleLoop3 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1083:2: ruleLoop3 EOF
            {
             markComposite(elementTypeProvider.getLoop3ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop3_in_entryRuleLoop33141);
            ruleLoop3();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop33147); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleLoop3"


    // $ANTLR start "ruleLoop3"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1091:1: ruleLoop3 : ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) ;
    public final void ruleLoop3() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_id_4_0=null;
        Token otherlv_5=null;
        Token lv_id_6_0=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1091:10: ( ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1092:2: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1092:2: ( (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1093:3: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' ) otherlv_3= '#10' ( (lv_id_4_0= RULE_ID ) ) (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1093:3: (otherlv_0= 'kw1' | otherlv_1= 'kw2' | otherlv_2= 'kw3' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1094:4: otherlv_0= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLoop33176); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getLoop3_Kw1Keyword_0_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1102:4: otherlv_1= 'kw2'
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLoop33202); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getLoop3_Kw2Keyword_0_1ElementType());
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1110:4: otherlv_2= 'kw3'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLoop33228); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getLoop3_Kw3Keyword_0_2ElementType());
                    			

                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleLoop33247); 

            			doneLeaf(otherlv_3, elementTypeProvider.getLoop3_NumberSignDigitOneDigitZeroKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1125:3: ( (lv_id_4_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1126:4: (lv_id_4_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1126:4: (lv_id_4_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1127:5: lv_id_4_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop33274); 

            					doneLeaf(lv_id_4_0, elementTypeProvider.getLoop3_IdIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1136:3: (otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5' )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==42) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1137:4: otherlv_5= 'kw4' ( (lv_id_6_0= RULE_ID ) ) otherlv_7= 'kw5'
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_5=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLoop33305); 

            	    				doneLeaf(otherlv_5, elementTypeProvider.getLoop3_Kw4Keyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1144:4: ( (lv_id_6_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1145:5: (lv_id_6_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1145:5: (lv_id_6_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1146:6: lv_id_6_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_id_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop33337); 

            	    						doneLeaf(lv_id_6_0, elementTypeProvider.getLoop3_IdIDTerminalRuleCall_3_1_0ElementType());
            	    					

            	    }


            	    }


            	    				markLeaf();
            	    			
            	    otherlv_7=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLoop33367); 

            	    				doneLeaf(otherlv_7, elementTypeProvider.getLoop3_Kw5Keyword_3_2ElementType());
            	    			

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
        return ;
    }
    // $ANTLR end "ruleLoop3"


    // $ANTLR start "entryRuleLoop4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1167:1: entryRuleLoop4 : ruleLoop4 EOF ;
    public final void entryRuleLoop4() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1167:15: ( ruleLoop4 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1168:2: ruleLoop4 EOF
            {
             markComposite(elementTypeProvider.getLoop4ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoop4_in_entryRuleLoop43393);
            ruleLoop4();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoop43399); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleLoop4"


    // $ANTLR start "ruleLoop4"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1176:1: ruleLoop4 : (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) ;
    public final void ruleLoop4() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1176:10: ( (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1177:2: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1177:2: (otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+ )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1178:3: otherlv_0= '#11' (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) ) ( (lv_id_5_0= RULE_ID ) ) (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleLoop43422); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLoop4_NumberSignDigitOneDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1185:3: (otherlv_1= 'kw1' | otherlv_2= 'kw2' | (otherlv_3= 'kw3' otherlv_4= 'kw4' ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1186:4: otherlv_1= 'kw1'
                    {

                    				markLeaf();
                    			
                    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleLoop43442); 

                    				doneLeaf(otherlv_1, elementTypeProvider.getLoop4_Kw1Keyword_1_0ElementType());
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1194:4: otherlv_2= 'kw2'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleLoop43468); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getLoop4_Kw2Keyword_1_1ElementType());
                    			

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1202:4: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1202:4: (otherlv_3= 'kw3' otherlv_4= 'kw4' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1203:5: otherlv_3= 'kw3' otherlv_4= 'kw4'
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLoop43501); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getLoop4_Kw3Keyword_1_2_0ElementType());
                    				

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLoop43521); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getLoop4_Kw4Keyword_1_2_1ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1219:3: ( (lv_id_5_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1220:4: (lv_id_5_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1220:4: (lv_id_5_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1221:5: lv_id_5_0= RULE_ID
            {

            					markLeaf();
            				
            lv_id_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoop43559); 

            					doneLeaf(lv_id_5_0, elementTypeProvider.getLoop4_IdIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1230:3: (otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )? )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1231:4: otherlv_6= 'kw5' (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_6=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleLoop43590); 

            	    				doneLeaf(otherlv_6, elementTypeProvider.getLoop4_Kw5Keyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1238:4: (otherlv_7= 'kw6' (otherlv_8= 'kw7' )? )?
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==44) ) {
            	        alt26=1;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1239:5: otherlv_7= 'kw6' (otherlv_8= 'kw7' )?
            	            {

            	            					markLeaf();
            	            				
            	            otherlv_7=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleLoop43614); 

            	            					doneLeaf(otherlv_7, elementTypeProvider.getLoop4_Kw6Keyword_3_1_0ElementType());
            	            				
            	            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1246:5: (otherlv_8= 'kw7' )?
            	            int alt25=2;
            	            int LA25_0 = input.LA(1);

            	            if ( (LA25_0==47) ) {
            	                alt25=1;
            	            }
            	            switch (alt25) {
            	                case 1 :
            	                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1247:6: otherlv_8= 'kw7'
            	                    {

            	                    						markLeaf();
            	                    					
            	                    otherlv_8=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleLoop43642); 

            	                    						doneLeaf(otherlv_8, elementTypeProvider.getLoop4_Kw7Keyword_3_1_1ElementType());
            	                    					

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
        return ;
    }
    // $ANTLR end "ruleLoop4"


    // $ANTLR start "entryRuleLoopBug285452"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1261:1: entryRuleLoopBug285452 : ruleLoopBug285452 EOF ;
    public final void entryRuleLoopBug285452() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1261:23: ( ruleLoopBug285452 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1262:2: ruleLoopBug285452 EOF
            {
             markComposite(elementTypeProvider.getLoopBug285452ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523683);
            ruleLoopBug285452();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoopBug2854523689); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleLoopBug285452"


    // $ANTLR start "ruleLoopBug285452"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1270:1: ruleLoopBug285452 : (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final void ruleLoopBug285452() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_interface_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1270:18: ( (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1271:2: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1271:2: (otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1272:3: otherlv_0= '#12' ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' ) ( (lv_name_3_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleLoopBug2854523712); 

            			doneLeaf(otherlv_0, elementTypeProvider.getLoopBug285452_NumberSignDigitOneDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1279:3: ( ( (lv_interface_1_0= 'interface' ) ) | otherlv_2= 'class' )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1280:4: ( (lv_interface_1_0= 'interface' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1280:4: ( (lv_interface_1_0= 'interface' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1281:5: (lv_interface_1_0= 'interface' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1281:5: (lv_interface_1_0= 'interface' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1282:6: lv_interface_1_0= 'interface'
                    {

                    						markLeaf();
                    					
                    lv_interface_1_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleLoopBug2854523747); 

                    						doneLeaf(lv_interface_1_0, elementTypeProvider.getLoopBug285452_InterfaceInterfaceKeyword_1_0_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1292:4: otherlv_2= 'class'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleLoopBug2854523786); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getLoopBug285452_ClassKeyword_1_1ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1300:3: ( (lv_name_3_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1301:4: (lv_name_3_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1301:4: (lv_name_3_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1302:5: lv_name_3_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleLoopBug2854523818); 

            					doneLeaf(lv_name_3_0, elementTypeProvider.getLoopBug285452_NameIDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleLoopBug285452"


    // $ANTLR start "entryRuleDuplicateBug284491"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1315:1: entryRuleDuplicateBug284491 : ruleDuplicateBug284491 EOF ;
    public final void entryRuleDuplicateBug284491() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1315:28: ( ruleDuplicateBug284491 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1316:2: ruleDuplicateBug284491 EOF
            {
             markComposite(elementTypeProvider.getDuplicateBug284491ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913849);
            ruleDuplicateBug284491();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDuplicateBug2844913855); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleDuplicateBug284491"


    // $ANTLR start "ruleDuplicateBug284491"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1324:1: ruleDuplicateBug284491 : (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) ;
    public final void ruleDuplicateBug284491() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_final_2_0=null;
        Token lv_transient_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1324:23: ( (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1325:2: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1325:2: (otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1326:3: otherlv_0= '#13' ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleDuplicateBug2844913878); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1333:3: ( ( (lv_static_1_0= 'static' ) ) | ( (lv_final_2_0= 'final' ) ) | ( (lv_transient_3_0= 'transient' ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1334:4: ( (lv_static_1_0= 'static' ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1334:4: ( (lv_static_1_0= 'static' ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1335:5: (lv_static_1_0= 'static' )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1335:5: (lv_static_1_0= 'static' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1336:6: lv_static_1_0= 'static'
            	    {

            	    						markLeaf();
            	    					
            	    lv_static_1_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleDuplicateBug2844913913); 

            	    						doneLeaf(lv_static_1_0, elementTypeProvider.getDuplicateBug284491_StaticStaticKeyword_1_0_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1346:4: ( (lv_final_2_0= 'final' ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1346:4: ( (lv_final_2_0= 'final' ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1347:5: (lv_final_2_0= 'final' )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1347:5: (lv_final_2_0= 'final' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1348:6: lv_final_2_0= 'final'
            	    {

            	    						markLeaf();
            	    					
            	    lv_final_2_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleDuplicateBug2844913967); 

            	    						doneLeaf(lv_final_2_0, elementTypeProvider.getDuplicateBug284491_FinalFinalKeyword_1_1_0ElementType());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1358:4: ( (lv_transient_3_0= 'transient' ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1358:4: ( (lv_transient_3_0= 'transient' ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1359:5: (lv_transient_3_0= 'transient' )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1359:5: (lv_transient_3_0= 'transient' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1360:6: lv_transient_3_0= 'transient'
            	    {

            	    						markLeaf();
            	    					
            	    lv_transient_3_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleDuplicateBug2844914021); 

            	    						doneLeaf(lv_transient_3_0, elementTypeProvider.getDuplicateBug284491_TransientTransientKeyword_1_2_0ElementType());
            	    					

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
        return ;
    }
    // $ANTLR end "ruleDuplicateBug284491"


    // $ANTLR start "entryRuleEmptyObjectBug284850"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1374:1: entryRuleEmptyObjectBug284850 : ruleEmptyObjectBug284850 EOF ;
    public final void entryRuleEmptyObjectBug284850() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1374:30: ( ruleEmptyObjectBug284850 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1375:2: ruleEmptyObjectBug284850 EOF
            {
             markComposite(elementTypeProvider.getEmptyObjectBug284850ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848504060);
            ruleEmptyObjectBug284850();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmptyObjectBug2848504066); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleEmptyObjectBug284850"


    // $ANTLR start "ruleEmptyObjectBug284850"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1383:1: ruleEmptyObjectBug284850 : (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) ;
    public final void ruleEmptyObjectBug284850() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1383:25: ( (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1384:2: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1384:2: (otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1385:3: otherlv_0= '#14' ( (lv_items_1_0= ruleEmptyObjectItems ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleEmptyObjectBug2848504089); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1392:3: ( (lv_items_1_0= ruleEmptyObjectItems ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1393:4: (lv_items_1_0= ruleEmptyObjectItems )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1393:4: (lv_items_1_0= ruleEmptyObjectItems )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1394:5: lv_items_1_0= ruleEmptyObjectItems
            {

            					markComposite(elementTypeProvider.getEmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848504116);
            ruleEmptyObjectItems();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleEmptyObjectBug284850"


    // $ANTLR start "entryRuleEmptyObjectItems"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1407:1: entryRuleEmptyObjectItems : ruleEmptyObjectItems EOF ;
    public final void entryRuleEmptyObjectItems() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1407:26: ( ruleEmptyObjectItems EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1408:2: ruleEmptyObjectItems EOF
            {
             markComposite(elementTypeProvider.getEmptyObjectItemsElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems4147);
            ruleEmptyObjectItems();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmptyObjectItems4153); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleEmptyObjectItems"


    // $ANTLR start "ruleEmptyObjectItems"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1416:1: ruleEmptyObjectItems : ( (lv_list_0_0= ruleEmptyObjectItem ) )* ;
    public final void ruleEmptyObjectItems() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1416:21: ( ( (lv_list_0_0= ruleEmptyObjectItem ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1417:2: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1417:2: ( (lv_list_0_0= ruleEmptyObjectItem ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==56) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1418:3: (lv_list_0_0= ruleEmptyObjectItem )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1418:3: (lv_list_0_0= ruleEmptyObjectItem )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1419:4: lv_list_0_0= ruleEmptyObjectItem
            	    {

            	    				markComposite(elementTypeProvider.getEmptyObjectItems_ListEmptyObjectItemParserRuleCall_0ElementType());
            	    			
            	    pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems4182);
            	    ruleEmptyObjectItem();

            	    state._fsp--;


            	    				doneComposite();
            	    			

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
        return ;
    }
    // $ANTLR end "ruleEmptyObjectItems"


    // $ANTLR start "entryRuleEmptyObjectItem"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1431:1: entryRuleEmptyObjectItem : ruleEmptyObjectItem EOF ;
    public final void entryRuleEmptyObjectItem() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1431:25: ( ruleEmptyObjectItem EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1432:2: ruleEmptyObjectItem EOF
            {
             markComposite(elementTypeProvider.getEmptyObjectItemElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem4208);
            ruleEmptyObjectItem();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEmptyObjectItem4214); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleEmptyObjectItem"


    // $ANTLR start "ruleEmptyObjectItem"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1440:1: ruleEmptyObjectItem : (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleEmptyObjectItem() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1440:20: ( (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1441:2: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1441:2: (otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1442:3: otherlv_0= 'item' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleEmptyObjectItem4237); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEmptyObjectItem_ItemKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1449:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1450:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1450:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1451:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEmptyObjectItem4264); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEmptyObjectItem_NameIDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleEmptyObjectItem"


    // $ANTLR start "entryRuleMultiInheritanceBug280439"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1464:1: entryRuleMultiInheritanceBug280439 : ruleMultiInheritanceBug280439 EOF ;
    public final void entryRuleMultiInheritanceBug280439() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1464:35: ( ruleMultiInheritanceBug280439 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1465:2: ruleMultiInheritanceBug280439 EOF
            {
             markComposite(elementTypeProvider.getMultiInheritanceBug280439ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804394295);
            ruleMultiInheritanceBug280439();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804394301); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleMultiInheritanceBug280439"


    // $ANTLR start "ruleMultiInheritanceBug280439"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1473:1: ruleMultiInheritanceBug280439 : (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) ;
    public final void ruleMultiInheritanceBug280439() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1473:30: ( (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1474:2: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1474:2: (otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1475:3: otherlv_0= '#15' ( (lv_val_1_0= ruleConcreteMulti ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleMultiInheritanceBug2804394324); 

            			doneLeaf(otherlv_0, elementTypeProvider.getMultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1482:3: ( (lv_val_1_0= ruleConcreteMulti ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1483:4: (lv_val_1_0= ruleConcreteMulti )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1483:4: (lv_val_1_0= ruleConcreteMulti )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1484:5: lv_val_1_0= ruleConcreteMulti
            {

            					markComposite(elementTypeProvider.getMultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804394351);
            ruleConcreteMulti();

            state._fsp--;


            					doneComposite();
            				

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
        return ;
    }
    // $ANTLR end "ruleMultiInheritanceBug280439"


    // $ANTLR start "entryRuleConcreteMulti"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1497:1: entryRuleConcreteMulti : ruleConcreteMulti EOF ;
    public final void entryRuleConcreteMulti() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1497:23: ( ruleConcreteMulti EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1498:2: ruleConcreteMulti EOF
            {
             markComposite(elementTypeProvider.getConcreteMultiElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti4382);
            ruleConcreteMulti();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteMulti4388); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleConcreteMulti"


    // $ANTLR start "ruleConcreteMulti"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1506:1: ruleConcreteMulti : ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) ;
    public final void ruleConcreteMulti() throws RecognitionException {
        Token lv_m1_0_0=null;
        Token lv_m2_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1506:18: ( ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1507:2: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1507:2: ( ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1508:3: ( (lv_m1_0_0= RULE_ID ) ) ( (lv_m2_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1508:3: ( (lv_m1_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1509:4: (lv_m1_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1509:4: (lv_m1_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1510:5: lv_m1_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_m1_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConcreteMulti4424); 

            					doneLeaf(lv_m1_0_0, elementTypeProvider.getConcreteMulti_M1IDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1519:3: ( (lv_m2_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1520:4: (lv_m2_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1520:4: (lv_m2_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1521:5: lv_m2_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_m2_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConcreteMulti4462); 

            					doneLeaf(lv_m2_1_0, elementTypeProvider.getConcreteMulti_M2IDTerminalRuleCall_1_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleConcreteMulti"


    // $ANTLR start "entryRuleEObjectRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1534:1: entryRuleEObjectRef : ruleEObjectRef EOF ;
    public final void entryRuleEObjectRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1534:20: ( ruleEObjectRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1535:2: ruleEObjectRef EOF
            {
             markComposite(elementTypeProvider.getEObjectRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEObjectRef_in_entryRuleEObjectRef4493);
            ruleEObjectRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObjectRef4499); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleEObjectRef"


    // $ANTLR start "ruleEObjectRef"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1543:1: ruleEObjectRef : (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) ;
    public final void ruleEObjectRef() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1543:15: ( (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1544:2: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1544:2: (otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1545:3: otherlv_0= '#16' ( (lv_obj_1_0= ruleEObjectElement ) ) otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleEObjectRef4522); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEObjectRef_NumberSignDigitOneDigitSixKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1552:3: ( (lv_obj_1_0= ruleEObjectElement ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1553:4: (lv_obj_1_0= ruleEObjectElement )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1553:4: (lv_obj_1_0= ruleEObjectElement )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1554:5: lv_obj_1_0= ruleEObjectElement
            {

            					markComposite(elementTypeProvider.getEObjectRef_ObjEObjectElementParserRuleCall_1_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleEObjectElement_in_ruleEObjectRef4549);
            ruleEObjectElement();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleEObjectRef4574); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEObjectRef_RefsKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1570:3: ( (otherlv_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1571:4: (otherlv_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1571:4: (otherlv_3= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1572:5: otherlv_3= RULE_ID
            {

            					markLeaf();
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEObjectRef4601); 

            					doneLeaf(otherlv_3, elementTypeProvider.getEObjectRef_RefEObjectCrossReference_3_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleEObjectRef"


    // $ANTLR start "entryRuleEObjectElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1585:1: entryRuleEObjectElement : ruleEObjectElement EOF ;
    public final void entryRuleEObjectElement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1585:24: ( ruleEObjectElement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1586:2: ruleEObjectElement EOF
            {
             markComposite(elementTypeProvider.getEObjectElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEObjectElement_in_entryRuleEObjectElement4632);
            ruleEObjectElement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEObjectElement4638); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleEObjectElement"


    // $ANTLR start "ruleEObjectElement"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1594:1: ruleEObjectElement : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleEObjectElement() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1594:19: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1595:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1595:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1596:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1596:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1597:4: lv_name_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEObjectElement4667); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getEObjectElement_NameIDTerminalRuleCall_0ElementType());
            			

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
        return ;
    }
    // $ANTLR end "ruleEObjectElement"


    // $ANTLR start "entryRuleTypeBug305577_1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1609:1: entryRuleTypeBug305577_1 : ruleTypeBug305577_1 EOF ;
    public final void entryRuleTypeBug305577_1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1609:25: ( ruleTypeBug305577_1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1610:2: ruleTypeBug305577_1 EOF
            {
             markComposite(elementTypeProvider.getTypeBug305577_1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_1_in_entryRuleTypeBug305577_14692);
            ruleTypeBug305577_1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug305577_14698); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTypeBug305577_1"


    // $ANTLR start "ruleTypeBug305577_1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1618:1: ruleTypeBug305577_1 : (otherlv_0= '#17' ( ruleTypeBug1A | ruleTypeBug1B ) ) ;
    public final void ruleTypeBug305577_1() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1618:20: ( (otherlv_0= '#17' ( ruleTypeBug1A | ruleTypeBug1B ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1619:2: (otherlv_0= '#17' ( ruleTypeBug1A | ruleTypeBug1B ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1619:2: (otherlv_0= '#17' ( ruleTypeBug1A | ruleTypeBug1B ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1620:3: otherlv_0= '#17' ( ruleTypeBug1A | ruleTypeBug1B )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleTypeBug305577_14721); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1627:3: ( ruleTypeBug1A | ruleTypeBug1B )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1628:4: ruleTypeBug1A
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_1_TypeBug1AParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug1A_in_ruleTypeBug305577_14739);
                    ruleTypeBug1A();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1636:4: ruleTypeBug1B
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_1_TypeBug1BParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug1B_in_ruleTypeBug305577_14763);
                    ruleTypeBug1B();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleTypeBug305577_1"


    // $ANTLR start "entryRuleTypeBug305577_2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1648:1: entryRuleTypeBug305577_2 : ruleTypeBug305577_2 EOF ;
    public final void entryRuleTypeBug305577_2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1648:25: ( ruleTypeBug305577_2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1649:2: ruleTypeBug305577_2 EOF
            {
             markComposite(elementTypeProvider.getTypeBug305577_2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug305577_2_in_entryRuleTypeBug305577_24788);
            ruleTypeBug305577_2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug305577_24794); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTypeBug305577_2"


    // $ANTLR start "ruleTypeBug305577_2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1657:1: ruleTypeBug305577_2 : (otherlv_0= '#18' ( ruleTypeBug2B | ruleTypeBug2A ) ) ;
    public final void ruleTypeBug305577_2() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1657:20: ( (otherlv_0= '#18' ( ruleTypeBug2B | ruleTypeBug2A ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1658:2: (otherlv_0= '#18' ( ruleTypeBug2B | ruleTypeBug2A ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1658:2: (otherlv_0= '#18' ( ruleTypeBug2B | ruleTypeBug2A ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1659:3: otherlv_0= '#18' ( ruleTypeBug2B | ruleTypeBug2A )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleTypeBug305577_24817); 

            			doneLeaf(otherlv_0, elementTypeProvider.getTypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1666:3: ( ruleTypeBug2B | ruleTypeBug2A )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1667:4: ruleTypeBug2B
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_2_TypeBug2BParserRuleCall_1_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug2B_in_ruleTypeBug305577_24835);
                    ruleTypeBug2B();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1675:4: ruleTypeBug2A
                    {

                    				markComposite(elementTypeProvider.getTypeBug305577_2_TypeBug2AParserRuleCall_1_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleTypeBug2A_in_ruleTypeBug305577_24859);
                    ruleTypeBug2A();

                    state._fsp--;


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
        return ;
    }
    // $ANTLR end "ruleTypeBug305577_2"


    // $ANTLR start "entryRuleTypeBug1A"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1687:1: entryRuleTypeBug1A : ruleTypeBug1A EOF ;
    public final void entryRuleTypeBug1A() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1687:19: ( ruleTypeBug1A EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1688:2: ruleTypeBug1A EOF
            {
             markComposite(elementTypeProvider.getTypeBug1AElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug1A_in_entryRuleTypeBug1A4884);
            ruleTypeBug1A();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug1A4890); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTypeBug1A"


    // $ANTLR start "ruleTypeBug1A"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1696:1: ruleTypeBug1A : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final void ruleTypeBug1A() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1696:14: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1697:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1697:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1698:3: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1698:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1699:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug1A_TypeBug1AAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleTypeBug1A4926); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTypeBug1A_KaKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1711:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1712:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1712:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1713:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug1A4953); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getTypeBug1A_NameIDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleTypeBug1A"


    // $ANTLR start "entryRuleTypeBug1B"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1726:1: entryRuleTypeBug1B : ruleTypeBug1B EOF ;
    public final void entryRuleTypeBug1B() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1726:19: ( ruleTypeBug1B EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1727:2: ruleTypeBug1B EOF
            {
             markComposite(elementTypeProvider.getTypeBug1BElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug1B_in_entryRuleTypeBug1B4984);
            ruleTypeBug1B();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug1B4990); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTypeBug1B"


    // $ANTLR start "ruleTypeBug1B"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1735:1: ruleTypeBug1B : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final void ruleTypeBug1B() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1735:14: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1736:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1736:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1737:3: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1737:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1738:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug1B_TypeBug1BAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleTypeBug1B5026); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTypeBug1B_KbKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1750:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1751:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1751:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1752:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug1B5053); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getTypeBug1B_NameIDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleTypeBug1B"


    // $ANTLR start "entryRuleTypeBug2A"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1765:1: entryRuleTypeBug2A : ruleTypeBug2A EOF ;
    public final void entryRuleTypeBug2A() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1765:19: ( ruleTypeBug2A EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1766:2: ruleTypeBug2A EOF
            {
             markComposite(elementTypeProvider.getTypeBug2AElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug2A_in_entryRuleTypeBug2A5084);
            ruleTypeBug2A();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug2A5090); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTypeBug2A"


    // $ANTLR start "ruleTypeBug2A"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1774:1: ruleTypeBug2A : ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final void ruleTypeBug2A() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1774:14: ( ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1775:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1775:2: ( () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1776:3: () otherlv_1= 'ka' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1776:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1777:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug2A_TypeBug2AAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleTypeBug2A5126); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTypeBug2A_KaKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1789:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1790:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1790:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1791:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug2A5153); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getTypeBug2A_NameIDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleTypeBug2A"


    // $ANTLR start "entryRuleTypeBug2B"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1804:1: entryRuleTypeBug2B : ruleTypeBug2B EOF ;
    public final void entryRuleTypeBug2B() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1804:19: ( ruleTypeBug2B EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1805:2: ruleTypeBug2B EOF
            {
             markComposite(elementTypeProvider.getTypeBug2BElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTypeBug2B_in_entryRuleTypeBug2B5184);
            ruleTypeBug2B();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeBug2B5190); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleTypeBug2B"


    // $ANTLR start "ruleTypeBug2B"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1813:1: ruleTypeBug2B : ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final void ruleTypeBug2B() throws RecognitionException {
        Token otherlv_1=null;
        Token lv_name_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1813:14: ( ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1814:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1814:2: ( () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1815:3: () otherlv_1= 'kb' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1815:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1816:4: 
            {

            				precedeComposite(elementTypeProvider.getTypeBug2B_TypeBug2BAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleTypeBug2B5226); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTypeBug2B_KbKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1828:3: ( (lv_name_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1829:4: (lv_name_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1829:4: (lv_name_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1830:5: lv_name_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTypeBug2B5253); 

            					doneLeaf(lv_name_2_0, elementTypeProvider.getTypeBug2B_NameIDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleTypeBug2B"


    // $ANTLR start "entryRuleBug305171"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1843:1: entryRuleBug305171 : ruleBug305171 EOF ;
    public final void entryRuleBug305171() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1843:19: ( ruleBug305171 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1844:2: ruleBug305171 EOF
            {
             markComposite(elementTypeProvider.getBug305171ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug305171_in_entryRuleBug3051715284);
            ruleBug305171();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug3051715290); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleBug305171"


    // $ANTLR start "ruleBug305171"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1852:1: ruleBug305171 : (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) ;
    public final void ruleBug305171() throws RecognitionException {
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1852:14: ( (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1853:2: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1853:2: (otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1854:3: otherlv_0= '#19' ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) ) ( (lv_name_13_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleBug3051715313); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBug305171_NumberSignDigitOneDigitNineKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1861:3: ( (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1862:4: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )? ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1862:4: (otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==65) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1863:5: otherlv_1= 'kx' ( (lv_x_2_0= RULE_ID ) ) (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    {

                    					markLeaf();
                    				
                    otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleBug3051715340); 

                    					doneLeaf(otherlv_1, elementTypeProvider.getBug305171_KxKeyword_1_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1870:5: ( (lv_x_2_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1871:6: (lv_x_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1871:6: (lv_x_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1872:7: lv_x_2_0= RULE_ID
                    {

                    							markLeaf();
                    						
                    lv_x_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715377); 

                    							doneLeaf(lv_x_2_0, elementTypeProvider.getBug305171_XIDTerminalRuleCall_1_0_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1881:5: (otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==30) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1882:6: otherlv_3= ',' ( (lv_x_4_0= RULE_ID ) )
                    	    {

                    	    						markLeaf();
                    	    					
                    	    otherlv_3=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug3051715420); 

                    	    						doneLeaf(otherlv_3, elementTypeProvider.getBug305171_CommaKeyword_1_0_2_0ElementType());
                    	    					
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1889:6: ( (lv_x_4_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1890:7: (lv_x_4_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1890:7: (lv_x_4_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1891:8: lv_x_4_0= RULE_ID
                    	    {

                    	    								markLeaf();
                    	    							
                    	    lv_x_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715462); 

                    	    								doneLeaf(lv_x_4_0, elementTypeProvider.getBug305171_XIDTerminalRuleCall_1_0_2_1_0ElementType());
                    	    							

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1902:4: ( (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1903:5: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )? (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1903:5: (otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )* )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==66) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1904:6: otherlv_5= 'ky' ( (lv_y_6_0= RULE_ID ) ) (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    {

                    						markLeaf();
                    					
                    otherlv_5=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleBug3051715526); 

                    						doneLeaf(otherlv_5, elementTypeProvider.getBug305171_KyKeyword_1_1_0_0ElementType());
                    					
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1911:6: ( (lv_y_6_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1912:7: (lv_y_6_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1912:7: (lv_y_6_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1913:8: lv_y_6_0= RULE_ID
                    {

                    								markLeaf();
                    							
                    lv_y_6_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715568); 

                    								doneLeaf(lv_y_6_0, elementTypeProvider.getBug305171_YIDTerminalRuleCall_1_1_0_1_0ElementType());
                    							

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1922:6: (otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==30) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1923:7: otherlv_7= ',' ( (lv_y_8_0= RULE_ID ) )
                    	    {

                    	    							markLeaf();
                    	    						
                    	    otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug3051715617); 

                    	    							doneLeaf(otherlv_7, elementTypeProvider.getBug305171_CommaKeyword_1_1_0_2_0ElementType());
                    	    						
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1930:7: ( (lv_y_8_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1931:8: (lv_y_8_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1931:8: (lv_y_8_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1932:9: lv_y_8_0= RULE_ID
                    	    {

                    	    									markLeaf();
                    	    								
                    	    lv_y_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715664); 

                    	    									doneLeaf(lv_y_8_0, elementTypeProvider.getBug305171_YIDTerminalRuleCall_1_1_0_2_1_0ElementType());
                    	    								

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1943:5: (otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==67) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1944:6: otherlv_9= 'kz' ( (lv_z_10_0= RULE_ID ) ) (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    {

                    						markLeaf();
                    					
                    otherlv_9=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleBug3051715728); 

                    						doneLeaf(otherlv_9, elementTypeProvider.getBug305171_KzKeyword_1_1_1_0ElementType());
                    					
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1951:6: ( (lv_z_10_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1952:7: (lv_z_10_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1952:7: (lv_z_10_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1953:8: lv_z_10_0= RULE_ID
                    {

                    								markLeaf();
                    							
                    lv_z_10_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715770); 

                    								doneLeaf(lv_z_10_0, elementTypeProvider.getBug305171_ZIDTerminalRuleCall_1_1_1_1_0ElementType());
                    							

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1962:6: (otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==30) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1963:7: otherlv_11= ',' ( (lv_z_12_0= RULE_ID ) )
                    	    {

                    	    							markLeaf();
                    	    						
                    	    otherlv_11=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBug3051715819); 

                    	    							doneLeaf(otherlv_11, elementTypeProvider.getBug305171_CommaKeyword_1_1_1_2_0ElementType());
                    	    						
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1970:7: ( (lv_z_12_0= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1971:8: (lv_z_12_0= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1971:8: (lv_z_12_0= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1972:9: lv_z_12_0= RULE_ID
                    	    {

                    	    									markLeaf();
                    	    								
                    	    lv_z_12_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715866); 

                    	    									doneLeaf(lv_z_12_0, elementTypeProvider.getBug305171_ZIDTerminalRuleCall_1_1_1_2_1_0ElementType());
                    	    								

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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1985:3: ( (lv_name_13_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1986:4: (lv_name_13_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1986:4: (lv_name_13_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:1987:5: lv_name_13_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_13_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug3051715940); 

            					doneLeaf(lv_name_13_0, elementTypeProvider.getBug305171_NameIDTerminalRuleCall_2_0ElementType());
            				

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
        return ;
    }
    // $ANTLR end "ruleBug305171"


    // $ANTLR start "entryRuleBug310435Enum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2000:1: entryRuleBug310435Enum : ruleBug310435Enum EOF ;
    public final void entryRuleBug310435Enum() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2000:23: ( ruleBug310435Enum EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2001:2: ruleBug310435Enum EOF
            {
             markComposite(elementTypeProvider.getBug310435EnumElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug310435Enum_in_entryRuleBug310435Enum5971);
            ruleBug310435Enum();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug310435Enum5977); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleBug310435Enum"


    // $ANTLR start "ruleBug310435Enum"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2009:1: ruleBug310435Enum : (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) ;
    public final void ruleBug310435Enum() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2009:18: ( (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2010:2: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2010:2: (otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2011:3: otherlv_0= '#20' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleBug310435Enum6000); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2018:3: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2019:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2019:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2020:5: otherlv_1= 'kw1' ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleBug310435Enum6027); 

            	    					doneLeaf(otherlv_1, elementTypeProvider.getBug310435Enum_Kw1Keyword_1_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2027:5: ( (lv_lits_2_0= ruleEnumBug310435Lit1 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2028:6: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2028:6: (lv_lits_2_0= ruleEnumBug310435Lit1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2029:7: lv_lits_2_0= ruleEnumBug310435Lit1
            	    {

            	    							markComposite(elementTypeProvider.getBug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumBug310435Lit1_in_ruleBug310435Enum6064);
            	    ruleEnumBug310435Lit1();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2040:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2040:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2041:5: otherlv_3= 'kw2' ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleBug310435Enum6118); 

            	    					doneLeaf(otherlv_3, elementTypeProvider.getBug310435Enum_Kw2Keyword_1_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2048:5: ( (lv_lits_4_0= ruleEnumBug310435Lit2 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2049:6: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2049:6: (lv_lits_4_0= ruleEnumBug310435Lit2 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2050:7: lv_lits_4_0= ruleEnumBug310435Lit2
            	    {

            	    							markComposite(elementTypeProvider.getBug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleEnumBug310435Lit2_in_ruleBug310435Enum6155);
            	    ruleEnumBug310435Lit2();

            	    state._fsp--;


            	    							doneComposite();
            	    						

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
        return ;
    }
    // $ANTLR end "ruleBug310435Enum"


    // $ANTLR start "entryRuleBug310435Val"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2065:1: entryRuleBug310435Val : ruleBug310435Val EOF ;
    public final void entryRuleBug310435Val() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2065:22: ( ruleBug310435Val EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2066:2: ruleBug310435Val EOF
            {
             markComposite(elementTypeProvider.getBug310435ValElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBug310435Val_in_entryRuleBug310435Val6202);
            ruleBug310435Val();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBug310435Val6208); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleBug310435Val"


    // $ANTLR start "ruleBug310435Val"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2074:1: ruleBug310435Val : (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) ;
    public final void ruleBug310435Val() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_lits_2_0=null;
        Token otherlv_3=null;
        Token lv_lits_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2074:17: ( (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2075:2: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2075:2: (otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2076:3: otherlv_0= '#21' ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleBug310435Val6231); 

            			doneLeaf(otherlv_0, elementTypeProvider.getBug310435Val_NumberSignDigitTwoDigitOneKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2083:3: ( (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) ) | (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2084:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2084:4: (otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2085:5: otherlv_1= 'kw1' ( (lv_lits_2_0= RULE_ID ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleBug310435Val6258); 

            	    					doneLeaf(otherlv_1, elementTypeProvider.getBug310435Val_Kw1Keyword_1_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2092:5: ( (lv_lits_2_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2093:6: (lv_lits_2_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2093:6: (lv_lits_2_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2094:7: lv_lits_2_0= RULE_ID
            	    {

            	    							markLeaf();
            	    						
            	    lv_lits_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBug310435Val6295); 

            	    							doneLeaf(lv_lits_2_0, elementTypeProvider.getBug310435Val_LitsIDTerminalRuleCall_1_0_1_0ElementType());
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2105:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2105:4: (otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2106:5: otherlv_3= 'kw2' ( (lv_lits_4_0= RULE_STRING ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleBug310435Val6349); 

            	    					doneLeaf(otherlv_3, elementTypeProvider.getBug310435Val_Kw2Keyword_1_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2113:5: ( (lv_lits_4_0= RULE_STRING ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2114:6: (lv_lits_4_0= RULE_STRING )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2114:6: (lv_lits_4_0= RULE_STRING )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2115:7: lv_lits_4_0= RULE_STRING
            	    {

            	    							markLeaf();
            	    						
            	    lv_lits_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleBug310435Val6386); 

            	    							doneLeaf(lv_lits_4_0, elementTypeProvider.getBug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0ElementType());
            	    						

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
        return ;
    }
    // $ANTLR end "ruleBug310435Val"


    // $ANTLR start "entryRuleCrossRefNameTest"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2130:1: entryRuleCrossRefNameTest : ruleCrossRefNameTest EOF ;
    public final void entryRuleCrossRefNameTest() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2130:26: ( ruleCrossRefNameTest EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2131:2: ruleCrossRefNameTest EOF
            {
             markComposite(elementTypeProvider.getCrossRefNameTestElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossRefNameTest_in_entryRuleCrossRefNameTest6433);
            ruleCrossRefNameTest();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossRefNameTest6439); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleCrossRefNameTest"


    // $ANTLR start "ruleCrossRefNameTest"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2139:1: ruleCrossRefNameTest : (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* ) ;
    public final void ruleCrossRefNameTest() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2139:21: ( (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2140:2: (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2140:2: (otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2141:3: otherlv_0= '#22' ( (lv_named_1_0= ruleCrossRefNamed ) )* otherlv_2= 'kw1' ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleCrossRefNameTest6462); 

            			doneLeaf(otherlv_0, elementTypeProvider.getCrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2148:3: ( (lv_named_1_0= ruleCrossRefNamed ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=RULE_ID1 && LA41_0<=RULE_ID2)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2149:4: (lv_named_1_0= ruleCrossRefNamed )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2149:4: (lv_named_1_0= ruleCrossRefNamed )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2150:5: lv_named_1_0= ruleCrossRefNamed
            	    {

            	    					markComposite(elementTypeProvider.getCrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleCrossRefNamed_in_ruleCrossRefNameTest6489);
            	    ruleCrossRefNamed();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_2=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleCrossRefNameTest6515); 

            			doneLeaf(otherlv_2, elementTypeProvider.getCrossRefNameTest_Kw1Keyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2166:3: ( (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) ) | (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) ) )*
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2167:4: (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2167:4: (otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2168:5: otherlv_3= 'kw2' ( (otherlv_4= RULE_ID1 ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_3=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleCrossRefNameTest6542); 

            	    					doneLeaf(otherlv_3, elementTypeProvider.getCrossRefNameTest_Kw2Keyword_3_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2175:5: ( (otherlv_4= RULE_ID1 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2176:6: (otherlv_4= RULE_ID1 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2176:6: (otherlv_4= RULE_ID1 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2177:7: otherlv_4= RULE_ID1
            	    {

            	    							markLeaf();
            	    						
            	    otherlv_4=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleCrossRefNameTest6579); 

            	    							doneLeaf(otherlv_4, elementTypeProvider.getCrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0ElementType());
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2188:4: (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2188:4: (otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2189:5: otherlv_5= 'kw3' ( (otherlv_6= RULE_ID2 ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_5=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleCrossRefNameTest6633); 

            	    					doneLeaf(otherlv_5, elementTypeProvider.getCrossRefNameTest_Kw3Keyword_3_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2196:5: ( (otherlv_6= RULE_ID2 ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2197:6: (otherlv_6= RULE_ID2 )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2197:6: (otherlv_6= RULE_ID2 )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2198:7: otherlv_6= RULE_ID2
            	    {

            	    							markLeaf();
            	    						
            	    otherlv_6=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleCrossRefNameTest6670); 

            	    							doneLeaf(otherlv_6, elementTypeProvider.getCrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0ElementType());
            	    						

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
        return ;
    }
    // $ANTLR end "ruleCrossRefNameTest"


    // $ANTLR start "entryRuleCrossRefNamed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2213:1: entryRuleCrossRefNamed : ruleCrossRefNamed EOF ;
    public final void entryRuleCrossRefNamed() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2213:23: ( ruleCrossRefNamed EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2214:2: ruleCrossRefNamed EOF
            {
             markComposite(elementTypeProvider.getCrossRefNamedElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCrossRefNamed_in_entryRuleCrossRefNamed6717);
            ruleCrossRefNamed();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCrossRefNamed6723); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {


        }
        return ;
    }
    // $ANTLR end "entryRuleCrossRefNamed"


    // $ANTLR start "ruleCrossRefNamed"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2222:1: ruleCrossRefNamed : ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) ) ;
    public final void ruleCrossRefNamed() throws RecognitionException {
        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2222:18: ( ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2223:2: ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2223:2: ( ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2224:3: ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2224:3: ( (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2225:4: (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2225:4: (lv_name_0_1= RULE_ID1 | lv_name_0_2= RULE_ID2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2226:5: lv_name_0_1= RULE_ID1
                    {

                    					markLeaf();
                    				
                    lv_name_0_1=(Token)match(input,RULE_ID1,FollowSets000.FOLLOW_RULE_ID1_in_ruleCrossRefNamed6759); 

                    					doneLeaf(lv_name_0_1, elementTypeProvider.getCrossRefNamed_NameID1TerminalRuleCall_0_0ElementType());
                    				

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2234:5: lv_name_0_2= RULE_ID2
                    {

                    					markLeaf();
                    				
                    lv_name_0_2=(Token)match(input,RULE_ID2,FollowSets000.FOLLOW_RULE_ID2_in_ruleCrossRefNamed6789); 

                    					doneLeaf(lv_name_0_2, elementTypeProvider.getCrossRefNamed_NameID2TerminalRuleCall_0_1ElementType());
                    				

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
        return ;
    }
    // $ANTLR end "ruleCrossRefNamed"


    // $ANTLR start "ruleEnumBug310435Lit1"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2247:1: ruleEnumBug310435Lit1 : (enumLiteral_0= 'lit1' ) ;
    public final void ruleEnumBug310435Lit1() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2247:22: ( (enumLiteral_0= 'lit1' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2248:2: (enumLiteral_0= 'lit1' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2248:2: (enumLiteral_0= 'lit1' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2249:3: enumLiteral_0= 'lit1'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleEnumBug310435Lit16827); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getEnumBug310435Lit1_Lit1EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleEnumBug310435Lit1"


    // $ANTLR start "ruleEnumBug310435Lit2"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2260:1: ruleEnumBug310435Lit2 : (enumLiteral_0= 'lit2' ) ;
    public final void ruleEnumBug310435Lit2() throws RecognitionException {
        Token enumLiteral_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2260:22: ( (enumLiteral_0= 'lit2' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2261:2: (enumLiteral_0= 'lit2' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2261:2: (enumLiteral_0= 'lit2' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/idea/parser/antlr/internal/PsiInternalSimpleReconstrTestLanguage.g:2262:3: enumLiteral_0= 'lit2'
            {

            			markLeaf();
            		
            enumLiteral_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleEnumBug310435Lit26854); 

            			doneLeaf(enumLiteral_0, elementTypeProvider.getEnumBug310435Lit2_Lit2EnumLiteralDeclarationElementType());
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleEnumBug310435Lit2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleOp_in_entryRuleOp54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOp60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp81 = new BitSet(new long[]{0x3689437C92962032L,0x0000000000000071L});
        public static final BitSet FOLLOW_ruleTerm_in_ruleOp132 = new BitSet(new long[]{0x3689437C92962032L,0x0000000000000071L});
        public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTerm177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_ruleTerm198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleTerm258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRef2_in_ruleTerm278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpare_in_ruleTerm298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_ruleTerm318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransient1_in_ruleTerm338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed1_in_ruleTerm358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed2_in_ruleTerm378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop1_in_ruleTerm398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop2_in_ruleTerm418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop3_in_ruleTerm438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop4_in_ruleTerm458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoopBug285452_in_ruleTerm478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDuplicateBug284491_in_ruleTerm498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_ruleTerm518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_ruleTerm538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObjectRef_in_ruleTerm558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_1_in_ruleTerm578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_2_in_ruleTerm598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_ruleTerm618 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug305171_in_ruleTerm638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug310435Val_in_ruleTerm658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug310435Enum_in_ruleTerm678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCrossRefNameTest_in_ruleTerm698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom718 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAtom724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAtom753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParens_in_entryRuleParens778 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParens784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleParens807 = new BitSet(new long[]{0x3689437C92962030L,0x0000000000000071L});
        public static final BitSet FOLLOW_ruleOp_in_ruleParens819 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleParens833 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleParens860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers892 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers934 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers972 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleTwoNumbers1003 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers1035 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings1074 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings1080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleManyStrings1103 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1130 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType1200 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType1206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleType1229 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType1256 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleType1281 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType1308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21339 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRef21345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRef21368 = new BitSet(new long[]{0x0000000000600040L});
        public static final BitSet FOLLOW_21_in_ruleRef21403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleRef21471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpare_in_entryRuleSpare1509 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpare1515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleSpare1538 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1565 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_24_in_ruleSpare1596 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1628 = new BitSet(new long[]{0x0000000001000002L});
        public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleBoolean1696 = new BitSet(new long[]{0x000000000C000000L});
        public static final BitSet FOLLOW_26_in_ruleBoolean1723 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBoolean1749 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean1776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransient1_in_entryRuleTransient11807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransient11813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleTransient11836 = new BitSet(new long[]{0x0000000020000020L});
        public static final BitSet FOLLOW_29_in_ruleTransient11871 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransient11925 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleTransient11963 = new BitSet(new long[]{0x0000000020000020L});
        public static final BitSet FOLLOW_29_in_ruleTransient12004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTransient12066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed1_in_entryRuleConsumed12113 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConsumed12119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleConsumed12142 = new BitSet(new long[]{0x0000000300000000L});
        public static final BitSet FOLLOW_32_in_ruleConsumed12169 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12206 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleConsumed12313 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConsumed12350 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleConsumed12403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConsumed2_in_entryRuleConsumed22449 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConsumed22455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleConsumed22478 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_ruleConsumed1_in_ruleConsumed22505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop1_in_entryRuleLoop12536 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop12542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleLoop12571 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleLoop12591 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12618 = new BitSet(new long[]{0x0000002000000010L});
        public static final BitSet FOLLOW_37_in_ruleLoop12649 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop12682 = new BitSet(new long[]{0x000000C000000000L});
        public static final BitSet FOLLOW_38_in_ruleLoop12720 = new BitSet(new long[]{0x000000C000000000L});
        public static final BitSet FOLLOW_39_in_ruleLoop12744 = new BitSet(new long[]{0x000000C000000002L});
        public static final BitSet FOLLOW_ruleLoop2_in_entryRuleLoop22770 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop22776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleLoop22799 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22826 = new BitSet(new long[]{0x0000002000000010L});
        public static final BitSet FOLLOW_37_in_ruleLoop22857 = new BitSet(new long[]{0x00001A0000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop22907 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_38_in_ruleLoop22942 = new BitSet(new long[]{0x00001A0000000010L});
        public static final BitSet FOLLOW_41_in_ruleLoop22973 = new BitSet(new long[]{0x0000180000000000L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop23023 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleLoop23058 = new BitSet(new long[]{0x0000180000000000L});
        public static final BitSet FOLLOW_43_in_ruleLoop23090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleLoop23116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoop3_in_entryRuleLoop33141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop33147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleLoop33176 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_38_in_ruleLoop33202 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_41_in_ruleLoop33228 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleLoop33247 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop33274 = new BitSet(new long[]{0x0000040000000002L});
        public static final BitSet FOLLOW_42_in_ruleLoop33305 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop33337 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleLoop33367 = new BitSet(new long[]{0x0000040000000002L});
        public static final BitSet FOLLOW_ruleLoop4_in_entryRuleLoop43393 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoop43399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleLoop43422 = new BitSet(new long[]{0x0000026000000000L});
        public static final BitSet FOLLOW_37_in_ruleLoop43442 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_38_in_ruleLoop43468 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_41_in_ruleLoop43501 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleLoop43521 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoop43559 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleLoop43590 = new BitSet(new long[]{0x0000180000000002L});
        public static final BitSet FOLLOW_44_in_ruleLoop43614 = new BitSet(new long[]{0x0000880000000002L});
        public static final BitSet FOLLOW_47_in_ruleLoop43642 = new BitSet(new long[]{0x0000080000000002L});
        public static final BitSet FOLLOW_ruleLoopBug285452_in_entryRuleLoopBug2854523683 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoopBug2854523689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleLoopBug2854523712 = new BitSet(new long[]{0x0006000000000000L});
        public static final BitSet FOLLOW_49_in_ruleLoopBug2854523747 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_50_in_ruleLoopBug2854523786 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleLoopBug2854523818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDuplicateBug284491_in_entryRuleDuplicateBug2844913849 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDuplicateBug2844913855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleDuplicateBug2844913878 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_52_in_ruleDuplicateBug2844913913 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_53_in_ruleDuplicateBug2844913967 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_54_in_ruleDuplicateBug2844914021 = new BitSet(new long[]{0x0070000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectBug284850_in_entryRuleEmptyObjectBug2848504060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectBug2848504066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleEmptyObjectBug2848504089 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_ruleEmptyObjectItems_in_ruleEmptyObjectBug2848504116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectItems_in_entryRuleEmptyObjectItems4147 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItems4153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectItem_in_ruleEmptyObjectItems4182 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_ruleEmptyObjectItem_in_entryRuleEmptyObjectItem4208 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEmptyObjectItem4214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleEmptyObjectItem4237 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEmptyObjectItem4264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiInheritanceBug280439_in_entryRuleMultiInheritanceBug2804394295 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiInheritanceBug2804394301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleMultiInheritanceBug2804394324 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleConcreteMulti_in_ruleMultiInheritanceBug2804394351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteMulti_in_entryRuleConcreteMulti4382 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteMulti4388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti4424 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConcreteMulti4462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObjectRef_in_entryRuleEObjectRef4493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObjectRef4499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleEObjectRef4522 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEObjectElement_in_ruleEObjectRef4549 = new BitSet(new long[]{0x0800000000000000L});
        public static final BitSet FOLLOW_59_in_ruleEObjectRef4574 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEObjectRef4601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEObjectElement_in_entryRuleEObjectElement4632 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEObjectElement4638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEObjectElement4667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_1_in_entryRuleTypeBug305577_14692 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug305577_14698 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleTypeBug305577_14721 = new BitSet(new long[]{0xC000000000000000L});
        public static final BitSet FOLLOW_ruleTypeBug1A_in_ruleTypeBug305577_14739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug1B_in_ruleTypeBug305577_14763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug305577_2_in_entryRuleTypeBug305577_24788 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug305577_24794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleTypeBug305577_24817 = new BitSet(new long[]{0xC000000000000000L});
        public static final BitSet FOLLOW_ruleTypeBug2B_in_ruleTypeBug305577_24835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug2A_in_ruleTypeBug305577_24859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug1A_in_entryRuleTypeBug1A4884 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug1A4890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleTypeBug1A4926 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug1A4953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug1B_in_entryRuleTypeBug1B4984 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug1B4990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleTypeBug1B5026 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug1B5053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug2A_in_entryRuleTypeBug2A5084 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug2A5090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleTypeBug2A5126 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug2A5153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeBug2B_in_entryRuleTypeBug2B5184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeBug2B5190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleTypeBug2B5226 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTypeBug2B5253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug305171_in_entryRuleBug3051715284 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug3051715290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleBug3051715313 = new BitSet(new long[]{0x0000000000000010L,0x000000000000000EL});
        public static final BitSet FOLLOW_65_in_ruleBug3051715340 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715377 = new BitSet(new long[]{0x0000000040000010L,0x000000000000000CL});
        public static final BitSet FOLLOW_30_in_ruleBug3051715420 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715462 = new BitSet(new long[]{0x0000000040000010L,0x000000000000000CL});
        public static final BitSet FOLLOW_66_in_ruleBug3051715526 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715568 = new BitSet(new long[]{0x0000000040000010L,0x0000000000000008L});
        public static final BitSet FOLLOW_30_in_ruleBug3051715617 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715664 = new BitSet(new long[]{0x0000000040000010L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleBug3051715728 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715770 = new BitSet(new long[]{0x0000000040000010L});
        public static final BitSet FOLLOW_30_in_ruleBug3051715819 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715866 = new BitSet(new long[]{0x0000000040000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug3051715940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBug310435Enum_in_entryRuleBug310435Enum5971 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug310435Enum5977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_68_in_ruleBug310435Enum6000 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleBug310435Enum6027 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_ruleEnumBug310435Lit1_in_ruleBug310435Enum6064 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_38_in_ruleBug310435Enum6118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_ruleEnumBug310435Lit2_in_ruleBug310435Enum6155 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_ruleBug310435Val_in_entryRuleBug310435Val6202 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBug310435Val6208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_69_in_ruleBug310435Val6231 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleBug310435Val6258 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBug310435Val6295 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_38_in_ruleBug310435Val6349 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleBug310435Val6386 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_ruleCrossRefNameTest_in_entryRuleCrossRefNameTest6433 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossRefNameTest6439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleCrossRefNameTest6462 = new BitSet(new long[]{0x0000002000000180L});
        public static final BitSet FOLLOW_ruleCrossRefNamed_in_ruleCrossRefNameTest6489 = new BitSet(new long[]{0x0000002000000180L});
        public static final BitSet FOLLOW_37_in_ruleCrossRefNameTest6515 = new BitSet(new long[]{0x0000024000000002L});
        public static final BitSet FOLLOW_38_in_ruleCrossRefNameTest6542 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleCrossRefNameTest6579 = new BitSet(new long[]{0x0000024000000002L});
        public static final BitSet FOLLOW_41_in_ruleCrossRefNameTest6633 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleCrossRefNameTest6670 = new BitSet(new long[]{0x0000024000000002L});
        public static final BitSet FOLLOW_ruleCrossRefNamed_in_entryRuleCrossRefNamed6717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCrossRefNamed6723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID1_in_ruleCrossRefNamed6759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID2_in_ruleCrossRefNamed6789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleEnumBug310435Lit16827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleEnumBug310435Lit26854 = new BitSet(new long[]{0x0000000000000002L});
    }


}
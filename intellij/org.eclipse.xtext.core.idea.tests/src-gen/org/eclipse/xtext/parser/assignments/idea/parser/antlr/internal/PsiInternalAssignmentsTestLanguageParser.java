package org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.assignments.services.AssignmentsTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalAssignmentsTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'simple'", "'complex'", "'id'", "'alternative'", "'string'", "'ids'", "'alternatives'", "'strings'", "'datatypeid'", "'datatypealternative'", "'datatypestring'", "'datatypeids'", "'datatypealternatives'", "'datatypestrings'"
    };
    public static final int RULE_ID=4;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalAssignmentsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalAssignmentsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalAssignmentsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g"; }



    private AssignmentsTestLanguageGrammarAccess grammarAccess;

    private AssignmentsTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalAssignmentsTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, AssignmentsTestLanguageElementTypeProvider elementTypeProvider, AssignmentsTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
    }




    // $ANTLR start "entryRuleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:49:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:49:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:50:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel54);
            ruleModel();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel60); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:58:1: ruleModel : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:58:10: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:59:2: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:59:2: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:60:3: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:60:3: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:61:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel89); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getModel_SimpleKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:68:4: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    int alt1=4;
                    switch ( input.LA(1) ) {
                    case 13:
                    case 14:
                    case 15:
                        {
                        alt1=1;
                        }
                        break;
                    case 16:
                    case 17:
                    case 18:
                        {
                        alt1=2;
                        }
                        break;
                    case 19:
                    case 20:
                    case 21:
                        {
                        alt1=3;
                        }
                        break;
                    case 22:
                    case 23:
                    case 24:
                        {
                        alt1=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;
                    }

                    switch (alt1) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:69:5: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:69:5: ( (lv_single_1_0= ruleSingleValue ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:70:6: (lv_single_1_0= ruleSingleValue )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:70:6: (lv_single_1_0= ruleSingleValue )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:71:7: lv_single_1_0= ruleSingleValue
                            {

                            							markComposite(elementTypeProvider.getModel_SingleSingleValueParserRuleCall_0_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel130);
                            ruleSingleValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:81:5: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:81:5: ( (lv_multi_2_0= ruleMultiValue ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:82:6: (lv_multi_2_0= ruleMultiValue )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:82:6: (lv_multi_2_0= ruleMultiValue )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:83:7: lv_multi_2_0= ruleMultiValue
                            {

                            							markComposite(elementTypeProvider.getModel_MultiMultiValueParserRuleCall_0_1_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel192);
                            ruleMultiValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:93:5: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:93:5: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:94:6: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:94:6: (lv_single_3_0= ruleSingleDatatype )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:95:7: lv_single_3_0= ruleSingleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_SingleSingleDatatypeParserRuleCall_0_1_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel254);
                            ruleSingleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:105:5: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:105:5: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:106:6: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:106:6: (lv_multi_4_0= ruleMultiDatatype )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:107:7: lv_multi_4_0= ruleMultiDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiMultiDatatypeParserRuleCall_0_1_3_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel316);
                            ruleMultiDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:119:3: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:119:3: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:120:4: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel370); 

                    				doneLeaf(otherlv_5, elementTypeProvider.getModel_ComplexKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:127:4: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:128:5: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:128:5: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:129:6: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:129:6: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    int alt2=4;
                    switch ( input.LA(1) ) {
                    case 13:
                    case 14:
                    case 15:
                        {
                        alt2=1;
                        }
                        break;
                    case 16:
                    case 17:
                    case 18:
                        {
                        alt2=2;
                        }
                        break;
                    case 19:
                    case 20:
                    case 21:
                        {
                        alt2=3;
                        }
                        break;
                    case 22:
                    case 23:
                    case 24:
                        {
                        alt2=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:130:7: lv_object_6_1= ruleSingleValue
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectSingleValueParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_ruleModel411);
                            ruleSingleValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:138:7: lv_object_6_2= ruleMultiValue
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectMultiValueParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_ruleModel449);
                            ruleMultiValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:146:7: lv_object_6_3= ruleSingleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectSingleDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_ruleModel487);
                            ruleSingleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:154:7: lv_object_6_4= ruleMultiDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectMultiDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_ruleModel525);
                            ruleMultiDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSingleValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:169:1: entryRuleSingleValue : ruleSingleValue EOF ;
    public final void entryRuleSingleValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:169:21: ( ruleSingleValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:170:2: ruleSingleValue EOF
            {
             markComposite(elementTypeProvider.getSingleValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleValue_in_entryRuleSingleValue571);
            ruleSingleValue();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleValue577); 

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
    // $ANTLR end "entryRuleSingleValue"


    // $ANTLR start "ruleSingleValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:178:1: ruleSingleValue : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final void ruleSingleValue() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:178:16: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:179:2: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:179:2: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case 15:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:180:3: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:180:3: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:181:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSingleValue606); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getSingleValue_IdKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:188:4: ( (lv_value_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:189:5: (lv_value_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:189:5: (lv_value_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:190:6: lv_value_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue638); 

                    						doneLeaf(lv_value_1_0, elementTypeProvider.getSingleValue_ValueIDTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:201:3: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:201:3: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:202:4: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSingleValue684); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getSingleValue_AlternativeKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:209:4: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:210:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:210:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:211:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:211:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==RULE_STRING) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:212:7: lv_value_3_1= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleValue725); 

                            							doneLeaf(lv_value_3_1, elementTypeProvider.getSingleValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:220:7: lv_value_3_2= RULE_STRING
                            {

                            							markLeaf();
                            						
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue763); 

                            							doneLeaf(lv_value_3_2, elementTypeProvider.getSingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:232:3: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:232:3: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:233:4: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSingleValue817); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getSingleValue_StringKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:240:4: ( (lv_value_5_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:241:5: (lv_value_5_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:241:5: (lv_value_5_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:242:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleValue849); 

                    						doneLeaf(lv_value_5_0, elementTypeProvider.getSingleValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }


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
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleMultiValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:256:1: entryRuleMultiValue : ruleMultiValue EOF ;
    public final void entryRuleMultiValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:256:20: ( ruleMultiValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:257:2: ruleMultiValue EOF
            {
             markComposite(elementTypeProvider.getMultiValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiValue_in_entryRuleMultiValue887);
            ruleMultiValue();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiValue893); 

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
    // $ANTLR end "entryRuleMultiValue"


    // $ANTLR start "ruleMultiValue"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:265:1: ruleMultiValue : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final void ruleMultiValue() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:265:15: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:266:2: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:266:2: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt7=1;
                }
                break;
            case 17:
                {
                alt7=2;
                }
                break;
            case 18:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:267:3: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:267:3: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:268:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMultiValue922); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getMultiValue_IdsKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:275:4: ( (lv_value_1_0= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:276:5: (lv_value_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:276:5: (lv_value_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:277:6: lv_value_1_0= RULE_ID
                    {

                    						markLeaf();
                    					
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue954); 

                    						doneLeaf(lv_value_1_0, elementTypeProvider.getMultiValue_ValueIDTerminalRuleCall_0_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:288:3: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:288:3: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:289:4: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleMultiValue1000); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getMultiValue_AlternativesKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:296:4: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:297:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:297:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:298:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:298:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==RULE_STRING) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:299:7: lv_value_3_1= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMultiValue1041); 

                            							doneLeaf(lv_value_3_1, elementTypeProvider.getMultiValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:307:7: lv_value_3_2= RULE_STRING
                            {

                            							markLeaf();
                            						
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue1079); 

                            							doneLeaf(lv_value_3_2, elementTypeProvider.getMultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:319:3: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:319:3: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:320:4: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMultiValue1133); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getMultiValue_StringsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:327:4: ( (lv_value_5_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:328:5: (lv_value_5_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:328:5: (lv_value_5_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:329:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMultiValue1165); 

                    						doneLeaf(lv_value_5_0, elementTypeProvider.getMultiValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }


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
    // $ANTLR end "ruleMultiValue"


    // $ANTLR start "entryRuleSingleDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:343:1: entryRuleSingleDatatype : ruleSingleDatatype EOF ;
    public final void entryRuleSingleDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:343:24: ( ruleSingleDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:344:2: ruleSingleDatatype EOF
            {
             markComposite(elementTypeProvider.getSingleDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype1203);
            ruleSingleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleDatatype1209); 

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
    // $ANTLR end "entryRuleSingleDatatype"


    // $ANTLR start "ruleSingleDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:352:1: ruleSingleDatatype : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final void ruleSingleDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:352:19: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:353:2: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:353:2: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt9=1;
                }
                break;
            case 20:
                {
                alt9=2;
                }
                break;
            case 21:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:354:3: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:354:3: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:355:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleDatatype1238); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getSingleDatatype_DatatypeidKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:362:4: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:363:5: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:363:5: (lv_value_1_0= ruleIdDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:364:6: lv_value_1_0= ruleIdDatatype
                    {

                    						markComposite(elementTypeProvider.getSingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype1270);
                    ruleIdDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:375:3: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:375:3: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:376:4: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSingleDatatype1316); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getSingleDatatype_DatatypealternativeKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:383:4: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:384:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:384:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:385:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:385:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_ID) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==RULE_STRING) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:386:7: lv_value_3_1= ruleIdDatatype
                            {

                            							markComposite(elementTypeProvider.getSingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleSingleDatatype1357);
                            ruleIdDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:394:7: lv_value_3_2= ruleStringDatatype
                            {

                            							markComposite(elementTypeProvider.getSingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype1395);
                            ruleStringDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:406:3: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:406:3: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:407:4: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSingleDatatype1449); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getSingleDatatype_DatatypestringKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:414:4: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:415:5: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:415:5: (lv_value_5_0= ruleStringDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:416:6: lv_value_5_0= ruleStringDatatype
                    {

                    						markComposite(elementTypeProvider.getSingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleSingleDatatype1481);
                    ruleStringDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


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
    // $ANTLR end "ruleSingleDatatype"


    // $ANTLR start "entryRuleMultiDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:430:1: entryRuleMultiDatatype : ruleMultiDatatype EOF ;
    public final void entryRuleMultiDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:430:23: ( ruleMultiDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:431:2: ruleMultiDatatype EOF
            {
             markComposite(elementTypeProvider.getMultiDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype1519);
            ruleMultiDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiDatatype1525); 

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
    // $ANTLR end "entryRuleMultiDatatype"


    // $ANTLR start "ruleMultiDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:439:1: ruleMultiDatatype : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final void ruleMultiDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:439:18: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:440:2: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:440:2: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt11=1;
                }
                break;
            case 23:
                {
                alt11=2;
                }
                break;
            case 24:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:441:3: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:441:3: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:442:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMultiDatatype1554); 

                    				doneLeaf(otherlv_0, elementTypeProvider.getMultiDatatype_DatatypeidsKeyword_0_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:449:4: ( (lv_value_1_0= ruleIdDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:450:5: (lv_value_1_0= ruleIdDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:450:5: (lv_value_1_0= ruleIdDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:451:6: lv_value_1_0= ruleIdDatatype
                    {

                    						markComposite(elementTypeProvider.getMultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1586);
                    ruleIdDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:462:3: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:462:3: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:463:4: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMultiDatatype1632); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getMultiDatatype_DatatypealternativesKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:470:4: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:471:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:471:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:472:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:472:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RULE_STRING) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:473:7: lv_value_3_1= ruleIdDatatype
                            {

                            							markComposite(elementTypeProvider.getMultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1673);
                            ruleIdDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:481:7: lv_value_3_2= ruleStringDatatype
                            {

                            							markComposite(elementTypeProvider.getMultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1711);
                            ruleStringDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:493:3: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:493:3: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:494:4: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMultiDatatype1765); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getMultiDatatype_DatatypestringsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:501:4: ( (lv_value_5_0= ruleStringDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:502:5: (lv_value_5_0= ruleStringDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:502:5: (lv_value_5_0= ruleStringDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:503:6: lv_value_5_0= ruleStringDatatype
                    {

                    						markComposite(elementTypeProvider.getMultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1797);
                    ruleStringDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


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
    // $ANTLR end "ruleMultiDatatype"


    // $ANTLR start "entryRuleIdDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:517:1: entryRuleIdDatatype : ruleIdDatatype EOF ;
    public final void entryRuleIdDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:517:20: ( ruleIdDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:518:2: ruleIdDatatype EOF
            {
             markComposite(elementTypeProvider.getIdDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1835);
            ruleIdDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdDatatype1841); 

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
    // $ANTLR end "entryRuleIdDatatype"


    // $ANTLR start "ruleIdDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:526:1: ruleIdDatatype : this_ID_0= RULE_ID ;
    public final void ruleIdDatatype() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:526:15: (this_ID_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:527:2: this_ID_0= RULE_ID
            {

            		markLeaf();
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIdDatatype1859); 

            		doneLeaf(this_ID_0, elementTypeProvider.getIdDatatype_IDTerminalRuleCallElementType());
            	

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
    // $ANTLR end "ruleIdDatatype"


    // $ANTLR start "entryRuleStringDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:537:1: entryRuleStringDatatype : ruleStringDatatype EOF ;
    public final void entryRuleStringDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:537:24: ( ruleStringDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:538:2: ruleStringDatatype EOF
            {
             markComposite(elementTypeProvider.getStringDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1875);
            ruleStringDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringDatatype1881); 

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
    // $ANTLR end "entryRuleStringDatatype"


    // $ANTLR start "ruleStringDatatype"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:546:1: ruleStringDatatype : this_STRING_0= RULE_STRING ;
    public final void ruleStringDatatype() throws RecognitionException {
        Token this_STRING_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:546:19: (this_STRING_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/assignments/idea/parser/antlr/internal/PsiInternalAssignmentsTestLanguage.g:547:2: this_STRING_0= RULE_STRING
            {

            		markLeaf();
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleStringDatatype1899); 

            		doneLeaf(this_STRING_0, elementTypeProvider.getStringDatatype_STRINGTerminalRuleCallElementType());
            	

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
    // $ANTLR end "ruleStringDatatype"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel89 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel370 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_ruleSingleValue_in_ruleModel411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_ruleModel449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_ruleModel487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_ruleModel525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleValue_in_entryRuleSingleValue571 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleValue577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSingleValue606 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleSingleValue684 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleValue725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleSingleValue817 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleValue849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiValue_in_entryRuleMultiValue887 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiValue893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleMultiValue922 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleMultiValue1000 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMultiValue1041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue1079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMultiValue1133 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiValue1165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleDatatype_in_entryRuleSingleDatatype1203 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleDatatype1209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleSingleDatatype1238 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype1270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleSingleDatatype1316 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleSingleDatatype1357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype1395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleSingleDatatype1449 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleSingleDatatype1481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiDatatype_in_entryRuleMultiDatatype1519 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiDatatype1525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleMultiDatatype1554 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleMultiDatatype1632 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_ruleMultiDatatype1673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleMultiDatatype1765 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_ruleMultiDatatype1797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdDatatype_in_entryRuleIdDatatype1835 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdDatatype1841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIdDatatype1859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringDatatype_in_entryRuleStringDatatype1875 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringDatatype1881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleStringDatatype1899 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.parser.assignments.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
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
    public String getGrammarFileName() { return "PsiInternalAssignmentsTestLanguage.g"; }



    	protected AssignmentsTestLanguageGrammarAccess grammarAccess;

    	protected AssignmentsTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalAssignmentsTestLanguageParser(PsiBuilder builder, TokenStream input, AssignmentsTestLanguageElementTypeProvider elementTypeProvider, AssignmentsTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalAssignmentsTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalAssignmentsTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:58:1: ruleModel : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_5=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:58:10: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:59:2: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:59:2: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:60:3: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:60:3: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:61:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_SimpleKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:68:4: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            // PsiInternalAssignmentsTestLanguage.g:69:5: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:69:5: ( (lv_single_1_0= ruleSingleValue ) )
                            // PsiInternalAssignmentsTestLanguage.g:70:6: (lv_single_1_0= ruleSingleValue )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:70:6: (lv_single_1_0= ruleSingleValue )
                            // PsiInternalAssignmentsTestLanguage.g:71:7: lv_single_1_0= ruleSingleValue
                            {

                            							markComposite(elementTypeProvider.getModel_SingleSingleValueParserRuleCall_0_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleSingleValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:81:5: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:81:5: ( (lv_multi_2_0= ruleMultiValue ) )
                            // PsiInternalAssignmentsTestLanguage.g:82:6: (lv_multi_2_0= ruleMultiValue )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:82:6: (lv_multi_2_0= ruleMultiValue )
                            // PsiInternalAssignmentsTestLanguage.g:83:7: lv_multi_2_0= ruleMultiValue
                            {

                            							markComposite(elementTypeProvider.getModel_MultiMultiValueParserRuleCall_0_1_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleMultiValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 3 :
                            // PsiInternalAssignmentsTestLanguage.g:93:5: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:93:5: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // PsiInternalAssignmentsTestLanguage.g:94:6: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:94:6: (lv_single_3_0= ruleSingleDatatype )
                            // PsiInternalAssignmentsTestLanguage.g:95:7: lv_single_3_0= ruleSingleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_SingleSingleDatatypeParserRuleCall_0_1_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleSingleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;
                        case 4 :
                            // PsiInternalAssignmentsTestLanguage.g:105:5: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:105:5: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // PsiInternalAssignmentsTestLanguage.g:106:6: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:106:6: (lv_multi_4_0= ruleMultiDatatype )
                            // PsiInternalAssignmentsTestLanguage.g:107:7: lv_multi_4_0= ruleMultiDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiMultiDatatypeParserRuleCall_0_1_3_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
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
                    // PsiInternalAssignmentsTestLanguage.g:119:3: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:119:3: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:120:4: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_ComplexKeyword_1_0ElementType());
                    			
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_5);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:127:4: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:128:5: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:128:5: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:129:6: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:129:6: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            // PsiInternalAssignmentsTestLanguage.g:130:7: lv_object_6_1= ruleSingleValue
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectSingleValueParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleSingleValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:138:7: lv_object_6_2= ruleMultiValue
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectMultiValueParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleMultiValue();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 3 :
                            // PsiInternalAssignmentsTestLanguage.g:146:7: lv_object_6_3= ruleSingleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectSingleDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleSingleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // PsiInternalAssignmentsTestLanguage.g:154:7: lv_object_6_4= ruleMultiDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectMultiDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalAssignmentsTestLanguage.g:169:1: entryRuleSingleValue : ruleSingleValue EOF ;
    public final void entryRuleSingleValue() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:169:21: ( ruleSingleValue EOF )
            // PsiInternalAssignmentsTestLanguage.g:170:2: ruleSingleValue EOF
            {
             markComposite(elementTypeProvider.getSingleValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSingleValue();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:175:1: ruleSingleValue : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final void ruleSingleValue() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:175:16: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:176:2: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:176:2: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:177:3: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:177:3: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:178:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleValue_IdKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:185:4: ( (lv_value_1_0= RULE_ID ) )
                    // PsiInternalAssignmentsTestLanguage.g:186:5: (lv_value_1_0= RULE_ID )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:186:5: (lv_value_1_0= RULE_ID )
                    // PsiInternalAssignmentsTestLanguage.g:187:6: lv_value_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSingleValue_ValueIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:198:3: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:198:3: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:199:4: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleValue_AlternativeKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:206:4: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:207:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:207:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:208:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:208:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // PsiInternalAssignmentsTestLanguage.g:209:7: lv_value_3_1= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getSingleValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());
                            						
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_3_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:217:7: lv_value_3_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getSingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_3_2);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalAssignmentsTestLanguage.g:229:3: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:229:3: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:230:4: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleValue_StringKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:237:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:238:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:238:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalAssignmentsTestLanguage.g:239:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getSingleValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

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
    // PsiInternalAssignmentsTestLanguage.g:253:1: entryRuleMultiValue : ruleMultiValue EOF ;
    public final void entryRuleMultiValue() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:253:20: ( ruleMultiValue EOF )
            // PsiInternalAssignmentsTestLanguage.g:254:2: ruleMultiValue EOF
            {
             markComposite(elementTypeProvider.getMultiValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiValue();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:259:1: ruleMultiValue : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final void ruleMultiValue() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:259:15: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:260:2: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:260:2: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:261:3: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:261:3: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:262:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiValue_IdsKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:269:4: ( (lv_value_1_0= RULE_ID ) )
                    // PsiInternalAssignmentsTestLanguage.g:270:5: (lv_value_1_0= RULE_ID )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:270:5: (lv_value_1_0= RULE_ID )
                    // PsiInternalAssignmentsTestLanguage.g:271:6: lv_value_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getMultiValue_ValueIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:282:3: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:282:3: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:283:4: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiValue_AlternativesKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:290:4: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:291:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:291:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:292:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:292:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // PsiInternalAssignmentsTestLanguage.g:293:7: lv_value_3_1= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getMultiValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());
                            						
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_3_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:301:7: lv_value_3_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getMultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_3_2);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalAssignmentsTestLanguage.g:313:3: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:313:3: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:314:4: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiValue_StringsKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:321:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:322:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:322:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalAssignmentsTestLanguage.g:323:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getMultiValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

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
    // PsiInternalAssignmentsTestLanguage.g:337:1: entryRuleSingleDatatype : ruleSingleDatatype EOF ;
    public final void entryRuleSingleDatatype() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:337:24: ( ruleSingleDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:338:2: ruleSingleDatatype EOF
            {
             markComposite(elementTypeProvider.getSingleDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSingleDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:343:1: ruleSingleDatatype : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final void ruleSingleDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:343:19: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:344:2: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:344:2: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:345:3: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:345:3: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:346:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleDatatype_DatatypeidKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:353:4: ( (lv_value_1_0= ruleIdDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:354:5: (lv_value_1_0= ruleIdDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:354:5: (lv_value_1_0= ruleIdDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:355:6: lv_value_1_0= ruleIdDatatype
                    {

                    						markComposite(elementTypeProvider.getSingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIdDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:366:3: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:366:3: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:367:4: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleDatatype_DatatypealternativeKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:374:4: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:375:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:375:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:376:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:376:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // PsiInternalAssignmentsTestLanguage.g:377:7: lv_value_3_1= ruleIdDatatype
                            {

                            							markComposite(elementTypeProvider.getSingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleIdDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:385:7: lv_value_3_2= ruleStringDatatype
                            {

                            							markComposite(elementTypeProvider.getSingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
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
                    // PsiInternalAssignmentsTestLanguage.g:397:3: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:397:3: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:398:4: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleDatatype_DatatypestringKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:405:4: ( (lv_value_5_0= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:406:5: (lv_value_5_0= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:406:5: (lv_value_5_0= ruleStringDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:407:6: lv_value_5_0= ruleStringDatatype
                    {

                    						markComposite(elementTypeProvider.getSingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalAssignmentsTestLanguage.g:421:1: entryRuleMultiDatatype : ruleMultiDatatype EOF ;
    public final void entryRuleMultiDatatype() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:421:23: ( ruleMultiDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:422:2: ruleMultiDatatype EOF
            {
             markComposite(elementTypeProvider.getMultiDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMultiDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:427:1: ruleMultiDatatype : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final void ruleMultiDatatype() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:427:18: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:428:2: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:428:2: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:429:3: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:429:3: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:430:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiDatatype_DatatypeidsKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:437:4: ( (lv_value_1_0= ruleIdDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:438:5: (lv_value_1_0= ruleIdDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:438:5: (lv_value_1_0= ruleIdDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:439:6: lv_value_1_0= ruleIdDatatype
                    {

                    						markComposite(elementTypeProvider.getMultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleIdDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:450:3: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:450:3: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:451:4: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiDatatype_DatatypealternativesKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:458:4: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:459:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:459:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:460:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:460:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // PsiInternalAssignmentsTestLanguage.g:461:7: lv_value_3_1= ruleIdDatatype
                            {

                            							markComposite(elementTypeProvider.getMultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleIdDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:469:7: lv_value_3_2= ruleStringDatatype
                            {

                            							markComposite(elementTypeProvider.getMultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
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
                    // PsiInternalAssignmentsTestLanguage.g:481:3: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:481:3: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:482:4: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiDatatype_DatatypestringsKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:489:4: ( (lv_value_5_0= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:490:5: (lv_value_5_0= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:490:5: (lv_value_5_0= ruleStringDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:491:6: lv_value_5_0= ruleStringDatatype
                    {

                    						markComposite(elementTypeProvider.getMultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // PsiInternalAssignmentsTestLanguage.g:505:1: entryRuleIdDatatype : ruleIdDatatype EOF ;
    public final void entryRuleIdDatatype() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:505:20: ( ruleIdDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:506:2: ruleIdDatatype EOF
            {
             markComposite(elementTypeProvider.getIdDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleIdDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:511:1: ruleIdDatatype : this_ID_0= RULE_ID ;
    public final void ruleIdDatatype() throws RecognitionException {
        Token this_ID_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:511:15: (this_ID_0= RULE_ID )
            // PsiInternalAssignmentsTestLanguage.g:512:2: this_ID_0= RULE_ID
            {

            		markLeaf(elementTypeProvider.getIdDatatype_IDTerminalRuleCallElementType());
            	
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            		doneLeaf(this_ID_0);
            	

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
    // PsiInternalAssignmentsTestLanguage.g:522:1: entryRuleStringDatatype : ruleStringDatatype EOF ;
    public final void entryRuleStringDatatype() throws RecognitionException {
        try {
            // PsiInternalAssignmentsTestLanguage.g:522:24: ( ruleStringDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:523:2: ruleStringDatatype EOF
            {
             markComposite(elementTypeProvider.getStringDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStringDatatype();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // PsiInternalAssignmentsTestLanguage.g:528:1: ruleStringDatatype : this_STRING_0= RULE_STRING ;
    public final void ruleStringDatatype() throws RecognitionException {
        Token this_STRING_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:528:19: (this_STRING_0= RULE_STRING )
            // PsiInternalAssignmentsTestLanguage.g:529:2: this_STRING_0= RULE_STRING
            {

            		markLeaf(elementTypeProvider.getStringDatatype_STRINGTerminalRuleCallElementType());
            	
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            		doneLeaf(this_STRING_0);
            	

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001FFE000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    }


}
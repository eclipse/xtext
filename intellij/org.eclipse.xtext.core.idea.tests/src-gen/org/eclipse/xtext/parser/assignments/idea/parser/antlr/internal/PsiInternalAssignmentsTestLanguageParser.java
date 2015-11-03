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
    // PsiInternalAssignmentsTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalAssignmentsTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalAssignmentsTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_5=null;
        Boolean lv_single_1_0 = null;

        Boolean lv_multi_2_0 = null;

        Boolean lv_single_3_0 = null;

        Boolean lv_multi_4_0 = null;

        Boolean lv_object_6_1 = null;

        Boolean lv_object_6_2 = null;

        Boolean lv_object_6_3 = null;

        Boolean lv_object_6_4 = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:60:1: ( ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:61:2: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:61:2: ( (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) ) | (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:62:3: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:62:3: (otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:63:4: otherlv_0= 'simple' ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_SimpleKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:70:4: ( ( (lv_single_1_0= ruleSingleValue ) ) | ( (lv_multi_2_0= ruleMultiValue ) ) | ( (lv_single_3_0= ruleSingleDatatype ) ) | ( (lv_multi_4_0= ruleMultiDatatype ) ) )
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
                            // PsiInternalAssignmentsTestLanguage.g:71:5: ( (lv_single_1_0= ruleSingleValue ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:71:5: ( (lv_single_1_0= ruleSingleValue ) )
                            // PsiInternalAssignmentsTestLanguage.g:72:6: (lv_single_1_0= ruleSingleValue )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:72:6: (lv_single_1_0= ruleSingleValue )
                            // PsiInternalAssignmentsTestLanguage.g:73:7: lv_single_1_0= ruleSingleValue
                            {

                            							markComposite(elementTypeProvider.getModel_SingleSingleValueParserRuleCall_0_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_single_1_0=ruleSingleValue();

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
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:87:5: ( (lv_multi_2_0= ruleMultiValue ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:87:5: ( (lv_multi_2_0= ruleMultiValue ) )
                            // PsiInternalAssignmentsTestLanguage.g:88:6: (lv_multi_2_0= ruleMultiValue )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:88:6: (lv_multi_2_0= ruleMultiValue )
                            // PsiInternalAssignmentsTestLanguage.g:89:7: lv_multi_2_0= ruleMultiValue
                            {

                            							markComposite(elementTypeProvider.getModel_MultiMultiValueParserRuleCall_0_1_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_multi_2_0=ruleMultiValue();

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
                        case 3 :
                            // PsiInternalAssignmentsTestLanguage.g:103:5: ( (lv_single_3_0= ruleSingleDatatype ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:103:5: ( (lv_single_3_0= ruleSingleDatatype ) )
                            // PsiInternalAssignmentsTestLanguage.g:104:6: (lv_single_3_0= ruleSingleDatatype )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:104:6: (lv_single_3_0= ruleSingleDatatype )
                            // PsiInternalAssignmentsTestLanguage.g:105:7: lv_single_3_0= ruleSingleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_SingleSingleDatatypeParserRuleCall_0_1_2_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_single_3_0=ruleSingleDatatype();

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
                        case 4 :
                            // PsiInternalAssignmentsTestLanguage.g:119:5: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:119:5: ( (lv_multi_4_0= ruleMultiDatatype ) )
                            // PsiInternalAssignmentsTestLanguage.g:120:6: (lv_multi_4_0= ruleMultiDatatype )
                            {
                            // PsiInternalAssignmentsTestLanguage.g:120:6: (lv_multi_4_0= ruleMultiDatatype )
                            // PsiInternalAssignmentsTestLanguage.g:121:7: lv_multi_4_0= ruleMultiDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiMultiDatatypeParserRuleCall_0_1_3_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_multi_4_0=ruleMultiDatatype();

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

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:137:3: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:137:3: (otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:138:4: otherlv_5= 'complex' ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_ComplexKeyword_1_0ElementType());
                    			
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_5);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:145:4: ( ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:146:5: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:146:5: ( (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:147:6: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:147:6: (lv_object_6_1= ruleSingleValue | lv_object_6_2= ruleMultiValue | lv_object_6_3= ruleSingleDatatype | lv_object_6_4= ruleMultiDatatype )
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
                            // PsiInternalAssignmentsTestLanguage.g:148:7: lv_object_6_1= ruleSingleValue
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectSingleValueParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_1=ruleSingleValue();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:160:7: lv_object_6_2= ruleMultiValue
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectMultiValueParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_2=ruleMultiValue();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 3 :
                            // PsiInternalAssignmentsTestLanguage.g:172:7: lv_object_6_3= ruleSingleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectSingleDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_3=ruleSingleDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 4 :
                            // PsiInternalAssignmentsTestLanguage.g:184:7: lv_object_6_4= ruleMultiDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ObjectMultiDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_object_6_4=ruleMultiDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSingleValue"
    // PsiInternalAssignmentsTestLanguage.g:203:1: entryRuleSingleValue returns [Boolean current=false] : iv_ruleSingleValue= ruleSingleValue EOF ;
    public final Boolean entryRuleSingleValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleValue = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:203:53: (iv_ruleSingleValue= ruleSingleValue EOF )
            // PsiInternalAssignmentsTestLanguage.g:204:2: iv_ruleSingleValue= ruleSingleValue EOF
            {
             markComposite(elementTypeProvider.getSingleValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleValue=ruleSingleValue();

            state._fsp--;

             current =iv_ruleSingleValue; 
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
    // $ANTLR end "entryRuleSingleValue"


    // $ANTLR start "ruleSingleValue"
    // PsiInternalAssignmentsTestLanguage.g:210:1: ruleSingleValue returns [Boolean current=false] : ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final Boolean ruleSingleValue() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:211:1: ( ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:212:2: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:212:2: ( (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:213:3: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:213:3: (otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:214:4: otherlv_0= 'id' ( (lv_value_1_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleValue_IdKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:221:4: ( (lv_value_1_0= RULE_ID ) )
                    // PsiInternalAssignmentsTestLanguage.g:222:5: (lv_value_1_0= RULE_ID )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:222:5: (lv_value_1_0= RULE_ID )
                    // PsiInternalAssignmentsTestLanguage.g:223:6: lv_value_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSingleValue_ValueIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_value_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:240:3: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:240:3: (otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:241:4: otherlv_2= 'alternative' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleValue_AlternativeKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:248:4: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:249:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:249:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:250:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:250:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // PsiInternalAssignmentsTestLanguage.g:251:7: lv_value_3_1= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getSingleValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());
                            						
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							doneLeaf(lv_value_3_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:265:7: lv_value_3_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getSingleValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

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
                    // PsiInternalAssignmentsTestLanguage.g:283:3: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:283:3: (otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:284:4: otherlv_4= 'string' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleValue_StringKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:291:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:292:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:292:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalAssignmentsTestLanguage.g:293:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getSingleValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleSingleValue"


    // $ANTLR start "entryRuleMultiValue"
    // PsiInternalAssignmentsTestLanguage.g:313:1: entryRuleMultiValue returns [Boolean current=false] : iv_ruleMultiValue= ruleMultiValue EOF ;
    public final Boolean entryRuleMultiValue() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiValue = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:313:52: (iv_ruleMultiValue= ruleMultiValue EOF )
            // PsiInternalAssignmentsTestLanguage.g:314:2: iv_ruleMultiValue= ruleMultiValue EOF
            {
             markComposite(elementTypeProvider.getMultiValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiValue=ruleMultiValue();

            state._fsp--;

             current =iv_ruleMultiValue; 
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
    // $ANTLR end "entryRuleMultiValue"


    // $ANTLR start "ruleMultiValue"
    // PsiInternalAssignmentsTestLanguage.g:320:1: ruleMultiValue returns [Boolean current=false] : ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) ;
    public final Boolean ruleMultiValue() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_1=null;
        Token lv_value_3_2=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:321:1: ( ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:322:2: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:322:2: ( (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) ) | (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) ) | (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:323:3: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:323:3: (otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:324:4: otherlv_0= 'ids' ( (lv_value_1_0= RULE_ID ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiValue_IdsKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:331:4: ( (lv_value_1_0= RULE_ID ) )
                    // PsiInternalAssignmentsTestLanguage.g:332:5: (lv_value_1_0= RULE_ID )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:332:5: (lv_value_1_0= RULE_ID )
                    // PsiInternalAssignmentsTestLanguage.g:333:6: lv_value_1_0= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getMultiValue_ValueIDTerminalRuleCall_0_1_0ElementType());
                    					
                    lv_value_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

                    						doneLeaf(lv_value_1_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalAssignmentsTestLanguage.g:350:3: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:350:3: (otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:351:4: otherlv_2= 'alternatives' ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiValue_AlternativesKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:358:4: ( ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:359:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:359:5: ( (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:360:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:360:6: (lv_value_3_1= RULE_ID | lv_value_3_2= RULE_STRING )
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
                            // PsiInternalAssignmentsTestLanguage.g:361:7: lv_value_3_1= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getMultiValue_ValueIDTerminalRuleCall_1_1_0_0ElementType());
                            						
                            lv_value_3_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            							doneLeaf(lv_value_3_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:375:7: lv_value_3_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getMultiValue_ValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						
                            lv_value_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

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
                    // PsiInternalAssignmentsTestLanguage.g:393:3: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:393:3: (otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:394:4: otherlv_4= 'strings' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiValue_StringsKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,18,FollowSets000.FOLLOW_6); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:401:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalAssignmentsTestLanguage.g:402:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:402:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalAssignmentsTestLanguage.g:403:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getMultiValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					

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
        return current;
    }
    // $ANTLR end "ruleMultiValue"


    // $ANTLR start "entryRuleSingleDatatype"
    // PsiInternalAssignmentsTestLanguage.g:423:1: entryRuleSingleDatatype returns [Boolean current=false] : iv_ruleSingleDatatype= ruleSingleDatatype EOF ;
    public final Boolean entryRuleSingleDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleSingleDatatype = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:423:56: (iv_ruleSingleDatatype= ruleSingleDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:424:2: iv_ruleSingleDatatype= ruleSingleDatatype EOF
            {
             markComposite(elementTypeProvider.getSingleDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleDatatype=ruleSingleDatatype();

            state._fsp--;

             current =iv_ruleSingleDatatype; 
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
    // $ANTLR end "entryRuleSingleDatatype"


    // $ANTLR start "ruleSingleDatatype"
    // PsiInternalAssignmentsTestLanguage.g:430:1: ruleSingleDatatype returns [Boolean current=false] : ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final Boolean ruleSingleDatatype() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_value_1_0 = null;

        Boolean lv_value_3_1 = null;

        Boolean lv_value_3_2 = null;

        Boolean lv_value_5_0 = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:431:1: ( ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:432:2: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:432:2: ( (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:433:3: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:433:3: (otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:434:4: otherlv_0= 'datatypeid' ( (lv_value_1_0= ruleIdDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleDatatype_DatatypeidKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:441:4: ( (lv_value_1_0= ruleIdDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:442:5: (lv_value_1_0= ruleIdDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:442:5: (lv_value_1_0= ruleIdDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:443:6: lv_value_1_0= ruleIdDatatype
                    {

                    						markComposite(elementTypeProvider.getSingleDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_1_0=ruleIdDatatype();

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
                    // PsiInternalAssignmentsTestLanguage.g:458:3: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:458:3: (otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:459:4: otherlv_2= 'datatypealternative' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleDatatype_DatatypealternativeKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,20,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:466:4: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:467:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:467:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:468:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:468:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // PsiInternalAssignmentsTestLanguage.g:469:7: lv_value_3_1= ruleIdDatatype
                            {

                            							markComposite(elementTypeProvider.getSingleDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_1=ruleIdDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:481:7: lv_value_3_2= ruleStringDatatype
                            {

                            							markComposite(elementTypeProvider.getSingleDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_2=ruleStringDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
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
                    break;
                case 3 :
                    // PsiInternalAssignmentsTestLanguage.g:497:3: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:497:3: (otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:498:4: otherlv_4= 'datatypestring' ( (lv_value_5_0= ruleStringDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getSingleDatatype_DatatypestringKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:505:4: ( (lv_value_5_0= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:506:5: (lv_value_5_0= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:506:5: (lv_value_5_0= ruleStringDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:507:6: lv_value_5_0= ruleStringDatatype
                    {

                    						markComposite(elementTypeProvider.getSingleDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_5_0=ruleStringDatatype();

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
    // $ANTLR end "ruleSingleDatatype"


    // $ANTLR start "entryRuleMultiDatatype"
    // PsiInternalAssignmentsTestLanguage.g:525:1: entryRuleMultiDatatype returns [Boolean current=false] : iv_ruleMultiDatatype= ruleMultiDatatype EOF ;
    public final Boolean entryRuleMultiDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMultiDatatype = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:525:55: (iv_ruleMultiDatatype= ruleMultiDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:526:2: iv_ruleMultiDatatype= ruleMultiDatatype EOF
            {
             markComposite(elementTypeProvider.getMultiDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMultiDatatype=ruleMultiDatatype();

            state._fsp--;

             current =iv_ruleMultiDatatype; 
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
    // $ANTLR end "entryRuleMultiDatatype"


    // $ANTLR start "ruleMultiDatatype"
    // PsiInternalAssignmentsTestLanguage.g:532:1: ruleMultiDatatype returns [Boolean current=false] : ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) ;
    public final Boolean ruleMultiDatatype() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_value_1_0 = null;

        Boolean lv_value_3_1 = null;

        Boolean lv_value_3_2 = null;

        Boolean lv_value_5_0 = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:533:1: ( ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) ) )
            // PsiInternalAssignmentsTestLanguage.g:534:2: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
            {
            // PsiInternalAssignmentsTestLanguage.g:534:2: ( (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) ) | (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) ) | (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) ) )
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
                    // PsiInternalAssignmentsTestLanguage.g:535:3: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:535:3: (otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:536:4: otherlv_0= 'datatypeids' ( (lv_value_1_0= ruleIdDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiDatatype_DatatypeidsKeyword_0_0ElementType());
                    			
                    otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_0);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:543:4: ( (lv_value_1_0= ruleIdDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:544:5: (lv_value_1_0= ruleIdDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:544:5: (lv_value_1_0= ruleIdDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:545:6: lv_value_1_0= ruleIdDatatype
                    {

                    						markComposite(elementTypeProvider.getMultiDatatype_ValueIdDatatypeParserRuleCall_0_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_1_0=ruleIdDatatype();

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
                    // PsiInternalAssignmentsTestLanguage.g:560:3: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:560:3: (otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:561:4: otherlv_2= 'datatypealternatives' ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiDatatype_DatatypealternativesKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:568:4: ( ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:569:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:569:5: ( (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:570:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:570:6: (lv_value_3_1= ruleIdDatatype | lv_value_3_2= ruleStringDatatype )
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
                            // PsiInternalAssignmentsTestLanguage.g:571:7: lv_value_3_1= ruleIdDatatype
                            {

                            							markComposite(elementTypeProvider.getMultiDatatype_ValueIdDatatypeParserRuleCall_1_1_0_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_1=ruleIdDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalAssignmentsTestLanguage.g:583:7: lv_value_3_2= ruleStringDatatype
                            {

                            							markComposite(elementTypeProvider.getMultiDatatype_ValueStringDatatypeParserRuleCall_1_1_0_1ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_3_2=ruleStringDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
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
                    break;
                case 3 :
                    // PsiInternalAssignmentsTestLanguage.g:599:3: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:599:3: (otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) ) )
                    // PsiInternalAssignmentsTestLanguage.g:600:4: otherlv_4= 'datatypestrings' ( (lv_value_5_0= ruleStringDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getMultiDatatype_DatatypestringsKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalAssignmentsTestLanguage.g:607:4: ( (lv_value_5_0= ruleStringDatatype ) )
                    // PsiInternalAssignmentsTestLanguage.g:608:5: (lv_value_5_0= ruleStringDatatype )
                    {
                    // PsiInternalAssignmentsTestLanguage.g:608:5: (lv_value_5_0= ruleStringDatatype )
                    // PsiInternalAssignmentsTestLanguage.g:609:6: lv_value_5_0= ruleStringDatatype
                    {

                    						markComposite(elementTypeProvider.getMultiDatatype_ValueStringDatatypeParserRuleCall_2_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_5_0=ruleStringDatatype();

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
    // $ANTLR end "ruleMultiDatatype"


    // $ANTLR start "entryRuleIdDatatype"
    // PsiInternalAssignmentsTestLanguage.g:627:1: entryRuleIdDatatype returns [Boolean current=false] : iv_ruleIdDatatype= ruleIdDatatype EOF ;
    public final Boolean entryRuleIdDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleIdDatatype = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:627:52: (iv_ruleIdDatatype= ruleIdDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:628:2: iv_ruleIdDatatype= ruleIdDatatype EOF
            {
             markComposite(elementTypeProvider.getIdDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIdDatatype=ruleIdDatatype();

            state._fsp--;

             current =iv_ruleIdDatatype; 
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
    // $ANTLR end "entryRuleIdDatatype"


    // $ANTLR start "ruleIdDatatype"
    // PsiInternalAssignmentsTestLanguage.g:634:1: ruleIdDatatype returns [Boolean current=false] : this_ID_0= RULE_ID ;
    public final Boolean ruleIdDatatype() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:635:1: (this_ID_0= RULE_ID )
            // PsiInternalAssignmentsTestLanguage.g:636:2: this_ID_0= RULE_ID
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
        return current;
    }
    // $ANTLR end "ruleIdDatatype"


    // $ANTLR start "entryRuleStringDatatype"
    // PsiInternalAssignmentsTestLanguage.g:646:1: entryRuleStringDatatype returns [Boolean current=false] : iv_ruleStringDatatype= ruleStringDatatype EOF ;
    public final Boolean entryRuleStringDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStringDatatype = null;


        try {
            // PsiInternalAssignmentsTestLanguage.g:646:56: (iv_ruleStringDatatype= ruleStringDatatype EOF )
            // PsiInternalAssignmentsTestLanguage.g:647:2: iv_ruleStringDatatype= ruleStringDatatype EOF
            {
             markComposite(elementTypeProvider.getStringDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStringDatatype=ruleStringDatatype();

            state._fsp--;

             current =iv_ruleStringDatatype; 
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
    // $ANTLR end "entryRuleStringDatatype"


    // $ANTLR start "ruleStringDatatype"
    // PsiInternalAssignmentsTestLanguage.g:653:1: ruleStringDatatype returns [Boolean current=false] : this_STRING_0= RULE_STRING ;
    public final Boolean ruleStringDatatype() throws RecognitionException {
        Boolean current = false;

        Token this_STRING_0=null;

        try {
            // PsiInternalAssignmentsTestLanguage.g:654:1: (this_STRING_0= RULE_STRING )
            // PsiInternalAssignmentsTestLanguage.g:655:2: this_STRING_0= RULE_STRING
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
        return current;
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
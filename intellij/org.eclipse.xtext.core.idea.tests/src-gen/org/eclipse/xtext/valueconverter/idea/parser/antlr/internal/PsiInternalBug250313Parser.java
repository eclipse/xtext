package org.eclipse.xtext.valueconverter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313ElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug250313Parser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'mykeyword1'", "'1+'", "'2'", "'2+'", "'3'", "'3+'", "'4'", "'4+'", "'content'", "'ref'", "'-'", "'+'"
    };
    public static final int RULE_ID=5;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
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


        public PsiInternalBug250313Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug250313Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug250313Parser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug250313.g"; }



    	protected Bug250313GrammarAccess grammarAccess;

    	protected Bug250313ElementTypeProvider elementTypeProvider;

    	public PsiInternalBug250313Parser(PsiBuilder builder, TokenStream input, Bug250313ElementTypeProvider elementTypeProvider, Bug250313GrammarAccess grammarAccess) {
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
    // PsiInternalBug250313.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:52:15: ( ruleModel EOF )
            // PsiInternalBug250313.g:53:2: ruleModel EOF
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
    // PsiInternalBug250313.g:58:1: ruleModel : ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) ) ;
    public final void ruleModel() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_5=null;
        Token otherlv_2=null;
        Token lv_multiValue_3_1=null;
        Token lv_multiValue_3_2=null;
        Token lv_multiValue_3_5=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        Token lv_multiValue_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_19=null;

        try {
            // PsiInternalBug250313.g:58:10: ( ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) ) )
            // PsiInternalBug250313.g:59:2: ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) )
            {
            // PsiInternalBug250313.g:59:2: ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) )
            int alt6=9;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case 11:
            case 12:
                {
                alt6=1;
                }
                break;
            case 13:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            case 15:
                {
                alt6=4;
                }
                break;
            case 16:
                {
                alt6=5;
                }
                break;
            case 17:
                {
                alt6=6;
                }
                break;
            case 18:
                {
                alt6=7;
                }
                break;
            case 19:
                {
                alt6=8;
                }
                break;
            case 20:
                {
                alt6=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // PsiInternalBug250313.g:60:3: ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    {
                    // PsiInternalBug250313.g:60:3: ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    // PsiInternalBug250313.g:61:4: (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    {
                    // PsiInternalBug250313.g:61:4: (otherlv_0= '1' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalBug250313.g:62:5: otherlv_0= '1'
                            {

                            					markLeaf(elementTypeProvider.getModel_DigitOneKeyword_0_0ElementType());
                            				
                            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_0);
                            				

                            }
                            break;

                    }

                    // PsiInternalBug250313.g:70:4: ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    // PsiInternalBug250313.g:71:5: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    {
                    // PsiInternalBug250313.g:71:5: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    // PsiInternalBug250313.g:72:6: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
                    {
                    // PsiInternalBug250313.g:72:6: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
                    int alt2=5;
                    switch ( input.LA(1) ) {
                    case 12:
                        {
                        alt2=1;
                        }
                        break;
                    case RULE_STRING:
                        {
                        alt2=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        switch ( input.LA(2) ) {
                        case 23:
                            {
                            alt2=3;
                            }
                            break;
                        case EOF:
                            {
                            alt2=5;
                            }
                            break;
                        case 22:
                            {
                            alt2=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // PsiInternalBug250313.g:73:7: lv_value_1_1= 'mykeyword1'
                            {

                            							markLeaf(elementTypeProvider.getModel_ValueMykeyword1Keyword_0_1_0_0ElementType());
                            						
                            lv_value_1_1=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_1_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalBug250313.g:81:7: lv_value_1_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType());
                            						
                            lv_value_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_1_2);
                            						

                            }
                            break;
                        case 3 :
                            // PsiInternalBug250313.g:89:7: lv_value_1_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // PsiInternalBug250313.g:97:7: lv_value_1_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 5 :
                            // PsiInternalBug250313.g:105:7: lv_value_1_5= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getModel_ValueIDTerminalRuleCall_0_1_0_4ElementType());
                            						
                            lv_value_1_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_1_5);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalBug250313.g:117:3: (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    {
                    // PsiInternalBug250313.g:117:3: (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    // PsiInternalBug250313.g:118:4: otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitOnePlusSignKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug250313.g:125:4: ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    // PsiInternalBug250313.g:126:5: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    {
                    // PsiInternalBug250313.g:126:5: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    // PsiInternalBug250313.g:127:6: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
                    {
                    // PsiInternalBug250313.g:127:6: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
                    int alt3=5;
                    switch ( input.LA(1) ) {
                    case 12:
                        {
                        alt3=1;
                        }
                        break;
                    case RULE_STRING:
                        {
                        alt3=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        switch ( input.LA(2) ) {
                        case EOF:
                            {
                            alt3=5;
                            }
                            break;
                        case 22:
                            {
                            alt3=4;
                            }
                            break;
                        case 23:
                            {
                            alt3=3;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // PsiInternalBug250313.g:128:7: lv_multiValue_3_1= 'mykeyword1'
                            {

                            							markLeaf(elementTypeProvider.getModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType());
                            						
                            lv_multiValue_3_1=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_multiValue_3_1);
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalBug250313.g:136:7: lv_multiValue_3_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						
                            lv_multiValue_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_multiValue_3_2);
                            						

                            }
                            break;
                        case 3 :
                            // PsiInternalBug250313.g:144:7: lv_multiValue_3_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // PsiInternalBug250313.g:152:7: lv_multiValue_3_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 5 :
                            // PsiInternalBug250313.g:160:7: lv_multiValue_3_5= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getModel_MultiValueIDTerminalRuleCall_1_1_0_4ElementType());
                            						
                            lv_multiValue_3_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_multiValue_3_5);
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalBug250313.g:172:3: (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalBug250313.g:172:3: (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    // PsiInternalBug250313.g:173:4: otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitTwoKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug250313.g:180:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalBug250313.g:181:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalBug250313.g:181:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalBug250313.g:182:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalBug250313.g:193:3: (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    {
                    // PsiInternalBug250313.g:193:3: (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    // PsiInternalBug250313.g:194:4: otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitTwoPlusSignKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug250313.g:201:4: ( (lv_multiValue_7_0= RULE_STRING ) )
                    // PsiInternalBug250313.g:202:5: (lv_multiValue_7_0= RULE_STRING )
                    {
                    // PsiInternalBug250313.g:202:5: (lv_multiValue_7_0= RULE_STRING )
                    // PsiInternalBug250313.g:203:6: lv_multiValue_7_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_multiValue_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_multiValue_7_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalBug250313.g:214:3: (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:214:3: (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    // PsiInternalBug250313.g:215:4: otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitThreeKeyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalBug250313.g:222:4: ( (lv_value_9_0= ruleDatatype ) )
                    // PsiInternalBug250313.g:223:5: (lv_value_9_0= ruleDatatype )
                    {
                    // PsiInternalBug250313.g:223:5: (lv_value_9_0= ruleDatatype )
                    // PsiInternalBug250313.g:224:6: lv_value_9_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // PsiInternalBug250313.g:235:3: (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:235:3: (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    // PsiInternalBug250313.g:236:4: otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitThreePlusSignKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalBug250313.g:243:4: ( (lv_multiValue_11_0= ruleDatatype ) )
                    // PsiInternalBug250313.g:244:5: (lv_multiValue_11_0= ruleDatatype )
                    {
                    // PsiInternalBug250313.g:244:5: (lv_multiValue_11_0= ruleDatatype )
                    // PsiInternalBug250313.g:245:6: lv_multiValue_11_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // PsiInternalBug250313.g:256:3: (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:256:3: (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    // PsiInternalBug250313.g:257:4: otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitFourKeyword_6_0ElementType());
                    			
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_12);
                    			
                    // PsiInternalBug250313.g:264:4: ( (lv_value_13_0= ruleNestedDatatype ) )
                    // PsiInternalBug250313.g:265:5: (lv_value_13_0= ruleNestedDatatype )
                    {
                    // PsiInternalBug250313.g:265:5: (lv_value_13_0= ruleNestedDatatype )
                    // PsiInternalBug250313.g:266:6: lv_value_13_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNestedDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // PsiInternalBug250313.g:277:3: (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:277:3: (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    // PsiInternalBug250313.g:278:4: otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitFourPlusSignKeyword_7_0ElementType());
                    			
                    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_14);
                    			
                    // PsiInternalBug250313.g:285:4: ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    // PsiInternalBug250313.g:286:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    {
                    // PsiInternalBug250313.g:286:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    // PsiInternalBug250313.g:287:6: lv_multiValue_15_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleNestedDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // PsiInternalBug250313.g:298:3: ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? )
                    {
                    // PsiInternalBug250313.g:298:3: ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? )
                    // PsiInternalBug250313.g:299:4: (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )?
                    {
                    // PsiInternalBug250313.g:299:4: (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) )
                    // PsiInternalBug250313.g:300:5: otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) )
                    {

                    					markLeaf(elementTypeProvider.getModel_ContentKeyword_8_0_0ElementType());
                    				
                    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_6); 

                    					doneLeaf(otherlv_16);
                    				
                    // PsiInternalBug250313.g:307:5: ( (lv_children_17_0= ruleChild ) )
                    // PsiInternalBug250313.g:308:6: (lv_children_17_0= ruleChild )
                    {
                    // PsiInternalBug250313.g:308:6: (lv_children_17_0= ruleChild )
                    // PsiInternalBug250313.g:309:7: lv_children_17_0= ruleChild
                    {

                    							markComposite(elementTypeProvider.getModel_ChildrenChildParserRuleCall_8_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_7);
                    ruleChild();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }

                    // PsiInternalBug250313.g:319:4: (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // PsiInternalBug250313.g:320:5: otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) )
                            {

                            					markLeaf(elementTypeProvider.getModel_RefKeyword_8_1_0ElementType());
                            				
                            otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_6); 

                            					doneLeaf(otherlv_18);
                            				
                            // PsiInternalBug250313.g:327:5: ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) )
                            // PsiInternalBug250313.g:328:6: ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) )
                            {
                            // PsiInternalBug250313.g:328:6: ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) )
                            // PsiInternalBug250313.g:329:7: (otherlv_19= RULE_STRING | otherlv_19= RULE_ID )
                            {
                            // PsiInternalBug250313.g:329:7: (otherlv_19= RULE_STRING | otherlv_19= RULE_ID )
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==RULE_STRING) ) {
                                alt4=1;
                            }
                            else if ( (LA4_0==RULE_ID) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // PsiInternalBug250313.g:330:8: otherlv_19= RULE_STRING
                                    {

                                    								markLeaf(elementTypeProvider.getModel_RefChild1CrossReference_8_1_1_0_0ElementType());
                                    							
                                    otherlv_19=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                                    								doneLeaf(otherlv_19);
                                    							

                                    }
                                    break;
                                case 2 :
                                    // PsiInternalBug250313.g:338:8: otherlv_19= RULE_ID
                                    {

                                    								markLeaf(elementTypeProvider.getModel_RefChild2CrossReference_8_1_1_0_1ElementType());
                                    							
                                    otherlv_19=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

                                    								doneLeaf(otherlv_19);
                                    							

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;

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


    // $ANTLR start "entryRuleDatatype"
    // PsiInternalBug250313.g:354:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:354:18: ( ruleDatatype EOF )
            // PsiInternalBug250313.g:355:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDatatype();

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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // PsiInternalBug250313.g:360:1: ruleDatatype : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalBug250313.g:360:13: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // PsiInternalBug250313.g:361:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // PsiInternalBug250313.g:361:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // PsiInternalBug250313.g:362:3: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
            {

            			markLeaf(elementTypeProvider.getDatatype_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            			doneLeaf(this_ID_0);
            		

            			markLeaf(elementTypeProvider.getDatatype_HyphenMinusKeyword_1ElementType());
            		
            kw=(Token)match(input,22,FollowSets000.FOLLOW_5); 

            			doneLeaf(kw);
            		

            			markLeaf(elementTypeProvider.getDatatype_IDTerminalRuleCall_2ElementType());
            		
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			doneLeaf(this_ID_2);
            		

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
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleNestedDatatype"
    // PsiInternalBug250313.g:387:1: entryRuleNestedDatatype : ruleNestedDatatype EOF ;
    public final void entryRuleNestedDatatype() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:387:24: ( ruleNestedDatatype EOF )
            // PsiInternalBug250313.g:388:2: ruleNestedDatatype EOF
            {
             markComposite(elementTypeProvider.getNestedDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNestedDatatype();

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
    // $ANTLR end "entryRuleNestedDatatype"


    // $ANTLR start "ruleNestedDatatype"
    // PsiInternalBug250313.g:393:1: ruleNestedDatatype : (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) ;
    public final void ruleNestedDatatype() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;

        try {
            // PsiInternalBug250313.g:393:19: ( (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) )
            // PsiInternalBug250313.g:394:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            {
            // PsiInternalBug250313.g:394:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            // PsiInternalBug250313.g:395:3: this_ID_0= RULE_ID kw= '+' ( ruleDatatype )?
            {

            			markLeaf(elementTypeProvider.getNestedDatatype_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			doneLeaf(this_ID_0);
            		

            			markLeaf(elementTypeProvider.getNestedDatatype_PlusSignKeyword_1ElementType());
            		
            kw=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            			doneLeaf(kw);
            		
            // PsiInternalBug250313.g:409:3: ( ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalBug250313.g:410:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getNestedDatatype_DatatypeParserRuleCall_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleDatatype();

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
    // $ANTLR end "ruleNestedDatatype"


    // $ANTLR start "entryRuleChild"
    // PsiInternalBug250313.g:422:1: entryRuleChild : ruleChild EOF ;
    public final void entryRuleChild() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:422:15: ( ruleChild EOF )
            // PsiInternalBug250313.g:423:2: ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild();

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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // PsiInternalBug250313.g:428:1: ruleChild : ( ruleChild1 | ruleChild2 ) ;
    public final void ruleChild() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:428:10: ( ( ruleChild1 | ruleChild2 ) )
            // PsiInternalBug250313.g:429:2: ( ruleChild1 | ruleChild2 )
            {
            // PsiInternalBug250313.g:429:2: ( ruleChild1 | ruleChild2 )
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
                    // PsiInternalBug250313.g:430:3: ruleChild1
                    {

                    			markComposite(elementTypeProvider.getChild_Child1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleChild1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalBug250313.g:438:3: ruleChild2
                    {

                    			markComposite(elementTypeProvider.getChild_Child2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleChild2();

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
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleChild1"
    // PsiInternalBug250313.g:449:1: entryRuleChild1 : ruleChild1 EOF ;
    public final void entryRuleChild1() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:449:16: ( ruleChild1 EOF )
            // PsiInternalBug250313.g:450:2: ruleChild1 EOF
            {
             markComposite(elementTypeProvider.getChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild1();

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
    // $ANTLR end "entryRuleChild1"


    // $ANTLR start "ruleChild1"
    // PsiInternalBug250313.g:455:1: ruleChild1 : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleChild1() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalBug250313.g:455:11: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalBug250313.g:456:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalBug250313.g:456:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug250313.g:457:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug250313.g:457:3: (lv_name_0_0= RULE_ID )
            // PsiInternalBug250313.g:458:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getChild1_NameIDTerminalRuleCall_0ElementType());
            			
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
        return ;
    }
    // $ANTLR end "ruleChild1"


    // $ANTLR start "entryRuleChild2"
    // PsiInternalBug250313.g:470:1: entryRuleChild2 : ruleChild2 EOF ;
    public final void entryRuleChild2() throws RecognitionException {
        try {
            // PsiInternalBug250313.g:470:16: ( ruleChild2 EOF )
            // PsiInternalBug250313.g:471:2: ruleChild2 EOF
            {
             markComposite(elementTypeProvider.getChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleChild2();

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
    // $ANTLR end "entryRuleChild2"


    // $ANTLR start "ruleChild2"
    // PsiInternalBug250313.g:476:1: ruleChild2 : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleChild2() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // PsiInternalBug250313.g:476:11: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // PsiInternalBug250313.g:477:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // PsiInternalBug250313.g:477:2: ( (lv_name_0_0= RULE_STRING ) )
            // PsiInternalBug250313.g:478:3: (lv_name_0_0= RULE_STRING )
            {
            // PsiInternalBug250313.g:478:3: (lv_name_0_0= RULE_STRING )
            // PsiInternalBug250313.g:479:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getChild2_NameSTRINGTerminalRuleCall_0ElementType());
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

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
        return ;
    }
    // $ANTLR end "ruleChild2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    }


}
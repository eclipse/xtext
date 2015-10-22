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
    // PsiInternalBug250313.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalBug250313.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalBug250313.g:53:2: iv_ruleModel= ruleModel EOF
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
    // PsiInternalBug250313.g:59:1: ruleModel returns [Boolean current=false] : ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

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
        Boolean lv_value_1_3 = null;

        Boolean lv_value_1_4 = null;

        Boolean lv_multiValue_3_3 = null;

        Boolean lv_multiValue_3_4 = null;

        Boolean lv_value_9_0 = null;

        Boolean lv_multiValue_11_0 = null;

        Boolean lv_value_13_0 = null;

        Boolean lv_multiValue_15_0 = null;

        Boolean lv_children_17_0 = null;


        try {
            // PsiInternalBug250313.g:60:1: ( ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) ) )
            // PsiInternalBug250313.g:61:2: ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) )
            {
            // PsiInternalBug250313.g:61:2: ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) )
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
                    // PsiInternalBug250313.g:62:3: ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    {
                    // PsiInternalBug250313.g:62:3: ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    // PsiInternalBug250313.g:63:4: (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    {
                    // PsiInternalBug250313.g:63:4: (otherlv_0= '1' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // PsiInternalBug250313.g:64:5: otherlv_0= '1'
                            {

                            					markLeaf(elementTypeProvider.getModel_DigitOneKeyword_0_0ElementType());
                            				
                            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_0);
                            				

                            }
                            break;

                    }

                    // PsiInternalBug250313.g:72:4: ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    // PsiInternalBug250313.g:73:5: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    {
                    // PsiInternalBug250313.g:73:5: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    // PsiInternalBug250313.g:74:6: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
                    {
                    // PsiInternalBug250313.g:74:6: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
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
                        case EOF:
                            {
                            alt2=5;
                            }
                            break;
                        case 23:
                            {
                            alt2=3;
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
                            // PsiInternalBug250313.g:75:7: lv_value_1_1= 'mykeyword1'
                            {

                            							markLeaf(elementTypeProvider.getModel_ValueMykeyword1Keyword_0_1_0_0ElementType());
                            						
                            lv_value_1_1=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_1_1);
                            						

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalBug250313.g:89:7: lv_value_1_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
                            lv_value_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_value_1_2);
                            						

                            }
                            break;
                        case 3 :
                            // PsiInternalBug250313.g:103:7: lv_value_1_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_1_3=ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 4 :
                            // PsiInternalBug250313.g:115:7: lv_value_1_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_value_1_4=ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 5 :
                            // PsiInternalBug250313.g:127:7: lv_value_1_5= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getModel_ValueIDTerminalRuleCall_0_1_0_4ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
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
                    // PsiInternalBug250313.g:145:3: (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    {
                    // PsiInternalBug250313.g:145:3: (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    // PsiInternalBug250313.g:146:4: otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitOnePlusSignKeyword_1_0ElementType());
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_2);
                    			
                    // PsiInternalBug250313.g:153:4: ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    // PsiInternalBug250313.g:154:5: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    {
                    // PsiInternalBug250313.g:154:5: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    // PsiInternalBug250313.g:155:6: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
                    {
                    // PsiInternalBug250313.g:155:6: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
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
                        case 22:
                            {
                            alt3=4;
                            }
                            break;
                        case EOF:
                            {
                            alt3=5;
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
                            // PsiInternalBug250313.g:156:7: lv_multiValue_3_1= 'mykeyword1'
                            {

                            							markLeaf(elementTypeProvider.getModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType());
                            						
                            lv_multiValue_3_1=(Token)match(input,12,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_multiValue_3_1);
                            						

                            							if (!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 2 :
                            // PsiInternalBug250313.g:170:7: lv_multiValue_3_2= RULE_STRING
                            {

                            							markLeaf(elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
                            lv_multiValue_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                            							doneLeaf(lv_multiValue_3_2);
                            						

                            }
                            break;
                        case 3 :
                            // PsiInternalBug250313.g:184:7: lv_multiValue_3_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_multiValue_3_3=ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 4 :
                            // PsiInternalBug250313.g:196:7: lv_multiValue_3_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_2);
                            lv_multiValue_3_4=ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						

                            }
                            break;
                        case 5 :
                            // PsiInternalBug250313.g:208:7: lv_multiValue_3_5= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getModel_MultiValueIDTerminalRuleCall_1_1_0_4ElementType());
                            						

                            							if(!current) {
                            								associateWithSemanticElement();
                            								current = true;
                            							}
                            						
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
                    // PsiInternalBug250313.g:226:3: (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalBug250313.g:226:3: (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    // PsiInternalBug250313.g:227:4: otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitTwoKeyword_2_0ElementType());
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_4);
                    			
                    // PsiInternalBug250313.g:234:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalBug250313.g:235:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalBug250313.g:235:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalBug250313.g:236:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalBug250313.g:253:3: (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    {
                    // PsiInternalBug250313.g:253:3: (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    // PsiInternalBug250313.g:254:4: otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitTwoPlusSignKeyword_3_0ElementType());
                    			
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                    				doneLeaf(otherlv_6);
                    			
                    // PsiInternalBug250313.g:261:4: ( (lv_multiValue_7_0= RULE_STRING ) )
                    // PsiInternalBug250313.g:262:5: (lv_multiValue_7_0= RULE_STRING )
                    {
                    // PsiInternalBug250313.g:262:5: (lv_multiValue_7_0= RULE_STRING )
                    // PsiInternalBug250313.g:263:6: lv_multiValue_7_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_3_1_0ElementType());
                    					

                    						if(!current) {
                    							associateWithSemanticElement();
                    							current = true;
                    						}
                    					
                    lv_multiValue_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_multiValue_7_0);
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalBug250313.g:280:3: (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:280:3: (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    // PsiInternalBug250313.g:281:4: otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitThreeKeyword_4_0ElementType());
                    			
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_8);
                    			
                    // PsiInternalBug250313.g:288:4: ( (lv_value_9_0= ruleDatatype ) )
                    // PsiInternalBug250313.g:289:5: (lv_value_9_0= ruleDatatype )
                    {
                    // PsiInternalBug250313.g:289:5: (lv_value_9_0= ruleDatatype )
                    // PsiInternalBug250313.g:290:6: lv_value_9_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_9_0=ruleDatatype();

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
                case 6 :
                    // PsiInternalBug250313.g:305:3: (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:305:3: (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    // PsiInternalBug250313.g:306:4: otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitThreePlusSignKeyword_5_0ElementType());
                    			
                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalBug250313.g:313:4: ( (lv_multiValue_11_0= ruleDatatype ) )
                    // PsiInternalBug250313.g:314:5: (lv_multiValue_11_0= ruleDatatype )
                    {
                    // PsiInternalBug250313.g:314:5: (lv_multiValue_11_0= ruleDatatype )
                    // PsiInternalBug250313.g:315:6: lv_multiValue_11_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_multiValue_11_0=ruleDatatype();

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
                case 7 :
                    // PsiInternalBug250313.g:330:3: (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:330:3: (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    // PsiInternalBug250313.g:331:4: otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitFourKeyword_6_0ElementType());
                    			
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_12);
                    			
                    // PsiInternalBug250313.g:338:4: ( (lv_value_13_0= ruleNestedDatatype ) )
                    // PsiInternalBug250313.g:339:5: (lv_value_13_0= ruleNestedDatatype )
                    {
                    // PsiInternalBug250313.g:339:5: (lv_value_13_0= ruleNestedDatatype )
                    // PsiInternalBug250313.g:340:6: lv_value_13_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_value_13_0=ruleNestedDatatype();

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
                case 8 :
                    // PsiInternalBug250313.g:355:3: (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    {
                    // PsiInternalBug250313.g:355:3: (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    // PsiInternalBug250313.g:356:4: otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    {

                    				markLeaf(elementTypeProvider.getModel_DigitFourPlusSignKeyword_7_0ElementType());
                    			
                    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_5); 

                    				doneLeaf(otherlv_14);
                    			
                    // PsiInternalBug250313.g:363:4: ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    // PsiInternalBug250313.g:364:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    {
                    // PsiInternalBug250313.g:364:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    // PsiInternalBug250313.g:365:6: lv_multiValue_15_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_multiValue_15_0=ruleNestedDatatype();

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
                case 9 :
                    // PsiInternalBug250313.g:380:3: ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? )
                    {
                    // PsiInternalBug250313.g:380:3: ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? )
                    // PsiInternalBug250313.g:381:4: (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )?
                    {
                    // PsiInternalBug250313.g:381:4: (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) )
                    // PsiInternalBug250313.g:382:5: otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) )
                    {

                    					markLeaf(elementTypeProvider.getModel_ContentKeyword_8_0_0ElementType());
                    				
                    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_6); 

                    					doneLeaf(otherlv_16);
                    				
                    // PsiInternalBug250313.g:389:5: ( (lv_children_17_0= ruleChild ) )
                    // PsiInternalBug250313.g:390:6: (lv_children_17_0= ruleChild )
                    {
                    // PsiInternalBug250313.g:390:6: (lv_children_17_0= ruleChild )
                    // PsiInternalBug250313.g:391:7: lv_children_17_0= ruleChild
                    {

                    							markComposite(elementTypeProvider.getModel_ChildrenChildParserRuleCall_8_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_7);
                    lv_children_17_0=ruleChild();

                    state._fsp--;


                    							doneComposite();
                    							if(!current) {
                    								associateWithSemanticElement();
                    								current = true;
                    							}
                    						

                    }


                    }


                    }

                    // PsiInternalBug250313.g:405:4: (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // PsiInternalBug250313.g:406:5: otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) )
                            {

                            					markLeaf(elementTypeProvider.getModel_RefKeyword_8_1_0ElementType());
                            				
                            otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_6); 

                            					doneLeaf(otherlv_18);
                            				
                            // PsiInternalBug250313.g:413:5: ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) )
                            // PsiInternalBug250313.g:414:6: ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) )
                            {
                            // PsiInternalBug250313.g:414:6: ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) )
                            // PsiInternalBug250313.g:415:7: (otherlv_19= RULE_STRING | otherlv_19= RULE_ID )
                            {
                            // PsiInternalBug250313.g:415:7: (otherlv_19= RULE_STRING | otherlv_19= RULE_ID )
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
                                    // PsiInternalBug250313.g:416:8: otherlv_19= RULE_STRING
                                    {

                                    								if (!current) {
                                    									associateWithSemanticElement();
                                    									current = true;
                                    								}
                                    							

                                    								markLeaf(elementTypeProvider.getModel_RefChild1CrossReference_8_1_1_0_0ElementType());
                                    							
                                    otherlv_19=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                                    								doneLeaf(otherlv_19);
                                    							

                                    }
                                    break;
                                case 2 :
                                    // PsiInternalBug250313.g:430:8: otherlv_19= RULE_ID
                                    {

                                    								if (!current) {
                                    									associateWithSemanticElement();
                                    									current = true;
                                    								}
                                    							

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDatatype"
    // PsiInternalBug250313.g:452:1: entryRuleDatatype returns [Boolean current=false] : iv_ruleDatatype= ruleDatatype EOF ;
    public final Boolean entryRuleDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDatatype = null;


        try {
            // PsiInternalBug250313.g:452:50: (iv_ruleDatatype= ruleDatatype EOF )
            // PsiInternalBug250313.g:453:2: iv_ruleDatatype= ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDatatype=ruleDatatype();

            state._fsp--;

             current =iv_ruleDatatype; 
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
    // $ANTLR end "entryRuleDatatype"


    // $ANTLR start "ruleDatatype"
    // PsiInternalBug250313.g:459:1: ruleDatatype returns [Boolean current=false] : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final Boolean ruleDatatype() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // PsiInternalBug250313.g:460:1: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // PsiInternalBug250313.g:461:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // PsiInternalBug250313.g:461:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // PsiInternalBug250313.g:462:3: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
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
        return current;
    }
    // $ANTLR end "ruleDatatype"


    // $ANTLR start "entryRuleNestedDatatype"
    // PsiInternalBug250313.g:487:1: entryRuleNestedDatatype returns [Boolean current=false] : iv_ruleNestedDatatype= ruleNestedDatatype EOF ;
    public final Boolean entryRuleNestedDatatype() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNestedDatatype = null;


        try {
            // PsiInternalBug250313.g:487:56: (iv_ruleNestedDatatype= ruleNestedDatatype EOF )
            // PsiInternalBug250313.g:488:2: iv_ruleNestedDatatype= ruleNestedDatatype EOF
            {
             markComposite(elementTypeProvider.getNestedDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNestedDatatype=ruleNestedDatatype();

            state._fsp--;

             current =iv_ruleNestedDatatype; 
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
    // $ANTLR end "entryRuleNestedDatatype"


    // $ANTLR start "ruleNestedDatatype"
    // PsiInternalBug250313.g:494:1: ruleNestedDatatype returns [Boolean current=false] : (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) ;
    public final Boolean ruleNestedDatatype() throws RecognitionException {
        Boolean current = false;

        Token this_ID_0=null;
        Token kw=null;

        try {
            // PsiInternalBug250313.g:495:1: ( (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) )
            // PsiInternalBug250313.g:496:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            {
            // PsiInternalBug250313.g:496:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            // PsiInternalBug250313.g:497:3: this_ID_0= RULE_ID kw= '+' ( ruleDatatype )?
            {

            			markLeaf(elementTypeProvider.getNestedDatatype_IDTerminalRuleCall_0ElementType());
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

            			doneLeaf(this_ID_0);
            		

            			markLeaf(elementTypeProvider.getNestedDatatype_PlusSignKeyword_1ElementType());
            		
            kw=(Token)match(input,23,FollowSets000.FOLLOW_10); 

            			doneLeaf(kw);
            		
            // PsiInternalBug250313.g:511:3: ( ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // PsiInternalBug250313.g:512:4: ruleDatatype
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
        return current;
    }
    // $ANTLR end "ruleNestedDatatype"


    // $ANTLR start "entryRuleChild"
    // PsiInternalBug250313.g:524:1: entryRuleChild returns [Boolean current=false] : iv_ruleChild= ruleChild EOF ;
    public final Boolean entryRuleChild() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChild = null;


        try {
            // PsiInternalBug250313.g:524:47: (iv_ruleChild= ruleChild EOF )
            // PsiInternalBug250313.g:525:2: iv_ruleChild= ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // PsiInternalBug250313.g:531:1: ruleChild returns [Boolean current=false] : (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) ;
    public final Boolean ruleChild() throws RecognitionException {
        Boolean current = false;

        Boolean this_Child1_0 = null;

        Boolean this_Child2_1 = null;


        try {
            // PsiInternalBug250313.g:532:1: ( (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) )
            // PsiInternalBug250313.g:533:2: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            {
            // PsiInternalBug250313.g:533:2: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
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
                    // PsiInternalBug250313.g:534:3: this_Child1_0= ruleChild1
                    {

                    			markComposite(elementTypeProvider.getChild_Child1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Child1_0=ruleChild1();

                    state._fsp--;


                    			current = this_Child1_0;
                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalBug250313.g:543:3: this_Child2_1= ruleChild2
                    {

                    			markComposite(elementTypeProvider.getChild_Child2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Child2_1=ruleChild2();

                    state._fsp--;


                    			current = this_Child2_1;
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
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleChild1"
    // PsiInternalBug250313.g:555:1: entryRuleChild1 returns [Boolean current=false] : iv_ruleChild1= ruleChild1 EOF ;
    public final Boolean entryRuleChild1() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChild1 = null;


        try {
            // PsiInternalBug250313.g:555:48: (iv_ruleChild1= ruleChild1 EOF )
            // PsiInternalBug250313.g:556:2: iv_ruleChild1= ruleChild1 EOF
            {
             markComposite(elementTypeProvider.getChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild1=ruleChild1();

            state._fsp--;

             current =iv_ruleChild1; 
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
    // $ANTLR end "entryRuleChild1"


    // $ANTLR start "ruleChild1"
    // PsiInternalBug250313.g:562:1: ruleChild1 returns [Boolean current=false] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final Boolean ruleChild1() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalBug250313.g:563:1: ( ( (lv_name_0_0= RULE_ID ) ) )
            // PsiInternalBug250313.g:564:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // PsiInternalBug250313.g:564:2: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalBug250313.g:565:3: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalBug250313.g:565:3: (lv_name_0_0= RULE_ID )
            // PsiInternalBug250313.g:566:4: lv_name_0_0= RULE_ID
            {

            				markLeaf(elementTypeProvider.getChild1_NameIDTerminalRuleCall_0ElementType());
            			

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
    // $ANTLR end "ruleChild1"


    // $ANTLR start "entryRuleChild2"
    // PsiInternalBug250313.g:584:1: entryRuleChild2 returns [Boolean current=false] : iv_ruleChild2= ruleChild2 EOF ;
    public final Boolean entryRuleChild2() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleChild2 = null;


        try {
            // PsiInternalBug250313.g:584:48: (iv_ruleChild2= ruleChild2 EOF )
            // PsiInternalBug250313.g:585:2: iv_ruleChild2= ruleChild2 EOF
            {
             markComposite(elementTypeProvider.getChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleChild2=ruleChild2();

            state._fsp--;

             current =iv_ruleChild2; 
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
    // $ANTLR end "entryRuleChild2"


    // $ANTLR start "ruleChild2"
    // PsiInternalBug250313.g:591:1: ruleChild2 returns [Boolean current=false] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final Boolean ruleChild2() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;

        try {
            // PsiInternalBug250313.g:592:1: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // PsiInternalBug250313.g:593:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // PsiInternalBug250313.g:593:2: ( (lv_name_0_0= RULE_STRING ) )
            // PsiInternalBug250313.g:594:3: (lv_name_0_0= RULE_STRING )
            {
            // PsiInternalBug250313.g:594:3: (lv_name_0_0= RULE_STRING )
            // PsiInternalBug250313.g:595:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getChild2_NameSTRINGTerminalRuleCall_0ElementType());
            			

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			
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
        return current;
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
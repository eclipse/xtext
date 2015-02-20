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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:52:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:53:2: ruleModel EOF
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:59:1: ruleModel : ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:59:10: ( ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:60:2: ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:60:2: ( ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) ) | (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) ) | (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:61:3: ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:61:3: ( (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:62:4: (otherlv_0= '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:62:4: (otherlv_0= '1' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:63:5: otherlv_0= '1'
                            {

                            					markLeaf();
                            				
                            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel92); 

                            					doneLeaf(otherlv_0, elementTypeProvider.getModel_DigitOneKeyword_0_0ElementType());
                            				

                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:71:4: ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:72:5: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:72:5: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:73:6: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:73:6: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
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
                        case 22:
                            {
                            alt2=4;
                            }
                            break;
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:74:7: lv_value_1_1= 'mykeyword1'
                            {

                            							markLeaf();
                            						
                            lv_value_1_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel140); 

                            							doneLeaf(lv_value_1_1, elementTypeProvider.getModel_ValueMykeyword1Keyword_0_1_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:82:7: lv_value_1_2= RULE_STRING
                            {

                            							markLeaf();
                            						
                            lv_value_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel178); 

                            							doneLeaf(lv_value_1_2, elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType());
                            						

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:90:7: lv_value_1_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel216);
                            ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:98:7: lv_value_1_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel254);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 5 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:106:7: lv_value_1_5= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_value_1_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel292); 

                            							doneLeaf(lv_value_1_5, elementTypeProvider.getModel_ValueIDTerminalRuleCall_0_1_0_4ElementType());
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:118:3: (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:118:3: (otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:119:4: otherlv_2= '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel346); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getModel_DigitOnePlusSignKeyword_1_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:126:4: ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:127:5: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:127:5: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:128:6: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:128:6: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
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
                        case 23:
                            {
                            alt3=3;
                            }
                            break;
                        case EOF:
                            {
                            alt3=5;
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
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:129:7: lv_multiValue_3_1= 'mykeyword1'
                            {

                            							markLeaf();
                            						
                            lv_multiValue_3_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel387); 

                            							doneLeaf(lv_multiValue_3_1, elementTypeProvider.getModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:137:7: lv_multiValue_3_2= RULE_STRING
                            {

                            							markLeaf();
                            						
                            lv_multiValue_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel425); 

                            							doneLeaf(lv_multiValue_3_2, elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:145:7: lv_multiValue_3_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel463);
                            ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:153:7: lv_multiValue_3_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel501);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 5 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:161:7: lv_multiValue_3_5= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_multiValue_3_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel539); 

                            							doneLeaf(lv_multiValue_3_5, elementTypeProvider.getModel_MultiValueIDTerminalRuleCall_1_1_0_4ElementType());
                            						

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:173:3: (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:173:3: (otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:174:4: otherlv_4= '2' ( (lv_value_5_0= RULE_STRING ) )
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel593); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getModel_DigitTwoKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:181:4: ( (lv_value_5_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:182:5: (lv_value_5_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:182:5: (lv_value_5_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:183:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel625); 

                    						doneLeaf(lv_value_5_0, elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:194:3: (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:194:3: (otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:195:4: otherlv_6= '2+' ( (lv_multiValue_7_0= RULE_STRING ) )
                    {

                    				markLeaf();
                    			
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel671); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getModel_DigitTwoPlusSignKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:202:4: ( (lv_multiValue_7_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:203:5: (lv_multiValue_7_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:203:5: (lv_multiValue_7_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:204:6: lv_multiValue_7_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_multiValue_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel703); 

                    						doneLeaf(lv_multiValue_7_0, elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_3_1_0ElementType());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:215:3: (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:215:3: (otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:216:4: otherlv_8= '3' ( (lv_value_9_0= ruleDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel749); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getModel_DigitThreeKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:223:4: ( (lv_value_9_0= ruleDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:224:5: (lv_value_9_0= ruleDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:224:5: (lv_value_9_0= ruleDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:225:6: lv_value_9_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel781);
                    ruleDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:236:3: (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:236:3: (otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:237:4: otherlv_10= '3+' ( (lv_multiValue_11_0= ruleDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel827); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getModel_DigitThreePlusSignKeyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:244:4: ( (lv_multiValue_11_0= ruleDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:245:5: (lv_multiValue_11_0= ruleDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:245:5: (lv_multiValue_11_0= ruleDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:246:6: lv_multiValue_11_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel859);
                    ruleDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:257:3: (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:257:3: (otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:258:4: otherlv_12= '4' ( (lv_value_13_0= ruleNestedDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel905); 

                    				doneLeaf(otherlv_12, elementTypeProvider.getModel_DigitFourKeyword_6_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:265:4: ( (lv_value_13_0= ruleNestedDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:266:5: (lv_value_13_0= ruleNestedDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:266:5: (lv_value_13_0= ruleNestedDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:267:6: lv_value_13_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel937);
                    ruleNestedDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:278:3: (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:278:3: (otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:279:4: otherlv_14= '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    {

                    				markLeaf();
                    			
                    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel983); 

                    				doneLeaf(otherlv_14, elementTypeProvider.getModel_DigitFourPlusSignKeyword_7_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:286:4: ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:287:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:287:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:288:6: lv_multiValue_15_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel1015);
                    ruleNestedDatatype();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:299:3: ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:299:3: ( (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:300:4: (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) ) (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )?
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:300:4: (otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:301:5: otherlv_16= 'content' ( (lv_children_17_0= ruleChild ) )
                    {

                    					markLeaf();
                    				
                    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel1068); 

                    					doneLeaf(otherlv_16, elementTypeProvider.getModel_ContentKeyword_8_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:308:5: ( (lv_children_17_0= ruleChild ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:309:6: (lv_children_17_0= ruleChild )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:309:6: (lv_children_17_0= ruleChild )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:310:7: lv_children_17_0= ruleChild
                    {

                    							markComposite(elementTypeProvider.getModel_ChildrenChildParserRuleCall_8_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleModel1105);
                    ruleChild();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:320:4: (otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:321:5: otherlv_18= 'ref' ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) )
                            {

                            					markLeaf();
                            				
                            otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModel1150); 

                            					doneLeaf(otherlv_18, elementTypeProvider.getModel_RefKeyword_8_1_0ElementType());
                            				
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:328:5: ( ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:329:6: ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:329:6: ( (otherlv_19= RULE_STRING | otherlv_19= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:330:7: (otherlv_19= RULE_STRING | otherlv_19= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:330:7: (otherlv_19= RULE_STRING | otherlv_19= RULE_ID )
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
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:331:8: otherlv_19= RULE_STRING
                                    {

                                    								markLeaf();
                                    							
                                    otherlv_19=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel1197); 

                                    								doneLeaf(otherlv_19, elementTypeProvider.getModel_RefChild1CrossReference_8_1_1_0_0ElementType());
                                    							

                                    }
                                    break;
                                case 2 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:339:8: otherlv_19= RULE_ID
                                    {

                                    								markLeaf();
                                    							
                                    otherlv_19=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel1239); 

                                    								doneLeaf(otherlv_19, elementTypeProvider.getModel_RefChild2CrossReference_8_1_1_0_1ElementType());
                                    							

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:355:1: entryRuleDatatype : ruleDatatype EOF ;
    public final void entryRuleDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:355:18: ( ruleDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:356:2: ruleDatatype EOF
            {
             markComposite(elementTypeProvider.getDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype1295);
            ruleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype1301); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:362:1: ruleDatatype : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:362:13: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:363:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:363:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:364:3: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype1320); 

            			doneLeaf(this_ID_0, elementTypeProvider.getDatatype_IDTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleDatatype1334); 

            			doneLeaf(kw, elementTypeProvider.getDatatype_HyphenMinusKeyword_1ElementType());
            		

            			markLeaf();
            		
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype1348); 

            			doneLeaf(this_ID_2, elementTypeProvider.getDatatype_IDTerminalRuleCall_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:389:1: entryRuleNestedDatatype : ruleNestedDatatype EOF ;
    public final void entryRuleNestedDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:389:24: ( ruleNestedDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:390:2: ruleNestedDatatype EOF
            {
             markComposite(elementTypeProvider.getNestedDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype1368);
            ruleNestedDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedDatatype1374); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:396:1: ruleNestedDatatype : (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) ;
    public final void ruleNestedDatatype() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:396:19: ( (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:397:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:397:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:398:3: this_ID_0= RULE_ID kw= '+' ( ruleDatatype )?
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedDatatype1393); 

            			doneLeaf(this_ID_0, elementTypeProvider.getNestedDatatype_IDTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedDatatype1407); 

            			doneLeaf(kw, elementTypeProvider.getNestedDatatype_PlusSignKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:412:3: ( ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:413:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getNestedDatatype_DatatypeParserRuleCall_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleNestedDatatype1425);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:425:1: entryRuleChild : ruleChild EOF ;
    public final void entryRuleChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:425:15: ( ruleChild EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:426:2: ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild1451);
            ruleChild();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1457); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:432:1: ruleChild : ( ruleChild1 | ruleChild2 ) ;
    public final void ruleChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:432:10: ( ( ruleChild1 | ruleChild2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:433:2: ( ruleChild1 | ruleChild2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:433:2: ( ruleChild1 | ruleChild2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:434:3: ruleChild1
                    {

                    			markComposite(elementTypeProvider.getChild_Child1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_in_ruleChild1474);
                    ruleChild1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:442:3: ruleChild2
                    {

                    			markComposite(elementTypeProvider.getChild_Child2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_in_ruleChild1494);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:453:1: entryRuleChild1 : ruleChild1 EOF ;
    public final void entryRuleChild1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:453:16: ( ruleChild1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:454:2: ruleChild1 EOF
            {
             markComposite(elementTypeProvider.getChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_in_entryRuleChild11514);
            ruleChild1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild11520); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:460:1: ruleChild1 : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleChild1() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:460:11: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:461:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:461:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:462:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:462:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:463:4: lv_name_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild11545); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getChild1_NameIDTerminalRuleCall_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:475:1: entryRuleChild2 : ruleChild2 EOF ;
    public final void entryRuleChild2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:475:16: ( ruleChild2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:476:2: ruleChild2 EOF
            {
             markComposite(elementTypeProvider.getChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_in_entryRuleChild21570);
            ruleChild2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild21576); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:482:1: ruleChild2 : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleChild2() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:482:11: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:483:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:483:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:484:3: (lv_name_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:484:3: (lv_name_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:485:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleChild21601); 

            				doneLeaf(lv_name_0_0, elementTypeProvider.getChild2_NameSTRINGTerminalRuleCall_0ElementType());
            			

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
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel92 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12_in_ruleModel140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel346 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12_in_ruleModel387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel593 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel671 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel749 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel827 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel905 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel937 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel983 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel1015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel1068 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleChild_in_ruleModel1105 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleModel1150 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel1197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel1239 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype1295 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype1301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1320 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleDatatype1334 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype1368 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedDatatype1374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedDatatype1393 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedDatatype1407 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleNestedDatatype1425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild1451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_in_ruleChild1474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_in_ruleChild1494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild11514 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild11520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild11545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild21570 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild21576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleChild21601 = new BitSet(new long[]{0x0000000000000002L});
    }


}
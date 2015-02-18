package org.eclipse.xtext.valueconverter.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313ElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:50:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:50:15: ( ruleModel EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:51:2: ruleModel EOF
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
                            				
                            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel96); 

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
                            						
                            lv_value_1_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel144); 

                            							doneLeaf(lv_value_1_1, elementTypeProvider.getModel_ValueMykeyword1Keyword_0_1_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:82:7: lv_value_1_2= RULE_STRING
                            {

                            							markLeaf();
                            						
                            lv_value_1_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel182); 

                            							doneLeaf(lv_value_1_2, elementTypeProvider.getModel_ValueSTRINGTerminalRuleCall_0_1_0_1ElementType());
                            						

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:90:7: lv_value_1_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_0_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel220);
                            ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:98:7: lv_value_1_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_0_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel258);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 5 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:106:7: lv_value_1_5= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_value_1_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel296); 

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
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModel350); 

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
                            						
                            lv_multiValue_3_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel391); 

                            							doneLeaf(lv_multiValue_3_1, elementTypeProvider.getModel_MultiValueMykeyword1Keyword_1_1_0_0ElementType());
                            						

                            }
                            break;
                        case 2 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:137:7: lv_multiValue_3_2= RULE_STRING
                            {

                            							markLeaf();
                            						
                            lv_multiValue_3_2=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel429); 

                            							doneLeaf(lv_multiValue_3_2, elementTypeProvider.getModel_MultiValueSTRINGTerminalRuleCall_1_1_0_1ElementType());
                            						

                            }
                            break;
                        case 3 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:145:7: lv_multiValue_3_3= ruleNestedDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_1_1_0_2ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel467);
                            ruleNestedDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 4 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:153:7: lv_multiValue_3_4= ruleDatatype
                            {

                            							markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_1_1_0_3ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel505);
                            ruleDatatype();

                            state._fsp--;


                            							doneComposite();
                            						

                            }
                            break;
                        case 5 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:161:7: lv_multiValue_3_5= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_multiValue_3_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel543); 

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
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModel597); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getModel_DigitTwoKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:181:4: ( (lv_value_5_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:182:5: (lv_value_5_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:182:5: (lv_value_5_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:183:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel629); 

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
                    			
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModel675); 

                    				doneLeaf(otherlv_6, elementTypeProvider.getModel_DigitTwoPlusSignKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:202:4: ( (lv_multiValue_7_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:203:5: (lv_multiValue_7_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:203:5: (lv_multiValue_7_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:204:6: lv_multiValue_7_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_multiValue_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel707); 

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
                    			
                    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModel753); 

                    				doneLeaf(otherlv_8, elementTypeProvider.getModel_DigitThreeKeyword_4_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:223:4: ( (lv_value_9_0= ruleDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:224:5: (lv_value_9_0= ruleDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:224:5: (lv_value_9_0= ruleDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:225:6: lv_value_9_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueDatatypeParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel785);
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
                    			
                    otherlv_10=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModel831); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getModel_DigitThreePlusSignKeyword_5_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:244:4: ( (lv_multiValue_11_0= ruleDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:245:5: (lv_multiValue_11_0= ruleDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:245:5: (lv_multiValue_11_0= ruleDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:246:6: lv_multiValue_11_0= ruleDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueDatatypeParserRuleCall_5_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel863);
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
                    			
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModel909); 

                    				doneLeaf(otherlv_12, elementTypeProvider.getModel_DigitFourKeyword_6_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:265:4: ( (lv_value_13_0= ruleNestedDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:266:5: (lv_value_13_0= ruleNestedDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:266:5: (lv_value_13_0= ruleNestedDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:267:6: lv_value_13_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_ValueNestedDatatypeParserRuleCall_6_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel941);
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
                    			
                    otherlv_14=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModel987); 

                    				doneLeaf(otherlv_14, elementTypeProvider.getModel_DigitFourPlusSignKeyword_7_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:286:4: ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:287:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:287:5: (lv_multiValue_15_0= ruleNestedDatatype )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:288:6: lv_multiValue_15_0= ruleNestedDatatype
                    {

                    						markComposite(elementTypeProvider.getModel_MultiValueNestedDatatypeParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel1019);
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
                    				
                    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModel1072); 

                    					doneLeaf(otherlv_16, elementTypeProvider.getModel_ContentKeyword_8_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:308:5: ( (lv_children_17_0= ruleChild ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:309:6: (lv_children_17_0= ruleChild )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:309:6: (lv_children_17_0= ruleChild )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:310:7: lv_children_17_0= ruleChild
                    {

                    							markComposite(elementTypeProvider.getModel_ChildrenChildParserRuleCall_8_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleModel1109);
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
                            				
                            otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModel1154); 

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
                                    							
                                    otherlv_19=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel1201); 

                                    								doneLeaf(otherlv_19, elementTypeProvider.getModel_RefChild1CrossReference_8_1_1_0_0ElementType());
                                    							

                                    }
                                    break;
                                case 2 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:339:8: otherlv_19= RULE_ID
                                    {

                                    								markLeaf();
                                    							
                                    otherlv_19=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel1243); 

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
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype1299);
            ruleDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype1305); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:364:1: ruleDatatype : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final void ruleDatatype() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:364:13: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:365:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:365:2: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:366:3: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype1328); 

            			doneLeaf(this_ID_0, elementTypeProvider.getDatatype_IDTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleDatatype1342); 

            			doneLeaf(kw, elementTypeProvider.getDatatype_HyphenMinusKeyword_1ElementType());
            		

            			markLeaf();
            		
            this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype1356); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:391:1: entryRuleNestedDatatype : ruleNestedDatatype EOF ;
    public final void entryRuleNestedDatatype() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:391:24: ( ruleNestedDatatype EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:392:2: ruleNestedDatatype EOF
            {
             markComposite(elementTypeProvider.getNestedDatatypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype1376);
            ruleNestedDatatype();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedDatatype1382); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:400:1: ruleNestedDatatype : (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) ;
    public final void ruleNestedDatatype() throws RecognitionException {
        Token this_ID_0=null;
        Token kw=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:400:19: ( (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:401:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:401:2: (this_ID_0= RULE_ID kw= '+' ( ruleDatatype )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:402:3: this_ID_0= RULE_ID kw= '+' ( ruleDatatype )?
            {

            			markLeaf();
            		
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedDatatype1405); 

            			doneLeaf(this_ID_0, elementTypeProvider.getNestedDatatype_IDTerminalRuleCall_0ElementType());
            		

            			markLeaf();
            		
            kw=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedDatatype1419); 

            			doneLeaf(kw, elementTypeProvider.getNestedDatatype_PlusSignKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:416:3: ( ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:417:4: ruleDatatype
                    {

                    				markComposite(elementTypeProvider.getNestedDatatype_DatatypeParserRuleCall_2ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleNestedDatatype1437);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:429:1: entryRuleChild : ruleChild EOF ;
    public final void entryRuleChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:429:15: ( ruleChild EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:430:2: ruleChild EOF
            {
             markComposite(elementTypeProvider.getChildElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild1463);
            ruleChild();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1469); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:438:1: ruleChild : ( ruleChild1 | ruleChild2 ) ;
    public final void ruleChild() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:438:10: ( ( ruleChild1 | ruleChild2 ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:439:2: ( ruleChild1 | ruleChild2 )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:439:2: ( ruleChild1 | ruleChild2 )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:440:3: ruleChild1
                    {

                    			markComposite(elementTypeProvider.getChild_Child1ParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_in_ruleChild1490);
                    ruleChild1();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:448:3: ruleChild2
                    {

                    			markComposite(elementTypeProvider.getChild_Child2ParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_in_ruleChild1510);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:459:1: entryRuleChild1 : ruleChild1 EOF ;
    public final void entryRuleChild1() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:459:16: ( ruleChild1 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:460:2: ruleChild1 EOF
            {
             markComposite(elementTypeProvider.getChild1ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_in_entryRuleChild11530);
            ruleChild1();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild11536); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:468:1: ruleChild1 : ( (lv_name_0_0= RULE_ID ) ) ;
    public final void ruleChild1() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:468:11: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:469:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:469:2: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:470:3: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:470:3: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:471:4: lv_name_0_0= RULE_ID
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild11565); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:483:1: entryRuleChild2 : ruleChild2 EOF ;
    public final void entryRuleChild2() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:483:16: ( ruleChild2 EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:484:2: ruleChild2 EOF
            {
             markComposite(elementTypeProvider.getChild2ElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_in_entryRuleChild21590);
            ruleChild2();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild21596); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:492:1: ruleChild2 : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final void ruleChild2() throws RecognitionException {
        Token lv_name_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:492:11: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:493:2: ( (lv_name_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:493:2: ( (lv_name_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:494:3: (lv_name_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:494:3: (lv_name_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/valueconverter/idea/parser/antlr/internal/PsiInternalBug250313.g:495:4: lv_name_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_name_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleChild21625); 

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
        public static final BitSet FOLLOW_11_in_ruleModel96 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12_in_ruleModel144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel350 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12_in_ruleModel391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel597 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel675 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel753 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel831 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel909 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel987 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel1019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel1072 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleChild_in_ruleModel1109 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleModel1154 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel1201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel1243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype1299 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype1305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1328 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleDatatype1342 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype1356 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype1376 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedDatatype1382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedDatatype1405 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedDatatype1419 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleNestedDatatype1437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild1463 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_in_ruleChild1490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_in_ruleChild1510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild11530 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild11536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild11565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild21590 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild21596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleChild21625 = new BitSet(new long[]{0x0000000000000002L});
    }


}
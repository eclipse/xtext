package org.eclipse.xtext.resource.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.resource.idea.lang.Bug385636ElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.resource.services.Bug385636GrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalBug385636Parser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'END'", "'VARIABLES'", "'ENDVARIABLES'", "'NAME'", "'C1'", "'C2'", "'C3'", "'C4'", "'C5'", "'C6'", "'C7'", "'C8'"
    };
    public static final int RULE_ID=4;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public PsiInternalBug385636Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalBug385636Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalBug385636Parser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalBug385636.g"; }



    	protected Bug385636GrammarAccess grammarAccess;

    	protected Bug385636ElementTypeProvider elementTypeProvider;

    	public PsiInternalBug385636Parser(PsiBuilder builder, TokenStream input, Bug385636ElementTypeProvider elementTypeProvider, Bug385636GrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Program";
    	}




    // $ANTLR start "entryRuleProgram"
    // PsiInternalBug385636.g:52:1: entryRuleProgram returns [Boolean current=false] : iv_ruleProgram= ruleProgram EOF ;
    public final Boolean entryRuleProgram() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleProgram = null;


        try {
            // PsiInternalBug385636.g:52:49: (iv_ruleProgram= ruleProgram EOF )
            // PsiInternalBug385636.g:53:2: iv_ruleProgram= ruleProgram EOF
            {
             markComposite(elementTypeProvider.getProgramElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
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
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // PsiInternalBug385636.g:59:1: ruleProgram returns [Boolean current=false] : ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) ;
    public final Boolean ruleProgram() throws RecognitionException {
        Boolean current = false;

        Token otherlv_2=null;
        Boolean lv_define_0_0 = null;

        Boolean lv_statements_1_0 = null;


        try {
            // PsiInternalBug385636.g:60:1: ( ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) )
            // PsiInternalBug385636.g:61:2: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            {
            // PsiInternalBug385636.g:61:2: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            // PsiInternalBug385636.g:62:3: ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END'
            {
            // PsiInternalBug385636.g:62:3: ( (lv_define_0_0= ruleDefineVariables ) )
            // PsiInternalBug385636.g:63:4: (lv_define_0_0= ruleDefineVariables )
            {
            // PsiInternalBug385636.g:63:4: (lv_define_0_0= ruleDefineVariables )
            // PsiInternalBug385636.g:64:5: lv_define_0_0= ruleDefineVariables
            {

            					markComposite(elementTypeProvider.getProgram_DefineDefineVariablesParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            lv_define_0_0=ruleDefineVariables();

            state._fsp--;


            					doneComposite();
            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            }


            }

            // PsiInternalBug385636.g:77:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug385636.g:78:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // PsiInternalBug385636.g:78:4: (lv_statements_1_0= ruleStatement )
            	    // PsiInternalBug385636.g:79:5: lv_statements_1_0= ruleStatement
            	    {

            	    					markComposite(elementTypeProvider.getProgram_StatementsStatementParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_statements_1_0=ruleStatement();

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
            	    break loop1;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getProgram_ENDKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleDefineVariables"
    // PsiInternalBug385636.g:103:1: entryRuleDefineVariables returns [Boolean current=false] : iv_ruleDefineVariables= ruleDefineVariables EOF ;
    public final Boolean entryRuleDefineVariables() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDefineVariables = null;


        try {
            // PsiInternalBug385636.g:103:57: (iv_ruleDefineVariables= ruleDefineVariables EOF )
            // PsiInternalBug385636.g:104:2: iv_ruleDefineVariables= ruleDefineVariables EOF
            {
             markComposite(elementTypeProvider.getDefineVariablesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefineVariables=ruleDefineVariables();

            state._fsp--;

             current =iv_ruleDefineVariables; 
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
    // $ANTLR end "entryRuleDefineVariables"


    // $ANTLR start "ruleDefineVariables"
    // PsiInternalBug385636.g:110:1: ruleDefineVariables returns [Boolean current=false] : (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) ;
    public final Boolean ruleDefineVariables() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Boolean lv_variables_1_0 = null;


        try {
            // PsiInternalBug385636.g:111:1: ( (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) )
            // PsiInternalBug385636.g:112:2: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            {
            // PsiInternalBug385636.g:112:2: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            // PsiInternalBug385636.g:113:3: otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES'
            {

            			markLeaf(elementTypeProvider.getDefineVariables_VARIABLESKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug385636.g:120:3: ( (lv_variables_1_0= ruleDefineVariable ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalBug385636.g:121:4: (lv_variables_1_0= ruleDefineVariable )
            	    {
            	    // PsiInternalBug385636.g:121:4: (lv_variables_1_0= ruleDefineVariable )
            	    // PsiInternalBug385636.g:122:5: lv_variables_1_0= ruleDefineVariable
            	    {

            	    					markComposite(elementTypeProvider.getDefineVariables_VariablesDefineVariableParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    lv_variables_1_0=ruleDefineVariable();

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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            			markLeaf(elementTypeProvider.getDefineVariables_ENDVARIABLESKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_2);
            		

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
    // $ANTLR end "ruleDefineVariables"


    // $ANTLR start "entryRuleDefineVariable"
    // PsiInternalBug385636.g:146:1: entryRuleDefineVariable returns [Boolean current=false] : iv_ruleDefineVariable= ruleDefineVariable EOF ;
    public final Boolean entryRuleDefineVariable() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleDefineVariable = null;


        try {
            // PsiInternalBug385636.g:146:56: (iv_ruleDefineVariable= ruleDefineVariable EOF )
            // PsiInternalBug385636.g:147:2: iv_ruleDefineVariable= ruleDefineVariable EOF
            {
             markComposite(elementTypeProvider.getDefineVariableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDefineVariable=ruleDefineVariable();

            state._fsp--;

             current =iv_ruleDefineVariable; 
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
    // $ANTLR end "entryRuleDefineVariable"


    // $ANTLR start "ruleDefineVariable"
    // PsiInternalBug385636.g:153:1: ruleDefineVariable returns [Boolean current=false] : (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final Boolean ruleDefineVariable() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalBug385636.g:154:1: ( (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBug385636.g:155:2: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBug385636.g:155:2: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBug385636.g:156:3: otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getDefineVariable_NAMEKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug385636.g:163:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug385636.g:164:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug385636.g:164:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug385636.g:165:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDefineVariable_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

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
    // $ANTLR end "ruleDefineVariable"


    // $ANTLR start "entryRuleNVariableAccess"
    // PsiInternalBug385636.g:184:1: entryRuleNVariableAccess returns [Boolean current=false] : iv_ruleNVariableAccess= ruleNVariableAccess EOF ;
    public final Boolean entryRuleNVariableAccess() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNVariableAccess = null;


        try {
            // PsiInternalBug385636.g:184:57: (iv_ruleNVariableAccess= ruleNVariableAccess EOF )
            // PsiInternalBug385636.g:185:2: iv_ruleNVariableAccess= ruleNVariableAccess EOF
            {
             markComposite(elementTypeProvider.getNVariableAccessElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNVariableAccess=ruleNVariableAccess();

            state._fsp--;

             current =iv_ruleNVariableAccess; 
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
    // $ANTLR end "entryRuleNVariableAccess"


    // $ANTLR start "ruleNVariableAccess"
    // PsiInternalBug385636.g:191:1: ruleNVariableAccess returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean ruleNVariableAccess() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalBug385636.g:192:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalBug385636.g:193:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalBug385636.g:193:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalBug385636.g:194:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalBug385636.g:194:3: (otherlv_0= RULE_ID )
            // PsiInternalBug385636.g:195:4: otherlv_0= RULE_ID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markLeaf(elementTypeProvider.getNVariableAccess_VariableDefineVariableCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
    // $ANTLR end "ruleNVariableAccess"


    // $ANTLR start "entryRuleStatement"
    // PsiInternalBug385636.g:213:1: entryRuleStatement returns [Boolean current=false] : iv_ruleStatement= ruleStatement EOF ;
    public final Boolean entryRuleStatement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleStatement = null;


        try {
            // PsiInternalBug385636.g:213:51: (iv_ruleStatement= ruleStatement EOF )
            // PsiInternalBug385636.g:214:2: iv_ruleStatement= ruleStatement EOF
            {
             markComposite(elementTypeProvider.getStatementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // PsiInternalBug385636.g:220:1: ruleStatement returns [Boolean current=false] : (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) ;
    public final Boolean ruleStatement() throws RecognitionException {
        Boolean current = false;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Boolean this_Expression_VariableName_0 = null;

        Boolean lv_right_3_0 = null;

        Boolean lv_right_6_0 = null;

        Boolean lv_right_9_0 = null;

        Boolean lv_right_12_0 = null;

        Boolean lv_right_15_0 = null;

        Boolean lv_right_19_0 = null;

        Boolean lv_right_23_0 = null;


        try {
            // PsiInternalBug385636.g:221:1: ( (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) )
            // PsiInternalBug385636.g:222:2: (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            {
            // PsiInternalBug385636.g:222:2: (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            // PsiInternalBug385636.g:223:3: this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            {

            			markComposite(elementTypeProvider.getStatement_Expression_VariableNameParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            this_Expression_VariableName_0=ruleExpression_VariableName();

            state._fsp--;


            			current = this_Expression_VariableName_0;
            			doneComposite();
            		
            // PsiInternalBug385636.g:231:3: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            loop3:
            do {
                int alt3=8;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // PsiInternalBug385636.g:232:4: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:232:4: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:233:5: otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C1Keyword_1_0_0ElementType());
            	    				
            	    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_1);
            	    				
            	    // PsiInternalBug385636.g:240:5: ()
            	    // PsiInternalBug385636.g:241:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Larger_EqualLeftAction_1_0_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:247:5: ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:248:6: (lv_right_3_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:248:6: (lv_right_3_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:249:7: lv_right_3_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_0_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_3_0=ruleExpression_VariableName();

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
            	    // PsiInternalBug385636.g:264:4: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:264:4: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:265:5: otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C2Keyword_1_1_0ElementType());
            	    				
            	    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_4);
            	    				
            	    // PsiInternalBug385636.g:272:5: ()
            	    // PsiInternalBug385636.g:273:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_SmallerLeftAction_1_1_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:279:5: ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:280:6: (lv_right_6_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:280:6: (lv_right_6_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:281:7: lv_right_6_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_1_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_6_0=ruleExpression_VariableName();

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
            	case 3 :
            	    // PsiInternalBug385636.g:296:4: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:296:4: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:297:5: otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C3Keyword_1_2_0ElementType());
            	    				
            	    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_7);
            	    				
            	    // PsiInternalBug385636.g:304:5: ()
            	    // PsiInternalBug385636.g:305:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Smaller_EqualLeftAction_1_2_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:311:5: ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:312:6: (lv_right_9_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:312:6: (lv_right_9_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:313:7: lv_right_9_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_2_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_9_0=ruleExpression_VariableName();

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
            	case 4 :
            	    // PsiInternalBug385636.g:328:4: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:328:4: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:329:5: otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C4Keyword_1_3_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalBug385636.g:336:5: ()
            	    // PsiInternalBug385636.g:337:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_EqualLeftAction_1_3_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:343:5: ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:344:6: (lv_right_12_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:344:6: (lv_right_12_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:345:7: lv_right_12_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_3_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_12_0=ruleExpression_VariableName();

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
            	case 5 :
            	    // PsiInternalBug385636.g:360:4: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:360:4: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:361:5: otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C5Keyword_1_4_0ElementType());
            	    				
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_13);
            	    				
            	    // PsiInternalBug385636.g:368:5: ()
            	    // PsiInternalBug385636.g:369:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_EqualLeftAction_1_4_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:375:5: ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:376:6: (lv_right_15_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:376:6: (lv_right_15_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:377:7: lv_right_15_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_4_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_15_0=ruleExpression_VariableName();

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
            	    // PsiInternalBug385636.g:392:4: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:392:4: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:393:5: (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    {
            	    // PsiInternalBug385636.g:393:5: (otherlv_16= 'C6' otherlv_17= 'C7' )
            	    // PsiInternalBug385636.g:394:6: otherlv_16= 'C6' otherlv_17= 'C7'
            	    {

            	    						markLeaf(elementTypeProvider.getStatement_C6Keyword_1_5_0_0ElementType());
            	    					
            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_8); 

            	    						doneLeaf(otherlv_16);
            	    					

            	    						markLeaf(elementTypeProvider.getStatement_C7Keyword_1_5_0_1ElementType());
            	    					
            	    otherlv_17=(Token)match(input,21,FollowSets000.FOLLOW_6); 

            	    						doneLeaf(otherlv_17);
            	    					

            	    }

            	    // PsiInternalBug385636.g:409:5: ()
            	    // PsiInternalBug385636.g:410:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_LessLeftAction_1_5_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:416:5: ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:417:6: (lv_right_19_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:417:6: (lv_right_19_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:418:7: lv_right_19_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_5_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_19_0=ruleExpression_VariableName();

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
            	    // PsiInternalBug385636.g:433:4: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:433:4: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:434:5: (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    {
            	    // PsiInternalBug385636.g:434:5: (otherlv_20= 'C6' otherlv_21= 'C8' )
            	    // PsiInternalBug385636.g:435:6: otherlv_20= 'C6' otherlv_21= 'C8'
            	    {

            	    						markLeaf(elementTypeProvider.getStatement_C6Keyword_1_6_0_0ElementType());
            	    					
            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_9); 

            	    						doneLeaf(otherlv_20);
            	    					

            	    						markLeaf(elementTypeProvider.getStatement_C8Keyword_1_6_0_1ElementType());
            	    					
            	    otherlv_21=(Token)match(input,22,FollowSets000.FOLLOW_6); 

            	    						doneLeaf(otherlv_21);
            	    					

            	    }

            	    // PsiInternalBug385636.g:450:5: ()
            	    // PsiInternalBug385636.g:451:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_GreaterLeftAction_1_6_1ElementType());
            	    						doneComposite();
            	    						associateWithSemanticElement();
            	    					

            	    }

            	    // PsiInternalBug385636.g:457:5: ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:458:6: (lv_right_23_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:458:6: (lv_right_23_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:459:7: lv_right_23_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_6_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_right_23_0=ruleExpression_VariableName();

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
            	    break loop3;
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleExpression_VariableName"
    // PsiInternalBug385636.g:478:1: entryRuleExpression_VariableName returns [Boolean current=false] : iv_ruleExpression_VariableName= ruleExpression_VariableName EOF ;
    public final Boolean entryRuleExpression_VariableName() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleExpression_VariableName = null;


        try {
            // PsiInternalBug385636.g:478:65: (iv_ruleExpression_VariableName= ruleExpression_VariableName EOF )
            // PsiInternalBug385636.g:479:2: iv_ruleExpression_VariableName= ruleExpression_VariableName EOF
            {
             markComposite(elementTypeProvider.getExpression_VariableNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleExpression_VariableName=ruleExpression_VariableName();

            state._fsp--;

             current =iv_ruleExpression_VariableName; 
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
    // $ANTLR end "entryRuleExpression_VariableName"


    // $ANTLR start "ruleExpression_VariableName"
    // PsiInternalBug385636.g:485:1: ruleExpression_VariableName returns [Boolean current=false] : ( (lv_variable_0_0= ruleNVariableAccess ) ) ;
    public final Boolean ruleExpression_VariableName() throws RecognitionException {
        Boolean current = false;

        Boolean lv_variable_0_0 = null;


        try {
            // PsiInternalBug385636.g:486:1: ( ( (lv_variable_0_0= ruleNVariableAccess ) ) )
            // PsiInternalBug385636.g:487:2: ( (lv_variable_0_0= ruleNVariableAccess ) )
            {
            // PsiInternalBug385636.g:487:2: ( (lv_variable_0_0= ruleNVariableAccess ) )
            // PsiInternalBug385636.g:488:3: (lv_variable_0_0= ruleNVariableAccess )
            {
            // PsiInternalBug385636.g:488:3: (lv_variable_0_0= ruleNVariableAccess )
            // PsiInternalBug385636.g:489:4: lv_variable_0_0= ruleNVariableAccess
            {

            				markComposite(elementTypeProvider.getExpression_VariableName_VariableNVariableAccessParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            lv_variable_0_0=ruleNVariableAccess();

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression_VariableName"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\1\11\uffff";
    static final String dfa_3s = "\1\4\6\uffff\1\25\2\uffff";
    static final String dfa_4s = "\1\24\6\uffff\1\26\2\uffff";
    static final String dfa_5s = "\1\uffff\1\10\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\6";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\6\uffff\1\1\3\uffff\1\2\1\3\1\4\1\5\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\10",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()* loopback of 231:3: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000400000L});
    }


}
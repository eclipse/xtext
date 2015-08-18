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
    // PsiInternalBug385636.g:52:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:52:17: ( ruleProgram EOF )
            // PsiInternalBug385636.g:53:2: ruleProgram EOF
            {
             markComposite(elementTypeProvider.getProgramElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleProgram();

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
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // PsiInternalBug385636.g:58:1: ruleProgram : ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) ;
    public final void ruleProgram() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // PsiInternalBug385636.g:58:12: ( ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) )
            // PsiInternalBug385636.g:59:2: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            {
            // PsiInternalBug385636.g:59:2: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            // PsiInternalBug385636.g:60:3: ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END'
            {
            // PsiInternalBug385636.g:60:3: ( (lv_define_0_0= ruleDefineVariables ) )
            // PsiInternalBug385636.g:61:4: (lv_define_0_0= ruleDefineVariables )
            {
            // PsiInternalBug385636.g:61:4: (lv_define_0_0= ruleDefineVariables )
            // PsiInternalBug385636.g:62:5: lv_define_0_0= ruleDefineVariables
            {

            					markComposite(elementTypeProvider.getProgram_DefineDefineVariablesParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_3);
            ruleDefineVariables();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // PsiInternalBug385636.g:71:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalBug385636.g:72:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // PsiInternalBug385636.g:72:4: (lv_statements_1_0= ruleStatement )
            	    // PsiInternalBug385636.g:73:5: lv_statements_1_0= ruleStatement
            	    {

            	    					markComposite(elementTypeProvider.getProgram_StatementsStatementParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleStatement();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
        return ;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleDefineVariables"
    // PsiInternalBug385636.g:93:1: entryRuleDefineVariables : ruleDefineVariables EOF ;
    public final void entryRuleDefineVariables() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:93:25: ( ruleDefineVariables EOF )
            // PsiInternalBug385636.g:94:2: ruleDefineVariables EOF
            {
             markComposite(elementTypeProvider.getDefineVariablesElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDefineVariables();

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
    // $ANTLR end "entryRuleDefineVariables"


    // $ANTLR start "ruleDefineVariables"
    // PsiInternalBug385636.g:99:1: ruleDefineVariables : (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) ;
    public final void ruleDefineVariables() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // PsiInternalBug385636.g:99:20: ( (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) )
            // PsiInternalBug385636.g:100:2: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            {
            // PsiInternalBug385636.g:100:2: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            // PsiInternalBug385636.g:101:3: otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES'
            {

            			markLeaf(elementTypeProvider.getDefineVariables_VARIABLESKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug385636.g:108:3: ( (lv_variables_1_0= ruleDefineVariable ) )+
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
            	    // PsiInternalBug385636.g:109:4: (lv_variables_1_0= ruleDefineVariable )
            	    {
            	    // PsiInternalBug385636.g:109:4: (lv_variables_1_0= ruleDefineVariable )
            	    // PsiInternalBug385636.g:110:5: lv_variables_1_0= ruleDefineVariable
            	    {

            	    					markComposite(elementTypeProvider.getDefineVariables_VariablesDefineVariableParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
            	    ruleDefineVariable();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
        return ;
    }
    // $ANTLR end "ruleDefineVariables"


    // $ANTLR start "entryRuleDefineVariable"
    // PsiInternalBug385636.g:130:1: entryRuleDefineVariable : ruleDefineVariable EOF ;
    public final void entryRuleDefineVariable() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:130:24: ( ruleDefineVariable EOF )
            // PsiInternalBug385636.g:131:2: ruleDefineVariable EOF
            {
             markComposite(elementTypeProvider.getDefineVariableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleDefineVariable();

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
    // $ANTLR end "entryRuleDefineVariable"


    // $ANTLR start "ruleDefineVariable"
    // PsiInternalBug385636.g:136:1: ruleDefineVariable : (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDefineVariable() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // PsiInternalBug385636.g:136:19: ( (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) )
            // PsiInternalBug385636.g:137:2: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // PsiInternalBug385636.g:137:2: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            // PsiInternalBug385636.g:138:3: otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getDefineVariable_NAMEKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalBug385636.g:145:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalBug385636.g:146:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalBug385636.g:146:4: (lv_name_1_0= RULE_ID )
            // PsiInternalBug385636.g:147:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getDefineVariable_NameIDTerminalRuleCall_1_0ElementType());
            				
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
        return ;
    }
    // $ANTLR end "ruleDefineVariable"


    // $ANTLR start "entryRuleNVariableAccess"
    // PsiInternalBug385636.g:160:1: entryRuleNVariableAccess : ruleNVariableAccess EOF ;
    public final void entryRuleNVariableAccess() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:160:25: ( ruleNVariableAccess EOF )
            // PsiInternalBug385636.g:161:2: ruleNVariableAccess EOF
            {
             markComposite(elementTypeProvider.getNVariableAccessElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNVariableAccess();

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
    // $ANTLR end "entryRuleNVariableAccess"


    // $ANTLR start "ruleNVariableAccess"
    // PsiInternalBug385636.g:166:1: ruleNVariableAccess : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleNVariableAccess() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // PsiInternalBug385636.g:166:20: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalBug385636.g:167:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalBug385636.g:167:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalBug385636.g:168:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalBug385636.g:168:3: (otherlv_0= RULE_ID )
            // PsiInternalBug385636.g:169:4: otherlv_0= RULE_ID
            {

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
        return ;
    }
    // $ANTLR end "ruleNVariableAccess"


    // $ANTLR start "entryRuleStatement"
    // PsiInternalBug385636.g:181:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:181:19: ( ruleStatement EOF )
            // PsiInternalBug385636.g:182:2: ruleStatement EOF
            {
             markComposite(elementTypeProvider.getStatementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleStatement();

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // PsiInternalBug385636.g:187:1: ruleStatement : ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) ;
    public final void ruleStatement() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_21=null;

        try {
            // PsiInternalBug385636.g:187:14: ( ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) )
            // PsiInternalBug385636.g:188:2: ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            {
            // PsiInternalBug385636.g:188:2: ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            // PsiInternalBug385636.g:189:3: ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            {

            			markComposite(elementTypeProvider.getStatement_Expression_VariableNameParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_7);
            ruleExpression_VariableName();

            state._fsp--;


            			doneComposite();
            		
            // PsiInternalBug385636.g:196:3: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            loop3:
            do {
                int alt3=8;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // PsiInternalBug385636.g:197:4: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:197:4: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:198:5: otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C1Keyword_1_0_0ElementType());
            	    				
            	    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_1);
            	    				
            	    // PsiInternalBug385636.g:205:5: ()
            	    // PsiInternalBug385636.g:206:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Larger_EqualLeftAction_1_0_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:211:5: ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:212:6: (lv_right_3_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:212:6: (lv_right_3_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:213:7: lv_right_3_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_0_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // PsiInternalBug385636.g:224:4: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:224:4: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:225:5: otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C2Keyword_1_1_0ElementType());
            	    				
            	    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_4);
            	    				
            	    // PsiInternalBug385636.g:232:5: ()
            	    // PsiInternalBug385636.g:233:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_SmallerLeftAction_1_1_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:238:5: ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:239:6: (lv_right_6_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:239:6: (lv_right_6_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:240:7: lv_right_6_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_1_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // PsiInternalBug385636.g:251:4: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:251:4: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:252:5: otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C3Keyword_1_2_0ElementType());
            	    				
            	    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_7);
            	    				
            	    // PsiInternalBug385636.g:259:5: ()
            	    // PsiInternalBug385636.g:260:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Smaller_EqualLeftAction_1_2_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:265:5: ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:266:6: (lv_right_9_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:266:6: (lv_right_9_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:267:7: lv_right_9_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_2_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // PsiInternalBug385636.g:278:4: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:278:4: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:279:5: otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C4Keyword_1_3_0ElementType());
            	    				
            	    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_10);
            	    				
            	    // PsiInternalBug385636.g:286:5: ()
            	    // PsiInternalBug385636.g:287:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_EqualLeftAction_1_3_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:292:5: ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:293:6: (lv_right_12_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:293:6: (lv_right_12_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:294:7: lv_right_12_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_3_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // PsiInternalBug385636.g:305:4: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:305:4: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:306:5: otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf(elementTypeProvider.getStatement_C5Keyword_1_4_0ElementType());
            	    				
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_6); 

            	    					doneLeaf(otherlv_13);
            	    				
            	    // PsiInternalBug385636.g:313:5: ()
            	    // PsiInternalBug385636.g:314:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_EqualLeftAction_1_4_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:319:5: ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:320:6: (lv_right_15_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:320:6: (lv_right_15_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:321:7: lv_right_15_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_4_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // PsiInternalBug385636.g:332:4: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:332:4: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:333:5: (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    {
            	    // PsiInternalBug385636.g:333:5: (otherlv_16= 'C6' otherlv_17= 'C7' )
            	    // PsiInternalBug385636.g:334:6: otherlv_16= 'C6' otherlv_17= 'C7'
            	    {

            	    						markLeaf(elementTypeProvider.getStatement_C6Keyword_1_5_0_0ElementType());
            	    					
            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_8); 

            	    						doneLeaf(otherlv_16);
            	    					

            	    						markLeaf(elementTypeProvider.getStatement_C7Keyword_1_5_0_1ElementType());
            	    					
            	    otherlv_17=(Token)match(input,21,FollowSets000.FOLLOW_6); 

            	    						doneLeaf(otherlv_17);
            	    					

            	    }

            	    // PsiInternalBug385636.g:349:5: ()
            	    // PsiInternalBug385636.g:350:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_LessLeftAction_1_5_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:355:5: ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:356:6: (lv_right_19_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:356:6: (lv_right_19_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:357:7: lv_right_19_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_5_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // PsiInternalBug385636.g:368:4: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    {
            	    // PsiInternalBug385636.g:368:4: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    // PsiInternalBug385636.g:369:5: (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    {
            	    // PsiInternalBug385636.g:369:5: (otherlv_20= 'C6' otherlv_21= 'C8' )
            	    // PsiInternalBug385636.g:370:6: otherlv_20= 'C6' otherlv_21= 'C8'
            	    {

            	    						markLeaf(elementTypeProvider.getStatement_C6Keyword_1_6_0_0ElementType());
            	    					
            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_9); 

            	    						doneLeaf(otherlv_20);
            	    					

            	    						markLeaf(elementTypeProvider.getStatement_C8Keyword_1_6_0_1ElementType());
            	    					
            	    otherlv_21=(Token)match(input,22,FollowSets000.FOLLOW_6); 

            	    						doneLeaf(otherlv_21);
            	    					

            	    }

            	    // PsiInternalBug385636.g:385:5: ()
            	    // PsiInternalBug385636.g:386:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_GreaterLeftAction_1_6_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // PsiInternalBug385636.g:391:5: ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    // PsiInternalBug385636.g:392:6: (lv_right_23_0= ruleExpression_VariableName )
            	    {
            	    // PsiInternalBug385636.g:392:6: (lv_right_23_0= ruleExpression_VariableName )
            	    // PsiInternalBug385636.g:393:7: lv_right_23_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_6_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

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
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleExpression_VariableName"
    // PsiInternalBug385636.g:408:1: entryRuleExpression_VariableName : ruleExpression_VariableName EOF ;
    public final void entryRuleExpression_VariableName() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:408:33: ( ruleExpression_VariableName EOF )
            // PsiInternalBug385636.g:409:2: ruleExpression_VariableName EOF
            {
             markComposite(elementTypeProvider.getExpression_VariableNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExpression_VariableName();

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
    // $ANTLR end "entryRuleExpression_VariableName"


    // $ANTLR start "ruleExpression_VariableName"
    // PsiInternalBug385636.g:414:1: ruleExpression_VariableName : ( (lv_variable_0_0= ruleNVariableAccess ) ) ;
    public final void ruleExpression_VariableName() throws RecognitionException {
        try {
            // PsiInternalBug385636.g:414:28: ( ( (lv_variable_0_0= ruleNVariableAccess ) ) )
            // PsiInternalBug385636.g:415:2: ( (lv_variable_0_0= ruleNVariableAccess ) )
            {
            // PsiInternalBug385636.g:415:2: ( (lv_variable_0_0= ruleNVariableAccess ) )
            // PsiInternalBug385636.g:416:3: (lv_variable_0_0= ruleNVariableAccess )
            {
            // PsiInternalBug385636.g:416:3: (lv_variable_0_0= ruleNVariableAccess )
            // PsiInternalBug385636.g:417:4: lv_variable_0_0= ruleNVariableAccess
            {

            				markComposite(elementTypeProvider.getExpression_VariableName_VariableNVariableAccessParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_2);
            ruleNVariableAccess();

            state._fsp--;


            				doneComposite();
            			

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
    // $ANTLR end "ruleExpression_VariableName"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\12\uffff";
    static final String DFA3_eofS =
        "\1\1\11\uffff";
    static final String DFA3_minS =
        "\1\4\6\uffff\1\25\2\uffff";
    static final String DFA3_maxS =
        "\1\24\6\uffff\1\26\2\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\10\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\6";
    static final String DFA3_specialS =
        "\12\uffff}>";
    static final String[] DFA3_transitionS = {
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

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 196:3: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*";
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
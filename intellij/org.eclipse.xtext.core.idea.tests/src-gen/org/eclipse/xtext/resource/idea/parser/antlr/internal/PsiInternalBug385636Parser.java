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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:52:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:52:17: ( ruleProgram EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:53:2: ruleProgram EOF
            {
             markComposite(elementTypeProvider.getProgramElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram54);
            ruleProgram();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:59:1: ruleProgram : ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) ;
    public final void ruleProgram() throws RecognitionException {
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:59:12: ( ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:60:2: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:60:2: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:61:3: ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:61:3: ( (lv_define_0_0= ruleDefineVariables ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:62:4: (lv_define_0_0= ruleDefineVariables )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:62:4: (lv_define_0_0= ruleDefineVariables )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:63:5: lv_define_0_0= ruleDefineVariables
            {

            					markComposite(elementTypeProvider.getProgram_DefineDefineVariablesParserRuleCall_0_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleDefineVariables_in_ruleProgram92);
            ruleDefineVariables();

            state._fsp--;


            					doneComposite();
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:72:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:73:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:73:4: (lv_statements_1_0= ruleStatement )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:74:5: lv_statements_1_0= ruleStatement
            	    {

            	    					markComposite(elementTypeProvider.getProgram_StatementsStatementParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleProgram130);
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


            			markLeaf();
            		
            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleProgram156); 

            			doneLeaf(otherlv_2, elementTypeProvider.getProgram_ENDKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:94:1: entryRuleDefineVariables : ruleDefineVariables EOF ;
    public final void entryRuleDefineVariables() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:94:25: ( ruleDefineVariables EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:95:2: ruleDefineVariables EOF
            {
             markComposite(elementTypeProvider.getDefineVariablesElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefineVariables_in_entryRuleDefineVariables176);
            ruleDefineVariables();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefineVariables182); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:101:1: ruleDefineVariables : (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) ;
    public final void ruleDefineVariables() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:101:20: ( (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:102:2: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:102:2: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:103:3: otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDefineVariables201); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDefineVariables_VARIABLESKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:110:3: ( (lv_variables_1_0= ruleDefineVariable ) )+
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
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:111:4: (lv_variables_1_0= ruleDefineVariable )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:111:4: (lv_variables_1_0= ruleDefineVariable )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:112:5: lv_variables_1_0= ruleDefineVariable
            	    {

            	    					markComposite(elementTypeProvider.getDefineVariables_VariablesDefineVariableParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleDefineVariable_in_ruleDefineVariables228);
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


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDefineVariables254); 

            			doneLeaf(otherlv_2, elementTypeProvider.getDefineVariables_ENDVARIABLESKeyword_2ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:132:1: entryRuleDefineVariable : ruleDefineVariable EOF ;
    public final void entryRuleDefineVariable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:132:24: ( ruleDefineVariable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:133:2: ruleDefineVariable EOF
            {
             markComposite(elementTypeProvider.getDefineVariableElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefineVariable_in_entryRuleDefineVariable274);
            ruleDefineVariable();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefineVariable280); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:139:1: ruleDefineVariable : (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final void ruleDefineVariable() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:139:19: ( (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:140:2: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:140:2: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:141:3: otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDefineVariable299); 

            			doneLeaf(otherlv_0, elementTypeProvider.getDefineVariable_NAMEKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:148:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:149:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:149:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:150:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDefineVariable326); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getDefineVariable_NameIDTerminalRuleCall_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:163:1: entryRuleNVariableAccess : ruleNVariableAccess EOF ;
    public final void entryRuleNVariableAccess() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:163:25: ( ruleNVariableAccess EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:164:2: ruleNVariableAccess EOF
            {
             markComposite(elementTypeProvider.getNVariableAccessElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNVariableAccess_in_entryRuleNVariableAccess357);
            ruleNVariableAccess();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNVariableAccess363); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:170:1: ruleNVariableAccess : ( (otherlv_0= RULE_ID ) ) ;
    public final void ruleNVariableAccess() throws RecognitionException {
        Token otherlv_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:170:20: ( ( (otherlv_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:171:2: ( (otherlv_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:171:2: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:172:3: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:172:3: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:173:4: otherlv_0= RULE_ID
            {

            				markLeaf();
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNVariableAccess388); 

            				doneLeaf(otherlv_0, elementTypeProvider.getNVariableAccess_VariableDefineVariableCrossReference_0ElementType());
            			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:185:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:185:19: ( ruleStatement EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:186:2: ruleStatement EOF
            {
             markComposite(elementTypeProvider.getStatementElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_entryRuleStatement413);
            ruleStatement();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatement419); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:192:1: ruleStatement : ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:192:14: ( ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:193:2: ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:193:2: ( ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:194:3: ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            {

            			markComposite(elementTypeProvider.getStatement_Expression_VariableNameParserRuleCall_0ElementType());
            		
            pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement436);
            ruleExpression_VariableName();

            state._fsp--;


            			doneComposite();
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:201:3: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            loop3:
            do {
                int alt3=8;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:202:4: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:202:4: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:203:5: otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleStatement463); 

            	    					doneLeaf(otherlv_1, elementTypeProvider.getStatement_C1Keyword_1_0_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:210:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:211:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Larger_EqualLeftAction_1_0_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:216:5: ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:217:6: (lv_right_3_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:217:6: (lv_right_3_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:218:7: lv_right_3_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_0_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement519);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:229:4: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:229:4: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:230:5: otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleStatement573); 

            	    					doneLeaf(otherlv_4, elementTypeProvider.getStatement_C2Keyword_1_1_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:237:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:238:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_SmallerLeftAction_1_1_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:243:5: ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:244:6: (lv_right_6_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:244:6: (lv_right_6_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:245:7: lv_right_6_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_1_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement629);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:256:4: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:256:4: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:257:5: otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleStatement683); 

            	    					doneLeaf(otherlv_7, elementTypeProvider.getStatement_C3Keyword_1_2_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:264:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:265:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Smaller_EqualLeftAction_1_2_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:270:5: ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:271:6: (lv_right_9_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:271:6: (lv_right_9_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:272:7: lv_right_9_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_2_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement739);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:283:4: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:283:4: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:284:5: otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleStatement793); 

            	    					doneLeaf(otherlv_10, elementTypeProvider.getStatement_C4Keyword_1_3_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:291:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:292:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_EqualLeftAction_1_3_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:297:5: ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:298:6: (lv_right_12_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:298:6: (lv_right_12_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:299:7: lv_right_12_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_3_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement849);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:310:4: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:310:4: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:311:5: otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    {

            	    					markLeaf();
            	    				
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleStatement903); 

            	    					doneLeaf(otherlv_13, elementTypeProvider.getStatement_C5Keyword_1_4_0ElementType());
            	    				
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:318:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:319:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_EqualLeftAction_1_4_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:324:5: ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:325:6: (lv_right_15_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:325:6: (lv_right_15_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:326:7: lv_right_15_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_4_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement959);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:337:4: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:337:4: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:338:5: (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:338:5: (otherlv_16= 'C6' otherlv_17= 'C7' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:339:6: otherlv_16= 'C6' otherlv_17= 'C7'
            	    {

            	    						markLeaf();
            	    					
            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleStatement1021); 

            	    						doneLeaf(otherlv_16, elementTypeProvider.getStatement_C6Keyword_1_5_0_0ElementType());
            	    					

            	    						markLeaf();
            	    					
            	    otherlv_17=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleStatement1044); 

            	    						doneLeaf(otherlv_17, elementTypeProvider.getStatement_C7Keyword_1_5_0_1ElementType());
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:354:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:355:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_LessLeftAction_1_5_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:360:5: ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:361:6: (lv_right_19_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:361:6: (lv_right_19_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:362:7: lv_right_19_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_5_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement1107);
            	    ruleExpression_VariableName();

            	    state._fsp--;


            	    							doneComposite();
            	    						

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:373:4: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:373:4: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:374:5: (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:374:5: (otherlv_20= 'C6' otherlv_21= 'C8' )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:375:6: otherlv_20= 'C6' otherlv_21= 'C8'
            	    {

            	    						markLeaf();
            	    					
            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleStatement1169); 

            	    						doneLeaf(otherlv_20, elementTypeProvider.getStatement_C6Keyword_1_6_0_0ElementType());
            	    					

            	    						markLeaf();
            	    					
            	    otherlv_21=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleStatement1192); 

            	    						doneLeaf(otherlv_21, elementTypeProvider.getStatement_C8Keyword_1_6_0_1ElementType());
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:390:5: ()
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:391:6: 
            	    {

            	    						precedeComposite(elementTypeProvider.getStatement_Expression_Not_GreaterLeftAction_1_6_1ElementType());
            	    						doneComposite();
            	    					

            	    }

            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:396:5: ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:397:6: (lv_right_23_0= ruleExpression_VariableName )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:397:6: (lv_right_23_0= ruleExpression_VariableName )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:398:7: lv_right_23_0= ruleExpression_VariableName
            	    {

            	    							markComposite(elementTypeProvider.getStatement_RightExpression_VariableNameParserRuleCall_1_6_2_0ElementType());
            	    						
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement1255);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:413:1: entryRuleExpression_VariableName : ruleExpression_VariableName EOF ;
    public final void entryRuleExpression_VariableName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:413:33: ( ruleExpression_VariableName EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:414:2: ruleExpression_VariableName EOF
            {
             markComposite(elementTypeProvider.getExpression_VariableNameElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_entryRuleExpression_VariableName1302);
            ruleExpression_VariableName();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression_VariableName1308); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:420:1: ruleExpression_VariableName : ( (lv_variable_0_0= ruleNVariableAccess ) ) ;
    public final void ruleExpression_VariableName() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:420:28: ( ( (lv_variable_0_0= ruleNVariableAccess ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:421:2: ( (lv_variable_0_0= ruleNVariableAccess ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:421:2: ( (lv_variable_0_0= ruleNVariableAccess ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:422:3: (lv_variable_0_0= ruleNVariableAccess )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:422:3: (lv_variable_0_0= ruleNVariableAccess )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/resource/idea/parser/antlr/internal/PsiInternalBug385636.g:423:4: lv_variable_0_0= ruleNVariableAccess
            {

            				markComposite(elementTypeProvider.getExpression_VariableName_VariableNVariableAccessParserRuleCall_0ElementType());
            			
            pushFollow(FollowSets000.FOLLOW_ruleNVariableAccess_in_ruleExpression_VariableName1333);
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
        "\1\uffff\1\10\1\1\1\2\1\3\1\4\1\5\1\uffff\1\6\1\7";
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
            "\1\10\1\11",
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
            return "()* loopback of 201:3: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefineVariables_in_ruleProgram92 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleProgram130 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_11_in_ruleProgram156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefineVariables_in_entryRuleDefineVariables176 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefineVariables182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleDefineVariables201 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleDefineVariable_in_ruleDefineVariables228 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleDefineVariables254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefineVariable_in_entryRuleDefineVariable274 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefineVariable280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleDefineVariable299 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDefineVariable326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNVariableAccess_in_entryRuleNVariableAccess357 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNVariableAccess363 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNVariableAccess388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement413 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatement419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement436 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_15_in_ruleStatement463 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement519 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_16_in_ruleStatement573 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement629 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_17_in_ruleStatement683 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement739 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_18_in_ruleStatement793 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement849 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_19_in_ruleStatement903 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement959 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_20_in_ruleStatement1021 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleStatement1044 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement1107 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_20_in_ruleStatement1169 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleStatement1192 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement1255 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_entryRuleExpression_VariableName1302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression_VariableName1308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNVariableAccess_in_ruleExpression_VariableName1333 = new BitSet(new long[]{0x0000000000000002L});
    }


}
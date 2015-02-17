package org.eclipse.xtext.testlanguages.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalFowlerDslTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'events'", "'end'", "'commands'", "'resetting'", "'state'", "'actions'", "'{'", "'}'", "'=>'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalFowlerDslTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalFowlerDslTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalFowlerDslTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g"; }



    private FowlerDslTestLanguageGrammarAccess grammarAccess;

    private FowlerDslTestLanguageElementTypeProvider elementTypeProvider;

    public PsiInternalFowlerDslTestLanguageParser(PsiBuilder builder, TokenStream input, TokenTypeProvider tokenTypeProvider, FowlerDslTestLanguageElementTypeProvider elementTypeProvider, FowlerDslTestLanguageGrammarAccess grammarAccess) {
    	super(builder, input, tokenTypeProvider);
        this.grammarAccess = grammarAccess;
    	this.elementTypeProvider = elementTypeProvider;
    }

    @Override
    protected String getFirstRuleName() {
    	return "Statemachine";
    }




    // $ANTLR start "entryRuleStatemachine"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:49:1: entryRuleStatemachine : ruleStatemachine EOF ;
    public final void entryRuleStatemachine() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:49:22: ( ruleStatemachine EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:50:2: ruleStatemachine EOF
            {
             markComposite(elementTypeProvider.getStatemachineElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleStatemachine_in_entryRuleStatemachine54);
            ruleStatemachine();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatemachine60); 

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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:58:1: ruleStatemachine : (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) ;
    public final void ruleStatemachine() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:58:17: ( (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:59:2: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:59:2: (otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:60:3: otherlv_0= 'events' ( (lv_events_1_0= ruleEvent ) )* otherlv_2= 'end' otherlv_3= 'commands' ( (lv_commands_4_0= ruleCommand ) )* otherlv_5= 'end' ( (lv_states_6_0= ruleState ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleStatemachine83); 

            			doneLeaf(otherlv_0, elementTypeProvider.getStatemachine_EventsKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:67:3: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:68:4: (lv_events_1_0= ruleEvent )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:68:4: (lv_events_1_0= ruleEvent )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:69:5: lv_events_1_0= ruleEvent
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_EventsEventParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleEvent_in_ruleStatemachine110);
            	    ruleEvent();

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
            		
            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleStatemachine136); 

            			doneLeaf(otherlv_2, elementTypeProvider.getStatemachine_EndKeyword_2ElementType());
            		

            			markLeaf();
            		
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleStatemachine150); 

            			doneLeaf(otherlv_3, elementTypeProvider.getStatemachine_CommandsKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:92:3: ( (lv_commands_4_0= ruleCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:93:4: (lv_commands_4_0= ruleCommand )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:93:4: (lv_commands_4_0= ruleCommand )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:94:5: lv_commands_4_0= ruleCommand
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_CommandsCommandParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleCommand_in_ruleStatemachine177);
            	    ruleCommand();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleStatemachine203); 

            			doneLeaf(otherlv_5, elementTypeProvider.getStatemachine_EndKeyword_5ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:110:3: ( (lv_states_6_0= ruleState ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:111:4: (lv_states_6_0= ruleState )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:111:4: (lv_states_6_0= ruleState )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:112:5: lv_states_6_0= ruleState
            	    {

            	    					markComposite(elementTypeProvider.getStatemachine_StatesStateParserRuleCall_6_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleState_in_ruleStatemachine230);
            	    ruleState();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleEvent"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:125:1: entryRuleEvent : ruleEvent EOF ;
    public final void entryRuleEvent() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:125:15: ( ruleEvent EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:126:2: ruleEvent EOF
            {
             markComposite(elementTypeProvider.getEventElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvent_in_entryRuleEvent262);
            ruleEvent();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvent268); 

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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:134:1: ruleEvent : ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) ;
    public final void ruleEvent() throws RecognitionException {
        Token lv_resetting_0_0=null;
        Token lv_name_1_0=null;
        Token lv_code_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:134:10: ( ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:135:2: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:135:2: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:136:3: ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:136:3: ( (lv_resetting_0_0= 'resetting' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:137:4: (lv_resetting_0_0= 'resetting' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:137:4: (lv_resetting_0_0= 'resetting' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:138:5: lv_resetting_0_0= 'resetting'
                    {

                    					markLeaf();
                    				
                    lv_resetting_0_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEvent304); 

                    					doneLeaf(lv_resetting_0_0, elementTypeProvider.getEvent_ResettingResettingKeyword_0_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:147:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:148:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:148:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:149:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEvent343); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEvent_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:158:3: ( (lv_code_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:159:4: (lv_code_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:159:4: (lv_code_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:160:5: lv_code_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_code_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEvent381); 

            					doneLeaf(lv_code_2_0, elementTypeProvider.getEvent_CodeIDTerminalRuleCall_2_0ElementType());
            				

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:173:1: entryRuleCommand : ruleCommand EOF ;
    public final void entryRuleCommand() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:173:17: ( ruleCommand EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:174:2: ruleCommand EOF
            {
             markComposite(elementTypeProvider.getCommandElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCommand_in_entryRuleCommand412);
            ruleCommand();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommand418); 

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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:182:1: ruleCommand : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) ;
    public final void ruleCommand() throws RecognitionException {
        Token lv_name_0_0=null;
        Token lv_code_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:182:12: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:183:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:183:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:184:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:184:3: ( (lv_name_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:185:4: (lv_name_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:185:4: (lv_name_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:186:5: lv_name_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommand454); 

            					doneLeaf(lv_name_0_0, elementTypeProvider.getCommand_NameIDTerminalRuleCall_0_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:195:3: ( (lv_code_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:196:4: (lv_code_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:196:4: (lv_code_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:197:5: lv_code_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_code_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommand492); 

            					doneLeaf(lv_code_1_0, elementTypeProvider.getCommand_CodeIDTerminalRuleCall_1_0ElementType());
            				

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
    // $ANTLR end "ruleCommand"


    // $ANTLR start "entryRuleState"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:210:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:210:15: ( ruleState EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:211:2: ruleState EOF
            {
             markComposite(elementTypeProvider.getStateElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleState_in_entryRuleState523);
            ruleState();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleState529); 

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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:219:1: ruleState : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) ;
    public final void ruleState() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:219:10: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:220:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:220:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:221:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )? ( (lv_transitions_6_0= ruleTransition ) )* otherlv_7= 'end'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleState552); 

            			doneLeaf(otherlv_0, elementTypeProvider.getState_StateKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:228:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:229:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:229:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:230:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleState579); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getState_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:239:3: (otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:240:4: otherlv_2= 'actions' otherlv_3= '{' ( (otherlv_4= RULE_ID ) )+ otherlv_5= '}'
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleState610); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getState_ActionsKeyword_2_0ElementType());
                    			

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleState627); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getState_LeftCurlyBracketKeyword_2_1ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:254:4: ( (otherlv_4= RULE_ID ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:255:5: (otherlv_4= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:255:5: (otherlv_4= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:256:6: otherlv_4= RULE_ID
                    	    {

                    	    						markLeaf();
                    	    					
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleState659); 

                    	    						doneLeaf(otherlv_4, elementTypeProvider.getState_ActionsCommandCrossReference_2_2_0ElementType());
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    				markLeaf();
                    			
                    otherlv_5=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleState690); 

                    				doneLeaf(otherlv_5, elementTypeProvider.getState_RightCurlyBracketKeyword_2_3ElementType());
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:273:3: ( (lv_transitions_6_0= ruleTransition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:274:4: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:274:4: (lv_transitions_6_0= ruleTransition )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:275:5: lv_transitions_6_0= ruleTransition
            	    {

            	    					markComposite(elementTypeProvider.getState_TransitionsTransitionParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleTransition_in_ruleState723);
            	    ruleTransition();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            			markLeaf();
            		
            otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleState749); 

            			doneLeaf(otherlv_7, elementTypeProvider.getState_EndKeyword_4ElementType());
            		

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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:295:1: entryRuleTransition : ruleTransition EOF ;
    public final void entryRuleTransition() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:295:20: ( ruleTransition EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:296:2: ruleTransition EOF
            {
             markComposite(elementTypeProvider.getTransitionElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleTransition_in_entryRuleTransition769);
            ruleTransition();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTransition775); 

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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:304:1: ruleTransition : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) ;
    public final void ruleTransition() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:304:15: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:305:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:305:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:306:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:306:3: ( (otherlv_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:307:4: (otherlv_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:307:4: (otherlv_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:308:5: otherlv_0= RULE_ID
            {

            					markLeaf();
            				
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransition811); 

            					doneLeaf(otherlv_0, elementTypeProvider.getTransition_EventEventCrossReference_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleTransition836); 

            			doneLeaf(otherlv_1, elementTypeProvider.getTransition_EqualsSignGreaterThanSignKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:324:3: ( (otherlv_2= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:325:4: (otherlv_2= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:325:4: (otherlv_2= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/testlanguages/idea/parser/antlr/internal/PsiInternalFowlerDslTestLanguage.g:326:5: otherlv_2= RULE_ID
            {

            					markLeaf();
            				
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTransition863); 

            					doneLeaf(otherlv_2, elementTypeProvider.getTransition_StateStateCrossReference_2_0ElementType());
            				

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
    // $ANTLR end "ruleTransition"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleStatemachine83 = new BitSet(new long[]{0x0000000000005010L});
        public static final BitSet FOLLOW_ruleEvent_in_ruleStatemachine110 = new BitSet(new long[]{0x0000000000005010L});
        public static final BitSet FOLLOW_12_in_ruleStatemachine136 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleStatemachine150 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleCommand_in_ruleStatemachine177 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleStatemachine203 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleState_in_ruleStatemachine230 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent262 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvent268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleEvent304 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEvent343 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEvent381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand412 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommand418 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommand454 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommand492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleState_in_entryRuleState523 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleState529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleState552 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleState579 = new BitSet(new long[]{0x0000000000011010L});
        public static final BitSet FOLLOW_16_in_ruleState610 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleState627 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleState659 = new BitSet(new long[]{0x0000000000040010L});
        public static final BitSet FOLLOW_18_in_ruleState690 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleTransition_in_ruleState723 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleState749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition769 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTransition775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransition811 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleTransition836 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTransition863 = new BitSet(new long[]{0x0000000000000002L});
    }


}
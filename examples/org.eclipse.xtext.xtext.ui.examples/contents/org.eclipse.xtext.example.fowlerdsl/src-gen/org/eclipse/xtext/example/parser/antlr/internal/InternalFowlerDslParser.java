package org.eclipse.xtext.example.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalFowlerDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'events'", "'end'", "'commands'", "'resetting'", "'state'", "'actions'", "'{'", "'}'", "'=>'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalFowlerDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g"; }



     	private FowlerDslGrammarAccess grammarAccess;
     	
        public InternalFowlerDslParser(TokenStream input, IAstFactory factory, FowlerDslGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";	
       	} 



    // $ANTLR start entryRuleStatemachine
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:72:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:73:2: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:74:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStatemachineRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine75);
            iv_ruleStatemachine=ruleStatemachine();
            _fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStatemachine


    // $ANTLR start ruleStatemachine
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:81:1: ruleStatemachine returns [EObject current=null] : ( 'events' ( (lv_events_1_0= ruleEvent ) )* 'end' 'commands' ( (lv_commands_4_0= ruleCommand ) )* 'end' ( (lv_states_6_0= ruleState ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_events_1_0 = null;

        EObject lv_commands_4_0 = null;

        EObject lv_states_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:86:6: ( ( 'events' ( (lv_events_1_0= ruleEvent ) )* 'end' 'commands' ( (lv_commands_4_0= ruleCommand ) )* 'end' ( (lv_states_6_0= ruleState ) )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:87:1: ( 'events' ( (lv_events_1_0= ruleEvent ) )* 'end' 'commands' ( (lv_commands_4_0= ruleCommand ) )* 'end' ( (lv_states_6_0= ruleState ) )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:87:1: ( 'events' ( (lv_events_1_0= ruleEvent ) )* 'end' 'commands' ( (lv_commands_4_0= ruleCommand ) )* 'end' ( (lv_states_6_0= ruleState ) )* )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:87:3: 'events' ( (lv_events_1_0= ruleEvent ) )* 'end' 'commands' ( (lv_commands_4_0= ruleCommand ) )* 'end' ( (lv_states_6_0= ruleState ) )*
            {
            match(input,11,FOLLOW_11_in_ruleStatemachine120); 

                    createLeafNode(grammarAccess.getStatemachineAccess().getEventsKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:91:1: ( (lv_events_1_0= ruleEvent ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:92:1: (lv_events_1_0= ruleEvent )
            	    {
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:92:1: (lv_events_1_0= ruleEvent )
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:93:3: lv_events_1_0= ruleEvent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStatemachineAccess().getEventsEventParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleStatemachine141);
            	    lv_events_1_0=ruleEvent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStatemachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"events",
            	    	        		lv_events_1_0, 
            	    	        		"Event", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleStatemachine152); 

                    createLeafNode(grammarAccess.getStatemachineAccess().getEndKeyword_2(), null); 
                
            match(input,13,FOLLOW_13_in_ruleStatemachine162); 

                    createLeafNode(grammarAccess.getStatemachineAccess().getCommandsKeyword_3(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:123:1: ( (lv_commands_4_0= ruleCommand ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:124:1: (lv_commands_4_0= ruleCommand )
            	    {
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:124:1: (lv_commands_4_0= ruleCommand )
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:125:3: lv_commands_4_0= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStatemachineAccess().getCommandsCommandParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleStatemachine183);
            	    lv_commands_4_0=ruleCommand();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStatemachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"commands",
            	    	        		lv_commands_4_0, 
            	    	        		"Command", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleStatemachine194); 

                    createLeafNode(grammarAccess.getStatemachineAccess().getEndKeyword_5(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:151:1: ( (lv_states_6_0= ruleState ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:152:1: (lv_states_6_0= ruleState )
            	    {
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:152:1: (lv_states_6_0= ruleState )
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:153:3: lv_states_6_0= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine215);
            	    lv_states_6_0=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStatemachineRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"states",
            	    	        		lv_states_6_0, 
            	    	        		"State", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStatemachine


    // $ANTLR start entryRuleEvent
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:183:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:184:2: (iv_ruleEvent= ruleEvent EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:185:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEventRule(), currentNode); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent252);
            iv_ruleEvent=ruleEvent();
            _fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent262); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEvent


    // $ANTLR start ruleEvent
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:192:1: ruleEvent returns [EObject current=null] : ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting_0_0=null;
        Token lv_name_1_0=null;
        Token lv_code_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:197:6: ( ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:198:1: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:198:1: ( ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:198:2: ( (lv_resetting_0_0= 'resetting' ) )? ( (lv_name_1_0= RULE_ID ) ) ( (lv_code_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:198:2: ( (lv_resetting_0_0= 'resetting' ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:199:1: (lv_resetting_0_0= 'resetting' )
                    {
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:199:1: (lv_resetting_0_0= 'resetting' )
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:200:3: lv_resetting_0_0= 'resetting'
                    {
                    lv_resetting_0_0=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleEvent305); 

                            createLeafNode(grammarAccess.getEventAccess().getResettingResettingKeyword_0_0(), "resetting"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getEventRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "resetting", true, "resetting", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:219:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:220:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:220:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:221:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent336); 

            			createLeafNode(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEventRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:243:2: ( (lv_code_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:244:1: (lv_code_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:244:1: (lv_code_2_0= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:245:3: lv_code_2_0= RULE_ID
            {
            lv_code_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent358); 

            			createLeafNode(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_2_0(), "code"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEventRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"code",
            	        		lv_code_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEvent


    // $ANTLR start entryRuleCommand
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:275:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:276:2: (iv_ruleCommand= ruleCommand EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:277:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommandRule(), currentNode); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand399);
            iv_ruleCommand=ruleCommand();
            _fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand409); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleCommand


    // $ANTLR start ruleCommand
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:284:1: ruleCommand returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_code_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:289:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:290:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:290:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:290:2: ( (lv_name_0_0= RULE_ID ) ) ( (lv_code_1_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:290:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:291:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:291:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:292:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand451); 

            			createLeafNode(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCommandRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:314:2: ( (lv_code_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:315:1: (lv_code_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:315:1: (lv_code_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:316:3: lv_code_1_0= RULE_ID
            {
            lv_code_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand473); 

            			createLeafNode(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0(), "code"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCommandRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"code",
            	        		lv_code_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleCommand


    // $ANTLR start entryRuleState
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:346:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:347:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:348:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStateRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState514);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState524); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleState


    // $ANTLR start ruleState
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:355:1: ruleState returns [EObject current=null] : ( 'state' ( (lv_name_1_0= RULE_ID ) ) ( 'actions' '{' ( ( RULE_ID ) )+ '}' )? ( (lv_transitions_6_0= ruleTransition ) )* 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_transitions_6_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:360:6: ( ( 'state' ( (lv_name_1_0= RULE_ID ) ) ( 'actions' '{' ( ( RULE_ID ) )+ '}' )? ( (lv_transitions_6_0= ruleTransition ) )* 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:361:1: ( 'state' ( (lv_name_1_0= RULE_ID ) ) ( 'actions' '{' ( ( RULE_ID ) )+ '}' )? ( (lv_transitions_6_0= ruleTransition ) )* 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:361:1: ( 'state' ( (lv_name_1_0= RULE_ID ) ) ( 'actions' '{' ( ( RULE_ID ) )+ '}' )? ( (lv_transitions_6_0= ruleTransition ) )* 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:361:3: 'state' ( (lv_name_1_0= RULE_ID ) ) ( 'actions' '{' ( ( RULE_ID ) )+ '}' )? ( (lv_transitions_6_0= ruleTransition ) )* 'end'
            {
            match(input,15,FOLLOW_15_in_ruleState559); 

                    createLeafNode(grammarAccess.getStateAccess().getStateKeyword_0(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:365:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:366:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:366:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:367:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState576); 

            			createLeafNode(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:389:2: ( 'actions' '{' ( ( RULE_ID ) )+ '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:389:4: 'actions' '{' ( ( RULE_ID ) )+ '}'
                    {
                    match(input,16,FOLLOW_16_in_ruleState592); 

                            createLeafNode(grammarAccess.getStateAccess().getActionsKeyword_2_0(), null); 
                        
                    match(input,17,FOLLOW_17_in_ruleState602); 

                            createLeafNode(grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2_1(), null); 
                        
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:397:1: ( ( RULE_ID ) )+
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
                    	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:398:1: ( RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:398:1: ( RULE_ID )
                    	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:399:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState620); 

                    	    		createLeafNode(grammarAccess.getStateAccess().getActionsCommandCrossReference_2_2_0(), "actions"); 
                    	    	

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

                    match(input,18,FOLLOW_18_in_ruleState631); 

                            createLeafNode(grammarAccess.getStateAccess().getRightCurlyBracketKeyword_2_3(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:415:3: ( (lv_transitions_6_0= ruleTransition ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:416:1: (lv_transitions_6_0= ruleTransition )
            	    {
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:416:1: (lv_transitions_6_0= ruleTransition )
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:417:3: lv_transitions_6_0= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleState654);
            	    lv_transitions_6_0=ruleTransition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getStateRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"transitions",
            	    	        		lv_transitions_6_0, 
            	    	        		"Transition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleState665); 

                    createLeafNode(grammarAccess.getStateAccess().getEndKeyword_4(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleState


    // $ANTLR start entryRuleTransition
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:451:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:452:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:453:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTransitionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition701);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition711); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTransition


    // $ANTLR start ruleTransition
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:460:1: ruleTransition returns [EObject current=null] : ( ( ( RULE_ID ) ) '=>' ( ( RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:465:6: ( ( ( ( RULE_ID ) ) '=>' ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:466:1: ( ( ( RULE_ID ) ) '=>' ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:466:1: ( ( ( RULE_ID ) ) '=>' ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:466:2: ( ( RULE_ID ) ) '=>' ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:466:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:467:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:467:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:468:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition754); 

            		createLeafNode(grammarAccess.getTransitionAccess().getEventEventCrossReference_0_0(), "event"); 
            	

            }


            }

            match(input,19,FOLLOW_19_in_ruleTransition764); 

                    createLeafNode(grammarAccess.getTransitionAccess().getEqualsSignGreaterThanSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:484:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:485:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:485:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:486:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getTransitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition782); 

            		createLeafNode(grammarAccess.getTransitionAccess().getStateStateCrossReference_2_0(), "state"); 
            	

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTransition


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStatemachine120 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleStatemachine141 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine152 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStatemachine162 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleStatemachine183 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine194 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine215 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEvent305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent336 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand399 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand451 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleState559 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState576 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_16_in_ruleState592 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState620 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleState631 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleState654 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleState665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition701 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition754 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransition764 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition782 = new BitSet(new long[]{0x0000000000000002L});

}
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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:69:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:69:54: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:70:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.prStatemachine().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine71);
            iv_ruleStatemachine=ruleStatemachine();
            _fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine81); 

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:1: ruleStatemachine returns [EObject current=null] : ( 'events' (lv_events_1= ruleEvent )* 'end' 'commands' (lv_commands_4= ruleCommand )* 'end' (lv_states_6= ruleState )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_events_1 = null;

        EObject lv_commands_4 = null;

        EObject lv_states_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:82:6: ( ( 'events' (lv_events_1= ruleEvent )* 'end' 'commands' (lv_commands_4= ruleCommand )* 'end' (lv_states_6= ruleState )* ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:83:1: ( 'events' (lv_events_1= ruleEvent )* 'end' 'commands' (lv_commands_4= ruleCommand )* 'end' (lv_states_6= ruleState )* )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:83:1: ( 'events' (lv_events_1= ruleEvent )* 'end' 'commands' (lv_commands_4= ruleCommand )* 'end' (lv_states_6= ruleState )* )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:83:2: 'events' (lv_events_1= ruleEvent )* 'end' 'commands' (lv_commands_4= ruleCommand )* 'end' (lv_states_6= ruleState )*
            {
            match(input,11,FOLLOW_11_in_ruleStatemachine115); 

                    createLeafNode(grammarAccess.prStatemachine().ele0KeywordEvents(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:87:1: (lv_events_1= ruleEvent )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:90:6: lv_events_1= ruleEvent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele10ParserRuleCallEvent(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleStatemachine149);
            	    lv_events_1=ruleEvent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prStatemachine().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "events", lv_events_1, "Event", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleStatemachine163); 

                    createLeafNode(grammarAccess.prStatemachine().ele2KeywordEnd(), null); 
                
            match(input,13,FOLLOW_13_in_ruleStatemachine172); 

                    createLeafNode(grammarAccess.prStatemachine().ele3KeywordCommands(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:116:1: (lv_commands_4= ruleCommand )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:119:6: lv_commands_4= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele40ParserRuleCallCommand(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleStatemachine206);
            	    lv_commands_4=ruleCommand();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prStatemachine().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "commands", lv_commands_4, "Command", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleStatemachine220); 

                    createLeafNode(grammarAccess.prStatemachine().ele5KeywordEnd(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:141:1: (lv_states_6= ruleState )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:144:6: lv_states_6= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele60ParserRuleCallState(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine254);
            	    lv_states_6=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prStatemachine().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "states", lv_states_6, "State", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:169:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:169:47: (iv_ruleEvent= ruleEvent EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:170:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEvent().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent292);
            iv_ruleEvent=ruleEvent();
            _fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent302); 

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:177:1: ruleEvent returns [EObject current=null] : ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) (lv_code_2= RULE_ID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting_0=null;
        Token lv_name_1=null;
        Token lv_code_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:182:6: ( ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) (lv_code_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:183:1: ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) (lv_code_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:183:1: ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) (lv_code_2= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:183:2: (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) (lv_code_2= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:183:2: (lv_resetting_0= 'resetting' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:185:6: lv_resetting_0= 'resetting'
                    {
                    lv_resetting_0=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleEvent348); 

                            createLeafNode(grammarAccess.prEvent().ele00KeywordResetting(), "resetting"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prEvent().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "resetting", true, "resetting", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:204:3: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:206:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent384); 

            		createLeafNode(grammarAccess.prEvent().ele10TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEvent().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:224:2: (lv_code_2= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:226:6: lv_code_2= RULE_ID
            {
            lv_code_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent414); 

            		createLeafNode(grammarAccess.prEvent().ele20TerminalRuleCallID(), "code"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prEvent().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "code", lv_code_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:251:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:251:49: (iv_ruleCommand= ruleCommand EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:252:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCommand().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand455);
            iv_ruleCommand=ruleCommand();
            _fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand465); 

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:259:1: ruleCommand returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_code_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:264:6: ( ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:265:1: ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:265:1: ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:265:2: (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:265:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:267:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand512); 

            		createLeafNode(grammarAccess.prCommand().ele00TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCommand().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:285:2: (lv_code_1= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:287:6: lv_code_1= RULE_ID
            {
            lv_code_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand542); 

            		createLeafNode(grammarAccess.prCommand().ele10TerminalRuleCallID(), "code"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCommand().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "code", lv_code_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:312:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:312:47: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:313:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.prState().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState583);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState593); 

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:320:1: ruleState returns [EObject current=null] : ( 'state' (lv_name_1= RULE_ID ) ( 'actions' '{' ( RULE_ID )+ '}' )? (lv_transitions_6= ruleTransition )* 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_transitions_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:325:6: ( ( 'state' (lv_name_1= RULE_ID ) ( 'actions' '{' ( RULE_ID )+ '}' )? (lv_transitions_6= ruleTransition )* 'end' ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:326:1: ( 'state' (lv_name_1= RULE_ID ) ( 'actions' '{' ( RULE_ID )+ '}' )? (lv_transitions_6= ruleTransition )* 'end' )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:326:1: ( 'state' (lv_name_1= RULE_ID ) ( 'actions' '{' ( RULE_ID )+ '}' )? (lv_transitions_6= ruleTransition )* 'end' )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:326:2: 'state' (lv_name_1= RULE_ID ) ( 'actions' '{' ( RULE_ID )+ '}' )? (lv_transitions_6= ruleTransition )* 'end'
            {
            match(input,15,FOLLOW_15_in_ruleState627); 

                    createLeafNode(grammarAccess.prState().ele0KeywordState(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:330:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:332:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState649); 

            		createLeafNode(grammarAccess.prState().ele10TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prState().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:350:2: ( 'actions' '{' ( RULE_ID )+ '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:350:3: 'actions' '{' ( RULE_ID )+ '}'
                    {
                    match(input,16,FOLLOW_16_in_ruleState667); 

                            createLeafNode(grammarAccess.prState().ele20KeywordActions(), null); 
                        
                    match(input,17,FOLLOW_17_in_ruleState676); 

                            createLeafNode(grammarAccess.prState().ele21KeywordLeftCurlyBracket(), null); 
                        
                    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:358:1: ( RULE_ID )+
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
                    	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:361:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create(grammarAccess.prState().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState698); 

                    	    		createLeafNode(grammarAccess.prState().ele220CrossReferenceEStringCommand(), "actions"); 
                    	    	

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

                    match(input,18,FOLLOW_18_in_ruleState711); 

                            createLeafNode(grammarAccess.prState().ele23KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:378:3: (lv_transitions_6= ruleTransition )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:381:6: lv_transitions_6= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prState().ele30ParserRuleCallTransition(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleState747);
            	    lv_transitions_6=ruleTransition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.prState().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "transitions", lv_transitions_6, "Transition", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleState761); 

                    createLeafNode(grammarAccess.prState().ele4KeywordEnd(), null); 
                

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:410:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:410:52: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:411:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTransition().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition794);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition804); 

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
    // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:418:1: ruleTransition returns [EObject current=null] : ( ( RULE_ID ) '=>' ( RULE_ID ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:423:6: ( ( ( RULE_ID ) '=>' ( RULE_ID ) ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:424:1: ( ( RULE_ID ) '=>' ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:424:1: ( ( RULE_ID ) '=>' ( RULE_ID ) )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:424:2: ( RULE_ID ) '=>' ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:424:2: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:427:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTransition().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition851); 

            		createLeafNode(grammarAccess.prTransition().ele00CrossReferenceEStringEvent(), "event"); 
            	

            }

            match(input,19,FOLLOW_19_in_ruleTransition863); 

                    createLeafNode(grammarAccess.prTransition().ele1KeywordEqualsSignGreaterThanSign(), null); 
                
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:444:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.fowlerdsl/src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:447:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prTransition().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition885); 

            		createLeafNode(grammarAccess.prTransition().ele20CrossReferenceEStringState(), "state"); 
            	

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


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStatemachine115 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleStatemachine149 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine163 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStatemachine172 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleStatemachine206 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine220 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine254 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEvent348 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand512 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState583 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleState627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState649 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_16_in_ruleState667 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState676 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState698 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleState711 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleState747 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleState761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition851 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransition863 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition885 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalFowlerDslTestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalFowlerDslTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g"; }


     
     	private FowlerDslTestLanguageGrammarAccess grammarAccess;
     	
        public InternalFowlerDslTestLanguageParser(TokenStream input, IAstFactory factory, FowlerDslTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalFowlerDslTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";	
       	} 



    // $ANTLR start entryRuleStatemachine
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:70:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:70:54: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:71:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             currentNode = createCompositeNode(grammarAccess.prStatemachine().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine72);
            iv_ruleStatemachine=ruleStatemachine();
            _fsp--;

             current =iv_ruleStatemachine; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatemachine82); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:1: ruleStatemachine returns [EObject current=null] : ( ( ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end' ) (lv_states_6= ruleState )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_events_1 = null;

        EObject lv_commands_4 = null;

        EObject lv_states_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:6: ( ( ( ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end' ) (lv_states_6= ruleState )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:1: ( ( ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end' ) (lv_states_6= ruleState )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:1: ( ( ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end' ) (lv_states_6= ruleState )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:2: ( ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end' ) (lv_states_6= ruleState )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:2: ( ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:3: ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:3: ( ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:4: ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands_4= ruleCommand )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:4: ( ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:5: ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' ) 'commands'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:5: ( ( 'events' (lv_events_1= ruleEvent )* ) 'end' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:6: ( 'events' (lv_events_1= ruleEvent )* ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:6: ( 'events' (lv_events_1= ruleEvent )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:84:7: 'events' (lv_events_1= ruleEvent )*
            {
            match(input,11,FOLLOW_11_in_ruleStatemachine121); 

                    createLeafNode(grammarAccess.prStatemachine().ele000000KeywordEvents(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:88:1: (lv_events_1= ruleEvent )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:91:6: lv_events_1= ruleEvent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele0000010ParserRuleCallEvent(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleStatemachine155);
            	    lv_events_1=ruleEvent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Statemachine");
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


            }

            match(input,12,FOLLOW_12_in_ruleStatemachine170); 

                    createLeafNode(grammarAccess.prStatemachine().ele00001KeywordEnd(), null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleStatemachine180); 

                    createLeafNode(grammarAccess.prStatemachine().ele0001KeywordCommands(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:117:2: (lv_commands_4= ruleCommand )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:120:6: lv_commands_4= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele0010ParserRuleCallCommand(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleStatemachine215);
            	    lv_commands_4=ruleCommand();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Statemachine");
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


            }

            match(input,12,FOLLOW_12_in_ruleStatemachine230); 

                    createLeafNode(grammarAccess.prStatemachine().ele01KeywordEnd(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:142:2: (lv_states_6= ruleState )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:145:6: lv_states_6= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele10ParserRuleCallState(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine265);
            	    lv_states_6=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Statemachine");
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:172:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:172:47: (iv_ruleEvent= ruleEvent EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:173:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode(grammarAccess.prEvent().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent305);
            iv_ruleEvent=ruleEvent();
            _fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent315); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:180:1: ruleEvent returns [EObject current=null] : ( ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) ) (lv_code_2= RULE_ID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting_0=null;
        Token lv_name_1=null;
        Token lv_code_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:185:6: ( ( ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) ) (lv_code_2= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:1: ( ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) ) (lv_code_2= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:1: ( ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) ) (lv_code_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:2: ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) ) (lv_code_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:2: ( (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:3: (lv_resetting_0= 'resetting' )? (lv_name_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:3: (lv_resetting_0= 'resetting' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:188:6: lv_resetting_0= 'resetting'
                    {
                    lv_resetting_0=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleEvent362); 

                            createLeafNode(grammarAccess.prEvent().ele000KeywordResetting(), "resetting"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Event");
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:207:3: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:209:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent398); 

            		createLeafNode(grammarAccess.prEvent().ele010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Event");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:227:3: (lv_code_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:229:6: lv_code_2= RULE_ID
            {
            lv_code_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent429); 

            		createLeafNode(grammarAccess.prEvent().ele10LexerRuleCallID(), "code"); 
            	

            	        if (current==null) {
            	            current = factory.create("Event");
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:256:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:256:49: (iv_ruleCommand= ruleCommand EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:257:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCommand().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand472);
            iv_ruleCommand=ruleCommand();
            _fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand482); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:264:1: ruleCommand returns [EObject current=null] : ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_code_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:269:6: ( ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:270:1: ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:270:1: ( (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:270:2: (lv_name_0= RULE_ID ) (lv_code_1= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:270:2: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:272:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand529); 

            		createLeafNode(grammarAccess.prCommand().ele00LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("Command");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:290:2: (lv_code_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:292:6: lv_code_1= RULE_ID
            {
            lv_code_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand559); 

            		createLeafNode(grammarAccess.prCommand().ele10LexerRuleCallID(), "code"); 
            	

            	        if (current==null) {
            	            current = factory.create("Command");
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:319:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:319:47: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:320:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.prState().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState602);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState612); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:327:1: ruleState returns [EObject current=null] : ( ( ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )* ) 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_transitions_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:332:6: ( ( ( ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )* ) 'end' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:1: ( ( ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )* ) 'end' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:1: ( ( ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )* ) 'end' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:2: ( ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )* ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:2: ( ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:3: ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? ) (lv_transitions_6= ruleTransition )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:3: ( ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:4: ( 'state' (lv_name_1= RULE_ID ) ) ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:4: ( 'state' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:333:5: 'state' (lv_name_1= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleState649); 

                    createLeafNode(grammarAccess.prState().ele0000KeywordState(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:337:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:339:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState671); 

            		createLeafNode(grammarAccess.prState().ele00010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create("State");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:357:3: ( ( ( 'actions' '{' ) ( RULE_ID )+ ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:357:4: ( ( 'actions' '{' ) ( RULE_ID )+ ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:357:4: ( ( 'actions' '{' ) ( RULE_ID )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:357:5: ( 'actions' '{' ) ( RULE_ID )+
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:357:5: ( 'actions' '{' )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:357:6: 'actions' '{'
                    {
                    match(input,16,FOLLOW_16_in_ruleState692); 

                            createLeafNode(grammarAccess.prState().ele001000KeywordActions(), null); 
                        
                    match(input,17,FOLLOW_17_in_ruleState701); 

                            createLeafNode(grammarAccess.prState().ele001001KeywordLeftCurlyBracket(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:365:2: ( RULE_ID )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:368:3: RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create("State");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState724); 

                    	    		createLeafNode(grammarAccess.prState().ele001010CrossReferenceEStringCommand(), "actions"); 
                    	    	

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


                    }

                    match(input,18,FOLLOW_18_in_ruleState738); 

                            createLeafNode(grammarAccess.prState().ele0011KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:385:4: (lv_transitions_6= ruleTransition )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:388:6: lv_transitions_6= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prState().ele010ParserRuleCallTransition(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleState775);
            	    lv_transitions_6=ruleTransition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("State");
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


            }

            match(input,12,FOLLOW_12_in_ruleState790); 

                    createLeafNode(grammarAccess.prState().ele1KeywordEnd(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:419:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:419:52: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:420:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTransition().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition825);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition835); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:427:1: ruleTransition returns [EObject current=null] : ( ( ( RULE_ID ) '=>' ) ( RULE_ID ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:432:6: ( ( ( ( RULE_ID ) '=>' ) ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:433:1: ( ( ( RULE_ID ) '=>' ) ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:433:1: ( ( ( RULE_ID ) '=>' ) ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:433:2: ( ( RULE_ID ) '=>' ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:433:2: ( ( RULE_ID ) '=>' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:433:3: ( RULE_ID ) '=>'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:433:3: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:436:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition883); 

            		createLeafNode(grammarAccess.prTransition().ele000CrossReferenceEStringEvent(), "event"); 
            	

            }

            match(input,19,FOLLOW_19_in_ruleTransition895); 

                    createLeafNode(grammarAccess.prTransition().ele01KeywordEqualsSignGreaterThanSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:453:2: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:456:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition918); 

            		createLeafNode(grammarAccess.prTransition().ele10CrossReferenceEStringState(), "state"); 
            	

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


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStatemachine121 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleStatemachine155 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine170 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStatemachine180 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleStatemachine215 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine230 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine265 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEvent362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent398 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand472 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand529 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleState649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState671 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_16_in_ruleState692 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState701 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState724 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleState738 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleState775 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleState790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition883 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransition895 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition918 = new BitSet(new long[]{0x0000000000000002L});

}
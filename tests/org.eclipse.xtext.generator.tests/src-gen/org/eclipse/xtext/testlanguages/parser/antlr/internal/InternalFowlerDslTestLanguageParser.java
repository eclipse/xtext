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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:1: ruleStatemachine returns [EObject current=null] : ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_events = null;

        EObject lv_commands = null;

        EObject lv_states = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:82:6: ( ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:1: ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:1: ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:2: ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:2: ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:3: ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:3: ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:4: ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:4: ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:5: ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:5: ( ( 'events' (lv_events= ruleEvent )* ) 'end' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:6: ( 'events' (lv_events= ruleEvent )* ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:6: ( 'events' (lv_events= ruleEvent )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:83:7: 'events' (lv_events= ruleEvent )*
            {
            match(input,11,FOLLOW_11_in_ruleStatemachine121); 

                    createLeafNode(grammarAccess.prStatemachine().ele000000KeywordEvents(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:87:1: (lv_events= ruleEvent )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:90:6: lv_events= ruleEvent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele0000010ParserRuleCallEvent(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleStatemachine155);
            	    lv_events=ruleEvent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Statemachine");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "events", lv_events, "Event", currentNode);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:116:2: (lv_commands= ruleCommand )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:119:6: lv_commands= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele0010ParserRuleCallCommand(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleStatemachine215);
            	    lv_commands=ruleCommand();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Statemachine");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "commands", lv_commands, "Command", currentNode);
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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:141:2: (lv_states= ruleState )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:144:6: lv_states= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prStatemachine().ele10ParserRuleCallState(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine265);
            	    lv_states=ruleState();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Statemachine");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "states", lv_states, "State", currentNode);
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:171:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:171:47: (iv_ruleEvent= ruleEvent EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:172:2: iv_ruleEvent= ruleEvent EOF
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:179:1: ruleEvent returns [EObject current=null] : ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting=null;
        Token lv_name=null;
        Token lv_code=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:183:6: ( ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:184:1: ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:184:1: ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:184:2: ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:184:2: ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:184:3: (lv_resetting= 'resetting' )? (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:184:3: (lv_resetting= 'resetting' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:186:6: lv_resetting= 'resetting'
                    {
                    lv_resetting=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleEvent362); 

                            createLeafNode(grammarAccess.prEvent().ele000KeywordResetting(), "resetting"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Event");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "resetting", true, "resetting", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:204:3: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:206:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent396); 
             
                createLeafNode(grammarAccess.prEvent().ele010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Event");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:224:3: (lv_code= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:226:6: lv_code= RULE_ID
            {
            lv_code=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent429); 
             
                createLeafNode(grammarAccess.prEvent().ele10LexerRuleCallID(), "code"); 
                

            	        if (current==null) {
            	            current = factory.create("Event");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "code", lv_code, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:253:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:253:49: (iv_ruleCommand= ruleCommand EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:254:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCommand().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand475);
            iv_ruleCommand=ruleCommand();
            _fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand485); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:261:1: ruleCommand returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_code=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:265:6: ( ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:266:1: ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:266:1: ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:266:2: (lv_name= RULE_ID ) (lv_code= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:266:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:268:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand531); 
             
                createLeafNode(grammarAccess.prCommand().ele00LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Command");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:286:2: (lv_code= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:288:6: lv_code= RULE_ID
            {
            lv_code=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand563); 
             
                createLeafNode(grammarAccess.prCommand().ele10LexerRuleCallID(), "code"); 
                

            	        if (current==null) {
            	            current = factory.create("Command");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "code", lv_code, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:315:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:315:47: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:316:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode(grammarAccess.prState().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState609);
            iv_ruleState=ruleState();
            _fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState619); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:323:1: ruleState returns [EObject current=null] : ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_transitions = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:327:6: ( ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:1: ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:1: ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:2: ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:2: ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:3: ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:3: ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:4: ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:4: ( 'state' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:328:5: 'state' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleState656); 

                    createLeafNode(grammarAccess.prState().ele0000KeywordState(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:332:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:334:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState677); 
             
                createLeafNode(grammarAccess.prState().ele00010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("State");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:3: ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:4: ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}'
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:4: ( ( 'actions' '{' ) ( ( RULE_ID ) )+ )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:5: ( 'actions' '{' ) ( ( RULE_ID ) )+
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:5: ( 'actions' '{' )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:6: 'actions' '{'
                    {
                    match(input,16,FOLLOW_16_in_ruleState701); 

                            createLeafNode(grammarAccess.prState().ele001000KeywordActions(), null); 
                        
                    match(input,17,FOLLOW_17_in_ruleState710); 

                            createLeafNode(grammarAccess.prState().ele001001KeywordLeftCurlyBracket(), null); 
                        

                    }

                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:360:2: ( ( RULE_ID ) )+
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
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:363:3: ( RULE_ID )
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create("State");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:369:1: ( RULE_ID )
                    	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:370:2: RULE_ID
                    	    {
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState735); 
                    	     
                    	        createLeafNode(grammarAccess.prState().ele001010CrossReferenceEStringCommand(), "actions"); 
                    	        

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


                    }

                    match(input,18,FOLLOW_18_in_ruleState750); 

                            createLeafNode(grammarAccess.prState().ele0011KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:379:4: (lv_transitions= ruleTransition )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:382:6: lv_transitions= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prState().ele010ParserRuleCallTransition(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleState787);
            	    lv_transitions=ruleTransition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("State");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "transitions", lv_transitions, "Transition", currentNode);
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

            match(input,12,FOLLOW_12_in_ruleState802); 

                    createLeafNode(grammarAccess.prState().ele1KeywordEnd(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:52: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:414:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTransition().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition837);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition847); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:421:1: ruleTransition returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:425:6: ( ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:426:1: ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:426:1: ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:426:2: ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:426:2: ( ( ( RULE_ID ) ) '=>' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:426:3: ( ( RULE_ID ) ) '=>'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:426:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:429:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:435:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:436:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition897); 
             
                createLeafNode(grammarAccess.prTransition().ele000CrossReferenceEStringEvent(), "event"); 
                

            }


            }

            match(input,19,FOLLOW_19_in_ruleTransition910); 

                    createLeafNode(grammarAccess.prTransition().ele01KeywordEqualsSignGreaterThanSign(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:445:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:448:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:454:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:455:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition935); 
             
                createLeafNode(grammarAccess.prTransition().ele10CrossReferenceEStringState(), "state"); 
                

            }


            }


            }


            }

             resetLookahead(); 
                
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
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent396 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand531 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleState656 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState677 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_16_in_ruleState701 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState710 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState735 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleState750 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleState787 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleState802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition897 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransition910 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition935 = new BitSet(new long[]{0x0000000000000002L});

}
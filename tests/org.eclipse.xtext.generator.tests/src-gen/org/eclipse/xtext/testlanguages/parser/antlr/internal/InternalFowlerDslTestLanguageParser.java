// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g 2009-01-19 15:14:02

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g"; }


     
        public InternalFowlerDslTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:67:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:67:54: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:68:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:75:1: ruleStatemachine returns [EObject current=null] : ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_events = null;

        EObject lv_commands = null;

        EObject lv_states = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:77:33: ( ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:1: ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:1: ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:2: ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:2: ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:3: ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:3: ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:4: ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:4: ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:5: ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:5: ( ( 'events' (lv_events= ruleEvent )* ) 'end' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:6: ( 'events' (lv_events= ruleEvent )* ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:6: ( 'events' (lv_events= ruleEvent )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:78:7: 'events' (lv_events= ruleEvent )*
            {
            match(input,11,FOLLOW_11_in_ruleStatemachine121); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:82:1: (lv_events= ruleEvent )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:85:6: lv_events= ruleEvent
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleStatemachine180); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:111:2: (lv_commands= ruleCommand )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:114:6: lv_commands= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:136:2: (lv_states= ruleState )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:139:6: lv_states= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:166:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:166:47: (iv_ruleEvent= ruleEvent EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:167:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:174:1: ruleEvent returns [EObject current=null] : ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting=null;
        Token lv_name=null;
        Token lv_code=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:176:33: ( ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:177:1: ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:177:1: ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:177:2: ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:177:2: ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:177:3: (lv_resetting= 'resetting' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:177:3: (lv_resetting= 'resetting' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:179:6: lv_resetting= 'resetting'
                    {
                    lv_resetting=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleEvent362); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "resetting"); 
                        

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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:197:3: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:199:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent396); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:217:3: (lv_code= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:219:6: lv_code= RULE_ID
            {
            lv_code=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent429); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "code"); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:246:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:246:49: (iv_ruleCommand= ruleCommand EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:247:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:254:1: ruleCommand returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_code=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:256:33: ( ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:257:1: ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:257:1: ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:257:2: (lv_name= RULE_ID ) (lv_code= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:257:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:259:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand531); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:277:2: (lv_code= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:279:6: lv_code= RULE_ID
            {
            lv_code=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand563); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "code"); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:306:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:306:47: (iv_ruleState= ruleState EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:307:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:314:1: ruleState returns [EObject current=null] : ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_transitions = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:316:33: ( ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:1: ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:1: ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:2: ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:2: ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:3: ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:3: ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:4: ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:4: ( 'state' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:317:5: 'state' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleState656); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:321:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:323:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState677); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:341:3: ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:341:4: ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:341:4: ( ( 'actions' '{' ) ( ( RULE_ID ) )+ )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:341:5: ( 'actions' '{' ) ( ( RULE_ID ) )+
                    {
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:341:5: ( 'actions' '{' )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:341:6: 'actions' '{'
                    {
                    match(input,16,FOLLOW_16_in_ruleState701); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,17,FOLLOW_17_in_ruleState710); 

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:349:2: ( ( RULE_ID ) )+
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
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:352:3: ( RULE_ID )
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create("State");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:358:1: ( RULE_ID )
                    	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:359:2: RULE_ID
                    	    {
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState735); 
                    	     
                    	        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "actions"); 
                    	        

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

                            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:368:4: (lv_transitions= ruleTransition )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:371:6: lv_transitions= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
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

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:402:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:402:52: (iv_ruleTransition= ruleTransition EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:403:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:410:1: ruleTransition returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:412:33: ( ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:1: ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:1: ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:2: ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:2: ( ( ( RULE_ID ) ) '=>' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:3: ( ( RULE_ID ) ) '=>'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:413:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:416:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:422:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:423:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition897); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "event"); 
                

            }


            }

            match(input,19,FOLLOW_19_in_ruleTransition910); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:432:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:435:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:441:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalFowlerDslTestLanguage.g:442:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition935); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/FowlerDslTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "state"); 
                

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
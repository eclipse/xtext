// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g 2009-01-13 18:45:31

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
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g"; }


     
        public InternalFowlerDslParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalFowlerDslParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";	
       	} 



    // $ANTLR start entryRuleStatemachine
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:66:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:66:54: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:67:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:74:1: ruleStatemachine returns [EObject current=null] : ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_events = null;

        EObject lv_commands = null;

        EObject lv_states = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:76:33: ( ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:1: ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:1: ( ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:2: ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' ) (lv_states= ruleState )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:2: ( ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:3: ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:3: ( ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:4: ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' ) (lv_commands= ruleCommand )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:4: ( ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:5: ( ( 'events' (lv_events= ruleEvent )* ) 'end' ) 'commands'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:5: ( ( 'events' (lv_events= ruleEvent )* ) 'end' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:6: ( 'events' (lv_events= ruleEvent )* ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:6: ( 'events' (lv_events= ruleEvent )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:77:7: 'events' (lv_events= ruleEvent )*
            {
            match(input,11,FOLLOW_11_in_ruleStatemachine120); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:81:1: (lv_events= ruleEvent )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:84:6: lv_events= ruleEvent
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleStatemachine154);
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

            match(input,12,FOLLOW_12_in_ruleStatemachine169); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,13,FOLLOW_13_in_ruleStatemachine179); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:110:2: (lv_commands= ruleCommand )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:113:6: lv_commands= ruleCommand
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleStatemachine214);
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

            match(input,12,FOLLOW_12_in_ruleStatemachine229); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:135:2: (lv_states= ruleState )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:138:6: lv_states= ruleState
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine264);
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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:163:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:163:47: (iv_ruleEvent= ruleEvent EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:164:2: iv_ruleEvent= ruleEvent EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent302);
            iv_ruleEvent=ruleEvent();
            _fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent312); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:171:1: ruleEvent returns [EObject current=null] : ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token lv_resetting=null;
        Token lv_name=null;
        Token lv_code=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:173:33: ( ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:174:1: ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:174:1: ( ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:174:2: ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) ) (lv_code= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:174:2: ( (lv_resetting= 'resetting' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:174:3: (lv_resetting= 'resetting' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:174:3: (lv_resetting= 'resetting' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:176:6: lv_resetting= 'resetting'
                    {
                    lv_resetting=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_ruleEvent359); 

                            createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "resetting"); 
                        

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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:194:3: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:196:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent393); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:214:3: (lv_code= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:216:6: lv_code= RULE_ID
            {
            lv_code=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent426); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "code"); 
                

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:241:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:241:49: (iv_ruleCommand= ruleCommand EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:242:2: iv_ruleCommand= ruleCommand EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand470);
            iv_ruleCommand=ruleCommand();
            _fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand480); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:249:1: ruleCommand returns [EObject current=null] : ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_code=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:251:33: ( ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:252:1: ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:252:1: ( (lv_name= RULE_ID ) (lv_code= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:252:2: (lv_name= RULE_ID ) (lv_code= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:252:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:254:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand526); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:272:2: (lv_code= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:274:6: lv_code= RULE_ID
            {
            lv_code=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand558); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.2/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "code"); 
                

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:299:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:299:47: (iv_ruleState= ruleState EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:300:2: iv_ruleState= ruleState EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:307:1: ruleState returns [EObject current=null] : ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_transitions = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:309:33: ( ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:1: ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:1: ( ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:2: ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* ) 'end'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:2: ( ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )* )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:3: ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? ) (lv_transitions= ruleTransition )*
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:3: ( ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )? )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:4: ( 'state' (lv_name= RULE_ID ) ) ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:4: ( 'state' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:310:5: 'state' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleState649); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:314:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:316:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState670); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:334:3: ( ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:334:4: ( ( 'actions' '{' ) ( ( RULE_ID ) )+ ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:334:4: ( ( 'actions' '{' ) ( ( RULE_ID ) )+ )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:334:5: ( 'actions' '{' ) ( ( RULE_ID ) )+
                    {
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:334:5: ( 'actions' '{' )
                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:334:6: 'actions' '{'
                    {
                    match(input,16,FOLLOW_16_in_ruleState694); 

                            createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,17,FOLLOW_17_in_ruleState703); 

                            createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:342:2: ( ( RULE_ID ) )+
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
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:345:3: ( RULE_ID )
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create("State");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:351:1: ( RULE_ID )
                    	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:352:2: RULE_ID
                    	    {
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState728); 
                    	     
                    	        createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "actions"); 
                    	        

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

                    match(input,18,FOLLOW_18_in_ruleState743); 

                            createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:361:4: (lv_transitions= ruleTransition )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:364:6: lv_transitions= ruleTransition
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleState780);
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

            match(input,12,FOLLOW_12_in_ruleState795); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:393:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:393:52: (iv_ruleTransition= ruleTransition EOF )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:394:2: iv_ruleTransition= ruleTransition EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition828);
            iv_ruleTransition=ruleTransition();
            _fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition838); 

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
    // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:401:1: ruleTransition returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:403:33: ( ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:404:1: ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:404:1: ( ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:404:2: ( ( ( RULE_ID ) ) '=>' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:404:2: ( ( ( RULE_ID ) ) '=>' )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:404:3: ( ( RULE_ID ) ) '=>'
            {
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:404:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:407:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:413:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:414:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition888); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "event"); 
                

            }


            }

            match(input,19,FOLLOW_19_in_ruleTransition901); 

                    createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:423:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:426:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Transition");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:432:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/example/parser/antlr/internal/InternalFowlerDsl.g:433:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition926); 
             
                createLeafNode("classpath:/org/eclipse/xtext/example/FowlerDsl.xmi#//@rules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "state"); 
                

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


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleStatemachine120 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleStatemachine154 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine169 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleStatemachine179 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleStatemachine214 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStatemachine229 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine264 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleEvent359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent393 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleState649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState670 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_16_in_ruleState694 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleState703 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState728 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleState743 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleState780 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleState795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition888 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransition901 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition926 = new BitSet(new long[]{0x0000000000000002L});

}
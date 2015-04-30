package org.eclipse.xtext.web.example.statemachine.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
@SuppressWarnings("all")
public class InternalStatemachineParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOLEAN", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'signal'", "'input'", "'output'", "'state'", "'end'", "'if'", "'goto'", "'and'", "'=='", "'set'", "'='"
    };
    public static final int RULE_BOOLEAN=5;
    public static final int RULE_ID=4;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__19=19;
    public static final int RULE_STRING=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalStatemachineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalStatemachineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalStatemachineParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g"; }



     	private StatemachineGrammarAccess grammarAccess;
     	
        public InternalStatemachineParser(TokenStream input, StatemachineGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statemachine";	
       	}
       	
       	@Override
       	protected StatemachineGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStatemachine"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:71:1: entryRuleStatemachine returns [EObject current=null] : iv_ruleStatemachine= ruleStatemachine EOF ;
    public final EObject entryRuleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatemachine = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:72:2: (iv_ruleStatemachine= ruleStatemachine EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:73:2: iv_ruleStatemachine= ruleStatemachine EOF
            {
             newCompositeNode(grammarAccess.getStatemachineRule()); 
            pushFollow(FOLLOW_ruleStatemachine_in_entryRuleStatemachine75);
            iv_ruleStatemachine=ruleStatemachine();

            state._fsp--;

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
    // $ANTLR end "entryRuleStatemachine"


    // $ANTLR start "ruleStatemachine"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:80:1: ruleStatemachine returns [EObject current=null] : ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* ) ;
    public final EObject ruleStatemachine() throws RecognitionException {
        EObject current = null;

        EObject lv_signals_1_0 = null;

        EObject lv_states_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:83:28: ( ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:1: ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:1: ( () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )* )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:2: () ( (lv_signals_1_0= ruleSignal ) )* ( (lv_states_2_0= ruleState ) )*
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:84:2: ()
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:85:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getStatemachineAccess().getStatemachineAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:90:2: ( (lv_signals_1_0= ruleSignal ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=14)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:91:1: (lv_signals_1_0= ruleSignal )
            	    {
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:91:1: (lv_signals_1_0= ruleSignal )
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:92:3: lv_signals_1_0= ruleSignal
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getSignalsSignalParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSignal_in_ruleStatemachine140);
            	    lv_signals_1_0=ruleSignal();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"signals",
            	            		lv_signals_1_0, 
            	            		"Signal");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:108:3: ( (lv_states_2_0= ruleState ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:109:1: (lv_states_2_0= ruleState )
            	    {
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:109:1: (lv_states_2_0= ruleState )
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:110:3: lv_states_2_0= ruleState
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatemachineAccess().getStatesStateParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleState_in_ruleStatemachine162);
            	    lv_states_2_0=ruleState();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatemachineRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"states",
            	            		lv_states_2_0, 
            	            		"State");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatemachine"


    // $ANTLR start "entryRuleSignal"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:134:1: entryRuleSignal returns [EObject current=null] : iv_ruleSignal= ruleSignal EOF ;
    public final EObject entryRuleSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignal = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:135:2: (iv_ruleSignal= ruleSignal EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:136:2: iv_ruleSignal= ruleSignal EOF
            {
             newCompositeNode(grammarAccess.getSignalRule()); 
            pushFollow(FOLLOW_ruleSignal_in_entryRuleSignal199);
            iv_ruleSignal=ruleSignal();

            state._fsp--;

             current =iv_ruleSignal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignal209); 

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
    // $ANTLR end "entryRuleSignal"


    // $ANTLR start "ruleSignal"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:143:1: ruleSignal returns [EObject current=null] : ( ( ruleInputSignal | ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_name_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:146:28: ( ( ( ruleInputSignal | ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:147:1: ( ( ruleInputSignal | ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:147:1: ( ( ruleInputSignal | ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:147:2: ( ruleInputSignal | ruleOutputSignal ) otherlv_2= 'signal' ( (lv_name_3_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:147:2: ( ruleInputSignal | ruleOutputSignal )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:148:5: ruleInputSignal
                    {
                     
                            newCompositeNode(grammarAccess.getSignalAccess().getInputSignalParserRuleCall_0_0()); 
                        
                    pushFollow(FOLLOW_ruleInputSignal_in_ruleSignal251);
                    ruleInputSignal();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:157:5: ruleOutputSignal
                    {
                     
                            newCompositeNode(grammarAccess.getSignalAccess().getOutputSignalParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleOutputSignal_in_ruleSignal272);
                    ruleOutputSignal();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleSignal284); 

                	newLeafNode(otherlv_2, grammarAccess.getSignalAccess().getSignalKeyword_1());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:168:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:169:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:169:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:170:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSignal301); 

            			newLeafNode(lv_name_3_0, grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSignalRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignal"


    // $ANTLR start "entryRuleInputSignal"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:194:1: entryRuleInputSignal returns [String current=null] : iv_ruleInputSignal= ruleInputSignal EOF ;
    public final String entryRuleInputSignal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInputSignal = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:195:2: (iv_ruleInputSignal= ruleInputSignal EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:196:2: iv_ruleInputSignal= ruleInputSignal EOF
            {
             newCompositeNode(grammarAccess.getInputSignalRule()); 
            pushFollow(FOLLOW_ruleInputSignal_in_entryRuleInputSignal343);
            iv_ruleInputSignal=ruleInputSignal();

            state._fsp--;

             current =iv_ruleInputSignal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInputSignal354); 

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
    // $ANTLR end "entryRuleInputSignal"


    // $ANTLR start "ruleInputSignal"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:203:1: ruleInputSignal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'input' ;
    public final AntlrDatatypeRuleToken ruleInputSignal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:206:28: (kw= 'input' )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:208:2: kw= 'input'
            {
            kw=(Token)match(input,13,FOLLOW_13_in_ruleInputSignal391); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getInputSignalAccess().getInputKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInputSignal"


    // $ANTLR start "entryRuleOutputSignal"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:221:1: entryRuleOutputSignal returns [String current=null] : iv_ruleOutputSignal= ruleOutputSignal EOF ;
    public final String entryRuleOutputSignal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOutputSignal = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:222:2: (iv_ruleOutputSignal= ruleOutputSignal EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:223:2: iv_ruleOutputSignal= ruleOutputSignal EOF
            {
             newCompositeNode(grammarAccess.getOutputSignalRule()); 
            pushFollow(FOLLOW_ruleOutputSignal_in_entryRuleOutputSignal431);
            iv_ruleOutputSignal=ruleOutputSignal();

            state._fsp--;

             current =iv_ruleOutputSignal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOutputSignal442); 

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
    // $ANTLR end "entryRuleOutputSignal"


    // $ANTLR start "ruleOutputSignal"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:230:1: ruleOutputSignal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'output' ;
    public final AntlrDatatypeRuleToken ruleOutputSignal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:233:28: (kw= 'output' )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:235:2: kw= 'output'
            {
            kw=(Token)match(input,14,FOLLOW_14_in_ruleOutputSignal479); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getOutputSignalAccess().getOutputKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutputSignal"


    // $ANTLR start "entryRuleState"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:248:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:249:2: (iv_ruleState= ruleState EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:250:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_ruleState_in_entryRuleState518);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleState528); 

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
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:257:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= 'end' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_4=null;
        EObject lv_commands_2_0 = null;

        EObject lv_transitions_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:260:28: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= 'end' ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:261:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= 'end' )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:261:1: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= 'end' )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:261:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) ( (lv_commands_2_0= ruleCommand ) )* ( (lv_transitions_3_0= ruleTransition ) )* otherlv_4= 'end'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleState565); 

                	newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:265:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:266:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:266:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:267:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleState582); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:283:2: ( (lv_commands_2_0= ruleCommand ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:284:1: (lv_commands_2_0= ruleCommand )
            	    {
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:284:1: (lv_commands_2_0= ruleCommand )
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:285:3: lv_commands_2_0= ruleCommand
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateAccess().getCommandsCommandParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCommand_in_ruleState608);
            	    lv_commands_2_0=ruleCommand();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_2_0, 
            	            		"Command");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:301:3: ( (lv_transitions_3_0= ruleTransition ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:302:1: (lv_transitions_3_0= ruleTransition )
            	    {
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:302:1: (lv_transitions_3_0= ruleTransition )
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:303:3: lv_transitions_3_0= ruleTransition
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStateAccess().getTransitionsTransitionParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransition_in_ruleState630);
            	    lv_transitions_3_0=ruleTransition();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStateRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transitions",
            	            		lv_transitions_3_0, 
            	            		"Transition");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleState643); 

                	newLeafNode(otherlv_4, grammarAccess.getStateAccess().getEndKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTransition"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:331:1: entryRuleTransition returns [EObject current=null] : iv_ruleTransition= ruleTransition EOF ;
    public final EObject entryRuleTransition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransition = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:332:2: (iv_ruleTransition= ruleTransition EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:333:2: iv_ruleTransition= ruleTransition EOF
            {
             newCompositeNode(grammarAccess.getTransitionRule()); 
            pushFollow(FOLLOW_ruleTransition_in_entryRuleTransition679);
            iv_ruleTransition=ruleTransition();

            state._fsp--;

             current =iv_ruleTransition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransition689); 

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
    // $ANTLR end "entryRuleTransition"


    // $ANTLR start "ruleTransition"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:340:1: ruleTransition returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleTransition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_condition_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:343:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( (otherlv_3= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:344:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:344:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( (otherlv_3= RULE_ID ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:344:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= 'goto' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleTransition726); 

                	newLeafNode(otherlv_0, grammarAccess.getTransitionAccess().getIfKeyword_0());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:348:1: ( (lv_condition_1_0= ruleCondition ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:349:1: (lv_condition_1_0= ruleCondition )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:349:1: (lv_condition_1_0= ruleCondition )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:350:3: lv_condition_1_0= ruleCondition
            {
             
            	        newCompositeNode(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleCondition_in_ruleTransition747);
            lv_condition_1_0=ruleCondition();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransitionRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"Condition");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleTransition759); 

                	newLeafNode(otherlv_2, grammarAccess.getTransitionAccess().getGotoKeyword_2());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:370:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:371:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:371:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:372:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransitionRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransition779); 

            		newLeafNode(otherlv_3, grammarAccess.getTransitionAccess().getStateStateCrossReference_3_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransition"


    // $ANTLR start "entryRuleCondition"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:391:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:392:2: (iv_ruleCondition= ruleCondition EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:393:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_ruleCondition_in_entryRuleCondition815);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondition825); 

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
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:400:1: ruleCondition returns [EObject current=null] : ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_events_0_0 = null;

        EObject lv_events_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:403:28: ( ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:404:1: ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:404:1: ( ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )* )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:404:2: ( (lv_events_0_0= ruleEvent ) ) (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )*
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:404:2: ( (lv_events_0_0= ruleEvent ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:405:1: (lv_events_0_0= ruleEvent )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:405:1: (lv_events_0_0= ruleEvent )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:406:3: lv_events_0_0= ruleEvent
            {
             
            	        newCompositeNode(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEvent_in_ruleCondition871);
            lv_events_0_0=ruleEvent();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConditionRule());
            	        }
                   		add(
                   			current, 
                   			"events",
                    		lv_events_0_0, 
                    		"Event");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:422:2: (otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:422:4: otherlv_1= 'and' ( (lv_events_2_0= ruleEvent ) )
            	    {
            	    otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleCondition884); 

            	        	newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getAndKeyword_1_0());
            	        
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:426:1: ( (lv_events_2_0= ruleEvent ) )
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:427:1: (lv_events_2_0= ruleEvent )
            	    {
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:427:1: (lv_events_2_0= ruleEvent )
            	    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:428:3: lv_events_2_0= ruleEvent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConditionAccess().getEventsEventParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEvent_in_ruleCondition905);
            	    lv_events_2_0=ruleEvent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConditionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"events",
            	            		lv_events_2_0, 
            	            		"Event");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleEvent"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:452:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:453:2: (iv_ruleEvent= ruleEvent EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:454:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_ruleEvent_in_entryRuleEvent943);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEvent953); 

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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:461:1: ruleEvent returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_state_2_0= RULE_BOOLEAN ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_state_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:464:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_state_2_0= RULE_BOOLEAN ) ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:465:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_state_2_0= RULE_BOOLEAN ) ) )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:465:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_state_2_0= RULE_BOOLEAN ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:465:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '==' ( (lv_state_2_0= RULE_BOOLEAN ) )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:465:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:466:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:466:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:467:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEvent998); 

            		newLeafNode(otherlv_0, grammarAccess.getEventAccess().getSignalSignalCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleEvent1010); 

                	newLeafNode(otherlv_1, grammarAccess.getEventAccess().getEqualsSignEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:482:1: ( (lv_state_2_0= RULE_BOOLEAN ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:483:1: (lv_state_2_0= RULE_BOOLEAN )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:483:1: (lv_state_2_0= RULE_BOOLEAN )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:484:3: lv_state_2_0= RULE_BOOLEAN
            {
            lv_state_2_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleEvent1027); 

            			newLeafNode(lv_state_2_0, grammarAccess.getEventAccess().getStateBOOLEANTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEventRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"state",
                    		lv_state_2_0, 
                    		"BOOLEAN");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvent"


    // $ANTLR start "entryRuleCommand"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:508:1: entryRuleCommand returns [EObject current=null] : iv_ruleCommand= ruleCommand EOF ;
    public final EObject entryRuleCommand() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommand = null;


        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:509:2: (iv_ruleCommand= ruleCommand EOF )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:510:2: iv_ruleCommand= ruleCommand EOF
            {
             newCompositeNode(grammarAccess.getCommandRule()); 
            pushFollow(FOLLOW_ruleCommand_in_entryRuleCommand1068);
            iv_ruleCommand=ruleCommand();

            state._fsp--;

             current =iv_ruleCommand; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCommand1078); 

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
    // $ANTLR end "entryRuleCommand"


    // $ANTLR start "ruleCommand"
    // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:517:1: ruleCommand returns [EObject current=null] : (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newState_3_0= RULE_BOOLEAN ) ) ) ;
    public final EObject ruleCommand() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_newState_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:520:28: ( (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newState_3_0= RULE_BOOLEAN ) ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:521:1: (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newState_3_0= RULE_BOOLEAN ) ) )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:521:1: (otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newState_3_0= RULE_BOOLEAN ) ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:521:3: otherlv_0= 'set' ( (otherlv_1= RULE_ID ) ) otherlv_2= '=' ( (lv_newState_3_0= RULE_BOOLEAN ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleCommand1115); 

                	newLeafNode(otherlv_0, grammarAccess.getCommandAccess().getSetKeyword_0());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:525:1: ( (otherlv_1= RULE_ID ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:526:1: (otherlv_1= RULE_ID )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:526:1: (otherlv_1= RULE_ID )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:527:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCommand1135); 

            		newLeafNode(otherlv_1, grammarAccess.getCommandAccess().getSignalSignalCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleCommand1147); 

                	newLeafNode(otherlv_2, grammarAccess.getCommandAccess().getEqualsSignKeyword_2());
                
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:542:1: ( (lv_newState_3_0= RULE_BOOLEAN ) )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:543:1: (lv_newState_3_0= RULE_BOOLEAN )
            {
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:543:1: (lv_newState_3_0= RULE_BOOLEAN )
            // ../org.eclipse.xtext.web.example.statemachine/src-gen/org/eclipse/xtext/web/example/statemachine/parser/antlr/internal/InternalStatemachine.g:544:3: lv_newState_3_0= RULE_BOOLEAN
            {
            lv_newState_3_0=(Token)match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleCommand1164); 

            			newLeafNode(lv_newState_3_0, grammarAccess.getCommandAccess().getNewStateBOOLEANTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCommandRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"newState",
                    		lv_newState_3_0, 
                    		"BOOLEAN");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCommand"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleStatemachine_in_entryRuleStatemachine75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatemachine85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignal_in_ruleStatemachine140 = new BitSet(new long[]{0x000000000000E002L});
    public static final BitSet FOLLOW_ruleState_in_ruleStatemachine162 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleSignal_in_entryRuleSignal199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignal209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInputSignal_in_ruleSignal251 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleOutputSignal_in_ruleSignal272 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSignal284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSignal301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInputSignal_in_entryRuleInputSignal343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInputSignal354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleInputSignal391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOutputSignal_in_entryRuleOutputSignal431 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOutputSignal442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleOutputSignal479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleState_in_entryRuleState518 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleState528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleState565 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleState582 = new BitSet(new long[]{0x0000000000230000L});
    public static final BitSet FOLLOW_ruleCommand_in_ruleState608 = new BitSet(new long[]{0x0000000000230000L});
    public static final BitSet FOLLOW_ruleTransition_in_ruleState630 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_ruleState643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransition_in_entryRuleTransition679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransition689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleTransition726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleTransition747 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransition759 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransition779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondition_in_entryRuleCondition815 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondition825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleCondition871 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleCondition884 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleEvent_in_ruleCondition905 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleEvent_in_entryRuleEvent943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEvent953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEvent998 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleEvent1010 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleEvent1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCommand_in_entryRuleCommand1068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCommand1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleCommand1115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCommand1135 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleCommand1147 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleCommand1164 = new BitSet(new long[]{0x0000000000000002L});

}
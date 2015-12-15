package org.eclipse.xtext.example.homeautomation.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.example.homeautomation.services.RuleEngineGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalRuleEngineParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Synchronized", "Instanceof", "Extension", "Default", "Extends", "Finally", "Device", "Import", "Return", "Static", "Switch", "Typeof", "Catch", "False", "Super", "Throw", "While", "Rule", "Case", "Else", "Null", "Then", "True", "When", "ExclamationMarkEqualsSignEqualsSign", "FullStopFullStopLessThanSign", "EqualsSignEqualsSignEqualsSign", "Can", "For", "New", "Try", "Val", "Var", "ExclamationMarkEqualsSign", "PercentSignEqualsSign", "AmpersandAmpersand", "AsteriskAsterisk", "AsteriskEqualsSign", "PlusSignPlusSign", "PlusSignEqualsSign", "HyphenMinusHyphenMinus", "HyphenMinusEqualsSign", "HyphenMinusGreaterThanSign", "FullStopFullStop", "SolidusEqualsSign", "ColonColon", "LessThanSignGreaterThanSign", "EqualsSignEqualsSign", "EqualsSignGreaterThanSign", "GreaterThanSignEqualsSign", "QuestionMarkFullStop", "QuestionMarkColon", "As", "Be", "Do", "If", "VerticalLineVerticalLine", "ExclamationMark", "NumberSign", "PercentSign", "Ampersand", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "Semicolon", "LessThanSign", "EqualsSign", "GreaterThanSign", "QuestionMark", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "VerticalLine", "RightCurlyBracket", "RULE_BEGIN", "RULE_END", "RULE_HEX", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Switch=14;
    public static final int RULE_ID=89;
    public static final int RightParenthesis=66;
    public static final int Static=13;
    public static final int RULE_ANY_OTHER=94;
    public static final int ExclamationMark=61;
    public static final int LeftParenthesis=65;
    public static final int RightSquareBracket=80;
    public static final int Extends=8;
    public static final int Solidus=72;
    public static final int EOF=-1;
    public static final int EqualsSignEqualsSign=51;
    public static final int FullStop=71;
    public static final int Finally=9;
    public static final int PercentSign=63;
    public static final int Default=7;
    public static final int RULE_HEX=86;
    public static final int LessThanSign=75;
    public static final int When=27;
    public static final int Do=58;
    public static final int PlusSignPlusSign=42;
    public static final int RULE_DECIMAL=88;
    public static final int FullStopFullStop=47;
    public static final int Null=24;
    public static final int PercentSignEqualsSign=38;
    public static final int LeftCurlyBracket=81;
    public static final int Colon=73;
    public static final int NumberSign=62;
    public static final int RULE_ML_COMMENT=91;
    public static final int RULE_STRING=90;
    public static final int VerticalLine=82;
    public static final int RULE_END=85;
    public static final int HyphenMinusEqualsSign=45;
    public static final int ExclamationMarkEqualsSignEqualsSign=28;
    public static final int Else=23;
    public static final int Val=35;
    public static final int Var=36;
    public static final int HyphenMinusGreaterThanSign=46;
    public static final int RightCurlyBracket=83;
    public static final int Typeof=15;
    public static final int QuestionMarkFullStop=54;
    public static final int Try=34;
    public static final int VerticalLineVerticalLine=60;
    public static final int HyphenMinus=70;
    public static final int AmpersandAmpersand=39;
    public static final int RULE_BEGIN=84;
    public static final int QuestionMarkColon=55;
    public static final int False=17;
    public static final int Extension=6;
    public static final int While=20;
    public static final int LessThanSignGreaterThanSign=50;
    public static final int Case=22;
    public static final int GreaterThanSign=77;
    public static final int HyphenMinusHyphenMinus=44;
    public static final int EqualsSignGreaterThanSign=52;
    public static final int EqualsSignEqualsSignEqualsSign=30;
    public static final int RULE_INT=87;
    public static final int AsteriskAsterisk=40;
    public static final int Synchronized=4;
    public static final int LeftSquareBracket=79;
    public static final int Return=12;
    public static final int True=26;
    public static final int If=59;
    public static final int ExclamationMarkEqualsSign=37;
    public static final int Asterisk=67;
    public static final int Import=11;
    public static final int Device=10;
    public static final int As=56;
    public static final int Then=25;
    public static final int Catch=16;
    public static final int Super=18;
    public static final int Throw=19;
    public static final int SolidusEqualsSign=48;
    public static final int Can=31;
    public static final int Semicolon=74;
    public static final int RULE_SL_COMMENT=92;
    public static final int For=32;
    public static final int Ampersand=64;
    public static final int ColonColon=49;
    public static final int PlusSign=68;
    public static final int New=33;
    public static final int AsteriskEqualsSign=41;
    public static final int Rule=21;
    public static final int Instanceof=5;
    public static final int PlusSignEqualsSign=43;
    public static final int FullStopFullStopLessThanSign=29;
    public static final int GreaterThanSignEqualsSign=53;
    public static final int QuestionMark=78;
    public static final int Be=57;
    public static final int RULE_WS=93;
    public static final int EqualsSign=76;
    public static final int Comma=69;

    // delegates
    // delegators


        public InternalRuleEngineParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRuleEngineParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRuleEngineParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRuleEngineParser.g"; }



     	private RuleEngineGrammarAccess grammarAccess;

        public InternalRuleEngineParser(TokenStream input, RuleEngineGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected RuleEngineGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalRuleEngineParser.g:57:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalRuleEngineParser.g:57:46: (iv_ruleModel= ruleModel EOF )
            // InternalRuleEngineParser.g:58:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalRuleEngineParser.g:64:1: ruleModel returns [EObject current=null] : ( (lv_declarations_0_0= ruleDeclaration ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_0_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:70:2: ( ( (lv_declarations_0_0= ruleDeclaration ) )* )
            // InternalRuleEngineParser.g:71:2: ( (lv_declarations_0_0= ruleDeclaration ) )*
            {
            // InternalRuleEngineParser.g:71:2: ( (lv_declarations_0_0= ruleDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==Device||LA1_0==Rule) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRuleEngineParser.g:72:3: (lv_declarations_0_0= ruleDeclaration )
            	    {
            	    // InternalRuleEngineParser.g:72:3: (lv_declarations_0_0= ruleDeclaration )
            	    // InternalRuleEngineParser.g:73:4: lv_declarations_0_0= ruleDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getModelAccess().getDeclarationsDeclarationParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_declarations_0_0=ruleDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"declarations",
            	      					lv_declarations_0_0,
            	      					"org.eclipse.xtext.example.homeautomation.RuleEngine.Declaration");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDeclaration"
    // InternalRuleEngineParser.g:93:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalRuleEngineParser.g:93:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalRuleEngineParser.g:94:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalRuleEngineParser.g:100:1: ruleDeclaration returns [EObject current=null] : (this_Device_0= ruleDevice | this_Rule_1= ruleRule ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_Device_0 = null;

        EObject this_Rule_1 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:106:2: ( (this_Device_0= ruleDevice | this_Rule_1= ruleRule ) )
            // InternalRuleEngineParser.g:107:2: (this_Device_0= ruleDevice | this_Rule_1= ruleRule )
            {
            // InternalRuleEngineParser.g:107:2: (this_Device_0= ruleDevice | this_Rule_1= ruleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Device) ) {
                alt2=1;
            }
            else if ( (LA2_0==Rule) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalRuleEngineParser.g:108:3: this_Device_0= ruleDevice
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeclarationAccess().getDeviceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Device_0=ruleDevice();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Device_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:117:3: this_Rule_1= ruleRule
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDeclarationAccess().getRuleParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Rule_1=ruleRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Rule_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleDevice"
    // InternalRuleEngineParser.g:129:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // InternalRuleEngineParser.g:129:47: (iv_ruleDevice= ruleDevice EOF )
            // InternalRuleEngineParser.g:130:2: iv_ruleDevice= ruleDevice EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeviceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDevice=ruleDevice();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDevice; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // InternalRuleEngineParser.g:136:1: ruleDevice returns [EObject current=null] : (otherlv_0= Device ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Can otherlv_3= Be ( ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )* )? ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_states_4_0 = null;

        EObject lv_states_6_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:142:2: ( (otherlv_0= Device ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Can otherlv_3= Be ( ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )* )? ) )
            // InternalRuleEngineParser.g:143:2: (otherlv_0= Device ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Can otherlv_3= Be ( ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )* )? )
            {
            // InternalRuleEngineParser.g:143:2: (otherlv_0= Device ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Can otherlv_3= Be ( ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )* )? )
            // InternalRuleEngineParser.g:144:3: otherlv_0= Device ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Can otherlv_3= Be ( ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )* )?
            {
            otherlv_0=(Token)match(input,Device,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDeviceAccess().getDeviceKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:148:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRuleEngineParser.g:149:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRuleEngineParser.g:149:4: (lv_name_1_0= RULE_ID )
            // InternalRuleEngineParser.g:150:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getDeviceAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDeviceRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.xbase.Xtype.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Can,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDeviceAccess().getCanKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,Be,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDeviceAccess().getBeKeyword_3());
              		
            }
            // InternalRuleEngineParser.g:174:3: ( ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRuleEngineParser.g:175:4: ( (lv_states_4_0= ruleState ) ) (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )*
                    {
                    // InternalRuleEngineParser.g:175:4: ( (lv_states_4_0= ruleState ) )
                    // InternalRuleEngineParser.g:176:5: (lv_states_4_0= ruleState )
                    {
                    // InternalRuleEngineParser.g:176:5: (lv_states_4_0= ruleState )
                    // InternalRuleEngineParser.g:177:6: lv_states_4_0= ruleState
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
                    lv_states_4_0=ruleState();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeviceRule());
                      						}
                      						add(
                      							current,
                      							"states",
                      							lv_states_4_0,
                      							"org.eclipse.xtext.example.homeautomation.RuleEngine.State");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:194:4: (otherlv_5= Comma ( (lv_states_6_0= ruleState ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==Comma) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:195:5: otherlv_5= Comma ( (lv_states_6_0= ruleState ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Comma,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getDeviceAccess().getCommaKeyword_4_1_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:199:5: ( (lv_states_6_0= ruleState ) )
                    	    // InternalRuleEngineParser.g:200:6: (lv_states_6_0= ruleState )
                    	    {
                    	    // InternalRuleEngineParser.g:200:6: (lv_states_6_0= ruleState )
                    	    // InternalRuleEngineParser.g:201:7: lv_states_6_0= ruleState
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_8);
                    	    lv_states_6_0=ruleState();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getDeviceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"states",
                    	      								lv_states_6_0,
                    	      								"org.eclipse.xtext.example.homeautomation.RuleEngine.State");
                    	      							afterParserOrEnumRuleCall();
                    	      						
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
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleState"
    // InternalRuleEngineParser.g:224:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRuleEngineParser.g:224:46: (iv_ruleState= ruleState EOF )
            // InternalRuleEngineParser.g:225:2: iv_ruleState= ruleState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalRuleEngineParser.g:231:1: ruleState returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:237:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalRuleEngineParser.g:238:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalRuleEngineParser.g:238:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRuleEngineParser.g:239:3: (lv_name_0_0= RULE_ID )
            {
            // InternalRuleEngineParser.g:239:3: (lv_name_0_0= RULE_ID )
            // InternalRuleEngineParser.g:240:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getStateRule());
              				}
              				setWithLastConsumed(
              					current,
              					"name",
              					lv_name_0_0,
              					"org.eclipse.xtext.xbase.Xtype.ID");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleRule"
    // InternalRuleEngineParser.g:259:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalRuleEngineParser.g:259:45: (iv_ruleRule= ruleRule EOF )
            // InternalRuleEngineParser.g:260:2: iv_ruleRule= ruleRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalRuleEngineParser.g:266:1: ruleRule returns [EObject current=null] : (otherlv_0= Rule ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= When ( ( ruleQualifiedName ) ) otherlv_4= Then ( (lv_thenPart_5_0= ruleXBlockExpression ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_thenPart_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:272:2: ( (otherlv_0= Rule ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= When ( ( ruleQualifiedName ) ) otherlv_4= Then ( (lv_thenPart_5_0= ruleXBlockExpression ) ) ) )
            // InternalRuleEngineParser.g:273:2: (otherlv_0= Rule ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= When ( ( ruleQualifiedName ) ) otherlv_4= Then ( (lv_thenPart_5_0= ruleXBlockExpression ) ) )
            {
            // InternalRuleEngineParser.g:273:2: (otherlv_0= Rule ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= When ( ( ruleQualifiedName ) ) otherlv_4= Then ( (lv_thenPart_5_0= ruleXBlockExpression ) ) )
            // InternalRuleEngineParser.g:274:3: otherlv_0= Rule ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= When ( ( ruleQualifiedName ) ) otherlv_4= Then ( (lv_thenPart_5_0= ruleXBlockExpression ) )
            {
            otherlv_0=(Token)match(input,Rule,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:278:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalRuleEngineParser.g:279:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalRuleEngineParser.g:279:4: (lv_description_1_0= RULE_STRING )
            // InternalRuleEngineParser.g:280:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_description_1_0, grammarAccess.getRuleAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRuleRule());
              					}
              					setWithLastConsumed(
              						current,
              						"description",
              						lv_description_1_0,
              						"org.eclipse.xtext.xbase.Xtype.STRING");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,When,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getWhenKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:300:3: ( ( ruleQualifiedName ) )
            // InternalRuleEngineParser.g:301:4: ( ruleQualifiedName )
            {
            // InternalRuleEngineParser.g:301:4: ( ruleQualifiedName )
            // InternalRuleEngineParser.g:302:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRuleRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleAccess().getDeviceStateStateCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_11);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,Then,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getThenKeyword_4());
              		
            }
            // InternalRuleEngineParser.g:320:3: ( (lv_thenPart_5_0= ruleXBlockExpression ) )
            // InternalRuleEngineParser.g:321:4: (lv_thenPart_5_0= ruleXBlockExpression )
            {
            // InternalRuleEngineParser.g:321:4: (lv_thenPart_5_0= ruleXBlockExpression )
            // InternalRuleEngineParser.g:322:5: lv_thenPart_5_0= ruleXBlockExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRuleAccess().getThenPartXBlockExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_thenPart_5_0=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRuleRule());
              					}
              					set(
              						current,
              						"thenPart",
              						lv_thenPart_5_0,
              						"org.eclipse.xtext.example.homeautomation.RuleEngine.XBlockExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleXBlockExpression"
    // InternalRuleEngineParser.g:343:1: entryRuleXBlockExpression returns [EObject current=null] : iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
    public final EObject entryRuleXBlockExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBlockExpression = null;


        try {
            // InternalRuleEngineParser.g:343:57: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
            // InternalRuleEngineParser.g:344:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBlockExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBlockExpression=ruleXBlockExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBlockExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBlockExpression"


    // $ANTLR start "ruleXBlockExpression"
    // InternalRuleEngineParser.g:350:1: ruleXBlockExpression returns [EObject current=null] : ( () this_BEGIN_1= RULE_BEGIN ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )? )* this_END_4= RULE_END ) ;
    public final EObject ruleXBlockExpression() throws RecognitionException {
        EObject current = null;

        Token this_BEGIN_1=null;
        Token otherlv_3=null;
        Token this_END_4=null;
        EObject lv_expressions_2_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:356:2: ( ( () this_BEGIN_1= RULE_BEGIN ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )? )* this_END_4= RULE_END ) )
            // InternalRuleEngineParser.g:357:2: ( () this_BEGIN_1= RULE_BEGIN ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )? )* this_END_4= RULE_END )
            {
            // InternalRuleEngineParser.g:357:2: ( () this_BEGIN_1= RULE_BEGIN ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )? )* this_END_4= RULE_END )
            // InternalRuleEngineParser.g:358:3: () this_BEGIN_1= RULE_BEGIN ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )? )* this_END_4= RULE_END
            {
            // InternalRuleEngineParser.g:358:3: ()
            // InternalRuleEngineParser.g:359:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
              					current);
              			
            }

            }

            this_BEGIN_1=(Token)match(input,RULE_BEGIN,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_1, grammarAccess.getXBlockExpressionAccess().getBEGINTerminalRuleCall_1());
              		
            }
            // InternalRuleEngineParser.g:369:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )? )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Synchronized||LA6_0==Extension||LA6_0==Extends||(LA6_0>=Import && LA6_0<=Typeof)||(LA6_0>=False && LA6_0<=While)||LA6_0==Null||LA6_0==True||(LA6_0>=For && LA6_0<=Var)||(LA6_0>=Do && LA6_0<=If)||(LA6_0>=ExclamationMark && LA6_0<=NumberSign)||LA6_0==LeftParenthesis||LA6_0==PlusSign||LA6_0==HyphenMinus||LA6_0==LessThanSign||LA6_0==LeftSquareBracket||LA6_0==RULE_BEGIN||(LA6_0>=RULE_HEX && LA6_0<=RULE_STRING)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalRuleEngineParser.g:370:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= Semicolon )?
            	    {
            	    // InternalRuleEngineParser.g:370:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
            	    // InternalRuleEngineParser.g:371:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // InternalRuleEngineParser.g:371:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
            	    // InternalRuleEngineParser.g:372:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_expressions_2_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_2_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalRuleEngineParser.g:389:4: (otherlv_3= Semicolon )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==Semicolon) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:390:5: otherlv_3= Semicolon
            	            {
            	            otherlv_3=(Token)match(input,Semicolon,FOLLOW_13); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            this_END_4=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_4, grammarAccess.getXBlockExpressionAccess().getENDTerminalRuleCall_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXBlockExpression"


    // $ANTLR start "entryRuleXSwitchExpression"
    // InternalRuleEngineParser.g:404:1: entryRuleXSwitchExpression returns [EObject current=null] : iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
    public final EObject entryRuleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSwitchExpression = null;


        try {
            // InternalRuleEngineParser.g:404:58: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
            // InternalRuleEngineParser.g:405:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSwitchExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSwitchExpression=ruleXSwitchExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSwitchExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSwitchExpression"


    // $ANTLR start "ruleXSwitchExpression"
    // InternalRuleEngineParser.g:411:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= Switch ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) this_BEGIN_10= RULE_BEGIN ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) ) )? this_END_15= RULE_END ) ;
    public final EObject ruleXSwitchExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_BEGIN_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token this_END_15=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_switch_5_0 = null;

        EObject lv_declaredParam_7_0 = null;

        EObject lv_switch_9_0 = null;

        EObject lv_cases_11_0 = null;

        EObject lv_default_14_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:417:2: ( ( () otherlv_1= Switch ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) this_BEGIN_10= RULE_BEGIN ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) ) )? this_END_15= RULE_END ) )
            // InternalRuleEngineParser.g:418:2: ( () otherlv_1= Switch ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) this_BEGIN_10= RULE_BEGIN ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) ) )? this_END_15= RULE_END )
            {
            // InternalRuleEngineParser.g:418:2: ( () otherlv_1= Switch ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) this_BEGIN_10= RULE_BEGIN ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) ) )? this_END_15= RULE_END )
            // InternalRuleEngineParser.g:419:3: () otherlv_1= Switch ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) this_BEGIN_10= RULE_BEGIN ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) ) )? this_END_15= RULE_END
            {
            // InternalRuleEngineParser.g:419:3: ()
            // InternalRuleEngineParser.g:420:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Switch,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:430:3: ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalRuleEngineParser.g:431:4: ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis )
                    {
                    // InternalRuleEngineParser.g:431:4: ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis )
                    // InternalRuleEngineParser.g:432:5: ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis
                    {
                    // InternalRuleEngineParser.g:432:5: ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) )
                    // InternalRuleEngineParser.g:433:6: ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon )
                    {
                    // InternalRuleEngineParser.g:443:6: (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon )
                    // InternalRuleEngineParser.g:444:7: otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon
                    {
                    otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
                      						
                    }
                    // InternalRuleEngineParser.g:448:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
                    // InternalRuleEngineParser.g:449:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    {
                    // InternalRuleEngineParser.g:449:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
                    // InternalRuleEngineParser.g:450:9: lv_declaredParam_3_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      									newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0());
                      								
                    }
                    pushFollow(FOLLOW_17);
                    lv_declaredParam_3_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									if (current==null) {
                      										current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      									}
                      									set(
                      										current,
                      										"declaredParam",
                      										lv_declaredParam_3_0,
                      										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                      									afterParserOrEnumRuleCall();
                      								
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,Colon,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
                      						
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:473:5: ( (lv_switch_5_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:474:6: (lv_switch_5_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:474:6: (lv_switch_5_0= ruleXExpression )
                    // InternalRuleEngineParser.g:475:7: lv_switch_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_19);
                    lv_switch_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      							}
                      							set(
                      								current,
                      								"switch",
                      								lv_switch_5_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:498:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    {
                    // InternalRuleEngineParser.g:498:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
                    // InternalRuleEngineParser.g:499:5: ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) )
                    {
                    // InternalRuleEngineParser.g:499:5: ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )?
                    int alt7=2;
                    alt7 = dfa7.predict(input);
                    switch (alt7) {
                        case 1 :
                            // InternalRuleEngineParser.g:500:6: ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon )
                            {
                            // InternalRuleEngineParser.g:509:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon )
                            // InternalRuleEngineParser.g:510:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon
                            {
                            // InternalRuleEngineParser.g:510:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
                            // InternalRuleEngineParser.g:511:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            {
                            // InternalRuleEngineParser.g:511:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
                            // InternalRuleEngineParser.g:512:9: lv_declaredParam_7_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0());
                              								
                            }
                            pushFollow(FOLLOW_17);
                            lv_declaredParam_7_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                              									}
                              									set(
                              										current,
                              										"declaredParam",
                              										lv_declaredParam_7_0,
                              										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }

                            otherlv_8=(Token)match(input,Colon,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalRuleEngineParser.g:535:5: ( (lv_switch_9_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:536:6: (lv_switch_9_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:536:6: (lv_switch_9_0= ruleXExpression )
                    // InternalRuleEngineParser.g:537:7: lv_switch_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_12);
                    lv_switch_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      							}
                      							set(
                      								current,
                      								"switch",
                      								lv_switch_9_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            this_BEGIN_10=(Token)match(input,RULE_BEGIN,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_10, grammarAccess.getXSwitchExpressionAccess().getBEGINTerminalRuleCall_3());
              		
            }
            // InternalRuleEngineParser.g:560:3: ( (lv_cases_11_0= ruleXCasePart ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Case||LA9_0==EqualsSignGreaterThanSign||LA9_0==LeftParenthesis||LA9_0==Comma||LA9_0==Colon||LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRuleEngineParser.g:561:4: (lv_cases_11_0= ruleXCasePart )
            	    {
            	    // InternalRuleEngineParser.g:561:4: (lv_cases_11_0= ruleXCasePart )
            	    // InternalRuleEngineParser.g:562:5: lv_cases_11_0= ruleXCasePart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_cases_11_0=ruleXCasePart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"cases",
            	      						lv_cases_11_0,
            	      						"org.eclipse.xtext.xbase.Xbase.XCasePart");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalRuleEngineParser.g:579:3: (otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Default) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalRuleEngineParser.g:580:4: otherlv_12= Default otherlv_13= Colon ( (lv_default_14_0= ruleXExpression ) )
                    {
                    otherlv_12=(Token)match(input,Default,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
                      			
                    }
                    otherlv_13=(Token)match(input,Colon,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
                      			
                    }
                    // InternalRuleEngineParser.g:588:4: ( (lv_default_14_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:589:5: (lv_default_14_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:589:5: (lv_default_14_0= ruleXExpression )
                    // InternalRuleEngineParser.g:590:6: lv_default_14_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_default_14_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
                      						}
                      						set(
                      							current,
                      							"default",
                      							lv_default_14_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            this_END_15=(Token)match(input,RULE_END,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_15, grammarAccess.getXSwitchExpressionAccess().getENDTerminalRuleCall_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXSwitchExpression"


    // $ANTLR start "entryRuleXExpression"
    // InternalRuleEngineParser.g:616:1: entryRuleXExpression returns [EObject current=null] : iv_ruleXExpression= ruleXExpression EOF ;
    public final EObject entryRuleXExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpression = null;


        try {
            // InternalRuleEngineParser.g:616:52: (iv_ruleXExpression= ruleXExpression EOF )
            // InternalRuleEngineParser.g:617:2: iv_ruleXExpression= ruleXExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpression=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpression"


    // $ANTLR start "ruleXExpression"
    // InternalRuleEngineParser.g:623:1: ruleXExpression returns [EObject current=null] : this_XAssignment_0= ruleXAssignment ;
    public final EObject ruleXExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAssignment_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:629:2: (this_XAssignment_0= ruleXAssignment )
            // InternalRuleEngineParser.g:630:2: this_XAssignment_0= ruleXAssignment
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_XAssignment_0=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_XAssignment_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXExpression"


    // $ANTLR start "entryRuleXAssignment"
    // InternalRuleEngineParser.g:641:1: entryRuleXAssignment returns [EObject current=null] : iv_ruleXAssignment= ruleXAssignment EOF ;
    public final EObject entryRuleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAssignment = null;


        try {
            // InternalRuleEngineParser.g:641:52: (iv_ruleXAssignment= ruleXAssignment EOF )
            // InternalRuleEngineParser.g:642:2: iv_ruleXAssignment= ruleXAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAssignment=ruleXAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAssignment"


    // $ANTLR start "ruleXAssignment"
    // InternalRuleEngineParser.g:648:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
    public final EObject ruleXAssignment() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;

        EObject this_XOrExpression_4 = null;

        EObject lv_rightOperand_7_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:654:2: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
            // InternalRuleEngineParser.g:655:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            {
            // InternalRuleEngineParser.g:655:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
            int alt12=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==EqualsSign) ) {
                    alt12=1;
                }
                else if ( (LA12_1==EOF||(LA12_1>=Synchronized && LA12_1<=Finally)||(LA12_1>=Import && LA12_1<=While)||(LA12_1>=Case && LA12_1<=Null)||LA12_1==True||(LA12_1>=ExclamationMarkEqualsSignEqualsSign && LA12_1<=EqualsSignEqualsSignEqualsSign)||(LA12_1>=For && LA12_1<=As)||(LA12_1>=Do && LA12_1<=PercentSign)||(LA12_1>=LeftParenthesis && LA12_1<=LessThanSign)||LA12_1==GreaterThanSign||(LA12_1>=LeftSquareBracket && LA12_1<=RightSquareBracket)||(LA12_1>=RightCurlyBracket && LA12_1<=RULE_STRING)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case Extends:
                {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==EqualsSign) ) {
                    alt12=1;
                }
                else if ( (LA12_2==EOF||(LA12_2>=Synchronized && LA12_2<=Finally)||(LA12_2>=Import && LA12_2<=While)||(LA12_2>=Case && LA12_2<=Null)||LA12_2==True||(LA12_2>=ExclamationMarkEqualsSignEqualsSign && LA12_2<=EqualsSignEqualsSignEqualsSign)||(LA12_2>=For && LA12_2<=As)||(LA12_2>=Do && LA12_2<=PercentSign)||(LA12_2>=LeftParenthesis && LA12_2<=LessThanSign)||LA12_2==GreaterThanSign||(LA12_2>=LeftSquareBracket && LA12_2<=RightSquareBracket)||(LA12_2>=RightCurlyBracket && LA12_2<=RULE_STRING)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case Static:
                {
                int LA12_3 = input.LA(2);

                if ( (LA12_3==EqualsSign) ) {
                    alt12=1;
                }
                else if ( (LA12_3==EOF||(LA12_3>=Synchronized && LA12_3<=Finally)||(LA12_3>=Import && LA12_3<=While)||(LA12_3>=Case && LA12_3<=Null)||LA12_3==True||(LA12_3>=ExclamationMarkEqualsSignEqualsSign && LA12_3<=EqualsSignEqualsSignEqualsSign)||(LA12_3>=For && LA12_3<=As)||(LA12_3>=Do && LA12_3<=PercentSign)||(LA12_3>=LeftParenthesis && LA12_3<=LessThanSign)||LA12_3==GreaterThanSign||(LA12_3>=LeftSquareBracket && LA12_3<=RightSquareBracket)||(LA12_3>=RightCurlyBracket && LA12_3<=RULE_STRING)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;
                }
                }
                break;
            case Import:
                {
                int LA12_4 = input.LA(2);

                if ( (LA12_4==EOF||(LA12_4>=Synchronized && LA12_4<=Finally)||(LA12_4>=Import && LA12_4<=While)||(LA12_4>=Case && LA12_4<=Null)||LA12_4==True||(LA12_4>=ExclamationMarkEqualsSignEqualsSign && LA12_4<=EqualsSignEqualsSignEqualsSign)||(LA12_4>=For && LA12_4<=As)||(LA12_4>=Do && LA12_4<=PercentSign)||(LA12_4>=LeftParenthesis && LA12_4<=LessThanSign)||LA12_4==GreaterThanSign||(LA12_4>=LeftSquareBracket && LA12_4<=RightSquareBracket)||(LA12_4>=RightCurlyBracket && LA12_4<=RULE_STRING)) ) {
                    alt12=2;
                }
                else if ( (LA12_4==EqualsSign) ) {
                    alt12=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    throw nvae;
                }
                }
                break;
            case Extension:
                {
                int LA12_5 = input.LA(2);

                if ( (LA12_5==EqualsSign) ) {
                    alt12=1;
                }
                else if ( (LA12_5==EOF||(LA12_5>=Synchronized && LA12_5<=Finally)||(LA12_5>=Import && LA12_5<=While)||(LA12_5>=Case && LA12_5<=Null)||LA12_5==True||(LA12_5>=ExclamationMarkEqualsSignEqualsSign && LA12_5<=EqualsSignEqualsSignEqualsSign)||(LA12_5>=For && LA12_5<=As)||(LA12_5>=Do && LA12_5<=PercentSign)||(LA12_5>=LeftParenthesis && LA12_5<=LessThanSign)||LA12_5==GreaterThanSign||(LA12_5>=LeftSquareBracket && LA12_5<=RightSquareBracket)||(LA12_5>=RightCurlyBracket && LA12_5<=RULE_STRING)) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 5, input);

                    throw nvae;
                }
                }
                break;
            case Synchronized:
            case Return:
            case Switch:
            case Typeof:
            case False:
            case Super:
            case Throw:
            case While:
            case Null:
            case True:
            case For:
            case New:
            case Try:
            case Do:
            case If:
            case ExclamationMark:
            case NumberSign:
            case LeftParenthesis:
            case PlusSign:
            case HyphenMinus:
            case LessThanSign:
            case LeftSquareBracket:
            case RULE_BEGIN:
            case RULE_HEX:
            case RULE_INT:
            case RULE_DECIMAL:
            case RULE_STRING:
                {
                alt12=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalRuleEngineParser.g:656:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    {
                    // InternalRuleEngineParser.g:656:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
                    // InternalRuleEngineParser.g:657:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
                    {
                    // InternalRuleEngineParser.g:657:4: ()
                    // InternalRuleEngineParser.g:658:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalRuleEngineParser.g:664:4: ( ( ruleFeatureCallID ) )
                    // InternalRuleEngineParser.g:665:5: ( ruleFeatureCallID )
                    {
                    // InternalRuleEngineParser.g:665:5: ( ruleFeatureCallID )
                    // InternalRuleEngineParser.g:666:6: ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXAssignmentRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_22);
                    ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2());
                      			
                    }
                    pushFollow(FOLLOW_18);
                    ruleOpSingleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalRuleEngineParser.g:687:4: ( (lv_value_3_0= ruleXAssignment ) )
                    // InternalRuleEngineParser.g:688:5: (lv_value_3_0= ruleXAssignment )
                    {
                    // InternalRuleEngineParser.g:688:5: (lv_value_3_0= ruleXAssignment )
                    // InternalRuleEngineParser.g:689:6: lv_value_3_0= ruleXAssignment
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleXAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XAssignment");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:708:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    {
                    // InternalRuleEngineParser.g:708:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
                    // InternalRuleEngineParser.g:709:4: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_23);
                    this_XOrExpression_4=ruleXOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XOrExpression_4;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalRuleEngineParser.g:717:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
                    int alt11=2;
                    alt11 = dfa11.predict(input);
                    switch (alt11) {
                        case 1 :
                            // InternalRuleEngineParser.g:718:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            {
                            // InternalRuleEngineParser.g:718:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
                            // InternalRuleEngineParser.g:719:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
                            {
                            // InternalRuleEngineParser.g:729:6: ( () ( ( ruleOpMultiAssign ) ) )
                            // InternalRuleEngineParser.g:730:7: () ( ( ruleOpMultiAssign ) )
                            {
                            // InternalRuleEngineParser.g:730:7: ()
                            // InternalRuleEngineParser.g:731:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            // InternalRuleEngineParser.g:737:7: ( ( ruleOpMultiAssign ) )
                            // InternalRuleEngineParser.g:738:8: ( ruleOpMultiAssign )
                            {
                            // InternalRuleEngineParser.g:738:8: ( ruleOpMultiAssign )
                            // InternalRuleEngineParser.g:739:9: ruleOpMultiAssign
                            {
                            if ( state.backtracking==0 ) {

                              									if (current==null) {
                              										current = createModelElement(grammarAccess.getXAssignmentRule());
                              									}
                              								
                            }
                            if ( state.backtracking==0 ) {

                              									newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
                              								
                            }
                            pushFollow(FOLLOW_18);
                            ruleOpMultiAssign();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              									afterParserOrEnumRuleCall();
                              								
                            }

                            }


                            }


                            }


                            }

                            // InternalRuleEngineParser.g:755:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
                            // InternalRuleEngineParser.g:756:6: (lv_rightOperand_7_0= ruleXAssignment )
                            {
                            // InternalRuleEngineParser.g:756:6: (lv_rightOperand_7_0= ruleXAssignment )
                            // InternalRuleEngineParser.g:757:7: lv_rightOperand_7_0= ruleXAssignment
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_rightOperand_7_0=ruleXAssignment();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXAssignmentRule());
                              							}
                              							set(
                              								current,
                              								"rightOperand",
                              								lv_rightOperand_7_0,
                              								"org.eclipse.xtext.xbase.Xbase.XAssignment");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXAssignment"


    // $ANTLR start "entryRuleOpSingleAssign"
    // InternalRuleEngineParser.g:780:1: entryRuleOpSingleAssign returns [String current=null] : iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
    public final String entryRuleOpSingleAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpSingleAssign = null;


        try {
            // InternalRuleEngineParser.g:780:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
            // InternalRuleEngineParser.g:781:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpSingleAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpSingleAssign=ruleOpSingleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpSingleAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpSingleAssign"


    // $ANTLR start "ruleOpSingleAssign"
    // InternalRuleEngineParser.g:787:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= EqualsSign ;
    public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:793:2: (kw= EqualsSign )
            // InternalRuleEngineParser.g:794:2: kw= EqualsSign
            {
            kw=(Token)match(input,EqualsSign,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpSingleAssign"


    // $ANTLR start "entryRuleOpMultiAssign"
    // InternalRuleEngineParser.g:802:1: entryRuleOpMultiAssign returns [String current=null] : iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
    public final String entryRuleOpMultiAssign() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMultiAssign = null;


        try {
            // InternalRuleEngineParser.g:802:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
            // InternalRuleEngineParser.g:803:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMultiAssign=ruleOpMultiAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMultiAssign.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMultiAssign"


    // $ANTLR start "ruleOpMultiAssign"
    // InternalRuleEngineParser.g:809:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign | (kw= LessThanSign kw= LessThanSign kw= EqualsSign ) | (kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign ) ) ;
    public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:815:2: ( (kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign | (kw= LessThanSign kw= LessThanSign kw= EqualsSign ) | (kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign ) ) )
            // InternalRuleEngineParser.g:816:2: (kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign | (kw= LessThanSign kw= LessThanSign kw= EqualsSign ) | (kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign ) )
            {
            // InternalRuleEngineParser.g:816:2: (kw= PlusSignEqualsSign | kw= HyphenMinusEqualsSign | kw= AsteriskEqualsSign | kw= SolidusEqualsSign | kw= PercentSignEqualsSign | (kw= LessThanSign kw= LessThanSign kw= EqualsSign ) | (kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign ) )
            int alt14=7;
            switch ( input.LA(1) ) {
            case PlusSignEqualsSign:
                {
                alt14=1;
                }
                break;
            case HyphenMinusEqualsSign:
                {
                alt14=2;
                }
                break;
            case AsteriskEqualsSign:
                {
                alt14=3;
                }
                break;
            case SolidusEqualsSign:
                {
                alt14=4;
                }
                break;
            case PercentSignEqualsSign:
                {
                alt14=5;
                }
                break;
            case LessThanSign:
                {
                alt14=6;
                }
                break;
            case GreaterThanSign:
                {
                alt14=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalRuleEngineParser.g:817:3: kw= PlusSignEqualsSign
                    {
                    kw=(Token)match(input,PlusSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:823:3: kw= HyphenMinusEqualsSign
                    {
                    kw=(Token)match(input,HyphenMinusEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:829:3: kw= AsteriskEqualsSign
                    {
                    kw=(Token)match(input,AsteriskEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:835:3: kw= SolidusEqualsSign
                    {
                    kw=(Token)match(input,SolidusEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRuleEngineParser.g:841:3: kw= PercentSignEqualsSign
                    {
                    kw=(Token)match(input,PercentSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRuleEngineParser.g:847:3: (kw= LessThanSign kw= LessThanSign kw= EqualsSign )
                    {
                    // InternalRuleEngineParser.g:847:3: (kw= LessThanSign kw= LessThanSign kw= EqualsSign )
                    // InternalRuleEngineParser.g:848:4: kw= LessThanSign kw= LessThanSign kw= EqualsSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0());
                      			
                    }
                    kw=(Token)match(input,LessThanSign,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1());
                      			
                    }
                    kw=(Token)match(input,EqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalRuleEngineParser.g:865:3: (kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign )
                    {
                    // InternalRuleEngineParser.g:865:3: (kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign )
                    // InternalRuleEngineParser.g:866:4: kw= GreaterThanSign (kw= GreaterThanSign )? kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0());
                      			
                    }
                    // InternalRuleEngineParser.g:871:4: (kw= GreaterThanSign )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==GreaterThanSign) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalRuleEngineParser.g:872:5: kw= GreaterThanSign
                            {
                            kw=(Token)match(input,GreaterThanSign,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1());
                              				
                            }

                            }
                            break;

                    }

                    kw=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpMultiAssign"


    // $ANTLR start "entryRuleXOrExpression"
    // InternalRuleEngineParser.g:888:1: entryRuleXOrExpression returns [EObject current=null] : iv_ruleXOrExpression= ruleXOrExpression EOF ;
    public final EObject entryRuleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOrExpression = null;


        try {
            // InternalRuleEngineParser.g:888:54: (iv_ruleXOrExpression= ruleXOrExpression EOF )
            // InternalRuleEngineParser.g:889:2: iv_ruleXOrExpression= ruleXOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOrExpression=ruleXOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOrExpression"


    // $ANTLR start "ruleXOrExpression"
    // InternalRuleEngineParser.g:895:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
    public final EObject ruleXOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:901:2: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
            // InternalRuleEngineParser.g:902:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            {
            // InternalRuleEngineParser.g:902:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
            // InternalRuleEngineParser.g:903:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
            this_XAndExpression_0=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:911:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==VerticalLineVerticalLine) ) {
                    int LA15_2 = input.LA(2);

                    if ( (synpred4_InternalRuleEngineParser()) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // InternalRuleEngineParser.g:912:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    {
            	    // InternalRuleEngineParser.g:912:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
            	    // InternalRuleEngineParser.g:913:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
            	    {
            	    // InternalRuleEngineParser.g:923:5: ( () ( ( ruleOpOr ) ) )
            	    // InternalRuleEngineParser.g:924:6: () ( ( ruleOpOr ) )
            	    {
            	    // InternalRuleEngineParser.g:924:6: ()
            	    // InternalRuleEngineParser.g:925:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalRuleEngineParser.g:931:6: ( ( ruleOpOr ) )
            	    // InternalRuleEngineParser.g:932:7: ( ruleOpOr )
            	    {
            	    // InternalRuleEngineParser.g:932:7: ( ruleOpOr )
            	    // InternalRuleEngineParser.g:933:8: ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXOrExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:949:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
            	    // InternalRuleEngineParser.g:950:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    {
            	    // InternalRuleEngineParser.g:950:5: (lv_rightOperand_3_0= ruleXAndExpression )
            	    // InternalRuleEngineParser.g:951:6: lv_rightOperand_3_0= ruleXAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_rightOperand_3_0=ruleXAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalRuleEngineParser.g:973:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalRuleEngineParser.g:973:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalRuleEngineParser.g:974:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalRuleEngineParser.g:980:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= VerticalLineVerticalLine ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:986:2: (kw= VerticalLineVerticalLine )
            // InternalRuleEngineParser.g:987:2: kw= VerticalLineVerticalLine
            {
            kw=(Token)match(input,VerticalLineVerticalLine,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleXAndExpression"
    // InternalRuleEngineParser.g:995:1: entryRuleXAndExpression returns [EObject current=null] : iv_ruleXAndExpression= ruleXAndExpression EOF ;
    public final EObject entryRuleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAndExpression = null;


        try {
            // InternalRuleEngineParser.g:995:55: (iv_ruleXAndExpression= ruleXAndExpression EOF )
            // InternalRuleEngineParser.g:996:2: iv_ruleXAndExpression= ruleXAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAndExpression=ruleXAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAndExpression"


    // $ANTLR start "ruleXAndExpression"
    // InternalRuleEngineParser.g:1002:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
    public final EObject ruleXAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XEqualityExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1008:2: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
            // InternalRuleEngineParser.g:1009:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            {
            // InternalRuleEngineParser.g:1009:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
            // InternalRuleEngineParser.g:1010:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_XEqualityExpression_0=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XEqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:1018:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==AmpersandAmpersand) ) {
                    int LA16_2 = input.LA(2);

                    if ( (synpred5_InternalRuleEngineParser()) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // InternalRuleEngineParser.g:1019:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    {
            	    // InternalRuleEngineParser.g:1019:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
            	    // InternalRuleEngineParser.g:1020:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1030:5: ( () ( ( ruleOpAnd ) ) )
            	    // InternalRuleEngineParser.g:1031:6: () ( ( ruleOpAnd ) )
            	    {
            	    // InternalRuleEngineParser.g:1031:6: ()
            	    // InternalRuleEngineParser.g:1032:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalRuleEngineParser.g:1038:6: ( ( ruleOpAnd ) )
            	    // InternalRuleEngineParser.g:1039:7: ( ruleOpAnd )
            	    {
            	    // InternalRuleEngineParser.g:1039:7: ( ruleOpAnd )
            	    // InternalRuleEngineParser.g:1040:8: ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXAndExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:1056:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
            	    // InternalRuleEngineParser.g:1057:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    {
            	    // InternalRuleEngineParser.g:1057:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
            	    // InternalRuleEngineParser.g:1058:6: lv_rightOperand_3_0= ruleXEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_rightOperand_3_0=ruleXEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalRuleEngineParser.g:1080:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalRuleEngineParser.g:1080:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalRuleEngineParser.g:1081:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalRuleEngineParser.g:1087:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= AmpersandAmpersand ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1093:2: (kw= AmpersandAmpersand )
            // InternalRuleEngineParser.g:1094:2: kw= AmpersandAmpersand
            {
            kw=(Token)match(input,AmpersandAmpersand,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleXEqualityExpression"
    // InternalRuleEngineParser.g:1102:1: entryRuleXEqualityExpression returns [EObject current=null] : iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
    public final EObject entryRuleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEqualityExpression = null;


        try {
            // InternalRuleEngineParser.g:1102:60: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
            // InternalRuleEngineParser.g:1103:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXEqualityExpression=ruleXEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXEqualityExpression"


    // $ANTLR start "ruleXEqualityExpression"
    // InternalRuleEngineParser.g:1109:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
    public final EObject ruleXEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XRelationalExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1115:2: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
            // InternalRuleEngineParser.g:1116:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            {
            // InternalRuleEngineParser.g:1116:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
            // InternalRuleEngineParser.g:1117:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_XRelationalExpression_0=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XRelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:1125:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case EqualsSignEqualsSign:
                    {
                    int LA17_2 = input.LA(2);

                    if ( (synpred6_InternalRuleEngineParser()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case ExclamationMarkEqualsSign:
                    {
                    int LA17_3 = input.LA(2);

                    if ( (synpred6_InternalRuleEngineParser()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case EqualsSignEqualsSignEqualsSign:
                    {
                    int LA17_4 = input.LA(2);

                    if ( (synpred6_InternalRuleEngineParser()) ) {
                        alt17=1;
                    }


                    }
                    break;
                case ExclamationMarkEqualsSignEqualsSign:
                    {
                    int LA17_5 = input.LA(2);

                    if ( (synpred6_InternalRuleEngineParser()) ) {
                        alt17=1;
                    }


                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // InternalRuleEngineParser.g:1126:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    {
            	    // InternalRuleEngineParser.g:1126:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
            	    // InternalRuleEngineParser.g:1127:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1137:5: ( () ( ( ruleOpEquality ) ) )
            	    // InternalRuleEngineParser.g:1138:6: () ( ( ruleOpEquality ) )
            	    {
            	    // InternalRuleEngineParser.g:1138:6: ()
            	    // InternalRuleEngineParser.g:1139:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalRuleEngineParser.g:1145:6: ( ( ruleOpEquality ) )
            	    // InternalRuleEngineParser.g:1146:7: ( ruleOpEquality )
            	    {
            	    // InternalRuleEngineParser.g:1146:7: ( ruleOpEquality )
            	    // InternalRuleEngineParser.g:1147:8: ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXEqualityExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:1163:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
            	    // InternalRuleEngineParser.g:1164:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    {
            	    // InternalRuleEngineParser.g:1164:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
            	    // InternalRuleEngineParser.g:1165:6: lv_rightOperand_3_0= ruleXRelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_rightOperand_3_0=ruleXRelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalRuleEngineParser.g:1187:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalRuleEngineParser.g:1187:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalRuleEngineParser.g:1188:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalRuleEngineParser.g:1194:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1200:2: ( (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign ) )
            // InternalRuleEngineParser.g:1201:2: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign )
            {
            // InternalRuleEngineParser.g:1201:2: (kw= EqualsSignEqualsSign | kw= ExclamationMarkEqualsSign | kw= EqualsSignEqualsSignEqualsSign | kw= ExclamationMarkEqualsSignEqualsSign )
            int alt18=4;
            switch ( input.LA(1) ) {
            case EqualsSignEqualsSign:
                {
                alt18=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt18=2;
                }
                break;
            case EqualsSignEqualsSignEqualsSign:
                {
                alt18=3;
                }
                break;
            case ExclamationMarkEqualsSignEqualsSign:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalRuleEngineParser.g:1202:3: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1208:3: kw= ExclamationMarkEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:1214:3: kw= EqualsSignEqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:1220:3: kw= ExclamationMarkEqualsSignEqualsSign
                    {
                    kw=(Token)match(input,ExclamationMarkEqualsSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleXRelationalExpression"
    // InternalRuleEngineParser.g:1229:1: entryRuleXRelationalExpression returns [EObject current=null] : iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
    public final EObject entryRuleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRelationalExpression = null;


        try {
            // InternalRuleEngineParser.g:1229:62: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
            // InternalRuleEngineParser.g:1230:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXRelationalExpression=ruleXRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXRelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXRelationalExpression"


    // $ANTLR start "ruleXRelationalExpression"
    // InternalRuleEngineParser.g:1236:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
    public final EObject ruleXRelationalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XOtherOperatorExpression_0 = null;

        EObject lv_type_3_0 = null;

        EObject lv_rightOperand_6_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1242:2: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
            // InternalRuleEngineParser.g:1243:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            {
            // InternalRuleEngineParser.g:1243:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
            // InternalRuleEngineParser.g:1244:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XOtherOperatorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:1252:3: ( ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
            loop19:
            do {
                int alt19=3;
                switch ( input.LA(1) ) {
                case LessThanSign:
                    {
                    int LA19_2 = input.LA(2);

                    if ( (synpred8_InternalRuleEngineParser()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case GreaterThanSign:
                    {
                    int LA19_3 = input.LA(2);

                    if ( (synpred8_InternalRuleEngineParser()) ) {
                        alt19=2;
                    }


                    }
                    break;
                case Instanceof:
                    {
                    int LA19_4 = input.LA(2);

                    if ( (synpred7_InternalRuleEngineParser()) ) {
                        alt19=1;
                    }


                    }
                    break;
                case GreaterThanSignEqualsSign:
                    {
                    int LA19_5 = input.LA(2);

                    if ( (synpred8_InternalRuleEngineParser()) ) {
                        alt19=2;
                    }


                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // InternalRuleEngineParser.g:1253:4: ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1253:4: ( ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
            	    // InternalRuleEngineParser.g:1254:5: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // InternalRuleEngineParser.g:1254:5: ( ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof ) )
            	    // InternalRuleEngineParser.g:1255:6: ( ( () Instanceof ) )=> ( () otherlv_2= Instanceof )
            	    {
            	    // InternalRuleEngineParser.g:1261:6: ( () otherlv_2= Instanceof )
            	    // InternalRuleEngineParser.g:1262:7: () otherlv_2= Instanceof
            	    {
            	    // InternalRuleEngineParser.g:1262:7: ()
            	    // InternalRuleEngineParser.g:1263:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    otherlv_2=(Token)match(input,Instanceof,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
            	      						
            	    }

            	    }


            	    }

            	    // InternalRuleEngineParser.g:1275:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // InternalRuleEngineParser.g:1276:6: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // InternalRuleEngineParser.g:1276:6: (lv_type_3_0= ruleJvmTypeReference )
            	    // InternalRuleEngineParser.g:1277:7: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"type",
            	      								lv_type_3_0,
            	      								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRuleEngineParser.g:1296:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1296:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
            	    // InternalRuleEngineParser.g:1297:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    {
            	    // InternalRuleEngineParser.g:1297:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
            	    // InternalRuleEngineParser.g:1298:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1308:6: ( () ( ( ruleOpCompare ) ) )
            	    // InternalRuleEngineParser.g:1309:7: () ( ( ruleOpCompare ) )
            	    {
            	    // InternalRuleEngineParser.g:1309:7: ()
            	    // InternalRuleEngineParser.g:1310:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    // InternalRuleEngineParser.g:1316:7: ( ( ruleOpCompare ) )
            	    // InternalRuleEngineParser.g:1317:8: ( ruleOpCompare )
            	    {
            	    // InternalRuleEngineParser.g:1317:8: ( ruleOpCompare )
            	    // InternalRuleEngineParser.g:1318:9: ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (current==null) {
            	      										current = createModelElement(grammarAccess.getXRelationalExpressionRule());
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
            	      								
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									afterParserOrEnumRuleCall();
            	      								
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:1334:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
            	    // InternalRuleEngineParser.g:1335:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    {
            	    // InternalRuleEngineParser.g:1335:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
            	    // InternalRuleEngineParser.g:1336:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_rightOperand_6_0=ruleXOtherOperatorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rightOperand",
            	      								lv_rightOperand_6_0,
            	      								"org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXRelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalRuleEngineParser.g:1359:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalRuleEngineParser.g:1359:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalRuleEngineParser.g:1360:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalRuleEngineParser.g:1366:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSignEqualsSign | (kw= LessThanSign kw= EqualsSign ) | kw= GreaterThanSign | kw= LessThanSign ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1372:2: ( (kw= GreaterThanSignEqualsSign | (kw= LessThanSign kw= EqualsSign ) | kw= GreaterThanSign | kw= LessThanSign ) )
            // InternalRuleEngineParser.g:1373:2: (kw= GreaterThanSignEqualsSign | (kw= LessThanSign kw= EqualsSign ) | kw= GreaterThanSign | kw= LessThanSign )
            {
            // InternalRuleEngineParser.g:1373:2: (kw= GreaterThanSignEqualsSign | (kw= LessThanSign kw= EqualsSign ) | kw= GreaterThanSign | kw= LessThanSign )
            int alt20=4;
            switch ( input.LA(1) ) {
            case GreaterThanSignEqualsSign:
                {
                alt20=1;
                }
                break;
            case LessThanSign:
                {
                int LA20_2 = input.LA(2);

                if ( (LA20_2==EOF||LA20_2==Synchronized||LA20_2==Extension||LA20_2==Extends||(LA20_2>=Import && LA20_2<=Typeof)||(LA20_2>=False && LA20_2<=While)||LA20_2==Null||LA20_2==True||(LA20_2>=For && LA20_2<=Try)||(LA20_2>=Do && LA20_2<=If)||(LA20_2>=ExclamationMark && LA20_2<=NumberSign)||LA20_2==LeftParenthesis||LA20_2==PlusSign||LA20_2==HyphenMinus||LA20_2==LessThanSign||LA20_2==LeftSquareBracket||LA20_2==RULE_BEGIN||(LA20_2>=RULE_HEX && LA20_2<=RULE_STRING)) ) {
                    alt20=4;
                }
                else if ( (LA20_2==EqualsSign) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 2, input);

                    throw nvae;
                }
                }
                break;
            case GreaterThanSign:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalRuleEngineParser.g:1374:3: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1380:3: (kw= LessThanSign kw= EqualsSign )
                    {
                    // InternalRuleEngineParser.g:1380:3: (kw= LessThanSign kw= EqualsSign )
                    // InternalRuleEngineParser.g:1381:4: kw= LessThanSign kw= EqualsSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_22); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    kw=(Token)match(input,EqualsSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:1393:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:1399:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleXOtherOperatorExpression"
    // InternalRuleEngineParser.g:1408:1: entryRuleXOtherOperatorExpression returns [EObject current=null] : iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
    public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXOtherOperatorExpression = null;


        try {
            // InternalRuleEngineParser.g:1408:65: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
            // InternalRuleEngineParser.g:1409:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXOtherOperatorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXOtherOperatorExpression"


    // $ANTLR start "ruleXOtherOperatorExpression"
    // InternalRuleEngineParser.g:1415:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
    public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XAdditiveExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1421:2: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
            // InternalRuleEngineParser.g:1422:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            {
            // InternalRuleEngineParser.g:1422:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
            // InternalRuleEngineParser.g:1423:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_XAdditiveExpression_0=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XAdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:1431:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
            loop21:
            do {
                int alt21=2;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // InternalRuleEngineParser.g:1432:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    {
            	    // InternalRuleEngineParser.g:1432:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
            	    // InternalRuleEngineParser.g:1433:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1443:5: ( () ( ( ruleOpOther ) ) )
            	    // InternalRuleEngineParser.g:1444:6: () ( ( ruleOpOther ) )
            	    {
            	    // InternalRuleEngineParser.g:1444:6: ()
            	    // InternalRuleEngineParser.g:1445:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalRuleEngineParser.g:1451:6: ( ( ruleOpOther ) )
            	    // InternalRuleEngineParser.g:1452:7: ( ruleOpOther )
            	    {
            	    // InternalRuleEngineParser.g:1452:7: ( ruleOpOther )
            	    // InternalRuleEngineParser.g:1453:8: ruleOpOther
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpOther();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:1469:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
            	    // InternalRuleEngineParser.g:1470:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    {
            	    // InternalRuleEngineParser.g:1470:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
            	    // InternalRuleEngineParser.g:1471:6: lv_rightOperand_3_0= ruleXAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_rightOperand_3_0=ruleXAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXOtherOperatorExpression"


    // $ANTLR start "entryRuleOpOther"
    // InternalRuleEngineParser.g:1493:1: entryRuleOpOther returns [String current=null] : iv_ruleOpOther= ruleOpOther EOF ;
    public final String entryRuleOpOther() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOther = null;


        try {
            // InternalRuleEngineParser.g:1493:47: (iv_ruleOpOther= ruleOpOther EOF )
            // InternalRuleEngineParser.g:1494:2: iv_ruleOpOther= ruleOpOther EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOtherRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOther=ruleOpOther();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOther.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOther"


    // $ANTLR start "ruleOpOther"
    // InternalRuleEngineParser.g:1500:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= HyphenMinusGreaterThanSign | kw= FullStopFullStopLessThanSign | (kw= GreaterThanSign kw= FullStopFullStop ) | kw= FullStopFullStop | kw= EqualsSignGreaterThanSign | (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) ) | (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) ) | kw= LessThanSignGreaterThanSign | kw= QuestionMarkColon ) ;
    public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1506:2: ( (kw= HyphenMinusGreaterThanSign | kw= FullStopFullStopLessThanSign | (kw= GreaterThanSign kw= FullStopFullStop ) | kw= FullStopFullStop | kw= EqualsSignGreaterThanSign | (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) ) | (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) ) | kw= LessThanSignGreaterThanSign | kw= QuestionMarkColon ) )
            // InternalRuleEngineParser.g:1507:2: (kw= HyphenMinusGreaterThanSign | kw= FullStopFullStopLessThanSign | (kw= GreaterThanSign kw= FullStopFullStop ) | kw= FullStopFullStop | kw= EqualsSignGreaterThanSign | (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) ) | (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) ) | kw= LessThanSignGreaterThanSign | kw= QuestionMarkColon )
            {
            // InternalRuleEngineParser.g:1507:2: (kw= HyphenMinusGreaterThanSign | kw= FullStopFullStopLessThanSign | (kw= GreaterThanSign kw= FullStopFullStop ) | kw= FullStopFullStop | kw= EqualsSignGreaterThanSign | (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) ) | (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) ) | kw= LessThanSignGreaterThanSign | kw= QuestionMarkColon )
            int alt24=9;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalRuleEngineParser.g:1508:3: kw= HyphenMinusGreaterThanSign
                    {
                    kw=(Token)match(input,HyphenMinusGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1514:3: kw= FullStopFullStopLessThanSign
                    {
                    kw=(Token)match(input,FullStopFullStopLessThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:1520:3: (kw= GreaterThanSign kw= FullStopFullStop )
                    {
                    // InternalRuleEngineParser.g:1520:3: (kw= GreaterThanSign kw= FullStopFullStop )
                    // InternalRuleEngineParser.g:1521:4: kw= GreaterThanSign kw= FullStopFullStop
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0());
                      			
                    }
                    kw=(Token)match(input,FullStopFullStop,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:1533:3: kw= FullStopFullStop
                    {
                    kw=(Token)match(input,FullStopFullStop,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRuleEngineParser.g:1539:3: kw= EqualsSignGreaterThanSign
                    {
                    kw=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRuleEngineParser.g:1545:3: (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) )
                    {
                    // InternalRuleEngineParser.g:1545:3: (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) )
                    // InternalRuleEngineParser.g:1546:4: kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign )
                    {
                    kw=(Token)match(input,GreaterThanSign,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
                      			
                    }
                    // InternalRuleEngineParser.g:1551:4: ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==GreaterThanSign) ) {
                        int LA22_1 = input.LA(2);

                        if ( (LA22_1==GreaterThanSign) && (synpred10_InternalRuleEngineParser())) {
                            alt22=1;
                        }
                        else if ( (LA22_1==EOF||LA22_1==Synchronized||LA22_1==Extension||LA22_1==Extends||(LA22_1>=Import && LA22_1<=Typeof)||(LA22_1>=False && LA22_1<=While)||LA22_1==Null||LA22_1==True||(LA22_1>=For && LA22_1<=Try)||(LA22_1>=Do && LA22_1<=If)||(LA22_1>=ExclamationMark && LA22_1<=NumberSign)||LA22_1==LeftParenthesis||LA22_1==PlusSign||LA22_1==HyphenMinus||LA22_1==LessThanSign||LA22_1==LeftSquareBracket||LA22_1==RULE_BEGIN||(LA22_1>=RULE_HEX && LA22_1<=RULE_STRING)) ) {
                            alt22=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 22, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalRuleEngineParser.g:1552:5: ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) )
                            {
                            // InternalRuleEngineParser.g:1552:5: ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) )
                            // InternalRuleEngineParser.g:1553:6: ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign )
                            {
                            // InternalRuleEngineParser.g:1558:6: (kw= GreaterThanSign kw= GreaterThanSign )
                            // InternalRuleEngineParser.g:1559:7: kw= GreaterThanSign kw= GreaterThanSign
                            {
                            kw=(Token)match(input,GreaterThanSign,FOLLOW_33); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRuleEngineParser.g:1572:5: kw= GreaterThanSign
                            {
                            kw=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalRuleEngineParser.g:1580:3: (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) )
                    {
                    // InternalRuleEngineParser.g:1580:3: (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) )
                    // InternalRuleEngineParser.g:1581:4: kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign )
                    {
                    kw=(Token)match(input,LessThanSign,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0());
                      			
                    }
                    // InternalRuleEngineParser.g:1586:4: ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign )
                    int alt23=3;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==LessThanSign) ) {
                        int LA23_1 = input.LA(2);

                        if ( (synpred11_InternalRuleEngineParser()) ) {
                            alt23=1;
                        }
                        else if ( (true) ) {
                            alt23=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 23, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA23_0==EqualsSignGreaterThanSign) ) {
                        alt23=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalRuleEngineParser.g:1587:5: ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) )
                            {
                            // InternalRuleEngineParser.g:1587:5: ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) )
                            // InternalRuleEngineParser.g:1588:6: ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign )
                            {
                            // InternalRuleEngineParser.g:1593:6: (kw= LessThanSign kw= LessThanSign )
                            // InternalRuleEngineParser.g:1594:7: kw= LessThanSign kw= LessThanSign
                            {
                            kw=(Token)match(input,LessThanSign,FOLLOW_24); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0());
                              						
                            }
                            kw=(Token)match(input,LessThanSign,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							current.merge(kw);
                              							newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1());
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRuleEngineParser.g:1607:5: kw= LessThanSign
                            {
                            kw=(Token)match(input,LessThanSign,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalRuleEngineParser.g:1613:5: kw= EqualsSignGreaterThanSign
                            {
                            kw=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalRuleEngineParser.g:1621:3: kw= LessThanSignGreaterThanSign
                    {
                    kw=(Token)match(input,LessThanSignGreaterThanSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalRuleEngineParser.g:1627:3: kw= QuestionMarkColon
                    {
                    kw=(Token)match(input,QuestionMarkColon,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpOther"


    // $ANTLR start "entryRuleXAdditiveExpression"
    // InternalRuleEngineParser.g:1636:1: entryRuleXAdditiveExpression returns [EObject current=null] : iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
    public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAdditiveExpression = null;


        try {
            // InternalRuleEngineParser.g:1636:60: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
            // InternalRuleEngineParser.g:1637:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXAdditiveExpression=ruleXAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXAdditiveExpression"


    // $ANTLR start "ruleXAdditiveExpression"
    // InternalRuleEngineParser.g:1643:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleXAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XMultiplicativeExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1649:2: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
            // InternalRuleEngineParser.g:1650:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            {
            // InternalRuleEngineParser.g:1650:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
            // InternalRuleEngineParser.g:1651:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:1659:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PlusSign) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred12_InternalRuleEngineParser()) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==HyphenMinus) ) {
                    int LA25_3 = input.LA(2);

                    if ( (synpred12_InternalRuleEngineParser()) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // InternalRuleEngineParser.g:1660:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    {
            	    // InternalRuleEngineParser.g:1660:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
            	    // InternalRuleEngineParser.g:1661:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1671:5: ( () ( ( ruleOpAdd ) ) )
            	    // InternalRuleEngineParser.g:1672:6: () ( ( ruleOpAdd ) )
            	    {
            	    // InternalRuleEngineParser.g:1672:6: ()
            	    // InternalRuleEngineParser.g:1673:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalRuleEngineParser.g:1679:6: ( ( ruleOpAdd ) )
            	    // InternalRuleEngineParser.g:1680:7: ( ruleOpAdd )
            	    {
            	    // InternalRuleEngineParser.g:1680:7: ( ruleOpAdd )
            	    // InternalRuleEngineParser.g:1681:8: ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:1697:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
            	    // InternalRuleEngineParser.g:1698:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    {
            	    // InternalRuleEngineParser.g:1698:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
            	    // InternalRuleEngineParser.g:1699:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_rightOperand_3_0=ruleXMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalRuleEngineParser.g:1721:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalRuleEngineParser.g:1721:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalRuleEngineParser.g:1722:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalRuleEngineParser.g:1728:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1734:2: ( (kw= PlusSign | kw= HyphenMinus ) )
            // InternalRuleEngineParser.g:1735:2: (kw= PlusSign | kw= HyphenMinus )
            {
            // InternalRuleEngineParser.g:1735:2: (kw= PlusSign | kw= HyphenMinus )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==PlusSign) ) {
                alt26=1;
            }
            else if ( (LA26_0==HyphenMinus) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalRuleEngineParser.g:1736:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1742:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleXMultiplicativeExpression"
    // InternalRuleEngineParser.g:1751:1: entryRuleXMultiplicativeExpression returns [EObject current=null] : iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
    public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMultiplicativeExpression = null;


        try {
            // InternalRuleEngineParser.g:1751:66: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
            // InternalRuleEngineParser.g:1752:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMultiplicativeExpression"


    // $ANTLR start "ruleXMultiplicativeExpression"
    // InternalRuleEngineParser.g:1758:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
    public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XUnaryOperation_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1764:2: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
            // InternalRuleEngineParser.g:1765:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            {
            // InternalRuleEngineParser.g:1765:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
            // InternalRuleEngineParser.g:1766:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_XUnaryOperation_0=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XUnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:1774:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
            loop27:
            do {
                int alt27=2;
                switch ( input.LA(1) ) {
                case Asterisk:
                    {
                    int LA27_2 = input.LA(2);

                    if ( (synpred13_InternalRuleEngineParser()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case AsteriskAsterisk:
                    {
                    int LA27_3 = input.LA(2);

                    if ( (synpred13_InternalRuleEngineParser()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case Solidus:
                    {
                    int LA27_4 = input.LA(2);

                    if ( (synpred13_InternalRuleEngineParser()) ) {
                        alt27=1;
                    }


                    }
                    break;
                case PercentSign:
                    {
                    int LA27_5 = input.LA(2);

                    if ( (synpred13_InternalRuleEngineParser()) ) {
                        alt27=1;
                    }


                    }
                    break;

                }

                switch (alt27) {
            	case 1 :
            	    // InternalRuleEngineParser.g:1775:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    {
            	    // InternalRuleEngineParser.g:1775:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
            	    // InternalRuleEngineParser.g:1776:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
            	    {
            	    // InternalRuleEngineParser.g:1786:5: ( () ( ( ruleOpMulti ) ) )
            	    // InternalRuleEngineParser.g:1787:6: () ( ( ruleOpMulti ) )
            	    {
            	    // InternalRuleEngineParser.g:1787:6: ()
            	    // InternalRuleEngineParser.g:1788:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalRuleEngineParser.g:1794:6: ( ( ruleOpMulti ) )
            	    // InternalRuleEngineParser.g:1795:7: ( ruleOpMulti )
            	    {
            	    // InternalRuleEngineParser.g:1795:7: ( ruleOpMulti )
            	    // InternalRuleEngineParser.g:1796:8: ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
            	      								}
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:1812:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
            	    // InternalRuleEngineParser.g:1813:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    {
            	    // InternalRuleEngineParser.g:1813:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
            	    // InternalRuleEngineParser.g:1814:6: lv_rightOperand_3_0= ruleXUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_rightOperand_3_0=ruleXUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalRuleEngineParser.g:1836:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalRuleEngineParser.g:1836:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalRuleEngineParser.g:1837:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalRuleEngineParser.g:1843:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Asterisk | kw= AsteriskAsterisk | kw= Solidus | kw= PercentSign ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1849:2: ( (kw= Asterisk | kw= AsteriskAsterisk | kw= Solidus | kw= PercentSign ) )
            // InternalRuleEngineParser.g:1850:2: (kw= Asterisk | kw= AsteriskAsterisk | kw= Solidus | kw= PercentSign )
            {
            // InternalRuleEngineParser.g:1850:2: (kw= Asterisk | kw= AsteriskAsterisk | kw= Solidus | kw= PercentSign )
            int alt28=4;
            switch ( input.LA(1) ) {
            case Asterisk:
                {
                alt28=1;
                }
                break;
            case AsteriskAsterisk:
                {
                alt28=2;
                }
                break;
            case Solidus:
                {
                alt28=3;
                }
                break;
            case PercentSign:
                {
                alt28=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalRuleEngineParser.g:1851:3: kw= Asterisk
                    {
                    kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1857:3: kw= AsteriskAsterisk
                    {
                    kw=(Token)match(input,AsteriskAsterisk,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:1863:3: kw= Solidus
                    {
                    kw=(Token)match(input,Solidus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:1869:3: kw= PercentSign
                    {
                    kw=(Token)match(input,PercentSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleXUnaryOperation"
    // InternalRuleEngineParser.g:1878:1: entryRuleXUnaryOperation returns [EObject current=null] : iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
    public final EObject entryRuleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnaryOperation = null;


        try {
            // InternalRuleEngineParser.g:1878:56: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
            // InternalRuleEngineParser.g:1879:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXUnaryOperation=ruleXUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXUnaryOperation"


    // $ANTLR start "ruleXUnaryOperation"
    // InternalRuleEngineParser.g:1885:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) ;
    public final EObject ruleXUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_2_0 = null;

        EObject this_XCastedExpression_3 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1891:2: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression ) )
            // InternalRuleEngineParser.g:1892:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            {
            // InternalRuleEngineParser.g:1892:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) | this_XCastedExpression_3= ruleXCastedExpression )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==ExclamationMark||LA29_0==PlusSign||LA29_0==HyphenMinus) ) {
                alt29=1;
            }
            else if ( (LA29_0==Synchronized||LA29_0==Extension||LA29_0==Extends||(LA29_0>=Import && LA29_0<=Typeof)||(LA29_0>=False && LA29_0<=While)||LA29_0==Null||LA29_0==True||(LA29_0>=For && LA29_0<=Try)||(LA29_0>=Do && LA29_0<=If)||LA29_0==NumberSign||LA29_0==LeftParenthesis||LA29_0==LessThanSign||LA29_0==LeftSquareBracket||LA29_0==RULE_BEGIN||(LA29_0>=RULE_HEX && LA29_0<=RULE_STRING)) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalRuleEngineParser.g:1893:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    {
                    // InternalRuleEngineParser.g:1893:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
                    // InternalRuleEngineParser.g:1894:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    {
                    // InternalRuleEngineParser.g:1894:4: ()
                    // InternalRuleEngineParser.g:1895:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalRuleEngineParser.g:1901:4: ( ( ruleOpUnary ) )
                    // InternalRuleEngineParser.g:1902:5: ( ruleOpUnary )
                    {
                    // InternalRuleEngineParser.g:1902:5: ( ruleOpUnary )
                    // InternalRuleEngineParser.g:1903:6: ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXUnaryOperationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_18);
                    ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:1917:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
                    // InternalRuleEngineParser.g:1918:5: (lv_operand_2_0= ruleXUnaryOperation )
                    {
                    // InternalRuleEngineParser.g:1918:5: (lv_operand_2_0= ruleXUnaryOperation )
                    // InternalRuleEngineParser.g:1919:6: lv_operand_2_0= ruleXUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleXUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1938:3: this_XCastedExpression_3= ruleXCastedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCastedExpression_3=ruleXCastedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCastedExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalRuleEngineParser.g:1950:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalRuleEngineParser.g:1950:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalRuleEngineParser.g:1951:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalRuleEngineParser.g:1957:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ExclamationMark | kw= HyphenMinus | kw= PlusSign ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:1963:2: ( (kw= ExclamationMark | kw= HyphenMinus | kw= PlusSign ) )
            // InternalRuleEngineParser.g:1964:2: (kw= ExclamationMark | kw= HyphenMinus | kw= PlusSign )
            {
            // InternalRuleEngineParser.g:1964:2: (kw= ExclamationMark | kw= HyphenMinus | kw= PlusSign )
            int alt30=3;
            switch ( input.LA(1) ) {
            case ExclamationMark:
                {
                alt30=1;
                }
                break;
            case HyphenMinus:
                {
                alt30=2;
                }
                break;
            case PlusSign:
                {
                alt30=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // InternalRuleEngineParser.g:1965:3: kw= ExclamationMark
                    {
                    kw=(Token)match(input,ExclamationMark,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:1971:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:1977:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleXCastedExpression"
    // InternalRuleEngineParser.g:1986:1: entryRuleXCastedExpression returns [EObject current=null] : iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
    public final EObject entryRuleXCastedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCastedExpression = null;


        try {
            // InternalRuleEngineParser.g:1986:58: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
            // InternalRuleEngineParser.g:1987:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCastedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCastedExpression=ruleXCastedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCastedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCastedExpression"


    // $ANTLR start "ruleXCastedExpression"
    // InternalRuleEngineParser.g:1993:1: ruleXCastedExpression returns [EObject current=null] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
    public final EObject ruleXCastedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_XPostfixOperation_0 = null;

        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:1999:2: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
            // InternalRuleEngineParser.g:2000:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            {
            // InternalRuleEngineParser.g:2000:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
            // InternalRuleEngineParser.g:2001:3: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_XPostfixOperation_0=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPostfixOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:2009:3: ( ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==As) ) {
                    int LA31_2 = input.LA(2);

                    if ( (synpred14_InternalRuleEngineParser()) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // InternalRuleEngineParser.g:2010:4: ( ( ( () As ) )=> ( () otherlv_2= As ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    {
            	    // InternalRuleEngineParser.g:2010:4: ( ( ( () As ) )=> ( () otherlv_2= As ) )
            	    // InternalRuleEngineParser.g:2011:5: ( ( () As ) )=> ( () otherlv_2= As )
            	    {
            	    // InternalRuleEngineParser.g:2017:5: ( () otherlv_2= As )
            	    // InternalRuleEngineParser.g:2018:6: () otherlv_2= As
            	    {
            	    // InternalRuleEngineParser.g:2018:6: ()
            	    // InternalRuleEngineParser.g:2019:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    otherlv_2=(Token)match(input,As,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
            	      					
            	    }

            	    }


            	    }

            	    // InternalRuleEngineParser.g:2031:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
            	    // InternalRuleEngineParser.g:2032:5: (lv_type_3_0= ruleJvmTypeReference )
            	    {
            	    // InternalRuleEngineParser.g:2032:5: (lv_type_3_0= ruleJvmTypeReference )
            	    // InternalRuleEngineParser.g:2033:6: lv_type_3_0= ruleJvmTypeReference
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_type_3_0=ruleJvmTypeReference();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"type",
            	      							lv_type_3_0,
            	      							"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXCastedExpression"


    // $ANTLR start "entryRuleXPostfixOperation"
    // InternalRuleEngineParser.g:2055:1: entryRuleXPostfixOperation returns [EObject current=null] : iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
    public final EObject entryRuleXPostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPostfixOperation = null;


        try {
            // InternalRuleEngineParser.g:2055:58: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
            // InternalRuleEngineParser.g:2056:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPostfixOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPostfixOperation=ruleXPostfixOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPostfixOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPostfixOperation"


    // $ANTLR start "ruleXPostfixOperation"
    // InternalRuleEngineParser.g:2062:1: ruleXPostfixOperation returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
    public final EObject ruleXPostfixOperation() throws RecognitionException {
        EObject current = null;

        EObject this_XMemberFeatureCall_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2068:2: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
            // InternalRuleEngineParser.g:2069:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            {
            // InternalRuleEngineParser.g:2069:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
            // InternalRuleEngineParser.g:2070:3: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_XMemberFeatureCall_0=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XMemberFeatureCall_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:2078:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==PlusSignPlusSign) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred15_InternalRuleEngineParser()) ) {
                    alt32=1;
                }
            }
            else if ( (LA32_0==HyphenMinusHyphenMinus) ) {
                int LA32_2 = input.LA(2);

                if ( (synpred15_InternalRuleEngineParser()) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalRuleEngineParser.g:2079:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
                    {
                    // InternalRuleEngineParser.g:2089:4: ( () ( ( ruleOpPostfix ) ) )
                    // InternalRuleEngineParser.g:2090:5: () ( ( ruleOpPostfix ) )
                    {
                    // InternalRuleEngineParser.g:2090:5: ()
                    // InternalRuleEngineParser.g:2091:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElementAndSet(
                      							grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalRuleEngineParser.g:2097:5: ( ( ruleOpPostfix ) )
                    // InternalRuleEngineParser.g:2098:6: ( ruleOpPostfix )
                    {
                    // InternalRuleEngineParser.g:2098:6: ( ruleOpPostfix )
                    // InternalRuleEngineParser.g:2099:7: ruleOpPostfix
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXPostfixOperationRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    ruleOpPostfix();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXPostfixOperation"


    // $ANTLR start "entryRuleOpPostfix"
    // InternalRuleEngineParser.g:2119:1: entryRuleOpPostfix returns [String current=null] : iv_ruleOpPostfix= ruleOpPostfix EOF ;
    public final String entryRuleOpPostfix() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpPostfix = null;


        try {
            // InternalRuleEngineParser.g:2119:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
            // InternalRuleEngineParser.g:2120:2: iv_ruleOpPostfix= ruleOpPostfix EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpPostfixRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpPostfix=ruleOpPostfix();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpPostfix.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpPostfix"


    // $ANTLR start "ruleOpPostfix"
    // InternalRuleEngineParser.g:2126:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSignPlusSign | kw= HyphenMinusHyphenMinus ) ;
    public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:2132:2: ( (kw= PlusSignPlusSign | kw= HyphenMinusHyphenMinus ) )
            // InternalRuleEngineParser.g:2133:2: (kw= PlusSignPlusSign | kw= HyphenMinusHyphenMinus )
            {
            // InternalRuleEngineParser.g:2133:2: (kw= PlusSignPlusSign | kw= HyphenMinusHyphenMinus )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==PlusSignPlusSign) ) {
                alt33=1;
            }
            else if ( (LA33_0==HyphenMinusHyphenMinus) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalRuleEngineParser.g:2134:3: kw= PlusSignPlusSign
                    {
                    kw=(Token)match(input,PlusSignPlusSign,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:2140:3: kw= HyphenMinusHyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinusHyphenMinus,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpPostfix"


    // $ANTLR start "entryRuleXMemberFeatureCall"
    // InternalRuleEngineParser.g:2149:1: entryRuleXMemberFeatureCall returns [EObject current=null] : iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
    public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXMemberFeatureCall = null;


        try {
            // InternalRuleEngineParser.g:2149:59: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
            // InternalRuleEngineParser.g:2150:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXMemberFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXMemberFeatureCall"


    // $ANTLR start "ruleXMemberFeatureCall"
    // InternalRuleEngineParser.g:2156:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
    public final EObject ruleXMemberFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitStatic_3_0=null;
        Token otherlv_8=null;
        Token lv_nullSafe_9_0=null;
        Token lv_explicitStatic_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token lv_explicitOperationCall_17_0=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject this_XPrimaryExpression_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_typeArguments_12_0 = null;

        EObject lv_typeArguments_14_0 = null;

        EObject lv_memberCallArguments_18_0 = null;

        EObject lv_memberCallArguments_19_0 = null;

        EObject lv_memberCallArguments_21_0 = null;

        EObject lv_memberCallArguments_23_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2162:2: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
            // InternalRuleEngineParser.g:2163:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            {
            // InternalRuleEngineParser.g:2163:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
            // InternalRuleEngineParser.g:2164:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_XPrimaryExpression_0=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XPrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:2172:3: ( ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
            loop42:
            do {
                int alt42=3;
                switch ( input.LA(1) ) {
                case FullStop:
                    {
                    int LA42_2 = input.LA(2);

                    if ( (synpred16_InternalRuleEngineParser()) ) {
                        alt42=1;
                    }
                    else if ( (synpred17_InternalRuleEngineParser()) ) {
                        alt42=2;
                    }


                    }
                    break;
                case ColonColon:
                    {
                    int LA42_3 = input.LA(2);

                    if ( (synpred16_InternalRuleEngineParser()) ) {
                        alt42=1;
                    }
                    else if ( (synpred17_InternalRuleEngineParser()) ) {
                        alt42=2;
                    }


                    }
                    break;
                case QuestionMarkFullStop:
                    {
                    int LA42_4 = input.LA(2);

                    if ( (synpred17_InternalRuleEngineParser()) ) {
                        alt42=2;
                    }


                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // InternalRuleEngineParser.g:2173:4: ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    {
            	    // InternalRuleEngineParser.g:2173:4: ( ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
            	    // InternalRuleEngineParser.g:2174:5: ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
            	    {
            	    // InternalRuleEngineParser.g:2174:5: ( ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
            	    // InternalRuleEngineParser.g:2175:6: ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    {
            	    // InternalRuleEngineParser.g:2195:6: ( () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
            	    // InternalRuleEngineParser.g:2196:7: () (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
            	    {
            	    // InternalRuleEngineParser.g:2196:7: ()
            	    // InternalRuleEngineParser.g:2197:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    // InternalRuleEngineParser.g:2203:7: (otherlv_2= FullStop | ( (lv_explicitStatic_3_0= ColonColon ) ) )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==FullStop) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==ColonColon) ) {
            	        alt34=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:2204:8: otherlv_2= FullStop
            	            {
            	            otherlv_2=(Token)match(input,FullStop,FOLLOW_40); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalRuleEngineParser.g:2209:8: ( (lv_explicitStatic_3_0= ColonColon ) )
            	            {
            	            // InternalRuleEngineParser.g:2209:8: ( (lv_explicitStatic_3_0= ColonColon ) )
            	            // InternalRuleEngineParser.g:2210:9: (lv_explicitStatic_3_0= ColonColon )
            	            {
            	            // InternalRuleEngineParser.g:2210:9: (lv_explicitStatic_3_0= ColonColon )
            	            // InternalRuleEngineParser.g:2211:10: lv_explicitStatic_3_0= ColonColon
            	            {
            	            lv_explicitStatic_3_0=(Token)match(input,ColonColon,FOLLOW_40); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_explicitStatic_3_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "explicitStatic", true, "::");
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalRuleEngineParser.g:2224:7: ( ( ruleFeatureCallID ) )
            	    // InternalRuleEngineParser.g:2225:8: ( ruleFeatureCallID )
            	    {
            	    // InternalRuleEngineParser.g:2225:8: ( ruleFeatureCallID )
            	    // InternalRuleEngineParser.g:2226:9: ruleFeatureCallID
            	    {
            	    if ( state.backtracking==0 ) {

            	      									if (current==null) {
            	      										current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      									}
            	      								
            	    }
            	    if ( state.backtracking==0 ) {

            	      									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0());
            	      								
            	    }
            	    pushFollow(FOLLOW_22);
            	    ruleFeatureCallID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      									afterParserOrEnumRuleCall();
            	      								
            	    }

            	    }


            	    }

            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3());
            	      						
            	    }
            	    pushFollow(FOLLOW_18);
            	    ruleOpSingleAssign();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalRuleEngineParser.g:2249:5: ( (lv_value_6_0= ruleXAssignment ) )
            	    // InternalRuleEngineParser.g:2250:6: (lv_value_6_0= ruleXAssignment )
            	    {
            	    // InternalRuleEngineParser.g:2250:6: (lv_value_6_0= ruleXAssignment )
            	    // InternalRuleEngineParser.g:2251:7: lv_value_6_0= ruleXAssignment
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_value_6_0=ruleXAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	      							}
            	      							set(
            	      								current,
            	      								"value",
            	      								lv_value_6_0,
            	      								"org.eclipse.xtext.xbase.Xbase.XAssignment");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRuleEngineParser.g:2270:4: ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    {
            	    // InternalRuleEngineParser.g:2270:4: ( ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
            	    // InternalRuleEngineParser.g:2271:5: ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) ) (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    {
            	    // InternalRuleEngineParser.g:2271:5: ( ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) ) )
            	    // InternalRuleEngineParser.g:2272:6: ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )=> ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) )
            	    {
            	    // InternalRuleEngineParser.g:2292:6: ( () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) ) )
            	    // InternalRuleEngineParser.g:2293:7: () (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) )
            	    {
            	    // InternalRuleEngineParser.g:2293:7: ()
            	    // InternalRuleEngineParser.g:2294:8: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      								current = forceCreateModelElementAndSet(
            	      									grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
            	      									current);
            	      							
            	    }

            	    }

            	    // InternalRuleEngineParser.g:2300:7: (otherlv_8= FullStop | ( (lv_nullSafe_9_0= QuestionMarkFullStop ) ) | ( (lv_explicitStatic_10_0= ColonColon ) ) )
            	    int alt35=3;
            	    switch ( input.LA(1) ) {
            	    case FullStop:
            	        {
            	        alt35=1;
            	        }
            	        break;
            	    case QuestionMarkFullStop:
            	        {
            	        alt35=2;
            	        }
            	        break;
            	    case ColonColon:
            	        {
            	        alt35=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt35) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:2301:8: otherlv_8= FullStop
            	            {
            	            otherlv_8=(Token)match(input,FullStop,FOLLOW_41); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalRuleEngineParser.g:2306:8: ( (lv_nullSafe_9_0= QuestionMarkFullStop ) )
            	            {
            	            // InternalRuleEngineParser.g:2306:8: ( (lv_nullSafe_9_0= QuestionMarkFullStop ) )
            	            // InternalRuleEngineParser.g:2307:9: (lv_nullSafe_9_0= QuestionMarkFullStop )
            	            {
            	            // InternalRuleEngineParser.g:2307:9: (lv_nullSafe_9_0= QuestionMarkFullStop )
            	            // InternalRuleEngineParser.g:2308:10: lv_nullSafe_9_0= QuestionMarkFullStop
            	            {
            	            lv_nullSafe_9_0=(Token)match(input,QuestionMarkFullStop,FOLLOW_41); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_nullSafe_9_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "nullSafe", true, "?.");
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalRuleEngineParser.g:2321:8: ( (lv_explicitStatic_10_0= ColonColon ) )
            	            {
            	            // InternalRuleEngineParser.g:2321:8: ( (lv_explicitStatic_10_0= ColonColon ) )
            	            // InternalRuleEngineParser.g:2322:9: (lv_explicitStatic_10_0= ColonColon )
            	            {
            	            // InternalRuleEngineParser.g:2322:9: (lv_explicitStatic_10_0= ColonColon )
            	            // InternalRuleEngineParser.g:2323:10: lv_explicitStatic_10_0= ColonColon
            	            {
            	            lv_explicitStatic_10_0=(Token)match(input,ColonColon,FOLLOW_41); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_explicitStatic_10_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "explicitStatic", true, "::");
            	              									
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalRuleEngineParser.g:2338:5: (otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign )?
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==LessThanSign) ) {
            	        alt37=1;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:2339:6: otherlv_11= LessThanSign ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= GreaterThanSign
            	            {
            	            otherlv_11=(Token)match(input,LessThanSign,FOLLOW_42); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
            	              					
            	            }
            	            // InternalRuleEngineParser.g:2343:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
            	            // InternalRuleEngineParser.g:2344:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            {
            	            // InternalRuleEngineParser.g:2344:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
            	            // InternalRuleEngineParser.g:2345:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
            	            {
            	            if ( state.backtracking==0 ) {

            	              								newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0());
            	              							
            	            }
            	            pushFollow(FOLLOW_43);
            	            lv_typeArguments_12_0=ruleJvmArgumentTypeReference();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              								}
            	              								add(
            	              									current,
            	              									"typeArguments",
            	              									lv_typeArguments_12_0,
            	              									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
            	              								afterParserOrEnumRuleCall();
            	              							
            	            }

            	            }


            	            }

            	            // InternalRuleEngineParser.g:2362:6: (otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
            	            loop36:
            	            do {
            	                int alt36=2;
            	                int LA36_0 = input.LA(1);

            	                if ( (LA36_0==Comma) ) {
            	                    alt36=1;
            	                }


            	                switch (alt36) {
            	            	case 1 :
            	            	    // InternalRuleEngineParser.g:2363:7: otherlv_13= Comma ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    {
            	            	    otherlv_13=(Token)match(input,Comma,FOLLOW_42); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      							newLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
            	            	      						
            	            	    }
            	            	    // InternalRuleEngineParser.g:2367:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
            	            	    // InternalRuleEngineParser.g:2368:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    {
            	            	    // InternalRuleEngineParser.g:2368:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
            	            	    // InternalRuleEngineParser.g:2369:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0());
            	            	      								
            	            	    }
            	            	    pushFollow(FOLLOW_43);
            	            	    lv_typeArguments_14_0=ruleJvmArgumentTypeReference();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      									if (current==null) {
            	            	      										current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	            	      									}
            	            	      									add(
            	            	      										current,
            	            	      										"typeArguments",
            	            	      										lv_typeArguments_14_0,
            	            	      										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
            	            	      									afterParserOrEnumRuleCall();
            	            	      								
            	            	    }

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop36;
            	                }
            	            } while (true);

            	            otherlv_15=(Token)match(input,GreaterThanSign,FOLLOW_41); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // InternalRuleEngineParser.g:2392:5: ( ( ruleIdOrSuper ) )
            	    // InternalRuleEngineParser.g:2393:6: ( ruleIdOrSuper )
            	    {
            	    // InternalRuleEngineParser.g:2393:6: ( ruleIdOrSuper )
            	    // InternalRuleEngineParser.g:2394:7: ruleIdOrSuper
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	      							}
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_44);
            	    ruleIdOrSuper();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalRuleEngineParser.g:2408:5: ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )?
            	    int alt40=2;
            	    alt40 = dfa40.predict(input);
            	    switch (alt40) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:2409:6: ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis
            	            {
            	            // InternalRuleEngineParser.g:2409:6: ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) )
            	            // InternalRuleEngineParser.g:2410:7: ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis )
            	            {
            	            // InternalRuleEngineParser.g:2414:7: (lv_explicitOperationCall_17_0= LeftParenthesis )
            	            // InternalRuleEngineParser.g:2415:8: lv_explicitOperationCall_17_0= LeftParenthesis
            	            {
            	            lv_explicitOperationCall_17_0=(Token)match(input,LeftParenthesis,FOLLOW_45); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_explicitOperationCall_17_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
            	              								}
            	              								setWithLastConsumed(current, "explicitOperationCall", true, "(");
            	              							
            	            }

            	            }


            	            }

            	            // InternalRuleEngineParser.g:2427:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
            	            int alt39=3;
            	            alt39 = dfa39.predict(input);
            	            switch (alt39) {
            	                case 1 :
            	                    // InternalRuleEngineParser.g:2428:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    {
            	                    // InternalRuleEngineParser.g:2428:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
            	                    // InternalRuleEngineParser.g:2429:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    {
            	                    // InternalRuleEngineParser.g:2454:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
            	                    // InternalRuleEngineParser.g:2455:9: lv_memberCallArguments_18_0= ruleXShortClosure
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_19);
            	                    lv_memberCallArguments_18_0=ruleXShortClosure();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      									}
            	                      									add(
            	                      										current,
            	                      										"memberCallArguments",
            	                      										lv_memberCallArguments_18_0,
            	                      										"org.eclipse.xtext.xbase.Xbase.XShortClosure");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }


            	                    }


            	                    }
            	                    break;
            	                case 2 :
            	                    // InternalRuleEngineParser.g:2473:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    {
            	                    // InternalRuleEngineParser.g:2473:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
            	                    // InternalRuleEngineParser.g:2474:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    {
            	                    // InternalRuleEngineParser.g:2474:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
            	                    // InternalRuleEngineParser.g:2475:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    {
            	                    // InternalRuleEngineParser.g:2475:9: (lv_memberCallArguments_19_0= ruleXExpression )
            	                    // InternalRuleEngineParser.g:2476:10: lv_memberCallArguments_19_0= ruleXExpression
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      										newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0());
            	                      									
            	                    }
            	                    pushFollow(FOLLOW_46);
            	                    lv_memberCallArguments_19_0=ruleXExpression();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      										if (current==null) {
            	                      											current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                      										}
            	                      										add(
            	                      											current,
            	                      											"memberCallArguments",
            	                      											lv_memberCallArguments_19_0,
            	                      											"org.eclipse.xtext.xbase.Xbase.XExpression");
            	                      										afterParserOrEnumRuleCall();
            	                      									
            	                    }

            	                    }


            	                    }

            	                    // InternalRuleEngineParser.g:2493:8: (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
            	                    loop38:
            	                    do {
            	                        int alt38=2;
            	                        int LA38_0 = input.LA(1);

            	                        if ( (LA38_0==Comma) ) {
            	                            alt38=1;
            	                        }


            	                        switch (alt38) {
            	                    	case 1 :
            	                    	    // InternalRuleEngineParser.g:2494:9: otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    {
            	                    	    otherlv_20=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      									newLeafNode(otherlv_20, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
            	                    	      								
            	                    	    }
            	                    	    // InternalRuleEngineParser.g:2498:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
            	                    	    // InternalRuleEngineParser.g:2499:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    {
            	                    	    // InternalRuleEngineParser.g:2499:10: (lv_memberCallArguments_21_0= ruleXExpression )
            	                    	    // InternalRuleEngineParser.g:2500:11: lv_memberCallArguments_21_0= ruleXExpression
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0());
            	                    	      										
            	                    	    }
            	                    	    pushFollow(FOLLOW_46);
            	                    	    lv_memberCallArguments_21_0=ruleXExpression();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      											if (current==null) {
            	                    	      												current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	                    	      											}
            	                    	      											add(
            	                    	      												current,
            	                    	      												"memberCallArguments",
            	                    	      												lv_memberCallArguments_21_0,
            	                    	      												"org.eclipse.xtext.xbase.Xbase.XExpression");
            	                    	      											afterParserOrEnumRuleCall();
            	                    	      										
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop38;
            	                        }
            	                    } while (true);


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_22=(Token)match(input,RightParenthesis,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_22, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
            	              					
            	            }

            	            }
            	            break;

            	    }

            	    // InternalRuleEngineParser.g:2525:5: ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
            	    int alt41=2;
            	    alt41 = dfa41.predict(input);
            	    switch (alt41) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:2526:6: ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
            	            {
            	            // InternalRuleEngineParser.g:2532:6: (lv_memberCallArguments_23_0= ruleXClosure )
            	            // InternalRuleEngineParser.g:2533:7: lv_memberCallArguments_23_0= ruleXClosure
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_39);
            	            lv_memberCallArguments_23_0=ruleXClosure();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
            	              							}
            	              							add(
            	              								current,
            	              								"memberCallArguments",
            	              								lv_memberCallArguments_23_0,
            	              								"org.eclipse.xtext.xbase.Xbase.XClosure");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXMemberFeatureCall"


    // $ANTLR start "entryRuleXPrimaryExpression"
    // InternalRuleEngineParser.g:2556:1: entryRuleXPrimaryExpression returns [EObject current=null] : iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
    public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPrimaryExpression = null;


        try {
            // InternalRuleEngineParser.g:2556:59: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
            // InternalRuleEngineParser.g:2557:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXPrimaryExpression=ruleXPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXPrimaryExpression"


    // $ANTLR start "ruleXPrimaryExpression"
    // InternalRuleEngineParser.g:2563:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
    public final EObject ruleXPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XConstructorCall_0 = null;

        EObject this_XBlockExpression_1 = null;

        EObject this_XSwitchExpression_2 = null;

        EObject this_XSynchronizedExpression_3 = null;

        EObject this_XFeatureCall_4 = null;

        EObject this_XLiteral_5 = null;

        EObject this_XIfExpression_6 = null;

        EObject this_XForLoopExpression_7 = null;

        EObject this_XBasicForLoopExpression_8 = null;

        EObject this_XWhileExpression_9 = null;

        EObject this_XDoWhileExpression_10 = null;

        EObject this_XThrowExpression_11 = null;

        EObject this_XReturnExpression_12 = null;

        EObject this_XTryCatchFinallyExpression_13 = null;

        EObject this_XParenthesizedExpression_14 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2569:2: ( (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
            // InternalRuleEngineParser.g:2570:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            {
            // InternalRuleEngineParser.g:2570:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
            int alt43=15;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // InternalRuleEngineParser.g:2571:3: this_XConstructorCall_0= ruleXConstructorCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XConstructorCall_0=ruleXConstructorCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XConstructorCall_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:2580:3: this_XBlockExpression_1= ruleXBlockExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBlockExpression_1=ruleXBlockExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBlockExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:2589:3: this_XSwitchExpression_2= ruleXSwitchExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSwitchExpression_2=ruleXSwitchExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSwitchExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:2598:3: ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    {
                    // InternalRuleEngineParser.g:2598:3: ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
                    // InternalRuleEngineParser.g:2599:4: ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XSynchronizedExpression_3=ruleXSynchronizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XSynchronizedExpression_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalRuleEngineParser.g:2616:3: this_XFeatureCall_4= ruleXFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFeatureCall_4=ruleXFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFeatureCall_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRuleEngineParser.g:2625:3: this_XLiteral_5= ruleXLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XLiteral_5=ruleXLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRuleEngineParser.g:2634:3: this_XIfExpression_6= ruleXIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XIfExpression_6=ruleXIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XIfExpression_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalRuleEngineParser.g:2643:3: ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    {
                    // InternalRuleEngineParser.g:2643:3: ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
                    // InternalRuleEngineParser.g:2644:4: ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XForLoopExpression_7=ruleXForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XForLoopExpression_7;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalRuleEngineParser.g:2667:3: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBasicForLoopExpression_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalRuleEngineParser.g:2676:3: this_XWhileExpression_9= ruleXWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XWhileExpression_9=ruleXWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XWhileExpression_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalRuleEngineParser.g:2685:3: this_XDoWhileExpression_10= ruleXDoWhileExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XDoWhileExpression_10=ruleXDoWhileExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XDoWhileExpression_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalRuleEngineParser.g:2694:3: this_XThrowExpression_11= ruleXThrowExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XThrowExpression_11=ruleXThrowExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XThrowExpression_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 13 :
                    // InternalRuleEngineParser.g:2703:3: this_XReturnExpression_12= ruleXReturnExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XReturnExpression_12=ruleXReturnExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XReturnExpression_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 14 :
                    // InternalRuleEngineParser.g:2712:3: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTryCatchFinallyExpression_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 15 :
                    // InternalRuleEngineParser.g:2721:3: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XParenthesizedExpression_14=ruleXParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XParenthesizedExpression_14;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXPrimaryExpression"


    // $ANTLR start "entryRuleXLiteral"
    // InternalRuleEngineParser.g:2733:1: entryRuleXLiteral returns [EObject current=null] : iv_ruleXLiteral= ruleXLiteral EOF ;
    public final EObject entryRuleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXLiteral = null;


        try {
            // InternalRuleEngineParser.g:2733:49: (iv_ruleXLiteral= ruleXLiteral EOF )
            // InternalRuleEngineParser.g:2734:2: iv_ruleXLiteral= ruleXLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXLiteral=ruleXLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXLiteral"


    // $ANTLR start "ruleXLiteral"
    // InternalRuleEngineParser.g:2740:1: ruleXLiteral returns [EObject current=null] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) ;
    public final EObject ruleXLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XCollectionLiteral_0 = null;

        EObject this_XClosure_1 = null;

        EObject this_XBooleanLiteral_2 = null;

        EObject this_XNumberLiteral_3 = null;

        EObject this_XNullLiteral_4 = null;

        EObject this_XStringLiteral_5 = null;

        EObject this_XTypeLiteral_6 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2746:2: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral ) )
            // InternalRuleEngineParser.g:2747:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            {
            // InternalRuleEngineParser.g:2747:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure ) | this_XBooleanLiteral_2= ruleXBooleanLiteral | this_XNumberLiteral_3= ruleXNumberLiteral | this_XNullLiteral_4= ruleXNullLiteral | this_XStringLiteral_5= ruleXStringLiteral | this_XTypeLiteral_6= ruleXTypeLiteral )
            int alt44=7;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==NumberSign) ) {
                alt44=1;
            }
            else if ( (LA44_0==LeftSquareBracket) && (synpred23_InternalRuleEngineParser())) {
                alt44=2;
            }
            else if ( (LA44_0==False||LA44_0==True) ) {
                alt44=3;
            }
            else if ( ((LA44_0>=RULE_HEX && LA44_0<=RULE_DECIMAL)) ) {
                alt44=4;
            }
            else if ( (LA44_0==Null) ) {
                alt44=5;
            }
            else if ( (LA44_0==RULE_STRING) ) {
                alt44=6;
            }
            else if ( (LA44_0==Typeof) ) {
                alt44=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalRuleEngineParser.g:2748:3: this_XCollectionLiteral_0= ruleXCollectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XCollectionLiteral_0=ruleXCollectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XCollectionLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:2757:3: ( ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure )
                    {
                    // InternalRuleEngineParser.g:2757:3: ( ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure )
                    // InternalRuleEngineParser.g:2758:4: ( ( () LeftSquareBracket ) )=>this_XClosure_1= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_XClosure_1=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_XClosure_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:2774:3: this_XBooleanLiteral_2= ruleXBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XBooleanLiteral_2=ruleXBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XBooleanLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:2783:3: this_XNumberLiteral_3= ruleXNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNumberLiteral_3=ruleXNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNumberLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRuleEngineParser.g:2792:3: this_XNullLiteral_4= ruleXNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XNullLiteral_4=ruleXNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XNullLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalRuleEngineParser.g:2801:3: this_XStringLiteral_5= ruleXStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XStringLiteral_5=ruleXStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XStringLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalRuleEngineParser.g:2810:3: this_XTypeLiteral_6= ruleXTypeLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XTypeLiteral_6=ruleXTypeLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XTypeLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXLiteral"


    // $ANTLR start "entryRuleXCollectionLiteral"
    // InternalRuleEngineParser.g:2822:1: entryRuleXCollectionLiteral returns [EObject current=null] : iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
    public final EObject entryRuleXCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCollectionLiteral = null;


        try {
            // InternalRuleEngineParser.g:2822:59: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
            // InternalRuleEngineParser.g:2823:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCollectionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCollectionLiteral=ruleXCollectionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCollectionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCollectionLiteral"


    // $ANTLR start "ruleXCollectionLiteral"
    // InternalRuleEngineParser.g:2829:1: ruleXCollectionLiteral returns [EObject current=null] : (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) ;
    public final EObject ruleXCollectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_XSetLiteral_0 = null;

        EObject this_XListLiteral_1 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2835:2: ( (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral ) )
            // InternalRuleEngineParser.g:2836:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            {
            // InternalRuleEngineParser.g:2836:2: (this_XSetLiteral_0= ruleXSetLiteral | this_XListLiteral_1= ruleXListLiteral )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NumberSign) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==LeftSquareBracket) ) {
                    alt45=2;
                }
                else if ( (LA45_1==LeftCurlyBracket) ) {
                    alt45=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalRuleEngineParser.g:2837:3: this_XSetLiteral_0= ruleXSetLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XSetLiteral_0=ruleXSetLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XSetLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:2846:3: this_XListLiteral_1= ruleXListLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XListLiteral_1=ruleXListLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XListLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXCollectionLiteral"


    // $ANTLR start "entryRuleXSetLiteral"
    // InternalRuleEngineParser.g:2858:1: entryRuleXSetLiteral returns [EObject current=null] : iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
    public final EObject entryRuleXSetLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSetLiteral = null;


        try {
            // InternalRuleEngineParser.g:2858:52: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
            // InternalRuleEngineParser.g:2859:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSetLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSetLiteral=ruleXSetLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSetLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSetLiteral"


    // $ANTLR start "ruleXSetLiteral"
    // InternalRuleEngineParser.g:2865:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= NumberSign otherlv_2= LeftCurlyBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleXSetLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2871:2: ( ( () otherlv_1= NumberSign otherlv_2= LeftCurlyBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalRuleEngineParser.g:2872:2: ( () otherlv_1= NumberSign otherlv_2= LeftCurlyBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalRuleEngineParser.g:2872:2: ( () otherlv_1= NumberSign otherlv_2= LeftCurlyBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalRuleEngineParser.g:2873:3: () otherlv_1= NumberSign otherlv_2= LeftCurlyBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalRuleEngineParser.g:2873:3: ()
            // InternalRuleEngineParser.g:2874:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,NumberSign,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:2888:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==Synchronized||LA47_0==Extension||LA47_0==Extends||(LA47_0>=Import && LA47_0<=Typeof)||(LA47_0>=False && LA47_0<=While)||LA47_0==Null||LA47_0==True||(LA47_0>=For && LA47_0<=Try)||(LA47_0>=Do && LA47_0<=If)||(LA47_0>=ExclamationMark && LA47_0<=NumberSign)||LA47_0==LeftParenthesis||LA47_0==PlusSign||LA47_0==HyphenMinus||LA47_0==LessThanSign||LA47_0==LeftSquareBracket||LA47_0==RULE_BEGIN||(LA47_0>=RULE_HEX && LA47_0<=RULE_STRING)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalRuleEngineParser.g:2889:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // InternalRuleEngineParser.g:2889:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:2890:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:2890:5: (lv_elements_3_0= ruleXExpression )
                    // InternalRuleEngineParser.g:2891:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_50);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
                      						}
                      						add(
                      							current,
                      							"elements",
                      							lv_elements_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:2908:4: (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==Comma) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:2909:5: otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:2913:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // InternalRuleEngineParser.g:2914:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // InternalRuleEngineParser.g:2914:6: (lv_elements_5_0= ruleXExpression )
                    	    // InternalRuleEngineParser.g:2915:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_50);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"elements",
                    	      								lv_elements_5_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXSetLiteral"


    // $ANTLR start "entryRuleXListLiteral"
    // InternalRuleEngineParser.g:2942:1: entryRuleXListLiteral returns [EObject current=null] : iv_ruleXListLiteral= ruleXListLiteral EOF ;
    public final EObject entryRuleXListLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXListLiteral = null;


        try {
            // InternalRuleEngineParser.g:2942:53: (iv_ruleXListLiteral= ruleXListLiteral EOF )
            // InternalRuleEngineParser.g:2943:2: iv_ruleXListLiteral= ruleXListLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXListLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXListLiteral=ruleXListLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXListLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXListLiteral"


    // $ANTLR start "ruleXListLiteral"
    // InternalRuleEngineParser.g:2949:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= NumberSign otherlv_2= LeftSquareBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightSquareBracket ) ;
    public final EObject ruleXListLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;

        EObject lv_elements_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:2955:2: ( ( () otherlv_1= NumberSign otherlv_2= LeftSquareBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightSquareBracket ) )
            // InternalRuleEngineParser.g:2956:2: ( () otherlv_1= NumberSign otherlv_2= LeftSquareBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightSquareBracket )
            {
            // InternalRuleEngineParser.g:2956:2: ( () otherlv_1= NumberSign otherlv_2= LeftSquareBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightSquareBracket )
            // InternalRuleEngineParser.g:2957:3: () otherlv_1= NumberSign otherlv_2= LeftSquareBracket ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= RightSquareBracket
            {
            // InternalRuleEngineParser.g:2957:3: ()
            // InternalRuleEngineParser.g:2958:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,NumberSign,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:2972:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )* )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==Synchronized||LA49_0==Extension||LA49_0==Extends||(LA49_0>=Import && LA49_0<=Typeof)||(LA49_0>=False && LA49_0<=While)||LA49_0==Null||LA49_0==True||(LA49_0>=For && LA49_0<=Try)||(LA49_0>=Do && LA49_0<=If)||(LA49_0>=ExclamationMark && LA49_0<=NumberSign)||LA49_0==LeftParenthesis||LA49_0==PlusSign||LA49_0==HyphenMinus||LA49_0==LessThanSign||LA49_0==LeftSquareBracket||LA49_0==RULE_BEGIN||(LA49_0>=RULE_HEX && LA49_0<=RULE_STRING)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalRuleEngineParser.g:2973:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )*
                    {
                    // InternalRuleEngineParser.g:2973:4: ( (lv_elements_3_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:2974:5: (lv_elements_3_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:2974:5: (lv_elements_3_0= ruleXExpression )
                    // InternalRuleEngineParser.g:2975:6: lv_elements_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_53);
                    lv_elements_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXListLiteralRule());
                      						}
                      						add(
                      							current,
                      							"elements",
                      							lv_elements_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:2992:4: (otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==Comma) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:2993:5: otherlv_4= Comma ( (lv_elements_5_0= ruleXExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:2997:5: ( (lv_elements_5_0= ruleXExpression ) )
                    	    // InternalRuleEngineParser.g:2998:6: (lv_elements_5_0= ruleXExpression )
                    	    {
                    	    // InternalRuleEngineParser.g:2998:6: (lv_elements_5_0= ruleXExpression )
                    	    // InternalRuleEngineParser.g:2999:7: lv_elements_5_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_53);
                    	    lv_elements_5_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXListLiteralRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"elements",
                    	      								lv_elements_5_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXListLiteral"


    // $ANTLR start "entryRuleXClosure"
    // InternalRuleEngineParser.g:3026:1: entryRuleXClosure returns [EObject current=null] : iv_ruleXClosure= ruleXClosure EOF ;
    public final EObject entryRuleXClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXClosure = null;


        try {
            // InternalRuleEngineParser.g:3026:49: (iv_ruleXClosure= ruleXClosure EOF )
            // InternalRuleEngineParser.g:3027:2: iv_ruleXClosure= ruleXClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXClosure=ruleXClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXClosure"


    // $ANTLR start "ruleXClosure"
    // InternalRuleEngineParser.g:3033:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= RightSquareBracket ) ;
    public final EObject ruleXClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_explicitSyntax_5_0=null;
        Token otherlv_7=null;
        EObject lv_declaredFormalParameters_2_0 = null;

        EObject lv_declaredFormalParameters_4_0 = null;

        EObject lv_expression_6_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3039:2: ( ( ( ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= RightSquareBracket ) )
            // InternalRuleEngineParser.g:3040:2: ( ( ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= RightSquareBracket )
            {
            // InternalRuleEngineParser.g:3040:2: ( ( ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= RightSquareBracket )
            // InternalRuleEngineParser.g:3041:3: ( ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= RightSquareBracket
            {
            // InternalRuleEngineParser.g:3041:3: ( ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket ) )
            // InternalRuleEngineParser.g:3042:4: ( ( () LeftSquareBracket ) )=> ( () otherlv_1= LeftSquareBracket )
            {
            // InternalRuleEngineParser.g:3048:4: ( () otherlv_1= LeftSquareBracket )
            // InternalRuleEngineParser.g:3049:5: () otherlv_1= LeftSquareBracket
            {
            // InternalRuleEngineParser.g:3049:5: ()
            // InternalRuleEngineParser.g:3050:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_54); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
              				
            }

            }


            }

            // InternalRuleEngineParser.g:3062:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )?
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalRuleEngineParser.g:3063:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) )
                    {
                    // InternalRuleEngineParser.g:3086:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) )
                    // InternalRuleEngineParser.g:3087:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) )
                    {
                    // InternalRuleEngineParser.g:3087:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==EqualsSignGreaterThanSign||LA51_0==LeftParenthesis||LA51_0==RULE_ID) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // InternalRuleEngineParser.g:3088:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            {
                            // InternalRuleEngineParser.g:3088:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
                            // InternalRuleEngineParser.g:3089:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            {
                            // InternalRuleEngineParser.g:3089:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
                            // InternalRuleEngineParser.g:3090:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0());
                              							
                            }
                            pushFollow(FOLLOW_55);
                            lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXClosureRule());
                              								}
                              								add(
                              									current,
                              									"declaredFormalParameters",
                              									lv_declaredFormalParameters_2_0,
                              									"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalRuleEngineParser.g:3107:6: (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==Comma) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // InternalRuleEngineParser.g:3108:7: otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    {
                            	    otherlv_3=(Token)match(input,Comma,FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
                            	      						
                            	    }
                            	    // InternalRuleEngineParser.g:3112:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
                            	    // InternalRuleEngineParser.g:3113:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    {
                            	    // InternalRuleEngineParser.g:3113:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
                            	    // InternalRuleEngineParser.g:3114:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_55);
                            	    lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getXClosureRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"declaredFormalParameters",
                            	      										lv_declaredFormalParameters_4_0,
                            	      										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalRuleEngineParser.g:3133:5: ( (lv_explicitSyntax_5_0= VerticalLine ) )
                    // InternalRuleEngineParser.g:3134:6: (lv_explicitSyntax_5_0= VerticalLine )
                    {
                    // InternalRuleEngineParser.g:3134:6: (lv_explicitSyntax_5_0= VerticalLine )
                    // InternalRuleEngineParser.g:3135:7: lv_explicitSyntax_5_0= VerticalLine
                    {
                    lv_explicitSyntax_5_0=(Token)match(input,VerticalLine,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXClosureRule());
                      							}
                      							setWithLastConsumed(current, "explicitSyntax", true, "|");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            // InternalRuleEngineParser.g:3149:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
            // InternalRuleEngineParser.g:3150:4: (lv_expression_6_0= ruleXExpressionInClosure )
            {
            // InternalRuleEngineParser.g:3150:4: (lv_expression_6_0= ruleXExpressionInClosure )
            // InternalRuleEngineParser.g:3151:5: lv_expression_6_0= ruleXExpressionInClosure
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_56);
            lv_expression_6_0=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXClosureRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_6_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpressionInClosure");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_7=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXClosure"


    // $ANTLR start "entryRuleXExpressionInClosure"
    // InternalRuleEngineParser.g:3176:1: entryRuleXExpressionInClosure returns [EObject current=null] : iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
    public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionInClosure = null;


        try {
            // InternalRuleEngineParser.g:3176:61: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
            // InternalRuleEngineParser.g:3177:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionInClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionInClosure=ruleXExpressionInClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionInClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionInClosure"


    // $ANTLR start "ruleXExpressionInClosure"
    // InternalRuleEngineParser.g:3183:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )? )* ) ;
    public final EObject ruleXExpressionInClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3189:2: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )? )* ) )
            // InternalRuleEngineParser.g:3190:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )? )* )
            {
            // InternalRuleEngineParser.g:3190:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )? )* )
            // InternalRuleEngineParser.g:3191:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )? )*
            {
            // InternalRuleEngineParser.g:3191:3: ()
            // InternalRuleEngineParser.g:3192:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:3198:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )? )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==Synchronized||LA54_0==Extension||LA54_0==Extends||(LA54_0>=Import && LA54_0<=Typeof)||(LA54_0>=False && LA54_0<=While)||LA54_0==Null||LA54_0==True||(LA54_0>=For && LA54_0<=Var)||(LA54_0>=Do && LA54_0<=If)||(LA54_0>=ExclamationMark && LA54_0<=NumberSign)||LA54_0==LeftParenthesis||LA54_0==PlusSign||LA54_0==HyphenMinus||LA54_0==LessThanSign||LA54_0==LeftSquareBracket||LA54_0==RULE_BEGIN||(LA54_0>=RULE_HEX && LA54_0<=RULE_STRING)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalRuleEngineParser.g:3199:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= Semicolon )?
            	    {
            	    // InternalRuleEngineParser.g:3199:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
            	    // InternalRuleEngineParser.g:3200:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    {
            	    // InternalRuleEngineParser.g:3200:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
            	    // InternalRuleEngineParser.g:3201:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_expressions_1_0=ruleXExpressionOrVarDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expressions",
            	      							lv_expressions_1_0,
            	      							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalRuleEngineParser.g:3218:4: (otherlv_2= Semicolon )?
            	    int alt53=2;
            	    int LA53_0 = input.LA(1);

            	    if ( (LA53_0==Semicolon) ) {
            	        alt53=1;
            	    }
            	    switch (alt53) {
            	        case 1 :
            	            // InternalRuleEngineParser.g:3219:5: otherlv_2= Semicolon
            	            {
            	            otherlv_2=(Token)match(input,Semicolon,FOLLOW_58); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              					newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
            	              				
            	            }

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXExpressionInClosure"


    // $ANTLR start "entryRuleXShortClosure"
    // InternalRuleEngineParser.g:3229:1: entryRuleXShortClosure returns [EObject current=null] : iv_ruleXShortClosure= ruleXShortClosure EOF ;
    public final EObject entryRuleXShortClosure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXShortClosure = null;


        try {
            // InternalRuleEngineParser.g:3229:54: (iv_ruleXShortClosure= ruleXShortClosure EOF )
            // InternalRuleEngineParser.g:3230:2: iv_ruleXShortClosure= ruleXShortClosure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXShortClosureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXShortClosure=ruleXShortClosure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXShortClosure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXShortClosure"


    // $ANTLR start "ruleXShortClosure"
    // InternalRuleEngineParser.g:3236:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXShortClosure() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_explicitSyntax_4_0=null;
        EObject lv_declaredFormalParameters_1_0 = null;

        EObject lv_declaredFormalParameters_3_0 = null;

        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3242:2: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:3243:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:3243:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:3244:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:3244:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) ) )
            // InternalRuleEngineParser.g:3245:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) )
            {
            // InternalRuleEngineParser.g:3270:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) ) )
            // InternalRuleEngineParser.g:3271:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= VerticalLine ) )
            {
            // InternalRuleEngineParser.g:3271:5: ()
            // InternalRuleEngineParser.g:3272:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
              							current);
              					
            }

            }

            // InternalRuleEngineParser.g:3278:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==EqualsSignGreaterThanSign||LA56_0==LeftParenthesis||LA56_0==RULE_ID) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalRuleEngineParser.g:3279:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    {
                    // InternalRuleEngineParser.g:3279:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
                    // InternalRuleEngineParser.g:3280:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    {
                    // InternalRuleEngineParser.g:3280:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
                    // InternalRuleEngineParser.g:3281:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0());
                      							
                    }
                    pushFollow(FOLLOW_55);
                    lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                      								}
                      								add(
                      									current,
                      									"declaredFormalParameters",
                      									lv_declaredFormalParameters_1_0,
                      									"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:3298:6: (otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==Comma) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:3299:7: otherlv_2= Comma ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    {
                    	    otherlv_2=(Token)match(input,Comma,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
                    	      						
                    	    }
                    	    // InternalRuleEngineParser.g:3303:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
                    	    // InternalRuleEngineParser.g:3304:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    {
                    	    // InternalRuleEngineParser.g:3304:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
                    	    // InternalRuleEngineParser.g:3305:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_55);
                    	    lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									if (current==null) {
                    	      										current = createModelElementForParent(grammarAccess.getXShortClosureRule());
                    	      									}
                    	      									add(
                    	      										current,
                    	      										"declaredFormalParameters",
                    	      										lv_declaredFormalParameters_3_0,
                    	      										"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
                    	      									afterParserOrEnumRuleCall();
                    	      								
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalRuleEngineParser.g:3324:5: ( (lv_explicitSyntax_4_0= VerticalLine ) )
            // InternalRuleEngineParser.g:3325:6: (lv_explicitSyntax_4_0= VerticalLine )
            {
            // InternalRuleEngineParser.g:3325:6: (lv_explicitSyntax_4_0= VerticalLine )
            // InternalRuleEngineParser.g:3326:7: lv_explicitSyntax_4_0= VerticalLine
            {
            lv_explicitSyntax_4_0=(Token)match(input,VerticalLine,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
              						
            }
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElement(grammarAccess.getXShortClosureRule());
              							}
              							setWithLastConsumed(current, "explicitSyntax", true, "|");
              						
            }

            }


            }


            }


            }

            // InternalRuleEngineParser.g:3340:3: ( (lv_expression_5_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3341:4: (lv_expression_5_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3341:4: (lv_expression_5_0= ruleXExpression )
            // InternalRuleEngineParser.g:3342:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXShortClosureRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXShortClosure"


    // $ANTLR start "entryRuleXParenthesizedExpression"
    // InternalRuleEngineParser.g:3363:1: entryRuleXParenthesizedExpression returns [EObject current=null] : iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
    public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXParenthesizedExpression = null;


        try {
            // InternalRuleEngineParser.g:3363:65: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
            // InternalRuleEngineParser.g:3364:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXParenthesizedExpression"


    // $ANTLR start "ruleXParenthesizedExpression"
    // InternalRuleEngineParser.g:3370:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= LeftParenthesis this_XExpression_1= ruleXExpression otherlv_2= RightParenthesis ) ;
    public final EObject ruleXParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_XExpression_1 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3376:2: ( (otherlv_0= LeftParenthesis this_XExpression_1= ruleXExpression otherlv_2= RightParenthesis ) )
            // InternalRuleEngineParser.g:3377:2: (otherlv_0= LeftParenthesis this_XExpression_1= ruleXExpression otherlv_2= RightParenthesis )
            {
            // InternalRuleEngineParser.g:3377:2: (otherlv_0= LeftParenthesis this_XExpression_1= ruleXExpression otherlv_2= RightParenthesis )
            // InternalRuleEngineParser.g:3378:3: otherlv_0= LeftParenthesis this_XExpression_1= ruleXExpression otherlv_2= RightParenthesis
            {
            otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_19);
            this_XExpression_1=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_XExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXParenthesizedExpression"


    // $ANTLR start "entryRuleXIfExpression"
    // InternalRuleEngineParser.g:3398:1: entryRuleXIfExpression returns [EObject current=null] : iv_ruleXIfExpression= ruleXIfExpression EOF ;
    public final EObject entryRuleXIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXIfExpression = null;


        try {
            // InternalRuleEngineParser.g:3398:54: (iv_ruleXIfExpression= ruleXIfExpression EOF )
            // InternalRuleEngineParser.g:3399:2: iv_ruleXIfExpression= ruleXIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXIfExpression=ruleXIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXIfExpression"


    // $ANTLR start "ruleXIfExpression"
    // InternalRuleEngineParser.g:3405:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_then_5_0= ruleXExpression ) ) ( ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_if_3_0 = null;

        EObject lv_then_5_0 = null;

        EObject lv_else_7_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3411:2: ( ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_then_5_0= ruleXExpression ) ) ( ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
            // InternalRuleEngineParser.g:3412:2: ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_then_5_0= ruleXExpression ) ) ( ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            {
            // InternalRuleEngineParser.g:3412:2: ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_then_5_0= ruleXExpression ) ) ( ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) ) )? )
            // InternalRuleEngineParser.g:3413:3: () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_then_5_0= ruleXExpression ) ) ( ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) ) )?
            {
            // InternalRuleEngineParser.g:3413:3: ()
            // InternalRuleEngineParser.g:3414:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,If,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:3428:3: ( (lv_if_3_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3429:4: (lv_if_3_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3429:4: (lv_if_3_0= ruleXExpression )
            // InternalRuleEngineParser.g:3430:5: lv_if_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_if_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              					}
              					set(
              						current,
              						"if",
              						lv_if_3_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalRuleEngineParser.g:3451:3: ( (lv_then_5_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3452:4: (lv_then_5_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3452:4: (lv_then_5_0= ruleXExpression )
            // InternalRuleEngineParser.g:3453:5: lv_then_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_60);
            lv_then_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:3470:3: ( ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==Else) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred27_InternalRuleEngineParser()) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalRuleEngineParser.g:3471:4: ( ( Else )=>otherlv_6= Else ) ( (lv_else_7_0= ruleXExpression ) )
                    {
                    // InternalRuleEngineParser.g:3471:4: ( ( Else )=>otherlv_6= Else )
                    // InternalRuleEngineParser.g:3472:5: ( Else )=>otherlv_6= Else
                    {
                    otherlv_6=(Token)match(input,Else,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
                      				
                    }

                    }

                    // InternalRuleEngineParser.g:3478:4: ( (lv_else_7_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:3479:5: (lv_else_7_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:3479:5: (lv_else_7_0= ruleXExpression )
                    // InternalRuleEngineParser.g:3480:6: lv_else_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_7_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXIfExpression"


    // $ANTLR start "entryRuleXCasePart"
    // InternalRuleEngineParser.g:3502:1: entryRuleXCasePart returns [EObject current=null] : iv_ruleXCasePart= ruleXCasePart EOF ;
    public final EObject entryRuleXCasePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCasePart = null;


        try {
            // InternalRuleEngineParser.g:3502:50: (iv_ruleXCasePart= ruleXCasePart EOF )
            // InternalRuleEngineParser.g:3503:2: iv_ruleXCasePart= ruleXCasePart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCasePartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCasePart=ruleXCasePart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCasePart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCasePart"


    // $ANTLR start "ruleXCasePart"
    // InternalRuleEngineParser.g:3509:1: ruleXCasePart returns [EObject current=null] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= Comma ) ) ) ) ;
    public final EObject ruleXCasePart() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_fallThrough_6_0=null;
        EObject lv_typeGuard_1_0 = null;

        EObject lv_case_3_0 = null;

        EObject lv_then_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3515:2: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= Comma ) ) ) ) )
            // InternalRuleEngineParser.g:3516:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= Comma ) ) ) )
            {
            // InternalRuleEngineParser.g:3516:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= Comma ) ) ) )
            // InternalRuleEngineParser.g:3517:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= Comma ) ) )
            {
            // InternalRuleEngineParser.g:3517:3: ()
            // InternalRuleEngineParser.g:3518:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:3524:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==EqualsSignGreaterThanSign||LA58_0==LeftParenthesis||LA58_0==RULE_ID) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalRuleEngineParser.g:3525:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    {
                    // InternalRuleEngineParser.g:3525:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
                    // InternalRuleEngineParser.g:3526:5: lv_typeGuard_1_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_61);
                    lv_typeGuard_1_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      					}
                      					set(
                      						current,
                      						"typeGuard",
                      						lv_typeGuard_1_0,
                      						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRuleEngineParser.g:3543:3: (otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==Case) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalRuleEngineParser.g:3544:4: otherlv_2= Case ( (lv_case_3_0= ruleXExpression ) )
                    {
                    otherlv_2=(Token)match(input,Case,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXCasePartAccess().getCaseKeyword_2_0());
                      			
                    }
                    // InternalRuleEngineParser.g:3548:4: ( (lv_case_3_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:3549:5: (lv_case_3_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:3549:5: (lv_case_3_0= ruleXExpression )
                    // InternalRuleEngineParser.g:3550:6: lv_case_3_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_62);
                    lv_case_3_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      						}
                      						set(
                      							current,
                      							"case",
                      							lv_case_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRuleEngineParser.g:3568:3: ( (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= Comma ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==Colon) ) {
                alt60=1;
            }
            else if ( (LA60_0==Comma) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalRuleEngineParser.g:3569:4: (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) )
                    {
                    // InternalRuleEngineParser.g:3569:4: (otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) ) )
                    // InternalRuleEngineParser.g:3570:5: otherlv_4= Colon ( (lv_then_5_0= ruleXExpression ) )
                    {
                    otherlv_4=(Token)match(input,Colon,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0());
                      				
                    }
                    // InternalRuleEngineParser.g:3574:5: ( (lv_then_5_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:3575:6: (lv_then_5_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:3575:6: (lv_then_5_0= ruleXExpression )
                    // InternalRuleEngineParser.g:3576:7: lv_then_5_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_then_5_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXCasePartRule());
                      							}
                      							set(
                      								current,
                      								"then",
                      								lv_then_5_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:3595:4: ( (lv_fallThrough_6_0= Comma ) )
                    {
                    // InternalRuleEngineParser.g:3595:4: ( (lv_fallThrough_6_0= Comma ) )
                    // InternalRuleEngineParser.g:3596:5: (lv_fallThrough_6_0= Comma )
                    {
                    // InternalRuleEngineParser.g:3596:5: (lv_fallThrough_6_0= Comma )
                    // InternalRuleEngineParser.g:3597:6: lv_fallThrough_6_0= Comma
                    {
                    lv_fallThrough_6_0=(Token)match(input,Comma,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_fallThrough_6_0, grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXCasePartRule());
                      						}
                      						setWithLastConsumed(current, "fallThrough", true, ",");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXCasePart"


    // $ANTLR start "entryRuleXForLoopExpression"
    // InternalRuleEngineParser.g:3614:1: entryRuleXForLoopExpression returns [EObject current=null] : iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
    public final EObject entryRuleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXForLoopExpression = null;


        try {
            // InternalRuleEngineParser.g:3614:59: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
            // InternalRuleEngineParser.g:3615:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXForLoopExpression=ruleXForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXForLoopExpression"


    // $ANTLR start "ruleXForLoopExpression"
    // InternalRuleEngineParser.g:3621:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
    public final EObject ruleXForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_7_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3627:2: ( ( ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:3628:2: ( ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:3628:2: ( ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ( (lv_eachExpression_7_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:3629:3: ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ( (lv_eachExpression_7_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:3629:3: ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) )
            // InternalRuleEngineParser.g:3630:4: ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon )
            {
            // InternalRuleEngineParser.g:3643:4: ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon )
            // InternalRuleEngineParser.g:3644:5: () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon
            {
            // InternalRuleEngineParser.g:3644:5: ()
            // InternalRuleEngineParser.g:3645:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,For,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
              				
            }
            // InternalRuleEngineParser.g:3659:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
            // InternalRuleEngineParser.g:3660:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            {
            // InternalRuleEngineParser.g:3660:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
            // InternalRuleEngineParser.g:3661:7: lv_declaredParam_3_0= ruleJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              							newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0());
              						
            }
            pushFollow(FOLLOW_17);
            lv_declaredParam_3_0=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              							}
              							set(
              								current,
              								"declaredParam",
              								lv_declaredParam_3_0,
              								"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
              							afterParserOrEnumRuleCall();
              						
            }

            }


            }

            otherlv_4=(Token)match(input,Colon,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
              				
            }

            }


            }

            // InternalRuleEngineParser.g:3684:3: ( (lv_forExpression_5_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3685:4: (lv_forExpression_5_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3685:4: (lv_forExpression_5_0= ruleXExpression )
            // InternalRuleEngineParser.g:3686:5: lv_forExpression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_forExpression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              					}
              					set(
              						current,
              						"forExpression",
              						lv_forExpression_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:3707:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3708:4: (lv_eachExpression_7_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3708:4: (lv_eachExpression_7_0= ruleXExpression )
            // InternalRuleEngineParser.g:3709:5: lv_eachExpression_7_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_7_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
              					}
              					set(
              						current,
              						"eachExpression",
              						lv_eachExpression_7_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXForLoopExpression"


    // $ANTLR start "entryRuleXBasicForLoopExpression"
    // InternalRuleEngineParser.g:3730:1: entryRuleXBasicForLoopExpression returns [EObject current=null] : iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
    public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBasicForLoopExpression = null;


        try {
            // InternalRuleEngineParser.g:3730:64: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
            // InternalRuleEngineParser.g:3731:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBasicForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBasicForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBasicForLoopExpression"


    // $ANTLR start "ruleXBasicForLoopExpression"
    // InternalRuleEngineParser.g:3737:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= For otherlv_2= LeftParenthesis ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= Semicolon ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= Semicolon ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= RightParenthesis ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
    public final EObject ruleXBasicForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_initExpressions_3_0 = null;

        EObject lv_initExpressions_5_0 = null;

        EObject lv_expression_7_0 = null;

        EObject lv_updateExpressions_9_0 = null;

        EObject lv_updateExpressions_11_0 = null;

        EObject lv_eachExpression_13_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3743:2: ( ( () otherlv_1= For otherlv_2= LeftParenthesis ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= Semicolon ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= Semicolon ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= RightParenthesis ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:3744:2: ( () otherlv_1= For otherlv_2= LeftParenthesis ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= Semicolon ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= Semicolon ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= RightParenthesis ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:3744:2: ( () otherlv_1= For otherlv_2= LeftParenthesis ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= Semicolon ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= Semicolon ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= RightParenthesis ( (lv_eachExpression_13_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:3745:3: () otherlv_1= For otherlv_2= LeftParenthesis ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= Semicolon ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= Semicolon ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= RightParenthesis ( (lv_eachExpression_13_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:3745:3: ()
            // InternalRuleEngineParser.g:3746:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,For,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:3760:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==Synchronized||LA62_0==Extension||LA62_0==Extends||(LA62_0>=Import && LA62_0<=Typeof)||(LA62_0>=False && LA62_0<=While)||LA62_0==Null||LA62_0==True||(LA62_0>=For && LA62_0<=Var)||(LA62_0>=Do && LA62_0<=If)||(LA62_0>=ExclamationMark && LA62_0<=NumberSign)||LA62_0==LeftParenthesis||LA62_0==PlusSign||LA62_0==HyphenMinus||LA62_0==LessThanSign||LA62_0==LeftSquareBracket||LA62_0==RULE_BEGIN||(LA62_0>=RULE_HEX && LA62_0<=RULE_STRING)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalRuleEngineParser.g:3761:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    {
                    // InternalRuleEngineParser.g:3761:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
                    // InternalRuleEngineParser.g:3762:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    {
                    // InternalRuleEngineParser.g:3762:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
                    // InternalRuleEngineParser.g:3763:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_64);
                    lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      						}
                      						add(
                      							current,
                      							"initExpressions",
                      							lv_initExpressions_3_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:3780:4: (otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==Comma) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:3781:5: otherlv_4= Comma ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:3785:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
                    	    // InternalRuleEngineParser.g:3786:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    {
                    	    // InternalRuleEngineParser.g:3786:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
                    	    // InternalRuleEngineParser.g:3787:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_64);
                    	    lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"initExpressions",
                    	      								lv_initExpressions_5_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,Semicolon,FOLLOW_63); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
              		
            }
            // InternalRuleEngineParser.g:3810:3: ( (lv_expression_7_0= ruleXExpression ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==Synchronized||LA63_0==Extension||LA63_0==Extends||(LA63_0>=Import && LA63_0<=Typeof)||(LA63_0>=False && LA63_0<=While)||LA63_0==Null||LA63_0==True||(LA63_0>=For && LA63_0<=Try)||(LA63_0>=Do && LA63_0<=If)||(LA63_0>=ExclamationMark && LA63_0<=NumberSign)||LA63_0==LeftParenthesis||LA63_0==PlusSign||LA63_0==HyphenMinus||LA63_0==LessThanSign||LA63_0==LeftSquareBracket||LA63_0==RULE_BEGIN||(LA63_0>=RULE_HEX && LA63_0<=RULE_STRING)) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalRuleEngineParser.g:3811:4: (lv_expression_7_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:3811:4: (lv_expression_7_0= ruleXExpression )
                    // InternalRuleEngineParser.g:3812:5: lv_expression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_65);
                    lv_expression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_7_0,
                      						"org.eclipse.xtext.xbase.Xbase.XExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,Semicolon,FOLLOW_66); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
              		
            }
            // InternalRuleEngineParser.g:3833:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==Synchronized||LA65_0==Extension||LA65_0==Extends||(LA65_0>=Import && LA65_0<=Typeof)||(LA65_0>=False && LA65_0<=While)||LA65_0==Null||LA65_0==True||(LA65_0>=For && LA65_0<=Try)||(LA65_0>=Do && LA65_0<=If)||(LA65_0>=ExclamationMark && LA65_0<=NumberSign)||LA65_0==LeftParenthesis||LA65_0==PlusSign||LA65_0==HyphenMinus||LA65_0==LessThanSign||LA65_0==LeftSquareBracket||LA65_0==RULE_BEGIN||(LA65_0>=RULE_HEX && LA65_0<=RULE_STRING)) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalRuleEngineParser.g:3834:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    {
                    // InternalRuleEngineParser.g:3834:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:3835:5: (lv_updateExpressions_9_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:3835:5: (lv_updateExpressions_9_0= ruleXExpression )
                    // InternalRuleEngineParser.g:3836:6: lv_updateExpressions_9_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
                      					
                    }
                    pushFollow(FOLLOW_46);
                    lv_updateExpressions_9_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                      						}
                      						add(
                      							current,
                      							"updateExpressions",
                      							lv_updateExpressions_9_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:3853:4: (otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==Comma) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:3854:5: otherlv_10= Comma ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    {
                    	    otherlv_10=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:3858:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
                    	    // InternalRuleEngineParser.g:3859:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    {
                    	    // InternalRuleEngineParser.g:3859:6: (lv_updateExpressions_11_0= ruleXExpression )
                    	    // InternalRuleEngineParser.g:3860:7: lv_updateExpressions_11_0= ruleXExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_46);
                    	    lv_updateExpressions_11_0=ruleXExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"updateExpressions",
                    	      								lv_updateExpressions_11_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,RightParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
              		
            }
            // InternalRuleEngineParser.g:3883:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3884:4: (lv_eachExpression_13_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3884:4: (lv_eachExpression_13_0= ruleXExpression )
            // InternalRuleEngineParser.g:3885:5: lv_eachExpression_13_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_eachExpression_13_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
              					}
              					set(
              						current,
              						"eachExpression",
              						lv_eachExpression_13_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXBasicForLoopExpression"


    // $ANTLR start "entryRuleXWhileExpression"
    // InternalRuleEngineParser.g:3906:1: entryRuleXWhileExpression returns [EObject current=null] : iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
    public final EObject entryRuleXWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXWhileExpression = null;


        try {
            // InternalRuleEngineParser.g:3906:57: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
            // InternalRuleEngineParser.g:3907:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXWhileExpression=ruleXWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXWhileExpression"


    // $ANTLR start "ruleXWhileExpression"
    // InternalRuleEngineParser.g:3913:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= While otherlv_2= LeftParenthesis ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_predicate_3_0 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3919:2: ( ( () otherlv_1= While otherlv_2= LeftParenthesis ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:3920:2: ( () otherlv_1= While otherlv_2= LeftParenthesis ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:3920:2: ( () otherlv_1= While otherlv_2= LeftParenthesis ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:3921:3: () otherlv_1= While otherlv_2= LeftParenthesis ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_body_5_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:3921:3: ()
            // InternalRuleEngineParser.g:3922:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,While,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:3936:3: ( (lv_predicate_3_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3937:4: (lv_predicate_3_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3937:4: (lv_predicate_3_0= ruleXExpression )
            // InternalRuleEngineParser.g:3938:5: lv_predicate_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_predicate_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              					}
              					set(
              						current,
              						"predicate",
              						lv_predicate_3_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalRuleEngineParser.g:3959:3: ( (lv_body_5_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:3960:4: (lv_body_5_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:3960:4: (lv_body_5_0= ruleXExpression )
            // InternalRuleEngineParser.g:3961:5: lv_body_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXWhileExpression"


    // $ANTLR start "entryRuleXDoWhileExpression"
    // InternalRuleEngineParser.g:3982:1: entryRuleXDoWhileExpression returns [EObject current=null] : iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
    public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXDoWhileExpression = null;


        try {
            // InternalRuleEngineParser.g:3982:59: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
            // InternalRuleEngineParser.g:3983:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXDoWhileExpression=ruleXDoWhileExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXDoWhileExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXDoWhileExpression"


    // $ANTLR start "ruleXDoWhileExpression"
    // InternalRuleEngineParser.g:3989:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= Do ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= While otherlv_4= LeftParenthesis ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) ;
    public final EObject ruleXDoWhileExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_body_2_0 = null;

        EObject lv_predicate_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:3995:2: ( ( () otherlv_1= Do ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= While otherlv_4= LeftParenthesis ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) )
            // InternalRuleEngineParser.g:3996:2: ( () otherlv_1= Do ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= While otherlv_4= LeftParenthesis ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis )
            {
            // InternalRuleEngineParser.g:3996:2: ( () otherlv_1= Do ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= While otherlv_4= LeftParenthesis ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis )
            // InternalRuleEngineParser.g:3997:3: () otherlv_1= Do ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= While otherlv_4= LeftParenthesis ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis
            {
            // InternalRuleEngineParser.g:3997:3: ()
            // InternalRuleEngineParser.g:3998:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Do,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:4008:3: ( (lv_body_2_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:4009:4: (lv_body_2_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:4009:4: (lv_body_2_0= ruleXExpression )
            // InternalRuleEngineParser.g:4010:5: lv_body_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_67);
            lv_body_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,While,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,LeftParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
              		
            }
            // InternalRuleEngineParser.g:4035:3: ( (lv_predicate_5_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:4036:4: (lv_predicate_5_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:4036:4: (lv_predicate_5_0= ruleXExpression )
            // InternalRuleEngineParser.g:4037:5: lv_predicate_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_predicate_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
              					}
              					set(
              						current,
              						"predicate",
              						lv_predicate_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXDoWhileExpression"


    // $ANTLR start "entryRuleXExpressionOrVarDeclaration"
    // InternalRuleEngineParser.g:4062:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] : iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
    public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExpressionOrVarDeclaration = null;


        try {
            // InternalRuleEngineParser.g:4062:68: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
            // InternalRuleEngineParser.g:4063:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExpressionOrVarDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExpressionOrVarDeclaration"


    // $ANTLR start "ruleXExpressionOrVarDeclaration"
    // InternalRuleEngineParser.g:4069:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) ;
    public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_XVariableDeclaration_0 = null;

        EObject this_XExpression_1 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4075:2: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression ) )
            // InternalRuleEngineParser.g:4076:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            {
            // InternalRuleEngineParser.g:4076:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration | this_XExpression_1= ruleXExpression )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( ((LA66_0>=Val && LA66_0<=Var)) ) {
                alt66=1;
            }
            else if ( (LA66_0==Synchronized||LA66_0==Extension||LA66_0==Extends||(LA66_0>=Import && LA66_0<=Typeof)||(LA66_0>=False && LA66_0<=While)||LA66_0==Null||LA66_0==True||(LA66_0>=For && LA66_0<=Try)||(LA66_0>=Do && LA66_0<=If)||(LA66_0>=ExclamationMark && LA66_0<=NumberSign)||LA66_0==LeftParenthesis||LA66_0==PlusSign||LA66_0==HyphenMinus||LA66_0==LessThanSign||LA66_0==LeftSquareBracket||LA66_0==RULE_BEGIN||(LA66_0>=RULE_HEX && LA66_0<=RULE_STRING)) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalRuleEngineParser.g:4077:3: this_XVariableDeclaration_0= ruleXVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XVariableDeclaration_0=ruleXVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XVariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:4086:3: this_XExpression_1= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XExpression_1=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXExpressionOrVarDeclaration"


    // $ANTLR start "entryRuleXVariableDeclaration"
    // InternalRuleEngineParser.g:4098:1: entryRuleXVariableDeclaration returns [EObject current=null] : iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
    public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXVariableDeclaration = null;


        try {
            // InternalRuleEngineParser.g:4098:61: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
            // InternalRuleEngineParser.g:4099:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXVariableDeclaration=ruleXVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXVariableDeclaration"


    // $ANTLR start "ruleXVariableDeclaration"
    // InternalRuleEngineParser.g:4105:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
    public final EObject ruleXVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_right_7_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4111:2: ( ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) ) )? ) )
            // InternalRuleEngineParser.g:4112:2: ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) ) )? )
            {
            // InternalRuleEngineParser.g:4112:2: ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) ) )? )
            // InternalRuleEngineParser.g:4113:3: () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) ) )?
            {
            // InternalRuleEngineParser.g:4113:3: ()
            // InternalRuleEngineParser.g:4114:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:4120:3: ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==Var) ) {
                alt67=1;
            }
            else if ( (LA67_0==Val) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalRuleEngineParser.g:4121:4: ( (lv_writeable_1_0= Var ) )
                    {
                    // InternalRuleEngineParser.g:4121:4: ( (lv_writeable_1_0= Var ) )
                    // InternalRuleEngineParser.g:4122:5: (lv_writeable_1_0= Var )
                    {
                    // InternalRuleEngineParser.g:4122:5: (lv_writeable_1_0= Var )
                    // InternalRuleEngineParser.g:4123:6: lv_writeable_1_0= Var
                    {
                    lv_writeable_1_0=(Token)match(input,Var,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "writeable", true, "var");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:4136:4: otherlv_2= Val
                    {
                    otherlv_2=(Token)match(input,Val,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalRuleEngineParser.g:4141:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                int LA68_1 = input.LA(2);

                if ( (synpred29_InternalRuleEngineParser()) ) {
                    alt68=1;
                }
                else if ( (true) ) {
                    alt68=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 68, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA68_0==LeftParenthesis) && (synpred29_InternalRuleEngineParser())) {
                alt68=1;
            }
            else if ( (LA68_0==EqualsSignGreaterThanSign) && (synpred29_InternalRuleEngineParser())) {
                alt68=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalRuleEngineParser.g:4142:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    {
                    // InternalRuleEngineParser.g:4142:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
                    // InternalRuleEngineParser.g:4143:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    {
                    // InternalRuleEngineParser.g:4156:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
                    // InternalRuleEngineParser.g:4157:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
                    {
                    // InternalRuleEngineParser.g:4157:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
                    // InternalRuleEngineParser.g:4158:7: (lv_type_3_0= ruleJvmTypeReference )
                    {
                    // InternalRuleEngineParser.g:4158:7: (lv_type_3_0= ruleJvmTypeReference )
                    // InternalRuleEngineParser.g:4159:8: lv_type_3_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0());
                      							
                    }
                    pushFollow(FOLLOW_4);
                    lv_type_3_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"type",
                      									lv_type_3_0,
                      									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:4176:6: ( (lv_name_4_0= ruleValidID ) )
                    // InternalRuleEngineParser.g:4177:7: (lv_name_4_0= ruleValidID )
                    {
                    // InternalRuleEngineParser.g:4177:7: (lv_name_4_0= ruleValidID )
                    // InternalRuleEngineParser.g:4178:8: lv_name_4_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0());
                      							
                    }
                    pushFollow(FOLLOW_68);
                    lv_name_4_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"name",
                      									lv_name_4_0,
                      									"org.eclipse.xtext.xbase.Xtype.ValidID");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:4198:4: ( (lv_name_5_0= ruleValidID ) )
                    {
                    // InternalRuleEngineParser.g:4198:4: ( (lv_name_5_0= ruleValidID ) )
                    // InternalRuleEngineParser.g:4199:5: (lv_name_5_0= ruleValidID )
                    {
                    // InternalRuleEngineParser.g:4199:5: (lv_name_5_0= ruleValidID )
                    // InternalRuleEngineParser.g:4200:6: lv_name_5_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_68);
                    lv_name_5_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"name",
                      							lv_name_5_0,
                      							"org.eclipse.xtext.xbase.Xtype.ValidID");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRuleEngineParser.g:4218:3: (otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==EqualsSign) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalRuleEngineParser.g:4219:4: otherlv_6= EqualsSign ( (lv_right_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,EqualsSign,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalRuleEngineParser.g:4223:4: ( (lv_right_7_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:4224:5: (lv_right_7_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:4224:5: (lv_right_7_0= ruleXExpression )
                    // InternalRuleEngineParser.g:4225:6: lv_right_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_7_0,
                      							"org.eclipse.xtext.xbase.Xbase.XExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXVariableDeclaration"


    // $ANTLR start "entryRuleJvmFormalParameter"
    // InternalRuleEngineParser.g:4247:1: entryRuleJvmFormalParameter returns [EObject current=null] : iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
    public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmFormalParameter = null;


        try {
            // InternalRuleEngineParser.g:4247:59: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
            // InternalRuleEngineParser.g:4248:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmFormalParameter=ruleJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmFormalParameter"


    // $ANTLR start "ruleJvmFormalParameter"
    // InternalRuleEngineParser.g:4254:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4260:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalRuleEngineParser.g:4261:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalRuleEngineParser.g:4261:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
            // InternalRuleEngineParser.g:4262:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalRuleEngineParser.g:4262:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==FullStop||LA70_1==LessThanSign||LA70_1==LeftSquareBracket||LA70_1==RULE_ID) ) {
                    alt70=1;
                }
            }
            else if ( (LA70_0==EqualsSignGreaterThanSign||LA70_0==LeftParenthesis) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalRuleEngineParser.g:4263:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    {
                    // InternalRuleEngineParser.g:4263:4: (lv_parameterType_0_0= ruleJvmTypeReference )
                    // InternalRuleEngineParser.g:4264:5: lv_parameterType_0_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_4);
                    lv_parameterType_0_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
                      					}
                      					set(
                      						current,
                      						"parameterType",
                      						lv_parameterType_0_0,
                      						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalRuleEngineParser.g:4281:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalRuleEngineParser.g:4282:4: (lv_name_1_0= ruleValidID )
            {
            // InternalRuleEngineParser.g:4282:4: (lv_name_1_0= ruleValidID )
            // InternalRuleEngineParser.g:4283:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmFormalParameter"


    // $ANTLR start "entryRuleFullJvmFormalParameter"
    // InternalRuleEngineParser.g:4304:1: entryRuleFullJvmFormalParameter returns [EObject current=null] : iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
    public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFullJvmFormalParameter = null;


        try {
            // InternalRuleEngineParser.g:4304:63: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
            // InternalRuleEngineParser.g:4305:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFullJvmFormalParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFullJvmFormalParameter"


    // $ANTLR start "ruleFullJvmFormalParameter"
    // InternalRuleEngineParser.g:4311:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
    public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
        EObject current = null;

        EObject lv_parameterType_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4317:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
            // InternalRuleEngineParser.g:4318:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            {
            // InternalRuleEngineParser.g:4318:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
            // InternalRuleEngineParser.g:4319:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
            {
            // InternalRuleEngineParser.g:4319:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
            // InternalRuleEngineParser.g:4320:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            {
            // InternalRuleEngineParser.g:4320:4: (lv_parameterType_0_0= ruleJvmTypeReference )
            // InternalRuleEngineParser.g:4321:5: lv_parameterType_0_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_parameterType_0_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              					}
              					set(
              						current,
              						"parameterType",
              						lv_parameterType_0_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:4338:3: ( (lv_name_1_0= ruleValidID ) )
            // InternalRuleEngineParser.g:4339:4: (lv_name_1_0= ruleValidID )
            {
            // InternalRuleEngineParser.g:4339:4: (lv_name_1_0= ruleValidID )
            // InternalRuleEngineParser.g:4340:5: lv_name_1_0= ruleValidID
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.xbase.Xtype.ValidID");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFullJvmFormalParameter"


    // $ANTLR start "entryRuleXFeatureCall"
    // InternalRuleEngineParser.g:4361:1: entryRuleXFeatureCall returns [EObject current=null] : iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
    public final EObject entryRuleXFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFeatureCall = null;


        try {
            // InternalRuleEngineParser.g:4361:53: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
            // InternalRuleEngineParser.g:4362:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFeatureCall=ruleXFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFeatureCall"


    // $ANTLR start "ruleXFeatureCall"
    // InternalRuleEngineParser.g:4368:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
    public final EObject ruleXFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_explicitOperationCall_7_0=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;

        EObject lv_featureCallArguments_8_0 = null;

        EObject lv_featureCallArguments_9_0 = null;

        EObject lv_featureCallArguments_11_0 = null;

        EObject lv_featureCallArguments_13_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4374:2: ( ( () (otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
            // InternalRuleEngineParser.g:4375:2: ( () (otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            {
            // InternalRuleEngineParser.g:4375:2: ( () (otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
            // InternalRuleEngineParser.g:4376:3: () (otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign )? ( ( ruleIdOrSuper ) ) ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            {
            // InternalRuleEngineParser.g:4376:3: ()
            // InternalRuleEngineParser.g:4377:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:4383:3: (otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==LessThanSign) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalRuleEngineParser.g:4384:4: otherlv_1= LessThanSign ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign
                    {
                    otherlv_1=(Token)match(input,LessThanSign,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalRuleEngineParser.g:4388:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
                    // InternalRuleEngineParser.g:4389:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalRuleEngineParser.g:4389:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
                    // InternalRuleEngineParser.g:4390:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_typeArguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      						}
                      						add(
                      							current,
                      							"typeArguments",
                      							lv_typeArguments_2_0,
                      							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:4407:4: (otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==Comma) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:4408:5: otherlv_3= Comma ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FOLLOW_42); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:4412:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalRuleEngineParser.g:4413:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalRuleEngineParser.g:4413:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    	    // InternalRuleEngineParser.g:4414:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeArguments",
                    	      								lv_typeArguments_4_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,GreaterThanSign,FOLLOW_41); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRuleEngineParser.g:4437:3: ( ( ruleIdOrSuper ) )
            // InternalRuleEngineParser.g:4438:4: ( ruleIdOrSuper )
            {
            // InternalRuleEngineParser.g:4438:4: ( ruleIdOrSuper )
            // InternalRuleEngineParser.g:4439:5: ruleIdOrSuper
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXFeatureCallRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_69);
            ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:4453:3: ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )?
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // InternalRuleEngineParser.g:4454:4: ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis
                    {
                    // InternalRuleEngineParser.g:4454:4: ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) )
                    // InternalRuleEngineParser.g:4455:5: ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis )
                    {
                    // InternalRuleEngineParser.g:4459:5: (lv_explicitOperationCall_7_0= LeftParenthesis )
                    // InternalRuleEngineParser.g:4460:6: lv_explicitOperationCall_7_0= LeftParenthesis
                    {
                    lv_explicitOperationCall_7_0=(Token)match(input,LeftParenthesis,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_explicitOperationCall_7_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXFeatureCallRule());
                      						}
                      						setWithLastConsumed(current, "explicitOperationCall", true, "(");
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:4472:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
                    int alt74=3;
                    alt74 = dfa74.predict(input);
                    switch (alt74) {
                        case 1 :
                            // InternalRuleEngineParser.g:4473:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            {
                            // InternalRuleEngineParser.g:4473:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
                            // InternalRuleEngineParser.g:4474:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
                            {
                            // InternalRuleEngineParser.g:4499:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
                            // InternalRuleEngineParser.g:4500:7: lv_featureCallArguments_8_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_19);
                            lv_featureCallArguments_8_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              							}
                              							add(
                              								current,
                              								"featureCallArguments",
                              								lv_featureCallArguments_8_0,
                              								"org.eclipse.xtext.xbase.Xbase.XShortClosure");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRuleEngineParser.g:4518:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            {
                            // InternalRuleEngineParser.g:4518:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
                            // InternalRuleEngineParser.g:4519:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            {
                            // InternalRuleEngineParser.g:4519:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
                            // InternalRuleEngineParser.g:4520:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            {
                            // InternalRuleEngineParser.g:4520:7: (lv_featureCallArguments_9_0= ruleXExpression )
                            // InternalRuleEngineParser.g:4521:8: lv_featureCallArguments_9_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_46);
                            lv_featureCallArguments_9_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                              								}
                              								add(
                              									current,
                              									"featureCallArguments",
                              									lv_featureCallArguments_9_0,
                              									"org.eclipse.xtext.xbase.Xbase.XExpression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalRuleEngineParser.g:4538:6: (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
                            loop73:
                            do {
                                int alt73=2;
                                int LA73_0 = input.LA(1);

                                if ( (LA73_0==Comma) ) {
                                    alt73=1;
                                }


                                switch (alt73) {
                            	case 1 :
                            	    // InternalRuleEngineParser.g:4539:7: otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    {
                            	    otherlv_10=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
                            	      						
                            	    }
                            	    // InternalRuleEngineParser.g:4543:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
                            	    // InternalRuleEngineParser.g:4544:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    {
                            	    // InternalRuleEngineParser.g:4544:8: (lv_featureCallArguments_11_0= ruleXExpression )
                            	    // InternalRuleEngineParser.g:4545:9: lv_featureCallArguments_11_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_46);
                            	    lv_featureCallArguments_11_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"featureCallArguments",
                            	      										lv_featureCallArguments_11_0,
                            	      										"org.eclipse.xtext.xbase.Xbase.XExpression");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop73;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_12=(Token)match(input,RightParenthesis,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }

            // InternalRuleEngineParser.g:4570:3: ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
            int alt76=2;
            alt76 = dfa76.predict(input);
            switch (alt76) {
                case 1 :
                    // InternalRuleEngineParser.g:4571:4: ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
                    {
                    // InternalRuleEngineParser.g:4577:4: (lv_featureCallArguments_13_0= ruleXClosure )
                    // InternalRuleEngineParser.g:4578:5: lv_featureCallArguments_13_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_featureCallArguments_13_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
                      					}
                      					add(
                      						current,
                      						"featureCallArguments",
                      						lv_featureCallArguments_13_0,
                      						"org.eclipse.xtext.xbase.Xbase.XClosure");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXFeatureCall"


    // $ANTLR start "entryRuleFeatureCallID"
    // InternalRuleEngineParser.g:4599:1: entryRuleFeatureCallID returns [String current=null] : iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
    public final String entryRuleFeatureCallID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCallID = null;


        try {
            // InternalRuleEngineParser.g:4599:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
            // InternalRuleEngineParser.g:4600:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallID=ruleFeatureCallID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeatureCallID"


    // $ANTLR start "ruleFeatureCallID"
    // InternalRuleEngineParser.g:4606:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID | kw= Extends | kw= Static | kw= Import | kw= Extension ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4612:2: ( (this_ValidID_0= ruleValidID | kw= Extends | kw= Static | kw= Import | kw= Extension ) )
            // InternalRuleEngineParser.g:4613:2: (this_ValidID_0= ruleValidID | kw= Extends | kw= Static | kw= Import | kw= Extension )
            {
            // InternalRuleEngineParser.g:4613:2: (this_ValidID_0= ruleValidID | kw= Extends | kw= Static | kw= Import | kw= Extension )
            int alt77=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt77=1;
                }
                break;
            case Extends:
                {
                alt77=2;
                }
                break;
            case Static:
                {
                alt77=3;
                }
                break;
            case Import:
                {
                alt77=4;
                }
                break;
            case Extension:
                {
                alt77=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // InternalRuleEngineParser.g:4614:3: this_ValidID_0= ruleValidID
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeatureCallIDAccess().getValidIDParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ValidID_0=ruleValidID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ValidID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:4625:3: kw= Extends
                    {
                    kw=(Token)match(input,Extends,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:4631:3: kw= Static
                    {
                    kw=(Token)match(input,Static,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalRuleEngineParser.g:4637:3: kw= Import
                    {
                    kw=(Token)match(input,Import,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalRuleEngineParser.g:4643:3: kw= Extension
                    {
                    kw=(Token)match(input,Extension,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFeatureCallID"


    // $ANTLR start "entryRuleIdOrSuper"
    // InternalRuleEngineParser.g:4652:1: entryRuleIdOrSuper returns [String current=null] : iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
    public final String entryRuleIdOrSuper() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdOrSuper = null;


        try {
            // InternalRuleEngineParser.g:4652:49: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
            // InternalRuleEngineParser.g:4653:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdOrSuperRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIdOrSuper=ruleIdOrSuper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdOrSuper.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIdOrSuper"


    // $ANTLR start "ruleIdOrSuper"
    // InternalRuleEngineParser.g:4659:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID | kw= Super ) ;
    public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FeatureCallID_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4665:2: ( (this_FeatureCallID_0= ruleFeatureCallID | kw= Super ) )
            // InternalRuleEngineParser.g:4666:2: (this_FeatureCallID_0= ruleFeatureCallID | kw= Super )
            {
            // InternalRuleEngineParser.g:4666:2: (this_FeatureCallID_0= ruleFeatureCallID | kw= Super )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==Extension||LA78_0==Extends||LA78_0==Import||LA78_0==Static||LA78_0==RULE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==Super) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalRuleEngineParser.g:4667:3: this_FeatureCallID_0= ruleFeatureCallID
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCallID_0=ruleFeatureCallID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_FeatureCallID_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:4678:3: kw= Super
                    {
                    kw=(Token)match(input,Super,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIdOrSuper"


    // $ANTLR start "entryRuleXConstructorCall"
    // InternalRuleEngineParser.g:4687:1: entryRuleXConstructorCall returns [EObject current=null] : iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
    public final EObject entryRuleXConstructorCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXConstructorCall = null;


        try {
            // InternalRuleEngineParser.g:4687:57: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
            // InternalRuleEngineParser.g:4688:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXConstructorCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXConstructorCall=ruleXConstructorCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXConstructorCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXConstructorCall"


    // $ANTLR start "ruleXConstructorCall"
    // InternalRuleEngineParser.g:4694:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= New ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )? ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
    public final EObject ruleXConstructorCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_explicitConstructorCall_8_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_typeArguments_4_0 = null;

        EObject lv_typeArguments_6_0 = null;

        EObject lv_arguments_9_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;

        EObject lv_arguments_14_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:4700:2: ( ( () otherlv_1= New ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )? ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
            // InternalRuleEngineParser.g:4701:2: ( () otherlv_1= New ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )? ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            {
            // InternalRuleEngineParser.g:4701:2: ( () otherlv_1= New ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )? ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
            // InternalRuleEngineParser.g:4702:3: () otherlv_1= New ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )? ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )? ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            {
            // InternalRuleEngineParser.g:4702:3: ()
            // InternalRuleEngineParser.g:4703:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,New,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:4713:3: ( ( ruleQualifiedName ) )
            // InternalRuleEngineParser.g:4714:4: ( ruleQualifiedName )
            {
            // InternalRuleEngineParser.g:4714:4: ( ruleQualifiedName )
            // InternalRuleEngineParser.g:4715:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXConstructorCallRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_71);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:4729:3: ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )?
            int alt80=2;
            alt80 = dfa80.predict(input);
            switch (alt80) {
                case 1 :
                    // InternalRuleEngineParser.g:4730:4: ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign
                    {
                    // InternalRuleEngineParser.g:4730:4: ( ( LessThanSign )=>otherlv_3= LessThanSign )
                    // InternalRuleEngineParser.g:4731:5: ( LessThanSign )=>otherlv_3= LessThanSign
                    {
                    otherlv_3=(Token)match(input,LessThanSign,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
                      				
                    }

                    }

                    // InternalRuleEngineParser.g:4737:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
                    // InternalRuleEngineParser.g:4738:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalRuleEngineParser.g:4738:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
                    // InternalRuleEngineParser.g:4739:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_typeArguments_4_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      						}
                      						add(
                      							current,
                      							"typeArguments",
                      							lv_typeArguments_4_0,
                      							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:4756:4: (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
                    loop79:
                    do {
                        int alt79=2;
                        int LA79_0 = input.LA(1);

                        if ( (LA79_0==Comma) ) {
                            alt79=1;
                        }


                        switch (alt79) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:4757:5: otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_5=(Token)match(input,Comma,FOLLOW_42); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:4761:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalRuleEngineParser.g:4762:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalRuleEngineParser.g:4762:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
                    	    // InternalRuleEngineParser.g:4763:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_typeArguments_6_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeArguments",
                    	      								lv_typeArguments_6_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop79;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,GreaterThanSign,FOLLOW_69); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
                      			
                    }

                    }
                    break;

            }

            // InternalRuleEngineParser.g:4786:3: ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )?
            int alt83=2;
            alt83 = dfa83.predict(input);
            switch (alt83) {
                case 1 :
                    // InternalRuleEngineParser.g:4787:4: ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis
                    {
                    // InternalRuleEngineParser.g:4787:4: ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) )
                    // InternalRuleEngineParser.g:4788:5: ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis )
                    {
                    // InternalRuleEngineParser.g:4792:5: (lv_explicitConstructorCall_8_0= LeftParenthesis )
                    // InternalRuleEngineParser.g:4793:6: lv_explicitConstructorCall_8_0= LeftParenthesis
                    {
                    lv_explicitConstructorCall_8_0=(Token)match(input,LeftParenthesis,FOLLOW_45); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXConstructorCallRule());
                      						}
                      						setWithLastConsumed(current, "explicitConstructorCall", true, "(");
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:4805:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
                    int alt82=3;
                    alt82 = dfa82.predict(input);
                    switch (alt82) {
                        case 1 :
                            // InternalRuleEngineParser.g:4806:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            {
                            // InternalRuleEngineParser.g:4806:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
                            // InternalRuleEngineParser.g:4807:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
                            {
                            // InternalRuleEngineParser.g:4832:6: (lv_arguments_9_0= ruleXShortClosure )
                            // InternalRuleEngineParser.g:4833:7: lv_arguments_9_0= ruleXShortClosure
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_19);
                            lv_arguments_9_0=ruleXShortClosure();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              							}
                              							add(
                              								current,
                              								"arguments",
                              								lv_arguments_9_0,
                              								"org.eclipse.xtext.xbase.Xbase.XShortClosure");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRuleEngineParser.g:4851:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            {
                            // InternalRuleEngineParser.g:4851:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* )
                            // InternalRuleEngineParser.g:4852:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            {
                            // InternalRuleEngineParser.g:4852:6: ( (lv_arguments_10_0= ruleXExpression ) )
                            // InternalRuleEngineParser.g:4853:7: (lv_arguments_10_0= ruleXExpression )
                            {
                            // InternalRuleEngineParser.g:4853:7: (lv_arguments_10_0= ruleXExpression )
                            // InternalRuleEngineParser.g:4854:8: lv_arguments_10_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_46);
                            lv_arguments_10_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                              								}
                              								add(
                              									current,
                              									"arguments",
                              									lv_arguments_10_0,
                              									"org.eclipse.xtext.xbase.Xbase.XExpression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalRuleEngineParser.g:4871:6: (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )*
                            loop81:
                            do {
                                int alt81=2;
                                int LA81_0 = input.LA(1);

                                if ( (LA81_0==Comma) ) {
                                    alt81=1;
                                }


                                switch (alt81) {
                            	case 1 :
                            	    // InternalRuleEngineParser.g:4872:7: otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) )
                            	    {
                            	    otherlv_11=(Token)match(input,Comma,FOLLOW_18); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
                            	      						
                            	    }
                            	    // InternalRuleEngineParser.g:4876:7: ( (lv_arguments_12_0= ruleXExpression ) )
                            	    // InternalRuleEngineParser.g:4877:8: (lv_arguments_12_0= ruleXExpression )
                            	    {
                            	    // InternalRuleEngineParser.g:4877:8: (lv_arguments_12_0= ruleXExpression )
                            	    // InternalRuleEngineParser.g:4878:9: lv_arguments_12_0= ruleXExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_46);
                            	    lv_arguments_12_0=ruleXExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"arguments",
                            	      										lv_arguments_12_0,
                            	      										"org.eclipse.xtext.xbase.Xbase.XExpression");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop81;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }

                    otherlv_13=(Token)match(input,RightParenthesis,FOLLOW_70); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
                      			
                    }

                    }
                    break;

            }

            // InternalRuleEngineParser.g:4903:3: ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )?
            int alt84=2;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // InternalRuleEngineParser.g:4904:4: ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure )
                    {
                    // InternalRuleEngineParser.g:4910:4: (lv_arguments_14_0= ruleXClosure )
                    // InternalRuleEngineParser.g:4911:5: lv_arguments_14_0= ruleXClosure
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_arguments_14_0=ruleXClosure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
                      					}
                      					add(
                      						current,
                      						"arguments",
                      						lv_arguments_14_0,
                      						"org.eclipse.xtext.xbase.Xbase.XClosure");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXConstructorCall"


    // $ANTLR start "entryRuleXBooleanLiteral"
    // InternalRuleEngineParser.g:4932:1: entryRuleXBooleanLiteral returns [EObject current=null] : iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
    public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXBooleanLiteral = null;


        try {
            // InternalRuleEngineParser.g:4932:56: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
            // InternalRuleEngineParser.g:4933:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXBooleanLiteral=ruleXBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXBooleanLiteral"


    // $ANTLR start "ruleXBooleanLiteral"
    // InternalRuleEngineParser.g:4939:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) ) ;
    public final EObject ruleXBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:4945:2: ( ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) ) )
            // InternalRuleEngineParser.g:4946:2: ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) )
            {
            // InternalRuleEngineParser.g:4946:2: ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) )
            // InternalRuleEngineParser.g:4947:3: () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) )
            {
            // InternalRuleEngineParser.g:4947:3: ()
            // InternalRuleEngineParser.g:4948:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:4954:3: (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==False) ) {
                alt85=1;
            }
            else if ( (LA85_0==True) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // InternalRuleEngineParser.g:4955:4: otherlv_1= False
                    {
                    otherlv_1=(Token)match(input,False,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:4960:4: ( (lv_isTrue_2_0= True ) )
                    {
                    // InternalRuleEngineParser.g:4960:4: ( (lv_isTrue_2_0= True ) )
                    // InternalRuleEngineParser.g:4961:5: (lv_isTrue_2_0= True )
                    {
                    // InternalRuleEngineParser.g:4961:5: (lv_isTrue_2_0= True )
                    // InternalRuleEngineParser.g:4962:6: lv_isTrue_2_0= True
                    {
                    lv_isTrue_2_0=(Token)match(input,True,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "isTrue", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXBooleanLiteral"


    // $ANTLR start "entryRuleXNullLiteral"
    // InternalRuleEngineParser.g:4979:1: entryRuleXNullLiteral returns [EObject current=null] : iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
    public final EObject entryRuleXNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNullLiteral = null;


        try {
            // InternalRuleEngineParser.g:4979:53: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
            // InternalRuleEngineParser.g:4980:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNullLiteral=ruleXNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNullLiteral"


    // $ANTLR start "ruleXNullLiteral"
    // InternalRuleEngineParser.g:4986:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= Null ) ;
    public final EObject ruleXNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:4992:2: ( ( () otherlv_1= Null ) )
            // InternalRuleEngineParser.g:4993:2: ( () otherlv_1= Null )
            {
            // InternalRuleEngineParser.g:4993:2: ( () otherlv_1= Null )
            // InternalRuleEngineParser.g:4994:3: () otherlv_1= Null
            {
            // InternalRuleEngineParser.g:4994:3: ()
            // InternalRuleEngineParser.g:4995:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Null,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXNullLiteral"


    // $ANTLR start "entryRuleXNumberLiteral"
    // InternalRuleEngineParser.g:5009:1: entryRuleXNumberLiteral returns [EObject current=null] : iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
    public final EObject entryRuleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXNumberLiteral = null;


        try {
            // InternalRuleEngineParser.g:5009:55: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
            // InternalRuleEngineParser.g:5010:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXNumberLiteral=ruleXNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXNumberLiteral"


    // $ANTLR start "ruleXNumberLiteral"
    // InternalRuleEngineParser.g:5016:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
    public final EObject ruleXNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5022:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
            // InternalRuleEngineParser.g:5023:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            {
            // InternalRuleEngineParser.g:5023:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
            // InternalRuleEngineParser.g:5024:3: () ( (lv_value_1_0= ruleNumber ) )
            {
            // InternalRuleEngineParser.g:5024:3: ()
            // InternalRuleEngineParser.g:5025:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:5031:3: ( (lv_value_1_0= ruleNumber ) )
            // InternalRuleEngineParser.g:5032:4: (lv_value_1_0= ruleNumber )
            {
            // InternalRuleEngineParser.g:5032:4: (lv_value_1_0= ruleNumber )
            // InternalRuleEngineParser.g:5033:5: lv_value_1_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.xbase.Xbase.Number");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXNumberLiteral"


    // $ANTLR start "entryRuleXStringLiteral"
    // InternalRuleEngineParser.g:5054:1: entryRuleXStringLiteral returns [EObject current=null] : iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
    public final EObject entryRuleXStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXStringLiteral = null;


        try {
            // InternalRuleEngineParser.g:5054:55: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
            // InternalRuleEngineParser.g:5055:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXStringLiteral=ruleXStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXStringLiteral"


    // $ANTLR start "ruleXStringLiteral"
    // InternalRuleEngineParser.g:5061:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleXStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:5067:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalRuleEngineParser.g:5068:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalRuleEngineParser.g:5068:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalRuleEngineParser.g:5069:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalRuleEngineParser.g:5069:3: ()
            // InternalRuleEngineParser.g:5070:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalRuleEngineParser.g:5076:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalRuleEngineParser.g:5077:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalRuleEngineParser.g:5077:4: (lv_value_1_0= RULE_STRING )
            // InternalRuleEngineParser.g:5078:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.xbase.Xtype.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXStringLiteral"


    // $ANTLR start "entryRuleXTypeLiteral"
    // InternalRuleEngineParser.g:5098:1: entryRuleXTypeLiteral returns [EObject current=null] : iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
    public final EObject entryRuleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeLiteral = null;


        try {
            // InternalRuleEngineParser.g:5098:53: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
            // InternalRuleEngineParser.g:5099:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTypeLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTypeLiteral=ruleXTypeLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTypeLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTypeLiteral"


    // $ANTLR start "ruleXTypeLiteral"
    // InternalRuleEngineParser.g:5105:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= Typeof otherlv_2= LeftParenthesis ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= RightParenthesis ) ;
    public final EObject ruleXTypeLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_arrayDimensions_4_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5111:2: ( ( () otherlv_1= Typeof otherlv_2= LeftParenthesis ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= RightParenthesis ) )
            // InternalRuleEngineParser.g:5112:2: ( () otherlv_1= Typeof otherlv_2= LeftParenthesis ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= RightParenthesis )
            {
            // InternalRuleEngineParser.g:5112:2: ( () otherlv_1= Typeof otherlv_2= LeftParenthesis ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= RightParenthesis )
            // InternalRuleEngineParser.g:5113:3: () otherlv_1= Typeof otherlv_2= LeftParenthesis ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= RightParenthesis
            {
            // InternalRuleEngineParser.g:5113:3: ()
            // InternalRuleEngineParser.g:5114:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Typeof,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:5128:3: ( ( ruleQualifiedName ) )
            // InternalRuleEngineParser.g:5129:4: ( ruleQualifiedName )
            {
            // InternalRuleEngineParser.g:5129:4: ( ruleQualifiedName )
            // InternalRuleEngineParser.g:5130:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getXTypeLiteralRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0());
              				
            }
            pushFollow(FOLLOW_72);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:5144:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
            loop86:
            do {
                int alt86=2;
                int LA86_0 = input.LA(1);

                if ( (LA86_0==LeftSquareBracket) ) {
                    alt86=1;
                }


                switch (alt86) {
            	case 1 :
            	    // InternalRuleEngineParser.g:5145:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    {
            	    // InternalRuleEngineParser.g:5145:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
            	    // InternalRuleEngineParser.g:5146:5: lv_arrayDimensions_4_0= ruleArrayBrackets
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_72);
            	    lv_arrayDimensions_4_0=ruleArrayBrackets();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getXTypeLiteralRule());
            	      					}
            	      					add(
            	      						current,
            	      						"arrayDimensions",
            	      						lv_arrayDimensions_4_0,
            	      						"org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop86;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXTypeLiteral"


    // $ANTLR start "entryRuleXThrowExpression"
    // InternalRuleEngineParser.g:5171:1: entryRuleXThrowExpression returns [EObject current=null] : iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
    public final EObject entryRuleXThrowExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXThrowExpression = null;


        try {
            // InternalRuleEngineParser.g:5171:57: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
            // InternalRuleEngineParser.g:5172:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXThrowExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXThrowExpression=ruleXThrowExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXThrowExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXThrowExpression"


    // $ANTLR start "ruleXThrowExpression"
    // InternalRuleEngineParser.g:5178:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= Throw ( (lv_expression_2_0= ruleXExpression ) ) ) ;
    public final EObject ruleXThrowExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5184:2: ( ( () otherlv_1= Throw ( (lv_expression_2_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:5185:2: ( () otherlv_1= Throw ( (lv_expression_2_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:5185:2: ( () otherlv_1= Throw ( (lv_expression_2_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:5186:3: () otherlv_1= Throw ( (lv_expression_2_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:5186:3: ()
            // InternalRuleEngineParser.g:5187:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Throw,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:5197:3: ( (lv_expression_2_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:5198:4: (lv_expression_2_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:5198:4: (lv_expression_2_0= ruleXExpression )
            // InternalRuleEngineParser.g:5199:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXThrowExpression"


    // $ANTLR start "entryRuleXReturnExpression"
    // InternalRuleEngineParser.g:5220:1: entryRuleXReturnExpression returns [EObject current=null] : iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
    public final EObject entryRuleXReturnExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXReturnExpression = null;


        try {
            // InternalRuleEngineParser.g:5220:58: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
            // InternalRuleEngineParser.g:5221:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXReturnExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXReturnExpression=ruleXReturnExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXReturnExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXReturnExpression"


    // $ANTLR start "ruleXReturnExpression"
    // InternalRuleEngineParser.g:5227:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= Return ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
    public final EObject ruleXReturnExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5233:2: ( ( () otherlv_1= Return ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
            // InternalRuleEngineParser.g:5234:2: ( () otherlv_1= Return ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            {
            // InternalRuleEngineParser.g:5234:2: ( () otherlv_1= Return ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
            // InternalRuleEngineParser.g:5235:3: () otherlv_1= Return ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            {
            // InternalRuleEngineParser.g:5235:3: ()
            // InternalRuleEngineParser.g:5236:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Return,FOLLOW_58); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:5246:3: ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
            int alt87=2;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalRuleEngineParser.g:5247:4: ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:5248:4: (lv_expression_2_0= ruleXExpression )
                    // InternalRuleEngineParser.g:5249:5: lv_expression_2_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_2_0,
                      						"org.eclipse.xtext.xbase.Xbase.XExpression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXReturnExpression"


    // $ANTLR start "entryRuleXTryCatchFinallyExpression"
    // InternalRuleEngineParser.g:5270:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] : iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
    public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTryCatchFinallyExpression = null;


        try {
            // InternalRuleEngineParser.g:5270:67: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
            // InternalRuleEngineParser.g:5271:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXTryCatchFinallyExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXTryCatchFinallyExpression"


    // $ANTLR start "ruleXTryCatchFinallyExpression"
    // InternalRuleEngineParser.g:5277:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= Try ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
    public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_2_0 = null;

        EObject lv_catchClauses_3_0 = null;

        EObject lv_finallyExpression_5_0 = null;

        EObject lv_finallyExpression_7_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5283:2: ( ( () otherlv_1= Try ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
            // InternalRuleEngineParser.g:5284:2: ( () otherlv_1= Try ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            {
            // InternalRuleEngineParser.g:5284:2: ( () otherlv_1= Try ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
            // InternalRuleEngineParser.g:5285:3: () otherlv_1= Try ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            {
            // InternalRuleEngineParser.g:5285:3: ()
            // InternalRuleEngineParser.g:5286:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Try,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:5296:3: ( (lv_expression_2_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:5297:4: (lv_expression_2_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:5297:4: (lv_expression_2_0= ruleXExpression )
            // InternalRuleEngineParser.g:5298:5: lv_expression_2_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_73);
            lv_expression_2_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:5315:3: ( ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==Catch) ) {
                alt90=1;
            }
            else if ( (LA90_0==Finally) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // InternalRuleEngineParser.g:5316:4: ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    {
                    // InternalRuleEngineParser.g:5316:4: ( ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
                    // InternalRuleEngineParser.g:5317:5: ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    {
                    // InternalRuleEngineParser.g:5317:5: ( ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
                    int cnt88=0;
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==Catch) ) {
                            int LA88_2 = input.LA(2);

                            if ( (synpred38_InternalRuleEngineParser()) ) {
                                alt88=1;
                            }


                        }


                        switch (alt88) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:5318:6: ( Catch )=> (lv_catchClauses_3_0= ruleXCatchClause )
                    	    {
                    	    // InternalRuleEngineParser.g:5319:6: (lv_catchClauses_3_0= ruleXCatchClause )
                    	    // InternalRuleEngineParser.g:5320:7: lv_catchClauses_3_0= ruleXCatchClause
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_74);
                    	    lv_catchClauses_3_0=ruleXCatchClause();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"catchClauses",
                    	      								lv_catchClauses_3_0,
                    	      								"org.eclipse.xtext.xbase.Xbase.XCatchClause");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt88 >= 1 ) break loop88;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(88, input);
                                throw eee;
                        }
                        cnt88++;
                    } while (true);

                    // InternalRuleEngineParser.g:5337:5: ( ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==Finally) ) {
                        int LA89_1 = input.LA(2);

                        if ( (synpred39_InternalRuleEngineParser()) ) {
                            alt89=1;
                        }
                    }
                    switch (alt89) {
                        case 1 :
                            // InternalRuleEngineParser.g:5338:6: ( ( Finally )=>otherlv_4= Finally ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            {
                            // InternalRuleEngineParser.g:5338:6: ( ( Finally )=>otherlv_4= Finally )
                            // InternalRuleEngineParser.g:5339:7: ( Finally )=>otherlv_4= Finally
                            {
                            otherlv_4=(Token)match(input,Finally,FOLLOW_18); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
                              						
                            }

                            }

                            // InternalRuleEngineParser.g:5345:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
                            // InternalRuleEngineParser.g:5346:7: (lv_finallyExpression_5_0= ruleXExpression )
                            {
                            // InternalRuleEngineParser.g:5346:7: (lv_finallyExpression_5_0= ruleXExpression )
                            // InternalRuleEngineParser.g:5347:8: lv_finallyExpression_5_0= ruleXExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0());
                              							
                            }
                            pushFollow(FOLLOW_2);
                            lv_finallyExpression_5_0=ruleXExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                              								}
                              								set(
                              									current,
                              									"finallyExpression",
                              									lv_finallyExpression_5_0,
                              									"org.eclipse.xtext.xbase.Xbase.XExpression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:5367:4: (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    {
                    // InternalRuleEngineParser.g:5367:4: (otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
                    // InternalRuleEngineParser.g:5368:5: otherlv_6= Finally ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    {
                    otherlv_6=(Token)match(input,Finally,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
                      				
                    }
                    // InternalRuleEngineParser.g:5372:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
                    // InternalRuleEngineParser.g:5373:6: (lv_finallyExpression_7_0= ruleXExpression )
                    {
                    // InternalRuleEngineParser.g:5373:6: (lv_finallyExpression_7_0= ruleXExpression )
                    // InternalRuleEngineParser.g:5374:7: lv_finallyExpression_7_0= ruleXExpression
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0());
                      						
                    }
                    pushFollow(FOLLOW_2);
                    lv_finallyExpression_7_0=ruleXExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
                      							}
                      							set(
                      								current,
                      								"finallyExpression",
                      								lv_finallyExpression_7_0,
                      								"org.eclipse.xtext.xbase.Xbase.XExpression");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXTryCatchFinallyExpression"


    // $ANTLR start "entryRuleXSynchronizedExpression"
    // InternalRuleEngineParser.g:5397:1: entryRuleXSynchronizedExpression returns [EObject current=null] : iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
    public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSynchronizedExpression = null;


        try {
            // InternalRuleEngineParser.g:5397:64: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
            // InternalRuleEngineParser.g:5398:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXSynchronizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXSynchronizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXSynchronizedExpression"


    // $ANTLR start "ruleXSynchronizedExpression"
    // InternalRuleEngineParser.g:5404:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_expression_5_0= ruleXExpression ) ) ) ;
    public final EObject ruleXSynchronizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_param_3_0 = null;

        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5410:2: ( ( ( ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_expression_5_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:5411:2: ( ( ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_expression_5_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:5411:2: ( ( ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_expression_5_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:5412:3: ( ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= RightParenthesis ( (lv_expression_5_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:5412:3: ( ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis ) )
            // InternalRuleEngineParser.g:5413:4: ( ( () Synchronized LeftParenthesis ) )=> ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis )
            {
            // InternalRuleEngineParser.g:5420:4: ( () otherlv_1= Synchronized otherlv_2= LeftParenthesis )
            // InternalRuleEngineParser.g:5421:5: () otherlv_1= Synchronized otherlv_2= LeftParenthesis
            {
            // InternalRuleEngineParser.g:5421:5: ()
            // InternalRuleEngineParser.g:5422:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,Synchronized,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
              				
            }

            }


            }

            // InternalRuleEngineParser.g:5438:3: ( (lv_param_3_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:5439:4: (lv_param_3_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:5439:4: (lv_param_3_0= ruleXExpression )
            // InternalRuleEngineParser.g:5440:5: lv_param_3_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_param_3_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
              					}
              					set(
              						current,
              						"param",
              						lv_param_3_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }
            // InternalRuleEngineParser.g:5461:3: ( (lv_expression_5_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:5462:4: (lv_expression_5_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:5462:4: (lv_expression_5_0= ruleXExpression )
            // InternalRuleEngineParser.g:5463:5: lv_expression_5_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_5_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_5_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXSynchronizedExpression"


    // $ANTLR start "entryRuleXCatchClause"
    // InternalRuleEngineParser.g:5484:1: entryRuleXCatchClause returns [EObject current=null] : iv_ruleXCatchClause= ruleXCatchClause EOF ;
    public final EObject entryRuleXCatchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXCatchClause = null;


        try {
            // InternalRuleEngineParser.g:5484:53: (iv_ruleXCatchClause= ruleXCatchClause EOF )
            // InternalRuleEngineParser.g:5485:2: iv_ruleXCatchClause= ruleXCatchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXCatchClauseRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXCatchClause=ruleXCatchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXCatchClause; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXCatchClause"


    // $ANTLR start "ruleXCatchClause"
    // InternalRuleEngineParser.g:5491:1: ruleXCatchClause returns [EObject current=null] : ( ( ( Catch )=>otherlv_0= Catch ) otherlv_1= LeftParenthesis ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= RightParenthesis ( (lv_expression_4_0= ruleXExpression ) ) ) ;
    public final EObject ruleXCatchClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_declaredParam_2_0 = null;

        EObject lv_expression_4_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5497:2: ( ( ( ( Catch )=>otherlv_0= Catch ) otherlv_1= LeftParenthesis ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= RightParenthesis ( (lv_expression_4_0= ruleXExpression ) ) ) )
            // InternalRuleEngineParser.g:5498:2: ( ( ( Catch )=>otherlv_0= Catch ) otherlv_1= LeftParenthesis ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= RightParenthesis ( (lv_expression_4_0= ruleXExpression ) ) )
            {
            // InternalRuleEngineParser.g:5498:2: ( ( ( Catch )=>otherlv_0= Catch ) otherlv_1= LeftParenthesis ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= RightParenthesis ( (lv_expression_4_0= ruleXExpression ) ) )
            // InternalRuleEngineParser.g:5499:3: ( ( Catch )=>otherlv_0= Catch ) otherlv_1= LeftParenthesis ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= RightParenthesis ( (lv_expression_4_0= ruleXExpression ) )
            {
            // InternalRuleEngineParser.g:5499:3: ( ( Catch )=>otherlv_0= Catch )
            // InternalRuleEngineParser.g:5500:4: ( Catch )=>otherlv_0= Catch
            {
            otherlv_0=(Token)match(input,Catch,FOLLOW_59); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:5510:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
            // InternalRuleEngineParser.g:5511:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            {
            // InternalRuleEngineParser.g:5511:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
            // InternalRuleEngineParser.g:5512:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_declaredParam_2_0=ruleFullJvmFormalParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              					}
              					set(
              						current,
              						"declaredParam",
              						lv_declaredParam_2_0,
              						"org.eclipse.xtext.xbase.Xbase.FullJvmFormalParameter");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,RightParenthesis,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalRuleEngineParser.g:5533:3: ( (lv_expression_4_0= ruleXExpression ) )
            // InternalRuleEngineParser.g:5534:4: (lv_expression_4_0= ruleXExpression )
            {
            // InternalRuleEngineParser.g:5534:4: (lv_expression_4_0= ruleXExpression )
            // InternalRuleEngineParser.g:5535:5: lv_expression_4_0= ruleXExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_4_0=ruleXExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_4_0,
              						"org.eclipse.xtext.xbase.Xbase.XExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXCatchClause"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRuleEngineParser.g:5556:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalRuleEngineParser.g:5556:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRuleEngineParser.g:5557:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalRuleEngineParser.g:5563:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5569:2: ( (this_ValidID_0= ruleValidID ( ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID )* ) )
            // InternalRuleEngineParser.g:5570:2: (this_ValidID_0= ruleValidID ( ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID )* )
            {
            // InternalRuleEngineParser.g:5570:2: (this_ValidID_0= ruleValidID ( ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID )* )
            // InternalRuleEngineParser.g:5571:3: this_ValidID_0= ruleValidID ( ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_75);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ValidID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            // InternalRuleEngineParser.g:5581:3: ( ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID )*
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==FullStop) ) {
                    int LA91_2 = input.LA(2);

                    if ( (LA91_2==RULE_ID) ) {
                        int LA91_3 = input.LA(3);

                        if ( (synpred42_InternalRuleEngineParser()) ) {
                            alt91=1;
                        }


                    }


                }


                switch (alt91) {
            	case 1 :
            	    // InternalRuleEngineParser.g:5582:4: ( ( FullStop )=>kw= FullStop ) this_ValidID_2= ruleValidID
            	    {
            	    // InternalRuleEngineParser.g:5582:4: ( ( FullStop )=>kw= FullStop )
            	    // InternalRuleEngineParser.g:5583:5: ( FullStop )=>kw= FullStop
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					current.merge(kw);
            	      					newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_75);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ValidID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop91;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNumber"
    // InternalRuleEngineParser.g:5605:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalRuleEngineParser.g:5607:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalRuleEngineParser.g:5608:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalRuleEngineParser.g:5617:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_HEX_0=null;
        Token this_INT_1=null;
        Token this_DECIMAL_2=null;
        Token kw=null;
        Token this_INT_4=null;
        Token this_DECIMAL_5=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalRuleEngineParser.g:5624:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
            // InternalRuleEngineParser.g:5625:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            {
            // InternalRuleEngineParser.g:5625:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? ) )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RULE_HEX) ) {
                alt95=1;
            }
            else if ( ((LA95_0>=RULE_INT && LA95_0<=RULE_DECIMAL)) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // InternalRuleEngineParser.g:5626:3: this_HEX_0= RULE_HEX
                    {
                    this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_HEX_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:5634:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    {
                    // InternalRuleEngineParser.g:5634:3: ( (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )? )
                    // InternalRuleEngineParser.g:5635:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL ) (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    {
                    // InternalRuleEngineParser.g:5635:4: (this_INT_1= RULE_INT | this_DECIMAL_2= RULE_DECIMAL )
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==RULE_INT) ) {
                        alt92=1;
                    }
                    else if ( (LA92_0==RULE_DECIMAL) ) {
                        alt92=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 92, 0, input);

                        throw nvae;
                    }
                    switch (alt92) {
                        case 1 :
                            // InternalRuleEngineParser.g:5636:5: this_INT_1= RULE_INT
                            {
                            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_75); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(this_INT_1);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalRuleEngineParser.g:5644:5: this_DECIMAL_2= RULE_DECIMAL
                            {
                            this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_75); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(this_DECIMAL_2);
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
                              				
                            }

                            }
                            break;

                    }

                    // InternalRuleEngineParser.g:5652:4: (kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL ) )?
                    int alt94=2;
                    int LA94_0 = input.LA(1);

                    if ( (LA94_0==FullStop) ) {
                        int LA94_1 = input.LA(2);

                        if ( ((LA94_1>=RULE_INT && LA94_1<=RULE_DECIMAL)) ) {
                            alt94=1;
                        }
                    }
                    switch (alt94) {
                        case 1 :
                            // InternalRuleEngineParser.g:5653:5: kw= FullStop (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            {
                            kw=(Token)match(input,FullStop,FOLLOW_76); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					current.merge(kw);
                              					newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
                              				
                            }
                            // InternalRuleEngineParser.g:5658:5: (this_INT_4= RULE_INT | this_DECIMAL_5= RULE_DECIMAL )
                            int alt93=2;
                            int LA93_0 = input.LA(1);

                            if ( (LA93_0==RULE_INT) ) {
                                alt93=1;
                            }
                            else if ( (LA93_0==RULE_DECIMAL) ) {
                                alt93=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 93, 0, input);

                                throw nvae;
                            }
                            switch (alt93) {
                                case 1 :
                                    // InternalRuleEngineParser.g:5659:6: this_INT_4= RULE_INT
                                    {
                                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						current.merge(this_INT_4);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0());
                                      					
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalRuleEngineParser.g:5667:6: this_DECIMAL_5= RULE_DECIMAL
                                    {
                                    this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      						current.merge(this_DECIMAL_5);
                                      					
                                    }
                                    if ( state.backtracking==0 ) {

                                      						newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1());
                                      					
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleJvmTypeReference"
    // InternalRuleEngineParser.g:5684:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // InternalRuleEngineParser.g:5684:57: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // InternalRuleEngineParser.g:5685:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // InternalRuleEngineParser.g:5691:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_3 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5697:2: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // InternalRuleEngineParser.g:5698:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // InternalRuleEngineParser.g:5698:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==RULE_ID) ) {
                alt97=1;
            }
            else if ( (LA97_0==EqualsSignGreaterThanSign||LA97_0==LeftParenthesis) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // InternalRuleEngineParser.g:5699:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // InternalRuleEngineParser.g:5699:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // InternalRuleEngineParser.g:5700:4: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_70);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_JvmParameterizedTypeReference_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalRuleEngineParser.g:5708:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop96:
                    do {
                        int alt96=2;
                        int LA96_0 = input.LA(1);

                        if ( (LA96_0==LeftSquareBracket) ) {
                            int LA96_2 = input.LA(2);

                            if ( (LA96_2==RightSquareBracket) ) {
                                int LA96_3 = input.LA(3);

                                if ( (synpred43_InternalRuleEngineParser()) ) {
                                    alt96=1;
                                }


                            }


                        }


                        switch (alt96) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:5709:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // InternalRuleEngineParser.g:5715:5: ( () ruleArrayBrackets )
                    	    // InternalRuleEngineParser.g:5716:6: () ruleArrayBrackets
                    	    {
                    	    // InternalRuleEngineParser.g:5716:6: ()
                    	    // InternalRuleEngineParser.g:5717:7: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							current = forceCreateModelElementAndSet(
                    	      								grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	      								current);
                    	      						
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_70);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop96;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:5734:3: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_XFunctionTypeRef_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // InternalRuleEngineParser.g:5746:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // InternalRuleEngineParser.g:5746:53: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // InternalRuleEngineParser.g:5747:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // InternalRuleEngineParser.g:5753:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LeftSquareBracket kw= RightSquareBracket ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:5759:2: ( (kw= LeftSquareBracket kw= RightSquareBracket ) )
            // InternalRuleEngineParser.g:5760:2: (kw= LeftSquareBracket kw= RightSquareBracket )
            {
            // InternalRuleEngineParser.g:5760:2: (kw= LeftSquareBracket kw= RightSquareBracket )
            // InternalRuleEngineParser.g:5761:3: kw= LeftSquareBracket kw= RightSquareBracket
            {
            kw=(Token)match(input,LeftSquareBracket,FOLLOW_56); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
              		
            }
            kw=(Token)match(input,RightSquareBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // InternalRuleEngineParser.g:5775:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // InternalRuleEngineParser.g:5775:57: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // InternalRuleEngineParser.g:5776:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // InternalRuleEngineParser.g:5782:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis )? otherlv_5= EqualsSignGreaterThanSign ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5788:2: ( ( (otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis )? otherlv_5= EqualsSignGreaterThanSign ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // InternalRuleEngineParser.g:5789:2: ( (otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis )? otherlv_5= EqualsSignGreaterThanSign ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // InternalRuleEngineParser.g:5789:2: ( (otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis )? otherlv_5= EqualsSignGreaterThanSign ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // InternalRuleEngineParser.g:5790:3: (otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis )? otherlv_5= EqualsSignGreaterThanSign ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // InternalRuleEngineParser.g:5790:3: (otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==LeftParenthesis) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalRuleEngineParser.g:5791:4: otherlv_0= LeftParenthesis ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= RightParenthesis
                    {
                    otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_77); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    // InternalRuleEngineParser.g:5795:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt99=2;
                    int LA99_0 = input.LA(1);

                    if ( (LA99_0==EqualsSignGreaterThanSign||LA99_0==LeftParenthesis||LA99_0==RULE_ID) ) {
                        alt99=1;
                    }
                    switch (alt99) {
                        case 1 :
                            // InternalRuleEngineParser.g:5796:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // InternalRuleEngineParser.g:5796:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // InternalRuleEngineParser.g:5797:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // InternalRuleEngineParser.g:5797:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // InternalRuleEngineParser.g:5798:7: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_46);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              							}
                              							add(
                              								current,
                              								"paramTypes",
                              								lv_paramTypes_1_0,
                              								"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalRuleEngineParser.g:5815:5: (otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop98:
                            do {
                                int alt98=2;
                                int LA98_0 = input.LA(1);

                                if ( (LA98_0==Comma) ) {
                                    alt98=1;
                                }


                                switch (alt98) {
                            	case 1 :
                            	    // InternalRuleEngineParser.g:5816:6: otherlv_2= Comma ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,Comma,FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	      					
                            	    }
                            	    // InternalRuleEngineParser.g:5820:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // InternalRuleEngineParser.g:5821:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // InternalRuleEngineParser.g:5821:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // InternalRuleEngineParser.g:5822:8: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_46);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"paramTypes",
                            	      									lv_paramTypes_3_0,
                            	      									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop98;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_78); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,EqualsSignGreaterThanSign,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:5850:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // InternalRuleEngineParser.g:5851:4: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // InternalRuleEngineParser.g:5851:4: (lv_returnType_6_0= ruleJvmTypeReference )
            // InternalRuleEngineParser.g:5852:5: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_6_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // InternalRuleEngineParser.g:5873:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // InternalRuleEngineParser.g:5873:70: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // InternalRuleEngineParser.g:5874:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // InternalRuleEngineParser.g:5880:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_10_0 = null;

        EObject lv_arguments_12_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:5886:2: ( ( ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )? ) )
            // InternalRuleEngineParser.g:5887:2: ( ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )? )
            {
            // InternalRuleEngineParser.g:5887:2: ( ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )? )
            // InternalRuleEngineParser.g:5888:3: ( ( ruleQualifiedName ) ) ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )?
            {
            // InternalRuleEngineParser.g:5888:3: ( ( ruleQualifiedName ) )
            // InternalRuleEngineParser.g:5889:4: ( ruleQualifiedName )
            {
            // InternalRuleEngineParser.g:5889:4: ( ruleQualifiedName )
            // InternalRuleEngineParser.g:5890:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_79);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalRuleEngineParser.g:5904:3: ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )?
            int alt105=2;
            alt105 = dfa105.predict(input);
            switch (alt105) {
                case 1 :
                    // InternalRuleEngineParser.g:5905:4: ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )*
                    {
                    // InternalRuleEngineParser.g:5905:4: ( ( LessThanSign )=>otherlv_1= LessThanSign )
                    // InternalRuleEngineParser.g:5906:5: ( LessThanSign )=>otherlv_1= LessThanSign
                    {
                    otherlv_1=(Token)match(input,LessThanSign,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                      				
                    }

                    }

                    // InternalRuleEngineParser.g:5912:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // InternalRuleEngineParser.g:5913:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // InternalRuleEngineParser.g:5913:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // InternalRuleEngineParser.g:5914:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_43);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      						}
                      						add(
                      							current,
                      							"arguments",
                      							lv_arguments_2_0,
                      							"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:5931:4: (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==Comma) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:5932:5: otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,Comma,FOLLOW_42); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalRuleEngineParser.g:5936:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // InternalRuleEngineParser.g:5937:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // InternalRuleEngineParser.g:5937:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // InternalRuleEngineParser.g:5938:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_43);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"arguments",
                    	      								lv_arguments_4_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop101;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,GreaterThanSign,FOLLOW_75); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }
                    // InternalRuleEngineParser.g:5960:4: ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )*
                    loop104:
                    do {
                        int alt104=2;
                        int LA104_0 = input.LA(1);

                        if ( (LA104_0==FullStop) ) {
                            int LA104_2 = input.LA(2);

                            if ( (LA104_2==RULE_ID) ) {
                                int LA104_3 = input.LA(3);

                                if ( (synpred45_InternalRuleEngineParser()) ) {
                                    alt104=1;
                                }


                            }


                        }


                        switch (alt104) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:5961:5: ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )?
                    	    {
                    	    // InternalRuleEngineParser.g:5961:5: ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) )
                    	    // InternalRuleEngineParser.g:5962:6: ( ( () FullStop ) )=> ( () otherlv_7= FullStop )
                    	    {
                    	    // InternalRuleEngineParser.g:5968:6: ( () otherlv_7= FullStop )
                    	    // InternalRuleEngineParser.g:5969:7: () otherlv_7= FullStop
                    	    {
                    	    // InternalRuleEngineParser.g:5969:7: ()
                    	    // InternalRuleEngineParser.g:5970:8: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								current = forceCreateModelElementAndSet(
                    	      									grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
                    	      									current);
                    	      							
                    	    }

                    	    }

                    	    otherlv_7=(Token)match(input,FullStop,FOLLOW_4); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // InternalRuleEngineParser.g:5982:5: ( ( ruleValidID ) )
                    	    // InternalRuleEngineParser.g:5983:6: ( ruleValidID )
                    	    {
                    	    // InternalRuleEngineParser.g:5983:6: ( ruleValidID )
                    	    // InternalRuleEngineParser.g:5984:7: ruleValidID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_80);
                    	    ruleValidID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // InternalRuleEngineParser.g:5998:5: ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )?
                    	    int alt103=2;
                    	    alt103 = dfa103.predict(input);
                    	    switch (alt103) {
                    	        case 1 :
                    	            // InternalRuleEngineParser.g:5999:6: ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign
                    	            {
                    	            // InternalRuleEngineParser.g:5999:6: ( ( LessThanSign )=>otherlv_9= LessThanSign )
                    	            // InternalRuleEngineParser.g:6000:7: ( LessThanSign )=>otherlv_9= LessThanSign
                    	            {
                    	            otherlv_9=(Token)match(input,LessThanSign,FOLLOW_42); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              							newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
                    	              						
                    	            }

                    	            }

                    	            // InternalRuleEngineParser.g:6006:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
                    	            // InternalRuleEngineParser.g:6007:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            {
                    	            // InternalRuleEngineParser.g:6007:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
                    	            // InternalRuleEngineParser.g:6008:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
                    	            {
                    	            if ( state.backtracking==0 ) {

                    	              								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
                    	              							
                    	            }
                    	            pushFollow(FOLLOW_43);
                    	            lv_arguments_10_0=ruleJvmArgumentTypeReference();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              								if (current==null) {
                    	              									current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	              								}
                    	              								add(
                    	              									current,
                    	              									"arguments",
                    	              									lv_arguments_10_0,
                    	              									"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	              								afterParserOrEnumRuleCall();
                    	              							
                    	            }

                    	            }


                    	            }

                    	            // InternalRuleEngineParser.g:6025:6: (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
                    	            loop102:
                    	            do {
                    	                int alt102=2;
                    	                int LA102_0 = input.LA(1);

                    	                if ( (LA102_0==Comma) ) {
                    	                    alt102=1;
                    	                }


                    	                switch (alt102) {
                    	            	case 1 :
                    	            	    // InternalRuleEngineParser.g:6026:7: otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    {
                    	            	    otherlv_11=(Token)match(input,Comma,FOLLOW_42); if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      							newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
                    	            	      						
                    	            	    }
                    	            	    // InternalRuleEngineParser.g:6030:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
                    	            	    // InternalRuleEngineParser.g:6031:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    {
                    	            	    // InternalRuleEngineParser.g:6031:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
                    	            	    // InternalRuleEngineParser.g:6032:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
                    	            	    {
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
                    	            	      								
                    	            	    }
                    	            	    pushFollow(FOLLOW_43);
                    	            	    lv_arguments_12_0=ruleJvmArgumentTypeReference();

                    	            	    state._fsp--;
                    	            	    if (state.failed) return current;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      									if (current==null) {
                    	            	      										current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	            	      									}
                    	            	      									add(
                    	            	      										current,
                    	            	      										"arguments",
                    	            	      										lv_arguments_12_0,
                    	            	      										"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
                    	            	      									afterParserOrEnumRuleCall();
                    	            	      								
                    	            	    }

                    	            	    }


                    	            	    }


                    	            	    }
                    	            	    break;

                    	            	default :
                    	            	    break loop102;
                    	                }
                    	            } while (true);

                    	            otherlv_13=(Token)match(input,GreaterThanSign,FOLLOW_75); if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              						newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
                    	              					
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop104;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // InternalRuleEngineParser.g:6061:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // InternalRuleEngineParser.g:6061:65: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // InternalRuleEngineParser.g:6062:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // InternalRuleEngineParser.g:6068:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6074:2: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // InternalRuleEngineParser.g:6075:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // InternalRuleEngineParser.g:6075:2: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==EqualsSignGreaterThanSign||LA106_0==LeftParenthesis||LA106_0==RULE_ID) ) {
                alt106=1;
            }
            else if ( (LA106_0==QuestionMark) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalRuleEngineParser.g:6076:3: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmTypeReference_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:6085:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_JvmWildcardTypeReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // InternalRuleEngineParser.g:6097:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // InternalRuleEngineParser.g:6097:65: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // InternalRuleEngineParser.g:6098:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // InternalRuleEngineParser.g:6104:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= QuestionMark ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;

        EObject lv_constraints_4_0 = null;

        EObject lv_constraints_5_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6110:2: ( ( () otherlv_1= QuestionMark ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
            // InternalRuleEngineParser.g:6111:2: ( () otherlv_1= QuestionMark ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            {
            // InternalRuleEngineParser.g:6111:2: ( () otherlv_1= QuestionMark ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
            // InternalRuleEngineParser.g:6112:3: () otherlv_1= QuestionMark ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            {
            // InternalRuleEngineParser.g:6112:3: ()
            // InternalRuleEngineParser.g:6113:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,QuestionMark,FOLLOW_81); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
              		
            }
            // InternalRuleEngineParser.g:6123:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
            int alt109=3;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==Extends) ) {
                alt109=1;
            }
            else if ( (LA109_0==Super) ) {
                alt109=2;
            }
            switch (alt109) {
                case 1 :
                    // InternalRuleEngineParser.g:6124:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    {
                    // InternalRuleEngineParser.g:6124:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
                    // InternalRuleEngineParser.g:6125:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    {
                    // InternalRuleEngineParser.g:6125:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // InternalRuleEngineParser.g:6126:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // InternalRuleEngineParser.g:6126:6: (lv_constraints_2_0= ruleJvmUpperBound )
                    // InternalRuleEngineParser.g:6127:7: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
                      						
                    }
                    pushFollow(FOLLOW_82);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      							}
                      							add(
                      								current,
                      								"constraints",
                      								lv_constraints_2_0,
                      								"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:6144:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==Ampersand) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:6145:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    {
                    	    // InternalRuleEngineParser.g:6145:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
                    	    // InternalRuleEngineParser.g:6146:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_82);
                    	    lv_constraints_3_0=ruleJvmUpperBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"constraints",
                    	      								lv_constraints_3_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop107;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:6165:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    {
                    // InternalRuleEngineParser.g:6165:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
                    // InternalRuleEngineParser.g:6166:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    {
                    // InternalRuleEngineParser.g:6166:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
                    // InternalRuleEngineParser.g:6167:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    {
                    // InternalRuleEngineParser.g:6167:6: (lv_constraints_4_0= ruleJvmLowerBound )
                    // InternalRuleEngineParser.g:6168:7: lv_constraints_4_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_82);
                    lv_constraints_4_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      							}
                      							add(
                      								current,
                      								"constraints",
                      								lv_constraints_4_0,
                      								"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:6185:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
                    loop108:
                    do {
                        int alt108=2;
                        int LA108_0 = input.LA(1);

                        if ( (LA108_0==Ampersand) ) {
                            alt108=1;
                        }


                        switch (alt108) {
                    	case 1 :
                    	    // InternalRuleEngineParser.g:6186:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    {
                    	    // InternalRuleEngineParser.g:6186:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
                    	    // InternalRuleEngineParser.g:6187:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_82);
                    	    lv_constraints_5_0=ruleJvmLowerBoundAnded();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"constraints",
                    	      								lv_constraints_5_0,
                    	      								"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop108;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // InternalRuleEngineParser.g:6210:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // InternalRuleEngineParser.g:6210:54: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // InternalRuleEngineParser.g:6211:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // InternalRuleEngineParser.g:6217:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= Extends ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6223:2: ( (otherlv_0= Extends ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalRuleEngineParser.g:6224:2: (otherlv_0= Extends ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalRuleEngineParser.g:6224:2: (otherlv_0= Extends ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalRuleEngineParser.g:6225:3: otherlv_0= Extends ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,Extends,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:6229:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalRuleEngineParser.g:6230:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalRuleEngineParser.g:6230:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalRuleEngineParser.g:6231:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // InternalRuleEngineParser.g:6252:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // InternalRuleEngineParser.g:6252:59: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // InternalRuleEngineParser.g:6253:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // InternalRuleEngineParser.g:6259:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6265:2: ( (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalRuleEngineParser.g:6266:2: (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalRuleEngineParser.g:6266:2: (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalRuleEngineParser.g:6267:3: otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,Ampersand,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:6271:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalRuleEngineParser.g:6272:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalRuleEngineParser.g:6272:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalRuleEngineParser.g:6273:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // InternalRuleEngineParser.g:6294:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // InternalRuleEngineParser.g:6294:54: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // InternalRuleEngineParser.g:6295:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // InternalRuleEngineParser.g:6301:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= Super ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6307:2: ( (otherlv_0= Super ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalRuleEngineParser.g:6308:2: (otherlv_0= Super ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalRuleEngineParser.g:6308:2: (otherlv_0= Super ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalRuleEngineParser.g:6309:3: otherlv_0= Super ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,Super,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:6313:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalRuleEngineParser.g:6314:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalRuleEngineParser.g:6314:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalRuleEngineParser.g:6315:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleJvmLowerBoundAnded"
    // InternalRuleEngineParser.g:6336:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] : iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
    public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBoundAnded = null;


        try {
            // InternalRuleEngineParser.g:6336:59: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
            // InternalRuleEngineParser.g:6337:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBoundAnded; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBoundAnded"


    // $ANTLR start "ruleJvmLowerBoundAnded"
    // InternalRuleEngineParser.g:6343:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6349:2: ( (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // InternalRuleEngineParser.g:6350:2: (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // InternalRuleEngineParser.g:6350:2: (otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // InternalRuleEngineParser.g:6351:3: otherlv_0= Ampersand ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,Ampersand,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:6355:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // InternalRuleEngineParser.g:6356:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // InternalRuleEngineParser.g:6356:4: (lv_typeReference_1_0= ruleJvmTypeReference )
            // InternalRuleEngineParser.g:6357:5: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
              					}
              					set(
              						current,
              						"typeReference",
              						lv_typeReference_1_0,
              						"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleJvmLowerBoundAnded"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalRuleEngineParser.g:6378:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalRuleEngineParser.g:6378:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalRuleEngineParser.g:6379:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildcard.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalRuleEngineParser.g:6385:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= FullStop kw= Asterisk ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6391:2: ( (this_QualifiedName_0= ruleQualifiedName kw= FullStop kw= Asterisk ) )
            // InternalRuleEngineParser.g:6392:2: (this_QualifiedName_0= ruleQualifiedName kw= FullStop kw= Asterisk )
            {
            // InternalRuleEngineParser.g:6392:2: (this_QualifiedName_0= ruleQualifiedName kw= FullStop kw= Asterisk )
            // InternalRuleEngineParser.g:6393:3: this_QualifiedName_0= ruleQualifiedName kw= FullStop kw= Asterisk
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_83);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_QualifiedName_0);
              		
            }
            if ( state.backtracking==0 ) {

              			afterParserOrEnumRuleCall();
              		
            }
            kw=(Token)match(input,FullStop,FOLLOW_84); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
              		
            }
            kw=(Token)match(input,Asterisk,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleValidID"
    // InternalRuleEngineParser.g:6417:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // InternalRuleEngineParser.g:6417:47: (iv_ruleValidID= ruleValidID EOF )
            // InternalRuleEngineParser.g:6418:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // InternalRuleEngineParser.g:6424:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalRuleEngineParser.g:6430:2: (this_ID_0= RULE_ID )
            // InternalRuleEngineParser.g:6431:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportDeclaration"
    // InternalRuleEngineParser.g:6441:1: entryRuleXImportDeclaration returns [EObject current=null] : iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
    public final EObject entryRuleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportDeclaration = null;


        try {
            // InternalRuleEngineParser.g:6441:59: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
            // InternalRuleEngineParser.g:6442:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleXImportDeclaration=ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // InternalRuleEngineParser.g:6448:1: ruleXImportDeclaration returns [EObject current=null] : (otherlv_0= Import ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= Semicolon )? ) ;
    public final EObject ruleXImportDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_static_1_0=null;
        Token lv_extension_2_0=null;
        Token lv_wildcard_4_0=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_memberName_5_0 = null;

        AntlrDatatypeRuleToken lv_importedNamespace_7_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6454:2: ( (otherlv_0= Import ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= Semicolon )? ) )
            // InternalRuleEngineParser.g:6455:2: (otherlv_0= Import ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= Semicolon )? )
            {
            // InternalRuleEngineParser.g:6455:2: (otherlv_0= Import ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= Semicolon )? )
            // InternalRuleEngineParser.g:6456:3: otherlv_0= Import ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= Semicolon )?
            {
            otherlv_0=(Token)match(input,Import,FOLLOW_85); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
              		
            }
            // InternalRuleEngineParser.g:6460:3: ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
            int alt112=3;
            alt112 = dfa112.predict(input);
            switch (alt112) {
                case 1 :
                    // InternalRuleEngineParser.g:6461:4: ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    {
                    // InternalRuleEngineParser.g:6461:4: ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
                    // InternalRuleEngineParser.g:6462:5: ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    {
                    // InternalRuleEngineParser.g:6462:5: ( (lv_static_1_0= Static ) )
                    // InternalRuleEngineParser.g:6463:6: (lv_static_1_0= Static )
                    {
                    // InternalRuleEngineParser.g:6463:6: (lv_static_1_0= Static )
                    // InternalRuleEngineParser.g:6464:7: lv_static_1_0= Static
                    {
                    lv_static_1_0=(Token)match(input,Static,FOLLOW_86); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      							}
                      							setWithLastConsumed(current, "static", true, "static");
                      						
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:6476:5: ( (lv_extension_2_0= Extension ) )?
                    int alt110=2;
                    int LA110_0 = input.LA(1);

                    if ( (LA110_0==Extension) ) {
                        alt110=1;
                    }
                    switch (alt110) {
                        case 1 :
                            // InternalRuleEngineParser.g:6477:6: (lv_extension_2_0= Extension )
                            {
                            // InternalRuleEngineParser.g:6477:6: (lv_extension_2_0= Extension )
                            // InternalRuleEngineParser.g:6478:7: lv_extension_2_0= Extension
                            {
                            lv_extension_2_0=(Token)match(input,Extension,FOLLOW_86); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              							}
                              							setWithLastConsumed(current, "extension", true, "extension");
                              						
                            }

                            }


                            }
                            break;

                    }

                    // InternalRuleEngineParser.g:6490:5: ( ( ruleQualifiedNameInStaticImport ) )
                    // InternalRuleEngineParser.g:6491:6: ( ruleQualifiedNameInStaticImport )
                    {
                    // InternalRuleEngineParser.g:6491:6: ( ruleQualifiedNameInStaticImport )
                    // InternalRuleEngineParser.g:6492:7: ruleQualifiedNameInStaticImport
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      							}
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
                      						
                    }
                    pushFollow(FOLLOW_87);
                    ruleQualifiedNameInStaticImport();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalRuleEngineParser.g:6506:5: ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==Asterisk) ) {
                        alt111=1;
                    }
                    else if ( (LA111_0==RULE_ID) ) {
                        alt111=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 111, 0, input);

                        throw nvae;
                    }
                    switch (alt111) {
                        case 1 :
                            // InternalRuleEngineParser.g:6507:6: ( (lv_wildcard_4_0= Asterisk ) )
                            {
                            // InternalRuleEngineParser.g:6507:6: ( (lv_wildcard_4_0= Asterisk ) )
                            // InternalRuleEngineParser.g:6508:7: (lv_wildcard_4_0= Asterisk )
                            {
                            // InternalRuleEngineParser.g:6508:7: (lv_wildcard_4_0= Asterisk )
                            // InternalRuleEngineParser.g:6509:8: lv_wildcard_4_0= Asterisk
                            {
                            lv_wildcard_4_0=(Token)match(input,Asterisk,FOLLOW_88); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getXImportDeclarationRule());
                              								}
                              								setWithLastConsumed(current, "wildcard", true, "*");
                              							
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalRuleEngineParser.g:6522:6: ( (lv_memberName_5_0= ruleValidID ) )
                            {
                            // InternalRuleEngineParser.g:6522:6: ( (lv_memberName_5_0= ruleValidID ) )
                            // InternalRuleEngineParser.g:6523:7: (lv_memberName_5_0= ruleValidID )
                            {
                            // InternalRuleEngineParser.g:6523:7: (lv_memberName_5_0= ruleValidID )
                            // InternalRuleEngineParser.g:6524:8: lv_memberName_5_0= ruleValidID
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
                              							
                            }
                            pushFollow(FOLLOW_88);
                            lv_memberName_5_0=ruleValidID();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                              								}
                              								set(
                              									current,
                              									"memberName",
                              									lv_memberName_5_0,
                              									"org.eclipse.xtext.xbase.Xtype.ValidID");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalRuleEngineParser.g:6544:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalRuleEngineParser.g:6544:4: ( ( ruleQualifiedName ) )
                    // InternalRuleEngineParser.g:6545:5: ( ruleQualifiedName )
                    {
                    // InternalRuleEngineParser.g:6545:5: ( ruleQualifiedName )
                    // InternalRuleEngineParser.g:6546:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getXImportDeclarationRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_88);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalRuleEngineParser.g:6561:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    {
                    // InternalRuleEngineParser.g:6561:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
                    // InternalRuleEngineParser.g:6562:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    {
                    // InternalRuleEngineParser.g:6562:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
                    // InternalRuleEngineParser.g:6563:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_88);
                    lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"importedNamespace",
                      							lv_importedNamespace_7_0,
                      							"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalRuleEngineParser.g:6581:3: (otherlv_8= Semicolon )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==Semicolon) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalRuleEngineParser.g:6582:4: otherlv_8= Semicolon
                    {
                    otherlv_8=(Token)match(input,Semicolon,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleQualifiedNameInStaticImport"
    // InternalRuleEngineParser.g:6591:1: entryRuleQualifiedNameInStaticImport returns [String current=null] : iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
    public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport = null;


        try {
            // InternalRuleEngineParser.g:6591:67: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
            // InternalRuleEngineParser.g:6592:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameInStaticImport.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameInStaticImport"


    // $ANTLR start "ruleQualifiedNameInStaticImport"
    // InternalRuleEngineParser.g:6598:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= FullStop )+ ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;



        	enterRule();

        try {
            // InternalRuleEngineParser.g:6604:2: ( (this_ValidID_0= ruleValidID kw= FullStop )+ )
            // InternalRuleEngineParser.g:6605:2: (this_ValidID_0= ruleValidID kw= FullStop )+
            {
            // InternalRuleEngineParser.g:6605:2: (this_ValidID_0= ruleValidID kw= FullStop )+
            int cnt114=0;
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==RULE_ID) ) {
                    int LA114_2 = input.LA(2);

                    if ( (LA114_2==FullStop) ) {
                        alt114=1;
                    }


                }


                switch (alt114) {
            	case 1 :
            	    // InternalRuleEngineParser.g:6606:3: this_ValidID_0= ruleValidID kw= FullStop
            	    {
            	    if ( state.backtracking==0 ) {

            	      			newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
            	      		
            	    }
            	    pushFollow(FOLLOW_83);
            	    this_ValidID_0=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			current.merge(this_ValidID_0);
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			afterParserOrEnumRuleCall();
            	      		
            	    }
            	    kw=(Token)match(input,FullStop,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			current.merge(kw);
            	      			newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
            	      		
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt114 >= 1 ) break loop114;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(114, input);
                        throw eee;
                }
                cnt114++;
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQualifiedNameInStaticImport"

    // $ANTLR start synpred1_InternalRuleEngineParser
    public final void synpred1_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:433:6: ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )
        // InternalRuleEngineParser.g:433:7: ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon )
        {
        // InternalRuleEngineParser.g:433:7: ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon )
        // InternalRuleEngineParser.g:434:7: LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon
        {
        match(input,LeftParenthesis,FOLLOW_16); if (state.failed) return ;
        // InternalRuleEngineParser.g:435:7: ( ( ruleJvmFormalParameter ) )
        // InternalRuleEngineParser.g:436:8: ( ruleJvmFormalParameter )
        {
        // InternalRuleEngineParser.g:436:8: ( ruleJvmFormalParameter )
        // InternalRuleEngineParser.g:437:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_17);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,Colon,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalRuleEngineParser

    // $ANTLR start synpred2_InternalRuleEngineParser
    public final void synpred2_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:500:6: ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )
        // InternalRuleEngineParser.g:500:7: ( ( ( ruleJvmFormalParameter ) ) Colon )
        {
        // InternalRuleEngineParser.g:500:7: ( ( ( ruleJvmFormalParameter ) ) Colon )
        // InternalRuleEngineParser.g:501:7: ( ( ruleJvmFormalParameter ) ) Colon
        {
        // InternalRuleEngineParser.g:501:7: ( ( ruleJvmFormalParameter ) )
        // InternalRuleEngineParser.g:502:8: ( ruleJvmFormalParameter )
        {
        // InternalRuleEngineParser.g:502:8: ( ruleJvmFormalParameter )
        // InternalRuleEngineParser.g:503:9: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_17);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,Colon,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalRuleEngineParser

    // $ANTLR start synpred3_InternalRuleEngineParser
    public final void synpred3_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:719:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
        // InternalRuleEngineParser.g:719:7: ( () ( ( ruleOpMultiAssign ) ) )
        {
        // InternalRuleEngineParser.g:719:7: ( () ( ( ruleOpMultiAssign ) ) )
        // InternalRuleEngineParser.g:720:7: () ( ( ruleOpMultiAssign ) )
        {
        // InternalRuleEngineParser.g:720:7: ()
        // InternalRuleEngineParser.g:721:7: 
        {
        }

        // InternalRuleEngineParser.g:722:7: ( ( ruleOpMultiAssign ) )
        // InternalRuleEngineParser.g:723:8: ( ruleOpMultiAssign )
        {
        // InternalRuleEngineParser.g:723:8: ( ruleOpMultiAssign )
        // InternalRuleEngineParser.g:724:9: ruleOpMultiAssign
        {
        pushFollow(FOLLOW_2);
        ruleOpMultiAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalRuleEngineParser

    // $ANTLR start synpred4_InternalRuleEngineParser
    public final void synpred4_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:913:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalRuleEngineParser.g:913:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalRuleEngineParser.g:913:6: ( () ( ( ruleOpOr ) ) )
        // InternalRuleEngineParser.g:914:6: () ( ( ruleOpOr ) )
        {
        // InternalRuleEngineParser.g:914:6: ()
        // InternalRuleEngineParser.g:915:6: 
        {
        }

        // InternalRuleEngineParser.g:916:6: ( ( ruleOpOr ) )
        // InternalRuleEngineParser.g:917:7: ( ruleOpOr )
        {
        // InternalRuleEngineParser.g:917:7: ( ruleOpOr )
        // InternalRuleEngineParser.g:918:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalRuleEngineParser

    // $ANTLR start synpred5_InternalRuleEngineParser
    public final void synpred5_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1020:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalRuleEngineParser.g:1020:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalRuleEngineParser.g:1020:6: ( () ( ( ruleOpAnd ) ) )
        // InternalRuleEngineParser.g:1021:6: () ( ( ruleOpAnd ) )
        {
        // InternalRuleEngineParser.g:1021:6: ()
        // InternalRuleEngineParser.g:1022:6: 
        {
        }

        // InternalRuleEngineParser.g:1023:6: ( ( ruleOpAnd ) )
        // InternalRuleEngineParser.g:1024:7: ( ruleOpAnd )
        {
        // InternalRuleEngineParser.g:1024:7: ( ruleOpAnd )
        // InternalRuleEngineParser.g:1025:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalRuleEngineParser

    // $ANTLR start synpred6_InternalRuleEngineParser
    public final void synpred6_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1127:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalRuleEngineParser.g:1127:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalRuleEngineParser.g:1127:6: ( () ( ( ruleOpEquality ) ) )
        // InternalRuleEngineParser.g:1128:6: () ( ( ruleOpEquality ) )
        {
        // InternalRuleEngineParser.g:1128:6: ()
        // InternalRuleEngineParser.g:1129:6: 
        {
        }

        // InternalRuleEngineParser.g:1130:6: ( ( ruleOpEquality ) )
        // InternalRuleEngineParser.g:1131:7: ( ruleOpEquality )
        {
        // InternalRuleEngineParser.g:1131:7: ( ruleOpEquality )
        // InternalRuleEngineParser.g:1132:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalRuleEngineParser

    // $ANTLR start synpred7_InternalRuleEngineParser
    public final void synpred7_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1255:6: ( ( () Instanceof ) )
        // InternalRuleEngineParser.g:1255:7: ( () Instanceof )
        {
        // InternalRuleEngineParser.g:1255:7: ( () Instanceof )
        // InternalRuleEngineParser.g:1256:7: () Instanceof
        {
        // InternalRuleEngineParser.g:1256:7: ()
        // InternalRuleEngineParser.g:1257:7: 
        {
        }

        match(input,Instanceof,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalRuleEngineParser

    // $ANTLR start synpred8_InternalRuleEngineParser
    public final void synpred8_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1298:6: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalRuleEngineParser.g:1298:7: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalRuleEngineParser.g:1298:7: ( () ( ( ruleOpCompare ) ) )
        // InternalRuleEngineParser.g:1299:7: () ( ( ruleOpCompare ) )
        {
        // InternalRuleEngineParser.g:1299:7: ()
        // InternalRuleEngineParser.g:1300:7: 
        {
        }

        // InternalRuleEngineParser.g:1301:7: ( ( ruleOpCompare ) )
        // InternalRuleEngineParser.g:1302:8: ( ruleOpCompare )
        {
        // InternalRuleEngineParser.g:1302:8: ( ruleOpCompare )
        // InternalRuleEngineParser.g:1303:9: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalRuleEngineParser

    // $ANTLR start synpred9_InternalRuleEngineParser
    public final void synpred9_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1433:5: ( ( () ( ( ruleOpOther ) ) ) )
        // InternalRuleEngineParser.g:1433:6: ( () ( ( ruleOpOther ) ) )
        {
        // InternalRuleEngineParser.g:1433:6: ( () ( ( ruleOpOther ) ) )
        // InternalRuleEngineParser.g:1434:6: () ( ( ruleOpOther ) )
        {
        // InternalRuleEngineParser.g:1434:6: ()
        // InternalRuleEngineParser.g:1435:6: 
        {
        }

        // InternalRuleEngineParser.g:1436:6: ( ( ruleOpOther ) )
        // InternalRuleEngineParser.g:1437:7: ( ruleOpOther )
        {
        // InternalRuleEngineParser.g:1437:7: ( ruleOpOther )
        // InternalRuleEngineParser.g:1438:8: ruleOpOther
        {
        pushFollow(FOLLOW_2);
        ruleOpOther();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalRuleEngineParser

    // $ANTLR start synpred10_InternalRuleEngineParser
    public final void synpred10_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1553:6: ( ( GreaterThanSign GreaterThanSign ) )
        // InternalRuleEngineParser.g:1553:7: ( GreaterThanSign GreaterThanSign )
        {
        // InternalRuleEngineParser.g:1553:7: ( GreaterThanSign GreaterThanSign )
        // InternalRuleEngineParser.g:1554:7: GreaterThanSign GreaterThanSign
        {
        match(input,GreaterThanSign,FOLLOW_33); if (state.failed) return ;
        match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred10_InternalRuleEngineParser

    // $ANTLR start synpred11_InternalRuleEngineParser
    public final void synpred11_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1588:6: ( ( LessThanSign LessThanSign ) )
        // InternalRuleEngineParser.g:1588:7: ( LessThanSign LessThanSign )
        {
        // InternalRuleEngineParser.g:1588:7: ( LessThanSign LessThanSign )
        // InternalRuleEngineParser.g:1589:7: LessThanSign LessThanSign
        {
        match(input,LessThanSign,FOLLOW_24); if (state.failed) return ;
        match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred11_InternalRuleEngineParser

    // $ANTLR start synpred12_InternalRuleEngineParser
    public final void synpred12_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1661:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalRuleEngineParser.g:1661:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalRuleEngineParser.g:1661:6: ( () ( ( ruleOpAdd ) ) )
        // InternalRuleEngineParser.g:1662:6: () ( ( ruleOpAdd ) )
        {
        // InternalRuleEngineParser.g:1662:6: ()
        // InternalRuleEngineParser.g:1663:6: 
        {
        }

        // InternalRuleEngineParser.g:1664:6: ( ( ruleOpAdd ) )
        // InternalRuleEngineParser.g:1665:7: ( ruleOpAdd )
        {
        // InternalRuleEngineParser.g:1665:7: ( ruleOpAdd )
        // InternalRuleEngineParser.g:1666:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred12_InternalRuleEngineParser

    // $ANTLR start synpred13_InternalRuleEngineParser
    public final void synpred13_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:1776:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalRuleEngineParser.g:1776:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalRuleEngineParser.g:1776:6: ( () ( ( ruleOpMulti ) ) )
        // InternalRuleEngineParser.g:1777:6: () ( ( ruleOpMulti ) )
        {
        // InternalRuleEngineParser.g:1777:6: ()
        // InternalRuleEngineParser.g:1778:6: 
        {
        }

        // InternalRuleEngineParser.g:1779:6: ( ( ruleOpMulti ) )
        // InternalRuleEngineParser.g:1780:7: ( ruleOpMulti )
        {
        // InternalRuleEngineParser.g:1780:7: ( ruleOpMulti )
        // InternalRuleEngineParser.g:1781:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred13_InternalRuleEngineParser

    // $ANTLR start synpred14_InternalRuleEngineParser
    public final void synpred14_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2011:5: ( ( () As ) )
        // InternalRuleEngineParser.g:2011:6: ( () As )
        {
        // InternalRuleEngineParser.g:2011:6: ( () As )
        // InternalRuleEngineParser.g:2012:6: () As
        {
        // InternalRuleEngineParser.g:2012:6: ()
        // InternalRuleEngineParser.g:2013:6: 
        {
        }

        match(input,As,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred14_InternalRuleEngineParser

    // $ANTLR start synpred15_InternalRuleEngineParser
    public final void synpred15_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2079:4: ( ( () ( ( ruleOpPostfix ) ) ) )
        // InternalRuleEngineParser.g:2079:5: ( () ( ( ruleOpPostfix ) ) )
        {
        // InternalRuleEngineParser.g:2079:5: ( () ( ( ruleOpPostfix ) ) )
        // InternalRuleEngineParser.g:2080:5: () ( ( ruleOpPostfix ) )
        {
        // InternalRuleEngineParser.g:2080:5: ()
        // InternalRuleEngineParser.g:2081:5: 
        {
        }

        // InternalRuleEngineParser.g:2082:5: ( ( ruleOpPostfix ) )
        // InternalRuleEngineParser.g:2083:6: ( ruleOpPostfix )
        {
        // InternalRuleEngineParser.g:2083:6: ( ruleOpPostfix )
        // InternalRuleEngineParser.g:2084:7: ruleOpPostfix
        {
        pushFollow(FOLLOW_2);
        ruleOpPostfix();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred15_InternalRuleEngineParser

    // $ANTLR start synpred16_InternalRuleEngineParser
    public final void synpred16_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2175:6: ( ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
        // InternalRuleEngineParser.g:2175:7: ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        {
        // InternalRuleEngineParser.g:2175:7: ( () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
        // InternalRuleEngineParser.g:2176:7: () ( FullStop | ( ( ColonColon ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
        {
        // InternalRuleEngineParser.g:2176:7: ()
        // InternalRuleEngineParser.g:2177:7: 
        {
        }

        // InternalRuleEngineParser.g:2178:7: ( FullStop | ( ( ColonColon ) ) )
        int alt115=2;
        int LA115_0 = input.LA(1);

        if ( (LA115_0==FullStop) ) {
            alt115=1;
        }
        else if ( (LA115_0==ColonColon) ) {
            alt115=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 115, 0, input);

            throw nvae;
        }
        switch (alt115) {
            case 1 :
                // InternalRuleEngineParser.g:2179:8: FullStop
                {
                match(input,FullStop,FOLLOW_40); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalRuleEngineParser.g:2181:8: ( ( ColonColon ) )
                {
                // InternalRuleEngineParser.g:2181:8: ( ( ColonColon ) )
                // InternalRuleEngineParser.g:2182:9: ( ColonColon )
                {
                // InternalRuleEngineParser.g:2182:9: ( ColonColon )
                // InternalRuleEngineParser.g:2183:10: ColonColon
                {
                match(input,ColonColon,FOLLOW_40); if (state.failed) return ;

                }


                }


                }
                break;

        }

        // InternalRuleEngineParser.g:2187:7: ( ( ruleFeatureCallID ) )
        // InternalRuleEngineParser.g:2188:8: ( ruleFeatureCallID )
        {
        // InternalRuleEngineParser.g:2188:8: ( ruleFeatureCallID )
        // InternalRuleEngineParser.g:2189:9: ruleFeatureCallID
        {
        pushFollow(FOLLOW_22);
        ruleFeatureCallID();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        pushFollow(FOLLOW_2);
        ruleOpSingleAssign();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred16_InternalRuleEngineParser

    // $ANTLR start synpred17_InternalRuleEngineParser
    public final void synpred17_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2272:6: ( ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) ) )
        // InternalRuleEngineParser.g:2272:7: ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) )
        {
        // InternalRuleEngineParser.g:2272:7: ( () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) ) )
        // InternalRuleEngineParser.g:2273:7: () ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) )
        {
        // InternalRuleEngineParser.g:2273:7: ()
        // InternalRuleEngineParser.g:2274:7: 
        {
        }

        // InternalRuleEngineParser.g:2275:7: ( FullStop | ( ( QuestionMarkFullStop ) ) | ( ( ColonColon ) ) )
        int alt116=3;
        switch ( input.LA(1) ) {
        case FullStop:
            {
            alt116=1;
            }
            break;
        case QuestionMarkFullStop:
            {
            alt116=2;
            }
            break;
        case ColonColon:
            {
            alt116=3;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 116, 0, input);

            throw nvae;
        }

        switch (alt116) {
            case 1 :
                // InternalRuleEngineParser.g:2276:8: FullStop
                {
                match(input,FullStop,FOLLOW_2); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalRuleEngineParser.g:2278:8: ( ( QuestionMarkFullStop ) )
                {
                // InternalRuleEngineParser.g:2278:8: ( ( QuestionMarkFullStop ) )
                // InternalRuleEngineParser.g:2279:9: ( QuestionMarkFullStop )
                {
                // InternalRuleEngineParser.g:2279:9: ( QuestionMarkFullStop )
                // InternalRuleEngineParser.g:2280:10: QuestionMarkFullStop
                {
                match(input,QuestionMarkFullStop,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 3 :
                // InternalRuleEngineParser.g:2284:8: ( ( ColonColon ) )
                {
                // InternalRuleEngineParser.g:2284:8: ( ( ColonColon ) )
                // InternalRuleEngineParser.g:2285:9: ( ColonColon )
                {
                // InternalRuleEngineParser.g:2285:9: ( ColonColon )
                // InternalRuleEngineParser.g:2286:10: ColonColon
                {
                match(input,ColonColon,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred17_InternalRuleEngineParser

    // $ANTLR start synpred18_InternalRuleEngineParser
    public final void synpred18_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2410:7: ( ( LeftParenthesis ) )
        // InternalRuleEngineParser.g:2410:8: ( LeftParenthesis )
        {
        // InternalRuleEngineParser.g:2410:8: ( LeftParenthesis )
        // InternalRuleEngineParser.g:2411:8: LeftParenthesis
        {
        match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred18_InternalRuleEngineParser

    // $ANTLR start synpred19_InternalRuleEngineParser
    public final void synpred19_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2429:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )
        // InternalRuleEngineParser.g:2429:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        {
        // InternalRuleEngineParser.g:2429:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        // InternalRuleEngineParser.g:2430:9: () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) )
        {
        // InternalRuleEngineParser.g:2430:9: ()
        // InternalRuleEngineParser.g:2431:9: 
        {
        }

        // InternalRuleEngineParser.g:2432:9: ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )?
        int alt118=2;
        int LA118_0 = input.LA(1);

        if ( (LA118_0==EqualsSignGreaterThanSign||LA118_0==LeftParenthesis||LA118_0==RULE_ID) ) {
            alt118=1;
        }
        switch (alt118) {
            case 1 :
                // InternalRuleEngineParser.g:2433:10: ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalRuleEngineParser.g:2433:10: ( ( ruleJvmFormalParameter ) )
                // InternalRuleEngineParser.g:2434:11: ( ruleJvmFormalParameter )
                {
                // InternalRuleEngineParser.g:2434:11: ( ruleJvmFormalParameter )
                // InternalRuleEngineParser.g:2435:12: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_55);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalRuleEngineParser.g:2438:10: ( Comma ( ( ruleJvmFormalParameter ) ) )*
                loop117:
                do {
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( (LA117_0==Comma) ) {
                        alt117=1;
                    }


                    switch (alt117) {
                	case 1 :
                	    // InternalRuleEngineParser.g:2439:11: Comma ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,Comma,FOLLOW_16); if (state.failed) return ;
                	    // InternalRuleEngineParser.g:2440:11: ( ( ruleJvmFormalParameter ) )
                	    // InternalRuleEngineParser.g:2441:12: ( ruleJvmFormalParameter )
                	    {
                	    // InternalRuleEngineParser.g:2441:12: ( ruleJvmFormalParameter )
                	    // InternalRuleEngineParser.g:2442:13: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_55);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop117;
                    }
                } while (true);


                }
                break;

        }

        // InternalRuleEngineParser.g:2447:9: ( ( VerticalLine ) )
        // InternalRuleEngineParser.g:2448:10: ( VerticalLine )
        {
        // InternalRuleEngineParser.g:2448:10: ( VerticalLine )
        // InternalRuleEngineParser.g:2449:11: VerticalLine
        {
        match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred19_InternalRuleEngineParser

    // $ANTLR start synpred20_InternalRuleEngineParser
    public final void synpred20_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2526:6: ( ( () LeftSquareBracket ) )
        // InternalRuleEngineParser.g:2526:7: ( () LeftSquareBracket )
        {
        // InternalRuleEngineParser.g:2526:7: ( () LeftSquareBracket )
        // InternalRuleEngineParser.g:2527:7: () LeftSquareBracket
        {
        // InternalRuleEngineParser.g:2527:7: ()
        // InternalRuleEngineParser.g:2528:7: 
        {
        }

        match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred20_InternalRuleEngineParser

    // $ANTLR start synpred21_InternalRuleEngineParser
    public final void synpred21_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2599:4: ( ( () Synchronized LeftParenthesis ) )
        // InternalRuleEngineParser.g:2599:5: ( () Synchronized LeftParenthesis )
        {
        // InternalRuleEngineParser.g:2599:5: ( () Synchronized LeftParenthesis )
        // InternalRuleEngineParser.g:2600:5: () Synchronized LeftParenthesis
        {
        // InternalRuleEngineParser.g:2600:5: ()
        // InternalRuleEngineParser.g:2601:5: 
        {
        }

        match(input,Synchronized,FOLLOW_59); if (state.failed) return ;
        match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred21_InternalRuleEngineParser

    // $ANTLR start synpred22_InternalRuleEngineParser
    public final void synpred22_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2644:4: ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )
        // InternalRuleEngineParser.g:2644:5: ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon )
        {
        // InternalRuleEngineParser.g:2644:5: ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon )
        // InternalRuleEngineParser.g:2645:5: () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon
        {
        // InternalRuleEngineParser.g:2645:5: ()
        // InternalRuleEngineParser.g:2646:5: 
        {
        }

        match(input,For,FOLLOW_59); if (state.failed) return ;
        match(input,LeftParenthesis,FOLLOW_16); if (state.failed) return ;
        // InternalRuleEngineParser.g:2649:5: ( ( ruleJvmFormalParameter ) )
        // InternalRuleEngineParser.g:2650:6: ( ruleJvmFormalParameter )
        {
        // InternalRuleEngineParser.g:2650:6: ( ruleJvmFormalParameter )
        // InternalRuleEngineParser.g:2651:7: ruleJvmFormalParameter
        {
        pushFollow(FOLLOW_17);
        ruleJvmFormalParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,Colon,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalRuleEngineParser

    // $ANTLR start synpred23_InternalRuleEngineParser
    public final void synpred23_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:2758:4: ( ( () LeftSquareBracket ) )
        // InternalRuleEngineParser.g:2758:5: ( () LeftSquareBracket )
        {
        // InternalRuleEngineParser.g:2758:5: ( () LeftSquareBracket )
        // InternalRuleEngineParser.g:2759:5: () LeftSquareBracket
        {
        // InternalRuleEngineParser.g:2759:5: ()
        // InternalRuleEngineParser.g:2760:5: 
        {
        }

        match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred23_InternalRuleEngineParser

    // $ANTLR start synpred25_InternalRuleEngineParser
    public final void synpred25_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:3063:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )
        // InternalRuleEngineParser.g:3063:5: ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        {
        // InternalRuleEngineParser.g:3063:5: ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        // InternalRuleEngineParser.g:3064:5: ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) )
        {
        // InternalRuleEngineParser.g:3064:5: ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )?
        int alt120=2;
        int LA120_0 = input.LA(1);

        if ( (LA120_0==EqualsSignGreaterThanSign||LA120_0==LeftParenthesis||LA120_0==RULE_ID) ) {
            alt120=1;
        }
        switch (alt120) {
            case 1 :
                // InternalRuleEngineParser.g:3065:6: ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalRuleEngineParser.g:3065:6: ( ( ruleJvmFormalParameter ) )
                // InternalRuleEngineParser.g:3066:7: ( ruleJvmFormalParameter )
                {
                // InternalRuleEngineParser.g:3066:7: ( ruleJvmFormalParameter )
                // InternalRuleEngineParser.g:3067:8: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_55);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalRuleEngineParser.g:3070:6: ( Comma ( ( ruleJvmFormalParameter ) ) )*
                loop119:
                do {
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==Comma) ) {
                        alt119=1;
                    }


                    switch (alt119) {
                	case 1 :
                	    // InternalRuleEngineParser.g:3071:7: Comma ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,Comma,FOLLOW_16); if (state.failed) return ;
                	    // InternalRuleEngineParser.g:3072:7: ( ( ruleJvmFormalParameter ) )
                	    // InternalRuleEngineParser.g:3073:8: ( ruleJvmFormalParameter )
                	    {
                	    // InternalRuleEngineParser.g:3073:8: ( ruleJvmFormalParameter )
                	    // InternalRuleEngineParser.g:3074:9: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_55);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop119;
                    }
                } while (true);


                }
                break;

        }

        // InternalRuleEngineParser.g:3079:5: ( ( VerticalLine ) )
        // InternalRuleEngineParser.g:3080:6: ( VerticalLine )
        {
        // InternalRuleEngineParser.g:3080:6: ( VerticalLine )
        // InternalRuleEngineParser.g:3081:7: VerticalLine
        {
        match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred25_InternalRuleEngineParser

    // $ANTLR start synpred27_InternalRuleEngineParser
    public final void synpred27_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:3472:5: ( Else )
        // InternalRuleEngineParser.g:3472:6: Else
        {
        match(input,Else,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalRuleEngineParser

    // $ANTLR start synpred29_InternalRuleEngineParser
    public final void synpred29_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4143:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
        // InternalRuleEngineParser.g:4143:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        {
        // InternalRuleEngineParser.g:4143:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
        // InternalRuleEngineParser.g:4144:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
        {
        // InternalRuleEngineParser.g:4144:6: ( ( ruleJvmTypeReference ) )
        // InternalRuleEngineParser.g:4145:7: ( ruleJvmTypeReference )
        {
        // InternalRuleEngineParser.g:4145:7: ( ruleJvmTypeReference )
        // InternalRuleEngineParser.g:4146:8: ruleJvmTypeReference
        {
        pushFollow(FOLLOW_4);
        ruleJvmTypeReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalRuleEngineParser.g:4149:6: ( ( ruleValidID ) )
        // InternalRuleEngineParser.g:4150:7: ( ruleValidID )
        {
        // InternalRuleEngineParser.g:4150:7: ( ruleValidID )
        // InternalRuleEngineParser.g:4151:8: ruleValidID
        {
        pushFollow(FOLLOW_2);
        ruleValidID();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred29_InternalRuleEngineParser

    // $ANTLR start synpred30_InternalRuleEngineParser
    public final void synpred30_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4455:5: ( ( LeftParenthesis ) )
        // InternalRuleEngineParser.g:4455:6: ( LeftParenthesis )
        {
        // InternalRuleEngineParser.g:4455:6: ( LeftParenthesis )
        // InternalRuleEngineParser.g:4456:6: LeftParenthesis
        {
        match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred30_InternalRuleEngineParser

    // $ANTLR start synpred31_InternalRuleEngineParser
    public final void synpred31_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4474:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )
        // InternalRuleEngineParser.g:4474:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        {
        // InternalRuleEngineParser.g:4474:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        // InternalRuleEngineParser.g:4475:7: () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) )
        {
        // InternalRuleEngineParser.g:4475:7: ()
        // InternalRuleEngineParser.g:4476:7: 
        {
        }

        // InternalRuleEngineParser.g:4477:7: ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )?
        int alt124=2;
        int LA124_0 = input.LA(1);

        if ( (LA124_0==EqualsSignGreaterThanSign||LA124_0==LeftParenthesis||LA124_0==RULE_ID) ) {
            alt124=1;
        }
        switch (alt124) {
            case 1 :
                // InternalRuleEngineParser.g:4478:8: ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalRuleEngineParser.g:4478:8: ( ( ruleJvmFormalParameter ) )
                // InternalRuleEngineParser.g:4479:9: ( ruleJvmFormalParameter )
                {
                // InternalRuleEngineParser.g:4479:9: ( ruleJvmFormalParameter )
                // InternalRuleEngineParser.g:4480:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_55);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalRuleEngineParser.g:4483:8: ( Comma ( ( ruleJvmFormalParameter ) ) )*
                loop123:
                do {
                    int alt123=2;
                    int LA123_0 = input.LA(1);

                    if ( (LA123_0==Comma) ) {
                        alt123=1;
                    }


                    switch (alt123) {
                	case 1 :
                	    // InternalRuleEngineParser.g:4484:9: Comma ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,Comma,FOLLOW_16); if (state.failed) return ;
                	    // InternalRuleEngineParser.g:4485:9: ( ( ruleJvmFormalParameter ) )
                	    // InternalRuleEngineParser.g:4486:10: ( ruleJvmFormalParameter )
                	    {
                	    // InternalRuleEngineParser.g:4486:10: ( ruleJvmFormalParameter )
                	    // InternalRuleEngineParser.g:4487:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_55);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop123;
                    }
                } while (true);


                }
                break;

        }

        // InternalRuleEngineParser.g:4492:7: ( ( VerticalLine ) )
        // InternalRuleEngineParser.g:4493:8: ( VerticalLine )
        {
        // InternalRuleEngineParser.g:4493:8: ( VerticalLine )
        // InternalRuleEngineParser.g:4494:9: VerticalLine
        {
        match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred31_InternalRuleEngineParser

    // $ANTLR start synpred32_InternalRuleEngineParser
    public final void synpred32_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4571:4: ( ( () LeftSquareBracket ) )
        // InternalRuleEngineParser.g:4571:5: ( () LeftSquareBracket )
        {
        // InternalRuleEngineParser.g:4571:5: ( () LeftSquareBracket )
        // InternalRuleEngineParser.g:4572:5: () LeftSquareBracket
        {
        // InternalRuleEngineParser.g:4572:5: ()
        // InternalRuleEngineParser.g:4573:5: 
        {
        }

        match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred32_InternalRuleEngineParser

    // $ANTLR start synpred33_InternalRuleEngineParser
    public final void synpred33_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4731:5: ( LessThanSign )
        // InternalRuleEngineParser.g:4731:6: LessThanSign
        {
        match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalRuleEngineParser

    // $ANTLR start synpred34_InternalRuleEngineParser
    public final void synpred34_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4788:5: ( ( LeftParenthesis ) )
        // InternalRuleEngineParser.g:4788:6: ( LeftParenthesis )
        {
        // InternalRuleEngineParser.g:4788:6: ( LeftParenthesis )
        // InternalRuleEngineParser.g:4789:6: LeftParenthesis
        {
        match(input,LeftParenthesis,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred34_InternalRuleEngineParser

    // $ANTLR start synpred35_InternalRuleEngineParser
    public final void synpred35_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4807:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )
        // InternalRuleEngineParser.g:4807:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        {
        // InternalRuleEngineParser.g:4807:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) )
        // InternalRuleEngineParser.g:4808:7: () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) )
        {
        // InternalRuleEngineParser.g:4808:7: ()
        // InternalRuleEngineParser.g:4809:7: 
        {
        }

        // InternalRuleEngineParser.g:4810:7: ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )?
        int alt126=2;
        int LA126_0 = input.LA(1);

        if ( (LA126_0==EqualsSignGreaterThanSign||LA126_0==LeftParenthesis||LA126_0==RULE_ID) ) {
            alt126=1;
        }
        switch (alt126) {
            case 1 :
                // InternalRuleEngineParser.g:4811:8: ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )*
                {
                // InternalRuleEngineParser.g:4811:8: ( ( ruleJvmFormalParameter ) )
                // InternalRuleEngineParser.g:4812:9: ( ruleJvmFormalParameter )
                {
                // InternalRuleEngineParser.g:4812:9: ( ruleJvmFormalParameter )
                // InternalRuleEngineParser.g:4813:10: ruleJvmFormalParameter
                {
                pushFollow(FOLLOW_55);
                ruleJvmFormalParameter();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // InternalRuleEngineParser.g:4816:8: ( Comma ( ( ruleJvmFormalParameter ) ) )*
                loop125:
                do {
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==Comma) ) {
                        alt125=1;
                    }


                    switch (alt125) {
                	case 1 :
                	    // InternalRuleEngineParser.g:4817:9: Comma ( ( ruleJvmFormalParameter ) )
                	    {
                	    match(input,Comma,FOLLOW_16); if (state.failed) return ;
                	    // InternalRuleEngineParser.g:4818:9: ( ( ruleJvmFormalParameter ) )
                	    // InternalRuleEngineParser.g:4819:10: ( ruleJvmFormalParameter )
                	    {
                	    // InternalRuleEngineParser.g:4819:10: ( ruleJvmFormalParameter )
                	    // InternalRuleEngineParser.g:4820:11: ruleJvmFormalParameter
                	    {
                	    pushFollow(FOLLOW_55);
                	    ruleJvmFormalParameter();

                	    state._fsp--;
                	    if (state.failed) return ;

                	    }


                	    }


                	    }
                	    break;

                	default :
                	    break loop125;
                    }
                } while (true);


                }
                break;

        }

        // InternalRuleEngineParser.g:4825:7: ( ( VerticalLine ) )
        // InternalRuleEngineParser.g:4826:8: ( VerticalLine )
        {
        // InternalRuleEngineParser.g:4826:8: ( VerticalLine )
        // InternalRuleEngineParser.g:4827:9: VerticalLine
        {
        match(input,VerticalLine,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred35_InternalRuleEngineParser

    // $ANTLR start synpred36_InternalRuleEngineParser
    public final void synpred36_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:4904:4: ( ( () LeftSquareBracket ) )
        // InternalRuleEngineParser.g:4904:5: ( () LeftSquareBracket )
        {
        // InternalRuleEngineParser.g:4904:5: ( () LeftSquareBracket )
        // InternalRuleEngineParser.g:4905:5: () LeftSquareBracket
        {
        // InternalRuleEngineParser.g:4905:5: ()
        // InternalRuleEngineParser.g:4906:5: 
        {
        }

        match(input,LeftSquareBracket,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred36_InternalRuleEngineParser

    // $ANTLR start synpred37_InternalRuleEngineParser
    public final void synpred37_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5247:4: ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
        // InternalRuleEngineParser.g:
        {
        if ( input.LA(1)==Synchronized||input.LA(1)==Extension||input.LA(1)==Extends||(input.LA(1)>=Import && input.LA(1)<=Typeof)||(input.LA(1)>=False && input.LA(1)<=While)||input.LA(1)==Null||input.LA(1)==True||(input.LA(1)>=For && input.LA(1)<=Try)||(input.LA(1)>=Do && input.LA(1)<=If)||(input.LA(1)>=ExclamationMark && input.LA(1)<=NumberSign)||input.LA(1)==LeftParenthesis||input.LA(1)==PlusSign||input.LA(1)==HyphenMinus||input.LA(1)==LessThanSign||input.LA(1)==LeftSquareBracket||input.LA(1)==RULE_BEGIN||(input.LA(1)>=RULE_HEX && input.LA(1)<=RULE_STRING) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        }
    }
    // $ANTLR end synpred37_InternalRuleEngineParser

    // $ANTLR start synpred38_InternalRuleEngineParser
    public final void synpred38_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5318:6: ( Catch )
        // InternalRuleEngineParser.g:5318:7: Catch
        {
        match(input,Catch,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalRuleEngineParser

    // $ANTLR start synpred39_InternalRuleEngineParser
    public final void synpred39_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5339:7: ( Finally )
        // InternalRuleEngineParser.g:5339:8: Finally
        {
        match(input,Finally,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalRuleEngineParser

    // $ANTLR start synpred42_InternalRuleEngineParser
    public final void synpred42_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5583:5: ( FullStop )
        // InternalRuleEngineParser.g:5583:6: FullStop
        {
        match(input,FullStop,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalRuleEngineParser

    // $ANTLR start synpred43_InternalRuleEngineParser
    public final void synpred43_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5709:5: ( ( () ruleArrayBrackets ) )
        // InternalRuleEngineParser.g:5709:6: ( () ruleArrayBrackets )
        {
        // InternalRuleEngineParser.g:5709:6: ( () ruleArrayBrackets )
        // InternalRuleEngineParser.g:5710:6: () ruleArrayBrackets
        {
        // InternalRuleEngineParser.g:5710:6: ()
        // InternalRuleEngineParser.g:5711:6: 
        {
        }

        pushFollow(FOLLOW_2);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred43_InternalRuleEngineParser

    // $ANTLR start synpred44_InternalRuleEngineParser
    public final void synpred44_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5906:5: ( LessThanSign )
        // InternalRuleEngineParser.g:5906:6: LessThanSign
        {
        match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalRuleEngineParser

    // $ANTLR start synpred45_InternalRuleEngineParser
    public final void synpred45_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:5962:6: ( ( () FullStop ) )
        // InternalRuleEngineParser.g:5962:7: ( () FullStop )
        {
        // InternalRuleEngineParser.g:5962:7: ( () FullStop )
        // InternalRuleEngineParser.g:5963:7: () FullStop
        {
        // InternalRuleEngineParser.g:5963:7: ()
        // InternalRuleEngineParser.g:5964:7: 
        {
        }

        match(input,FullStop,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred45_InternalRuleEngineParser

    // $ANTLR start synpred46_InternalRuleEngineParser
    public final void synpred46_InternalRuleEngineParser_fragment() throws RecognitionException {   
        // InternalRuleEngineParser.g:6000:7: ( LessThanSign )
        // InternalRuleEngineParser.g:6000:8: LessThanSign
        {
        match(input,LessThanSign,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalRuleEngineParser

    // Delegated rules

    public final boolean synpred20_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred18_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalRuleEngineParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalRuleEngineParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA74 dfa74 = new DFA74(this);
    protected DFA76 dfa76 = new DFA76(this);
    protected DFA80 dfa80 = new DFA80(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA84 dfa84 = new DFA84(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA105 dfa105 = new DFA105(this);
    protected DFA103 dfa103 = new DFA103(this);
    protected DFA112 dfa112 = new DFA112(this);
    static final String dfa_1s = "\43\uffff";
    static final String dfa_2s = "\1\4\1\0\41\uffff";
    static final String dfa_3s = "\1\132\1\0\41\uffff";
    static final String dfa_4s = "\2\uffff\1\2\37\uffff\1\1";
    static final String dfa_5s = "\1\uffff\1\0\41\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\5\2\1\uffff\4\2\3\uffff\1\2\1\uffff\1\2\5\uffff\3\2\21\uffff\1\2\5\uffff\2\2\1\uffff\2\2\2\uffff\1\1\2\uffff\1\2\1\uffff\1\2\4\uffff\1\2\3\uffff\1\2\4\uffff\1\2\1\uffff\5\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "430:3: ( ( ( ( ( LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=> (otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= Colon ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= RightParenthesis ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalRuleEngineParser()) ) {s = 34;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index8_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_7s = "\42\uffff";
    static final String dfa_8s = "\1\4\2\0\37\uffff";
    static final String dfa_9s = "\1\132\2\0\37\uffff";
    static final String dfa_10s = "\3\uffff\1\1\1\2\35\uffff";
    static final String dfa_11s = "\1\0\1\1\1\2\37\uffff}>";
    static final String[] dfa_12s = {
            "\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\5\4\1\uffff\4\4\3\uffff\1\4\1\uffff\1\4\5\uffff\3\4\21\uffff\1\3\5\uffff\2\4\1\uffff\2\4\2\uffff\1\2\2\uffff\1\4\1\uffff\1\4\4\uffff\1\4\3\uffff\1\4\4\uffff\1\4\1\uffff\3\4\1\1\1\4",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "499:5: ( ( ( ( ( ruleJvmFormalParameter ) ) Colon ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= Colon ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_0 = input.LA(1);

                         
                        int index7_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA7_0==RULE_ID) ) {s = 1;}

                        else if ( (LA7_0==LeftParenthesis) ) {s = 2;}

                        else if ( (LA7_0==EqualsSignGreaterThanSign) && (synpred2_InternalRuleEngineParser())) {s = 3;}

                        else if ( (LA7_0==Synchronized||LA7_0==Extension||LA7_0==Extends||(LA7_0>=Import && LA7_0<=Typeof)||(LA7_0>=False && LA7_0<=While)||LA7_0==Null||LA7_0==True||(LA7_0>=For && LA7_0<=Try)||(LA7_0>=Do && LA7_0<=If)||(LA7_0>=ExclamationMark && LA7_0<=NumberSign)||LA7_0==PlusSign||LA7_0==HyphenMinus||LA7_0==LessThanSign||LA7_0==LeftSquareBracket||LA7_0==RULE_BEGIN||(LA7_0>=RULE_HEX && LA7_0<=RULE_DECIMAL)||LA7_0==RULE_STRING) ) {s = 4;}

                         
                        input.seek(index7_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_1 = input.LA(1);

                         
                        int index7_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRuleEngineParser()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index7_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_2 = input.LA(1);

                         
                        int index7_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalRuleEngineParser()) ) {s = 3;}

                        else if ( (true) ) {s = 4;}

                         
                        input.seek(index7_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_13s = "\12\uffff";
    static final String dfa_14s = "\1\10\11\uffff";
    static final String dfa_15s = "\1\4\7\0\2\uffff";
    static final String dfa_16s = "\1\132\7\0\2\uffff";
    static final String dfa_17s = "\10\uffff\1\2\1\1";
    static final String dfa_18s = "\1\uffff\1\3\1\4\1\2\1\1\1\0\1\5\1\6\2\uffff}>";
    static final String[] dfa_19s = {
            "\6\10\1\uffff\12\10\1\uffff\3\10\1\uffff\1\10\1\uffff\3\10\1\uffff\6\10\1\5\2\10\1\3\1\10\1\1\1\10\1\2\2\10\1\4\10\10\1\uffff\6\10\1\uffff\12\10\1\6\1\uffff\1\7\1\uffff\2\10\2\uffff\10\10",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "717:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_5 = input.LA(1);

                         
                        int index11_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_5);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_4 = input.LA(1);

                         
                        int index11_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_3 = input.LA(1);

                         
                        int index11_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_1 = input.LA(1);

                         
                        int index11_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_1);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_2 = input.LA(1);

                         
                        int index11_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA11_6 = input.LA(1);

                         
                        int index11_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA11_7 = input.LA(1);

                         
                        int index11_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalRuleEngineParser()) ) {s = 9;}

                        else if ( (true) ) {s = 8;}

                         
                        input.seek(index11_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_20s = "\13\uffff";
    static final String dfa_21s = "\1\1\12\uffff";
    static final String dfa_22s = "\1\4\1\uffff\10\0\1\uffff";
    static final String dfa_23s = "\1\132\1\uffff\10\0\1\uffff";
    static final String dfa_24s = "\1\uffff\1\2\10\uffff\1\1";
    static final String dfa_25s = "\2\uffff\1\4\1\7\1\6\1\5\1\3\1\0\1\2\1\1\1\uffff}>";
    static final String[] dfa_26s = {
            "\6\1\1\uffff\12\1\1\uffff\3\1\1\uffff\1\1\1\uffff\1\1\1\5\1\1\1\uffff\16\1\1\4\1\6\2\1\1\10\1\1\1\7\2\1\1\11\1\1\1\uffff\6\1\1\uffff\12\1\1\2\1\uffff\1\3\1\uffff\2\1\2\uffff\10\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "()* loopback of 1431:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_9 = input.LA(1);

                         
                        int index21_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_8 = input.LA(1);

                         
                        int index21_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_8);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_6 = input.LA(1);

                         
                        int index21_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_5 = input.LA(1);

                         
                        int index21_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_3 = input.LA(1);

                         
                        int index21_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_InternalRuleEngineParser()) ) {s = 10;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index21_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_27s = "\1\35\2\uffff\1\57\7\uffff";
    static final String dfa_28s = "\1\115\2\uffff\1\115\7\uffff";
    static final String dfa_29s = "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\7\1\10\1\11\1\6\1\3";
    static final String dfa_30s = "\13\uffff}>";
    static final String[] dfa_31s = {
            "\1\2\20\uffff\1\1\1\4\2\uffff\1\7\1\uffff\1\5\2\uffff\1\10\23\uffff\1\6\1\uffff\1\3",
            "",
            "",
            "\1\12\35\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "1507:2: (kw= HyphenMinusGreaterThanSign | kw= FullStopFullStopLessThanSign | (kw= GreaterThanSign kw= FullStopFullStop ) | kw= FullStopFullStop | kw= EqualsSignGreaterThanSign | (kw= GreaterThanSign ( ( ( ( GreaterThanSign GreaterThanSign ) )=> (kw= GreaterThanSign kw= GreaterThanSign ) ) | kw= GreaterThanSign ) ) | (kw= LessThanSign ( ( ( ( LessThanSign LessThanSign ) )=> (kw= LessThanSign kw= LessThanSign ) ) | kw= LessThanSign | kw= EqualsSignGreaterThanSign ) ) | kw= LessThanSignGreaterThanSign | kw= QuestionMarkColon )";
        }
    }
    static final String dfa_32s = "\117\uffff";
    static final String dfa_33s = "\1\2\116\uffff";
    static final String dfa_34s = "\1\4\1\0\115\uffff";
    static final String dfa_35s = "\1\132\1\0\115\uffff";
    static final String dfa_36s = "\2\uffff\1\2\113\uffff\1\1";
    static final String dfa_37s = "\1\uffff\1\0\115\uffff}>";
    static final String[] dfa_38s = {
            "\6\2\1\uffff\12\2\1\uffff\3\2\1\uffff\1\2\1\uffff\3\2\1\uffff\31\2\1\uffff\6\2\1\uffff\1\1\12\2\1\uffff\1\2\1\uffff\2\2\2\uffff\10\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "2408:5: ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_17_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= RightParenthesis )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_1 = input.LA(1);

                         
                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index40_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_39s = "\44\uffff";
    static final String dfa_40s = "\1\4\2\0\41\uffff";
    static final String dfa_41s = "\1\132\2\0\41\uffff";
    static final String dfa_42s = "\3\uffff\2\1\1\2\35\uffff\1\3";
    static final String dfa_43s = "\1\0\1\1\1\2\41\uffff}>";
    static final String[] dfa_44s = {
            "\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\5\5\1\uffff\4\5\3\uffff\1\5\1\uffff\1\5\5\uffff\3\5\21\uffff\1\3\5\uffff\2\5\1\uffff\2\5\2\uffff\1\2\1\43\1\uffff\1\5\1\uffff\1\5\4\uffff\1\5\3\uffff\1\5\2\uffff\1\4\1\uffff\1\5\1\uffff\3\5\1\1\1\5",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "2427:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= Comma ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_0 = input.LA(1);

                         
                        int index39_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA39_0==RULE_ID) ) {s = 1;}

                        else if ( (LA39_0==LeftParenthesis) ) {s = 2;}

                        else if ( (LA39_0==EqualsSignGreaterThanSign) && (synpred19_InternalRuleEngineParser())) {s = 3;}

                        else if ( (LA39_0==VerticalLine) && (synpred19_InternalRuleEngineParser())) {s = 4;}

                        else if ( (LA39_0==Synchronized||LA39_0==Extension||LA39_0==Extends||(LA39_0>=Import && LA39_0<=Typeof)||(LA39_0>=False && LA39_0<=While)||LA39_0==Null||LA39_0==True||(LA39_0>=For && LA39_0<=Try)||(LA39_0>=Do && LA39_0<=If)||(LA39_0>=ExclamationMark && LA39_0<=NumberSign)||LA39_0==PlusSign||LA39_0==HyphenMinus||LA39_0==LessThanSign||LA39_0==LeftSquareBracket||LA39_0==RULE_BEGIN||(LA39_0>=RULE_HEX && LA39_0<=RULE_DECIMAL)||LA39_0==RULE_STRING) ) {s = 5;}

                        else if ( (LA39_0==RightParenthesis) ) {s = 35;}

                         
                        input.seek(index39_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred19_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_45s = {
            "\6\2\1\uffff\12\2\1\uffff\3\2\1\uffff\1\2\1\uffff\3\2\1\uffff\31\2\1\uffff\6\2\1\uffff\13\2\1\uffff\1\2\1\uffff\1\1\1\2\2\uffff\10\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "2525:5: ( ( ( () LeftSquareBracket ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA41_1 = input.LA(1);

                         
                        int index41_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred20_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index41_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_46s = "\40\uffff";
    static final String dfa_47s = "\1\4\26\uffff\1\0\10\uffff";
    static final String dfa_48s = "\1\132\26\uffff\1\0\10\uffff";
    static final String dfa_49s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\6\uffff\1\6\11\uffff\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\11";
    static final String dfa_50s = "\1\0\26\uffff\1\1\10\uffff}>";
    static final String[] dfa_51s = {
            "\1\4\1\uffff\1\5\1\uffff\1\5\2\uffff\1\5\1\33\1\5\1\3\1\14\1\uffff\1\14\1\5\1\32\1\30\3\uffff\1\14\1\uffff\1\14\5\uffff\1\27\1\1\1\34\27\uffff\1\31\1\26\2\uffff\1\14\2\uffff\1\35\11\uffff\1\5\3\uffff\1\14\4\uffff\1\2\1\uffff\3\14\1\5\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[][] dfa_51 = unpackEncodedStringArray(dfa_51s);

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_46;
            this.eof = dfa_46;
            this.min = dfa_47;
            this.max = dfa_48;
            this.accept = dfa_49;
            this.special = dfa_50;
            this.transition = dfa_51;
        }
        public String getDescription() {
            return "2570:2: (this_XConstructorCall_0= ruleXConstructorCall | this_XBlockExpression_1= ruleXBlockExpression | this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () Synchronized LeftParenthesis ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) | this_XFeatureCall_4= ruleXFeatureCall | this_XLiteral_5= ruleXLiteral | this_XIfExpression_6= ruleXIfExpression | ( ( ( () For LeftParenthesis ( ( ruleJvmFormalParameter ) ) Colon ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) | this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression | this_XWhileExpression_9= ruleXWhileExpression | this_XDoWhileExpression_10= ruleXDoWhileExpression | this_XThrowExpression_11= ruleXThrowExpression | this_XReturnExpression_12= ruleXReturnExpression | this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression | this_XParenthesizedExpression_14= ruleXParenthesizedExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_0 = input.LA(1);

                         
                        int index43_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA43_0==New) ) {s = 1;}

                        else if ( (LA43_0==RULE_BEGIN) ) {s = 2;}

                        else if ( (LA43_0==Switch) ) {s = 3;}

                        else if ( (LA43_0==Synchronized) && (synpred21_InternalRuleEngineParser())) {s = 4;}

                        else if ( (LA43_0==Extension||LA43_0==Extends||LA43_0==Import||LA43_0==Static||LA43_0==Super||LA43_0==LessThanSign||LA43_0==RULE_ID) ) {s = 5;}

                        else if ( (LA43_0==Typeof||LA43_0==False||LA43_0==Null||LA43_0==True||LA43_0==NumberSign||LA43_0==LeftSquareBracket||(LA43_0>=RULE_HEX && LA43_0<=RULE_DECIMAL)||LA43_0==RULE_STRING) ) {s = 12;}

                        else if ( (LA43_0==If) ) {s = 22;}

                        else if ( (LA43_0==For) ) {s = 23;}

                        else if ( (LA43_0==While) ) {s = 24;}

                        else if ( (LA43_0==Do) ) {s = 25;}

                        else if ( (LA43_0==Throw) ) {s = 26;}

                        else if ( (LA43_0==Return) ) {s = 27;}

                        else if ( (LA43_0==Try) ) {s = 28;}

                        else if ( (LA43_0==LeftParenthesis) ) {s = 29;}

                         
                        input.seek(index43_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_23 = input.LA(1);

                         
                        int index43_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalRuleEngineParser()) ) {s = 30;}

                        else if ( (true) ) {s = 31;}

                         
                        input.seek(index43_23);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_52s = "\46\uffff";
    static final String dfa_53s = "\1\4\2\0\43\uffff";
    static final String dfa_54s = "\1\132\2\0\43\uffff";
    static final String dfa_55s = "\3\uffff\2\1\1\2\40\uffff";
    static final String dfa_56s = "\1\0\1\1\1\2\43\uffff}>";
    static final String[] dfa_57s = {
            "\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\5\5\1\uffff\4\5\3\uffff\1\5\1\uffff\1\5\5\uffff\5\5\17\uffff\1\3\5\uffff\2\5\1\uffff\2\5\2\uffff\1\2\2\uffff\1\5\1\uffff\1\5\4\uffff\1\5\3\uffff\2\5\1\uffff\1\4\1\uffff\1\5\1\uffff\3\5\1\1\1\5",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_52 = DFA.unpackEncodedString(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final char[] dfa_54 = DFA.unpackEncodedStringToUnsignedChars(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[] dfa_56 = DFA.unpackEncodedString(dfa_56s);
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_52;
            this.eof = dfa_52;
            this.min = dfa_53;
            this.max = dfa_54;
            this.accept = dfa_55;
            this.special = dfa_56;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "3062:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= Comma ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= VerticalLine ) ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_0 = input.LA(1);

                         
                        int index52_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA52_0==RULE_ID) ) {s = 1;}

                        else if ( (LA52_0==LeftParenthesis) ) {s = 2;}

                        else if ( (LA52_0==EqualsSignGreaterThanSign) && (synpred25_InternalRuleEngineParser())) {s = 3;}

                        else if ( (LA52_0==VerticalLine) && (synpred25_InternalRuleEngineParser())) {s = 4;}

                        else if ( (LA52_0==Synchronized||LA52_0==Extension||LA52_0==Extends||(LA52_0>=Import && LA52_0<=Typeof)||(LA52_0>=False && LA52_0<=While)||LA52_0==Null||LA52_0==True||(LA52_0>=For && LA52_0<=Var)||(LA52_0>=Do && LA52_0<=If)||(LA52_0>=ExclamationMark && LA52_0<=NumberSign)||LA52_0==PlusSign||LA52_0==HyphenMinus||LA52_0==LessThanSign||(LA52_0>=LeftSquareBracket && LA52_0<=RightSquareBracket)||LA52_0==RULE_BEGIN||(LA52_0>=RULE_HEX && LA52_0<=RULE_DECIMAL)||LA52_0==RULE_STRING) ) {s = 5;}

                         
                        input.seek(index52_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index52_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA52_2 = input.LA(1);

                         
                        int index52_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index52_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "4453:3: ( ( ( ( LeftParenthesis ) )=> (lv_explicitOperationCall_7_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= RightParenthesis )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA75_1 = input.LA(1);

                         
                        int index75_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index75_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 75, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA74 extends DFA {

        public DFA74(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 74;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "4472:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= Comma ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA74_0 = input.LA(1);

                         
                        int index74_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA74_0==RULE_ID) ) {s = 1;}

                        else if ( (LA74_0==LeftParenthesis) ) {s = 2;}

                        else if ( (LA74_0==EqualsSignGreaterThanSign) && (synpred31_InternalRuleEngineParser())) {s = 3;}

                        else if ( (LA74_0==VerticalLine) && (synpred31_InternalRuleEngineParser())) {s = 4;}

                        else if ( (LA74_0==Synchronized||LA74_0==Extension||LA74_0==Extends||(LA74_0>=Import && LA74_0<=Typeof)||(LA74_0>=False && LA74_0<=While)||LA74_0==Null||LA74_0==True||(LA74_0>=For && LA74_0<=Try)||(LA74_0>=Do && LA74_0<=If)||(LA74_0>=ExclamationMark && LA74_0<=NumberSign)||LA74_0==PlusSign||LA74_0==HyphenMinus||LA74_0==LessThanSign||LA74_0==LeftSquareBracket||LA74_0==RULE_BEGIN||(LA74_0>=RULE_HEX && LA74_0<=RULE_DECIMAL)||LA74_0==RULE_STRING) ) {s = 5;}

                        else if ( (LA74_0==RightParenthesis) ) {s = 35;}

                         
                        input.seek(index74_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA74_1 = input.LA(1);

                         
                        int index74_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index74_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA74_2 = input.LA(1);

                         
                        int index74_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred31_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index74_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 74, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA76 extends DFA {

        public DFA76(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 76;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "4570:3: ( ( ( () LeftSquareBracket ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA76_1 = input.LA(1);

                         
                        int index76_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred32_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index76_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 76, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String[] dfa_58s = {
            "\6\2\1\uffff\12\2\1\uffff\3\2\1\uffff\1\2\1\uffff\3\2\1\uffff\31\2\1\uffff\6\2\1\uffff\12\2\1\1\1\uffff\1\2\1\uffff\2\2\2\uffff\10\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[][] dfa_58 = unpackEncodedStringArray(dfa_58s);

    class DFA80 extends DFA {

        public DFA80(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 80;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_58;
        }
        public String getDescription() {
            return "4729:3: ( ( ( LessThanSign )=>otherlv_3= LessThanSign ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= Comma ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= GreaterThanSign )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA80_1 = input.LA(1);

                         
                        int index80_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred33_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index80_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 80, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "4786:3: ( ( ( ( LeftParenthesis ) )=> (lv_explicitConstructorCall_8_0= LeftParenthesis ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= RightParenthesis )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA83_1 = input.LA(1);

                         
                        int index83_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index83_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 83, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "4805:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( Comma ( ( ruleJvmFormalParameter ) ) )* )? ( ( VerticalLine ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA82_0 = input.LA(1);

                         
                        int index82_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA82_0==RULE_ID) ) {s = 1;}

                        else if ( (LA82_0==LeftParenthesis) ) {s = 2;}

                        else if ( (LA82_0==EqualsSignGreaterThanSign) && (synpred35_InternalRuleEngineParser())) {s = 3;}

                        else if ( (LA82_0==VerticalLine) && (synpred35_InternalRuleEngineParser())) {s = 4;}

                        else if ( (LA82_0==Synchronized||LA82_0==Extension||LA82_0==Extends||(LA82_0>=Import && LA82_0<=Typeof)||(LA82_0>=False && LA82_0<=While)||LA82_0==Null||LA82_0==True||(LA82_0>=For && LA82_0<=Try)||(LA82_0>=Do && LA82_0<=If)||(LA82_0>=ExclamationMark && LA82_0<=NumberSign)||LA82_0==PlusSign||LA82_0==HyphenMinus||LA82_0==LessThanSign||LA82_0==LeftSquareBracket||LA82_0==RULE_BEGIN||(LA82_0>=RULE_HEX && LA82_0<=RULE_DECIMAL)||LA82_0==RULE_STRING) ) {s = 5;}

                        else if ( (LA82_0==RightParenthesis) ) {s = 35;}

                         
                        input.seek(index82_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA82_1 = input.LA(1);

                         
                        int index82_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index82_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA82_2 = input.LA(1);

                         
                        int index82_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred35_InternalRuleEngineParser()) ) {s = 4;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index82_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 82, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "4903:3: ( ( ( () LeftSquareBracket ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA84_1 = input.LA(1);

                         
                        int index84_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred36_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index84_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 84, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_59s = "\1\41\116\uffff";
    static final String dfa_60s = "\1\4\40\0\56\uffff";
    static final String dfa_61s = "\1\132\40\0\56\uffff";
    static final String dfa_62s = "\41\uffff\1\2\54\uffff\1\1";
    static final String dfa_63s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\56\uffff}>";
    static final String[] dfa_64s = {
            "\1\14\1\41\1\5\1\41\1\2\1\41\1\uffff\1\4\1\36\1\3\1\13\1\30\1\41\1\21\1\16\1\35\1\33\1\uffff\2\41\1\26\1\uffff\1\22\1\uffff\3\41\1\uffff\1\32\1\11\1\37\26\41\1\uffff\1\34\1\31\1\41\1\6\1\17\1\41\1\uffff\1\40\2\41\1\10\1\41\1\7\4\41\1\15\1\uffff\1\41\1\uffff\1\20\1\41\2\uffff\1\41\1\12\1\41\1\23\1\24\1\25\1\1\1\27",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final char[] dfa_60 = DFA.unpackEncodedStringToUnsignedChars(dfa_60s);
    static final char[] dfa_61 = DFA.unpackEncodedStringToUnsignedChars(dfa_61s);
    static final short[] dfa_62 = DFA.unpackEncodedString(dfa_62s);
    static final short[] dfa_63 = DFA.unpackEncodedString(dfa_63s);
    static final short[][] dfa_64 = unpackEncodedStringArray(dfa_64s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_32;
            this.eof = dfa_59;
            this.min = dfa_60;
            this.max = dfa_61;
            this.accept = dfa_62;
            this.special = dfa_63;
            this.transition = dfa_64;
        }
        public String getDescription() {
            return "5246:3: ( ( Extends | Static | Import | Extension | ExclamationMark | HyphenMinus | PlusSign | New | Switch | Synchronized | LessThanSign | Super | NumberSign | LeftSquareBracket | False | True | Null | Typeof | If | For | While | Do | Throw | Return | Try | LeftParenthesis | RULE_ID | RULE_BEGIN | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA87_1 = input.LA(1);

                         
                        int index87_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA87_2 = input.LA(1);

                         
                        int index87_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA87_3 = input.LA(1);

                         
                        int index87_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA87_4 = input.LA(1);

                         
                        int index87_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA87_5 = input.LA(1);

                         
                        int index87_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA87_6 = input.LA(1);

                         
                        int index87_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA87_7 = input.LA(1);

                         
                        int index87_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA87_8 = input.LA(1);

                         
                        int index87_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA87_9 = input.LA(1);

                         
                        int index87_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA87_10 = input.LA(1);

                         
                        int index87_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA87_11 = input.LA(1);

                         
                        int index87_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA87_12 = input.LA(1);

                         
                        int index87_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA87_13 = input.LA(1);

                         
                        int index87_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA87_14 = input.LA(1);

                         
                        int index87_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA87_15 = input.LA(1);

                         
                        int index87_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA87_16 = input.LA(1);

                         
                        int index87_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_16);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA87_17 = input.LA(1);

                         
                        int index87_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_17);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA87_18 = input.LA(1);

                         
                        int index87_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_18);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA87_19 = input.LA(1);

                         
                        int index87_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_19);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA87_20 = input.LA(1);

                         
                        int index87_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_20);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA87_21 = input.LA(1);

                         
                        int index87_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_21);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA87_22 = input.LA(1);

                         
                        int index87_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_22);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA87_23 = input.LA(1);

                         
                        int index87_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_23);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA87_24 = input.LA(1);

                         
                        int index87_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_24);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA87_25 = input.LA(1);

                         
                        int index87_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_25);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA87_26 = input.LA(1);

                         
                        int index87_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_26);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA87_27 = input.LA(1);

                         
                        int index87_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_27);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA87_28 = input.LA(1);

                         
                        int index87_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_28);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA87_29 = input.LA(1);

                         
                        int index87_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_29);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA87_30 = input.LA(1);

                         
                        int index87_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_30);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA87_31 = input.LA(1);

                         
                        int index87_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_31);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA87_32 = input.LA(1);

                         
                        int index87_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred37_InternalRuleEngineParser()) ) {s = 78;}

                        else if ( (true) ) {s = 33;}

                         
                        input.seek(index87_32);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 87, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_65s = "\120\uffff";
    static final String dfa_66s = "\1\2\117\uffff";
    static final String dfa_67s = "\1\4\1\0\116\uffff";
    static final String dfa_68s = "\1\132\1\0\116\uffff";
    static final String dfa_69s = "\2\uffff\1\2\114\uffff\1\1";
    static final String dfa_70s = "\1\uffff\1\0\116\uffff}>";
    static final String[] dfa_71s = {
            "\6\2\1\uffff\12\2\1\uffff\3\2\1\uffff\1\2\1\uffff\3\2\1\uffff\31\2\1\uffff\21\2\1\1\1\uffff\1\2\1\uffff\2\2\2\uffff\10\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[] dfa_66 = DFA.unpackEncodedString(dfa_66s);
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final short[][] dfa_71 = unpackEncodedStringArray(dfa_71s);

    class DFA105 extends DFA {

        public DFA105(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 105;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "5904:3: ( ( ( LessThanSign )=>otherlv_1= LessThanSign ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= Comma ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= GreaterThanSign ( ( ( ( () FullStop ) )=> ( () otherlv_7= FullStop ) ) ( ( ruleValidID ) ) ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )? )* )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA105_1 = input.LA(1);

                         
                        int index105_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred44_InternalRuleEngineParser()) ) {s = 79;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index105_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 105, _s, input);
            error(nvae);
            throw nvae;
        }
    }

    class DFA103 extends DFA {

        public DFA103(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 103;
            this.eot = dfa_65;
            this.eof = dfa_66;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_69;
            this.special = dfa_70;
            this.transition = dfa_71;
        }
        public String getDescription() {
            return "5998:5: ( ( ( LessThanSign )=>otherlv_9= LessThanSign ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= Comma ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= GreaterThanSign )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA103_1 = input.LA(1);

                         
                        int index103_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred46_InternalRuleEngineParser()) ) {s = 79;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index103_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 103, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_72s = "\7\uffff";
    static final String dfa_73s = "\2\uffff\1\4\3\uffff\1\4";
    static final String dfa_74s = "\1\15\1\uffff\1\107\1\103\2\uffff\1\107";
    static final String dfa_75s = "\1\131\1\uffff\1\112\1\131\2\uffff\1\112";
    static final String dfa_76s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String dfa_77s = "\7\uffff}>";
    static final String[] dfa_78s = {
            "\1\1\113\uffff\1\2",
            "",
            "\1\3\2\uffff\1\4",
            "\1\5\25\uffff\1\6",
            "",
            "",
            "\1\3\2\uffff\1\4"
    };

    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final char[] dfa_74 = DFA.unpackEncodedStringToUnsignedChars(dfa_74s);
    static final char[] dfa_75 = DFA.unpackEncodedStringToUnsignedChars(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final short[] dfa_77 = DFA.unpackEncodedString(dfa_77s);
    static final short[][] dfa_78 = unpackEncodedStringArray(dfa_78s);

    class DFA112 extends DFA {

        public DFA112(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 112;
            this.eot = dfa_72;
            this.eof = dfa_73;
            this.min = dfa_74;
            this.max = dfa_75;
            this.accept = dfa_76;
            this.special = dfa_77;
            this.transition = dfa_78;
        }
        public String getDescription() {
            return "6460:3: ( ( ( (lv_static_1_0= Static ) ) ( (lv_extension_2_0= Extension ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= Asterisk ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000200402L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007F08852L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007F08C52L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x6C10001F051EF950L,0x0000000007D08852L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0010000000000000L,0x0000000002000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007D08852L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0010000000400080L,0x0000000002200222L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00012A4000000002L,0x0000000000002800L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0020000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0008002050000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0020000000000022L,0x0000000000002800L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0094C00020000002L,0x0000000000002800L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000050L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x8000010000000002L,0x0000000000000108L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000140000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0042000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000002940L,0x0000000002000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000042940L,0x0000000002000800L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000000000000L,0x0000000002004002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0042000000000002L,0x0000000000008082L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x6C10001F051EF950L,0x0000000007D48856L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000024L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0042000000000002L,0x0000000000008080L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007D88852L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080020L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007D18852L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010020L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x6C10001F051EF950L,0x0000000007D58852L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040020L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x6C00001F051EF952L,0x0000000007D08C52L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x6C00001F051EF952L,0x0000000007D08852L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000220L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000220L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007D08C52L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000420L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x6C00001F051EF950L,0x0000000007D08856L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008002L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008802L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008004L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000010200L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000010202L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000001800000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0010000000000000L,0x0000000002000006L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000880L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000040102L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000002000L,0x0000000002000000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000040L,0x0000000002000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000008L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});

}
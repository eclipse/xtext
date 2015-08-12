package org.eclipse.xtext.resource.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.resource.services.Bug385636GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug385636Parser extends AbstractInternalAntlrParser {
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


        public InternalBug385636Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug385636Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug385636Parser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g"; }



     	private Bug385636GrammarAccess grammarAccess;
     	
        public InternalBug385636Parser(TokenStream input, Bug385636GrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Program";	
       	}
       	
       	@Override
       	protected Bug385636GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleProgram"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:67:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:68:2: (iv_ruleProgram= ruleProgram EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:69:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram75);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram85); 

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
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:76:1: ruleProgram returns [EObject current=null] : ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_define_0_0 = null;

        EObject lv_statements_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:79:28: ( ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:80:1: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:80:1: ( ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:80:2: ( (lv_define_0_0= ruleDefineVariables ) ) ( (lv_statements_1_0= ruleStatement ) )* otherlv_2= 'END'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:80:2: ( (lv_define_0_0= ruleDefineVariables ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:81:1: (lv_define_0_0= ruleDefineVariables )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:81:1: (lv_define_0_0= ruleDefineVariables )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:82:3: lv_define_0_0= ruleDefineVariables
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getDefineDefineVariablesParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDefineVariables_in_ruleProgram131);
            lv_define_0_0=ruleDefineVariables();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"define",
                    		lv_define_0_0, 
                    		"org.eclipse.xtext.resource.Bug385636.DefineVariables");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:98:2: ( (lv_statements_1_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:99:1: (lv_statements_1_0= ruleStatement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:99:1: (lv_statements_1_0= ruleStatement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:100:3: lv_statements_1_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getProgramAccess().getStatementsStatementParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleStatement_in_ruleProgram152);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_1_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleProgram165); 

                	newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getENDKeyword_2());
                

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
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleDefineVariables"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:128:1: entryRuleDefineVariables returns [EObject current=null] : iv_ruleDefineVariables= ruleDefineVariables EOF ;
    public final EObject entryRuleDefineVariables() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineVariables = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:129:2: (iv_ruleDefineVariables= ruleDefineVariables EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:130:2: iv_ruleDefineVariables= ruleDefineVariables EOF
            {
             newCompositeNode(grammarAccess.getDefineVariablesRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefineVariables_in_entryRuleDefineVariables201);
            iv_ruleDefineVariables=ruleDefineVariables();

            state._fsp--;

             current =iv_ruleDefineVariables; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefineVariables211); 

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
    // $ANTLR end "entryRuleDefineVariables"


    // $ANTLR start "ruleDefineVariables"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:137:1: ruleDefineVariables returns [EObject current=null] : (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) ;
    public final EObject ruleDefineVariables() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_variables_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:140:28: ( (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:141:1: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:141:1: (otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:141:3: otherlv_0= 'VARIABLES' ( (lv_variables_1_0= ruleDefineVariable ) )+ otherlv_2= 'ENDVARIABLES'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleDefineVariables248); 

                	newLeafNode(otherlv_0, grammarAccess.getDefineVariablesAccess().getVARIABLESKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:145:1: ( (lv_variables_1_0= ruleDefineVariable ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:146:1: (lv_variables_1_0= ruleDefineVariable )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:146:1: (lv_variables_1_0= ruleDefineVariable )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:147:3: lv_variables_1_0= ruleDefineVariable
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDefineVariablesAccess().getVariablesDefineVariableParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleDefineVariable_in_ruleDefineVariables269);
            	    lv_variables_1_0=ruleDefineVariable();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDefineVariablesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variables",
            	            		lv_variables_1_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.DefineVariable");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleDefineVariables282); 

                	newLeafNode(otherlv_2, grammarAccess.getDefineVariablesAccess().getENDVARIABLESKeyword_2());
                

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
    // $ANTLR end "ruleDefineVariables"


    // $ANTLR start "entryRuleDefineVariable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:175:1: entryRuleDefineVariable returns [EObject current=null] : iv_ruleDefineVariable= ruleDefineVariable EOF ;
    public final EObject entryRuleDefineVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefineVariable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:176:2: (iv_ruleDefineVariable= ruleDefineVariable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:177:2: iv_ruleDefineVariable= ruleDefineVariable EOF
            {
             newCompositeNode(grammarAccess.getDefineVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefineVariable_in_entryRuleDefineVariable318);
            iv_ruleDefineVariable=ruleDefineVariable();

            state._fsp--;

             current =iv_ruleDefineVariable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefineVariable328); 

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
    // $ANTLR end "entryRuleDefineVariable"


    // $ANTLR start "ruleDefineVariable"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:184:1: ruleDefineVariable returns [EObject current=null] : (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleDefineVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:187:28: ( (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:188:1: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:188:1: (otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:188:3: otherlv_0= 'NAME' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleDefineVariable365); 

                	newLeafNode(otherlv_0, grammarAccess.getDefineVariableAccess().getNAMEKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:192:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:193:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:193:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:194:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDefineVariable382); 

            			newLeafNode(lv_name_1_0, grammarAccess.getDefineVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDefineVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleDefineVariable"


    // $ANTLR start "entryRuleNVariableAccess"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:218:1: entryRuleNVariableAccess returns [EObject current=null] : iv_ruleNVariableAccess= ruleNVariableAccess EOF ;
    public final EObject entryRuleNVariableAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNVariableAccess = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:219:2: (iv_ruleNVariableAccess= ruleNVariableAccess EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:220:2: iv_ruleNVariableAccess= ruleNVariableAccess EOF
            {
             newCompositeNode(grammarAccess.getNVariableAccessRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNVariableAccess_in_entryRuleNVariableAccess423);
            iv_ruleNVariableAccess=ruleNVariableAccess();

            state._fsp--;

             current =iv_ruleNVariableAccess; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNVariableAccess433); 

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
    // $ANTLR end "entryRuleNVariableAccess"


    // $ANTLR start "ruleNVariableAccess"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:227:1: ruleNVariableAccess returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleNVariableAccess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:230:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:231:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:231:1: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:232:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:232:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:233:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNVariableAccessRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNVariableAccess477); 

            		newLeafNode(otherlv_0, grammarAccess.getNVariableAccessAccess().getVariableDefineVariableCrossReference_0()); 
            	

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
    // $ANTLR end "ruleNVariableAccess"


    // $ANTLR start "entryRuleStatement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:252:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:253:2: (iv_ruleStatement= ruleStatement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:254:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStatement_in_entryRuleStatement512);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStatement522); 

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:261:1: ruleStatement returns [EObject current=null] : (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject this_Expression_VariableName_0 = null;

        EObject lv_right_3_0 = null;

        EObject lv_right_6_0 = null;

        EObject lv_right_9_0 = null;

        EObject lv_right_12_0 = null;

        EObject lv_right_15_0 = null;

        EObject lv_right_19_0 = null;

        EObject lv_right_23_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:264:28: ( (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:265:1: (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:265:1: (this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:266:5: this_Expression_VariableName_0= ruleExpression_VariableName ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            {
             
                    newCompositeNode(grammarAccess.getStatementAccess().getExpression_VariableNameParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement569);
            this_Expression_VariableName_0=ruleExpression_VariableName();

            state._fsp--;

             
                    current = this_Expression_VariableName_0; 
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:274:1: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*
            loop3:
            do {
                int alt3=8;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:274:2: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:274:2: (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:274:4: otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    {
            	    otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleStatement582); 

            	        	newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getC1Keyword_1_0_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:278:1: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:279:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:284:2: ( (lv_right_3_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:285:1: (lv_right_3_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:285:1: (lv_right_3_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:286:3: lv_right_3_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_0_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement612);
            	    lv_right_3_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_3_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:303:6: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:303:6: (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:303:8: otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    {
            	    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleStatement632); 

            	        	newLeafNode(otherlv_4, grammarAccess.getStatementAccess().getC2Keyword_1_1_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:307:1: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:308:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:313:2: ( (lv_right_6_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:314:1: (lv_right_6_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:314:1: (lv_right_6_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:315:3: lv_right_6_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_1_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement662);
            	    lv_right_6_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_6_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:332:6: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:332:6: (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:332:8: otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    {
            	    otherlv_7=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleStatement682); 

            	        	newLeafNode(otherlv_7, grammarAccess.getStatementAccess().getC3Keyword_1_2_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:336:1: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:337:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:342:2: ( (lv_right_9_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:343:1: (lv_right_9_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:343:1: (lv_right_9_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:344:3: lv_right_9_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_2_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement712);
            	    lv_right_9_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_9_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:361:6: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:361:6: (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:361:8: otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    {
            	    otherlv_10=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleStatement732); 

            	        	newLeafNode(otherlv_10, grammarAccess.getStatementAccess().getC4Keyword_1_3_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:365:1: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:366:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:371:2: ( (lv_right_12_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:372:1: (lv_right_12_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:372:1: (lv_right_12_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:373:3: lv_right_12_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_3_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement762);
            	    lv_right_12_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_12_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:390:6: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:390:6: (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:390:8: otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    {
            	    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleStatement782); 

            	        	newLeafNode(otherlv_13, grammarAccess.getStatementAccess().getC5Keyword_1_4_0());
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:394:1: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:395:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:400:2: ( (lv_right_15_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:401:1: (lv_right_15_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:401:1: (lv_right_15_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:402:3: lv_right_15_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_4_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement812);
            	    lv_right_15_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_15_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:419:6: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:419:6: ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:419:7: (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:419:7: (otherlv_16= 'C6' otherlv_17= 'C7' )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:419:9: otherlv_16= 'C6' otherlv_17= 'C7'
            	    {
            	    otherlv_16=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleStatement833); 

            	        	newLeafNode(otherlv_16, grammarAccess.getStatementAccess().getC6Keyword_1_5_0_0());
            	        
            	    otherlv_17=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleStatement845); 

            	        	newLeafNode(otherlv_17, grammarAccess.getStatementAccess().getC7Keyword_1_5_0_1());
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:427:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:428:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:433:2: ( (lv_right_19_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:434:1: (lv_right_19_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:434:1: (lv_right_19_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:435:3: lv_right_19_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_5_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement876);
            	    lv_right_19_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_19_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:452:6: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:452:6: ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:452:7: (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:452:7: (otherlv_20= 'C6' otherlv_21= 'C8' )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:452:9: otherlv_20= 'C6' otherlv_21= 'C8'
            	    {
            	    otherlv_20=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleStatement897); 

            	        	newLeafNode(otherlv_20, grammarAccess.getStatementAccess().getC6Keyword_1_6_0_0());
            	        
            	    otherlv_21=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleStatement909); 

            	        	newLeafNode(otherlv_21, grammarAccess.getStatementAccess().getC8Keyword_1_6_0_1());
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:460:2: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:461:5: 
            	    {

            	            current = forceCreateModelElementAndSet(
            	                grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1(),
            	                current);
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:466:2: ( (lv_right_23_0= ruleExpression_VariableName ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:467:1: (lv_right_23_0= ruleExpression_VariableName )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:467:1: (lv_right_23_0= ruleExpression_VariableName )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:468:3: lv_right_23_0= ruleExpression_VariableName
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_6_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_ruleStatement940);
            	    lv_right_23_0=ruleExpression_VariableName();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStatementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"right",
            	            		lv_right_23_0, 
            	            		"org.eclipse.xtext.resource.Bug385636.Expression_VariableName");
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleExpression_VariableName"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:492:1: entryRuleExpression_VariableName returns [EObject current=null] : iv_ruleExpression_VariableName= ruleExpression_VariableName EOF ;
    public final EObject entryRuleExpression_VariableName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression_VariableName = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:493:2: (iv_ruleExpression_VariableName= ruleExpression_VariableName EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:494:2: iv_ruleExpression_VariableName= ruleExpression_VariableName EOF
            {
             newCompositeNode(grammarAccess.getExpression_VariableNameRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_VariableName_in_entryRuleExpression_VariableName979);
            iv_ruleExpression_VariableName=ruleExpression_VariableName();

            state._fsp--;

             current =iv_ruleExpression_VariableName; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression_VariableName989); 

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
    // $ANTLR end "entryRuleExpression_VariableName"


    // $ANTLR start "ruleExpression_VariableName"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:501:1: ruleExpression_VariableName returns [EObject current=null] : ( (lv_variable_0_0= ruleNVariableAccess ) ) ;
    public final EObject ruleExpression_VariableName() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:504:28: ( ( (lv_variable_0_0= ruleNVariableAccess ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:505:1: ( (lv_variable_0_0= ruleNVariableAccess ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:505:1: ( (lv_variable_0_0= ruleNVariableAccess ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:506:1: (lv_variable_0_0= ruleNVariableAccess )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:506:1: (lv_variable_0_0= ruleNVariableAccess )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/resource/parser/antlr/internal/InternalBug385636.g:507:3: lv_variable_0_0= ruleNVariableAccess
            {
             
            	        newCompositeNode(grammarAccess.getExpression_VariableNameAccess().getVariableNVariableAccessParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNVariableAccess_in_ruleExpression_VariableName1034);
            lv_variable_0_0=ruleNVariableAccess();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpression_VariableNameRule());
            	        }
                   		set(
                   			current, 
                   			"variable",
                    		lv_variable_0_0, 
                    		"org.eclipse.xtext.resource.Bug385636.NVariableAccess");
            	        afterParserOrEnumRuleCall();
            	    

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
            return "()* loopback of 274:1: ( (otherlv_1= 'C1' () ( (lv_right_3_0= ruleExpression_VariableName ) ) ) | (otherlv_4= 'C2' () ( (lv_right_6_0= ruleExpression_VariableName ) ) ) | (otherlv_7= 'C3' () ( (lv_right_9_0= ruleExpression_VariableName ) ) ) | (otherlv_10= 'C4' () ( (lv_right_12_0= ruleExpression_VariableName ) ) ) | (otherlv_13= 'C5' () ( (lv_right_15_0= ruleExpression_VariableName ) ) ) | ( (otherlv_16= 'C6' otherlv_17= 'C7' ) () ( (lv_right_19_0= ruleExpression_VariableName ) ) ) | ( (otherlv_20= 'C6' otherlv_21= 'C8' ) () ( (lv_right_23_0= ruleExpression_VariableName ) ) ) )*";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefineVariables_in_ruleProgram131 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_ruleStatement_in_ruleProgram152 = new BitSet(new long[]{0x0000000000000810L});
        public static final BitSet FOLLOW_11_in_ruleProgram165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefineVariables_in_entryRuleDefineVariables201 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefineVariables211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleDefineVariables248 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_ruleDefineVariable_in_ruleDefineVariables269 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_13_in_ruleDefineVariables282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefineVariable_in_entryRuleDefineVariable318 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefineVariable328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleDefineVariable365 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDefineVariable382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNVariableAccess_in_entryRuleNVariableAccess423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNVariableAccess433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNVariableAccess477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement512 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStatement522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement569 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_15_in_ruleStatement582 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement612 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_16_in_ruleStatement632 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement662 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_17_in_ruleStatement682 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement712 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_18_in_ruleStatement732 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement762 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_19_in_ruleStatement782 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement812 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_20_in_ruleStatement833 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleStatement845 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement876 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_20_in_ruleStatement897 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleStatement909 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_ruleStatement940 = new BitSet(new long[]{0x00000000001F8002L});
        public static final BitSet FOLLOW_ruleExpression_VariableName_in_entryRuleExpression_VariableName979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression_VariableName989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNVariableAccess_in_ruleExpression_VariableName1034 = new BitSet(new long[]{0x0000000000000002L});
    }


}
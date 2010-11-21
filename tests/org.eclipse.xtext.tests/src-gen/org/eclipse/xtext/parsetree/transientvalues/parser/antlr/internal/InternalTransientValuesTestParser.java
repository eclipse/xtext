package org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTransientValuesTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'test'", "'required'", "'optional'", "':'", "'list'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=4;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalTransientValuesTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTransientValuesTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTransientValuesTestParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g"; }



     	private TransientValuesTestGrammarAccess grammarAccess;
     	
        public InternalTransientValuesTestParser(TokenStream input, IAstFactory factory, TransientValuesTestGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected TransientValuesTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:70:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:71:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:72:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:79:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TestRequired_1 = null;

        EObject this_TestOptional_2 = null;

        EObject this_TestList_3 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:82:28: ( (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:1: (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:1: (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:83:3: otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot122); 

                	newLeafNode(otherlv_0, grammarAccess.getRootAccess().getTestKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:87:1: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 13:
                {
                alt1=2;
                }
                break;
            case 15:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:88:5: this_TestRequired_1= ruleTestRequired
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getTestRequiredParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_ruleRoot145);
                    this_TestRequired_1=ruleTestRequired();

                    state._fsp--;

                     
                            current = this_TestRequired_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:98:5: this_TestOptional_2= ruleTestOptional
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getTestOptionalParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_ruleRoot172);
                    this_TestOptional_2=ruleTestOptional();

                    state._fsp--;

                     
                            current = this_TestOptional_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:108:5: this_TestList_3= ruleTestList
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getTestListParserRuleCall_1_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTestList_in_ruleRoot199);
                    this_TestList_3=ruleTestList();

                    state._fsp--;

                     
                            current = this_TestList_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleTestRequired"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:124:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:125:2: (iv_ruleTestRequired= ruleTestRequired EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:126:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             newCompositeNode(grammarAccess.getTestRequiredRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestRequired_in_entryRuleTestRequired235);
            iv_ruleTestRequired=ruleTestRequired();

            state._fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestRequired245); 

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
    // $ANTLR end "entryRuleTestRequired"


    // $ANTLR start "ruleTestRequired"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:133:1: ruleTestRequired returns [EObject current=null] : (otherlv_0= 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_required1_1_0=null;
        Token lv_required2_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:136:28: ( (otherlv_0= 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:137:1: (otherlv_0= 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:137:1: (otherlv_0= 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:137:3: otherlv_0= 'required' ( (lv_required1_1_0= RULE_INT ) ) ( (lv_required2_2_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleTestRequired282); 

                	newLeafNode(otherlv_0, grammarAccess.getTestRequiredAccess().getRequiredKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:141:1: ( (lv_required1_1_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:142:1: (lv_required1_1_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:142:1: (lv_required1_1_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:143:3: lv_required1_1_0= RULE_INT
            {
            lv_required1_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired299); 

            			newLeafNode(lv_required1_1_0, grammarAccess.getTestRequiredAccess().getRequired1INTTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRequiredRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"required1",
                    		lv_required1_1_0, 
                    		"INT");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:159:2: ( (lv_required2_2_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:160:1: (lv_required2_2_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:160:1: (lv_required2_2_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:161:3: lv_required2_2_0= RULE_INT
            {
            lv_required2_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestRequired321); 

            			newLeafNode(lv_required2_2_0, grammarAccess.getTestRequiredAccess().getRequired2INTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRequiredRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"required2",
                    		lv_required2_2_0, 
                    		"INT");
            	    

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
    // $ANTLR end "ruleTestRequired"


    // $ANTLR start "entryRuleTestOptional"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:185:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:186:2: (iv_ruleTestOptional= ruleTestOptional EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:187:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             newCompositeNode(grammarAccess.getTestOptionalRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestOptional_in_entryRuleTestOptional362);
            iv_ruleTestOptional=ruleTestOptional();

            state._fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestOptional372); 

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
    // $ANTLR end "entryRuleTestOptional"


    // $ANTLR start "ruleTestOptional"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:194:1: ruleTestOptional returns [EObject current=null] : (otherlv_0= 'optional' ( (lv_opt1_1_0= RULE_INT ) )? (otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_opt1_1_0=null;
        Token otherlv_2=null;
        Token lv_opt2_3_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:197:28: ( (otherlv_0= 'optional' ( (lv_opt1_1_0= RULE_INT ) )? (otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:198:1: (otherlv_0= 'optional' ( (lv_opt1_1_0= RULE_INT ) )? (otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:198:1: (otherlv_0= 'optional' ( (lv_opt1_1_0= RULE_INT ) )? (otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:198:3: otherlv_0= 'optional' ( (lv_opt1_1_0= RULE_INT ) )? (otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) ) )?
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTestOptional409); 

                	newLeafNode(otherlv_0, grammarAccess.getTestOptionalAccess().getOptionalKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:202:1: ( (lv_opt1_1_0= RULE_INT ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:203:1: (lv_opt1_1_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:203:1: (lv_opt1_1_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:204:3: lv_opt1_1_0= RULE_INT
                    {
                    lv_opt1_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional426); 

                    			newLeafNode(lv_opt1_1_0, grammarAccess.getTestOptionalAccess().getOpt1INTTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestOptionalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"opt1",
                            		lv_opt1_1_0, 
                            		"INT");
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:220:3: (otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:220:5: otherlv_2= ':' ( (lv_opt2_3_0= RULE_INT ) )
                    {
                    otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleTestOptional445); 

                        	newLeafNode(otherlv_2, grammarAccess.getTestOptionalAccess().getColonKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:224:1: ( (lv_opt2_3_0= RULE_INT ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:225:1: (lv_opt2_3_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:225:1: (lv_opt2_3_0= RULE_INT )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:226:3: lv_opt2_3_0= RULE_INT
                    {
                    lv_opt2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestOptional462); 

                    			newLeafNode(lv_opt2_3_0, grammarAccess.getTestOptionalAccess().getOpt2INTTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestOptionalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"opt2",
                            		lv_opt2_3_0, 
                            		"INT");
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleTestOptional"


    // $ANTLR start "entryRuleTestList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:250:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:251:2: (iv_ruleTestList= ruleTestList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:252:2: iv_ruleTestList= ruleTestList EOF
            {
             newCompositeNode(grammarAccess.getTestListRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestList_in_entryRuleTestList505);
            iv_ruleTestList=ruleTestList();

            state._fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestList515); 

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
    // $ANTLR end "entryRuleTestList"


    // $ANTLR start "ruleTestList"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:259:1: ruleTestList returns [EObject current=null] : (otherlv_0= 'list' ( (lv_item_1_0= RULE_INT ) )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_item_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:262:28: ( (otherlv_0= 'list' ( (lv_item_1_0= RULE_INT ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:263:1: (otherlv_0= 'list' ( (lv_item_1_0= RULE_INT ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:263:1: (otherlv_0= 'list' ( (lv_item_1_0= RULE_INT ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:263:3: otherlv_0= 'list' ( (lv_item_1_0= RULE_INT ) )*
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleTestList552); 

                	newLeafNode(otherlv_0, grammarAccess.getTestListAccess().getListKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:267:1: ( (lv_item_1_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:268:1: (lv_item_1_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:268:1: (lv_item_1_0= RULE_INT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/transientvalues/parser/antlr/internal/InternalTransientValuesTest.g:269:3: lv_item_1_0= RULE_INT
            	    {
            	    lv_item_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleTestList569); 

            	    			newLeafNode(lv_item_1_0, grammarAccess.getTestListAccess().getItemINTTerminalRuleCall_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTestListRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"item",
            	            		lv_item_1_0, 
            	            		"INT");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "ruleTestList"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot122 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_ruleTestRequired_in_ruleRoot145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_ruleRoot172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_ruleRoot199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestRequired_in_entryRuleTestRequired235 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestRequired245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleTestRequired282 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired299 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestRequired321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestOptional_in_entryRuleTestOptional362 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestOptional372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleTestOptional409 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional426 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleTestOptional445 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestOptional462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestList_in_entryRuleTestList505 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestList515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleTestList552 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleTestList569 = new BitSet(new long[]{0x0000000000000012L});
    }


}
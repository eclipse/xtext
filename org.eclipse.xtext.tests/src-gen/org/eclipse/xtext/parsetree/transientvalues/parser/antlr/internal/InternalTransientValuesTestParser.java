package org.eclipse.xtext.parsetree.transientvalues.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=4;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalTransientValuesTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTransientValuesTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTransientValuesTestParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTransientValuesTest.g"; }



     	private TransientValuesTestGrammarAccess grammarAccess;
     	
        public InternalTransientValuesTestParser(TokenStream input, TransientValuesTestGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalTransientValuesTest.g:67:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // InternalTransientValuesTest.g:68:2: (iv_ruleRoot= ruleRoot EOF )
            // InternalTransientValuesTest.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalTransientValuesTest.g:76:1: ruleRoot returns [EObject current=null] : (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_TestRequired_1 = null;

        EObject this_TestOptional_2 = null;

        EObject this_TestList_3 = null;


         enterRule(); 
            
        try {
            // InternalTransientValuesTest.g:79:28: ( (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) ) )
            // InternalTransientValuesTest.g:80:1: (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            {
            // InternalTransientValuesTest.g:80:1: (otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList ) )
            // InternalTransientValuesTest.g:80:3: otherlv_0= 'test' (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRootAccess().getTestKeyword_0());
                
            // InternalTransientValuesTest.g:84:1: (this_TestRequired_1= ruleTestRequired | this_TestOptional_2= ruleTestOptional | this_TestList_3= ruleTestList )
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
                    // InternalTransientValuesTest.g:85:5: this_TestRequired_1= ruleTestRequired
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getTestRequiredParserRuleCall_1_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestRequired_1=ruleTestRequired();

                    state._fsp--;

                     
                            current = this_TestRequired_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTransientValuesTest.g:95:5: this_TestOptional_2= ruleTestOptional
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getTestOptionalParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_TestOptional_2=ruleTestOptional();

                    state._fsp--;

                     
                            current = this_TestOptional_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTransientValuesTest.g:105:5: this_TestList_3= ruleTestList
                    {
                     
                            newCompositeNode(grammarAccess.getRootAccess().getTestListParserRuleCall_1_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
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
    // InternalTransientValuesTest.g:121:1: entryRuleTestRequired returns [EObject current=null] : iv_ruleTestRequired= ruleTestRequired EOF ;
    public final EObject entryRuleTestRequired() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestRequired = null;


        try {
            // InternalTransientValuesTest.g:122:2: (iv_ruleTestRequired= ruleTestRequired EOF )
            // InternalTransientValuesTest.g:123:2: iv_ruleTestRequired= ruleTestRequired EOF
            {
             newCompositeNode(grammarAccess.getTestRequiredRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestRequired=ruleTestRequired();

            state._fsp--;

             current =iv_ruleTestRequired; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalTransientValuesTest.g:130:1: ruleTestRequired returns [EObject current=null] : ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) ;
    public final EObject ruleTestRequired() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_required1_2_0=null;
        Token lv_required2_3_0=null;

         enterRule(); 
            
        try {
            // InternalTransientValuesTest.g:133:28: ( ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) ) )
            // InternalTransientValuesTest.g:134:1: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            {
            // InternalTransientValuesTest.g:134:1: ( () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) ) )
            // InternalTransientValuesTest.g:134:2: () otherlv_1= 'required' ( (lv_required1_2_0= RULE_INT ) ) ( (lv_required2_3_0= RULE_INT ) )
            {
            // InternalTransientValuesTest.g:134:2: ()
            // InternalTransientValuesTest.g:135:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTestRequiredAccess().getTestRequiredAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_1, grammarAccess.getTestRequiredAccess().getRequiredKeyword_1());
                
            // InternalTransientValuesTest.g:144:1: ( (lv_required1_2_0= RULE_INT ) )
            // InternalTransientValuesTest.g:145:1: (lv_required1_2_0= RULE_INT )
            {
            // InternalTransientValuesTest.g:145:1: (lv_required1_2_0= RULE_INT )
            // InternalTransientValuesTest.g:146:3: lv_required1_2_0= RULE_INT
            {
            lv_required1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_4); 

            			newLeafNode(lv_required1_2_0, grammarAccess.getTestRequiredAccess().getRequired1INTTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRequiredRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"required1",
                    		lv_required1_2_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

            }


            }

            // InternalTransientValuesTest.g:162:2: ( (lv_required2_3_0= RULE_INT ) )
            // InternalTransientValuesTest.g:163:1: (lv_required2_3_0= RULE_INT )
            {
            // InternalTransientValuesTest.g:163:1: (lv_required2_3_0= RULE_INT )
            // InternalTransientValuesTest.g:164:3: lv_required2_3_0= RULE_INT
            {
            lv_required2_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_required2_3_0, grammarAccess.getTestRequiredAccess().getRequired2INTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRequiredRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"required2",
                    		lv_required2_3_0, 
                    		"org.eclipse.xtext.common.Terminals.INT");
            	    

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
    // InternalTransientValuesTest.g:188:1: entryRuleTestOptional returns [EObject current=null] : iv_ruleTestOptional= ruleTestOptional EOF ;
    public final EObject entryRuleTestOptional() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestOptional = null;


        try {
            // InternalTransientValuesTest.g:189:2: (iv_ruleTestOptional= ruleTestOptional EOF )
            // InternalTransientValuesTest.g:190:2: iv_ruleTestOptional= ruleTestOptional EOF
            {
             newCompositeNode(grammarAccess.getTestOptionalRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestOptional=ruleTestOptional();

            state._fsp--;

             current =iv_ruleTestOptional; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalTransientValuesTest.g:197:1: ruleTestOptional returns [EObject current=null] : ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) ;
    public final EObject ruleTestOptional() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_opt1_2_0=null;
        Token otherlv_3=null;
        Token lv_opt2_4_0=null;

         enterRule(); 
            
        try {
            // InternalTransientValuesTest.g:200:28: ( ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? ) )
            // InternalTransientValuesTest.g:201:1: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            {
            // InternalTransientValuesTest.g:201:1: ( () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )? )
            // InternalTransientValuesTest.g:201:2: () otherlv_1= 'optional' ( (lv_opt1_2_0= RULE_INT ) )? (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            {
            // InternalTransientValuesTest.g:201:2: ()
            // InternalTransientValuesTest.g:202:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTestOptionalAccess().getTestOptionalAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getTestOptionalAccess().getOptionalKeyword_1());
                
            // InternalTransientValuesTest.g:211:1: ( (lv_opt1_2_0= RULE_INT ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_INT) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalTransientValuesTest.g:212:1: (lv_opt1_2_0= RULE_INT )
                    {
                    // InternalTransientValuesTest.g:212:1: (lv_opt1_2_0= RULE_INT )
                    // InternalTransientValuesTest.g:213:3: lv_opt1_2_0= RULE_INT
                    {
                    lv_opt1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_6); 

                    			newLeafNode(lv_opt1_2_0, grammarAccess.getTestOptionalAccess().getOpt1INTTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestOptionalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"opt1",
                            		lv_opt1_2_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }
                    break;

            }

            // InternalTransientValuesTest.g:229:3: (otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTransientValuesTest.g:229:5: otherlv_3= ':' ( (lv_opt2_4_0= RULE_INT ) )
                    {
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_3, grammarAccess.getTestOptionalAccess().getColonKeyword_3_0());
                        
                    // InternalTransientValuesTest.g:233:1: ( (lv_opt2_4_0= RULE_INT ) )
                    // InternalTransientValuesTest.g:234:1: (lv_opt2_4_0= RULE_INT )
                    {
                    // InternalTransientValuesTest.g:234:1: (lv_opt2_4_0= RULE_INT )
                    // InternalTransientValuesTest.g:235:3: lv_opt2_4_0= RULE_INT
                    {
                    lv_opt2_4_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_opt2_4_0, grammarAccess.getTestOptionalAccess().getOpt2INTTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestOptionalRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"opt2",
                            		lv_opt2_4_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

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
    // InternalTransientValuesTest.g:259:1: entryRuleTestList returns [EObject current=null] : iv_ruleTestList= ruleTestList EOF ;
    public final EObject entryRuleTestList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestList = null;


        try {
            // InternalTransientValuesTest.g:260:2: (iv_ruleTestList= ruleTestList EOF )
            // InternalTransientValuesTest.g:261:2: iv_ruleTestList= ruleTestList EOF
            {
             newCompositeNode(grammarAccess.getTestListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTestList=ruleTestList();

            state._fsp--;

             current =iv_ruleTestList; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalTransientValuesTest.g:268:1: ruleTestList returns [EObject current=null] : ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) ;
    public final EObject ruleTestList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_item_2_0=null;

         enterRule(); 
            
        try {
            // InternalTransientValuesTest.g:271:28: ( ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* ) )
            // InternalTransientValuesTest.g:272:1: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            {
            // InternalTransientValuesTest.g:272:1: ( () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )* )
            // InternalTransientValuesTest.g:272:2: () otherlv_1= 'list' ( (lv_item_2_0= RULE_INT ) )*
            {
            // InternalTransientValuesTest.g:272:2: ()
            // InternalTransientValuesTest.g:273:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTestListAccess().getTestListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_7); 

                	newLeafNode(otherlv_1, grammarAccess.getTestListAccess().getListKeyword_1());
                
            // InternalTransientValuesTest.g:282:1: ( (lv_item_2_0= RULE_INT ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_INT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTransientValuesTest.g:283:1: (lv_item_2_0= RULE_INT )
            	    {
            	    // InternalTransientValuesTest.g:283:1: (lv_item_2_0= RULE_INT )
            	    // InternalTransientValuesTest.g:284:3: lv_item_2_0= RULE_INT
            	    {
            	    lv_item_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_7); 

            	    			newLeafNode(lv_item_2_0, grammarAccess.getTestListAccess().getItemINTTerminalRuleCall_2_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTestListRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"item",
            	            		lv_item_2_0, 
            	            		"org.eclipse.xtext.common.Terminals.INT");
            	    	    

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
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000000B000L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004012L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000012L});
    }


}
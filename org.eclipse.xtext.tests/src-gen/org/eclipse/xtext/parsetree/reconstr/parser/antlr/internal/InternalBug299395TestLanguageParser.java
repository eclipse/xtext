package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parsetree.reconstr.services.Bug299395TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug299395TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'['", "']'", "'subModel'", "'1'", "'2'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalBug299395TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug299395TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug299395TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug299395TestLanguage.g"; }



     	private Bug299395TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug299395TestLanguageParser(TokenStream input, Bug299395TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug299395TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalBug299395TestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug299395TestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug299395TestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalBug299395TestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_strings_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_keys_5_0=null;
        Token lv_values_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_subModel_9_0 = null;


         enterRule(); 
            
        try {
            // InternalBug299395TestLanguage.g:79:28: ( ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? ) )
            // InternalBug299395TestLanguage.g:80:1: ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? )
            {
            // InternalBug299395TestLanguage.g:80:1: ( () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )? )
            // InternalBug299395TestLanguage.g:80:2: () (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )* (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )* (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )?
            {
            // InternalBug299395TestLanguage.g:80:2: ()
            // InternalBug299395TestLanguage.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // InternalBug299395TestLanguage.g:86:2: (otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalBug299395TestLanguage.g:86:4: otherlv_1= '{' ( (lv_strings_2_0= RULE_STRING ) )? otherlv_3= '}'
            	    {
            	    otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

            	        	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_1_0());
            	        
            	    // InternalBug299395TestLanguage.g:90:1: ( (lv_strings_2_0= RULE_STRING ) )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==RULE_STRING) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalBug299395TestLanguage.g:91:1: (lv_strings_2_0= RULE_STRING )
            	            {
            	            // InternalBug299395TestLanguage.g:91:1: (lv_strings_2_0= RULE_STRING )
            	            // InternalBug299395TestLanguage.g:92:3: lv_strings_2_0= RULE_STRING
            	            {
            	            lv_strings_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_4); 

            	            			newLeafNode(lv_strings_2_0, grammarAccess.getModelAccess().getStringsSTRINGTerminalRuleCall_1_1_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getModelRule());
            	            	        }
            	                   		addWithLastConsumed(
            	                   			current, 
            	                   			"strings",
            	                    		lv_strings_2_0, 
            	                    		"org.eclipse.xtext.common.Terminals.STRING");
            	            	    

            	            }


            	            }
            	            break;

            	    }

            	    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_5); 

            	        	newLeafNode(otherlv_3, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_1_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalBug299395TestLanguage.g:112:3: (otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalBug299395TestLanguage.g:112:5: otherlv_4= '[' ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )* otherlv_7= ']'
            	    {
            	    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            	        	newLeafNode(otherlv_4, grammarAccess.getModelAccess().getLeftSquareBracketKeyword_2_0());
            	        
            	    // InternalBug299395TestLanguage.g:116:1: ( ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==RULE_STRING) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalBug299395TestLanguage.g:116:2: ( (lv_keys_5_0= RULE_STRING ) ) ( (lv_values_6_0= RULE_STRING ) )
            	    	    {
            	    	    // InternalBug299395TestLanguage.g:116:2: ( (lv_keys_5_0= RULE_STRING ) )
            	    	    // InternalBug299395TestLanguage.g:117:1: (lv_keys_5_0= RULE_STRING )
            	    	    {
            	    	    // InternalBug299395TestLanguage.g:117:1: (lv_keys_5_0= RULE_STRING )
            	    	    // InternalBug299395TestLanguage.g:118:3: lv_keys_5_0= RULE_STRING
            	    	    {
            	    	    lv_keys_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_7); 

            	    	    			newLeafNode(lv_keys_5_0, grammarAccess.getModelAccess().getKeysSTRINGTerminalRuleCall_2_1_0_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getModelRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"keys",
            	    	            		lv_keys_5_0, 
            	    	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    	    

            	    	    }


            	    	    }

            	    	    // InternalBug299395TestLanguage.g:134:2: ( (lv_values_6_0= RULE_STRING ) )
            	    	    // InternalBug299395TestLanguage.g:135:1: (lv_values_6_0= RULE_STRING )
            	    	    {
            	    	    // InternalBug299395TestLanguage.g:135:1: (lv_values_6_0= RULE_STRING )
            	    	    // InternalBug299395TestLanguage.g:136:3: lv_values_6_0= RULE_STRING
            	    	    {
            	    	    lv_values_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_6); 

            	    	    			newLeafNode(lv_values_6_0, grammarAccess.getModelAccess().getValuesSTRINGTerminalRuleCall_2_1_1_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getModelRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"values",
            	    	            		lv_values_6_0, 
            	    	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_8); 

            	        	newLeafNode(otherlv_7, grammarAccess.getModelAccess().getRightSquareBracketKeyword_2_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalBug299395TestLanguage.g:156:3: (otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalBug299395TestLanguage.g:156:5: otherlv_8= 'subModel' ( (lv_subModel_9_0= ruleSubModel ) )
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_9); 

                        	newLeafNode(otherlv_8, grammarAccess.getModelAccess().getSubModelKeyword_3_0());
                        
                    // InternalBug299395TestLanguage.g:160:1: ( (lv_subModel_9_0= ruleSubModel ) )
                    // InternalBug299395TestLanguage.g:161:1: (lv_subModel_9_0= ruleSubModel )
                    {
                    // InternalBug299395TestLanguage.g:161:1: (lv_subModel_9_0= ruleSubModel )
                    // InternalBug299395TestLanguage.g:162:3: lv_subModel_9_0= ruleSubModel
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getSubModelSubModelParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_subModel_9_0=ruleSubModel();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"subModel",
                            		lv_subModel_9_0, 
                            		"org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguage.SubModel");
                    	        afterParserOrEnumRuleCall();
                    	    

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSubModel"
    // InternalBug299395TestLanguage.g:186:1: entryRuleSubModel returns [EObject current=null] : iv_ruleSubModel= ruleSubModel EOF ;
    public final EObject entryRuleSubModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubModel = null;


        try {
            // InternalBug299395TestLanguage.g:187:2: (iv_ruleSubModel= ruleSubModel EOF )
            // InternalBug299395TestLanguage.g:188:2: iv_ruleSubModel= ruleSubModel EOF
            {
             newCompositeNode(grammarAccess.getSubModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSubModel=ruleSubModel();

            state._fsp--;

             current =iv_ruleSubModel; 
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
    // $ANTLR end "entryRuleSubModel"


    // $ANTLR start "ruleSubModel"
    // InternalBug299395TestLanguage.g:195:1: ruleSubModel returns [EObject current=null] : ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* ) ;
    public final EObject ruleSubModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_strings_3_0=null;

         enterRule(); 
            
        try {
            // InternalBug299395TestLanguage.g:198:28: ( ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* ) )
            // InternalBug299395TestLanguage.g:199:1: ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* )
            {
            // InternalBug299395TestLanguage.g:199:1: ( () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )* )
            // InternalBug299395TestLanguage.g:199:2: () (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )*
            {
            // InternalBug299395TestLanguage.g:199:2: ()
            // InternalBug299395TestLanguage.g:200:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSubModelAccess().getSubModelAction_0(),
                        current);
                

            }

            // InternalBug299395TestLanguage.g:205:2: (otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )? )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalBug299395TestLanguage.g:205:4: otherlv_1= '1' otherlv_2= '2' ( (lv_strings_3_0= RULE_STRING ) )?
            	    {
            	    otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_10); 

            	        	newLeafNode(otherlv_1, grammarAccess.getSubModelAccess().getDigitOneKeyword_1_0());
            	        
            	    otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_11); 

            	        	newLeafNode(otherlv_2, grammarAccess.getSubModelAccess().getDigitTwoKeyword_1_1());
            	        
            	    // InternalBug299395TestLanguage.g:213:1: ( (lv_strings_3_0= RULE_STRING ) )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==RULE_STRING) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalBug299395TestLanguage.g:214:1: (lv_strings_3_0= RULE_STRING )
            	            {
            	            // InternalBug299395TestLanguage.g:214:1: (lv_strings_3_0= RULE_STRING )
            	            // InternalBug299395TestLanguage.g:215:3: lv_strings_3_0= RULE_STRING
            	            {
            	            lv_strings_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_12); 

            	            			newLeafNode(lv_strings_3_0, grammarAccess.getSubModelAccess().getStringsSTRINGTerminalRuleCall_1_2_0()); 
            	            		

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getSubModelRule());
            	            	        }
            	                   		addWithLastConsumed(
            	                   			current, 
            	                   			"strings",
            	                    		lv_strings_3_0, 
            	                    		"org.eclipse.xtext.common.Terminals.STRING");
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleSubModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000000A802L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000A002L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010012L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000010002L});
    }


}
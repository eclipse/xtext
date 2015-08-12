package org.eclipse.xtext.dummy.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDummyTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'optional'", "'element'", "';'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalDummyTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDummyTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDummyTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g"; }



     	private DummyTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDummyTestLanguageParser(TokenStream input, DummyTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected DummyTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:79:28: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:80:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:81:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:81:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:82:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel130);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.dummy.DummyTestLanguage.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:106:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:107:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:108:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement166);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement176); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:115:1: ruleElement returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? otherlv_1= 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* otherlv_4= ';' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token lv_descriptions_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:118:28: ( ( ( (lv_optional_0_0= 'optional' ) )? otherlv_1= 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* otherlv_4= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:1: ( ( (lv_optional_0_0= 'optional' ) )? otherlv_1= 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* otherlv_4= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:1: ( ( (lv_optional_0_0= 'optional' ) )? otherlv_1= 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* otherlv_4= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:2: ( (lv_optional_0_0= 'optional' ) )? otherlv_1= 'element' ( (lv_name_2_0= RULE_ID ) ) ( (lv_descriptions_3_0= RULE_STRING ) )* otherlv_4= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:119:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:120:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:120:1: (lv_optional_0_0= 'optional' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:121:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement219); 

                            newLeafNode(lv_optional_0_0, grammarAccess.getElementAccess().getOptionalOptionalKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(current, "optional", true, "optional");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElement245); 

                	newLeafNode(otherlv_1, grammarAccess.getElementAccess().getElementKeyword_1());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:138:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:139:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:139:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:140:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement262); 

            			newLeafNode(lv_name_2_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:156:2: ( (lv_descriptions_3_0= RULE_STRING ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_STRING) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:157:1: (lv_descriptions_3_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:157:1: (lv_descriptions_3_0= RULE_STRING )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/dummy/parser/antlr/internal/InternalDummyTestLanguage.g:158:3: lv_descriptions_3_0= RULE_STRING
            	    {
            	    lv_descriptions_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleElement284); 

            	    			newLeafNode(lv_descriptions_3_0, grammarAccess.getElementAccess().getDescriptionsSTRINGTerminalRuleCall_3_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getElementRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"descriptions",
            	            		lv_descriptions_3_0, 
            	            		"org.eclipse.xtext.common.Terminals.STRING");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElement302); 

                	newLeafNode(otherlv_4, grammarAccess.getElementAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleElement"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement219 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleElement245 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement262 = new BitSet(new long[]{0x0000000000002020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleElement284 = new BitSet(new long[]{0x0000000000002020L});
        public static final BitSet FOLLOW_13_in_ruleElement302 = new BitSet(new long[]{0x0000000000000002L});
    }


}
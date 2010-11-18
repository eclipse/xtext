package org.eclipse.xtext.generator.grammarAccess.parser.antlr.internal; 

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
import org.eclipse.xtext.generator.grammarAccess.services.GrammarAccessTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGrammarAccessTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo'", "'bar'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalGrammarAccessTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGrammarAccessTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGrammarAccessTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g"; }



     	private GrammarAccessTestLanguageGrammarAccess grammarAccess;
     	
        public InternalGrammarAccessTestLanguageParser(TokenStream input, IAstFactory factory, GrammarAccessTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected GrammarAccessTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:71:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:72:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:73:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:80:1: ruleRoot returns [EObject current=null] : ( (lv_elements_0_0= ruleType ) )* ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:85:6: ( ( (lv_elements_0_0= ruleType ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:86:1: ( (lv_elements_0_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:86:1: ( (lv_elements_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:87:1: (lv_elements_0_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:87:1: (lv_elements_0_0= ruleType )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:88:3: lv_elements_0_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getElementsTypeParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleRoot130);
            	    lv_elements_0_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRootRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"Type", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:113:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:114:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:115:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType166);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType176); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:122:1: ruleType returns [EObject current=null] : (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_AType_0 = null;

        EObject this_AnotherType_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:127:6: ( (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:128:1: (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:128:1: (this_AType_0= ruleAType | this_AnotherType_1= ruleAnotherType )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:129:5: this_AType_0= ruleAType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getATypeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAType_in_ruleType223);
                    this_AType_0=ruleAType();

                    state._fsp--;

                     
                            current = this_AType_0; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:140:5: this_AnotherType_1= ruleAnotherType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getAnotherTypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAnotherType_in_ruleType250);
                    this_AnotherType_1=ruleAnotherType();

                    state._fsp--;

                     
                            current = this_AnotherType_1; 
                            // currentNode = currentNode.getParent();
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleAType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:157:1: entryRuleAType returns [EObject current=null] : iv_ruleAType= ruleAType EOF ;
    public final EObject entryRuleAType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:158:2: (iv_ruleAType= ruleAType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:159:2: iv_ruleAType= ruleAType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getATypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAType_in_entryRuleAType285);
            iv_ruleAType=ruleAType();

            state._fsp--;

             current =iv_ruleAType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAType295); 

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
    // $ANTLR end "entryRuleAType"


    // $ANTLR start "ruleAType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:166:1: ruleAType returns [EObject current=null] : (otherlv_0= 'foo' () ) ;
    public final EObject ruleAType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:171:6: ( (otherlv_0= 'foo' () ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:172:1: (otherlv_0= 'foo' () )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:172:1: (otherlv_0= 'foo' () )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:172:3: otherlv_0= 'foo' ()
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleAType332); 

                	createLeafNode(otherlv_0, grammarAccess.getATypeAccess().getFooKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:176:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:177:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getATypeAccess().getATypeAction_1(),
                        current);
                

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAType"


    // $ANTLR start "entryRuleAnotherType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:190:1: entryRuleAnotherType returns [EObject current=null] : iv_ruleAnotherType= ruleAnotherType EOF ;
    public final EObject entryRuleAnotherType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnotherType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:191:2: (iv_ruleAnotherType= ruleAnotherType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:192:2: iv_ruleAnotherType= ruleAnotherType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAnotherTypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAnotherType_in_entryRuleAnotherType377);
            iv_ruleAnotherType=ruleAnotherType();

            state._fsp--;

             current =iv_ruleAnotherType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAnotherType387); 

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
    // $ANTLR end "entryRuleAnotherType"


    // $ANTLR start "ruleAnotherType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:199:1: ruleAnotherType returns [EObject current=null] : (otherlv_0= 'bar' () ) ;
    public final EObject ruleAnotherType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:204:6: ( (otherlv_0= 'bar' () ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:205:1: (otherlv_0= 'bar' () )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:205:1: (otherlv_0= 'bar' () )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:205:3: otherlv_0= 'bar' ()
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAnotherType424); 

                	createLeafNode(otherlv_0, grammarAccess.getAnotherTypeAccess().getBarKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:209:1: ()
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/generator/grammarAccess/parser/antlr/internal/InternalGrammarAccessTestLanguage.g:210:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAnotherTypeAccess().getAnotherTypeAction_1(),
                        current);
                

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnotherType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleRoot130 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAType_in_ruleType223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherType_in_ruleType250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAType_in_entryRuleAType285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAType295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleAType332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAnotherType_in_entryRuleAnotherType377 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAnotherType387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleAnotherType424 = new BitSet(new long[]{0x0000000000000002L});
    }


}
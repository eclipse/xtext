package org.eclipse.xtext.ui.tests.quickfix.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.quickfix.services.QuickfixCrossrefTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalQuickfixCrossrefTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'ref'", "'}'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalQuickfixCrossrefTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g"; }



     	private QuickfixCrossrefTestLanguageGrammarAccess grammarAccess;
     	
        public InternalQuickfixCrossrefTestLanguageParser(TokenStream input, IAstFactory factory, QuickfixCrossrefTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	}
       	
       	@Override
       	protected QuickfixCrossrefTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:71:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:72:2: (iv_ruleMain= ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:73:2: iv_ruleMain= ruleMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain75);
            iv_ruleMain=ruleMain();

            state._fsp--;

             current =iv_ruleMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMain85); 

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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:80:1: ruleMain returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:85:6: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:86:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:86:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:87:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:87:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:88:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getMainAccess().getElementsElementParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleMain130);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getMainRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_0_0, 
            	    	        		"Element", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:118:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:119:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:120:2: iv_ruleElement= ruleElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getElementRule(), currentNode); 
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:127:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_contained_2_0= ruleElement ) )* (otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_contained_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:132:6: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_contained_2_0= ruleElement ) )* (otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:133:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_contained_2_0= ruleElement ) )* (otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:133:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_contained_2_0= ruleElement ) )* (otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:133:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '{' ( (lv_contained_2_0= ruleElement ) )* (otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) ) )* otherlv_5= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:133:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:134:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:134:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:135:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement218); 

            			createLeafNode(lv_name_0_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement235); 

                	createLeafNode(otherlv_1, grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:161:1: ( (lv_contained_2_0= ruleElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:162:1: (lv_contained_2_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:162:1: (lv_contained_2_0= ruleElement )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:163:3: lv_contained_2_0= ruleElement
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getElementAccess().getContainedElementParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleElement256);
            	    lv_contained_2_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"contained",
            	    	        		lv_contained_2_0, 
            	    	        		"Element", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:185:3: (otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:185:5: otherlv_3= 'ref' ( (otherlv_4= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElement270); 

            	        	createLeafNode(otherlv_3, grammarAccess.getElementAccess().getRefKeyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:189:1: ( (otherlv_4= RULE_ID ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:190:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:190:1: (otherlv_4= RULE_ID )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/quickfix/parser/antlr/internal/InternalQuickfixCrossrefTestLanguage.g:191:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getElementRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement290); 

            	    		createLeafNode(otherlv_4, grammarAccess.getElementAccess().getReferencedElementCrossReference_3_1_0(), "referenced"); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElement304); 

                	createLeafNode(otherlv_5, grammarAccess.getElementAccess().getRightCurlyBracketKeyword_4(), null);
                

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
    // $ANTLR end "ruleElement"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleMain130 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement218 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleElement235 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_ruleElement_in_ruleElement256 = new BitSet(new long[]{0x0000000000003010L});
        public static final BitSet FOLLOW_12_in_ruleElement270 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement290 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_13_in_ruleElement304 = new BitSet(new long[]{0x0000000000000002L});
    }


}
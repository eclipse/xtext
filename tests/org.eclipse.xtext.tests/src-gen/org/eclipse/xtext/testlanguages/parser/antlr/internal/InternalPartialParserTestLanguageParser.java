package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPartialParserTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'container'", "'{'", "'}'", "'nested'", "'children'", "','", "'->'", "'C'", "'('", "')'", "'abstract children'", "'F'", "'S'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalPartialParserTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPartialParserTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPartialParserTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g"; }



     	private PartialParserTestLanguageGrammarAccess grammarAccess;
     	
        public InternalPartialParserTestLanguageParser(TokenStream input, IAstFactory factory, PartialParserTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SomeContainer";	
       	}
       	
       	@Override
       	protected PartialParserTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSomeContainer"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:71:1: entryRuleSomeContainer returns [EObject current=null] : iv_ruleSomeContainer= ruleSomeContainer EOF ;
    public final EObject entryRuleSomeContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSomeContainer = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:72:2: (iv_ruleSomeContainer= ruleSomeContainer EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:73:2: iv_ruleSomeContainer= ruleSomeContainer EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSomeContainerRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer75);
            iv_ruleSomeContainer=ruleSomeContainer();

            state._fsp--;

             current =iv_ruleSomeContainer; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSomeContainer85); 

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
    // $ANTLR end "entryRuleSomeContainer"


    // $ANTLR start "ruleSomeContainer"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:80:1: ruleSomeContainer returns [EObject current=null] : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleSomeContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_nested_3_0 = null;

        EObject lv_content_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:85:6: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:86:1: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:86:1: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:86:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSomeContainer122); 

                	createLeafNode(otherlv_0, grammarAccess.getSomeContainerAccess().getContainerKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:90:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:91:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:92:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSomeContainer139); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSomeContainerAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSomeContainerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSomeContainer156); 

                	createLeafNode(otherlv_2, grammarAccess.getSomeContainerAccess().getLeftCurlyBracketKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:118:1: ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }
                else if ( (LA1_0==15||LA1_0==21) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:118:2: ( (lv_nested_3_0= ruleNested ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:118:2: ( (lv_nested_3_0= ruleNested ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:119:1: (lv_nested_3_0= ruleNested )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:119:1: (lv_nested_3_0= ruleNested )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:120:3: lv_nested_3_0= ruleNested
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSomeContainerAccess().getNestedNestedParserRuleCall_3_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNested_in_ruleSomeContainer178);
            	    lv_nested_3_0=ruleNested();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSomeContainerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"nested",
            	    	        		lv_nested_3_0, 
            	    	        		"Nested", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:143:6: ( (lv_content_4_0= ruleContent ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:143:6: ( (lv_content_4_0= ruleContent ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:144:1: (lv_content_4_0= ruleContent )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:144:1: (lv_content_4_0= ruleContent )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:145:3: lv_content_4_0= ruleContent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSomeContainerAccess().getContentContentParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleSomeContainer205);
            	    lv_content_4_0=ruleContent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSomeContainerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"content",
            	    	        		lv_content_4_0, 
            	    	        		"Content", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSomeContainer219); 

                	createLeafNode(otherlv_5, grammarAccess.getSomeContainerAccess().getRightCurlyBracketKeyword_4(), null);
                

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
    // $ANTLR end "ruleSomeContainer"


    // $ANTLR start "entryRuleNested"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:179:1: entryRuleNested returns [EObject current=null] : iv_ruleNested= ruleNested EOF ;
    public final EObject entryRuleNested() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNested = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:2: (iv_ruleNested= ruleNested EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:181:2: iv_ruleNested= ruleNested EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNested_in_entryRuleNested255);
            iv_ruleNested=ruleNested();

            state._fsp--;

             current =iv_ruleNested; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNested265); 

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
    // $ANTLR end "entryRuleNested"


    // $ANTLR start "ruleNested"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:188:1: ruleNested returns [EObject current=null] : (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) ;
    public final EObject ruleNested() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_nested_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:193:6: ( (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:194:1: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:194:1: (otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:194:3: otherlv_0= 'nested' otherlv_1= '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNested302); 

                	createLeafNode(otherlv_0, grammarAccess.getNestedAccess().getNestedKeyword_0(), null);
                
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNested314); 

                	createLeafNode(otherlv_1, grammarAccess.getNestedAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:202:1: ( (lv_nested_2_0= ruleSomeContainer ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:203:1: (lv_nested_2_0= ruleSomeContainer )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:203:1: (lv_nested_2_0= ruleSomeContainer )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:204:3: lv_nested_2_0= ruleSomeContainer
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNestedAccess().getNestedSomeContainerParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSomeContainer_in_ruleNested335);
            	    lv_nested_2_0=ruleSomeContainer();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNestedRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"nested",
            	    	        		lv_nested_2_0, 
            	    	        		"SomeContainer", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNested348); 

                	createLeafNode(otherlv_3, grammarAccess.getNestedAccess().getRightCurlyBracketKeyword_3(), null);
                

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
    // $ANTLR end "ruleNested"


    // $ANTLR start "entryRuleContent"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:238:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:239:2: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:240:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent384);
            iv_ruleContent=ruleContent();

            state._fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent394); 

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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:247:1: ruleContent returns [EObject current=null] : (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Children_0 = null;

        EObject this_AbstractChildren_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:252:6: ( (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:253:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:253:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==21) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:254:5: this_Children_0= ruleChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getContentAccess().getChildrenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleChildren_in_ruleContent441);
                    this_Children_0=ruleChildren();

                    state._fsp--;

                     
                            current = this_Children_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:264:5: this_AbstractChildren_1= ruleAbstractChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getContentAccess().getAbstractChildrenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractChildren_in_ruleContent468);
                    this_AbstractChildren_1=ruleAbstractChildren();

                    state._fsp--;

                     
                            current = this_AbstractChildren_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleChildren"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:280:1: entryRuleChildren returns [EObject current=null] : iv_ruleChildren= ruleChildren EOF ;
    public final EObject entryRuleChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildren = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:281:2: (iv_ruleChildren= ruleChildren EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:282:2: iv_ruleChildren= ruleChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildrenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChildren_in_entryRuleChildren503);
            iv_ruleChildren=ruleChildren();

            state._fsp--;

             current =iv_ruleChildren; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChildren513); 

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
    // $ANTLR end "entryRuleChildren"


    // $ANTLR start "ruleChildren"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:289:1: ruleChildren returns [EObject current=null] : (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleChildren() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_children_2_0 = null;

        EObject lv_children_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:294:6: ( (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:295:1: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:295:1: (otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:295:3: otherlv_0= 'children' otherlv_1= '{' ( (lv_children_2_0= ruleChild ) ) (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleChildren550); 

                	createLeafNode(otherlv_0, grammarAccess.getChildrenAccess().getChildrenKeyword_0(), null);
                
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleChildren562); 

                	createLeafNode(otherlv_1, grammarAccess.getChildrenAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:303:1: ( (lv_children_2_0= ruleChild ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:304:1: (lv_children_2_0= ruleChild )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:304:1: (lv_children_2_0= ruleChild )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:305:3: lv_children_2_0= ruleChild
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getChildrenAccess().getChildrenChildParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleChildren583);
            lv_children_2_0=ruleChild();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChildrenRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"children",
            	        		lv_children_2_0, 
            	        		"Child", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:327:2: (otherlv_3= ',' ( (lv_children_4_0= ruleChild ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:327:4: otherlv_3= ',' ( (lv_children_4_0= ruleChild ) )
            	    {
            	    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleChildren596); 

            	        	createLeafNode(otherlv_3, grammarAccess.getChildrenAccess().getCommaKeyword_3_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:331:1: ( (lv_children_4_0= ruleChild ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:332:1: (lv_children_4_0= ruleChild )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:332:1: (lv_children_4_0= ruleChild )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:333:3: lv_children_4_0= ruleChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getChildrenAccess().getChildrenChildParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleChildren617);
            	    lv_children_4_0=ruleChild();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getChildrenRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"children",
            	    	        		lv_children_4_0, 
            	    	        		"Child", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleChildren631); 

                	createLeafNode(otherlv_5, grammarAccess.getChildrenAccess().getRightCurlyBracketKeyword_4(), null);
                

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
    // $ANTLR end "ruleChildren"


    // $ANTLR start "entryRuleChild"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:367:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:368:2: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:369:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild667);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild677); 

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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:376:1: ruleChild returns [EObject current=null] : (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:381:6: ( (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:382:1: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:382:1: (otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:382:3: otherlv_0= '->' otherlv_1= 'C' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleChild714); 

                	createLeafNode(otherlv_0, grammarAccess.getChildAccess().getHyphenMinusGreaterThanSignKeyword_0(), null);
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleChild726); 

                	createLeafNode(otherlv_1, grammarAccess.getChildAccess().getCKeyword_1(), null);
                
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleChild738); 

                	createLeafNode(otherlv_2, grammarAccess.getChildAccess().getLeftParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:394:1: ( (lv_value_3_0= ruleNamed ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:395:1: (lv_value_3_0= ruleNamed )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:395:1: (lv_value_3_0= ruleNamed )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:396:3: lv_value_3_0= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getChildAccess().getValueNamedParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleChild759);
            lv_value_3_0=ruleNamed();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_3_0, 
            	        		"Named", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_4=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleChild771); 

                	createLeafNode(otherlv_4, grammarAccess.getChildAccess().getRightParenthesisKeyword_4(), null);
                

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
    // $ANTLR end "ruleChild"


    // $ANTLR start "entryRuleAbstractChildren"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:430:1: entryRuleAbstractChildren returns [EObject current=null] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final EObject entryRuleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChildren = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:431:2: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:432:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractChildrenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren807);
            iv_ruleAbstractChildren=ruleAbstractChildren();

            state._fsp--;

             current =iv_ruleAbstractChildren; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractChildren817); 

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
    // $ANTLR end "entryRuleAbstractChildren"


    // $ANTLR start "ruleAbstractChildren"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:439:1: ruleAbstractChildren returns [EObject current=null] : (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) ;
    public final EObject ruleAbstractChildren() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_abstractChildren_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:444:6: ( (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:445:1: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:445:1: (otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:445:3: otherlv_0= 'abstract children' otherlv_1= '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAbstractChildren854); 

                	createLeafNode(otherlv_0, grammarAccess.getAbstractChildrenAccess().getAbstractChildrenKeyword_0(), null);
                
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAbstractChildren866); 

                	createLeafNode(otherlv_1, grammarAccess.getAbstractChildrenAccess().getLeftCurlyBracketKeyword_1(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:453:1: ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:454:1: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:454:1: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:455:3: lv_abstractChildren_2_0= ruleAbstractChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAbstractChildrenAccess().getAbstractChildrenAbstractChildParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractChild_in_ruleAbstractChildren887);
            	    lv_abstractChildren_2_0=ruleAbstractChild();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAbstractChildrenRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"abstractChildren",
            	    	        		lv_abstractChildren_2_0, 
            	    	        		"AbstractChild", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAbstractChildren900); 

                	createLeafNode(otherlv_3, grammarAccess.getAbstractChildrenAccess().getRightCurlyBracketKeyword_3(), null);
                

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
    // $ANTLR end "ruleAbstractChildren"


    // $ANTLR start "entryRuleAbstractChild"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:489:1: entryRuleAbstractChild returns [EObject current=null] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final EObject entryRuleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChild = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:490:2: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:491:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild936);
            iv_ruleAbstractChild=ruleAbstractChild();

            state._fsp--;

             current =iv_ruleAbstractChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractChild946); 

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
    // $ANTLR end "entryRuleAbstractChild"


    // $ANTLR start "ruleAbstractChild"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:498:1: ruleAbstractChild returns [EObject current=null] : (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) ;
    public final EObject ruleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject this_FirstConcrete_0 = null;

        EObject this_SecondConcrete_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:503:6: ( (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:504:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:504:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==22) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==23) ) {
                        alt6=2;
                    }
                    else if ( (LA6_2==19) ) {
                        alt6=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:505:5: this_FirstConcrete_0= ruleFirstConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractChildAccess().getFirstConcreteParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleFirstConcrete_in_ruleAbstractChild993);
                    this_FirstConcrete_0=ruleFirstConcrete();

                    state._fsp--;

                     
                            current = this_FirstConcrete_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:515:5: this_SecondConcrete_1= ruleSecondConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractChildAccess().getSecondConcreteParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1020);
                    this_SecondConcrete_1=ruleSecondConcrete();

                    state._fsp--;

                     
                            current = this_SecondConcrete_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end "ruleAbstractChild"


    // $ANTLR start "entryRuleFirstConcrete"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:531:1: entryRuleFirstConcrete returns [EObject current=null] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final EObject entryRuleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstConcrete = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:532:2: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:533:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstConcreteRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1055);
            iv_ruleFirstConcrete=ruleFirstConcrete();

            state._fsp--;

             current =iv_ruleFirstConcrete; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstConcrete1065); 

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
    // $ANTLR end "entryRuleFirstConcrete"


    // $ANTLR start "ruleFirstConcrete"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:540:1: ruleFirstConcrete returns [EObject current=null] : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) ;
    public final EObject ruleFirstConcrete() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_value_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:545:6: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:546:1: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:546:1: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:546:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= '(' ( (lv_value_3_0= ruleNamed ) ) ( (otherlv_4= RULE_ID ) )? otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFirstConcrete1102); 

                	createLeafNode(otherlv_0, grammarAccess.getFirstConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0(), null);
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFirstConcrete1114); 

                	createLeafNode(otherlv_1, grammarAccess.getFirstConcreteAccess().getFKeyword_1(), null);
                
            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFirstConcrete1126); 

                	createLeafNode(otherlv_2, grammarAccess.getFirstConcreteAccess().getLeftParenthesisKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:558:1: ( (lv_value_3_0= ruleNamed ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:559:1: (lv_value_3_0= ruleNamed )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:559:1: (lv_value_3_0= ruleNamed )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:560:3: lv_value_3_0= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFirstConcreteAccess().getValueNamedParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleFirstConcrete1147);
            lv_value_3_0=ruleNamed();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFirstConcreteRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_3_0, 
            	        		"Named", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:582:2: ( (otherlv_4= RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:583:1: (otherlv_4= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:583:1: (otherlv_4= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:584:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getFirstConcreteRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFirstConcrete1167); 

                    		createLeafNode(otherlv_4, grammarAccess.getFirstConcreteAccess().getReferencedContainerSomeContainerCrossReference_4_0(), "referencedContainer"); 
                    	

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFirstConcrete1180); 

                	createLeafNode(otherlv_5, grammarAccess.getFirstConcreteAccess().getRightParenthesisKeyword_5(), null);
                

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
    // $ANTLR end "ruleFirstConcrete"


    // $ANTLR start "entryRuleSecondConcrete"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:608:1: entryRuleSecondConcrete returns [EObject current=null] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final EObject entryRuleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondConcrete = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:609:2: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:610:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondConcreteRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1216);
            iv_ruleSecondConcrete=ruleSecondConcrete();

            state._fsp--;

             current =iv_ruleSecondConcrete; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondConcrete1226); 

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
    // $ANTLR end "entryRuleSecondConcrete"


    // $ANTLR start "ruleSecondConcrete"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:617:1: ruleSecondConcrete returns [EObject current=null] : (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) ;
    public final EObject ruleSecondConcrete() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_value_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:622:6: ( (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:623:1: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:623:1: (otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:623:3: otherlv_0= '->' otherlv_1= 'F' otherlv_2= 'S' otherlv_3= '(' ( (lv_value_4_0= ruleNamed ) ) ( (otherlv_5= RULE_ID ) )? otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSecondConcrete1263); 

                	createLeafNode(otherlv_0, grammarAccess.getSecondConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0(), null);
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSecondConcrete1275); 

                	createLeafNode(otherlv_1, grammarAccess.getSecondConcreteAccess().getFKeyword_1(), null);
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSecondConcrete1287); 

                	createLeafNode(otherlv_2, grammarAccess.getSecondConcreteAccess().getSKeyword_2(), null);
                
            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSecondConcrete1299); 

                	createLeafNode(otherlv_3, grammarAccess.getSecondConcreteAccess().getLeftParenthesisKeyword_3(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:639:1: ( (lv_value_4_0= ruleNamed ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:640:1: (lv_value_4_0= ruleNamed )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:640:1: (lv_value_4_0= ruleNamed )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:641:3: lv_value_4_0= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSecondConcreteAccess().getValueNamedParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleSecondConcrete1320);
            lv_value_4_0=ruleNamed();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondConcreteRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_4_0, 
            	        		"Named", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:663:2: ( (otherlv_5= RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:664:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:664:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:665:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSecondConcreteRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecondConcrete1340); 

                    		createLeafNode(otherlv_5, grammarAccess.getSecondConcreteAccess().getReferencedChildrenChildCrossReference_5_0(), "referencedChildren"); 
                    	

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSecondConcrete1353); 

                	createLeafNode(otherlv_6, grammarAccess.getSecondConcreteAccess().getRightParenthesisKeyword_6(), null);
                

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
    // $ANTLR end "ruleSecondConcrete"


    // $ANTLR start "entryRuleNamed"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:689:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:690:2: (iv_ruleNamed= ruleNamed EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:691:2: iv_ruleNamed= ruleNamed EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_entryRuleNamed1389);
            iv_ruleNamed=ruleNamed();

            state._fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamed1399); 

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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:698:1: ruleNamed returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:703:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:704:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:704:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:705:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:705:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:706:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamed1440); 

            			createLeafNode(lv_name_0_0, grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedRule().getType().getClassifier());
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
    // $ANTLR end "ruleNamed"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSomeContainer85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSomeContainer122 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSomeContainer139 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSomeContainer156 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_ruleNested_in_ruleSomeContainer178 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_ruleContent_in_ruleSomeContainer205 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_13_in_ruleSomeContainer219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNested_in_entryRuleNested255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNested265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleNested302 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNested314 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_ruleSomeContainer_in_ruleNested335 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_13_in_ruleNested348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent384 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChildren_in_ruleContent441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren503 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChildren513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleChildren550 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleChildren562 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleChildren583 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleChildren596 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleChildren617 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleChildren631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleChild714 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild726 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleChild738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleChild759 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild771 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren807 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAbstractChildren854 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAbstractChildren866 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren887 = new BitSet(new long[]{0x0000000000022000L});
        public static final BitSet FOLLOW_13_in_ruleAbstractChildren900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild936 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete1065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleFirstConcrete1102 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleFirstConcrete1114 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleFirstConcrete1126 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete1147 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1167 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFirstConcrete1180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSecondConcrete1263 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleSecondConcrete1275 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSecondConcrete1287 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleSecondConcrete1299 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1320 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1340 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSecondConcrete1353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1389 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamed1399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1440 = new BitSet(new long[]{0x0000000000000002L});
    }


}
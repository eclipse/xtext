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

public class InternalPartialParserTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'container'", "'{'", "'}'", "'nested'", "'children'", "','", "'->'", "'C'", "'('", "')'", "'abstract children'", "'F'", "'S'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalPartialParserTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g"; }



     	private PartialParserTestLanguageGrammarAccess grammarAccess;
     	
        public InternalPartialParserTestLanguageParser(TokenStream input, IAstFactory factory, PartialParserTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SomeContainer";	
       	} 



    // $ANTLR start entryRuleSomeContainer
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:72:1: entryRuleSomeContainer returns [EObject current=null] : iv_ruleSomeContainer= ruleSomeContainer EOF ;
    public final EObject entryRuleSomeContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSomeContainer = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:73:2: (iv_ruleSomeContainer= ruleSomeContainer EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:74:2: iv_ruleSomeContainer= ruleSomeContainer EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSomeContainerRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer75);
            iv_ruleSomeContainer=ruleSomeContainer();
            _fsp--;

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
    // $ANTLR end entryRuleSomeContainer


    // $ANTLR start ruleSomeContainer
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:81:1: ruleSomeContainer returns [EObject current=null] : ( 'container' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* '}' ) ;
    public final EObject ruleSomeContainer() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_nested_3_0 = null;

        EObject lv_content_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:86:6: ( ( 'container' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:87:1: ( 'container' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:87:1: ( 'container' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:87:3: 'container' ( (lv_name_1_0= RULE_ID ) ) '{' ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )* '}'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSomeContainer120); 

                    createLeafNode(grammarAccess.getSomeContainerAccess().getContainerKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:91:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:92:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:92:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:93:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSomeContainer137); 

            			createLeafNode(grammarAccess.getSomeContainerAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleSomeContainer152); 

                    createLeafNode(grammarAccess.getSomeContainerAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:119:1: ( ( (lv_nested_3_0= ruleNested ) ) | ( (lv_content_4_0= ruleContent ) ) )*
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:119:2: ( (lv_nested_3_0= ruleNested ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:119:2: ( (lv_nested_3_0= ruleNested ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:120:1: (lv_nested_3_0= ruleNested )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:120:1: (lv_nested_3_0= ruleNested )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:121:3: lv_nested_3_0= ruleNested
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSomeContainerAccess().getNestedNestedParserRuleCall_3_0_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNested_in_ruleSomeContainer174);
            	    lv_nested_3_0=ruleNested();
            	    _fsp--;


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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:144:6: ( (lv_content_4_0= ruleContent ) )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:144:6: ( (lv_content_4_0= ruleContent ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:145:1: (lv_content_4_0= ruleContent )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:145:1: (lv_content_4_0= ruleContent )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:146:3: lv_content_4_0= ruleContent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSomeContainerAccess().getContentContentParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleSomeContainer201);
            	    lv_content_4_0=ruleContent();
            	    _fsp--;


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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleSomeContainer213); 

                    createLeafNode(grammarAccess.getSomeContainerAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleSomeContainer


    // $ANTLR start entryRuleNested
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:1: entryRuleNested returns [EObject current=null] : iv_ruleNested= ruleNested EOF ;
    public final EObject entryRuleNested() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNested = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:181:2: (iv_ruleNested= ruleNested EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:182:2: iv_ruleNested= ruleNested EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNested_in_entryRuleNested249);
            iv_ruleNested=ruleNested();
            _fsp--;

             current =iv_ruleNested; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNested259); 

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
    // $ANTLR end entryRuleNested


    // $ANTLR start ruleNested
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:189:1: ruleNested returns [EObject current=null] : ( 'nested' '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ '}' ) ;
    public final EObject ruleNested() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:194:6: ( ( 'nested' '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:195:1: ( 'nested' '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:195:1: ( 'nested' '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:195:3: 'nested' '{' ( (lv_nested_2_0= ruleSomeContainer ) )+ '}'
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleNested294); 

                    createLeafNode(grammarAccess.getNestedAccess().getNestedKeyword_0(), null); 
                
            match(input,12,FollowSets000.FOLLOW_12_in_ruleNested304); 

                    createLeafNode(grammarAccess.getNestedAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:203:1: ( (lv_nested_2_0= ruleSomeContainer ) )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:204:1: (lv_nested_2_0= ruleSomeContainer )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:204:1: (lv_nested_2_0= ruleSomeContainer )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:205:3: lv_nested_2_0= ruleSomeContainer
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNestedAccess().getNestedSomeContainerParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleSomeContainer_in_ruleNested325);
            	    lv_nested_2_0=ruleSomeContainer();
            	    _fsp--;


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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleNested336); 

                    createLeafNode(grammarAccess.getNestedAccess().getRightCurlyBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleNested


    // $ANTLR start entryRuleContent
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:239:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:240:2: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:241:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent372);
            iv_ruleContent=ruleContent();
            _fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent382); 

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
    // $ANTLR end entryRuleContent


    // $ANTLR start ruleContent
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:248:1: ruleContent returns [EObject current=null] : (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Children_0 = null;

        EObject this_AbstractChildren_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:253:6: ( (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:254:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:254:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
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
                    new NoViableAltException("254:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:255:5: this_Children_0= ruleChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getContentAccess().getChildrenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleChildren_in_ruleContent429);
                    this_Children_0=ruleChildren();
                    _fsp--;

                     
                            current = this_Children_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:265:5: this_AbstractChildren_1= ruleAbstractChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getContentAccess().getAbstractChildrenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAbstractChildren_in_ruleContent456);
                    this_AbstractChildren_1=ruleAbstractChildren();
                    _fsp--;

                     
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
    // $ANTLR end ruleContent


    // $ANTLR start entryRuleChildren
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:281:1: entryRuleChildren returns [EObject current=null] : iv_ruleChildren= ruleChildren EOF ;
    public final EObject entryRuleChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildren = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:282:2: (iv_ruleChildren= ruleChildren EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:283:2: iv_ruleChildren= ruleChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildrenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChildren_in_entryRuleChildren491);
            iv_ruleChildren=ruleChildren();
            _fsp--;

             current =iv_ruleChildren; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChildren501); 

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
    // $ANTLR end entryRuleChildren


    // $ANTLR start ruleChildren
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:290:1: ruleChildren returns [EObject current=null] : ( 'children' '{' ( (lv_children_2_0= ruleChild ) ) ( ',' ( (lv_children_4_0= ruleChild ) ) )* '}' ) ;
    public final EObject ruleChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_children_2_0 = null;

        EObject lv_children_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:295:6: ( ( 'children' '{' ( (lv_children_2_0= ruleChild ) ) ( ',' ( (lv_children_4_0= ruleChild ) ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:296:1: ( 'children' '{' ( (lv_children_2_0= ruleChild ) ) ( ',' ( (lv_children_4_0= ruleChild ) ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:296:1: ( 'children' '{' ( (lv_children_2_0= ruleChild ) ) ( ',' ( (lv_children_4_0= ruleChild ) ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:296:3: 'children' '{' ( (lv_children_2_0= ruleChild ) ) ( ',' ( (lv_children_4_0= ruleChild ) ) )* '}'
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleChildren536); 

                    createLeafNode(grammarAccess.getChildrenAccess().getChildrenKeyword_0(), null); 
                
            match(input,12,FollowSets000.FOLLOW_12_in_ruleChildren546); 

                    createLeafNode(grammarAccess.getChildrenAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:304:1: ( (lv_children_2_0= ruleChild ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:305:1: (lv_children_2_0= ruleChild )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:305:1: (lv_children_2_0= ruleChild )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:306:3: lv_children_2_0= ruleChild
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getChildrenAccess().getChildrenChildParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleChildren567);
            lv_children_2_0=ruleChild();
            _fsp--;


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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:328:2: ( ',' ( (lv_children_4_0= ruleChild ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:328:4: ',' ( (lv_children_4_0= ruleChild ) )
            	    {
            	    match(input,16,FollowSets000.FOLLOW_16_in_ruleChildren578); 

            	            createLeafNode(grammarAccess.getChildrenAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:332:1: ( (lv_children_4_0= ruleChild ) )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:333:1: (lv_children_4_0= ruleChild )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:333:1: (lv_children_4_0= ruleChild )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:334:3: lv_children_4_0= ruleChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getChildrenAccess().getChildrenChildParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleChildren599);
            	    lv_children_4_0=ruleChild();
            	    _fsp--;


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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleChildren611); 

                    createLeafNode(grammarAccess.getChildrenAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleChildren


    // $ANTLR start entryRuleChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:368:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:369:2: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:370:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild647);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild657); 

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
    // $ANTLR end entryRuleChild


    // $ANTLR start ruleChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:377:1: ruleChild returns [EObject current=null] : ( '->' 'C' '(' ( (lv_value_3_0= ruleNamed ) ) ')' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:382:6: ( ( '->' 'C' '(' ( (lv_value_3_0= ruleNamed ) ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:383:1: ( '->' 'C' '(' ( (lv_value_3_0= ruleNamed ) ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:383:1: ( '->' 'C' '(' ( (lv_value_3_0= ruleNamed ) ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:383:3: '->' 'C' '(' ( (lv_value_3_0= ruleNamed ) ) ')'
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleChild692); 

                    createLeafNode(grammarAccess.getChildAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            match(input,18,FollowSets000.FOLLOW_18_in_ruleChild702); 

                    createLeafNode(grammarAccess.getChildAccess().getCKeyword_1(), null); 
                
            match(input,19,FollowSets000.FOLLOW_19_in_ruleChild712); 

                    createLeafNode(grammarAccess.getChildAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:395:1: ( (lv_value_3_0= ruleNamed ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:396:1: (lv_value_3_0= ruleNamed )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:396:1: (lv_value_3_0= ruleNamed )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:397:3: lv_value_3_0= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getChildAccess().getValueNamedParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleChild733);
            lv_value_3_0=ruleNamed();
            _fsp--;


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

            match(input,20,FollowSets000.FOLLOW_20_in_ruleChild743); 

                    createLeafNode(grammarAccess.getChildAccess().getRightParenthesisKeyword_4(), null); 
                

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
    // $ANTLR end ruleChild


    // $ANTLR start entryRuleAbstractChildren
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:431:1: entryRuleAbstractChildren returns [EObject current=null] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final EObject entryRuleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChildren = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:432:2: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:433:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractChildrenRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren779);
            iv_ruleAbstractChildren=ruleAbstractChildren();
            _fsp--;

             current =iv_ruleAbstractChildren; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractChildren789); 

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
    // $ANTLR end entryRuleAbstractChildren


    // $ANTLR start ruleAbstractChildren
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:440:1: ruleAbstractChildren returns [EObject current=null] : ( 'abstract children' '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ '}' ) ;
    public final EObject ruleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_abstractChildren_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:445:6: ( ( 'abstract children' '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:446:1: ( 'abstract children' '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:446:1: ( 'abstract children' '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:446:3: 'abstract children' '{' ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+ '}'
            {
            match(input,21,FollowSets000.FOLLOW_21_in_ruleAbstractChildren824); 

                    createLeafNode(grammarAccess.getAbstractChildrenAccess().getAbstractChildrenKeyword_0(), null); 
                
            match(input,12,FollowSets000.FOLLOW_12_in_ruleAbstractChildren834); 

                    createLeafNode(grammarAccess.getAbstractChildrenAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:454:1: ( (lv_abstractChildren_2_0= ruleAbstractChild ) )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:455:1: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:455:1: (lv_abstractChildren_2_0= ruleAbstractChild )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:456:3: lv_abstractChildren_2_0= ruleAbstractChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAbstractChildrenAccess().getAbstractChildrenAbstractChildParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractChild_in_ruleAbstractChildren855);
            	    lv_abstractChildren_2_0=ruleAbstractChild();
            	    _fsp--;


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

            match(input,13,FollowSets000.FOLLOW_13_in_ruleAbstractChildren866); 

                    createLeafNode(grammarAccess.getAbstractChildrenAccess().getRightCurlyBracketKeyword_3(), null); 
                

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
    // $ANTLR end ruleAbstractChildren


    // $ANTLR start entryRuleAbstractChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:490:1: entryRuleAbstractChild returns [EObject current=null] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final EObject entryRuleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:491:2: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:492:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild902);
            iv_ruleAbstractChild=ruleAbstractChild();
            _fsp--;

             current =iv_ruleAbstractChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractChild912); 

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
    // $ANTLR end entryRuleAbstractChild


    // $ANTLR start ruleAbstractChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:499:1: ruleAbstractChild returns [EObject current=null] : (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) ;
    public final EObject ruleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject this_FirstConcrete_0 = null;

        EObject this_SecondConcrete_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:504:6: ( (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:505:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:505:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==22) ) {
                    int LA6_2 = input.LA(3);

                    if ( (LA6_2==19) ) {
                        alt6=1;
                    }
                    else if ( (LA6_2==23) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("505:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("505:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("505:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:506:5: this_FirstConcrete_0= ruleFirstConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractChildAccess().getFirstConcreteParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleFirstConcrete_in_ruleAbstractChild959);
                    this_FirstConcrete_0=ruleFirstConcrete();
                    _fsp--;

                     
                            current = this_FirstConcrete_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:516:5: this_SecondConcrete_1= ruleSecondConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractChildAccess().getSecondConcreteParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSecondConcrete_in_ruleAbstractChild986);
                    this_SecondConcrete_1=ruleSecondConcrete();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstractChild


    // $ANTLR start entryRuleFirstConcrete
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:532:1: entryRuleFirstConcrete returns [EObject current=null] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final EObject entryRuleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstConcrete = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:533:2: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:534:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstConcreteRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1021);
            iv_ruleFirstConcrete=ruleFirstConcrete();
            _fsp--;

             current =iv_ruleFirstConcrete; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstConcrete1031); 

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
    // $ANTLR end entryRuleFirstConcrete


    // $ANTLR start ruleFirstConcrete
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:541:1: ruleFirstConcrete returns [EObject current=null] : ( '->' 'F' '(' ( (lv_value_3_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' ) ;
    public final EObject ruleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:546:6: ( ( '->' 'F' '(' ( (lv_value_3_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:547:1: ( '->' 'F' '(' ( (lv_value_3_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:547:1: ( '->' 'F' '(' ( (lv_value_3_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:547:3: '->' 'F' '(' ( (lv_value_3_0= ruleNamed ) ) ( ( RULE_ID ) )? ')'
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleFirstConcrete1066); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            match(input,22,FollowSets000.FOLLOW_22_in_ruleFirstConcrete1076); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getFKeyword_1(), null); 
                
            match(input,19,FollowSets000.FOLLOW_19_in_ruleFirstConcrete1086); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:559:1: ( (lv_value_3_0= ruleNamed ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:560:1: (lv_value_3_0= ruleNamed )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:560:1: (lv_value_3_0= ruleNamed )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:561:3: lv_value_3_0= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFirstConcreteAccess().getValueNamedParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleFirstConcrete1107);
            lv_value_3_0=ruleNamed();
            _fsp--;


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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:583:2: ( ( RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:584:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:584:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getFirstConcreteRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFirstConcrete1125); 

                    		createLeafNode(grammarAccess.getFirstConcreteAccess().getReferencedContainerSomeContainerCrossReference_4_0(), "referencedContainer"); 
                    	

                    }


                    }
                    break;

            }

            match(input,20,FollowSets000.FOLLOW_20_in_ruleFirstConcrete1136); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getRightParenthesisKeyword_5(), null); 
                

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
    // $ANTLR end ruleFirstConcrete


    // $ANTLR start entryRuleSecondConcrete
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:609:1: entryRuleSecondConcrete returns [EObject current=null] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final EObject entryRuleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondConcrete = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:610:2: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:611:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondConcreteRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1172);
            iv_ruleSecondConcrete=ruleSecondConcrete();
            _fsp--;

             current =iv_ruleSecondConcrete; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecondConcrete1182); 

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
    // $ANTLR end entryRuleSecondConcrete


    // $ANTLR start ruleSecondConcrete
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:618:1: ruleSecondConcrete returns [EObject current=null] : ( '->' 'F' 'S' '(' ( (lv_value_4_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' ) ;
    public final EObject ruleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:623:6: ( ( '->' 'F' 'S' '(' ( (lv_value_4_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:624:1: ( '->' 'F' 'S' '(' ( (lv_value_4_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:624:1: ( '->' 'F' 'S' '(' ( (lv_value_4_0= ruleNamed ) ) ( ( RULE_ID ) )? ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:624:3: '->' 'F' 'S' '(' ( (lv_value_4_0= ruleNamed ) ) ( ( RULE_ID ) )? ')'
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleSecondConcrete1217); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            match(input,22,FollowSets000.FOLLOW_22_in_ruleSecondConcrete1227); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getFKeyword_1(), null); 
                
            match(input,23,FollowSets000.FOLLOW_23_in_ruleSecondConcrete1237); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getSKeyword_2(), null); 
                
            match(input,19,FollowSets000.FOLLOW_19_in_ruleSecondConcrete1247); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getLeftParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:640:1: ( (lv_value_4_0= ruleNamed ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:641:1: (lv_value_4_0= ruleNamed )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:641:1: (lv_value_4_0= ruleNamed )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:642:3: lv_value_4_0= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSecondConcreteAccess().getValueNamedParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleSecondConcrete1268);
            lv_value_4_0=ruleNamed();
            _fsp--;


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

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:664:2: ( ( RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:665:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:665:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:666:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSecondConcreteRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSecondConcrete1286); 

                    		createLeafNode(grammarAccess.getSecondConcreteAccess().getReferencedChildrenChildCrossReference_5_0(), "referencedChildren"); 
                    	

                    }


                    }
                    break;

            }

            match(input,20,FollowSets000.FOLLOW_20_in_ruleSecondConcrete1297); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getRightParenthesisKeyword_6(), null); 
                

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
    // $ANTLR end ruleSecondConcrete


    // $ANTLR start entryRuleNamed
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:690:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:691:2: (iv_ruleNamed= ruleNamed EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:692:2: iv_ruleNamed= ruleNamed EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_entryRuleNamed1333);
            iv_ruleNamed=ruleNamed();
            _fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamed1343); 

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
    // $ANTLR end entryRuleNamed


    // $ANTLR start ruleNamed
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:699:1: ruleNamed returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:704:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:705:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:705:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:706:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:706:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:707:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamed1384); 

            			createLeafNode(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

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
    // $ANTLR end ruleNamed


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSomeContainer85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSomeContainer120 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSomeContainer137 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSomeContainer152 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_ruleNested_in_ruleSomeContainer174 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_ruleContent_in_ruleSomeContainer201 = new BitSet(new long[]{0x000000000020E000L});
        public static final BitSet FOLLOW_13_in_ruleSomeContainer213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNested_in_entryRuleNested249 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNested259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleNested294 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleNested304 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_ruleSomeContainer_in_ruleNested325 = new BitSet(new long[]{0x0000000000002800L});
        public static final BitSet FOLLOW_13_in_ruleNested336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent372 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChildren_in_ruleContent429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChildren501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleChildren536 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleChildren546 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleChildren567 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_16_in_ruleChildren578 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleChildren599 = new BitSet(new long[]{0x0000000000012000L});
        public static final BitSet FOLLOW_13_in_ruleChildren611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild647 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild657 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleChild692 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleChild702 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleChild712 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleChild733 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleChild743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren779 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAbstractChildren824 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAbstractChildren834 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren855 = new BitSet(new long[]{0x0000000000022000L});
        public static final BitSet FOLLOW_13_in_ruleAbstractChildren866 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild902 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1021 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete1031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleFirstConcrete1066 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleFirstConcrete1076 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleFirstConcrete1086 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete1107 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1125 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFirstConcrete1136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSecondConcrete1217 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleSecondConcrete1227 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSecondConcrete1237 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleSecondConcrete1247 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1268 = new BitSet(new long[]{0x0000000000100010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1286 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleSecondConcrete1297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamed1343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1384 = new BitSet(new long[]{0x0000000000000002L});
    }


}
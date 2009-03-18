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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:69:1: entryRuleSomeContainer returns [EObject current=null] : iv_ruleSomeContainer= ruleSomeContainer EOF ;
    public final EObject entryRuleSomeContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSomeContainer = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:69:55: (iv_ruleSomeContainer= ruleSomeContainer EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:70:2: iv_ruleSomeContainer= ruleSomeContainer EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSomeContainerRule(), currentNode); 
            pushFollow(FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer71);
            iv_ruleSomeContainer=ruleSomeContainer();
            _fsp--;

             current =iv_ruleSomeContainer; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSomeContainer81); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:77:1: ruleSomeContainer returns [EObject current=null] : ( 'container' (lv_name_1= RULE_ID ) '{' ( (lv_nested_3= ruleNested ) | (lv_content_4= ruleContent ) )* '}' ) ;
    public final EObject ruleSomeContainer() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_nested_3 = null;

        EObject lv_content_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:82:6: ( ( 'container' (lv_name_1= RULE_ID ) '{' ( (lv_nested_3= ruleNested ) | (lv_content_4= ruleContent ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:1: ( 'container' (lv_name_1= RULE_ID ) '{' ( (lv_nested_3= ruleNested ) | (lv_content_4= ruleContent ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:1: ( 'container' (lv_name_1= RULE_ID ) '{' ( (lv_nested_3= ruleNested ) | (lv_content_4= ruleContent ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:2: 'container' (lv_name_1= RULE_ID ) '{' ( (lv_nested_3= ruleNested ) | (lv_content_4= ruleContent ) )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleSomeContainer115); 

                    createLeafNode(grammarAccess.getSomeContainerAccess().getContainerKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:87:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:89:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSomeContainer137); 

            		createLeafNode(grammarAccess.getSomeContainerAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSomeContainerRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,12,FOLLOW_12_in_ruleSomeContainer154); 

                    createLeafNode(grammarAccess.getSomeContainerAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:111:1: ( (lv_nested_3= ruleNested ) | (lv_content_4= ruleContent ) )*
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:111:2: (lv_nested_3= ruleNested )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:111:2: (lv_nested_3= ruleNested )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:114:6: lv_nested_3= ruleNested
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSomeContainerAccess().getNestedNestedParserRuleCall_3_0_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNested_in_ruleSomeContainer189);
            	    lv_nested_3=ruleNested();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSomeContainerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "nested", lv_nested_3, "Nested", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:133:6: (lv_content_4= ruleContent )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:133:6: (lv_content_4= ruleContent )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:136:6: lv_content_4= ruleContent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getSomeContainerAccess().getContentContentParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContent_in_ruleSomeContainer233);
            	    lv_content_4=ruleContent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getSomeContainerRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "content", lv_content_4, "Content", currentNode);
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

            match(input,13,FOLLOW_13_in_ruleSomeContainer248); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:165:1: entryRuleNested returns [EObject current=null] : iv_ruleNested= ruleNested EOF ;
    public final EObject entryRuleNested() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNested = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:165:48: (iv_ruleNested= ruleNested EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:166:2: iv_ruleNested= ruleNested EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedRule(), currentNode); 
            pushFollow(FOLLOW_ruleNested_in_entryRuleNested281);
            iv_ruleNested=ruleNested();
            _fsp--;

             current =iv_ruleNested; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNested291); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:173:1: ruleNested returns [EObject current=null] : ( 'nested' '{' (lv_nested_2= ruleSomeContainer )+ '}' ) ;
    public final EObject ruleNested() throws RecognitionException {
        EObject current = null;

        EObject lv_nested_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:178:6: ( ( 'nested' '{' (lv_nested_2= ruleSomeContainer )+ '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:179:1: ( 'nested' '{' (lv_nested_2= ruleSomeContainer )+ '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:179:1: ( 'nested' '{' (lv_nested_2= ruleSomeContainer )+ '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:179:2: 'nested' '{' (lv_nested_2= ruleSomeContainer )+ '}'
            {
            match(input,14,FOLLOW_14_in_ruleNested325); 

                    createLeafNode(grammarAccess.getNestedAccess().getNestedKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleNested334); 

                    createLeafNode(grammarAccess.getNestedAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:187:1: (lv_nested_2= ruleSomeContainer )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:190:6: lv_nested_2= ruleSomeContainer
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getNestedAccess().getNestedSomeContainerParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleSomeContainer_in_ruleNested368);
            	    lv_nested_2=ruleSomeContainer();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getNestedRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "nested", lv_nested_2, "SomeContainer", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

            match(input,13,FOLLOW_13_in_ruleNested382); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:219:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:219:49: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:220:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContentRule(), currentNode); 
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent415);
            iv_ruleContent=ruleContent();
            _fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent425); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:227:1: ruleContent returns [EObject current=null] : (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Children_0 = null;

        EObject this_AbstractChildren_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:232:6: ( (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:233:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:233:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )
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
                    new NoViableAltException("233:1: (this_Children_0= ruleChildren | this_AbstractChildren_1= ruleAbstractChildren )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:234:5: this_Children_0= ruleChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getContentAccess().getChildrenParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChildren_in_ruleContent472);
                    this_Children_0=ruleChildren();
                    _fsp--;

                     
                            current = this_Children_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:244:5: this_AbstractChildren_1= ruleAbstractChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getContentAccess().getAbstractChildrenParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractChildren_in_ruleContent499);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:259:1: entryRuleChildren returns [EObject current=null] : iv_ruleChildren= ruleChildren EOF ;
    public final EObject entryRuleChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildren = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:259:50: (iv_ruleChildren= ruleChildren EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:260:2: iv_ruleChildren= ruleChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildrenRule(), currentNode); 
            pushFollow(FOLLOW_ruleChildren_in_entryRuleChildren531);
            iv_ruleChildren=ruleChildren();
            _fsp--;

             current =iv_ruleChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChildren541); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:267:1: ruleChildren returns [EObject current=null] : ( 'children' '{' (lv_children_2= ruleChild ) ( ',' (lv_children_4= ruleChild ) )* '}' ) ;
    public final EObject ruleChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_children_2 = null;

        EObject lv_children_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:272:6: ( ( 'children' '{' (lv_children_2= ruleChild ) ( ',' (lv_children_4= ruleChild ) )* '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:273:1: ( 'children' '{' (lv_children_2= ruleChild ) ( ',' (lv_children_4= ruleChild ) )* '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:273:1: ( 'children' '{' (lv_children_2= ruleChild ) ( ',' (lv_children_4= ruleChild ) )* '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:273:2: 'children' '{' (lv_children_2= ruleChild ) ( ',' (lv_children_4= ruleChild ) )* '}'
            {
            match(input,15,FOLLOW_15_in_ruleChildren575); 

                    createLeafNode(grammarAccess.getChildrenAccess().getChildrenKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleChildren584); 

                    createLeafNode(grammarAccess.getChildrenAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:281:1: (lv_children_2= ruleChild )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:284:6: lv_children_2= ruleChild
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getChildrenAccess().getChildrenChildParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleChild_in_ruleChildren618);
            lv_children_2=ruleChild();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChildrenRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		add(current, "children", lv_children_2, "Child", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:302:2: ( ',' (lv_children_4= ruleChild ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:302:3: ',' (lv_children_4= ruleChild )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleChildren632); 

            	            createLeafNode(grammarAccess.getChildrenAccess().getCommaKeyword_3_0(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:306:1: (lv_children_4= ruleChild )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:309:6: lv_children_4= ruleChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getChildrenAccess().getChildrenChildParserRuleCall_3_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChild_in_ruleChildren666);
            	    lv_children_4=ruleChild();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getChildrenRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "children", lv_children_4, "Child", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleChildren681); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:338:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:338:47: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:339:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild714);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild724); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:346:1: ruleChild returns [EObject current=null] : ( '->' 'C' '(' (lv_value_3= ruleNamed ) ')' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:351:6: ( ( '->' 'C' '(' (lv_value_3= ruleNamed ) ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:352:1: ( '->' 'C' '(' (lv_value_3= ruleNamed ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:352:1: ( '->' 'C' '(' (lv_value_3= ruleNamed ) ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:352:2: '->' 'C' '(' (lv_value_3= ruleNamed ) ')'
            {
            match(input,17,FOLLOW_17_in_ruleChild758); 

                    createLeafNode(grammarAccess.getChildAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            match(input,18,FOLLOW_18_in_ruleChild767); 

                    createLeafNode(grammarAccess.getChildAccess().getCKeyword_1(), null); 
                
            match(input,19,FOLLOW_19_in_ruleChild776); 

                    createLeafNode(grammarAccess.getChildAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:364:1: (lv_value_3= ruleNamed )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:367:6: lv_value_3= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getChildAccess().getValueNamedParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleChild810);
            lv_value_3=ruleNamed();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChildRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_3, "Named", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            match(input,20,FOLLOW_20_in_ruleChild823); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:396:1: entryRuleAbstractChildren returns [EObject current=null] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final EObject entryRuleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChildren = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:396:58: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:397:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractChildrenRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren856);
            iv_ruleAbstractChildren=ruleAbstractChildren();
            _fsp--;

             current =iv_ruleAbstractChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChildren866); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:404:1: ruleAbstractChildren returns [EObject current=null] : ( 'abstract children' '{' (lv_abstractChildren_2= ruleAbstractChild )+ '}' ) ;
    public final EObject ruleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_abstractChildren_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:409:6: ( ( 'abstract children' '{' (lv_abstractChildren_2= ruleAbstractChild )+ '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:410:1: ( 'abstract children' '{' (lv_abstractChildren_2= ruleAbstractChild )+ '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:410:1: ( 'abstract children' '{' (lv_abstractChildren_2= ruleAbstractChild )+ '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:410:2: 'abstract children' '{' (lv_abstractChildren_2= ruleAbstractChild )+ '}'
            {
            match(input,21,FOLLOW_21_in_ruleAbstractChildren900); 

                    createLeafNode(grammarAccess.getAbstractChildrenAccess().getAbstractChildrenKeyword_0(), null); 
                
            match(input,12,FOLLOW_12_in_ruleAbstractChildren909); 

                    createLeafNode(grammarAccess.getAbstractChildrenAccess().getLeftCurlyBracketKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:418:1: (lv_abstractChildren_2= ruleAbstractChild )+
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
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:421:6: lv_abstractChildren_2= ruleAbstractChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAbstractChildrenAccess().getAbstractChildrenAbstractChildParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractChild_in_ruleAbstractChildren943);
            	    lv_abstractChildren_2=ruleAbstractChild();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAbstractChildrenRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "abstractChildren", lv_abstractChildren_2, "AbstractChild", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

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

            match(input,13,FOLLOW_13_in_ruleAbstractChildren957); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:450:1: entryRuleAbstractChild returns [EObject current=null] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final EObject entryRuleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:450:55: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:451:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractChildRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild990);
            iv_ruleAbstractChild=ruleAbstractChild();
            _fsp--;

             current =iv_ruleAbstractChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChild1000); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:458:1: ruleAbstractChild returns [EObject current=null] : (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) ;
    public final EObject ruleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject this_FirstConcrete_0 = null;

        EObject this_SecondConcrete_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:463:6: ( (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:464:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:464:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )
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
                            new NoViableAltException("464:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("464:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("464:1: (this_FirstConcrete_0= ruleFirstConcrete | this_SecondConcrete_1= ruleSecondConcrete )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:465:5: this_FirstConcrete_0= ruleFirstConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractChildAccess().getFirstConcreteParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1047);
                    this_FirstConcrete_0=ruleFirstConcrete();
                    _fsp--;

                     
                            current = this_FirstConcrete_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:475:5: this_SecondConcrete_1= ruleSecondConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractChildAccess().getSecondConcreteParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1074);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:490:1: entryRuleFirstConcrete returns [EObject current=null] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final EObject entryRuleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstConcrete = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:490:55: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:491:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFirstConcreteRule(), currentNode); 
            pushFollow(FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1106);
            iv_ruleFirstConcrete=ruleFirstConcrete();
            _fsp--;

             current =iv_ruleFirstConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstConcrete1116); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:498:1: ruleFirstConcrete returns [EObject current=null] : ( '->' 'F' '(' (lv_value_3= ruleNamed ) ( RULE_ID )? ')' ) ;
    public final EObject ruleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:503:6: ( ( '->' 'F' '(' (lv_value_3= ruleNamed ) ( RULE_ID )? ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:504:1: ( '->' 'F' '(' (lv_value_3= ruleNamed ) ( RULE_ID )? ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:504:1: ( '->' 'F' '(' (lv_value_3= ruleNamed ) ( RULE_ID )? ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:504:2: '->' 'F' '(' (lv_value_3= ruleNamed ) ( RULE_ID )? ')'
            {
            match(input,17,FOLLOW_17_in_ruleFirstConcrete1150); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleFirstConcrete1159); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getFKeyword_1(), null); 
                
            match(input,19,FOLLOW_19_in_ruleFirstConcrete1168); 

                    createLeafNode(grammarAccess.getFirstConcreteAccess().getLeftParenthesisKeyword_2(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:516:1: (lv_value_3= ruleNamed )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:519:6: lv_value_3= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getFirstConcreteAccess().getValueNamedParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleFirstConcrete1202);
            lv_value_3=ruleNamed();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFirstConcreteRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_3, "Named", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:537:2: ( RULE_ID )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:540:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getFirstConcreteRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstConcrete1228); 

                    		createLeafNode(grammarAccess.getFirstConcreteAccess().getReferencedContainerSomeContainerCrossReference_4_0(), "referencedContainer"); 
                    	

                    }
                    break;

            }

            match(input,20,FOLLOW_20_in_ruleFirstConcrete1241); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:564:1: entryRuleSecondConcrete returns [EObject current=null] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final EObject entryRuleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondConcrete = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:564:56: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:565:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSecondConcreteRule(), currentNode); 
            pushFollow(FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1274);
            iv_ruleSecondConcrete=ruleSecondConcrete();
            _fsp--;

             current =iv_ruleSecondConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondConcrete1284); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:572:1: ruleSecondConcrete returns [EObject current=null] : ( '->' 'F' 'S' '(' (lv_value_4= ruleNamed ) ( RULE_ID )? ')' ) ;
    public final EObject ruleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value_4 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:577:6: ( ( '->' 'F' 'S' '(' (lv_value_4= ruleNamed ) ( RULE_ID )? ')' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:578:1: ( '->' 'F' 'S' '(' (lv_value_4= ruleNamed ) ( RULE_ID )? ')' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:578:1: ( '->' 'F' 'S' '(' (lv_value_4= ruleNamed ) ( RULE_ID )? ')' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:578:2: '->' 'F' 'S' '(' (lv_value_4= ruleNamed ) ( RULE_ID )? ')'
            {
            match(input,17,FOLLOW_17_in_ruleSecondConcrete1318); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0(), null); 
                
            match(input,22,FOLLOW_22_in_ruleSecondConcrete1327); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getFKeyword_1(), null); 
                
            match(input,23,FOLLOW_23_in_ruleSecondConcrete1336); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getSKeyword_2(), null); 
                
            match(input,19,FOLLOW_19_in_ruleSecondConcrete1345); 

                    createLeafNode(grammarAccess.getSecondConcreteAccess().getLeftParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:594:1: (lv_value_4= ruleNamed )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:597:6: lv_value_4= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSecondConcreteAccess().getValueNamedParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleSecondConcrete1379);
            lv_value_4=ruleNamed();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSecondConcreteRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "value", lv_value_4, "Named", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:615:2: ( RULE_ID )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:618:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSecondConcreteRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondConcrete1405); 

                    		createLeafNode(grammarAccess.getSecondConcreteAccess().getReferencedChildrenChildCrossReference_5_0(), "referencedChildren"); 
                    	

                    }
                    break;

            }

            match(input,20,FOLLOW_20_in_ruleSecondConcrete1418); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:642:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:642:47: (iv_ruleNamed= ruleNamed EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:643:2: iv_ruleNamed= ruleNamed EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNamedRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamed_in_entryRuleNamed1451);
            iv_ruleNamed=ruleNamed();
            _fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamed1461); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:650:1: ruleNamed returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:655:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:656:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:656:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:658:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamed1507); 

            		createLeafNode(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNamedRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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


 

    public static final BitSet FOLLOW_ruleSomeContainer_in_entryRuleSomeContainer71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSomeContainer81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSomeContainer115 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSomeContainer137 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSomeContainer154 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleNested_in_ruleSomeContainer189 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleContent_in_ruleSomeContainer233 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_13_in_ruleSomeContainer248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNested_in_entryRuleNested281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNested291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleNested325 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNested334 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ruleSomeContainer_in_ruleNested368 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_13_in_ruleNested382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent415 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_ruleContent472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChildren541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleChildren575 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleChildren584 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren618 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleChildren632 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren666 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleChildren681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleChild758 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleChild767 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleChild776 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleChild810 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleChild823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren856 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractChildren900 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAbstractChildren909 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren943 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleAbstractChildren957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFirstConcrete1150 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFirstConcrete1159 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFirstConcrete1168 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete1202 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1228 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFirstConcrete1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSecondConcrete1318 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSecondConcrete1327 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSecondConcrete1336 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSecondConcrete1345 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1379 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1405 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSecondConcrete1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamed1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1507 = new BitSet(new long[]{0x0000000000000002L});

}
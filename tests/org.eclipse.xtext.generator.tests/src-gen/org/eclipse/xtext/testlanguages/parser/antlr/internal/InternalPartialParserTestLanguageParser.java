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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g"; }


     
     	private PartialParserTestLanguageGrammarAccess grammarAccess;
     	
        public InternalPartialParserTestLanguageParser(TokenStream input, IAstFactory factory, PartialParserTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalPartialParserTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Container";	
       	} 



    // $ANTLR start entryRuleContainer
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:70:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:70:51: (iv_ruleContainer= ruleContainer EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:71:2: iv_ruleContainer= ruleContainer EOF
            {
             currentNode = createCompositeNode(grammarAccess.prContainer().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleContainer_in_entryRuleContainer72);
            iv_ruleContainer=ruleContainer();
            _fsp--;

             current =iv_ruleContainer; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainer82); 

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
    // $ANTLR end entryRuleContainer


    // $ANTLR start ruleContainer
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:78:1: ruleContainer returns [EObject current=null] : ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nested = null;

        EObject lv_content = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:82:6: ( ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:1: ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:1: ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:2: ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:2: ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:3: ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:3: ( ( 'container' (lv_name= RULE_ID ) ) '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:4: ( 'container' (lv_name= RULE_ID ) ) '{'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:4: ( 'container' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:83:5: 'container' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleContainer119); 

                    createLeafNode(grammarAccess.prContainer().ele0000KeywordContainer(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:87:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:89:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainer140); 
             
                createLeafNode(grammarAccess.prContainer().ele00010LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Container");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleContainer161); 

                    createLeafNode(grammarAccess.prContainer().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:111:2: ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )*
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
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:111:3: (lv_nested= ruleNested )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:111:3: (lv_nested= ruleNested )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:114:6: lv_nested= ruleNested
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prContainer().ele0100ParserRuleCallNested(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNested_in_ruleContainer197);
            	    lv_nested=ruleNested();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Container");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "nested", lv_nested, "Nested", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:133:6: (lv_content= ruleContent )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:133:6: (lv_content= ruleContent )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:136:6: lv_content= ruleContent
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prContainer().ele0110ParserRuleCallContent(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContent_in_ruleContainer241);
            	    lv_content=ruleContent();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Container");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "content", lv_content, "Content", currentNode);
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

            match(input,13,FOLLOW_13_in_ruleContainer257); 

                    createLeafNode(grammarAccess.prContainer().ele1KeywordRightCurlyBracket(), null); 
                

            }


            }

             resetLookahead(); 
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleContainer


    // $ANTLR start entryRuleNested
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:167:1: entryRuleNested returns [EObject current=null] : iv_ruleNested= ruleNested EOF ;
    public final EObject entryRuleNested() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNested = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:167:48: (iv_ruleNested= ruleNested EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:168:2: iv_ruleNested= ruleNested EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNested().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNested_in_entryRuleNested292);
            iv_ruleNested=ruleNested();
            _fsp--;

             current =iv_ruleNested; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNested302); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:175:1: ruleNested returns [EObject current=null] : ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' ) ;
    public final EObject ruleNested() throws RecognitionException {
        EObject current = null;

        EObject lv_nested = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:179:6: ( ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:1: ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:1: ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:2: ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:2: ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:3: ( 'nested' '{' ) (lv_nested= ruleContainer )+
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:3: ( 'nested' '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:180:4: 'nested' '{'
            {
            match(input,14,FOLLOW_14_in_ruleNested338); 

                    createLeafNode(grammarAccess.prNested().ele000KeywordNested(), null); 
                
            match(input,12,FOLLOW_12_in_ruleNested347); 

                    createLeafNode(grammarAccess.prNested().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:188:2: (lv_nested= ruleContainer )+
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
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:191:6: lv_nested= ruleContainer
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prNested().ele010ParserRuleCallContainer(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContainer_in_ruleNested382);
            	    lv_nested=ruleContainer();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Nested");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "nested", lv_nested, "Container", currentNode);
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


            }

            match(input,13,FOLLOW_13_in_ruleNested397); 

                    createLeafNode(grammarAccess.prNested().ele1KeywordRightCurlyBracket(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:222:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:222:49: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:223:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.prContent().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent432);
            iv_ruleContent=ruleContent();
            _fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent442); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:230:1: ruleContent returns [EObject current=null] : (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Children = null;

        EObject this_AbstractChildren = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:234:6: ( (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:235:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:235:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )
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
                    new NoViableAltException("235:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:236:5: this_Children= ruleChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prContent().ele0ParserRuleCallChildren(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChildren_in_ruleContent489);
                    this_Children=ruleChildren();
                    _fsp--;

                     
                            current = this_Children; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:246:5: this_AbstractChildren= ruleAbstractChildren
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prContent().ele1ParserRuleCallAbstractChildren(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractChildren_in_ruleContent516);
                    this_AbstractChildren=ruleAbstractChildren();
                    _fsp--;

                     
                            current = this_AbstractChildren; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:263:1: entryRuleChildren returns [EObject current=null] : iv_ruleChildren= ruleChildren EOF ;
    public final EObject entryRuleChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildren = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:263:50: (iv_ruleChildren= ruleChildren EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:264:2: iv_ruleChildren= ruleChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChildren().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChildren_in_entryRuleChildren550);
            iv_ruleChildren=ruleChildren();
            _fsp--;

             current =iv_ruleChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChildren560); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:271:1: ruleChildren returns [EObject current=null] : ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' ) ;
    public final EObject ruleChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:275:6: ( ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:1: ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:1: ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:2: ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:2: ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:3: ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:3: ( ( 'children' '{' ) (lv_children= ruleChild ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:4: ( 'children' '{' ) (lv_children= ruleChild )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:4: ( 'children' '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:276:5: 'children' '{'
            {
            match(input,15,FOLLOW_15_in_ruleChildren597); 

                    createLeafNode(grammarAccess.prChildren().ele0000KeywordChildren(), null); 
                
            match(input,12,FOLLOW_12_in_ruleChildren606); 

                    createLeafNode(grammarAccess.prChildren().ele0001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:284:2: (lv_children= ruleChild )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:287:6: lv_children= ruleChild
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prChildren().ele0010ParserRuleCallChild(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleChild_in_ruleChildren641);
            lv_children=ruleChild();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Children");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "children", lv_children, "Child", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:305:3: ( ',' (lv_children= ruleChild ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:305:4: ',' (lv_children= ruleChild )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleChildren656); 

            	            createLeafNode(grammarAccess.prChildren().ele010KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:309:1: (lv_children= ruleChild )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:312:6: lv_children= ruleChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prChildren().ele0110ParserRuleCallChild(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChild_in_ruleChildren690);
            	    lv_children=ruleChild();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Children");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children, "Child", currentNode);
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


            }

            match(input,13,FOLLOW_13_in_ruleChildren706); 

                    createLeafNode(grammarAccess.prChildren().ele1KeywordRightCurlyBracket(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:343:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:343:47: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:344:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild741);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild751); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:351:1: ruleChild returns [EObject current=null] : ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:355:6: ( ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:1: ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:1: ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:2: ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:2: ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:3: ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:3: ( ( '->' 'C' ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:4: ( '->' 'C' ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:4: ( '->' 'C' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:356:5: '->' 'C'
            {
            match(input,17,FOLLOW_17_in_ruleChild788); 

                    createLeafNode(grammarAccess.prChild().ele0000KeywordHyphenMinusGreaterThanSign(), null); 
                
            match(input,18,FOLLOW_18_in_ruleChild797); 

                    createLeafNode(grammarAccess.prChild().ele0001KeywordC(), null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleChild807); 

                    createLeafNode(grammarAccess.prChild().ele001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:368:2: (lv_value= ruleNamed )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:371:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prChild().ele010ParserRuleCallNamed(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleChild842);
            lv_value=ruleNamed();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Child");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "Named", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,20,FOLLOW_20_in_ruleChild856); 

                    createLeafNode(grammarAccess.prChild().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:402:1: entryRuleAbstractChildren returns [EObject current=null] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final EObject entryRuleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChildren = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:402:58: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:403:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractChildren().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren891);
            iv_ruleAbstractChildren=ruleAbstractChildren();
            _fsp--;

             current =iv_ruleAbstractChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChildren901); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:410:1: ruleAbstractChildren returns [EObject current=null] : ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' ) ;
    public final EObject ruleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_abstractChildren = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:414:6: ( ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:1: ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:1: ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:2: ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:2: ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:3: ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:3: ( 'abstract children' '{' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:415:4: 'abstract children' '{'
            {
            match(input,21,FOLLOW_21_in_ruleAbstractChildren937); 

                    createLeafNode(grammarAccess.prAbstractChildren().ele000KeywordAbstractChildren(), null); 
                
            match(input,12,FOLLOW_12_in_ruleAbstractChildren946); 

                    createLeafNode(grammarAccess.prAbstractChildren().ele001KeywordLeftCurlyBracket(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:423:2: (lv_abstractChildren= ruleAbstractChild )+
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
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:426:6: lv_abstractChildren= ruleAbstractChild
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prAbstractChildren().ele010ParserRuleCallAbstractChild(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractChild_in_ruleAbstractChildren981);
            	    lv_abstractChildren=ruleAbstractChild();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractChildren");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "abstractChildren", lv_abstractChildren, "AbstractChild", currentNode);
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


            }

            match(input,13,FOLLOW_13_in_ruleAbstractChildren996); 

                    createLeafNode(grammarAccess.prAbstractChildren().ele1KeywordRightCurlyBracket(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:457:1: entryRuleAbstractChild returns [EObject current=null] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final EObject entryRuleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:457:55: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:458:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAbstractChild().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild1031);
            iv_ruleAbstractChild=ruleAbstractChild();
            _fsp--;

             current =iv_ruleAbstractChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChild1041); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:465:1: ruleAbstractChild returns [EObject current=null] : (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete ) ;
    public final EObject ruleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject this_FirstConcrete = null;

        EObject this_SecondConcrete = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:469:6: ( (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:470:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:470:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )
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
                            new NoViableAltException("470:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("470:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("470:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:471:5: this_FirstConcrete= ruleFirstConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractChild().ele0ParserRuleCallFirstConcrete(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1088);
                    this_FirstConcrete=ruleFirstConcrete();
                    _fsp--;

                     
                            current = this_FirstConcrete; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:481:5: this_SecondConcrete= ruleSecondConcrete
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prAbstractChild().ele1ParserRuleCallSecondConcrete(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1115);
                    this_SecondConcrete=ruleSecondConcrete();
                    _fsp--;

                     
                            current = this_SecondConcrete; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:498:1: entryRuleFirstConcrete returns [EObject current=null] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final EObject entryRuleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstConcrete = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:498:55: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:499:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFirstConcrete().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1149);
            iv_ruleFirstConcrete=ruleFirstConcrete();
            _fsp--;

             current =iv_ruleFirstConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstConcrete1159); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:506:1: ruleFirstConcrete returns [EObject current=null] : ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) ;
    public final EObject ruleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:510:6: ( ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:1: ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:1: ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:2: ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:2: ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:3: ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:3: ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:4: ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:4: ( ( '->' 'F' ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:5: ( '->' 'F' ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:5: ( '->' 'F' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:511:6: '->' 'F'
            {
            match(input,17,FOLLOW_17_in_ruleFirstConcrete1197); 

                    createLeafNode(grammarAccess.prFirstConcrete().ele00000KeywordHyphenMinusGreaterThanSign(), null); 
                
            match(input,22,FOLLOW_22_in_ruleFirstConcrete1206); 

                    createLeafNode(grammarAccess.prFirstConcrete().ele00001KeywordF(), null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleFirstConcrete1216); 

                    createLeafNode(grammarAccess.prFirstConcrete().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:523:2: (lv_value= ruleNamed )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:526:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prFirstConcrete().ele0010ParserRuleCallNamed(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleFirstConcrete1251);
            lv_value=ruleNamed();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("FirstConcrete");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "Named", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:544:3: ( ( RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:547:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("FirstConcrete");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:553:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:554:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstConcrete1280); 
                     
                        createLeafNode(grammarAccess.prFirstConcrete().ele010CrossReferenceEStringContainer(), "referencedContainer"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,20,FOLLOW_20_in_ruleFirstConcrete1295); 

                    createLeafNode(grammarAccess.prFirstConcrete().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:572:1: entryRuleSecondConcrete returns [EObject current=null] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final EObject entryRuleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondConcrete = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:572:56: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:573:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSecondConcrete().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1330);
            iv_ruleSecondConcrete=ruleSecondConcrete();
            _fsp--;

             current =iv_ruleSecondConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondConcrete1340); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:580:1: ruleSecondConcrete returns [EObject current=null] : ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) ;
    public final EObject ruleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:584:6: ( ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:1: ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:1: ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:2: ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:2: ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:3: ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:3: ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:4: ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:4: ( ( ( '->' 'F' ) 'S' ) '(' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:5: ( ( '->' 'F' ) 'S' ) '('
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:5: ( ( '->' 'F' ) 'S' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:6: ( '->' 'F' ) 'S'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:6: ( '->' 'F' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:585:7: '->' 'F'
            {
            match(input,17,FOLLOW_17_in_ruleSecondConcrete1379); 

                    createLeafNode(grammarAccess.prSecondConcrete().ele000000KeywordHyphenMinusGreaterThanSign(), null); 
                
            match(input,22,FOLLOW_22_in_ruleSecondConcrete1388); 

                    createLeafNode(grammarAccess.prSecondConcrete().ele000001KeywordF(), null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleSecondConcrete1398); 

                    createLeafNode(grammarAccess.prSecondConcrete().ele00001KeywordS(), null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleSecondConcrete1408); 

                    createLeafNode(grammarAccess.prSecondConcrete().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:601:2: (lv_value= ruleNamed )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:604:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prSecondConcrete().ele0010ParserRuleCallNamed(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleSecondConcrete1443);
            lv_value=ruleNamed();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("SecondConcrete");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "Named", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:622:3: ( ( RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:625:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("SecondConcrete");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:631:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:632:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondConcrete1472); 
                     
                        createLeafNode(grammarAccess.prSecondConcrete().ele010CrossReferenceEStringChild(), "referencedChildren"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,20,FOLLOW_20_in_ruleSecondConcrete1487); 

                    createLeafNode(grammarAccess.prSecondConcrete().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:650:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:650:47: (iv_ruleNamed= ruleNamed EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:651:2: iv_ruleNamed= ruleNamed EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNamed().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNamed_in_entryRuleNamed1522);
            iv_ruleNamed=ruleNamed();
            _fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamed1532); 

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:658:1: ruleNamed returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:662:6: ( (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:663:1: (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:663:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalPartialParserTestLanguage.g:665:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamed1577); 
             
                createLeafNode(grammarAccess.prNamed().ele0LexerRuleCallID(), "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Named");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                
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


 

    public static final BitSet FOLLOW_ruleContainer_in_entryRuleContainer72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainer82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleContainer119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainer140 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleContainer161 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleNested_in_ruleContainer197 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleContent_in_ruleContainer241 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_13_in_ruleContainer257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNested_in_entryRuleNested292 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNested302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleNested338 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNested347 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ruleContainer_in_ruleNested382 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_13_in_ruleNested397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_ruleContent489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChildren560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleChildren597 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleChildren606 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren641 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleChildren656 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren690 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleChildren706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleChild788 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleChild797 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleChild807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleChild842 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleChild856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractChildren937 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAbstractChildren946 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren981 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleAbstractChildren996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild1031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFirstConcrete1197 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFirstConcrete1206 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFirstConcrete1216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete1251 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1280 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFirstConcrete1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSecondConcrete1379 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSecondConcrete1388 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSecondConcrete1398 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSecondConcrete1408 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1443 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1472 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSecondConcrete1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamed1532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1577 = new BitSet(new long[]{0x0000000000000002L});

}
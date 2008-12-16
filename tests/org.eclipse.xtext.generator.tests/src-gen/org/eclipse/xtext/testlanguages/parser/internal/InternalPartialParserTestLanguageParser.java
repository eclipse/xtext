// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g 2008-12-16 15:27:15

package org.eclipse.xtext.testlanguages.parser.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.ValueConverterException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalPartialParserTestLanguageParser extends AbstractAntlrParser {
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
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g"; }


     
        public InternalPartialParserTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalPartialParserTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Container";	
       	} 



    // $ANTLR start entryRuleContainer
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:64:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:64:51: (iv_ruleContainer= ruleContainer EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:65:2: iv_ruleContainer= ruleContainer EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleContainer_in_entryRuleContainer71);
            iv_ruleContainer=ruleContainer();
            _fsp--;

             current =iv_ruleContainer; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainer81); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:72:1: ruleContainer returns [EObject current=null] : ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nested = null;

        EObject lv_content = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:74:33: ( ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:1: ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:1: ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:2: ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:2: ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:3: ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:3: ( ( 'container' (lv_name= RULE_ID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:4: ( 'container' (lv_name= RULE_ID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:4: ( 'container' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:75:5: 'container' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleContainer118); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:79:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:81:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainer139); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Container");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name,"ID");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,12,FOLLOW_12_in_ruleContainer160); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:103:2: ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )*
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:103:3: (lv_nested= ruleNested )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:103:3: (lv_nested= ruleNested )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:106:6: lv_nested= ruleNested
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNested_in_ruleContainer196);
            	    lv_nested=ruleNested();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Container");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "nested", lv_nested,"Nested");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:125:6: (lv_content= ruleContent )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:125:6: (lv_content= ruleContent )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:128:6: lv_content= ruleContent
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContent_in_ruleContainer240);
            	    lv_content=ruleContent();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Container");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "content", lv_content,"Content");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            match(input,13,FOLLOW_13_in_ruleContainer256); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:157:1: entryRuleNested returns [EObject current=null] : iv_ruleNested= ruleNested EOF ;
    public final EObject entryRuleNested() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNested = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:157:48: (iv_ruleNested= ruleNested EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:158:2: iv_ruleNested= ruleNested EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNested_in_entryRuleNested289);
            iv_ruleNested=ruleNested();
            _fsp--;

             current =iv_ruleNested; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNested299); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:165:1: ruleNested returns [EObject current=null] : ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' ) ;
    public final EObject ruleNested() throws RecognitionException {
        EObject current = null;

        EObject lv_nested = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:167:33: ( ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:1: ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:1: ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:2: ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:2: ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:3: ( 'nested' '{' ) (lv_nested= ruleContainer )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:3: ( 'nested' '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:168:4: 'nested' '{'
            {
            match(input,14,FOLLOW_14_in_ruleNested335); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleNested344); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:176:2: (lv_nested= ruleContainer )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:179:6: lv_nested= ruleContainer
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContainer_in_ruleNested379);
            	    lv_nested=ruleContainer();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Nested");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "nested", lv_nested,"Container");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
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


            }

            match(input,13,FOLLOW_13_in_ruleNested394); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:208:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:208:49: (iv_ruleContent= ruleContent EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:209:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent427);
            iv_ruleContent=ruleContent();
            _fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent437); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:216:1: ruleContent returns [EObject current=null] : (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Children = null;

        EObject this_AbstractChildren = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:218:33: ( (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:219:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:219:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )
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
                    new NoViableAltException("219:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:220:5: this_Children= ruleChildren
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleChildren_in_ruleContent484);
                    this_Children=ruleChildren();
                    _fsp--;

                     
                            current = this_Children; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:230:5: this_AbstractChildren= ruleAbstractChildren
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractChildren_in_ruleContent511);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:245:1: entryRuleChildren returns [EObject current=null] : iv_ruleChildren= ruleChildren EOF ;
    public final EObject entryRuleChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildren = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:245:50: (iv_ruleChildren= ruleChildren EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:246:2: iv_ruleChildren= ruleChildren EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleChildren_in_entryRuleChildren543);
            iv_ruleChildren=ruleChildren();
            _fsp--;

             current =iv_ruleChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChildren553); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:253:1: ruleChildren returns [EObject current=null] : ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' ) ;
    public final EObject ruleChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:255:33: ( ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:1: ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:1: ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:2: ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:2: ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:3: ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:3: ( ( 'children' '{' ) (lv_children= ruleChild ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:4: ( 'children' '{' ) (lv_children= ruleChild )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:4: ( 'children' '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:256:5: 'children' '{'
            {
            match(input,15,FOLLOW_15_in_ruleChildren590); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleChildren599); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:264:2: (lv_children= ruleChild )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:267:6: lv_children= ruleChild
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleChild_in_ruleChildren634);
            lv_children=ruleChild();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Children");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "children", lv_children,"Child");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:285:3: ( ',' (lv_children= ruleChild ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:285:4: ',' (lv_children= ruleChild )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleChildren649); 

            	            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:289:1: (lv_children= ruleChild )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:292:6: lv_children= ruleChild
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChild_in_ruleChildren683);
            	    lv_children=ruleChild();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Children");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "children", lv_children,"Child");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            match(input,13,FOLLOW_13_in_ruleChildren699); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:321:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:321:47: (iv_ruleChild= ruleChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:322:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild732);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild742); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:329:1: ruleChild returns [EObject current=null] : ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:331:33: ( ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:1: ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:1: ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:2: ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:2: ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:3: ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:3: ( ( '->' 'C' ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:4: ( '->' 'C' ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:4: ( '->' 'C' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:332:5: '->' 'C'
            {
            match(input,17,FOLLOW_17_in_ruleChild779); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,18,FOLLOW_18_in_ruleChild788); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleChild798); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:344:2: (lv_value= ruleNamed )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleChild833);
            lv_value=ruleNamed();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Child");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value,"Named");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,20,FOLLOW_20_in_ruleChild847); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:376:1: entryRuleAbstractChildren returns [EObject current=null] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final EObject entryRuleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChildren = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:376:58: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:377:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren880);
            iv_ruleAbstractChildren=ruleAbstractChildren();
            _fsp--;

             current =iv_ruleAbstractChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChildren890); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:384:1: ruleAbstractChildren returns [EObject current=null] : ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' ) ;
    public final EObject ruleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_abstractChildren = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:386:33: ( ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:1: ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:1: ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:2: ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:2: ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:3: ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:3: ( 'abstract children' '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:387:4: 'abstract children' '{'
            {
            match(input,21,FOLLOW_21_in_ruleAbstractChildren926); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleAbstractChildren935); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:395:2: (lv_abstractChildren= ruleAbstractChild )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:398:6: lv_abstractChildren= ruleAbstractChild
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractChild_in_ruleAbstractChildren970);
            	    lv_abstractChildren=ruleAbstractChild();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("AbstractChildren");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "abstractChildren", lv_abstractChildren,"AbstractChild");
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
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


            }

            match(input,13,FOLLOW_13_in_ruleAbstractChildren985); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:1: entryRuleAbstractChild returns [EObject current=null] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final EObject entryRuleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:55: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:428:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild1018);
            iv_ruleAbstractChild=ruleAbstractChild();
            _fsp--;

             current =iv_ruleAbstractChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChild1028); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:435:1: ruleAbstractChild returns [EObject current=null] : (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete ) ;
    public final EObject ruleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject this_FirstConcrete = null;

        EObject this_SecondConcrete = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:437:33: ( (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:438:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:438:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )
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
                            new NoViableAltException("438:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("438:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("438:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:439:5: this_FirstConcrete= ruleFirstConcrete
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1075);
                    this_FirstConcrete=ruleFirstConcrete();
                    _fsp--;

                     
                            current = this_FirstConcrete; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:449:5: this_SecondConcrete= ruleSecondConcrete
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1102);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:464:1: entryRuleFirstConcrete returns [EObject current=null] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final EObject entryRuleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstConcrete = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:464:55: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:465:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1134);
            iv_ruleFirstConcrete=ruleFirstConcrete();
            _fsp--;

             current =iv_ruleFirstConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstConcrete1144); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:472:1: ruleFirstConcrete returns [EObject current=null] : ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) ;
    public final EObject ruleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:474:33: ( ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:1: ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:1: ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:2: ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:2: ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:3: ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:3: ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:4: ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:4: ( ( '->' 'F' ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:5: ( '->' 'F' ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:5: ( '->' 'F' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:475:6: '->' 'F'
            {
            match(input,17,FOLLOW_17_in_ruleFirstConcrete1182); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,22,FOLLOW_22_in_ruleFirstConcrete1191); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleFirstConcrete1201); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:487:2: (lv_value= ruleNamed )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:490:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleFirstConcrete1236);
            lv_value=ruleNamed();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("FirstConcrete");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value,"Named");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:508:3: ( ( RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:511:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("FirstConcrete");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:517:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:518:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstConcrete1265); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "referencedContainer"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,20,FOLLOW_20_in_ruleFirstConcrete1280); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:534:1: entryRuleSecondConcrete returns [EObject current=null] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final EObject entryRuleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondConcrete = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:534:56: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:535:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1313);
            iv_ruleSecondConcrete=ruleSecondConcrete();
            _fsp--;

             current =iv_ruleSecondConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondConcrete1323); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:542:1: ruleSecondConcrete returns [EObject current=null] : ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) ;
    public final EObject ruleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:544:33: ( ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:1: ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:1: ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:2: ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:2: ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:3: ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:3: ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:4: ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:4: ( ( ( '->' 'F' ) 'S' ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:5: ( ( '->' 'F' ) 'S' ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:5: ( ( '->' 'F' ) 'S' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:6: ( '->' 'F' ) 'S'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:6: ( '->' 'F' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:545:7: '->' 'F'
            {
            match(input,17,FOLLOW_17_in_ruleSecondConcrete1362); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,22,FOLLOW_22_in_ruleSecondConcrete1371); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleSecondConcrete1381); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleSecondConcrete1391); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:561:2: (lv_value= ruleNamed )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:564:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleSecondConcrete1426);
            lv_value=ruleNamed();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("SecondConcrete");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value,"Named");
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:582:3: ( ( RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:585:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("SecondConcrete");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:591:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:592:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondConcrete1455); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "referencedChildren"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,20,FOLLOW_20_in_ruleSecondConcrete1470); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:608:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:608:47: (iv_ruleNamed= ruleNamed EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:609:2: iv_ruleNamed= ruleNamed EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNamed_in_entryRuleNamed1503);
            iv_ruleNamed=ruleNamed();
            _fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamed1513); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:616:1: ruleNamed returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:618:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:619:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:619:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:621:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamed1558); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Named");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name,"ID");
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


 

    public static final BitSet FOLLOW_ruleContainer_in_entryRuleContainer71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainer81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleContainer118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainer139 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleContainer160 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleNested_in_ruleContainer196 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleContent_in_ruleContainer240 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_13_in_ruleContainer256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNested_in_entryRuleNested289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNested299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleNested335 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNested344 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ruleContainer_in_ruleNested379 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_13_in_ruleNested394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_ruleContent484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChildren553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleChildren590 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleChildren599 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren634 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleChildren649 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren683 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleChildren699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleChild779 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleChild788 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleChild798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleChild833 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleChild847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren880 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractChildren926 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAbstractChildren935 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren970 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleAbstractChildren985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild1018 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1134 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFirstConcrete1182 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFirstConcrete1191 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFirstConcrete1201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete1236 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1265 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFirstConcrete1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSecondConcrete1362 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSecondConcrete1371 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSecondConcrete1381 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSecondConcrete1391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1426 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1455 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSecondConcrete1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamed1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1558 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g 2008-12-02 18:42:27

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:62:1: entryRuleContainer returns [EObject current=null] : iv_ruleContainer= ruleContainer EOF ;
    public final EObject entryRuleContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainer = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:62:51: (iv_ruleContainer= ruleContainer EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:63:2: iv_ruleContainer= ruleContainer EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleContainer_in_entryRuleContainer70);
            iv_ruleContainer=ruleContainer();
            _fsp--;

             current =iv_ruleContainer; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainer80); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:70:1: ruleContainer returns [EObject current=null] : ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' ) ;
    public final EObject ruleContainer() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_nested = null;

        EObject lv_content = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:72:33: ( ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:1: ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:1: ( ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:2: ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:2: ( ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:3: ( ( 'container' (lv_name= RULE_ID ) ) '{' ) ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:3: ( ( 'container' (lv_name= RULE_ID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:4: ( 'container' (lv_name= RULE_ID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:4: ( 'container' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:73:5: 'container' (lv_name= RULE_ID )
            {
            match(input,11,FOLLOW_11_in_ruleContainer117); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:77:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:79:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContainer138); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Container");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            match(input,12,FOLLOW_12_in_ruleContainer159); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:97:2: ( (lv_nested= ruleNested ) | (lv_content= ruleContent ) )*
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:97:3: (lv_nested= ruleNested )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:97:3: (lv_nested= ruleNested )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:100:6: lv_nested= ruleNested
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleNested_in_ruleContainer195);
            	    lv_nested=ruleNested();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Container");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "nested", lv_nested,null);
            	    	         

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:115:6: (lv_content= ruleContent )
            	    {
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:115:6: (lv_content= ruleContent )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:118:6: lv_content= ruleContent
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContent_in_ruleContainer239);
            	    lv_content=ruleContent();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Container");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "content", lv_content,null);
            	    	         

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            match(input,13,FOLLOW_13_in_ruleContainer255); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:141:1: entryRuleNested returns [EObject current=null] : iv_ruleNested= ruleNested EOF ;
    public final EObject entryRuleNested() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNested = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:141:48: (iv_ruleNested= ruleNested EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:142:2: iv_ruleNested= ruleNested EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNested_in_entryRuleNested290);
            iv_ruleNested=ruleNested();
            _fsp--;

             current =iv_ruleNested; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNested300); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:149:1: ruleNested returns [EObject current=null] : ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' ) ;
    public final EObject ruleNested() throws RecognitionException {
        EObject current = null;

        EObject lv_nested = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:151:33: ( ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:1: ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:1: ( ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:2: ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:2: ( ( 'nested' '{' ) (lv_nested= ruleContainer )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:3: ( 'nested' '{' ) (lv_nested= ruleContainer )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:3: ( 'nested' '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:152:4: 'nested' '{'
            {
            match(input,14,FOLLOW_14_in_ruleNested336); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleNested345); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:160:2: (lv_nested= ruleContainer )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:163:6: lv_nested= ruleContainer
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleContainer_in_ruleNested380);
            	    lv_nested=ruleContainer();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Nested");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "nested", lv_nested,null);
            	    	         

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

            match(input,13,FOLLOW_13_in_ruleNested395); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:186:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:186:49: (iv_ruleContent= ruleContent EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:187:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleContent_in_entryRuleContent430);
            iv_ruleContent=ruleContent();
            _fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContent440); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:194:1: ruleContent returns [EObject current=null] : (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_Children = null;

        EObject this_AbstractChildren = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:196:33: ( (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:197:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:197:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )
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
                    new NoViableAltException("197:1: (this_Children= ruleChildren | this_AbstractChildren= ruleAbstractChildren )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:198:5: this_Children= ruleChildren
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleChildren_in_ruleContent487);
                    this_Children=ruleChildren();
                    _fsp--;

                     
                            current = this_Children; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:208:5: this_AbstractChildren= ruleAbstractChildren
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractChildren_in_ruleContent514);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:221:1: entryRuleChildren returns [EObject current=null] : iv_ruleChildren= ruleChildren EOF ;
    public final EObject entryRuleChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChildren = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:221:50: (iv_ruleChildren= ruleChildren EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:222:2: iv_ruleChildren= ruleChildren EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleChildren_in_entryRuleChildren548);
            iv_ruleChildren=ruleChildren();
            _fsp--;

             current =iv_ruleChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChildren558); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:229:1: ruleChildren returns [EObject current=null] : ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' ) ;
    public final EObject ruleChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_children = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:231:33: ( ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:1: ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:1: ( ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:2: ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:2: ( ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )* )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:3: ( ( 'children' '{' ) (lv_children= ruleChild ) ) ( ',' (lv_children= ruleChild ) )*
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:3: ( ( 'children' '{' ) (lv_children= ruleChild ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:4: ( 'children' '{' ) (lv_children= ruleChild )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:4: ( 'children' '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:232:5: 'children' '{'
            {
            match(input,15,FOLLOW_15_in_ruleChildren595); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleChildren604); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:240:2: (lv_children= ruleChild )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:243:6: lv_children= ruleChild
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleChild_in_ruleChildren639);
            lv_children=ruleChild();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Children");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.add(current, "children", lv_children,null);
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:257:3: ( ',' (lv_children= ruleChild ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:257:4: ',' (lv_children= ruleChild )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleChildren654); 

            	            createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:261:1: (lv_children= ruleChild )
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:264:6: lv_children= ruleChild
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleChild_in_ruleChildren688);
            	    lv_children=ruleChild();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Children");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "children", lv_children,null);
            	    	         

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            match(input,13,FOLLOW_13_in_ruleChildren704); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:287:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:287:47: (iv_ruleChild= ruleChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:288:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild739);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild749); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:295:1: ruleChild returns [EObject current=null] : ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:297:33: ( ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:1: ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:1: ( ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:2: ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:2: ( ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:3: ( ( '->' 'C' ) '(' ) (lv_value= ruleNamed )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:3: ( ( '->' 'C' ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:4: ( '->' 'C' ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:4: ( '->' 'C' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:298:5: '->' 'C'
            {
            match(input,17,FOLLOW_17_in_ruleChild786); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,18,FOLLOW_18_in_ruleChild795); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleChild805); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:310:2: (lv_value= ruleNamed )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:313:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleChild840);
            lv_value=ruleNamed();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Child");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "value", lv_value,null);
            	         

            }


            }

            match(input,20,FOLLOW_20_in_ruleChild854); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:336:1: entryRuleAbstractChildren returns [EObject current=null] : iv_ruleAbstractChildren= ruleAbstractChildren EOF ;
    public final EObject entryRuleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChildren = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:336:58: (iv_ruleAbstractChildren= ruleAbstractChildren EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:337:2: iv_ruleAbstractChildren= ruleAbstractChildren EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren889);
            iv_ruleAbstractChildren=ruleAbstractChildren();
            _fsp--;

             current =iv_ruleAbstractChildren; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChildren899); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:344:1: ruleAbstractChildren returns [EObject current=null] : ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' ) ;
    public final EObject ruleAbstractChildren() throws RecognitionException {
        EObject current = null;

        EObject lv_abstractChildren = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:346:33: ( ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:1: ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:1: ( ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:2: ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ ) '}'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:2: ( ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+ )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:3: ( 'abstract children' '{' ) (lv_abstractChildren= ruleAbstractChild )+
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:3: ( 'abstract children' '{' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:347:4: 'abstract children' '{'
            {
            match(input,21,FOLLOW_21_in_ruleAbstractChildren935); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,12,FOLLOW_12_in_ruleAbstractChildren944); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:355:2: (lv_abstractChildren= ruleAbstractChild )+
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
            	    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:358:6: lv_abstractChildren= ruleAbstractChild
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractChild_in_ruleAbstractChildren979);
            	    lv_abstractChildren=ruleAbstractChild();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("AbstractChildren");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "abstractChildren", lv_abstractChildren,null);
            	    	         

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

            match(input,13,FOLLOW_13_in_ruleAbstractChildren994); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:381:1: entryRuleAbstractChild returns [EObject current=null] : iv_ruleAbstractChild= ruleAbstractChild EOF ;
    public final EObject entryRuleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractChild = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:381:55: (iv_ruleAbstractChild= ruleAbstractChild EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:382:2: iv_ruleAbstractChild= ruleAbstractChild EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild1029);
            iv_ruleAbstractChild=ruleAbstractChild();
            _fsp--;

             current =iv_ruleAbstractChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractChild1039); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:389:1: ruleAbstractChild returns [EObject current=null] : (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete ) ;
    public final EObject ruleAbstractChild() throws RecognitionException {
        EObject current = null;

        EObject this_FirstConcrete = null;

        EObject this_SecondConcrete = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:391:33: ( (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:392:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:392:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )
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
                            new NoViableAltException("392:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("392:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("392:1: (this_FirstConcrete= ruleFirstConcrete | this_SecondConcrete= ruleSecondConcrete )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:393:5: this_FirstConcrete= ruleFirstConcrete
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1086);
                    this_FirstConcrete=ruleFirstConcrete();
                    _fsp--;

                     
                            current = this_FirstConcrete; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:403:5: this_SecondConcrete= ruleSecondConcrete
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1113);
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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:416:1: entryRuleFirstConcrete returns [EObject current=null] : iv_ruleFirstConcrete= ruleFirstConcrete EOF ;
    public final EObject entryRuleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstConcrete = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:416:55: (iv_ruleFirstConcrete= ruleFirstConcrete EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:417:2: iv_ruleFirstConcrete= ruleFirstConcrete EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1147);
            iv_ruleFirstConcrete=ruleFirstConcrete();
            _fsp--;

             current =iv_ruleFirstConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstConcrete1157); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:424:1: ruleFirstConcrete returns [EObject current=null] : ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) ;
    public final EObject ruleFirstConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:426:33: ( ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:1: ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:1: ( ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:2: ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:2: ( ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:3: ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:3: ( ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:4: ( ( '->' 'F' ) '(' ) (lv_value= ruleNamed )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:4: ( ( '->' 'F' ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:5: ( '->' 'F' ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:5: ( '->' 'F' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:427:6: '->' 'F'
            {
            match(input,17,FOLLOW_17_in_ruleFirstConcrete1195); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,22,FOLLOW_22_in_ruleFirstConcrete1204); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleFirstConcrete1214); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:439:2: (lv_value= ruleNamed )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:442:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleFirstConcrete1249);
            lv_value=ruleNamed();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("FirstConcrete");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "value", lv_value,null);
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:456:3: ( ( RULE_ID ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:459:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("FirstConcrete");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:465:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:466:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFirstConcrete1278); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "referencedContainer"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,20,FOLLOW_20_in_ruleFirstConcrete1293); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:480:1: entryRuleSecondConcrete returns [EObject current=null] : iv_ruleSecondConcrete= ruleSecondConcrete EOF ;
    public final EObject entryRuleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecondConcrete = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:480:56: (iv_ruleSecondConcrete= ruleSecondConcrete EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:481:2: iv_ruleSecondConcrete= ruleSecondConcrete EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1328);
            iv_ruleSecondConcrete=ruleSecondConcrete();
            _fsp--;

             current =iv_ruleSecondConcrete; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSecondConcrete1338); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:488:1: ruleSecondConcrete returns [EObject current=null] : ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) ;
    public final EObject ruleSecondConcrete() throws RecognitionException {
        EObject current = null;

        EObject lv_value = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:490:33: ( ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:1: ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:1: ( ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:2: ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? ) ')'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:2: ( ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:3: ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) ) ( ( RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:3: ( ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:4: ( ( ( '->' 'F' ) 'S' ) '(' ) (lv_value= ruleNamed )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:4: ( ( ( '->' 'F' ) 'S' ) '(' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:5: ( ( '->' 'F' ) 'S' ) '('
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:5: ( ( '->' 'F' ) 'S' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:6: ( '->' 'F' ) 'S'
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:6: ( '->' 'F' )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:491:7: '->' 'F'
            {
            match(input,17,FOLLOW_17_in_ruleSecondConcrete1377); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,22,FOLLOW_22_in_ruleSecondConcrete1386); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,23,FOLLOW_23_in_ruleSecondConcrete1396); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,19,FOLLOW_19_in_ruleSecondConcrete1406); 

                    createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:507:2: (lv_value= ruleNamed )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:510:6: lv_value= ruleNamed
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleNamed_in_ruleSecondConcrete1441);
            lv_value=ruleNamed();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("SecondConcrete");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "value", lv_value,null);
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:524:3: ( ( RULE_ID ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:527:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("SecondConcrete");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:533:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:534:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSecondConcrete1470); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "referencedChildren"); 
                        

                    }


                    }
                    break;

            }


            }

            match(input,20,FOLLOW_20_in_ruleSecondConcrete1485); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:548:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:548:47: (iv_ruleNamed= ruleNamed EOF )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:549:2: iv_ruleNamed= ruleNamed EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNamed_in_entryRuleNamed1520);
            iv_ruleNamed=ruleNamed();
            _fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamed1530); 

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
    // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:556:1: ruleNamed returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:558:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:559:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:559:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/testlanguages/parser/internal/InternalPartialParserTestLanguage.g:561:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNamed1575); 
             
                createLeafNode("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Named");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

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


 

    public static final BitSet FOLLOW_ruleContainer_in_entryRuleContainer70 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainer80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleContainer117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContainer138 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleContainer159 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleNested_in_ruleContainer195 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_ruleContent_in_ruleContainer239 = new BitSet(new long[]{0x000000000020E000L});
    public static final BitSet FOLLOW_13_in_ruleContainer255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNested_in_entryRuleNested290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNested300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleNested336 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleNested345 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ruleContainer_in_ruleNested380 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_13_in_ruleNested395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContent_in_entryRuleContent430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContent440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_ruleContent487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_ruleContent514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChildren_in_entryRuleChildren548 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChildren558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleChildren595 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleChildren604 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren639 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_16_in_ruleChildren654 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleChild_in_ruleChildren688 = new BitSet(new long[]{0x0000000000012000L});
    public static final BitSet FOLLOW_13_in_ruleChildren704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleChild786 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleChild795 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleChild805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleChild840 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleChild854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChildren_in_entryRuleAbstractChildren889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChildren899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleAbstractChildren935 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAbstractChildren944 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_ruleAbstractChildren979 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleAbstractChildren994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractChild_in_entryRuleAbstractChild1029 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractChild1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_ruleAbstractChild1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_ruleAbstractChild1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstConcrete_in_entryRuleFirstConcrete1147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstConcrete1157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFirstConcrete1195 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFirstConcrete1204 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFirstConcrete1214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleFirstConcrete1249 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFirstConcrete1278 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFirstConcrete1293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSecondConcrete_in_entryRuleSecondConcrete1328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSecondConcrete1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSecondConcrete1377 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleSecondConcrete1386 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleSecondConcrete1396 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSecondConcrete1406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNamed_in_ruleSecondConcrete1441 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSecondConcrete1470 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleSecondConcrete1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed1520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamed1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNamed1575 = new BitSet(new long[]{0x0000000000000002L});

}
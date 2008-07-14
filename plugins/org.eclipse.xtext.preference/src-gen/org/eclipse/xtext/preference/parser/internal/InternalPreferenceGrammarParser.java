// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g 2008-07-14 10:06:30

package org.eclipse.xtext.preference.parser.internal; 

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

public class InternalPreferenceGrammarParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'commonprefix'", "'page'", "'{'", "'}'", "';'", "'#'", "'?'", "'['", "','", "']'", "'.'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalPreferenceGrammarParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g"; }


     
        public InternalPreferenceGrammarParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalPreferenceGrammarParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Description";	
       	} 



    // $ANTLR start entryRuleDescription
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:63:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:63:53: (iv_ruleDescription= ruleDescription EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:64:2: iv_ruleDescription= ruleDescription EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription71);
            iv_ruleDescription=ruleDescription();
            _fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription81); 

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
    // $ANTLR end entryRuleDescription


    // $ANTLR start ruleDescription
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:71:1: ruleDescription returns [EObject current=null] : ( ( 'commonprefix' (lv_idPrefix= ruleQName ) ) (lv_pages= rulePage ) ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_idPrefix = null;

        EObject lv_pages = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:73:33: ( ( ( 'commonprefix' (lv_idPrefix= ruleQName ) ) (lv_pages= rulePage ) ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:74:1: ( ( 'commonprefix' (lv_idPrefix= ruleQName ) ) (lv_pages= rulePage ) )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:74:1: ( ( 'commonprefix' (lv_idPrefix= ruleQName ) ) (lv_pages= rulePage ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:74:2: ( 'commonprefix' (lv_idPrefix= ruleQName ) ) (lv_pages= rulePage )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:74:2: ( 'commonprefix' (lv_idPrefix= ruleQName ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:74:3: 'commonprefix' (lv_idPrefix= ruleQName )
            {
            match(input,11,FOLLOW_11_in_ruleDescription116); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:78:1: (lv_idPrefix= ruleQName )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:80:5: lv_idPrefix= ruleQName
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleQName_in_ruleDescription144);
            lv_idPrefix=ruleQName();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Description");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "idPrefix", lv_idPrefix,null);
                    
                     

            }


            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:94:3: (lv_pages= rulePage )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:96:5: lv_pages= rulePage
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_rulePage_in_ruleDescription174);
            lv_pages=rulePage();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Description");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.add(current, "pages", lv_pages,null);
                    
                     

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
    // $ANTLR end ruleDescription


    // $ANTLR start entryRulePage
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:115:1: entryRulePage returns [EObject current=null] : iv_rulePage= rulePage EOF ;
    public final EObject entryRulePage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePage = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:115:46: (iv_rulePage= rulePage EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:116:2: iv_rulePage= rulePage EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_rulePage_in_entryRulePage210);
            iv_rulePage=rulePage();
            _fsp--;

             current =iv_rulePage; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePage220); 

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
    // $ANTLR end entryRulePage


    // $ANTLR start rulePage
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:123:1: rulePage returns [EObject current=null] : ( ( 'page' (lv_name= ruleQName ) ) (lv_panel= rulePanel ) ) ;
    public final EObject rulePage() throws RecognitionException {
        EObject current = null;

        EObject lv_name = null;

        EObject lv_panel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:125:33: ( ( ( 'page' (lv_name= ruleQName ) ) (lv_panel= rulePanel ) ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:126:1: ( ( 'page' (lv_name= ruleQName ) ) (lv_panel= rulePanel ) )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:126:1: ( ( 'page' (lv_name= ruleQName ) ) (lv_panel= rulePanel ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:126:2: ( 'page' (lv_name= ruleQName ) ) (lv_panel= rulePanel )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:126:2: ( 'page' (lv_name= ruleQName ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:126:3: 'page' (lv_name= ruleQName )
            {
            match(input,12,FOLLOW_12_in_rulePage255); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:130:1: (lv_name= ruleQName )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:132:5: lv_name= ruleQName
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleQName_in_rulePage283);
            lv_name=ruleQName();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Page");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,null);
                    
                     

            }


            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:146:3: (lv_panel= rulePanel )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:148:5: lv_panel= rulePanel
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.1/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_rulePanel_in_rulePage313);
            lv_panel=rulePanel();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Page");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "panel", lv_panel,null);
                    
                     

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
    // $ANTLR end rulePage


    // $ANTLR start entryRulePanel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:167:1: entryRulePanel returns [EObject current=null] : iv_rulePanel= rulePanel EOF ;
    public final EObject entryRulePanel() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePanel = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:167:47: (iv_rulePanel= rulePanel EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:168:2: iv_rulePanel= rulePanel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_rulePanel_in_entryRulePanel349);
            iv_rulePanel=rulePanel();
            _fsp--;

             current =iv_rulePanel; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePanel359); 

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
    // $ANTLR end entryRulePanel


    // $ANTLR start rulePanel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:175:1: rulePanel returns [EObject current=null] : ( ( '{' (lv_rows= ruleRow )* ) '}' ) ;
    public final EObject rulePanel() throws RecognitionException {
        EObject current = null;

        EObject lv_rows = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:177:33: ( ( ( '{' (lv_rows= ruleRow )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:178:1: ( ( '{' (lv_rows= ruleRow )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:178:1: ( ( '{' (lv_rows= ruleRow )* ) '}' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:178:2: ( '{' (lv_rows= ruleRow )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:178:2: ( '{' (lv_rows= ruleRow )* )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:178:3: '{' (lv_rows= ruleRow )*
            {
            match(input,13,FOLLOW_13_in_rulePanel394); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:182:1: (lv_rows= ruleRow )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=15 && LA1_0<=16)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:184:5: lv_rows= ruleRow
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleRow_in_rulePanel422);
            	    lv_rows=ruleRow();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Panel");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "rows", lv_rows,null);
            	            
            	             

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_rulePanel434); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end rulePanel


    // $ANTLR start entryRuleRow
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:207:1: entryRuleRow returns [EObject current=null] : iv_ruleRow= ruleRow EOF ;
    public final EObject entryRuleRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRow = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:207:45: (iv_ruleRow= ruleRow EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:208:2: iv_ruleRow= ruleRow EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRow_in_entryRuleRow469);
            iv_ruleRow=ruleRow();
            _fsp--;

             current =iv_ruleRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRow479); 

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
    // $ANTLR end entryRuleRow


    // $ANTLR start ruleRow
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:215:1: ruleRow returns [EObject current=null] : ( (lv_entries= ruleEntry )* ';' ) ;
    public final EObject ruleRow() throws RecognitionException {
        EObject current = null;

        EObject lv_entries = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:217:33: ( ( (lv_entries= ruleEntry )* ';' ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:218:1: ( (lv_entries= ruleEntry )* ';' )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:218:1: ( (lv_entries= ruleEntry )* ';' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:218:2: (lv_entries= ruleEntry )* ';'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:218:2: (lv_entries= ruleEntry )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:220:5: lv_entries= ruleEntry
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleEntry_in_ruleRow532);
            	    lv_entries=ruleEntry();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Row");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "entries", lv_entries,null);
            	            
            	             

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match(input,15,FOLLOW_15_in_ruleRow543); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleRow


    // $ANTLR start entryRuleEntry
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:243:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:243:47: (iv_ruleEntry= ruleEntry EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:244:2: iv_ruleEntry= ruleEntry EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleEntry_in_entryRuleEntry578);
            iv_ruleEntry=ruleEntry();
            _fsp--;

             current =iv_ruleEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntry588); 

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
    // $ANTLR end entryRuleEntry


    // $ANTLR start ruleEntry
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:251:1: ruleEntry returns [EObject current=null] : ( (lv_colspan= '#' )+ (lv_widget= ruleWidget ) ) ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        Token lv_colspan=null;
        EObject lv_widget = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:253:33: ( ( (lv_colspan= '#' )+ (lv_widget= ruleWidget ) ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:254:1: ( (lv_colspan= '#' )+ (lv_widget= ruleWidget ) )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:254:1: ( (lv_colspan= '#' )+ (lv_widget= ruleWidget ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:254:2: (lv_colspan= '#' )+ (lv_widget= ruleWidget )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:254:2: (lv_colspan= '#' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:255:5: lv_colspan= '#'
            	    {
            	    lv_colspan=(Token)input.LT(1);
            	    match(input,16,FOLLOW_16_in_ruleEntry630); 

            	            createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@terminal" /* xtext::Keyword */, "colspan"); 
            	        

            	            if (current==null) {
            	                current = factory.create("Entry");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "colspan", input.LT(-1),"#");
            	            
            	             

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:269:3: (lv_widget= ruleWidget )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:271:5: lv_widget= ruleWidget
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleWidget_in_ruleEntry668);
            lv_widget=ruleWidget();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Entry");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "widget", lv_widget,null);
                    
                     

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
    // $ANTLR end ruleEntry


    // $ANTLR start entryRuleWidget
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:290:1: entryRuleWidget returns [EObject current=null] : iv_ruleWidget= ruleWidget EOF ;
    public final EObject entryRuleWidget() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWidget = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:290:48: (iv_ruleWidget= ruleWidget EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:291:2: iv_ruleWidget= ruleWidget EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleWidget_in_entryRuleWidget704);
            iv_ruleWidget=ruleWidget();
            _fsp--;

             current =iv_ruleWidget; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWidget714); 

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
    // $ANTLR end entryRuleWidget


    // $ANTLR start ruleWidget
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:298:1: ruleWidget returns [EObject current=null] : ( ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel ) | this_CheckedPanel= ruleCheckedPanel ) ;
    public final EObject ruleWidget() throws RecognitionException {
        EObject current = null;

        EObject this_Label = null;

        EObject this_Text = null;

        EObject this_Check = null;

        EObject this_Combo = null;

        EObject this_Panel = null;

        EObject this_NamedPanel = null;

        EObject this_CheckedPanel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:300:33: ( ( ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel ) | this_CheckedPanel= ruleCheckedPanel ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:1: ( ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel ) | this_CheckedPanel= ruleCheckedPanel )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:1: ( ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel ) | this_CheckedPanel= ruleCheckedPanel )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING||LA9_0==13||(LA9_0>=17 && LA9_0<=18)) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==13) ) {
                    alt9=2;
                }
                else if ( (LA9_2==EOF||(LA9_2>=15 && LA9_2<=16)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("301:1: ( ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel ) | this_CheckedPanel= ruleCheckedPanel )", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("301:1: ( ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel ) | this_CheckedPanel= ruleCheckedPanel )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:2: ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel )
                    {
                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:2: ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==RULE_STRING) ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1==13) ) {
                            alt8=2;
                        }
                        else if ( (LA8_1==EOF||(LA8_1>=15 && LA8_1<=16)) ) {
                            alt8=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("301:2: ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel )", 8, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA8_0==RULE_ID||LA8_0==13||(LA8_0>=17 && LA8_0<=18)) ) {
                        alt8=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("301:2: ( ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel ) | this_NamedPanel= ruleNamedPanel )", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:3: ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel )
                            {
                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:3: ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel )
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||(LA7_0>=17 && LA7_0<=18)) ) {
                                alt7=1;
                            }
                            else if ( (LA7_0==13) ) {
                                alt7=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("301:3: ( ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo ) | this_Panel= rulePanel )", 7, 0, input);

                                throw nvae;
                            }
                            switch (alt7) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:4: ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo )
                                    {
                                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:4: ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo )
                                    int alt6=2;
                                    int LA6_0 = input.LA(1);

                                    if ( ((LA6_0>=RULE_STRING && LA6_0<=RULE_ID)||LA6_0==17) ) {
                                        alt6=1;
                                    }
                                    else if ( (LA6_0==18) ) {
                                        alt6=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("301:4: ( ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck ) | this_Combo= ruleCombo )", 6, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt6) {
                                        case 1 :
                                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:5: ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck )
                                            {
                                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:5: ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck )
                                            int alt5=2;
                                            int LA5_0 = input.LA(1);

                                            if ( ((LA5_0>=RULE_STRING && LA5_0<=RULE_ID)) ) {
                                                alt5=1;
                                            }
                                            else if ( (LA5_0==17) ) {
                                                alt5=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("301:5: ( (this_Label= ruleLabel | this_Text= ruleText ) | this_Check= ruleCheck )", 5, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt5) {
                                                case 1 :
                                                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:6: (this_Label= ruleLabel | this_Text= ruleText )
                                                    {
                                                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:301:6: (this_Label= ruleLabel | this_Text= ruleText )
                                                    int alt4=2;
                                                    int LA4_0 = input.LA(1);

                                                    if ( (LA4_0==RULE_STRING) ) {
                                                        alt4=1;
                                                    }
                                                    else if ( (LA4_0==RULE_ID) ) {
                                                        alt4=2;
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("301:6: (this_Label= ruleLabel | this_Text= ruleText )", 4, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt4) {
                                                        case 1 :
                                                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:302:5: this_Label= ruleLabel
                                                            {
                                                             
                                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                                                
                                                            pushFollow(FOLLOW_ruleLabel_in_ruleWidget766);
                                                            this_Label=ruleLabel();
                                                            _fsp--;

                                                             
                                                                    current = this_Label; 
                                                                    currentNode = currentNode.getParent();
                                                                

                                                            }
                                                            break;
                                                        case 2 :
                                                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:312:5: this_Text= ruleText
                                                            {
                                                             
                                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                                
                                                            pushFollow(FOLLOW_ruleText_in_ruleWidget793);
                                                            this_Text=ruleText();
                                                            _fsp--;

                                                             
                                                                    current = this_Text; 
                                                                    currentNode = currentNode.getParent();
                                                                

                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:322:5: this_Check= ruleCheck
                                                    {
                                                     
                                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                        
                                                    pushFollow(FOLLOW_ruleCheck_in_ruleWidget821);
                                                    this_Check=ruleCheck();
                                                    _fsp--;

                                                     
                                                            current = this_Check; 
                                                            currentNode = currentNode.getParent();
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:332:5: this_Combo= ruleCombo
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCombo_in_ruleWidget849);
                                            this_Combo=ruleCombo();
                                            _fsp--;

                                             
                                                    current = this_Combo; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:342:5: this_Panel= rulePanel
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_rulePanel_in_ruleWidget877);
                                    this_Panel=rulePanel();
                                    _fsp--;

                                     
                                            current = this_Panel; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:352:5: this_NamedPanel= ruleNamedPanel
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleNamedPanel_in_ruleWidget905);
                            this_NamedPanel=ruleNamedPanel();
                            _fsp--;

                             
                                    current = this_NamedPanel; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:362:5: this_CheckedPanel= ruleCheckedPanel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.5/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleCheckedPanel_in_ruleWidget933);
                    this_CheckedPanel=ruleCheckedPanel();
                    _fsp--;

                     
                            current = this_CheckedPanel; 
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
    // $ANTLR end ruleWidget


    // $ANTLR start entryRuleNamedPanel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:375:1: entryRuleNamedPanel returns [EObject current=null] : iv_ruleNamedPanel= ruleNamedPanel EOF ;
    public final EObject entryRuleNamedPanel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedPanel = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:375:52: (iv_ruleNamedPanel= ruleNamedPanel EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:376:2: iv_ruleNamedPanel= ruleNamedPanel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNamedPanel_in_entryRuleNamedPanel967);
            iv_ruleNamedPanel=ruleNamedPanel();
            _fsp--;

             current =iv_ruleNamedPanel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedPanel977); 

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
    // $ANTLR end entryRuleNamedPanel


    // $ANTLR start ruleNamedPanel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:383:1: ruleNamedPanel returns [EObject current=null] : ( ( ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )* ) '}' ) ;
    public final EObject ruleNamedPanel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_rows = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:385:33: ( ( ( ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:1: ( ( ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:1: ( ( ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )* ) '}' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:2: ( ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:2: ( ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )* )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:3: ( (lv_name= RULE_STRING ) '{' ) (lv_rows= ruleRow )*
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:3: ( (lv_name= RULE_STRING ) '{' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:4: (lv_name= RULE_STRING ) '{'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:386:4: (lv_name= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:387:5: lv_name= RULE_STRING
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNamedPanel1021); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("NamedPanel");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,"STRING");
                    
                     

            }

            match(input,13,FOLLOW_13_in_ruleNamedPanel1038); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:405:2: (lv_rows= ruleRow )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=15 && LA10_0<=16)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:407:5: lv_rows= ruleRow
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleRow_in_ruleNamedPanel1067);
            	    lv_rows=ruleRow();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("NamedPanel");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "rows", lv_rows,null);
            	            
            	             

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleNamedPanel1079); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleNamedPanel


    // $ANTLR start entryRuleCheckedPanel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:430:1: entryRuleCheckedPanel returns [EObject current=null] : iv_ruleCheckedPanel= ruleCheckedPanel EOF ;
    public final EObject entryRuleCheckedPanel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckedPanel = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:430:54: (iv_ruleCheckedPanel= ruleCheckedPanel EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:431:2: iv_ruleCheckedPanel= ruleCheckedPanel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCheckedPanel_in_entryRuleCheckedPanel1114);
            iv_ruleCheckedPanel=ruleCheckedPanel();
            _fsp--;

             current =iv_ruleCheckedPanel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCheckedPanel1124); 

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
    // $ANTLR end entryRuleCheckedPanel


    // $ANTLR start ruleCheckedPanel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:438:1: ruleCheckedPanel returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )* ) '}' ) ;
    public final EObject ruleCheckedPanel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_rows = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:440:33: ( ( ( ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )* ) '}' ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:1: ( ( ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )* ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:1: ( ( ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )* ) '}' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:2: ( ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )* ) '}'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:2: ( ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )* )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:3: ( ( (lv_name= RULE_ID ) ) '{' ) (lv_rows= ruleRow )*
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:3: ( ( (lv_name= RULE_ID ) ) '{' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:4: ( (lv_name= RULE_ID ) ) '{'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:4: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:5: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:441:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:442:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCheckedPanel1169); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("CheckedPanel");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,"ID");
                    
                     

            }


            }

            match(input,13,FOLLOW_13_in_ruleCheckedPanel1187); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:460:2: (lv_rows= ruleRow )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=15 && LA11_0<=16)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:462:5: lv_rows= ruleRow
            	    {
            	     
            	            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleRow_in_ruleCheckedPanel1216);
            	    lv_rows=ruleRow();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("CheckedPanel");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "rows", lv_rows,null);
            	            
            	             

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            match(input,14,FOLLOW_14_in_ruleCheckedPanel1228); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleCheckedPanel


    // $ANTLR start entryRuleLabel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:487:1: entryRuleLabel returns [EObject current=null] : iv_ruleLabel= ruleLabel EOF ;
    public final EObject entryRuleLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLabel = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:487:47: (iv_ruleLabel= ruleLabel EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:488:2: iv_ruleLabel= ruleLabel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLabel_in_entryRuleLabel1265);
            iv_ruleLabel=ruleLabel();
            _fsp--;

             current =iv_ruleLabel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLabel1275); 

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
    // $ANTLR end entryRuleLabel


    // $ANTLR start ruleLabel
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:495:1: ruleLabel returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleLabel() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:497:33: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:498:1: (lv_value= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:498:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:499:5: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLabel1316); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.9/@alternatives/@terminal" /* xtext::RuleCall */, "value"); 
                

                    if (current==null) {
                        current = factory.create("Label");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "value", lv_value,"STRING");
                    
                     

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
    // $ANTLR end ruleLabel


    // $ANTLR start entryRuleText
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:518:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:518:46: (iv_ruleText= ruleText EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:519:2: iv_ruleText= ruleText EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.10" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleText_in_entryRuleText1358);
            iv_ruleText=ruleText();
            _fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleText1368); 

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
    // $ANTLR end entryRuleText


    // $ANTLR start ruleText
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:526:1: ruleText returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:528:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:529:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:529:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:530:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleText1409); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.10/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("Text");
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
    // $ANTLR end ruleText


    // $ANTLR start entryRuleCheck
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:549:1: entryRuleCheck returns [EObject current=null] : iv_ruleCheck= ruleCheck EOF ;
    public final EObject entryRuleCheck() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheck = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:549:47: (iv_ruleCheck= ruleCheck EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:550:2: iv_ruleCheck= ruleCheck EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.11" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCheck_in_entryRuleCheck1451);
            iv_ruleCheck=ruleCheck();
            _fsp--;

             current =iv_ruleCheck; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCheck1461); 

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
    // $ANTLR end entryRuleCheck


    // $ANTLR start ruleCheck
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:557:1: ruleCheck returns [EObject current=null] : ( '?' (lv_name= RULE_ID ) ) ;
    public final EObject ruleCheck() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:559:33: ( ( '?' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:560:1: ( '?' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:560:1: ( '?' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:560:2: '?' (lv_name= RULE_ID )
            {
            match(input,17,FOLLOW_17_in_ruleCheck1495); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.11/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:564:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:565:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCheck1512); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("Check");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,"ID");
                    
                     

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
    // $ANTLR end ruleCheck


    // $ANTLR start entryRuleCombo
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:584:1: entryRuleCombo returns [EObject current=null] : iv_ruleCombo= ruleCombo EOF ;
    public final EObject entryRuleCombo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCombo = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:584:47: (iv_ruleCombo= ruleCombo EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:585:2: iv_ruleCombo= ruleCombo EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCombo_in_entryRuleCombo1555);
            iv_ruleCombo=ruleCombo();
            _fsp--;

             current =iv_ruleCombo; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCombo1565); 

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
    // $ANTLR end entryRuleCombo


    // $ANTLR start ruleCombo
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:592:1: ruleCombo returns [EObject current=null] : ( ( ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']' ) (lv_name= RULE_ID ) ) ;
    public final EObject ruleCombo() throws RecognitionException {
        EObject current = null;

        Token lv_alts=null;
        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:594:33: ( ( ( ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']' ) (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:1: ( ( ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']' ) (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:1: ( ( ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:2: ( ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:2: ( ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']' )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:3: ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) ) ']'
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:3: ( ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:4: ( '[' (lv_alts= RULE_STRING ) ) ( ',' (lv_alts= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:4: ( '[' (lv_alts= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:595:5: '[' (lv_alts= RULE_STRING )
            {
            match(input,18,FOLLOW_18_in_ruleCombo1602); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:599:1: (lv_alts= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:600:5: lv_alts= RULE_STRING
            {
            lv_alts=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCombo1619); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alts"); 
                

                    if (current==null) {
                        current = factory.create("Combo");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.add(current, "alts", lv_alts,"STRING");
                    
                     

            }


            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:614:3: ( ',' (lv_alts= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:614:4: ',' (lv_alts= RULE_STRING )
            {
            match(input,19,FOLLOW_19_in_ruleCombo1638); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:618:1: (lv_alts= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:619:5: lv_alts= RULE_STRING
            {
            lv_alts=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCombo1655); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alts"); 
                

                    if (current==null) {
                        current = factory.create("Combo");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.add(current, "alts", lv_alts,"STRING");
                    
                     

            }


            }


            }

            match(input,20,FOLLOW_20_in_ruleCombo1674); 

                    createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:637:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:638:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCombo1692); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.12/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

                    if (current==null) {
                        current = factory.create("Combo");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.set(current, "name", lv_name,"ID");
                    
                     

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
    // $ANTLR end ruleCombo


    // $ANTLR start entryRuleQName
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:657:1: entryRuleQName returns [EObject current=null] : iv_ruleQName= ruleQName EOF ;
    public final EObject entryRuleQName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQName = null;


        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:657:47: (iv_ruleQName= ruleQName EOF )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:658:2: iv_ruleQName= ruleQName EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleQName_in_entryRuleQName1735);
            iv_ruleQName=ruleQName();
            _fsp--;

             current =iv_ruleQName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQName1745); 

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
    // $ANTLR end entryRuleQName


    // $ANTLR start ruleQName
    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:665:1: ruleQName returns [EObject current=null] : ( (lv_element= RULE_ID ) ( (lv_element= '.' ) (lv_element= RULE_ID ) )* ) ;
    public final EObject ruleQName() throws RecognitionException {
        EObject current = null;

        Token lv_element=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:667:33: ( ( (lv_element= RULE_ID ) ( (lv_element= '.' ) (lv_element= RULE_ID ) )* ) )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:668:1: ( (lv_element= RULE_ID ) ( (lv_element= '.' ) (lv_element= RULE_ID ) )* )
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:668:1: ( (lv_element= RULE_ID ) ( (lv_element= '.' ) (lv_element= RULE_ID ) )* )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:668:2: (lv_element= RULE_ID ) ( (lv_element= '.' ) (lv_element= RULE_ID ) )*
            {
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:668:2: (lv_element= RULE_ID )
            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:669:5: lv_element= RULE_ID
            {
            lv_element=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQName1787); 
             
                createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13/@alternatives/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "element"); 
                

                    if (current==null) {
                        current = factory.create("QName");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    
                    factory.add(current, "element", lv_element,"ID");
                    
                     

            }

            // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:683:2: ( (lv_element= '.' ) (lv_element= RULE_ID ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:683:3: (lv_element= '.' ) (lv_element= RULE_ID )
            	    {
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:683:3: (lv_element= '.' )
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:684:5: lv_element= '.'
            	    {
            	    lv_element=(Token)input.LT(1);
            	    match(input,21,FOLLOW_21_in_ruleQName1813); 

            	            createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13/@alternatives/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::Keyword */, "element"); 
            	        

            	            if (current==null) {
            	                current = factory.create("QName");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "element", input.LT(-1),".");
            	            
            	             

            	    }

            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:698:2: (lv_element= RULE_ID )
            	    // ./src-gen/org/eclipse/xtext/preference/parser/internal/InternalPreferenceGrammar.g:699:5: lv_element= RULE_ID
            	    {
            	    lv_element=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQName1839); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/preference/PreferenceGrammar.xmi#//@parserRules.13/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "element"); 
            	        

            	            if (current==null) {
            	                current = factory.create("QName");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            
            	            factory.add(current, "element", lv_element,"ID");
            	            
            	             

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end ruleQName


 

    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleDescription116 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQName_in_ruleDescription144 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rulePage_in_ruleDescription174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePage_in_entryRulePage210 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePage220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePage255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleQName_in_rulePage283 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rulePanel_in_rulePage313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePanel_in_entryRulePanel349 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePanel359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePanel394 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_ruleRow_in_rulePanel422 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_14_in_rulePanel434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRow_in_entryRuleRow469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRow479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_ruleRow532 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleRow543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntry588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleEntry630 = new BitSet(new long[]{0x0000000000072030L});
    public static final BitSet FOLLOW_ruleWidget_in_ruleEntry668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWidget_in_entryRuleWidget704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWidget714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabel_in_ruleWidget766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleText_in_ruleWidget793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCheck_in_ruleWidget821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCombo_in_ruleWidget849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePanel_in_ruleWidget877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedPanel_in_ruleWidget905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCheckedPanel_in_ruleWidget933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedPanel_in_entryRuleNamedPanel967 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedPanel977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedPanel1021 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleNamedPanel1038 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_ruleRow_in_ruleNamedPanel1067 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_14_in_ruleNamedPanel1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCheckedPanel_in_entryRuleCheckedPanel1114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCheckedPanel1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCheckedPanel1169 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCheckedPanel1187 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_ruleRow_in_ruleCheckedPanel1216 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_14_in_ruleCheckedPanel1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLabel_in_entryRuleLabel1265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLabel1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLabel1316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleText_in_entryRuleText1358 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleText1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleText1409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCheck_in_entryRuleCheck1451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCheck1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleCheck1495 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCheck1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCombo_in_entryRuleCombo1555 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCombo1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleCombo1602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCombo1619 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleCombo1638 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCombo1655 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleCombo1674 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCombo1692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQName_in_entryRuleQName1735 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQName1745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQName1787 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleQName1813 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQName1839 = new BitSet(new long[]{0x0000000000200002L});

}
// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g 2008-08-07 16:59:03

package org.eclipse.xtext.parser.internal; 

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

public class InternalXtextGrammarTestParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract language'", "'language'", "'.'", "'extends'", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextGrammarTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g"; }


     
        public InternalXtextGrammarTestParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalXtextGrammarTestParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:63:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:64:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar71);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar81); 

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
    // $ANTLR end entryRuleGrammar


    // $ANTLR start ruleGrammar
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:71:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract=null;
        Token lv_idElements=null;
        Token lv_superGrammarIdElements=null;
        EObject lv_metamodelDeclarations = null;

        EObject lv_parserRules = null;

        EObject lv_lexerRules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:73:33: ( ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:1: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:1: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:2: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:2: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:3: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:3: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:4: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )? (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:4: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=11 && LA5_0<=12)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:5: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:5: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:6: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:6: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:7: ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:7: ( (lv_abstract= 'abstract language' ) | 'language' )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==12) ) {
                        alt1=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("74:7: ( (lv_abstract= 'abstract language' ) | 'language' )", 1, 0, input);

                        throw nvae;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:8: (lv_abstract= 'abstract language' )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:74:8: (lv_abstract= 'abstract language' )
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:76:6: lv_abstract= 'abstract language'
                            {
                            lv_abstract=(Token)input.LT(1);
                            match(input,11,FOLLOW_11_in_ruleGrammar133); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "abstract"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Grammar");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        factory.set(current, "abstract", true,"abstract language");
                            	         

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:91:6: 'language'
                            {
                            match(input,12,FOLLOW_12_in_ruleGrammar160); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                                

                            }
                            break;

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:95:2: (lv_idElements= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:97:6: lv_idElements= RULE_ID
                    {
                    lv_idElements=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar182); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.add(current, "idElements", lv_idElements,"ID");
                    	         

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:3: ( '.' (lv_idElements= RULE_ID ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:111:4: '.' (lv_idElements= RULE_ID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar204); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:115:1: (lv_idElements= RULE_ID )
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:117:6: lv_idElements= RULE_ID
                    	    {
                    	    lv_idElements=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar225); 
                    	     
                    	        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
                    	        

                    	    	        if (current==null) {
                    	    	            current = factory.create("Grammar");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        factory.add(current, "idElements", lv_idElements,"ID");
                    	    	         

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:5: ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==14) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                            {
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) )
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:131:7: 'extends' (lv_superGrammarIdElements= RULE_ID )
                            {
                            match(input,14,FOLLOW_14_in_ruleGrammar250); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                                
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:135:1: (lv_superGrammarIdElements= RULE_ID )
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:137:6: lv_superGrammarIdElements= RULE_ID
                            {
                            lv_superGrammarIdElements=(Token)input.LT(1);
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar271); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Grammar");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        factory.add(current, "superGrammarIdElements", lv_superGrammarIdElements,"ID");
                            	         

                            }


                            }

                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:151:3: ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:151:4: '.' (lv_superGrammarIdElements= RULE_ID )
                            	    {
                            	    match(input,13,FOLLOW_13_in_ruleGrammar293); 

                            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                            	        
                            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:155:1: (lv_superGrammarIdElements= RULE_ID )
                            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:157:6: lv_superGrammarIdElements= RULE_ID
                            	    {
                            	    lv_superGrammarIdElements=(Token)input.LT(1);
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar314); 
                            	     
                            	        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
                            	        

                            	    	        if (current==null) {
                            	    	            current = factory.create("Grammar");
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	    	        
                            	    	        factory.add(current, "superGrammarIdElements", lv_superGrammarIdElements,"ID");
                            	    	         

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:171:8: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:174:6: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar365);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "metamodelDeclarations", lv_metamodelDeclarations,null);
            	    	         

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:188:4: (lv_parserRules= ruleParserRule )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:191:6: lv_parserRules= ruleParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar405);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "parserRules", lv_parserRules,null);
            	    	         

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:4: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:5: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:5: ( 'lexing' ':' )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:205:6: 'lexing' ':'
                    {
                    match(input,15,FOLLOW_15_in_ruleGrammar422); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,16,FOLLOW_16_in_ruleGrammar431); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:213:2: (lv_lexerRules= ruleLexerRule )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:216:6: lv_lexerRules= ruleLexerRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar466);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;


                    	    	        currentNode = currentNode.getParent();
                    	    	        if (current==null) {
                    	    	            current = factory.create("Grammar");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        factory.add(current, "lexerRules", lv_lexerRules,null);
                    	    	         

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

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
    // $ANTLR end ruleGrammar


    // $ANTLR start entryRuleAbstractMetamodelDeclaration
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:237:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:237:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:238:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration510);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration520); 

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
    // $ANTLR end entryRuleAbstractMetamodelDeclaration


    // $ANTLR start ruleAbstractMetamodelDeclaration
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:245:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:247:33: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:248:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:248:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            else if ( (LA10_0==19) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("248:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:249:5: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration567);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:259:5: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration594);
                    this_ReferencedMetamodel=ruleReferencedMetamodel();
                    _fsp--;

                     
                            current = this_ReferencedMetamodel; 
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
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start entryRuleGeneratedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:272:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:273:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel628);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel638); 

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
    // $ANTLR end entryRuleGeneratedMetamodel


    // $ANTLR start ruleGeneratedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:280:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:282:33: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:3: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:3: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:283:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,17,FOLLOW_17_in_ruleGeneratedMetamodel674); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:287:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:289:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel695); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:303:3: (lv_nsURI= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:305:6: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel728); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "nsURI"); 
                

            	        if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "nsURI", lv_nsURI,"STRING");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:319:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:319:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel750); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:323:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:325:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel771); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("GeneratedMetamodel");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "alias", lv_alias,"ID");
                    	         

                    }


                    }
                    break;

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
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start entryRuleReferencedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:344:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:345:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel819);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel829); 

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
    // $ANTLR end entryRuleReferencedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:352:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;
        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:354:33: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:2: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:2: ( 'import' (lv_uri= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:355:3: 'import' (lv_uri= RULE_STRING )
            {
            match(input,19,FOLLOW_19_in_ruleReferencedMetamodel864); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:359:1: (lv_uri= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:361:6: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel885); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "uri"); 
                

            	        if (current==null) {
            	            current = factory.create("ReferencedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "uri", lv_uri,"STRING");
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:375:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:375:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,18,FOLLOW_18_in_ruleReferencedMetamodel907); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:379:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:381:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel928); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ReferencedMetamodel");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "alias", lv_alias,"ID");
                    	         

                    }


                    }
                    break;

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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleLexerRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:400:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:400:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:401:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule976);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule986); 

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
    // $ANTLR end entryRuleLexerRule


    // $ANTLR start ruleLexerRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:408:1: ruleLexerRule returns [EObject current=null] : ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:410:33: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:1: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:2: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:2: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:3: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:3: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:4: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:411:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:413:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1034); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:427:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:427:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleLexerRule1055); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:431:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:434:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1089);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        currentNode = currentNode.getParent();
                    	        if (current==null) {
                    	            current = factory.create("LexerRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "type", lv_type,null);
                    	         

                    }


                    }
                    break;

            }


            }

            match(input,16,FOLLOW_16_in_ruleLexerRule1105); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:452:2: (lv_body= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:454:6: lv_body= RULE_STRING
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1127); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "body"); 
                

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "body", lv_body,"STRING");
            	         

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
    // $ANTLR end ruleLexerRule


    // $ANTLR start entryRuleParserRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:473:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:473:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:474:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1173);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1183); 

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
    // $ANTLR end entryRuleParserRule


    // $ANTLR start ruleParserRule
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:481:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:483:33: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:5: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:484:5: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:486:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1232); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "name", lv_name,"ID");
            	         

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:500:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:500:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleParserRule1253); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:504:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:507:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1287);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        currentNode = currentNode.getParent();
                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "type", lv_type,null);
                    	         

                    }


                    }
                    break;

            }


            }

            match(input,16,FOLLOW_16_in_ruleParserRule1303); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:525:2: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:528:6: lv_alternatives= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1338);
            lv_alternatives=ruleAlternatives();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "alternatives", lv_alternatives,null);
            	         

            }


            }

            match(input,21,FOLLOW_21_in_ruleParserRule1352); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleParserRule


    // $ANTLR start entryRuleTypeRef
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:551:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:551:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:552:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1387);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1397); 

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
    // $ANTLR end entryRuleTypeRef


    // $ANTLR start ruleTypeRef
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:559:1: ruleTypeRef returns [EObject current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:561:33: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:2: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:2: ( (lv_alias= RULE_ID ) '::' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==22) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:3: (lv_alias= RULE_ID ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:562:3: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:564:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1444); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("TypeRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "alias", lv_alias,"ID");
                    	         

                    }

                    match(input,22,FOLLOW_22_in_ruleTypeRef1464); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:582:3: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:584:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1487); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("TypeRef");
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
    // $ANTLR end ruleTypeRef


    // $ANTLR start entryRuleAlternatives
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:603:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:603:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:604:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives1533);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives1543); 

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
    // $ANTLR end entryRuleAlternatives


    // $ANTLR start ruleAlternatives
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:611:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:613:33: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:614:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:614:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:615:5: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.8/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1590);
            this_Group=ruleGroup();
            _fsp--;

             
                    current = this_Group; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:623:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:623:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:623:2: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:623:3: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:623:3: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:624:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            factory.add(temp, "groups",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,23,FOLLOW_23_in_ruleAlternatives1609); 

            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:639:2: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:642:6: lv_groups= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1644);
            	    lv_groups=ruleGroup();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "groups", lv_groups,null);
            	    	         

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // $ANTLR end ruleAlternatives


    // $ANTLR start entryRuleGroup
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:661:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:661:47: (iv_ruleGroup= ruleGroup EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:662:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup1685);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup1695); 

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
    // $ANTLR end entryRuleGroup


    // $ANTLR start ruleGroup
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:669:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:671:33: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:672:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:672:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:673:5: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1742);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:681:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_STRING)||LA17_0==30||LA17_0==33) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:681:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:681:2: ()
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:682:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            factory.add(temp, "abstractTokens",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:693:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:696:6: lv_abstractTokens= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1785);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;


            	    	        currentNode = currentNode.getParent();
            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        factory.add(current, "abstractTokens", lv_abstractTokens,null);
            	    	         

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleAbstractToken
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:715:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:715:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:716:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1826);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken1836); 

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
    // $ANTLR end entryRuleAbstractToken


    // $ANTLR start ruleAbstractToken
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:723:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:725:33: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:726:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:726:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:726:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:726:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt19=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA19_1 = input.LA(2);

                if ( ((LA19_1>=27 && LA19_1<=29)) ) {
                    alt19=1;
                }
                else if ( (LA19_1==EOF||(LA19_1>=RULE_ID && LA19_1<=RULE_STRING)||LA19_1==21||(LA19_1>=23 && LA19_1<=26)||LA19_1==30||(LA19_1>=33 && LA19_1<=34)) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("726:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 19, 1, input);

                    throw nvae;
                }
                }
                break;
            case 30:
                {
                alt19=1;
                }
                break;
            case RULE_STRING:
            case 33:
                {
                alt19=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("726:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:726:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:726:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_ID) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==30) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("726:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:727:5: this_Assignment= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken1885);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:737:5: this_Action= ruleAction
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken1912);
                            this_Action=ruleAction();
                            _fsp--;

                             
                                    current = this_Action; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:747:5: this_AbstractTerminal= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken1940);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:755:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=24 && LA22_0<=26)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:757:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:757:21: ( ( '?' | '*' ) | '+' )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=24 && LA21_0<=25)) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==26) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("757:21: ( ( '?' | '*' ) | '+' )", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:757:22: ( '?' | '*' )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:757:22: ( '?' | '*' )
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==24) ) {
                                alt20=1;
                            }
                            else if ( (LA20_0==25) ) {
                                alt20=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("757:22: ( '?' | '*' )", 20, 0, input);

                                throw nvae;
                            }
                            switch (alt20) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:757:23: '?'
                                    {
                                    match(input,24,FOLLOW_24_in_ruleAbstractToken1963); 

                                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:762:6: '*'
                                    {
                                    match(input,25,FOLLOW_25_in_ruleAbstractToken1978); 

                                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:767:6: '+'
                            {
                            match(input,26,FOLLOW_26_in_ruleAbstractToken1994); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "cardinality", input.LT(-1),null);
                    	         

                    }
                    break;

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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleAssignment
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:786:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:786:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:787:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2043);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2053); 

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
    // $ANTLR end entryRuleAssignment


    // $ANTLR start ruleAssignment
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:794:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:796:33: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:797:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:797:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:797:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:797:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:797:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:797:3: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:799:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment2100); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "feature", lv_feature,"ID");
            	         

            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:813:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:6: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:18: ( ( '+=' | '=' ) | '?=' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=27 && LA24_0<=28)) ) {
                alt24=1;
            }
            else if ( (LA24_0==29) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("815:18: ( ( '+=' | '=' ) | '?=' )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:19: ( '+=' | '=' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:19: ( '+=' | '=' )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==27) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==28) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("815:19: ( '+=' | '=' )", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:815:20: '+='
                            {
                            match(input,27,FOLLOW_27_in_ruleAssignment2134); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:820:6: '='
                            {
                            match(input,28,FOLLOW_28_in_ruleAssignment2149); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:825:6: '?='
                    {
                    match(input,29,FOLLOW_29_in_ruleAssignment2165); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "operator", input.LT(-1),null);
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:839:3: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:842:6: lv_terminal= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment2213);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "terminal", lv_terminal,null);
            	         

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
    // $ANTLR end ruleAssignment


    // $ANTLR start entryRuleAction
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:861:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:861:48: (iv_ruleAction= ruleAction EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:862:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction2252);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction2262); 

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
    // $ANTLR end entryRuleAction


    // $ANTLR start ruleAction
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:869:1: ruleAction returns [EObject current=null] : ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:871:33: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:1: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:2: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:2: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:3: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:3: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:4: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:4: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:872:5: '{' ( 'current' '=' )?
            {
            match(input,30,FOLLOW_30_in_ruleAction2299); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:876:1: ( 'current' '=' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==31) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:876:2: 'current' '='
                    {
                    match(input,31,FOLLOW_31_in_ruleAction2309); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,28,FOLLOW_28_in_ruleAction2318); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:884:4: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:887:6: lv_typeName= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction2355);
            lv_typeName=ruleTypeRef();
            _fsp--;


            	        currentNode = currentNode.getParent();
            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        factory.set(current, "typeName", lv_typeName,null);
            	         

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:901:3: ( ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==13) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:901:4: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:901:4: ( ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:901:5: ( '.' (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:901:5: ( '.' (lv_feature= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:901:6: '.' (lv_feature= RULE_ID )
                    {
                    match(input,13,FOLLOW_13_in_ruleAction2372); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:905:1: (lv_feature= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:907:6: lv_feature= RULE_ID
                    {
                    lv_feature=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction2393); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "feature"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Action");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "feature", lv_feature,"ID");
                    	         

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:921:3: (lv_operator= ( '=' | '+=' ) )
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:923:6: lv_operator= ( '=' | '+=' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:923:18: ( '=' | '+=' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==28) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==27) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("923:18: ( '=' | '+=' )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:923:19: '='
                            {
                            match(input,28,FOLLOW_28_in_ruleAction2427); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:928:6: '+='
                            {
                            match(input,27,FOLLOW_27_in_ruleAction2442); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create("Action");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        factory.set(current, "operator", input.LT(-1),null);
                    	         

                    }


                    }

                    match(input,31,FOLLOW_31_in_ruleAction2465); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            match(input,32,FOLLOW_32_in_ruleAction2477); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleAction


    // $ANTLR start entryRuleAbstractTerminal
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:955:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:955:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:956:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.13" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2512);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal2522); 

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
    // $ANTLR end entryRuleAbstractTerminal


    // $ANTLR start ruleAbstractTerminal
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:963:1: ruleAbstractTerminal returns [EObject current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:965:33: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:966:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:966:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
                alt29=1;
            }
            else if ( (LA29_0==33) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("966:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:966:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:966:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_STRING) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==RULE_ID) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("966:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:967:5: this_Keyword= ruleKeyword
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal2570);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                             
                                    current = this_Keyword; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:977:5: this_RuleCall= ruleRuleCall
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.13/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2597);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                             
                                    current = this_RuleCall; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:987:5: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.13/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2625);
                    this_ParenthesizedElement=ruleParenthesizedElement();
                    _fsp--;

                     
                            current = this_ParenthesizedElement; 
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
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start entryRuleParenthesizedElement
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1000:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1000:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1001:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.14" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement2659);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement2669); 

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
    // $ANTLR end entryRuleParenthesizedElement


    // $ANTLR start ruleParenthesizedElement
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1008:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1010:33: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1011:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1011:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1011:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1011:2: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1011:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,33,FOLLOW_33_in_ruleParenthesizedElement2704); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement2726);
            this_Alternatives=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,34,FOLLOW_34_in_ruleParenthesizedElement2735); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start entryRuleKeyword
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1033:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1033:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1034:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.15" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword2770);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword2780); 

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
    // $ANTLR end entryRuleKeyword


    // $ANTLR start ruleKeyword
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1041:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1043:33: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1044:1: (lv_value= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1044:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1046:6: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword2825); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.15/@alternatives/@terminal" /* xtext::RuleCall */, "value"); 
                

            	        if (current==null) {
            	            current = factory.create("Keyword");
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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleRuleCall
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1065:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1066:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.16" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall2870);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall2880); 

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
    // $ANTLR end entryRuleRuleCall


    // $ANTLR start ruleRuleCall
    // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1073:1: ruleRuleCall returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1075:33: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1076:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1076:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g:1078:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall2925); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.16/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("RuleCall");
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
    // $ANTLR end ruleRuleCall


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar182 = new BitSet(new long[]{0x00000000000AE012L});
    public static final BitSet FOLLOW_13_in_ruleGrammar204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar225 = new BitSet(new long[]{0x00000000000AE012L});
    public static final BitSet FOLLOW_14_in_ruleGrammar250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar271 = new BitSet(new long[]{0x00000000000AA012L});
    public static final BitSet FOLLOW_13_in_ruleGrammar293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar314 = new BitSet(new long[]{0x00000000000AA012L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar365 = new BitSet(new long[]{0x00000000000A8012L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar405 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_ruleGrammar422 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar431 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar466 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel628 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleGeneratedMetamodel674 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel695 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel728 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel864 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel885 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleReferencedMetamodel907 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1034 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleLexerRule1055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1089 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLexerRule1105 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1232 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleParserRule1253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1287 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1303 = new BitSet(new long[]{0x0000000240000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1338 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1444 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTypeRef1464 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives1533 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1590 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleAlternatives1609 = new BitSet(new long[]{0x0000000240000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1644 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup1685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1742 = new BitSet(new long[]{0x0000000240000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1785 = new BitSet(new long[]{0x0000000240000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken1826 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken1885 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken1912 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken1940 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_24_in_ruleAbstractToken1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleAbstractToken1978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAbstractToken1994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment2100 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_27_in_ruleAssignment2134 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_28_in_ruleAssignment2149 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_29_in_ruleAssignment2165 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment2213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction2252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction2262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAction2299 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_31_in_ruleAction2309 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleAction2318 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction2355 = new BitSet(new long[]{0x0000000100002000L});
    public static final BitSet FOLLOW_13_in_ruleAction2372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction2393 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_28_in_ruleAction2427 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27_in_ruleAction2442 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAction2465 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAction2477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal2512 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal2570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal2597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement2659 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleParenthesizedElement2704 = new BitSet(new long[]{0x0000000240000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement2726 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleParenthesizedElement2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword2770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword2825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall2870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall2925 = new BitSet(new long[]{0x0000000000000002L});

}
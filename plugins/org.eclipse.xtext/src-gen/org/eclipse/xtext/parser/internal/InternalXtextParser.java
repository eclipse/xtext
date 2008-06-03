// $ANTLR 3.0.1 ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g 2008-06-03 10:35:12

package org.eclipse.xtext.parser.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextParser extends AbstractAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_LEXER_BODY", "RULE_ANY_OTHER", "'language'", "'.'", "'extends'", "'lexing'", "':'", "'generate'", "'as'", "'import'", "'returns'", "';'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=10;

        public InternalXtextParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g"; }


     
        public InternalXtextParser(TokenStream input, IElementFactory factory) {
            this(input);
            this.factory = factory;
    		grammar = LanguageFacadeFactory.getFacade("org.eclipse.xtext.Xtext").getGrammar();
        }
        
        protected void setLexerRule(LeafNode node, Token t) {
        /*    LexerRule lexerRule = XtextTokenTypeResolver.getLexerRule(node, t.getType());
            if(lexerRule != null) {
                node.setGrammarElement(lexerRule);
            }*/
        }




    // $ANTLR start internalParse
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:90:1: internalParse returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject internalParse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:90:46: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:91:3: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode("//@parserRules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_internalParse76);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_internalParse86); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end internalParse


    // $ANTLR start ruleGrammar
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:99:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_idElements=null;
        Token lv_superGrammar=null;
        EObject lv_metamodelDeclarations = null;

        EObject lv_parserRules = null;

        EObject lv_lexerRules = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:100:33: ( ( ( ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:1: ( ( ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:1: ( ( ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:2: ( ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* ) ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:2: ( ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:3: ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_parserRules= ruleParserRule )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:3: ( ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:4: ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:4: ( ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:5: ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( 'extends' (lv_superGrammar= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:5: ( ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:6: ( 'language' (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:6: ( 'language' (lv_idElements= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:101:7: 'language' (lv_idElements= RULE_ID )
            {
            match(input,12,FOLLOW_12_in_ruleGrammar117); 

                    createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:106:1: (lv_idElements= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:107:5: lv_idElements= RULE_ID
            {
            lv_idElements=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar135); 
             
                createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"idElements"); 
                

                    if (current==null) {
                        current = factory.create("Grammar");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.add(current, "idElements", lv_idElements);    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:118:3: ( '.' (lv_idElements= RULE_ID ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:118:4: '.' (lv_idElements= RULE_ID )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleGrammar154); 

            	            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
            	        
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:123:1: (lv_idElements= RULE_ID )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:124:5: lv_idElements= RULE_ID
            	    {
            	    lv_idElements=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar172); 
            	     
            	        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"idElements"); 
            	        

            	            if (current==null) {
            	                current = factory.create("Grammar");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "idElements", lv_idElements);    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:135:5: ( 'extends' (lv_superGrammar= RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:135:6: 'extends' (lv_superGrammar= RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleGrammar193); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:140:1: (lv_superGrammar= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:141:5: lv_superGrammar= RULE_ID
                    {
                    lv_superGrammar=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar211); 
                     
                        createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"superGrammar"); 
                        

                            if (current==null) {
                                current = factory.create("Grammar");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "superGrammar", lv_superGrammar);    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:152:5: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17||LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:154:5: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar250);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Grammar");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "metamodelDeclarations", lv_metamodelDeclarations);    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:165:4: (lv_parserRules= ruleParserRule )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:167:5: lv_parserRules= ruleParserRule
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleParserRule_in_ruleGrammar281);
            	    lv_parserRules=ruleParserRule();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("Grammar");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "parserRules", lv_parserRules);    

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:178:4: ( ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+ )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:178:5: ( 'lexing' ':' ) (lv_lexerRules= ruleLexerRule )+
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:178:5: ( 'lexing' ':' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:178:6: 'lexing' ':'
                    {
                    match(input,15,FOLLOW_15_in_ruleGrammar295); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    match(input,16,FOLLOW_16_in_ruleGrammar305); 

                            createLeafNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:188:2: (lv_lexerRules= ruleLexerRule )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:190:5: lv_lexerRules= ruleLexerRule
                    	    {
                    	     
                    	            currentNode=createCompositeNode("//@parserRules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	        
                    	    pushFollow(FOLLOW_ruleLexerRule_in_ruleGrammar335);
                    	    lv_lexerRules=ruleLexerRule();
                    	    _fsp--;


                    	            currentNode = currentNode.getParent();
                    	            if (current==null) {
                    	                current = factory.create("Grammar");
                    	                associateNodeWithAstElement(currentNode, current);
                    	            }
                    	            factory.add(current, "lexerRules", lv_lexerRules);    

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
                    break;

            }


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGrammar


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:205:1: ruleAbstractRule returns [EObject current=null] : (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:206:33: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==20) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==RULE_ID) ) {
                        int LA7_4 = input.LA(4);

                        if ( (LA7_4==22) ) {
                            int LA7_7 = input.LA(5);

                            if ( (LA7_7==RULE_ID) ) {
                                int LA7_9 = input.LA(6);

                                if ( (LA7_9==16) ) {
                                    int LA7_3 = input.LA(7);

                                    if ( (LA7_3==RULE_STRING) ) {
                                        int LA7_5 = input.LA(8);

                                        if ( (LA7_5==21) ) {
                                            alt7=1;
                                        }
                                        else if ( ((LA7_5>=RULE_ID && LA7_5<=RULE_STRING)||(LA7_5>=23 && LA7_5<=26)||LA7_5==30||LA7_5==33) ) {
                                            alt7=2;
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 5, input);

                                            throw nvae;
                                        }
                                    }
                                    else if ( (LA7_3==RULE_ID||LA7_3==30||LA7_3==33) ) {
                                        alt7=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 3, input);

                                        throw nvae;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 9, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 7, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA7_4==16) ) {
                            int LA7_3 = input.LA(5);

                            if ( (LA7_3==RULE_STRING) ) {
                                int LA7_5 = input.LA(6);

                                if ( (LA7_5==21) ) {
                                    alt7=1;
                                }
                                else if ( ((LA7_5>=RULE_ID && LA7_5<=RULE_STRING)||(LA7_5>=23 && LA7_5<=26)||LA7_5==30||LA7_5==33) ) {
                                    alt7=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 5, input);

                                    throw nvae;
                                }
                            }
                            else if ( (LA7_3==RULE_ID||LA7_3==30||LA7_3==33) ) {
                                alt7=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 3, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA7_1==16) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==RULE_STRING) ) {
                        int LA7_5 = input.LA(4);

                        if ( (LA7_5==21) ) {
                            alt7=1;
                        }
                        else if ( ((LA7_5>=RULE_ID && LA7_5<=RULE_STRING)||(LA7_5>=23 && LA7_5<=26)||LA7_5==30||LA7_5==33) ) {
                            alt7=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 5, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA7_3==RULE_ID||LA7_3==30||LA7_3==33) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("207:1: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:207:2: this_LexerRule= ruleLexerRule
                    {
                    pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule374);
                    this_LexerRule=ruleLexerRule();
                    _fsp--;

                     
                            current = this_LexerRule; 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:212:6: this_ParserRule= ruleParserRule
                    {
                    pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule390);
                    this_ParserRule=ruleParserRule();
                    _fsp--;

                     
                            current = this_ParserRule; 
                        

                    }
                    break;

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractRule


    // $ANTLR start ruleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:220:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:221:33: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:222:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:222:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            else if ( (LA8_0==19) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("222:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:222:2: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration424);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel; 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:227:6: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration440);
                    this_ReferencedMetamodel=ruleReferencedMetamodel();
                    _fsp--;

                     
                            current = this_ReferencedMetamodel; 
                        

                    }
                    break;

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractMetamodelDeclaration


    // $ANTLR start ruleGeneratedMetamodel
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:235:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_nsURI=null;
        Token lv_alias=null;

         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:236:33: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:2: ( ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:3: ( 'generate' (lv_name= RULE_ID ) ) (lv_nsURI= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:3: ( 'generate' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:237:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,17,FOLLOW_17_in_ruleGeneratedMetamodel474); 

                    createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:242:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:243:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel492); 
             
                createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("GeneratedMetamodel");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:254:3: (lv_nsURI= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:255:5: lv_nsURI= RULE_STRING
            {
            lv_nsURI=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel518); 
             
                createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"nsURI"); 
                

                    if (current==null) {
                        current = factory.create("GeneratedMetamodel");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "nsURI", lv_nsURI);    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:266:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==18) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:266:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,18,FOLLOW_18_in_ruleGeneratedMetamodel537); 

                            createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:271:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:272:5: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel555); 
                     
                        createLeafNode("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"alias"); 
                        

                            if (current==null) {
                                current = factory.create("GeneratedMetamodel");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "alias", lv_alias);    

                    }


                    }
                    break;

            }


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start ruleReferencedMetamodel
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:287:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_uri=null;
        Token lv_alias=null;

         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:288:33: ( ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:289:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:289:1: ( ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:289:2: ( 'import' (lv_uri= RULE_STRING ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:289:2: ( 'import' (lv_uri= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:289:3: 'import' (lv_uri= RULE_STRING )
            {
            match(input,19,FOLLOW_19_in_ruleReferencedMetamodel599); 

                    createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:294:1: (lv_uri= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:295:5: lv_uri= RULE_STRING
            {
            lv_uri=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel617); 
             
                createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"uri"); 
                

                    if (current==null) {
                        current = factory.create("ReferencedMetamodel");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "uri", lv_uri);    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:306:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:306:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,18,FOLLOW_18_in_ruleReferencedMetamodel636); 

                            createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:311:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:312:5: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel654); 
                     
                        createLeafNode("//@parserRules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"alias"); 
                        

                            if (current==null) {
                                current = factory.create("ReferencedMetamodel");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "alias", lv_alias);    

                    }


                    }
                    break;

            }


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start ruleLexerRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:327:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;
        EObject lv_type = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:328:33: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:5: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:329:5: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:330:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule708); 
             
                createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("LexerRule");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:341:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:341:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleLexerRule726); 

                            createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:346:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:348:5: lv_type= ruleTypeRef
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule755);
                    lv_type=ruleTypeRef();
                    _fsp--;


                            currentNode = currentNode.getParent();
                            if (current==null) {
                                current = factory.create("LexerRule");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "type", lv_type);    

                    }


                    }
                    break;

            }


            }

            match(input,16,FOLLOW_16_in_ruleLexerRule768); 

                    createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:364:2: (lv_body= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:365:5: lv_body= RULE_STRING
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule787); 
             
                createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"body"); 
                

                    if (current==null) {
                        current = factory.create("LexerRule");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "body", lv_body);    

            }


            }

            match(input,21,FOLLOW_21_in_ruleLexerRule805); 

                    createLeafNode("//@parserRules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLexerRule


    // $ANTLR start ruleParserRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:385:1: ruleParserRule returns [EObject current=null] : ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:386:33: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:1: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:2: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:3: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:4: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:5: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:387:5: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:388:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule850); 
             
                createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("ParserRule");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:399:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:399:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleParserRule868); 

                            createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:404:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:406:5: lv_type= ruleTypeRef
                    {
                     
                            currentNode=createCompositeNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule897);
                    lv_type=ruleTypeRef();
                    _fsp--;


                            currentNode = currentNode.getParent();
                            if (current==null) {
                                current = factory.create("ParserRule");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "type", lv_type);    

                    }


                    }
                    break;

            }


            }

            match(input,16,FOLLOW_16_in_ruleParserRule910); 

                    createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:422:2: (lv_alternatives= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:424:5: lv_alternatives= ruleAlternatives
            {
             
                    currentNode=createCompositeNode("//@parserRules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule940);
            lv_alternatives=ruleAlternatives();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("ParserRule");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "alternatives", lv_alternatives);    

            }


            }

            match(input,21,FOLLOW_21_in_ruleParserRule951); 

                    createLeafNode("//@parserRules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParserRule


    // $ANTLR start ruleTypeRef
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:444:1: ruleTypeRef returns [EObject current=null] : ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;
        Token lv_name=null;

         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:445:33: ( ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:1: ( ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:2: ( (lv_alias= RULE_ID ) '::' )? (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:2: ( (lv_alias= RULE_ID ) '::' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==22) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:3: (lv_alias= RULE_ID ) '::'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:446:3: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:447:5: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef994); 
                     
                        createLeafNode("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"alias"); 
                        

                            if (current==null) {
                                current = factory.create("TypeRef");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "alias", lv_alias);    

                    }

                    match(input,22,FOLLOW_22_in_ruleTypeRef1011); 

                            createLeafNode("//@parserRules.7/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:463:3: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:464:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1031); 
             
                createLeafNode("//@parserRules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("TypeRef");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTypeRef


    // $ANTLR start ruleAlternatives
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:479:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:480:33: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:481:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:481:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:481:2: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1074);
            this_Group=ruleGroup();
            _fsp--;

             
                    current = this_Group; 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:485:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:485:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:485:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:485:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:485:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:486:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            factory.add(temp, "groups",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,23,FOLLOW_23_in_ruleAlternatives1093); 

            	            createLeafNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:501:2: (lv_groups= ruleGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:503:5: lv_groups= ruleGroup
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives1123);
            	    lv_groups=ruleGroup();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("AbstractElement");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "groups", lv_groups);    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAlternatives


    // $ANTLR start ruleGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:518:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:519:33: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:520:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:520:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:520:2: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1161);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken; 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:524:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_STRING)||LA15_0==30||LA15_0==33) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:524:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:524:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:525:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            factory.add(temp, "abstractTokens",current);
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:535:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:537:5: lv_abstractTokens= ruleAbstractToken
            	    {
            	     
            	            currentNode=createCompositeNode("//@parserRules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	        
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup1198);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;


            	            currentNode = currentNode.getParent();
            	            if (current==null) {
            	                current = factory.create("AbstractElement");
            	                associateNodeWithAstElement(currentNode, current);
            	            }
            	            factory.add(current, "abstractTokens", lv_abstractTokens);    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleGroup


    // $ANTLR start ruleAbstractToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:552:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:553:33: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt17=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1>=27 && LA17_1<=29)) ) {
                    alt17=1;
                }
                else if ( ((LA17_1>=RULE_ID && LA17_1<=RULE_STRING)||LA17_1==21||(LA17_1>=23 && LA17_1<=26)||LA17_1==30||(LA17_1>=33 && LA17_1<=34)) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("554:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 17, 1, input);

                    throw nvae;
                }
                }
                break;
            case 30:
                {
                alt17=1;
                }
                break;
            case RULE_STRING:
            case 33:
                {
                alt17=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("554:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_ID) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==30) ) {
                        alt16=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("554:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:554:4: this_Assignment= ruleAssignment
                            {
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken1238);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment; 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:559:6: this_Action= ruleAction
                            {
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken1254);
                            this_Action=ruleAction();
                            _fsp--;

                             
                                    current = this_Action; 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:564:6: this_AbstractTerminal= ruleAbstractTerminal
                    {
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken1271);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal; 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:568:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=24 && LA18_0<=26)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:569:5: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    lv_cardinality=(Token)input.LT(1);
                    if ( (input.LA(1)>=24 && input.LA(1)<=26) ) {
                        input.consume();
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAbstractToken1288);    throw mse;
                    }


                            if (current==null) {
                                current = factory.create("AbstractElement");
                                associateNodeWithAstElement(currentNode, current);
                            }
                            factory.set(current, "cardinality", lv_cardinality);        createLeafNode("//@parserRules.10/@alternatives/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"cardinality");    

                    }
                    break;

            }


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractToken


    // $ANTLR start ruleAssignment
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:585:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:586:33: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:587:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:587:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:587:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:587:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:587:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:587:3: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:588:5: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment1356); 
             
                createLeafNode("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode,"feature"); 
                

                    if (current==null) {
                        current = factory.create("Assignment");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "feature", lv_feature);    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:599:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:600:5: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=27 && input.LA(1)<=29) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAssignment1381);    throw mse;
            }


                    if (current==null) {
                        current = factory.create("Assignment");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "operator", lv_operator);        createLeafNode("//@parserRules.11/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:612:3: (lv_terminal= ruleAbstractTerminal )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:614:5: lv_terminal= ruleAbstractTerminal
            {
             
                    currentNode=createCompositeNode("//@parserRules.11/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment1435);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Assignment");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "terminal", lv_terminal);    

            }


            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAssignment


    // $ANTLR start ruleAction
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:629:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:630:33: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:7: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:631:8: '{' ( 'current' '=' )?
            {
            match(input,30,FOLLOW_30_in_ruleAction1475); 

                    createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:636:1: ( 'current' '=' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==31) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:636:2: 'current' '='
                    {
                    match(input,31,FOLLOW_31_in_ruleAction1486); 

                            createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                        
                    match(input,28,FOLLOW_28_in_ruleAction1496); 

                            createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:646:4: (lv_typeName= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:648:5: lv_typeName= ruleTypeRef
            {
             
                    currentNode=createCompositeNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction1528);
            lv_typeName=ruleTypeRef();
            _fsp--;


                    currentNode = currentNode.getParent();
                    if (current==null) {
                        current = factory.create("Action");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "typeName", lv_typeName);    

            }


            }

            match(input,13,FOLLOW_13_in_ruleAction1539); 

                    createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:664:2: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:665:5: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction1558); 
             
                createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode,"feature"); 
                

                    if (current==null) {
                        current = factory.create("Action");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "feature", lv_feature);    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:676:3: (lv_operator= ( '=' | '+=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:677:5: lv_operator= ( '=' | '+=' )
            {
            lv_operator=(Token)input.LT(1);
            if ( (input.LA(1)>=27 && input.LA(1)<=28) ) {
                input.consume();
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_ruleAction1584);    throw mse;
            }


                    if (current==null) {
                        current = factory.create("Action");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "operator", lv_operator);        createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Alternatives */, currentNode,"operator");    

            }


            }

            match(input,31,FOLLOW_31_in_ruleAction1608); 

                    createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }

            match(input,32,FOLLOW_32_in_ruleAction1619); 

                    createLeafNode("//@parserRules.12/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAction


    // $ANTLR start ruleAbstractTerminal
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:701:1: ruleAbstractTerminal returns [EObject current=null] : ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:702:33: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:703:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:703:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
                alt21=1;
            }
            else if ( (LA21_0==33) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("703:1: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:703:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:703:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==RULE_STRING) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==RULE_ID) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("703:2: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 20, 0, input);

                        throw nvae;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:703:3: this_Keyword= ruleKeyword
                            {
                            pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal1656);
                            this_Keyword=ruleKeyword();
                            _fsp--;

                             
                                    current = this_Keyword; 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:708:6: this_RuleCall= ruleRuleCall
                            {
                            pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal1672);
                            this_RuleCall=ruleRuleCall();
                            _fsp--;

                             
                                    current = this_RuleCall; 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:713:6: this_ParenthesizedElement= ruleParenthesizedElement
                    {
                    pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal1689);
                    this_ParenthesizedElement=ruleParenthesizedElement();
                    _fsp--;

                     
                            current = this_ParenthesizedElement; 
                        

                    }
                    break;

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractTerminal


    // $ANTLR start ruleParenthesizedElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:721:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:722:33: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:723:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:723:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:723:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:723:2: ( '(' this_Alternatives= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:723:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,33,FOLLOW_33_in_ruleParenthesizedElement1722); 

                    createLeafNode("//@parserRules.14/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, currentNode,null); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement1734);
            this_Alternatives=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives; 
                

            }

            match(input,34,FOLLOW_34_in_ruleParenthesizedElement1743); 

                    createLeafNode("//@parserRules.14/@alternatives/@abstractTokens.1" /* xtext::Keyword */, currentNode,null); 
                

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleParenthesizedElement


    // $ANTLR start ruleKeyword
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:741:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:742:33: ( (lv_value= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:743:1: (lv_value= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:743:1: (lv_value= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:744:5: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword1784); 
             
                createLeafNode("//@parserRules.15/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"value"); 
                

                    if (current==null) {
                        current = factory.create("Keyword");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "value", lv_value);    

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKeyword


    // $ANTLR start ruleRuleCall
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:759:1: ruleRuleCall returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:760:33: ( (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:761:1: (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:761:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/internal/InternalXtext.g:762:5: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall1831); 
             
                createLeafNode("//@parserRules.16/@alternatives/@terminal" /* xtext::RuleCall */, currentNode,"name"); 
                

                    if (current==null) {
                        current = factory.create("RuleCall");
                        associateNodeWithAstElement(currentNode, current);
                    }
                    factory.set(current, "name", lv_name);    

            }


            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
                IParseError error = createParseError(re);
                reportError(error, re);
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRuleCall


 

    public static final BitSet FOLLOW_ruleGrammar_in_internalParse76 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_internalParse86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleGrammar117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar135 = new BitSet(new long[]{0x00000000000AE012L});
    public static final BitSet FOLLOW_13_in_ruleGrammar154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar172 = new BitSet(new long[]{0x00000000000AE012L});
    public static final BitSet FOLLOW_14_in_ruleGrammar193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar211 = new BitSet(new long[]{0x00000000000A8012L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar250 = new BitSet(new long[]{0x00000000000A8012L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleGrammar281 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_15_in_ruleGrammar295 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleGrammar335 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleGeneratedMetamodel474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel518 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleGeneratedMetamodel537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleReferencedMetamodel599 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel617 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleReferencedMetamodel636 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule708 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleLexerRule726 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule755 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleLexerRule768 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule787 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleLexerRule805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule850 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleParserRule868 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule897 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule910 = new BitSet(new long[]{0x0000000240000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule940 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef994 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTypeRef1011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1074 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleAlternatives1093 = new BitSet(new long[]{0x0000000240000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives1123 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1161 = new BitSet(new long[]{0x0000000240000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup1198 = new BitSet(new long[]{0x0000000240000032L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken1238 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken1254 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken1271 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_set_in_ruleAbstractToken1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment1356 = new BitSet(new long[]{0x0000000038000000L});
    public static final BitSet FOLLOW_set_in_ruleAssignment1381 = new BitSet(new long[]{0x0000000200000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleAction1475 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_31_in_ruleAction1486 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleAction1496 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction1528 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAction1539 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction1558 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_set_in_ruleAction1584 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleAction1608 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleAction1619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleParenthesizedElement1722 = new BitSet(new long[]{0x0000000240000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement1734 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleParenthesizedElement1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall1831 = new BitSet(new long[]{0x0000000000000002L});

}
// $ANTLR 3.0.1 ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g 2009-01-19 15:13:18

package org.eclipse.xtext.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract language'", "'language'", "'.'", "'extends'", "'generate'", "'as'", "'import'", "'native'", "'lexer'", "'returns'", "':'", "';'", "'hidden'", "'('", "','", "')'", "'terminal'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'!'", "'->'", "'..'", "'['", "']'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g"; }


     
        public InternalXtextParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalXtextParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtext.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:67:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:67:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:68:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGrammar_in_entryRuleGrammar72);
            iv_ruleGrammar=ruleGrammar();
            _fsp--;

             current =iv_ruleGrammar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGrammar82); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:75:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract=null;
        Token lv_idElements=null;
        Token lv_superGrammarIdElements=null;
        EObject lv_metamodelDeclarations = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:77:33: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:1: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:1: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:2: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:2: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:3: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:3: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:4: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:4: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:5: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )*
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:5: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:6: ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:6: ( (lv_abstract= 'abstract language' ) | 'language' )
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
                    new NoViableAltException("78:6: ( (lv_abstract= 'abstract language' ) | 'language' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:7: (lv_abstract= 'abstract language' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:78:7: (lv_abstract= 'abstract language' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:80:6: lv_abstract= 'abstract language'
                    {
                    lv_abstract=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleGrammar133); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "abstract", true, "abstract language", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:99:6: 'language'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar160); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:103:2: (lv_idElements= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:105:6: lv_idElements= RULE_ID
            {
            lv_idElements=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar182); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
                

            	        if (current==null) {
            	            current = factory.create("Grammar");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "idElements", lv_idElements, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:123:3: ( '.' (lv_idElements= RULE_ID ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:123:4: '.' (lv_idElements= RULE_ID )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleGrammar204); 

            	            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:127:1: (lv_idElements= RULE_ID )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:129:6: lv_idElements= RULE_ID
            	    {
            	    lv_idElements=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar225); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "idElements", lv_idElements, "ID", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:147:5: ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:147:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:147:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:147:7: 'extends' (lv_superGrammarIdElements= RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleGrammar250); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:151:1: (lv_superGrammarIdElements= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:153:6: lv_superGrammarIdElements= RULE_ID
                    {
                    lv_superGrammarIdElements=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar271); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "superGrammarIdElements", lv_superGrammarIdElements, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:171:3: ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==13) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:171:4: '.' (lv_superGrammarIdElements= RULE_ID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar293); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:175:1: (lv_superGrammarIdElements= RULE_ID )
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:177:6: lv_superGrammarIdElements= RULE_ID
                    	    {
                    	    lv_superGrammarIdElements=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar314); 
                    	     
                    	        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
                    	        

                    	    	        if (current==null) {
                    	    	            current = factory.create("Grammar");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "superGrammarIdElements", lv_superGrammarIdElements, "ID", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

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

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:195:7: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15||LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:198:6: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar364);
            	    lv_metamodelDeclarations=ruleAbstractMetamodelDeclaration();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "metamodelDeclarations", lv_metamodelDeclarations, "AbstractMetamodelDeclaration", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:216:4: (lv_rules= ruleAbstractRule )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=18 && LA6_0<=19)||LA6_0==27) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:219:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar404);
            	    lv_rules=ruleAbstractRule();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "rules", lv_rules, "AbstractRule", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // $ANTLR end ruleGrammar


    // $ANTLR start entryRuleAbstractRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:246:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:246:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:247:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule444);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule454); 

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
    // $ANTLR end entryRuleAbstractRule


    // $ANTLR start ruleAbstractRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:254:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;

        EObject this_TerminalRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:256:33: ( ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:257:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:257:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=18 && LA8_0<=19)) ) {
                alt8=1;
            }
            else if ( (LA8_0==27) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("257:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:257:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:257:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=18 && LA7_0<=19)) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==RULE_ID) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("257:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:258:5: this_LexerRule= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule502);
                            this_LexerRule=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:268:5: this_ParserRule= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule529);
                            this_ParserRule=ruleParserRule();
                            _fsp--;

                             
                                    current = this_ParserRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:278:5: this_TerminalRule= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule557);
                    this_TerminalRule=ruleTerminalRule();
                    _fsp--;

                     
                            current = this_TerminalRule; 
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
    // $ANTLR end ruleAbstractRule


    // $ANTLR start entryRuleAbstractMetamodelDeclaration
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:295:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:295:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:296:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration591);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration601); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:303:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:305:33: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:306:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:306:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            else if ( (LA9_0==17) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("306:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:307:5: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration648);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:317:5: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration675);
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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:334:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:334:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:335:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel709);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel719); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:342:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:344:33: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:3: ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:3: ( 'generate' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:345:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel755); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:349:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:351:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel776); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:369:3: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:372:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:378:1: ( RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:379:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel812); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
                

            }


            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:384:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:384:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleGeneratedMetamodel827); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:388:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:390:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel848); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("GeneratedMetamodel");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:417:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:417:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:418:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel896);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel906); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:425:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:427:33: ( ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:2: ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:2: ( 'import' ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:428:3: 'import' ( ( RULE_STRING ) )
            {
            match(input,17,FOLLOW_17_in_ruleReferencedMetamodel941); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:432:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:435:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("ReferencedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:441:1: ( RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:442:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel965); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
                

            }


            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:447:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:447:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleReferencedMetamodel980); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:451:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:453:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1001); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ReferencedMetamodel");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:480:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:480:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:481:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1049);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1059); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:488:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:490:33: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:6: ( 'native' | 'lexer' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:6: ( 'native' | 'lexer' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==18) ) {
                alt12=1;
            }
            else if ( (LA12_0==19) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("491:6: ( 'native' | 'lexer' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:491:7: 'native'
                    {
                    match(input,18,FOLLOW_18_in_ruleLexerRule1098); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0" /* xtext::Keyword */, null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:496:6: 'lexer'
                    {
                    match(input,19,FOLLOW_19_in_ruleLexerRule1113); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:500:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:502:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1135); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:520:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:520:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleLexerRule1157); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:524:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:527:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1191);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("LexerRule");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,21,FOLLOW_21_in_ruleLexerRule1207); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:549:2: (lv_body= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:551:6: lv_body= RULE_STRING
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1229); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "body"); 
                

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "body", lv_body, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,22,FOLLOW_22_in_ruleLexerRule1250); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:582:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:582:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:583:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1285);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1295); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:590:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_definesHiddenTokens=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:592:33: ( ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:6: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:593:6: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:595:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1345); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:613:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:613:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleParserRule1366); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:617:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:620:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1400);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:5: ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==23) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:6: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:6: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:7: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )*
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:7: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:8: ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:8: ( (lv_definesHiddenTokens= 'hidden' ) '(' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:9: (lv_definesHiddenTokens= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:638:9: (lv_definesHiddenTokens= 'hidden' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:640:6: lv_definesHiddenTokens= 'hidden'
                    {
                    lv_definesHiddenTokens=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleParserRule1432); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "definesHiddenTokens", true, "hidden", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,24,FOLLOW_24_in_ruleParserRule1453); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:662:2: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:665:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:671:1: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:672:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1478); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                        

                    }


                    }


                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:677:3: ( ',' ( ( RULE_ID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==25) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:677:4: ',' ( ( RULE_ID ) )
                    	    {
                    	    match(input,25,FOLLOW_25_in_ruleParserRule1493); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:681:1: ( ( RULE_ID ) )
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:684:3: ( RULE_ID )
                    	    {

                    	    			if (current==null) {
                    	    	            current = factory.create("ParserRule");
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	            
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:690:1: ( RULE_ID )
                    	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:691:2: RULE_ID
                    	    {
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1517); 
                    	     
                    	        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                    	        

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }

                    match(input,26,FOLLOW_26_in_ruleParserRule1533); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            match(input,21,FOLLOW_21_in_ruleParserRule1545); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:704:2: (lv_alternatives= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:707:6: lv_alternatives= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1580);
            lv_alternatives=ruleAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "alternatives", lv_alternatives, "Alternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,22,FOLLOW_22_in_ruleParserRule1594); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


    // $ANTLR start entryRuleTerminalRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:738:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:738:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:739:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1629);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1639); 

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
    // $ANTLR end entryRuleTerminalRule


    // $ANTLR start ruleTerminalRule
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:746:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal=null;
        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:748:33: ( ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:6: (lv_terminal= 'terminal' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:749:6: (lv_terminal= 'terminal' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:751:6: lv_terminal= 'terminal'
            {
            lv_terminal=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_ruleTerminalRule1689); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "terminal"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", true, "terminal", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:769:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:771:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1722); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:789:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==20) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:789:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleTerminalRule1744); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:793:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:796:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1778);
                    lv_type=ruleTypeRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }
                    break;

            }


            }

            match(input,21,FOLLOW_21_in_ruleTerminalRule1794); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:818:2: (lv_alternatives= ruleTerminalAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:821:6: lv_alternatives= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1829);
            lv_alternatives=ruleTerminalAlternatives();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "alternatives", lv_alternatives, "TerminalAlternatives", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,22,FOLLOW_22_in_ruleTerminalRule1843); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleTerminalRule


    // $ANTLR start entryRuleTypeRef
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:852:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:852:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:853:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1878);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1888); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:860:1: ruleTypeRef returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:862:33: ( ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:2: ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:2: ( ( ( RULE_ID ) ) '::' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==28) ) {
                    alt18=1;
                }
            }
            switch (alt18) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:3: ( ( RULE_ID ) ) '::'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:863:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:866:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("TypeRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:872:1: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:873:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1938); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "metamodel"); 
                        

                    }


                    }

                    match(input,28,FOLLOW_28_in_ruleTypeRef1951); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:882:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:885:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("TypeRef");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:891:1: ( RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:892:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef1977); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.8/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "type"); 
                

            }


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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:906:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:906:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:907:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2016);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2026); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:914:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:916:33: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:917:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:917:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:918:5: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2073);
            this_Group=ruleGroup();
            _fsp--;

             
                    current = this_Group; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:926:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:926:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:926:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:926:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:926:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:927:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleAlternatives2092); 

            	            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:946:2: (lv_groups= ruleGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:949:6: lv_groups= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2127);
            	    lv_groups=ruleGroup();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "groups", lv_groups, "Group", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
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


    // $ANTLR start entryRuleTerminalAlternatives
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:976:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:976:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:977:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2168);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2178); 

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
    // $ANTLR end entryRuleTerminalAlternatives


    // $ANTLR start ruleTerminalAlternatives
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:984:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:986:33: ( (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:987:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:987:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:988:5: this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2225);
            this_TerminalGroup=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:996:1: ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==29) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:996:2: ( () '|' ) (lv_groups= ruleTerminalGroup )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:996:2: ( () '|' )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:996:3: () '|'
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:996:3: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:997:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleTerminalAlternatives2244); 

            	            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1016:2: (lv_groups= ruleTerminalGroup )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1019:6: lv_groups= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2279);
            	    lv_groups=ruleTerminalGroup();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "groups", lv_groups, "TerminalGroup", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1046:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1046:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1047:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2320);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2330); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1054:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1056:33: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1057:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1057:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1058:5: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2377);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1066:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==24||LA21_0==36||LA21_0==42) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1066:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1066:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1067:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1082:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1085:6: lv_abstractTokens= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2420);
            	    lv_abstractTokens=ruleAbstractToken();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "abstractTokens", lv_abstractTokens, "AbstractToken", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
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


    // $ANTLR start entryRuleTerminalGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1112:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1112:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1113:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2461);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2471); 

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
    // $ANTLR end entryRuleTerminalGroup


    // $ANTLR start ruleTerminalGroup
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1120:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1122:33: ( (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1123:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1123:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1124:5: this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2518);
            this_TerminalToken=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1132:1: ( () (lv_abstractTokens= ruleTerminalToken ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_STRING)||LA22_0==13||LA22_0==24||(LA22_0>=39 && LA22_0<=40)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1132:2: () (lv_abstractTokens= ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1132:2: ()
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1133:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1148:2: (lv_abstractTokens= ruleTerminalToken )
            	    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1151:6: lv_abstractTokens= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2561);
            	    lv_abstractTokens=ruleTerminalToken();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("AbstractElement");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "abstractTokens", lv_abstractTokens, "TerminalToken", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleAbstractToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1178:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1178:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1179:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2602);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2612); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1186:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1188:33: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1189:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1189:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1189:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1189:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt24=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA24_1 = input.LA(2);

                if ( ((LA24_1>=33 && LA24_1<=35)) ) {
                    alt24=1;
                }
                else if ( (LA24_1==EOF||(LA24_1>=RULE_ID && LA24_1<=RULE_STRING)||LA24_1==22||LA24_1==24||LA24_1==26||(LA24_1>=29 && LA24_1<=32)||LA24_1==36||LA24_1==42) ) {
                    alt24=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1189:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 24, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt24=1;
                }
                break;
            case RULE_STRING:
            case 24:
            case 42:
                {
                alt24=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1189:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1189:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1189:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RULE_ID) ) {
                        alt23=1;
                    }
                    else if ( (LA23_0==36) ) {
                        alt23=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1189:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 23, 0, input);

                        throw nvae;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1190:5: this_Assignment= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2661);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1200:5: this_Action= ruleAction
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2688);
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
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1210:5: this_AbstractTerminal= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2716);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1218:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=30 && LA27_0<=32)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:21: ( ( '?' | '*' ) | '+' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( ((LA26_0>=30 && LA26_0<=31)) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==32) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1220:21: ( ( '?' | '*' ) | '+' )", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:22: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:22: ( '?' | '*' )
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==30) ) {
                                alt25=1;
                            }
                            else if ( (LA25_0==31) ) {
                                alt25=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1220:22: ( '?' | '*' )", 25, 0, input);

                                throw nvae;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1220:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2739); 

                                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1225:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleAbstractToken2754); 

                                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1230:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleAbstractToken2770); 

                                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "cardinality", input.LT(-1), null, currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // $ANTLR end ruleAbstractToken


    // $ANTLR start entryRuleTerminalToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1257:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1257:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1258:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2819);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2829); 

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
    // $ANTLR end entryRuleTerminalToken


    // $ANTLR start ruleTerminalToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1265:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_TerminalTokenElement = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1267:33: ( (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1268:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1268:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1269:5: this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2876);
            this_TerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1277:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=30 && LA30_0<=32)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1279:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1279:21: ( ( '?' | '*' ) | '+' )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( ((LA29_0>=30 && LA29_0<=31)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==32) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1279:21: ( ( '?' | '*' ) | '+' )", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1279:22: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1279:22: ( '?' | '*' )
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==30) ) {
                                alt28=1;
                            }
                            else if ( (LA28_0==31) ) {
                                alt28=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1279:22: ( '?' | '*' )", 28, 0, input);

                                throw nvae;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1279:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken2898); 

                                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1284:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleTerminalToken2913); 

                                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1289:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleTerminalToken2929); 

                                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "cardinality", input.LT(-1), null, currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
    // $ANTLR end ruleTerminalToken


    // $ANTLR start entryRuleAssignment
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1316:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1316:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1317:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment2978);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment2988); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1324:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1326:33: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1327:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1327:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1327:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1327:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1327:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1327:3: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1329:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3035); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1347:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1349:6: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1349:18: ( ( '+=' | '=' ) | '?=' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=33 && LA32_0<=34)) ) {
                alt32=1;
            }
            else if ( (LA32_0==35) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1349:18: ( ( '+=' | '=' ) | '?=' )", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1349:19: ( '+=' | '=' )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1349:19: ( '+=' | '=' )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==33) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==34) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1349:19: ( '+=' | '=' )", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1349:20: '+='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3069); 

                                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1354:6: '='
                            {
                            match(input,34,FOLLOW_34_in_ruleAssignment3084); 

                                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1359:6: '?='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignment3100); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "operator", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1377:3: (lv_terminal= ruleAbstractTerminal )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1380:6: lv_terminal= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.15/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3148);
            lv_terminal=ruleAbstractTerminal();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", lv_terminal, "AbstractTerminal", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1407:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1407:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1408:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3187);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3197); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1415:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1417:33: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:7: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1418:8: '{' ( 'current' '=' )?
            {
            match(input,36,FOLLOW_36_in_ruleAction3237); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1422:1: ( 'current' '=' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==37) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1422:2: 'current' '='
                    {
                    match(input,37,FOLLOW_37_in_ruleAction3247); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,34,FOLLOW_34_in_ruleAction3256); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1430:4: (lv_typeName= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1433:6: lv_typeName= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3293);
            lv_typeName=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "typeName", lv_typeName, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleAction3307); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1455:2: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1457:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3329); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "feature"); 
                

            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1475:3: (lv_operator= ( '=' | '+=' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1477:6: lv_operator= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1477:18: ( '=' | '+=' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==34) ) {
                alt34=1;
            }
            else if ( (LA34_0==33) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1477:18: ( '=' | '+=' )", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1477:19: '='
                    {
                    match(input,34,FOLLOW_34_in_ruleAction3363); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1482:6: '+='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3378); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "operator", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,37,FOLLOW_37_in_ruleAction3401); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,38,FOLLOW_38_in_ruleAction3411); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.16/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1517:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1517:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1518:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3446);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3456); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1525:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;

        EObject this_CrossReference = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1527:33: ( ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1528:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1528:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=RULE_ID && LA37_0<=RULE_STRING)||LA37_0==24) ) {
                alt37=1;
            }
            else if ( (LA37_0==42) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1528:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1528:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1528:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_STRING)) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==24) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1528:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1528:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1528:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            int alt35=2;
                            int LA35_0 = input.LA(1);

                            if ( (LA35_0==RULE_STRING) ) {
                                alt35=1;
                            }
                            else if ( (LA35_0==RULE_ID) ) {
                                alt35=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1528:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 35, 0, input);

                                throw nvae;
                            }
                            switch (alt35) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1529:5: this_Keyword= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3505);
                                    this_Keyword=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1539:5: this_RuleCall= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3532);
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
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1549:5: this_ParenthesizedElement= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3560);
                            this_ParenthesizedElement=ruleParenthesizedElement();
                            _fsp--;

                             
                                    current = this_ParenthesizedElement; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1559:5: this_CrossReference= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.17/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3588);
                    this_CrossReference=ruleCrossReference();
                    _fsp--;

                     
                            current = this_CrossReference; 
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


    // $ANTLR start entryRuleTerminalTokenElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1576:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1576:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1577:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.18" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3622);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3632); 

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
    // $ANTLR end entryRuleTerminalTokenElement


    // $ANTLR start ruleTerminalTokenElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1584:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedTerminalElement = null;

        EObject this_AbstractNegatedToken = null;

        EObject this_Wildcard = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1586:33: ( ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==24||(LA41_0>=39 && LA41_0<=40)) ) {
                alt41=1;
            }
            else if ( (LA41_0==13) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1587:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==24) ) {
                        alt40=1;
                    }
                    else if ( ((LA40_0>=39 && LA40_0<=40)) ) {
                        alt40=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1587:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            {
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            int alt39=2;
                            int LA39_0 = input.LA(1);

                            if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)) ) {
                                alt39=1;
                            }
                            else if ( (LA39_0==24) ) {
                                alt39=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1587:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )", 39, 0, input);

                                throw nvae;
                            }
                            switch (alt39) {
                                case 1 :
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    {
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1587:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    int alt38=2;
                                    int LA38_0 = input.LA(1);

                                    if ( (LA38_0==RULE_STRING) ) {
                                        alt38=1;
                                    }
                                    else if ( (LA38_0==RULE_ID) ) {
                                        alt38=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1587:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )", 38, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt38) {
                                        case 1 :
                                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1588:5: this_CharacterRange= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3682);
                                            this_CharacterRange=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1598:5: this_RuleCall= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3709);
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
                                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1608:5: this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3737);
                                    this_ParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
                                    _fsp--;

                                     
                                            current = this_ParenthesizedTerminalElement; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1618:5: this_AbstractNegatedToken= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.18/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3765);
                            this_AbstractNegatedToken=ruleAbstractNegatedToken();
                            _fsp--;

                             
                                    current = this_AbstractNegatedToken; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1628:5: this_Wildcard= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.18/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3793);
                    this_Wildcard=ruleWildcard();
                    _fsp--;

                     
                            current = this_Wildcard; 
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
    // $ANTLR end ruleTerminalTokenElement


    // $ANTLR start entryRuleAbstractNegatedToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1645:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1645:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1646:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.19" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3827);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3837); 

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
    // $ANTLR end entryRuleAbstractNegatedToken


    // $ANTLR start ruleAbstractNegatedToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1653:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken = null;

        EObject this_UpToToken = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1655:33: ( (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1656:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1656:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==39) ) {
                alt42=1;
            }
            else if ( (LA42_0==40) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1656:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1657:5: this_NegatedToken= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.19/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3884);
                    this_NegatedToken=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1667:5: this_UpToToken= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.19/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken3911);
                    this_UpToToken=ruleUpToToken();
                    _fsp--;

                     
                            current = this_UpToToken; 
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
    // $ANTLR end ruleAbstractNegatedToken


    // $ANTLR start entryRuleNegatedToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1684:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1684:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1685:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.20" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken3945);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken3955); 

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
    // $ANTLR end entryRuleNegatedToken


    // $ANTLR start ruleNegatedToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1692:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1694:33: ( ( '!' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1695:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1695:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1695:2: '!' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleNegatedToken3989); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.20/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1699:1: (lv_terminal= ruleTerminalTokenElement )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1702:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.20/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4023);
            lv_terminal=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("NegatedToken");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", lv_terminal, "TerminalTokenElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleNegatedToken


    // $ANTLR start entryRuleUpToToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1729:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1729:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1730:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.21" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4062);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4072); 

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
    // $ANTLR end entryRuleUpToToken


    // $ANTLR start ruleUpToToken
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1737:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1739:33: ( ( '->' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1740:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1740:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1740:2: '->' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,40,FOLLOW_40_in_ruleUpToToken4106); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.21/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1744:1: (lv_terminal= ruleTerminalTokenElement )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1747:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.21/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4140);
            lv_terminal=ruleTerminalTokenElement();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("UpToToken");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "terminal", lv_terminal, "TerminalTokenElement", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleUpToToken


    // $ANTLR start entryRuleWildcard
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1774:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1774:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1775:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.22" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4179);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4189); 

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
    // $ANTLR end entryRuleWildcard


    // $ANTLR start ruleWildcard
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1782:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1784:33: ( (lv_isWildcard= '.' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1785:1: (lv_isWildcard= '.' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1785:1: (lv_isWildcard= '.' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1787:6: lv_isWildcard= '.'
            {
            lv_isWildcard=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_ruleWildcard4234); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.22/@alternatives/@terminal" /* xtext::Keyword */, "isWildcard"); 
                

            	        if (current==null) {
            	            current = factory.create("Wildcard");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "isWildcard", true, ".", currentNode);
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
    // $ANTLR end ruleWildcard


    // $ANTLR start entryRuleCharacterRange
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1814:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1814:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1815:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.23" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4280);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4290); 

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
    // $ANTLR end entryRuleCharacterRange


    // $ANTLR start ruleCharacterRange
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1822:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject lv_right = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1824:33: ( (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1825:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1825:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1826:5: this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.23/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4337);
            this_Keyword=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:1: ( ( () '..' ) (lv_right= ruleKeyword ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==41) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:2: ( () '..' ) (lv_right= ruleKeyword )
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:2: ( () '..' )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:3: () '..'
                    {
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1834:3: ()
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1835:5: 
                    {
                     
                            temp=factory.create("CharacterRange");
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,41,FOLLOW_41_in_ruleCharacterRange4356); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1854:2: (lv_right= ruleKeyword )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1857:6: lv_right= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4391);
                    lv_right=ruleKeyword();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create("AbstractElement");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "right", lv_right, "Keyword", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleCharacterRange


    // $ANTLR start entryRuleCrossReference
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1884:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1884:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1885:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.24" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4432);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4442); 

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
    // $ANTLR end entryRuleCrossReference


    // $ANTLR start ruleCrossReference
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1892:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1894:33: ( ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:3: ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:3: ( '[' (lv_type= ruleTypeRef ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1895:4: '[' (lv_type= ruleTypeRef )
            {
            match(input,42,FOLLOW_42_in_ruleCrossReference4478); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1899:1: (lv_type= ruleTypeRef )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1902:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4512);
            lv_type=ruleTypeRef();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("CrossReference");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "type", lv_type, "TypeRef", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1920:3: ( '|' ( ( RULE_ID ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==29) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1920:4: '|' ( ( RULE_ID ) )
                    {
                    match(input,29,FOLLOW_29_in_ruleCrossReference4527); 

                            createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1924:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1927:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("CrossReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1933:1: ( RULE_ID )
                    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1934:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4551); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "rule"); 
                        

                    }


                    }


                    }
                    break;

            }


            }

            match(input,43,FOLLOW_43_in_ruleCrossReference4567); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.24/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleCrossReference


    // $ANTLR start entryRuleParenthesizedElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1952:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1952:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1953:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.25" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4602);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4612); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1960:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1962:33: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1963:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1963:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1963:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1963:2: ( '(' this_Alternatives= ruleAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1963:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,24,FOLLOW_24_in_ruleParenthesizedElement4647); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4669);
            this_Alternatives=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,26,FOLLOW_26_in_ruleParenthesizedElement4678); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.25/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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


    // $ANTLR start entryRuleParenthesizedTerminalElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1989:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1989:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1990:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.26" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4713);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4723); 

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
    // $ANTLR end entryRuleParenthesizedTerminalElement


    // $ANTLR start ruleParenthesizedTerminalElement
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1997:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:1999:33: ( ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2000:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2000:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2000:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')'
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2000:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2000:3: '(' this_TerminalAlternatives= ruleTerminalAlternatives
            {
            match(input,24,FOLLOW_24_in_ruleParenthesizedTerminalElement4758); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4780);
            this_TerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,26,FOLLOW_26_in_ruleParenthesizedTerminalElement4789); 

                    createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.26/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleParenthesizedTerminalElement


    // $ANTLR start entryRuleKeyword
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2026:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2026:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2027:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.27" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4824);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4834); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2034:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2036:33: ( (lv_value= RULE_STRING ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2037:1: (lv_value= RULE_STRING )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2037:1: (lv_value= RULE_STRING )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2039:6: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4879); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.27/@alternatives/@terminal" /* xtext::RuleCall */, "value"); 
                

            	        if (current==null) {
            	            current = factory.create("Keyword");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "STRING", currentNode);
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
    // $ANTLR end ruleKeyword


    // $ANTLR start entryRuleRuleCall
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2066:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2066:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2067:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.28" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall4924);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall4934); 

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
    // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2074:1: ruleRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2076:33: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2077:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2077:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2080:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("RuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2086:1: ( RULE_ID )
            // ../org.eclipse.xtext/src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtext.g:2087:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall4982); 
             
                createLeafNode("classpath:/org/eclipse/xtext/Xtext.xmi#//@rules.28/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
                

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
    // $ANTLR end ruleRuleCall


 

    public static final BitSet FOLLOW_ruleGrammar_in_entryRuleGrammar72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGrammar82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleGrammar133 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar182 = new BitSet(new long[]{0x00000000080EE010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar225 = new BitSet(new long[]{0x00000000080EE010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar250 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar271 = new BitSet(new long[]{0x00000000080EA010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar314 = new BitSet(new long[]{0x00000000080EA010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar364 = new BitSet(new long[]{0x00000000080E8010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar404 = new BitSet(new long[]{0x00000000080C0012L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedMetamodel755 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel776 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel812 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleGeneratedMetamodel827 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleReferencedMetamodel941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel965 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleLexerRule1098 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_19_in_ruleLexerRule1113 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1135 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleLexerRule1157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1191 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleLexerRule1207 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1229 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1285 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1345 = new BitSet(new long[]{0x0000000000B00000L});
    public static final BitSet FOLLOW_20_in_ruleParserRule1366 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1400 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1432 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1478 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1493 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1517 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_26_in_ruleParserRule1533 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule1545 = new BitSet(new long[]{0x0000041001000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1580 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParserRule1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalRule1689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1722 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleTerminalRule1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1778 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTerminalRule1794 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1829 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTerminalRule1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1878 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1938 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef1951 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef1977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2016 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2073 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAlternatives2092 = new BitSet(new long[]{0x0000041001000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2127 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2225 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives2244 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2279 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2377 = new BitSet(new long[]{0x0000041001000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2420 = new BitSet(new long[]{0x0000041001000032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2518 = new BitSet(new long[]{0x0000018001002032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2561 = new BitSet(new long[]{0x0000018001002032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2661 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2688 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2716 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAbstractToken2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2876 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken2898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTerminalToken2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment2978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3035 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3069 = new BitSet(new long[]{0x0000040001000030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3084 = new BitSet(new long[]{0x0000040001000030L});
    public static final BitSet FOLLOW_35_in_ruleAssignment3100 = new BitSet(new long[]{0x0000040001000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAction3237 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_37_in_ruleAction3247 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3256 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3293 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAction3307 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3329 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3363 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3378 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3401 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAction3411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken3911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken3945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken3955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNegatedToken3989 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4062 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUpToToken4106 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleWildcard4234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4337 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleCharacterRange4356 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4478 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4512 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleCrossReference4527 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4551 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCrossReference4567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesizedElement4647 = new BitSet(new long[]{0x0000041001000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4669 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedElement4678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesizedTerminalElement4758 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4780 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedTerminalElement4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4824 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall4924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall4934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall4982 = new BitSet(new long[]{0x0000000000000002L});

}
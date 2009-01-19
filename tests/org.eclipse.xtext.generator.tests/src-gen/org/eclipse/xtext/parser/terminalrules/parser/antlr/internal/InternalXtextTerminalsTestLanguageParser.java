// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g 2009-01-19 15:14:14

package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

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

public class InternalXtextTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
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

        public InternalXtextTerminalsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g"; }


     
        public InternalXtextTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalXtextTerminalsTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:67:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:67:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:68:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:75:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract=null;
        Token lv_idElements=null;
        Token lv_superGrammarIdElements=null;
        EObject lv_metamodelDeclarations = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:77:33: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:1: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:1: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:2: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:2: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:3: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:3: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:4: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:4: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:5: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )*
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:5: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:6: ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:6: ( (lv_abstract= 'abstract language' ) | 'language' )
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:7: (lv_abstract= 'abstract language' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:78:7: (lv_abstract= 'abstract language' )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:80:6: lv_abstract= 'abstract language'
                    {
                    lv_abstract=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleGrammar133); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "abstract"); 
                        

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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:99:6: 'language'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar160); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:103:2: (lv_idElements= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:106:6: lv_idElements= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_idElements=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar195); 

            	        if (current==null) {
            	            current = factory.create("Grammar");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "idElements", lv_idElements, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:124:3: ( '.' (lv_idElements= RULE_ID ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:124:4: '.' (lv_idElements= RULE_ID )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleGrammar210); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:128:1: (lv_idElements= RULE_ID )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:131:6: lv_idElements= RULE_ID
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    lv_idElements=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar244); 

            	    	        if (current==null) {
            	    	            current = factory.create("Grammar");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "idElements", lv_idElements, "ID", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:149:5: ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:149:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:149:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:149:7: 'extends' (lv_superGrammarIdElements= RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleGrammar262); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:153:1: (lv_superGrammarIdElements= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:156:6: lv_superGrammarIdElements= RULE_ID
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    lv_superGrammarIdElements=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar296); 

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.add(current, "superGrammarIdElements", lv_superGrammarIdElements, "ID", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:174:3: ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==13) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:174:4: '.' (lv_superGrammarIdElements= RULE_ID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar311); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:178:1: (lv_superGrammarIdElements= RULE_ID )
                    	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:181:6: lv_superGrammarIdElements= RULE_ID
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    lv_superGrammarIdElements=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar345); 

                    	    	        if (current==null) {
                    	    	            current = factory.create("Grammar");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "superGrammarIdElements", lv_superGrammarIdElements, "ID", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:199:7: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15||LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:202:6: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar388);
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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:220:4: (lv_rules= ruleAbstractRule )+
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
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:223:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar428);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:250:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:250:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:251:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule468);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule478); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:258:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;

        EObject this_TerminalRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:260:33: ( ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:261:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:261:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
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
                    new NoViableAltException("261:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:261:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:261:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
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
                            new NoViableAltException("261:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:262:5: this_LexerRule= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule526);
                            this_LexerRule=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:272:5: this_ParserRule= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule553);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:282:5: this_TerminalRule= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule581);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:299:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:299:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:300:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration615);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration625); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:307:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:309:33: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:310:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:310:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
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
                    new NoViableAltException("310:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:311:5: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration672);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:321:5: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration699);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:338:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:338:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:339:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel733);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel743); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:346:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:348:33: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:3: ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:3: ( 'generate' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:349:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,15,FOLLOW_15_in_ruleGeneratedMetamodel779); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:353:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:356:6: lv_name= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel813); 

            	        if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:374:3: ( ( RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:377:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:383:1: ( RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:384:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel842); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:389:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:389:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleGeneratedMetamodel857); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:393:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:396:6: lv_alias= RULE_ID
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel891); 

                    	        if (current==null) {
                    	            current = factory.create("GeneratedMetamodel");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
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
    // $ANTLR end ruleGeneratedMetamodel


    // $ANTLR start entryRuleReferencedMetamodel
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:423:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:423:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:424:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel932);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel942); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:431:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:433:33: ( ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:434:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:434:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:434:2: ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:434:2: ( 'import' ( ( RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:434:3: 'import' ( ( RULE_STRING ) )
            {
            match(input,17,FOLLOW_17_in_ruleReferencedMetamodel977); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:438:1: ( ( RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:441:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("ReferencedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:447:1: ( RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:448:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1001); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:453:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:453:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,16,FOLLOW_16_in_ruleReferencedMetamodel1016); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:457:1: (lv_alias= RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:460:6: lv_alias= RULE_ID
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1050); 

                    	        if (current==null) {
                    	            current = factory.create("ReferencedMetamodel");
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "alias", lv_alias, "ID", currentNode);
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
    // $ANTLR end ruleReferencedMetamodel


    // $ANTLR start entryRuleLexerRule
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:487:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:487:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:488:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1091);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1101); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:495:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:497:33: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:6: ( 'native' | 'lexer' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:6: ( 'native' | 'lexer' )
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
                    new NoViableAltException("498:6: ( 'native' | 'lexer' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:498:7: 'native'
                    {
                    match(input,18,FOLLOW_18_in_ruleLexerRule1140); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0" /* xtext::Keyword */, null); 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:503:6: 'lexer'
                    {
                    match(input,19,FOLLOW_19_in_ruleLexerRule1155); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:507:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:510:6: lv_name= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1190); 

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:528:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:528:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleLexerRule1205); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:532:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:535:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1239);
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

            match(input,21,FOLLOW_21_in_ruleLexerRule1255); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:557:2: (lv_body= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:560:6: lv_body= RULE_STRING
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_body=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1290); 

            	        if (current==null) {
            	            current = factory.create("LexerRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "body", lv_body, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,22,FOLLOW_22_in_ruleLexerRule1304); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:591:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:591:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:592:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1339);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1349); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:599:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_definesHiddenTokens=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:601:33: ( ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:6: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:602:6: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:605:6: lv_name= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1412); 

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:623:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:623:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleParserRule1426); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:627:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:630:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1460);
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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:5: ( ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:6: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) ) ')'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:6: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:7: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:7: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:8: ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( RULE_ID ) )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:8: ( (lv_definesHiddenTokens= 'hidden' ) '(' )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:9: (lv_definesHiddenTokens= 'hidden' ) '('
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:648:9: (lv_definesHiddenTokens= 'hidden' )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:650:6: lv_definesHiddenTokens= 'hidden'
                    {
                    lv_definesHiddenTokens=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleParserRule1492); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "definesHiddenTokens"); 
                        

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

                    match(input,24,FOLLOW_24_in_ruleParserRule1513); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:672:2: ( ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:675:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:681:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:682:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1538); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                        

                    }


                    }


                    }

                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:687:3: ( ',' ( ( RULE_ID ) ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:687:4: ',' ( ( RULE_ID ) )
                    {
                    match(input,25,FOLLOW_25_in_ruleParserRule1553); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:691:1: ( ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:694:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("ParserRule");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:700:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:701:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1577); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                        

                    }


                    }


                    }


                    }

                    match(input,26,FOLLOW_26_in_ruleParserRule1592); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            match(input,21,FOLLOW_21_in_ruleParserRule1604); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:714:2: (lv_alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:717:6: lv_alternatives= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1639);
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

            match(input,22,FOLLOW_22_in_ruleParserRule1653); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:748:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:748:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:749:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1688);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1698); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:756:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal=null;
        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:758:33: ( ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:6: (lv_terminal= 'terminal' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:759:6: (lv_terminal= 'terminal' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:761:6: lv_terminal= 'terminal'
            {
            lv_terminal=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_ruleTerminalRule1748); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "terminal"); 
                

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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:779:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:782:6: lv_name= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1794); 

            	        if (current==null) {
            	            current = factory.create("ParserRule");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:800:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:800:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,20,FOLLOW_20_in_ruleTerminalRule1809); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:804:1: (lv_type= ruleTypeRef )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:807:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1843);
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

            match(input,21,FOLLOW_21_in_ruleTerminalRule1859); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:829:2: (lv_alternatives= ruleTerminalAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:832:6: lv_alternatives= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1894);
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

            match(input,22,FOLLOW_22_in_ruleTerminalRule1908); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:863:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:863:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:864:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef1943);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef1953); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:871:1: ruleTypeRef returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:873:33: ( ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:874:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:874:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:874:2: ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:874:2: ( ( ( RULE_ID ) ) '::' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==28) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:874:3: ( ( RULE_ID ) ) '::'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:874:3: ( ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:877:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("TypeRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:883:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:884:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2003); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "metamodel"); 
                        

                    }


                    }

                    match(input,28,FOLLOW_28_in_ruleTypeRef2016); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:893:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:896:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("TypeRef");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:902:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:903:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2042); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "type"); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:917:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:917:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:918:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2081);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2091); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:925:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:927:33: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:928:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:928:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:929:5: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2138);
            this_Group=ruleGroup();
            _fsp--;

             
                    current = this_Group; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:2: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:3: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:937:3: ()
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:938:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleAlternatives2157); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:957:2: (lv_groups= ruleGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:960:6: lv_groups= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2192);
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
            	    break loop18;
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:987:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:987:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:988:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2233);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2243); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:995:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:997:33: ( (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:998:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:998:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:999:5: this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2290);
            this_TerminalGroup=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1007:1: ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==29) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1007:2: ( () '|' ) (lv_groups= ruleTerminalGroup )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1007:2: ( () '|' )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1007:3: () '|'
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1007:3: ()
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1008:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleTerminalAlternatives2309); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1027:2: (lv_groups= ruleTerminalGroup )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1030:6: lv_groups= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2344);
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
    // $ANTLR end ruleTerminalAlternatives


    // $ANTLR start entryRuleGroup
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1057:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1057:47: (iv_ruleGroup= ruleGroup EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1058:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2385);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2395); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1065:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1067:33: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1068:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1068:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1069:5: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2442);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1077:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=RULE_ID && LA20_0<=RULE_STRING)||LA20_0==24||LA20_0==36||LA20_0==42) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1077:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1077:2: ()
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1078:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1093:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1096:6: lv_abstractTokens= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2485);
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
    // $ANTLR end ruleGroup


    // $ANTLR start entryRuleTerminalGroup
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1123:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1123:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1124:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2526);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2536); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1131:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1133:33: ( (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1134:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1134:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1135:5: this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2583);
            this_TerminalToken=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1143:1: ( () (lv_abstractTokens= ruleTerminalToken ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||LA21_0==13||LA21_0==24||(LA21_0>=39 && LA21_0<=40)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1143:2: () (lv_abstractTokens= ruleTerminalToken )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1143:2: ()
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1144:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1159:2: (lv_abstractTokens= ruleTerminalToken )
            	    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1162:6: lv_abstractTokens= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2626);
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
    // $ANTLR end ruleTerminalGroup


    // $ANTLR start entryRuleAbstractToken
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1189:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1189:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1190:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2667);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2677); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1197:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1199:33: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1200:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1200:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1200:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1200:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt23=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==EOF||(LA23_1>=RULE_ID && LA23_1<=RULE_STRING)||LA23_1==22||LA23_1==24||LA23_1==26||(LA23_1>=29 && LA23_1<=32)||LA23_1==36||LA23_1==42) ) {
                    alt23=2;
                }
                else if ( ((LA23_1>=33 && LA23_1<=35)) ) {
                    alt23=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1200:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 23, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt23=1;
                }
                break;
            case RULE_STRING:
            case 24:
            case 42:
                {
                alt23=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1200:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1200:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1200:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==RULE_ID) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==36) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1200:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1201:5: this_Assignment= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2726);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1211:5: this_Action= ruleAction
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2753);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1221:5: this_AbstractTerminal= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2781);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1229:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=30 && LA26_0<=32)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1231:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1231:21: ( ( '?' | '*' ) | '+' )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0>=30 && LA25_0<=31)) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==32) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1231:21: ( ( '?' | '*' ) | '+' )", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1231:22: ( '?' | '*' )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1231:22: ( '?' | '*' )
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==30) ) {
                                alt24=1;
                            }
                            else if ( (LA24_0==31) ) {
                                alt24=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1231:22: ( '?' | '*' )", 24, 0, input);

                                throw nvae;
                            }
                            switch (alt24) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1231:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2804); 

                                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1236:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleAbstractToken2819); 

                                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1241:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleAbstractToken2835); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1268:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1268:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1269:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2884);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2894); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1276:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_TerminalTokenElement = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1278:33: ( (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1279:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1279:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1280:5: this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2941);
            this_TerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1288:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=30 && LA29_0<=32)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1290:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1290:21: ( ( '?' | '*' ) | '+' )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( ((LA28_0>=30 && LA28_0<=31)) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==32) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1290:21: ( ( '?' | '*' ) | '+' )", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1290:22: ( '?' | '*' )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1290:22: ( '?' | '*' )
                            int alt27=2;
                            int LA27_0 = input.LA(1);

                            if ( (LA27_0==30) ) {
                                alt27=1;
                            }
                            else if ( (LA27_0==31) ) {
                                alt27=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1290:22: ( '?' | '*' )", 27, 0, input);

                                throw nvae;
                            }
                            switch (alt27) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1290:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken2963); 

                                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1295:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleTerminalToken2978); 

                                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1300:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleTerminalToken2994); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1327:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1327:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1328:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment3043);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment3053); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1335:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1337:33: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1338:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1338:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1338:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1338:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1338:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1338:3: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1341:6: lv_feature= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3113); 

            	        if (current==null) {
            	            current = factory.create("Assignment");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1359:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1361:6: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1361:18: ( ( '+=' | '=' ) | '?=' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=33 && LA31_0<=34)) ) {
                alt31=1;
            }
            else if ( (LA31_0==35) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1361:18: ( ( '+=' | '=' ) | '?=' )", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1361:19: ( '+=' | '=' )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1361:19: ( '+=' | '=' )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==33) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==34) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1361:19: ( '+=' | '=' )", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1361:20: '+='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3140); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1366:6: '='
                            {
                            match(input,34,FOLLOW_34_in_ruleAssignment3155); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1371:6: '?='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignment3171); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1389:3: (lv_terminal= ruleAbstractTerminal )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1392:6: lv_terminal= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.15/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3219);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1419:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1419:48: (iv_ruleAction= ruleAction EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1420:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3258);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3268); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1427:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1429:33: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:7: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:7: ( '{' ( 'current' '=' )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1430:8: '{' ( 'current' '=' )?
            {
            match(input,36,FOLLOW_36_in_ruleAction3308); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1434:1: ( 'current' '=' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1434:2: 'current' '='
                    {
                    match(input,37,FOLLOW_37_in_ruleAction3318); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,34,FOLLOW_34_in_ruleAction3327); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1442:4: (lv_typeName= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1445:6: lv_typeName= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3364);
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

            match(input,13,FOLLOW_13_in_ruleAction3378); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1467:2: (lv_feature= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1470:6: lv_feature= RULE_ID
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3413); 

            	        if (current==null) {
            	            current = factory.create("Action");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "feature", lv_feature, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1488:3: (lv_operator= ( '=' | '+=' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1490:6: lv_operator= ( '=' | '+=' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1490:18: ( '=' | '+=' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            else if ( (LA33_0==33) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1490:18: ( '=' | '+=' )", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1490:19: '='
                    {
                    match(input,34,FOLLOW_34_in_ruleAction3440); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1495:6: '+='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3455); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

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

            match(input,37,FOLLOW_37_in_ruleAction3478); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,38,FOLLOW_38_in_ruleAction3488); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.16/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1530:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1530:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1531:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3523);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3533); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1538:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;

        EObject this_CrossReference = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1540:33: ( ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1541:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1541:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=RULE_ID && LA36_0<=RULE_STRING)||LA36_0==24) ) {
                alt36=1;
            }
            else if ( (LA36_0==42) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1541:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1541:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1541:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_STRING)) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==24) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1541:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1541:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1541:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==RULE_STRING) ) {
                                alt34=1;
                            }
                            else if ( (LA34_0==RULE_ID) ) {
                                alt34=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1541:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 34, 0, input);

                                throw nvae;
                            }
                            switch (alt34) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1542:5: this_Keyword= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3582);
                                    this_Keyword=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1552:5: this_RuleCall= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3609);
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
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1562:5: this_ParenthesizedElement= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3637);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1572:5: this_CrossReference= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.17/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3665);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1589:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1589:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1590:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3699);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3709); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1597:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedTerminalElement = null;

        EObject this_AbstractNegatedToken = null;

        EObject this_Wildcard = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1599:33: ( ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)||LA40_0==24||(LA40_0>=39 && LA40_0<=40)) ) {
                alt40=1;
            }
            else if ( (LA40_0==13) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1600:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=RULE_ID && LA39_0<=RULE_STRING)||LA39_0==24) ) {
                        alt39=1;
                    }
                    else if ( ((LA39_0>=39 && LA39_0<=40)) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1600:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            {
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            int alt38=2;
                            int LA38_0 = input.LA(1);

                            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_STRING)) ) {
                                alt38=1;
                            }
                            else if ( (LA38_0==24) ) {
                                alt38=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1600:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )", 38, 0, input);

                                throw nvae;
                            }
                            switch (alt38) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    {
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1600:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    int alt37=2;
                                    int LA37_0 = input.LA(1);

                                    if ( (LA37_0==RULE_STRING) ) {
                                        alt37=1;
                                    }
                                    else if ( (LA37_0==RULE_ID) ) {
                                        alt37=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1600:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )", 37, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt37) {
                                        case 1 :
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1601:5: this_CharacterRange= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3759);
                                            this_CharacterRange=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1611:5: this_RuleCall= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3786);
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
                                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1621:5: this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3814);
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
                            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1631:5: this_AbstractNegatedToken= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3842);
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
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1641:5: this_Wildcard= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.18/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3870);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1658:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1658:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1659:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.19" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3904);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3914); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1666:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken = null;

        EObject this_UpToToken = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1668:33: ( (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1669:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1669:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==39) ) {
                alt41=1;
            }
            else if ( (LA41_0==40) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1669:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1670:5: this_NegatedToken= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.19/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3961);
                    this_NegatedToken=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1680:5: this_UpToToken= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.19/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken3988);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1697:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1697:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1698:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.20" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4022);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4032); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1705:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1707:33: ( ( '!' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1708:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1708:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1708:2: '!' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleNegatedToken4066); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1712:1: (lv_terminal= ruleTerminalTokenElement )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1715:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.20/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4100);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1742:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1742:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1743:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.21" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4139);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4149); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1750:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1752:33: ( ( '->' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1753:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1753:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1753:2: '->' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,40,FOLLOW_40_in_ruleUpToToken4183); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.21/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1757:1: (lv_terminal= ruleTerminalTokenElement )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1760:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.21/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4217);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1787:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1787:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1788:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.22" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4256);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4266); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1795:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1797:33: ( (lv_isWildcard= '.' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1798:1: (lv_isWildcard= '.' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1798:1: (lv_isWildcard= '.' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1800:6: lv_isWildcard= '.'
            {
            lv_isWildcard=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_ruleWildcard4311); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.22/@alternatives/@terminal" /* xtext::Keyword */, "isWildcard"); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1827:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1827:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1828:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4357);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4367); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1835:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject lv_right = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1837:33: ( (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1838:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1838:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1839:5: this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4414);
            this_Keyword=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1847:1: ( ( () '..' ) (lv_right= ruleKeyword ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==41) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1847:2: ( () '..' ) (lv_right= ruleKeyword )
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1847:2: ( () '..' )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1847:3: () '..'
                    {
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1847:3: ()
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1848:5: 
                    {
                     
                            temp=factory.create("CharacterRange");
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,41,FOLLOW_41_in_ruleCharacterRange4433); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1867:2: (lv_right= ruleKeyword )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1870:6: lv_right= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4468);
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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1897:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1897:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1898:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4509);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4519); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1905:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1907:33: ( ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:3: ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )?
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:3: ( '[' (lv_type= ruleTypeRef ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1908:4: '[' (lv_type= ruleTypeRef )
            {
            match(input,42,FOLLOW_42_in_ruleCrossReference4555); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1912:1: (lv_type= ruleTypeRef )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1915:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4589);
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

            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1933:3: ( '|' ( ( RULE_ID ) ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==29) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1933:4: '|' ( ( RULE_ID ) )
                    {
                    match(input,29,FOLLOW_29_in_ruleCrossReference4604); 

                            createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1937:1: ( ( RULE_ID ) )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1940:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("CrossReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1946:1: ( RULE_ID )
                    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1947:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4628); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "rule"); 
                        

                    }


                    }


                    }
                    break;

            }


            }

            match(input,43,FOLLOW_43_in_ruleCrossReference4644); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.24/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1965:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1965:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1966:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4679);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4689); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1973:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1975:33: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1976:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1976:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1976:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1976:2: ( '(' this_Alternatives= ruleAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:1976:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,24,FOLLOW_24_in_ruleParenthesizedElement4724); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4746);
            this_Alternatives=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,26,FOLLOW_26_in_ruleParenthesizedElement4755); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.25/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2002:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2002:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2003:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4790);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4800); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2010:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2012:33: ( ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2013:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2013:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2013:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2013:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2013:3: '(' this_TerminalAlternatives= ruleTerminalAlternatives
            {
            match(input,24,FOLLOW_24_in_ruleParenthesizedTerminalElement4835); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4857);
            this_TerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,26,FOLLOW_26_in_ruleParenthesizedTerminalElement4866); 

                    createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.26/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2039:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2039:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2040:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.27" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4901);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4911); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2047:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2049:33: ( (lv_value= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2050:1: (lv_value= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2050:1: (lv_value= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2053:6: lv_value= RULE_STRING
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.27/@alternatives/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword4969); 

            	        if (current==null) {
            	            current = factory.create("Keyword");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "STRING", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2080:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2080:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2081:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.28" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall5007);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall5017); 

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
    // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2088:1: ruleRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        try {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2090:33: ( ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2091:1: ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2091:1: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2094:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("RuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2100:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalXtextTerminalsTestLanguage.g:2101:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall5065); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.xmi#//@rules.28/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
                

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
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar195 = new BitSet(new long[]{0x00000000080EE010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar210 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar244 = new BitSet(new long[]{0x00000000080EE010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar296 = new BitSet(new long[]{0x00000000080EA010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar345 = new BitSet(new long[]{0x00000000080EA010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar388 = new BitSet(new long[]{0x00000000080E8010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar428 = new BitSet(new long[]{0x00000000080C0012L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleGeneratedMetamodel779 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel813 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel842 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleGeneratedMetamodel857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleReferencedMetamodel977 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1001 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleReferencedMetamodel1016 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleLexerRule1140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_19_in_ruleLexerRule1155 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1190 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleLexerRule1205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1239 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleLexerRule1255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1290 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1412 = new BitSet(new long[]{0x0000000000B00000L});
    public static final BitSet FOLLOW_20_in_ruleParserRule1426 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1460 = new BitSet(new long[]{0x0000000000A00000L});
    public static final BitSet FOLLOW_23_in_ruleParserRule1492 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1513 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1538 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1553 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1577 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParserRule1592 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleParserRule1604 = new BitSet(new long[]{0x0000041001000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1639 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleParserRule1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalRule1748 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1794 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_ruleTerminalRule1809 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1843 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTerminalRule1859 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1894 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTerminalRule1908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef1943 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2003 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef2016 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2138 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAlternatives2157 = new BitSet(new long[]{0x0000041001000030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2192 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2233 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2290 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives2309 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2344 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2442 = new BitSet(new long[]{0x0000041001000032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2485 = new BitSet(new long[]{0x0000041001000032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2583 = new BitSet(new long[]{0x0000018001002032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2626 = new BitSet(new long[]{0x0000018001002032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2726 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2753 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2781 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAbstractToken2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken2941 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTerminalToken2994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3043 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3113 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3140 = new BitSet(new long[]{0x0000040001000030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3155 = new BitSet(new long[]{0x0000040001000030L});
    public static final BitSet FOLLOW_35_in_ruleAssignment3171 = new BitSet(new long[]{0x0000040001000030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3258 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAction3308 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_37_in_ruleAction3318 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3327 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3364 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAction3378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3413 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3440 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3455 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3478 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAction3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3523 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken3961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNegatedToken4066 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUpToToken4183 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleWildcard4311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4414 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleCharacterRange4433 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4509 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4555 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4589 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleCrossReference4604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4628 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCrossReference4644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesizedElement4724 = new BitSet(new long[]{0x0000041001000030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4746 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedElement4755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleParenthesizedTerminalElement4835 = new BitSet(new long[]{0x0000018001002030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4857 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParenthesizedTerminalElement4866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword4969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall5007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall5017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall5065 = new BitSet(new long[]{0x0000000000000002L});

}
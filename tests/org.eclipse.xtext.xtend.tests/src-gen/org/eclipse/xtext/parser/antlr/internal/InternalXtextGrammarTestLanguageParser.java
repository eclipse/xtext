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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalXtextGrammarTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract language'", "'language'", "'.'", "'extends'", "'hidden'", "'('", "','", "')'", "'generate'", "'as'", "'import'", "'native'", "'lexer'", "'returns'", "':'", "';'", "'terminal'", "'::'", "'|'", "'?'", "'*'", "'+'", "'+='", "'='", "'?='", "'{'", "'current'", "'}'", "'!'", "'->'", "'..'", "'['", "']'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalXtextGrammarTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g"; }


     
        public InternalXtextGrammarTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalXtextGrammarTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Grammar";	
       	} 



    // $ANTLR start entryRuleGrammar
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:68:1: entryRuleGrammar returns [EObject current=null] : iv_ruleGrammar= ruleGrammar EOF ;
    public final EObject entryRuleGrammar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammar = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:68:49: (iv_ruleGrammar= ruleGrammar EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:69:2: iv_ruleGrammar= ruleGrammar EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0" /* xtext::ParserRule */, currentNode); 
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:76:1: ruleGrammar returns [EObject current=null] : ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) ;
    public final EObject ruleGrammar() throws RecognitionException {
        EObject current = null;

        Token lv_abstract=null;
        Token lv_idElements=null;
        Token lv_superGrammarIdElements=null;
        Token lv_definesHiddenTokens=null;
        EObject lv_metamodelDeclarations = null;

        EObject lv_rules = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:80:6: ( ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:1: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:1: ( ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+ )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:2: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* ) (lv_rules= ruleAbstractRule )+
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:2: ( ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )* )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:3: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:3: ( ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:4: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:4: ( ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:5: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* ) ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:5: ( ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )* )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:6: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) ) ( '.' (lv_idElements= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:6: ( ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:7: ( (lv_abstract= 'abstract language' ) | 'language' ) (lv_idElements= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:7: ( (lv_abstract= 'abstract language' ) | 'language' )
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
                    new NoViableAltException("81:7: ( (lv_abstract= 'abstract language' ) | 'language' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:8: (lv_abstract= 'abstract language' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:81:8: (lv_abstract= 'abstract language' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:83:6: lv_abstract= 'abstract language'
                    {
                    lv_abstract=(Token)input.LT(1);
                    match(input,11,FOLLOW_11_in_ruleGrammar134); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0/@terminal" /* xtext::Keyword */, "abstract"); 
                        

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
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:102:6: 'language'
                    {
                    match(input,12,FOLLOW_12_in_ruleGrammar161); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:106:2: (lv_idElements= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:108:6: lv_idElements= RULE_ID
            {
            lv_idElements=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar183); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:126:3: ( '.' (lv_idElements= RULE_ID ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:126:4: '.' (lv_idElements= RULE_ID )
            	    {
            	    match(input,13,FOLLOW_13_in_ruleGrammar205); 

            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:130:1: (lv_idElements= RULE_ID )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:132:6: lv_idElements= RULE_ID
            	    {
            	    lv_idElements=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar226); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "idElements"); 
            	        

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:150:5: ( ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:150:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) ) ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:150:6: ( 'extends' (lv_superGrammarIdElements= RULE_ID ) )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:150:7: 'extends' (lv_superGrammarIdElements= RULE_ID )
                    {
                    match(input,14,FOLLOW_14_in_ruleGrammar251); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:154:1: (lv_superGrammarIdElements= RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:156:6: lv_superGrammarIdElements= RULE_ID
                    {
                    lv_superGrammarIdElements=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar272); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
                        

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

                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:174:3: ( '.' (lv_superGrammarIdElements= RULE_ID ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==13) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:174:4: '.' (lv_superGrammarIdElements= RULE_ID )
                    	    {
                    	    match(input,13,FOLLOW_13_in_ruleGrammar294); 

                    	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                    	        
                    	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:178:1: (lv_superGrammarIdElements= RULE_ID )
                    	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:180:6: lv_superGrammarIdElements= RULE_ID
                    	    {
                    	    lv_superGrammarIdElements=(Token)input.LT(1);
                    	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar315); 
                    	     
                    	        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "superGrammarIdElements"); 
                    	        

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:7: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:8: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:8: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:9: ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:9: ( (lv_definesHiddenTokens= 'hidden' ) '(' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:10: (lv_definesHiddenTokens= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:198:10: (lv_definesHiddenTokens= 'hidden' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:200:6: lv_definesHiddenTokens= 'hidden'
                    {
                    lv_definesHiddenTokens=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleGrammar355); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "definesHiddenTokens"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Grammar");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "definesHiddenTokens", true, "hidden", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }

                    match(input,16,FOLLOW_16_in_ruleGrammar376); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:222:2: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_ID) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:222:3: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:222:3: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:225:3: ( RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("Grammar");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:231:1: ( RULE_ID )
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:232:2: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar402); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                                

                            }


                            }

                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:237:2: ( ',' ( ( RULE_ID ) ) )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==17) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:237:3: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,17,FOLLOW_17_in_ruleGrammar416); 

                            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                            	        
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:241:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:244:3: ( RULE_ID )
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create("Grammar");
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:250:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:251:2: RULE_ID
                            	    {
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGrammar440); 
                            	     
                            	        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                            	        

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,18,FOLLOW_18_in_ruleGrammar458); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:260:4: (lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==19||LA8_0==21) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:263:6: lv_metamodelDeclarations= ruleAbstractMetamodelDeclaration
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar495);
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
            	    break loop8;
                }
            } while (true);


            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:281:4: (lv_rules= ruleAbstractRule )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||(LA9_0>=22 && LA9_0<=23)||LA9_0==27) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:284:6: lv_rules= ruleAbstractRule
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.0/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleGrammar535);
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:311:1: entryRuleAbstractRule returns [EObject current=null] : iv_ruleAbstractRule= ruleAbstractRule EOF ;
    public final EObject entryRuleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:311:54: (iv_ruleAbstractRule= ruleAbstractRule EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:312:2: iv_ruleAbstractRule= ruleAbstractRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule575);
            iv_ruleAbstractRule=ruleAbstractRule();
            _fsp--;

             current =iv_ruleAbstractRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRule585); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:319:1: ruleAbstractRule returns [EObject current=null] : ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_LexerRule = null;

        EObject this_ParserRule = null;

        EObject this_TerminalRule = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:323:6: ( ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID||(LA11_0>=22 && LA11_0<=23)) ) {
                alt11=1;
            }
            else if ( (LA11_0==27) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("324:1: ( (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule ) | this_TerminalRule= ruleTerminalRule )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:324:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=22 && LA10_0<=23)) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==RULE_ID) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("324:2: (this_LexerRule= ruleLexerRule | this_ParserRule= ruleParserRule )", 10, 0, input);

                        throw nvae;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:325:5: this_LexerRule= ruleLexerRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.1/@alternatives/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleLexerRule_in_ruleAbstractRule633);
                            this_LexerRule=ruleLexerRule();
                            _fsp--;

                             
                                    current = this_LexerRule; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:335:5: this_ParserRule= ruleParserRule
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleParserRule_in_ruleAbstractRule660);
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
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:345:5: this_TerminalRule= ruleTerminalRule
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleAbstractRule688);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:362:1: entryRuleAbstractMetamodelDeclaration returns [EObject current=null] : iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF ;
    public final EObject entryRuleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractMetamodelDeclaration = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:362:70: (iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:363:2: iv_ruleAbstractMetamodelDeclaration= ruleAbstractMetamodelDeclaration EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration722);
            iv_ruleAbstractMetamodelDeclaration=ruleAbstractMetamodelDeclaration();
            _fsp--;

             current =iv_ruleAbstractMetamodelDeclaration; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration732); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:370:1: ruleAbstractMetamodelDeclaration returns [EObject current=null] : (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) ;
    public final EObject ruleAbstractMetamodelDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_GeneratedMetamodel = null;

        EObject this_ReferencedMetamodel = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:374:6: ( (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:375:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:375:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            else if ( (LA12_0==21) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("375:1: (this_GeneratedMetamodel= ruleGeneratedMetamodel | this_ReferencedMetamodel= ruleReferencedMetamodel )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:376:5: this_GeneratedMetamodel= ruleGeneratedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.2/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration779);
                    this_GeneratedMetamodel=ruleGeneratedMetamodel();
                    _fsp--;

                     
                            current = this_GeneratedMetamodel; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:386:5: this_ReferencedMetamodel= ruleReferencedMetamodel
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.2/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration806);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:403:1: entryRuleGeneratedMetamodel returns [EObject current=null] : iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF ;
    public final EObject entryRuleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGeneratedMetamodel = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:403:60: (iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:404:2: iv_ruleGeneratedMetamodel= ruleGeneratedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel840);
            iv_ruleGeneratedMetamodel=ruleGeneratedMetamodel();
            _fsp--;

             current =iv_ruleGeneratedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGeneratedMetamodel850); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:411:1: ruleGeneratedMetamodel returns [EObject current=null] : ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleGeneratedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:415:6: ( ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:1: ( ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:2: ( ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:3: ( 'generate' (lv_name= RULE_ID ) ) ( ( RULE_STRING ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:3: ( 'generate' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:416:4: 'generate' (lv_name= RULE_ID )
            {
            match(input,19,FOLLOW_19_in_ruleGeneratedMetamodel886); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:420:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:422:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel907); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:440:3: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:443:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("GeneratedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:449:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:450:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel943); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:455:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:455:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleGeneratedMetamodel958); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:459:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:461:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGeneratedMetamodel979); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:488:1: entryRuleReferencedMetamodel returns [EObject current=null] : iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF ;
    public final EObject entryRuleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencedMetamodel = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:488:61: (iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:489:2: iv_ruleReferencedMetamodel= ruleReferencedMetamodel EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1027);
            iv_ruleReferencedMetamodel=ruleReferencedMetamodel();
            _fsp--;

             current =iv_ruleReferencedMetamodel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencedMetamodel1037); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:496:1: ruleReferencedMetamodel returns [EObject current=null] : ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) ;
    public final EObject ruleReferencedMetamodel() throws RecognitionException {
        EObject current = null;

        Token lv_alias=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:500:6: ( ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:501:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:501:1: ( ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:501:2: ( 'import' ( ( RULE_STRING ) ) ) ( 'as' (lv_alias= RULE_ID ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:501:2: ( 'import' ( ( RULE_STRING ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:501:3: 'import' ( ( RULE_STRING ) )
            {
            match(input,21,FOLLOW_21_in_ruleReferencedMetamodel1072); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:505:1: ( ( RULE_STRING ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:508:3: ( RULE_STRING )
            {

            			if (current==null) {
            	            current = factory.create("ReferencedMetamodel");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:514:1: ( RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:515:2: RULE_STRING
            {
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1096); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "ePackage"); 
                

            }


            }


            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:520:3: ( 'as' (lv_alias= RULE_ID ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:520:4: 'as' (lv_alias= RULE_ID )
                    {
                    match(input,20,FOLLOW_20_in_ruleReferencedMetamodel1111); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:524:1: (lv_alias= RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:526:6: lv_alias= RULE_ID
                    {
                    lv_alias=(Token)input.LT(1);
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencedMetamodel1132); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "alias"); 
                        

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:553:1: entryRuleLexerRule returns [EObject current=null] : iv_ruleLexerRule= ruleLexerRule EOF ;
    public final EObject entryRuleLexerRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLexerRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:553:51: (iv_ruleLexerRule= ruleLexerRule EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:554:2: iv_ruleLexerRule= ruleLexerRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleLexerRule_in_entryRuleLexerRule1180);
            iv_ruleLexerRule=ruleLexerRule();
            _fsp--;

             current =iv_ruleLexerRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLexerRule1190); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:561:1: ruleLexerRule returns [EObject current=null] : ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) ;
    public final EObject ruleLexerRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_body=null;
        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:565:6: ( ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:1: ( ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) ) ';'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:2: ( ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_body= RULE_STRING )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:3: ( ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:4: ( ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:5: ( ( 'native' | 'lexer' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:6: ( 'native' | 'lexer' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:6: ( 'native' | 'lexer' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            else if ( (LA15_0==23) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("566:6: ( 'native' | 'lexer' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:566:7: 'native'
                    {
                    match(input,22,FOLLOW_22_in_ruleLexerRule1229); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.0" /* xtext::Keyword */, null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:571:6: 'lexer'
                    {
                    match(input,23,FOLLOW_23_in_ruleLexerRule1244); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@groups.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:575:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:577:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLexerRule1266); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:595:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:595:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleLexerRule1288); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:599:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:602:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleLexerRule1322);
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

            match(input,25,FOLLOW_25_in_ruleLexerRule1338); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:624:2: (lv_body= RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:626:6: lv_body= RULE_STRING
            {
            lv_body=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleLexerRule1360); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "body"); 
                

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

            match(input,26,FOLLOW_26_in_ruleLexerRule1381); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:657:1: entryRuleParserRule returns [EObject current=null] : iv_ruleParserRule= ruleParserRule EOF ;
    public final EObject entryRuleParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParserRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:657:52: (iv_ruleParserRule= ruleParserRule EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:658:2: iv_ruleParserRule= ruleParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParserRule_in_entryRuleParserRule1416);
            iv_ruleParserRule=ruleParserRule();
            _fsp--;

             current =iv_ruleParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParserRule1426); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:665:1: ruleParserRule returns [EObject current=null] : ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) ;
    public final EObject ruleParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_definesHiddenTokens=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:669:6: ( ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:1: ( ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:2: ( ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' ) (lv_alternatives= ruleAlternatives )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:3: ( ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? ) ':'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:4: ( ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:5: ( (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:6: (lv_name= RULE_ID ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:670:6: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:672:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1476); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:690:2: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:690:3: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleParserRule1497); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:694:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:697:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleParserRule1531);
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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:5: ( ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==15) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:6: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? ) ')'
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:6: ( ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )? )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:7: ( (lv_definesHiddenTokens= 'hidden' ) '(' ) ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:7: ( (lv_definesHiddenTokens= 'hidden' ) '(' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:8: (lv_definesHiddenTokens= 'hidden' ) '('
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:715:8: (lv_definesHiddenTokens= 'hidden' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:717:6: lv_definesHiddenTokens= 'hidden'
                    {
                    lv_definesHiddenTokens=(Token)input.LT(1);
                    match(input,15,FOLLOW_15_in_ruleParserRule1562); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "definesHiddenTokens"); 
                        

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

                    match(input,16,FOLLOW_16_in_ruleParserRule1583); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:739:2: ( ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )* )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:739:3: ( ( RULE_ID ) ) ( ',' ( ( RULE_ID ) ) )*
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:739:3: ( ( RULE_ID ) )
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:742:3: ( RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create("ParserRule");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:748:1: ( RULE_ID )
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:749:2: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1609); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                                

                            }


                            }

                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:754:2: ( ',' ( ( RULE_ID ) ) )*
                            loop18:
                            do {
                                int alt18=2;
                                int LA18_0 = input.LA(1);

                                if ( (LA18_0==17) ) {
                                    alt18=1;
                                }


                                switch (alt18) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:754:3: ',' ( ( RULE_ID ) )
                            	    {
                            	    match(input,17,FOLLOW_17_in_ruleParserRule1623); 

                            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                            	        
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:758:1: ( ( RULE_ID ) )
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:761:3: ( RULE_ID )
                            	    {

                            	    			if (current==null) {
                            	    	            current = factory.create("ParserRule");
                            	    	            associateNodeWithAstElement(currentNode, current);
                            	    	        }
                            	            
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:767:1: ( RULE_ID )
                            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:768:2: RULE_ID
                            	    {
                            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleParserRule1647); 
                            	     
                            	        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "hiddenTokens"); 
                            	        

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop18;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }

                    match(input,18,FOLLOW_18_in_ruleParserRule1665); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleParserRule1677); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:781:2: (lv_alternatives= ruleAlternatives )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:784:6: lv_alternatives= ruleAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParserRule1712);
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

            match(input,26,FOLLOW_26_in_ruleParserRule1726); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.6/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:815:1: entryRuleTerminalRule returns [EObject current=null] : iv_ruleTerminalRule= ruleTerminalRule EOF ;
    public final EObject entryRuleTerminalRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalRule = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:815:54: (iv_ruleTerminalRule= ruleTerminalRule EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:816:2: iv_ruleTerminalRule= ruleTerminalRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1761);
            iv_ruleTerminalRule=ruleTerminalRule();
            _fsp--;

             current =iv_ruleTerminalRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalRule1771); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:823:1: ruleTerminalRule returns [EObject current=null] : ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_terminal=null;
        Token lv_name=null;
        EObject lv_type = null;

        EObject lv_alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:827:6: ( ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:1: ( ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) ) ';'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:2: ( ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' ) (lv_alternatives= ruleTerminalAlternatives )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:3: ( ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? ) ':'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:4: ( ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) ) ( 'returns' (lv_type= ruleTypeRef ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:5: ( (lv_terminal= 'terminal' ) (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:6: (lv_terminal= 'terminal' ) (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:828:6: (lv_terminal= 'terminal' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:830:6: lv_terminal= 'terminal'
            {
            lv_terminal=(Token)input.LT(1);
            match(input,27,FOLLOW_27_in_ruleTerminalRule1821); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::Keyword */, "terminal"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:848:2: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:850:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTerminalRule1854); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:868:3: ( 'returns' (lv_type= ruleTypeRef ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==24) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:868:4: 'returns' (lv_type= ruleTypeRef )
                    {
                    match(input,24,FOLLOW_24_in_ruleTerminalRule1876); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:872:1: (lv_type= ruleTypeRef )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:875:6: lv_type= ruleTypeRef
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleTypeRef_in_ruleTerminalRule1910);
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

            match(input,25,FOLLOW_25_in_ruleTerminalRule1926); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:897:2: (lv_alternatives= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:900:6: lv_alternatives= ruleTerminalAlternatives
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1961);
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

            match(input,26,FOLLOW_26_in_ruleTerminalRule1975); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.7/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:931:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:931:49: (iv_ruleTypeRef= ruleTypeRef EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:932:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTypeRef_in_entryRuleTypeRef2010);
            iv_ruleTypeRef=ruleTypeRef();
            _fsp--;

             current =iv_ruleTypeRef; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeRef2020); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:939:1: ruleTypeRef returns [EObject current=null] : ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:943:6: ( ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:944:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:944:1: ( ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:944:2: ( ( ( RULE_ID ) ) '::' )? ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:944:2: ( ( ( RULE_ID ) ) '::' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==28) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:944:3: ( ( RULE_ID ) ) '::'
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:944:3: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:947:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("TypeRef");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:953:1: ( RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:954:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2070); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::CrossReference */, "metamodel"); 
                        

                    }


                    }

                    match(input,28,FOLLOW_28_in_ruleTypeRef2083); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:963:3: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:966:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("TypeRef");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:972:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:973:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeRef2109); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.8/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "type"); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:987:1: entryRuleAlternatives returns [EObject current=null] : iv_ruleAlternatives= ruleAlternatives EOF ;
    public final EObject entryRuleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlternatives = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:987:54: (iv_ruleAlternatives= ruleAlternatives EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:988:2: iv_ruleAlternatives= ruleAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAlternatives_in_entryRuleAlternatives2148);
            iv_ruleAlternatives=ruleAlternatives();
            _fsp--;

             current =iv_ruleAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlternatives2158); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:995:1: ruleAlternatives returns [EObject current=null] : (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) ;
    public final EObject ruleAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_Group = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:999:6: ( (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1000:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1000:1: (this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )* )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1001:5: this_Group= ruleGroup ( ( () '|' ) (lv_groups= ruleGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2205);
            this_Group=ruleGroup();
            _fsp--;

             
                    current = this_Group; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:1: ( ( () '|' ) (lv_groups= ruleGroup ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==29) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:2: ( () '|' ) (lv_groups= ruleGroup )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:2: ( () '|' )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:3: () '|'
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1009:3: ()
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1010:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleAlternatives2224); 

            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1029:2: (lv_groups= ruleGroup )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1032:6: lv_groups= ruleGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.9/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleGroup_in_ruleAlternatives2259);
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
            	    break loop23;
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1059:1: entryRuleTerminalAlternatives returns [EObject current=null] : iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF ;
    public final EObject entryRuleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalAlternatives = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1059:62: (iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1060:2: iv_ruleTerminalAlternatives= ruleTerminalAlternatives EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.10" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2300);
            iv_ruleTerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             current =iv_ruleTerminalAlternatives; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalAlternatives2310); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1067:1: ruleTerminalAlternatives returns [EObject current=null] : (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) ;
    public final EObject ruleTerminalAlternatives() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalGroup = null;

        EObject lv_groups = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1071:6: ( (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1072:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1072:1: (this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )* )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1073:5: this_TerminalGroup= ruleTerminalGroup ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.10/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2357);
            this_TerminalGroup=ruleTerminalGroup();
            _fsp--;

             
                    current = this_TerminalGroup; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:1: ( ( () '|' ) (lv_groups= ruleTerminalGroup ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==29) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:2: ( () '|' ) (lv_groups= ruleTerminalGroup )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:2: ( () '|' )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:3: () '|'
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1081:3: ()
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1082:5: 
            	    {
            	     
            	            temp=factory.create("Alternatives");
            	            try {
            	            	factory.add(temp, "groups", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,29,FOLLOW_29_in_ruleTerminalAlternatives2376); 

            	            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
            	        

            	    }

            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1101:2: (lv_groups= ruleTerminalGroup )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1104:6: lv_groups= ruleTerminalGroup
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.10/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2411);
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
            	    break loop24;
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1131:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1131:47: (iv_ruleGroup= ruleGroup EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1132:2: iv_ruleGroup= ruleGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.11" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleGroup_in_entryRuleGroup2452);
            iv_ruleGroup=ruleGroup();
            _fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGroup2462); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1139:1: ruleGroup returns [EObject current=null] : (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        EObject this_AbstractToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1143:6: ( (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1144:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1144:1: (this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )* )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1145:5: this_AbstractToken= ruleAbstractToken ( () (lv_abstractTokens= ruleAbstractToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2509);
            this_AbstractToken=ruleAbstractToken();
            _fsp--;

             
                    current = this_AbstractToken; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1153:1: ( () (lv_abstractTokens= ruleAbstractToken ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||LA25_0==16||LA25_0==36||LA25_0==42) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1153:2: () (lv_abstractTokens= ruleAbstractToken )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1153:2: ()
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1154:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1169:2: (lv_abstractTokens= ruleAbstractToken )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1172:6: lv_abstractTokens= ruleAbstractToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.11/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractToken_in_ruleGroup2552);
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
            	    break loop25;
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1199:1: entryRuleTerminalGroup returns [EObject current=null] : iv_ruleTerminalGroup= ruleTerminalGroup EOF ;
    public final EObject entryRuleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalGroup = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1199:55: (iv_ruleTerminalGroup= ruleTerminalGroup EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1200:2: iv_ruleTerminalGroup= ruleTerminalGroup EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.12" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2593);
            iv_ruleTerminalGroup=ruleTerminalGroup();
            _fsp--;

             current =iv_ruleTerminalGroup; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalGroup2603); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1207:1: ruleTerminalGroup returns [EObject current=null] : (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) ;
    public final EObject ruleTerminalGroup() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalToken = null;

        EObject lv_abstractTokens = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1211:6: ( (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1212:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1212:1: (this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )* )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1213:5: this_TerminalToken= ruleTerminalToken ( () (lv_abstractTokens= ruleTerminalToken ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2650);
            this_TerminalToken=ruleTerminalToken();
            _fsp--;

             
                    current = this_TerminalToken; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1221:1: ( () (lv_abstractTokens= ruleTerminalToken ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_STRING)||LA26_0==13||LA26_0==16||(LA26_0>=39 && LA26_0<=40)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1221:2: () (lv_abstractTokens= ruleTerminalToken )
            	    {
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1221:2: ()
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1222:5: 
            	    {
            	     
            	            temp=factory.create("Group");
            	            try {
            	            	factory.add(temp, "abstractTokens", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1237:2: (lv_abstractTokens= ruleTerminalToken )
            	    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1240:6: lv_abstractTokens= ruleTerminalToken
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.12/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2693);
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
            	    break loop26;
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1267:1: entryRuleAbstractToken returns [EObject current=null] : iv_ruleAbstractToken= ruleAbstractToken EOF ;
    public final EObject entryRuleAbstractToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1267:55: (iv_ruleAbstractToken= ruleAbstractToken EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1268:2: iv_ruleAbstractToken= ruleAbstractToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2734);
            iv_ruleAbstractToken=ruleAbstractToken();
            _fsp--;

             current =iv_ruleAbstractToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractToken2744); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1275:1: ruleAbstractToken returns [EObject current=null] : ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleAbstractToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_Assignment = null;

        EObject this_Action = null;

        EObject this_AbstractTerminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1279:6: ( ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:1: ( ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal ) (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )
            int alt28=2;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==EOF||(LA28_1>=RULE_ID && LA28_1<=RULE_STRING)||LA28_1==16||LA28_1==18||LA28_1==26||(LA28_1>=29 && LA28_1<=32)||LA28_1==36||LA28_1==42) ) {
                    alt28=2;
                }
                else if ( ((LA28_1>=33 && LA28_1<=35)) ) {
                    alt28=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1280:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 28, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
                {
                alt28=1;
                }
                break;
            case RULE_STRING:
            case 16:
            case 42:
                {
                alt28=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1280:2: ( (this_Assignment= ruleAssignment | this_Action= ruleAction ) | this_AbstractTerminal= ruleAbstractTerminal )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1280:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==RULE_ID) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==36) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1280:3: (this_Assignment= ruleAssignment | this_Action= ruleAction )", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1281:5: this_Assignment= ruleAssignment
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAssignment_in_ruleAbstractToken2793);
                            this_Assignment=ruleAssignment();
                            _fsp--;

                             
                                    current = this_Assignment; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1291:5: this_Action= ruleAction
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAction_in_ruleAbstractToken2820);
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
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1301:5: this_AbstractTerminal= ruleAbstractTerminal
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2848);
                    this_AbstractTerminal=ruleAbstractTerminal();
                    _fsp--;

                     
                            current = this_AbstractTerminal; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1309:2: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=30 && LA31_0<=32)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:21: ( ( '?' | '*' ) | '+' )
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( ((LA30_0>=30 && LA30_0<=31)) ) {
                        alt30=1;
                    }
                    else if ( (LA30_0==32) ) {
                        alt30=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1311:21: ( ( '?' | '*' ) | '+' )", 30, 0, input);

                        throw nvae;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:22: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:22: ( '?' | '*' )
                            int alt29=2;
                            int LA29_0 = input.LA(1);

                            if ( (LA29_0==30) ) {
                                alt29=1;
                            }
                            else if ( (LA29_0==31) ) {
                                alt29=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1311:22: ( '?' | '*' )", 29, 0, input);

                                throw nvae;
                            }
                            switch (alt29) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1311:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleAbstractToken2871); 

                                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1316:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleAbstractToken2886); 

                                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1321:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleAbstractToken2902); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.13/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1348:1: entryRuleTerminalToken returns [EObject current=null] : iv_ruleTerminalToken= ruleTerminalToken EOF ;
    public final EObject entryRuleTerminalToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1348:55: (iv_ruleTerminalToken= ruleTerminalToken EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1349:2: iv_ruleTerminalToken= ruleTerminalToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.14" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2951);
            iv_ruleTerminalToken=ruleTerminalToken();
            _fsp--;

             current =iv_ruleTerminalToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalToken2961); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1356:1: ruleTerminalToken returns [EObject current=null] : (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) ;
    public final EObject ruleTerminalToken() throws RecognitionException {
        EObject current = null;

        Token lv_cardinality=null;
        EObject this_TerminalTokenElement = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1360:6: ( (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1361:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1361:1: (this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1362:5: this_TerminalTokenElement= ruleTerminalTokenElement (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3008);
            this_TerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             
                    current = this_TerminalTokenElement; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1370:1: (lv_cardinality= ( ( '?' | '*' ) | '+' ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=30 && LA34_0<=32)) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1372:6: lv_cardinality= ( ( '?' | '*' ) | '+' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1372:21: ( ( '?' | '*' ) | '+' )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=30 && LA33_0<=31)) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==32) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1372:21: ( ( '?' | '*' ) | '+' )", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1372:22: ( '?' | '*' )
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1372:22: ( '?' | '*' )
                            int alt32=2;
                            int LA32_0 = input.LA(1);

                            if ( (LA32_0==30) ) {
                                alt32=1;
                            }
                            else if ( (LA32_0==31) ) {
                                alt32=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1372:22: ( '?' | '*' )", 32, 0, input);

                                throw nvae;
                            }
                            switch (alt32) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1372:23: '?'
                                    {
                                    match(input,30,FOLLOW_30_in_ruleTerminalToken3030); 

                                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1377:6: '*'
                                    {
                                    match(input,31,FOLLOW_31_in_ruleTerminalToken3045); 

                                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1382:6: '+'
                            {
                            match(input,32,FOLLOW_32_in_ruleTerminalToken3061); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.14/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "cardinality"); 
                                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1409:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1409:52: (iv_ruleAssignment= ruleAssignment EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1410:2: iv_ruleAssignment= ruleAssignment EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.15" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment3110);
            iv_ruleAssignment=ruleAssignment();
            _fsp--;

             current =iv_ruleAssignment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment3120); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1417:1: ruleAssignment returns [EObject current=null] : ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1421:6: ( ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:1: ( ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) ) (lv_terminal= ruleAbstractTerminal )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:2: ( (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:3: (lv_feature= RULE_ID ) (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1422:3: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1424:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssignment3167); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "feature"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1442:2: (lv_operator= ( ( '+=' | '=' ) | '?=' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:6: lv_operator= ( ( '+=' | '=' ) | '?=' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:18: ( ( '+=' | '=' ) | '?=' )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( ((LA36_0>=33 && LA36_0<=34)) ) {
                alt36=1;
            }
            else if ( (LA36_0==35) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1444:18: ( ( '+=' | '=' ) | '?=' )", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:19: ( '+=' | '=' )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:19: ( '+=' | '=' )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==33) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==34) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1444:19: ( '+=' | '=' )", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1444:20: '+='
                            {
                            match(input,33,FOLLOW_33_in_ruleAssignment3201); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1449:6: '='
                            {
                            match(input,34,FOLLOW_34_in_ruleAssignment3216); 

                                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "operator"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1454:6: '?='
                    {
                    match(input,35,FOLLOW_35_in_ruleAssignment3232); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.15/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1472:3: (lv_terminal= ruleAbstractTerminal )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1475:6: lv_terminal= ruleAbstractTerminal
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.15/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleAbstractTerminal_in_ruleAssignment3280);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1502:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1502:48: (iv_ruleAction= ruleAction EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1503:2: iv_ruleAction= ruleAction EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAction_in_entryRuleAction3319);
            iv_ruleAction=ruleAction();
            _fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAction3329); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1510:1: ruleAction returns [EObject current=null] : ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token lv_feature=null;
        Token lv_operator=null;
        EObject lv_typeName = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1514:6: ( ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:1: ( ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' ) '}'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:2: ( ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) ) 'current'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:3: ( ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) ) (lv_operator= ( '=' | '+=' ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:4: ( ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' ) (lv_feature= RULE_ID )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:5: ( ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) ) '.'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:6: ( ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:7: ( '{' ( 'current' '=' )? ) (lv_typeName= ruleTypeRef )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:7: ( '{' ( 'current' '=' )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1515:8: '{' ( 'current' '=' )?
            {
            match(input,36,FOLLOW_36_in_ruleAction3369); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1519:1: ( 'current' '=' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==37) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1519:2: 'current' '='
                    {
                    match(input,37,FOLLOW_37_in_ruleAction3379); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    match(input,34,FOLLOW_34_in_ruleAction3388); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }
                    break;

            }


            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1527:4: (lv_typeName= ruleTypeRef )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1530:6: lv_typeName= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleAction3425);
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

            match(input,13,FOLLOW_13_in_ruleAction3439); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1552:2: (lv_feature= RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1554:6: lv_feature= RULE_ID
            {
            lv_feature=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAction3461); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "feature"); 
                

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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1572:3: (lv_operator= ( '=' | '+=' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1574:6: lv_operator= ( '=' | '+=' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1574:18: ( '=' | '+=' )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==34) ) {
                alt38=1;
            }
            else if ( (LA38_0==33) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1574:18: ( '=' | '+=' )", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1574:19: '='
                    {
                    match(input,34,FOLLOW_34_in_ruleAction3495); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0" /* xtext::Keyword */, "operator"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1579:6: '+='
                    {
                    match(input,33,FOLLOW_33_in_ruleAction3510); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "operator"); 
                        

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

            match(input,37,FOLLOW_37_in_ruleAction3533); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            match(input,38,FOLLOW_38_in_ruleAction3543); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.16/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1614:1: entryRuleAbstractTerminal returns [EObject current=null] : iv_ruleAbstractTerminal= ruleAbstractTerminal EOF ;
    public final EObject entryRuleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractTerminal = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1614:58: (iv_ruleAbstractTerminal= ruleAbstractTerminal EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1615:2: iv_ruleAbstractTerminal= ruleAbstractTerminal EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.17" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3578);
            iv_ruleAbstractTerminal=ruleAbstractTerminal();
            _fsp--;

             current =iv_ruleAbstractTerminal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractTerminal3588); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1622:1: ruleAbstractTerminal returns [EObject current=null] : ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) ;
    public final EObject ruleAbstractTerminal() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedElement = null;

        EObject this_CrossReference = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1626:6: ( ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1627:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1627:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_ID && LA41_0<=RULE_STRING)||LA41_0==16) ) {
                alt41=1;
            }
            else if ( (LA41_0==42) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1627:1: ( ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement ) | this_CrossReference= ruleCrossReference )", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1627:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1627:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( ((LA40_0>=RULE_ID && LA40_0<=RULE_STRING)) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==16) ) {
                        alt40=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1627:2: ( (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall ) | this_ParenthesizedElement= ruleParenthesizedElement )", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1627:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1627:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )
                            int alt39=2;
                            int LA39_0 = input.LA(1);

                            if ( (LA39_0==RULE_STRING) ) {
                                alt39=1;
                            }
                            else if ( (LA39_0==RULE_ID) ) {
                                alt39=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1627:3: (this_Keyword= ruleKeyword | this_RuleCall= ruleRuleCall )", 39, 0, input);

                                throw nvae;
                            }
                            switch (alt39) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1628:5: this_Keyword= ruleKeyword
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleKeyword_in_ruleAbstractTerminal3637);
                                    this_Keyword=ruleKeyword();
                                    _fsp--;

                                     
                                            current = this_Keyword; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1638:5: this_RuleCall= ruleRuleCall
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3664);
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
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1648:5: this_ParenthesizedElement= ruleParenthesizedElement
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3692);
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
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1658:5: this_CrossReference= ruleCrossReference
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.17/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3720);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1675:1: entryRuleTerminalTokenElement returns [EObject current=null] : iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF ;
    public final EObject entryRuleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerminalTokenElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1675:62: (iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1676:2: iv_ruleTerminalTokenElement= ruleTerminalTokenElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.18" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3754);
            iv_ruleTerminalTokenElement=ruleTerminalTokenElement();
            _fsp--;

             current =iv_ruleTerminalTokenElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerminalTokenElement3764); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1683:1: ruleTerminalTokenElement returns [EObject current=null] : ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) ;
    public final EObject ruleTerminalTokenElement() throws RecognitionException {
        EObject current = null;

        EObject this_CharacterRange = null;

        EObject this_RuleCall = null;

        EObject this_ParenthesizedTerminalElement = null;

        EObject this_AbstractNegatedToken = null;

        EObject this_Wildcard = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1687:6: ( ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=RULE_ID && LA45_0<=RULE_STRING)||LA45_0==16||(LA45_0>=39 && LA45_0<=40)) ) {
                alt45=1;
            }
            else if ( (LA45_0==13) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1688:1: ( ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken ) | this_Wildcard= ruleWildcard )", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||LA44_0==16) ) {
                        alt44=1;
                    }
                    else if ( ((LA44_0>=39 && LA44_0<=40)) ) {
                        alt44=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1688:2: ( ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement ) | this_AbstractNegatedToken= ruleAbstractNegatedToken )", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            {
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )
                            int alt43=2;
                            int LA43_0 = input.LA(1);

                            if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_STRING)) ) {
                                alt43=1;
                            }
                            else if ( (LA43_0==16) ) {
                                alt43=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1688:3: ( (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall ) | this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement )", 43, 0, input);

                                throw nvae;
                            }
                            switch (alt43) {
                                case 1 :
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    {
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1688:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )
                                    int alt42=2;
                                    int LA42_0 = input.LA(1);

                                    if ( (LA42_0==RULE_STRING) ) {
                                        alt42=1;
                                    }
                                    else if ( (LA42_0==RULE_ID) ) {
                                        alt42=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("1688:4: (this_CharacterRange= ruleCharacterRange | this_RuleCall= ruleRuleCall )", 42, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt42) {
                                        case 1 :
                                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1689:5: this_CharacterRange= ruleCharacterRange
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3814);
                                            this_CharacterRange=ruleCharacterRange();
                                            _fsp--;

                                             
                                                    current = this_CharacterRange; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;
                                        case 2 :
                                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1699:5: this_RuleCall= ruleRuleCall
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.18/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3841);
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
                                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1709:5: this_ParenthesizedTerminalElement= ruleParenthesizedTerminalElement
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.18/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3869);
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
                            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1719:5: this_AbstractNegatedToken= ruleAbstractNegatedToken
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.18/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3897);
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
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1729:5: this_Wildcard= ruleWildcard
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.18/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3925);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1746:1: entryRuleAbstractNegatedToken returns [EObject current=null] : iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF ;
    public final EObject entryRuleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractNegatedToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1746:62: (iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1747:2: iv_ruleAbstractNegatedToken= ruleAbstractNegatedToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.19" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3959);
            iv_ruleAbstractNegatedToken=ruleAbstractNegatedToken();
            _fsp--;

             current =iv_ruleAbstractNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractNegatedToken3969); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1754:1: ruleAbstractNegatedToken returns [EObject current=null] : (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) ;
    public final EObject ruleAbstractNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject this_NegatedToken = null;

        EObject this_UpToToken = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1758:6: ( (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1759:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1759:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==39) ) {
                alt46=1;
            }
            else if ( (LA46_0==40) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1759:1: (this_NegatedToken= ruleNegatedToken | this_UpToToken= ruleUpToToken )", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1760:5: this_NegatedToken= ruleNegatedToken
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.19/@alternatives/@groups.0" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4016);
                    this_NegatedToken=ruleNegatedToken();
                    _fsp--;

                     
                            current = this_NegatedToken; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1770:5: this_UpToToken= ruleUpToToken
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.19/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4043);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1787:1: entryRuleNegatedToken returns [EObject current=null] : iv_ruleNegatedToken= ruleNegatedToken EOF ;
    public final EObject entryRuleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNegatedToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1787:54: (iv_ruleNegatedToken= ruleNegatedToken EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1788:2: iv_ruleNegatedToken= ruleNegatedToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.20" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4077);
            iv_ruleNegatedToken=ruleNegatedToken();
            _fsp--;

             current =iv_ruleNegatedToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegatedToken4087); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1795:1: ruleNegatedToken returns [EObject current=null] : ( '!' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleNegatedToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1799:6: ( ( '!' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1800:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1800:1: ( '!' (lv_terminal= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1800:2: '!' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,39,FOLLOW_39_in_ruleNegatedToken4121); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.20/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1804:1: (lv_terminal= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1807:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.20/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4155);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1834:1: entryRuleUpToToken returns [EObject current=null] : iv_ruleUpToToken= ruleUpToToken EOF ;
    public final EObject entryRuleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpToToken = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1834:51: (iv_ruleUpToToken= ruleUpToToken EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1835:2: iv_ruleUpToToken= ruleUpToToken EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.21" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleUpToToken_in_entryRuleUpToToken4194);
            iv_ruleUpToToken=ruleUpToToken();
            _fsp--;

             current =iv_ruleUpToToken; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpToToken4204); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1842:1: ruleUpToToken returns [EObject current=null] : ( '->' (lv_terminal= ruleTerminalTokenElement ) ) ;
    public final EObject ruleUpToToken() throws RecognitionException {
        EObject current = null;

        EObject lv_terminal = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1846:6: ( ( '->' (lv_terminal= ruleTerminalTokenElement ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1847:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1847:1: ( '->' (lv_terminal= ruleTerminalTokenElement ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1847:2: '->' (lv_terminal= ruleTerminalTokenElement )
            {
            match(input,40,FOLLOW_40_in_ruleUpToToken4238); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.21/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1851:1: (lv_terminal= ruleTerminalTokenElement )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1854:6: lv_terminal= ruleTerminalTokenElement
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.21/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4272);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1881:1: entryRuleWildcard returns [EObject current=null] : iv_ruleWildcard= ruleWildcard EOF ;
    public final EObject entryRuleWildcard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcard = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1881:50: (iv_ruleWildcard= ruleWildcard EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1882:2: iv_ruleWildcard= ruleWildcard EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.22" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleWildcard_in_entryRuleWildcard4311);
            iv_ruleWildcard=ruleWildcard();
            _fsp--;

             current =iv_ruleWildcard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleWildcard4321); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1889:1: ruleWildcard returns [EObject current=null] : (lv_isWildcard= '.' ) ;
    public final EObject ruleWildcard() throws RecognitionException {
        EObject current = null;

        Token lv_isWildcard=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1893:6: ( (lv_isWildcard= '.' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1894:1: (lv_isWildcard= '.' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1894:1: (lv_isWildcard= '.' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1896:6: lv_isWildcard= '.'
            {
            lv_isWildcard=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_ruleWildcard4366); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.22/@alternatives/@terminal" /* xtext::Keyword */, "isWildcard"); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1923:1: entryRuleCharacterRange returns [EObject current=null] : iv_ruleCharacterRange= ruleCharacterRange EOF ;
    public final EObject entryRuleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCharacterRange = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1923:56: (iv_ruleCharacterRange= ruleCharacterRange EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1924:2: iv_ruleCharacterRange= ruleCharacterRange EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.23" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4412);
            iv_ruleCharacterRange=ruleCharacterRange();
            _fsp--;

             current =iv_ruleCharacterRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCharacterRange4422); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1931:1: ruleCharacterRange returns [EObject current=null] : (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) ;
    public final EObject ruleCharacterRange() throws RecognitionException {
        EObject current = null;

        EObject this_Keyword = null;

        EObject lv_right = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1935:6: ( (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1936:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1936:1: (this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1937:5: this_Keyword= ruleKeyword ( ( () '..' ) (lv_right= ruleKeyword ) )?
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.23/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4469);
            this_Keyword=ruleKeyword();
            _fsp--;

             
                    current = this_Keyword; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:1: ( ( () '..' ) (lv_right= ruleKeyword ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==41) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:2: ( () '..' ) (lv_right= ruleKeyword )
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:2: ( () '..' )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:3: () '..'
                    {
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1945:3: ()
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1946:5: 
                    {
                     
                            temp=factory.create("CharacterRange");
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    match(input,41,FOLLOW_41_in_ruleCharacterRange4488); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1965:2: (lv_right= ruleKeyword )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1968:6: lv_right= ruleKeyword
                    {
                     
                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.23/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleKeyword_in_ruleCharacterRange4523);
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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1995:1: entryRuleCrossReference returns [EObject current=null] : iv_ruleCrossReference= ruleCrossReference EOF ;
    public final EObject entryRuleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCrossReference = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1995:56: (iv_ruleCrossReference= ruleCrossReference EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:1996:2: iv_ruleCrossReference= ruleCrossReference EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.24" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCrossReference_in_entryRuleCrossReference4564);
            iv_ruleCrossReference=ruleCrossReference();
            _fsp--;

             current =iv_ruleCrossReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCrossReference4574); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2003:1: ruleCrossReference returns [EObject current=null] : ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) ;
    public final EObject ruleCrossReference() throws RecognitionException {
        EObject current = null;

        EObject lv_type = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2007:6: ( ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:1: ( ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? ) ']'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:2: ( ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )? )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:3: ( '[' (lv_type= ruleTypeRef ) ) ( '|' ( ( RULE_ID ) ) )?
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:3: ( '[' (lv_type= ruleTypeRef ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2008:4: '[' (lv_type= ruleTypeRef )
            {
            match(input,42,FOLLOW_42_in_ruleCrossReference4610); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2012:1: (lv_type= ruleTypeRef )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2015:6: lv_type= ruleTypeRef
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeRef_in_ruleCrossReference4644);
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

            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2033:3: ( '|' ( ( RULE_ID ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==29) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2033:4: '|' ( ( RULE_ID ) )
                    {
                    match(input,29,FOLLOW_29_in_ruleCrossReference4659); 

                            createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2037:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2040:3: ( RULE_ID )
                    {

                    			if (current==null) {
                    	            current = factory.create("CrossReference");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2046:1: ( RULE_ID )
                    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2047:2: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCrossReference4683); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "rule"); 
                        

                    }


                    }


                    }
                    break;

            }


            }

            match(input,43,FOLLOW_43_in_ruleCrossReference4699); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.24/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:1: entryRuleParenthesizedElement returns [EObject current=null] : iv_ruleParenthesizedElement= ruleParenthesizedElement EOF ;
    public final EObject entryRuleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2065:62: (iv_ruleParenthesizedElement= ruleParenthesizedElement EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2066:2: iv_ruleParenthesizedElement= ruleParenthesizedElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.25" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4734);
            iv_ruleParenthesizedElement=ruleParenthesizedElement();
            _fsp--;

             current =iv_ruleParenthesizedElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedElement4744); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2073:1: ruleParenthesizedElement returns [EObject current=null] : ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedElement() throws RecognitionException {
        EObject current = null;

        EObject this_Alternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2077:6: ( ( ( '(' this_Alternatives= ruleAlternatives ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2078:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2078:1: ( ( '(' this_Alternatives= ruleAlternatives ) ')' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2078:2: ( '(' this_Alternatives= ruleAlternatives ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2078:2: ( '(' this_Alternatives= ruleAlternatives )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2078:3: '(' this_Alternatives= ruleAlternatives
            {
            match(input,16,FOLLOW_16_in_ruleParenthesizedElement4779); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.25/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4801);
            this_Alternatives=ruleAlternatives();
            _fsp--;

             
                    current = this_Alternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,18,FOLLOW_18_in_ruleParenthesizedElement4810); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.25/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2104:1: entryRuleParenthesizedTerminalElement returns [EObject current=null] : iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF ;
    public final EObject entryRuleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedTerminalElement = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2104:70: (iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2105:2: iv_ruleParenthesizedTerminalElement= ruleParenthesizedTerminalElement EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.26" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4845);
            iv_ruleParenthesizedTerminalElement=ruleParenthesizedTerminalElement();
            _fsp--;

             current =iv_ruleParenthesizedTerminalElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4855); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2112:1: ruleParenthesizedTerminalElement returns [EObject current=null] : ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) ;
    public final EObject ruleParenthesizedTerminalElement() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalAlternatives = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2116:6: ( ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:1: ( ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')' )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives ) ')'
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:2: ( '(' this_TerminalAlternatives= ruleTerminalAlternatives )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2117:3: '(' this_TerminalAlternatives= ruleTerminalAlternatives
            {
            match(input,16,FOLLOW_16_in_ruleParenthesizedTerminalElement4890); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.26/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4912);
            this_TerminalAlternatives=ruleTerminalAlternatives();
            _fsp--;

             
                    current = this_TerminalAlternatives; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,18,FOLLOW_18_in_ruleParenthesizedTerminalElement4921); 

                    createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.26/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2143:1: entryRuleKeyword returns [EObject current=null] : iv_ruleKeyword= ruleKeyword EOF ;
    public final EObject entryRuleKeyword() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyword = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2143:49: (iv_ruleKeyword= ruleKeyword EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2144:2: iv_ruleKeyword= ruleKeyword EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.27" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKeyword_in_entryRuleKeyword4956);
            iv_ruleKeyword=ruleKeyword();
            _fsp--;

             current =iv_ruleKeyword; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyword4966); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2151:1: ruleKeyword returns [EObject current=null] : (lv_value= RULE_STRING ) ;
    public final EObject ruleKeyword() throws RecognitionException {
        EObject current = null;

        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2155:6: ( (lv_value= RULE_STRING ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2156:1: (lv_value= RULE_STRING )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2156:1: (lv_value= RULE_STRING )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2158:6: lv_value= RULE_STRING
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyword5011); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.27/@alternatives/@terminal" /* xtext::RuleCall */, "value"); 
                

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2185:1: entryRuleRuleCall returns [EObject current=null] : iv_ruleRuleCall= ruleRuleCall EOF ;
    public final EObject entryRuleRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleCall = null;


        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2185:50: (iv_ruleRuleCall= ruleRuleCall EOF )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2186:2: iv_ruleRuleCall= ruleRuleCall EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.28" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRuleCall_in_entryRuleRuleCall5056);
            iv_ruleRuleCall=ruleRuleCall();
            _fsp--;

             current =iv_ruleRuleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleCall5066); 

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
    // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2193:1: ruleRuleCall returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleRuleCall() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2197:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2198:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2198:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2201:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("RuleCall");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2207:1: ( RULE_ID )
            // ../org.eclipse.xtext.xtend.tests/./src-gen/org/eclipse/xtext/parser/antlr/internal/InternalXtextGrammarTestLanguage.g:2208:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRuleCall5114); 
             
                createLeafNode("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi#/0/@rules.28/@alternatives/@terminal" /* xtext::CrossReference */, "rule"); 
                

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
    public static final BitSet FOLLOW_11_in_ruleGrammar134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_12_in_ruleGrammar161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar183 = new BitSet(new long[]{0x0000000008E8E010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar205 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar226 = new BitSet(new long[]{0x0000000008E8E010L});
    public static final BitSet FOLLOW_14_in_ruleGrammar251 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar272 = new BitSet(new long[]{0x0000000008E8A010L});
    public static final BitSet FOLLOW_13_in_ruleGrammar294 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar315 = new BitSet(new long[]{0x0000000008E8A010L});
    public static final BitSet FOLLOW_15_in_ruleGrammar355 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleGrammar376 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar402 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleGrammar416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGrammar440 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleGrammar458 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_ruleGrammar495 = new BitSet(new long[]{0x0000000008E80010L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleGrammar535 = new BitSet(new long[]{0x0000000008C00012L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_entryRuleAbstractRule575 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRule585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_ruleAbstractRule633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_ruleAbstractRule660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleAbstractRule688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractMetamodelDeclaration_in_entryRuleAbstractMetamodelDeclaration722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractMetamodelDeclaration732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_ruleAbstractMetamodelDeclaration779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_ruleAbstractMetamodelDeclaration806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGeneratedMetamodel_in_entryRuleGeneratedMetamodel840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGeneratedMetamodel850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGeneratedMetamodel886 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel907 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGeneratedMetamodel943 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleGeneratedMetamodel958 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGeneratedMetamodel979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencedMetamodel_in_entryRuleReferencedMetamodel1027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencedMetamodel1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleReferencedMetamodel1072 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReferencedMetamodel1096 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleReferencedMetamodel1111 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencedMetamodel1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLexerRule_in_entryRuleLexerRule1180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLexerRule1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleLexerRule1229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_23_in_ruleLexerRule1244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLexerRule1266 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleLexerRule1288 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleLexerRule1322 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleLexerRule1338 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleLexerRule1360 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleLexerRule1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParserRule_in_entryRuleParserRule1416 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParserRule1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1476 = new BitSet(new long[]{0x0000000003008000L});
    public static final BitSet FOLLOW_24_in_ruleParserRule1497 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleParserRule1531 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_15_in_ruleParserRule1562 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleParserRule1583 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1609 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleParserRule1623 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleParserRule1647 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleParserRule1665 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleParserRule1677 = new BitSet(new long[]{0x0000041000010030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParserRule1712 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleParserRule1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_entryRuleTerminalRule1761 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalRule1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTerminalRule1821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTerminalRule1854 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleTerminalRule1876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleTerminalRule1910 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTerminalRule1926 = new BitSet(new long[]{0x0000018000012030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleTerminalRule1961 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTerminalRule1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeRef_in_entryRuleTypeRef2010 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeRef2020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2070 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTypeRef2083 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeRef2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlternatives_in_entryRuleAlternatives2148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlternatives2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2205 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleAlternatives2224 = new BitSet(new long[]{0x0000041000010030L});
    public static final BitSet FOLLOW_ruleGroup_in_ruleAlternatives2259 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_entryRuleTerminalAlternatives2300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalAlternatives2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2357 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleTerminalAlternatives2376 = new BitSet(new long[]{0x0000018000012030L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_ruleTerminalAlternatives2411 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleGroup_in_entryRuleGroup2452 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGroup2462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2509 = new BitSet(new long[]{0x0000041000010032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_ruleGroup2552 = new BitSet(new long[]{0x0000041000010032L});
    public static final BitSet FOLLOW_ruleTerminalGroup_in_entryRuleTerminalGroup2593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalGroup2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2650 = new BitSet(new long[]{0x0000018000012032L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_ruleTerminalGroup2693 = new BitSet(new long[]{0x0000018000012032L});
    public static final BitSet FOLLOW_ruleAbstractToken_in_entryRuleAbstractToken2734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractToken2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleAbstractToken2793 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAction_in_ruleAbstractToken2820 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAbstractToken2848 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleAbstractToken2871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleAbstractToken2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleAbstractToken2902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalToken_in_entryRuleTerminalToken2951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalToken2961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleTerminalToken3008 = new BitSet(new long[]{0x00000001C0000002L});
    public static final BitSet FOLLOW_30_in_ruleTerminalToken3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTerminalToken3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleTerminalToken3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment3110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment3120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssignment3167 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_33_in_ruleAssignment3201 = new BitSet(new long[]{0x0000040000010030L});
    public static final BitSet FOLLOW_34_in_ruleAssignment3216 = new BitSet(new long[]{0x0000040000010030L});
    public static final BitSet FOLLOW_35_in_ruleAssignment3232 = new BitSet(new long[]{0x0000040000010030L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_ruleAssignment3280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_entryRuleAction3319 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAction3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleAction3369 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_37_in_ruleAction3379 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleAction3425 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAction3439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAction3461 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_34_in_ruleAction3495 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_33_in_ruleAction3510 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleAction3533 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleAction3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractTerminal_in_entryRuleAbstractTerminal3578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractTerminal3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleAbstractTerminal3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleAbstractTerminal3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_ruleAbstractTerminal3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_ruleAbstractTerminal3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_entryRuleTerminalTokenElement3754 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerminalTokenElement3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_ruleTerminalTokenElement3814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_ruleTerminalTokenElement3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_ruleTerminalTokenElement3869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_ruleTerminalTokenElement3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_ruleTerminalTokenElement3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractNegatedToken_in_entryRuleAbstractNegatedToken3959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractNegatedToken3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_ruleAbstractNegatedToken4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_ruleAbstractNegatedToken4043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegatedToken_in_entryRuleNegatedToken4077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegatedToken4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleNegatedToken4121 = new BitSet(new long[]{0x0000018000012030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleNegatedToken4155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpToToken_in_entryRuleUpToToken4194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpToToken4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUpToToken4238 = new BitSet(new long[]{0x0000018000012030L});
    public static final BitSet FOLLOW_ruleTerminalTokenElement_in_ruleUpToToken4272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWildcard_in_entryRuleWildcard4311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWildcard4321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleWildcard4366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCharacterRange_in_entryRuleCharacterRange4412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCharacterRange4422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4469 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleCharacterRange4488 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleKeyword_in_ruleCharacterRange4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCrossReference_in_entryRuleCrossReference4564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCrossReference4574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCrossReference4610 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeRef_in_ruleCrossReference4644 = new BitSet(new long[]{0x0000080020000000L});
    public static final BitSet FOLLOW_29_in_ruleCrossReference4659 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCrossReference4683 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_ruleCrossReference4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedElement_in_entryRuleParenthesizedElement4734 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedElement4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedElement4779 = new BitSet(new long[]{0x0000041000010030L});
    public static final BitSet FOLLOW_ruleAlternatives_in_ruleParenthesizedElement4801 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleParenthesizedElement4810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedTerminalElement_in_entryRuleParenthesizedTerminalElement4845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedTerminalElement4855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleParenthesizedTerminalElement4890 = new BitSet(new long[]{0x0000018000012030L});
    public static final BitSet FOLLOW_ruleTerminalAlternatives_in_ruleParenthesizedTerminalElement4912 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleParenthesizedTerminalElement4921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyword_in_entryRuleKeyword4956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyword4966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyword5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleCall_in_entryRuleRuleCall5056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleCall5066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRuleCall5114 = new BitSet(new long[]{0x0000000000000002L});

}
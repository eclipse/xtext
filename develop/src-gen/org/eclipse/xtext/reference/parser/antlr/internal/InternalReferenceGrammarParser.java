package org.eclipse.xtext.reference.parser.antlr.internal; 

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

public class InternalReferenceGrammarParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "'keyword'", "','", "'ROT'", "'BLAU'", "'GELB'", "'GRÜN'", "'type'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=6;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalReferenceGrammarParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g"; }


     
        public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalReferenceGrammarParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:68:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:68:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:69:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz72);
            iv_ruleSpielplatz=ruleSpielplatz();
            _fsp--;

             current =iv_ruleSpielplatz; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielplatz82); 

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
    // $ANTLR end entryRuleSpielplatz


    // $ANTLR start ruleSpielplatz
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:76:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse=null;
        Token lv_beschreibung=null;
        EObject lv_kinder = null;

        EObject lv_erzieher = null;

        EObject lv_spielzeuge = null;

        EObject lv_familie = null;

        EObject lv_types = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:80:6: ( ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )? )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )?
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:1: ( ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* ) '}'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:2: ( ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )* )
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )*
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:3: ( ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{' )
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? ) '{'
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:4: ( ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )? )
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:5: ( 'spielplatz' (lv_groesse= RULE_INT ) ) (lv_beschreibung= RULE_STRING )?
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:5: ( 'spielplatz' (lv_groesse= RULE_INT ) )
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:81:6: 'spielplatz' (lv_groesse= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz120); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                        
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:85:1: (lv_groesse= RULE_INT )
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:87:6: lv_groesse= RULE_INT
                    {
                    lv_groesse=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz141); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "groesse"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Spielplatz");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "groesse", lv_groesse, "INT", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:105:3: (lv_beschreibung= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:107:6: lv_beschreibung= RULE_STRING
                            {
                            lv_beschreibung=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz174); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "beschreibung"); 
                                

                            	        if (current==null) {
                            	            current = factory.create("Spielplatz");
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	        	factory.set(current, "beschreibung", lv_beschreibung, "STRING", currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz196); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

                    }

                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:2: ( ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) ) | (lv_types= ruleCustomTypeParserRule ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==14||(LA5_0>=17 && LA5_0<=19)) ) {
                            alt5=1;
                        }
                        else if ( (LA5_0==26) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:3: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:3: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==14||(LA4_0>=17 && LA4_0<=18)) ) {
                    	        alt4=1;
                    	    }
                    	    else if ( (LA4_0==19) ) {
                    	        alt4=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("129:3: ( ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) ) | (lv_familie= ruleFamilie ) )", 4, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:4: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:4: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )
                    	            int alt3=2;
                    	            int LA3_0 = input.LA(1);

                    	            if ( (LA3_0==14||LA3_0==17) ) {
                    	                alt3=1;
                    	            }
                    	            else if ( (LA3_0==18) ) {
                    	                alt3=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("129:4: ( ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) ) | (lv_spielzeuge= ruleSpielzeug ) )", 3, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt3) {
                    	                case 1 :
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:5: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	                    {
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:5: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )
                    	                    int alt2=2;
                    	                    int LA2_0 = input.LA(1);

                    	                    if ( (LA2_0==14) ) {
                    	                        alt2=1;
                    	                    }
                    	                    else if ( (LA2_0==17) ) {
                    	                        alt2=2;
                    	                    }
                    	                    else {
                    	                        NoViableAltException nvae =
                    	                            new NoViableAltException("129:5: ( (lv_kinder= ruleKind ) | (lv_erzieher= ruleErwachsener ) )", 2, 0, input);

                    	                        throw nvae;
                    	                    }
                    	                    switch (alt2) {
                    	                        case 1 :
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:6: (lv_kinder= ruleKind )
                    	                            {
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:129:6: (lv_kinder= ruleKind )
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:6: lv_kinder= ruleKind
                    	                            {
                    	                             
                    	                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.0/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                            	    
                    	                            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz235);
                    	                            lv_kinder=ruleKind();
                    	                            _fsp--;


                    	                            	        if (current==null) {
                    	                            	            current = factory.create("Spielplatz");
                    	                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                            	        }
                    	                            	        
                    	                            	        try {
                    	                            	        	factory.add(current, "kinder", lv_kinder, "Kind", currentNode);
                    	                            	        } catch (ValueConverterException vce) {
                    	                            				handleValueConverterException(vce);
                    	                            	        }
                    	                            	        currentNode = currentNode.getParent();
                    	                            	    

                    	                            }


                    	                            }
                    	                            break;
                    	                        case 2 :
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:151:6: (lv_erzieher= ruleErwachsener )
                    	                            {
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:151:6: (lv_erzieher= ruleErwachsener )
                    	                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:154:6: lv_erzieher= ruleErwachsener
                    	                            {
                    	                             
                    	                            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                            	    
                    	                            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz279);
                    	                            lv_erzieher=ruleErwachsener();
                    	                            _fsp--;


                    	                            	        if (current==null) {
                    	                            	            current = factory.create("Spielplatz");
                    	                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                            	        }
                    	                            	        
                    	                            	        try {
                    	                            	        	factory.add(current, "erzieher", lv_erzieher, "Erwachsener", currentNode);
                    	                            	        } catch (ValueConverterException vce) {
                    	                            				handleValueConverterException(vce);
                    	                            	        }
                    	                            	        currentNode = currentNode.getParent();
                    	                            	    

                    	                            }


                    	                            }
                    	                            break;

                    	                    }


                    	                    }
                    	                    break;
                    	                case 2 :
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:173:6: (lv_spielzeuge= ruleSpielzeug )
                    	                    {
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:173:6: (lv_spielzeuge= ruleSpielzeug )
                    	                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:176:6: lv_spielzeuge= ruleSpielzeug
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz324);
                    	                    lv_spielzeuge=ruleSpielzeug();
                    	                    _fsp--;


                    	                    	        if (current==null) {
                    	                    	            current = factory.create("Spielplatz");
                    	                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                    	        }
                    	                    	        
                    	                    	        try {
                    	                    	        	factory.add(current, "spielzeuge", lv_spielzeuge, "Spielzeug", currentNode);
                    	                    	        } catch (ValueConverterException vce) {
                    	                    				handleValueConverterException(vce);
                    	                    	        }
                    	                    	        currentNode = currentNode.getParent();
                    	                    	    

                    	                    }


                    	                    }
                    	                    break;

                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:195:6: (lv_familie= ruleFamilie )
                    	            {
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:195:6: (lv_familie= ruleFamilie )
                    	            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:198:6: lv_familie= ruleFamilie
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.0/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz369);
                    	            lv_familie=ruleFamilie();
                    	            _fsp--;


                    	            	        if (current==null) {
                    	            	            current = factory.create("Spielplatz");
                    	            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	            	        }
                    	            	        
                    	            	        try {
                    	            	        	factory.add(current, "familie", lv_familie, "Familie", currentNode);
                    	            	        } catch (ValueConverterException vce) {
                    	            				handleValueConverterException(vce);
                    	            	        }
                    	            	        currentNode = currentNode.getParent();
                    	            	    

                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:217:6: (lv_types= ruleCustomTypeParserRule )
                    	    {
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:217:6: (lv_types= ruleCustomTypeParserRule )
                    	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:220:6: lv_types= ruleCustomTypeParserRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.0/@abstractTokens.1/@groups.1/@terminal" /* xtext::RuleCall */, currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz414);
                    	    lv_types=ruleCustomTypeParserRule();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create("Spielplatz");
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	        	factory.add(current, "types", lv_types, "CustomTypeParserRule", currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }

                    match(input,13,FOLLOW_13_in_ruleSpielplatz430); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.0/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                        

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
    // $ANTLR end ruleSpielplatz


    // $ANTLR start entryRuleKind
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:253:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:253:46: (iv_ruleKind= ruleKind EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:254:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind468);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind478); 

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
    // $ANTLR end entryRuleKind


    // $ANTLR start ruleKind
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:261:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:265:6: ( ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:1: ( ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:2: ( ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:3: ( ( 'kind' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:4: ( 'kind' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:4: ( 'kind' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:266:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind515); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleKind524); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:274:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:276:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind546); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:294:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:296:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind579); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Kind");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "age", lv_age, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind600); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.2/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleKind


    // $ANTLR start entryRuleErwachsener
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:327:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:327:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:328:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener635);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener645); 

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
    // $ANTLR end entryRuleErwachsener


    // $ANTLR start ruleErwachsener
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:335:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        Token lv_age=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:339:6: ( ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:1: ( ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:2: ( ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) ) (lv_age= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:3: ( ( 'erwachsener' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:4: ( 'erwachsener' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:4: ( 'erwachsener' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:340:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener682); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener691); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:348:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:350:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener713); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:368:3: (lv_age= RULE_INT )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:370:6: lv_age= RULE_INT
            {
            lv_age=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener746); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "age"); 
                

            	        if (current==null) {
            	            current = factory.create("Erwachsener");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "age", lv_age, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener767); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.3/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleErwachsener


    // $ANTLR start entryRuleSpielzeug
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:401:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:401:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:402:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug802);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug812); 

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
    // $ANTLR end entryRuleSpielzeug


    // $ANTLR start ruleSpielzeug
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:409:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;
        EObject lv_farbe = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:413:6: ( ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:1: ( ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:2: ( ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) ) (lv_farbe= ruleFarbe )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:3: ( ( 'spielzeug' '(' ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:4: ( 'spielzeug' '(' ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:4: ( 'spielzeug' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug849); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug858); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:422:2: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:424:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug880); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:442:3: (lv_farbe= ruleFarbe )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:445:6: lv_farbe= ruleFarbe
            {
             
            	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug926);
            lv_farbe=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create("Spielzeug");
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "farbe", lv_farbe, "Farbe", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug940); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.4/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleSpielzeug


    // $ANTLR start entryRuleFamilie
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:476:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:476:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:477:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie975);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie985); 

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
    // $ANTLR end entryRuleFamilie


    // $ANTLR start ruleFamilie
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:484:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:488:6: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* ) ')'
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )* )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ',' ( ( RULE_ID ) ) )*
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:3: ( ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:4: ( ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:5: ( ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:6: ( ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:7: ( 'familie' '(' ) (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:7: ( 'familie' '(' )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:489:8: 'familie' '('
            {
            match(input,19,FOLLOW_19_in_ruleFamilie1025); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1034); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:497:2: (lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:499:6: lv_name= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:499:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING||LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("499:14: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:499:15: ( 'keyword' | RULE_STRING )
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:499:15: ( 'keyword' | RULE_STRING )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==20) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==RULE_STRING) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("499:15: ( 'keyword' | RULE_STRING )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:499:16: 'keyword'
                            {
                            match(input,20,FOLLOW_20_in_ruleFamilie1058); 

                                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:504:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1073); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "name"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:509:6: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1088); 
                     
                        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal/@groups.1" /* xtext::RuleCall */, "name"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", input.LT(-1), null, currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:527:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:530:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:536:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:537:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1125); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "mutter"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:542:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:545:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:551:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:552:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1154); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "vater"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:557:3: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:560:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Familie");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:566:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:567:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1183); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
                

            }


            }


            }

            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:572:3: ( ',' ( ( RULE_ID ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:572:4: ',' ( ( RULE_ID ) )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleFamilie1198); 

            	            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:576:1: ( ( RULE_ID ) )
            	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:579:3: ( RULE_ID )
            	    {

            	    			if (current==null) {
            	    	            current = factory.create("Familie");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:585:1: ( RULE_ID )
            	    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:586:2: RULE_ID
            	    {
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1222); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "kinder"); 
            	        

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1238); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.5/@alternatives/@abstractTokens.1" /* xtext::Keyword */, null); 
                

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
    // $ANTLR end ruleFamilie


    // $ANTLR start entryRuleFarbe
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:604:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:604:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:605:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe1273);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe1283); 

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
    // $ANTLR end entryRuleFarbe


    // $ANTLR start ruleFarbe
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:612:1: ruleFarbe returns [EObject current=null] : (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:616:6: ( (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:617:1: (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:617:1: (lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:6: lv_wert= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:14: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=22 && LA12_0<=24)) ) {
                alt12=1;
            }
            else if ( (LA12_0==25) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("619:14: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GRÜN' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:15: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:15: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( ((LA11_0>=22 && LA11_0<=23)) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==24) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("619:15: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:16: ( 'ROT' | 'BLAU' )
                            {
                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:16: ( 'ROT' | 'BLAU' )
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0==22) ) {
                                alt10=1;
                            }
                            else if ( (LA10_0==23) ) {
                                alt10=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("619:16: ( 'ROT' | 'BLAU' )", 10, 0, input);

                                throw nvae;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:17: 'ROT'
                                    {
                                    match(input,22,FOLLOW_22_in_ruleFarbe1331); 

                                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.0/@groups.0" /* xtext::Keyword */, "wert"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:624:6: 'BLAU'
                                    {
                                    match(input,23,FOLLOW_23_in_ruleFarbe1346); 

                                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.0/@groups.1" /* xtext::Keyword */, "wert"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:629:6: 'GELB'
                            {
                            match(input,24,FOLLOW_24_in_ruleFarbe1362); 

                                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.0/@groups.1" /* xtext::Keyword */, "wert"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:6: 'GRÜN'
                    {
                    match(input,25,FOLLOW_25_in_ruleFarbe1378); 

                            createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.6/@alternatives/@terminal/@groups.1" /* xtext::Keyword */, "wert"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Farbe");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "wert", input.LT(-1), null, currentNode);
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
    // $ANTLR end ruleFarbe


    // $ANTLR start entryRuleCustomTypeParserRule
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:661:1: entryRuleCustomTypeParserRule returns [EObject current=null] : iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF ;
    public final EObject entryRuleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomTypeParserRule = null;


        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:661:62: (iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:662:2: iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1425);
            iv_ruleCustomTypeParserRule=ruleCustomTypeParserRule();
            _fsp--;

             current =iv_ruleCustomTypeParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomTypeParserRule1435); 

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
    // $ANTLR end entryRuleCustomTypeParserRule


    // $ANTLR start ruleCustomTypeParserRule
    // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:669:1: ruleCustomTypeParserRule returns [EObject current=null] : ( 'type' (lv_name= RULE_ID ) ) ;
    public final EObject ruleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:673:6: ( ( 'type' (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:674:1: ( 'type' (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:674:1: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:674:2: 'type' (lv_name= RULE_ID )
            {
            match(input,26,FOLLOW_26_in_ruleCustomTypeParserRule1469); 

                    createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:678:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:680:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1490); 
             
                createLeafNode("classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("CustomType");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleCustomTypeParserRule


 

    public static final BitSet FOLLOW_ruleSpielplatz_in_entryRuleSpielplatz72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielplatz82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSpielplatz120 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz141 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz174 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz196 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz235 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz279 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz324 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz369 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz414 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind468 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind515 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind524 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind579 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener682 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener691 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener713 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener746 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug849 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug858 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug880 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug926 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie975 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFamilie1025 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1034 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_20_in_ruleFamilie1058 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1073 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1088 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1125 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1154 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1183 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleFamilie1198 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1222 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe1273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFarbe1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFarbe1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomTypeParserRule1435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleCustomTypeParserRule1469 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1490 = new BitSet(new long[]{0x0000000000000002L});

}
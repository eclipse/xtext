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
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalReferenceGrammarParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'spielplatz'", "'{'", "'}'", "'kind'", "'('", "')'", "'erwachsener'", "'spielzeug'", "'familie'", "'keyword'", "','", "'ROT'", "'BLAU'", "'GELB'", "'GR\\u00DCN'", "'type'"
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
    public String getGrammarFileName() { return "../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g"; }


     
     	private ReferenceGrammarGrammarAccess grammarAccess;
     	
        public InternalReferenceGrammarParser(TokenStream input, IAstFactory factory, ReferenceGrammarGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Spielplatz";	
       	} 



    // $ANTLR start entryRuleSpielplatz
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:70:1: entryRuleSpielplatz returns [EObject current=null] : iv_ruleSpielplatz= ruleSpielplatz EOF ;
    public final EObject entryRuleSpielplatz() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielplatz = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:70:52: (iv_ruleSpielplatz= ruleSpielplatz EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:71:2: iv_ruleSpielplatz= ruleSpielplatz EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielplatz().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:78:1: ruleSpielplatz returns [EObject current=null] : ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )* ) '}' )? ;
    public final EObject ruleSpielplatz() throws RecognitionException {
        EObject current = null;

        Token lv_groesse_1=null;
        Token lv_beschreibung_2=null;
        EObject lv_kinder_4 = null;

        EObject lv_erzieher_5 = null;

        EObject lv_spielzeuge_6 = null;

        EObject lv_familie_7 = null;

        EObject lv_types_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:83:6: ( ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )* ) '}' )? )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:1: ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )* ) '}' )?
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:1: ( ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )* ) '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:2: ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )* ) '}'
                    {
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:2: ( ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )* )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:3: ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' ) ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )*
                    {
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:3: ( ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{' )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:4: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? ) '{'
                    {
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:4: ( ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )? )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:5: ( 'spielplatz' (lv_groesse_1= RULE_INT ) ) (lv_beschreibung_2= RULE_STRING )?
                    {
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:5: ( 'spielplatz' (lv_groesse_1= RULE_INT ) )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:84:6: 'spielplatz' (lv_groesse_1= RULE_INT )
                    {
                    match(input,11,FOLLOW_11_in_ruleSpielplatz120); 

                            createLeafNode(grammarAccess.prSpielplatz().ele00000KeywordSpielplatz(), null); 
                        
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:88:1: (lv_groesse_1= RULE_INT )
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:90:6: lv_groesse_1= RULE_INT
                    {
                    lv_groesse_1=(Token)input.LT(1);
                    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSpielplatz142); 

                    		createLeafNode(grammarAccess.prSpielplatz().ele000010LexerRuleCallINT(), "groesse"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "groesse", lv_groesse_1, "INT", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:108:3: (lv_beschreibung_2= RULE_STRING )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_STRING) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:110:6: lv_beschreibung_2= RULE_STRING
                            {
                            lv_beschreibung_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSpielplatz173); 

                            		createLeafNode(grammarAccess.prSpielplatz().ele00010LexerRuleCallSTRING(), "beschreibung"); 
                            	

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "beschreibung", lv_beschreibung_2, "STRING", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }

                    match(input,12,FOLLOW_12_in_ruleSpielplatz192); 

                            createLeafNode(grammarAccess.prSpielplatz().ele001KeywordLeftCurlyBracket(), null); 
                        

                    }

                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:2: ( ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) ) | (lv_types_8= ruleCustomTypeParserRule ) )*
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:3: ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:3: ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )
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
                    	            new NoViableAltException("132:3: ( ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) ) | (lv_familie_7= ruleFamilie ) )", 4, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:4: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )
                    	            {
                    	            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:4: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )
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
                    	                    new NoViableAltException("132:4: ( ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) ) | (lv_spielzeuge_6= ruleSpielzeug ) )", 3, 0, input);

                    	                throw nvae;
                    	            }
                    	            switch (alt3) {
                    	                case 1 :
                    	                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:5: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )
                    	                    {
                    	                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:5: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )
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
                    	                            new NoViableAltException("132:5: ( (lv_kinder_4= ruleKind ) | (lv_erzieher_5= ruleErwachsener ) )", 2, 0, input);

                    	                        throw nvae;
                    	                    }
                    	                    switch (alt2) {
                    	                        case 1 :
                    	                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:6: (lv_kinder_4= ruleKind )
                    	                            {
                    	                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:132:6: (lv_kinder_4= ruleKind )
                    	                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:135:6: lv_kinder_4= ruleKind
                    	                            {
                    	                             
                    	                            	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0100000ParserRuleCallKind(), currentNode); 
                    	                            	    
                    	                            pushFollow(FOLLOW_ruleKind_in_ruleSpielplatz231);
                    	                            lv_kinder_4=ruleKind();
                    	                            _fsp--;


                    	                            	        if (current==null) {
                    	                            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                            	        }
                    	                            	        
                    	                            	        try {
                    	                            	       		add(current, "kinder", lv_kinder_4, "Kind", currentNode);
                    	                            	        } catch (ValueConverterException vce) {
                    	                            				handleValueConverterException(vce);
                    	                            	        }
                    	                            	        currentNode = currentNode.getParent();
                    	                            	    

                    	                            }


                    	                            }
                    	                            break;
                    	                        case 2 :
                    	                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:154:6: (lv_erzieher_5= ruleErwachsener )
                    	                            {
                    	                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:154:6: (lv_erzieher_5= ruleErwachsener )
                    	                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:157:6: lv_erzieher_5= ruleErwachsener
                    	                            {
                    	                             
                    	                            	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0100010ParserRuleCallErwachsener(), currentNode); 
                    	                            	    
                    	                            pushFollow(FOLLOW_ruleErwachsener_in_ruleSpielplatz275);
                    	                            lv_erzieher_5=ruleErwachsener();
                    	                            _fsp--;


                    	                            	        if (current==null) {
                    	                            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                            	        }
                    	                            	        
                    	                            	        try {
                    	                            	       		add(current, "erzieher", lv_erzieher_5, "Erwachsener", currentNode);
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
                    	                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:176:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	                    {
                    	                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:176:6: (lv_spielzeuge_6= ruleSpielzeug )
                    	                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:179:6: lv_spielzeuge_6= ruleSpielzeug
                    	                    {
                    	                     
                    	                    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele010010ParserRuleCallSpielzeug(), currentNode); 
                    	                    	    
                    	                    pushFollow(FOLLOW_ruleSpielzeug_in_ruleSpielplatz320);
                    	                    lv_spielzeuge_6=ruleSpielzeug();
                    	                    _fsp--;


                    	                    	        if (current==null) {
                    	                    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	                    	        }
                    	                    	        
                    	                    	        try {
                    	                    	       		add(current, "spielzeuge", lv_spielzeuge_6, "Spielzeug", currentNode);
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
                    	            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:198:6: (lv_familie_7= ruleFamilie )
                    	            {
                    	            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:198:6: (lv_familie_7= ruleFamilie )
                    	            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:201:6: lv_familie_7= ruleFamilie
                    	            {
                    	             
                    	            	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele01010ParserRuleCallFamilie(), currentNode); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleFamilie_in_ruleSpielplatz365);
                    	            lv_familie_7=ruleFamilie();
                    	            _fsp--;


                    	            	        if (current==null) {
                    	            	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	            	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	            	        }
                    	            	        
                    	            	        try {
                    	            	       		add(current, "familie", lv_familie_7, "Familie", currentNode);
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
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:220:6: (lv_types_8= ruleCustomTypeParserRule )
                    	    {
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:220:6: (lv_types_8= ruleCustomTypeParserRule )
                    	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:223:6: lv_types_8= ruleCustomTypeParserRule
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.prSpielplatz().ele0110ParserRuleCallCustomTypeParserRule(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz410);
                    	    lv_types_8=ruleCustomTypeParserRule();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.prSpielplatz().getRule().getType().getType());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		add(current, "types", lv_types_8, "CustomTypeParserRule", currentNode);
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

                    match(input,13,FOLLOW_13_in_ruleSpielplatz426); 

                            createLeafNode(grammarAccess.prSpielplatz().ele1KeywordRightCurlyBracket(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:256:1: entryRuleKind returns [EObject current=null] : iv_ruleKind= ruleKind EOF ;
    public final EObject entryRuleKind() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKind = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:256:46: (iv_ruleKind= ruleKind EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:257:2: iv_ruleKind= ruleKind EOF
            {
             currentNode = createCompositeNode(grammarAccess.prKind().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleKind_in_entryRuleKind464);
            iv_ruleKind=ruleKind();
            _fsp--;

             current =iv_ruleKind; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKind474); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:264:1: ruleKind returns [EObject current=null] : ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) ;
    public final EObject ruleKind() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:269:6: ( ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:1: ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:1: ( ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:2: ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:2: ( ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:3: ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:3: ( ( 'kind' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:4: ( 'kind' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:4: ( 'kind' '(' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:270:5: 'kind' '('
            {
            match(input,14,FOLLOW_14_in_ruleKind511); 

                    createLeafNode(grammarAccess.prKind().ele0000KeywordKind(), null); 
                
            match(input,15,FOLLOW_15_in_ruleKind520); 

                    createLeafNode(grammarAccess.prKind().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:278:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:280:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKind543); 

            		createLeafNode(grammarAccess.prKind().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKind().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:298:3: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:300:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleKind574); 

            		createLeafNode(grammarAccess.prKind().ele010LexerRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prKind().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleKind592); 

                    createLeafNode(grammarAccess.prKind().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:331:1: entryRuleErwachsener returns [EObject current=null] : iv_ruleErwachsener= ruleErwachsener EOF ;
    public final EObject entryRuleErwachsener() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErwachsener = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:331:53: (iv_ruleErwachsener= ruleErwachsener EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:332:2: iv_ruleErwachsener= ruleErwachsener EOF
            {
             currentNode = createCompositeNode(grammarAccess.prErwachsener().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleErwachsener_in_entryRuleErwachsener627);
            iv_ruleErwachsener=ruleErwachsener();
            _fsp--;

             current =iv_ruleErwachsener; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleErwachsener637); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:339:1: ruleErwachsener returns [EObject current=null] : ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) ;
    public final EObject ruleErwachsener() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        Token lv_age_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:344:6: ( ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:1: ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:1: ( ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:2: ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) ) ')'
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:2: ( ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:3: ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) ) (lv_age_3= RULE_INT )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:3: ( ( 'erwachsener' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:4: ( 'erwachsener' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:4: ( 'erwachsener' '(' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:345:5: 'erwachsener' '('
            {
            match(input,17,FOLLOW_17_in_ruleErwachsener674); 

                    createLeafNode(grammarAccess.prErwachsener().ele0000KeywordErwachsener(), null); 
                
            match(input,15,FOLLOW_15_in_ruleErwachsener683); 

                    createLeafNode(grammarAccess.prErwachsener().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:353:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:355:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleErwachsener706); 

            		createLeafNode(grammarAccess.prErwachsener().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prErwachsener().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:373:3: (lv_age_3= RULE_INT )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:375:6: lv_age_3= RULE_INT
            {
            lv_age_3=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleErwachsener737); 

            		createLeafNode(grammarAccess.prErwachsener().ele010LexerRuleCallINT(), "age"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prErwachsener().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "age", lv_age_3, "INT", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleErwachsener755); 

                    createLeafNode(grammarAccess.prErwachsener().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:406:1: entryRuleSpielzeug returns [EObject current=null] : iv_ruleSpielzeug= ruleSpielzeug EOF ;
    public final EObject entryRuleSpielzeug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpielzeug = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:406:51: (iv_ruleSpielzeug= ruleSpielzeug EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:407:2: iv_ruleSpielzeug= ruleSpielzeug EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpielzeug().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug790);
            iv_ruleSpielzeug=ruleSpielzeug();
            _fsp--;

             current =iv_ruleSpielzeug; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpielzeug800); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:414:1: ruleSpielzeug returns [EObject current=null] : ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' ) ;
    public final EObject ruleSpielzeug() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;
        EObject lv_farbe_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:419:6: ( ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:1: ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:1: ( ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:2: ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) ) ')'
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:2: ( ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:3: ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) ) (lv_farbe_3= ruleFarbe )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:3: ( ( 'spielzeug' '(' ) (lv_name_2= RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:4: ( 'spielzeug' '(' ) (lv_name_2= RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:4: ( 'spielzeug' '(' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:420:5: 'spielzeug' '('
            {
            match(input,18,FOLLOW_18_in_ruleSpielzeug837); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0000KeywordSpielzeug(), null); 
                
            match(input,15,FOLLOW_15_in_ruleSpielzeug846); 

                    createLeafNode(grammarAccess.prSpielzeug().ele0001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:428:2: (lv_name_2= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:430:6: lv_name_2= RULE_ID
            {
            lv_name_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpielzeug869); 

            		createLeafNode(grammarAccess.prSpielzeug().ele0010LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpielzeug().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_2, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:448:3: (lv_farbe_3= ruleFarbe )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:451:6: lv_farbe_3= ruleFarbe
            {
             
            	        currentNode=createCompositeNode(grammarAccess.prSpielzeug().ele010ParserRuleCallFarbe(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleFarbe_in_ruleSpielzeug912);
            lv_farbe_3=ruleFarbe();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prSpielzeug().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        
            	        try {
            	       		set(current, "farbe", lv_farbe_3, "Farbe", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,16,FOLLOW_16_in_ruleSpielzeug926); 

                    createLeafNode(grammarAccess.prSpielzeug().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:482:1: entryRuleFamilie returns [EObject current=null] : iv_ruleFamilie= ruleFamilie EOF ;
    public final EObject entryRuleFamilie() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFamilie = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:482:49: (iv_ruleFamilie= ruleFamilie EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:483:2: iv_ruleFamilie= ruleFamilie EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFamilie().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFamilie_in_entryRuleFamilie961);
            iv_ruleFamilie=ruleFamilie();
            _fsp--;

             current =iv_ruleFamilie; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFamilie971); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:490:1: ruleFamilie returns [EObject current=null] : ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' ) ;
    public final EObject ruleFamilie() throws RecognitionException {
        EObject current = null;

        Token lv_name_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:495:6: ( ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:1: ( ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* ) ')'
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:2: ( ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )* )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:3: ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( ',' ( RULE_ID ) )*
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:3: ( ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:4: ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:4: ( ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:5: ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:5: ( ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:6: ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) ) ( RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:6: ( ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:7: ( 'familie' '(' ) (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:7: ( 'familie' '(' )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:496:8: 'familie' '('
            {
            match(input,19,FOLLOW_19_in_ruleFamilie1011); 

                    createLeafNode(grammarAccess.prFamilie().ele0000000KeywordFamilie(), null); 
                
            match(input,15,FOLLOW_15_in_ruleFamilie1020); 

                    createLeafNode(grammarAccess.prFamilie().ele0000001KeywordLeftParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:504:2: (lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:506:6: lv_name_2= ( ( 'keyword' | RULE_STRING ) | RULE_ID )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:506:16: ( ( 'keyword' | RULE_STRING ) | RULE_ID )
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
                    new NoViableAltException("506:16: ( ( 'keyword' | RULE_STRING ) | RULE_ID )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:506:17: ( 'keyword' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:506:17: ( 'keyword' | RULE_STRING )
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
                            new NoViableAltException("506:17: ( 'keyword' | RULE_STRING )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:506:18: 'keyword'
                            {
                            match(input,20,FOLLOW_20_in_ruleFamilie1044); 

                                    createLeafNode(grammarAccess.prFamilie().ele000001000KeywordKeyword(), "name"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:512:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFamilie1061); 

                            		createLeafNode(grammarAccess.prFamilie().ele000001001LexerRuleCallSTRING(), "name"); 
                            	

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:518:7: RULE_ID
                    {
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1075); 

                    		createLeafNode(grammarAccess.prFamilie().ele00000101LexerRuleCallID(), "name"); 
                    	

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", /* lv_name_2 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:537:3: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:540:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1108); 

            		createLeafNode(grammarAccess.prFamilie().ele000010CrossReferenceEStringErwachsener(), "mutter"); 
            	

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:553:3: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:556:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1134); 

            		createLeafNode(grammarAccess.prFamilie().ele00010CrossReferenceEStringErwachsener(), "vater"); 
            	

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:569:3: ( RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:572:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1160); 

            		createLeafNode(grammarAccess.prFamilie().ele0010CrossReferenceEStringKind(), "kinder"); 
            	

            }


            }

            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:585:3: ( ',' ( RULE_ID ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:585:4: ',' ( RULE_ID )
            	    {
            	    match(input,21,FOLLOW_21_in_ruleFamilie1174); 

            	            createLeafNode(grammarAccess.prFamilie().ele010KeywordComma(), null); 
            	        
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:589:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:592:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.prFamilie().getRule().getType().getType());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFamilie1196); 

            	    		createLeafNode(grammarAccess.prFamilie().ele0110CrossReferenceEStringKind(), "kinder"); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            match(input,16,FOLLOW_16_in_ruleFamilie1211); 

                    createLeafNode(grammarAccess.prFamilie().ele1KeywordRightParenthesis(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:618:1: entryRuleFarbe returns [EObject current=null] : iv_ruleFarbe= ruleFarbe EOF ;
    public final EObject entryRuleFarbe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFarbe = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:618:47: (iv_ruleFarbe= ruleFarbe EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:619:2: iv_ruleFarbe= ruleFarbe EOF
            {
             currentNode = createCompositeNode(grammarAccess.prFarbe().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleFarbe_in_entryRuleFarbe1246);
            iv_ruleFarbe=ruleFarbe();
            _fsp--;

             current =iv_ruleFarbe; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFarbe1256); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:626:1: ruleFarbe returns [EObject current=null] : (lv_wert_0= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) ) ;
    public final EObject ruleFarbe() throws RecognitionException {
        EObject current = null;

        Token lv_wert_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:631:6: ( (lv_wert_0= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:632:1: (lv_wert_0= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:632:1: (lv_wert_0= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:6: lv_wert_0= ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:16: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )
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
                    new NoViableAltException("634:16: ( ( ( 'ROT' | 'BLAU' ) | 'GELB' ) | 'GR\\u00DCN' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:17: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
                    {
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:17: ( ( 'ROT' | 'BLAU' ) | 'GELB' )
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
                            new NoViableAltException("634:17: ( ( 'ROT' | 'BLAU' ) | 'GELB' )", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:18: ( 'ROT' | 'BLAU' )
                            {
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:18: ( 'ROT' | 'BLAU' )
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
                                    new NoViableAltException("634:18: ( 'ROT' | 'BLAU' )", 10, 0, input);

                                throw nvae;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:634:19: 'ROT'
                                    {
                                    match(input,22,FOLLOW_22_in_ruleFarbe1304); 

                                            createLeafNode(grammarAccess.prFarbe().ele0000KeywordROT(), "wert"); 
                                        

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:640:6: 'BLAU'
                                    {
                                    match(input,23,FOLLOW_23_in_ruleFarbe1320); 

                                            createLeafNode(grammarAccess.prFarbe().ele0001KeywordBLAU(), "wert"); 
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:647:6: 'GELB'
                            {
                            match(input,24,FOLLOW_24_in_ruleFarbe1338); 

                                    createLeafNode(grammarAccess.prFarbe().ele001KeywordGELB(), "wert"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:654:6: 'GR\\u00DCN'
                    {
                    match(input,25,FOLLOW_25_in_ruleFarbe1356); 

                            createLeafNode(grammarAccess.prFarbe().ele01KeywordGRÜN(), "wert"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.prFarbe().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "wert", /* lv_wert_0 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:683:1: entryRuleCustomTypeParserRule returns [EObject current=null] : iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF ;
    public final EObject entryRuleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomTypeParserRule = null;


        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:683:62: (iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:684:2: iv_ruleCustomTypeParserRule= ruleCustomTypeParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.prCustomTypeParserRule().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1405);
            iv_ruleCustomTypeParserRule=ruleCustomTypeParserRule();
            _fsp--;

             current =iv_ruleCustomTypeParserRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomTypeParserRule1415); 

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
    // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:691:1: ruleCustomTypeParserRule returns [EObject current=null] : ( 'type' (lv_name_1= RULE_ID ) ) ;
    public final EObject ruleCustomTypeParserRule() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:696:6: ( ( 'type' (lv_name_1= RULE_ID ) ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:697:1: ( 'type' (lv_name_1= RULE_ID ) )
            {
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:697:1: ( 'type' (lv_name_1= RULE_ID ) )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:697:2: 'type' (lv_name_1= RULE_ID )
            {
            match(input,26,FOLLOW_26_in_ruleCustomTypeParserRule1449); 

                    createLeafNode(grammarAccess.prCustomTypeParserRule().ele0KeywordType(), null); 
                
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:701:1: (lv_name_1= RULE_ID )
            // ../org.eclipse.xtext.reference/src-gen/org/eclipse/xtext/reference/parser/antlr/internal/InternalReferenceGrammar.g:703:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1471); 

            		createLeafNode(grammarAccess.prCustomTypeParserRule().ele10LexerRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prCustomTypeParserRule().getRule().getType().getType());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
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
    public static final BitSet FOLLOW_RULE_INT_in_ruleSpielplatz142 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSpielplatz173 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSpielplatz192 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleSpielplatz231 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleErwachsener_in_ruleSpielplatz275 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_ruleSpielplatz320 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleFamilie_in_ruleSpielplatz365 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_ruleSpielplatz410 = new BitSet(new long[]{0x00000000040E6000L});
    public static final BitSet FOLLOW_13_in_ruleSpielplatz426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_entryRuleKind464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKind474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleKind511 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleKind520 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKind543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleKind574 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleKind592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleErwachsener_in_entryRuleErwachsener627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleErwachsener637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleErwachsener674 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleErwachsener683 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleErwachsener706 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleErwachsener737 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleErwachsener755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpielzeug_in_entryRuleSpielzeug790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpielzeug800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSpielzeug837 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSpielzeug846 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpielzeug869 = new BitSet(new long[]{0x0000000003C00000L});
    public static final BitSet FOLLOW_ruleFarbe_in_ruleSpielzeug912 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSpielzeug926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFamilie_in_entryRuleFamilie961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFamilie971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFamilie1011 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFamilie1020 = new BitSet(new long[]{0x0000000000100060L});
    public static final BitSet FOLLOW_20_in_ruleFamilie1044 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFamilie1061 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1075 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1108 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1134 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1160 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_21_in_ruleFamilie1174 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFamilie1196 = new BitSet(new long[]{0x0000000000210000L});
    public static final BitSet FOLLOW_16_in_ruleFamilie1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFarbe_in_entryRuleFarbe1246 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFarbe1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFarbe1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFarbe1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFarbe1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFarbe1356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomTypeParserRule_in_entryRuleCustomTypeParserRule1405 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomTypeParserRule1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleCustomTypeParserRule1449 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCustomTypeParserRule1471 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

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

public class InternalSimpleReconstrTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'!'", "'#'", "'='", "'type'", "'extends'", "'#2'", "'mykeyword1'", "'mykeyword2'", "'#3'", "'.'", "'#4'", "'myoption'", "'kw'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSimpleReconstrTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g"; }


     
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, IAstFactory factory, Grammar g) {
            this(input);
            this.factory = factory;
    		grammar = g;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = InternalSimpleReconstrTestLanguageParser.class.getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Op";	
       	} 



    // $ANTLR start entryRuleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:68:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:68:44: (iv_ruleOp= ruleOp EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:69:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleOp_in_entryRuleOp72);
            iv_ruleOp=ruleOp();
            _fsp--;

             current =iv_ruleOp; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOp82); 

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
    // $ANTLR end entryRuleOp


    // $ANTLR start ruleOp
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:76:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:80:6: ( (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:81:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:81:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:82:5: this_Term= ruleTerm ( () (lv_values= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.0" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp129);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                    currentNode = currentNode.getParent();
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:90:1: ( () (lv_values= ruleTerm ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||LA1_0==21||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:90:2: () (lv_values= ruleTerm )
            	    {
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:90:2: ()
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:91:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Action */, currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:106:2: (lv_values= ruleTerm )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:109:6: lv_values= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.0/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleTerm_in_ruleOp172);
            	    lv_values=ruleTerm();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create("Expression");
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "values", lv_values, "Term", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end ruleOp


    // $ANTLR start entryRuleTerm
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:136:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:136:46: (iv_ruleTerm= ruleTerm EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:137:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm213);
            iv_ruleTerm=ruleTerm();
            _fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm223); 

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
    // $ANTLR end entryRuleTerm


    // $ANTLR start ruleTerm
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:144:1: ruleTerm returns [EObject current=null] : ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Atom = null;

        EObject this_TwoNumbers = null;

        EObject this_ManyStrings = null;

        EObject this_Parens = null;

        EObject this_Type = null;

        EObject this_Ref2 = null;

        EObject this_Spare = null;

        EObject this_Boolean = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:148:6: ( ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:1: ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:1: ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_INT)||LA8_0==11||(LA8_0>=15 && LA8_0<=16)||LA8_0==18||LA8_0==21) ) {
                alt8=1;
            }
            else if ( (LA8_0==23) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("149:1: ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:2: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare )
                    {
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:2: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_INT)||LA7_0==11||(LA7_0>=15 && LA7_0<=16)||LA7_0==18) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==21) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("149:2: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:3: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )
                            {
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:3: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( ((LA6_0>=RULE_ID && LA6_0<=RULE_INT)||LA6_0==11||(LA6_0>=15 && LA6_0<=16)) ) {
                                alt6=1;
                            }
                            else if ( (LA6_0==18) ) {
                                alt6=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("149:3: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:4: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )
                                    {
                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:4: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )
                                    int alt5=2;
                                    int LA5_0 = input.LA(1);

                                    if ( ((LA5_0>=RULE_ID && LA5_0<=RULE_INT)||LA5_0==11||LA5_0==15) ) {
                                        alt5=1;
                                    }
                                    else if ( (LA5_0==16) ) {
                                        alt5=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("149:4: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )", 5, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt5) {
                                        case 1 :
                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:5: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )
                                            {
                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:5: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )
                                            int alt4=2;
                                            int LA4_0 = input.LA(1);

                                            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_INT)||LA4_0==15) ) {
                                                alt4=1;
                                            }
                                            else if ( (LA4_0==11) ) {
                                                alt4=2;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("149:5: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )", 4, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt4) {
                                                case 1 :
                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:6: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )
                                                    {
                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:6: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )
                                                    int alt3=2;
                                                    int LA3_0 = input.LA(1);

                                                    if ( ((LA3_0>=RULE_ID && LA3_0<=RULE_INT)) ) {
                                                        alt3=1;
                                                    }
                                                    else if ( (LA3_0==15) ) {
                                                        alt3=2;
                                                    }
                                                    else {
                                                        NoViableAltException nvae =
                                                            new NoViableAltException("149:6: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )", 3, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt3) {
                                                        case 1 :
                                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:7: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )
                                                            {
                                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:149:7: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )
                                                            int alt2=2;
                                                            int LA2_0 = input.LA(1);

                                                            if ( (LA2_0==RULE_ID) ) {
                                                                alt2=1;
                                                            }
                                                            else if ( (LA2_0==RULE_INT) ) {
                                                                alt2=2;
                                                            }
                                                            else {
                                                                NoViableAltException nvae =
                                                                    new NoViableAltException("149:7: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )", 2, 0, input);

                                                                throw nvae;
                                                            }
                                                            switch (alt2) {
                                                                case 1 :
                                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:150:5: this_Atom= ruleAtom
                                                                    {
                                                                     
                                                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0" /* xtext::RuleCall */, currentNode); 
                                                                        
                                                                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm276);
                                                                    this_Atom=ruleAtom();
                                                                    _fsp--;

                                                                     
                                                                            current = this_Atom; 
                                                                            currentNode = currentNode.getParent();
                                                                        

                                                                    }
                                                                    break;
                                                                case 2 :
                                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:160:5: this_TwoNumbers= ruleTwoNumbers
                                                                    {
                                                                     
                                                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                                        
                                                                    pushFollow(FOLLOW_ruleTwoNumbers_in_ruleTerm303);
                                                                    this_TwoNumbers=ruleTwoNumbers();
                                                                    _fsp--;

                                                                     
                                                                            current = this_TwoNumbers; 
                                                                            currentNode = currentNode.getParent();
                                                                        

                                                                    }
                                                                    break;

                                                            }


                                                            }
                                                            break;
                                                        case 2 :
                                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:170:5: this_ManyStrings= ruleManyStrings
                                                            {
                                                             
                                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                                
                                                            pushFollow(FOLLOW_ruleManyStrings_in_ruleTerm331);
                                                            this_ManyStrings=ruleManyStrings();
                                                            _fsp--;

                                                             
                                                                    current = this_ManyStrings; 
                                                                    currentNode = currentNode.getParent();
                                                                

                                                            }
                                                            break;

                                                    }


                                                    }
                                                    break;
                                                case 2 :
                                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:180:5: this_Parens= ruleParens
                                                    {
                                                     
                                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                        
                                                    pushFollow(FOLLOW_ruleParens_in_ruleTerm359);
                                                    this_Parens=ruleParens();
                                                    _fsp--;

                                                     
                                                            current = this_Parens; 
                                                            currentNode = currentNode.getParent();
                                                        

                                                    }
                                                    break;

                                            }


                                            }
                                            break;
                                        case 2 :
                                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:190:5: this_Type= ruleType
                                            {
                                             
                                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                                
                                            pushFollow(FOLLOW_ruleType_in_ruleTerm387);
                                            this_Type=ruleType();
                                            _fsp--;

                                             
                                                    current = this_Type; 
                                                    currentNode = currentNode.getParent();
                                                

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:200:5: this_Ref2= ruleRef2
                                    {
                                     
                                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                        
                                    pushFollow(FOLLOW_ruleRef2_in_ruleTerm415);
                                    this_Ref2=ruleRef2();
                                    _fsp--;

                                     
                                            current = this_Ref2; 
                                            currentNode = currentNode.getParent();
                                        

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:210:5: this_Spare= ruleSpare
                            {
                             
                                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.0/@groups.1" /* xtext::RuleCall */, currentNode); 
                                
                            pushFollow(FOLLOW_ruleSpare_in_ruleTerm443);
                            this_Spare=ruleSpare();
                            _fsp--;

                             
                                    current = this_Spare; 
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:220:5: this_Boolean= ruleBoolean
                    {
                     
                            currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.1/@alternatives/@groups.1" /* xtext::RuleCall */, currentNode); 
                        
                    pushFollow(FOLLOW_ruleBoolean_in_ruleTerm471);
                    this_Boolean=ruleBoolean();
                    _fsp--;

                     
                            current = this_Boolean; 
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
    // $ANTLR end ruleTerm


    // $ANTLR start entryRuleAtom
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:237:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:237:46: (iv_ruleAtom= ruleAtom EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:238:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.2" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleAtom_in_entryRuleAtom505);
            iv_ruleAtom=ruleAtom();
            _fsp--;

             current =iv_ruleAtom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAtom515); 

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
    // $ANTLR end entryRuleAtom


    // $ANTLR start ruleAtom
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:245:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:249:6: ( (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:250:1: (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:250:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:252:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom560); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.2/@alternatives/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Atom");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
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
    // $ANTLR end ruleAtom


    // $ANTLR start entryRuleParens
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:279:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:279:48: (iv_ruleParens= ruleParens EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:280:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleParens_in_entryRuleParens605);
            iv_ruleParens=ruleParens();
            _fsp--;

             current =iv_ruleParens; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParens615); 

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
    // $ANTLR end entryRuleParens


    // $ANTLR start ruleParens
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:287:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:291:6: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:3: ( '(' this_Op= ruleOp )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:292:4: '(' this_Op= ruleOp
            {
            match(input,11,FOLLOW_11_in_ruleParens651); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
             
                    currentNode=createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1" /* xtext::RuleCall */, currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens673);
            this_Op=ruleOp();
            _fsp--;

             
                    current = this_Op; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,12,FOLLOW_12_in_ruleParens682); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:309:2: (lv_em= '!' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:311:6: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParens704); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.3/@alternatives/@abstractTokens.1/@terminal" /* xtext::Keyword */, "em"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Expression");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "em", input.LT(-1), "!", currentNode);
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
    // $ANTLR end ruleParens


    // $ANTLR start entryRuleTwoNumbers
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:338:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:338:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:339:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers752);
            iv_ruleTwoNumbers=ruleTwoNumbers();
            _fsp--;

             current =iv_ruleTwoNumbers; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTwoNumbers762); 

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
    // $ANTLR end entryRuleTwoNumbers


    // $ANTLR start ruleTwoNumbers
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:346:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1=null;
        Token lv_num2=null;
        Token lv_num3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:350:6: ( ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:351:1: ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:351:1: ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:351:2: ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )*
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:351:2: ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:351:3: (lv_num1= RULE_INT ) (lv_num2= RULE_INT )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:351:3: (lv_num1= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:6: lv_num1= RULE_INT
            {
            lv_num1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers809); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.0/@terminal" /* xtext::RuleCall */, "num1"); 
                

            	        if (current==null) {
            	            current = factory.create("TwoNumbers");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "num1", lv_num1, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:371:2: (lv_num2= RULE_INT )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:373:6: lv_num2= RULE_INT
            {
            lv_num2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers841); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "num2"); 
                

            	        if (current==null) {
            	            current = factory.create("TwoNumbers");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "num2", lv_num2, "INT", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:391:3: ( '#' (lv_num3= RULE_INT ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:391:4: '#' (lv_num3= RULE_INT )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTwoNumbers863); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:395:1: (lv_num3= RULE_INT )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:397:6: lv_num3= RULE_INT
            	    {
            	    lv_num3=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers884); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.4/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "num3"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("TwoNumbers");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "num3", lv_num3, "INT", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // $ANTLR end ruleTwoNumbers


    // $ANTLR start entryRuleManyStrings
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:424:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:424:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:425:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleManyStrings_in_entryRuleManyStrings932);
            iv_ruleManyStrings=ruleManyStrings();
            _fsp--;

             current =iv_ruleManyStrings; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleManyStrings942); 

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
    // $ANTLR end entryRuleManyStrings


    // $ANTLR start ruleManyStrings
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:432:1: ruleManyStrings returns [EObject current=null] : ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token lv_str1=null;
        Token lv_str2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:436:6: ( ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:437:1: ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:437:1: ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:437:2: ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:437:2: ( '=' (lv_str1= RULE_STRING )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:437:3: '=' (lv_str1= RULE_STRING )*
            {
            match(input,15,FOLLOW_15_in_ruleManyStrings977); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:441:1: (lv_str1= RULE_STRING )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_STRING) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==RULE_STRING) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:443:6: lv_str1= RULE_STRING
            	    {
            	    lv_str1=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings998); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "str1"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("ManyStrings");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "str1", lv_str1, "STRING", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:461:4: (lv_str2= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:6: lv_str2= RULE_STRING
            {
            lv_str2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1032); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.5/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "str2"); 
                

            	        if (current==null) {
            	            current = factory.create("ManyStrings");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "str2", lv_str2, "STRING", currentNode);
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
    // $ANTLR end ruleManyStrings


    // $ANTLR start entryRuleType
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:490:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:490:46: (iv_ruleType= ruleType EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:491:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType1078);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType1088); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:498:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:502:6: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:3: ( 'type' (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:503:4: 'type' (lv_name= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleType1124); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:507:1: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:509:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1145); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "name"); 
                

            	        if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "name", lv_name, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,17,FOLLOW_17_in_ruleType1166); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:531:2: ( ( RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:534:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:540:1: ( RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:541:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1191); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.6/@alternatives/@abstractTokens.1/@terminal" /* xtext::CrossReference */, "extends"); 
                

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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleRef2
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:555:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:555:46: (iv_ruleRef2= ruleRef2 EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:556:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleRef2_in_entryRuleRef21230);
            iv_ruleRef2=ruleRef2();
            _fsp--;

             current =iv_ruleRef2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRef21240); 

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
    // $ANTLR end entryRuleRef2


    // $ANTLR start ruleRef2
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:563:1: ruleRef2 returns [EObject current=null] : ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:567:6: ( ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:568:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:568:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:568:2: '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            {
            match(input,18,FOLLOW_18_in_ruleRef21274); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:572:1: (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:6: lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:14: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING||LA13_0==19) ) {
                alt13=1;
            }
            else if ( (LA13_0==20) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("574:14: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:15: ( 'mykeyword1' | RULE_STRING )
                    {
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:15: ( 'mykeyword1' | RULE_STRING )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==19) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_STRING) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("574:15: ( 'mykeyword1' | RULE_STRING )", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:16: 'mykeyword1'
                            {
                            match(input,19,FOLLOW_19_in_ruleRef21297); 

                                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.0" /* xtext::Keyword */, "ref2"); 
                                

                            }
                            break;
                        case 2 :
                            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:579:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef21312); 
                             
                                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.0/@groups.1" /* xtext::RuleCall */, "ref2"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:584:6: 'mykeyword2'
                    {
                    match(input,20,FOLLOW_20_in_ruleRef21327); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.7/@alternatives/@abstractTokens.1/@terminal/@groups.1" /* xtext::Keyword */, "ref2"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create("Ref2");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "ref2", input.LT(-1), null, currentNode);
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
    // $ANTLR end ruleRef2


    // $ANTLR start entryRuleSpare
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:611:47: (iv_ruleSpare= ruleSpare EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:612:2: iv_ruleSpare= ruleSpare EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleSpare_in_entryRuleSpare1375);
            iv_ruleSpare=ruleSpare();
            _fsp--;

             current =iv_ruleSpare; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpare1385); 

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
    // $ANTLR end entryRuleSpare


    // $ANTLR start ruleSpare
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:619:1: ruleSpare returns [EObject current=null] : ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token lv_id=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:623:6: ( ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:624:1: ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:624:1: ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:624:2: ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )*
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:624:2: ( '#3' (lv_id= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:624:3: '#3' (lv_id= RULE_ID )
            {
            match(input,21,FOLLOW_21_in_ruleSpare1420); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:628:1: (lv_id= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:630:6: lv_id= RULE_ID
            {
            lv_id=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1441); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "id"); 
                

            	        if (current==null) {
            	            current = factory.create("Spare");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.add(current, "id", lv_id, "ID", currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:648:3: ( '.' (lv_id= RULE_ID ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:648:4: '.' (lv_id= RULE_ID )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleSpare1463); 

            	            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.0" /* xtext::Keyword */, null); 
            	        
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:652:1: (lv_id= RULE_ID )
            	    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:654:6: lv_id= RULE_ID
            	    {
            	    lv_id=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1484); 
            	     
            	        createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.8/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "id"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create("Spare");
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	        	factory.add(current, "id", lv_id, "ID", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end ruleSpare


    // $ANTLR start entryRuleBoolean
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:681:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:681:49: (iv_ruleBoolean= ruleBoolean EOF )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:682:2: iv_ruleBoolean= ruleBoolean EOF
            {
             currentNode = createCompositeNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.9" /* xtext::ParserRule */, currentNode); 
            pushFollow(FOLLOW_ruleBoolean_in_entryRuleBoolean1532);
            iv_ruleBoolean=ruleBoolean();
            _fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBoolean1542); 

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
    // $ANTLR end entryRuleBoolean


    // $ANTLR start ruleBoolean
    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:689:1: ruleBoolean returns [EObject current=null] : ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool=null;
        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:693:6: ( ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:1: ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:1: ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:2: ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:2: ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:3: ( '#4' (lv_bool= 'myoption' )? ) 'kw'
            {
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:3: ( '#4' (lv_bool= 'myoption' )? )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:694:4: '#4' (lv_bool= 'myoption' )?
            {
            match(input,23,FOLLOW_23_in_ruleBoolean1578); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.0" /* xtext::Keyword */, null); 
                
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:698:1: (lv_bool= 'myoption' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:700:6: lv_bool= 'myoption'
                    {
                    lv_bool=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleBoolean1599); 

                            createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.0/@abstractTokens.1/@terminal" /* xtext::Keyword */, "bool"); 
                        

                    	        if (current==null) {
                    	            current = factory.create("Boolean");
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	        	factory.set(current, "bool", true, "myoption", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }
                    break;

            }


            }

            match(input,25,FOLLOW_25_in_ruleBoolean1622); 

                    createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.0/@abstractTokens.1" /* xtext::Keyword */, null); 
                

            }

            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:722:2: (lv_value= RULE_ID )
            // ./src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:724:6: lv_value= RULE_ID
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBoolean1644); 
             
                createLeafNode("classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi#//@rules.9/@alternatives/@abstractTokens.1/@terminal" /* xtext::RuleCall */, "value"); 
                

            	        if (current==null) {
            	            current = factory.create("Boolean");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	        	factory.set(current, "value", lv_value, "ID", currentNode);
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
    // $ANTLR end ruleBoolean


 

    public static final BitSet FOLLOW_ruleOp_in_entryRuleOp72 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOp82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp129 = new BitSet(new long[]{0x0000000000A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleOp172 = new BitSet(new long[]{0x0000000000A58832L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_ruleTerm276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_ruleTerm303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_ruleTerm331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_ruleTerm359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_ruleTerm387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_ruleTerm415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_ruleTerm443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBoolean_in_ruleTerm471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAtom_in_entryRuleAtom505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAtom515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAtom560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParens_in_entryRuleParens605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParens615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleParens651 = new BitSet(new long[]{0x0000000000A58830L});
    public static final BitSet FOLLOW_ruleOp_in_ruleParens673 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleParens682 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleParens704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTwoNumbers_in_entryRuleTwoNumbers752 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTwoNumbers762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers809 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers841 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleTwoNumbers863 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleTwoNumbers884 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ruleManyStrings_in_entryRuleManyStrings932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleManyStrings942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleManyStrings977 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings998 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleManyStrings1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType1078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleType1124 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1145 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleType1166 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleType1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRef2_in_entryRuleRef21230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRef21240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRef21274 = new BitSet(new long[]{0x0000000000180040L});
    public static final BitSet FOLLOW_19_in_ruleRef21297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRef21312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleRef21327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpare_in_entryRuleSpare1375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpare1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleSpare1420 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1441 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleSpare1463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSpare1484 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleBoolean_in_entryRuleBoolean1532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBoolean1542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleBoolean1578 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_24_in_ruleBoolean1599 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleBoolean1622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleBoolean1644 = new BitSet(new long[]{0x0000000000000002L});

}
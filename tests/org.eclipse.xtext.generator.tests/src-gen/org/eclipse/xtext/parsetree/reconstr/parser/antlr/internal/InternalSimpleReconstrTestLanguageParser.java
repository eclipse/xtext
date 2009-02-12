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
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;



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
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g"; }


     
     	private SimpleReconstrTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSimpleReconstrTestLanguageParser(TokenStream input, IAstFactory factory, SimpleReconstrTestLanguageGrammarAccess grammarAccess) {
            super(input, factory, grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:70:1: entryRuleOp returns [EObject current=null] : iv_ruleOp= ruleOp EOF ;
    public final EObject entryRuleOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOp = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:70:44: (iv_ruleOp= ruleOp EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:71:2: iv_ruleOp= ruleOp EOF
            {
             currentNode = createCompositeNode(grammarAccess.prOp().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:78:1: ruleOp returns [EObject current=null] : (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) ;
    public final EObject ruleOp() throws RecognitionException {
        EObject current = null;

        EObject this_Term = null;

        EObject lv_values = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:82:6: ( (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:83:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:83:1: (this_Term= ruleTerm ( () (lv_values= ruleTerm ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:84:5: this_Term= ruleTerm ( () (lv_values= ruleTerm ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.prOp().ele0ParserRuleCallTerm(), currentNode); 
                
            pushFollow(FOLLOW_ruleTerm_in_ruleOp129);
            this_Term=ruleTerm();
            _fsp--;

             
                    current = this_Term; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:92:1: ( () (lv_values= ruleTerm ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_INT)||LA1_0==11||(LA1_0>=15 && LA1_0<=16)||LA1_0==18||LA1_0==21||LA1_0==23) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:92:2: () (lv_values= ruleTerm )
            	    {
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:92:2: ()
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:93:5: 
            	    {
            	     
            	            temp=factory.create("Op");
            	            try {
            	            	factory.add(temp, "values", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.prOp().ele10ActionOpvalues(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:108:2: (lv_values= ruleTerm )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:111:6: lv_values= ruleTerm
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.prOp().ele110ParserRuleCallTerm(), currentNode); 
            	    	    
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:138:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:138:46: (iv_ruleTerm= ruleTerm EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:139:2: iv_ruleTerm= ruleTerm EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTerm().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:146:1: ruleTerm returns [EObject current=null] : ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean ) ;
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
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:150:6: ( ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:1: ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:1: ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean )
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
                    new NoViableAltException("151:1: ( ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare ) | this_Boolean= ruleBoolean )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:2: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:2: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare )
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
                            new NoViableAltException("151:2: ( ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 ) | this_Spare= ruleSpare )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:3: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )
                            {
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:3: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )
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
                                    new NoViableAltException("151:3: ( ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType ) | this_Ref2= ruleRef2 )", 6, 0, input);

                                throw nvae;
                            }
                            switch (alt6) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:4: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )
                                    {
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:4: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )
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
                                            new NoViableAltException("151:4: ( ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens ) | this_Type= ruleType )", 5, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt5) {
                                        case 1 :
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:5: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )
                                            {
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:5: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )
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
                                                    new NoViableAltException("151:5: ( ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings ) | this_Parens= ruleParens )", 4, 0, input);

                                                throw nvae;
                                            }
                                            switch (alt4) {
                                                case 1 :
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:6: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )
                                                    {
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:6: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )
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
                                                            new NoViableAltException("151:6: ( (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers ) | this_ManyStrings= ruleManyStrings )", 3, 0, input);

                                                        throw nvae;
                                                    }
                                                    switch (alt3) {
                                                        case 1 :
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:7: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )
                                                            {
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:151:7: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )
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
                                                                    new NoViableAltException("151:7: (this_Atom= ruleAtom | this_TwoNumbers= ruleTwoNumbers )", 2, 0, input);

                                                                throw nvae;
                                                            }
                                                            switch (alt2) {
                                                                case 1 :
                                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:152:5: this_Atom= ruleAtom
                                                                    {
                                                                     
                                                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele0000000ParserRuleCallAtom(), currentNode); 
                                                                        
                                                                    pushFollow(FOLLOW_ruleAtom_in_ruleTerm276);
                                                                    this_Atom=ruleAtom();
                                                                    _fsp--;

                                                                     
                                                                            current = this_Atom; 
                                                                            currentNode = currentNode.getParent();
                                                                        

                                                                    }
                                                                    break;
                                                                case 2 :
                                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:162:5: this_TwoNumbers= ruleTwoNumbers
                                                                    {
                                                                     
                                                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele0000001ParserRuleCallTwoNumbers(), currentNode); 
                                                                        
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
                                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:172:5: this_ManyStrings= ruleManyStrings
                                                            {
                                                             
                                                                    currentNode=createCompositeNode(grammarAccess.prTerm().ele000001ParserRuleCallManyStrings(), currentNode); 
                                                                
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
                                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:182:5: this_Parens= ruleParens
                                                    {
                                                     
                                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele00001ParserRuleCallParens(), currentNode); 
                                                        
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
                                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:192:5: this_Type= ruleType
                                            {
                                             
                                                    currentNode=createCompositeNode(grammarAccess.prTerm().ele0001ParserRuleCallType(), currentNode); 
                                                
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
                                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:202:5: this_Ref2= ruleRef2
                                    {
                                     
                                            currentNode=createCompositeNode(grammarAccess.prTerm().ele001ParserRuleCallRef2(), currentNode); 
                                        
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
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:212:5: this_Spare= ruleSpare
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prTerm().ele01ParserRuleCallSpare(), currentNode); 
                                
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
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:222:5: this_Boolean= ruleBoolean
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prTerm().ele1ParserRuleCallBoolean(), currentNode); 
                        
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:239:1: entryRuleAtom returns [EObject current=null] : iv_ruleAtom= ruleAtom EOF ;
    public final EObject entryRuleAtom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtom = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:239:46: (iv_ruleAtom= ruleAtom EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:240:2: iv_ruleAtom= ruleAtom EOF
            {
             currentNode = createCompositeNode(grammarAccess.prAtom().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:247:1: ruleAtom returns [EObject current=null] : (lv_name= RULE_ID ) ;
    public final EObject ruleAtom() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:251:6: ( (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:252:1: (lv_name= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:252:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:254:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAtom560); 
             
                createLeafNode(grammarAccess.prAtom().ele0LexerRuleCallID(), "name"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:281:1: entryRuleParens returns [EObject current=null] : iv_ruleParens= ruleParens EOF ;
    public final EObject entryRuleParens() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParens = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:281:48: (iv_ruleParens= ruleParens EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:282:2: iv_ruleParens= ruleParens EOF
            {
             currentNode = createCompositeNode(grammarAccess.prParens().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:289:1: ruleParens returns [EObject current=null] : ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) ;
    public final EObject ruleParens() throws RecognitionException {
        EObject current = null;

        Token lv_em=null;
        EObject this_Op = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:293:6: ( ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:1: ( ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:2: ( ( '(' this_Op= ruleOp ) ')' ) (lv_em= '!' )?
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:2: ( ( '(' this_Op= ruleOp ) ')' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:3: ( '(' this_Op= ruleOp ) ')'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:3: ( '(' this_Op= ruleOp )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:294:4: '(' this_Op= ruleOp
            {
            match(input,11,FOLLOW_11_in_ruleParens651); 

                    createLeafNode(grammarAccess.prParens().ele000KeywordLeftParenthesis(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.prParens().ele001ParserRuleCallOp(), currentNode); 
                
            pushFollow(FOLLOW_ruleOp_in_ruleParens673);
            this_Op=ruleOp();
            _fsp--;

             
                    current = this_Op; 
                    currentNode = currentNode.getParent();
                

            }

            match(input,12,FOLLOW_12_in_ruleParens682); 

                    createLeafNode(grammarAccess.prParens().ele01KeywordRightParenthesis(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:311:2: (lv_em= '!' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==13) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:313:6: lv_em= '!'
                    {
                    lv_em=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleParens704); 

                            createLeafNode(grammarAccess.prParens().ele10KeywordExclamationMark(), "em"); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:340:1: entryRuleTwoNumbers returns [EObject current=null] : iv_ruleTwoNumbers= ruleTwoNumbers EOF ;
    public final EObject entryRuleTwoNumbers() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTwoNumbers = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:340:52: (iv_ruleTwoNumbers= ruleTwoNumbers EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:341:2: iv_ruleTwoNumbers= ruleTwoNumbers EOF
            {
             currentNode = createCompositeNode(grammarAccess.prTwoNumbers().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:348:1: ruleTwoNumbers returns [EObject current=null] : ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* ) ;
    public final EObject ruleTwoNumbers() throws RecognitionException {
        EObject current = null;

        Token lv_num1=null;
        Token lv_num2=null;
        Token lv_num3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:352:6: ( ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:1: ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:1: ( ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:2: ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) ) ( '#' (lv_num3= RULE_INT ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:2: ( (lv_num1= RULE_INT ) (lv_num2= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:3: (lv_num1= RULE_INT ) (lv_num2= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:353:3: (lv_num1= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:355:6: lv_num1= RULE_INT
            {
            lv_num1=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers809); 
             
                createLeafNode(grammarAccess.prTwoNumbers().ele000LexerRuleCallINT(), "num1"); 
                

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:373:2: (lv_num2= RULE_INT )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:375:6: lv_num2= RULE_INT
            {
            lv_num2=(Token)input.LT(1);
            match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers841); 
             
                createLeafNode(grammarAccess.prTwoNumbers().ele010LexerRuleCallINT(), "num2"); 
                

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:393:3: ( '#' (lv_num3= RULE_INT ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:393:4: '#' (lv_num3= RULE_INT )
            	    {
            	    match(input,14,FOLLOW_14_in_ruleTwoNumbers863); 

            	            createLeafNode(grammarAccess.prTwoNumbers().ele10KeywordNumberSign(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:397:1: (lv_num3= RULE_INT )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:399:6: lv_num3= RULE_INT
            	    {
            	    lv_num3=(Token)input.LT(1);
            	    match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleTwoNumbers884); 
            	     
            	        createLeafNode(grammarAccess.prTwoNumbers().ele110LexerRuleCallINT(), "num3"); 
            	        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:426:1: entryRuleManyStrings returns [EObject current=null] : iv_ruleManyStrings= ruleManyStrings EOF ;
    public final EObject entryRuleManyStrings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyStrings = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:426:53: (iv_ruleManyStrings= ruleManyStrings EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:427:2: iv_ruleManyStrings= ruleManyStrings EOF
            {
             currentNode = createCompositeNode(grammarAccess.prManyStrings().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:434:1: ruleManyStrings returns [EObject current=null] : ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) ) ;
    public final EObject ruleManyStrings() throws RecognitionException {
        EObject current = null;

        Token lv_str1=null;
        Token lv_str2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:438:6: ( ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:439:1: ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:439:1: ( ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:439:2: ( '=' (lv_str1= RULE_STRING )* ) (lv_str2= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:439:2: ( '=' (lv_str1= RULE_STRING )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:439:3: '=' (lv_str1= RULE_STRING )*
            {
            match(input,15,FOLLOW_15_in_ruleManyStrings977); 

                    createLeafNode(grammarAccess.prManyStrings().ele00KeywordEqualsSign(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:443:1: (lv_str1= RULE_STRING )*
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
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:445:6: lv_str1= RULE_STRING
            	    {
            	    lv_str1=(Token)input.LT(1);
            	    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings998); 
            	     
            	        createLeafNode(grammarAccess.prManyStrings().ele010LexerRuleCallSTRING(), "str1"); 
            	        

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:463:4: (lv_str2= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:465:6: lv_str2= RULE_STRING
            {
            lv_str2=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleManyStrings1032); 
             
                createLeafNode(grammarAccess.prManyStrings().ele10LexerRuleCallSTRING(), "str2"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:492:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:492:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:493:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.prType().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:500:1: ruleType returns [EObject current=null] : ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:504:6: ( ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:1: ( ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' ) ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:2: ( ( 'type' (lv_name= RULE_ID ) ) 'extends' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:3: ( 'type' (lv_name= RULE_ID ) ) 'extends'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:3: ( 'type' (lv_name= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:505:4: 'type' (lv_name= RULE_ID )
            {
            match(input,16,FOLLOW_16_in_ruleType1124); 

                    createLeafNode(grammarAccess.prType().ele000KeywordType(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:509:1: (lv_name= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:511:6: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1145); 
             
                createLeafNode(grammarAccess.prType().ele0010LexerRuleCallID(), "name"); 
                

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

                    createLeafNode(grammarAccess.prType().ele01KeywordExtends(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:533:2: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:536:3: ( RULE_ID )
            {

            			if (current==null) {
            	            current = factory.create("Type");
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:542:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:543:2: RULE_ID
            {
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleType1191); 
             
                createLeafNode(grammarAccess.prType().ele10CrossReferenceEStringType(), "extends"); 
                

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:557:1: entryRuleRef2 returns [EObject current=null] : iv_ruleRef2= ruleRef2 EOF ;
    public final EObject entryRuleRef2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRef2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:557:46: (iv_ruleRef2= ruleRef2 EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:558:2: iv_ruleRef2= ruleRef2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prRef2().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:565:1: ruleRef2 returns [EObject current=null] : ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) ;
    public final EObject ruleRef2() throws RecognitionException {
        EObject current = null;

        Token lv_ref2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:569:6: ( ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:570:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:570:1: ( '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:570:2: '#2' (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            {
            match(input,18,FOLLOW_18_in_ruleRef21274); 

                    createLeafNode(grammarAccess.prRef2().ele0KeywordNumberSignDigitTwo(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:574:1: (lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:576:6: lv_ref2= ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:576:14: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )
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
                    new NoViableAltException("576:14: ( ( 'mykeyword1' | RULE_STRING ) | 'mykeyword2' )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:576:15: ( 'mykeyword1' | RULE_STRING )
                    {
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:576:15: ( 'mykeyword1' | RULE_STRING )
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
                            new NoViableAltException("576:15: ( 'mykeyword1' | RULE_STRING )", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:576:16: 'mykeyword1'
                            {
                            match(input,19,FOLLOW_19_in_ruleRef21297); 

                                    createLeafNode(grammarAccess.prRef2().ele1000KeywordMykeyword1(), "ref2"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:581:6: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRef21312); 
                             
                                createLeafNode(grammarAccess.prRef2().ele1001LexerRuleCallSTRING(), "ref2"); 
                                

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:586:6: 'mykeyword2'
                    {
                    match(input,20,FOLLOW_20_in_ruleRef21327); 

                            createLeafNode(grammarAccess.prRef2().ele101KeywordMykeyword2(), "ref2"); 
                        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:613:1: entryRuleSpare returns [EObject current=null] : iv_ruleSpare= ruleSpare EOF ;
    public final EObject entryRuleSpare() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpare = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:613:47: (iv_ruleSpare= ruleSpare EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:614:2: iv_ruleSpare= ruleSpare EOF
            {
             currentNode = createCompositeNode(grammarAccess.prSpare().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:621:1: ruleSpare returns [EObject current=null] : ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* ) ;
    public final EObject ruleSpare() throws RecognitionException {
        EObject current = null;

        Token lv_id=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:625:6: ( ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:1: ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:1: ( ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )* )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:2: ( '#3' (lv_id= RULE_ID ) ) ( '.' (lv_id= RULE_ID ) )*
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:2: ( '#3' (lv_id= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:626:3: '#3' (lv_id= RULE_ID )
            {
            match(input,21,FOLLOW_21_in_ruleSpare1420); 

                    createLeafNode(grammarAccess.prSpare().ele00KeywordNumberSignDigitThree(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:630:1: (lv_id= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:632:6: lv_id= RULE_ID
            {
            lv_id=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1441); 
             
                createLeafNode(grammarAccess.prSpare().ele010LexerRuleCallID(), "id"); 
                

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

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:650:3: ( '.' (lv_id= RULE_ID ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:650:4: '.' (lv_id= RULE_ID )
            	    {
            	    match(input,22,FOLLOW_22_in_ruleSpare1463); 

            	            createLeafNode(grammarAccess.prSpare().ele10KeywordFullStop(), null); 
            	        
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:654:1: (lv_id= RULE_ID )
            	    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:656:6: lv_id= RULE_ID
            	    {
            	    lv_id=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSpare1484); 
            	     
            	        createLeafNode(grammarAccess.prSpare().ele110LexerRuleCallID(), "id"); 
            	        

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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:683:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:683:49: (iv_ruleBoolean= ruleBoolean EOF )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:684:2: iv_ruleBoolean= ruleBoolean EOF
            {
             currentNode = createCompositeNode(grammarAccess.prBoolean().getRule(), currentNode); 
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
    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:691:1: ruleBoolean returns [EObject current=null] : ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token lv_bool=null;
        Token lv_value=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:695:6: ( ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:1: ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:1: ( ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:2: ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' ) (lv_value= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:2: ( ( '#4' (lv_bool= 'myoption' )? ) 'kw' )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:3: ( '#4' (lv_bool= 'myoption' )? ) 'kw'
            {
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:3: ( '#4' (lv_bool= 'myoption' )? )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:696:4: '#4' (lv_bool= 'myoption' )?
            {
            match(input,23,FOLLOW_23_in_ruleBoolean1578); 

                    createLeafNode(grammarAccess.prBoolean().ele000KeywordNumberSignDigitFour(), null); 
                
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:700:1: (lv_bool= 'myoption' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:702:6: lv_bool= 'myoption'
                    {
                    lv_bool=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleBoolean1599); 

                            createLeafNode(grammarAccess.prBoolean().ele0010KeywordMyoption(), "bool"); 
                        

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

                    createLeafNode(grammarAccess.prBoolean().ele01KeywordKw(), null); 
                

            }

            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:724:2: (lv_value= RULE_ID )
            // ../org.eclipse.xtext.generator.tests//src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSimpleReconstrTestLanguage.g:726:6: lv_value= RULE_ID
            {
            lv_value=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleBoolean1644); 
             
                createLeafNode(grammarAccess.prBoolean().ele10LexerRuleCallID(), "value"); 
                

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
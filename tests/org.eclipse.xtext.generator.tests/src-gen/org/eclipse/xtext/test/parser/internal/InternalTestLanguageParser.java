// $ANTLR 3.0.1 ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g 2008-05-20 08:04:40

package org.eclipse.xtext.test.parser.internal; 

import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.*;
import org.eclipse.emf.ecore.EObject;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalTestLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_LEXER_BODY", "RULE_WS", "RULE_ANY_OTHER", "'choice'", "'optional'", "'reducible'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_LEXER_BODY=9;

        public InternalTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g"; }



    private IElementFactory factory;
    public InternalTestLanguageParser(TokenStream input, IElementFactory factory) {
    	this(input);
    	this.factory = factory;
    }

    public CompositeNode createCompositeNode(EObject grammarElement, CompositeNode parentNode) {
    	CompositeNode compositeNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
    	if (parentNode!=null) parentNode.getChildren().add(compositeNode);
    	compositeNode.setGrammarElement(grammarElement);
    	return compositeNode;
    }

    public Object createLeafNode(EObject currentGrammarElement, CompositeNode parentNode, String feature) {
    	Token token = input.LT(-1);
    	Token tokenBefore = input.LT(-2);
    	int indexOfTokenBefore = tokenBefore!=null?tokenBefore.getTokenIndex() : -1;
    	if (indexOfTokenBefore+1<token.getTokenIndex()) {
    		for (int x = indexOfTokenBefore+1; x<token.getTokenIndex();x++) {
    			Token hidden = input.get(x);
    			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    			leafNode.setText(hidden.getText());
    			leafNode.setHidden(true);
    			parentNode.getChildren().add(leafNode);
    		}
    	}
    	LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    		leafNode.setText(token.getText());
    	leafNode.setGrammarElement(currentGrammarElement);
    	leafNode.setFeature(feature);
    	parentNode.getChildren().add(leafNode);
    	return leafNode;
    }

    private void appendTrailingHiddenTokens(CompositeNode parentNode) {
    	Token tokenBefore = input.LT(-1);
    	int size = input.size();
    	if (tokenBefore!=null && tokenBefore.getTokenIndex()<size) {
    		for (int x = tokenBefore.getTokenIndex()+1; x<size;x++) {
    			Token hidden = input.get(x);
    			LeafNode leafNode = ParsetreeFactory.eINSTANCE.createLeafNode();
    			leafNode.setText(hidden.getText());
    			leafNode.setHidden(true);
    			parentNode.getChildren().add(leafNode);
    		}
    	}
    }
    	
    public void associateNodeWithAstElement(CompositeNode node, EObject astElement) {
    	if(node.getElement() != null && node.getElement() != astElement) {
    		throw new ParseException(node, "Reassignment of astElement in parse tree node");
    	}
    	node.setElement(astElement);
    	if(astElement instanceof EObject) {
    		EObject eObject = (EObject) astElement;
    		NodeAdapter adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(eObject, AbstractNode.class);
    		adapter.setParserNode(node); 
    	}
    }
    	
    private CompositeNode currentNode;

    private org.eclipse.xtext.Grammar grammar = org.eclipse.xtext.test.TestLanguageConstants.getTestLanguageGrammar();



    // $ANTLR start parse
    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:85:1: parse returns [EObject current] : ruleEntryRule EOF ;
    public final EObject parse() throws RecognitionException {
        EObject current = null;

        EObject ruleEntryRule1 = null;


        try {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:85:33: ( ruleEntryRule EOF )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:85:35: ruleEntryRule EOF
            {
            currentNode = createCompositeNode(// org.eclipse.xtext.impl.ParserRuleImpl@2c896d (name: EntryRule)
            grammar.eResource().getEObject("//@parserRules.0"), currentNode);
            pushFollow(FOLLOW_ruleEntryRule_in_parse45);
            ruleEntryRule1=ruleEntryRule();
            _fsp--;

            current =ruleEntryRule1;
            match(input,EOF,FOLLOW_EOF_in_parse49); 
            appendTrailingHiddenTokens(currentNode);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end parse


    // $ANTLR start ruleEntryRule
    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:92:1: ruleEntryRule returns [EObject current=null] : (lv_multiFeature= ruleAbstractRule )* ;
    public final EObject ruleEntryRule() throws RecognitionException {
        EObject current = null;

        EObject lv_multiFeature = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:94:4: ( (lv_multiFeature= ruleAbstractRule )* )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:95:1: (lv_multiFeature= ruleAbstractRule )*
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:95:1: (lv_multiFeature= ruleAbstractRule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:96:4: lv_multiFeature= ruleAbstractRule
            	    {
            	     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@529aa0 (cardinality: null) (name: AbstractRule)
            	    grammar.eResource().getEObject("//@parserRules.0/@alternatives/@terminal"), currentNode); 
            	    pushFollow(FOLLOW_ruleAbstractRule_in_ruleEntryRule91);
            	    lv_multiFeature=ruleAbstractRule();
            	    _fsp--;

            	      currentNode = currentNode.getParent();   if (current==null) {
            	          current = factory.create("Model");
            	          associateNodeWithAstElement(currentNode, current);
            	       }
            	       factory.add(current, "multiFeature", lv_multiFeature);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEntryRule


    // $ANTLR start ruleAbstractRule
    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:110:1: ruleAbstractRule returns [EObject current=null] : (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) ;
    public final EObject ruleAbstractRule() throws RecognitionException {
        EObject current = null;

        EObject this_ChoiceRule = null;

        EObject this_ReducibleRule = null;


         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:112:4: ( (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule ) )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:113:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:113:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("113:1: (this_ChoiceRule= ruleChoiceRule | this_ReducibleRule= ruleReducibleRule )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:113:2: this_ChoiceRule= ruleChoiceRule
                    {
                    pushFollow(FOLLOW_ruleChoiceRule_in_ruleAbstractRule127);
                    this_ChoiceRule=ruleChoiceRule();
                    _fsp--;

                    current = this_ChoiceRule;

                    }
                    break;
                case 2 :
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:114:2: this_ReducibleRule= ruleReducibleRule
                    {
                    pushFollow(FOLLOW_ruleReducibleRule_in_ruleAbstractRule133);
                    this_ReducibleRule=ruleReducibleRule();
                    _fsp--;

                    current = this_ReducibleRule;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAbstractRule


    // $ANTLR start ruleChoiceRule
    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:119:1: ruleChoiceRule returns [EObject current=null] : ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) ;
    public final EObject ruleChoiceRule() throws RecognitionException {
        EObject current = null;

        Token lv_optionalKeyword=null;
        Token lv_name=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:121:4: ( ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) ) )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:122:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:122:1: ( ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID ) )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:122:2: ( 'choice' (lv_optionalKeyword= 'optional' )? ) (lv_name= RULE_ID )
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:122:2: ( 'choice' (lv_optionalKeyword= 'optional' )? )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:122:3: 'choice' (lv_optionalKeyword= 'optional' )?
            {
            match(input,12,FOLLOW_12_in_ruleChoiceRule164); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@c3adf2 (cardinality: null) (value: "choice")
            grammar.eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:123:123: (lv_optionalKeyword= 'optional' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:125:4: lv_optionalKeyword= 'optional'
                    {
                    lv_optionalKeyword=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_ruleChoiceRule178); 
                         if (current==null) {
                          current = factory.create("ChoiceElement");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.set(current, "optionalKeyword", true);
                    createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@2cb01d (cardinality: null) (value: 'optional')
                    grammar.eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.0/@abstractTokens.1/@terminal"), currentNode,"optionalKeyword");

                    }
                    break;

            }


            }

            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:133:4: (lv_name= RULE_ID )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:135:4: lv_name= RULE_ID
            {
            lv_name=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChoiceRule198); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@9312cd (cardinality: null) (name: ID)
            grammar.eResource().getEObject("//@parserRules.2/@alternatives/@abstractTokens.1/@terminal"), currentNode,"name"); 
                 if (current==null) {
                  current = factory.create("ChoiceElement");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "name", lv_name);


            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleChoiceRule


    // $ANTLR start ruleReducibleRule
    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:148:1: ruleReducibleRule returns [EObject current=null] : ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) ;
    public final EObject ruleReducibleRule() throws RecognitionException {
        EObject current = null;

        EObject this_TerminalRule = null;

        EObject lv_actionFeature = null;


         EObject temp=null; CompositeNode entryNode = currentNode; 
        try {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:150:39: ( ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? ) )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:151:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:151:1: ( ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )? )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:151:2: ( 'reducible' this_TerminalRule= ruleTerminalRule ) ( () (lv_actionFeature= ruleTerminalRule ) )?
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:151:2: ( 'reducible' this_TerminalRule= ruleTerminalRule )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:151:3: 'reducible' this_TerminalRule= ruleTerminalRule
            {
            match(input,14,FOLLOW_14_in_ruleReducibleRule238); 
             createLeafNode(// org.eclipse.xtext.impl.KeywordImpl@967e3f (cardinality: null) (value: "reducible")
            grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.0/@abstractTokens.0"), currentNode,null); 
            pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule243);
            this_TerminalRule=ruleTerminalRule();
            _fsp--;

            current = this_TerminalRule;

            }

            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:153:2: ( () (lv_actionFeature= ruleTerminalRule ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:153:3: () (lv_actionFeature= ruleTerminalRule )
                    {
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:153:3: ()
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:154:1: 
                    {
                     temp=factory.create("ReducibleComposite");
                      factory.add(temp, "actionFeature",current);
                      current = temp; 
                      temp = null;
                      currentNode=createCompositeNode(// org.eclipse.xtext.impl.ActionImpl@d8e367 (cardinality: null) (operator: +=, feature: actionFeature)
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.0"), currentNode); 
                      associateNodeWithAstElement(currentNode, current); 

                    }

                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:161:2: (lv_actionFeature= ruleTerminalRule )
                    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:162:4: lv_actionFeature= ruleTerminalRule
                    {
                     currentNode=createCompositeNode(// org.eclipse.xtext.impl.RuleCallImpl@a96cf9 (cardinality: null) (name: TerminalRule)
                    grammar.eResource().getEObject("//@parserRules.3/@alternatives/@abstractTokens.1/@abstractTokens.1/@terminal"), currentNode); 
                    pushFollow(FOLLOW_ruleTerminalRule_in_ruleReducibleRule266);
                    lv_actionFeature=ruleTerminalRule();
                    _fsp--;

                      currentNode = currentNode.getParent();   if (current==null) {
                          current = factory.create("ReducibleElement");
                          associateNodeWithAstElement(currentNode, current);
                       }
                       factory.add(current, "actionFeature", lv_actionFeature);


                    }


                    }
                    break;

            }


            }


            }

             currentNode = entryNode; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleReducibleRule


    // $ANTLR start ruleTerminalRule
    // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:176:1: ruleTerminalRule returns [EObject current=null] : (lv_stringFeature= RULE_STRING ) ;
    public final EObject ruleTerminalRule() throws RecognitionException {
        EObject current = null;

        Token lv_stringFeature=null;

         EObject temp=null; 
        try {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:178:4: ( (lv_stringFeature= RULE_STRING ) )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:179:1: (lv_stringFeature= RULE_STRING )
            {
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:179:1: (lv_stringFeature= RULE_STRING )
            // ./src-gen/org/eclipse/xtext/test/parser/internal/InternalTestLanguage.g:181:4: lv_stringFeature= RULE_STRING
            {
            lv_stringFeature=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTerminalRule312); 
             createLeafNode(// org.eclipse.xtext.impl.RuleCallImpl@7e6fdf (cardinality: null) (name: STRING)
            grammar.eResource().getEObject("//@parserRules.4/@alternatives/@terminal"), currentNode,"stringFeature"); 
                 if (current==null) {
                  current = factory.create("TerminalElement");
                  associateNodeWithAstElement(currentNode, current);
               }
               factory.set(current, "stringFeature", lv_stringFeature);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTerminalRule


 

    public static final BitSet FOLLOW_ruleEntryRule_in_parse45 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_parse49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRule_in_ruleEntryRule91 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleChoiceRule_in_ruleAbstractRule127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReducibleRule_in_ruleAbstractRule133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleChoiceRule164 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_13_in_ruleChoiceRule178 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChoiceRule198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleReducibleRule238 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule243 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleTerminalRule_in_ruleReducibleRule266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTerminalRule312 = new BitSet(new long[]{0x0000000000000002L});

}
package org.eclipse.xtext.valueconverter.parser.antlr.internal; 

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
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug250313Parser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'mykeyword1'", "'1+'", "'2'", "'2+'", "'3'", "'3+'", "'4'", "'4+'", "'content'", "'ref'", "'-'", "'+'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug250313Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g"; }


     
     	private Bug250313GrammarAccess grammarAccess;
     	
        public InternalBug250313Parser(TokenStream input, IAstFactory factory, Bug250313GrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:80:1: ruleModel returns [EObject current=null] : ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_1=null;
        Token lv_multiValue_3=null;
        Token lv_value_5=null;
        Token lv_multiValue_7=null;
        AntlrDatatypeRuleToken lv_value_9 = null;

        AntlrDatatypeRuleToken lv_multiValue_11 = null;

        AntlrDatatypeRuleToken lv_value_13 = null;

        AntlrDatatypeRuleToken lv_multiValue_15 = null;

        EObject lv_children_17 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:85:6: ( ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:1: ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:1: ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            int alt6=9;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case 11:
            case 12:
                {
                alt6=1;
                }
                break;
            case 13:
                {
                alt6=2;
                }
                break;
            case 14:
                {
                alt6=3;
                }
                break;
            case 15:
                {
                alt6=4;
                }
                break;
            case 16:
                {
                alt6=5;
                }
                break;
            case 17:
                {
                alt6=6;
                }
                break;
            case 18:
                {
                alt6=7;
                }
                break;
            case 19:
                {
                alt6=8;
                }
                break;
            case 20:
                {
                alt6=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("86:1: ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:2: ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:2: ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:3: ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:3: ( '1' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:4: '1'
                            {
                            match(input,11,FOLLOW_11_in_ruleModel119); 

                                    createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                                

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:90:3: (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:6: lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:17: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
                    int alt2=5;
                    switch ( input.LA(1) ) {
                    case 12:
                        {
                        alt2=1;
                        }
                        break;
                    case RULE_STRING:
                        {
                        alt2=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        switch ( input.LA(2) ) {
                        case 22:
                            {
                            alt2=4;
                            }
                            break;
                        case 23:
                            {
                            alt2=3;
                            }
                            break;
                        case EOF:
                            {
                            alt2=5;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("92:17: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 2, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("92:17: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:18: 'mykeyword1'
                            {
                            match(input,12,FOLLOW_12_in_ruleModel143); 

                                    createLeafNode(grammarAccess.getModelAccess().getValueMykeyword1Keyword_0_1_0_0(), "value"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:98:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel160); 

                            		createLeafNode(grammarAccess.getModelAccess().getValueSTRINGTerminalRuleCall_0_1_0_1(), "value"); 
                            	

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:103:7: ruleNestedDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueNestedDatatypeParserRuleCall_0_1_0_2(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel175);
                            ruleNestedDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:110:7: ruleDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueDatatypeParserRuleCall_0_1_0_3(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel189);
                            ruleDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:117:7: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel200); 

                            		createLeafNode(grammarAccess.getModelAccess().getValueIDTerminalRuleCall_0_1_0_4(), "value"); 
                            	

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", /* lv_value_1 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:137:6: ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:137:6: ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:137:7: '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel227); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOnePlusSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:141:1: (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:143:6: lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:143:22: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
                    int alt3=5;
                    switch ( input.LA(1) ) {
                    case 12:
                        {
                        alt3=1;
                        }
                        break;
                    case RULE_STRING:
                        {
                        alt3=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        switch ( input.LA(2) ) {
                        case 22:
                            {
                            alt3=4;
                            }
                            break;
                        case 23:
                            {
                            alt3=3;
                            }
                            break;
                        case EOF:
                            {
                            alt3=5;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("143:22: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 3, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("143:22: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:143:23: 'mykeyword1'
                            {
                            match(input,12,FOLLOW_12_in_ruleModel249); 

                                    createLeafNode(grammarAccess.getModelAccess().getMultiValueMykeyword1Keyword_1_1_0_0(), "multiValue"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:149:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel266); 

                            		createLeafNode(grammarAccess.getModelAccess().getMultiValueSTRINGTerminalRuleCall_1_1_0_1(), "multiValue"); 
                            	

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:154:7: ruleNestedDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueNestedDatatypeParserRuleCall_1_1_0_2(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel281);
                            ruleNestedDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:161:7: ruleDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueDatatypeParserRuleCall_1_1_0_3(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel295);
                            ruleDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:168:7: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel306); 

                            		createLeafNode(grammarAccess.getModelAccess().getMultiValueIDTerminalRuleCall_1_1_0_4(), "multiValue"); 
                            	

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "multiValue", /* lv_multiValue_3 */ input.LT(-1), null, lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:188:6: ( '2' (lv_value_5= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:188:6: ( '2' (lv_value_5= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:188:7: '2' (lv_value_5= RULE_STRING )
                    {
                    match(input,14,FOLLOW_14_in_ruleModel333); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:192:1: (lv_value_5= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:194:6: lv_value_5= RULE_STRING
                    {
                    lv_value_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel355); 

                    		createLeafNode(grammarAccess.getModelAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_5, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:213:6: ( '2+' (lv_multiValue_7= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:213:6: ( '2+' (lv_multiValue_7= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:213:7: '2+' (lv_multiValue_7= RULE_STRING )
                    {
                    match(input,15,FOLLOW_15_in_ruleModel380); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoPlusSignKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:217:1: (lv_multiValue_7= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:219:6: lv_multiValue_7= RULE_STRING
                    {
                    lv_multiValue_7=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel402); 

                    		createLeafNode(grammarAccess.getModelAccess().getMultiValueSTRINGTerminalRuleCall_3_1_0(), "multiValue"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "multiValue", lv_multiValue_7, "STRING", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:238:6: ( '3' (lv_value_9= ruleDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:238:6: ( '3' (lv_value_9= ruleDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:238:7: '3' (lv_value_9= ruleDatatype )
                    {
                    match(input,16,FOLLOW_16_in_ruleModel427); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreeKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:242:1: (lv_value_9= ruleDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:245:6: lv_value_9= ruleDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueDatatypeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDatatype_in_ruleModel461);
                    lv_value_9=ruleDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_9, "Datatype", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:264:6: ( '3+' (lv_multiValue_11= ruleDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:264:6: ( '3+' (lv_multiValue_11= ruleDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:264:7: '3+' (lv_multiValue_11= ruleDatatype )
                    {
                    match(input,17,FOLLOW_17_in_ruleModel482); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreePlusSignKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:268:1: (lv_multiValue_11= ruleDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:271:6: lv_multiValue_11= ruleDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueDatatypeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDatatype_in_ruleModel516);
                    lv_multiValue_11=ruleDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "multiValue", lv_multiValue_11, "Datatype", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:290:6: ( '4' (lv_value_13= ruleNestedDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:290:6: ( '4' (lv_value_13= ruleNestedDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:290:7: '4' (lv_value_13= ruleNestedDatatype )
                    {
                    match(input,18,FOLLOW_18_in_ruleModel537); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:294:1: (lv_value_13= ruleNestedDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:297:6: lv_value_13= ruleNestedDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueNestedDatatypeParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel571);
                    lv_value_13=ruleNestedDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "value", lv_value_13, "NestedDatatype", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:316:6: ( '4+' (lv_multiValue_15= ruleNestedDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:316:6: ( '4+' (lv_multiValue_15= ruleNestedDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:316:7: '4+' (lv_multiValue_15= ruleNestedDatatype )
                    {
                    match(input,19,FOLLOW_19_in_ruleModel592); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourPlusSignKeyword_7_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:320:1: (lv_multiValue_15= ruleNestedDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:323:6: lv_multiValue_15= ruleNestedDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueNestedDatatypeParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel626);
                    lv_multiValue_15=ruleNestedDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		add(current, "multiValue", lv_multiValue_15, "NestedDatatype", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:342:6: ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:342:6: ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:342:7: ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:342:7: ( 'content' (lv_children_17= ruleChild ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:342:8: 'content' (lv_children_17= ruleChild )
                    {
                    match(input,20,FOLLOW_20_in_ruleModel648); 

                            createLeafNode(grammarAccess.getModelAccess().getContentKeyword_8_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:346:1: (lv_children_17= ruleChild )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:349:6: lv_children_17= ruleChild
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getChildrenChildParserRuleCall_8_0_1_0(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleChild_in_ruleModel682);
                    lv_children_17=ruleChild();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "children", lv_children_17, "Child", currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:367:3: ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:367:4: 'ref' ( ( RULE_STRING | RULE_ID ) )
                            {
                            match(input,21,FOLLOW_21_in_ruleModel697); 

                                    createLeafNode(grammarAccess.getModelAccess().getRefKeyword_8_1_0(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:371:1: ( ( RULE_STRING | RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:374:3: ( RULE_STRING | RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:380:1: ( RULE_STRING | RULE_ID )
                            int alt4=2;
                            int LA4_0 = input.LA(1);

                            if ( (LA4_0==RULE_STRING) ) {
                                alt4=1;
                            }
                            else if ( (LA4_0==RULE_ID) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("380:1: ( RULE_STRING | RULE_ID )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:380:3: RULE_STRING
                                    {
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel720); 

                                    		createLeafNode(grammarAccess.getModelAccess().getRefChild1CrossReference_8_1_1_0_0(), "ref"); 
                                    	
                                     lastConsumedDatatypeToken = null; 

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:386:7: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel736); 

                                    		createLeafNode(grammarAccess.getModelAccess().getRefChild2CrossReference_8_1_1_0_1(), "ref"); 
                                    	
                                     lastConsumedDatatypeToken = null; 

                                    }
                                    break;

                            }


                            }


                            }
                            break;

                    }


                    }


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:402:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:402:49: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:403:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype782);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype793); 

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
    // $ANTLR end entryRuleDatatype


    // $ANTLR start ruleDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:410:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:416:6: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:417:1: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:417:1: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:417:6: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype833); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getDatatypeAccess().getIDTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,22,FOLLOW_22_in_ruleDatatype851); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDatatypeAccess().getHyphenMinusKeyword_1(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype866); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.getDatatypeAccess().getIDTerminalRuleCall_2(), null); 
                

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleNestedDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:445:1: entryRuleNestedDatatype returns [String current=null] : iv_ruleNestedDatatype= ruleNestedDatatype EOF ;
    public final String entryRuleNestedDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:445:55: (iv_ruleNestedDatatype= ruleNestedDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:446:2: iv_ruleNestedDatatype= ruleNestedDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedDatatypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype910);
            iv_ruleNestedDatatype=ruleNestedDatatype();
            _fsp--;

             current =iv_ruleNestedDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedDatatype921); 

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
    // $ANTLR end entryRuleNestedDatatype


    // $ANTLR start ruleNestedDatatype
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:453:1: ruleNestedDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? ) ;
    public final AntlrDatatypeRuleToken ruleNestedDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_Datatype_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:459:6: ( (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:460:1: (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:460:1: (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:460:6: this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )?
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNestedDatatype961); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getNestedDatatypeAccess().getIDTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_ruleNestedDatatype979); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getNestedDatatypeAccess().getPlusSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:473:1: (this_Datatype_2= ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:474:5: this_Datatype_2= ruleDatatype
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNestedDatatypeAccess().getDatatypeParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatype_in_ruleNestedDatatype1002);
                    this_Datatype_2=ruleDatatype();
                    _fsp--;


                    		current.merge(this_Datatype_2);
                        
                     
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
            	    lastConsumedDatatypeToken = current;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNestedDatatype


    // $ANTLR start entryRuleChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:47: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:493:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild1047);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild1057); 

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
    // $ANTLR end entryRuleChild


    // $ANTLR start ruleChild
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:500:1: ruleChild returns [EObject current=null] : (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject this_Child1_0 = null;

        EObject this_Child2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:505:6: ( (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:506:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:506:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_STRING) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("506:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:507:5: this_Child1_0= ruleChild1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getChildAccess().getChild1ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild1_in_ruleChild1104);
                    this_Child1_0=ruleChild1();
                    _fsp--;

                     
                            current = this_Child1_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:517:5: this_Child2_1= ruleChild2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getChildAccess().getChild2ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild2_in_ruleChild1131);
                    this_Child2_1=ruleChild2();
                    _fsp--;

                     
                            current = this_Child2_1; 
                            currentNode = currentNode.getParent();
                        

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
    // $ANTLR end ruleChild


    // $ANTLR start entryRuleChild1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:532:1: entryRuleChild1 returns [EObject current=null] : iv_ruleChild1= ruleChild1 EOF ;
    public final EObject entryRuleChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:532:48: (iv_ruleChild1= ruleChild1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:533:2: iv_ruleChild1= ruleChild1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChild1Rule(), currentNode); 
            pushFollow(FOLLOW_ruleChild1_in_entryRuleChild11163);
            iv_ruleChild1=ruleChild1();
            _fsp--;

             current =iv_ruleChild1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild11173); 

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
    // $ANTLR end entryRuleChild1


    // $ANTLR start ruleChild1
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:540:1: ruleChild1 returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleChild1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:545:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:546:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:546:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:548:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild11219); 

            		createLeafNode(grammarAccess.getChild1Access().getNameIDTerminalRuleCall_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChild1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
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
    // $ANTLR end ruleChild1


    // $ANTLR start entryRuleChild2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:573:1: entryRuleChild2 returns [EObject current=null] : iv_ruleChild2= ruleChild2 EOF ;
    public final EObject entryRuleChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:573:48: (iv_ruleChild2= ruleChild2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:574:2: iv_ruleChild2= ruleChild2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChild2Rule(), currentNode); 
            pushFollow(FOLLOW_ruleChild2_in_entryRuleChild21259);
            iv_ruleChild2=ruleChild2();
            _fsp--;

             current =iv_ruleChild2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild21269); 

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
    // $ANTLR end entryRuleChild2


    // $ANTLR start ruleChild2
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:581:1: ruleChild2 returns [EObject current=null] : (lv_name_0= RULE_STRING ) ;
    public final EObject ruleChild2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:586:6: ( (lv_name_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:587:1: (lv_name_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:587:1: (lv_name_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:589:6: lv_name_0= RULE_STRING
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleChild21315); 

            		createLeafNode(grammarAccess.getChild2Access().getNameSTRINGTerminalRuleCall_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChild2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "STRING", lastConsumedNode);
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
    // $ANTLR end ruleChild2


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel119 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleModel143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel227 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleModel249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModel380 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleModel427 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModel482 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleModel537 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModel592 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleModel648 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel682 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleModel697 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype833 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDatatype851 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedDatatype921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNestedDatatype961 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNestedDatatype979 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleNestedDatatype1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild1047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_ruleChild1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_ruleChild1131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild11163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild11173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild11219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild21259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild21269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleChild21315 = new BitSet(new long[]{0x0000000000000002L});

}
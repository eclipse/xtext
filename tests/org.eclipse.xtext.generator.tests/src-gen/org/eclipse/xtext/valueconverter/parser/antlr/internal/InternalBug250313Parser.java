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
            super(input, factory, grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:69:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:69:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:70:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.prModel().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel71);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel81); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:77:1: ruleModel returns [EObject current=null] : ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) ;
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
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:82:6: ( ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:1: ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:1: ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )
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
                    new NoViableAltException("83:1: ( ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) ) | ( '2' (lv_value_5= RULE_STRING ) ) | ( '2+' (lv_multiValue_7= RULE_STRING ) ) | ( '3' (lv_value_9= ruleDatatype ) ) | ( '3+' (lv_multiValue_11= ruleDatatype ) ) | ( '4' (lv_value_13= ruleNestedDatatype ) ) | ( '4+' (lv_multiValue_15= ruleNestedDatatype ) ) | ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? ) )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:2: ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:2: ( ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:3: ( '1' )? (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:3: ( '1' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:83:4: '1'
                            {
                            match(input,11,FOLLOW_11_in_ruleModel117); 

                                    createLeafNode(grammarAccess.prModel().ele00KeywordDigitOne(), null); 
                                

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:87:3: (lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:89:6: lv_value_1= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:89:17: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
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
                                new NoViableAltException("89:17: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 2, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("89:17: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:89:18: 'mykeyword1'
                            {
                            match(input,12,FOLLOW_12_in_ruleModel141); 

                                    createLeafNode(grammarAccess.prModel().ele0100KeywordMykeyword1(), "value"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:95:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel158); 

                            		createLeafNode(grammarAccess.prModel().ele0101TerminalRuleCallSTRING(), "value"); 
                            	

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:100:7: ruleNestedDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prModel().ele0102ParserRuleCallNestedDatatype(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel173);
                            ruleNestedDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:107:7: ruleDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prModel().ele0103ParserRuleCallDatatype(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel187);
                            ruleDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:114:7: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel198); 

                            		createLeafNode(grammarAccess.prModel().ele0104TerminalRuleCallID(), "value"); 
                            	

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:134:6: ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:134:6: ( '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:134:7: '1+' (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    {
                    match(input,13,FOLLOW_13_in_ruleModel225); 

                            createLeafNode(grammarAccess.prModel().ele10KeywordDigitOnePlusSign(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:138:1: (lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:140:6: lv_multiValue_3= ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:140:22: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )
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
                                new NoViableAltException("140:22: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 3, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("140:22: ( 'mykeyword1' | RULE_STRING | ruleNestedDatatype | ruleDatatype | RULE_ID )", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:140:23: 'mykeyword1'
                            {
                            match(input,12,FOLLOW_12_in_ruleModel247); 

                                    createLeafNode(grammarAccess.prModel().ele1100KeywordMykeyword1(), "multiValue"); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:146:7: RULE_STRING
                            {
                            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel264); 

                            		createLeafNode(grammarAccess.prModel().ele1101TerminalRuleCallSTRING(), "multiValue"); 
                            	

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:151:7: ruleNestedDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prModel().ele1102ParserRuleCallNestedDatatype(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel279);
                            ruleNestedDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:158:7: ruleDatatype
                            {
                             
                                    currentNode=createCompositeNode(grammarAccess.prModel().ele1103ParserRuleCallDatatype(), currentNode); 
                                
                            pushFollow(FOLLOW_ruleDatatype_in_ruleModel293);
                            ruleDatatype();
                            _fsp--;

                             
                                    currentNode = currentNode.getParent();
                                

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:165:7: RULE_ID
                            {
                            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel304); 

                            		createLeafNode(grammarAccess.prModel().ele1104TerminalRuleCallID(), "multiValue"); 
                            	

                            }
                            break;

                    }


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:185:6: ( '2' (lv_value_5= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:185:6: ( '2' (lv_value_5= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:185:7: '2' (lv_value_5= RULE_STRING )
                    {
                    match(input,14,FOLLOW_14_in_ruleModel331); 

                            createLeafNode(grammarAccess.prModel().ele20KeywordDigitTwo(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:189:1: (lv_value_5= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:191:6: lv_value_5= RULE_STRING
                    {
                    lv_value_5=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel353); 

                    		createLeafNode(grammarAccess.prModel().ele210TerminalRuleCallSTRING(), "value"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:210:6: ( '2+' (lv_multiValue_7= RULE_STRING ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:210:6: ( '2+' (lv_multiValue_7= RULE_STRING ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:210:7: '2+' (lv_multiValue_7= RULE_STRING )
                    {
                    match(input,15,FOLLOW_15_in_ruleModel378); 

                            createLeafNode(grammarAccess.prModel().ele30KeywordDigitTwoPlusSign(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:214:1: (lv_multiValue_7= RULE_STRING )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:216:6: lv_multiValue_7= RULE_STRING
                    {
                    lv_multiValue_7=(Token)input.LT(1);
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel400); 

                    		createLeafNode(grammarAccess.prModel().ele310TerminalRuleCallSTRING(), "multiValue"); 
                    	

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:235:6: ( '3' (lv_value_9= ruleDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:235:6: ( '3' (lv_value_9= ruleDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:235:7: '3' (lv_value_9= ruleDatatype )
                    {
                    match(input,16,FOLLOW_16_in_ruleModel425); 

                            createLeafNode(grammarAccess.prModel().ele40KeywordDigitThree(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:239:1: (lv_value_9= ruleDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:242:6: lv_value_9= ruleDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele410ParserRuleCallDatatype(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDatatype_in_ruleModel459);
                    lv_value_9=ruleDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:261:6: ( '3+' (lv_multiValue_11= ruleDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:261:6: ( '3+' (lv_multiValue_11= ruleDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:261:7: '3+' (lv_multiValue_11= ruleDatatype )
                    {
                    match(input,17,FOLLOW_17_in_ruleModel480); 

                            createLeafNode(grammarAccess.prModel().ele50KeywordDigitThreePlusSign(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:265:1: (lv_multiValue_11= ruleDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:268:6: lv_multiValue_11= ruleDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele510ParserRuleCallDatatype(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleDatatype_in_ruleModel514);
                    lv_multiValue_11=ruleDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:287:6: ( '4' (lv_value_13= ruleNestedDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:287:6: ( '4' (lv_value_13= ruleNestedDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:287:7: '4' (lv_value_13= ruleNestedDatatype )
                    {
                    match(input,18,FOLLOW_18_in_ruleModel535); 

                            createLeafNode(grammarAccess.prModel().ele60KeywordDigitFour(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:291:1: (lv_value_13= ruleNestedDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:294:6: lv_value_13= ruleNestedDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele610ParserRuleCallNestedDatatype(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel569);
                    lv_value_13=ruleNestedDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:313:6: ( '4+' (lv_multiValue_15= ruleNestedDatatype ) )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:313:6: ( '4+' (lv_multiValue_15= ruleNestedDatatype ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:313:7: '4+' (lv_multiValue_15= ruleNestedDatatype )
                    {
                    match(input,19,FOLLOW_19_in_ruleModel590); 

                            createLeafNode(grammarAccess.prModel().ele70KeywordDigitFourPlusSign(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:317:1: (lv_multiValue_15= ruleNestedDatatype )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:320:6: lv_multiValue_15= ruleNestedDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele710ParserRuleCallNestedDatatype(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleNestedDatatype_in_ruleModel624);
                    lv_multiValue_15=ruleNestedDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:339:6: ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:339:6: ( ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )? )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:339:7: ( 'content' (lv_children_17= ruleChild ) ) ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:339:7: ( 'content' (lv_children_17= ruleChild ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:339:8: 'content' (lv_children_17= ruleChild )
                    {
                    match(input,20,FOLLOW_20_in_ruleModel646); 

                            createLeafNode(grammarAccess.prModel().ele800KeywordContent(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:343:1: (lv_children_17= ruleChild )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:346:6: lv_children_17= ruleChild
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.prModel().ele8010ParserRuleCallChild(), currentNode); 
                    	    
                    pushFollow(FOLLOW_ruleChild_in_ruleModel680);
                    lv_children_17=ruleChild();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
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

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:364:3: ( 'ref' ( ( RULE_STRING | RULE_ID ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:364:4: 'ref' ( ( RULE_STRING | RULE_ID ) )
                            {
                            match(input,21,FOLLOW_21_in_ruleModel695); 

                                    createLeafNode(grammarAccess.prModel().ele810KeywordRef(), null); 
                                
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:368:1: ( ( RULE_STRING | RULE_ID ) )
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:371:3: ( RULE_STRING | RULE_ID )
                            {

                            			if (current==null) {
                            	            current = factory.create(grammarAccess.prModel().getRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                                    
                            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:377:1: ( RULE_STRING | RULE_ID )
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
                                    new NoViableAltException("377:1: ( RULE_STRING | RULE_ID )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:377:3: RULE_STRING
                                    {
                                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleModel718); 

                                    		createLeafNode(grammarAccess.prModel().ele81100CrossReferenceSTRINGChild1(), "ref"); 
                                    	

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:382:7: RULE_ID
                                    {
                                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel730); 

                                    		createLeafNode(grammarAccess.prModel().ele81101CrossReferenceIDChild2(), "ref"); 
                                    	

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:397:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:397:49: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:398:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.prDatatype().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleDatatype_in_entryRuleDatatype772);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDatatype783); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:405:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:411:6: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:412:1: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:412:1: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:412:6: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype823); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prDatatype().ele0TerminalRuleCallID(), null); 
                
            kw=(Token)input.LT(1);
            match(input,22,FOLLOW_22_in_ruleDatatype841); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prDatatype().ele1KeywordHyphenMinus(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDatatype856); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.prDatatype().ele2TerminalRuleCallID(), null); 
                

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:440:1: entryRuleNestedDatatype returns [String current=null] : iv_ruleNestedDatatype= ruleNestedDatatype EOF ;
    public final String entryRuleNestedDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedDatatype = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:440:55: (iv_ruleNestedDatatype= ruleNestedDatatype EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:441:2: iv_ruleNestedDatatype= ruleNestedDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.prNestedDatatype().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype900);
            iv_ruleNestedDatatype=ruleNestedDatatype();
            _fsp--;

             current =iv_ruleNestedDatatype.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedDatatype911); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:448:1: ruleNestedDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? ) ;
    public final AntlrDatatypeRuleToken ruleNestedDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_Datatype_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:454:6: ( (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:455:1: (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:455:1: (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:455:6: this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )?
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNestedDatatype951); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.prNestedDatatype().ele0TerminalRuleCallID(), null); 
                
            kw=(Token)input.LT(1);
            match(input,23,FOLLOW_23_in_ruleNestedDatatype969); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.prNestedDatatype().ele1KeywordPlusSign(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:468:1: (this_Datatype_2= ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:469:5: this_Datatype_2= ruleDatatype
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prNestedDatatype().ele2ParserRuleCallDatatype(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleDatatype_in_ruleNestedDatatype992);
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:487:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:487:47: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:488:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild_in_entryRuleChild1037);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild1047); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:495:1: ruleChild returns [EObject current=null] : (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject this_Child1_0 = null;

        EObject this_Child2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:500:6: ( (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:501:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:501:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
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
                    new NoViableAltException("501:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:502:5: this_Child1_0= ruleChild1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prChild().ele0ParserRuleCallChild1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild1_in_ruleChild1094);
                    this_Child1_0=ruleChild1();
                    _fsp--;

                     
                            current = this_Child1_0; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prChild().ele0ParserRuleCallChild1(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:516:5: this_Child2_1= ruleChild2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.prChild().ele1ParserRuleCallChild2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleChild2_in_ruleChild1128);
                    this_Child2_1=ruleChild2();
                    _fsp--;

                     
                            current = this_Child2_1; 
                            currentNode = currentNode.getParent();
                        
                     
                        createLeafNode(grammarAccess.prChild().ele1ParserRuleCallChild2(), null); 
                        

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:535:1: entryRuleChild1 returns [EObject current=null] : iv_ruleChild1= ruleChild1 EOF ;
    public final EObject entryRuleChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:535:48: (iv_ruleChild1= ruleChild1 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:536:2: iv_ruleChild1= ruleChild1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild1().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild1_in_entryRuleChild11167);
            iv_ruleChild1=ruleChild1();
            _fsp--;

             current =iv_ruleChild1; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild11177); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:543:1: ruleChild1 returns [EObject current=null] : (lv_name_0= RULE_ID ) ;
    public final EObject ruleChild1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:548:6: ( (lv_name_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:549:1: (lv_name_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:549:1: (lv_name_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:551:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleChild11223); 

            		createLeafNode(grammarAccess.prChild1().ele0TerminalRuleCallID(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prChild1().getRule().getType().getClassifier());
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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:576:1: entryRuleChild2 returns [EObject current=null] : iv_ruleChild2= ruleChild2 EOF ;
    public final EObject entryRuleChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2 = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:576:48: (iv_ruleChild2= ruleChild2 EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:577:2: iv_ruleChild2= ruleChild2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.prChild2().getRule(), currentNode); 
            pushFollow(FOLLOW_ruleChild2_in_entryRuleChild21263);
            iv_ruleChild2=ruleChild2();
            _fsp--;

             current =iv_ruleChild2; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleChild21273); 

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
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:584:1: ruleChild2 returns [EObject current=null] : (lv_name_0= RULE_STRING ) ;
    public final EObject ruleChild2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:589:6: ( (lv_name_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:590:1: (lv_name_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:590:1: (lv_name_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:592:6: lv_name_0= RULE_STRING
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleChild21319); 

            		createLeafNode(grammarAccess.prChild2().ele0TerminalRuleCallSTRING(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.prChild2().getRule().getType().getClassifier());
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


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel71 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModel117 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleModel141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModel225 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_12_in_ruleModel247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleModel331 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModel378 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleModel425 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModel480 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleModel514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleModel535 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleModel590 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleModel646 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleChild_in_ruleModel680 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_ruleModel695 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleModel718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype772 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDatatype783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype823 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleDatatype841 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedDatatype911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNestedDatatype951 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNestedDatatype969 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_ruleDatatype_in_ruleNestedDatatype992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild_in_entryRuleChild1037 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_ruleChild1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_ruleChild1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild11167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild11177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleChild11223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild21263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleChild21273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleChild21319 = new BitSet(new long[]{0x0000000000000002L});

}
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
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBug250313Parser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g"; }



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
       	
       	@Override
       	protected Bug250313GrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:86:1: ruleModel returns [EObject current=null] : ( ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | ( '2' ( (lv_value_5_0= RULE_STRING ) ) ) | ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | ( '3' ( (lv_value_9_0= ruleDatatype ) ) ) | ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token lv_value_1_5=null;
        Token lv_multiValue_3_1=null;
        Token lv_multiValue_3_2=null;
        Token lv_multiValue_3_5=null;
        Token lv_value_5_0=null;
        Token lv_multiValue_7_0=null;
        AntlrDatatypeRuleToken lv_value_1_3 = null;

        AntlrDatatypeRuleToken lv_value_1_4 = null;

        AntlrDatatypeRuleToken lv_multiValue_3_3 = null;

        AntlrDatatypeRuleToken lv_multiValue_3_4 = null;

        AntlrDatatypeRuleToken lv_value_9_0 = null;

        AntlrDatatypeRuleToken lv_multiValue_11_0 = null;

        AntlrDatatypeRuleToken lv_value_13_0 = null;

        AntlrDatatypeRuleToken lv_multiValue_15_0 = null;

        EObject lv_children_17_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:91:6: ( ( ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | ( '2' ( (lv_value_5_0= RULE_STRING ) ) ) | ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | ( '3' ( (lv_value_9_0= ruleDatatype ) ) ) | ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:1: ( ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | ( '2' ( (lv_value_5_0= RULE_STRING ) ) ) | ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | ( '3' ( (lv_value_9_0= ruleDatatype ) ) ) | ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:1: ( ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | ( '2' ( (lv_value_5_0= RULE_STRING ) ) ) | ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | ( '3' ( (lv_value_9_0= ruleDatatype ) ) ) | ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? ) )
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
                    new NoViableAltException("92:1: ( ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) ) | ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) ) | ( '2' ( (lv_value_5_0= RULE_STRING ) ) ) | ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) ) | ( '3' ( (lv_value_9_0= ruleDatatype ) ) ) | ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) ) | ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) ) | ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) ) | ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? ) )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:2: ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:2: ( ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:3: ( '1' )? ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:3: ( '1' )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==11) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:92:5: '1'
                            {
                            match(input,11,FollowSets000.FOLLOW_11_in_ruleModel122); 

                                    createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                                

                            }
                            break;

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:96:3: ( ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:97:1: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:97:1: ( (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:98:1: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:98:1: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )
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
                        case 23:
                            {
                            alt2=3;
                            }
                            break;
                        case 22:
                            {
                            alt2=4;
                            }
                            break;
                        case EOF:
                            {
                            alt2=5;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("98:1: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )", 2, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("98:1: (lv_value_1_1= 'mykeyword1' | lv_value_1_2= RULE_STRING | lv_value_1_3= ruleNestedDatatype | lv_value_1_4= ruleDatatype | lv_value_1_5= RULE_ID )", 2, 0, input);

                        throw nvae;
                    }

                    switch (alt2) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:99:3: lv_value_1_1= 'mykeyword1'
                            {
                            lv_value_1_1=(Token)input.LT(1);
                            match(input,12,FollowSets000.FOLLOW_12_in_ruleModel144); 

                                    createLeafNode(grammarAccess.getModelAccess().getValueMykeyword1Keyword_0_1_0_0(), "value"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "value", lv_value_1_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:117:8: lv_value_1_2= RULE_STRING
                            {
                            lv_value_1_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel172); 

                            			createLeafNode(grammarAccess.getModelAccess().getValueSTRINGTerminalRuleCall_0_1_0_1(), "value"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_1_2, 
                            	        		"STRING", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:138:8: lv_value_1_3= ruleNestedDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueNestedDatatypeParserRuleCall_0_1_0_2(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel196);
                            lv_value_1_3=ruleNestedDatatype();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_1_3, 
                            	        		"NestedDatatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:159:8: lv_value_1_4= ruleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueDatatypeParserRuleCall_0_1_0_3(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel215);
                            lv_value_1_4=ruleDatatype();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_1_4, 
                            	        		"Datatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:180:8: lv_value_1_5= RULE_ID
                            {
                            lv_value_1_5=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel230); 

                            			createLeafNode(grammarAccess.getModelAccess().getValueIDTerminalRuleCall_0_1_0_4(), "value"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		set(
                            	       			current, 
                            	       			"value",
                            	        		lv_value_1_5, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:205:6: ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:205:6: ( '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:205:8: '1+' ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleModel256); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOnePlusSignKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:209:1: ( ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:210:1: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:210:1: ( (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:211:1: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:211:1: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )
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
                                new NoViableAltException("211:1: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )", 3, 3, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("211:1: (lv_multiValue_3_1= 'mykeyword1' | lv_multiValue_3_2= RULE_STRING | lv_multiValue_3_3= ruleNestedDatatype | lv_multiValue_3_4= ruleDatatype | lv_multiValue_3_5= RULE_ID )", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:212:3: lv_multiValue_3_1= 'mykeyword1'
                            {
                            lv_multiValue_3_1=(Token)input.LT(1);
                            match(input,12,FollowSets000.FOLLOW_12_in_ruleModel276); 

                                    createLeafNode(grammarAccess.getModelAccess().getMultiValueMykeyword1Keyword_1_1_0_0(), "multiValue"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		add(current, "multiValue", lv_multiValue_3_1, null, lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 2 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:230:8: lv_multiValue_3_2= RULE_STRING
                            {
                            lv_multiValue_3_2=(Token)input.LT(1);
                            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel304); 

                            			createLeafNode(grammarAccess.getModelAccess().getMultiValueSTRINGTerminalRuleCall_1_1_0_1(), "multiValue"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"multiValue",
                            	        		lv_multiValue_3_2, 
                            	        		"STRING", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;
                        case 3 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:251:8: lv_multiValue_3_3= ruleNestedDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueNestedDatatypeParserRuleCall_1_1_0_2(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel328);
                            lv_multiValue_3_3=ruleNestedDatatype();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"multiValue",
                            	        		lv_multiValue_3_3, 
                            	        		"NestedDatatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 4 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:272:8: lv_multiValue_3_4= ruleDatatype
                            {
                             
                            	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueDatatypeParserRuleCall_1_1_0_3(), currentNode); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel347);
                            lv_multiValue_3_4=ruleDatatype();
                            _fsp--;


                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode.getParent(), current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"multiValue",
                            	        		lv_multiValue_3_4, 
                            	        		"Datatype", 
                            	        		currentNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	        currentNode = currentNode.getParent();
                            	    

                            }
                            break;
                        case 5 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:293:8: lv_multiValue_3_5= RULE_ID
                            {
                            lv_multiValue_3_5=(Token)input.LT(1);
                            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel362); 

                            			createLeafNode(grammarAccess.getModelAccess().getMultiValueIDTerminalRuleCall_1_1_0_4(), "multiValue"); 
                            		

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        try {
                            	       		add(
                            	       			current, 
                            	       			"multiValue",
                            	        		lv_multiValue_3_5, 
                            	        		"ID", 
                            	        		lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:318:6: ( '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:318:6: ( '2' ( (lv_value_5_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:318:8: '2' ( (lv_value_5_0= RULE_STRING ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleModel388); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:322:1: ( (lv_value_5_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:323:1: (lv_value_5_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:323:1: (lv_value_5_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:324:3: lv_value_5_0= RULE_STRING
                    {
                    lv_value_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel405); 

                    			createLeafNode(grammarAccess.getModelAccess().getValueSTRINGTerminalRuleCall_2_1_0(), "value"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_5_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:347:6: ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:347:6: ( '2+' ( (lv_multiValue_7_0= RULE_STRING ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:347:8: '2+' ( (lv_multiValue_7_0= RULE_STRING ) )
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleModel428); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoPlusSignKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:351:1: ( (lv_multiValue_7_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:352:1: (lv_multiValue_7_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:352:1: (lv_multiValue_7_0= RULE_STRING )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:353:3: lv_multiValue_7_0= RULE_STRING
                    {
                    lv_multiValue_7_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel445); 

                    			createLeafNode(grammarAccess.getModelAccess().getMultiValueSTRINGTerminalRuleCall_3_1_0(), "multiValue"); 
                    		

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"multiValue",
                    	        		lv_multiValue_7_0, 
                    	        		"STRING", 
                    	        		lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:376:6: ( '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:376:6: ( '3' ( (lv_value_9_0= ruleDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:376:8: '3' ( (lv_value_9_0= ruleDatatype ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleModel468); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreeKeyword_4_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:380:1: ( (lv_value_9_0= ruleDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:381:1: (lv_value_9_0= ruleDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:381:1: (lv_value_9_0= ruleDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:382:3: lv_value_9_0= ruleDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueDatatypeParserRuleCall_4_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel489);
                    lv_value_9_0=ruleDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_9_0, 
                    	        		"Datatype", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:405:6: ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:405:6: ( '3+' ( (lv_multiValue_11_0= ruleDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:405:8: '3+' ( (lv_multiValue_11_0= ruleDatatype ) )
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleModel507); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitThreePlusSignKeyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:409:1: ( (lv_multiValue_11_0= ruleDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:410:1: (lv_multiValue_11_0= ruleDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:410:1: (lv_multiValue_11_0= ruleDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:411:3: lv_multiValue_11_0= ruleDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueDatatypeParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleModel528);
                    lv_multiValue_11_0=ruleDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"multiValue",
                    	        		lv_multiValue_11_0, 
                    	        		"Datatype", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:434:6: ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:434:6: ( '4' ( (lv_value_13_0= ruleNestedDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:434:8: '4' ( (lv_value_13_0= ruleNestedDatatype ) )
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleModel546); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourKeyword_6_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:438:1: ( (lv_value_13_0= ruleNestedDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:439:1: (lv_value_13_0= ruleNestedDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:439:1: (lv_value_13_0= ruleNestedDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:440:3: lv_value_13_0= ruleNestedDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueNestedDatatypeParserRuleCall_6_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel567);
                    lv_value_13_0=ruleNestedDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"value",
                    	        		lv_value_13_0, 
                    	        		"NestedDatatype", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:463:6: ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:463:6: ( '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:463:8: '4+' ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleModel585); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitFourPlusSignKeyword_7_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:467:1: ( (lv_multiValue_15_0= ruleNestedDatatype ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:468:1: (lv_multiValue_15_0= ruleNestedDatatype )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:468:1: (lv_multiValue_15_0= ruleNestedDatatype )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:469:3: lv_multiValue_15_0= ruleNestedDatatype
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getMultiValueNestedDatatypeParserRuleCall_7_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_ruleModel606);
                    lv_multiValue_15_0=ruleNestedDatatype();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"multiValue",
                    	        		lv_multiValue_15_0, 
                    	        		"NestedDatatype", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:6: ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:6: ( ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:7: ( 'content' ( (lv_children_17_0= ruleChild ) ) ) ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )?
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:7: ( 'content' ( (lv_children_17_0= ruleChild ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:492:9: 'content' ( (lv_children_17_0= ruleChild ) )
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleModel625); 

                            createLeafNode(grammarAccess.getModelAccess().getContentKeyword_8_0_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:496:1: ( (lv_children_17_0= ruleChild ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:497:1: (lv_children_17_0= ruleChild )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:497:1: (lv_children_17_0= ruleChild )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:498:3: lv_children_17_0= ruleChild
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getChildrenChildParserRuleCall_8_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleModel646);
                    lv_children_17_0=ruleChild();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"children",
                    	        		lv_children_17_0, 
                    	        		"Child", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:520:3: ( 'ref' ( ( ( RULE_STRING | RULE_ID ) ) ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==21) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:520:5: 'ref' ( ( ( RULE_STRING | RULE_ID ) ) )
                            {
                            match(input,21,FollowSets000.FOLLOW_21_in_ruleModel658); 

                                    createLeafNode(grammarAccess.getModelAccess().getRefKeyword_8_1_0(), null); 
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:524:1: ( ( ( RULE_STRING | RULE_ID ) ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:525:1: ( ( RULE_STRING | RULE_ID ) )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:525:1: ( ( RULE_STRING | RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:526:1: ( RULE_STRING | RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:526:1: ( RULE_STRING | RULE_ID )
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
                                    new NoViableAltException("526:1: ( RULE_STRING | RULE_ID )", 4, 0, input);

                                throw nvae;
                            }
                            switch (alt4) {
                                case 1 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:527:3: RULE_STRING
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleModel678); 

                                    		createLeafNode(grammarAccess.getModelAccess().getRefChild1CrossReference_8_1_1_0_0(), "ref"); 
                                    	

                                    }
                                    break;
                                case 2 :
                                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:538:8: RULE_ID
                                    {

                                    			if (current==null) {
                                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                                    	            associateNodeWithAstElement(currentNode, current);
                                    	        }
                                            
                                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel694); 

                                    		createLeafNode(grammarAccess.getModelAccess().getRefChild2CrossReference_8_1_1_0_1(), "ref"); 
                                    	

                                    }
                                    break;

                            }


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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:560:1: entryRuleDatatype returns [String current=null] : iv_ruleDatatype= ruleDatatype EOF ;
    public final String entryRuleDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:561:2: (iv_ruleDatatype= ruleDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:562:2: iv_ruleDatatype= ruleDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_entryRuleDatatype737);
            iv_ruleDatatype=ruleDatatype();
            _fsp--;

             current =iv_ruleDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatype748); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:569:1: ruleDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:574:6: ( (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:575:1: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:575:1: (this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:575:6: this_ID_0= RULE_ID kw= '-' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype788); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getDatatypeAccess().getIDTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,22,FollowSets000.FOLLOW_22_in_ruleDatatype806); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getDatatypeAccess().getHyphenMinusKeyword_1(), null); 
                
            this_ID_2=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDatatype821); 

            		current.merge(this_ID_2);
                
             
                createLeafNode(grammarAccess.getDatatypeAccess().getIDTerminalRuleCall_2(), null); 
                

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
    // $ANTLR end ruleDatatype


    // $ANTLR start entryRuleNestedDatatype
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:603:1: entryRuleNestedDatatype returns [String current=null] : iv_ruleNestedDatatype= ruleNestedDatatype EOF ;
    public final String entryRuleNestedDatatype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNestedDatatype = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:604:2: (iv_ruleNestedDatatype= ruleNestedDatatype EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:605:2: iv_ruleNestedDatatype= ruleNestedDatatype EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNestedDatatypeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype867);
            iv_ruleNestedDatatype=ruleNestedDatatype();
            _fsp--;

             current =iv_ruleNestedDatatype.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedDatatype878); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:612:1: ruleNestedDatatype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? ) ;
    public final AntlrDatatypeRuleToken ruleNestedDatatype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_Datatype_2 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:617:6: ( (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:618:1: (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:618:1: (this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:618:6: this_ID_0= RULE_ID kw= '+' (this_Datatype_2= ruleDatatype )?
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNestedDatatype918); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getNestedDatatypeAccess().getIDTerminalRuleCall_0(), null); 
                
            kw=(Token)input.LT(1);
            match(input,23,FollowSets000.FOLLOW_23_in_ruleNestedDatatype936); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getNestedDatatypeAccess().getPlusSignKeyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:631:1: (this_Datatype_2= ruleDatatype )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:632:5: this_Datatype_2= ruleDatatype
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getNestedDatatypeAccess().getDatatypeParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatype_in_ruleNestedDatatype959);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:650:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:651:2: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:652:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild1006);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild1016); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:659:1: ruleChild returns [EObject current=null] : (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        EObject this_Child1_0 = null;

        EObject this_Child2_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:664:6: ( (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:665:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:665:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )
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
                    new NoViableAltException("665:1: (this_Child1_0= ruleChild1 | this_Child2_1= ruleChild2 )", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:666:5: this_Child1_0= ruleChild1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getChildAccess().getChild1ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleChild1_in_ruleChild1063);
                    this_Child1_0=ruleChild1();
                    _fsp--;

                     
                            current = this_Child1_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:676:5: this_Child2_1= ruleChild2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getChildAccess().getChild2ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleChild2_in_ruleChild1090);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:692:1: entryRuleChild1 returns [EObject current=null] : iv_ruleChild1= ruleChild1 EOF ;
    public final EObject entryRuleChild1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:693:2: (iv_ruleChild1= ruleChild1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:694:2: iv_ruleChild1= ruleChild1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChild1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild1_in_entryRuleChild11125);
            iv_ruleChild1=ruleChild1();
            _fsp--;

             current =iv_ruleChild1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild11135); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:701:1: ruleChild1 returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleChild1() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:706:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:707:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:707:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:708:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:708:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:709:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild11176); 

            			createLeafNode(grammarAccess.getChild1Access().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChild1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleChild1


    // $ANTLR start entryRuleChild2
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:739:1: entryRuleChild2 returns [EObject current=null] : iv_ruleChild2= ruleChild2 EOF ;
    public final EObject entryRuleChild2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:740:2: (iv_ruleChild2= ruleChild2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:741:2: iv_ruleChild2= ruleChild2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChild2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild2_in_entryRuleChild21216);
            iv_ruleChild2=ruleChild2();
            _fsp--;

             current =iv_ruleChild2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild21226); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:748:1: ruleChild2 returns [EObject current=null] : ( (lv_name_0_0= RULE_STRING ) ) ;
    public final EObject ruleChild2() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:753:6: ( ( (lv_name_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:754:1: ( (lv_name_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:754:1: ( (lv_name_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:755:1: (lv_name_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:755:1: (lv_name_0_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/valueconverter/parser/antlr/internal/InternalBug250313.g:756:3: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleChild21267); 

            			createLeafNode(grammarAccess.getChild2Access().getNameSTRINGTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChild2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
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
    // $ANTLR end ruleChild2


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel122 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12_in_ruleModel144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleModel256 = new BitSet(new long[]{0x0000000000001030L});
        public static final BitSet FOLLOW_12_in_ruleModel276 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleModel388 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleModel428 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleModel468 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModel507 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleModel528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleModel546 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleModel585 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_ruleModel606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleModel625 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleChild_in_ruleModel646 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleModel658 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleModel678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatype_in_entryRuleDatatype737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatype748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype788 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleDatatype806 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDatatype821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedDatatype_in_entryRuleNestedDatatype867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedDatatype878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNestedDatatype918 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNestedDatatype936 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_ruleDatatype_in_ruleNestedDatatype959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild1006 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild1016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_in_ruleChild1063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_in_ruleChild1090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild1_in_entryRuleChild11125 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild11135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild11176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild2_in_entryRuleChild21216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild21226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleChild21267 = new BitSet(new long[]{0x0000000000000002L});
    }


}
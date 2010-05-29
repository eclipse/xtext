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
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.terminalrules.services.EcoreTerminalsTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcoreTerminalsTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_EINT", "RULE_EDOUBLE", "RULE_EDATE", "RULE_WS", "'int'", "'double'", "'date'"
    };
    public static final int RULE_EDATE=6;
    public static final int RULE_WS=7;
    public static final int EOF=-1;
    public static final int RULE_EDOUBLE=5;
    public static final int RULE_EINT=4;

        public InternalEcoreTerminalsTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g"; }



     	private EcoreTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEcoreTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, EcoreTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EcoreTerminalsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | ( 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | ( 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_intValues_1_0=null;
        Token lv_doubleValues_3_0=null;
        Token lv_dateValues_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:91:6: ( ( ( 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | ( 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | ( 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:92:1: ( ( 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | ( 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | ( 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:92:1: ( ( 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | ( 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | ( 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 8:
                    {
                    alt1=1;
                    }
                    break;
                case 9:
                    {
                    alt1=2;
                    }
                    break;
                case 10:
                    {
                    alt1=3;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:92:2: ( 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:92:2: ( 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:92:4: 'int' ( (lv_intValues_1_0= RULE_EINT ) )
            	    {
            	    match(input,8,FollowSets000.FOLLOW_8_in_ruleModel121); 

            	            createLeafNode(grammarAccess.getModelAccess().getIntKeyword_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:96:1: ( (lv_intValues_1_0= RULE_EINT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:97:1: (lv_intValues_1_0= RULE_EINT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:97:1: (lv_intValues_1_0= RULE_EINT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:98:3: lv_intValues_1_0= RULE_EINT
            	    {
            	    lv_intValues_1_0=(Token)input.LT(1);
            	    match(input,RULE_EINT,FollowSets000.FOLLOW_RULE_EINT_in_ruleModel138); 

            	    			createLeafNode(grammarAccess.getModelAccess().getIntValuesEINTTerminalRuleCall_0_1_0(), "intValues"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"intValues",
            	    	        		lv_intValues_1_0, 
            	    	        		"EINT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:121:6: ( 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:121:6: ( 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:121:8: 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    {
            	    match(input,9,FollowSets000.FOLLOW_9_in_ruleModel161); 

            	            createLeafNode(grammarAccess.getModelAccess().getDoubleKeyword_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:125:1: ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:126:1: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:126:1: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:127:3: lv_doubleValues_3_0= RULE_EDOUBLE
            	    {
            	    lv_doubleValues_3_0=(Token)input.LT(1);
            	    match(input,RULE_EDOUBLE,FollowSets000.FOLLOW_RULE_EDOUBLE_in_ruleModel178); 

            	    			createLeafNode(grammarAccess.getModelAccess().getDoubleValuesEDOUBLETerminalRuleCall_1_1_0(), "doubleValues"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"doubleValues",
            	    	        		lv_doubleValues_3_0, 
            	    	        		"EDOUBLE", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:150:6: ( 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:150:6: ( 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:150:8: 'date' ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    {
            	    match(input,10,FollowSets000.FOLLOW_10_in_ruleModel201); 

            	            createLeafNode(grammarAccess.getModelAccess().getDateKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:154:1: ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:1: (lv_dateValues_5_0= RULE_EDATE )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:155:1: (lv_dateValues_5_0= RULE_EDATE )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:156:3: lv_dateValues_5_0= RULE_EDATE
            	    {
            	    lv_dateValues_5_0=(Token)input.LT(1);
            	    match(input,RULE_EDATE,FollowSets000.FOLLOW_RULE_EDATE_in_ruleModel218); 

            	    			createLeafNode(grammarAccess.getModelAccess().getDateValuesEDATETerminalRuleCall_2_1_0(), "dateValues"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"dateValues",
            	    	        		lv_dateValues_5_0, 
            	    	        		"EDATE", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleModel121 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_EINT_in_ruleModel138 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_9_in_ruleModel161 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_EDOUBLE_in_ruleModel178 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_10_in_ruleModel201 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_EDATE_in_ruleModel218 = new BitSet(new long[]{0x0000000000000702L});
    }


}
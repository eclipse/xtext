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
    public static final int RULE_WS=7;
    public static final int RULE_EDATE=6;
    public static final int T__8=8;
    public static final int EOF=-1;
    public static final int T__10=10;
    public static final int RULE_EDOUBLE=5;
    public static final int T__9=9;
    public static final int RULE_EINT=4;

    // delegates
    // delegators


        public InternalEcoreTerminalsTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcoreTerminalsTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcoreTerminalsTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g"; }



     	private EcoreTerminalsTestLanguageGrammarAccess grammarAccess;
     	
        public InternalEcoreTerminalsTestLanguageParser(TokenStream input, IAstFactory factory, EcoreTerminalsTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected EcoreTerminalsTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_intValues_1_0=null;
        Token otherlv_2=null;
        Token lv_doubleValues_3_0=null;
        Token otherlv_4=null;
        Token lv_dateValues_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:85:6: ( ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:86:1: ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:86:1: ( (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) ) | (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) ) | (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) ) )*
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:86:2: (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:86:2: (otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:86:4: otherlv_0= 'int' ( (lv_intValues_1_0= RULE_EINT ) )
            	    {
            	    otherlv_0=(Token)match(input,8,FollowSets000.FOLLOW_8_in_ruleModel123); 

            	        	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getIntKeyword_0_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:90:1: ( (lv_intValues_1_0= RULE_EINT ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:91:1: (lv_intValues_1_0= RULE_EINT )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:91:1: (lv_intValues_1_0= RULE_EINT )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:92:3: lv_intValues_1_0= RULE_EINT
            	    {
            	    lv_intValues_1_0=(Token)match(input,RULE_EINT,FollowSets000.FOLLOW_RULE_EINT_in_ruleModel140); 

            	    			createLeafNode(lv_intValues_1_0, grammarAccess.getModelAccess().getIntValuesEINTTerminalRuleCall_0_1_0(), "intValues"); 
            	    		

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:115:6: (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:115:6: (otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:115:8: otherlv_2= 'double' ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    {
            	    otherlv_2=(Token)match(input,9,FollowSets000.FOLLOW_9_in_ruleModel165); 

            	        	createLeafNode(otherlv_2, grammarAccess.getModelAccess().getDoubleKeyword_1_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:119:1: ( (lv_doubleValues_3_0= RULE_EDOUBLE ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:120:1: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:120:1: (lv_doubleValues_3_0= RULE_EDOUBLE )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:121:3: lv_doubleValues_3_0= RULE_EDOUBLE
            	    {
            	    lv_doubleValues_3_0=(Token)match(input,RULE_EDOUBLE,FollowSets000.FOLLOW_RULE_EDOUBLE_in_ruleModel182); 

            	    			createLeafNode(lv_doubleValues_3_0, grammarAccess.getModelAccess().getDoubleValuesEDOUBLETerminalRuleCall_1_1_0(), "doubleValues"); 
            	    		

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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:144:6: (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:144:6: (otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:144:8: otherlv_4= 'date' ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    {
            	    otherlv_4=(Token)match(input,10,FollowSets000.FOLLOW_10_in_ruleModel207); 

            	        	createLeafNode(otherlv_4, grammarAccess.getModelAccess().getDateKeyword_2_0(), null);
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:148:1: ( (lv_dateValues_5_0= RULE_EDATE ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:149:1: (lv_dateValues_5_0= RULE_EDATE )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:149:1: (lv_dateValues_5_0= RULE_EDATE )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalEcoreTerminalsTestLanguage.g:150:3: lv_dateValues_5_0= RULE_EDATE
            	    {
            	    lv_dateValues_5_0=(Token)match(input,RULE_EDATE,FollowSets000.FOLLOW_RULE_EDATE_in_ruleModel224); 

            	    			createLeafNode(lv_dateValues_5_0, grammarAccess.getModelAccess().getDateValuesEDATETerminalRuleCall_2_1_0(), "dateValues"); 
            	    		

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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_8_in_ruleModel123 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_EINT_in_ruleModel140 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_9_in_ruleModel165 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_EDOUBLE_in_ruleModel182 = new BitSet(new long[]{0x0000000000000702L});
        public static final BitSet FOLLOW_10_in_ruleModel207 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_EDATE_in_ruleModel224 = new BitSet(new long[]{0x0000000000000702L});
    }


}
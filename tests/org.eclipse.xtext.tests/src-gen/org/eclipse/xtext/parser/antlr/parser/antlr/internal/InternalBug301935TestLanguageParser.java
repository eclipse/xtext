package org.eclipse.xtext.parser.antlr.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.antlr.services.Bug301935TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug301935TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_WS", "RULE_ANY_OTHER", "'\\r'", "'\\n'"
    };
    public static final int RULE_ANY_OTHER=6;
    public static final int RULE_ID=4;
    public static final int RULE_WS=5;
    public static final int EOF=-1;

        public InternalBug301935TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g"; }



     	private Bug301935TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug301935TestLanguageParser(TokenStream input, IAstFactory factory, Bug301935TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_value_2_0=null;
        Token lv_value2_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:86:6: ( ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:87:1: ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:87:1: ( ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:87:2: ( (lv_name_0_0= RULE_ID ) ) RULE_WS ( (lv_value_2_0= RULE_ID ) ) ruleNL ( (lv_value2_4_0= RULE_ID ) ) RULE_WS
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:87:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:88:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:88:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:89:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel127); 

            			createLeafNode(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
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

            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel141); 
             
                createLeafNode(grammarAccess.getModelAccess().getWSTerminalRuleCall_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:115:1: ( (lv_value_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:116:1: (lv_value_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:116:1: (lv_value_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:117:3: lv_value_2_0= RULE_ID
            {
            lv_value_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel157); 

            			createLeafNode(grammarAccess.getModelAccess().getValueIDTerminalRuleCall_2_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            pushFollow(FollowSets000.FOLLOW_ruleNL_in_ruleModel171);
            ruleNL();
            _fsp--;

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:139:8: ( (lv_value2_4_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:140:1: (lv_value2_4_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:140:1: (lv_value2_4_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:141:3: lv_value2_4_0= RULE_ID
            {
            lv_value2_4_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel180); 

            			createLeafNode(grammarAccess.getModelAccess().getValue2IDTerminalRuleCall_4_0(), "value2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value2",
            	        		lv_value2_4_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleModel194); 
             
                createLeafNode(grammarAccess.getModelAccess().getWSTerminalRuleCall_5(), null); 
                

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


    // $ANTLR start entryRuleNL
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:175:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:176:2: (iv_ruleNL= ruleNL EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:177:2: iv_ruleNL= ruleNL EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNLRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNL_in_entryRuleNL230);
            iv_ruleNL=ruleNL();
            _fsp--;

             current =iv_ruleNL.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNL241); 

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
    // $ANTLR end entryRuleNL


    // $ANTLR start ruleNL
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:184:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token kw=null;
        Token this_WS_3=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:189:6: ( ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:190:1: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:190:1: ( (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:190:2: (this_WS_0= RULE_WS )* ( (kw= '\\r' )? kw= '\\n' ) (this_WS_3= RULE_WS )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:190:2: (this_WS_0= RULE_WS )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:190:7: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)input.LT(1);
            	    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL282); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        createLeafNode(grammarAccess.getNLAccess().getWSTerminalRuleCall_0(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:197:3: ( (kw= '\\r' )? kw= '\\n' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:197:4: (kw= '\\r' )? kw= '\\n'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:197:4: (kw= '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==7) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:198:2: kw= '\\r'
                    {
                    kw=(Token)input.LT(1);
                    match(input,7,FollowSets000.FOLLOW_7_in_ruleNL304); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNLAccess().getCarriageReturnCrKeyword_1_0(), null); 
                        

                    }
                    break;

            }

            kw=(Token)input.LT(1);
            match(input,8,FollowSets000.FOLLOW_8_in_ruleNL319); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getNLAccess().getLineFeedLfKeyword_1_1(), null); 
                

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:209:2: (this_WS_3= RULE_WS )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/antlr/parser/antlr/internal/InternalBug301935TestLanguage.g:209:7: this_WS_3= RULE_WS
            	    {
            	    this_WS_3=(Token)input.LT(1);
            	    match(input,RULE_WS,FollowSets000.FOLLOW_RULE_WS_in_ruleNL336); 

            	    		current.merge(this_WS_3);
            	        
            	     
            	        createLeafNode(grammarAccess.getNLAccess().getWSTerminalRuleCall_2(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end ruleNL


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel127 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel141 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel157 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_ruleNL_in_ruleModel171 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel180 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleModel194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNL_in_entryRuleNL230 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNL241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL282 = new BitSet(new long[]{0x00000000000001A0L});
        public static final BitSet FOLLOW_7_in_ruleNL304 = new BitSet(new long[]{0x0000000000000100L});
        public static final BitSet FOLLOW_8_in_ruleNL319 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_WS_in_ruleNL336 = new BitSet(new long[]{0x0000000000000022L});
    }


}
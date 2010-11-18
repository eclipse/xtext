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
import org.eclipse.xtext.parsetree.reconstr.services.SerializationBug269362TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSerializationBug269362TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'foo'", "'bar'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalSerializationBug269362TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSerializationBug269362TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSerializationBug269362TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g"; }



     	private SerializationBug269362TestLanguageGrammarAccess grammarAccess;
     	
        public InternalSerializationBug269362TestLanguageParser(TokenStream input, IAstFactory factory, SerializationBug269362TestLanguageGrammarAccess grammarAccess) {
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
       	protected SerializationBug269362TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_foo_1_0=null;
        Token otherlv_2=null;
        Token lv_bar_3_0=null;
        Token otherlv_4=null;
        Token lv_bar_5_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:85:6: ( ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:86:1: ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:86:1: ( (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? ) | (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:86:2: (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:86:2: (otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )? )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:86:4: otherlv_0= 'foo' ( (lv_foo_1_0= RULE_ID ) ) (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )?
                    {
                    otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModel123); 

                        	createLeafNode(otherlv_0, grammarAccess.getModelAccess().getFooKeyword_0_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:90:1: ( (lv_foo_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:91:1: (lv_foo_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:91:1: (lv_foo_1_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:92:3: lv_foo_1_0= RULE_ID
                    {
                    lv_foo_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel140); 

                    			createLeafNode(lv_foo_1_0, grammarAccess.getModelAccess().getFooIDTerminalRuleCall_0_1_0(), "foo"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"foo",
                            		lv_foo_1_0, 
                            		"ID", 
                            		lastConsumedNode);
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:109:2: (otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==12) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:109:4: otherlv_2= 'bar' ( (lv_bar_3_0= RULE_ID ) )
                            {
                            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel158); 

                                	createLeafNode(otherlv_2, grammarAccess.getModelAccess().getBarKeyword_0_2_0(), null);
                                
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:113:1: ( (lv_bar_3_0= RULE_ID ) )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:114:1: (lv_bar_3_0= RULE_ID )
                            {
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:114:1: (lv_bar_3_0= RULE_ID )
                            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:115:3: lv_bar_3_0= RULE_ID
                            {
                            lv_bar_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel175); 

                            			createLeafNode(lv_bar_3_0, grammarAccess.getModelAccess().getBarIDTerminalRuleCall_0_2_1_0(), "bar"); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getModelRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"bar",
                                    		lv_bar_3_0, 
                                    		"ID", 
                                    		lastConsumedNode);
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:133:6: (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:133:6: (otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:133:8: otherlv_4= 'bar' ( (lv_bar_5_0= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModel202); 

                        	createLeafNode(otherlv_4, grammarAccess.getModelAccess().getBarKeyword_1_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:137:1: ( (lv_bar_5_0= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:138:1: (lv_bar_5_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:138:1: (lv_bar_5_0= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalSerializationBug269362TestLanguage.g:139:3: lv_bar_5_0= RULE_ID
                    {
                    lv_bar_5_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModel219); 

                    			createLeafNode(lv_bar_5_0, grammarAccess.getModelAccess().getBarIDTerminalRuleCall_1_1_0(), "bar"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelRule());
                    	        }
                           		set(
                           			current, 
                           			"bar",
                            		lv_bar_5_0, 
                            		"ID", 
                            		lastConsumedNode);
                    	    

                    }


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
    // $ANTLR end "ruleModel"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel123 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel140 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleModel158 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel202 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModel219 = new BitSet(new long[]{0x0000000000000002L});
    }


}
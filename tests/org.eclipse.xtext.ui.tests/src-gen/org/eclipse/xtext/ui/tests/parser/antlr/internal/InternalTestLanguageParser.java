package org.eclipse.xtext.ui.tests.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.services.TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'stuff'", "'refs'"
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


        public InternalTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g"; }



     	private TestLanguageGrammarAccess grammarAccess;
     	
        public InternalTestLanguageParser(TokenStream input, IAstFactory factory, TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "File";	
       	}
       	
       	@Override
       	protected TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleFile"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:71:1: entryRuleFile returns [EObject current=null] : iv_ruleFile= ruleFile EOF ;
    public final EObject entryRuleFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFile = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:72:2: (iv_ruleFile= ruleFile EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:73:2: iv_ruleFile= ruleFile EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFileRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFile_in_entryRuleFile75);
            iv_ruleFile=ruleFile();

            state._fsp--;

             current =iv_ruleFile; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFile85); 

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
    // $ANTLR end "entryRuleFile"


    // $ANTLR start "ruleFile"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:80:1: ruleFile returns [EObject current=null] : ( (lv_stuff_0_0= ruleStuff ) )* ;
    public final EObject ruleFile() throws RecognitionException {
        EObject current = null;

        EObject lv_stuff_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:85:6: ( ( (lv_stuff_0_0= ruleStuff ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:86:1: ( (lv_stuff_0_0= ruleStuff ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:86:1: ( (lv_stuff_0_0= ruleStuff ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:87:1: (lv_stuff_0_0= ruleStuff )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:87:1: (lv_stuff_0_0= ruleStuff )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:88:3: lv_stuff_0_0= ruleStuff
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getFileAccess().getStuffStuffParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleStuff_in_ruleFile130);
            	    lv_stuff_0_0=ruleStuff();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getFileRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"stuff",
            	    	        		lv_stuff_0_0, 
            	    	        		"Stuff", 
            	    	        		currentNode);
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
    // $ANTLR end "ruleFile"


    // $ANTLR start "entryRuleStuff"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:118:1: entryRuleStuff returns [EObject current=null] : iv_ruleStuff= ruleStuff EOF ;
    public final EObject entryRuleStuff() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStuff = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:119:2: (iv_ruleStuff= ruleStuff EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:120:2: iv_ruleStuff= ruleStuff EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStuffRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleStuff_in_entryRuleStuff166);
            iv_ruleStuff=ruleStuff();

            state._fsp--;

             current =iv_ruleStuff; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStuff176); 

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
    // $ANTLR end "entryRuleStuff"


    // $ANTLR start "ruleStuff"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:127:1: ruleStuff returns [EObject current=null] : (otherlv_0= 'stuff' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleStuff() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:132:6: ( (otherlv_0= 'stuff' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:133:1: (otherlv_0= 'stuff' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:133:1: (otherlv_0= 'stuff' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:133:3: otherlv_0= 'stuff' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleStuff213); 

                	createLeafNode(otherlv_0, grammarAccess.getStuffAccess().getStuffKeyword_0(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:137:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:138:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:138:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:139:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStuff230); 

            			createLeafNode(lv_name_1_0, grammarAccess.getStuffAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStuffRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:161:2: (otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:161:4: otherlv_2= 'refs' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleStuff248); 

                        	createLeafNode(otherlv_2, grammarAccess.getStuffAccess().getRefsKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:165:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:166:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:166:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/parser/antlr/internal/InternalTestLanguage.g:167:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getStuffRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleStuff268); 

                    		createLeafNode(otherlv_3, grammarAccess.getStuffAccess().getRefsStuffCrossReference_2_1_0(), "refs"); 
                    	

                    }


                    }


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
    // $ANTLR end "ruleStuff"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleFile_in_entryRuleFile75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFile85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStuff_in_ruleFile130 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleStuff_in_entryRuleStuff166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStuff176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleStuff213 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStuff230 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleStuff248 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleStuff268 = new BitSet(new long[]{0x0000000000000002L});
    }


}
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
import org.eclipse.xtext.parsetree.reconstr.services.PartialSerializationTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalPartialSerializationTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'node'", "'('", "')'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int RULE_WS=9;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__14=14;
    public static final int T__11=11;

    // delegates
    // delegators


        public InternalPartialSerializationTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalPartialSerializationTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalPartialSerializationTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g"; }



     	private PartialSerializationTestLanguageGrammarAccess grammarAccess;
     	
        public InternalPartialSerializationTestLanguageParser(TokenStream input, IAstFactory factory, PartialSerializationTestLanguageGrammarAccess grammarAccess) {
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
       	protected PartialSerializationTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:80:1: ruleModel returns [EObject current=null] : this_NodeRoot_0= ruleNodeRoot ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_NodeRoot_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:85:6: (this_NodeRoot_0= ruleNodeRoot )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:87:5: this_NodeRoot_0= ruleNodeRoot
            {
             
                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getNodeRootParserRuleCall(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleNodeRoot_in_ruleModel131);
            this_NodeRoot_0=ruleNodeRoot();

            state._fsp--;

             
                    current = this_NodeRoot_0; 
                    currentNode = currentNode.getParent();
                

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


    // $ANTLR start "entryRuleNodeRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:103:1: entryRuleNodeRoot returns [EObject current=null] : iv_ruleNodeRoot= ruleNodeRoot EOF ;
    public final EObject entryRuleNodeRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeRoot = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:104:2: (iv_ruleNodeRoot= ruleNodeRoot EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:105:2: iv_ruleNodeRoot= ruleNodeRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNodeRootRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeRoot_in_entryRuleNodeRoot165);
            iv_ruleNodeRoot=ruleNodeRoot();

            state._fsp--;

             current =iv_ruleNodeRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNodeRoot175); 

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
    // $ANTLR end "entryRuleNodeRoot"


    // $ANTLR start "ruleNodeRoot"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:112:1: ruleNodeRoot returns [EObject current=null] : (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) ;
    public final EObject ruleNodeRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_node_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:117:6: ( (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:118:1: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:118:1: (otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:118:3: otherlv_0= '#1' ( (lv_node_1_0= ruleNode ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleNodeRoot212); 

                	createLeafNode(otherlv_0, grammarAccess.getNodeRootAccess().getNumberSignDigitOneKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:122:1: ( (lv_node_1_0= ruleNode ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:123:1: (lv_node_1_0= ruleNode )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:123:1: (lv_node_1_0= ruleNode )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:124:3: lv_node_1_0= ruleNode
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNodeRootAccess().getNodeNodeParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_ruleNodeRoot233);
            lv_node_1_0=ruleNode();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNodeRootRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"node",
            	        		lv_node_1_0, 
            	        		"Node", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleNodeRoot"


    // $ANTLR start "entryRuleNode"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:154:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:155:2: (iv_ruleNode= ruleNode EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:156:2: iv_ruleNode= ruleNode EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNodeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_entryRuleNode269);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNode279); 

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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:163:1: ruleNode returns [EObject current=null] : (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_children_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:168:6: ( (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:169:1: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:169:1: (otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:169:3: otherlv_0= 'node' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNode316); 

                	createLeafNode(otherlv_0, grammarAccess.getNodeAccess().getNodeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:173:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:174:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:174:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:175:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNode333); 

            			createLeafNode(lv_name_1_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNodeRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:197:2: (otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:197:4: otherlv_2= '(' ( (lv_children_3_0= ruleNode ) )+ otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNode351); 

                        	createLeafNode(otherlv_2, grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:201:1: ( (lv_children_3_0= ruleNode ) )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:202:1: (lv_children_3_0= ruleNode )
                    	    {
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:202:1: (lv_children_3_0= ruleNode )
                    	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalPartialSerializationTestLanguage.g:203:3: lv_children_3_0= ruleNode
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleNode_in_ruleNode372);
                    	    lv_children_3_0=ruleNode();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getNodeRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"children",
                    	    	        		lv_children_3_0, 
                    	    	        		"Node", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);

                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNode385); 

                        	createLeafNode(otherlv_4, grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_2(), null);
                        

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
    // $ANTLR end "ruleNode"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeRoot_in_ruleModel131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeRoot_in_entryRuleNodeRoot165 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNodeRoot175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleNodeRoot212 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleNode_in_ruleNodeRoot233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNode_in_entryRuleNode269 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNode279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleNode316 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNode333 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleNode351 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_ruleNode_in_ruleNode372 = new BitSet(new long[]{0x0000000000005000L});
        public static final BitSet FOLLOW_14_in_ruleNode385 = new BitSet(new long[]{0x0000000000000002L});
    }


}
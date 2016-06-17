package org.eclipse.xtext.testlanguages.indent.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.indent.services.IndentationAwareTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIndentationAwareTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_NL", "RULE_BEGIN", "RULE_END", "RULE_OTHER"
    };
    public static final int RULE_END=6;
    public static final int RULE_BEGIN=5;
    public static final int RULE_OTHER=7;
    public static final int RULE_NL=4;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalIndentationAwareTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIndentationAwareTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIndentationAwareTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIndentationAwareTestLanguage.g"; }



     	private IndentationAwareTestLanguageGrammarAccess grammarAccess;
     	
        public InternalIndentationAwareTestLanguageParser(TokenStream input, IndentationAwareTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "NodeList";	
       	}
       	
       	@Override
       	protected IndentationAwareTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleNodeList"
    // InternalIndentationAwareTestLanguage.g:67:1: entryRuleNodeList returns [EObject current=null] : iv_ruleNodeList= ruleNodeList EOF ;
    public final EObject entryRuleNodeList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNodeList = null;


        try {
            // InternalIndentationAwareTestLanguage.g:68:2: (iv_ruleNodeList= ruleNodeList EOF )
            // InternalIndentationAwareTestLanguage.g:69:2: iv_ruleNodeList= ruleNodeList EOF
            {
             newCompositeNode(grammarAccess.getNodeListRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNodeList=ruleNodeList();

            state._fsp--;

             current =iv_ruleNodeList; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleNodeList"


    // $ANTLR start "ruleNodeList"
    // InternalIndentationAwareTestLanguage.g:76:1: ruleNodeList returns [EObject current=null] : ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* ) ;
    public final EObject ruleNodeList() throws RecognitionException {
        EObject current = null;

        Token this_NL_1=null;
        EObject lv_children_0_0 = null;

        EObject lv_children_2_0 = null;


         enterRule(); 
            
        try {
            // InternalIndentationAwareTestLanguage.g:79:28: ( ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* ) )
            // InternalIndentationAwareTestLanguage.g:80:1: ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* )
            {
            // InternalIndentationAwareTestLanguage.g:80:1: ( ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )* )
            // InternalIndentationAwareTestLanguage.g:80:2: ( (lv_children_0_0= ruleNode ) ) (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )*
            {
            // InternalIndentationAwareTestLanguage.g:80:2: ( (lv_children_0_0= ruleNode ) )
            // InternalIndentationAwareTestLanguage.g:81:1: (lv_children_0_0= ruleNode )
            {
            // InternalIndentationAwareTestLanguage.g:81:1: (lv_children_0_0= ruleNode )
            // InternalIndentationAwareTestLanguage.g:82:3: lv_children_0_0= ruleNode
            {
             
            	        newCompositeNode(grammarAccess.getNodeListAccess().getChildrenNodeParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_3);
            lv_children_0_0=ruleNode();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeListRule());
            	        }
                   		add(
                   			current, 
                   			"children",
                    		lv_children_0_0, 
                    		"org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage.Node");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalIndentationAwareTestLanguage.g:98:2: (this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_NL) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguage.g:98:3: this_NL_1= RULE_NL ( (lv_children_2_0= ruleNode ) )
            	    {
            	    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_4); 
            	     
            	        newLeafNode(this_NL_1, grammarAccess.getNodeListAccess().getNLTerminalRuleCall_1_0()); 
            	        
            	    // InternalIndentationAwareTestLanguage.g:102:1: ( (lv_children_2_0= ruleNode ) )
            	    // InternalIndentationAwareTestLanguage.g:103:1: (lv_children_2_0= ruleNode )
            	    {
            	    // InternalIndentationAwareTestLanguage.g:103:1: (lv_children_2_0= ruleNode )
            	    // InternalIndentationAwareTestLanguage.g:104:3: lv_children_2_0= ruleNode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNodeListAccess().getChildrenNodeParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_children_2_0=ruleNode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNodeListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"children",
            	            		lv_children_2_0, 
            	            		"org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage.Node");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNodeList"


    // $ANTLR start "entryRuleNode"
    // InternalIndentationAwareTestLanguage.g:128:1: entryRuleNode returns [EObject current=null] : iv_ruleNode= ruleNode EOF ;
    public final EObject entryRuleNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNode = null;


        try {
            // InternalIndentationAwareTestLanguage.g:129:2: (iv_ruleNode= ruleNode EOF )
            // InternalIndentationAwareTestLanguage.g:130:2: iv_ruleNode= ruleNode EOF
            {
             newCompositeNode(grammarAccess.getNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNode=ruleNode();

            state._fsp--;

             current =iv_ruleNode; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalIndentationAwareTestLanguage.g:137:1: ruleNode returns [EObject current=null] : ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? ) ;
    public final EObject ruleNode() throws RecognitionException {
        EObject current = null;

        Token this_NL_1=null;
        Token this_BEGIN_2=null;
        Token this_END_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_children_3_0 = null;


         enterRule(); 
            
        try {
            // InternalIndentationAwareTestLanguage.g:140:28: ( ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? ) )
            // InternalIndentationAwareTestLanguage.g:141:1: ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? )
            {
            // InternalIndentationAwareTestLanguage.g:141:1: ( ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )? )
            // InternalIndentationAwareTestLanguage.g:141:2: ( (lv_name_0_0= ruleString ) ) (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )?
            {
            // InternalIndentationAwareTestLanguage.g:141:2: ( (lv_name_0_0= ruleString ) )
            // InternalIndentationAwareTestLanguage.g:142:1: (lv_name_0_0= ruleString )
            {
            // InternalIndentationAwareTestLanguage.g:142:1: (lv_name_0_0= ruleString )
            // InternalIndentationAwareTestLanguage.g:143:3: lv_name_0_0= ruleString
            {
             
            	        newCompositeNode(grammarAccess.getNodeAccess().getNameStringParserRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_3);
            lv_name_0_0=ruleString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNodeRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage.String");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalIndentationAwareTestLanguage.g:159:2: (this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_NL) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==RULE_BEGIN) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // InternalIndentationAwareTestLanguage.g:159:3: this_NL_1= RULE_NL this_BEGIN_2= RULE_BEGIN ( (lv_children_3_0= ruleNodeList ) ) this_END_4= RULE_END
                    {
                    this_NL_1=(Token)match(input,RULE_NL,FollowSets000.FOLLOW_5); 
                     
                        newLeafNode(this_NL_1, grammarAccess.getNodeAccess().getNLTerminalRuleCall_1_0()); 
                        
                    this_BEGIN_2=(Token)match(input,RULE_BEGIN,FollowSets000.FOLLOW_4); 
                     
                        newLeafNode(this_BEGIN_2, grammarAccess.getNodeAccess().getBEGINTerminalRuleCall_1_1()); 
                        
                    // InternalIndentationAwareTestLanguage.g:167:1: ( (lv_children_3_0= ruleNodeList ) )
                    // InternalIndentationAwareTestLanguage.g:168:1: (lv_children_3_0= ruleNodeList )
                    {
                    // InternalIndentationAwareTestLanguage.g:168:1: (lv_children_3_0= ruleNodeList )
                    // InternalIndentationAwareTestLanguage.g:169:3: lv_children_3_0= ruleNodeList
                    {
                     
                    	        newCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeListParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_children_3_0=ruleNodeList();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNodeRule());
                    	        }
                           		set(
                           			current, 
                           			"children",
                            		lv_children_3_0, 
                            		"org.eclipse.xtext.testlanguages.indent.IndentationAwareTestLanguage.NodeList");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    this_END_4=(Token)match(input,RULE_END,FollowSets000.FOLLOW_2); 
                     
                        newLeafNode(this_END_4, grammarAccess.getNodeAccess().getENDTerminalRuleCall_1_3()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleString"
    // InternalIndentationAwareTestLanguage.g:197:1: entryRuleString returns [String current=null] : iv_ruleString= ruleString EOF ;
    public final String entryRuleString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleString = null;


        try {
            // InternalIndentationAwareTestLanguage.g:198:2: (iv_ruleString= ruleString EOF )
            // InternalIndentationAwareTestLanguage.g:199:2: iv_ruleString= ruleString EOF
            {
             newCompositeNode(grammarAccess.getStringRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleString=ruleString();

            state._fsp--;

             current =iv_ruleString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // $ANTLR end "entryRuleString"


    // $ANTLR start "ruleString"
    // InternalIndentationAwareTestLanguage.g:206:1: ruleString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OTHER_0= RULE_OTHER )+ ;
    public final AntlrDatatypeRuleToken ruleString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OTHER_0=null;

         enterRule(); 
            
        try {
            // InternalIndentationAwareTestLanguage.g:209:28: ( (this_OTHER_0= RULE_OTHER )+ )
            // InternalIndentationAwareTestLanguage.g:210:1: (this_OTHER_0= RULE_OTHER )+
            {
            // InternalIndentationAwareTestLanguage.g:210:1: (this_OTHER_0= RULE_OTHER )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_OTHER) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIndentationAwareTestLanguage.g:210:6: this_OTHER_0= RULE_OTHER
            	    {
            	    this_OTHER_0=(Token)match(input,RULE_OTHER,FollowSets000.FOLLOW_7); 

            	    		current.merge(this_OTHER_0);
            	        
            	     
            	        newLeafNode(this_OTHER_0, grammarAccess.getStringAccess().getOTHERTerminalRuleCall()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleString"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000082L});
    }


}
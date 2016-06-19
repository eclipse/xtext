package org.eclipse.xtext.grammarinheritance.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.grammarinheritance.services.InheritanceTest3LanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInheritanceTest3LanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SUPER_ID", "SUPER_1_ID", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'model'", "'{'", "'}'"
    };
    public static final int RULE_ID=7;
    public static final int RULE_WS=11;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int SUPER_ID=4;
    public static final int RULE_INT=8;
    public static final int RULE_ML_COMMENT=9;
    public static final int SUPER_1_ID=5;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalInheritanceTest3LanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInheritanceTest3LanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInheritanceTest3LanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalInheritanceTest3Language.g"; }



     	private InheritanceTest3LanguageGrammarAccess grammarAccess;
     	
        public InternalInheritanceTest3LanguageParser(TokenStream input, InheritanceTest3LanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected InheritanceTest3LanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalInheritanceTest3Language.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalInheritanceTest3Language.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalInheritanceTest3Language.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalInheritanceTest3Language.g:76:1: ruleModel returns [EObject current=null] : this_Model_0= superModel ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Model_0 = null;


         enterRule(); 
            
        try {
            // InternalInheritanceTest3Language.g:79:28: (this_Model_0= superModel )
            // InternalInheritanceTest3Language.g:81:5: this_Model_0= superModel
            {
             
                    newCompositeNode(grammarAccess.getModelAccess().getModelParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_Model_0=superModel();

            state._fsp--;

             
                    current = this_Model_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // InternalInheritanceTest3Language.g:97:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalInheritanceTest3Language.g:98:2: (iv_ruleElement= ruleElement EOF )
            // InternalInheritanceTest3Language.g:99:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalInheritanceTest3Language.g:106:1: ruleElement returns [EObject current=null] : (this_Element_0= superElement | ( () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) ) ) | ( () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) ) ) | ( () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_5=null;
        Token lv_name_6_0=null;
        Token otherlv_8=null;
        Token lv_name_9_0=null;
        EObject this_Element_0 = null;


         enterRule(); 
            
        try {
            // InternalInheritanceTest3Language.g:109:28: ( (this_Element_0= superElement | ( () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) ) ) | ( () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) ) ) | ( () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) ) ) ) )
            // InternalInheritanceTest3Language.g:110:1: (this_Element_0= superElement | ( () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) ) ) | ( () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) ) ) | ( () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) ) ) )
            {
            // InternalInheritanceTest3Language.g:110:1: (this_Element_0= superElement | ( () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) ) ) | ( () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) ) ) | ( () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) ) ) )
            int alt1=4;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                switch ( input.LA(2) ) {
                case SUPER_ID:
                    {
                    alt1=2;
                    }
                    break;
                case SUPER_1_ID:
                    {
                    alt1=3;
                    }
                    break;
                case RULE_ID:
                    {
                    alt1=1;
                    }
                    break;
                case RULE_STRING:
                    {
                    alt1=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalInheritanceTest3Language.g:111:5: this_Element_0= superElement
                    {
                     
                            newCompositeNode(grammarAccess.getElementAccess().getElementParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Element_0=superElement();

                    state._fsp--;

                     
                            current = this_Element_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalInheritanceTest3Language.g:120:6: ( () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) ) )
                    {
                    // InternalInheritanceTest3Language.g:120:6: ( () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) ) )
                    // InternalInheritanceTest3Language.g:120:7: () otherlv_2= 'element' ( (lv_name_3_0= SUPER_ID ) )
                    {
                    // InternalInheritanceTest3Language.g:120:7: ()
                    // InternalInheritanceTest3Language.g:121:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getElementAccess().getElementAction_1_0(),
                                current);
                        

                    }

                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getElementAccess().getElementKeyword_1_1());
                        
                    // InternalInheritanceTest3Language.g:130:1: ( (lv_name_3_0= SUPER_ID ) )
                    // InternalInheritanceTest3Language.g:131:1: (lv_name_3_0= SUPER_ID )
                    {
                    // InternalInheritanceTest3Language.g:131:1: (lv_name_3_0= SUPER_ID )
                    // InternalInheritanceTest3Language.g:132:3: lv_name_3_0= SUPER_ID
                    {
                    lv_name_3_0=(Token)match(input,SUPER_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalInheritanceTest3Language.g:149:6: ( () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) ) )
                    {
                    // InternalInheritanceTest3Language.g:149:6: ( () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) ) )
                    // InternalInheritanceTest3Language.g:149:7: () otherlv_5= 'element' ( (lv_name_6_0= SUPER_1_ID ) )
                    {
                    // InternalInheritanceTest3Language.g:149:7: ()
                    // InternalInheritanceTest3Language.g:150:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getElementAccess().getElementAction_2_0(),
                                current);
                        

                    }

                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_4); 

                        	newLeafNode(otherlv_5, grammarAccess.getElementAccess().getElementKeyword_2_1());
                        
                    // InternalInheritanceTest3Language.g:159:1: ( (lv_name_6_0= SUPER_1_ID ) )
                    // InternalInheritanceTest3Language.g:160:1: (lv_name_6_0= SUPER_1_ID )
                    {
                    // InternalInheritanceTest3Language.g:160:1: (lv_name_6_0= SUPER_1_ID )
                    // InternalInheritanceTest3Language.g:161:3: lv_name_6_0= SUPER_1_ID
                    {
                    lv_name_6_0=(Token)match(input,SUPER_1_ID,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_name_6_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_2_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_6_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalInheritanceTest3Language.g:178:6: ( () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) ) )
                    {
                    // InternalInheritanceTest3Language.g:178:6: ( () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) ) )
                    // InternalInheritanceTest3Language.g:178:7: () otherlv_8= 'element' ( (lv_name_9_0= RULE_STRING ) )
                    {
                    // InternalInheritanceTest3Language.g:178:7: ()
                    // InternalInheritanceTest3Language.g:179:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getElementAccess().getElementAction_3_0(),
                                current);
                        

                    }

                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_8, grammarAccess.getElementAccess().getElementKeyword_3_1());
                        
                    // InternalInheritanceTest3Language.g:188:1: ( (lv_name_9_0= RULE_STRING ) )
                    // InternalInheritanceTest3Language.g:189:1: (lv_name_9_0= RULE_STRING )
                    {
                    // InternalInheritanceTest3Language.g:189:1: (lv_name_9_0= RULE_STRING )
                    // InternalInheritanceTest3Language.g:190:3: lv_name_9_0= RULE_STRING
                    {
                    lv_name_9_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_name_9_0, grammarAccess.getElementAccess().getNameSTRINGTerminalRuleCall_3_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_9_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entrySuperModel"
    // InternalInheritanceTest3Language.g:214:1: entrySuperModel returns [EObject current=null] : iv_superModel= superModel EOF ;
    public final EObject entrySuperModel() throws RecognitionException {
        EObject current = null;

        EObject iv_superModel = null;


        try {
            // InternalInheritanceTest3Language.g:215:2: (iv_superModel= superModel EOF )
            // InternalInheritanceTest3Language.g:216:2: iv_superModel= superModel EOF
            {
             newCompositeNode(grammarAccess.getInheritanceTestLanguageModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_superModel=superModel();

            state._fsp--;

             current =iv_superModel; 
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
    // $ANTLR end "entrySuperModel"


    // $ANTLR start "superModel"
    // InternalInheritanceTest3Language.g:223:1: superModel returns [EObject current=null] : (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) ;
    public final EObject superModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_elements_3_0 = null;


         enterRule(); 
            
        try {
            // InternalInheritanceTest3Language.g:226:28: ( (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) )
            // InternalInheritanceTest3Language.g:227:1: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            {
            // InternalInheritanceTest3Language.g:227:1: (otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            // InternalInheritanceTest3Language.g:227:3: otherlv_0= 'model' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getInheritanceTestLanguageModelAccess().getModelKeyword_0());
                
            // InternalInheritanceTest3Language.g:231:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalInheritanceTest3Language.g:232:1: (lv_name_1_0= RULE_ID )
            {
            // InternalInheritanceTest3Language.g:232:1: (lv_name_1_0= RULE_ID )
            // InternalInheritanceTest3Language.g:233:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInheritanceTestLanguageModelAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInheritanceTestLanguageModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.grammarinheritance.InheritanceTest3Language.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_8); 

                	newLeafNode(otherlv_2, grammarAccess.getInheritanceTestLanguageModelAccess().getLeftCurlyBracketKeyword_2());
                
            // InternalInheritanceTest3Language.g:253:1: ( (lv_elements_3_0= ruleElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalInheritanceTest3Language.g:254:1: (lv_elements_3_0= ruleElement )
            	    {
            	    // InternalInheritanceTest3Language.g:254:1: (lv_elements_3_0= ruleElement )
            	    // InternalInheritanceTest3Language.g:255:3: lv_elements_3_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInheritanceTestLanguageModelAccess().getElementsElementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_elements_3_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInheritanceTestLanguageModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_3_0, 
            	            		"org.eclipse.xtext.grammarinheritance.InheritanceTest3Language.Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getInheritanceTestLanguageModelAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "superModel"


    // $ANTLR start "entrySuperElement"
    // InternalInheritanceTest3Language.g:283:1: entrySuperElement returns [EObject current=null] : iv_superElement= superElement EOF ;
    public final EObject entrySuperElement() throws RecognitionException {
        EObject current = null;

        EObject iv_superElement = null;


        try {
            // InternalInheritanceTest3Language.g:284:2: (iv_superElement= superElement EOF )
            // InternalInheritanceTest3Language.g:285:2: iv_superElement= superElement EOF
            {
             newCompositeNode(grammarAccess.getInheritanceTestLanguageElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_superElement=superElement();

            state._fsp--;

             current =iv_superElement; 
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
    // $ANTLR end "entrySuperElement"


    // $ANTLR start "superElement"
    // InternalInheritanceTest3Language.g:292:1: superElement returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject superElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalInheritanceTest3Language.g:295:28: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalInheritanceTest3Language.g:296:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalInheritanceTest3Language.g:296:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalInheritanceTest3Language.g:296:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getInheritanceTestLanguageElementAccess().getElementKeyword_0());
                
            // InternalInheritanceTest3Language.g:300:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalInheritanceTest3Language.g:301:1: (lv_name_1_0= RULE_ID )
            {
            // InternalInheritanceTest3Language.g:301:1: (lv_name_1_0= RULE_ID )
            // InternalInheritanceTest3Language.g:302:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_1_0, grammarAccess.getInheritanceTestLanguageElementAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getInheritanceTestLanguageElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.grammarinheritance.InheritanceTest3Language.ID");
            	    

            }


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
    // $ANTLR end "superElement"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000012000L});
    }


}
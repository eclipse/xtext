package org.eclipse.xtext.testlanguages.parser.antlr.internal; 

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
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalActionTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

    // delegates
    // delegators


        public InternalActionTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalActionTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalActionTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g"; }



     	private ActionTestLanguageGrammarAccess grammarAccess;
     	
        public InternalActionTestLanguageParser(TokenStream input, IAstFactory factory, ActionTestLanguageGrammarAccess grammarAccess) {
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
       	protected ActionTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:80:1: ruleModel returns [EObject current=null] : (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Child_0 = null;

        EObject lv_right_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:85:6: ( (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:86:1: (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:86:1: (this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:87:5: this_Child_0= ruleChild ( () ( (lv_right_2_0= ruleChild ) ) )?
            {
             
                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getChildParserRuleCall_0(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleModel132);
            this_Child_0=ruleChild();

            state._fsp--;

             
                    current = this_Child_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:95:1: ( () ( (lv_right_2_0= ruleChild ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:95:2: () ( (lv_right_2_0= ruleChild ) )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:95:2: ()
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:96:5: 
                    {
                     
                            temp=factory.create(grammarAccess.getModelAccess().getParentLeftAction_1_0().getType().getClassifier());
                            try {
                            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                            } catch(ValueConverterException vce) {
                            	handleValueConverterException(vce);
                            }
                            current = temp; 
                            temp = null;
                            CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getParentLeftAction_1_0(), currentNode.getParent());
                        newNode.getChildren().add(currentNode);
                        moveLookaheadInfo(currentNode, newNode);
                        currentNode = newNode; 
                            associateNodeWithAstElement(currentNode, current); 
                        

                    }

                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:111:2: ( (lv_right_2_0= ruleChild ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:112:1: (lv_right_2_0= ruleChild )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:112:1: (lv_right_2_0= ruleChild )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:113:3: lv_right_2_0= ruleChild
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getRightChildParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleModel162);
                    lv_right_2_0=ruleChild();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"right",
                    	        		lv_right_2_0, 
                    	        		"Child", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleChild"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:143:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:144:2: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:145:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild200);
            iv_ruleChild=ruleChild();

            state._fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild210); 

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
    // $ANTLR end "entryRuleChild"


    // $ANTLR start "ruleChild"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:152:1: ruleChild returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:157:6: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:158:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:158:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:159:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:159:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/testlanguages/parser/antlr/internal/InternalActionTestLanguage.g:160:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild251); 

            			createLeafNode(lv_name_0_0, grammarAccess.getChildAccess().getNameIDTerminalRuleCall_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChildRule().getType().getClassifier());
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
    // $ANTLR end "ruleChild"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_ruleModel132 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleChild_in_ruleModel162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild200 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild251 = new BitSet(new long[]{0x0000000000000002L});
    }


}
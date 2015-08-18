package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug288760TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug288760TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_START_TAG", "RULE_END_TAG_SHORT", "RULE_GT", "RULE_END_TAG", "RULE_ID", "RULE_EQ", "RULE_STRING", "RULE_ML_COMMENT", "RULE_LT", "RULE_END_TAG_START", "RULE_INT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=8;
    public static final int RULE_STRING=10;
    public static final int RULE_END_TAG=7;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_GT=6;
    public static final int RULE_EQ=9;
    public static final int RULE_INT=14;
    public static final int RULE_WS=15;
    public static final int EOF=-1;
    public static final int RULE_END_TAG_START=13;
    public static final int RULE_END_TAG_SHORT=5;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_START_TAG=4;
    public static final int RULE_LT=12;

    // delegates
    // delegators


        public InternalBug288760TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug288760TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug288760TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug288760TestLanguage.g"; }



     	private Bug288760TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug288760TestLanguageParser(TokenStream input, Bug288760TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "WorkflowElement";	
       	}
       	
       	@Override
       	protected Bug288760TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleWorkflowElement"
    // InternalBug288760TestLanguage.g:67:1: entryRuleWorkflowElement returns [EObject current=null] : iv_ruleWorkflowElement= ruleWorkflowElement EOF ;
    public final EObject entryRuleWorkflowElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflowElement = null;


        try {
            // InternalBug288760TestLanguage.g:68:2: (iv_ruleWorkflowElement= ruleWorkflowElement EOF )
            // InternalBug288760TestLanguage.g:69:2: iv_ruleWorkflowElement= ruleWorkflowElement EOF
            {
             newCompositeNode(grammarAccess.getWorkflowElementRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleWorkflowElement=ruleWorkflowElement();

            state._fsp--;

             current =iv_ruleWorkflowElement; 
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
    // $ANTLR end "entryRuleWorkflowElement"


    // $ANTLR start "ruleWorkflowElement"
    // InternalBug288760TestLanguage.g:76:1: ruleWorkflowElement returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) ) ;
    public final EObject ruleWorkflowElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_END_TAG_SHORT_2=null;
        Token lv_name_3_0=null;
        Token this_GT_5=null;
        Token lv_end_7_0=null;
        EObject lv_attributes_1_0 = null;

        EObject lv_attributes_4_0 = null;

        EObject lv_children_6_0 = null;


         enterRule(); 
            
        try {
            // InternalBug288760TestLanguage.g:79:28: ( ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) ) )
            // InternalBug288760TestLanguage.g:80:1: ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) )
            {
            // InternalBug288760TestLanguage.g:80:1: ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // InternalBug288760TestLanguage.g:80:2: ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT )
                    {
                    // InternalBug288760TestLanguage.g:80:2: ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT )
                    // InternalBug288760TestLanguage.g:80:3: ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT
                    {
                    // InternalBug288760TestLanguage.g:80:3: ( (lv_name_0_0= RULE_START_TAG ) )
                    // InternalBug288760TestLanguage.g:81:1: (lv_name_0_0= RULE_START_TAG )
                    {
                    // InternalBug288760TestLanguage.g:81:1: (lv_name_0_0= RULE_START_TAG )
                    // InternalBug288760TestLanguage.g:82:3: lv_name_0_0= RULE_START_TAG
                    {
                    lv_name_0_0=(Token)match(input,RULE_START_TAG,FollowSets000.FOLLOW_3); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWorkflowElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.START_TAG");
                    	    

                    }


                    }

                    // InternalBug288760TestLanguage.g:98:2: ( (lv_attributes_1_0= ruleAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalBug288760TestLanguage.g:99:1: (lv_attributes_1_0= ruleAttribute )
                    	    {
                    	    // InternalBug288760TestLanguage.g:99:1: (lv_attributes_1_0= ruleAttribute )
                    	    // InternalBug288760TestLanguage.g:100:3: lv_attributes_1_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_3);
                    	    lv_attributes_1_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWorkflowElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_1_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    this_END_TAG_SHORT_2=(Token)match(input,RULE_END_TAG_SHORT,FollowSets000.FOLLOW_2); 
                     
                        newLeafNode(this_END_TAG_SHORT_2, grammarAccess.getWorkflowElementAccess().getEND_TAG_SHORTTerminalRuleCall_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug288760TestLanguage.g:121:6: ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) )
                    {
                    // InternalBug288760TestLanguage.g:121:6: ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) )
                    // InternalBug288760TestLanguage.g:121:7: ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) )
                    {
                    // InternalBug288760TestLanguage.g:121:7: ( (lv_name_3_0= RULE_START_TAG ) )
                    // InternalBug288760TestLanguage.g:122:1: (lv_name_3_0= RULE_START_TAG )
                    {
                    // InternalBug288760TestLanguage.g:122:1: (lv_name_3_0= RULE_START_TAG )
                    // InternalBug288760TestLanguage.g:123:3: lv_name_3_0= RULE_START_TAG
                    {
                    lv_name_3_0=(Token)match(input,RULE_START_TAG,FollowSets000.FOLLOW_4); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getWorkflowElementAccess().getNameSTART_TAGTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWorkflowElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.START_TAG");
                    	    

                    }


                    }

                    // InternalBug288760TestLanguage.g:139:2: ( (lv_attributes_4_0= ruleAttribute ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // InternalBug288760TestLanguage.g:140:1: (lv_attributes_4_0= ruleAttribute )
                    	    {
                    	    // InternalBug288760TestLanguage.g:140:1: (lv_attributes_4_0= ruleAttribute )
                    	    // InternalBug288760TestLanguage.g:141:3: lv_attributes_4_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWorkflowElementAccess().getAttributesAttributeParserRuleCall_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_4);
                    	    lv_attributes_4_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWorkflowElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_4_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    this_GT_5=(Token)match(input,RULE_GT,FollowSets000.FOLLOW_5); 
                     
                        newLeafNode(this_GT_5, grammarAccess.getWorkflowElementAccess().getGTTerminalRuleCall_1_2()); 
                        
                    // InternalBug288760TestLanguage.g:161:1: ( (lv_children_6_0= ruleWorkflowElement ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_START_TAG) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalBug288760TestLanguage.g:162:1: (lv_children_6_0= ruleWorkflowElement )
                    	    {
                    	    // InternalBug288760TestLanguage.g:162:1: (lv_children_6_0= ruleWorkflowElement )
                    	    // InternalBug288760TestLanguage.g:163:3: lv_children_6_0= ruleWorkflowElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getWorkflowElementAccess().getChildrenWorkflowElementParserRuleCall_1_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_5);
                    	    lv_children_6_0=ruleWorkflowElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getWorkflowElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"children",
                    	            		lv_children_6_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.WorkflowElement");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // InternalBug288760TestLanguage.g:179:3: ( (lv_end_7_0= RULE_END_TAG ) )
                    // InternalBug288760TestLanguage.g:180:1: (lv_end_7_0= RULE_END_TAG )
                    {
                    // InternalBug288760TestLanguage.g:180:1: (lv_end_7_0= RULE_END_TAG )
                    // InternalBug288760TestLanguage.g:181:3: lv_end_7_0= RULE_END_TAG
                    {
                    lv_end_7_0=(Token)match(input,RULE_END_TAG,FollowSets000.FOLLOW_2); 

                    			newLeafNode(lv_end_7_0, grammarAccess.getWorkflowElementAccess().getEndEND_TAGTerminalRuleCall_1_4_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getWorkflowElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"end",
                            		lv_end_7_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.END_TAG");
                    	    

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
    // $ANTLR end "ruleWorkflowElement"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug288760TestLanguage.g:205:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalBug288760TestLanguage.g:206:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalBug288760TestLanguage.g:207:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalBug288760TestLanguage.g:214:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) this_EQ_1= RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_EQ_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // InternalBug288760TestLanguage.g:217:28: ( ( ( (lv_name_0_0= RULE_ID ) ) this_EQ_1= RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) ) )
            // InternalBug288760TestLanguage.g:218:1: ( ( (lv_name_0_0= RULE_ID ) ) this_EQ_1= RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // InternalBug288760TestLanguage.g:218:1: ( ( (lv_name_0_0= RULE_ID ) ) this_EQ_1= RULE_EQ ( (lv_value_2_0= RULE_STRING ) ) )
            // InternalBug288760TestLanguage.g:218:2: ( (lv_name_0_0= RULE_ID ) ) this_EQ_1= RULE_EQ ( (lv_value_2_0= RULE_STRING ) )
            {
            // InternalBug288760TestLanguage.g:218:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalBug288760TestLanguage.g:219:1: (lv_name_0_0= RULE_ID )
            {
            // InternalBug288760TestLanguage.g:219:1: (lv_name_0_0= RULE_ID )
            // InternalBug288760TestLanguage.g:220:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.ID");
            	    

            }


            }

            this_EQ_1=(Token)match(input,RULE_EQ,FollowSets000.FOLLOW_7); 
             
                newLeafNode(this_EQ_1, grammarAccess.getAttributeAccess().getEQTerminalRuleCall_1()); 
                
            // InternalBug288760TestLanguage.g:240:1: ( (lv_value_2_0= RULE_STRING ) )
            // InternalBug288760TestLanguage.g:241:1: (lv_value_2_0= RULE_STRING )
            {
            // InternalBug288760TestLanguage.g:241:1: (lv_value_2_0= RULE_STRING )
            // InternalBug288760TestLanguage.g:242:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug288760TestLanguage.STRING");
            	    

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
    // $ANTLR end "ruleAttribute"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\7\uffff";
    static final String DFA4_eofS =
        "\7\uffff";
    static final String DFA4_minS =
        "\1\4\1\5\1\11\2\uffff\1\12\1\5";
    static final String DFA4_maxS =
        "\1\4\1\10\1\11\2\uffff\1\12\1\10";
    static final String DFA4_acceptS =
        "\3\uffff\1\1\1\2\2\uffff";
    static final String DFA4_specialS =
        "\7\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1",
            "\1\3\1\4\1\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\3\1\4\1\uffff\1\2"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "80:1: ( ( ( (lv_name_0_0= RULE_START_TAG ) ) ( (lv_attributes_1_0= ruleAttribute ) )* this_END_TAG_SHORT_2= RULE_END_TAG_SHORT ) | ( ( (lv_name_3_0= RULE_START_TAG ) ) ( (lv_attributes_4_0= ruleAttribute ) )* this_GT_5= RULE_GT ( (lv_children_6_0= ruleWorkflowElement ) )* ( (lv_end_7_0= RULE_END_TAG ) ) ) )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000120L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000140L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000090L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000200L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000400L});
    }


}
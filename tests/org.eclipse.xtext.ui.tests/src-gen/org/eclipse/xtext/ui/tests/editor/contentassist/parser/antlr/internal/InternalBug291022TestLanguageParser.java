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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug291022TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug291022TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "':'", "';'", "'='"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalBug291022TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug291022TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug291022TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g"; }



     	private Bug291022TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug291022TestLanguageParser(TokenStream input, Bug291022TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootModel";	
       	}
       	
       	@Override
       	protected Bug291022TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRootModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:67:1: entryRuleRootModel returns [EObject current=null] : iv_ruleRootModel= ruleRootModel EOF ;
    public final EObject entryRuleRootModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:68:2: (iv_ruleRootModel= ruleRootModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:69:2: iv_ruleRootModel= ruleRootModel EOF
            {
             newCompositeNode(grammarAccess.getRootModelRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRootModel_in_entryRuleRootModel75);
            iv_ruleRootModel=ruleRootModel();

            state._fsp--;

             current =iv_ruleRootModel; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootModel85); 

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
    // $ANTLR end "entryRuleRootModel"


    // $ANTLR start "ruleRootModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:76:1: ruleRootModel returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? (otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}' )? )? ;
    public final EObject ruleRootModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:79:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? (otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}' )? )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:80:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? (otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}' )? )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:80:1: ( () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? (otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}' )? )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:80:2: () ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= RULE_ID ) )? (otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}' )?
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:80:2: ()
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:81:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getRootModelAccess().getRootModelAction_0(),
                                current);
                        

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:86:2: ( (lv_name_1_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:87:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:87:1: (lv_name_1_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:88:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRootModel136); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getRootModelAccess().getNameIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRootModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:104:2: ( (otherlv_2= RULE_ID ) )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==RULE_ID) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:105:1: (otherlv_2= RULE_ID )
                            {
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:105:1: (otherlv_2= RULE_ID )
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:106:3: otherlv_2= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRootModelRule());
                            	        }
                                    
                            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRootModel161); 

                            		newLeafNode(otherlv_2, grammarAccess.getRootModelAccess().getTypeModelElementCrossReference_2_0()); 
                            	

                            }


                            }
                            break;

                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:117:3: (otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==11) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:117:5: otherlv_3= '{' ( (lv_elements_4_0= ruleModelAttribute ) )* otherlv_5= '}'
                            {
                            otherlv_3=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRootModel175); 

                                	newLeafNode(otherlv_3, grammarAccess.getRootModelAccess().getLeftCurlyBracketKeyword_3_0());
                                
                            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:121:1: ( (lv_elements_4_0= ruleModelAttribute ) )*
                            loop2:
                            do {
                                int alt2=2;
                                int LA2_0 = input.LA(1);

                                if ( (LA2_0==RULE_ID) ) {
                                    alt2=1;
                                }


                                switch (alt2) {
                            	case 1 :
                            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:122:1: (lv_elements_4_0= ruleModelAttribute )
                            	    {
                            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:122:1: (lv_elements_4_0= ruleModelAttribute )
                            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:123:3: lv_elements_4_0= ruleModelAttribute
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getRootModelAccess().getElementsModelAttributeParserRuleCall_3_1_0()); 
                            	    	    
                            	    pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_ruleRootModel196);
                            	    lv_elements_4_0=ruleModelAttribute();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getRootModelRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"elements",
                            	            		lv_elements_4_0, 
                            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug291022TestLanguage.ModelAttribute");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop2;
                                }
                            } while (true);

                            otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRootModel209); 

                                	newLeafNode(otherlv_5, grammarAccess.getRootModelAccess().getRightCurlyBracketKeyword_3_2());
                                

                            }
                            break;

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
    // $ANTLR end "ruleRootModel"


    // $ANTLR start "entryRuleModelElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:151:1: entryRuleModelElement returns [EObject current=null] : iv_ruleModelElement= ruleModelElement EOF ;
    public final EObject entryRuleModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelElement = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:152:2: (iv_ruleModelElement= ruleModelElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:153:2: iv_ruleModelElement= ruleModelElement EOF
            {
             newCompositeNode(grammarAccess.getModelElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_entryRuleModelElement248);
            iv_ruleModelElement=ruleModelElement();

            state._fsp--;

             current =iv_ruleModelElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelElement258); 

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
    // $ANTLR end "entryRuleModelElement"


    // $ANTLR start "ruleModelElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:160:1: ruleModelElement returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) )? (otherlv_4= ';' | (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' ) ) ) ;
    public final EObject ruleModelElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_elements_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:163:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) )? (otherlv_4= ';' | (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:164:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) )? (otherlv_4= ';' | (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:164:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) )? (otherlv_4= ';' | (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:164:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )? ( (otherlv_3= RULE_ID ) )? (otherlv_4= ';' | (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:164:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:165:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:165:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:166:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModelElementRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement303); 

            		newLeafNode(otherlv_0, grammarAccess.getModelElementAccess().getFirstReferenceModelElementCrossReference_0_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:177:2: (otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:177:4: otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModelElement316); 

                        	newLeafNode(otherlv_1, grammarAccess.getModelElementAccess().getColonKeyword_1_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:181:1: ( (lv_name_2_0= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:182:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:182:1: (lv_name_2_0= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:183:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement333); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getModelElementAccess().getNameIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"org.eclipse.xtext.common.Terminals.ID");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:199:4: ( (otherlv_3= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:200:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:200:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:201:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModelElementRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModelElement360); 

                    		newLeafNode(otherlv_3, grammarAccess.getModelElementAccess().getSecondReferenceModelElementCrossReference_2_0()); 
                    	

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:212:3: (otherlv_4= ';' | (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            else if ( (LA8_0==11) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:212:5: otherlv_4= ';'
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModelElement374); 

                        	newLeafNode(otherlv_4, grammarAccess.getModelElementAccess().getSemicolonKeyword_3_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:217:6: (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:217:6: (otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:217:8: otherlv_5= '{' ( (lv_elements_6_0= ruleModelAttribute ) )* otherlv_7= '}'
                    {
                    otherlv_5=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModelElement393); 

                        	newLeafNode(otherlv_5, grammarAccess.getModelElementAccess().getLeftCurlyBracketKeyword_3_1_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:221:1: ( (lv_elements_6_0= ruleModelAttribute ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:222:1: (lv_elements_6_0= ruleModelAttribute )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:222:1: (lv_elements_6_0= ruleModelAttribute )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:223:3: lv_elements_6_0= ruleModelAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModelElementAccess().getElementsModelAttributeParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_ruleModelElement414);
                    	    lv_elements_6_0=ruleModelAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModelElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"elements",
                    	            		lv_elements_6_0, 
                    	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug291022TestLanguage.ModelAttribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModelElement427); 

                        	newLeafNode(otherlv_7, grammarAccess.getModelElementAccess().getRightCurlyBracketKeyword_3_1_2());
                        

                    }


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
    // $ANTLR end "ruleModelElement"


    // $ANTLR start "entryRuleModelAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:251:1: entryRuleModelAttribute returns [EObject current=null] : iv_ruleModelAttribute= ruleModelAttribute EOF ;
    public final EObject entryRuleModelAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModelAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:252:2: (iv_ruleModelAttribute= ruleModelAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:253:2: iv_ruleModelAttribute= ruleModelAttribute EOF
            {
             newCompositeNode(grammarAccess.getModelAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute465);
            iv_ruleModelAttribute=ruleModelAttribute();

            state._fsp--;

             current =iv_ruleModelAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelAttribute475); 

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
    // $ANTLR end "entryRuleModelAttribute"


    // $ANTLR start "ruleModelAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:260:1: ruleModelAttribute returns [EObject current=null] : (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute ) ;
    public final EObject ruleModelAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_ModelElement_0 = null;

        EObject this_Attribute_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:263:28: ( (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:264:1: (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:264:1: (this_ModelElement_0= ruleModelElement | this_Attribute_1= ruleAttribute )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==15) ) {
                    alt9=2;
                }
                else if ( (LA9_1==RULE_ID||LA9_1==11||(LA9_1>=13 && LA9_1<=14)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:265:5: this_ModelElement_0= ruleModelElement
                    {
                     
                            newCompositeNode(grammarAccess.getModelAttributeAccess().getModelElementParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModelElement_in_ruleModelAttribute522);
                    this_ModelElement_0=ruleModelElement();

                    state._fsp--;

                     
                            current = this_ModelElement_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:275:5: this_Attribute_1= ruleAttribute
                    {
                     
                            newCompositeNode(grammarAccess.getModelAttributeAccess().getAttributeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleModelAttribute549);
                    this_Attribute_1=ruleAttribute();

                    state._fsp--;

                     
                            current = this_Attribute_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleModelAttribute"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:291:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:292:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:293:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute584);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute594); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:300:1: ruleAttribute returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:303:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:304:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:304:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:304:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:304:2: ( (otherlv_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:305:1: (otherlv_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:305:1: (otherlv_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:306:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute639); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeAccess().getFeatureModelElementCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleAttribute651); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:321:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:322:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:322:1: (lv_value_2_0= RULE_STRING )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug291022TestLanguage.g:323:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute668); 

            			newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"org.eclipse.xtext.common.Terminals.STRING");
            	    

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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRootModel_in_entryRuleRootModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRootModel136 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRootModel161 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_11_in_ruleRootModel175 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_ruleRootModel196 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleRootModel209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_entryRuleModelElement248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelElement258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement303 = new BitSet(new long[]{0x0000000000006810L});
        public static final BitSet FOLLOW_13_in_ruleModelElement316 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement333 = new BitSet(new long[]{0x0000000000004810L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModelElement360 = new BitSet(new long[]{0x0000000000004800L});
        public static final BitSet FOLLOW_14_in_ruleModelElement374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModelElement393 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_ruleModelElement414 = new BitSet(new long[]{0x0000000000001010L});
        public static final BitSet FOLLOW_12_in_ruleModelElement427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelAttribute_in_entryRuleModelAttribute465 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelAttribute475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelElement_in_ruleModelAttribute522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleModelAttribute549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute584 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute639 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleAttribute651 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute668 = new BitSet(new long[]{0x0000000000000002L});
    }


}
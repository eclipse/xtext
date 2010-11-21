package org.eclipse.xtext.parser.terminalrules.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.terminalrules.services.Bug317840TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug317840TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'element'", "'.'"
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


        public InternalBug317840TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug317840TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug317840TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g"; }



     	private Bug317840TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug317840TestLanguageParser(TokenStream input, IAstFactory factory, Bug317840TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.semanticModelBuilder = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug317840TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:72:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:79:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:82:28: ( ( (lv_elements_0_0= ruleElement ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:83:1: ( (lv_elements_0_0= ruleElement ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:83:1: ( (lv_elements_0_0= ruleElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:84:1: (lv_elements_0_0= ruleElement )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:84:1: (lv_elements_0_0= ruleElement )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:85:3: lv_elements_0_0= ruleElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleModel130);
            	    lv_elements_0_0=ruleElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"Element");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:109:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:110:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:111:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement166);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement176); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:118:1: ruleElement returns [EObject current=null] : (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_first_1_0 = null;

        EObject lv_second_2_0 = null;

        EObject lv_third_3_0 = null;

        EObject lv_forth_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:121:28: ( (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:122:1: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:122:1: (otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:122:3: otherlv_0= 'element' ( (lv_first_1_0= ruleNamed ) ) ( (lv_second_2_0= ruleNamed ) )? ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleElement213); 

                	newLeafNode(otherlv_0, grammarAccess.getElementAccess().getElementKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:126:1: ( (lv_first_1_0= ruleNamed ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:127:1: (lv_first_1_0= ruleNamed )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:127:1: (lv_first_1_0= ruleNamed )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:128:3: lv_first_1_0= ruleNamed
            {
             
            	        newCompositeNode(grammarAccess.getElementAccess().getFirstNamedParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement234);
            lv_first_1_0=ruleNamed();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getElementRule());
            	        }
                   		set(
                   			current, 
                   			"first",
                    		lv_first_1_0, 
                    		"Named");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:144:2: ( (lv_second_2_0= ruleNamed ) )?
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:145:1: (lv_second_2_0= ruleNamed )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:145:1: (lv_second_2_0= ruleNamed )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:146:3: lv_second_2_0= ruleNamed
                    {
                     
                    	        newCompositeNode(grammarAccess.getElementAccess().getSecondNamedParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement255);
                    lv_second_2_0=ruleNamed();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	        }
                           		set(
                           			current, 
                           			"second",
                            		lv_second_2_0, 
                            		"Named");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:162:3: ( ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:162:4: ( (lv_third_3_0= ruleNamed ) ) ( (lv_forth_4_0= ruleNamed ) )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:162:4: ( (lv_third_3_0= ruleNamed ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:163:1: (lv_third_3_0= ruleNamed )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:163:1: (lv_third_3_0= ruleNamed )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:164:3: lv_third_3_0= ruleNamed
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getThirdNamedParserRuleCall_3_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement278);
            	    lv_third_3_0=ruleNamed();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"third",
            	            		lv_third_3_0, 
            	            		"Named");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:180:2: ( (lv_forth_4_0= ruleNamed ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:181:1: (lv_forth_4_0= ruleNamed )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:181:1: (lv_forth_4_0= ruleNamed )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:182:3: lv_forth_4_0= ruleNamed
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getElementAccess().getForthNamedParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleNamed_in_ruleElement299);
            	    lv_forth_4_0=ruleNamed();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getElementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"forth",
            	            		lv_forth_4_0, 
            	            		"Named");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleNamed"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:206:1: entryRuleNamed returns [EObject current=null] : iv_ruleNamed= ruleNamed EOF ;
    public final EObject entryRuleNamed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamed = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:207:2: (iv_ruleNamed= ruleNamed EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:208:2: iv_ruleNamed= ruleNamed EOF
            {
             newCompositeNode(grammarAccess.getNamedRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamed_in_entryRuleNamed337);
            iv_ruleNamed=ruleNamed();

            state._fsp--;

             current =iv_ruleNamed; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamed347); 

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
    // $ANTLR end "entryRuleNamed"


    // $ANTLR start "ruleNamed"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:215:1: ruleNamed returns [EObject current=null] : ( (lv_name_0_0= ruleNAME ) ) ;
    public final EObject ruleNamed() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:218:28: ( ( (lv_name_0_0= ruleNAME ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:219:1: ( (lv_name_0_0= ruleNAME ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:219:1: ( (lv_name_0_0= ruleNAME ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:220:1: (lv_name_0_0= ruleNAME )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:220:1: (lv_name_0_0= ruleNAME )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:221:3: lv_name_0_0= ruleNAME
            {
             
            	        newCompositeNode(grammarAccess.getNamedAccess().getNameNAMEParserRuleCall_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleNAME_in_ruleNamed392);
            lv_name_0_0=ruleNAME();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"NAME");
            	        afterParserOrEnumRuleCall();
            	    

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
    // $ANTLR end "ruleNamed"


    // $ANTLR start "entryRuleNAME"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:245:1: entryRuleNAME returns [String current=null] : iv_ruleNAME= ruleNAME EOF ;
    public final String entryRuleNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNAME = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:249:2: (iv_ruleNAME= ruleNAME EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:250:2: iv_ruleNAME= ruleNAME EOF
            {
             newCompositeNode(grammarAccess.getNAMERule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNAME_in_entryRuleNAME434);
            iv_ruleNAME=ruleNAME();

            state._fsp--;

             current =iv_ruleNAME.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNAME445); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNAME"


    // $ANTLR start "ruleNAME"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:260:1: ruleNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:264:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:265:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:265:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:265:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNAME489); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getNAMEAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:272:1: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parser/terminalrules/parser/antlr/internal/InternalBug317840TestLanguage.g:273:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleNAME508); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getNAMEAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNAME523); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getNAMEAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop4;
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

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNAME"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\14\uffff";
    static final String DFA2_eofS =
        "\1\2\1\5\2\uffff\1\2\1\uffff\1\5\1\uffff\1\5\1\2\1\uffff\1\5";
    static final String DFA2_minS =
        "\2\4\1\uffff\2\4\1\uffff\6\4";
    static final String DFA2_maxS =
        "\1\13\1\14\1\uffff\1\4\1\14\1\uffff\1\14\1\4\2\14\1\4\1\14";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\2\uffff\1\1\6\uffff";
    static final String DFA2_specialS =
        "\14\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1\6\uffff\1\2",
            "\1\4\6\uffff\1\5\1\3",
            "",
            "\1\6",
            "\1\10\6\uffff\1\2\1\7",
            "",
            "\1\4\6\uffff\1\5\1\3",
            "\1\11",
            "\1\4\6\uffff\1\5\1\12",
            "\1\10\6\uffff\1\2\1\7",
            "\1\13",
            "\1\4\6\uffff\1\5\1\12"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "144:2: ( (lv_second_2_0= ruleNamed ) )?";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleElement213 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement234 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement255 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement278 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleNamed_in_ruleElement299 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleNamed_in_entryRuleNamed337 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamed347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNAME_in_ruleNamed392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNAME_in_entryRuleNAME434 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNAME445 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNAME489 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleNAME508 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNAME523 = new BitSet(new long[]{0x0000000000001002L});
    }


}
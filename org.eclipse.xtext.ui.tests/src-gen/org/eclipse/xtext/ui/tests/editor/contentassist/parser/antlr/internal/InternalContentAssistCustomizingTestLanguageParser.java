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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ContentAssistCustomizingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalContentAssistCustomizingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'FQN'", "'extends'", "';'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalContentAssistCustomizingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalContentAssistCustomizingTestLanguage.g"; }



     	private ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalContentAssistCustomizingTestLanguageParser(TokenStream input, ContentAssistCustomizingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected ContentAssistCustomizingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalContentAssistCustomizingTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalContentAssistCustomizingTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalContentAssistCustomizingTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalContentAssistCustomizingTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_types_0_0= ruleType ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0_0 = null;


         enterRule(); 
            
        try {
            // InternalContentAssistCustomizingTestLanguage.g:79:28: ( ( (lv_types_0_0= ruleType ) )* )
            // InternalContentAssistCustomizingTestLanguage.g:80:1: ( (lv_types_0_0= ruleType ) )*
            {
            // InternalContentAssistCustomizingTestLanguage.g:80:1: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalContentAssistCustomizingTestLanguage.g:81:1: (lv_types_0_0= ruleType )
            	    {
            	    // InternalContentAssistCustomizingTestLanguage.g:81:1: (lv_types_0_0= ruleType )
            	    // InternalContentAssistCustomizingTestLanguage.g:82:3: lv_types_0_0= ruleType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_types_0_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"types",
            	            		lv_types_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistCustomizingTestLanguage.Type");
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


    // $ANTLR start "entryRuleType"
    // InternalContentAssistCustomizingTestLanguage.g:106:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalContentAssistCustomizingTestLanguage.g:107:2: (iv_ruleType= ruleType EOF )
            // InternalContentAssistCustomizingTestLanguage.g:108:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalContentAssistCustomizingTestLanguage.g:115:1: ruleType returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleFQN ) ) | ( (lv_name_1_0= 'FQN' ) ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_superType_3_0 = null;


         enterRule(); 
            
        try {
            // InternalContentAssistCustomizingTestLanguage.g:118:28: ( ( ( ( (lv_name_0_0= ruleFQN ) ) | ( (lv_name_1_0= 'FQN' ) ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) ) )? otherlv_4= ';' ) )
            // InternalContentAssistCustomizingTestLanguage.g:119:1: ( ( ( (lv_name_0_0= ruleFQN ) ) | ( (lv_name_1_0= 'FQN' ) ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) ) )? otherlv_4= ';' )
            {
            // InternalContentAssistCustomizingTestLanguage.g:119:1: ( ( ( (lv_name_0_0= ruleFQN ) ) | ( (lv_name_1_0= 'FQN' ) ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) ) )? otherlv_4= ';' )
            // InternalContentAssistCustomizingTestLanguage.g:119:2: ( ( (lv_name_0_0= ruleFQN ) ) | ( (lv_name_1_0= 'FQN' ) ) ) (otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) ) )? otherlv_4= ';'
            {
            // InternalContentAssistCustomizingTestLanguage.g:119:2: ( ( (lv_name_0_0= ruleFQN ) ) | ( (lv_name_1_0= 'FQN' ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==11) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalContentAssistCustomizingTestLanguage.g:119:3: ( (lv_name_0_0= ruleFQN ) )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:119:3: ( (lv_name_0_0= ruleFQN ) )
                    // InternalContentAssistCustomizingTestLanguage.g:120:1: (lv_name_0_0= ruleFQN )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:120:1: (lv_name_0_0= ruleFQN )
                    // InternalContentAssistCustomizingTestLanguage.g:121:3: lv_name_0_0= ruleFQN
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeAccess().getNameFQNParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_4);
                    lv_name_0_0=ruleFQN();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistCustomizingTestLanguage.FQN");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalContentAssistCustomizingTestLanguage.g:138:6: ( (lv_name_1_0= 'FQN' ) )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:138:6: ( (lv_name_1_0= 'FQN' ) )
                    // InternalContentAssistCustomizingTestLanguage.g:139:1: (lv_name_1_0= 'FQN' )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:139:1: (lv_name_1_0= 'FQN' )
                    // InternalContentAssistCustomizingTestLanguage.g:140:3: lv_name_1_0= 'FQN'
                    {
                    lv_name_1_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                            newLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameFQNKeyword_0_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_0, "FQN");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalContentAssistCustomizingTestLanguage.g:153:3: (otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalContentAssistCustomizingTestLanguage.g:153:5: otherlv_2= 'extends' ( (lv_superType_3_0= ruleTypeRef ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                        	newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_1_0());
                        
                    // InternalContentAssistCustomizingTestLanguage.g:157:1: ( (lv_superType_3_0= ruleTypeRef ) )
                    // InternalContentAssistCustomizingTestLanguage.g:158:1: (lv_superType_3_0= ruleTypeRef )
                    {
                    // InternalContentAssistCustomizingTestLanguage.g:158:1: (lv_superType_3_0= ruleTypeRef )
                    // InternalContentAssistCustomizingTestLanguage.g:159:3: lv_superType_3_0= ruleTypeRef
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeAccess().getSuperTypeTypeRefParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_superType_3_0=ruleTypeRef();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"superType",
                            		lv_superType_3_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistCustomizingTestLanguage.TypeRef");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getTypeAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTypeRef"
    // InternalContentAssistCustomizingTestLanguage.g:187:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalContentAssistCustomizingTestLanguage.g:188:2: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalContentAssistCustomizingTestLanguage.g:189:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
             newCompositeNode(grammarAccess.getTypeRefRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;

             current =iv_ruleTypeRef; 
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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalContentAssistCustomizingTestLanguage.g:196:1: ruleTypeRef returns [EObject current=null] : ( ( ruleFQN ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalContentAssistCustomizingTestLanguage.g:199:28: ( ( ( ruleFQN ) ) )
            // InternalContentAssistCustomizingTestLanguage.g:200:1: ( ( ruleFQN ) )
            {
            // InternalContentAssistCustomizingTestLanguage.g:200:1: ( ( ruleFQN ) )
            // InternalContentAssistCustomizingTestLanguage.g:201:1: ( ruleFQN )
            {
            // InternalContentAssistCustomizingTestLanguage.g:201:1: ( ruleFQN )
            // InternalContentAssistCustomizingTestLanguage.g:202:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRefRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTypeRefAccess().getTypeTypeCrossReference_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            ruleFQN();

            state._fsp--;

             
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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRuleFQN"
    // InternalContentAssistCustomizingTestLanguage.g:223:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // InternalContentAssistCustomizingTestLanguage.g:224:2: (iv_ruleFQN= ruleFQN EOF )
            // InternalContentAssistCustomizingTestLanguage.g:225:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // InternalContentAssistCustomizingTestLanguage.g:232:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalContentAssistCustomizingTestLanguage.g:235:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalContentAssistCustomizingTestLanguage.g:236:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalContentAssistCustomizingTestLanguage.g:236:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalContentAssistCustomizingTestLanguage.g:236:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // InternalContentAssistCustomizingTestLanguage.g:243:1: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalContentAssistCustomizingTestLanguage.g:244:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,14,FollowSets000.FOLLOW_5); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

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
        }
        return current;
    }
    // $ANTLR end "ruleFQN"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    }


}
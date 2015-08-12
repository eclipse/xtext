package org.eclipse.xtext.linking.lazy.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLazyLinkingTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'extends'", "'.'", "'for'", "'in'", "'{'", "'}'", "';'", "'unresolved'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalLazyLinkingTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLazyLinkingTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLazyLinkingTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g"; }



     	private LazyLinkingTestLanguageGrammarAccess grammarAccess;
     	
        public InternalLazyLinkingTestLanguageParser(TokenStream input, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected LazyLinkingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:76:1: ruleModel returns [EObject current=null] : ( (lv_types_0_0= ruleType ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:79:28: ( ( (lv_types_0_0= ruleType ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:80:1: ( (lv_types_0_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:80:1: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:81:1: (lv_types_0_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:81:1: (lv_types_0_0= ruleType )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:82:3: lv_types_0_0= ruleType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleModel130);
            	    lv_types_0_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"types",
            	            		lv_types_0_0, 
            	            		"org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage.Type");
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:106:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:107:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:108:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType166);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType176); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:115:1: ruleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        EObject lv_properties_11_0 = null;

        EObject lv_unresolvedProxyProperty_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:118:28: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:119:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:119:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:119:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleType213); 

                	newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:123:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:124:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:124:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:125:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType230); 

            			newLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:141:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:141:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleType248); 

                        	newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:145:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:146:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:146:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:147:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType268); 

                    		newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0()); 
                    	

                    }


                    }

                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleType280); 

                        	newLeafNode(otherlv_4, grammarAccess.getTypeAccess().getFullStopKeyword_2_2());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:162:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:163:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:163:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:164:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType300); 

                    		newLeafNode(otherlv_5, grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:175:4: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:175:6: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleType315); 

                        	newLeafNode(otherlv_6, grammarAccess.getTypeAccess().getForKeyword_3_0());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:179:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:180:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:180:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:181:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType335); 

                    		newLeafNode(otherlv_7, grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0()); 
                    	

                    }


                    }

                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleType347); 

                        	newLeafNode(otherlv_8, grammarAccess.getTypeAccess().getInKeyword_3_2());
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:196:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:197:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:197:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:198:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getTypeRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType367); 

                    		newLeafNode(otherlv_9, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleType381); 

                	newLeafNode(otherlv_10, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:213:1: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:214:1: (lv_properties_11_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:214:1: (lv_properties_11_0= ruleProperty )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:215:3: lv_properties_11_0= ruleProperty
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleProperty_in_ruleType402);
            	    lv_properties_11_0=ruleProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"properties",
            	            		lv_properties_11_0, 
            	            		"org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage.Property");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:231:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:232:1: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:232:1: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:233:3: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_ruleType424);
            	    lv_unresolvedProxyProperty_12_0=ruleUnresolvedProxyProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"unresolvedProxyProperty",
            	            		lv_unresolvedProxyProperty_12_0, 
            	            		"org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage.UnresolvedProxyProperty");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleType437); 

                	newLeafNode(otherlv_13, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_7());
                

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


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:261:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:262:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:263:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProperty_in_entryRuleProperty473);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProperty483); 

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
    // $ANTLR end "entryRuleProperty"


    // $ANTLR start "ruleProperty"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:270:1: ruleProperty returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:273:28: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:274:1: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:274:1: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:274:2: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:274:2: ( (otherlv_0= RULE_ID ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==RULE_ID) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:275:1: (otherlv_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:275:1: (otherlv_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:276:3: otherlv_0= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getPropertyRule());
            	    	        }
            	            
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty528); 

            	    		newLeafNode(otherlv_0, grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:287:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:288:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:288:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:289:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty546); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProperty563); 

                	newLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleUnresolvedProxyProperty"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:317:1: entryRuleUnresolvedProxyProperty returns [EObject current=null] : iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF ;
    public final EObject entryRuleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnresolvedProxyProperty = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:318:2: (iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:319:2: iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF
            {
             newCompositeNode(grammarAccess.getUnresolvedProxyPropertyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty599);
            iv_ruleUnresolvedProxyProperty=ruleUnresolvedProxyProperty();

            state._fsp--;

             current =iv_ruleUnresolvedProxyProperty; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty609); 

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
    // $ANTLR end "entryRuleUnresolvedProxyProperty"


    // $ANTLR start "ruleUnresolvedProxyProperty"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:326:1: ruleUnresolvedProxyProperty returns [EObject current=null] : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:329:28: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:330:1: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:330:1: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:330:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnresolvedProxyProperty646); 

                	newLeafNode(otherlv_0, grammarAccess.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0());
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:334:1: ( (otherlv_1= RULE_ID ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==RULE_ID) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:335:1: (otherlv_1= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:335:1: (otherlv_1= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:336:3: otherlv_1= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUnresolvedProxyPropertyRule());
            	    	        }
            	            
            	    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty666); 

            	    		newLeafNode(otherlv_1, grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:347:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:348:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:348:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:349:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty684); 

            			newLeafNode(lv_name_2_0, grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUnresolvedProxyPropertyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnresolvedProxyProperty701); 

                	newLeafNode(otherlv_3, grammarAccess.getUnresolvedProxyPropertyAccess().getSemicolonKeyword_3());
                

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
    // $ANTLR end "ruleUnresolvedProxyProperty"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleType213 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType230 = new BitSet(new long[]{0x0000000000015000L});
        public static final BitSet FOLLOW_12_in_ruleType248 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType268 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleType280 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType300 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_14_in_ruleType315 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType335 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleType347 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType367 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleType381 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_ruleProperty_in_ruleType402 = new BitSet(new long[]{0x00000000000A0010L});
        public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_ruleType424 = new BitSet(new long[]{0x00000000000A0000L});
        public static final BitSet FOLLOW_17_in_ruleType437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty473 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProperty483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProperty528 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProperty546 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleProperty563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnresolvedProxyProperty_in_entryRuleUnresolvedProxyProperty599 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnresolvedProxyProperty609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleUnresolvedProxyProperty646 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty684 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleUnresolvedProxyProperty701 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.linking.lazy.parser.antlr.internal; 

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
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=4;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

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
     	
        public InternalLazyLinkingTestLanguageParser(TokenStream input, IAstFactory factory, LazyLinkingTestLanguageGrammarAccess grammarAccess) {
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
       	protected LazyLinkingTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:80:1: ruleModel returns [EObject current=null] : ( (lv_types_0_0= ruleType ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_types_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:85:6: ( ( (lv_types_0_0= ruleType ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:1: ( (lv_types_0_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:86:1: ( (lv_types_0_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:87:1: (lv_types_0_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:87:1: (lv_types_0_0= ruleType )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:88:3: lv_types_0_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleModel130);
            	    lv_types_0_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"types",
            	    	        		lv_types_0_0, 
            	    	        		"Type", 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:118:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:119:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:120:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:127:1: ruleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) ;
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


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:132:6: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:133:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:133:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:133:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= '{' ( (lv_properties_11_0= ruleProperty ) )* ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )* otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleType213); 

                	createLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:137:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:138:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:138:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:139:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType230); 

            			createLeafNode(lv_name_1_0, grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:161:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:161:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) otherlv_4= '.' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleType248); 

                        	createLeafNode(otherlv_2, grammarAccess.getTypeAccess().getExtendsKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:165:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:166:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:166:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:167:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType268); 

                    		createLeafNode(otherlv_3, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0(), "extends"); 
                    	

                    }


                    }

                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleType280); 

                        	createLeafNode(otherlv_4, grammarAccess.getTypeAccess().getFullStopKeyword_2_2(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:183:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:184:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:184:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:185:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType300); 

                    		createLeafNode(otherlv_5, grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0(), "parentId"); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:197:4: (otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:197:6: otherlv_6= 'for' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'in' ( (otherlv_9= RULE_ID ) )
                    {
                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleType315); 

                        	createLeafNode(otherlv_6, grammarAccess.getTypeAccess().getForKeyword_3_0(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:201:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:202:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:202:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:203:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType335); 

                    		createLeafNode(otherlv_7, grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0(), "parentId"); 
                    	

                    }


                    }

                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleType347); 

                        	createLeafNode(otherlv_8, grammarAccess.getTypeAccess().getInKeyword_3_2(), null);
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:219:1: ( (otherlv_9= RULE_ID ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:220:1: (otherlv_9= RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:220:1: (otherlv_9= RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:221:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType367); 

                    		createLeafNode(otherlv_9, grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0(), "extends"); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleType381); 

                	createLeafNode(otherlv_10, grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:237:1: ( (lv_properties_11_0= ruleProperty ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:238:1: (lv_properties_11_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:238:1: (lv_properties_11_0= ruleProperty )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:239:3: lv_properties_11_0= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleProperty_in_ruleType402);
            	    lv_properties_11_0=ruleProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"properties",
            	    	        		lv_properties_11_0, 
            	    	        		"Property", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:261:3: ( (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:262:1: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:262:1: (lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:263:3: lv_unresolvedProxyProperty_12_0= ruleUnresolvedProxyProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleUnresolvedProxyProperty_in_ruleType424);
            	    lv_unresolvedProxyProperty_12_0=ruleUnresolvedProxyProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypeRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"unresolvedProxyProperty",
            	    	        		lv_unresolvedProxyProperty_12_0, 
            	    	        		"UnresolvedProxyProperty", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleType437); 

                	createLeafNode(otherlv_13, grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_7(), null);
                

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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:297:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:298:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:299:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:306:1: ruleProperty returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:311:6: ( ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:312:1: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:312:1: ( ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:312:2: ( (otherlv_0= RULE_ID ) )+ ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:312:2: ( (otherlv_0= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:313:1: (otherlv_0= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:313:1: (otherlv_0= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:314:3: otherlv_0= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty528); 

            	    		createLeafNode(otherlv_0, grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(), "type"); 
            	    	

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:326:3: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:327:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:327:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:328:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProperty546); 

            			createLeafNode(lv_name_1_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyRule().getType().getClassifier());
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

            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProperty563); 

                	createLeafNode(otherlv_2, grammarAccess.getPropertyAccess().getSemicolonKeyword_2(), null);
                

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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleUnresolvedProxyProperty"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:362:1: entryRuleUnresolvedProxyProperty returns [EObject current=null] : iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF ;
    public final EObject entryRuleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnresolvedProxyProperty = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:363:2: (iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:364:2: iv_ruleUnresolvedProxyProperty= ruleUnresolvedProxyProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getUnresolvedProxyPropertyRule(), currentNode); 
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:371:1: ruleUnresolvedProxyProperty returns [EObject current=null] : (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleUnresolvedProxyProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:376:6: ( (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:377:1: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:377:1: (otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:377:3: otherlv_0= 'unresolved' ( (otherlv_1= RULE_ID ) )+ ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleUnresolvedProxyProperty646); 

                	createLeafNode(otherlv_0, grammarAccess.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:381:1: ( (otherlv_1= RULE_ID ) )+
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
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:382:1: (otherlv_1= RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:382:1: (otherlv_1= RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:383:3: otherlv_1= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty666); 

            	    		createLeafNode(otherlv_1, grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0(), "type"); 
            	    	

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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:395:3: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:396:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:396:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalLazyLinkingTestLanguage.g:397:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUnresolvedProxyProperty684); 

            			createLeafNode(lv_name_2_0, grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUnresolvedProxyProperty701); 

                	createLeafNode(otherlv_3, grammarAccess.getUnresolvedProxyPropertyAccess().getSemicolonKeyword_3(), null);
                

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
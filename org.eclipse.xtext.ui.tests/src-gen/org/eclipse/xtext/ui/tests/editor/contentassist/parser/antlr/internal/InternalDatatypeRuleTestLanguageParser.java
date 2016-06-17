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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDatatypeRuleTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Types'", "'Type'", "';'", "'Composite'", "'base'", "'<'", "','", "'>'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
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


        public InternalDatatypeRuleTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDatatypeRuleTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDatatypeRuleTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDatatypeRuleTestLanguage.g"; }



     	private DatatypeRuleTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDatatypeRuleTestLanguageParser(TokenStream input, DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected DatatypeRuleTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // InternalDatatypeRuleTestLanguage.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalDatatypeRuleTestLanguage.g:69:2: iv_ruleModel= ruleModel EOF
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
    // InternalDatatypeRuleTestLanguage.g:76:1: ruleModel returns [EObject current=null] : this_Types_0= ruleTypes ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Types_0 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:79:28: (this_Types_0= ruleTypes )
            // InternalDatatypeRuleTestLanguage.g:81:5: this_Types_0= ruleTypes
            {
             
                    newCompositeNode(grammarAccess.getModelAccess().getTypesParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_2);
            this_Types_0=ruleTypes();

            state._fsp--;

             
                    current = this_Types_0; 
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


    // $ANTLR start "entryRuleTypes"
    // InternalDatatypeRuleTestLanguage.g:97:1: entryRuleTypes returns [EObject current=null] : iv_ruleTypes= ruleTypes EOF ;
    public final EObject entryRuleTypes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypes = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:98:2: (iv_ruleTypes= ruleTypes EOF )
            // InternalDatatypeRuleTestLanguage.g:99:2: iv_ruleTypes= ruleTypes EOF
            {
             newCompositeNode(grammarAccess.getTypesRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypes=ruleTypes();

            state._fsp--;

             current =iv_ruleTypes; 
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
    // $ANTLR end "entryRuleTypes"


    // $ANTLR start "ruleTypes"
    // InternalDatatypeRuleTestLanguage.g:106:1: ruleTypes returns [EObject current=null] : ( () otherlv_1= 'Types' ( (lv_types_2_0= ruleType ) )* ) ;
    public final EObject ruleTypes() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_types_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:109:28: ( ( () otherlv_1= 'Types' ( (lv_types_2_0= ruleType ) )* ) )
            // InternalDatatypeRuleTestLanguage.g:110:1: ( () otherlv_1= 'Types' ( (lv_types_2_0= ruleType ) )* )
            {
            // InternalDatatypeRuleTestLanguage.g:110:1: ( () otherlv_1= 'Types' ( (lv_types_2_0= ruleType ) )* )
            // InternalDatatypeRuleTestLanguage.g:110:2: () otherlv_1= 'Types' ( (lv_types_2_0= ruleType ) )*
            {
            // InternalDatatypeRuleTestLanguage.g:110:2: ()
            // InternalDatatypeRuleTestLanguage.g:111:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTypesAccess().getTypesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getTypesAccess().getTypesKeyword_1());
                
            // InternalDatatypeRuleTestLanguage.g:120:1: ( (lv_types_2_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDatatypeRuleTestLanguage.g:121:1: (lv_types_2_0= ruleType )
            	    {
            	    // InternalDatatypeRuleTestLanguage.g:121:1: (lv_types_2_0= ruleType )
            	    // InternalDatatypeRuleTestLanguage.g:122:3: lv_types_2_0= ruleType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_types_2_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTypesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"types",
            	            		lv_types_2_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.DatatypeRuleTestLanguage.Type");
            	    	        afterParserOrEnumRuleCall();
            	    	    

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
    // $ANTLR end "ruleTypes"


    // $ANTLR start "entryRuleType"
    // InternalDatatypeRuleTestLanguage.g:146:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:147:2: (iv_ruleType= ruleType EOF )
            // InternalDatatypeRuleTestLanguage.g:148:2: iv_ruleType= ruleType EOF
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
    // InternalDatatypeRuleTestLanguage.g:155:1: ruleType returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_CompositeType_1 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:158:28: ( (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType ) )
            // InternalDatatypeRuleTestLanguage.g:159:1: (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType )
            {
            // InternalDatatypeRuleTestLanguage.g:159:1: (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalDatatypeRuleTestLanguage.g:160:5: this_SimpleType_0= ruleSimpleType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_SimpleType_0=ruleSimpleType();

                    state._fsp--;

                     
                            current = this_SimpleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDatatypeRuleTestLanguage.g:170:5: this_CompositeType_1= ruleCompositeType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_CompositeType_1=ruleCompositeType();

                    state._fsp--;

                     
                            current = this_CompositeType_1; 
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleSimpleType"
    // InternalDatatypeRuleTestLanguage.g:186:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:187:2: (iv_ruleSimpleType= ruleSimpleType EOF )
            // InternalDatatypeRuleTestLanguage.g:188:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             newCompositeNode(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSimpleType=ruleSimpleType();

            state._fsp--;

             current =iv_ruleSimpleType; 
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
    // $ANTLR end "entryRuleSimpleType"


    // $ANTLR start "ruleSimpleType"
    // InternalDatatypeRuleTestLanguage.g:195:1: ruleSimpleType returns [EObject current=null] : (otherlv_0= 'Type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:198:28: ( (otherlv_0= 'Type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalDatatypeRuleTestLanguage.g:199:1: (otherlv_0= 'Type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:199:1: (otherlv_0= 'Type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalDatatypeRuleTestLanguage.g:199:3: otherlv_0= 'Type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleTypeAccess().getTypeKeyword_0());
                
            // InternalDatatypeRuleTestLanguage.g:203:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:204:1: (lv_name_1_0= RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:204:1: (lv_name_1_0= RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:205:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleCompositeType"
    // InternalDatatypeRuleTestLanguage.g:233:1: entryRuleCompositeType returns [EObject current=null] : iv_ruleCompositeType= ruleCompositeType EOF ;
    public final EObject entryRuleCompositeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeType = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:234:2: (iv_ruleCompositeType= ruleCompositeType EOF )
            // InternalDatatypeRuleTestLanguage.g:235:2: iv_ruleCompositeType= ruleCompositeType EOF
            {
             newCompositeNode(grammarAccess.getCompositeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCompositeType=ruleCompositeType();

            state._fsp--;

             current =iv_ruleCompositeType; 
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
    // $ANTLR end "entryRuleCompositeType"


    // $ANTLR start "ruleCompositeType"
    // InternalDatatypeRuleTestLanguage.g:242:1: ruleCompositeType returns [EObject current=null] : (otherlv_0= 'Composite' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) otherlv_4= ';' ) ;
    public final EObject ruleCompositeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_baseType_3_0 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:245:28: ( (otherlv_0= 'Composite' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) otherlv_4= ';' ) )
            // InternalDatatypeRuleTestLanguage.g:246:1: (otherlv_0= 'Composite' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) otherlv_4= ';' )
            {
            // InternalDatatypeRuleTestLanguage.g:246:1: (otherlv_0= 'Composite' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) otherlv_4= ';' )
            // InternalDatatypeRuleTestLanguage.g:246:3: otherlv_0= 'Composite' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_0, grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0());
                
            // InternalDatatypeRuleTestLanguage.g:250:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalDatatypeRuleTestLanguage.g:251:1: (lv_name_1_0= RULE_ID )
            {
            // InternalDatatypeRuleTestLanguage.g:251:1: (lv_name_1_0= RULE_ID )
            // InternalDatatypeRuleTestLanguage.g:252:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCompositeTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FollowSets000.FOLLOW_4); 

                	newLeafNode(otherlv_2, grammarAccess.getCompositeTypeAccess().getBaseKeyword_2());
                
            // InternalDatatypeRuleTestLanguage.g:272:1: ( (lv_baseType_3_0= ruleCompositeTypeEntry ) )
            // InternalDatatypeRuleTestLanguage.g:273:1: (lv_baseType_3_0= ruleCompositeTypeEntry )
            {
            // InternalDatatypeRuleTestLanguage.g:273:1: (lv_baseType_3_0= ruleCompositeTypeEntry )
            // InternalDatatypeRuleTestLanguage.g:274:3: lv_baseType_3_0= ruleCompositeTypeEntry
            {
             
            	        newCompositeNode(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_5);
            lv_baseType_3_0=ruleCompositeTypeEntry();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompositeTypeRule());
            	        }
                   		set(
                   			current, 
                   			"baseType",
                    		lv_baseType_3_0, 
                    		"org.eclipse.xtext.ui.tests.editor.contentassist.DatatypeRuleTestLanguage.CompositeTypeEntry");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_4, grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4());
                

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
    // $ANTLR end "ruleCompositeType"


    // $ANTLR start "entryRuleCompositeTypeEntry"
    // InternalDatatypeRuleTestLanguage.g:302:1: entryRuleCompositeTypeEntry returns [EObject current=null] : iv_ruleCompositeTypeEntry= ruleCompositeTypeEntry EOF ;
    public final EObject entryRuleCompositeTypeEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeTypeEntry = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:303:2: (iv_ruleCompositeTypeEntry= ruleCompositeTypeEntry EOF )
            // InternalDatatypeRuleTestLanguage.g:304:2: iv_ruleCompositeTypeEntry= ruleCompositeTypeEntry EOF
            {
             newCompositeNode(grammarAccess.getCompositeTypeEntryRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCompositeTypeEntry=ruleCompositeTypeEntry();

            state._fsp--;

             current =iv_ruleCompositeTypeEntry; 
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
    // $ANTLR end "entryRuleCompositeTypeEntry"


    // $ANTLR start "ruleCompositeTypeEntry"
    // InternalDatatypeRuleTestLanguage.g:311:1: ruleCompositeTypeEntry returns [EObject current=null] : ( ( ruleTypeId ) ) ;
    public final EObject ruleCompositeTypeEntry() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:314:28: ( ( ( ruleTypeId ) ) )
            // InternalDatatypeRuleTestLanguage.g:315:1: ( ( ruleTypeId ) )
            {
            // InternalDatatypeRuleTestLanguage.g:315:1: ( ( ruleTypeId ) )
            // InternalDatatypeRuleTestLanguage.g:316:1: ( ruleTypeId )
            {
            // InternalDatatypeRuleTestLanguage.g:316:1: ( ruleTypeId )
            // InternalDatatypeRuleTestLanguage.g:317:3: ruleTypeId
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCompositeTypeEntryRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_2);
            ruleTypeId();

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
    // $ANTLR end "ruleCompositeTypeEntry"


    // $ANTLR start "entryRuleTypeId"
    // InternalDatatypeRuleTestLanguage.g:338:1: entryRuleTypeId returns [String current=null] : iv_ruleTypeId= ruleTypeId EOF ;
    public final String entryRuleTypeId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTypeId = null;


        try {
            // InternalDatatypeRuleTestLanguage.g:339:2: (iv_ruleTypeId= ruleTypeId EOF )
            // InternalDatatypeRuleTestLanguage.g:340:2: iv_ruleTypeId= ruleTypeId EOF
            {
             newCompositeNode(grammarAccess.getTypeIdRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTypeId=ruleTypeId();

            state._fsp--;

             current =iv_ruleTypeId.getText(); 
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
    // $ANTLR end "entryRuleTypeId"


    // $ANTLR start "ruleTypeId"
    // InternalDatatypeRuleTestLanguage.g:347:1: ruleTypeId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? ) ;
    public final AntlrDatatypeRuleToken ruleTypeId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_TypeId_2 = null;

        AntlrDatatypeRuleToken this_TypeId_4 = null;


         enterRule(); 
            
        try {
            // InternalDatatypeRuleTestLanguage.g:350:28: ( (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? ) )
            // InternalDatatypeRuleTestLanguage.g:351:1: (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? )
            {
            // InternalDatatypeRuleTestLanguage.g:351:1: (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? )
            // InternalDatatypeRuleTestLanguage.g:351:6: this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0()); 
                
            // InternalDatatypeRuleTestLanguage.g:358:1: (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDatatypeRuleTestLanguage.g:359:2: kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_4); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_8);
                    this_TypeId_2=ruleTypeId();

                    state._fsp--;


                    		current.merge(this_TypeId_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDatatypeRuleTestLanguage.g:375:1: (kw= ',' this_TypeId_4= ruleTypeId )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalDatatypeRuleTestLanguage.g:376:2: kw= ',' this_TypeId_4= ruleTypeId
                    	    {
                    	    kw=(Token)match(input,17,FollowSets000.FOLLOW_4); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0()); 
                    	        
                    	     
                    	            newCompositeNode(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1()); 
                    	        
                    	    pushFollow(FollowSets000.FOLLOW_8);
                    	    this_TypeId_4=ruleTypeId();

                    	    state._fsp--;


                    	    		current.merge(this_TypeId_4);
                    	        
                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    kw=(Token)match(input,18,FollowSets000.FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3()); 
                        

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
    // $ANTLR end "ruleTypeId"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000005002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000060000L});
    }


}
package org.eclipse.xtext.example.gmf.parser.antlr.internal; 

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
import org.eclipse.xtext.example.gmf.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEntitiesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'extends'", "'{'", "'}'", "'property'", "':'", "'[]'", "'reference'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=5;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=4;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalEntitiesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEntitiesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEntitiesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g"; }



     	private EntitiesGrammarAccess grammarAccess;
     	
        public InternalEntitiesParser(TokenStream input, IAstFactory factory, EntitiesGrammarAccess grammarAccess) {
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
       	protected EntitiesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:70:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:71:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:72:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:79:1: ruleModel returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_elements_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:82:28: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:83:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:83:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:83:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:83:2: ()
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:84:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:89:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:90:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:90:1: (lv_imports_1_0= ruleImport )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:91:3: lv_imports_1_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel140);
            	    lv_imports_1_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_1_0, 
            	            		"Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:107:3: ( (lv_elements_2_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:108:1: (lv_elements_2_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:108:1: (lv_elements_2_0= ruleType )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:109:3: lv_elements_2_0= ruleType
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleModel162);
            	    lv_elements_2_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_2_0, 
            	            		"Type");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:133:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:134:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:135:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport199);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport209); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:142:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:145:28: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:146:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:146:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:146:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport246); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:150:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:151:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:151:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:152:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport263); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"STRING");
            	    

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:176:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:177:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:178:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType304);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType314); 

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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:185:1: ruleType returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_Entity_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:188:28: ( (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:189:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:189:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:190:5: this_SimpleType_0= ruleSimpleType
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleType_in_ruleType361);
                    this_SimpleType_0=ruleSimpleType();

                    state._fsp--;

                     
                            current = this_SimpleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:200:5: this_Entity_1= ruleEntity
                    {
                     
                            newCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType388);
                    this_Entity_1=ruleEntity();

                    state._fsp--;

                     
                            current = this_Entity_1; 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:216:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:217:2: (iv_ruleSimpleType= ruleSimpleType EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:218:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             newCompositeNode(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType423);
            iv_ruleSimpleType=ruleSimpleType();

            state._fsp--;

             current =iv_ruleSimpleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType433); 

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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:225:1: ruleSimpleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:228:28: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:229:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:229:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:229:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleSimpleType470); 

                	newLeafNode(otherlv_0, grammarAccess.getSimpleTypeAccess().getTypeKeyword_0());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:233:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:234:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:234:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:235:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleType487); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimpleTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:259:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:260:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:261:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity528);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity538); 

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
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:268:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_properties_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:271:28: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:272:1: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:272:1: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:272:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleEntity575); 

                	newLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:276:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:277:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:277:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:278:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity592); 

            			newLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEntityRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:294:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:294:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleEntity610); 

                        	newLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0());
                        
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:298:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:299:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:299:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:300:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEntityRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity630); 

                    		newLeafNode(otherlv_3, grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEntity644); 

                	newLeafNode(otherlv_4, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:315:1: ( (lv_properties_5_0= ruleProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:316:1: (lv_properties_5_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:316:1: (lv_properties_5_0= ruleProperty )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:317:3: lv_properties_5_0= ruleProperty
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity665);
            	    lv_properties_5_0=ruleProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getEntityRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"properties",
            	            		lv_properties_5_0, 
            	            		"Property");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleEntity678); 

                	newLeafNode(otherlv_6, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:345:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:346:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:347:2: iv_ruleProperty= ruleProperty EOF
            {
             newCompositeNode(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty714);
            iv_ruleProperty=ruleProperty();

            state._fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty724); 

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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:354:1: ruleProperty returns [EObject current=null] : (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleProperty_0 = null;

        EObject this_Reference_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:357:28: ( (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:358:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:358:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==20) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:359:5: this_SimpleProperty_0= ruleSimpleProperty
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSimpleProperty_in_ruleProperty771);
                    this_SimpleProperty_0=ruleSimpleProperty();

                    state._fsp--;

                     
                            current = this_SimpleProperty_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:369:5: this_Reference_1= ruleReference
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleProperty798);
                    this_Reference_1=ruleReference();

                    state._fsp--;

                     
                            current = this_Reference_1; 
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
    // $ANTLR end "ruleProperty"


    // $ANTLR start "entryRuleSimpleProperty"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:385:1: entryRuleSimpleProperty returns [EObject current=null] : iv_ruleSimpleProperty= ruleSimpleProperty EOF ;
    public final EObject entryRuleSimpleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleProperty = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:386:2: (iv_ruleSimpleProperty= ruleSimpleProperty EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:387:2: iv_ruleSimpleProperty= ruleSimpleProperty EOF
            {
             newCompositeNode(grammarAccess.getSimplePropertyRule()); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty833);
            iv_ruleSimpleProperty=ruleSimpleProperty();

            state._fsp--;

             current =iv_ruleSimpleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty843); 

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
    // $ANTLR end "entryRuleSimpleProperty"


    // $ANTLR start "ruleSimpleProperty"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:394:1: ruleSimpleProperty returns [EObject current=null] : (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) ;
    public final EObject ruleSimpleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_many_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:397:28: ( (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:398:1: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:398:1: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:398:3: otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSimpleProperty880); 

                	newLeafNode(otherlv_0, grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:402:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:403:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:403:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:404:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty897); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimplePropertyRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:420:2: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:420:4: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleSimpleProperty915); 

                        	newLeafNode(otherlv_2, grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0());
                        
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:424:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:425:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:425:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:426:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSimplePropertyRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty935); 

                    		newLeafNode(otherlv_3, grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:437:2: ( (lv_many_4_0= '[]' ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==19) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:438:1: (lv_many_4_0= '[]' )
                            {
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:438:1: (lv_many_4_0= '[]' )
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:439:3: lv_many_4_0= '[]'
                            {
                            lv_many_4_0=(Token)match(input,19,FOLLOW_19_in_ruleSimpleProperty953); 

                                    newLeafNode(lv_many_4_0, grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getSimplePropertyRule());
                            	        }
                                   		setWithLastConsumed(current, "many", true, "[]");
                            	    

                            }


                            }
                            break;

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
    // $ANTLR end "ruleSimpleProperty"


    // $ANTLR start "entryRuleReference"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:460:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:461:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:462:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference1005);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference1015); 

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
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:469:1: ruleReference returns [EObject current=null] : (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_many_4_0=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:472:28: ( (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:473:1: (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:473:1: (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:473:3: otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleReference1052); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getReferenceKeyword_0());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:477:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:478:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:478:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:479:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1069); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleReference1086); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getColonKeyword_2());
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:499:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:500:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:500:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:501:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1106); 

            		newLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 
            	

            }


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:512:2: ( (lv_many_4_0= '[]' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:513:1: (lv_many_4_0= '[]' )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:513:1: (lv_many_4_0= '[]' )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:514:3: lv_many_4_0= '[]'
                    {
                    lv_many_4_0=(Token)match(input,19,FOLLOW_19_in_ruleReference1124); 

                            newLeafNode(lv_many_4_0, grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "many", true, "[]");
                    	    

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
    // $ANTLR end "ruleReference"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModel140 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ruleType_in_ruleModel162 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport199 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport246 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_ruleType361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSimpleType470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleType487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleEntity575 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity592 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleEntity610 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity630 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEntity644 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity665 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_16_in_ruleEntity678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_ruleProperty771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_ruleProperty798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleProperty880 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty897 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleSimpleProperty915 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty935 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleProperty953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1005 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReference1052 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1069 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReference1086 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1106 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleReference1124 = new BitSet(new long[]{0x0000000000000002L});

}
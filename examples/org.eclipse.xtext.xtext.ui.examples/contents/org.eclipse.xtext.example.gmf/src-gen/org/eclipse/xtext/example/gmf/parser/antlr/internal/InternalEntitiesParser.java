package org.eclipse.xtext.example.gmf.parser.antlr.internal; 

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
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:71:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:72:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:80:1: ruleModel returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_elements_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:85:6: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:86:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:86:2: ()
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:87:5: 
            {
             
                    temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:97:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:98:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:98:1: (lv_imports_1_0= ruleImport )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:99:3: lv_imports_1_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel140);
            	    lv_imports_1_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_1_0, 
            	    	        		"Import", 
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

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:121:3: ( (lv_elements_2_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:122:1: (lv_elements_2_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:122:1: (lv_elements_2_0= ruleType )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:123:3: lv_elements_2_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleModel162);
            	    lv_elements_2_0=ruleType();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_2_0, 
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
            	    break loop2;
                }
            } while (true);


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


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:153:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:154:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:155:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:162:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:167:6: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:168:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:168:1: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:168:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleImport246); 

                	createLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:172:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:173:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:173:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:174:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport263); 

            			createLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importURI",
            	        		lv_importURI_1_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:204:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:205:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:206:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:213:1: ruleType returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_Entity_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:218:6: ( (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:219:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:219:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
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
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:220:5: this_SimpleType_0= ruleSimpleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSimpleType_in_ruleType361);
                    this_SimpleType_0=ruleSimpleType();

                    state._fsp--;

                     
                            current = this_SimpleType_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:230:5: this_Entity_1= ruleEntity
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType388);
                    this_Entity_1=ruleEntity();

                    state._fsp--;

                     
                            current = this_Entity_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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


    // $ANTLR start "entryRuleSimpleType"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:246:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:247:2: (iv_ruleSimpleType= ruleSimpleType EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:248:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleTypeRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:255:1: ruleSimpleType returns [EObject current=null] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:260:6: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:261:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:261:1: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:261:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleSimpleType470); 

                	createLeafNode(otherlv_0, grammarAccess.getSimpleTypeAccess().getTypeKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:265:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:266:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:266:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:267:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleType487); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleTypeRule().getType().getClassifier());
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
    // $ANTLR end "ruleSimpleType"


    // $ANTLR start "entryRuleEntity"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:297:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:298:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:299:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:306:1: ruleEntity returns [EObject current=null] : (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_properties_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:311:6: ( (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:312:1: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:312:1: (otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}' )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:312:3: otherlv_0= 'entity' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_properties_5_0= ruleProperty ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleEntity575); 

                	createLeafNode(otherlv_0, grammarAccess.getEntityAccess().getEntityKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:316:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:317:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:317:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:318:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity592); 

            			createLeafNode(lv_name_1_0, grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:340:2: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:340:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleEntity610); 

                        	createLeafNode(otherlv_2, grammarAccess.getEntityAccess().getExtendsKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:344:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:345:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:345:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:346:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity630); 

                    		createLeafNode(otherlv_3, grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0(), "extends"); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleEntity644); 

                	createLeafNode(otherlv_4, grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:362:1: ( (lv_properties_5_0= ruleProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:363:1: (lv_properties_5_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:363:1: (lv_properties_5_0= ruleProperty )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:364:3: lv_properties_5_0= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity665);
            	    lv_properties_5_0=ruleProperty();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"properties",
            	    	        		lv_properties_5_0, 
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
            	    break loop5;
                }
            } while (true);

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleEntity678); 

                	createLeafNode(otherlv_6, grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5(), null);
                

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
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleProperty"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:398:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:399:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:400:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:407:1: ruleProperty returns [EObject current=null] : (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleProperty_0 = null;

        EObject this_Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:412:6: ( (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:413:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:413:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
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
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:414:5: this_SimpleProperty_0= ruleSimpleProperty
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSimpleProperty_in_ruleProperty771);
                    this_SimpleProperty_0=ruleSimpleProperty();

                    state._fsp--;

                     
                            current = this_SimpleProperty_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:424:5: this_Reference_1= ruleReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleProperty798);
                    this_Reference_1=ruleReference();

                    state._fsp--;

                     
                            current = this_Reference_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

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


    // $ANTLR start "entryRuleSimpleProperty"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:440:1: entryRuleSimpleProperty returns [EObject current=null] : iv_ruleSimpleProperty= ruleSimpleProperty EOF ;
    public final EObject entryRuleSimpleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleProperty = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:441:2: (iv_ruleSimpleProperty= ruleSimpleProperty EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:442:2: iv_ruleSimpleProperty= ruleSimpleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimplePropertyRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:449:1: ruleSimpleProperty returns [EObject current=null] : (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) ;
    public final EObject ruleSimpleProperty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_many_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:454:6: ( (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:455:1: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:455:1: (otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:455:3: otherlv_0= 'property' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSimpleProperty880); 

                	createLeafNode(otherlv_0, grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:459:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:460:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:460:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:461:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty897); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
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

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:483:2: (otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:483:4: otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleSimpleProperty915); 

                        	createLeafNode(otherlv_2, grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0(), null);
                        
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:487:1: ( (otherlv_3= RULE_ID ) )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:488:1: (otherlv_3= RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:488:1: (otherlv_3= RULE_ID )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:489:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty935); 

                    		createLeafNode(otherlv_3, grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0(), "type"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:501:2: ( (lv_many_4_0= '[]' ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==19) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:502:1: (lv_many_4_0= '[]' )
                            {
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:502:1: (lv_many_4_0= '[]' )
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:503:3: lv_many_4_0= '[]'
                            {
                            lv_many_4_0=(Token)match(input,19,FOLLOW_19_in_ruleSimpleProperty953); 

                                    createLeafNode(lv_many_4_0, grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0(), "many");
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "many", true, "[]", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

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
    // $ANTLR end "ruleSimpleProperty"


    // $ANTLR start "entryRuleReference"
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:530:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:531:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:532:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
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
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:539:1: ruleReference returns [EObject current=null] : (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_many_4_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:544:6: ( (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:545:1: (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:545:1: (otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:545:3: otherlv_0= 'reference' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (otherlv_3= RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleReference1052); 

                	createLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getReferenceKeyword_0(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:549:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:550:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:550:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:551:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1069); 

            			createLeafNode(lv_name_1_0, grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
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

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleReference1086); 

                	createLeafNode(otherlv_2, grammarAccess.getReferenceAccess().getColonKeyword_2(), null);
                
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:577:1: ( (otherlv_3= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:578:1: (otherlv_3= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:578:1: (otherlv_3= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:579:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1106); 

            		createLeafNode(otherlv_3, grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:591:2: ( (lv_many_4_0= '[]' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:592:1: (lv_many_4_0= '[]' )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:592:1: (lv_many_4_0= '[]' )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:593:3: lv_many_4_0= '[]'
                    {
                    lv_many_4_0=(Token)match(input,19,FOLLOW_19_in_ruleReference1124); 

                            createLeafNode(lv_many_4_0, grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0(), "many");
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "many", true, "[]", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
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
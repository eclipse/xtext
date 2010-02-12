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
import java.util.Map;
import java.util.HashMap;
public class InternalEntitiesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'extends'", "'{'", "'}'", "'property'", "':'", "'[]'", "'reference'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEntitiesParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[25+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private EntitiesGrammarAccess grammarAccess;
     	
        public InternalEntitiesParser(TokenStream input, IAstFactory factory, EntitiesGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:80:2: iv_ruleModel= ruleModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); if (failed) return current;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:87:1: ruleModel returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_elements_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:92:6: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:93:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:93:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:93:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )*
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:93:2: ()
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:94:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:107:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:108:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:108:1: (lv_imports_1_0= ruleImport )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:109:3: lv_imports_1_0= ruleImport
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel149);
            	    lv_imports_1_0=ruleImport();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:131:3: ( (lv_elements_2_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:132:1: (lv_elements_2_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:132:1: (lv_elements_2_0= ruleType )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:133:3: lv_elements_2_0= ruleType
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleModel171);
            	    lv_elements_2_0=ruleType();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:163:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:164:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:165:2: iv_ruleImport= ruleImport EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport208);
            iv_ruleImport=ruleImport();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport218); if (failed) return current;

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:172:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:177:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:178:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:178:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:178:3: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleImport253); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:182:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:183:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:183:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:184:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImport270); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
              		
            }
            if ( backtracking==0 ) {

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


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:214:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:215:2: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:216:2: iv_ruleType= ruleType EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType311);
            iv_ruleType=ruleType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType321); if (failed) return current;

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:223:1: ruleType returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_Entity_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:228:6: ( (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:229:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:229:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("229:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:230:2: this_SimpleType_0= ruleSimpleType
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleType_in_ruleType371);
                    this_SimpleType_0=ruleSimpleType();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleType_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:243:2: this_Entity_1= ruleEntity
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEntity_in_ruleType401);
                    this_Entity_1=ruleEntity();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Entity_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleSimpleType
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:262:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:263:2: (iv_ruleSimpleType= ruleSimpleType EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:264:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimpleTypeRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleType_in_entryRuleSimpleType436);
            iv_ruleSimpleType=ruleSimpleType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleType; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleType446); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleType


    // $ANTLR start ruleSimpleType
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:271:1: ruleSimpleType returns [EObject current=null] : ( 'type' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:276:6: ( ( 'type' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:277:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:277:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:277:3: 'type' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,12,FollowSets000.FOLLOW_12_in_ruleSimpleType481); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:281:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:282:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:282:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:283:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleType498); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

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


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleSimpleType


    // $ANTLR start entryRuleEntity
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:313:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:314:2: (iv_ruleEntity= ruleEntity EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:315:2: iv_ruleEntity= ruleEntity EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEntity_in_entryRuleEntity539);
            iv_ruleEntity=ruleEntity();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEntity; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEntity549); if (failed) return current;

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
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:322:1: ruleEntity returns [EObject current=null] : ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_properties_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:327:6: ( ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:328:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:328:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:328:3: 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}'
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleEntity584); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:332:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:333:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:333:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:334:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntity601); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

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


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:356:2: ( 'extends' ( ( RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:356:4: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleEntity617); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getEntityAccess().getExtendsKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:360:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:361:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:361:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:362:3: RULE_ID
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEntity639); if (failed) return current;
                    if ( backtracking==0 ) {

                      		createLeafNode(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0(), "extends"); 
                      	
                    }

                    }


                    }


                    }
                    break;

            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleEntity651); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:381:1: ( (lv_properties_5_0= ruleProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:382:1: (lv_properties_5_0= ruleProperty )
            	    {
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:382:1: (lv_properties_5_0= ruleProperty )
            	    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:383:3: lv_properties_5_0= ruleProperty
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleProperty_in_ruleEntity672);
            	    lv_properties_5_0=ruleProperty();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

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


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,16,FollowSets000.FOLLOW_16_in_ruleEntity683); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleProperty
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:417:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:418:2: (iv_ruleProperty= ruleProperty EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:419:2: iv_ruleProperty= ruleProperty EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProperty_in_entryRuleProperty719);
            iv_ruleProperty=ruleProperty();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProperty729); if (failed) return current;

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
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:426:1: ruleProperty returns [EObject current=null] : (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleProperty_0 = null;

        EObject this_Reference_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:431:6: ( (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:432:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:432:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==20) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("432:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:433:2: this_SimpleProperty_0= ruleSimpleProperty
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleProperty_in_ruleProperty779);
                    this_SimpleProperty_0=ruleSimpleProperty();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SimpleProperty_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:446:2: this_Reference_1= ruleReference
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleProperty809);
                    this_Reference_1=ruleReference();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Reference_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleProperty


    // $ANTLR start entryRuleSimpleProperty
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:465:1: entryRuleSimpleProperty returns [EObject current=null] : iv_ruleSimpleProperty= ruleSimpleProperty EOF ;
    public final EObject entryRuleSimpleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleProperty = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:466:2: (iv_ruleSimpleProperty= ruleSimpleProperty EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:467:2: iv_ruleSimpleProperty= ruleSimpleProperty EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSimplePropertyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty844);
            iv_ruleSimpleProperty=ruleSimpleProperty();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSimpleProperty; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleProperty854); if (failed) return current;

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
    // $ANTLR end entryRuleSimpleProperty


    // $ANTLR start ruleSimpleProperty
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:474:1: ruleSimpleProperty returns [EObject current=null] : ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) ;
    public final EObject ruleSimpleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_many_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:479:6: ( ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:480:1: ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:480:1: ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:480:3: 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleSimpleProperty889); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:484:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:485:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:485:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:486:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleProperty906); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

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


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:508:2: ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:508:4: ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleSimpleProperty922); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:512:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:513:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:513:1: ( RULE_ID )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:514:3: RULE_ID
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSimpleProperty944); if (failed) return current;
                    if ( backtracking==0 ) {

                      		createLeafNode(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0(), "type"); 
                      	
                    }

                    }


                    }

                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:529:2: ( (lv_many_4_0= '[]' ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==19) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:530:1: (lv_many_4_0= '[]' )
                            {
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:530:1: (lv_many_4_0= '[]' )
                            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:531:3: lv_many_4_0= '[]'
                            {
                            lv_many_4_0=(Token)input.LT(1);
                            match(input,19,FollowSets000.FOLLOW_19_in_ruleSimpleProperty962); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0(), "many"); 
                                  
                            }
                            if ( backtracking==0 ) {

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


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleSimpleProperty


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:558:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:559:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:560:2: iv_ruleReference= ruleReference EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference1014);
            iv_ruleReference=ruleReference();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleReference; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference1024); if (failed) return current;

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
    // $ANTLR end entryRuleReference


    // $ANTLR start ruleReference
    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:567:1: ruleReference returns [EObject current=null] : ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_many_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:572:6: ( ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:573:1: ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:573:1: ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:573:3: 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleReference1059); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getReferenceAccess().getReferenceKeyword_0(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:577:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:578:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:578:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:579:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1076); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

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


            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleReference1091); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getReferenceAccess().getColonKeyword_2(), null); 
                  
            }
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:605:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:606:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:606:1: ( RULE_ID )
            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:607:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1113); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0(), "type"); 
              	
            }

            }


            }

            // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:622:2: ( (lv_many_4_0= '[]' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:623:1: (lv_many_4_0= '[]' )
                    {
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:623:1: (lv_many_4_0= '[]' )
                    // ../org.eclipse.xtext.example.gmf/src-gen/org/eclipse/xtext/example/gmf/parser/antlr/internal/InternalEntities.g:624:3: lv_many_4_0= '[]'
                    {
                    lv_many_4_0=(Token)input.LT(1);
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleReference1131); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0(), "many"); 
                          
                    }
                    if ( backtracking==0 ) {

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


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleReference


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel149 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_ruleType_in_ruleModel171 = new BitSet(new long[]{0x0000000000003002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport208 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleImport253 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImport270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType311 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleType_in_ruleType371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEntity_in_ruleType401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType436 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleSimpleType481 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleType498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity539 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEntity549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleEntity584 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntity601 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleEntity617 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEntity639 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleEntity651 = new BitSet(new long[]{0x0000000000130000L});
        public static final BitSet FOLLOW_ruleProperty_in_ruleEntity672 = new BitSet(new long[]{0x0000000000130000L});
        public static final BitSet FOLLOW_16_in_ruleEntity683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty719 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProperty729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleProperty_in_ruleProperty779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleProperty809 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty844 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSimpleProperty889 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty906 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_18_in_ruleSimpleProperty922 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty944 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleSimpleProperty962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1014 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference1024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleReference1059 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1076 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleReference1091 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1113 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleReference1131 = new BitSet(new long[]{0x0000000000000002L});
    }


}
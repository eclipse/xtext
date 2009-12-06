package org.eclipse.xtext.ui.common.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.common.editor.contentassist.services.DatatypeRuleTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalDatatypeRuleTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Types'", "'Type'", "';'", "'Composite'", "'base'", "'<'", "','", "'>'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalDatatypeRuleTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g"; }



     	private DatatypeRuleTestLanguageGrammarAccess grammarAccess;
     	
        public InternalDatatypeRuleTestLanguageParser(TokenStream input, IAstFactory factory, DatatypeRuleTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:80:1: ruleModel returns [EObject current=null] : this_Types_0= ruleTypes ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Types_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:85:6: (this_Types_0= ruleTypes )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:87:5: this_Types_0= ruleTypes
            {
             
                    currentNode=createCompositeNode(grammarAccess.getModelAccess().getTypesParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleTypes_in_ruleModel129);
            this_Types_0=ruleTypes();
            _fsp--;

             
                    current = this_Types_0; 
                    currentNode = currentNode.getParent();
                

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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleTypes
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:102:1: entryRuleTypes returns [EObject current=null] : iv_ruleTypes= ruleTypes EOF ;
    public final EObject entryRuleTypes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypes = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:102:47: (iv_ruleTypes= ruleTypes EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:103:2: iv_ruleTypes= ruleTypes EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypesRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypes_in_entryRuleTypes160);
            iv_ruleTypes=ruleTypes();
            _fsp--;

             current =iv_ruleTypes; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypes170); 

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
    // $ANTLR end entryRuleTypes


    // $ANTLR start ruleTypes
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:110:1: ruleTypes returns [EObject current=null] : ( 'Types' ( (lv_types_1_0= ruleType ) )* ) ;
    public final EObject ruleTypes() throws RecognitionException {
        EObject current = null;

        EObject lv_types_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:115:6: ( ( 'Types' ( (lv_types_1_0= ruleType ) )* ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:116:1: ( 'Types' ( (lv_types_1_0= ruleType ) )* )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:116:1: ( 'Types' ( (lv_types_1_0= ruleType ) )* )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:116:3: 'Types' ( (lv_types_1_0= ruleType ) )*
            {
            match(input,11,FOLLOW_11_in_ruleTypes205); 

                    createLeafNode(grammarAccess.getTypesAccess().getTypesKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:120:1: ( (lv_types_1_0= ruleType ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12||LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:121:1: (lv_types_1_0= ruleType )
            	    {
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:121:1: (lv_types_1_0= ruleType )
            	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:122:3: lv_types_1_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTypesAccess().getTypesTypeParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleTypes226);
            	    lv_types_1_0=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTypesRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"types",
            	    	        		lv_types_1_0, 
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
    // $ANTLR end ruleTypes


    // $ANTLR start entryRuleType
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:151:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:151:46: (iv_ruleType= ruleType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:152:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType260);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType270); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:159:1: ruleType returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_CompositeType_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:164:6: ( (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:165:1: (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:165:1: (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType )
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
                    new NoViableAltException("165:1: (this_SimpleType_0= ruleSimpleType | this_CompositeType_1= ruleCompositeType )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:166:5: this_SimpleType_0= ruleSimpleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSimpleType_in_ruleType317);
                    this_SimpleType_0=ruleSimpleType();
                    _fsp--;

                     
                            current = this_SimpleType_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:176:5: this_CompositeType_1= ruleCompositeType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getCompositeTypeParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleCompositeType_in_ruleType344);
                    this_CompositeType_1=ruleCompositeType();
                    _fsp--;

                     
                            current = this_CompositeType_1; 
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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleSimpleType
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:191:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:191:52: (iv_ruleSimpleType= ruleSimpleType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:192:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType376);
            iv_ruleSimpleType=ruleSimpleType();
            _fsp--;

             current =iv_ruleSimpleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType386); 

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
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:199:1: ruleSimpleType returns [EObject current=null] : ( 'Type' ( (lv_name_1_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:204:6: ( ( 'Type' ( (lv_name_1_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:205:1: ( 'Type' ( (lv_name_1_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:205:1: ( 'Type' ( (lv_name_1_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:205:3: 'Type' ( (lv_name_1_0= RULE_ID ) ) ';'
            {
            match(input,12,FOLLOW_12_in_ruleSimpleType421); 

                    createLeafNode(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:209:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:210:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:210:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:211:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleType438); 

            			createLeafNode(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

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

            match(input,13,FOLLOW_13_in_ruleSimpleType453); 

                    createLeafNode(grammarAccess.getSimpleTypeAccess().getSemicolonKeyword_2(), null); 
                

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
    // $ANTLR end ruleSimpleType


    // $ANTLR start entryRuleCompositeType
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:244:1: entryRuleCompositeType returns [EObject current=null] : iv_ruleCompositeType= ruleCompositeType EOF ;
    public final EObject entryRuleCompositeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeType = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:244:55: (iv_ruleCompositeType= ruleCompositeType EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:245:2: iv_ruleCompositeType= ruleCompositeType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCompositeTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleCompositeType_in_entryRuleCompositeType486);
            iv_ruleCompositeType=ruleCompositeType();
            _fsp--;

             current =iv_ruleCompositeType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeType496); 

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
    // $ANTLR end entryRuleCompositeType


    // $ANTLR start ruleCompositeType
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:252:1: ruleCompositeType returns [EObject current=null] : ( 'Composite' ( (lv_name_1_0= RULE_ID ) ) 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) ';' ) ;
    public final EObject ruleCompositeType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_baseType_3_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:257:6: ( ( 'Composite' ( (lv_name_1_0= RULE_ID ) ) 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) ';' ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:258:1: ( 'Composite' ( (lv_name_1_0= RULE_ID ) ) 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:258:1: ( 'Composite' ( (lv_name_1_0= RULE_ID ) ) 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) ';' )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:258:3: 'Composite' ( (lv_name_1_0= RULE_ID ) ) 'base' ( (lv_baseType_3_0= ruleCompositeTypeEntry ) ) ';'
            {
            match(input,14,FOLLOW_14_in_ruleCompositeType531); 

                    createLeafNode(grammarAccess.getCompositeTypeAccess().getCompositeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:262:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:263:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:263:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:264:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCompositeType548); 

            			createLeafNode(grammarAccess.getCompositeTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCompositeTypeRule().getType().getClassifier());
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

            match(input,15,FOLLOW_15_in_ruleCompositeType563); 

                    createLeafNode(grammarAccess.getCompositeTypeAccess().getBaseKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:290:1: ( (lv_baseType_3_0= ruleCompositeTypeEntry ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:291:1: (lv_baseType_3_0= ruleCompositeTypeEntry )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:291:1: (lv_baseType_3_0= ruleCompositeTypeEntry )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:292:3: lv_baseType_3_0= ruleCompositeTypeEntry
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCompositeTypeAccess().getBaseTypeCompositeTypeEntryParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleCompositeTypeEntry_in_ruleCompositeType584);
            lv_baseType_3_0=ruleCompositeTypeEntry();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCompositeTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"baseType",
            	        		lv_baseType_3_0, 
            	        		"CompositeTypeEntry", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,13,FOLLOW_13_in_ruleCompositeType594); 

                    createLeafNode(grammarAccess.getCompositeTypeAccess().getSemicolonKeyword_4(), null); 
                

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
    // $ANTLR end ruleCompositeType


    // $ANTLR start entryRuleCompositeTypeEntry
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:325:1: entryRuleCompositeTypeEntry returns [EObject current=null] : iv_ruleCompositeTypeEntry= ruleCompositeTypeEntry EOF ;
    public final EObject entryRuleCompositeTypeEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeTypeEntry = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:325:60: (iv_ruleCompositeTypeEntry= ruleCompositeTypeEntry EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:326:2: iv_ruleCompositeTypeEntry= ruleCompositeTypeEntry EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCompositeTypeEntryRule(), currentNode); 
            pushFollow(FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry627);
            iv_ruleCompositeTypeEntry=ruleCompositeTypeEntry();
            _fsp--;

             current =iv_ruleCompositeTypeEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCompositeTypeEntry637); 

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
    // $ANTLR end entryRuleCompositeTypeEntry


    // $ANTLR start ruleCompositeTypeEntry
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:333:1: ruleCompositeTypeEntry returns [EObject current=null] : ( ( ruleTypeId ) ) ;
    public final EObject ruleCompositeTypeEntry() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:338:6: ( ( ( ruleTypeId ) ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:339:1: ( ( ruleTypeId ) )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:339:1: ( ( ruleTypeId ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:340:1: ( ruleTypeId )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:340:1: ( ruleTypeId )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:341:3: ruleTypeId
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getCompositeTypeEntryRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
             
            	        currentNode=createCompositeNode(grammarAccess.getCompositeTypeEntryAccess().getDataTypeTypeCrossReference_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleTypeId_in_ruleCompositeTypeEntry684);
            ruleTypeId();
            _fsp--;

             
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end ruleCompositeTypeEntry


    // $ANTLR start entryRuleTypeId
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:362:1: entryRuleTypeId returns [String current=null] : iv_ruleTypeId= ruleTypeId EOF ;
    public final String entryRuleTypeId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTypeId = null;


        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:362:47: (iv_ruleTypeId= ruleTypeId EOF )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:363:2: iv_ruleTypeId= ruleTypeId EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeIdRule(), currentNode); 
            pushFollow(FOLLOW_ruleTypeId_in_entryRuleTypeId717);
            iv_ruleTypeId=ruleTypeId();
            _fsp--;

             current =iv_ruleTypeId.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeId728); 

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
    // $ANTLR end entryRuleTypeId


    // $ANTLR start ruleTypeId
    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:370:1: ruleTypeId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? ) ;
    public final AntlrDatatypeRuleToken ruleTypeId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        AntlrDatatypeRuleToken this_TypeId_2 = null;

        AntlrDatatypeRuleToken this_TypeId_4 = null;


         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:375:6: ( (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? ) )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:376:1: (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? )
            {
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:376:1: (this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )? )
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:376:6: this_ID_0= RULE_ID (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )?
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTypeId768); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getTypeIdAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:383:1: (kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:384:2: kw= '<' this_TypeId_2= ruleTypeId (kw= ',' this_TypeId_4= ruleTypeId )* kw= '>'
                    {
                    kw=(Token)input.LT(1);
                    match(input,16,FOLLOW_16_in_ruleTypeId787); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getTypeIdAccess().getLessThanSignKeyword_1_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTypeId_in_ruleTypeId809);
                    this_TypeId_2=ruleTypeId();
                    _fsp--;


                    		current.merge(this_TypeId_2);
                        
                     
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:400:1: (kw= ',' this_TypeId_4= ruleTypeId )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==17) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.common.tests/src-gen/org/eclipse/xtext/ui/common/editor/contentassist/parser/antlr/internal/InternalDatatypeRuleTestLanguage.g:401:2: kw= ',' this_TypeId_4= ruleTypeId
                    	    {
                    	    kw=(Token)input.LT(1);
                    	    match(input,17,FOLLOW_17_in_ruleTypeId828); 

                    	            current.merge(kw);
                    	            createLeafNode(grammarAccess.getTypeIdAccess().getCommaKeyword_1_2_0(), null); 
                    	        
                    	     
                    	            currentNode=createCompositeNode(grammarAccess.getTypeIdAccess().getTypeIdParserRuleCall_1_2_1(), currentNode); 
                    	        
                    	    pushFollow(FOLLOW_ruleTypeId_in_ruleTypeId850);
                    	    this_TypeId_4=ruleTypeId();
                    	    _fsp--;


                    	    		current.merge(this_TypeId_4);
                    	        
                    	     
                    	            currentNode = currentNode.getParent();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    kw=(Token)input.LT(1);
                    match(input,18,FOLLOW_18_in_ruleTypeId870); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getTypeIdAccess().getGreaterThanSignKeyword_1_3(), null); 
                        

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
    // $ANTLR end ruleTypeId


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypes_in_ruleModel129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypes_in_entryRuleTypes160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypes170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTypes205 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleType_in_ruleTypes226 = new BitSet(new long[]{0x0000000000005002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_ruleType317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeType_in_ruleType344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSimpleType421 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleType438 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSimpleType453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeType_in_entryRuleCompositeType486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeType496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleCompositeType531 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCompositeType548 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleCompositeType563 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_ruleCompositeType584 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCompositeType594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCompositeTypeEntry_in_entryRuleCompositeTypeEntry627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCompositeTypeEntry637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeId_in_ruleCompositeTypeEntry684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeId_in_entryRuleTypeId717 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeId728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTypeId768 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleTypeId787 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeId_in_ruleTypeId809 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleTypeId828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeId_in_ruleTypeId850 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleTypeId870 = new BitSet(new long[]{0x0000000000000002L});

}
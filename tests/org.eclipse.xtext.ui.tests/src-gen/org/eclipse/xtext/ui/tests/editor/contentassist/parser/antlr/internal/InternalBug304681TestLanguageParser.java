package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug304681TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug304681TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'1'", "'2'", "'package'", "';'", "'enabled'", "'abstract'", "'object'", "'extends'", "'{'", "'shortDescription'", "'longDescription'", "'serialUID'", "'cloneable'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'}'", "'Attribute'", "'Reference'", "'*'", "'required'", "'technical'", "'constraint'", "'parameters'", "'message'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug304681TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g"; }



     	private Bug304681TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug304681TestLanguageParser(TokenStream input, IAstFactory factory, Bug304681TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug304681TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();
            _fsp--;

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
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_definition_1_0 = null;

        EObject lv_definition_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:91:6: ( ( ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:1: ( ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:1: ( ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("92:1: ( ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) ) | ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) ) )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:2: ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:2: ( '1' ( (lv_definition_1_0= rulePackageDefinition ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:92:4: '1' ( (lv_definition_1_0= rulePackageDefinition ) )
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleModel121); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitOneKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:96:1: ( (lv_definition_1_0= rulePackageDefinition ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:97:1: (lv_definition_1_0= rulePackageDefinition )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:97:1: (lv_definition_1_0= rulePackageDefinition )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:98:3: lv_definition_1_0= rulePackageDefinition
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefinitionPackageDefinitionParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_ruleModel142);
                    lv_definition_1_0=rulePackageDefinition();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"definition",
                    	        		lv_definition_1_0, 
                    	        		"PackageDefinition", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:121:6: ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:121:6: ( '2' ( (lv_definition_3_0= rulePackageDefinition2 ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:121:8: '2' ( (lv_definition_3_0= rulePackageDefinition2 ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleModel160); 

                            createLeafNode(grammarAccess.getModelAccess().getDigitTwoKeyword_1_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:125:1: ( (lv_definition_3_0= rulePackageDefinition2 ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:126:1: (lv_definition_3_0= rulePackageDefinition2 )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:126:1: (lv_definition_3_0= rulePackageDefinition2 )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:127:3: lv_definition_3_0= rulePackageDefinition2
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefinitionPackageDefinition2ParserRuleCall_1_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_ruleModel181);
                    lv_definition_3_0=rulePackageDefinition2();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"definition",
                    	        		lv_definition_3_0, 
                    	        		"PackageDefinition2", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }


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
    // $ANTLR end ruleModel


    // $ANTLR start entryRulePackageDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:157:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:158:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:159:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageDefinitionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition218);
            iv_rulePackageDefinition=rulePackageDefinition();
            _fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition228); 

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
    // $ANTLR end entryRulePackageDefinition


    // $ANTLR start rulePackageDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:166:1: rulePackageDefinition returns [EObject current=null] : ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_namespace_2_0=null;
        EObject lv_contents_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:171:6: ( ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:172:1: ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:172:1: ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:172:2: () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:172:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:173:5: 
            {
             
                    temp=factory.create(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getPackageDefinitionAccess().getPackageDefinitionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,13,FollowSets000.FOLLOW_13_in_rulePackageDefinition272); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:187:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:188:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:188:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:189:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition289); 

            			createLeafNode(grammarAccess.getPackageDefinitionAccess().getNamespaceIDTerminalRuleCall_2_0(), "namespace"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPackageDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"namespace",
            	        		lv_namespace_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FollowSets000.FOLLOW_14_in_rulePackageDefinition304); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:215:1: ( (lv_contents_4_0= ruleObject ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=15 && LA2_0<=17)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:216:1: (lv_contents_4_0= ruleObject )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:216:1: (lv_contents_4_0= ruleObject )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:217:3: lv_contents_4_0= ruleObject
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleObject_in_rulePackageDefinition325);
            	    lv_contents_4_0=ruleObject();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPackageDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"contents",
            	    	        		lv_contents_4_0, 
            	    	        		"Object", 
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
    // $ANTLR end rulePackageDefinition


    // $ANTLR start entryRuleObject
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:247:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:248:2: (iv_ruleObject= ruleObject EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:249:2: iv_ruleObject= ruleObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_entryRuleObject362);
            iv_ruleObject=ruleObject();
            _fsp--;

             current =iv_ruleObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject372); 

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
    // $ANTLR end entryRuleObject


    // $ANTLR start ruleObject
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:256:1: ruleObject returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token lv_enabled_0_0=null;
        Token lv_abstract_1_0=null;
        Token lv_name_3_0=null;
        Token lv_shortDescription_9_0=null;
        Token lv_longDescription_12_0=null;
        Token lv_serialVersionUID_15_0=null;
        Token lv_cloneable_17_0=null;
        EObject lv_features_19_0 = null;

        EObject lv_features_21_0 = null;

        EObject lv_features_24_0 = null;

        EObject lv_features_26_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:261:6: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:262:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:262:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:262:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:262:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            else if ( (LA3_0==16) ) {
                alt3=2;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:262:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:262:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:263:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:263:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:264:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleObject416); 

                            createLeafNode(grammarAccess.getObjectAccess().getEnabledEnabledKeyword_0_0_0(), "enabled"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "enabled", true, "enabled", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:284:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:284:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:285:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:285:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:286:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleObject453); 

                            createLeafNode(grammarAccess.getObjectAccess().getAbstractAbstractKeyword_0_1_0(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleObject478); 

                    createLeafNode(grammarAccess.getObjectAccess().getObjectKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:309:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:310:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:310:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:311:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject495); 

            			createLeafNode(grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:333:2: ( 'extends' ( ( RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==18) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:333:4: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleObject511); 

                            createLeafNode(grammarAccess.getObjectAccess().getExtendsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:337:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:338:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:338:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:339:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject529); 

                    		createLeafNode(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0(), "parent"); 
                    	

                    }


                    }


                    }
                    break;

            }

            match(input,19,FollowSets000.FOLLOW_19_in_ruleObject541); 

                    createLeafNode(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:355:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:357:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:357:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:358:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:361:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:362:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*
            loop9:
            do {
                int alt9=9;
                int LA9_0 = input.LA(1);

                if ( LA9_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
                    alt9=1;
                }
                else if ( LA9_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
                    alt9=2;
                }
                else if ( LA9_0==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
                    alt9=3;
                }
                else if ( LA9_0==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
                    alt9=4;
                }
                else if ( LA9_0>=29 && LA9_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
                    alt9=5;
                }
                else if ( LA9_0==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
                    alt9=6;
                }
                else if ( LA9_0==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
                    alt9=7;
                }
                else if ( LA9_0==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
                    alt9=8;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:364:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:364:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:365:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:365:103: ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:366:6: ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:369:6: ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:369:8: 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleObject594); 

            	            createLeafNode(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:373:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:374:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:374:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:375:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject611); 

            	    			createLeafNode(grammarAccess.getObjectAccess().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0(), "shortDescription"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"shortDescription",
            	    	        		lv_shortDescription_9_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject626); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:408:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:408:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:409:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:409:103: ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:410:6: ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:413:6: ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:413:8: 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleObject688); 

            	            createLeafNode(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:417:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:418:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:418:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:419:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject705); 

            	    			createLeafNode(grammarAccess.getObjectAccess().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0(), "longDescription"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"longDescription",
            	    	        		lv_longDescription_12_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject720); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:452:4: ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:452:4: ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:453:5: {...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:453:103: ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:454:6: ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:457:6: ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:457:8: 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';'
            	    {
            	    match(input,22,FollowSets000.FOLLOW_22_in_ruleObject782); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:461:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:462:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:462:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:463:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject799); 

            	    			createLeafNode(grammarAccess.getObjectAccess().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0(), "serialVersionUID"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"serialVersionUID",
            	    	        		lv_serialVersionUID_15_0, 
            	    	        		"INT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject814); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:496:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:496:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:497:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:497:103: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:498:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:501:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:501:7: ( (lv_cloneable_17_0= 'cloneable' ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:501:7: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:502:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:502:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:503:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)input.LT(1);
            	    match(input,23,FollowSets000.FOLLOW_23_in_ruleObject884); 

            	            createLeafNode(grammarAccess.getObjectAccess().getCloneableCloneableKeyword_5_3_0_0(), "cloneable"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "cloneable", true, "cloneable", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject907); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:533:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:533:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:534:5: {...}? => ( ( (lv_features_19_0= ruleFeature ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:534:103: ( ( (lv_features_19_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:535:6: ( (lv_features_19_0= ruleFeature ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:6: ( (lv_features_19_0= ruleFeature ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==29) ) {
            	            int LA5_6 = input.LA(2);

            	            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            	                alt5=1;
            	            }


            	        }
            	        else if ( (LA5_0==30) ) {
            	            int LA5_7 = input.LA(2);

            	            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:539:1: (lv_features_19_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:539:1: (lv_features_19_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:540:3: lv_features_19_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject979);
            	    	    lv_features_19_0=ruleFeature();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"features",
            	    	    	        		lv_features_19_0, 
            	    	    	        		"Feature", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:569:4: ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:569:4: ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:570:5: {...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:570:103: ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:571:6: ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:574:6: ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:574:8: 'before' ( (lv_features_21_0= ruleFeature ) )* 'after'
            	    {
            	    match(input,24,FollowSets000.FOLLOW_24_in_ruleObject1041); 

            	            createLeafNode(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:578:1: ( (lv_features_21_0= ruleFeature ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( ((LA6_0>=29 && LA6_0<=30)) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:579:1: (lv_features_21_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:579:1: (lv_features_21_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:580:3: lv_features_21_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1062);
            	    	    lv_features_21_0=ruleFeature();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"features",
            	    	    	        		lv_features_21_0, 
            	    	    	        		"Feature", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);

            	    match(input,25,FollowSets000.FOLLOW_25_in_ruleObject1073); 

            	            createLeafNode(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:613:4: ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:613:4: ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:614:5: {...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:614:103: ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:615:6: ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:618:6: ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:618:8: 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )*
            	    {
            	    match(input,26,FollowSets000.FOLLOW_26_in_ruleObject1135); 

            	            createLeafNode(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:622:1: ( (lv_features_24_0= ruleFeature ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        alt7 = dfa7.predict(input);
            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:623:1: (lv_features_24_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:623:1: (lv_features_24_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:624:3: lv_features_24_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1156);
            	    	    lv_features_24_0=ruleFeature();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"features",
            	    	    	        		lv_features_24_0, 
            	    	    	        		"Feature", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:653:4: ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:653:4: ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:654:5: {...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:654:103: ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:655:6: ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:658:6: ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:658:8: 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+
            	    {
            	    match(input,27,FollowSets000.FOLLOW_27_in_ruleObject1219); 

            	            createLeafNode(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:662:1: ( (lv_features_26_0= ruleFeature ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        alt8 = dfa8.predict(input);
            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:663:1: (lv_features_26_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:663:1: (lv_features_26_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:664:3: lv_features_26_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1240);
            	    	    lv_features_26_0=ruleFeature();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"features",
            	    	    	        		lv_features_26_0, 
            	    	    	        		"Feature", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleObject1291); 

                    createLeafNode(grammarAccess.getObjectAccess().getRightCurlyBracketKeyword_6(), null); 
                

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
    // $ANTLR end ruleObject


    // $ANTLR start entryRuleFeature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:712:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:713:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:714:2: iv_ruleFeature= ruleFeature EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature1327);
            iv_ruleFeature=ruleFeature();
            _fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature1337); 

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
    // $ANTLR end entryRuleFeature


    // $ANTLR start ruleFeature
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:721:1: ruleFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:726:6: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:727:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:727:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            else if ( (LA10_0==30) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("727:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:728:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleFeature1384);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:738:5: this_Reference_1= ruleReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleFeature1411);
                    this_Reference_1=ruleReference();
                    _fsp--;

                     
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
    // $ANTLR end ruleFeature


    // $ANTLR start entryRuleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:754:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:755:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:756:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute1446);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute1456); 

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
    // $ANTLR end entryRuleAttribute


    // $ANTLR start ruleAttribute
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:763:1: ruleAttribute returns [EObject current=null] : ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Token lv_name_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:768:6: ( ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:769:1: ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:769:1: ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:769:3: 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';'
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleAttribute1491); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttributeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:773:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:774:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:774:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:775:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1508); 

            			createLeafNode(grammarAccess.getAttributeAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:797:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:798:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:798:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:799:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1530); 

            			createLeafNode(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttributeRule().getType().getClassifier());
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

            match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute1545); 

                    createLeafNode(grammarAccess.getAttributeAccess().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleAttribute


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:834:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:835:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference1581);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference1591); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:842:1: ruleReference returns [EObject current=null] : ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_many_2_0=null;
        Token lv_name_3_0=null;
        Token lv_shortDescription_7_0=null;
        Token lv_longDescription_10_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:847:6: ( ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:848:1: ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:848:1: ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:848:3: 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            {
            match(input,30,FollowSets000.FOLLOW_30_in_ruleReference1626); 

                    createLeafNode(grammarAccess.getReferenceAccess().getReferenceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:852:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:853:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:853:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:854:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1644); 

            		createLeafNode(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:866:2: ( (lv_many_2_0= '*' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:867:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:868:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)input.LT(1);
                    match(input,31,FollowSets000.FOLLOW_31_in_ruleReference1662); 

                            createLeafNode(grammarAccess.getReferenceAccess().getManyAsteriskKeyword_2_0(), "many"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "many", true, "*", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:887:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:888:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:888:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:889:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1693); 

            			createLeafNode(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:911:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            else if ( (LA13_0==14) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("911:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:911:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:911:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:911:5: '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleReference1710); 

                            createLeafNode(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:915:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:917:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:917:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:918:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:921:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:922:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:922:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( LA12_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                            alt12=1;
                        }
                        else if ( LA12_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:924:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:924:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:925:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:925:110: ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:926:6: ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:929:6: ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:929:8: 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleReference1763); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:933:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:934:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:934:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:935:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1780); 

                    	    			createLeafNode(grammarAccess.getReferenceAccess().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0(), "shortDescription"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"shortDescription",
                    	    	        		lv_shortDescription_7_0, 
                    	    	        		"STRING", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleReference1795); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:968:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:968:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:969:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:969:110: ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:970:6: ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:973:6: ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:973:8: 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleReference1857); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:977:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:978:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:978:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:979:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1874); 

                    	    			createLeafNode(grammarAccess.getReferenceAccess().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0(), "longDescription"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"longDescription",
                    	    	        		lv_longDescription_10_0, 
                    	    	        		"STRING", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleReference1889); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	

                    }

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleReference1939); 

                            createLeafNode(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1024:7: ';'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleReference1956); 

                            createLeafNode(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_1(), null); 
                        

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
    // $ANTLR end ruleReference


    // $ANTLR start entryRulePackageDefinition2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1036:1: entryRulePackageDefinition2 returns [EObject current=null] : iv_rulePackageDefinition2= rulePackageDefinition2 EOF ;
    public final EObject entryRulePackageDefinition2() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1037:2: (iv_rulePackageDefinition2= rulePackageDefinition2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1038:2: iv_rulePackageDefinition2= rulePackageDefinition2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageDefinition2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition21993);
            iv_rulePackageDefinition2=rulePackageDefinition2();
            _fsp--;

             current =iv_rulePackageDefinition2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition22003); 

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
    // $ANTLR end entryRulePackageDefinition2


    // $ANTLR start rulePackageDefinition2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1045:1: rulePackageDefinition2 returns [EObject current=null] : ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject2 ) )* ) ;
    public final EObject rulePackageDefinition2() throws RecognitionException {
        EObject current = null;

        Token lv_namespace_2_0=null;
        EObject lv_contents_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1050:6: ( ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject2 ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1051:1: ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject2 ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1051:1: ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject2 ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1051:2: () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject2 ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1051:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1052:5: 
            {
             
                    temp=factory.create(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getPackageDefinition2Access().getPackageDefinitionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,13,FollowSets000.FOLLOW_13_in_rulePackageDefinition22047); 

                    createLeafNode(grammarAccess.getPackageDefinition2Access().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1066:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1067:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1067:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1068:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition22064); 

            			createLeafNode(grammarAccess.getPackageDefinition2Access().getNamespaceIDTerminalRuleCall_2_0(), "namespace"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPackageDefinition2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"namespace",
            	        		lv_namespace_2_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,14,FollowSets000.FOLLOW_14_in_rulePackageDefinition22079); 

                    createLeafNode(grammarAccess.getPackageDefinition2Access().getSemicolonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1094:1: ( (lv_contents_4_0= ruleObject2 ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=15 && LA14_0<=17)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1095:1: (lv_contents_4_0= ruleObject2 )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1095:1: (lv_contents_4_0= ruleObject2 )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1096:3: lv_contents_4_0= ruleObject2
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPackageDefinition2Access().getContentsObject2ParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleObject2_in_rulePackageDefinition22100);
            	    lv_contents_4_0=ruleObject2();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getPackageDefinition2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"contents",
            	    	        		lv_contents_4_0, 
            	    	        		"Object2", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end rulePackageDefinition2


    // $ANTLR start entryRuleObject2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1126:1: entryRuleObject2 returns [EObject current=null] : iv_ruleObject2= ruleObject2 EOF ;
    public final EObject entryRuleObject2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1127:2: (iv_ruleObject2= ruleObject2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1128:2: iv_ruleObject2= ruleObject2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObject2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleObject2_in_entryRuleObject22137);
            iv_ruleObject2=ruleObject2();
            _fsp--;

             current =iv_ruleObject2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject22147); 

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
    // $ANTLR end entryRuleObject2


    // $ANTLR start ruleObject2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1135:1: ruleObject2 returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) '}' ) ;
    public final EObject ruleObject2() throws RecognitionException {
        EObject current = null;

        Token lv_enabled_0_0=null;
        Token lv_abstract_1_0=null;
        Token lv_name_3_0=null;
        Token lv_shortDescription_9_0=null;
        Token lv_longDescription_12_0=null;
        Token lv_serialVersionUID_15_0=null;
        Token lv_cloneable_17_0=null;
        EObject lv_features_19_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1140:6: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) ) '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            else if ( (LA15_0==16) ) {
                alt15=2;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1141:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1142:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1142:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1143:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)input.LT(1);
                    match(input,15,FollowSets000.FOLLOW_15_in_ruleObject22191); 

                            createLeafNode(grammarAccess.getObject2Access().getEnabledEnabledKeyword_0_0_0(), "enabled"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "enabled", true, "enabled", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1163:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1163:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1164:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1164:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1165:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)input.LT(1);
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleObject22228); 

                            createLeafNode(grammarAccess.getObject2Access().getAbstractAbstractKeyword_0_1_0(), "abstract"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleObject22253); 

                    createLeafNode(grammarAccess.getObject2Access().getObjectKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1188:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1189:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1189:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1190:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject22270); 

            			createLeafNode(grammarAccess.getObject2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1212:2: ( 'extends' ( ( RULE_ID ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==18) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1212:4: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_ruleObject22286); 

                            createLeafNode(grammarAccess.getObject2Access().getExtendsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1216:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1217:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1217:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1218:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject22304); 

                    		createLeafNode(grammarAccess.getObject2Access().getParentObjectCrossReference_3_1_0(), "parent"); 
                    	

                    }


                    }


                    }
                    break;

            }

            match(input,19,FollowSets000.FOLLOW_19_in_ruleObject22316); 

                    createLeafNode(grammarAccess.getObject2Access().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1234:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1236:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1236:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1237:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1240:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1241:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1241:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) ) )*
            loop18:
            do {
                int alt18=6;
                int LA18_0 = input.LA(1);

                if ( LA18_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
                    alt18=1;
                }
                else if ( LA18_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
                    alt18=2;
                }
                else if ( LA18_0==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
                    alt18=3;
                }
                else if ( LA18_0==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
                    alt18=4;
                }
                else if ( LA18_0>=29 && LA18_0<=30 && getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
                    alt18=5;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1243:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1243:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1244:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1244:104: ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1245:6: ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1248:6: ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1248:8: 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleObject22369); 

            	            createLeafNode(grammarAccess.getObject2Access().getShortDescriptionKeyword_5_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1252:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1253:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1253:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1254:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject22386); 

            	    			createLeafNode(grammarAccess.getObject2Access().getShortDescriptionSTRINGTerminalRuleCall_5_0_1_0(), "shortDescription"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"shortDescription",
            	    	        		lv_shortDescription_9_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22401); 

            	            createLeafNode(grammarAccess.getObject2Access().getSemicolonKeyword_5_0_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1287:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1287:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1288:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1288:104: ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1289:6: ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1292:6: ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1292:8: 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleObject22463); 

            	            createLeafNode(grammarAccess.getObject2Access().getLongDescriptionKeyword_5_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1296:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1297:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1297:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1298:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject22480); 

            	    			createLeafNode(grammarAccess.getObject2Access().getLongDescriptionSTRINGTerminalRuleCall_5_1_1_0(), "longDescription"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"longDescription",
            	    	        		lv_longDescription_12_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22495); 

            	            createLeafNode(grammarAccess.getObject2Access().getSemicolonKeyword_5_1_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1331:4: ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1331:4: ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1332:5: {...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1332:104: ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1333:6: ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1336:6: ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1336:8: 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';'
            	    {
            	    match(input,22,FollowSets000.FOLLOW_22_in_ruleObject22557); 

            	            createLeafNode(grammarAccess.getObject2Access().getSerialUIDKeyword_5_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1340:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1341:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1341:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1342:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject22574); 

            	    			createLeafNode(grammarAccess.getObject2Access().getSerialVersionUIDINTTerminalRuleCall_5_2_1_0(), "serialVersionUID"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"serialVersionUID",
            	    	        		lv_serialVersionUID_15_0, 
            	    	        		"INT", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22589); 

            	            createLeafNode(grammarAccess.getObject2Access().getSemicolonKeyword_5_2_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1375:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1375:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1376:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1376:104: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1377:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1380:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1380:7: ( (lv_cloneable_17_0= 'cloneable' ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1380:7: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1381:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1381:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1382:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)input.LT(1);
            	    match(input,23,FollowSets000.FOLLOW_23_in_ruleObject22659); 

            	            createLeafNode(grammarAccess.getObject2Access().getCloneableCloneableKeyword_5_3_0_0(), "cloneable"); 
            	        

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		set(current, "cloneable", true, "cloneable", lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject22682); 

            	            createLeafNode(grammarAccess.getObject2Access().getSemicolonKeyword_5_3_1(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1412:4: ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1412:4: ({...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1413:5: {...}? => ( ( (lv_features_19_0= ruleFeature2 ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleObject2", "getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1413:104: ( ( (lv_features_19_0= ruleFeature2 ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1414:6: ( (lv_features_19_0= ruleFeature2 ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1417:6: ( (lv_features_19_0= ruleFeature2 ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==29) ) {
            	            int LA17_6 = input.LA(2);

            	            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            	                alt17=1;
            	            }


            	        }
            	        else if ( (LA17_0==30) ) {
            	            int LA17_7 = input.LA(2);

            	            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObject2Access().getUnorderedGroup_5(), 4) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1418:1: (lv_features_19_0= ruleFeature2 )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1418:1: (lv_features_19_0= ruleFeature2 )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1419:3: lv_features_19_0= ruleFeature2
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObject2Access().getFeaturesFeature2ParserRuleCall_5_4_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_ruleObject22754);
            	    	    lv_features_19_0=ruleFeature2();
            	    	    _fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getObject2Rule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"features",
            	    	    	        		lv_features_19_0, 
            	    	    	        		"Feature2", 
            	    	    	        		currentNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	        currentNode = currentNode.getParent();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getObject2Access().getUnorderedGroup_5());
            	

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleObject22804); 

                    createLeafNode(grammarAccess.getObject2Access().getRightCurlyBracketKeyword_6(), null); 
                

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
    // $ANTLR end ruleObject2


    // $ANTLR start entryRuleFeature2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1467:1: entryRuleFeature2 returns [EObject current=null] : iv_ruleFeature2= ruleFeature2 EOF ;
    public final EObject entryRuleFeature2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1468:2: (iv_ruleFeature2= ruleFeature2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1469:2: iv_ruleFeature2= ruleFeature2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeature2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature2_in_entryRuleFeature22840);
            iv_ruleFeature2=ruleFeature2();
            _fsp--;

             current =iv_ruleFeature2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature22850); 

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
    // $ANTLR end entryRuleFeature2


    // $ANTLR start ruleFeature2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1476:1: ruleFeature2 returns [EObject current=null] : (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 ) ;
    public final EObject ruleFeature2() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute2_0 = null;

        EObject this_Reference2_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1481:6: ( (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1482:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1482:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            else if ( (LA19_0==30) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1482:1: (this_Attribute2_0= ruleAttribute2 | this_Reference2_1= ruleReference2 )", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1483:5: this_Attribute2_0= ruleAttribute2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeature2Access().getAttribute2ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_ruleFeature22897);
                    this_Attribute2_0=ruleAttribute2();
                    _fsp--;

                     
                            current = this_Attribute2_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1493:5: this_Reference2_1= ruleReference2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeature2Access().getReference2ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReference2_in_ruleFeature22924);
                    this_Reference2_1=ruleReference2();
                    _fsp--;

                     
                            current = this_Reference2_1; 
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
    // $ANTLR end ruleFeature2


    // $ANTLR start entryRuleAttribute2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1509:1: entryRuleAttribute2 returns [EObject current=null] : iv_ruleAttribute2= ruleAttribute2 EOF ;
    public final EObject entryRuleAttribute2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1510:2: (iv_ruleAttribute2= ruleAttribute2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1511:2: iv_ruleAttribute2= ruleAttribute2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttribute2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute2_in_entryRuleAttribute22959);
            iv_ruleAttribute2=ruleAttribute2();
            _fsp--;

             current =iv_ruleAttribute2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute22969); 

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
    // $ANTLR end entryRuleAttribute2


    // $ANTLR start ruleAttribute2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1518:1: ruleAttribute2 returns [EObject current=null] : ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) ;
    public final EObject ruleAttribute2() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Token lv_name_2_0=null;
        Token lv_shortDescription_6_0=null;
        Token lv_longDescription_9_0=null;
        Token lv_required_12_0=null;
        Token lv_technical_14_0=null;
        EObject lv_constraintDefinitions_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1523:6: ( ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1524:1: ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1524:1: ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1524:3: 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleAttribute23004); 

                    createLeafNode(grammarAccess.getAttribute2Access().getAttributeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1528:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1529:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1529:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1530:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute23021); 

            			createLeafNode(grammarAccess.getAttribute2Access().getTypeIDTerminalRuleCall_1_0(), "type"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1552:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1553:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1553:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1554:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute23043); 

            			createLeafNode(grammarAccess.getAttribute2Access().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1576:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            else if ( (LA22_0==14) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1576:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1576:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1576:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1576:5: '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) ) '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleAttribute23060); 

                            createLeafNode(grammarAccess.getAttribute2Access().getLeftCurlyBracketKeyword_3_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1580:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1582:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1582:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1583:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1586:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1587:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1587:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) ) | ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) ) )*
                    loop21:
                    do {
                        int alt21=6;
                        int LA21_0 = input.LA(1);

                        if ( LA21_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                            alt21=1;
                        }
                        else if ( LA21_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                            alt21=2;
                        }
                        else if ( LA21_0==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                            alt21=3;
                        }
                        else if ( LA21_0==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                            alt21=4;
                        }
                        else if ( LA21_0==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                            alt21=5;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1589:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1589:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1590:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1590:111: ( ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1591:6: ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 0);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1594:6: ( 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1594:8: 'shortDescription' ( (lv_shortDescription_6_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleAttribute23113); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getShortDescriptionKeyword_3_0_1_0_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1598:1: ( (lv_shortDescription_6_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1599:1: (lv_shortDescription_6_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1599:1: (lv_shortDescription_6_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1600:3: lv_shortDescription_6_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_6_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute23130); 

                    	    			createLeafNode(grammarAccess.getAttribute2Access().getShortDescriptionSTRINGTerminalRuleCall_3_0_1_0_1_0(), "shortDescription"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"shortDescription",
                    	    	        		lv_shortDescription_6_0, 
                    	    	        		"STRING", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23145); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_0_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1633:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1633:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1634:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1634:111: ( ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1635:6: ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 1);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1638:6: ( 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1638:8: 'longDescription' ( (lv_longDescription_9_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleAttribute23207); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getLongDescriptionKeyword_3_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1642:1: ( (lv_longDescription_9_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1643:1: (lv_longDescription_9_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1643:1: (lv_longDescription_9_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1644:3: lv_longDescription_9_0= RULE_STRING
                    	    {
                    	    lv_longDescription_9_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAttribute23224); 

                    	    			createLeafNode(grammarAccess.getAttribute2Access().getLongDescriptionSTRINGTerminalRuleCall_3_0_1_1_1_0(), "longDescription"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"longDescription",
                    	    	        		lv_longDescription_9_0, 
                    	    	        		"STRING", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23239); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_1_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1677:4: ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1677:4: ({...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1678:5: {...}? => ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1678:111: ( ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+ )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1679:6: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1682:6: ( (lv_constraintDefinitions_11_0= ruleConstraintDefinition ) )+
                    	    int cnt20=0;
                    	    loop20:
                    	    do {
                    	        int alt20=2;
                    	        int LA20_0 = input.LA(1);

                    	        if ( (LA20_0==34) ) {
                    	            int LA20_4 = input.LA(2);

                    	            if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 2) ) {
                    	                alt20=1;
                    	            }


                    	        }


                    	        switch (alt20) {
                    	    	case 1 :
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1683:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
                    	    	    {
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1683:1: (lv_constraintDefinitions_11_0= ruleConstraintDefinition )
                    	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1684:3: lv_constraintDefinitions_11_0= ruleConstraintDefinition
                    	    	    {
                    	    	     
                    	    	    	        currentNode=createCompositeNode(grammarAccess.getAttribute2Access().getConstraintDefinitionsConstraintDefinitionParserRuleCall_3_0_1_2_0(), currentNode); 
                    	    	    	    
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_ruleAttribute23311);
                    	    	    lv_constraintDefinitions_11_0=ruleConstraintDefinition();
                    	    	    _fsp--;


                    	    	    	        if (current==null) {
                    	    	    	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	    	        }
                    	    	    	        try {
                    	    	    	       		add(
                    	    	    	       			current, 
                    	    	    	       			"constraintDefinitions",
                    	    	    	        		lv_constraintDefinitions_11_0, 
                    	    	    	        		"ConstraintDefinition", 
                    	    	    	        		currentNode);
                    	    	    	        } catch (ValueConverterException vce) {
                    	    	    				handleValueConverterException(vce);
                    	    	    	        }
                    	    	    	        currentNode = currentNode.getParent();
                    	    	    	    

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt20 >= 1 ) break loop20;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(20, input);
                    	                throw eee;
                    	        }
                    	        cnt20++;
                    	    } while (true);

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1713:4: ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1713:4: ({...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:5: {...}? => ( ( ( (lv_required_12_0= 'required' ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3) ) {
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1714:111: ( ( ( (lv_required_12_0= 'required' ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1715:6: ( ( (lv_required_12_0= 'required' ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 3);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1718:6: ( ( (lv_required_12_0= 'required' ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1718:7: ( (lv_required_12_0= 'required' ) ) ';'
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1718:7: ( (lv_required_12_0= 'required' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1719:1: (lv_required_12_0= 'required' )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1719:1: (lv_required_12_0= 'required' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1720:3: lv_required_12_0= 'required'
                    	    {
                    	    lv_required_12_0=(Token)input.LT(1);
                    	    match(input,32,FollowSets000.FOLLOW_32_in_ruleAttribute23381); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getRequiredRequiredKeyword_3_0_1_3_0_0(), "required"); 
                    	        

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		set(current, "required", true, "required", lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23404); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_3_1(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1750:4: ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1750:4: ({...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1751:5: {...}? => ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4) ) {
                    	        throw new FailedPredicateException(input, "ruleAttribute2", "getUnorderedGroupHelper().canSelect(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1751:111: ( ( ( (lv_technical_14_0= 'technical' ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1752:6: ( ( (lv_technical_14_0= 'technical' ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1(), 4);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1755:6: ( ( (lv_technical_14_0= 'technical' ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1755:7: ( (lv_technical_14_0= 'technical' ) ) ';'
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1755:7: ( (lv_technical_14_0= 'technical' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1756:1: (lv_technical_14_0= 'technical' )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1756:1: (lv_technical_14_0= 'technical' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1757:3: lv_technical_14_0= 'technical'
                    	    {
                    	    lv_technical_14_0=(Token)input.LT(1);
                    	    match(input,33,FollowSets000.FOLLOW_33_in_ruleAttribute23474); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getTechnicalTechnicalKeyword_3_0_1_4_0_0(), "technical"); 
                    	        

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getAttribute2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        
                    	    	        try {
                    	    	       		set(current, "technical", true, "technical", lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23497); 

                    	            createLeafNode(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_0_1_4_1(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getAttribute2Access().getUnorderedGroup_3_0_1());
                    	

                    }

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleAttribute23547); 

                            createLeafNode(grammarAccess.getAttribute2Access().getRightCurlyBracketKeyword_3_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1799:7: ';'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleAttribute23564); 

                            createLeafNode(grammarAccess.getAttribute2Access().getSemicolonKeyword_3_1(), null); 
                        

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
    // $ANTLR end ruleAttribute2


    // $ANTLR start entryRuleReference2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1811:1: entryRuleReference2 returns [EObject current=null] : iv_ruleReference2= ruleReference2 EOF ;
    public final EObject entryRuleReference2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference2 = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1812:2: (iv_ruleReference2= ruleReference2 EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1813:2: iv_ruleReference2= ruleReference2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReference2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReference2_in_entryRuleReference23601);
            iv_ruleReference2=ruleReference2();
            _fsp--;

             current =iv_ruleReference2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference23611); 

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
    // $ANTLR end entryRuleReference2


    // $ANTLR start ruleReference2
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1820:1: ruleReference2 returns [EObject current=null] : ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) ;
    public final EObject ruleReference2() throws RecognitionException {
        EObject current = null;

        Token lv_many_2_0=null;
        Token lv_name_3_0=null;
        Token lv_shortDescription_7_0=null;
        Token lv_longDescription_10_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1825:6: ( ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1826:1: ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1826:1: ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1826:3: 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            {
            match(input,30,FollowSets000.FOLLOW_30_in_ruleReference23646); 

                    createLeafNode(grammarAccess.getReference2Access().getReferenceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1830:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1831:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1832:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference23664); 

            		createLeafNode(grammarAccess.getReference2Access().getTypeObjectCrossReference_1_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1844:2: ( (lv_many_2_0= '*' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==31) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1845:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1845:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1846:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)input.LT(1);
                    match(input,31,FollowSets000.FOLLOW_31_in_ruleReference23682); 

                            createLeafNode(grammarAccess.getReference2Access().getManyAsteriskKeyword_2_0(), "many"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "many", true, "*", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1865:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1866:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1866:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1867:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference23713); 

            			createLeafNode(grammarAccess.getReference2Access().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_3_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1889:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==19) ) {
                alt25=1;
            }
            else if ( (LA25_0==14) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1889:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1889:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1889:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1889:5: '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleReference23730); 

                            createLeafNode(grammarAccess.getReference2Access().getLeftCurlyBracketKeyword_4_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1893:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1895:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1895:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1896:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
                    	
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1899:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1900:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1900:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )*
                    loop24:
                    do {
                        int alt24=3;
                        int LA24_0 = input.LA(1);

                        if ( LA24_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                            alt24=1;
                        }
                        else if ( LA24_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                            alt24=2;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1902:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1902:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1903:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleReference2", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1903:111: ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1904:6: ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 0);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1907:6: ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1907:8: 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,20,FollowSets000.FOLLOW_20_in_ruleReference23783); 

                    	            createLeafNode(grammarAccess.getReference2Access().getShortDescriptionKeyword_4_0_1_0_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1911:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1912:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1912:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1913:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference23800); 

                    	    			createLeafNode(grammarAccess.getReference2Access().getShortDescriptionSTRINGTerminalRuleCall_4_0_1_0_1_0(), "shortDescription"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"shortDescription",
                    	    	        		lv_shortDescription_7_0, 
                    	    	        		"STRING", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleReference23815); 

                    	            createLeafNode(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_0_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1946:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1946:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1947:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleReference2", "getUnorderedGroupHelper().canSelect(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1947:111: ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1948:6: ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1(), 1);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1951:6: ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1951:8: 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,21,FollowSets000.FOLLOW_21_in_ruleReference23877); 

                    	            createLeafNode(grammarAccess.getReference2Access().getLongDescriptionKeyword_4_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1955:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1956:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1956:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:1957:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference23894); 

                    	    			createLeafNode(grammarAccess.getReference2Access().getLongDescriptionSTRINGTerminalRuleCall_4_0_1_1_1_0(), "longDescription"); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getReference2Rule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode, current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"longDescription",
                    	    	        		lv_longDescription_10_0, 
                    	    	        		"STRING", 
                    	    	        		lastConsumedNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	    

                    	    }


                    	    }

                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleReference23909); 

                    	            createLeafNode(grammarAccess.getReference2Access().getSemicolonKeyword_4_0_1_1_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getReference2Access().getUnorderedGroup_4_0_1());
                    	

                    }

                    match(input,28,FollowSets000.FOLLOW_28_in_ruleReference23959); 

                            createLeafNode(grammarAccess.getReference2Access().getRightCurlyBracketKeyword_4_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2002:7: ';'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleReference23976); 

                            createLeafNode(grammarAccess.getReference2Access().getSemicolonKeyword_4_1(), null); 
                        

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
    // $ANTLR end ruleReference2


    // $ANTLR start entryRuleConstraintDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2014:1: entryRuleConstraintDefinition returns [EObject current=null] : iv_ruleConstraintDefinition= ruleConstraintDefinition EOF ;
    public final EObject entryRuleConstraintDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintDefinition = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2015:2: (iv_ruleConstraintDefinition= ruleConstraintDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2016:2: iv_ruleConstraintDefinition= ruleConstraintDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConstraintDefinitionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition4013);
            iv_ruleConstraintDefinition=ruleConstraintDefinition();
            _fsp--;

             current =iv_ruleConstraintDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstraintDefinition4023); 

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
    // $ANTLR end entryRuleConstraintDefinition


    // $ANTLR start ruleConstraintDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2023:1: ruleConstraintDefinition returns [EObject current=null] : ( 'constraint' ( (lv_type_1_0= RULE_ID ) ) '{' ( ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) ) ) '}' ) ;
    public final EObject ruleConstraintDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Token lv_parameters_5_0=null;
        Token lv_message_8_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2028:6: ( ( 'constraint' ( (lv_type_1_0= RULE_ID ) ) '{' ( ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) ) ) '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2029:1: ( 'constraint' ( (lv_type_1_0= RULE_ID ) ) '{' ( ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) ) ) '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2029:1: ( 'constraint' ( (lv_type_1_0= RULE_ID ) ) '{' ( ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) ) ) '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2029:3: 'constraint' ( (lv_type_1_0= RULE_ID ) ) '{' ( ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) ) ) '}'
            {
            match(input,34,FollowSets000.FOLLOW_34_in_ruleConstraintDefinition4058); 

                    createLeafNode(grammarAccess.getConstraintDefinitionAccess().getConstraintKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2033:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2034:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2034:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2035:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConstraintDefinition4075); 

            			createLeafNode(grammarAccess.getConstraintDefinitionAccess().getTypeIDTerminalRuleCall_1_0(), "type"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConstraintDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,19,FollowSets000.FOLLOW_19_in_ruleConstraintDefinition4090); 

                    createLeafNode(grammarAccess.getConstraintDefinitionAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2061:1: ( ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2063:1: ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2063:1: ( ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2064:2: ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2067:2: ( ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?)
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2068:3: ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+ {...}?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2068:3: ( ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) ) | ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) ) )+
            int cnt27=0;
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( LA27_0==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
                    alt27=1;
                }
                else if ( LA27_0==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
                    alt27=2;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2070:4: ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2070:4: ({...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2071:5: {...}? => ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2071:117: ( ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2072:6: ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2075:6: ( 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2075:8: 'parameters' ( (lv_parameters_5_0= RULE_STRING ) )* ';'
            	    {
            	    match(input,35,FollowSets000.FOLLOW_35_in_ruleConstraintDefinition4143); 

            	            createLeafNode(grammarAccess.getConstraintDefinitionAccess().getParametersKeyword_3_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2079:1: ( (lv_parameters_5_0= RULE_STRING ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==RULE_STRING) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2080:1: (lv_parameters_5_0= RULE_STRING )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2080:1: (lv_parameters_5_0= RULE_STRING )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2081:3: lv_parameters_5_0= RULE_STRING
            	    	    {
            	    	    lv_parameters_5_0=(Token)input.LT(1);
            	    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConstraintDefinition4160); 

            	    	    			createLeafNode(grammarAccess.getConstraintDefinitionAccess().getParametersSTRINGTerminalRuleCall_3_0_1_0(), "parameters"); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = factory.create(grammarAccess.getConstraintDefinitionRule().getType().getClassifier());
            	    	    	            associateNodeWithAstElement(currentNode, current);
            	    	    	        }
            	    	    	        try {
            	    	    	       		add(
            	    	    	       			current, 
            	    	    	       			"parameters",
            	    	    	        		lv_parameters_5_0, 
            	    	    	        		"STRING", 
            	    	    	        		lastConsumedNode);
            	    	    	        } catch (ValueConverterException vce) {
            	    	    				handleValueConverterException(vce);
            	    	    	        }
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleConstraintDefinition4176); 

            	            createLeafNode(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_0_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2114:4: ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2114:4: ({...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2115:5: {...}? => ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canSelect(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2115:117: ( ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2116:6: ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2119:6: ( 'message' ( (lv_message_8_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2119:8: 'message' ( (lv_message_8_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,36,FollowSets000.FOLLOW_36_in_ruleConstraintDefinition4238); 

            	            createLeafNode(grammarAccess.getConstraintDefinitionAccess().getMessageKeyword_3_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2123:1: ( (lv_message_8_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2124:1: (lv_message_8_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2124:1: (lv_message_8_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:2125:3: lv_message_8_0= RULE_STRING
            	    {
            	    lv_message_8_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleConstraintDefinition4255); 

            	    			createLeafNode(grammarAccess.getConstraintDefinitionAccess().getMessageSTRINGTerminalRuleCall_3_1_1_0(), "message"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getConstraintDefinitionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"message",
            	    	        		lv_message_8_0, 
            	    	        		"STRING", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }

            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleConstraintDefinition4270); 

            	            createLeafNode(grammarAccess.getConstraintDefinitionAccess().getSemicolonKeyword_3_1_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleConstraintDefinition", "getUnorderedGroupHelper().canLeave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getConstraintDefinitionAccess().getUnorderedGroup_3());
            	

            }

            match(input,28,FollowSets000.FOLLOW_28_in_ruleConstraintDefinition4326); 

                    createLeafNode(grammarAccess.getConstraintDefinitionAccess().getRightCurlyBracketKeyword_4(), null); 
                

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
    // $ANTLR end ruleConstraintDefinition


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA7_eotS =
        "\35\uffff";
    static final String DFA7_eofS =
        "\35\uffff";
    static final String DFA7_minS =
        "\1\24\5\uffff\2\4\3\uffff\2\4\1\16\1\4\1\16\1\0\1\24\1\0\1\uffff"+
        "\2\5\1\0\2\16\2\24\2\0";
    static final String DFA7_maxS =
        "\1\36\5\uffff\2\4\3\uffff\1\4\1\37\1\16\1\4\1\23\1\0\1\34\1\0\1"+
        "\uffff\2\5\1\0\2\16\2\34\2\0";
    static final String DFA7_acceptS =
        "\1\uffff\5\2\2\uffff\3\2\10\uffff\1\1\11\uffff";
    static final String DFA7_specialS =
        "\1\1\17\uffff\1\2\1\uffff\1\0\3\uffff\1\5\4\uffff\1\4\1\3}>";
    static final String[] DFA7_transitionS = {
            "\1\2\1\3\1\4\1\5\1\10\1\uffff\1\11\1\12\1\1\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\14",
            "",
            "",
            "",
            "\1\15",
            "\1\17\32\uffff\1\16",
            "\1\20",
            "\1\17",
            "\1\22\4\uffff\1\21",
            "\1\uffff",
            "\1\24\1\25\6\uffff\1\26",
            "\1\uffff",
            "",
            "\1\27",
            "\1\30",
            "\1\uffff",
            "\1\31",
            "\1\32",
            "\1\24\1\25\6\uffff\1\33",
            "\1\24\1\25\6\uffff\1\34",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()* loopback of 622:1: ( (lv_features_24_0= ruleFeature ) )*";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_18 = input.LA(1);

                         
                        int index7_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index7_18);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_0 = input.LA(1);

                         
                        int index7_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA7_0==28) ) {s = 1;}

                        else if ( LA7_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA7_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA7_0==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA7_0==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( (LA7_0==29) ) {s = 6;}

                        else if ( (LA7_0==30) ) {s = 7;}

                        else if ( LA7_0==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 8;}

                        else if ( LA7_0==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 9;}

                        else if ( LA7_0==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 10;}

                         
                        input.seek(index7_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_16 = input.LA(1);

                         
                        int index7_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index7_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_28 = input.LA(1);

                         
                        int index7_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index7_28);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_27 = input.LA(1);

                         
                        int index7_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index7_27);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_22 = input.LA(1);

                         
                        int index7_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index7_22);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA8_eotS =
        "\36\uffff";
    static final String DFA8_eofS =
        "\36\uffff";
    static final String DFA8_minS =
        "\1\24\5\uffff\2\4\3\uffff\2\4\1\16\1\4\1\16\1\0\1\24\1\0\1\uffff"+
        "\2\5\1\0\1\uffff\2\16\2\24\2\0";
    static final String DFA8_maxS =
        "\1\36\5\uffff\2\4\3\uffff\1\4\1\37\1\16\1\4\1\23\1\0\1\34\1\0\1"+
        "\uffff\2\5\1\0\1\uffff\2\16\2\34\2\0";
    static final String DFA8_acceptS =
        "\1\uffff\5\2\2\uffff\3\2\10\uffff\1\1\3\uffff\1\1\6\uffff";
    static final String DFA8_specialS =
        "\1\2\17\uffff\1\0\1\uffff\1\1\3\uffff\1\5\5\uffff\1\4\1\3}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\3\1\4\1\5\1\10\1\uffff\1\11\1\12\1\1\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\14",
            "",
            "",
            "",
            "\1\15",
            "\1\17\32\uffff\1\16",
            "\1\20",
            "\1\17",
            "\1\22\4\uffff\1\21",
            "\1\uffff",
            "\1\24\1\25\6\uffff\1\26",
            "\1\uffff",
            "",
            "\1\30",
            "\1\31",
            "\1\uffff",
            "",
            "\1\32",
            "\1\33",
            "\1\24\1\25\6\uffff\1\34",
            "\1\24\1\25\6\uffff\1\35",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()+ loopback of 662:1: ( (lv_features_26_0= ruleFeature ) )+";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_16 = input.LA(1);

                         
                        int index8_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index8_16);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA8_18 = input.LA(1);

                         
                        int index8_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 23;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index8_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA8_0 = input.LA(1);

                         
                        int index8_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA8_0==28) ) {s = 1;}

                        else if ( LA8_0==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA8_0==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA8_0==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA8_0==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( (LA8_0==29) ) {s = 6;}

                        else if ( (LA8_0==30) ) {s = 7;}

                        else if ( LA8_0==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5) ) {s = 8;}

                        else if ( LA8_0==26 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6) ) {s = 9;}

                        else if ( LA8_0==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7) ) {s = 10;}

                         
                        input.seek(index8_0);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA8_29 = input.LA(1);

                         
                        int index8_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index8_29);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA8_28 = input.LA(1);

                         
                        int index8_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index8_28);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA8_22 = input.LA(1);

                         
                        int index8_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 19;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4) ) {s = 10;}

                         
                        input.seek(index8_22);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleModel121 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rulePackageDefinition_in_ruleModel142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleModel160 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_ruleModel181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition218 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePackageDefinition272 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePackageDefinition289 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_rulePackageDefinition304 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject_in_rulePackageDefinition325 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject_in_entryRuleObject362 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleObject416 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleObject453 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleObject478 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject495 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleObject511 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject529 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleObject541 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_20_in_ruleObject594 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject611 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject626 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_21_in_ruleObject688 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject705 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject720 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_22_in_ruleObject782 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject799 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject814 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_23_in_ruleObject884 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject907 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject979 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_24_in_ruleObject1041 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1062 = new BitSet(new long[]{0x0000000062000000L});
        public static final BitSet FOLLOW_25_in_ruleObject1073 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_26_in_ruleObject1135 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1156 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_27_in_ruleObject1219 = new BitSet(new long[]{0x0000000060000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1240 = new BitSet(new long[]{0x000000007DF00000L});
        public static final BitSet FOLLOW_28_in_ruleObject1291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1327 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature1337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleFeature1384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleFeature1411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1446 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAttribute1491 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1508 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1530 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute1545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1581 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference1591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleReference1626 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1644 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_31_in_ruleReference1662 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1693 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleReference1710 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_20_in_ruleReference1763 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1780 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference1795 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_21_in_ruleReference1857 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1874 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference1889 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_28_in_ruleReference1939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference1956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePackageDefinition2_in_entryRulePackageDefinition21993 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition22003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rulePackageDefinition22047 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePackageDefinition22064 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_rulePackageDefinition22079 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject2_in_rulePackageDefinition22100 = new BitSet(new long[]{0x0000000000038002L});
        public static final BitSet FOLLOW_ruleObject2_in_entryRuleObject22137 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject22147 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleObject22191 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_16_in_ruleObject22228 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleObject22253 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject22270 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_18_in_ruleObject22286 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject22304 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleObject22316 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_20_in_ruleObject22369 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject22386 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22401 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_21_in_ruleObject22463 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject22480 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22495 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_22_in_ruleObject22557 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject22574 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22589 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_23_in_ruleObject22659 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObject22682 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_ruleFeature2_in_ruleObject22754 = new BitSet(new long[]{0x0000000070F00000L});
        public static final BitSet FOLLOW_28_in_ruleObject22804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature2_in_entryRuleFeature22840 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature22850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_ruleFeature22897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_ruleFeature22924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute2_in_entryRuleAttribute22959 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute22969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleAttribute23004 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute23021 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute23043 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleAttribute23060 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_20_in_ruleAttribute23113 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute23130 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23145 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_21_in_ruleAttribute23207 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute23224 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23239 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_ruleAttribute23311 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_32_in_ruleAttribute23381 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23404 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_33_in_ruleAttribute23474 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23497 = new BitSet(new long[]{0x0000000710300000L});
        public static final BitSet FOLLOW_28_in_ruleAttribute23547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleAttribute23564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference2_in_entryRuleReference23601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference23611 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleReference23646 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference23664 = new BitSet(new long[]{0x0000000080000010L});
        public static final BitSet FOLLOW_31_in_ruleReference23682 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference23713 = new BitSet(new long[]{0x0000000000084000L});
        public static final BitSet FOLLOW_19_in_ruleReference23730 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_20_in_ruleReference23783 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference23800 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference23815 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_21_in_ruleReference23877 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference23894 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReference23909 = new BitSet(new long[]{0x0000000010300000L});
        public static final BitSet FOLLOW_28_in_ruleReference23959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference23976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraintDefinition_in_entryRuleConstraintDefinition4013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstraintDefinition4023 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleConstraintDefinition4058 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConstraintDefinition4075 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleConstraintDefinition4090 = new BitSet(new long[]{0x0000001800000000L});
        public static final BitSet FOLLOW_35_in_ruleConstraintDefinition4143 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintDefinition4160 = new BitSet(new long[]{0x0000000000004020L});
        public static final BitSet FOLLOW_14_in_ruleConstraintDefinition4176 = new BitSet(new long[]{0x0000001810000000L});
        public static final BitSet FOLLOW_36_in_ruleConstraintDefinition4238 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleConstraintDefinition4255 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConstraintDefinition4270 = new BitSet(new long[]{0x0000001810000000L});
        public static final BitSet FOLLOW_28_in_ruleConstraintDefinition4326 = new BitSet(new long[]{0x0000000000000002L});
    }


}
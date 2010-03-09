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

public class InternalBug304681TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "';'", "'enabled'", "'abstract'", "'object'", "'extends'", "'{'", "'shortDescription'", "'longDescription'", "'serialUID'", "'cloneable'", "'before'", "'after'", "'optionalLoop'", "'mandatoryLoop'", "'}'", "'Attribute'", "'Reference'", "'*'"
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
        	return "PackageDefinition";	
       	} 



    // $ANTLR start entryRulePackageDefinition
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:72:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:73:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:74:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPackageDefinitionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition75);
            iv_rulePackageDefinition=rulePackageDefinition();
            _fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePackageDefinition85); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:81:1: rulePackageDefinition returns [EObject current=null] : ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_namespace_2_0=null;
        EObject lv_contents_4_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:86:6: ( ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:1: ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:1: ( () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:2: () 'package' ( (lv_namespace_2_0= RULE_ID ) ) ';' ( (lv_contents_4_0= ruleObject ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:87:2: ()
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:88:5: 
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

            match(input,11,FollowSets000.FOLLOW_11_in_rulePackageDefinition129); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getPackageKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:102:1: ( (lv_namespace_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:103:1: (lv_namespace_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:103:1: (lv_namespace_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:104:3: lv_namespace_2_0= RULE_ID
            {
            lv_namespace_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rulePackageDefinition146); 

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

            match(input,12,FollowSets000.FOLLOW_12_in_rulePackageDefinition161); 

                    createLeafNode(grammarAccess.getPackageDefinitionAccess().getSemicolonKeyword_3(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:130:1: ( (lv_contents_4_0= ruleObject ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:131:1: (lv_contents_4_0= ruleObject )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:131:1: (lv_contents_4_0= ruleObject )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:132:3: lv_contents_4_0= ruleObject
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getPackageDefinitionAccess().getContentsObjectParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleObject_in_rulePackageDefinition182);
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
    // $ANTLR end rulePackageDefinition


    // $ANTLR start entryRuleObject
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:162:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:163:2: (iv_ruleObject= ruleObject EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:164:2: iv_ruleObject= ruleObject EOF
            {
             currentNode = createCompositeNode(grammarAccess.getObjectRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleObject_in_entryRuleObject219);
            iv_ruleObject=ruleObject();
            _fsp--;

             current =iv_ruleObject; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObject229); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:171:1: ruleObject returns [EObject current=null] : ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' ) ;
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


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:176:6: ( ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:177:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:177:1: ( ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:177:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )? 'object' ( (lv_name_3_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) ) '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:177:2: ( ( (lv_enabled_0_0= 'enabled' ) ) | ( (lv_abstract_1_0= 'abstract' ) ) )?
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:177:3: ( (lv_enabled_0_0= 'enabled' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:177:3: ( (lv_enabled_0_0= 'enabled' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:178:1: (lv_enabled_0_0= 'enabled' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:178:1: (lv_enabled_0_0= 'enabled' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:179:3: lv_enabled_0_0= 'enabled'
                    {
                    lv_enabled_0_0=(Token)input.LT(1);
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleObject273); 

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
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:199:6: ( (lv_abstract_1_0= 'abstract' ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:199:6: ( (lv_abstract_1_0= 'abstract' ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:200:1: (lv_abstract_1_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:200:1: (lv_abstract_1_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:201:3: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)input.LT(1);
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleObject310); 

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

            match(input,15,FollowSets000.FOLLOW_15_in_ruleObject335); 

                    createLeafNode(grammarAccess.getObjectAccess().getObjectKeyword_1(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:224:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:225:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:225:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:226:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject352); 

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:248:2: ( 'extends' ( ( RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:248:4: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleObject368); 

                            createLeafNode(grammarAccess.getObjectAccess().getExtendsKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:252:1: ( ( RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:253:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:253:1: ( RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:254:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getObjectRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObject386); 

                    		createLeafNode(grammarAccess.getObjectAccess().getParentObjectCrossReference_3_1_0(), "parent"); 
                    	

                    }


                    }


                    }
                    break;

            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleObject398); 

                    createLeafNode(grammarAccess.getObjectAccess().getLeftCurlyBracketKeyword_4(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:270:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:272:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:272:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:273:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:276:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:277:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) ) | ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) ) | ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) ) | ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) ) | ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) ) | ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) ) )*
            loop8:
            do {
                int alt8=9;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {
                    alt8=1;
                }
                else if ( (LA8_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {
                    alt8=2;
                }
                else if ( (LA8_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {
                    alt8=3;
                }
                else if ( (LA8_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {
                    alt8=4;
                }
                else if ( ((LA8_0>=27 && LA8_0<=28)) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) {
                    alt8=5;
                }
                else if ( (LA8_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {
                    alt8=6;
                }
                else if ( (LA8_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {
                    alt8=7;
                }
                else if ( (LA8_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {
                    alt8=8;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:279:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:279:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:280:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:280:103: ( ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:281:6: ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:284:6: ( 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:284:8: 'shortDescription' ( (lv_shortDescription_9_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,18,FollowSets000.FOLLOW_18_in_ruleObject451); 

            	            createLeafNode(grammarAccess.getObjectAccess().getShortDescriptionKeyword_5_0_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:288:1: ( (lv_shortDescription_9_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:289:1: (lv_shortDescription_9_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:289:1: (lv_shortDescription_9_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:290:3: lv_shortDescription_9_0= RULE_STRING
            	    {
            	    lv_shortDescription_9_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject468); 

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

            	    match(input,12,FollowSets000.FOLLOW_12_in_ruleObject483); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_0_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:323:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:323:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:324:103: ( ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:325:6: ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:328:6: ( 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:328:8: 'longDescription' ( (lv_longDescription_12_0= RULE_STRING ) ) ';'
            	    {
            	    match(input,19,FollowSets000.FOLLOW_19_in_ruleObject545); 

            	            createLeafNode(grammarAccess.getObjectAccess().getLongDescriptionKeyword_5_1_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:332:1: ( (lv_longDescription_12_0= RULE_STRING ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:333:1: (lv_longDescription_12_0= RULE_STRING )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:333:1: (lv_longDescription_12_0= RULE_STRING )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:334:3: lv_longDescription_12_0= RULE_STRING
            	    {
            	    lv_longDescription_12_0=(Token)input.LT(1);
            	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleObject562); 

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

            	    match(input,12,FollowSets000.FOLLOW_12_in_ruleObject577); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_1_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:4: ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:367:4: ({...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:368:5: {...}? => ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:368:103: ( ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:369:6: ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:372:6: ( 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:372:8: 'serialUID' ( (lv_serialVersionUID_15_0= RULE_INT ) ) ';'
            	    {
            	    match(input,20,FollowSets000.FOLLOW_20_in_ruleObject639); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSerialUIDKeyword_5_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:376:1: ( (lv_serialVersionUID_15_0= RULE_INT ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:377:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:377:1: (lv_serialVersionUID_15_0= RULE_INT )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:378:3: lv_serialVersionUID_15_0= RULE_INT
            	    {
            	    lv_serialVersionUID_15_0=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleObject656); 

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

            	    match(input,12,FollowSets000.FOLLOW_12_in_ruleObject671); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_2_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:411:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:411:4: ({...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:412:5: {...}? => ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:412:103: ( ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:413:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:416:6: ( ( (lv_cloneable_17_0= 'cloneable' ) ) ';' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:416:7: ( (lv_cloneable_17_0= 'cloneable' ) ) ';'
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:416:7: ( (lv_cloneable_17_0= 'cloneable' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:417:1: (lv_cloneable_17_0= 'cloneable' )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:417:1: (lv_cloneable_17_0= 'cloneable' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:418:3: lv_cloneable_17_0= 'cloneable'
            	    {
            	    lv_cloneable_17_0=(Token)input.LT(1);
            	    match(input,21,FollowSets000.FOLLOW_21_in_ruleObject741); 

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

            	    match(input,12,FollowSets000.FOLLOW_12_in_ruleObject764); 

            	            createLeafNode(grammarAccess.getObjectAccess().getSemicolonKeyword_5_3_1(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:448:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:448:4: ({...}? => ( ( (lv_features_19_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:449:5: {...}? => ( ( (lv_features_19_0= ruleFeature ) )+ )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:449:103: ( ( (lv_features_19_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:450:6: ( (lv_features_19_0= ruleFeature ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:453:6: ( (lv_features_19_0= ruleFeature ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==27) ) {
            	            int LA4_6 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
            	                alt4=1;
            	            }


            	        }
            	        else if ( (LA4_0==28) ) {
            	            int LA4_7 = input.LA(2);

            	            if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:454:1: (lv_features_19_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:454:1: (lv_features_19_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:455:3: lv_features_19_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_4_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject836);
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
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:484:4: ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:484:4: ({...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:485:5: {...}? => ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:485:103: ( ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:486:6: ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:489:6: ( 'before' ( (lv_features_21_0= ruleFeature ) )* 'after' )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:489:8: 'before' ( (lv_features_21_0= ruleFeature ) )* 'after'
            	    {
            	    match(input,22,FollowSets000.FOLLOW_22_in_ruleObject898); 

            	            createLeafNode(grammarAccess.getObjectAccess().getBeforeKeyword_5_5_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:493:1: ( (lv_features_21_0= ruleFeature ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0>=27 && LA5_0<=28)) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:494:1: (lv_features_21_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:494:1: (lv_features_21_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:495:3: lv_features_21_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_5_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject919);
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
            	    	    break loop5;
            	        }
            	    } while (true);

            	    match(input,23,FollowSets000.FOLLOW_23_in_ruleObject930); 

            	            createLeafNode(grammarAccess.getObjectAccess().getAfterKeyword_5_5_2(), null); 
            	        

            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:528:4: ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:528:4: ({...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:529:5: {...}? => ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:529:103: ( ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:530:6: ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:533:6: ( 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )* )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:533:8: 'optionalLoop' ( (lv_features_24_0= ruleFeature ) )*
            	    {
            	    match(input,24,FollowSets000.FOLLOW_24_in_ruleObject992); 

            	            createLeafNode(grammarAccess.getObjectAccess().getOptionalLoopKeyword_5_6_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:537:1: ( (lv_features_24_0= ruleFeature ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        alt6 = dfa6.predict(input);
            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:1: (lv_features_24_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:538:1: (lv_features_24_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:539:3: lv_features_24_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_6_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1013);
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
            	    	    break loop6;
            	        }
            	    } while (true);


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:568:4: ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:568:4: ({...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:569:5: {...}? => ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    {
            	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)) ) {
            	        throw new FailedPredicateException(input, "ruleObject", "getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:569:103: ( ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ ) )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:570:6: ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:573:6: ( 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+ )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:573:8: 'mandatoryLoop' ( (lv_features_26_0= ruleFeature ) )+
            	    {
            	    match(input,25,FollowSets000.FOLLOW_25_in_ruleObject1076); 

            	            createLeafNode(grammarAccess.getObjectAccess().getMandatoryLoopKeyword_5_7_0(), null); 
            	        
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:577:1: ( (lv_features_26_0= ruleFeature ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        alt7 = dfa7.predict(input);
            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:578:1: (lv_features_26_0= ruleFeature )
            	    	    {
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:578:1: (lv_features_26_0= ruleFeature )
            	    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:579:3: lv_features_26_0= ruleFeature
            	    	    {
            	    	     
            	    	    	        currentNode=createCompositeNode(grammarAccess.getObjectAccess().getFeaturesFeatureParserRuleCall_5_7_1_0(), currentNode); 
            	    	    	    
            	    	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleObject1097);
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
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getObjectAccess().getUnorderedGroup_5());
            	

            }

            match(input,26,FollowSets000.FOLLOW_26_in_ruleObject1148); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:627:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:628:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:629:2: iv_ruleFeature= ruleFeature EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFeatureRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature1184);
            iv_ruleFeature=ruleFeature();
            _fsp--;

             current =iv_ruleFeature; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature1194); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:636:1: ruleFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_Reference_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:641:6: ( (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:642:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:642:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==27) ) {
                alt9=1;
            }
            else if ( (LA9_0==28) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("642:1: (this_Attribute_0= ruleAttribute | this_Reference_1= ruleReference )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:643:5: this_Attribute_0= ruleAttribute
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleFeature1241);
                    this_Attribute_0=ruleAttribute();
                    _fsp--;

                     
                            current = this_Attribute_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:653:5: this_Reference_1= ruleReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getFeatureAccess().getReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleFeature1268);
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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:669:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:670:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:671:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute1303);
            iv_ruleAttribute=ruleAttribute();
            _fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute1313); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:678:1: ruleAttribute returns [EObject current=null] : ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_type_1_0=null;
        Token lv_name_2_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:683:6: ( ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:684:1: ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:684:1: ( 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:684:3: 'Attribute' ( (lv_type_1_0= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) ';'
            {
            match(input,27,FollowSets000.FOLLOW_27_in_ruleAttribute1348); 

                    createLeafNode(grammarAccess.getAttributeAccess().getAttributeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:688:1: ( (lv_type_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:689:1: (lv_type_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:689:1: (lv_type_1_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:690:3: lv_type_1_0= RULE_ID
            {
            lv_type_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1365); 

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:712:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:713:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:713:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:714:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute1387); 

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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleAttribute1402); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:748:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:749:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:750:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference1438);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference1448); 

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
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:757:1: ruleReference returns [EObject current=null] : ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_many_2_0=null;
        Token lv_name_3_0=null;
        Token lv_shortDescription_7_0=null;
        Token lv_longDescription_10_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:762:6: ( ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:763:1: ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:763:1: ( 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:763:3: 'Reference' ( ( RULE_ID ) ) ( (lv_many_2_0= '*' ) )? ( (lv_name_3_0= RULE_ID ) ) ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            {
            match(input,28,FollowSets000.FOLLOW_28_in_ruleReference1483); 

                    createLeafNode(grammarAccess.getReferenceAccess().getReferenceKeyword_0(), null); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:767:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:768:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:768:1: ( RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:769:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1501); 

            		createLeafNode(grammarAccess.getReferenceAccess().getTypeObjectCrossReference_1_0(), "type"); 
            	

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:781:2: ( (lv_many_2_0= '*' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==29) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:782:1: (lv_many_2_0= '*' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:782:1: (lv_many_2_0= '*' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:783:3: lv_many_2_0= '*'
                    {
                    lv_many_2_0=(Token)input.LT(1);
                    match(input,29,FollowSets000.FOLLOW_29_in_ruleReference1519); 

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:802:3: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:803:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:803:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:804:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference1550); 

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

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==17) ) {
                alt12=1;
            }
            else if ( (LA12_0==12) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("826:2: ( ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' ) | ';' )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:3: ( '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:826:5: '{' ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) ) '}'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleReference1567); 

                            createLeafNode(grammarAccess.getReferenceAccess().getLeftCurlyBracketKeyword_4_0_0(), null); 
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:830:1: ( ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:832:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:832:1: ( ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:833:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* )
                    {
                     
                    	  getUnorderedGroupHelper().enter(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:836:2: ( ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )* )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:837:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )*
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:837:3: ( ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) ) | ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0))) {
                            alt11=1;
                        }
                        else if ( (LA11_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1))) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:839:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:839:4: ({...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:840:5: {...}? => ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)) ) {
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:840:110: ( ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:841:6: ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 0);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:844:6: ( 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:844:8: 'shortDescription' ( (lv_shortDescription_7_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,18,FollowSets000.FOLLOW_18_in_ruleReference1620); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getShortDescriptionKeyword_4_0_1_0_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:848:1: ( (lv_shortDescription_7_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:849:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:849:1: (lv_shortDescription_7_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:850:3: lv_shortDescription_7_0= RULE_STRING
                    	    {
                    	    lv_shortDescription_7_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1637); 

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

                    	    match(input,12,FollowSets000.FOLLOW_12_in_ruleReference1652); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_0_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:883:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:883:4: ({...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:884:5: {...}? => ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) )
                    	    {
                    	    if ( !(getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)) ) {
                    	        throw new FailedPredicateException(input, "ruleReference", "getUnorderedGroupHelper().canSelect(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1)");
                    	    }
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:884:110: ( ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:885:6: ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' )
                    	    {
                    	     
                    	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1(), 1);
                    	    	 				
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:888:6: ( 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';' )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:888:8: 'longDescription' ( (lv_longDescription_10_0= RULE_STRING ) ) ';'
                    	    {
                    	    match(input,19,FollowSets000.FOLLOW_19_in_ruleReference1714); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getLongDescriptionKeyword_4_0_1_1_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:892:1: ( (lv_longDescription_10_0= RULE_STRING ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:893:1: (lv_longDescription_10_0= RULE_STRING )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:893:1: (lv_longDescription_10_0= RULE_STRING )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:894:3: lv_longDescription_10_0= RULE_STRING
                    	    {
                    	    lv_longDescription_10_0=(Token)input.LT(1);
                    	    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleReference1731); 

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

                    	    match(input,12,FollowSets000.FOLLOW_12_in_ruleReference1746); 

                    	            createLeafNode(grammarAccess.getReferenceAccess().getSemicolonKeyword_4_0_1_1_2(), null); 
                    	        

                    	    }

                    	     
                    	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	    	 				

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }


                    }

                     
                    	  getUnorderedGroupHelper().leave(grammarAccess.getReferenceAccess().getUnorderedGroup_4_0_1());
                    	

                    }

                    match(input,26,FollowSets000.FOLLOW_26_in_ruleReference1796); 

                            createLeafNode(grammarAccess.getReferenceAccess().getRightCurlyBracketKeyword_4_0_2(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug304681TestLanguage.g:939:7: ';'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleReference1813); 

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


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA6_eotS =
        "\35\uffff";
    static final String DFA6_eofS =
        "\35\uffff";
    static final String DFA6_minS =
        "\1\22\5\uffff\2\4\3\uffff\2\4\1\14\1\4\1\14\1\0\1\22\1\0\1\uffff"+
        "\2\5\1\0\2\14\2\22\2\0";
    static final String DFA6_maxS =
        "\1\34\5\uffff\2\4\3\uffff\1\4\1\35\1\14\1\4\1\21\1\0\1\32\1\0\1"+
        "\uffff\2\5\1\0\2\14\2\32\2\0";
    static final String DFA6_acceptS =
        "\1\uffff\5\2\2\uffff\3\2\10\uffff\1\1\11\uffff";
    static final String DFA6_specialS =
        "\1\3\17\uffff\1\4\1\uffff\1\5\3\uffff\1\2\4\uffff\1\1\1\0}>";
    static final String[] DFA6_transitionS = {
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
            "\1\17\30\uffff\1\16",
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

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 537:1: ( (lv_features_24_0= ruleFeature ) )*";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_28 = input.LA(1);

                         
                        int index6_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index6_28);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_27 = input.LA(1);

                         
                        int index6_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index6_27);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_22 = input.LA(1);

                         
                        int index6_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index6_22);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_0 = input.LA(1);

                         
                        int index6_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA6_0==26) ) {s = 1;}

                        else if ( (LA6_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {s = 2;}

                        else if ( (LA6_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {s = 3;}

                        else if ( (LA6_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {s = 4;}

                        else if ( (LA6_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {s = 5;}

                        else if ( (LA6_0==27) ) {s = 6;}

                        else if ( (LA6_0==28) ) {s = 7;}

                        else if ( (LA6_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {s = 8;}

                        else if ( (LA6_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {s = 9;}

                        else if ( (LA6_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {s = 10;}

                         
                        input.seek(index6_0);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_16 = input.LA(1);

                         
                        int index6_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index6_16);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_18 = input.LA(1);

                         
                        int index6_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index6_18);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\35\uffff";
    static final String DFA7_eofS =
        "\35\uffff";
    static final String DFA7_minS =
        "\1\22\5\uffff\2\4\3\uffff\2\4\1\14\1\4\1\14\1\0\1\22\1\0\1\uffff"+
        "\2\5\1\0\2\14\2\22\2\0";
    static final String DFA7_maxS =
        "\1\34\5\uffff\2\4\3\uffff\1\4\1\35\1\14\1\4\1\21\1\0\1\32\1\0\1"+
        "\uffff\2\5\1\0\2\14\2\32\2\0";
    static final String DFA7_acceptS =
        "\1\uffff\5\2\2\uffff\3\2\10\uffff\1\1\11\uffff";
    static final String DFA7_specialS =
        "\1\0\17\uffff\1\2\1\uffff\1\1\3\uffff\1\5\4\uffff\1\4\1\3}>";
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
            "\1\17\30\uffff\1\16",
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
            return "()+ loopback of 577:1: ( (lv_features_26_0= ruleFeature ) )+";
        }
        public int specialStateTransition(int s, IntStream input) throws NoViableAltException {
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_0 = input.LA(1);

                         
                        int index7_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA7_0==26) ) {s = 1;}

                        else if ( (LA7_0==18) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 0))) {s = 2;}

                        else if ( (LA7_0==19) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 1))) {s = 3;}

                        else if ( (LA7_0==20) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 2))) {s = 4;}

                        else if ( (LA7_0==21) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 3))) {s = 5;}

                        else if ( (LA7_0==27) ) {s = 6;}

                        else if ( (LA7_0==28) ) {s = 7;}

                        else if ( (LA7_0==22) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 5))) {s = 8;}

                        else if ( (LA7_0==24) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 6))) {s = 9;}

                        else if ( (LA7_0==25) && (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 7))) {s = 10;}

                         
                        input.seek(index7_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_18 = input.LA(1);

                         
                        int index7_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index7_18);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA7_16 = input.LA(1);

                         
                        int index7_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index7_16);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA7_28 = input.LA(1);

                         
                        int index7_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index7_28);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA7_27 = input.LA(1);

                         
                        int index7_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
                        input.seek(index7_27);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA7_22 = input.LA(1);

                         
                        int index7_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (!(getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4))) ) {s = 19;}

                        else if ( (getUnorderedGroupHelper().canSelect(grammarAccess.getObjectAccess().getUnorderedGroup_5(), 4)) ) {s = 10;}

                         
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
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rulePackageDefinition129 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_rulePackageDefinition146 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_rulePackageDefinition161 = new BitSet(new long[]{0x000000000000E002L});
        public static final BitSet FOLLOW_ruleObject_in_rulePackageDefinition182 = new BitSet(new long[]{0x000000000000E002L});
        public static final BitSet FOLLOW_ruleObject_in_entryRuleObject219 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObject229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleObject273 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_14_in_ruleObject310 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleObject335 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject352 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleObject368 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObject386 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleObject398 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_18_in_ruleObject451 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject468 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleObject483 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_19_in_ruleObject545 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleObject562 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleObject577 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_20_in_ruleObject639 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleObject656 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleObject671 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_21_in_ruleObject741 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleObject764 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject836 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_22_in_ruleObject898 = new BitSet(new long[]{0x0000000018800000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject919 = new BitSet(new long[]{0x0000000018800000L});
        public static final BitSet FOLLOW_23_in_ruleObject930 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_24_in_ruleObject992 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1013 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_25_in_ruleObject1076 = new BitSet(new long[]{0x0000000018000000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleObject1097 = new BitSet(new long[]{0x000000001F7C0000L});
        public static final BitSet FOLLOW_26_in_ruleObject1148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature1194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleFeature1241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleFeature1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleAttribute1348 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1365 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1387 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAttribute1402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference1438 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference1448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleReference1483 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1501 = new BitSet(new long[]{0x0000000020000010L});
        public static final BitSet FOLLOW_29_in_ruleReference1519 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference1550 = new BitSet(new long[]{0x0000000000021000L});
        public static final BitSet FOLLOW_17_in_ruleReference1567 = new BitSet(new long[]{0x00000000040C0000L});
        public static final BitSet FOLLOW_18_in_ruleReference1620 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1637 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReference1652 = new BitSet(new long[]{0x00000000040C0000L});
        public static final BitSet FOLLOW_19_in_ruleReference1714 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleReference1731 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleReference1746 = new BitSet(new long[]{0x00000000040C0000L});
        public static final BitSet FOLLOW_26_in_ruleReference1796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleReference1813 = new BitSet(new long[]{0x0000000000000002L});
    }


}
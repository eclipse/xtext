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
import org.eclipse.xtext.linking.lazy.services.Bug311337TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug311337TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'(def)'", "':'", "'(child)'", "'(ref)'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBug311337TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g"; }



     	private Bug311337TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug311337TestLanguageParser(TokenStream input, IAstFactory factory, Bug311337TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug311337TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:77:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:78:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:79:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:86:1: ruleModel returns [EObject current=null] : ( (lv_def_0_0= ruleDefinition ) )+ ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_def_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:91:6: ( ( (lv_def_0_0= ruleDefinition ) )+ )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:92:1: ( (lv_def_0_0= ruleDefinition ) )+
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:92:1: ( (lv_def_0_0= ruleDefinition ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:93:1: (lv_def_0_0= ruleDefinition )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:93:1: (lv_def_0_0= ruleDefinition )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:94:3: lv_def_0_0= ruleDefinition
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getDefDefinitionParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_ruleModel130);
            	    lv_def_0_0=ruleDefinition();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"def",
            	    	        		lv_def_0_0, 
            	    	        		"Definition", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleDefinition
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:124:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:125:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:126:2: iv_ruleDefinition= ruleDefinition EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDefinitionRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_entryRuleDefinition166);
            iv_ruleDefinition=ruleDefinition();
            _fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefinition176); 

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
    // $ANTLR end entryRuleDefinition


    // $ANTLR start ruleDefinition
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:133:1: ruleDefinition returns [EObject current=null] : ( '(def)' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_child_3_0 = null;

        EObject lv_ref_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:138:6: ( ( '(def)' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:139:1: ( '(def)' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:139:1: ( '(def)' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:139:3: '(def)' ( (lv_name_1_0= RULE_ID ) ) ':' ( (lv_child_3_0= ruleChild ) ) ( (lv_ref_4_0= ruleReference ) )?
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleDefinition211); 

                    createLeafNode(grammarAccess.getDefinitionAccess().getDefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:143:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:144:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:144:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:145:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDefinition228); 

            			createLeafNode(grammarAccess.getDefinitionAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleDefinition243); 

                    createLeafNode(grammarAccess.getDefinitionAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:171:1: ( (lv_child_3_0= ruleChild ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:172:1: (lv_child_3_0= ruleChild )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:172:1: (lv_child_3_0= ruleChild )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:173:3: lv_child_3_0= ruleChild
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getChildChildParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_ruleDefinition264);
            lv_child_3_0=ruleChild();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"child",
            	        		lv_child_3_0, 
            	        		"Child", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:195:2: ( (lv_ref_4_0= ruleReference ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:196:1: (lv_ref_4_0= ruleReference )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:196:1: (lv_ref_4_0= ruleReference )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:197:3: lv_ref_4_0= ruleReference
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDefinitionAccess().getRefReferenceParserRuleCall_4_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleReference_in_ruleDefinition285);
                    lv_ref_4_0=ruleReference();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getDefinitionRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"ref",
                    	        		lv_ref_4_0, 
                    	        		"Reference", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

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
    // $ANTLR end ruleDefinition


    // $ANTLR start entryRuleChild
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:227:1: entryRuleChild returns [EObject current=null] : iv_ruleChild= ruleChild EOF ;
    public final EObject entryRuleChild() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleChild = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:228:2: (iv_ruleChild= ruleChild EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:229:2: iv_ruleChild= ruleChild EOF
            {
             currentNode = createCompositeNode(grammarAccess.getChildRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleChild_in_entryRuleChild322);
            iv_ruleChild=ruleChild();
            _fsp--;

             current =iv_ruleChild; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleChild332); 

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
    // $ANTLR end entryRuleChild


    // $ANTLR start ruleChild
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:236:1: ruleChild returns [EObject current=null] : ( '(child)' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) )? ) ;
    public final EObject ruleChild() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:241:6: ( ( '(child)' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:242:1: ( '(child)' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:242:1: ( '(child)' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:242:3: '(child)' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) )?
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleChild367); 

                    createLeafNode(grammarAccess.getChildAccess().getChildKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:246:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:247:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:247:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:248:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild384); 

            			createLeafNode(grammarAccess.getChildAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getChildRule().getType().getClassifier());
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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleChild399); 

                    createLeafNode(grammarAccess.getChildAccess().getColonKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:274:1: ( ( RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:275:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:275:1: ( RULE_ID )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:276:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getChildRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleChild417); 

                    		createLeafNode(grammarAccess.getChildAccess().getLinkDefinitionCrossReference_3_0(), "link"); 
                    	

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
    // $ANTLR end ruleChild


    // $ANTLR start entryRuleReference
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:296:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:297:2: (iv_ruleReference= ruleReference EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:298:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleReference_in_entryRuleReference454);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReference464); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:305:1: ruleReference returns [EObject current=null] : ( '(ref)' ( ( RULE_ID ) ) ( ':' () ( ( RULE_ID ) ) )* ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:310:6: ( ( '(ref)' ( ( RULE_ID ) ) ( ':' () ( ( RULE_ID ) ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:311:1: ( '(ref)' ( ( RULE_ID ) ) ( ':' () ( ( RULE_ID ) ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:311:1: ( '(ref)' ( ( RULE_ID ) ) ( ':' () ( ( RULE_ID ) ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:311:3: '(ref)' ( ( RULE_ID ) ) ( ':' () ( ( RULE_ID ) ) )*
            {
            match(input,14,FollowSets000.FOLLOW_14_in_ruleReference499); 

                    createLeafNode(grammarAccess.getReferenceAccess().getRefKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:315:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:316:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:316:1: ( RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:317:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference517); 

            		createLeafNode(grammarAccess.getReferenceAccess().getRefChildChildCrossReference_1_0(), "refChild"); 
            	

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:329:2: ( ':' () ( ( RULE_ID ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:329:4: ':' () ( ( RULE_ID ) )
            	    {
            	    match(input,12,FollowSets000.FOLLOW_12_in_ruleReference528); 

            	            createLeafNode(grammarAccess.getReferenceAccess().getColonKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:333:1: ()
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:334:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getReferenceAccess().getNestedRefLeftAction_2_1(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:349:2: ( ( RULE_ID ) )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:350:1: ( RULE_ID )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:350:1: ( RULE_ID )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/linking/lazy/parser/antlr/internal/InternalBug311337TestLanguage.g:351:3: RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReference555); 

            	    		createLeafNode(grammarAccess.getReferenceAccess().getRefChildChildCrossReference_2_2_0(), "refChild"); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end ruleReference


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefinition_in_ruleModel130 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefinition176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDefinition211 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDefinition228 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDefinition243 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleChild_in_ruleDefinition264 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleReference_in_ruleDefinition285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleChild_in_entryRuleChild322 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleChild332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleChild367 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild384 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleChild399 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleChild417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReference_in_entryRuleReference454 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReference464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleReference499 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference517 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleReference528 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReference555 = new BitSet(new long[]{0x0000000000001002L});
    }


}
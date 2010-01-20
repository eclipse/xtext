package org.eclipse.xtext.generator.ecore.parser.antlr.internal; 

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
import org.eclipse.xtext.generator.ecore.services.SubTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalSubTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'super'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalSubTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g"; }



     	private SubTestLanguageGrammarAccess grammarAccess;
     	
        public InternalSubTestLanguageParser(TokenStream input, IAstFactory factory, SubTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SubMain";	
       	} 



    // $ANTLR start entryRuleSubMain
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:72:1: entryRuleSubMain returns [EObject current=null] : iv_ruleSubMain= ruleSubMain EOF ;
    public final EObject entryRuleSubMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubMain = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:73:2: (iv_ruleSubMain= ruleSubMain EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:74:2: iv_ruleSubMain= ruleSubMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubMain_in_entryRuleSubMain75);
            iv_ruleSubMain=ruleSubMain();
            _fsp--;

             current =iv_ruleSubMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubMain85); 

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
    // $ANTLR end entryRuleSubMain


    // $ANTLR start ruleSubMain
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:81:1: ruleSubMain returns [EObject current=null] : ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ) ;
    public final EObject ruleSubMain() throws RecognitionException {
        EObject current = null;

        EObject lv_superMains_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:86:6: ( ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:87:1: ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:87:1: ( '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:87:3: '{' ( (lv_superMains_1_0= ruleSuperMain ) ) '}'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleSubMain120); 

                    createLeafNode(grammarAccess.getSubMainAccess().getLeftCurlyBracketKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:91:1: ( (lv_superMains_1_0= ruleSuperMain ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:92:1: (lv_superMains_1_0= ruleSuperMain )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:92:1: (lv_superMains_1_0= ruleSuperMain )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:93:3: lv_superMains_1_0= ruleSuperMain
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getSubMainAccess().getSuperMainsSuperMainParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSuperMain_in_ruleSubMain141);
            lv_superMains_1_0=ruleSuperMain();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubMainRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"superMains",
            	        		lv_superMains_1_0, 
            	        		"SuperMain", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleSubMain151); 

                    createLeafNode(grammarAccess.getSubMainAccess().getRightCurlyBracketKeyword_2(), null); 
                

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
    // $ANTLR end ruleSubMain


    // $ANTLR start entryRuleSuperMain
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:127:1: entryRuleSuperMain returns [EObject current=null] : iv_ruleSuperMain= ruleSuperMain EOF ;
    public final EObject entryRuleSuperMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperMain = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:128:2: (iv_ruleSuperMain= ruleSuperMain EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:129:2: iv_ruleSuperMain= ruleSuperMain EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSuperMainRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSuperMain_in_entryRuleSuperMain187);
            iv_ruleSuperMain=ruleSuperMain();
            _fsp--;

             current =iv_ruleSuperMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSuperMain197); 

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
    // $ANTLR end entryRuleSuperMain


    // $ANTLR start ruleSuperMain
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:136:1: ruleSuperMain returns [EObject current=null] : ( 'super' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSuperMain() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:141:6: ( ( 'super' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:142:1: ( 'super' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:142:1: ( 'super' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:142:3: 'super' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,13,FollowSets000.FOLLOW_13_in_ruleSuperMain232); 

                    createLeafNode(grammarAccess.getSuperMainAccess().getSuperKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:146:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:147:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:147:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/generator/ecore/parser/antlr/internal/InternalSubTestLanguage.g:148:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSuperMain249); 

            			createLeafNode(grammarAccess.getSuperMainAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSuperMainRule().getType().getClassifier());
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
    // $ANTLR end ruleSuperMain


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSubMain_in_entryRuleSubMain75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubMain85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSubMain120 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_ruleSuperMain_in_ruleSubMain141 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSubMain151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSuperMain_in_entryRuleSuperMain187 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSuperMain197 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleSuperMain232 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSuperMain249 = new BitSet(new long[]{0x0000000000000002L});
    }


}
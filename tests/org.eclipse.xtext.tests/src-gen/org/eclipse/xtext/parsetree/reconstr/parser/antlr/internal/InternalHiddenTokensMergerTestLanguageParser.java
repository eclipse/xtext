package org.eclipse.xtext.parsetree.reconstr.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.reconstr.services.HiddenTokensMergerTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalHiddenTokensMergerTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'ref'", "';'", "'.'", "'#2'", "'kw1'", "'#3'", "'item'", "'#4'", "'#5'", "'refs'", "'#7'", "'class'", "'endclass'", "'array'", "'object'", "'resultSet'", "'iterator'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=5;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g"; }



     	private HiddenTokensMergerTestLanguageGrammarAccess grammarAccess;
     	
        public InternalHiddenTokensMergerTestLanguageParser(TokenStream input, IAstFactory factory, HiddenTokensMergerTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected HiddenTokensMergerTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleModel
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:78:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:79:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:80:2: iv_ruleModel= ruleModel EOF
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:87:1: ruleModel returns [EObject current=null] : (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_AppendToFileEnd_5= ruleAppendToFileEnd ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_DatatypeBug286557_0 = null;

        EObject this_EnumBug_1 = null;

        EObject this_Commentable_2 = null;

        EObject this_ValueList_3 = null;

        EObject this_RefList_4 = null;

        EObject this_AppendToFileEnd_5 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:92:6: ( (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_AppendToFileEnd_5= ruleAppendToFileEnd ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:93:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_AppendToFileEnd_5= ruleAppendToFileEnd )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:93:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_AppendToFileEnd_5= ruleAppendToFileEnd )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            case 19:
                {
                alt1=4;
                }
                break;
            case 20:
                {
                alt1=5;
                }
                break;
            case 22:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("93:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList | this_AppendToFileEnd_5= ruleAppendToFileEnd )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:94:5: this_DatatypeBug286557_0= ruleDatatypeBug286557
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getDatatypeBug286557ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_ruleModel132);
                    this_DatatypeBug286557_0=ruleDatatypeBug286557();
                    _fsp--;

                     
                            current = this_DatatypeBug286557_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:104:5: this_EnumBug_1= ruleEnumBug
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getEnumBugParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_ruleModel159);
                    this_EnumBug_1=ruleEnumBug();
                    _fsp--;

                     
                            current = this_EnumBug_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:114:5: this_Commentable_2= ruleCommentable
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getCommentableParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_ruleModel186);
                    this_Commentable_2=ruleCommentable();
                    _fsp--;

                     
                            current = this_Commentable_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:124:5: this_ValueList_3= ruleValueList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getValueListParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleValueList_in_ruleModel213);
                    this_ValueList_3=ruleValueList();
                    _fsp--;

                     
                            current = this_ValueList_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:134:5: this_RefList_4= ruleRefList
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getRefListParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRefList_in_ruleModel240);
                    this_RefList_4=ruleRefList();
                    _fsp--;

                     
                            current = this_RefList_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:144:5: this_AppendToFileEnd_5= ruleAppendToFileEnd
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getModelAccess().getAppendToFileEndParserRuleCall_5(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEnd_in_ruleModel267);
                    this_AppendToFileEnd_5=ruleAppendToFileEnd();
                    _fsp--;

                     
                            current = this_AppendToFileEnd_5; 
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
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleDatatypeBug286557
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:160:1: entryRuleDatatypeBug286557 returns [EObject current=null] : iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF ;
    public final EObject entryRuleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeBug286557 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:161:2: (iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:162:2: iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeBug286557Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557302);
            iv_ruleDatatypeBug286557=ruleDatatypeBug286557();
            _fsp--;

             current =iv_ruleDatatypeBug286557; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeBug286557312); 

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
    // $ANTLR end entryRuleDatatypeBug286557


    // $ANTLR start ruleDatatypeBug286557
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:169:1: ruleDatatypeBug286557 returns [EObject current=null] : ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' ) ;
    public final EObject ruleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:174:6: ( ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:175:1: ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:175:1: ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:175:3: '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleDatatypeBug286557347); 

                    createLeafNode(grammarAccess.getDatatypeBug286557Access().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:179:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:180:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:180:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:181:3: lv_name_1_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypeBug286557Access().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557368);
            lv_name_1_0=ruleFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDatatypeBug286557Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"FQN", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:203:2: ( 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:203:4: 'ref' ( ( ruleFQN ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleDatatypeBug286557379); 

                            createLeafNode(grammarAccess.getDatatypeBug286557Access().getRefKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:207:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:208:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:208:1: ( ruleFQN )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:209:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getDatatypeBug286557Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDatatypeBug286557Access().getRefDatatypeBug286557CrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557402);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleDatatypeBug286557414); 

                    createLeafNode(grammarAccess.getDatatypeBug286557Access().getSemicolonKeyword_3(), null); 
                

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
    // $ANTLR end ruleDatatypeBug286557


    // $ANTLR start entryRuleFQN
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:235:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:236:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:237:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN451);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN462); 

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
    // $ANTLR end entryRuleFQN


    // $ANTLR start ruleFQN
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:244:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:249:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:250:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:250:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:250:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN502); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:257:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:258:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleFQN521); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN536); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1(), null); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end ruleFQN


    // $ANTLR start entryRuleEnumBug
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:278:1: entryRuleEnumBug returns [EObject current=null] : iv_ruleEnumBug= ruleEnumBug EOF ;
    public final EObject entryRuleEnumBug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBug = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:279:2: (iv_ruleEnumBug= ruleEnumBug EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:280:2: iv_ruleEnumBug= ruleEnumBug EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumBugRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_entryRuleEnumBug583);
            iv_ruleEnumBug=ruleEnumBug();
            _fsp--;

             current =iv_ruleEnumBug; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumBug593); 

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
    // $ANTLR end entryRuleEnumBug


    // $ANTLR start ruleEnumBug
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:287:1: ruleEnumBug returns [EObject current=null] : ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumBug() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        Enumerator lv_return_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:292:6: ( ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:293:1: ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:293:1: ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:293:3: '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumBug628); 

                    createLeafNode(grammarAccess.getEnumBugAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
            match(input,16,FollowSets000.FOLLOW_16_in_ruleEnumBug638); 

                    createLeafNode(grammarAccess.getEnumBugAccess().getKw1Keyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:301:1: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:302:1: (lv_return_2_0= ruleEnumBugEnum )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:302:1: (lv_return_2_0= ruleEnumBugEnum )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:303:3: lv_return_2_0= ruleEnumBugEnum
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumBugAccess().getReturnEnumBugEnumEnumRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumBugEnum_in_ruleEnumBug659);
            lv_return_2_0=ruleEnumBugEnum();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumBugRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"return",
            	        		lv_return_2_0, 
            	        		"EnumBugEnum", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:325:2: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:326:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:326:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:327:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumBug676); 

            			createLeafNode(grammarAccess.getEnumBugAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEnumBugRule().getType().getClassifier());
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
    // $ANTLR end ruleEnumBug


    // $ANTLR start entryRuleCommentable
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:357:1: entryRuleCommentable returns [EObject current=null] : iv_ruleCommentable= ruleCommentable EOF ;
    public final EObject entryRuleCommentable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:358:2: (iv_ruleCommentable= ruleCommentable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:359:2: iv_ruleCommentable= ruleCommentable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommentableRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_entryRuleCommentable717);
            iv_ruleCommentable=ruleCommentable();
            _fsp--;

             current =iv_ruleCommentable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentable727); 

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
    // $ANTLR end entryRuleCommentable


    // $ANTLR start ruleCommentable
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:366:1: ruleCommentable returns [EObject current=null] : ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final EObject ruleCommentable() throws RecognitionException {
        EObject current = null;

        EObject lv_item_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:371:6: ( ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:372:1: ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:372:1: ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:372:3: '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleCommentable762); 

                    createLeafNode(grammarAccess.getCommentableAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:376:1: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:377:1: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:377:1: (lv_item_1_0= ruleCommentableItem )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:378:3: lv_item_1_0= ruleCommentableItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getCommentableAccess().getItemCommentableItemParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_ruleCommentable783);
            	    lv_item_1_0=ruleCommentableItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getCommentableRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"item",
            	    	        		lv_item_1_0, 
            	    	        		"CommentableItem", 
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
    // $ANTLR end ruleCommentable


    // $ANTLR start entryRuleCommentableItem
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:408:1: entryRuleCommentableItem returns [EObject current=null] : iv_ruleCommentableItem= ruleCommentableItem EOF ;
    public final EObject entryRuleCommentableItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentableItem = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:409:2: (iv_ruleCommentableItem= ruleCommentableItem EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:410:2: iv_ruleCommentableItem= ruleCommentableItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommentableItemRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem820);
            iv_ruleCommentableItem=ruleCommentableItem();
            _fsp--;

             current =iv_ruleCommentableItem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentableItem830); 

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
    // $ANTLR end entryRuleCommentableItem


    // $ANTLR start ruleCommentableItem
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:417:1: ruleCommentableItem returns [EObject current=null] : ( 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCommentableItem() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:422:6: ( ( 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:423:1: ( 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:423:1: ( 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:423:3: 'item' ( (lv_id_1_0= RULE_ID ) )
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleCommentableItem865); 

                    createLeafNode(grammarAccess.getCommentableItemAccess().getItemKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:427:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:428:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:428:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:429:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommentableItem882); 

            			createLeafNode(grammarAccess.getCommentableItemAccess().getIdIDTerminalRuleCall_1_0(), "id"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCommentableItemRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"id",
            	        		lv_id_1_0, 
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
    // $ANTLR end ruleCommentableItem


    // $ANTLR start entryRuleValueList
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:459:1: entryRuleValueList returns [EObject current=null] : iv_ruleValueList= ruleValueList EOF ;
    public final EObject entryRuleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:460:2: (iv_ruleValueList= ruleValueList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:461:2: iv_ruleValueList= ruleValueList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueListRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleValueList_in_entryRuleValueList923);
            iv_ruleValueList=ruleValueList();
            _fsp--;

             current =iv_ruleValueList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueList933); 

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
    // $ANTLR end entryRuleValueList


    // $ANTLR start ruleValueList
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:468:1: ruleValueList returns [EObject current=null] : ( '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final EObject ruleValueList() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_ids_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:473:6: ( ( '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:474:1: ( '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:474:1: ( '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:474:3: '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleValueList968); 

                    createLeafNode(grammarAccess.getValueListAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:478:1: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:479:1: (lv_ids_1_0= ruleFQN )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:479:1: (lv_ids_1_0= ruleFQN )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:480:3: lv_ids_1_0= ruleFQN
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getValueListAccess().getIdsFQNParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleValueList989);
            	    lv_ids_1_0=ruleFQN();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getValueListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"ids",
            	    	        		lv_ids_1_0, 
            	    	        		"FQN", 
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
    // $ANTLR end ruleValueList


    // $ANTLR start entryRuleRefList
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:510:1: entryRuleRefList returns [EObject current=null] : iv_ruleRefList= ruleRefList EOF ;
    public final EObject entryRuleRefList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:511:2: (iv_ruleRefList= ruleRefList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:512:2: iv_ruleRefList= ruleRefList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefListRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRefList_in_entryRuleRefList1026);
            iv_ruleRefList=ruleRefList();
            _fsp--;

             current =iv_ruleRefList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefList1036); 

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
    // $ANTLR end entryRuleRefList


    // $ANTLR start ruleRefList
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:519:1: ruleRefList returns [EObject current=null] : ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* ) ;
    public final EObject ruleRefList() throws RecognitionException {
        EObject current = null;

        EObject lv_objs_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:524:6: ( ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:525:1: ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:525:1: ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:525:3: '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )*
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleRefList1071); 

                    createLeafNode(grammarAccess.getRefListAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:529:1: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:530:1: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:530:1: (lv_objs_1_0= ruleRefObj )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:531:3: lv_objs_1_0= ruleRefObj
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRefListAccess().getObjsRefObjParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_ruleRefList1092);
            	    lv_objs_1_0=ruleRefObj();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getRefListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"objs",
            	    	        		lv_objs_1_0, 
            	    	        		"RefObj", 
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

            match(input,21,FollowSets000.FOLLOW_21_in_ruleRefList1103); 

                    createLeafNode(grammarAccess.getRefListAccess().getRefsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:557:1: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:558:1: ( ruleFQN )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:558:1: ( ruleFQN )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:559:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getRefListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRefListAccess().getRefsRefObjCrossReference_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefList1126);
            	    ruleFQN();
            	    _fsp--;

            	     
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end ruleRefList


    // $ANTLR start entryRuleRefObj
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:581:1: entryRuleRefObj returns [EObject current=null] : iv_ruleRefObj= ruleRefObj EOF ;
    public final EObject entryRuleRefObj() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefObj = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:582:2: (iv_ruleRefObj= ruleRefObj EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:583:2: iv_ruleRefObj= ruleRefObj EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefObjRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_entryRuleRefObj1163);
            iv_ruleRefObj=ruleRefObj();
            _fsp--;

             current =iv_ruleRefObj; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefObj1173); 

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
    // $ANTLR end entryRuleRefObj


    // $ANTLR start ruleRefObj
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:590:1: ruleRefObj returns [EObject current=null] : ( (lv_name_0_0= ruleFQN ) ) ;
    public final EObject ruleRefObj() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:595:6: ( ( (lv_name_0_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:596:1: ( (lv_name_0_0= ruleFQN ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:596:1: ( (lv_name_0_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:597:1: (lv_name_0_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:597:1: (lv_name_0_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:598:3: lv_name_0_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRefObjAccess().getNameFQNParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefObj1218);
            lv_name_0_0=ruleFQN();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRefObjRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"FQN", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
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
    // $ANTLR end ruleRefObj


    // $ANTLR start entryRuleAppendToFileEnd
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:630:1: entryRuleAppendToFileEnd returns [EObject current=null] : iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF ;
    public final EObject entryRuleAppendToFileEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendToFileEnd = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:631:2: (iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:632:2: iv_ruleAppendToFileEnd= ruleAppendToFileEnd EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAppendToFileEndRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEnd_in_entryRuleAppendToFileEnd1255);
            iv_ruleAppendToFileEnd=ruleAppendToFileEnd();
            _fsp--;

             current =iv_ruleAppendToFileEnd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAppendToFileEnd1265); 

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
    // $ANTLR end entryRuleAppendToFileEnd


    // $ANTLR start ruleAppendToFileEnd
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:639:1: ruleAppendToFileEnd returns [EObject current=null] : ( '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) ;
    public final EObject ruleAppendToFileEnd() throws RecognitionException {
        EObject current = null;

        EObject lv_items_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:644:6: ( ( '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:645:1: ( '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:645:1: ( '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:645:3: '#7' ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            {
            match(input,22,FollowSets000.FOLLOW_22_in_ruleAppendToFileEnd1300); 

                    createLeafNode(grammarAccess.getAppendToFileEndAccess().getNumberSignDigitSevenKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:649:1: ( (lv_items_1_0= ruleAppendToFileEndItem ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:650:1: (lv_items_1_0= ruleAppendToFileEndItem )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:650:1: (lv_items_1_0= ruleAppendToFileEndItem )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:651:3: lv_items_1_0= ruleAppendToFileEndItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAppendToFileEndAccess().getItemsAppendToFileEndItemParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEndItem_in_ruleAppendToFileEnd1321);
            	    lv_items_1_0=ruleAppendToFileEndItem();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAppendToFileEndRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"items",
            	    	        		lv_items_1_0, 
            	    	        		"AppendToFileEndItem", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end ruleAppendToFileEnd


    // $ANTLR start entryRuleAppendToFileEndItem
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:681:1: entryRuleAppendToFileEndItem returns [EObject current=null] : iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF ;
    public final EObject entryRuleAppendToFileEndItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAppendToFileEndItem = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:682:2: (iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:683:2: iv_ruleAppendToFileEndItem= ruleAppendToFileEndItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAppendToFileEndItemRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAppendToFileEndItem_in_entryRuleAppendToFileEndItem1358);
            iv_ruleAppendToFileEndItem=ruleAppendToFileEndItem();
            _fsp--;

             current =iv_ruleAppendToFileEndItem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAppendToFileEndItem1368); 

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
    // $ANTLR end entryRuleAppendToFileEndItem


    // $ANTLR start ruleAppendToFileEndItem
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:690:1: ruleAppendToFileEndItem returns [EObject current=null] : ( 'class' ( (lv_name_1_0= RULE_ID ) ) 'endclass' ) ;
    public final EObject ruleAppendToFileEndItem() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:695:6: ( ( 'class' ( (lv_name_1_0= RULE_ID ) ) 'endclass' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:696:1: ( 'class' ( (lv_name_1_0= RULE_ID ) ) 'endclass' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:696:1: ( 'class' ( (lv_name_1_0= RULE_ID ) ) 'endclass' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:696:3: 'class' ( (lv_name_1_0= RULE_ID ) ) 'endclass'
            {
            match(input,23,FollowSets000.FOLLOW_23_in_ruleAppendToFileEndItem1403); 

                    createLeafNode(grammarAccess.getAppendToFileEndItemAccess().getClassKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:700:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:701:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:701:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:702:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAppendToFileEndItem1420); 

            			createLeafNode(grammarAccess.getAppendToFileEndItemAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getAppendToFileEndItemRule().getType().getClassifier());
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

            match(input,24,FollowSets000.FOLLOW_24_in_ruleAppendToFileEndItem1435); 

                    createLeafNode(grammarAccess.getAppendToFileEndItemAccess().getEndclassKeyword_2(), null); 
                

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
    // $ANTLR end ruleAppendToFileEndItem


    // $ANTLR start ruleEnumBugEnum
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:736:1: ruleEnumBugEnum returns [Enumerator current=null] : ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) ) ;
    public final Enumerator ruleEnumBugEnum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:740:6: ( ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:741:1: ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:741:1: ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) )
            int alt9=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt9=1;
                }
                break;
            case 26:
                {
                alt9=2;
                }
                break;
            case 27:
                {
                alt9=3;
                }
                break;
            case 28:
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("741:1: ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) )", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:741:2: ( 'array' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:741:2: ( 'array' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:741:4: 'array'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumBugEnum1483); 

                            current = grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:747:6: ( 'object' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:747:6: ( 'object' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:747:8: 'object'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_ruleEnumBugEnum1498); 

                            current = grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:753:6: ( 'resultSet' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:753:6: ( 'resultSet' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:753:8: 'resultSet'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_ruleEnumBugEnum1513); 

                            current = grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:759:6: ( 'iterator' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:759:6: ( 'iterator' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:759:8: 'iterator'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_ruleEnumBugEnum1528); 

                            current = grammarAccess.getEnumBugEnumAccess().getIteratorEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getIteratorEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end ruleEnumBugEnum


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_ruleModel132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_ruleModel159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_ruleModel186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_ruleModel213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRefList_in_ruleModel240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEnd_in_ruleModel267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeBug286557312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDatatypeBug286557347 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557368 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleDatatypeBug286557379 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557402 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleDatatypeBug286557414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN502 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleFQN521 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN536 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_entryRuleEnumBug583 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumBug593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumBug628 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleEnumBug638 = new BitSet(new long[]{0x000000001E000000L});
        public static final BitSet FOLLOW_ruleEnumBugEnum_in_ruleEnumBug659 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumBug676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_entryRuleCommentable717 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentable727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCommentable762 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_ruleCommentable783 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem820 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentableItem830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleCommentableItem865 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommentableItem882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_entryRuleValueList923 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueList933 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleValueList968 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleValueList989 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefList_in_entryRuleRefList1026 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefList1036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRefList1071 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleRefObj_in_ruleRefList1092 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleRefList1103 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefList1126 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefObj_in_entryRuleRefObj1163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefObj1173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefObj1218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAppendToFileEnd_in_entryRuleAppendToFileEnd1255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAppendToFileEnd1265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleAppendToFileEnd1300 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleAppendToFileEndItem_in_ruleAppendToFileEnd1321 = new BitSet(new long[]{0x0000000000800002L});
        public static final BitSet FOLLOW_ruleAppendToFileEndItem_in_entryRuleAppendToFileEndItem1358 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAppendToFileEndItem1368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleAppendToFileEndItem1403 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAppendToFileEndItem1420 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAppendToFileEndItem1435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleEnumBugEnum1483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleEnumBugEnum1498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleEnumBugEnum1513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleEnumBugEnum1528 = new BitSet(new long[]{0x0000000000000002L});
    }


}
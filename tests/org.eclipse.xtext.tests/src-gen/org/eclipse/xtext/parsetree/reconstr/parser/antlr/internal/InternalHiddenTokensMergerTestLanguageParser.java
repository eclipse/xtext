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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#1'", "'ref'", "';'", "'.'", "'#2'", "'kw1'", "'#3'", "'item'", "'#4'", "'#5'", "'refs'", "'array'", "'object'", "'resultSet'", "'iterator'"
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:87:1: ruleModel returns [EObject current=null] : (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_DatatypeBug286557_0 = null;

        EObject this_EnumBug_1 = null;

        EObject this_Commentable_2 = null;

        EObject this_ValueList_3 = null;

        EObject this_RefList_4 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:92:6: ( (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:93:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:93:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList )
            int alt1=5;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("93:1: (this_DatatypeBug286557_0= ruleDatatypeBug286557 | this_EnumBug_1= ruleEnumBug | this_Commentable_2= ruleCommentable | this_ValueList_3= ruleValueList | this_RefList_4= ruleRefList )", 1, 0, input);

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:150:1: entryRuleDatatypeBug286557 returns [EObject current=null] : iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF ;
    public final EObject entryRuleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDatatypeBug286557 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:151:2: (iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:152:2: iv_ruleDatatypeBug286557= ruleDatatypeBug286557 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDatatypeBug286557Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557275);
            iv_ruleDatatypeBug286557=ruleDatatypeBug286557();
            _fsp--;

             current =iv_ruleDatatypeBug286557; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDatatypeBug286557285); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:159:1: ruleDatatypeBug286557 returns [EObject current=null] : ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' ) ;
    public final EObject ruleDatatypeBug286557() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:164:6: ( ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:165:1: ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:165:1: ( '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';' )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:165:3: '#1' ( (lv_name_1_0= ruleFQN ) ) ( 'ref' ( ( ruleFQN ) ) )? ';'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleDatatypeBug286557320); 

                    createLeafNode(grammarAccess.getDatatypeBug286557Access().getNumberSignDigitOneKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:169:1: ( (lv_name_1_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:170:1: (lv_name_1_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:170:1: (lv_name_1_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:171:3: lv_name_1_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDatatypeBug286557Access().getNameFQNParserRuleCall_1_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557341);
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:193:2: ( 'ref' ( ( ruleFQN ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:193:4: 'ref' ( ( ruleFQN ) )
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleDatatypeBug286557352); 

                            createLeafNode(grammarAccess.getDatatypeBug286557Access().getRefKeyword_2_0(), null); 
                        
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:197:1: ( ( ruleFQN ) )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:198:1: ( ruleFQN )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:198:1: ( ruleFQN )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:199:3: ruleFQN
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getDatatypeBug286557Rule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                     
                    	        currentNode=createCompositeNode(grammarAccess.getDatatypeBug286557Access().getRefDatatypeBug286557CrossReference_2_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleDatatypeBug286557375);
                    ruleFQN();
                    _fsp--;

                     
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleDatatypeBug286557387); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:225:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:226:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:227:2: iv_ruleFQN= ruleFQN EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFQNRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN424);
            iv_ruleFQN=ruleFQN();
            _fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN435); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:234:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:239:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:240:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:240:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:240:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN475); 

            		current.merge(this_ID_0);
                
             
                createLeafNode(grammarAccess.getFQNAccess().getIDTerminalRuleCall_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:247:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:248:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,14,FollowSets000.FOLLOW_14_in_ruleFQN494); 

            	            current.merge(kw);
            	            createLeafNode(grammarAccess.getFQNAccess().getFullStopKeyword_1_0(), null); 
            	        
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN509); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:268:1: entryRuleEnumBug returns [EObject current=null] : iv_ruleEnumBug= ruleEnumBug EOF ;
    public final EObject entryRuleEnumBug() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumBug = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:269:2: (iv_ruleEnumBug= ruleEnumBug EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:270:2: iv_ruleEnumBug= ruleEnumBug EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEnumBugRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEnumBug_in_entryRuleEnumBug556);
            iv_ruleEnumBug=ruleEnumBug();
            _fsp--;

             current =iv_ruleEnumBug; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEnumBug566); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:277:1: ruleEnumBug returns [EObject current=null] : ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) ;
    public final EObject ruleEnumBug() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        Enumerator lv_return_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:282:6: ( ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:283:1: ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:283:1: ( '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:283:3: '#2' 'kw1' ( (lv_return_2_0= ruleEnumBugEnum ) ) ( (lv_name_3_0= RULE_ID ) )
            {
            match(input,15,FollowSets000.FOLLOW_15_in_ruleEnumBug601); 

                    createLeafNode(grammarAccess.getEnumBugAccess().getNumberSignDigitTwoKeyword_0(), null); 
                
            match(input,16,FollowSets000.FOLLOW_16_in_ruleEnumBug611); 

                    createLeafNode(grammarAccess.getEnumBugAccess().getKw1Keyword_1(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:291:1: ( (lv_return_2_0= ruleEnumBugEnum ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:292:1: (lv_return_2_0= ruleEnumBugEnum )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:292:1: (lv_return_2_0= ruleEnumBugEnum )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:293:3: lv_return_2_0= ruleEnumBugEnum
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getEnumBugAccess().getReturnEnumBugEnumEnumRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEnumBugEnum_in_ruleEnumBug632);
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:315:2: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:316:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:316:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:317:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEnumBug649); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:347:1: entryRuleCommentable returns [EObject current=null] : iv_ruleCommentable= ruleCommentable EOF ;
    public final EObject entryRuleCommentable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentable = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:348:2: (iv_ruleCommentable= ruleCommentable EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:349:2: iv_ruleCommentable= ruleCommentable EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommentableRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentable_in_entryRuleCommentable690);
            iv_ruleCommentable=ruleCommentable();
            _fsp--;

             current =iv_ruleCommentable; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentable700); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:356:1: ruleCommentable returns [EObject current=null] : ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) ;
    public final EObject ruleCommentable() throws RecognitionException {
        EObject current = null;

        EObject lv_item_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:361:6: ( ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:362:1: ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:362:1: ( '#3' ( (lv_item_1_0= ruleCommentableItem ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:362:3: '#3' ( (lv_item_1_0= ruleCommentableItem ) )*
            {
            match(input,17,FollowSets000.FOLLOW_17_in_ruleCommentable735); 

                    createLeafNode(grammarAccess.getCommentableAccess().getNumberSignDigitThreeKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:366:1: ( (lv_item_1_0= ruleCommentableItem ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:367:1: (lv_item_1_0= ruleCommentableItem )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:367:1: (lv_item_1_0= ruleCommentableItem )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:368:3: lv_item_1_0= ruleCommentableItem
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getCommentableAccess().getItemCommentableItemParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_ruleCommentable756);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:398:1: entryRuleCommentableItem returns [EObject current=null] : iv_ruleCommentableItem= ruleCommentableItem EOF ;
    public final EObject entryRuleCommentableItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCommentableItem = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:399:2: (iv_ruleCommentableItem= ruleCommentableItem EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:400:2: iv_ruleCommentableItem= ruleCommentableItem EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCommentableItemRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem793);
            iv_ruleCommentableItem=ruleCommentableItem();
            _fsp--;

             current =iv_ruleCommentableItem; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCommentableItem803); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:407:1: ruleCommentableItem returns [EObject current=null] : ( 'item' ( (lv_id_1_0= RULE_ID ) ) ) ;
    public final EObject ruleCommentableItem() throws RecognitionException {
        EObject current = null;

        Token lv_id_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:412:6: ( ( 'item' ( (lv_id_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:413:1: ( 'item' ( (lv_id_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:413:1: ( 'item' ( (lv_id_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:413:3: 'item' ( (lv_id_1_0= RULE_ID ) )
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleCommentableItem838); 

                    createLeafNode(grammarAccess.getCommentableItemAccess().getItemKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:417:1: ( (lv_id_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:418:1: (lv_id_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:418:1: (lv_id_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:419:3: lv_id_1_0= RULE_ID
            {
            lv_id_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCommentableItem855); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:449:1: entryRuleValueList returns [EObject current=null] : iv_ruleValueList= ruleValueList EOF ;
    public final EObject entryRuleValueList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:450:2: (iv_ruleValueList= ruleValueList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:451:2: iv_ruleValueList= ruleValueList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getValueListRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleValueList_in_entryRuleValueList896);
            iv_ruleValueList=ruleValueList();
            _fsp--;

             current =iv_ruleValueList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleValueList906); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:458:1: ruleValueList returns [EObject current=null] : ( '#4' ( (lv_ids_1_0= ruleFQN ) )* ) ;
    public final EObject ruleValueList() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_ids_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:463:6: ( ( '#4' ( (lv_ids_1_0= ruleFQN ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:464:1: ( '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:464:1: ( '#4' ( (lv_ids_1_0= ruleFQN ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:464:3: '#4' ( (lv_ids_1_0= ruleFQN ) )*
            {
            match(input,19,FollowSets000.FOLLOW_19_in_ruleValueList941); 

                    createLeafNode(grammarAccess.getValueListAccess().getNumberSignDigitFourKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:468:1: ( (lv_ids_1_0= ruleFQN ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:469:1: (lv_ids_1_0= ruleFQN )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:469:1: (lv_ids_1_0= ruleFQN )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:470:3: lv_ids_1_0= ruleFQN
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getValueListAccess().getIdsFQNParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleValueList962);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:500:1: entryRuleRefList returns [EObject current=null] : iv_ruleRefList= ruleRefList EOF ;
    public final EObject entryRuleRefList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefList = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:501:2: (iv_ruleRefList= ruleRefList EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:502:2: iv_ruleRefList= ruleRefList EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefListRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRefList_in_entryRuleRefList999);
            iv_ruleRefList=ruleRefList();
            _fsp--;

             current =iv_ruleRefList; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefList1009); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:509:1: ruleRefList returns [EObject current=null] : ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* ) ;
    public final EObject ruleRefList() throws RecognitionException {
        EObject current = null;

        EObject lv_objs_1_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:514:6: ( ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:515:1: ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:515:1: ( '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:515:3: '#5' ( (lv_objs_1_0= ruleRefObj ) )* 'refs' ( ( ruleFQN ) )*
            {
            match(input,20,FollowSets000.FOLLOW_20_in_ruleRefList1044); 

                    createLeafNode(grammarAccess.getRefListAccess().getNumberSignDigitFiveKeyword_0(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:519:1: ( (lv_objs_1_0= ruleRefObj ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:520:1: (lv_objs_1_0= ruleRefObj )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:520:1: (lv_objs_1_0= ruleRefObj )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:521:3: lv_objs_1_0= ruleRefObj
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRefListAccess().getObjsRefObjParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_ruleRefList1065);
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

            match(input,21,FollowSets000.FOLLOW_21_in_ruleRefList1076); 

                    createLeafNode(grammarAccess.getRefListAccess().getRefsKeyword_2(), null); 
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:547:1: ( ( ruleFQN ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:548:1: ( ruleFQN )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:548:1: ( ruleFQN )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:549:3: ruleFQN
            	    {

            	    			if (current==null) {
            	    	            current = factory.create(grammarAccess.getRefListRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	            
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getRefListAccess().getRefsRefObjCrossReference_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefList1099);
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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:571:1: entryRuleRefObj returns [EObject current=null] : iv_ruleRefObj= ruleRefObj EOF ;
    public final EObject entryRuleRefObj() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRefObj = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:572:2: (iv_ruleRefObj= ruleRefObj EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:573:2: iv_ruleRefObj= ruleRefObj EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRefObjRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRefObj_in_entryRuleRefObj1136);
            iv_ruleRefObj=ruleRefObj();
            _fsp--;

             current =iv_ruleRefObj; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRefObj1146); 

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
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:580:1: ruleRefObj returns [EObject current=null] : ( (lv_name_0_0= ruleFQN ) ) ;
    public final EObject ruleRefObj() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:585:6: ( ( (lv_name_0_0= ruleFQN ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:586:1: ( (lv_name_0_0= ruleFQN ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:586:1: ( (lv_name_0_0= ruleFQN ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:587:1: (lv_name_0_0= ruleFQN )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:587:1: (lv_name_0_0= ruleFQN )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:588:3: lv_name_0_0= ruleFQN
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRefObjAccess().getNameFQNParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleRefObj1191);
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


    // $ANTLR start ruleEnumBugEnum
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:618:1: ruleEnumBugEnum returns [Enumerator current=null] : ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) ) ;
    public final Enumerator ruleEnumBugEnum() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:622:6: ( ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:623:1: ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:623:1: ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt8=1;
                }
                break;
            case 23:
                {
                alt8=2;
                }
                break;
            case 24:
                {
                alt8=3;
                }
                break;
            case 25:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("623:1: ( ( 'array' ) | ( 'object' ) | ( 'resultSet' ) | ( 'iterator' ) )", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:623:2: ( 'array' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:623:2: ( 'array' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:623:4: 'array'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_ruleEnumBugEnum1238); 

                            current = grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getArrayEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:629:6: ( 'object' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:629:6: ( 'object' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:629:8: 'object'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_ruleEnumBugEnum1253); 

                            current = grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getObjectEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:635:6: ( 'resultSet' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:635:6: ( 'resultSet' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:635:8: 'resultSet'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_ruleEnumBugEnum1268); 

                            current = grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getEnumBugEnumAccess().getResultSetEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:641:6: ( 'iterator' )
                    {
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:641:6: ( 'iterator' )
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/parsetree/reconstr/parser/antlr/internal/InternalHiddenTokensMergerTestLanguage.g:641:8: 'iterator'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_ruleEnumBugEnum1283); 

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
        public static final BitSet FOLLOW_ruleDatatypeBug286557_in_entryRuleDatatypeBug286557275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDatatypeBug286557285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDatatypeBug286557320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557341 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleDatatypeBug286557352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleDatatypeBug286557375 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleDatatypeBug286557387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN424 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN475 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleFQN494 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN509 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleEnumBug_in_entryRuleEnumBug556 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEnumBug566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEnumBug601 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleEnumBug611 = new BitSet(new long[]{0x0000000003C00000L});
        public static final BitSet FOLLOW_ruleEnumBugEnum_in_ruleEnumBug632 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEnumBug649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCommentable_in_entryRuleCommentable690 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentable700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleCommentable735 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_ruleCommentable756 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_ruleCommentableItem_in_entryRuleCommentableItem793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCommentableItem803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleCommentableItem838 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCommentableItem855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleValueList_in_entryRuleValueList896 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleValueList906 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleValueList941 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleValueList962 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefList_in_entryRuleRefList999 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefList1009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleRefList1044 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleRefObj_in_ruleRefList1065 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleRefList1076 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefList1099 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_ruleRefObj_in_entryRuleRefObj1136 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRefObj1146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleRefObj1191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleEnumBugEnum1238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_ruleEnumBugEnum1253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleEnumBugEnum1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleEnumBugEnum1283 = new BitSet(new long[]{0x0000000000000002L});
    }


}
package org.eclipse.xtext.grammarinheritance.parser.antlr.internal; 

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
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConcreteTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_REAL", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'model'", "':'", "'overriddenelement'", "'overridden other element'", "'-'", "'subrule1'", "'subrule3'", "'element'", "'overridemodel'", "'extendedmodel'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int T__12=12;
    public static final int RULE_ID=5;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=7;
    public static final int RULE_REAL=4;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int RULE_WS=10;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalConcreteTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConcreteTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConcreteTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g"; }



     	private ConcreteTestLanguageGrammarAccess grammarAccess;
     	
        public InternalConcreteTestLanguageParser(TokenStream input, IAstFactory factory, ConcreteTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "RootRule";	
       	}
       	
       	@Override
       	protected ConcreteTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRootRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:71:1: entryRuleRootRule returns [EObject current=null] : iv_ruleRootRule= ruleRootRule EOF ;
    public final EObject entryRuleRootRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRootRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:72:2: (iv_ruleRootRule= ruleRootRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:73:2: iv_ruleRootRule= ruleRootRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRootRule_in_entryRuleRootRule75);
            iv_ruleRootRule=ruleRootRule();

            state._fsp--;

             current =iv_ruleRootRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRootRule85); 

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
    // $ANTLR end "entryRuleRootRule"


    // $ANTLR start "ruleRootRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:80:1: ruleRootRule returns [EObject current=null] : (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) ;
    public final EObject ruleRootRule() throws RecognitionException {
        EObject current = null;

        EObject this_ConcreteParserRule_0 = null;

        EObject this_CallOverridenParserRule_1 = null;

        EObject this_CallExtendedParserRule_2 = null;

        EObject this_OverridableParserRule2_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:85:6: ( (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:86:1: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:86:1: (this_ConcreteParserRule_0= ruleConcreteParserRule | this_CallOverridenParserRule_1= ruleCallOverridenParserRule | this_CallExtendedParserRule_2= ruleCallExtendedParserRule | this_OverridableParserRule2_3= ruleOverridableParserRule2 )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt1=1;
                }
                break;
            case 20:
                {
                alt1=2;
                }
                break;
            case 21:
                {
                alt1=3;
                }
                break;
            case 15:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:87:5: this_ConcreteParserRule_0= ruleConcreteParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootRuleAccess().getConcreteParserRuleParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcreteParserRule_in_ruleRootRule132);
                    this_ConcreteParserRule_0=ruleConcreteParserRule();

                    state._fsp--;

                     
                            current = this_ConcreteParserRule_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:97:5: this_CallOverridenParserRule_1= ruleCallOverridenParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootRuleAccess().getCallOverridenParserRuleParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule159);
                    this_CallOverridenParserRule_1=ruleCallOverridenParserRule();

                    state._fsp--;

                     
                            current = this_CallOverridenParserRule_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:107:5: this_CallExtendedParserRule_2= ruleCallExtendedParserRule
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootRuleAccess().getCallExtendedParserRuleParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule186);
                    this_CallExtendedParserRule_2=ruleCallExtendedParserRule();

                    state._fsp--;

                     
                            current = this_CallExtendedParserRule_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:117:5: this_OverridableParserRule2_3= ruleOverridableParserRule2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getRootRuleAccess().getOverridableParserRule2ParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule2_in_ruleRootRule213);
                    this_OverridableParserRule2_3=ruleOverridableParserRule2();

                    state._fsp--;

                     
                            current = this_OverridableParserRule2_3; 
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
    // $ANTLR end "ruleRootRule"


    // $ANTLR start "entryRuleConcreteParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:133:1: entryRuleConcreteParserRule returns [EObject current=null] : iv_ruleConcreteParserRule= ruleConcreteParserRule EOF ;
    public final EObject entryRuleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:134:2: (iv_ruleConcreteParserRule= ruleConcreteParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:135:2: iv_ruleConcreteParserRule= ruleConcreteParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcreteParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule248);
            iv_ruleConcreteParserRule=ruleConcreteParserRule();

            state._fsp--;

             current =iv_ruleConcreteParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcreteParserRule258); 

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
    // $ANTLR end "entryRuleConcreteParserRule"


    // $ANTLR start "ruleConcreteParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:142:1: ruleConcreteParserRule returns [EObject current=null] : (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) ;
    public final EObject ruleConcreteParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_magicNumber_1_0=null;
        Token otherlv_2=null;
        EObject lv_elements_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:147:6: ( (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:148:1: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:148:1: (otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:148:3: otherlv_0= 'model' ( (lv_magicNumber_1_0= RULE_REAL ) ) otherlv_2= ':' ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConcreteParserRule295); 

                	createLeafNode(otherlv_0, grammarAccess.getConcreteParserRuleAccess().getModelKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:152:1: ( (lv_magicNumber_1_0= RULE_REAL ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:153:1: (lv_magicNumber_1_0= RULE_REAL )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:153:1: (lv_magicNumber_1_0= RULE_REAL )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:154:3: lv_magicNumber_1_0= RULE_REAL
            {
            lv_magicNumber_1_0=(Token)match(input,RULE_REAL,FollowSets000.FOLLOW_RULE_REAL_in_ruleConcreteParserRule312); 

            			createLeafNode(lv_magicNumber_1_0, grammarAccess.getConcreteParserRuleAccess().getMagicNumberREALTerminalRuleCall_1_0(), "magicNumber"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcreteParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"magicNumber",
            	        		lv_magicNumber_1_0, 
            	        		"REAL", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConcreteParserRule329); 

                	createLeafNode(otherlv_2, grammarAccess.getConcreteParserRuleAccess().getColonKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:180:1: ( (lv_elements_3_0= ruleInheritedParserRule ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:181:1: (lv_elements_3_0= ruleInheritedParserRule )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:181:1: (lv_elements_3_0= ruleInheritedParserRule )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:182:3: lv_elements_3_0= ruleInheritedParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConcreteParserRuleAccess().getElementsInheritedParserRuleParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule350);
            	    lv_elements_3_0=ruleInheritedParserRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getConcreteParserRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_3_0, 
            	    	        		"InheritedParserRule", 
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
    // $ANTLR end "ruleConcreteParserRule"


    // $ANTLR start "entryRuleOverridableParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:212:1: entryRuleOverridableParserRule returns [EObject current=null] : iv_ruleOverridableParserRule= ruleOverridableParserRule EOF ;
    public final EObject entryRuleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:213:2: (iv_ruleOverridableParserRule= ruleOverridableParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:214:2: iv_ruleOverridableParserRule= ruleOverridableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridableParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule387);
            iv_ruleOverridableParserRule=ruleOverridableParserRule();

            state._fsp--;

             current =iv_ruleOverridableParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridableParserRule397); 

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
    // $ANTLR end "entryRuleOverridableParserRule"


    // $ANTLR start "ruleOverridableParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:221:1: ruleOverridableParserRule returns [EObject current=null] : (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleOverridableParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:226:6: ( (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:227:1: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:227:1: (otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:227:3: otherlv_0= 'overriddenelement' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOverridableParserRule434); 

                	createLeafNode(otherlv_0, grammarAccess.getOverridableParserRuleAccess().getOverriddenelementKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:231:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:232:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:232:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:233:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOverridableParserRule451); 

            			createLeafNode(lv_name_1_0, grammarAccess.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridableParserRuleRule().getType().getClassifier());
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
    // $ANTLR end "ruleOverridableParserRule"


    // $ANTLR start "entryRuleCallOverridenParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:263:1: entryRuleCallOverridenParserRule returns [EObject current=null] : iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF ;
    public final EObject entryRuleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:264:2: (iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:265:2: iv_ruleCallOverridenParserRule= ruleCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallOverridenParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule492);
            iv_ruleCallOverridenParserRule=ruleCallOverridenParserRule();

            state._fsp--;

             current =iv_ruleCallOverridenParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallOverridenParserRule502); 

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
    // $ANTLR end "entryRuleCallOverridenParserRule"


    // $ANTLR start "ruleCallOverridenParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:272:1: ruleCallOverridenParserRule returns [EObject current=null] : ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) ;
    public final EObject ruleCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:277:6: ( ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:278:1: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:278:1: ( (lv_call_0_0= ruleAbstractCallOverridenParserRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:1: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:279:1: (lv_call_0_0= ruleAbstractCallOverridenParserRule )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:280:3: lv_call_0_0= ruleAbstractCallOverridenParserRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCallOverridenParserRuleAccess().getCallAbstractCallOverridenParserRuleParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule547);
            lv_call_0_0=ruleAbstractCallOverridenParserRule();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCallOverridenParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"call",
            	        		lv_call_0_0, 
            	        		"AbstractCallOverridenParserRule", 
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
    // $ANTLR end "ruleCallOverridenParserRule"


    // $ANTLR start "entryRuleOverridableParserRule2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:310:1: entryRuleOverridableParserRule2 returns [EObject current=null] : iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF ;
    public final EObject entryRuleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOverridableParserRule2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:311:2: (iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:312:2: iv_ruleOverridableParserRule2= ruleOverridableParserRule2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOverridableParserRule2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2582);
            iv_ruleOverridableParserRule2=ruleOverridableParserRule2();

            state._fsp--;

             current =iv_ruleOverridableParserRule2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOverridableParserRule2592); 

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
    // $ANTLR end "entryRuleOverridableParserRule2"


    // $ANTLR start "ruleOverridableParserRule2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:319:1: ruleOverridableParserRule2 returns [EObject current=null] : (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) ;
    public final EObject ruleOverridableParserRule2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_age_3_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:324:6: ( (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:325:1: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:325:1: (otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:325:3: otherlv_0= 'overridden other element' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '-' ( (lv_age_3_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleOverridableParserRule2629); 

                	createLeafNode(otherlv_0, grammarAccess.getOverridableParserRule2Access().getOverriddenOtherElementKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:329:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:330:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:330:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:331:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOverridableParserRule2646); 

            			createLeafNode(lv_name_1_0, grammarAccess.getOverridableParserRule2Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridableParserRule2Rule().getType().getClassifier());
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

            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleOverridableParserRule2663); 

                	createLeafNode(otherlv_2, grammarAccess.getOverridableParserRule2Access().getHyphenMinusKeyword_2(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:357:1: ( (lv_age_3_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:358:1: (lv_age_3_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:358:1: (lv_age_3_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:359:3: lv_age_3_0= RULE_INT
            {
            lv_age_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleOverridableParserRule2680); 

            			createLeafNode(lv_age_3_0, grammarAccess.getOverridableParserRule2Access().getAgeINTTerminalRuleCall_3_0(), "age"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getOverridableParserRule2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"age",
            	        		lv_age_3_0, 
            	        		"INT", 
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
    // $ANTLR end "ruleOverridableParserRule2"


    // $ANTLR start "entryRuleExtendableParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:389:1: entryRuleExtendableParserRule returns [EObject current=null] : iv_ruleExtendableParserRule= ruleExtendableParserRule EOF ;
    public final EObject entryRuleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendableParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:390:2: (iv_ruleExtendableParserRule= ruleExtendableParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:391:2: iv_ruleExtendableParserRule= ruleExtendableParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getExtendableParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule721);
            iv_ruleExtendableParserRule=ruleExtendableParserRule();

            state._fsp--;

             current =iv_ruleExtendableParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtendableParserRule731); 

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
    // $ANTLR end "entryRuleExtendableParserRule"


    // $ANTLR start "ruleExtendableParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:398:1: ruleExtendableParserRule returns [EObject current=null] : (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 ) ;
    public final EObject ruleExtendableParserRule() throws RecognitionException {
        EObject current = null;

        EObject this_Subrule1_0 = null;

        EObject this_Subrule2_1 = null;

        EObject this_Subrule3_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:403:6: ( (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:404:1: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:404:1: (this_Subrule1_0= ruleSubrule1 | this_Subrule2_1= ruleSubrule2 | this_Subrule3_2= ruleSubrule3 )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==17) ) {
                alt3=1;
            }
            else if ( (LA3_0==18) ) {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==RULE_ID) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==RULE_STRING) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==RULE_INT) ) {
                        alt3=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:405:5: this_Subrule1_0= ruleSubrule1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExtendableParserRuleAccess().getSubrule1ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule1_in_ruleExtendableParserRule778);
                    this_Subrule1_0=ruleSubrule1();

                    state._fsp--;

                     
                            current = this_Subrule1_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:415:5: this_Subrule2_1= ruleSubrule2
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExtendableParserRuleAccess().getSubrule2ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule2_in_ruleExtendableParserRule805);
                    this_Subrule2_1=ruleSubrule2();

                    state._fsp--;

                     
                            current = this_Subrule2_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:425:5: this_Subrule3_2= ruleSubrule3
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getExtendableParserRuleAccess().getSubrule3ParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSubrule3_in_ruleExtendableParserRule832);
                    this_Subrule3_2=ruleSubrule3();

                    state._fsp--;

                     
                            current = this_Subrule3_2; 
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
    // $ANTLR end "ruleExtendableParserRule"


    // $ANTLR start "entryRuleSubrule1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:441:1: entryRuleSubrule1 returns [EObject current=null] : iv_ruleSubrule1= ruleSubrule1 EOF ;
    public final EObject entryRuleSubrule1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule1 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:442:2: (iv_ruleSubrule1= ruleSubrule1 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:443:2: iv_ruleSubrule1= ruleSubrule1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubrule1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule1_in_entryRuleSubrule1867);
            iv_ruleSubrule1=ruleSubrule1();

            state._fsp--;

             current =iv_ruleSubrule1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule1877); 

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
    // $ANTLR end "entryRuleSubrule1"


    // $ANTLR start "ruleSubrule1"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:450:1: ruleSubrule1 returns [EObject current=null] : (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) ;
    public final EObject ruleSubrule1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:455:6: ( (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:456:1: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:456:1: (otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:456:3: otherlv_0= 'subrule1' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSubrule1914); 

                	createLeafNode(otherlv_0, grammarAccess.getSubrule1Access().getSubrule1Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:460:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:461:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:461:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:462:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule1931); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSubrule1Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubrule1Rule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:484:2: ( (lv_sub1_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:485:1: (lv_sub1_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:485:1: (lv_sub1_2_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:486:3: lv_sub1_2_0= RULE_ID
            {
            lv_sub1_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule1953); 

            			createLeafNode(lv_sub1_2_0, grammarAccess.getSubrule1Access().getSub1IDTerminalRuleCall_2_0(), "sub1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubrule1Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"sub1",
            	        		lv_sub1_2_0, 
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
    // $ANTLR end "ruleSubrule1"


    // $ANTLR start "entryRuleSubrule2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:516:1: entryRuleSubrule2 returns [EObject current=null] : iv_ruleSubrule2= ruleSubrule2 EOF ;
    public final EObject entryRuleSubrule2() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule2 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:517:2: (iv_ruleSubrule2= ruleSubrule2 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:518:2: iv_ruleSubrule2= ruleSubrule2 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubrule2Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule2_in_entryRuleSubrule2994);
            iv_ruleSubrule2=ruleSubrule2();

            state._fsp--;

             current =iv_ruleSubrule2; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule21004); 

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
    // $ANTLR end "entryRuleSubrule2"


    // $ANTLR start "ruleSubrule2"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:525:1: ruleSubrule2 returns [EObject current=null] : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSubrule2() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub2_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:530:6: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:531:1: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:531:1: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:531:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub2_2_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSubrule21041); 

                	createLeafNode(otherlv_0, grammarAccess.getSubrule2Access().getSubrule3Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:535:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:536:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:536:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:537:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule21058); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSubrule2Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubrule2Rule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:559:2: ( (lv_sub2_2_0= RULE_STRING ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:560:1: (lv_sub2_2_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:560:1: (lv_sub2_2_0= RULE_STRING )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:561:3: lv_sub2_2_0= RULE_STRING
            {
            lv_sub2_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSubrule21080); 

            			createLeafNode(lv_sub2_2_0, grammarAccess.getSubrule2Access().getSub2STRINGTerminalRuleCall_2_0(), "sub2"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubrule2Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"sub2",
            	        		lv_sub2_2_0, 
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
    // $ANTLR end "ruleSubrule2"


    // $ANTLR start "entryRuleSubrule3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:591:1: entryRuleSubrule3 returns [EObject current=null] : iv_ruleSubrule3= ruleSubrule3 EOF ;
    public final EObject entryRuleSubrule3() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubrule3 = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:592:2: (iv_ruleSubrule3= ruleSubrule3 EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:593:2: iv_ruleSubrule3= ruleSubrule3 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSubrule3Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleSubrule3_in_entryRuleSubrule31121);
            iv_ruleSubrule3=ruleSubrule3();

            state._fsp--;

             current =iv_ruleSubrule3; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubrule31131); 

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
    // $ANTLR end "entryRuleSubrule3"


    // $ANTLR start "ruleSubrule3"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:600:1: ruleSubrule3 returns [EObject current=null] : (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) ;
    public final EObject ruleSubrule3() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token lv_sub1_2_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:605:6: ( (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:606:1: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:606:1: (otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:606:3: otherlv_0= 'subrule3' ( (lv_name_1_0= RULE_ID ) ) ( (lv_sub1_2_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSubrule31168); 

                	createLeafNode(otherlv_0, grammarAccess.getSubrule3Access().getSubrule3Keyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:610:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:611:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:611:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:612:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSubrule31185); 

            			createLeafNode(lv_name_1_0, grammarAccess.getSubrule3Access().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubrule3Rule().getType().getClassifier());
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

            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:634:2: ( (lv_sub1_2_0= RULE_INT ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:635:1: (lv_sub1_2_0= RULE_INT )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:635:1: (lv_sub1_2_0= RULE_INT )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:636:3: lv_sub1_2_0= RULE_INT
            {
            lv_sub1_2_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSubrule31207); 

            			createLeafNode(lv_sub1_2_0, grammarAccess.getSubrule3Access().getSub1INTTerminalRuleCall_2_0(), "sub1"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSubrule3Rule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"sub1",
            	        		lv_sub1_2_0, 
            	        		"INT", 
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
    // $ANTLR end "ruleSubrule3"


    // $ANTLR start "entryRuleCallExtendedParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:666:1: entryRuleCallExtendedParserRule returns [EObject current=null] : iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF ;
    public final EObject entryRuleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:667:2: (iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:668:2: iv_ruleCallExtendedParserRule= ruleCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getCallExtendedParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1248);
            iv_ruleCallExtendedParserRule=ruleCallExtendedParserRule();

            state._fsp--;

             current =iv_ruleCallExtendedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCallExtendedParserRule1258); 

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
    // $ANTLR end "entryRuleCallExtendedParserRule"


    // $ANTLR start "ruleCallExtendedParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:675:1: ruleCallExtendedParserRule returns [EObject current=null] : ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) ;
    public final EObject ruleCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject lv_call_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:680:6: ( ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:681:1: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:681:1: ( (lv_call_0_0= ruleAbstractCallExtendedParserRule ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:682:1: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:682:1: (lv_call_0_0= ruleAbstractCallExtendedParserRule )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:683:3: lv_call_0_0= ruleAbstractCallExtendedParserRule
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getCallExtendedParserRuleAccess().getCallAbstractCallExtendedParserRuleParserRuleCall_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1303);
            lv_call_0_0=ruleAbstractCallExtendedParserRule();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getCallExtendedParserRuleRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"call",
            	        		lv_call_0_0, 
            	        		"AbstractCallExtendedParserRule", 
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
    // $ANTLR end "ruleCallExtendedParserRule"


    // $ANTLR start "entryRuleInheritedParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:713:1: entryRuleInheritedParserRule returns [EObject current=null] : iv_ruleInheritedParserRule= ruleInheritedParserRule EOF ;
    public final EObject entryRuleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritedParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:714:2: (iv_ruleInheritedParserRule= ruleInheritedParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:715:2: iv_ruleInheritedParserRule= ruleInheritedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getInheritedParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1338);
            iv_ruleInheritedParserRule=ruleInheritedParserRule();

            state._fsp--;

             current =iv_ruleInheritedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInheritedParserRule1348); 

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
    // $ANTLR end "entryRuleInheritedParserRule"


    // $ANTLR start "ruleInheritedParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:722:1: ruleInheritedParserRule returns [EObject current=null] : (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInheritedParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:727:6: ( (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:728:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:728:1: (otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:728:3: otherlv_0= 'element' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleInheritedParserRule1385); 

                	createLeafNode(otherlv_0, grammarAccess.getInheritedParserRuleAccess().getElementKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:732:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:733:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:733:1: (lv_name_1_0= RULE_ID )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:734:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInheritedParserRule1402); 

            			createLeafNode(lv_name_1_0, grammarAccess.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getInheritedParserRuleRule().getType().getClassifier());
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
    // $ANTLR end "ruleInheritedParserRule"


    // $ANTLR start "entryRuleAbstractCallOverridenParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:764:1: entryRuleAbstractCallOverridenParserRule returns [EObject current=null] : iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF ;
    public final EObject entryRuleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallOverridenParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:765:2: (iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:766:2: iv_ruleAbstractCallOverridenParserRule= ruleAbstractCallOverridenParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractCallOverridenParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1443);
            iv_ruleAbstractCallOverridenParserRule=ruleAbstractCallOverridenParserRule();

            state._fsp--;

             current =iv_ruleAbstractCallOverridenParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1453); 

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
    // $ANTLR end "entryRuleAbstractCallOverridenParserRule"


    // $ANTLR start "ruleAbstractCallOverridenParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:773:1: ruleAbstractCallOverridenParserRule returns [EObject current=null] : (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) ;
    public final EObject ruleAbstractCallOverridenParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:778:6: ( (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:779:1: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:779:1: (otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:779:3: otherlv_0= 'overridemodel' ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            {
            otherlv_0=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleAbstractCallOverridenParserRule1490); 

                	createLeafNode(otherlv_0, grammarAccess.getAbstractCallOverridenParserRuleAccess().getOverridemodelKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:783:1: ( (lv_elements_1_0= ruleOverridableParserRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:784:1: (lv_elements_1_0= ruleOverridableParserRule )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:784:1: (lv_elements_1_0= ruleOverridableParserRule )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:785:3: lv_elements_1_0= ruleOverridableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAbstractCallOverridenParserRuleAccess().getElementsOverridableParserRuleParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1511);
            	    lv_elements_1_0=ruleOverridableParserRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAbstractCallOverridenParserRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_1_0, 
            	    	        		"OverridableParserRule", 
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
    // $ANTLR end "ruleAbstractCallOverridenParserRule"


    // $ANTLR start "entryRuleAbstractCallExtendedParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:815:1: entryRuleAbstractCallExtendedParserRule returns [EObject current=null] : iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF ;
    public final EObject entryRuleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractCallExtendedParserRule = null;


        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:816:2: (iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:817:2: iv_ruleAbstractCallExtendedParserRule= ruleAbstractCallExtendedParserRule EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractCallExtendedParserRuleRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1548);
            iv_ruleAbstractCallExtendedParserRule=ruleAbstractCallExtendedParserRule();

            state._fsp--;

             current =iv_ruleAbstractCallExtendedParserRule; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1558); 

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
    // $ANTLR end "entryRuleAbstractCallExtendedParserRule"


    // $ANTLR start "ruleAbstractCallExtendedParserRule"
    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:824:1: ruleAbstractCallExtendedParserRule returns [EObject current=null] : (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) ;
    public final EObject ruleAbstractCallExtendedParserRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_elements_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:829:6: ( (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* ) )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:830:1: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            {
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:830:1: (otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )* )
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:830:3: otherlv_0= 'extendedmodel' ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            {
            otherlv_0=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAbstractCallExtendedParserRule1595); 

                	createLeafNode(otherlv_0, grammarAccess.getAbstractCallExtendedParserRuleAccess().getExtendedmodelKeyword_0(), null);
                
            // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:834:1: ( (lv_elements_1_0= ruleExtendableParserRule ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=17 && LA5_0<=18)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:835:1: (lv_elements_1_0= ruleExtendableParserRule )
            	    {
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:835:1: (lv_elements_1_0= ruleExtendableParserRule )
            	    // ../org.eclipse.xtext.tests/src-gen/org/eclipse/xtext/grammarinheritance/parser/antlr/internal/InternalConcreteTestLanguage.g:836:3: lv_elements_1_0= ruleExtendableParserRule
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAbstractCallExtendedParserRuleAccess().getElementsExtendableParserRuleParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1616);
            	    lv_elements_1_0=ruleExtendableParserRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAbstractCallExtendedParserRuleRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_1_0, 
            	    	        		"ExtendableParserRule", 
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
    // $ANTLR end "ruleAbstractCallExtendedParserRule"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRootRule_in_entryRuleRootRule75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRootRule85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteParserRule_in_ruleRootRule132 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_ruleRootRule159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_ruleRootRule186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule2_in_ruleRootRule213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcreteParserRule_in_entryRuleConcreteParserRule248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcreteParserRule258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConcreteParserRule295 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_REAL_in_ruleConcreteParserRule312 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConcreteParserRule329 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleInheritedParserRule_in_ruleConcreteParserRule350 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule_in_entryRuleOverridableParserRule387 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_ruleOverridableParserRule434 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallOverridenParserRule_in_entryRuleCallOverridenParserRule492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallOverridenParserRule502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_ruleCallOverridenParserRule547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule2_in_entryRuleOverridableParserRule2582 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOverridableParserRule2592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleOverridableParserRule2629 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOverridableParserRule2646 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOverridableParserRule2663 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleOverridableParserRule2680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtendableParserRule_in_entryRuleExtendableParserRule721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtendableParserRule731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule1_in_ruleExtendableParserRule778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule2_in_ruleExtendableParserRule805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule3_in_ruleExtendableParserRule832 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule1_in_entryRuleSubrule1867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule1877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleSubrule1914 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1931 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule1953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule2_in_entryRuleSubrule2994 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule21004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSubrule21041 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule21058 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSubrule21080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubrule3_in_entryRuleSubrule31121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubrule31131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleSubrule31168 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSubrule31185 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSubrule31207 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCallExtendedParserRule_in_entryRuleCallExtendedParserRule1248 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCallExtendedParserRule1258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_ruleCallExtendedParserRule1303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInheritedParserRule_in_entryRuleInheritedParserRule1338 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInheritedParserRule1348 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleInheritedParserRule1385 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInheritedParserRule1402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractCallOverridenParserRule_in_entryRuleAbstractCallOverridenParserRule1443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallOverridenParserRule1453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleAbstractCallOverridenParserRule1490 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleOverridableParserRule_in_ruleAbstractCallOverridenParserRule1511 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_ruleAbstractCallExtendedParserRule_in_entryRuleAbstractCallExtendedParserRule1548 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractCallExtendedParserRule1558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_ruleAbstractCallExtendedParserRule1595 = new BitSet(new long[]{0x0000000000060002L});
        public static final BitSet FOLLOW_ruleExtendableParserRule_in_ruleAbstractCallExtendedParserRule1616 = new BitSet(new long[]{0x0000000000060002L});
    }


}
package org.eclipse.xtext.xtext.ui.ecore2xtext.parser.antlr.internal; 

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
import org.eclipse.xtext.xtext.ui.ecore2xtext.services.Ecore2XtextTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEcore2XtextTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Root'", "'{'", "'classes'", "','", "'}'", "'concrete0'", "'INT'", "'Concrete0'", "'Concrete1'", "'DiamondInheritance'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int RULE_ID=5;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=4;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int T__16=16;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalEcore2XtextTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEcore2XtextTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEcore2XtextTestParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g"; }



     	private Ecore2XtextTestGrammarAccess grammarAccess;
     	
        public InternalEcore2XtextTestParser(TokenStream input, IAstFactory factory, Ecore2XtextTestGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	}
       	
       	@Override
       	protected Ecore2XtextTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleRoot"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:71:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:72:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:73:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();

            state._fsp--;

             current =iv_ruleRoot; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot85); 

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
    // $ANTLR end "entryRuleRoot"


    // $ANTLR start "ruleRoot"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:80:1: ruleRoot returns [EObject current=null] : ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_classes_6_0 = null;

        EObject lv_classes_8_0 = null;

        EObject lv_concrete0_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:85:6: ( ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:86:1: ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:86:1: ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:86:2: () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}'
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:86:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:87:5: 
            {
             
                    temp=factory.create(grammarAccess.getRootAccess().getRootAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getRootAccess().getRootAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot131); 

                	createLeafNode(otherlv_1, grammarAccess.getRootAccess().getRootKeyword_1(), null);
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:101:1: ( (lv_name_2_0= ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:102:1: (lv_name_2_0= ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:102:1: (lv_name_2_0= ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:103:3: lv_name_2_0= ruleINT0
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_ruleRoot152);
            lv_name_2_0=ruleINT0();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"INT0", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot164); 

                	createLeafNode(otherlv_3, grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3(), null);
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:129:1: (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:129:3: otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot177); 

                        	createLeafNode(otherlv_4, grammarAccess.getRootAccess().getClassesKeyword_4_0(), null);
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot189); 

                        	createLeafNode(otherlv_5, grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1(), null);
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:137:1: ( (lv_classes_6_0= ruleAbstract ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:138:1: (lv_classes_6_0= ruleAbstract )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:138:1: (lv_classes_6_0= ruleAbstract )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:139:3: lv_classes_6_0= ruleAbstract
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot210);
                    lv_classes_6_0=ruleAbstract();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"classes",
                    	        		lv_classes_6_0, 
                    	        		"Abstract", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:161:2: (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:161:4: otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot223); 

                    	        	createLeafNode(otherlv_7, grammarAccess.getRootAccess().getCommaKeyword_4_3_0(), null);
                    	        
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:165:1: ( (lv_classes_8_0= ruleAbstract ) )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:166:1: (lv_classes_8_0= ruleAbstract )
                    	    {
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:166:1: (lv_classes_8_0= ruleAbstract )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:167:3: lv_classes_8_0= ruleAbstract
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot244);
                    	    lv_classes_8_0=ruleAbstract();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"classes",
                    	    	        		lv_classes_8_0, 
                    	    	        		"Abstract", 
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

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot258); 

                        	createLeafNode(otherlv_9, grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4(), null);
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:193:3: (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:193:5: otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRoot273); 

                        	createLeafNode(otherlv_10, grammarAccess.getRootAccess().getConcrete0Keyword_5_0(), null);
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:197:1: ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:198:1: (lv_concrete0_11_0= ruleConcrete0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:198:1: (lv_concrete0_11_0= ruleConcrete0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:199:3: lv_concrete0_11_0= ruleConcrete0
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_ruleRoot294);
                    lv_concrete0_11_0=ruleConcrete0();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"concrete0",
                    	        		lv_concrete0_11_0, 
                    	        		"Concrete0", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot308); 

                	createLeafNode(otherlv_12, grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6(), null);
                

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
    // $ANTLR end "ruleRoot"


    // $ANTLR start "entryRuleAbstract"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:233:1: entryRuleAbstract returns [EObject current=null] : iv_ruleAbstract= ruleAbstract EOF ;
    public final EObject entryRuleAbstract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstract = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:234:2: (iv_ruleAbstract= ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:235:2: iv_ruleAbstract= ruleAbstract EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract344);
            iv_ruleAbstract=ruleAbstract();

            state._fsp--;

             current =iv_ruleAbstract; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract354); 

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
    // $ANTLR end "entryRuleAbstract"


    // $ANTLR start "ruleAbstract"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:242:1: ruleAbstract returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) ;
    public final EObject ruleAbstract() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_Concrete1_Impl_1 = null;

        EObject this_DiamondInheritance_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:247:6: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:248:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:248:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt4=1;
                }
                break;
            case 19:
                {
                alt4=2;
                }
                break;
            case 20:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:249:5: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleAbstract401);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();

                    state._fsp--;

                     
                            current = this_Concrete0_Impl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:259:5: this_Concrete1_Impl_1= ruleConcrete1_Impl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_ruleAbstract428);
                    this_Concrete1_Impl_1=ruleConcrete1_Impl();

                    state._fsp--;

                     
                            current = this_Concrete1_Impl_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:269:5: this_DiamondInheritance_2= ruleDiamondInheritance
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleAbstract455);
                    this_DiamondInheritance_2=ruleDiamondInheritance();

                    state._fsp--;

                     
                            current = this_DiamondInheritance_2; 
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
    // $ANTLR end "ruleAbstract"


    // $ANTLR start "entryRuleConcrete0"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:285:1: entryRuleConcrete0 returns [EObject current=null] : iv_ruleConcrete0= ruleConcrete0 EOF ;
    public final EObject entryRuleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:286:2: (iv_ruleConcrete0= ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:287:2: iv_ruleConcrete0= ruleConcrete0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0490);
            iv_ruleConcrete0=ruleConcrete0();

            state._fsp--;

             current =iv_ruleConcrete0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0500); 

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
    // $ANTLR end "entryRuleConcrete0"


    // $ANTLR start "ruleConcrete0"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:294:1: ruleConcrete0 returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) ;
    public final EObject ruleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_DiamondInheritance_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:299:6: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:300:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:300:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==20) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:301:5: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0547);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();

                    state._fsp--;

                     
                            current = this_Concrete0_Impl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:311:5: this_DiamondInheritance_1= ruleDiamondInheritance
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleConcrete0574);
                    this_DiamondInheritance_1=ruleDiamondInheritance();

                    state._fsp--;

                     
                            current = this_DiamondInheritance_1; 
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
    // $ANTLR end "ruleConcrete0"


    // $ANTLR start "entryRuleINT0"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:327:1: entryRuleINT0 returns [String current=null] : iv_ruleINT0= ruleINT0 EOF ;
    public final String entryRuleINT0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:328:2: (iv_ruleINT0= ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:329:2: iv_ruleINT0= ruleINT0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getINT0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0610);
            iv_ruleINT0=ruleINT0();

            state._fsp--;

             current =iv_ruleINT0.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0621); 

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
    // $ANTLR end "entryRuleINT0"


    // $ANTLR start "ruleINT0"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:336:1: ruleINT0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'INT' ;
    public final AntlrDatatypeRuleToken ruleINT0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:341:6: (kw= 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:343:2: kw= 'INT'
            {
            kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleINT0658); 

                    current.merge(kw);
                    createLeafNode(kw, grammarAccess.getINT0Access().getINTKeyword(), null); 
                

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
    // $ANTLR end "ruleINT0"


    // $ANTLR start "entryRuleConcrete0_Impl"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:356:1: entryRuleConcrete0_Impl returns [EObject current=null] : iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF ;
    public final EObject entryRuleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:357:2: (iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:358:2: iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete0_ImplRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl697);
            iv_ruleConcrete0_Impl=ruleConcrete0_Impl();

            state._fsp--;

             current =iv_ruleConcrete0_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0_Impl707); 

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
    // $ANTLR end "entryRuleConcrete0_Impl"


    // $ANTLR start "ruleConcrete0_Impl"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:365:1: ruleConcrete0_Impl returns [EObject current=null] : ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:370:6: ( ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:371:1: ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:371:1: ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:371:2: () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:371:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:372:5: 
            {
             
                    temp=factory.create(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleConcrete0_Impl753); 

                	createLeafNode(otherlv_1, grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1(), null);
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:386:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:387:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:387:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:388:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete0_Impl774);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcrete0_ImplRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"EString", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleConcrete0_Impl"


    // $ANTLR start "entryRuleEString"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:418:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:419:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:420:2: iv_ruleEString= ruleEString EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEStringRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString811);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString822); 

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
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:427:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:432:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:433:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:433:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:433:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString862); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:441:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString888); 

                    		current.merge(this_ID_1);
                        
                     
                        createLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1(), null); 
                        

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
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleConcrete1_Impl"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:456:1: entryRuleConcrete1_Impl returns [EObject current=null] : iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF ;
    public final EObject entryRuleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete1_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:457:2: (iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:458:2: iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete1_ImplRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl933);
            iv_ruleConcrete1_Impl=ruleConcrete1_Impl();

            state._fsp--;

             current =iv_ruleConcrete1_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1_Impl943); 

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
    // $ANTLR end "entryRuleConcrete1_Impl"


    // $ANTLR start "ruleConcrete1_Impl"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:465:1: ruleConcrete1_Impl returns [EObject current=null] : ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:470:6: ( ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:471:1: ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:471:1: ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:471:2: () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:471:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:472:5: 
            {
             
                    temp=factory.create(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleConcrete1_Impl989); 

                	createLeafNode(otherlv_1, grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1(), null);
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:486:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:487:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:487:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:488:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete1_Impl1010);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcrete1_ImplRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"EString", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleConcrete1_Impl"


    // $ANTLR start "entryRuleDiamondInheritance"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:518:1: entryRuleDiamondInheritance returns [EObject current=null] : iv_ruleDiamondInheritance= ruleDiamondInheritance EOF ;
    public final EObject entryRuleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiamondInheritance = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:519:2: (iv_ruleDiamondInheritance= ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:520:2: iv_ruleDiamondInheritance= ruleDiamondInheritance EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDiamondInheritanceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance1046);
            iv_ruleDiamondInheritance=ruleDiamondInheritance();

            state._fsp--;

             current =iv_ruleDiamondInheritance; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDiamondInheritance1056); 

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
    // $ANTLR end "entryRuleDiamondInheritance"


    // $ANTLR start "ruleDiamondInheritance"
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:527:1: ruleDiamondInheritance returns [EObject current=null] : ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:532:6: ( ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:533:1: ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:533:1: ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:533:2: () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:533:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:534:5: 
            {
             
                    temp=factory.create(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDiamondInheritance1102); 

                	createLeafNode(otherlv_1, grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1(), null);
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:548:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:549:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:549:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:550:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDiamondInheritance1123);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getDiamondInheritanceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_2_0, 
            	        		"EString", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

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
    // $ANTLR end "ruleDiamondInheritance"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot131 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleINT0_in_ruleRoot152 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot164 = new BitSet(new long[]{0x000000000001A000L});
        public static final BitSet FOLLOW_13_in_ruleRoot177 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot189 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot210 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleRoot223 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot244 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleRoot258 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_16_in_ruleRoot273 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleConcrete0_in_ruleRoot294 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleRoot308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract344 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_ruleAbstract401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_ruleAbstract428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_ruleAbstract455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0490 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_ruleConcrete0574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0610 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleINT0658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl697 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0_Impl707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleConcrete0_Impl753 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete0_Impl774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl933 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1_Impl943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleConcrete1_Impl989 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete1_Impl1010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance1046 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDiamondInheritance1056 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleDiamondInheritance1102 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDiamondInheritance1123 = new BitSet(new long[]{0x0000000000000002L});
    }


}
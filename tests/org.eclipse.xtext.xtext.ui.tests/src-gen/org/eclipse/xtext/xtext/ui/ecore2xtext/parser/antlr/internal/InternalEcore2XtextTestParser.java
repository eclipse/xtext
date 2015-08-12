package org.eclipse.xtext.xtext.ui.ecore2xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
    public static final int RULE_ID=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

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
     	
        public InternalEcore2XtextTestParser(TokenStream input, Ecore2XtextTestGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:67:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:68:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:69:2: iv_ruleRoot= ruleRoot EOF
            {
             newCompositeNode(grammarAccess.getRootRule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:76:1: ruleRoot returns [EObject current=null] : ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' ) ;
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


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:79:28: ( ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:80:1: ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:80:1: ( () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:80:2: () otherlv_1= 'Root' ( (lv_name_2_0= ruleINT0 ) ) otherlv_3= '{' (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )? (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? otherlv_12= '}'
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:80:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRootAccess().getRootAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot131); 

                	newLeafNode(otherlv_1, grammarAccess.getRootAccess().getRootKeyword_1());
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:90:1: ( (lv_name_2_0= ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:91:1: (lv_name_2_0= ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:91:1: (lv_name_2_0= ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:92:3: lv_name_2_0= ruleINT0
            {
             
            	        newCompositeNode(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_ruleRoot152);
            lv_name_2_0=ruleINT0();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRootRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.INT0");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot164); 

                	newLeafNode(otherlv_3, grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:112:1: (otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:112:3: otherlv_4= 'classes' otherlv_5= '{' ( (lv_classes_6_0= ruleAbstract ) ) (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )* otherlv_9= '}'
                    {
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot177); 

                        	newLeafNode(otherlv_4, grammarAccess.getRootAccess().getClassesKeyword_4_0());
                        
                    otherlv_5=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot189); 

                        	newLeafNode(otherlv_5, grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:120:1: ( (lv_classes_6_0= ruleAbstract ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:121:1: (lv_classes_6_0= ruleAbstract )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:121:1: (lv_classes_6_0= ruleAbstract )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:122:3: lv_classes_6_0= ruleAbstract
                    {
                     
                    	        newCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot210);
                    lv_classes_6_0=ruleAbstract();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRootRule());
                    	        }
                           		add(
                           			current, 
                           			"classes",
                            		lv_classes_6_0, 
                            		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.Abstract");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:138:2: (otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:138:4: otherlv_7= ',' ( (lv_classes_8_0= ruleAbstract ) )
                    	    {
                    	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot223); 

                    	        	newLeafNode(otherlv_7, grammarAccess.getRootAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:142:1: ( (lv_classes_8_0= ruleAbstract ) )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:143:1: (lv_classes_8_0= ruleAbstract )
                    	    {
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:143:1: (lv_classes_8_0= ruleAbstract )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:144:3: lv_classes_8_0= ruleAbstract
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot244);
                    	    lv_classes_8_0=ruleAbstract();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRootRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"classes",
                    	            		lv_classes_8_0, 
                    	            		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.Abstract");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot258); 

                        	newLeafNode(otherlv_9, grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:164:3: (otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:164:5: otherlv_10= 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    {
                    otherlv_10=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleRoot273); 

                        	newLeafNode(otherlv_10, grammarAccess.getRootAccess().getConcrete0Keyword_5_0());
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:168:1: ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:169:1: (lv_concrete0_11_0= ruleConcrete0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:169:1: (lv_concrete0_11_0= ruleConcrete0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:170:3: lv_concrete0_11_0= ruleConcrete0
                    {
                     
                    	        newCompositeNode(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_ruleRoot294);
                    lv_concrete0_11_0=ruleConcrete0();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRootRule());
                    	        }
                           		set(
                           			current, 
                           			"concrete0",
                            		lv_concrete0_11_0, 
                            		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.Concrete0");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot308); 

                	newLeafNode(otherlv_12, grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:198:1: entryRuleAbstract returns [EObject current=null] : iv_ruleAbstract= ruleAbstract EOF ;
    public final EObject entryRuleAbstract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstract = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:199:2: (iv_ruleAbstract= ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:200:2: iv_ruleAbstract= ruleAbstract EOF
            {
             newCompositeNode(grammarAccess.getAbstractRule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:207:1: ruleAbstract returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) ;
    public final EObject ruleAbstract() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_Concrete1_Impl_1 = null;

        EObject this_DiamondInheritance_2 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:210:28: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:211:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:211:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
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
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:212:5: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleAbstract401);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();

                    state._fsp--;

                     
                            current = this_Concrete0_Impl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:222:5: this_Concrete1_Impl_1= ruleConcrete1_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_ruleAbstract428);
                    this_Concrete1_Impl_1=ruleConcrete1_Impl();

                    state._fsp--;

                     
                            current = this_Concrete1_Impl_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:232:5: this_DiamondInheritance_2= ruleDiamondInheritance
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleAbstract455);
                    this_DiamondInheritance_2=ruleDiamondInheritance();

                    state._fsp--;

                     
                            current = this_DiamondInheritance_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:248:1: entryRuleConcrete0 returns [EObject current=null] : iv_ruleConcrete0= ruleConcrete0 EOF ;
    public final EObject entryRuleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:249:2: (iv_ruleConcrete0= ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:250:2: iv_ruleConcrete0= ruleConcrete0 EOF
            {
             newCompositeNode(grammarAccess.getConcrete0Rule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:257:1: ruleConcrete0 returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) ;
    public final EObject ruleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_DiamondInheritance_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:260:28: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:261:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:261:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
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
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:262:5: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                     
                            newCompositeNode(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0547);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();

                    state._fsp--;

                     
                            current = this_Concrete0_Impl_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:272:5: this_DiamondInheritance_1= ruleDiamondInheritance
                    {
                     
                            newCompositeNode(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleConcrete0574);
                    this_DiamondInheritance_1=ruleDiamondInheritance();

                    state._fsp--;

                     
                            current = this_DiamondInheritance_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:288:1: entryRuleINT0 returns [String current=null] : iv_ruleINT0= ruleINT0 EOF ;
    public final String entryRuleINT0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:289:2: (iv_ruleINT0= ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:290:2: iv_ruleINT0= ruleINT0 EOF
            {
             newCompositeNode(grammarAccess.getINT0Rule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:297:1: ruleINT0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'INT' ;
    public final AntlrDatatypeRuleToken ruleINT0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:300:28: (kw= 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:302:2: kw= 'INT'
            {
            kw=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleINT0658); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getINT0Access().getINTKeyword()); 
                

            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:315:1: entryRuleConcrete0_Impl returns [EObject current=null] : iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF ;
    public final EObject entryRuleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:316:2: (iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:317:2: iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF
            {
             newCompositeNode(grammarAccess.getConcrete0_ImplRule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:324:1: ruleConcrete0_Impl returns [EObject current=null] : ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:327:28: ( ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:328:1: ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:328:1: ( () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:328:2: () otherlv_1= 'Concrete0' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:328:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:329:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleConcrete0_Impl753); 

                	newLeafNode(otherlv_1, grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1());
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:338:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:339:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:339:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:340:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete0_Impl774);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConcrete0_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:364:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:365:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:366:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:373:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:376:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString862); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:385:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString888); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:400:1: entryRuleConcrete1_Impl returns [EObject current=null] : iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF ;
    public final EObject entryRuleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete1_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:401:2: (iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:402:2: iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF
            {
             newCompositeNode(grammarAccess.getConcrete1_ImplRule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:409:1: ruleConcrete1_Impl returns [EObject current=null] : ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:412:28: ( ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:413:1: ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:413:1: ( () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:413:2: () otherlv_1= 'Concrete1' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:413:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:414:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleConcrete1_Impl989); 

                	newLeafNode(otherlv_1, grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1());
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:423:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:424:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:424:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:425:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete1_Impl1010);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConcrete1_ImplRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:449:1: entryRuleDiamondInheritance returns [EObject current=null] : iv_ruleDiamondInheritance= ruleDiamondInheritance EOF ;
    public final EObject entryRuleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiamondInheritance = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:450:2: (iv_ruleDiamondInheritance= ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:451:2: iv_ruleDiamondInheritance= ruleDiamondInheritance EOF
            {
             newCompositeNode(grammarAccess.getDiamondInheritanceRule()); 
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:458:1: ruleDiamondInheritance returns [EObject current=null] : ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:461:28: ( ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:462:1: ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:462:1: ( () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:462:2: () otherlv_1= 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:462:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:463:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleDiamondInheritance1102); 

                	newLeafNode(otherlv_1, grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1());
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:472:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:473:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:473:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:474:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDiamondInheritance1123);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDiamondInheritanceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.xtext.ui.ecore2xtext.Ecore2XtextTest.EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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
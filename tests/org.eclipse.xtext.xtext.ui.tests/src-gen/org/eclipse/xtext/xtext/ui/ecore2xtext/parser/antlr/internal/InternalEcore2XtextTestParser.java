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

public class InternalEcore2XtextTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Root'", "'{'", "'name'", "'classes'", "','", "'}'", "'Concrete0'", "'Concrete1'", "'INT'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEcore2XtextTestParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g"; }



     	private Ecore2XtextTestGrammarAccess grammarAccess;
     	
        public InternalEcore2XtextTestParser(TokenStream input, IAstFactory factory, Ecore2XtextTestGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Root";	
       	} 



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:72:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:73:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:74:2: iv_ruleRoot= ruleRoot EOF
            {
             currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot75);
            iv_ruleRoot=ruleRoot();
            _fsp--;

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
    // $ANTLR end entryRuleRoot


    // $ANTLR start ruleRoot
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:81:1: ruleRoot returns [EObject current=null] : ( () 'Root' '{' ( 'name' ( (lv_name_4_0= ruleINT0 ) ) )? ( 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}' )? '}' ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_classes_7_0 = null;

        EObject lv_classes_9_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:86:6: ( ( () 'Root' '{' ( 'name' ( (lv_name_4_0= ruleINT0 ) ) )? ( 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}' )? '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:87:1: ( () 'Root' '{' ( 'name' ( (lv_name_4_0= ruleINT0 ) ) )? ( 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}' )? '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:87:1: ( () 'Root' '{' ( 'name' ( (lv_name_4_0= ruleINT0 ) ) )? ( 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}' )? '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:87:2: () 'Root' '{' ( 'name' ( (lv_name_4_0= ruleINT0 ) ) )? ( 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}' )? '}'
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:87:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:88:5: 
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

            match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot129); 

                    createLeafNode(grammarAccess.getRootAccess().getRootKeyword_1(), null); 
                
            match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot139); 

                    createLeafNode(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_2(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:106:1: ( 'name' ( (lv_name_4_0= ruleINT0 ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:106:3: 'name' ( (lv_name_4_0= ruleINT0 ) )
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot150); 

                            createLeafNode(grammarAccess.getRootAccess().getNameKeyword_3_0(), null); 
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:110:1: ( (lv_name_4_0= ruleINT0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:111:1: (lv_name_4_0= ruleINT0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:111:1: (lv_name_4_0= ruleINT0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:112:3: lv_name_4_0= ruleINT0
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_3_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleINT0_in_ruleRoot171);
                    lv_name_4_0=ruleINT0();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"name",
                    	        		lv_name_4_0, 
                    	        		"INT0", 
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

            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:134:4: ( 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:134:6: 'classes' '{' ( (lv_classes_7_0= ruleAbstract ) ) ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )* '}'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot184); 

                            createLeafNode(grammarAccess.getRootAccess().getClassesKeyword_4_0(), null); 
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot194); 

                            createLeafNode(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1(), null); 
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:142:1: ( (lv_classes_7_0= ruleAbstract ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:143:1: (lv_classes_7_0= ruleAbstract )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:143:1: (lv_classes_7_0= ruleAbstract )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:144:3: lv_classes_7_0= ruleAbstract
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot215);
                    lv_classes_7_0=ruleAbstract();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"classes",
                    	        		lv_classes_7_0, 
                    	        		"Abstract", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:166:2: ( ',' ( (lv_classes_9_0= ruleAbstract ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==15) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:166:4: ',' ( (lv_classes_9_0= ruleAbstract ) )
                    	    {
                    	    match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot226); 

                    	            createLeafNode(grammarAccess.getRootAccess().getCommaKeyword_4_3_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:170:1: ( (lv_classes_9_0= ruleAbstract ) )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:171:1: (lv_classes_9_0= ruleAbstract )
                    	    {
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:171:1: (lv_classes_9_0= ruleAbstract )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:172:3: lv_classes_9_0= ruleAbstract
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot247);
                    	    lv_classes_9_0=ruleAbstract();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getRootRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"classes",
                    	    	        		lv_classes_9_0, 
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
                    	    break loop2;
                        }
                    } while (true);

                    match(input,16,FollowSets000.FOLLOW_16_in_ruleRoot259); 

                            createLeafNode(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4(), null); 
                        

                    }
                    break;

            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleRoot271); 

                    createLeafNode(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_5(), null); 
                

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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleAbstract
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:210:1: entryRuleAbstract returns [EObject current=null] : iv_ruleAbstract= ruleAbstract EOF ;
    public final EObject entryRuleAbstract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstract = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:211:2: (iv_ruleAbstract= ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:212:2: iv_ruleAbstract= ruleAbstract EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract307);
            iv_ruleAbstract=ruleAbstract();
            _fsp--;

             current =iv_ruleAbstract; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract317); 

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
    // $ANTLR end entryRuleAbstract


    // $ANTLR start ruleAbstract
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:219:1: ruleAbstract returns [EObject current=null] : (this_Concrete0_0= ruleConcrete0 | this_Concrete1_1= ruleConcrete1 ) ;
    public final EObject ruleAbstract() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_0 = null;

        EObject this_Concrete1_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:224:6: ( (this_Concrete0_0= ruleConcrete0 | this_Concrete1_1= ruleConcrete1 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:225:1: (this_Concrete0_0= ruleConcrete0 | this_Concrete1_1= ruleConcrete1 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:225:1: (this_Concrete0_0= ruleConcrete0 | this_Concrete1_1= ruleConcrete1 )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("225:1: (this_Concrete0_0= ruleConcrete0 | this_Concrete1_1= ruleConcrete1 )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:226:5: this_Concrete0_0= ruleConcrete0
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete0ParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_ruleAbstract364);
                    this_Concrete0_0=ruleConcrete0();
                    _fsp--;

                     
                            current = this_Concrete0_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:236:5: this_Concrete1_1= ruleConcrete1
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete1ParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_in_ruleAbstract391);
                    this_Concrete1_1=ruleConcrete1();
                    _fsp--;

                     
                            current = this_Concrete1_1; 
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
    // $ANTLR end ruleAbstract


    // $ANTLR start entryRuleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:252:1: entryRuleConcrete0 returns [EObject current=null] : iv_ruleConcrete0= ruleConcrete0 EOF ;
    public final EObject entryRuleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:253:2: (iv_ruleConcrete0= ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:254:2: iv_ruleConcrete0= ruleConcrete0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0426);
            iv_ruleConcrete0=ruleConcrete0();
            _fsp--;

             current =iv_ruleConcrete0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0436); 

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
    // $ANTLR end entryRuleConcrete0


    // $ANTLR start ruleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:261:1: ruleConcrete0 returns [EObject current=null] : ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete0() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:266:6: ( ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:267:1: ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:267:1: ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:267:2: () 'Concrete0' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:267:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:268:5: 
            {
             
                    temp=factory.create(grammarAccess.getConcrete0Access().getConcrete0Action_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getConcrete0Access().getConcrete0Action_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleConcrete0480); 

                    createLeafNode(grammarAccess.getConcrete0Access().getConcrete0Keyword_1(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:282:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:283:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:283:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:284:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete0501);
            lv_name_2_0=ruleEString();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcrete0Rule().getType().getClassifier());
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
    // $ANTLR end ruleConcrete0


    // $ANTLR start entryRuleConcrete1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:314:1: entryRuleConcrete1 returns [EObject current=null] : iv_ruleConcrete1= ruleConcrete1 EOF ;
    public final EObject entryRuleConcrete1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete1 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:315:2: (iv_ruleConcrete1= ruleConcrete1 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:316:2: iv_ruleConcrete1= ruleConcrete1 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete1Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_in_entryRuleConcrete1537);
            iv_ruleConcrete1=ruleConcrete1();
            _fsp--;

             current =iv_ruleConcrete1; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1547); 

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
    // $ANTLR end entryRuleConcrete1


    // $ANTLR start ruleConcrete1
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:323:1: ruleConcrete1 returns [EObject current=null] : ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete1() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:328:6: ( ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:329:1: ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:329:1: ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:329:2: () 'Concrete1' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:329:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:330:5: 
            {
             
                    temp=factory.create(grammarAccess.getConcrete1Access().getConcrete1Action_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getConcrete1Access().getConcrete1Action_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleConcrete1591); 

                    createLeafNode(grammarAccess.getConcrete1Access().getConcrete1Keyword_1(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:344:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:345:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:345:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:346:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConcrete1Access().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete1612);
            lv_name_2_0=ruleEString();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getConcrete1Rule().getType().getClassifier());
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
    // $ANTLR end ruleConcrete1


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:376:1: entryRuleINT0 returns [String current=null] : iv_ruleINT0= ruleINT0 EOF ;
    public final String entryRuleINT0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:2: (iv_ruleINT0= ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:378:2: iv_ruleINT0= ruleINT0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getINT0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0649);
            iv_ruleINT0=ruleINT0();
            _fsp--;

             current =iv_ruleINT0.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0660); 

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
    // $ANTLR end entryRuleINT0


    // $ANTLR start ruleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:385:1: ruleINT0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'INT' ;
    public final AntlrDatatypeRuleToken ruleINT0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:390:6: (kw= 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:392:2: kw= 'INT'
            {
            kw=(Token)input.LT(1);
            match(input,19,FollowSets000.FOLLOW_19_in_ruleINT0697); 

                    current.merge(kw);
                    createLeafNode(grammarAccess.getINT0Access().getINTKeyword(), null); 
                

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
    // $ANTLR end ruleINT0


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:405:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:406:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:407:2: iv_ruleEString= ruleEString EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEStringRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString737);
            iv_ruleEString=ruleEString();
            _fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString748); 

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
    // $ANTLR end entryRuleEString


    // $ANTLR start ruleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:414:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:419:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:420:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:420:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("420:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:420:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString788); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:428:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString814); 

                    		current.merge(this_ID_1);
                        
                     
                        createLeafNode(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1(), null); 
                        

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
    // $ANTLR end ruleEString


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot129 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot139 = new BitSet(new long[]{0x0000000000016000L});
        public static final BitSet FOLLOW_13_in_ruleRoot150 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_ruleINT0_in_ruleRoot171 = new BitSet(new long[]{0x0000000000014000L});
        public static final BitSet FOLLOW_14_in_ruleRoot184 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot194 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot215 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_15_in_ruleRoot226 = new BitSet(new long[]{0x0000000000060000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot247 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_16_in_ruleRoot259 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleRoot271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract307 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_ruleAbstract364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_in_ruleAbstract391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleConcrete0480 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete0501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_in_entryRuleConcrete1537 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleConcrete1591 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete1612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleINT0697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString814 = new BitSet(new long[]{0x0000000000000002L});
    }


}
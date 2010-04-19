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
import java.util.Map;
import java.util.HashMap;
public class InternalEcore2XtextTestParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Root'", "'{'", "'classes'", "','", "'}'", "'concrete0'", "'INT'", "'Concrete0'", "'Concrete1'", "'DiamondInheritance'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalEcore2XtextTestParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[23+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
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
       	
       	@Override
       	protected Ecore2XtextTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:83:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:84:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:85:2: iv_ruleRoot= ruleRoot EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRootRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoot_in_entryRuleRoot81);
            iv_ruleRoot=ruleRoot();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleRoot; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoot91); if (failed) return current;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:92:1: ruleRoot returns [EObject current=null] : ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_classes_6_0 = null;

        EObject lv_classes_8_0 = null;

        EObject lv_concrete0_11_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:97:6: ( ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:98:1: ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:98:1: ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:98:2: () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}'
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:98:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:99:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getRootAccess().getRootAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getRootAccess().getRootAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,11,FollowSets000.FOLLOW_11_in_ruleRoot138); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRootAccess().getRootKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:116:1: ( (lv_name_2_0= ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:117:1: (lv_name_2_0= ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:117:1: (lv_name_2_0= ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:118:3: lv_name_2_0= ruleINT0
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_ruleRoot159);
            lv_name_2_0=ruleINT0();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

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


            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot169); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3(), null); 
                  
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:144:1: ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:144:3: 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot180); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getRootAccess().getClassesKeyword_4_0(), null); 
                          
                    }
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot190); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:152:1: ( (lv_classes_6_0= ruleAbstract ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:153:1: (lv_classes_6_0= ruleAbstract )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:153:1: (lv_classes_6_0= ruleAbstract )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:154:3: lv_classes_6_0= ruleAbstract
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot211);
                    lv_classes_6_0=ruleAbstract();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

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


                    }

                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:176:2: ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:176:4: ',' ( (lv_classes_8_0= ruleAbstract ) )
                    	    {
                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot222); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getRootAccess().getCommaKeyword_4_3_0(), null); 
                    	          
                    	    }
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:180:1: ( (lv_classes_8_0= ruleAbstract ) )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:181:1: (lv_classes_8_0= ruleAbstract )
                    	    {
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:181:1: (lv_classes_8_0= ruleAbstract )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:182:3: lv_classes_8_0= ruleAbstract
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot243);
                    	    lv_classes_8_0=ruleAbstract();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

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


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot255); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:208:3: ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:208:5: 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleRoot268); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getRootAccess().getConcrete0Keyword_5_0(), null); 
                          
                    }
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:212:1: ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:213:1: (lv_concrete0_11_0= ruleConcrete0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:213:1: (lv_concrete0_11_0= ruleConcrete0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:214:3: lv_concrete0_11_0= ruleConcrete0
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_ruleRoot289);
                    lv_concrete0_11_0=ruleConcrete0();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

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


                    }
                    break;

            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot301); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleRoot


    // $ANTLR start entryRuleAbstract
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:248:1: entryRuleAbstract returns [EObject current=null] : iv_ruleAbstract= ruleAbstract EOF ;
    public final EObject entryRuleAbstract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstract = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:249:2: (iv_ruleAbstract= ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:250:2: iv_ruleAbstract= ruleAbstract EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAbstractRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract337);
            iv_ruleAbstract=ruleAbstract();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAbstract; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract347); if (failed) return current;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:257:1: ruleAbstract returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) ;
    public final EObject ruleAbstract() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_Concrete1_Impl_1 = null;

        EObject this_DiamondInheritance_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:262:6: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:263:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:263:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
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
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("263:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:264:2: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleAbstract397);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Concrete0_Impl_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:277:2: this_Concrete1_Impl_1= ruleConcrete1_Impl
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_ruleAbstract427);
                    this_Concrete1_Impl_1=ruleConcrete1_Impl();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Concrete1_Impl_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:290:2: this_DiamondInheritance_2= ruleDiamondInheritance
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleAbstract457);
                    this_DiamondInheritance_2=ruleDiamondInheritance();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_DiamondInheritance_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleAbstract


    // $ANTLR start entryRuleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:309:1: entryRuleConcrete0 returns [EObject current=null] : iv_ruleConcrete0= ruleConcrete0 EOF ;
    public final EObject entryRuleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:310:2: (iv_ruleConcrete0= ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:311:2: iv_ruleConcrete0= ruleConcrete0 EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConcrete0Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0492);
            iv_ruleConcrete0=ruleConcrete0();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleConcrete0; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0502); if (failed) return current;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:318:1: ruleConcrete0 returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) ;
    public final EObject ruleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_DiamondInheritance_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:323:6: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:324:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:324:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==20) ) {
                alt5=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("324:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:325:2: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0552);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Concrete0_Impl_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:338:2: this_DiamondInheritance_1= ruleDiamondInheritance
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleConcrete0582);
                    this_DiamondInheritance_1=ruleDiamondInheritance();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_DiamondInheritance_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleConcrete0


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:357:1: entryRuleINT0 returns [String current=null] : iv_ruleINT0= ruleINT0 EOF ;
    public final String entryRuleINT0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:358:2: (iv_ruleINT0= ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:359:2: iv_ruleINT0= ruleINT0 EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getINT0Rule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0618);
            iv_ruleINT0=ruleINT0();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleINT0.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0629); if (failed) return current;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:366:1: ruleINT0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'INT' ;
    public final AntlrDatatypeRuleToken ruleINT0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:371:6: (kw= 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:373:2: kw= 'INT'
            {
            kw=(Token)input.LT(1);
            match(input,17,FollowSets000.FOLLOW_17_in_ruleINT0666); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getINT0Access().getINTKeyword(), null); 
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleINT0


    // $ANTLR start entryRuleConcrete0_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:386:1: entryRuleConcrete0_Impl returns [EObject current=null] : iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF ;
    public final EObject entryRuleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:387:2: (iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:388:2: iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConcrete0_ImplRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl705);
            iv_ruleConcrete0_Impl=ruleConcrete0_Impl();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleConcrete0_Impl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0_Impl715); if (failed) return current;

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
    // $ANTLR end entryRuleConcrete0_Impl


    // $ANTLR start ruleConcrete0_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:395:1: ruleConcrete0_Impl returns [EObject current=null] : ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:400:6: ( ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:401:1: ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:401:1: ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:401:2: () 'Concrete0' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:401:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:402:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getConcrete0_ImplAccess().getConcrete0Action_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleConcrete0_Impl762); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:419:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:420:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:420:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:421:3: lv_name_2_0= ruleEString
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete0_Impl783);
            lv_name_2_0=ruleEString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

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


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleConcrete0_Impl


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:451:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:452:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:453:2: iv_ruleEString= ruleEString EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEStringRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString820);
            iv_ruleEString=ruleEString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEString.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString831); if (failed) return current;

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:460:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:465:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:466:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:466:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("466:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:466:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString871); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0(), null); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:474:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString897); if (failed) return current;
                    if ( backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( backtracking==0 ) {
                       
                          createLeafNode(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1(), null); 
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleEString


    // $ANTLR start entryRuleConcrete1_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:489:1: entryRuleConcrete1_Impl returns [EObject current=null] : iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF ;
    public final EObject entryRuleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete1_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:490:2: (iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:491:2: iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getConcrete1_ImplRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl942);
            iv_ruleConcrete1_Impl=ruleConcrete1_Impl();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleConcrete1_Impl; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1_Impl952); if (failed) return current;

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
    // $ANTLR end entryRuleConcrete1_Impl


    // $ANTLR start ruleConcrete1_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:498:1: ruleConcrete1_Impl returns [EObject current=null] : ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:503:6: ( ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:504:1: ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:504:1: ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:504:2: () 'Concrete1' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:504:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:505:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getConcrete1_ImplAccess().getConcrete1Action_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,19,FollowSets000.FOLLOW_19_in_ruleConcrete1_Impl999); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:522:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:523:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:523:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:524:3: lv_name_2_0= ruleEString
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete1_Impl1020);
            lv_name_2_0=ruleEString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

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


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleConcrete1_Impl


    // $ANTLR start entryRuleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:554:1: entryRuleDiamondInheritance returns [EObject current=null] : iv_ruleDiamondInheritance= ruleDiamondInheritance EOF ;
    public final EObject entryRuleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiamondInheritance = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:555:2: (iv_ruleDiamondInheritance= ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:556:2: iv_ruleDiamondInheritance= ruleDiamondInheritance EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDiamondInheritanceRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance1056);
            iv_ruleDiamondInheritance=ruleDiamondInheritance();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDiamondInheritance; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDiamondInheritance1066); if (failed) return current;

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
    // $ANTLR end entryRuleDiamondInheritance


    // $ANTLR start ruleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:563:1: ruleDiamondInheritance returns [EObject current=null] : ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:568:6: ( ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:569:1: ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:569:1: ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:569:2: () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:569:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:570:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceAction_0(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            match(input,20,FollowSets000.FOLLOW_20_in_ruleDiamondInheritance1113); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1(), null); 
                  
            }
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:587:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:588:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:588:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:589:3: lv_name_2_0= ruleEString
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDiamondInheritance1134);
            lv_name_2_0=ruleEString();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

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


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
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
    // $ANTLR end ruleDiamondInheritance


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot138 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleINT0_in_ruleRoot159 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot169 = new BitSet(new long[]{0x000000000001A000L});
        public static final BitSet FOLLOW_13_in_ruleRoot180 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot190 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot211 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleRoot222 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot243 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleRoot255 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_16_in_ruleRoot268 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_ruleConcrete0_in_ruleRoot289 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleRoot301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract337 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_ruleAbstract397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_ruleAbstract427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_ruleAbstract457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_ruleConcrete0582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0618 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0629 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleINT0666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl705 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0_Impl715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleConcrete0_Impl762 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete0_Impl783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString820 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1_Impl952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleConcrete1_Impl999 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete1_Impl1020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance1056 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDiamondInheritance1066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleDiamondInheritance1113 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDiamondInheritance1134 = new BitSet(new long[]{0x0000000000000002L});
    }


}
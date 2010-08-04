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
       	
       	@Override
       	protected Ecore2XtextTestGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleRoot
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:77:1: entryRuleRoot returns [EObject current=null] : iv_ruleRoot= ruleRoot EOF ;
    public final EObject entryRuleRoot() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoot = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:78:2: (iv_ruleRoot= ruleRoot EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:79:2: iv_ruleRoot= ruleRoot EOF
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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:86:1: ruleRoot returns [EObject current=null] : ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' ) ;
    public final EObject ruleRoot() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_classes_6_0 = null;

        EObject lv_classes_8_0 = null;

        EObject lv_concrete0_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:91:6: ( ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:92:1: ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:92:1: ( () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:92:2: () 'Root' ( (lv_name_2_0= ruleINT0 ) ) '{' ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )? ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )? '}'
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:92:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:93:5: 
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
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:107:1: ( (lv_name_2_0= ruleINT0 ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:108:1: (lv_name_2_0= ruleINT0 )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:108:1: (lv_name_2_0= ruleINT0 )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:109:3: lv_name_2_0= ruleINT0
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getNameINT0ParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_ruleRoot150);
            lv_name_2_0=ruleINT0();
            _fsp--;


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

            match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot160); 

                    createLeafNode(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:135:1: ( 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:135:3: 'classes' '{' ( (lv_classes_6_0= ruleAbstract ) ) ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )* '}'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_ruleRoot171); 

                            createLeafNode(grammarAccess.getRootAccess().getClassesKeyword_4_0(), null); 
                        
                    match(input,12,FollowSets000.FOLLOW_12_in_ruleRoot181); 

                            createLeafNode(grammarAccess.getRootAccess().getLeftCurlyBracketKeyword_4_1(), null); 
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:143:1: ( (lv_classes_6_0= ruleAbstract ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:144:1: (lv_classes_6_0= ruleAbstract )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:144:1: (lv_classes_6_0= ruleAbstract )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:145:3: lv_classes_6_0= ruleAbstract
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_2_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot202);
                    lv_classes_6_0=ruleAbstract();
                    _fsp--;


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

                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:167:2: ( ',' ( (lv_classes_8_0= ruleAbstract ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==14) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:167:4: ',' ( (lv_classes_8_0= ruleAbstract ) )
                    	    {
                    	    match(input,14,FollowSets000.FOLLOW_14_in_ruleRoot213); 

                    	            createLeafNode(grammarAccess.getRootAccess().getCommaKeyword_4_3_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:171:1: ( (lv_classes_8_0= ruleAbstract ) )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:172:1: (lv_classes_8_0= ruleAbstract )
                    	    {
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:172:1: (lv_classes_8_0= ruleAbstract )
                    	    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:173:3: lv_classes_8_0= ruleAbstract
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getClassesAbstractParserRuleCall_4_3_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_ruleRoot234);
                    	    lv_classes_8_0=ruleAbstract();
                    	    _fsp--;


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

                    match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot246); 

                            createLeafNode(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_4_4(), null); 
                        

                    }
                    break;

            }

            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:199:3: ( 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:199:5: 'concrete0' ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleRoot259); 

                            createLeafNode(grammarAccess.getRootAccess().getConcrete0Keyword_5_0(), null); 
                        
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:203:1: ( (lv_concrete0_11_0= ruleConcrete0 ) )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:204:1: (lv_concrete0_11_0= ruleConcrete0 )
                    {
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:204:1: (lv_concrete0_11_0= ruleConcrete0 )
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:205:3: lv_concrete0_11_0= ruleConcrete0
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getRootAccess().getConcrete0Concrete0ParserRuleCall_5_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_ruleRoot280);
                    lv_concrete0_11_0=ruleConcrete0();
                    _fsp--;


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

            match(input,15,FollowSets000.FOLLOW_15_in_ruleRoot292); 

                    createLeafNode(grammarAccess.getRootAccess().getRightCurlyBracketKeyword_6(), null); 
                

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:239:1: entryRuleAbstract returns [EObject current=null] : iv_ruleAbstract= ruleAbstract EOF ;
    public final EObject entryRuleAbstract() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstract = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:240:2: (iv_ruleAbstract= ruleAbstract EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:241:2: iv_ruleAbstract= ruleAbstract EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAbstractRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstract_in_entryRuleAbstract328);
            iv_ruleAbstract=ruleAbstract();
            _fsp--;

             current =iv_ruleAbstract; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstract338); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:248:1: ruleAbstract returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) ;
    public final EObject ruleAbstract() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_Concrete1_Impl_1 = null;

        EObject this_DiamondInheritance_2 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:253:6: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:254:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:254:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )
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
                    new NoViableAltException("254:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_Concrete1_Impl_1= ruleConcrete1_Impl | this_DiamondInheritance_2= ruleDiamondInheritance )", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:255:5: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete0_ImplParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleAbstract385);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();
                    _fsp--;

                     
                            current = this_Concrete0_Impl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:265:5: this_Concrete1_Impl_1= ruleConcrete1_Impl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getConcrete1_ImplParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_ruleAbstract412);
                    this_Concrete1_Impl_1=ruleConcrete1_Impl();
                    _fsp--;

                     
                            current = this_Concrete1_Impl_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:275:5: this_DiamondInheritance_2= ruleDiamondInheritance
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getAbstractAccess().getDiamondInheritanceParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleAbstract439);
                    this_DiamondInheritance_2=ruleDiamondInheritance();
                    _fsp--;

                     
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
    // $ANTLR end ruleAbstract


    // $ANTLR start entryRuleConcrete0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:291:1: entryRuleConcrete0 returns [EObject current=null] : iv_ruleConcrete0= ruleConcrete0 EOF ;
    public final EObject entryRuleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:292:2: (iv_ruleConcrete0= ruleConcrete0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:293:2: iv_ruleConcrete0= ruleConcrete0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_in_entryRuleConcrete0474);
            iv_ruleConcrete0=ruleConcrete0();
            _fsp--;

             current =iv_ruleConcrete0; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0484); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:300:1: ruleConcrete0 returns [EObject current=null] : (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) ;
    public final EObject ruleConcrete0() throws RecognitionException {
        EObject current = null;

        EObject this_Concrete0_Impl_0 = null;

        EObject this_DiamondInheritance_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:305:6: ( (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:306:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:306:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )
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
                    new NoViableAltException("306:1: (this_Concrete0_Impl_0= ruleConcrete0_Impl | this_DiamondInheritance_1= ruleDiamondInheritance )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:307:5: this_Concrete0_Impl_0= ruleConcrete0_Impl
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getConcrete0_ImplParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0531);
                    this_Concrete0_Impl_0=ruleConcrete0_Impl();
                    _fsp--;

                     
                            current = this_Concrete0_Impl_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:317:5: this_DiamondInheritance_1= ruleDiamondInheritance
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getConcrete0Access().getDiamondInheritanceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_ruleConcrete0558);
                    this_DiamondInheritance_1=ruleDiamondInheritance();
                    _fsp--;

                     
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
    // $ANTLR end ruleConcrete0


    // $ANTLR start entryRuleINT0
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:333:1: entryRuleINT0 returns [String current=null] : iv_ruleINT0= ruleINT0 EOF ;
    public final String entryRuleINT0() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINT0 = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:334:2: (iv_ruleINT0= ruleINT0 EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:335:2: iv_ruleINT0= ruleINT0 EOF
            {
             currentNode = createCompositeNode(grammarAccess.getINT0Rule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleINT0_in_entryRuleINT0594);
            iv_ruleINT0=ruleINT0();
            _fsp--;

             current =iv_ruleINT0.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleINT0605); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:342:1: ruleINT0 returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'INT' ;
    public final AntlrDatatypeRuleToken ruleINT0() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:347:6: (kw= 'INT' )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:349:2: kw= 'INT'
            {
            kw=(Token)input.LT(1);
            match(input,17,FollowSets000.FOLLOW_17_in_ruleINT0642); 

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


    // $ANTLR start entryRuleConcrete0_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:362:1: entryRuleConcrete0_Impl returns [EObject current=null] : iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF ;
    public final EObject entryRuleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete0_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:363:2: (iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:364:2: iv_ruleConcrete0_Impl= ruleConcrete0_Impl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete0_ImplRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl681);
            iv_ruleConcrete0_Impl=ruleConcrete0_Impl();
            _fsp--;

             current =iv_ruleConcrete0_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete0_Impl691); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:371:1: ruleConcrete0_Impl returns [EObject current=null] : ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete0_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:376:6: ( ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:1: ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:1: ( () 'Concrete0' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:2: () 'Concrete0' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:377:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:378:5: 
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

            match(input,18,FollowSets000.FOLLOW_18_in_ruleConcrete0_Impl735); 

                    createLeafNode(grammarAccess.getConcrete0_ImplAccess().getConcrete0Keyword_1(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:392:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:393:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:393:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:394:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConcrete0_ImplAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete0_Impl756);
            lv_name_2_0=ruleEString();
            _fsp--;


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
    // $ANTLR end ruleConcrete0_Impl


    // $ANTLR start entryRuleEString
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:424:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:425:2: (iv_ruleEString= ruleEString EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:426:2: iv_ruleEString= ruleEString EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEStringRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString793);
            iv_ruleEString=ruleEString();
            _fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString804); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:433:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:438:6: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:439:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:439:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    new NoViableAltException("439:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:439:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString844); 

                    		current.merge(this_STRING_0);
                        
                     
                        createLeafNode(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:447:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString870); 

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


    // $ANTLR start entryRuleConcrete1_Impl
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:462:1: entryRuleConcrete1_Impl returns [EObject current=null] : iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF ;
    public final EObject entryRuleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcrete1_Impl = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:463:2: (iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:464:2: iv_ruleConcrete1_Impl= ruleConcrete1_Impl EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcrete1_ImplRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl915);
            iv_ruleConcrete1_Impl=ruleConcrete1_Impl();
            _fsp--;

             current =iv_ruleConcrete1_Impl; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConcrete1_Impl925); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:471:1: ruleConcrete1_Impl returns [EObject current=null] : ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleConcrete1_Impl() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:476:6: ( ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:477:1: ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:477:1: ( () 'Concrete1' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:477:2: () 'Concrete1' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:477:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:478:5: 
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

            match(input,19,FollowSets000.FOLLOW_19_in_ruleConcrete1_Impl969); 

                    createLeafNode(grammarAccess.getConcrete1_ImplAccess().getConcrete1Keyword_1(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:492:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:493:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:493:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:494:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getConcrete1_ImplAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConcrete1_Impl990);
            lv_name_2_0=ruleEString();
            _fsp--;


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
    // $ANTLR end ruleConcrete1_Impl


    // $ANTLR start entryRuleDiamondInheritance
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:524:1: entryRuleDiamondInheritance returns [EObject current=null] : iv_ruleDiamondInheritance= ruleDiamondInheritance EOF ;
    public final EObject entryRuleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiamondInheritance = null;


        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:525:2: (iv_ruleDiamondInheritance= ruleDiamondInheritance EOF )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:526:2: iv_ruleDiamondInheritance= ruleDiamondInheritance EOF
            {
             currentNode = createCompositeNode(grammarAccess.getDiamondInheritanceRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance1026);
            iv_ruleDiamondInheritance=ruleDiamondInheritance();
            _fsp--;

             current =iv_ruleDiamondInheritance; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDiamondInheritance1036); 

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
    // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:533:1: ruleDiamondInheritance returns [EObject current=null] : ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) ;
    public final EObject ruleDiamondInheritance() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:538:6: ( ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:539:1: ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:539:1: ( () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:539:2: () 'DiamondInheritance' ( (lv_name_2_0= ruleEString ) )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:539:2: ()
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:540:5: 
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

            match(input,20,FollowSets000.FOLLOW_20_in_ruleDiamondInheritance1080); 

                    createLeafNode(grammarAccess.getDiamondInheritanceAccess().getDiamondInheritanceKeyword_1(), null); 
                
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:554:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:555:1: (lv_name_2_0= ruleEString )
            {
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:555:1: (lv_name_2_0= ruleEString )
            // ../org.eclipse.xtext.xtext.ui.tests/src-gen/org/eclipse/xtext/xtext/ui/ecore2xtext/parser/antlr/internal/InternalEcore2XtextTest.g:556:3: lv_name_2_0= ruleEString
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getDiamondInheritanceAccess().getNameEStringParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleDiamondInheritance1101);
            lv_name_2_0=ruleEString();
            _fsp--;


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
    // $ANTLR end ruleDiamondInheritance


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleRoot_in_entryRuleRoot75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoot85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleRoot129 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_ruleINT0_in_ruleRoot150 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot160 = new BitSet(new long[]{0x000000000001A000L});
        public static final BitSet FOLLOW_13_in_ruleRoot171 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleRoot181 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot202 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleRoot213 = new BitSet(new long[]{0x00000000001C0000L});
        public static final BitSet FOLLOW_ruleAbstract_in_ruleRoot234 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_15_in_ruleRoot246 = new BitSet(new long[]{0x0000000000018000L});
        public static final BitSet FOLLOW_16_in_ruleRoot259 = new BitSet(new long[]{0x0000000000140000L});
        public static final BitSet FOLLOW_ruleConcrete0_in_ruleRoot280 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleRoot292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstract_in_entryRuleAbstract328 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstract338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_ruleAbstract385 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_ruleAbstract412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_ruleAbstract439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_in_entryRuleConcrete0474 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_ruleConcrete0531 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_ruleConcrete0558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleINT0_in_entryRuleINT0594 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleINT0605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleINT0642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete0_Impl_in_entryRuleConcrete0_Impl681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete0_Impl691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleConcrete0_Impl735 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete0_Impl756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString793 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConcrete1_Impl_in_entryRuleConcrete1_Impl915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConcrete1_Impl925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleConcrete1_Impl969 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConcrete1_Impl990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDiamondInheritance_in_entryRuleDiamondInheritance1026 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDiamondInheritance1036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleDiamondInheritance1080 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleDiamondInheritance1101 = new BitSet(new long[]{0x0000000000000002L});
    }


}
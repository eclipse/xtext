package org.eclipse.xtext.parser.assignments.parser.antlr.internal; 

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
import org.eclipse.xtext.parser.assignments.services.Bug288432TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalBug288432TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "','", "')'", "'body'", "'end body'", "'content'", "'end content'", "'element'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int EOF=-1;
    public static final int RULE_INT=6;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;

        public InternalBug288432TestLanguageParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g"; }



     	private Bug288432TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug288432TestLanguageParser(TokenStream input, IAstFactory factory, Bug288432TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Body";	
       	} 



    // $ANTLR start entryRuleBody
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:72:1: entryRuleBody returns [EObject current=null] : iv_ruleBody= ruleBody EOF ;
    public final EObject entryRuleBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBody = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:72:46: (iv_ruleBody= ruleBody EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:73:2: iv_ruleBody= ruleBody EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBodyRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleBody_in_entryRuleBody73);
            iv_ruleBody=ruleBody();
            _fsp--;

             current =iv_ruleBody; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBody83); 

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
    // $ANTLR end entryRuleBody


    // $ANTLR start ruleBody
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:80:1: ruleBody returns [EObject current=null] : ( ( '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')' )? 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ 'end body' ) ;
    public final EObject ruleBody() throws RecognitionException {
        EObject current = null;

        EObject lv_parameter_1_0 = null;

        EObject lv_parameter_3_0 = null;

        EObject lv_content_6_1 = null;

        EObject lv_content_6_2 = null;

        EObject lv_foo_7_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:85:6: ( ( ( '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')' )? 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ 'end body' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:1: ( ( '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')' )? 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ 'end body' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:1: ( ( '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')' )? 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ 'end body' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:2: ( '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')' )? 'body' ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) ) ( (lv_foo_7_0= ruleFoo ) )+ 'end body'
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:2: ( '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:86:4: '(' ( (lv_parameter_1_0= ruleParameter ) ) ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )* ')'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_ruleBody119); 

                            createLeafNode(grammarAccess.getBodyAccess().getLeftParenthesisKeyword_0_0(), null); 
                        
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:90:1: ( (lv_parameter_1_0= ruleParameter ) )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:91:1: (lv_parameter_1_0= ruleParameter )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:91:1: (lv_parameter_1_0= ruleParameter )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:92:3: lv_parameter_1_0= ruleParameter
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getParameterParameterParserRuleCall_0_1_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody140);
                    lv_parameter_1_0=ruleParameter();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBodyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		add(
                    	       			current, 
                    	       			"parameter",
                    	        		lv_parameter_1_0, 
                    	        		"Parameter", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }


                    }

                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:114:2: ( ',' ( (lv_parameter_3_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==12) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:114:4: ',' ( (lv_parameter_3_0= ruleParameter ) )
                    	    {
                    	    match(input,12,FollowSets000.FOLLOW_12_in_ruleBody151); 

                    	            createLeafNode(grammarAccess.getBodyAccess().getCommaKeyword_0_2_0(), null); 
                    	        
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:118:1: ( (lv_parameter_3_0= ruleParameter ) )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:119:1: (lv_parameter_3_0= ruleParameter )
                    	    {
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:119:1: (lv_parameter_3_0= ruleParameter )
                    	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:120:3: lv_parameter_3_0= ruleParameter
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getParameterParameterParserRuleCall_0_2_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleParameter_in_ruleBody172);
                    	    lv_parameter_3_0=ruleParameter();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getBodyRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		add(
                    	    	       			current, 
                    	    	       			"parameter",
                    	    	        		lv_parameter_3_0, 
                    	    	        		"Parameter", 
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

                    match(input,13,FollowSets000.FOLLOW_13_in_ruleBody184); 

                            createLeafNode(grammarAccess.getBodyAccess().getRightParenthesisKeyword_0_3(), null); 
                        

                    }
                    break;

            }

            match(input,14,FollowSets000.FOLLOW_14_in_ruleBody196); 

                    createLeafNode(grammarAccess.getBodyAccess().getBodyKeyword_1(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:150:1: ( ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:151:1: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:151:1: ( (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:152:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:152:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("152:1: (lv_content_6_1= ruleContent | lv_content_6_2= ruleParameterRef )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:153:3: lv_content_6_1= ruleContent
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getContentContentParserRuleCall_2_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleContent_in_ruleBody219);
                    lv_content_6_1=ruleContent();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBodyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"content",
                    	        		lv_content_6_1, 
                    	        		"Content", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:174:8: lv_content_6_2= ruleParameterRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getContentParameterRefParserRuleCall_2_0_1(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleBody238);
                    lv_content_6_2=ruleParameterRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getBodyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"content",
                    	        		lv_content_6_2, 
                    	        		"ParameterRef", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:198:2: ( (lv_foo_7_0= ruleFoo ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_STRING) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:199:1: (lv_foo_7_0= ruleFoo )
            	    {
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:199:1: (lv_foo_7_0= ruleFoo )
            	    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:200:3: lv_foo_7_0= ruleFoo
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getBodyAccess().getFooFooParserRuleCall_3_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleFoo_in_ruleBody262);
            	    lv_foo_7_0=ruleFoo();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getBodyRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"foo",
            	    	        		lv_foo_7_0, 
            	    	        		"Foo", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            match(input,15,FollowSets000.FOLLOW_15_in_ruleBody273); 

                    createLeafNode(grammarAccess.getBodyAccess().getEndBodyKeyword_4(), null); 
                

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
    // $ANTLR end ruleBody


    // $ANTLR start entryRuleFoo
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:233:1: entryRuleFoo returns [EObject current=null] : iv_ruleFoo= ruleFoo EOF ;
    public final EObject entryRuleFoo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFoo = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:233:45: (iv_ruleFoo= ruleFoo EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:234:2: iv_ruleFoo= ruleFoo EOF
            {
             currentNode = createCompositeNode(grammarAccess.getFooRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleFoo_in_entryRuleFoo306);
            iv_ruleFoo=ruleFoo();
            _fsp--;

             current =iv_ruleFoo; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFoo316); 

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
    // $ANTLR end entryRuleFoo


    // $ANTLR start ruleFoo
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:241:1: ruleFoo returns [EObject current=null] : ( (lv_fooValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleFoo() throws RecognitionException {
        EObject current = null;

        Token lv_fooValue_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:246:6: ( ( (lv_fooValue_0_0= RULE_STRING ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:247:1: ( (lv_fooValue_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:247:1: ( (lv_fooValue_0_0= RULE_STRING ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:248:1: (lv_fooValue_0_0= RULE_STRING )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:248:1: (lv_fooValue_0_0= RULE_STRING )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:249:3: lv_fooValue_0_0= RULE_STRING
            {
            lv_fooValue_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFoo357); 

            			createLeafNode(grammarAccess.getFooAccess().getFooValueSTRINGTerminalRuleCall_0(), "fooValue"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getFooRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"fooValue",
            	        		lv_fooValue_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleFoo


    // $ANTLR start entryRuleContent
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:278:1: entryRuleContent returns [EObject current=null] : iv_ruleContent= ruleContent EOF ;
    public final EObject entryRuleContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContent = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:278:49: (iv_ruleContent= ruleContent EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:279:2: iv_ruleContent= ruleContent EOF
            {
             currentNode = createCompositeNode(grammarAccess.getContentRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleContent_in_entryRuleContent394);
            iv_ruleContent=ruleContent();
            _fsp--;

             current =iv_ruleContent; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleContent404); 

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
    // $ANTLR end entryRuleContent


    // $ANTLR start ruleContent
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:286:1: ruleContent returns [EObject current=null] : ( 'content' this_MyElement_1= ruleMyElement 'end content' ) ;
    public final EObject ruleContent() throws RecognitionException {
        EObject current = null;

        EObject this_MyElement_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:291:6: ( ( 'content' this_MyElement_1= ruleMyElement 'end content' ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:292:1: ( 'content' this_MyElement_1= ruleMyElement 'end content' )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:292:1: ( 'content' this_MyElement_1= ruleMyElement 'end content' )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:292:3: 'content' this_MyElement_1= ruleMyElement 'end content'
            {
            match(input,16,FollowSets000.FOLLOW_16_in_ruleContent439); 

                    createLeafNode(grammarAccess.getContentAccess().getContentKeyword_0(), null); 
                
             
                    currentNode=createCompositeNode(grammarAccess.getContentAccess().getMyElementParserRuleCall_1(), currentNode); 
                
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_ruleContent461);
            this_MyElement_1=ruleMyElement();
            _fsp--;

             
                    current = this_MyElement_1; 
                    currentNode = currentNode.getParent();
                
            match(input,17,FollowSets000.FOLLOW_17_in_ruleContent470); 

                    createLeafNode(grammarAccess.getContentAccess().getEndContentKeyword_2(), null); 
                

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
    // $ANTLR end ruleContent


    // $ANTLR start entryRuleMyElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:316:1: entryRuleMyElement returns [EObject current=null] : iv_ruleMyElement= ruleMyElement EOF ;
    public final EObject entryRuleMyElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyElement = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:316:51: (iv_ruleMyElement= ruleMyElement EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:317:2: iv_ruleMyElement= ruleMyElement EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMyElementRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMyElement_in_entryRuleMyElement503);
            iv_ruleMyElement=ruleMyElement();
            _fsp--;

             current =iv_ruleMyElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyElement513); 

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
    // $ANTLR end entryRuleMyElement


    // $ANTLR start ruleMyElement
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:324:1: ruleMyElement returns [EObject current=null] : ( 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) ;
    public final EObject ruleMyElement() throws RecognitionException {
        EObject current = null;

        EObject lv_bar_1_1 = null;

        EObject lv_bar_1_2 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:329:6: ( ( 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:330:1: ( 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:330:1: ( 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:330:3: 'element' ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            {
            match(input,18,FollowSets000.FOLLOW_18_in_ruleMyElement548); 

                    createLeafNode(grammarAccess.getMyElementAccess().getElementKeyword_0(), null); 
                
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:334:1: ( ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:335:1: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:335:1: ( (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:336:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:336:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("336:1: (lv_bar_1_1= ruleMyInt | lv_bar_1_2= ruleParameterRef )", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:337:3: lv_bar_1_1= ruleMyInt
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMyElementAccess().getBarMyIntParserRuleCall_1_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_ruleMyElement571);
                    lv_bar_1_1=ruleMyInt();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMyElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"bar",
                    	        		lv_bar_1_1, 
                    	        		"MyInt", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:358:8: lv_bar_1_2= ruleParameterRef
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getMyElementAccess().getBarParameterRefParserRuleCall_1_0_1(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_ruleMyElement590);
                    lv_bar_1_2=ruleParameterRef();
                    _fsp--;


                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getMyElementRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	        }
                    	        try {
                    	       		set(
                    	       			current, 
                    	       			"bar",
                    	        		lv_bar_1_2, 
                    	        		"ParameterRef", 
                    	        		currentNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	        currentNode = currentNode.getParent();
                    	    

                    }
                    break;

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
    // $ANTLR end ruleMyElement


    // $ANTLR start entryRuleParameter
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:391:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:391:51: (iv_ruleParameter= ruleParameter EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:392:2: iv_ruleParameter= ruleParameter EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParameter_in_entryRuleParameter628);
            iv_ruleParameter=ruleParameter();
            _fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameter638); 

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
    // $ANTLR end entryRuleParameter


    // $ANTLR start ruleParameter
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:399:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:404:6: ( ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:405:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:405:1: ( ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )? )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:405:2: ( (lv_name_0_0= RULE_ID ) ) ( ( RULE_ID ) )?
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:405:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:406:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:406:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:407:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter680); 

            			createLeafNode(grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getParameterRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:429:2: ( ( RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:430:1: ( RULE_ID )
                    {
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:430:1: ( RULE_ID )
                    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:431:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getParameterRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameter703); 

                    		createLeafNode(grammarAccess.getParameterAccess().getValueParameterObjectCrossReference_1_0(), "value"); 
                    	

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
    // $ANTLR end ruleParameter


    // $ANTLR start entryRuleParameterRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:450:1: entryRuleParameterRef returns [EObject current=null] : iv_ruleParameterRef= ruleParameterRef EOF ;
    public final EObject entryRuleParameterRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterRef = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:450:54: (iv_ruleParameterRef= ruleParameterRef EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:451:2: iv_ruleParameterRef= ruleParameterRef EOF
            {
             currentNode = createCompositeNode(grammarAccess.getParameterRefRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleParameterRef_in_entryRuleParameterRef737);
            iv_ruleParameterRef=ruleParameterRef();
            _fsp--;

             current =iv_ruleParameterRef; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleParameterRef747); 

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
    // $ANTLR end entryRuleParameterRef


    // $ANTLR start ruleParameterRef
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:458:1: ruleParameterRef returns [EObject current=null] : ( ( RULE_ID ) ) ;
    public final EObject ruleParameterRef() throws RecognitionException {
        EObject current = null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:463:6: ( ( ( RULE_ID ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:464:1: ( ( RULE_ID ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:464:1: ( ( RULE_ID ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:465:1: ( RULE_ID )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:465:1: ( RULE_ID )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:466:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getParameterRefRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleParameterRef789); 

            		createLeafNode(grammarAccess.getParameterRefAccess().getParameterParameterCrossReference_0(), "parameter"); 
            	

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
    // $ANTLR end ruleParameterRef


    // $ANTLR start entryRuleMyInt
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:485:1: entryRuleMyInt returns [EObject current=null] : iv_ruleMyInt= ruleMyInt EOF ;
    public final EObject entryRuleMyInt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMyInt = null;


        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:485:47: (iv_ruleMyInt= ruleMyInt EOF )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:486:2: iv_ruleMyInt= ruleMyInt EOF
            {
             currentNode = createCompositeNode(grammarAccess.getMyIntRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleMyInt_in_entryRuleMyInt821);
            iv_ruleMyInt=ruleMyInt();
            _fsp--;

             current =iv_ruleMyInt; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMyInt831); 

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
    // $ANTLR end entryRuleMyInt


    // $ANTLR start ruleMyInt
    // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:493:1: ruleMyInt returns [EObject current=null] : ( (lv_int_0_0= RULE_INT ) ) ;
    public final EObject ruleMyInt() throws RecognitionException {
        EObject current = null;

        Token lv_int_0_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:498:6: ( ( (lv_int_0_0= RULE_INT ) ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:499:1: ( (lv_int_0_0= RULE_INT ) )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:499:1: ( (lv_int_0_0= RULE_INT ) )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:500:1: (lv_int_0_0= RULE_INT )
            {
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:500:1: (lv_int_0_0= RULE_INT )
            // ../org.eclipse.xtext.generator.tests/src-gen/org/eclipse/xtext/parser/assignments/parser/antlr/internal/InternalBug288432TestLanguage.g:501:3: lv_int_0_0= RULE_INT
            {
            lv_int_0_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMyInt872); 

            			createLeafNode(grammarAccess.getMyIntAccess().getIntINTTerminalRuleCall_0(), "int"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getMyIntRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"int",
            	        		lv_int_0_0, 
            	        		"INT", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
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
    // $ANTLR end ruleMyInt


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBody_in_entryRuleBody73 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBody83 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleBody119 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody140 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleBody151 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleParameter_in_ruleBody172 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_13_in_ruleBody184 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleBody196 = new BitSet(new long[]{0x0000000000010020L});
        public static final BitSet FOLLOW_ruleContent_in_ruleBody219 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleBody238 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFoo_in_ruleBody262 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleBody273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFoo_in_entryRuleFoo306 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFoo316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFoo357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleContent_in_entryRuleContent394 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleContent404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleContent439 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMyElement_in_ruleContent461 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleContent470 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyElement_in_entryRuleMyElement503 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyElement513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMyElement548 = new BitSet(new long[]{0x0000000000000060L});
        public static final BitSet FOLLOW_ruleMyInt_in_ruleMyElement571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_ruleMyElement590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter628 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameter638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter680 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameter703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleParameterRef_in_entryRuleParameterRef737 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleParameterRef747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleParameterRef789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMyInt_in_entryRuleMyInt821 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMyInt831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMyInt872 = new BitSet(new long[]{0x0000000000000002L});
    }


}
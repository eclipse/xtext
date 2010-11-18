package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug289187TestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalBug289187TestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'abstract'", "'transient'", "'class'", "'extends'", "'implements'", "','", "'{'", "'classNumber'", "'='", "'quid'", "'documentation'", "'}'", "'attribute'", "'operation'", "'PRIVATE'", "'PROTECTED'", "'PACKAGE_PRIVATE'", "'PUBLIC'"
    };
    public static final int RULE_ML_COMMENT=7;
    public static final int RULE_ID=4;
    public static final int T__12=12;
    public static final int T__28=28;
    public static final int T__23=23;
    public static final int T__20=20;
    public static final int T__13=13;
    public static final int RULE_STRING=6;
    public static final int T__21=21;
    public static final int T__19=19;
    public static final int T__14=14;
    public static final int T__11=11;
    public static final int T__22=22;
    public static final int RULE_WS=9;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int EOF=-1;
    public static final int T__27=27;
    public static final int T__16=16;
    public static final int T__24=24;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__18=18;
    public static final int T__15=15;

    // delegates
    // delegators


        public InternalBug289187TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289187TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289187TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g"; }



     	private Bug289187TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289187TestLanguageParser(TokenStream input, IAstFactory factory, Bug289187TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected Bug289187TestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:73:2: (iv_ruleModel= ruleModel EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:74:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:81:1: ruleModel returns [EObject current=null] : ( (lv_classes_0_0= ruleClass ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_classes_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:86:6: ( ( (lv_classes_0_0= ruleClass ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:87:1: ( (lv_classes_0_0= ruleClass ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:87:1: ( (lv_classes_0_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:88:1: (lv_classes_0_0= ruleClass )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:88:1: (lv_classes_0_0= ruleClass )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:89:3: lv_classes_0_0= ruleClass
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getClassesClassParserRuleCall_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleClass_in_ruleModel130);
            	    lv_classes_0_0=ruleClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"classes",
            	            		lv_classes_0_0, 
            	            		"Class", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleClass"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:114:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:115:2: (iv_ruleClass= ruleClass EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:116:2: iv_ruleClass= ruleClass EOF
            {
             currentNode = createCompositeNode(grammarAccess.getClassRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleClass_in_entryRuleClass166);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleClass176); 

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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:123:1: ruleClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token lv_transient_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_classNumber_14_0=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token lv_quid_17_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_documentation_20_0=null;
        Token otherlv_23=null;
        EObject lv_attributes_21_0 = null;

        EObject lv_operations_22_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:128:6: ( ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:129:1: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:129:1: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:129:2: ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}'
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:129:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:130:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:130:1: (lv_abstract_0_0= 'abstract' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:131:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleClass219); 

                            createLeafNode(lv_abstract_0_0, grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0(), "abstract");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		set(current, "abstract", true, "abstract", lastConsumedNode);
                    	    

                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:144:3: ( (lv_transient_1_0= 'transient' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:145:1: (lv_transient_1_0= 'transient' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:145:1: (lv_transient_1_0= 'transient' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:146:3: lv_transient_1_0= 'transient'
                    {
                    lv_transient_1_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleClass251); 

                            createLeafNode(lv_transient_1_0, grammarAccess.getClassAccess().getTransientTransientKeyword_1_0(), "transient");
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		set(current, "transient", true, "transient", lastConsumedNode);
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleClass277); 

                	createLeafNode(otherlv_2, grammarAccess.getClassAccess().getClassKeyword_2(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:163:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:164:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:164:1: (lv_name_3_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:165:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass294); 

            			createLeafNode(lv_name_3_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_3_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:182:2: (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:182:4: otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleClass312); 

                        	createLeafNode(otherlv_4, grammarAccess.getClassAccess().getExtendsKeyword_4_0(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:186:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:187:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:187:1: (otherlv_5= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:188:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass332); 

                    		createLeafNode(otherlv_5, grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0(), "superClass"); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:199:4: (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:199:6: otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleClass347); 

                        	createLeafNode(otherlv_6, grammarAccess.getClassAccess().getImplementsKeyword_5_0(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:203:1: ( (otherlv_7= RULE_ID ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:204:1: (otherlv_7= RULE_ID )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:204:1: (otherlv_7= RULE_ID )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:205:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass367); 

                    		createLeafNode(otherlv_7, grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0(), "implementedInterfaces"); 
                    	

                    }


                    }

                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:216:2: (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:216:4: otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleClass380); 

                    	        	createLeafNode(otherlv_8, grammarAccess.getClassAccess().getCommaKeyword_5_2_0(), null);
                    	        
                    	    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleClass392); 

                    	        	createLeafNode(otherlv_9, grammarAccess.getClassAccess().getImplementsKeyword_5_2_1(), null);
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:224:1: ( (otherlv_10= RULE_ID ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:225:1: (otherlv_10= RULE_ID )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:225:1: (otherlv_10= RULE_ID )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:226:3: otherlv_10= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getClassRule());
                    	    	        }
                    	            
                    	    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleClass412); 

                    	    		createLeafNode(otherlv_10, grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0(), "implementedInterfaces"); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleClass428); 

                	createLeafNode(otherlv_11, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:241:1: (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:241:3: otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) )
                    {
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleClass441); 

                        	createLeafNode(otherlv_12, grammarAccess.getClassAccess().getClassNumberKeyword_7_0(), null);
                        
                    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleClass453); 

                        	createLeafNode(otherlv_13, grammarAccess.getClassAccess().getEqualsSignKeyword_7_1(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:249:1: ( (lv_classNumber_14_0= RULE_INT ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:250:1: (lv_classNumber_14_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:250:1: (lv_classNumber_14_0= RULE_INT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:251:3: lv_classNumber_14_0= RULE_INT
                    {
                    lv_classNumber_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleClass470); 

                    			createLeafNode(lv_classNumber_14_0, grammarAccess.getClassAccess().getClassNumberINTTerminalRuleCall_7_2_0(), "classNumber"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		set(
                           			current, 
                           			"classNumber",
                            		lv_classNumber_14_0, 
                            		"INT", 
                            		lastConsumedNode);
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:268:4: (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:268:6: otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) )
                    {
                    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleClass490); 

                        	createLeafNode(otherlv_15, grammarAccess.getClassAccess().getQuidKeyword_8_0(), null);
                        
                    otherlv_16=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleClass502); 

                        	createLeafNode(otherlv_16, grammarAccess.getClassAccess().getEqualsSignKeyword_8_1(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:276:1: ( (lv_quid_17_0= RULE_INT ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:277:1: (lv_quid_17_0= RULE_INT )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:277:1: (lv_quid_17_0= RULE_INT )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:278:3: lv_quid_17_0= RULE_INT
                    {
                    lv_quid_17_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleClass519); 

                    			createLeafNode(lv_quid_17_0, grammarAccess.getClassAccess().getQuidINTTerminalRuleCall_8_2_0(), "quid"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		set(
                           			current, 
                           			"quid",
                            		lv_quid_17_0, 
                            		"INT", 
                            		lastConsumedNode);
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:295:4: (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:295:6: otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) )
                    {
                    otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleClass539); 

                        	createLeafNode(otherlv_18, grammarAccess.getClassAccess().getDocumentationKeyword_9_0(), null);
                        
                    otherlv_19=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleClass551); 

                        	createLeafNode(otherlv_19, grammarAccess.getClassAccess().getEqualsSignKeyword_9_1(), null);
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:303:1: ( (lv_documentation_20_0= RULE_STRING ) )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:304:1: (lv_documentation_20_0= RULE_STRING )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:304:1: (lv_documentation_20_0= RULE_STRING )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:305:3: lv_documentation_20_0= RULE_STRING
                    {
                    lv_documentation_20_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleClass568); 

                    			createLeafNode(lv_documentation_20_0, grammarAccess.getClassAccess().getDocumentationSTRINGTerminalRuleCall_9_2_0(), "documentation"); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_20_0, 
                            		"STRING", 
                            		lastConsumedNode);
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:322:4: ( (lv_attributes_21_0= ruleAttribute ) )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case 25:
                    {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 26:
                    {
                    int LA10_2 = input.LA(2);

                    if ( (LA10_2==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 27:
                    {
                    int LA10_3 = input.LA(2);

                    if ( (LA10_3==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 28:
                    {
                    int LA10_4 = input.LA(2);

                    if ( (LA10_4==23) ) {
                        alt10=1;
                    }


                    }
                    break;
                case 23:
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:323:1: (lv_attributes_21_0= ruleAttribute )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:323:1: (lv_attributes_21_0= ruleAttribute )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:324:3: lv_attributes_21_0= ruleAttribute
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_10_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_ruleClass596);
            	    lv_attributes_21_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_21_0, 
            	            		"Attribute", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:341:3: ( (lv_operations_22_0= ruleOperation ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=24 && LA11_0<=28)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:342:1: (lv_operations_22_0= ruleOperation )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:342:1: (lv_operations_22_0= ruleOperation )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:343:3: lv_operations_22_0= ruleOperation
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getClassAccess().getOperationsOperationParserRuleCall_11_0(), currentNode); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleOperation_in_ruleClass618);
            	    lv_operations_22_0=ruleOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_22_0, 
            	            		"Operation", 
            	            		currentNode);
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_23=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleClass631); 

                	createLeafNode(otherlv_23, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_12(), null);
                

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:372:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:373:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:374:2: iv_ruleAttribute= ruleAttribute EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAttributeRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute667);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute677); 

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:381:1: ruleAttribute returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:386:6: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:387:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:387:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:387:2: ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:387:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=25 && LA12_0<=28)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:388:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:388:1: (lv_visibility_0_0= ruleVisibility )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:389:3: lv_visibility_0_0= ruleVisibility
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getAttributeAccess().getVisibilityVisibilityEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_ruleAttribute723);
                    lv_visibility_0_0=ruleVisibility();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"visibility",
                            		lv_visibility_0_0, 
                            		"Visibility", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAttribute736); 

                	createLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getAttributeKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:410:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:411:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:411:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:412:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttribute753); 

            			createLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleOperation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:437:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:438:2: (iv_ruleOperation= ruleOperation EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:439:2: iv_ruleOperation= ruleOperation EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOperationRule(), currentNode); 
            pushFollow(FollowSets000.FOLLOW_ruleOperation_in_entryRuleOperation794);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperation804); 

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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:446:1: ruleOperation returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:451:6: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:452:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:452:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:452:2: ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:452:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=25 && LA13_0<=28)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:453:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:453:1: (lv_visibility_0_0= ruleVisibility )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:454:3: lv_visibility_0_0= ruleVisibility
                    {
                     
                    	        currentNode=createCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0(), currentNode); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleVisibility_in_ruleOperation850);
                    lv_visibility_0_0=ruleVisibility();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"visibility",
                            		lv_visibility_0_0, 
                            		"Visibility", 
                            		currentNode);
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleOperation863); 

                	createLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOperationKeyword_1(), null);
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:475:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:476:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:476:1: (lv_name_2_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:477:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOperation880); 

            			createLeafNode(lv_name_2_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0(), "name"); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID", 
                    		lastConsumedNode);
            	    

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "ruleVisibility"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:502:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:506:6: ( ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:507:1: ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:507:1: ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt14=1;
                }
                break;
            case 26:
                {
                alt14=2;
                }
                break;
            case 27:
                {
                alt14=3;
                }
                break;
            case 28:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:507:2: (enumLiteral_0= 'PRIVATE' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:507:2: (enumLiteral_0= 'PRIVATE' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:507:4: enumLiteral_0= 'PRIVATE'
                    {
                    enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleVisibility935); 

                            current = grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:513:6: (enumLiteral_1= 'PROTECTED' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:513:6: (enumLiteral_1= 'PROTECTED' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:513:8: enumLiteral_1= 'PROTECTED'
                    {
                    enumLiteral_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleVisibility952); 

                            current = grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:519:6: (enumLiteral_2= 'PACKAGE_PRIVATE' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:519:6: (enumLiteral_2= 'PACKAGE_PRIVATE' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:519:8: enumLiteral_2= 'PACKAGE_PRIVATE'
                    {
                    enumLiteral_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVisibility969); 

                            current = grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:525:6: (enumLiteral_3= 'PUBLIC' )
                    {
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:525:6: (enumLiteral_3= 'PUBLIC' )
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/editor/contentassist/parser/antlr/internal/InternalBug289187TestLanguage.g:525:8: enumLiteral_3= 'PUBLIC'
                    {
                    enumLiteral_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVisibility986); 

                            current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(enumLiteral_3, grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3(), null); 
                        

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
    // $ANTLR end "ruleVisibility"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleClass_in_ruleModel130 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_ruleClass_in_entryRuleClass166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleClass176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleClass219 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_12_in_ruleClass251 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleClass277 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass294 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_14_in_ruleClass312 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass332 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_15_in_ruleClass347 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass367 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_16_in_ruleClass380 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleClass392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleClass412 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_17_in_ruleClass428 = new BitSet(new long[]{0x000000001FF40000L});
        public static final BitSet FOLLOW_18_in_ruleClass441 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleClass453 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleClass470 = new BitSet(new long[]{0x000000001FF00000L});
        public static final BitSet FOLLOW_20_in_ruleClass490 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleClass502 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleClass519 = new BitSet(new long[]{0x000000001FE00000L});
        public static final BitSet FOLLOW_21_in_ruleClass539 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleClass551 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleClass568 = new BitSet(new long[]{0x000000001FC00000L});
        public static final BitSet FOLLOW_ruleAttribute_in_ruleClass596 = new BitSet(new long[]{0x000000001FC00000L});
        public static final BitSet FOLLOW_ruleOperation_in_ruleClass618 = new BitSet(new long[]{0x000000001F400000L});
        public static final BitSet FOLLOW_22_in_ruleClass631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute667 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_ruleAttribute723 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleAttribute736 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation794 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperation804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVisibility_in_ruleOperation850 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleOperation863 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOperation880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleVisibility935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleVisibility952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleVisibility969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleVisibility986 = new BitSet(new long[]{0x0000000000000002L});
    }


}
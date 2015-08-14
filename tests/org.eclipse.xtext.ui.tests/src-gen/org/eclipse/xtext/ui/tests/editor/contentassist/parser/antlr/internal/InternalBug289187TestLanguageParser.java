package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
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
    public static final int RULE_ID=4;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalBug289187TestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalBug289187TestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalBug289187TestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalBug289187TestLanguage.g"; }



     	private Bug289187TestLanguageGrammarAccess grammarAccess;
     	
        public InternalBug289187TestLanguageParser(TokenStream input, Bug289187TestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
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
    // InternalBug289187TestLanguage.g:68:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalBug289187TestLanguage.g:69:2: (iv_ruleModel= ruleModel EOF )
            // InternalBug289187TestLanguage.g:70:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug289187TestLanguage.g:77:1: ruleModel returns [EObject current=null] : ( (lv_classes_0_0= ruleClass ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_classes_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug289187TestLanguage.g:80:28: ( ( (lv_classes_0_0= ruleClass ) )* )
            // InternalBug289187TestLanguage.g:81:1: ( (lv_classes_0_0= ruleClass ) )*
            {
            // InternalBug289187TestLanguage.g:81:1: ( (lv_classes_0_0= ruleClass ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=13)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:82:1: (lv_classes_0_0= ruleClass )
            	    {
            	    // InternalBug289187TestLanguage.g:82:1: (lv_classes_0_0= ruleClass )
            	    // InternalBug289187TestLanguage.g:83:3: lv_classes_0_0= ruleClass
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getClassesClassParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_classes_0_0=ruleClass();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"classes",
            	            		lv_classes_0_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug289187TestLanguage.Class");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleClass"
    // InternalBug289187TestLanguage.g:107:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalBug289187TestLanguage.g:108:2: (iv_ruleClass= ruleClass EOF )
            // InternalBug289187TestLanguage.g:109:2: iv_ruleClass= ruleClass EOF
            {
             newCompositeNode(grammarAccess.getClassRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;

             current =iv_ruleClass; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug289187TestLanguage.g:116:1: ruleClass returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' ) ;
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


         enterRule(); 
            
        try {
            // InternalBug289187TestLanguage.g:119:28: ( ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' ) )
            // InternalBug289187TestLanguage.g:120:1: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' )
            {
            // InternalBug289187TestLanguage.g:120:1: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}' )
            // InternalBug289187TestLanguage.g:120:2: ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_transient_1_0= 'transient' ) )? otherlv_2= 'class' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )? (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )? otherlv_11= '{' (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )? (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )? (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )? ( (lv_attributes_21_0= ruleAttribute ) )* ( (lv_operations_22_0= ruleOperation ) )* otherlv_23= '}'
            {
            // InternalBug289187TestLanguage.g:120:2: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalBug289187TestLanguage.g:121:1: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalBug289187TestLanguage.g:121:1: (lv_abstract_0_0= 'abstract' )
                    // InternalBug289187TestLanguage.g:122:3: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,11,FollowSets000.FOLLOW_4); 

                            newLeafNode(lv_abstract_0_0, grammarAccess.getClassAccess().getAbstractAbstractKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		setWithLastConsumed(current, "abstract", true, "abstract");
                    	    

                    }


                    }
                    break;

            }

            // InternalBug289187TestLanguage.g:135:3: ( (lv_transient_1_0= 'transient' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalBug289187TestLanguage.g:136:1: (lv_transient_1_0= 'transient' )
                    {
                    // InternalBug289187TestLanguage.g:136:1: (lv_transient_1_0= 'transient' )
                    // InternalBug289187TestLanguage.g:137:3: lv_transient_1_0= 'transient'
                    {
                    lv_transient_1_0=(Token)match(input,12,FollowSets000.FOLLOW_5); 

                            newLeafNode(lv_transient_1_0, grammarAccess.getClassAccess().getTransientTransientKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		setWithLastConsumed(current, "transient", true, "transient");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getClassAccess().getClassKeyword_2());
                
            // InternalBug289187TestLanguage.g:154:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalBug289187TestLanguage.g:155:1: (lv_name_3_0= RULE_ID )
            {
            // InternalBug289187TestLanguage.g:155:1: (lv_name_3_0= RULE_ID )
            // InternalBug289187TestLanguage.g:156:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            			newLeafNode(lv_name_3_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalBug289187TestLanguage.g:172:2: (otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalBug289187TestLanguage.g:172:4: otherlv_4= 'extends' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getClassAccess().getExtendsKeyword_4_0());
                        
                    // InternalBug289187TestLanguage.g:176:1: ( (otherlv_5= RULE_ID ) )
                    // InternalBug289187TestLanguage.g:177:1: (otherlv_5= RULE_ID )
                    {
                    // InternalBug289187TestLanguage.g:177:1: (otherlv_5= RULE_ID )
                    // InternalBug289187TestLanguage.g:178:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

                    		newLeafNode(otherlv_5, grammarAccess.getClassAccess().getSuperClassClassCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // InternalBug289187TestLanguage.g:189:4: (otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalBug289187TestLanguage.g:189:6: otherlv_6= 'implements' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                        	newLeafNode(otherlv_6, grammarAccess.getClassAccess().getImplementsKeyword_5_0());
                        
                    // InternalBug289187TestLanguage.g:193:1: ( (otherlv_7= RULE_ID ) )
                    // InternalBug289187TestLanguage.g:194:1: (otherlv_7= RULE_ID )
                    {
                    // InternalBug289187TestLanguage.g:194:1: (otherlv_7= RULE_ID )
                    // InternalBug289187TestLanguage.g:195:3: otherlv_7= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                            
                    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    		newLeafNode(otherlv_7, grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_1_0()); 
                    	

                    }


                    }

                    // InternalBug289187TestLanguage.g:206:2: (otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalBug289187TestLanguage.g:206:4: otherlv_8= ',' otherlv_9= 'implements' ( (otherlv_10= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,16,FollowSets000.FOLLOW_10); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getClassAccess().getCommaKeyword_5_2_0());
                    	        
                    	    otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_6); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getClassAccess().getImplementsKeyword_5_2_1());
                    	        
                    	    // InternalBug289187TestLanguage.g:214:1: ( (otherlv_10= RULE_ID ) )
                    	    // InternalBug289187TestLanguage.g:215:1: (otherlv_10= RULE_ID )
                    	    {
                    	    // InternalBug289187TestLanguage.g:215:1: (otherlv_10= RULE_ID )
                    	    // InternalBug289187TestLanguage.g:216:3: otherlv_10= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getClassRule());
                    	    	        }
                    	            
                    	    otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_9); 

                    	    		newLeafNode(otherlv_10, grammarAccess.getClassAccess().getImplementedInterfacesClassCrossReference_5_2_2_0()); 
                    	    	

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

            otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_11); 

                	newLeafNode(otherlv_11, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_6());
                
            // InternalBug289187TestLanguage.g:231:1: (otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalBug289187TestLanguage.g:231:3: otherlv_12= 'classNumber' otherlv_13= '=' ( (lv_classNumber_14_0= RULE_INT ) )
                    {
                    otherlv_12=(Token)match(input,18,FollowSets000.FOLLOW_12); 

                        	newLeafNode(otherlv_12, grammarAccess.getClassAccess().getClassNumberKeyword_7_0());
                        
                    otherlv_13=(Token)match(input,19,FollowSets000.FOLLOW_13); 

                        	newLeafNode(otherlv_13, grammarAccess.getClassAccess().getEqualsSignKeyword_7_1());
                        
                    // InternalBug289187TestLanguage.g:239:1: ( (lv_classNumber_14_0= RULE_INT ) )
                    // InternalBug289187TestLanguage.g:240:1: (lv_classNumber_14_0= RULE_INT )
                    {
                    // InternalBug289187TestLanguage.g:240:1: (lv_classNumber_14_0= RULE_INT )
                    // InternalBug289187TestLanguage.g:241:3: lv_classNumber_14_0= RULE_INT
                    {
                    lv_classNumber_14_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_14); 

                    			newLeafNode(lv_classNumber_14_0, grammarAccess.getClassAccess().getClassNumberINTTerminalRuleCall_7_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"classNumber",
                            		lv_classNumber_14_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug289187TestLanguage.g:257:4: (otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalBug289187TestLanguage.g:257:6: otherlv_15= 'quid' otherlv_16= '=' ( (lv_quid_17_0= RULE_INT ) )
                    {
                    otherlv_15=(Token)match(input,20,FollowSets000.FOLLOW_12); 

                        	newLeafNode(otherlv_15, grammarAccess.getClassAccess().getQuidKeyword_8_0());
                        
                    otherlv_16=(Token)match(input,19,FollowSets000.FOLLOW_13); 

                        	newLeafNode(otherlv_16, grammarAccess.getClassAccess().getEqualsSignKeyword_8_1());
                        
                    // InternalBug289187TestLanguage.g:265:1: ( (lv_quid_17_0= RULE_INT ) )
                    // InternalBug289187TestLanguage.g:266:1: (lv_quid_17_0= RULE_INT )
                    {
                    // InternalBug289187TestLanguage.g:266:1: (lv_quid_17_0= RULE_INT )
                    // InternalBug289187TestLanguage.g:267:3: lv_quid_17_0= RULE_INT
                    {
                    lv_quid_17_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_15); 

                    			newLeafNode(lv_quid_17_0, grammarAccess.getClassAccess().getQuidINTTerminalRuleCall_8_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"quid",
                            		lv_quid_17_0, 
                            		"org.eclipse.xtext.common.Terminals.INT");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug289187TestLanguage.g:283:4: (otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalBug289187TestLanguage.g:283:6: otherlv_18= 'documentation' otherlv_19= '=' ( (lv_documentation_20_0= RULE_STRING ) )
                    {
                    otherlv_18=(Token)match(input,21,FollowSets000.FOLLOW_12); 

                        	newLeafNode(otherlv_18, grammarAccess.getClassAccess().getDocumentationKeyword_9_0());
                        
                    otherlv_19=(Token)match(input,19,FollowSets000.FOLLOW_16); 

                        	newLeafNode(otherlv_19, grammarAccess.getClassAccess().getEqualsSignKeyword_9_1());
                        
                    // InternalBug289187TestLanguage.g:291:1: ( (lv_documentation_20_0= RULE_STRING ) )
                    // InternalBug289187TestLanguage.g:292:1: (lv_documentation_20_0= RULE_STRING )
                    {
                    // InternalBug289187TestLanguage.g:292:1: (lv_documentation_20_0= RULE_STRING )
                    // InternalBug289187TestLanguage.g:293:3: lv_documentation_20_0= RULE_STRING
                    {
                    lv_documentation_20_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

                    			newLeafNode(lv_documentation_20_0, grammarAccess.getClassAccess().getDocumentationSTRINGTerminalRuleCall_9_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getClassRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"documentation",
                            		lv_documentation_20_0, 
                            		"org.eclipse.xtext.common.Terminals.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalBug289187TestLanguage.g:309:4: ( (lv_attributes_21_0= ruleAttribute ) )*
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
            	    // InternalBug289187TestLanguage.g:310:1: (lv_attributes_21_0= ruleAttribute )
            	    {
            	    // InternalBug289187TestLanguage.g:310:1: (lv_attributes_21_0= ruleAttribute )
            	    // InternalBug289187TestLanguage.g:311:3: lv_attributes_21_0= ruleAttribute
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassAccess().getAttributesAttributeParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_17);
            	    lv_attributes_21_0=ruleAttribute();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_21_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug289187TestLanguage.Attribute");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalBug289187TestLanguage.g:327:3: ( (lv_operations_22_0= ruleOperation ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=24 && LA11_0<=28)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalBug289187TestLanguage.g:328:1: (lv_operations_22_0= ruleOperation )
            	    {
            	    // InternalBug289187TestLanguage.g:328:1: (lv_operations_22_0= ruleOperation )
            	    // InternalBug289187TestLanguage.g:329:3: lv_operations_22_0= ruleOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassAccess().getOperationsOperationParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_18);
            	    lv_operations_22_0=ruleOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operations",
            	            		lv_operations_22_0, 
            	            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug289187TestLanguage.Operation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_23=(Token)match(input,22,FollowSets000.FOLLOW_2); 

                	newLeafNode(otherlv_23, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_12());
                

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleAttribute"
    // InternalBug289187TestLanguage.g:357:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalBug289187TestLanguage.g:358:2: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalBug289187TestLanguage.g:359:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug289187TestLanguage.g:366:1: ruleAttribute returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug289187TestLanguage.g:369:28: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug289187TestLanguage.g:370:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug289187TestLanguage.g:370:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:370:2: ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:370:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=25 && LA12_0<=28)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalBug289187TestLanguage.g:371:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // InternalBug289187TestLanguage.g:371:1: (lv_visibility_0_0= ruleVisibility )
                    // InternalBug289187TestLanguage.g:372:3: lv_visibility_0_0= ruleVisibility
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_19);
                    lv_visibility_0_0=ruleVisibility();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeRule());
                    	        }
                           		set(
                           			current, 
                           			"visibility",
                            		lv_visibility_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug289187TestLanguage.Visibility");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getAttributeKeyword_1());
                
            // InternalBug289187TestLanguage.g:392:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug289187TestLanguage.g:393:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug289187TestLanguage.g:393:1: (lv_name_2_0= RULE_ID )
            // InternalBug289187TestLanguage.g:394:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleOperation"
    // InternalBug289187TestLanguage.g:418:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalBug289187TestLanguage.g:419:2: (iv_ruleOperation= ruleOperation EOF )
            // InternalBug289187TestLanguage.g:420:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

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
    // InternalBug289187TestLanguage.g:427:1: ruleOperation returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Enumerator lv_visibility_0_0 = null;


         enterRule(); 
            
        try {
            // InternalBug289187TestLanguage.g:430:28: ( ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalBug289187TestLanguage.g:431:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalBug289187TestLanguage.g:431:1: ( ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalBug289187TestLanguage.g:431:2: ( (lv_visibility_0_0= ruleVisibility ) )? otherlv_1= 'operation' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalBug289187TestLanguage.g:431:2: ( (lv_visibility_0_0= ruleVisibility ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=25 && LA13_0<=28)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalBug289187TestLanguage.g:432:1: (lv_visibility_0_0= ruleVisibility )
                    {
                    // InternalBug289187TestLanguage.g:432:1: (lv_visibility_0_0= ruleVisibility )
                    // InternalBug289187TestLanguage.g:433:3: lv_visibility_0_0= ruleVisibility
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_20);
                    lv_visibility_0_0=ruleVisibility();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"visibility",
                            		lv_visibility_0_0, 
                            		"org.eclipse.xtext.ui.tests.editor.contentassist.Bug289187TestLanguage.Visibility");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,24,FollowSets000.FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getOperationKeyword_1());
                
            // InternalBug289187TestLanguage.g:453:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalBug289187TestLanguage.g:454:1: (lv_name_2_0= RULE_ID )
            {
            // InternalBug289187TestLanguage.g:454:1: (lv_name_2_0= RULE_ID )
            // InternalBug289187TestLanguage.g:455:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            			newLeafNode(lv_name_2_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "ruleVisibility"
    // InternalBug289187TestLanguage.g:479:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // InternalBug289187TestLanguage.g:481:28: ( ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) ) )
            // InternalBug289187TestLanguage.g:482:1: ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) )
            {
            // InternalBug289187TestLanguage.g:482:1: ( (enumLiteral_0= 'PRIVATE' ) | (enumLiteral_1= 'PROTECTED' ) | (enumLiteral_2= 'PACKAGE_PRIVATE' ) | (enumLiteral_3= 'PUBLIC' ) )
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
                    // InternalBug289187TestLanguage.g:482:2: (enumLiteral_0= 'PRIVATE' )
                    {
                    // InternalBug289187TestLanguage.g:482:2: (enumLiteral_0= 'PRIVATE' )
                    // InternalBug289187TestLanguage.g:482:4: enumLiteral_0= 'PRIVATE'
                    {
                    enumLiteral_0=(Token)match(input,25,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalBug289187TestLanguage.g:488:6: (enumLiteral_1= 'PROTECTED' )
                    {
                    // InternalBug289187TestLanguage.g:488:6: (enumLiteral_1= 'PROTECTED' )
                    // InternalBug289187TestLanguage.g:488:8: enumLiteral_1= 'PROTECTED'
                    {
                    enumLiteral_1=(Token)match(input,26,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getPROTECTEDEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalBug289187TestLanguage.g:494:6: (enumLiteral_2= 'PACKAGE_PRIVATE' )
                    {
                    // InternalBug289187TestLanguage.g:494:6: (enumLiteral_2= 'PACKAGE_PRIVATE' )
                    // InternalBug289187TestLanguage.g:494:8: enumLiteral_2= 'PACKAGE_PRIVATE'
                    {
                    enumLiteral_2=(Token)match(input,27,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getPACKAGE_PRIVATEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalBug289187TestLanguage.g:500:6: (enumLiteral_3= 'PUBLIC' )
                    {
                    // InternalBug289187TestLanguage.g:500:6: (enumLiteral_3= 'PUBLIC' )
                    // InternalBug289187TestLanguage.g:500:8: enumLiteral_3= 'PUBLIC'
                    {
                    enumLiteral_3=(Token)match(input,28,FollowSets000.FOLLOW_2); 

                            current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_3()); 
                        

                    }


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
    // $ANTLR end "ruleVisibility"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000003802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000002C000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000028000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x000000001FF40000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000001FF00000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000001FE00000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000001FC00000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000001F400000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000001000000L});
    }


}
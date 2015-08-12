package org.eclipse.xtext.ui.tests.refactoring.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.refactoring.services.RefactoringTestLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRefactoringTestLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'{'", "'ref'", "'}'", "'.'", "'.*'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalRefactoringTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRefactoringTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRefactoringTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g"; }



     	private RefactoringTestLanguageGrammarAccess grammarAccess;
     	
        public InternalRefactoringTestLanguageParser(TokenStream input, RefactoringTestLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Main";	
       	}
       	
       	@Override
       	protected RefactoringTestLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:67:1: entryRuleMain returns [EObject current=null] : iv_ruleMain= ruleMain EOF ;
    public final EObject entryRuleMain() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMain = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:68:2: (iv_ruleMain= ruleMain EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:69:2: iv_ruleMain= ruleMain EOF
            {
             newCompositeNode(grammarAccess.getMainRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain75);
            iv_ruleMain=ruleMain();

            state._fsp--;

             current =iv_ruleMain; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMain85); 

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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:76:1: ruleMain returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleMain() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:79:28: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:80:1: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:81:1: (lv_elements_0_0= ruleAbstractElement )
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:82:3: lv_elements_0_0= ruleAbstractElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMainAccess().getElementsAbstractElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_ruleMain130);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMainRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"elements",
            	            		lv_elements_0_0, 
            	            		"org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage.AbstractElement");
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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleAbstractElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:106:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:107:2: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:108:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAbstractElement176); 

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
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:115:1: ruleAbstractElement returns [EObject current=null] : (this_Element_0= ruleElement | this_Import_1= ruleImport ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_Element_0 = null;

        EObject this_Import_1 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:118:28: ( (this_Element_0= ruleElement | this_Import_1= ruleImport ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:119:1: (this_Element_0= ruleElement | this_Import_1= ruleImport )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:119:1: (this_Element_0= ruleElement | this_Import_1= ruleImport )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==11) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:120:5: this_Element_0= ruleElement
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getElementParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleAbstractElement223);
                    this_Element_0=ruleElement();

                    state._fsp--;

                     
                            current = this_Element_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:130:5: this_Import_1= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleAbstractElement250);
                    this_Import_1=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_1; 
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
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRuleImport"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:146:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:147:2: (iv_ruleImport= ruleImport EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:148:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport285);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport295); 

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:155:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleFQNWithWC ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:158:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleFQNWithWC ) ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleFQNWithWC ) ) )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:159:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleFQNWithWC ) ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:159:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleFQNWithWC ) )
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleImport332); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:163:1: ( (lv_importedNamespace_1_0= ruleFQNWithWC ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:164:1: (lv_importedNamespace_1_0= ruleFQNWithWC )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:164:1: (lv_importedNamespace_1_0= ruleFQNWithWC )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:165:3: lv_importedNamespace_1_0= ruleFQNWithWC
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceFQNWithWCParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleFQNWithWC_in_ruleImport353);
            lv_importedNamespace_1_0=ruleFQNWithWC();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage.FQNWithWC");
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:189:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:190:2: (iv_ruleElement= ruleElement EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:191:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement389);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement399); 

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
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:198:1: ruleElement returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}' )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_contained_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:201:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}' )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:202:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}' )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:202:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:202:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}' )?
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:202:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:203:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:203:1: (lv_name_0_0= RULE_ID )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:204:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleElement441); 

            			newLeafNode(lv_name_0_0, grammarAccess.getElementAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getElementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:220:2: (otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:220:4: otherlv_1= '{' ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )* otherlv_5= '}'
                    {
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleElement459); 

                        	newLeafNode(otherlv_1, grammarAccess.getElementAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:224:1: ( ( (lv_contained_2_0= ruleElement ) ) | (otherlv_3= 'ref' ( ( ruleFQN ) ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID) ) {
                            alt3=1;
                        }
                        else if ( (LA3_0==13) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:224:2: ( (lv_contained_2_0= ruleElement ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:224:2: ( (lv_contained_2_0= ruleElement ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:225:1: (lv_contained_2_0= ruleElement )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:225:1: (lv_contained_2_0= ruleElement )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:226:3: lv_contained_2_0= ruleElement
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getContainedElementParserRuleCall_1_1_0_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleElement_in_ruleElement481);
                    	    lv_contained_2_0=ruleElement();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getElementRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"contained",
                    	            		lv_contained_2_0, 
                    	            		"org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage.Element");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:243:6: (otherlv_3= 'ref' ( ( ruleFQN ) ) )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:243:6: (otherlv_3= 'ref' ( ( ruleFQN ) ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:243:8: otherlv_3= 'ref' ( ( ruleFQN ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleElement500); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getElementAccess().getRefKeyword_1_1_1_0());
                    	        
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:247:1: ( ( ruleFQN ) )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:248:1: ( ruleFQN )
                    	    {
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:248:1: ( ruleFQN )
                    	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:249:3: ruleFQN
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getElementRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getElementAccess().getReferencedElementCrossReference_1_1_1_1_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleElement523);
                    	    ruleFQN();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleElement538); 

                        	newLeafNode(otherlv_5, grammarAccess.getElementAccess().getRightCurlyBracketKeyword_1_2());
                        

                    }
                    break;

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
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:274:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:275:2: (iv_ruleFQN= ruleFQN EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:276:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_entryRuleFQN577);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQN588); 

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
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:283:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:286:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:287:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:287:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:287:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN628); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:294:1: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:295:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFQN647); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFQN662); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


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
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleFQNWithWC"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:315:1: entryRuleFQNWithWC returns [String current=null] : iv_ruleFQNWithWC= ruleFQNWithWC EOF ;
    public final String entryRuleFQNWithWC() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQNWithWC = null;


        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:316:2: (iv_ruleFQNWithWC= ruleFQNWithWC EOF )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:317:2: iv_ruleFQNWithWC= ruleFQNWithWC EOF
            {
             newCompositeNode(grammarAccess.getFQNWithWCRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleFQNWithWC_in_entryRuleFQNWithWC710);
            iv_ruleFQNWithWC=ruleFQNWithWC();

            state._fsp--;

             current =iv_ruleFQNWithWC.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFQNWithWC721); 

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
    // $ANTLR end "entryRuleFQNWithWC"


    // $ANTLR start "ruleFQNWithWC"
    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:324:1: ruleFQNWithWC returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FQN_0= ruleFQN (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleFQNWithWC() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_FQN_0 = null;


         enterRule(); 
            
        try {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:327:28: ( (this_FQN_0= ruleFQN (kw= '.*' )? ) )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:328:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            {
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:328:1: (this_FQN_0= ruleFQN (kw= '.*' )? )
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:329:5: this_FQN_0= ruleFQN (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getFQNWithWCAccess().getFQNParserRuleCall_0()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleFQN_in_ruleFQNWithWC768);
            this_FQN_0=ruleFQN();

            state._fsp--;


            		current.merge(this_FQN_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:339:1: (kw= '.*' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.eclipse.xtext.ui.tests/src-gen/org/eclipse/xtext/ui/tests/refactoring/parser/antlr/internal/InternalRefactoringTestLanguage.g:340:2: kw= '.*'
                    {
                    kw=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFQNWithWC787); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFQNWithWCAccess().getFullStopAsteriskKeyword_1()); 
                        

                    }
                    break;

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
    // $ANTLR end "ruleFQNWithWC"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_ruleMain130 = new BitSet(new long[]{0x0000000000000812L});
        public static final BitSet FOLLOW_ruleAbstractElement_in_entryRuleAbstractElement166 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAbstractElement176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_ruleAbstractElement223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleAbstractElement250 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleImport332 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQNWithWC_in_ruleImport353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement389 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleElement441 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_12_in_ruleElement459 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_ruleElement_in_ruleElement481 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_13_in_ruleElement500 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleElement523 = new BitSet(new long[]{0x0000000000006010L});
        public static final BitSet FOLLOW_14_in_ruleElement538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN577 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQN588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN628 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleFQN647 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFQN662 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleFQNWithWC_in_entryRuleFQNWithWC710 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFQNWithWC721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFQN_in_ruleFQNWithWC768 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleFQNWithWC787 = new BitSet(new long[]{0x0000000000000002L});
    }


}
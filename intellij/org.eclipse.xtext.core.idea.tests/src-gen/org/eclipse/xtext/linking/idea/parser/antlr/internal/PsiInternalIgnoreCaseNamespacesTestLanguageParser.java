package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.services.IgnoreCaseNamespacesTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalIgnoreCaseNamespacesTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalIgnoreCaseNamespacesTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalIgnoreCaseNamespacesTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalIgnoreCaseNamespacesTestLanguage.g"; }



    	protected IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess;

    	protected IgnoreCaseNamespacesTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalIgnoreCaseNamespacesTestLanguageParser(PsiBuilder builder, TokenStream input, IgnoreCaseNamespacesTestLanguageElementTypeProvider elementTypeProvider, IgnoreCaseNamespacesTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Model";
    	}




    // $ANTLR start "entryRuleModel"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:52:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:52:15: ( ruleModel EOF )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:53:2: ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModel();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:58:1: ruleModel : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) ;
    public final void ruleModel() throws RecognitionException {
        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:58:10: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:59:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:59:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:60:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:60:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:61:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:61:4: (lv_imports_0_0= ruleImport )
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:62:5: lv_imports_0_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getModel_ImportsImportParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    ruleImport();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:71:3: ( (lv_elements_1_0= ruleElement ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:72:4: (lv_elements_1_0= ruleElement )
            	    {
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:72:4: (lv_elements_1_0= ruleElement )
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:73:5: lv_elements_1_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:86:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:86:16: ( ruleImport EOF )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:87:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleImport();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:92:1: ruleImport : ( (lv_importedNamespace_0_0= RULE_STRING ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token lv_importedNamespace_0_0=null;

        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:92:11: ( ( (lv_importedNamespace_0_0= RULE_STRING ) ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:93:2: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:93:2: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:94:3: (lv_importedNamespace_0_0= RULE_STRING )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:94:3: (lv_importedNamespace_0_0= RULE_STRING )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:95:4: lv_importedNamespace_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getImport_ImportedNamespaceSTRINGTerminalRuleCall_0ElementType());
            			
            lv_importedNamespace_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_importedNamespace_0_0);
            			

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleElement"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:107:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:107:17: ( ruleElement EOF )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:108:2: ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleElement();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:113:1: ruleElement : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) ;
    public final void ruleElement() throws RecognitionException {
        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:113:12: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:114:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:114:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:115:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}'
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:115:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:116:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:116:4: (lv_name_0_0= RULE_ID )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:117:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:126:3: ( (otherlv_1= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:127:4: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:127:4: (otherlv_1= RULE_ID )
                    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:128:5: otherlv_1= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getElement_ReferenceElementCrossReference_1_0ElementType());
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_6); 

                    					doneLeaf(otherlv_1);
                    				

                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getElement_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_7); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:144:3: ( (lv_elements_3_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:145:4: (lv_elements_3_0= ruleElement )
            	    {
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:145:4: (lv_elements_3_0= ruleElement )
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:146:5: lv_elements_3_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getElement_ElementsElementParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getElement_RightCurlyBracketKeyword_4ElementType());
            		
            otherlv_4=(Token)match(input,12,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_4);
            		

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleElement"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000820L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001020L});
    }


}
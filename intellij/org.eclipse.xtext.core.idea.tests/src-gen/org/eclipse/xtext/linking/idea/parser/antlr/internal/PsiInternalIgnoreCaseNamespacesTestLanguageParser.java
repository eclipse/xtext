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
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:52:1: entryRuleModel returns [Boolean current=false] : iv_ruleModel= ruleModel EOF ;
    public final Boolean entryRuleModel() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleModel = null;


        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:52:47: (iv_ruleModel= ruleModel EOF )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:53:2: iv_ruleModel= ruleModel EOF
            {
             markComposite(elementTypeProvider.getModelElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:59:1: ruleModel returns [Boolean current=false] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) ;
    public final Boolean ruleModel() throws RecognitionException {
        Boolean current = false;

        Boolean lv_imports_0_0 = null;

        Boolean lv_elements_1_0 = null;


        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:60:1: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:61:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:61:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+ )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:62:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_elements_1_0= ruleElement ) )+
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:62:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:63:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:63:4: (lv_imports_0_0= ruleImport )
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:64:5: lv_imports_0_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getModel_ImportsImportParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:77:3: ( (lv_elements_1_0= ruleElement ) )+
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
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:78:4: (lv_elements_1_0= ruleElement )
            	    {
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:78:4: (lv_elements_1_0= ruleElement )
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:79:5: lv_elements_1_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getModel_ElementsElementParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_elements_1_0=ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleImport"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:96:1: entryRuleImport returns [Boolean current=false] : iv_ruleImport= ruleImport EOF ;
    public final Boolean entryRuleImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImport = null;


        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:96:48: (iv_ruleImport= ruleImport EOF )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:97:2: iv_ruleImport= ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:103:1: ruleImport returns [Boolean current=false] : ( (lv_importedNamespace_0_0= RULE_STRING ) ) ;
    public final Boolean ruleImport() throws RecognitionException {
        Boolean current = false;

        Token lv_importedNamespace_0_0=null;

        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:104:1: ( ( (lv_importedNamespace_0_0= RULE_STRING ) ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:105:2: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:105:2: ( (lv_importedNamespace_0_0= RULE_STRING ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:106:3: (lv_importedNamespace_0_0= RULE_STRING )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:106:3: (lv_importedNamespace_0_0= RULE_STRING )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:107:4: lv_importedNamespace_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getImport_ImportedNamespaceSTRINGTerminalRuleCall_0ElementType());
            			
            lv_importedNamespace_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				if(!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

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
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleElement"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:125:1: entryRuleElement returns [Boolean current=false] : iv_ruleElement= ruleElement EOF ;
    public final Boolean entryRuleElement() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleElement = null;


        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:125:49: (iv_ruleElement= ruleElement EOF )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:126:2: iv_ruleElement= ruleElement EOF
            {
             markComposite(elementTypeProvider.getElementElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FollowSets000.FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:132:1: ruleElement returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) ;
    public final Boolean ruleElement() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Boolean lv_elements_3_0 = null;


        try {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:133:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:134:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:134:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}' )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:135:3: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= RULE_ID ) )? otherlv_2= '{' ( (lv_elements_3_0= ruleElement ) )* otherlv_4= '}'
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:135:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:136:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:136:4: (lv_name_0_0= RULE_ID )
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:137:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getElement_NameIDTerminalRuleCall_0_0ElementType());
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_5); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:152:3: ( (otherlv_1= RULE_ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:153:4: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:153:4: (otherlv_1= RULE_ID )
                    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:154:5: otherlv_1= RULE_ID
                    {

                    					if (!current) {
                    						associateWithSemanticElement();
                    						current = true;
                    					}
                    				

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
            		
            // PsiInternalIgnoreCaseNamespacesTestLanguage.g:176:3: ( (lv_elements_3_0= ruleElement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:177:4: (lv_elements_3_0= ruleElement )
            	    {
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:177:4: (lv_elements_3_0= ruleElement )
            	    // PsiInternalIgnoreCaseNamespacesTestLanguage.g:178:5: lv_elements_3_0= ruleElement
            	    {

            	    					markComposite(elementTypeProvider.getElement_ElementsElementParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    lv_elements_3_0=ruleElement();

            	    state._fsp--;


            	    					doneComposite();
            	    					if(!current) {
            	    						associateWithSemanticElement();
            	    						current = true;
            	    					}
            	    				

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
        return current;
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
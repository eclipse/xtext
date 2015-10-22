package org.eclipse.xtext.metamodelreferencing.tests.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalMetamodelRefTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalMetamodelRefTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalMetamodelRefTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalMetamodelRefTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalMetamodelRefTestLanguage.g"; }



    	protected MetamodelRefTestLanguageGrammarAccess grammarAccess;

    	protected MetamodelRefTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalMetamodelRefTestLanguageParser(PsiBuilder builder, TokenStream input, MetamodelRefTestLanguageElementTypeProvider elementTypeProvider, MetamodelRefTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Foo";
    	}




    // $ANTLR start "entryRuleFoo"
    // PsiInternalMetamodelRefTestLanguage.g:52:1: entryRuleFoo returns [Boolean current=false] : iv_ruleFoo= ruleFoo EOF ;
    public final Boolean entryRuleFoo() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleFoo = null;


        try {
            // PsiInternalMetamodelRefTestLanguage.g:52:45: (iv_ruleFoo= ruleFoo EOF )
            // PsiInternalMetamodelRefTestLanguage.g:53:2: iv_ruleFoo= ruleFoo EOF
            {
             markComposite(elementTypeProvider.getFooElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFoo=ruleFoo();

            state._fsp--;

             current =iv_ruleFoo; 
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
    // $ANTLR end "entryRuleFoo"


    // $ANTLR start "ruleFoo"
    // PsiInternalMetamodelRefTestLanguage.g:59:1: ruleFoo returns [Boolean current=false] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) ;
    public final Boolean ruleFoo() throws RecognitionException {
        Boolean current = false;

        Token lv_name_0_0=null;
        Boolean lv_nameRefs_1_0 = null;


        try {
            // PsiInternalMetamodelRefTestLanguage.g:60:1: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* ) )
            // PsiInternalMetamodelRefTestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            {
            // PsiInternalMetamodelRefTestLanguage.g:61:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )* )
            // PsiInternalMetamodelRefTestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_nameRefs_1_0= ruleNameRef ) )*
            {
            // PsiInternalMetamodelRefTestLanguage.g:62:3: ( (lv_name_0_0= RULE_ID ) )
            // PsiInternalMetamodelRefTestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            {
            // PsiInternalMetamodelRefTestLanguage.g:63:4: (lv_name_0_0= RULE_ID )
            // PsiInternalMetamodelRefTestLanguage.g:64:5: lv_name_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getFoo_NameIDTerminalRuleCall_0_0ElementType());
            				

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_3); 

            					doneLeaf(lv_name_0_0);
            				

            }


            }

            // PsiInternalMetamodelRefTestLanguage.g:79:3: ( (lv_nameRefs_1_0= ruleNameRef ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalMetamodelRefTestLanguage.g:80:4: (lv_nameRefs_1_0= ruleNameRef )
            	    {
            	    // PsiInternalMetamodelRefTestLanguage.g:80:4: (lv_nameRefs_1_0= ruleNameRef )
            	    // PsiInternalMetamodelRefTestLanguage.g:81:5: lv_nameRefs_1_0= ruleNameRef
            	    {

            	    					markComposite(elementTypeProvider.getFoo_NameRefsNameRefParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_nameRefs_1_0=ruleNameRef();

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
    // $ANTLR end "ruleFoo"


    // $ANTLR start "entryRuleNameRef"
    // PsiInternalMetamodelRefTestLanguage.g:98:1: entryRuleNameRef returns [Boolean current=false] : iv_ruleNameRef= ruleNameRef EOF ;
    public final Boolean entryRuleNameRef() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleNameRef = null;


        try {
            // PsiInternalMetamodelRefTestLanguage.g:98:49: (iv_ruleNameRef= ruleNameRef EOF )
            // PsiInternalMetamodelRefTestLanguage.g:99:2: iv_ruleNameRef= ruleNameRef EOF
            {
             markComposite(elementTypeProvider.getNameRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleNameRef=ruleNameRef();

            state._fsp--;

             current =iv_ruleNameRef; 
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
    // $ANTLR end "entryRuleNameRef"


    // $ANTLR start "ruleNameRef"
    // PsiInternalMetamodelRefTestLanguage.g:105:1: ruleNameRef returns [Boolean current=false] : ( (otherlv_0= RULE_ID ) ) ;
    public final Boolean ruleNameRef() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;

        try {
            // PsiInternalMetamodelRefTestLanguage.g:106:1: ( ( (otherlv_0= RULE_ID ) ) )
            // PsiInternalMetamodelRefTestLanguage.g:107:2: ( (otherlv_0= RULE_ID ) )
            {
            // PsiInternalMetamodelRefTestLanguage.g:107:2: ( (otherlv_0= RULE_ID ) )
            // PsiInternalMetamodelRefTestLanguage.g:108:3: (otherlv_0= RULE_ID )
            {
            // PsiInternalMetamodelRefTestLanguage.g:108:3: (otherlv_0= RULE_ID )
            // PsiInternalMetamodelRefTestLanguage.g:109:4: otherlv_0= RULE_ID
            {

            				if (!current) {
            					associateWithSemanticElement();
            					current = true;
            				}
            			

            				markLeaf(elementTypeProvider.getNameRef_RuleParserRuleCrossReference_0ElementType());
            			
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            				doneLeaf(otherlv_0);
            			

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
    // $ANTLR end "ruleNameRef"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000012L});
    }


}
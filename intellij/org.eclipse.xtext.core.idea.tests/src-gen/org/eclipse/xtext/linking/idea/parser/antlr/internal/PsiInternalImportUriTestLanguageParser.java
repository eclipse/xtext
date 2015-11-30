package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.linking.services.ImportUriTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalImportUriTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalImportUriTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalImportUriTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalImportUriTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalImportUriTestLanguage.g"; }



    	protected ImportUriTestLanguageGrammarAccess grammarAccess;

    	protected ImportUriTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalImportUriTestLanguageParser(PsiBuilder builder, TokenStream input, ImportUriTestLanguageElementTypeProvider elementTypeProvider, ImportUriTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "Main";
    	}




    // $ANTLR start "entryRuleMain"
    // PsiInternalImportUriTestLanguage.g:52:1: entryRuleMain returns [Boolean current=false] : iv_ruleMain= ruleMain EOF ;
    public final Boolean entryRuleMain() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleMain = null;


        try {
            // PsiInternalImportUriTestLanguage.g:52:46: (iv_ruleMain= ruleMain EOF )
            // PsiInternalImportUriTestLanguage.g:53:2: iv_ruleMain= ruleMain EOF
            {
             markComposite(elementTypeProvider.getMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleMain=ruleMain();

            state._fsp--;

             current =iv_ruleMain; 
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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // PsiInternalImportUriTestLanguage.g:59:1: ruleMain returns [Boolean current=false] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) ;
    public final Boolean ruleMain() throws RecognitionException {
        Boolean current = false;

        Boolean lv_imports_0_0 = null;

        Boolean lv_types_1_0 = null;


        try {
            // PsiInternalImportUriTestLanguage.g:60:1: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) )
            // PsiInternalImportUriTestLanguage.g:61:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            {
            // PsiInternalImportUriTestLanguage.g:61:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            // PsiInternalImportUriTestLanguage.g:62:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )*
            {
            // PsiInternalImportUriTestLanguage.g:62:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalImportUriTestLanguage.g:63:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // PsiInternalImportUriTestLanguage.g:63:4: (lv_imports_0_0= ruleImport )
            	    // PsiInternalImportUriTestLanguage.g:64:5: lv_imports_0_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getMain_ImportsImportParserRuleCall_0_0ElementType());
            	    				
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

            // PsiInternalImportUriTestLanguage.g:77:3: ( (lv_types_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalImportUriTestLanguage.g:78:4: (lv_types_1_0= ruleType )
            	    {
            	    // PsiInternalImportUriTestLanguage.g:78:4: (lv_types_1_0= ruleType )
            	    // PsiInternalImportUriTestLanguage.g:79:5: lv_types_1_0= ruleType
            	    {

            	    					markComposite(elementTypeProvider.getMain_TypesTypeParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_4);
            	    lv_types_1_0=ruleType();

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
            	    break loop2;
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
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleImport"
    // PsiInternalImportUriTestLanguage.g:96:1: entryRuleImport returns [Boolean current=false] : iv_ruleImport= ruleImport EOF ;
    public final Boolean entryRuleImport() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleImport = null;


        try {
            // PsiInternalImportUriTestLanguage.g:96:48: (iv_ruleImport= ruleImport EOF )
            // PsiInternalImportUriTestLanguage.g:97:2: iv_ruleImport= ruleImport EOF
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
    // PsiInternalImportUriTestLanguage.g:103:1: ruleImport returns [Boolean current=false] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final Boolean ruleImport() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

        try {
            // PsiInternalImportUriTestLanguage.g:104:1: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // PsiInternalImportUriTestLanguage.g:105:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // PsiInternalImportUriTestLanguage.g:105:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // PsiInternalImportUriTestLanguage.g:106:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalImportUriTestLanguage.g:113:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // PsiInternalImportUriTestLanguage.g:114:4: (lv_importURI_1_0= RULE_STRING )
            {
            // PsiInternalImportUriTestLanguage.g:114:4: (lv_importURI_1_0= RULE_STRING )
            // PsiInternalImportUriTestLanguage.g:115:5: lv_importURI_1_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getImport_ImportURISTRINGTerminalRuleCall_1_0ElementType());
            				
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_importURI_1_0);
            				

            }


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


    // $ANTLR start "entryRuleType"
    // PsiInternalImportUriTestLanguage.g:134:1: entryRuleType returns [Boolean current=false] : iv_ruleType= ruleType EOF ;
    public final Boolean entryRuleType() throws RecognitionException {
        Boolean current = false;

        Boolean iv_ruleType = null;


        try {
            // PsiInternalImportUriTestLanguage.g:134:46: (iv_ruleType= ruleType EOF )
            // PsiInternalImportUriTestLanguage.g:135:2: iv_ruleType= ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // PsiInternalImportUriTestLanguage.g:141:1: ruleType returns [Boolean current=false] : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) ;
    public final Boolean ruleType() throws RecognitionException {
        Boolean current = false;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalImportUriTestLanguage.g:142:1: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) )
            // PsiInternalImportUriTestLanguage.g:143:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            {
            // PsiInternalImportUriTestLanguage.g:143:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            // PsiInternalImportUriTestLanguage.g:144:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalImportUriTestLanguage.g:151:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalImportUriTestLanguage.g:152:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalImportUriTestLanguage.g:152:4: (lv_name_1_0= RULE_ID )
            // PsiInternalImportUriTestLanguage.g:153:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_7); 

            					if(!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getType_ExtendsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_6); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalImportUriTestLanguage.g:175:3: ( (otherlv_3= RULE_ID ) )
            // PsiInternalImportUriTestLanguage.g:176:4: (otherlv_3= RULE_ID )
            {
            // PsiInternalImportUriTestLanguage.g:176:4: (otherlv_3= RULE_ID )
            // PsiInternalImportUriTestLanguage.g:177:5: otherlv_3= RULE_ID
            {

            					if (!current) {
            						associateWithSemanticElement();
            						current = true;
            					}
            				

            					markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_2); 

            					doneLeaf(otherlv_3);
            				

            }


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
    // $ANTLR end "ruleType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    }


}
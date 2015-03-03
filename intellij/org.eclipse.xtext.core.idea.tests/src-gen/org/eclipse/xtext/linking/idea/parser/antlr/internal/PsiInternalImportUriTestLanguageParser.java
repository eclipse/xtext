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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:52:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:52:14: ( ruleMain EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:53:2: ruleMain EOF
            {
             markComposite(elementTypeProvider.getMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain54);
            ruleMain();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMain57); 

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
    // $ANTLR end "entryRuleMain"


    // $ANTLR start "ruleMain"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:58:1: ruleMain : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) ;
    public final void ruleMain() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:58:9: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:59:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:59:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:60:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:60:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:61:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:61:4: (lv_imports_0_0= ruleImport )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:62:5: lv_imports_0_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getMain_ImportsImportParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleMain89);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:71:3: ( (lv_types_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:72:4: (lv_types_1_0= ruleType )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:72:4: (lv_types_1_0= ruleType )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:73:5: lv_types_1_0= ruleType
            	    {

            	    					markComposite(elementTypeProvider.getMain_TypesTypeParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleMain128);
            	    ruleType();

            	    state._fsp--;


            	    					doneComposite();
            	    				

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
        return ;
    }
    // $ANTLR end "ruleMain"


    // $ANTLR start "entryRuleImport"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:86:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:86:16: ( ruleImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:87:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport160);
            ruleImport();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport163); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:92:1: ruleImport : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:92:11: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:93:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:93:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:94:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleImport182); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:101:3: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:102:4: (lv_importURI_1_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:102:4: (lv_importURI_1_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:103:5: lv_importURI_1_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getImport_ImportURISTRINGTerminalRuleCall_1_0ElementType());
            				
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImport209); 

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
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleType"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:116:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:116:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:117:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType240);
            ruleType();

            state._fsp--;

            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType243); 

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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:122:1: ruleType : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) ;
    public final void ruleType() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:122:9: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:123:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:123:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:124:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
            {

            			markLeaf(elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleType262); 

            			doneLeaf(otherlv_0);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:131:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:132:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:132:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:133:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType289); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getType_ExtendsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleType314); 

            			doneLeaf(otherlv_2);
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:149:3: ( (otherlv_3= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:150:4: (otherlv_3= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:150:4: (otherlv_3= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalImportUriTestLanguage.g:151:5: otherlv_3= RULE_ID
            {

            					markLeaf(elementTypeProvider.getType_ExtendsTypeCrossReference_3_0ElementType());
            				
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType341); 

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
        return ;
    }
    // $ANTLR end "ruleType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMain_in_entryRuleMain54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMain57 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleMain89 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleType_in_ruleMain128 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport160 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleImport182 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImport209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType240 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleType262 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType289 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleType314 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType341 = new BitSet(new long[]{0x0000000000000002L});
    }


}
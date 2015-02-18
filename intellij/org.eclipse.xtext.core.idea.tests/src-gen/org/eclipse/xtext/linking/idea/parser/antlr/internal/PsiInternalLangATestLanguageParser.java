package org.eclipse.xtext.linking.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.linking.services.LangATestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalLangATestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'extends'", "'implements'", "','"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public PsiInternalLangATestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalLangATestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalLangATestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g"; }



    	protected LangATestLanguageGrammarAccess grammarAccess;

    	protected LangATestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalLangATestLanguageParser(PsiBuilder builder, TokenStream input, LangATestLanguageElementTypeProvider elementTypeProvider, LangATestLanguageGrammarAccess grammarAccess) {
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:50:1: entryRuleMain : ruleMain EOF ;
    public final void entryRuleMain() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:50:14: ( ruleMain EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:51:2: ruleMain EOF
            {
             markComposite(elementTypeProvider.getMainElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMain_in_entryRuleMain54);
            ruleMain();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMain60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:59:1: ruleMain : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) ;
    public final void ruleMain() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:59:9: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:60:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:60:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:61:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_types_1_0= ruleType ) )*
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:61:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:62:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:62:4: (lv_imports_0_0= ruleImport )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:63:5: lv_imports_0_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getMain_ImportsImportParserRuleCall_0_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleMain96);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:72:3: ( (lv_types_1_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:73:4: (lv_types_1_0= ruleType )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:73:4: (lv_types_1_0= ruleType )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:74:5: lv_types_1_0= ruleType
            	    {

            	    					markComposite(elementTypeProvider.getMain_TypesTypeParserRuleCall_1_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleType_in_ruleMain135);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:87:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:87:16: ( ruleImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:88:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport167);
            ruleImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport173); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:96:1: ruleImport : (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) ;
    public final void ruleImport() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_uri_1_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:96:11: ( (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:97:2: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:97:2: (otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:98:3: otherlv_0= 'import' ( (lv_uri_1_0= RULE_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleImport196); 

            			doneLeaf(otherlv_0, elementTypeProvider.getImport_ImportKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:105:3: ( (lv_uri_1_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:106:4: (lv_uri_1_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:106:4: (lv_uri_1_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:107:5: lv_uri_1_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_uri_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleImport223); 

            					doneLeaf(lv_uri_1_0, elementTypeProvider.getImport_UriSTRINGTerminalRuleCall_1_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:120:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:120:14: ( ruleType EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:121:2: ruleType EOF
            {
             markComposite(elementTypeProvider.getTypeElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleType_in_entryRuleType254);
            ruleType();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleType260); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:129:1: ruleType : (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? ) ;
    public final void ruleType() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:129:9: ( (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:130:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:130:2: (otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:131:3: otherlv_0= 'type' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleType283); 

            			doneLeaf(otherlv_0, elementTypeProvider.getType_TypeKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:138:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:139:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:139:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:140:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType310); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getType_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:149:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:150:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {

                    				markLeaf();
                    			
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleType341); 

                    				doneLeaf(otherlv_2, elementTypeProvider.getType_ExtendsKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:157:4: ( (otherlv_3= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:158:5: (otherlv_3= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:158:5: (otherlv_3= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:159:6: otherlv_3= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType373); 

                    						doneLeaf(otherlv_3, elementTypeProvider.getType_ExtendsTypeCrossReference_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:169:3: (otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:170:4: otherlv_4= 'implements' ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {

                    				markLeaf();
                    			
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleType412); 

                    				doneLeaf(otherlv_4, elementTypeProvider.getType_ImplementsKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:177:4: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:178:5: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:178:5: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:179:6: otherlv_5= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType444); 

                    						doneLeaf(otherlv_5, elementTypeProvider.getType_ImplementsTypeCrossReference_3_1_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:188:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:189:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleType481); 

                    	    					doneLeaf(otherlv_6, elementTypeProvider.getType_CommaKeyword_3_2_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:196:5: ( (otherlv_7= RULE_ID ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:197:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:197:6: (otherlv_7= RULE_ID )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/linking/idea/parser/antlr/internal/PsiInternalLangATestLanguage.g:198:7: otherlv_7= RULE_ID
                    	    {

                    	    							markLeaf();
                    	    						
                    	    otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleType518); 

                    	    							doneLeaf(otherlv_7, elementTypeProvider.getType_ImplementsTypeCrossReference_3_2_1_0ElementType());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

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
        public static final BitSet FOLLOW_EOF_in_entryRuleMain60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleMain96 = new BitSet(new long[]{0x0000000000001802L});
        public static final BitSet FOLLOW_ruleType_in_ruleMain135 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport167 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleImport196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleImport223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleType_in_entryRuleType254 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleType260 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleType283 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType310 = new BitSet(new long[]{0x0000000000006002L});
        public static final BitSet FOLLOW_13_in_ruleType341 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType373 = new BitSet(new long[]{0x0000000000004002L});
        public static final BitSet FOLLOW_14_in_ruleType412 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType444 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleType481 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleType518 = new BitSet(new long[]{0x0000000000008002L});
    }


}
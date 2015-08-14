package org.eclipse.xtext.parser.epatch.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;

import com.intellij.lang.PsiBuilder;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PsiInternalEpatchTestLanguageParser extends AbstractPsiAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_FRAGMENT", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'epatch'", "'{'", "'}'", "'import'", "'uri'", "'ns'", "'java'", "'.'", "'extension'", "'::'", "'resource'", "'left'", "';'", "'right'", "'object'", "'='", "'|'", "'['", "','", "']'", "':'", "'null'", "'new'", "'copy'", "'migrate'", "'as'", "'each'", "'('", "')'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_FRAGMENT=6;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=7;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public PsiInternalEpatchTestLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PsiInternalEpatchTestLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return PsiInternalEpatchTestLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "PsiInternalEpatchTestLanguage.g"; }



    	protected EpatchTestLanguageGrammarAccess grammarAccess;

    	protected EpatchTestLanguageElementTypeProvider elementTypeProvider;

    	public PsiInternalEpatchTestLanguageParser(PsiBuilder builder, TokenStream input, EpatchTestLanguageElementTypeProvider elementTypeProvider, EpatchTestLanguageGrammarAccess grammarAccess) {
    		this(input);
    		setPsiBuilder(builder);
        	this.grammarAccess = grammarAccess;
    		this.elementTypeProvider = elementTypeProvider;
    	}

    	@Override
    	protected String getFirstRuleName() {
    		return "EPatch";
    	}




    // $ANTLR start "entryRuleEPatch"
    // PsiInternalEpatchTestLanguage.g:52:1: entryRuleEPatch : ruleEPatch EOF ;
    public final void entryRuleEPatch() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:52:16: ( ruleEPatch EOF )
            // PsiInternalEpatchTestLanguage.g:53:2: ruleEPatch EOF
            {
             markComposite(elementTypeProvider.getEPatchElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEPatch();

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
    // $ANTLR end "entryRuleEPatch"


    // $ANTLR start "ruleEPatch"
    // PsiInternalEpatchTestLanguage.g:58:1: ruleEPatch : (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) ;
    public final void ruleEPatch() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;

        try {
            // PsiInternalEpatchTestLanguage.g:58:11: ( (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) )
            // PsiInternalEpatchTestLanguage.g:59:2: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            {
            // PsiInternalEpatchTestLanguage.g:59:2: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            // PsiInternalEpatchTestLanguage.g:60:3: otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}'
            {

            			markLeaf(elementTypeProvider.getEPatch_EpatchKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:67:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:68:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:69:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEPatch_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEPatch_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_5); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:85:3: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:86:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:86:4: (lv_imports_3_0= ruleImport )
            	    // PsiInternalEpatchTestLanguage.g:87:5: lv_imports_3_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ImportsImportParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_5);
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

            // PsiInternalEpatchTestLanguage.g:96:3: ( (lv_resources_4_0= ruleNamedResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:97:4: (lv_resources_4_0= ruleNamedResource )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:97:4: (lv_resources_4_0= ruleNamedResource )
            	    // PsiInternalEpatchTestLanguage.g:98:5: lv_resources_4_0= ruleNamedResource
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_6);
            	    ruleNamedResource();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // PsiInternalEpatchTestLanguage.g:107:3: ( (lv_objects_5_0= ruleObjectRef ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:108:4: (lv_objects_5_0= ruleObjectRef )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:108:4: (lv_objects_5_0= ruleObjectRef )
            	    // PsiInternalEpatchTestLanguage.g:109:5: lv_objects_5_0= ruleObjectRef
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_7);
            	    ruleObjectRef();

            	    state._fsp--;


            	    					doneComposite();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            			markLeaf(elementTypeProvider.getEPatch_RightCurlyBracketKeyword_6ElementType());
            		
            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_6);
            		

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
    // $ANTLR end "ruleEPatch"


    // $ANTLR start "entryRuleImport"
    // PsiInternalEpatchTestLanguage.g:129:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:129:16: ( ruleImport EOF )
            // PsiInternalEpatchTestLanguage.g:130:2: ruleImport EOF
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
    // PsiInternalEpatchTestLanguage.g:135:1: ruleImport : ( ruleModelImport | ruleJavaImport | ruleExtensionImport ) ;
    public final void ruleImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:135:11: ( ( ruleModelImport | ruleJavaImport | ruleExtensionImport ) )
            // PsiInternalEpatchTestLanguage.g:136:2: ( ruleModelImport | ruleJavaImport | ruleExtensionImport )
            {
            // PsiInternalEpatchTestLanguage.g:136:2: ( ruleModelImport | ruleJavaImport | ruleExtensionImport )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                switch ( input.LA(2) ) {
                case 18:
                    {
                    alt4=2;
                    }
                    break;
                case 20:
                    {
                    alt4=3;
                    }
                    break;
                case RULE_ID:
                    {
                    alt4=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:137:3: ruleModelImport
                    {

                    			markComposite(elementTypeProvider.getImport_ModelImportParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleModelImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:145:3: ruleJavaImport
                    {

                    			markComposite(elementTypeProvider.getImport_JavaImportParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleJavaImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:153:3: ruleExtensionImport
                    {

                    			markComposite(elementTypeProvider.getImport_ExtensionImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExtensionImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;

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


    // $ANTLR start "entryRuleModelImport"
    // PsiInternalEpatchTestLanguage.g:164:1: entryRuleModelImport : ruleModelImport EOF ;
    public final void entryRuleModelImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:164:21: ( ruleModelImport EOF )
            // PsiInternalEpatchTestLanguage.g:165:2: ruleModelImport EOF
            {
             markComposite(elementTypeProvider.getModelImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleModelImport();

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
    // $ANTLR end "entryRuleModelImport"


    // $ANTLR start "ruleModelImport"
    // PsiInternalEpatchTestLanguage.g:170:1: ruleModelImport : ( ruleResourceImport | ruleEPackageImport ) ;
    public final void ruleModelImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:170:16: ( ( ruleResourceImport | ruleEPackageImport ) )
            // PsiInternalEpatchTestLanguage.g:171:2: ( ruleResourceImport | ruleEPackageImport )
            {
            // PsiInternalEpatchTestLanguage.g:171:2: ( ruleResourceImport | ruleEPackageImport )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==RULE_ID) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==17) ) {
                        alt5=2;
                    }
                    else if ( (LA5_2==16) ) {
                        alt5=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:172:3: ruleResourceImport
                    {

                    			markComposite(elementTypeProvider.getModelImport_ResourceImportParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleResourceImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:180:3: ruleEPackageImport
                    {

                    			markComposite(elementTypeProvider.getModelImport_EPackageImportParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleEPackageImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;

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
    // $ANTLR end "ruleModelImport"


    // $ANTLR start "entryRuleResourceImport"
    // PsiInternalEpatchTestLanguage.g:191:1: entryRuleResourceImport : ruleResourceImport EOF ;
    public final void entryRuleResourceImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:191:24: ( ruleResourceImport EOF )
            // PsiInternalEpatchTestLanguage.g:192:2: ruleResourceImport EOF
            {
             markComposite(elementTypeProvider.getResourceImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleResourceImport();

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
    // $ANTLR end "entryRuleResourceImport"


    // $ANTLR start "ruleResourceImport"
    // PsiInternalEpatchTestLanguage.g:197:1: ruleResourceImport : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) ;
    public final void ruleResourceImport() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_uri_3_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:197:19: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) )
            // PsiInternalEpatchTestLanguage.g:198:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:198:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            // PsiInternalEpatchTestLanguage.g:199:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getResourceImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:206:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:207:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:207:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:208:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getResourceImport_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_8); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getResourceImport_UriKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:224:3: ( (lv_uri_3_0= RULE_STRING ) )
            // PsiInternalEpatchTestLanguage.g:225:4: (lv_uri_3_0= RULE_STRING )
            {
            // PsiInternalEpatchTestLanguage.g:225:4: (lv_uri_3_0= RULE_STRING )
            // PsiInternalEpatchTestLanguage.g:226:5: lv_uri_3_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getResourceImport_UriSTRINGTerminalRuleCall_3_0ElementType());
            				
            lv_uri_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_uri_3_0);
            				

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
    // $ANTLR end "ruleResourceImport"


    // $ANTLR start "entryRuleEPackageImport"
    // PsiInternalEpatchTestLanguage.g:239:1: entryRuleEPackageImport : ruleEPackageImport EOF ;
    public final void entryRuleEPackageImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:239:24: ( ruleEPackageImport EOF )
            // PsiInternalEpatchTestLanguage.g:240:2: ruleEPackageImport EOF
            {
             markComposite(elementTypeProvider.getEPackageImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleEPackageImport();

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
    // $ANTLR end "entryRuleEPackageImport"


    // $ANTLR start "ruleEPackageImport"
    // PsiInternalEpatchTestLanguage.g:245:1: ruleEPackageImport : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) ;
    public final void ruleEPackageImport() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_nsURI_3_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:245:19: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) )
            // PsiInternalEpatchTestLanguage.g:246:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:246:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            // PsiInternalEpatchTestLanguage.g:247:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) )
            {

            			markLeaf(elementTypeProvider.getEPackageImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:254:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:255:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:255:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:256:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getEPackageImport_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_10); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getEPackageImport_NsKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_9); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:272:3: ( (lv_nsURI_3_0= RULE_STRING ) )
            // PsiInternalEpatchTestLanguage.g:273:4: (lv_nsURI_3_0= RULE_STRING )
            {
            // PsiInternalEpatchTestLanguage.g:273:4: (lv_nsURI_3_0= RULE_STRING )
            // PsiInternalEpatchTestLanguage.g:274:5: lv_nsURI_3_0= RULE_STRING
            {

            					markLeaf(elementTypeProvider.getEPackageImport_NsURISTRINGTerminalRuleCall_3_0ElementType());
            				
            lv_nsURI_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_nsURI_3_0);
            				

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
    // $ANTLR end "ruleEPackageImport"


    // $ANTLR start "entryRuleJavaImport"
    // PsiInternalEpatchTestLanguage.g:287:1: entryRuleJavaImport : ruleJavaImport EOF ;
    public final void entryRuleJavaImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:287:20: ( ruleJavaImport EOF )
            // PsiInternalEpatchTestLanguage.g:288:2: ruleJavaImport EOF
            {
             markComposite(elementTypeProvider.getJavaImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleJavaImport();

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
    // $ANTLR end "entryRuleJavaImport"


    // $ANTLR start "ruleJavaImport"
    // PsiInternalEpatchTestLanguage.g:293:1: ruleJavaImport : (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final void ruleJavaImport() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:293:15: ( (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // PsiInternalEpatchTestLanguage.g:294:2: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // PsiInternalEpatchTestLanguage.g:294:2: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            // PsiInternalEpatchTestLanguage.g:295:3: otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getJavaImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_11); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getJavaImport_JavaKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:309:3: ( (lv_path_2_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:310:4: (lv_path_2_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:310:4: (lv_path_2_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:311:5: lv_path_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJavaImport_PathIDTerminalRuleCall_2_0ElementType());
            				
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            					doneLeaf(lv_path_2_0);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:320:3: (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:321:4: otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getJavaImport_FullStopKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalEpatchTestLanguage.g:328:4: ( (lv_path_4_0= RULE_ID ) )
            	    // PsiInternalEpatchTestLanguage.g:329:5: (lv_path_4_0= RULE_ID )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:329:5: (lv_path_4_0= RULE_ID )
            	    // PsiInternalEpatchTestLanguage.g:330:6: lv_path_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getJavaImport_PathIDTerminalRuleCall_3_1_0ElementType());
            	    					
            	    lv_path_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

            	    						doneLeaf(lv_path_4_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "ruleJavaImport"


    // $ANTLR start "entryRuleExtensionImport"
    // PsiInternalEpatchTestLanguage.g:344:1: entryRuleExtensionImport : ruleExtensionImport EOF ;
    public final void entryRuleExtensionImport() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:344:25: ( ruleExtensionImport EOF )
            // PsiInternalEpatchTestLanguage.g:345:2: ruleExtensionImport EOF
            {
             markComposite(elementTypeProvider.getExtensionImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExtensionImport();

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
    // $ANTLR end "entryRuleExtensionImport"


    // $ANTLR start "ruleExtensionImport"
    // PsiInternalEpatchTestLanguage.g:350:1: ruleExtensionImport : (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final void ruleExtensionImport() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:350:20: ( (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // PsiInternalEpatchTestLanguage.g:351:2: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // PsiInternalEpatchTestLanguage.g:351:2: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            // PsiInternalEpatchTestLanguage.g:352:3: otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            {

            			markLeaf(elementTypeProvider.getExtensionImport_ImportKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_13); 

            			doneLeaf(otherlv_0);
            		

            			markLeaf(elementTypeProvider.getExtensionImport_ExtensionKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:366:3: ( (lv_path_2_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:367:4: (lv_path_2_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:367:4: (lv_path_2_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:368:5: lv_path_2_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getExtensionImport_PathIDTerminalRuleCall_2_0ElementType());
            				
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            					doneLeaf(lv_path_2_0);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:377:3: (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PsiInternalEpatchTestLanguage.g:378:4: otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) )
            	    {

            	    				markLeaf(elementTypeProvider.getExtensionImport_ColonColonKeyword_3_0ElementType());
            	    			
            	    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_3); 

            	    				doneLeaf(otherlv_3);
            	    			
            	    // PsiInternalEpatchTestLanguage.g:385:4: ( (lv_path_4_0= RULE_ID ) )
            	    // PsiInternalEpatchTestLanguage.g:386:5: (lv_path_4_0= RULE_ID )
            	    {
            	    // PsiInternalEpatchTestLanguage.g:386:5: (lv_path_4_0= RULE_ID )
            	    // PsiInternalEpatchTestLanguage.g:387:6: lv_path_4_0= RULE_ID
            	    {

            	    						markLeaf(elementTypeProvider.getExtensionImport_PathIDTerminalRuleCall_3_1_0ElementType());
            	    					
            	    lv_path_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_14); 

            	    						doneLeaf(lv_path_4_0);
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ruleExtensionImport"


    // $ANTLR start "entryRuleNamedResource"
    // PsiInternalEpatchTestLanguage.g:401:1: entryRuleNamedResource : ruleNamedResource EOF ;
    public final void entryRuleNamedResource() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:401:23: ( ruleNamedResource EOF )
            // PsiInternalEpatchTestLanguage.g:402:2: ruleNamedResource EOF
            {
             markComposite(elementTypeProvider.getNamedResourceElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleNamedResource();

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
    // $ANTLR end "entryRuleNamedResource"


    // $ANTLR start "ruleNamedResource"
    // PsiInternalEpatchTestLanguage.g:407:1: ruleNamedResource : (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) ;
    public final void ruleNamedResource() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_leftUri_5_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_rightUri_10_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;

        try {
            // PsiInternalEpatchTestLanguage.g:407:18: ( (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) )
            // PsiInternalEpatchTestLanguage.g:408:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            {
            // PsiInternalEpatchTestLanguage.g:408:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            // PsiInternalEpatchTestLanguage.g:409:3: otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}'
            {

            			markLeaf(elementTypeProvider.getNamedResource_ResourceKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:416:3: ( (lv_name_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:417:4: (lv_name_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:417:4: (lv_name_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:418:5: lv_name_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getNamedResource_NameIDTerminalRuleCall_1_0ElementType());
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_4); 

            					doneLeaf(lv_name_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getNamedResource_LeftCurlyBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_15); 

            			doneLeaf(otherlv_2);
            		

            			markLeaf(elementTypeProvider.getNamedResource_LeftKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalEpatchTestLanguage.g:441:3: ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=34 && LA8_0<=35)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:442:4: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:442:4: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    // PsiInternalEpatchTestLanguage.g:443:5: otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) )
                    {

                    					markLeaf(elementTypeProvider.getNamedResource_UriKeyword_4_0_0ElementType());
                    				
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEpatchTestLanguage.g:450:5: ( (lv_leftUri_5_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:451:6: (lv_leftUri_5_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:451:6: (lv_leftUri_5_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:452:7: lv_leftUri_5_0= RULE_STRING
                    {

                    							markLeaf(elementTypeProvider.getNamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0ElementType());
                    						
                    lv_leftUri_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

                    							doneLeaf(lv_leftUri_5_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:463:4: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:463:4: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:464:5: (lv_leftRoot_6_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:464:5: (lv_leftRoot_6_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:465:6: lv_leftRoot_6_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_17);
                    ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getNamedResource_SemicolonKeyword_5ElementType());
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_18); 

            			doneLeaf(otherlv_7);
            		

            			markLeaf(elementTypeProvider.getNamedResource_RightKeyword_6ElementType());
            		
            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_16); 

            			doneLeaf(otherlv_8);
            		
            // PsiInternalEpatchTestLanguage.g:489:3: ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=34 && LA9_0<=35)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:490:4: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:490:4: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    // PsiInternalEpatchTestLanguage.g:491:5: otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) )
                    {

                    					markLeaf(elementTypeProvider.getNamedResource_UriKeyword_7_0_0ElementType());
                    				
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_9); 

                    					doneLeaf(otherlv_9);
                    				
                    // PsiInternalEpatchTestLanguage.g:498:5: ( (lv_rightUri_10_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:499:6: (lv_rightUri_10_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:499:6: (lv_rightUri_10_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:500:7: lv_rightUri_10_0= RULE_STRING
                    {

                    							markLeaf(elementTypeProvider.getNamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0ElementType());
                    						
                    lv_rightUri_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_17); 

                    							doneLeaf(lv_rightUri_10_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:511:4: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:511:4: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:512:5: (lv_rightRoot_11_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:512:5: (lv_rightRoot_11_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:513:6: lv_rightRoot_11_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_17);
                    ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getNamedResource_SemicolonKeyword_8ElementType());
            		
            otherlv_12=(Token)match(input,24,FollowSets000.FOLLOW_19); 

            			doneLeaf(otherlv_12);
            		

            			markLeaf(elementTypeProvider.getNamedResource_RightCurlyBracketKeyword_9ElementType());
            		
            otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_13);
            		

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
    // $ANTLR end "ruleNamedResource"


    // $ANTLR start "entryRuleObjectRef"
    // PsiInternalEpatchTestLanguage.g:541:1: entryRuleObjectRef : ruleObjectRef EOF ;
    public final void entryRuleObjectRef() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:541:19: ( ruleObjectRef EOF )
            // PsiInternalEpatchTestLanguage.g:542:2: ruleObjectRef EOF
            {
             markComposite(elementTypeProvider.getObjectRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObjectRef();

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
    // $ANTLR end "entryRuleObjectRef"


    // $ANTLR start "ruleObjectRef"
    // PsiInternalEpatchTestLanguage.g:547:1: ruleObjectRef : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) ;
    public final void ruleObjectRef() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_leftFrag_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_leftFrag_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_rightFrag_9_0=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;

        try {
            // PsiInternalEpatchTestLanguage.g:547:14: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) )
            // PsiInternalEpatchTestLanguage.g:548:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            {
            // PsiInternalEpatchTestLanguage.g:548:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            // PsiInternalEpatchTestLanguage.g:549:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            {

            			markLeaf(elementTypeProvider.getObjectRef_ObjectKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_20); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:556:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==RULE_ID||LA10_1==23) ) {
                    alt10=1;
                }
            }
            switch (alt10) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:557:4: (lv_name_1_0= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:557:4: (lv_name_1_0= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:558:5: lv_name_1_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getObjectRef_NameIDTerminalRuleCall_1_0ElementType());
                    				
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_20); 

                    					doneLeaf(lv_name_1_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:567:3: ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==23) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:568:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:568:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:569:5: ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:569:5: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:570:6: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:570:6: (otherlv_2= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:571:7: otherlv_2= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType());
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_2);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:580:5: ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:581:6: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:581:6: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:582:7: lv_leftFrag_3_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0ElementType());
                    						
                    lv_leftFrag_3_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_22); 

                    							doneLeaf(lv_leftFrag_3_0);
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:593:4: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:593:4: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:594:5: otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    {

                    					markLeaf(elementTypeProvider.getObjectRef_LeftKeyword_2_1_0ElementType());
                    				
                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_4);
                    				
                    // PsiInternalEpatchTestLanguage.g:601:5: ( (otherlv_5= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:602:6: (otherlv_5= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:602:6: (otherlv_5= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:603:7: otherlv_5= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType());
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_5);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:612:5: ( (lv_leftFrag_6_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:613:6: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:613:6: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:614:7: lv_leftFrag_6_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0ElementType());
                    						
                    lv_leftFrag_6_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_18); 

                    							doneLeaf(lv_leftFrag_6_0);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getObjectRef_RightKeyword_2_1_3ElementType());
                    				
                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_3); 

                    					doneLeaf(otherlv_7);
                    				
                    // PsiInternalEpatchTestLanguage.g:630:5: ( (otherlv_8= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:631:6: (otherlv_8= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:631:6: (otherlv_8= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:632:7: otherlv_8= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType());
                    						
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_8);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:641:5: ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:642:6: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:642:6: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:643:7: lv_rightFrag_9_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0ElementType());
                    						
                    lv_rightFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_22); 

                    							doneLeaf(lv_rightFrag_9_0);
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:654:3: (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:655:4: otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}'
                    {

                    				markLeaf(elementTypeProvider.getObjectRef_LeftCurlyBracketKeyword_3_0ElementType());
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_10);
                    			
                    // PsiInternalEpatchTestLanguage.g:662:4: ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            int LA12_2 = input.LA(2);

                            if ( (LA12_2==27) ) {
                                int LA12_3 = input.LA(3);

                                if ( (LA12_3==29) ) {
                                    alt12=2;
                                }
                                else if ( ((LA12_3>=RULE_ID && LA12_3<=RULE_STRING)||(LA12_3>=33 && LA12_3<=35)) ) {
                                    alt12=1;
                                }


                            }


                        }


                        switch (alt12) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:663:5: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:663:5: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:664:6: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:664:6: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:665:7: lv_assignments_11_0= ruleBiSingleAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    ruleBiSingleAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalEpatchTestLanguage.g:675:5: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:675:5: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:676:6: (lv_assignments_12_0= ruleBiListAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:676:6: (lv_assignments_12_0= ruleBiListAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:677:7: lv_assignments_12_0= ruleBiListAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_23);
                    	    ruleBiListAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    // PsiInternalEpatchTestLanguage.g:687:4: (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:688:5: otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) )
                            {

                            					markLeaf(elementTypeProvider.getObjectRef_LeftKeyword_3_2_0ElementType());
                            				
                            otherlv_13=(Token)match(input,23,FollowSets000.FOLLOW_24); 

                            					doneLeaf(otherlv_13);
                            				
                            // PsiInternalEpatchTestLanguage.g:695:5: ( (lv_leftMig_14_0= ruleMigration ) )
                            // PsiInternalEpatchTestLanguage.g:696:6: (lv_leftMig_14_0= ruleMigration )
                            {
                            // PsiInternalEpatchTestLanguage.g:696:6: (lv_leftMig_14_0= ruleMigration )
                            // PsiInternalEpatchTestLanguage.g:697:7: lv_leftMig_14_0= ruleMigration
                            {

                            							markComposite(elementTypeProvider.getObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_25);
                            ruleMigration();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // PsiInternalEpatchTestLanguage.g:707:4: (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:708:5: otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) )
                            {

                            					markLeaf(elementTypeProvider.getObjectRef_RightKeyword_3_3_0ElementType());
                            				
                            otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_24); 

                            					doneLeaf(otherlv_15);
                            				
                            // PsiInternalEpatchTestLanguage.g:715:5: ( (lv_rightMig_16_0= ruleMigration ) )
                            // PsiInternalEpatchTestLanguage.g:716:6: (lv_rightMig_16_0= ruleMigration )
                            {
                            // PsiInternalEpatchTestLanguage.g:716:6: (lv_rightMig_16_0= ruleMigration )
                            // PsiInternalEpatchTestLanguage.g:717:7: lv_rightMig_16_0= ruleMigration
                            {

                            							markComposite(elementTypeProvider.getObjectRef_RightMigMigrationParserRuleCall_3_3_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_19);
                            ruleMigration();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getObjectRef_RightCurlyBracketKeyword_3_4ElementType());
                    			
                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(otherlv_17);
                    			

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
    // $ANTLR end "ruleObjectRef"


    // $ANTLR start "entryRuleBiSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:739:1: entryRuleBiSingleAssignment : ruleBiSingleAssignment EOF ;
    public final void entryRuleBiSingleAssignment() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:739:28: ( ruleBiSingleAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:740:2: ruleBiSingleAssignment EOF
            {
             markComposite(elementTypeProvider.getBiSingleAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBiSingleAssignment();

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
    // $ANTLR end "entryRuleBiSingleAssignment"


    // $ANTLR start "ruleBiSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:745:1: ruleBiSingleAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) ;
    public final void ruleBiSingleAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // PsiInternalEpatchTestLanguage.g:745:23: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) )
            // PsiInternalEpatchTestLanguage.g:746:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:746:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            // PsiInternalEpatchTestLanguage.g:747:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';'
            {
            // PsiInternalEpatchTestLanguage.g:747:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:748:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:748:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:749:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBiSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBiSingleAssignment_EqualsSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:765:3: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // PsiInternalEpatchTestLanguage.g:766:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // PsiInternalEpatchTestLanguage.g:766:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // PsiInternalEpatchTestLanguage.g:767:5: lv_leftValue_2_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getBiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_28);
            ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getBiSingleAssignment_VerticalLineKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_3);
            		
            // PsiInternalEpatchTestLanguage.g:783:3: ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) )
            // PsiInternalEpatchTestLanguage.g:784:4: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            {
            // PsiInternalEpatchTestLanguage.g:784:4: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            // PsiInternalEpatchTestLanguage.g:785:5: lv_rightValue_4_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getBiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getBiSingleAssignment_SemicolonKeyword_5ElementType());
            		
            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_5);
            		

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
    // $ANTLR end "ruleBiSingleAssignment"


    // $ANTLR start "entryRuleBiListAssignment"
    // PsiInternalEpatchTestLanguage.g:805:1: entryRuleBiListAssignment : ruleBiListAssignment EOF ;
    public final void entryRuleBiListAssignment() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:805:26: ( ruleBiListAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:806:2: ruleBiListAssignment EOF
            {
             markComposite(elementTypeProvider.getBiListAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleBiListAssignment();

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
    // $ANTLR end "entryRuleBiListAssignment"


    // $ANTLR start "ruleBiListAssignment"
    // PsiInternalEpatchTestLanguage.g:811:1: ruleBiListAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) ;
    public final void ruleBiListAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;

        try {
            // PsiInternalEpatchTestLanguage.g:811:21: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) )
            // PsiInternalEpatchTestLanguage.g:812:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:812:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            // PsiInternalEpatchTestLanguage.g:813:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';'
            {
            // PsiInternalEpatchTestLanguage.g:813:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:814:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:814:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:815:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getBiListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getBiListAssignment_EqualsSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_29); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getBiListAssignment_LeftSquareBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_30); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:838:3: ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:839:4: ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    {
                    // PsiInternalEpatchTestLanguage.g:839:4: ( (lv_leftValues_3_0= ruleListAssignmentValue ) )
                    // PsiInternalEpatchTestLanguage.g:840:5: (lv_leftValues_3_0= ruleListAssignmentValue )
                    {
                    // PsiInternalEpatchTestLanguage.g:840:5: (lv_leftValues_3_0= ruleListAssignmentValue )
                    // PsiInternalEpatchTestLanguage.g:841:6: lv_leftValues_3_0= ruleListAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_31);
                    ruleListAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:850:4: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:851:5: otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getBiListAssignment_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_32); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalEpatchTestLanguage.g:858:5: ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    // PsiInternalEpatchTestLanguage.g:859:6: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:859:6: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    // PsiInternalEpatchTestLanguage.g:860:7: lv_leftValues_5_0= ruleListAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_31);
                    	    ruleListAssignmentValue();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getBiListAssignment_VerticalLineKeyword_4ElementType());
            		
            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_33); 

            			doneLeaf(otherlv_6);
            		
            // PsiInternalEpatchTestLanguage.g:878:3: ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:879:4: ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    {
                    // PsiInternalEpatchTestLanguage.g:879:4: ( (lv_rightValues_7_0= ruleListAssignmentValue ) )
                    // PsiInternalEpatchTestLanguage.g:880:5: (lv_rightValues_7_0= ruleListAssignmentValue )
                    {
                    // PsiInternalEpatchTestLanguage.g:880:5: (lv_rightValues_7_0= ruleListAssignmentValue )
                    // PsiInternalEpatchTestLanguage.g:881:6: lv_rightValues_7_0= ruleListAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_34);
                    ruleListAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:890:4: (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:891:5: otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getBiListAssignment_CommaKeyword_5_1_0ElementType());
                    	    				
                    	    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_32); 

                    	    					doneLeaf(otherlv_8);
                    	    				
                    	    // PsiInternalEpatchTestLanguage.g:898:5: ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    // PsiInternalEpatchTestLanguage.g:899:6: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:899:6: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    // PsiInternalEpatchTestLanguage.g:900:7: lv_rightValues_9_0= ruleListAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    ruleListAssignmentValue();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getBiListAssignment_RightSquareBracketKeyword_6ElementType());
            		
            otherlv_10=(Token)match(input,31,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_10);
            		

            			markLeaf(elementTypeProvider.getBiListAssignment_SemicolonKeyword_7ElementType());
            		
            otherlv_11=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_11);
            		

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
    // $ANTLR end "ruleBiListAssignment"


    // $ANTLR start "entryRuleMonoSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:929:1: entryRuleMonoSingleAssignment : ruleMonoSingleAssignment EOF ;
    public final void entryRuleMonoSingleAssignment() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:929:30: ( ruleMonoSingleAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:930:2: ruleMonoSingleAssignment EOF
            {
             markComposite(elementTypeProvider.getMonoSingleAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMonoSingleAssignment();

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
    // $ANTLR end "entryRuleMonoSingleAssignment"


    // $ANTLR start "ruleMonoSingleAssignment"
    // PsiInternalEpatchTestLanguage.g:935:1: ruleMonoSingleAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) ;
    public final void ruleMonoSingleAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // PsiInternalEpatchTestLanguage.g:935:25: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) )
            // PsiInternalEpatchTestLanguage.g:936:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:936:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            // PsiInternalEpatchTestLanguage.g:937:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';'
            {
            // PsiInternalEpatchTestLanguage.g:937:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:938:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:938:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:939:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getMonoSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMonoSingleAssignment_EqualsSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:955:3: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // PsiInternalEpatchTestLanguage.g:956:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // PsiInternalEpatchTestLanguage.g:956:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // PsiInternalEpatchTestLanguage.g:957:5: lv_leftValue_2_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getMonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_17);
            ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf(elementTypeProvider.getMonoSingleAssignment_SemicolonKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

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
    // $ANTLR end "ruleMonoSingleAssignment"


    // $ANTLR start "entryRuleMonoListAssignment"
    // PsiInternalEpatchTestLanguage.g:977:1: entryRuleMonoListAssignment : ruleMonoListAssignment EOF ;
    public final void entryRuleMonoListAssignment() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:977:28: ( ruleMonoListAssignment EOF )
            // PsiInternalEpatchTestLanguage.g:978:2: ruleMonoListAssignment EOF
            {
             markComposite(elementTypeProvider.getMonoListAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMonoListAssignment();

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
    // $ANTLR end "entryRuleMonoListAssignment"


    // $ANTLR start "ruleMonoListAssignment"
    // PsiInternalEpatchTestLanguage.g:983:1: ruleMonoListAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) ;
    public final void ruleMonoListAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

        try {
            // PsiInternalEpatchTestLanguage.g:983:23: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) )
            // PsiInternalEpatchTestLanguage.g:984:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:984:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            // PsiInternalEpatchTestLanguage.g:985:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';'
            {
            // PsiInternalEpatchTestLanguage.g:985:3: ( (lv_feature_0_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:986:4: (lv_feature_0_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:986:4: (lv_feature_0_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:987:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getMonoListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_26); 

            					doneLeaf(lv_feature_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getMonoListAssignment_EqualsSignKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_29); 

            			doneLeaf(otherlv_1);
            		

            			markLeaf(elementTypeProvider.getMonoListAssignment_LeftSquareBracketKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_35); 

            			doneLeaf(otherlv_2);
            		
            // PsiInternalEpatchTestLanguage.g:1010:3: ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1011:4: ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    {
                    // PsiInternalEpatchTestLanguage.g:1011:4: ( (lv_leftValues_3_0= ruleAssignmentValue ) )
                    // PsiInternalEpatchTestLanguage.g:1012:5: (lv_leftValues_3_0= ruleAssignmentValue )
                    {
                    // PsiInternalEpatchTestLanguage.g:1012:5: (lv_leftValues_3_0= ruleAssignmentValue )
                    // PsiInternalEpatchTestLanguage.g:1013:6: lv_leftValues_3_0= ruleAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_34);
                    ruleAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1022:4: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:1023:5: otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    {

                    	    					markLeaf(elementTypeProvider.getMonoListAssignment_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_36); 

                    	    					doneLeaf(otherlv_4);
                    	    				
                    	    // PsiInternalEpatchTestLanguage.g:1030:5: ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    // PsiInternalEpatchTestLanguage.g:1031:6: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1031:6: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    // PsiInternalEpatchTestLanguage.g:1032:7: lv_leftValues_5_0= ruleAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_34);
                    	    ruleAssignmentValue();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getMonoListAssignment_RightSquareBracketKeyword_4ElementType());
            		
            otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_17); 

            			doneLeaf(otherlv_6);
            		

            			markLeaf(elementTypeProvider.getMonoListAssignment_SemicolonKeyword_5ElementType());
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_7);
            		

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
    // $ANTLR end "ruleMonoListAssignment"


    // $ANTLR start "entryRuleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1061:1: entryRuleAssignmentValue : ruleAssignmentValue EOF ;
    public final void entryRuleAssignmentValue() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1061:25: ( ruleAssignmentValue EOF )
            // PsiInternalEpatchTestLanguage.g:1062:2: ruleAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleAssignmentValue();

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
    // $ANTLR end "entryRuleAssignmentValue"


    // $ANTLR start "ruleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1067:1: ruleAssignmentValue : ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) ;
    public final void ruleAssignmentValue() throws RecognitionException {
        Token lv_value_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_refFeature_3_0=null;
        Token otherlv_4=null;
        Token lv_refIndex_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_impFrag_9_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1067:20: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1068:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1068:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt24=1;
                }
                break;
            case RULE_ID:
                {
                int LA24_2 = input.LA(2);

                if ( (LA24_2==EOF||LA24_2==19||(LA24_2>=30 && LA24_2<=31)) ) {
                    alt24=2;
                }
                else if ( (LA24_2==RULE_FRAGMENT) ) {
                    alt24=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 2, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 35:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1069:3: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1069:3: ( (lv_value_0_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:1070:4: (lv_value_0_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:1070:4: (lv_value_0_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:1071:5: lv_value_0_0= RULE_STRING
                    {

                    					markLeaf(elementTypeProvider.getAssignmentValue_ValueSTRINGTerminalRuleCall_0_0ElementType());
                    				
                    lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_value_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1081:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    {
                    // PsiInternalEpatchTestLanguage.g:1081:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    // PsiInternalEpatchTestLanguage.g:1082:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    {
                    // PsiInternalEpatchTestLanguage.g:1082:4: ( (otherlv_1= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1083:5: (otherlv_1= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1083:5: (otherlv_1= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1084:6: otherlv_1= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType());
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						doneLeaf(otherlv_1);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1093:4: (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1094:5: otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            {

                            					markLeaf(elementTypeProvider.getAssignmentValue_FullStopKeyword_1_1_0ElementType());
                            				
                            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_2);
                            				
                            // PsiInternalEpatchTestLanguage.g:1101:5: ( (lv_refFeature_3_0= RULE_ID ) )
                            // PsiInternalEpatchTestLanguage.g:1102:6: (lv_refFeature_3_0= RULE_ID )
                            {
                            // PsiInternalEpatchTestLanguage.g:1102:6: (lv_refFeature_3_0= RULE_ID )
                            // PsiInternalEpatchTestLanguage.g:1103:7: lv_refFeature_3_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getAssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0ElementType());
                            						
                            lv_refFeature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

                            							doneLeaf(lv_refFeature_3_0);
                            						

                            }


                            }

                            // PsiInternalEpatchTestLanguage.g:1112:5: (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // PsiInternalEpatchTestLanguage.g:1113:6: otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']'
                                    {

                                    						markLeaf(elementTypeProvider.getAssignmentValue_LeftSquareBracketKeyword_1_1_2_0ElementType());
                                    					
                                    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                                    						doneLeaf(otherlv_4);
                                    					
                                    // PsiInternalEpatchTestLanguage.g:1120:6: ( (lv_refIndex_5_0= RULE_INT ) )
                                    // PsiInternalEpatchTestLanguage.g:1121:7: (lv_refIndex_5_0= RULE_INT )
                                    {
                                    // PsiInternalEpatchTestLanguage.g:1121:7: (lv_refIndex_5_0= RULE_INT )
                                    // PsiInternalEpatchTestLanguage.g:1122:8: lv_refIndex_5_0= RULE_INT
                                    {

                                    								markLeaf(elementTypeProvider.getAssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0ElementType());
                                    							
                                    lv_refIndex_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_38); 

                                    								doneLeaf(lv_refIndex_5_0);
                                    							

                                    }


                                    }


                                    						markLeaf(elementTypeProvider.getAssignmentValue_RightSquareBracketKeyword_1_1_2_2ElementType());
                                    					
                                    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                                    						doneLeaf(otherlv_6);
                                    					

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:1142:3: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1142:3: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:1143:4: (lv_newObject_7_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:1143:4: (lv_newObject_7_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:1144:5: lv_newObject_7_0= ruleCreatedObject
                    {

                    					markComposite(elementTypeProvider.getAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCreatedObject();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEpatchTestLanguage.g:1154:3: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1154:3: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:1155:4: ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1155:4: ( (otherlv_8= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1156:5: (otherlv_8= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1156:5: (otherlv_8= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1157:6: otherlv_8= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getAssignmentValue_ImportImportCrossReference_3_0_0ElementType());
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    						doneLeaf(otherlv_8);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1166:4: ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:1167:5: (lv_impFrag_9_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1167:5: (lv_impFrag_9_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:1168:6: lv_impFrag_9_0= RULE_FRAGMENT
                    {

                    						markLeaf(elementTypeProvider.getAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0ElementType());
                    					
                    lv_impFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_impFrag_9_0);
                    					

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleAssignmentValue"


    // $ANTLR start "entryRuleListAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1182:1: entryRuleListAssignmentValue : ruleListAssignmentValue EOF ;
    public final void entryRuleListAssignmentValue() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1182:29: ( ruleListAssignmentValue EOF )
            // PsiInternalEpatchTestLanguage.g:1183:2: ruleListAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getListAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleListAssignmentValue();

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
    // $ANTLR end "entryRuleListAssignmentValue"


    // $ANTLR start "ruleListAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1188:1: ruleListAssignmentValue : ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) ;
    public final void ruleListAssignmentValue() throws RecognitionException {
        Token lv_index_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_refIndex_3_0=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_refFeature_8_0=null;
        Token otherlv_9=null;
        Token lv_refIndex_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token lv_impFrag_14_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1188:24: ( ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1189:2: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1189:2: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1190:3: ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1190:3: ( (lv_index_0_0= RULE_INT ) )
            // PsiInternalEpatchTestLanguage.g:1191:4: (lv_index_0_0= RULE_INT )
            {
            // PsiInternalEpatchTestLanguage.g:1191:4: (lv_index_0_0= RULE_INT )
            // PsiInternalEpatchTestLanguage.g:1192:5: lv_index_0_0= RULE_INT
            {

            					markLeaf(elementTypeProvider.getListAssignmentValue_IndexINTTerminalRuleCall_0_0ElementType());
            				
            lv_index_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_39); 

            					doneLeaf(lv_index_0_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getListAssignmentValue_ColonKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_40); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:1208:3: ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt27=1;
                }
                break;
            case RULE_STRING:
                {
                alt27=2;
                }
                break;
            case RULE_ID:
                {
                int LA27_3 = input.LA(2);

                if ( (LA27_3==RULE_FRAGMENT) ) {
                    alt27=5;
                }
                else if ( (LA27_3==EOF||LA27_3==19||LA27_3==28||(LA27_3>=30 && LA27_3<=31)) ) {
                    alt27=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 3, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 35:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1209:4: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    {
                    // PsiInternalEpatchTestLanguage.g:1209:4: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    // PsiInternalEpatchTestLanguage.g:1210:5: otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']'
                    {

                    					markLeaf(elementTypeProvider.getListAssignmentValue_LeftSquareBracketKeyword_2_0_0ElementType());
                    				
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                    					doneLeaf(otherlv_2);
                    				
                    // PsiInternalEpatchTestLanguage.g:1217:5: ( (lv_refIndex_3_0= RULE_INT ) )
                    // PsiInternalEpatchTestLanguage.g:1218:6: (lv_refIndex_3_0= RULE_INT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1218:6: (lv_refIndex_3_0= RULE_INT )
                    // PsiInternalEpatchTestLanguage.g:1219:7: lv_refIndex_3_0= RULE_INT
                    {

                    							markLeaf(elementTypeProvider.getListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0ElementType());
                    						
                    lv_refIndex_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_38); 

                    							doneLeaf(lv_refIndex_3_0);
                    						

                    }


                    }


                    					markLeaf(elementTypeProvider.getListAssignmentValue_RightSquareBracketKeyword_2_0_2ElementType());
                    				
                    otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                    					doneLeaf(otherlv_4);
                    				

                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1237:4: ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1237:4: ( (lv_value_5_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:1238:5: (lv_value_5_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:1238:5: (lv_value_5_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:1239:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf(elementTypeProvider.getListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_value_5_0);
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:1249:4: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    {
                    // PsiInternalEpatchTestLanguage.g:1249:4: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    // PsiInternalEpatchTestLanguage.g:1250:5: ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    {
                    // PsiInternalEpatchTestLanguage.g:1250:5: ( (otherlv_6= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1251:6: (otherlv_6= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1251:6: (otherlv_6= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1252:7: otherlv_6= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType());
                    						
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    							doneLeaf(otherlv_6);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1261:5: (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1262:6: otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            {

                            						markLeaf(elementTypeProvider.getListAssignmentValue_FullStopKeyword_2_2_1_0ElementType());
                            					
                            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                            						doneLeaf(otherlv_7);
                            					
                            // PsiInternalEpatchTestLanguage.g:1269:6: ( (lv_refFeature_8_0= RULE_ID ) )
                            // PsiInternalEpatchTestLanguage.g:1270:7: (lv_refFeature_8_0= RULE_ID )
                            {
                            // PsiInternalEpatchTestLanguage.g:1270:7: (lv_refFeature_8_0= RULE_ID )
                            // PsiInternalEpatchTestLanguage.g:1271:8: lv_refFeature_8_0= RULE_ID
                            {

                            								markLeaf(elementTypeProvider.getListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0ElementType());
                            							
                            lv_refFeature_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

                            								doneLeaf(lv_refFeature_8_0);
                            							

                            }


                            }

                            // PsiInternalEpatchTestLanguage.g:1280:6: (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // PsiInternalEpatchTestLanguage.g:1281:7: otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']'
                                    {

                                    							markLeaf(elementTypeProvider.getListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0ElementType());
                                    						
                                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                                    							doneLeaf(otherlv_9);
                                    						
                                    // PsiInternalEpatchTestLanguage.g:1288:7: ( (lv_refIndex_10_0= RULE_INT ) )
                                    // PsiInternalEpatchTestLanguage.g:1289:8: (lv_refIndex_10_0= RULE_INT )
                                    {
                                    // PsiInternalEpatchTestLanguage.g:1289:8: (lv_refIndex_10_0= RULE_INT )
                                    // PsiInternalEpatchTestLanguage.g:1290:9: lv_refIndex_10_0= RULE_INT
                                    {

                                    									markLeaf(elementTypeProvider.getListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0ElementType());
                                    								
                                    lv_refIndex_10_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_38); 

                                    									doneLeaf(lv_refIndex_10_0);
                                    								

                                    }


                                    }


                                    							markLeaf(elementTypeProvider.getListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2ElementType());
                                    						
                                    otherlv_11=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                                    							doneLeaf(otherlv_11);
                                    						

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEpatchTestLanguage.g:1310:4: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1310:4: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:1311:5: (lv_newObject_12_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:1311:5: (lv_newObject_12_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:1312:6: lv_newObject_12_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalEpatchTestLanguage.g:1322:4: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1322:4: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:1323:5: ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1323:5: ( (otherlv_13= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1324:6: (otherlv_13= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1324:6: (otherlv_13= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1325:7: otherlv_13= RULE_ID
                    {

                    							markLeaf(elementTypeProvider.getListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType());
                    						
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    							doneLeaf(otherlv_13);
                    						

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1334:5: ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:1335:6: (lv_impFrag_14_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1335:6: (lv_impFrag_14_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:1336:7: lv_impFrag_14_0= RULE_FRAGMENT
                    {

                    							markLeaf(elementTypeProvider.getListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0ElementType());
                    						
                    lv_impFrag_14_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_2); 

                    							doneLeaf(lv_impFrag_14_0);
                    						

                    }


                    }


                    }


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
    // $ANTLR end "ruleListAssignmentValue"


    // $ANTLR start "entryRuleSingleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1351:1: entryRuleSingleAssignmentValue : ruleSingleAssignmentValue EOF ;
    public final void entryRuleSingleAssignmentValue() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1351:31: ( ruleSingleAssignmentValue EOF )
            // PsiInternalEpatchTestLanguage.g:1352:2: ruleSingleAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getSingleAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleSingleAssignmentValue();

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
    // $ANTLR end "entryRuleSingleAssignmentValue"


    // $ANTLR start "ruleSingleAssignmentValue"
    // PsiInternalEpatchTestLanguage.g:1357:1: ruleSingleAssignmentValue : ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) ;
    public final void ruleSingleAssignmentValue() throws RecognitionException {
        Token lv_keyword_0_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_refFeature_4_0=null;
        Token otherlv_5=null;
        Token lv_refIndex_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_impFrag_10_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1357:26: ( ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1358:2: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1358:2: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            int alt30=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt30=1;
                }
                break;
            case RULE_STRING:
                {
                alt30=2;
                }
                break;
            case RULE_ID:
                {
                int LA30_3 = input.LA(2);

                if ( (LA30_3==RULE_FRAGMENT) ) {
                    alt30=5;
                }
                else if ( (LA30_3==EOF||LA30_3==19||LA30_3==24||LA30_3==28) ) {
                    alt30=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 3, input);

                    throw nvae;
                }
                }
                break;
            case 34:
            case 35:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1359:3: ( (lv_keyword_0_0= 'null' ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1359:3: ( (lv_keyword_0_0= 'null' ) )
                    // PsiInternalEpatchTestLanguage.g:1360:4: (lv_keyword_0_0= 'null' )
                    {
                    // PsiInternalEpatchTestLanguage.g:1360:4: (lv_keyword_0_0= 'null' )
                    // PsiInternalEpatchTestLanguage.g:1361:5: lv_keyword_0_0= 'null'
                    {

                    					markLeaf(elementTypeProvider.getSingleAssignmentValue_KeywordNullKeyword_0_0ElementType());
                    				
                    lv_keyword_0_0=(Token)match(input,33,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_keyword_0_0);
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1371:3: ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1371:3: ( (lv_value_1_0= RULE_STRING ) )
                    // PsiInternalEpatchTestLanguage.g:1372:4: (lv_value_1_0= RULE_STRING )
                    {
                    // PsiInternalEpatchTestLanguage.g:1372:4: (lv_value_1_0= RULE_STRING )
                    // PsiInternalEpatchTestLanguage.g:1373:5: lv_value_1_0= RULE_STRING
                    {

                    					markLeaf(elementTypeProvider.getSingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0ElementType());
                    				
                    lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

                    					doneLeaf(lv_value_1_0);
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // PsiInternalEpatchTestLanguage.g:1383:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    {
                    // PsiInternalEpatchTestLanguage.g:1383:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    // PsiInternalEpatchTestLanguage.g:1384:4: ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    {
                    // PsiInternalEpatchTestLanguage.g:1384:4: ( (otherlv_2= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1385:5: (otherlv_2= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1385:5: (otherlv_2= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1386:6: otherlv_2= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType());
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_12); 

                    						doneLeaf(otherlv_2);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1395:4: (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1396:5: otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            {

                            					markLeaf(elementTypeProvider.getSingleAssignmentValue_FullStopKeyword_2_1_0ElementType());
                            				
                            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_3); 

                            					doneLeaf(otherlv_3);
                            				
                            // PsiInternalEpatchTestLanguage.g:1403:5: ( (lv_refFeature_4_0= RULE_ID ) )
                            // PsiInternalEpatchTestLanguage.g:1404:6: (lv_refFeature_4_0= RULE_ID )
                            {
                            // PsiInternalEpatchTestLanguage.g:1404:6: (lv_refFeature_4_0= RULE_ID )
                            // PsiInternalEpatchTestLanguage.g:1405:7: lv_refFeature_4_0= RULE_ID
                            {

                            							markLeaf(elementTypeProvider.getSingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0ElementType());
                            						
                            lv_refFeature_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_37); 

                            							doneLeaf(lv_refFeature_4_0);
                            						

                            }


                            }

                            // PsiInternalEpatchTestLanguage.g:1414:5: (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // PsiInternalEpatchTestLanguage.g:1415:6: otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']'
                                    {

                                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0ElementType());
                                    					
                                    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_32); 

                                    						doneLeaf(otherlv_5);
                                    					
                                    // PsiInternalEpatchTestLanguage.g:1422:6: ( (lv_refIndex_6_0= RULE_INT ) )
                                    // PsiInternalEpatchTestLanguage.g:1423:7: (lv_refIndex_6_0= RULE_INT )
                                    {
                                    // PsiInternalEpatchTestLanguage.g:1423:7: (lv_refIndex_6_0= RULE_INT )
                                    // PsiInternalEpatchTestLanguage.g:1424:8: lv_refIndex_6_0= RULE_INT
                                    {

                                    								markLeaf(elementTypeProvider.getSingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0ElementType());
                                    							
                                    lv_refIndex_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_38); 

                                    								doneLeaf(lv_refIndex_6_0);
                                    							

                                    }


                                    }


                                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2ElementType());
                                    					
                                    otherlv_7=(Token)match(input,31,FollowSets000.FOLLOW_2); 

                                    						doneLeaf(otherlv_7);
                                    					

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // PsiInternalEpatchTestLanguage.g:1444:3: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1444:3: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    // PsiInternalEpatchTestLanguage.g:1445:4: (lv_newObject_8_0= ruleCreatedObject )
                    {
                    // PsiInternalEpatchTestLanguage.g:1445:4: (lv_newObject_8_0= ruleCreatedObject )
                    // PsiInternalEpatchTestLanguage.g:1446:5: lv_newObject_8_0= ruleCreatedObject
                    {

                    					markComposite(elementTypeProvider.getSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleCreatedObject();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // PsiInternalEpatchTestLanguage.g:1456:3: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1456:3: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    // PsiInternalEpatchTestLanguage.g:1457:4: ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1457:4: ( (otherlv_9= RULE_ID ) )
                    // PsiInternalEpatchTestLanguage.g:1458:5: (otherlv_9= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1458:5: (otherlv_9= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1459:6: otherlv_9= RULE_ID
                    {

                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType());
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

                    						doneLeaf(otherlv_9);
                    					

                    }


                    }

                    // PsiInternalEpatchTestLanguage.g:1468:4: ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    // PsiInternalEpatchTestLanguage.g:1469:5: (lv_impFrag_10_0= RULE_FRAGMENT )
                    {
                    // PsiInternalEpatchTestLanguage.g:1469:5: (lv_impFrag_10_0= RULE_FRAGMENT )
                    // PsiInternalEpatchTestLanguage.g:1470:6: lv_impFrag_10_0= RULE_FRAGMENT
                    {

                    						markLeaf(elementTypeProvider.getSingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0ElementType());
                    					
                    lv_impFrag_10_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_2); 

                    						doneLeaf(lv_impFrag_10_0);
                    					

                    }


                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleSingleAssignmentValue"


    // $ANTLR start "entryRuleCreatedObject"
    // PsiInternalEpatchTestLanguage.g:1484:1: entryRuleCreatedObject : ruleCreatedObject EOF ;
    public final void entryRuleCreatedObject() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1484:23: ( ruleCreatedObject EOF )
            // PsiInternalEpatchTestLanguage.g:1485:2: ruleCreatedObject EOF
            {
             markComposite(elementTypeProvider.getCreatedObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleCreatedObject();

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
    // $ANTLR end "entryRuleCreatedObject"


    // $ANTLR start "ruleCreatedObject"
    // PsiInternalEpatchTestLanguage.g:1490:1: ruleCreatedObject : ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) ;
    public final void ruleCreatedObject() throws RecognitionException {
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1490:18: ( ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) )
            // PsiInternalEpatchTestLanguage.g:1491:2: ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            {
            // PsiInternalEpatchTestLanguage.g:1491:2: ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            // PsiInternalEpatchTestLanguage.g:1492:3: ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            {
            // PsiInternalEpatchTestLanguage.g:1492:3: ( ruleObjectNew | ruleObjectCopy )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            else if ( (LA31_0==35) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1493:4: ruleObjectNew
                    {

                    				markComposite(elementTypeProvider.getCreatedObject_ObjectNewParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_41);
                    ruleObjectNew();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1501:4: ruleObjectCopy
                    {

                    				markComposite(elementTypeProvider.getCreatedObject_ObjectCopyParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_41);
                    ruleObjectCopy();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:1509:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1510:4: (lv_name_2_0= RULE_ID )
                    {
                    // PsiInternalEpatchTestLanguage.g:1510:4: (lv_name_2_0= RULE_ID )
                    // PsiInternalEpatchTestLanguage.g:1511:5: lv_name_2_0= RULE_ID
                    {

                    					markLeaf(elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType());
                    				
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_22); 

                    					doneLeaf(lv_name_2_0);
                    				

                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:1520:3: (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1521:4: otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}'
                    {

                    				markLeaf(elementTypeProvider.getCreatedObject_LeftCurlyBracketKeyword_2_0ElementType());
                    			
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_3); 

                    				doneLeaf(otherlv_3);
                    			
                    // PsiInternalEpatchTestLanguage.g:1528:4: ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=3;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            int LA33_2 = input.LA(2);

                            if ( (LA33_2==27) ) {
                                int LA33_3 = input.LA(3);

                                if ( (LA33_3==29) ) {
                                    alt33=2;
                                }
                                else if ( ((LA33_3>=RULE_ID && LA33_3<=RULE_STRING)||(LA33_3>=33 && LA33_3<=35)) ) {
                                    alt33=1;
                                }


                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // PsiInternalEpatchTestLanguage.g:1529:5: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1529:5: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:1530:6: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1530:6: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:1531:7: lv_assignments_4_0= ruleMonoSingleAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getCreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_42);
                    	    ruleMonoSingleAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // PsiInternalEpatchTestLanguage.g:1541:5: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1541:5: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    // PsiInternalEpatchTestLanguage.g:1542:6: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    {
                    	    // PsiInternalEpatchTestLanguage.g:1542:6: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    // PsiInternalEpatchTestLanguage.g:1543:7: lv_assignments_5_0= ruleMonoListAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getCreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_42);
                    	    ruleMonoListAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt33 >= 1 ) break loop33;
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);

                    // PsiInternalEpatchTestLanguage.g:1553:4: ( (lv_leftMig_6_0= ruleMigration ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // PsiInternalEpatchTestLanguage.g:1554:5: (lv_leftMig_6_0= ruleMigration )
                            {
                            // PsiInternalEpatchTestLanguage.g:1554:5: (lv_leftMig_6_0= ruleMigration )
                            // PsiInternalEpatchTestLanguage.g:1555:6: lv_leftMig_6_0= ruleMigration
                            {

                            						markComposite(elementTypeProvider.getCreatedObject_LeftMigMigrationParserRuleCall_2_2_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_19);
                            ruleMigration();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }


                    				markLeaf(elementTypeProvider.getCreatedObject_RightCurlyBracketKeyword_2_3ElementType());
                    			
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_2); 

                    				doneLeaf(otherlv_7);
                    			

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
    // $ANTLR end "ruleCreatedObject"


    // $ANTLR start "entryRuleObjectNew"
    // PsiInternalEpatchTestLanguage.g:1576:1: entryRuleObjectNew : ruleObjectNew EOF ;
    public final void entryRuleObjectNew() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1576:19: ( ruleObjectNew EOF )
            // PsiInternalEpatchTestLanguage.g:1577:2: ruleObjectNew EOF
            {
             markComposite(elementTypeProvider.getObjectNewElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObjectNew();

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
    // $ANTLR end "entryRuleObjectNew"


    // $ANTLR start "ruleObjectNew"
    // PsiInternalEpatchTestLanguage.g:1582:1: ruleObjectNew : (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) ;
    public final void ruleObjectNew() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_impFrag_2_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1582:14: ( (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1583:2: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1583:2: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            // PsiInternalEpatchTestLanguage.g:1584:3: otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            {

            			markLeaf(elementTypeProvider.getObjectNew_NewKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:1591:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:1592:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:1592:4: (otherlv_1= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:1593:5: otherlv_1= RULE_ID
            {

            					markLeaf(elementTypeProvider.getObjectNew_ImportImportCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:1602:3: ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            // PsiInternalEpatchTestLanguage.g:1603:4: (lv_impFrag_2_0= RULE_FRAGMENT )
            {
            // PsiInternalEpatchTestLanguage.g:1603:4: (lv_impFrag_2_0= RULE_FRAGMENT )
            // PsiInternalEpatchTestLanguage.g:1604:5: lv_impFrag_2_0= RULE_FRAGMENT
            {

            					markLeaf(elementTypeProvider.getObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0ElementType());
            				
            lv_impFrag_2_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_impFrag_2_0);
            				

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
    // $ANTLR end "ruleObjectNew"


    // $ANTLR start "entryRuleObjectCopy"
    // PsiInternalEpatchTestLanguage.g:1617:1: entryRuleObjectCopy : ruleObjectCopy EOF ;
    public final void entryRuleObjectCopy() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1617:20: ( ruleObjectCopy EOF )
            // PsiInternalEpatchTestLanguage.g:1618:2: ruleObjectCopy EOF
            {
             markComposite(elementTypeProvider.getObjectCopyElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleObjectCopy();

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
    // $ANTLR end "entryRuleObjectCopy"


    // $ANTLR start "ruleObjectCopy"
    // PsiInternalEpatchTestLanguage.g:1623:1: ruleObjectCopy : (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) ;
    public final void ruleObjectCopy() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fragment_2_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1623:15: ( (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) )
            // PsiInternalEpatchTestLanguage.g:1624:2: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            {
            // PsiInternalEpatchTestLanguage.g:1624:2: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            // PsiInternalEpatchTestLanguage.g:1625:3: otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            {

            			markLeaf(elementTypeProvider.getObjectCopy_CopyKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:1632:3: ( (otherlv_1= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:1633:4: (otherlv_1= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:1633:4: (otherlv_1= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:1634:5: otherlv_1= RULE_ID
            {

            					markLeaf(elementTypeProvider.getObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType());
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_21); 

            					doneLeaf(otherlv_1);
            				

            }


            }

            // PsiInternalEpatchTestLanguage.g:1643:3: ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            // PsiInternalEpatchTestLanguage.g:1644:4: (lv_fragment_2_0= RULE_FRAGMENT )
            {
            // PsiInternalEpatchTestLanguage.g:1644:4: (lv_fragment_2_0= RULE_FRAGMENT )
            // PsiInternalEpatchTestLanguage.g:1645:5: lv_fragment_2_0= RULE_FRAGMENT
            {

            					markLeaf(elementTypeProvider.getObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0ElementType());
            				
            lv_fragment_2_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_2); 

            					doneLeaf(lv_fragment_2_0);
            				

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
    // $ANTLR end "ruleObjectCopy"


    // $ANTLR start "entryRuleMigration"
    // PsiInternalEpatchTestLanguage.g:1658:1: entryRuleMigration : ruleMigration EOF ;
    public final void entryRuleMigration() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1658:19: ( ruleMigration EOF )
            // PsiInternalEpatchTestLanguage.g:1659:2: ruleMigration EOF
            {
             markComposite(elementTypeProvider.getMigrationElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleMigration();

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
    // $ANTLR end "entryRuleMigration"


    // $ANTLR start "ruleMigration"
    // PsiInternalEpatchTestLanguage.g:1664:1: ruleMigration : ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) ;
    public final void ruleMigration() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1664:14: ( ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) )
            // PsiInternalEpatchTestLanguage.g:1665:2: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            {
            // PsiInternalEpatchTestLanguage.g:1665:2: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            // PsiInternalEpatchTestLanguage.g:1666:3: () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';'
            {
            // PsiInternalEpatchTestLanguage.g:1666:3: ()
            // PsiInternalEpatchTestLanguage.g:1667:4: 
            {

            				precedeComposite(elementTypeProvider.getMigration_MigrationAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf(elementTypeProvider.getMigration_MigrateKeyword_1ElementType());
            		
            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_43); 

            			doneLeaf(otherlv_1);
            		
            // PsiInternalEpatchTestLanguage.g:1679:3: ( (lv_first_2_0= ruleExecutable ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1680:4: (lv_first_2_0= ruleExecutable )
                    {
                    // PsiInternalEpatchTestLanguage.g:1680:4: (lv_first_2_0= ruleExecutable )
                    // PsiInternalEpatchTestLanguage.g:1681:5: lv_first_2_0= ruleExecutable
                    {

                    					markComposite(elementTypeProvider.getMigration_FirstExecutableParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_44);
                    ruleExecutable();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // PsiInternalEpatchTestLanguage.g:1690:3: ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )?
            int alt37=3;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==37) ) {
                alt37=1;
            }
            else if ( (LA37_0==38) ) {
                alt37=2;
            }
            switch (alt37) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1691:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1691:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    // PsiInternalEpatchTestLanguage.g:1692:5: otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) )
                    {

                    					markLeaf(elementTypeProvider.getMigration_AsKeyword_3_0_0ElementType());
                    				
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_45); 

                    					doneLeaf(otherlv_3);
                    				
                    // PsiInternalEpatchTestLanguage.g:1699:5: ( (lv_asOp_4_0= ruleExecutable ) )
                    // PsiInternalEpatchTestLanguage.g:1700:6: (lv_asOp_4_0= ruleExecutable )
                    {
                    // PsiInternalEpatchTestLanguage.g:1700:6: (lv_asOp_4_0= ruleExecutable )
                    // PsiInternalEpatchTestLanguage.g:1701:7: lv_asOp_4_0= ruleExecutable
                    {

                    							markComposite(elementTypeProvider.getMigration_AsOpExecutableParserRuleCall_3_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_17);
                    ruleExecutable();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1712:4: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    {
                    // PsiInternalEpatchTestLanguage.g:1712:4: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    // PsiInternalEpatchTestLanguage.g:1713:5: otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) )
                    {

                    					markLeaf(elementTypeProvider.getMigration_EachKeyword_3_1_0ElementType());
                    				
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_45); 

                    					doneLeaf(otherlv_5);
                    				
                    // PsiInternalEpatchTestLanguage.g:1720:5: ( (lv_eachOp_6_0= ruleExecutable ) )
                    // PsiInternalEpatchTestLanguage.g:1721:6: (lv_eachOp_6_0= ruleExecutable )
                    {
                    // PsiInternalEpatchTestLanguage.g:1721:6: (lv_eachOp_6_0= ruleExecutable )
                    // PsiInternalEpatchTestLanguage.g:1722:7: lv_eachOp_6_0= ruleExecutable
                    {

                    							markComposite(elementTypeProvider.getMigration_EachOpExecutableParserRuleCall_3_1_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_17);
                    ruleExecutable();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			markLeaf(elementTypeProvider.getMigration_SemicolonKeyword_4ElementType());
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_7);
            		

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
    // $ANTLR end "ruleMigration"


    // $ANTLR start "entryRuleExecutable"
    // PsiInternalEpatchTestLanguage.g:1744:1: entryRuleExecutable : ruleExecutable EOF ;
    public final void entryRuleExecutable() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1744:20: ( ruleExecutable EOF )
            // PsiInternalEpatchTestLanguage.g:1745:2: ruleExecutable EOF
            {
             markComposite(elementTypeProvider.getExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExecutable();

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
    // $ANTLR end "entryRuleExecutable"


    // $ANTLR start "ruleExecutable"
    // PsiInternalEpatchTestLanguage.g:1750:1: ruleExecutable : ( ruleJavaExecutable | ruleExpressionExecutable ) ;
    public final void ruleExecutable() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1750:15: ( ( ruleJavaExecutable | ruleExpressionExecutable ) )
            // PsiInternalEpatchTestLanguage.g:1751:2: ( ruleJavaExecutable | ruleExpressionExecutable )
            {
            // PsiInternalEpatchTestLanguage.g:1751:2: ( ruleJavaExecutable | ruleExpressionExecutable )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==18) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_STRING) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // PsiInternalEpatchTestLanguage.g:1752:3: ruleJavaExecutable
                    {

                    			markComposite(elementTypeProvider.getExecutable_JavaExecutableParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleJavaExecutable();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // PsiInternalEpatchTestLanguage.g:1760:3: ruleExpressionExecutable
                    {

                    			markComposite(elementTypeProvider.getExecutable_ExpressionExecutableParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_2);
                    ruleExpressionExecutable();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;

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
    // $ANTLR end "ruleExecutable"


    // $ANTLR start "entryRuleJavaExecutable"
    // PsiInternalEpatchTestLanguage.g:1771:1: entryRuleJavaExecutable : ruleJavaExecutable EOF ;
    public final void entryRuleJavaExecutable() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1771:24: ( ruleJavaExecutable EOF )
            // PsiInternalEpatchTestLanguage.g:1772:2: ruleJavaExecutable EOF
            {
             markComposite(elementTypeProvider.getJavaExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleJavaExecutable();

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
    // $ANTLR end "entryRuleJavaExecutable"


    // $ANTLR start "ruleJavaExecutable"
    // PsiInternalEpatchTestLanguage.g:1777:1: ruleJavaExecutable : (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) ;
    public final void ruleJavaExecutable() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_method_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1777:19: ( (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) )
            // PsiInternalEpatchTestLanguage.g:1778:2: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            {
            // PsiInternalEpatchTestLanguage.g:1778:2: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            // PsiInternalEpatchTestLanguage.g:1779:3: otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')'
            {

            			markLeaf(elementTypeProvider.getJavaExecutable_JavaKeyword_0ElementType());
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_3); 

            			doneLeaf(otherlv_0);
            		
            // PsiInternalEpatchTestLanguage.g:1786:3: ( (lv_method_1_0= RULE_ID ) )
            // PsiInternalEpatchTestLanguage.g:1787:4: (lv_method_1_0= RULE_ID )
            {
            // PsiInternalEpatchTestLanguage.g:1787:4: (lv_method_1_0= RULE_ID )
            // PsiInternalEpatchTestLanguage.g:1788:5: lv_method_1_0= RULE_ID
            {

            					markLeaf(elementTypeProvider.getJavaExecutable_MethodIDTerminalRuleCall_1_0ElementType());
            				
            lv_method_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_46); 

            					doneLeaf(lv_method_1_0);
            				

            }


            }


            			markLeaf(elementTypeProvider.getJavaExecutable_LeftParenthesisKeyword_2ElementType());
            		
            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_47); 

            			doneLeaf(otherlv_2);
            		

            			markLeaf(elementTypeProvider.getJavaExecutable_RightParenthesisKeyword_3ElementType());
            		
            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_2); 

            			doneLeaf(otherlv_3);
            		

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
    // $ANTLR end "ruleJavaExecutable"


    // $ANTLR start "entryRuleExpressionExecutable"
    // PsiInternalEpatchTestLanguage.g:1815:1: entryRuleExpressionExecutable : ruleExpressionExecutable EOF ;
    public final void entryRuleExpressionExecutable() throws RecognitionException {
        try {
            // PsiInternalEpatchTestLanguage.g:1815:30: ( ruleExpressionExecutable EOF )
            // PsiInternalEpatchTestLanguage.g:1816:2: ruleExpressionExecutable EOF
            {
             markComposite(elementTypeProvider.getExpressionExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_1);
            ruleExpressionExecutable();

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
    // $ANTLR end "entryRuleExpressionExecutable"


    // $ANTLR start "ruleExpressionExecutable"
    // PsiInternalEpatchTestLanguage.g:1821:1: ruleExpressionExecutable : ( (lv_exprstr_0_0= RULE_STRING ) ) ;
    public final void ruleExpressionExecutable() throws RecognitionException {
        Token lv_exprstr_0_0=null;

        try {
            // PsiInternalEpatchTestLanguage.g:1821:25: ( ( (lv_exprstr_0_0= RULE_STRING ) ) )
            // PsiInternalEpatchTestLanguage.g:1822:2: ( (lv_exprstr_0_0= RULE_STRING ) )
            {
            // PsiInternalEpatchTestLanguage.g:1822:2: ( (lv_exprstr_0_0= RULE_STRING ) )
            // PsiInternalEpatchTestLanguage.g:1823:3: (lv_exprstr_0_0= RULE_STRING )
            {
            // PsiInternalEpatchTestLanguage.g:1823:3: (lv_exprstr_0_0= RULE_STRING )
            // PsiInternalEpatchTestLanguage.g:1824:4: lv_exprstr_0_0= RULE_STRING
            {

            				markLeaf(elementTypeProvider.getExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0ElementType());
            			
            lv_exprstr_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); 

            				doneLeaf(lv_exprstr_0_0);
            			

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
    // $ANTLR end "ruleExpressionExecutable"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004404000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002004000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010000080L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000080000080L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000C80010030L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000C00010030L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000C20010030L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000006001040020L});
        public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000006001000000L});
        public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000010000000000L});
    }


}
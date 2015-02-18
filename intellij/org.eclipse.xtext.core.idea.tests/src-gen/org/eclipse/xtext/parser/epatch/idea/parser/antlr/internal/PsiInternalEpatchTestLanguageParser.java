package org.eclipse.xtext.parser.epatch.idea.parser.antlr.internal;

import org.eclipse.xtext.idea.parser.AbstractPsiAntlrParser;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
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
    public String getGrammarFileName() { return "../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g"; }



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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:50:1: entryRuleEPatch : ruleEPatch EOF ;
    public final void entryRuleEPatch() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:50:16: ( ruleEPatch EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:51:2: ruleEPatch EOF
            {
             markComposite(elementTypeProvider.getEPatchElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPatch_in_entryRuleEPatch54);
            ruleEPatch();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPatch60); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:59:1: ruleEPatch : (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) ;
    public final void ruleEPatch() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:59:11: ( (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:60:2: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:60:2: (otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:61:3: otherlv_0= 'epatch' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_imports_3_0= ruleImport ) )* ( (lv_resources_4_0= ruleNamedResource ) )* ( (lv_objects_5_0= ruleObjectRef ) )* otherlv_6= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleEPatch83); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEPatch_EpatchKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:68:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:69:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:69:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:70:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEPatch110); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEPatch_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEPatch135); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEPatch_LeftCurlyBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:86:3: ( (lv_imports_3_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:87:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:87:4: (lv_imports_3_0= ruleImport )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:88:5: lv_imports_3_0= ruleImport
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ImportsImportParserRuleCall_3_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleEPatch162);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:97:3: ( (lv_resources_4_0= ruleNamedResource ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:98:4: (lv_resources_4_0= ruleNamedResource )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:98:4: (lv_resources_4_0= ruleNamedResource )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:99:5: lv_resources_4_0= ruleNamedResource
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleNamedResource_in_ruleEPatch201);
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

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:108:3: ( (lv_objects_5_0= ruleObjectRef ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==26) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:109:4: (lv_objects_5_0= ruleObjectRef )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:109:4: (lv_objects_5_0= ruleObjectRef )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:110:5: lv_objects_5_0= ruleObjectRef
            	    {

            	    					markComposite(elementTypeProvider.getEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType());
            	    				
            	    pushFollow(FollowSets000.FOLLOW_ruleObjectRef_in_ruleEPatch240);
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


            			markLeaf();
            		
            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEPatch266); 

            			doneLeaf(otherlv_6, elementTypeProvider.getEPatch_RightCurlyBracketKeyword_6ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:130:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:130:16: ( ruleImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:131:2: ruleImport EOF
            {
             markComposite(elementTypeProvider.getImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport286);
            ruleImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport292); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:139:1: ruleImport : ( ruleModelImport | ruleJavaImport | ruleExtensionImport ) ;
    public final void ruleImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:139:11: ( ( ruleModelImport | ruleJavaImport | ruleExtensionImport ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:140:2: ( ruleModelImport | ruleJavaImport | ruleExtensionImport )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:140:2: ( ruleModelImport | ruleJavaImport | ruleExtensionImport )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                switch ( input.LA(2) ) {
                case 18:
                    {
                    alt4=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt4=1;
                    }
                    break;
                case 20:
                    {
                    alt4=3;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:141:3: ruleModelImport
                    {

                    			markComposite(elementTypeProvider.getImport_ModelImportParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleModelImport_in_ruleImport313);
                    ruleModelImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:149:3: ruleJavaImport
                    {

                    			markComposite(elementTypeProvider.getImport_JavaImportParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleJavaImport_in_ruleImport333);
                    ruleJavaImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:157:3: ruleExtensionImport
                    {

                    			markComposite(elementTypeProvider.getImport_ExtensionImportParserRuleCall_2ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleExtensionImport_in_ruleImport353);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:168:1: entryRuleModelImport : ruleModelImport EOF ;
    public final void entryRuleModelImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:168:21: ( ruleModelImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:169:2: ruleModelImport EOF
            {
             markComposite(elementTypeProvider.getModelImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleModelImport_in_entryRuleModelImport373);
            ruleModelImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModelImport379); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:177:1: ruleModelImport : ( ruleResourceImport | ruleEPackageImport ) ;
    public final void ruleModelImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:177:16: ( ( ruleResourceImport | ruleEPackageImport ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:178:2: ( ruleResourceImport | ruleEPackageImport )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:178:2: ( ruleResourceImport | ruleEPackageImport )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:179:3: ruleResourceImport
                    {

                    			markComposite(elementTypeProvider.getModelImport_ResourceImportParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleResourceImport_in_ruleModelImport400);
                    ruleResourceImport();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:187:3: ruleEPackageImport
                    {

                    			markComposite(elementTypeProvider.getModelImport_EPackageImportParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleEPackageImport_in_ruleModelImport420);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:198:1: entryRuleResourceImport : ruleResourceImport EOF ;
    public final void entryRuleResourceImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:198:24: ( ruleResourceImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:199:2: ruleResourceImport EOF
            {
             markComposite(elementTypeProvider.getResourceImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleResourceImport_in_entryRuleResourceImport440);
            ruleResourceImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleResourceImport446); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:207:1: ruleResourceImport : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) ;
    public final void ruleResourceImport() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_uri_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:207:19: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:208:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:208:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:209:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'uri' ( (lv_uri_3_0= RULE_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleResourceImport469); 

            			doneLeaf(otherlv_0, elementTypeProvider.getResourceImport_ImportKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:216:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:217:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:217:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:218:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleResourceImport496); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getResourceImport_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleResourceImport521); 

            			doneLeaf(otherlv_2, elementTypeProvider.getResourceImport_UriKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:234:3: ( (lv_uri_3_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:235:4: (lv_uri_3_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:235:4: (lv_uri_3_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:236:5: lv_uri_3_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_uri_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleResourceImport548); 

            					doneLeaf(lv_uri_3_0, elementTypeProvider.getResourceImport_UriSTRINGTerminalRuleCall_3_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:249:1: entryRuleEPackageImport : ruleEPackageImport EOF ;
    public final void entryRuleEPackageImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:249:24: ( ruleEPackageImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:250:2: ruleEPackageImport EOF
            {
             markComposite(elementTypeProvider.getEPackageImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport579);
            ruleEPackageImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEPackageImport585); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:258:1: ruleEPackageImport : (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) ;
    public final void ruleEPackageImport() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_nsURI_3_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:258:19: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:259:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:259:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:260:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'ns' ( (lv_nsURI_3_0= RULE_STRING ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleEPackageImport608); 

            			doneLeaf(otherlv_0, elementTypeProvider.getEPackageImport_ImportKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:267:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:268:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:268:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:269:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEPackageImport635); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getEPackageImport_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleEPackageImport660); 

            			doneLeaf(otherlv_2, elementTypeProvider.getEPackageImport_NsKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:285:3: ( (lv_nsURI_3_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:286:4: (lv_nsURI_3_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:286:4: (lv_nsURI_3_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:287:5: lv_nsURI_3_0= RULE_STRING
            {

            					markLeaf();
            				
            lv_nsURI_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEPackageImport687); 

            					doneLeaf(lv_nsURI_3_0, elementTypeProvider.getEPackageImport_NsURISTRINGTerminalRuleCall_3_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:300:1: entryRuleJavaImport : ruleJavaImport EOF ;
    public final void entryRuleJavaImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:300:20: ( ruleJavaImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:301:2: ruleJavaImport EOF
            {
             markComposite(elementTypeProvider.getJavaImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleJavaImport_in_entryRuleJavaImport718);
            ruleJavaImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJavaImport724); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:309:1: ruleJavaImport : (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final void ruleJavaImport() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:309:15: ( (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:310:2: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:310:2: (otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:311:3: otherlv_0= 'import' otherlv_1= 'java' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleJavaImport747); 

            			doneLeaf(otherlv_0, elementTypeProvider.getJavaImport_ImportKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJavaImport761); 

            			doneLeaf(otherlv_1, elementTypeProvider.getJavaImport_JavaKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:325:3: ( (lv_path_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:326:4: (lv_path_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:326:4: (lv_path_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:327:5: lv_path_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaImport788); 

            					doneLeaf(lv_path_2_0, elementTypeProvider.getJavaImport_PathIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:336:3: (otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:337:4: otherlv_3= '.' ( (lv_path_4_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleJavaImport819); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getJavaImport_FullStopKeyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:344:4: ( (lv_path_4_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:345:5: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:345:5: (lv_path_4_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:346:6: lv_path_4_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_path_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaImport851); 

            	    						doneLeaf(lv_path_4_0, elementTypeProvider.getJavaImport_PathIDTerminalRuleCall_3_1_0ElementType());
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:360:1: entryRuleExtensionImport : ruleExtensionImport EOF ;
    public final void entryRuleExtensionImport() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:360:25: ( ruleExtensionImport EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:361:2: ruleExtensionImport EOF
            {
             markComposite(elementTypeProvider.getExtensionImportElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport890);
            ruleExtensionImport();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExtensionImport896); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:369:1: ruleExtensionImport : (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) ;
    public final void ruleExtensionImport() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_path_2_0=null;
        Token otherlv_3=null;
        Token lv_path_4_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:369:20: ( (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:370:2: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:370:2: (otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )* )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:371:3: otherlv_0= 'import' otherlv_1= 'extension' ( (lv_path_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleExtensionImport919); 

            			doneLeaf(otherlv_0, elementTypeProvider.getExtensionImport_ImportKeyword_0ElementType());
            		

            			markLeaf();
            		
            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleExtensionImport933); 

            			doneLeaf(otherlv_1, elementTypeProvider.getExtensionImport_ExtensionKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:385:3: ( (lv_path_2_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:386:4: (lv_path_2_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:386:4: (lv_path_2_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:387:5: lv_path_2_0= RULE_ID
            {

            					markLeaf();
            				
            lv_path_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtensionImport960); 

            					doneLeaf(lv_path_2_0, elementTypeProvider.getExtensionImport_PathIDTerminalRuleCall_2_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:396:3: (otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==21) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:397:4: otherlv_3= '::' ( (lv_path_4_0= RULE_ID ) )
            	    {

            	    				markLeaf();
            	    			
            	    otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleExtensionImport991); 

            	    				doneLeaf(otherlv_3, elementTypeProvider.getExtensionImport_ColonColonKeyword_3_0ElementType());
            	    			
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:404:4: ( (lv_path_4_0= RULE_ID ) )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:405:5: (lv_path_4_0= RULE_ID )
            	    {
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:405:5: (lv_path_4_0= RULE_ID )
            	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:406:6: lv_path_4_0= RULE_ID
            	    {

            	    						markLeaf();
            	    					
            	    lv_path_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleExtensionImport1023); 

            	    						doneLeaf(lv_path_4_0, elementTypeProvider.getExtensionImport_PathIDTerminalRuleCall_3_1_0ElementType());
            	    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:420:1: entryRuleNamedResource : ruleNamedResource EOF ;
    public final void entryRuleNamedResource() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:420:23: ( ruleNamedResource EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:421:2: ruleNamedResource EOF
            {
             markComposite(elementTypeProvider.getNamedResourceElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleNamedResource_in_entryRuleNamedResource1062);
            ruleNamedResource();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNamedResource1068); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:429:1: ruleNamedResource : (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:429:18: ( (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:430:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:430:2: (otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:431:3: otherlv_0= 'resource' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'left' ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) ) otherlv_7= ';' otherlv_8= 'right' ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) ) otherlv_12= ';' otherlv_13= '}'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleNamedResource1091); 

            			doneLeaf(otherlv_0, elementTypeProvider.getNamedResource_ResourceKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:438:3: ( (lv_name_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:439:4: (lv_name_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:439:4: (lv_name_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:440:5: lv_name_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleNamedResource1118); 

            					doneLeaf(lv_name_1_0, elementTypeProvider.getNamedResource_NameIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleNamedResource1143); 

            			doneLeaf(otherlv_2, elementTypeProvider.getNamedResource_LeftCurlyBracketKeyword_2ElementType());
            		

            			markLeaf();
            		
            otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleNamedResource1157); 

            			doneLeaf(otherlv_3, elementTypeProvider.getNamedResource_LeftKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:463:3: ( (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) ) | ( (lv_leftRoot_6_0= ruleCreatedObject ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:464:4: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:464:4: (otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:465:5: otherlv_4= 'uri' ( (lv_leftUri_5_0= RULE_STRING ) )
                    {

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNamedResource1184); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getNamedResource_UriKeyword_4_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:472:5: ( (lv_leftUri_5_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:473:6: (lv_leftUri_5_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:473:6: (lv_leftUri_5_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:474:7: lv_leftUri_5_0= RULE_STRING
                    {

                    							markLeaf();
                    						
                    lv_leftUri_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNamedResource1221); 

                    							doneLeaf(lv_leftUri_5_0, elementTypeProvider.getNamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:485:4: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:485:4: ( (lv_leftRoot_6_0= ruleCreatedObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:486:5: (lv_leftRoot_6_0= ruleCreatedObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:486:5: (lv_leftRoot_6_0= ruleCreatedObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:487:6: lv_leftRoot_6_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleNamedResource1283);
                    ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedResource1315); 

            			doneLeaf(otherlv_7, elementTypeProvider.getNamedResource_SemicolonKeyword_5ElementType());
            		

            			markLeaf();
            		
            otherlv_8=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleNamedResource1329); 

            			doneLeaf(otherlv_8, elementTypeProvider.getNamedResource_RightKeyword_6ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:511:3: ( (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) ) | ( (lv_rightRoot_11_0= ruleCreatedObject ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:512:4: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:512:4: (otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:513:5: otherlv_9= 'uri' ( (lv_rightUri_10_0= RULE_STRING ) )
                    {

                    					markLeaf();
                    				
                    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleNamedResource1356); 

                    					doneLeaf(otherlv_9, elementTypeProvider.getNamedResource_UriKeyword_7_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:520:5: ( (lv_rightUri_10_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:521:6: (lv_rightUri_10_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:521:6: (lv_rightUri_10_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:522:7: lv_rightUri_10_0= RULE_STRING
                    {

                    							markLeaf();
                    						
                    lv_rightUri_10_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleNamedResource1393); 

                    							doneLeaf(lv_rightUri_10_0, elementTypeProvider.getNamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:533:4: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:533:4: ( (lv_rightRoot_11_0= ruleCreatedObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:534:5: (lv_rightRoot_11_0= ruleCreatedObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:534:5: (lv_rightRoot_11_0= ruleCreatedObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:535:6: lv_rightRoot_11_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleNamedResource1455);
                    ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_12=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleNamedResource1487); 

            			doneLeaf(otherlv_12, elementTypeProvider.getNamedResource_SemicolonKeyword_8ElementType());
            		

            			markLeaf();
            		
            otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleNamedResource1501); 

            			doneLeaf(otherlv_13, elementTypeProvider.getNamedResource_RightCurlyBracketKeyword_9ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:563:1: entryRuleObjectRef : ruleObjectRef EOF ;
    public final void entryRuleObjectRef() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:563:19: ( ruleObjectRef EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:564:2: ruleObjectRef EOF
            {
             markComposite(elementTypeProvider.getObjectRefElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectRef_in_entryRuleObjectRef1521);
            ruleObjectRef();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectRef1527); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:572:1: ruleObjectRef : (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:572:14: ( (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:573:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:573:2: (otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:574:3: otherlv_0= 'object' ( (lv_name_1_0= RULE_ID ) )? ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) ) (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleObjectRef1550); 

            			doneLeaf(otherlv_0, elementTypeProvider.getObjectRef_ObjectKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:581:3: ( (lv_name_1_0= RULE_ID ) )?
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:582:4: (lv_name_1_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:582:4: (lv_name_1_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:583:5: lv_name_1_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1577); 

                    					doneLeaf(lv_name_1_0, elementTypeProvider.getObjectRef_NameIDTerminalRuleCall_1_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:592:3: ( ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) ) | (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:593:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:593:4: ( ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:594:5: ( (otherlv_2= RULE_ID ) ) ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:594:5: ( (otherlv_2= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:595:6: (otherlv_2= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:595:6: (otherlv_2= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:596:7: otherlv_2= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1633); 

                    							doneLeaf(otherlv_2, elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:605:5: ( (lv_leftFrag_3_0= RULE_FRAGMENT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:606:6: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:606:6: (lv_leftFrag_3_0= RULE_FRAGMENT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:607:7: lv_leftFrag_3_0= RULE_FRAGMENT
                    {

                    							markLeaf();
                    						
                    lv_leftFrag_3_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1685); 

                    							doneLeaf(lv_leftFrag_3_0, elementTypeProvider.getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:618:4: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:618:4: (otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:619:5: otherlv_4= 'left' ( (otherlv_5= RULE_ID ) ) ( (lv_leftFrag_6_0= RULE_FRAGMENT ) ) otherlv_7= 'right' ( (otherlv_8= RULE_ID ) ) ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    {

                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObjectRef1739); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getObjectRef_LeftKeyword_2_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:626:5: ( (otherlv_5= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:627:6: (otherlv_5= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:627:6: (otherlv_5= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:628:7: otherlv_5= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1776); 

                    							doneLeaf(otherlv_5, elementTypeProvider.getObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:637:5: ( (lv_leftFrag_6_0= RULE_FRAGMENT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:638:6: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:638:6: (lv_leftFrag_6_0= RULE_FRAGMENT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:639:7: lv_leftFrag_6_0= RULE_FRAGMENT
                    {

                    							markLeaf();
                    						
                    lv_leftFrag_6_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1828); 

                    							doneLeaf(lv_leftFrag_6_0, elementTypeProvider.getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0ElementType());
                    						

                    }


                    }


                    					markLeaf();
                    				
                    otherlv_7=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleObjectRef1863); 

                    					doneLeaf(otherlv_7, elementTypeProvider.getObjectRef_RightKeyword_2_1_3ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:655:5: ( (otherlv_8= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:656:6: (otherlv_8= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:656:6: (otherlv_8= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:657:7: otherlv_8= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectRef1900); 

                    							doneLeaf(otherlv_8, elementTypeProvider.getObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:666:5: ( (lv_rightFrag_9_0= RULE_FRAGMENT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:667:6: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:667:6: (lv_rightFrag_9_0= RULE_FRAGMENT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:668:7: lv_rightFrag_9_0= RULE_FRAGMENT
                    {

                    							markLeaf();
                    						
                    lv_rightFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1952); 

                    							doneLeaf(lv_rightFrag_9_0, elementTypeProvider.getObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0ElementType());
                    						

                    }


                    }


                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:679:3: (otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:680:4: otherlv_10= '{' ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+ (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )? (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )? otherlv_17= '}'
                    {

                    				markLeaf();
                    			
                    otherlv_10=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleObjectRef1998); 

                    				doneLeaf(otherlv_10, elementTypeProvider.getObjectRef_LeftCurlyBracketKeyword_3_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:687:4: ( ( (lv_assignments_11_0= ruleBiSingleAssignment ) ) | ( (lv_assignments_12_0= ruleBiListAssignment ) ) )+
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
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:688:5: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:688:5: ( (lv_assignments_11_0= ruleBiSingleAssignment ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:689:6: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:689:6: (lv_assignments_11_0= ruleBiSingleAssignment )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:690:7: lv_assignments_11_0= ruleBiSingleAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef2039);
                    	    ruleBiSingleAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:700:5: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:700:5: ( (lv_assignments_12_0= ruleBiListAssignment ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:701:6: (lv_assignments_12_0= ruleBiListAssignment )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:701:6: (lv_assignments_12_0= ruleBiListAssignment )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:702:7: lv_assignments_12_0= ruleBiListAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleBiListAssignment_in_ruleObjectRef2101);
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

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:712:4: (otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==23) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:713:5: otherlv_13= 'left' ( (lv_leftMig_14_0= ruleMigration ) )
                            {

                            					markLeaf();
                            				
                            otherlv_13=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleObjectRef2147); 

                            					doneLeaf(otherlv_13, elementTypeProvider.getObjectRef_LeftKeyword_3_2_0ElementType());
                            				
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:720:5: ( (lv_leftMig_14_0= ruleMigration ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:721:6: (lv_leftMig_14_0= ruleMigration )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:721:6: (lv_leftMig_14_0= ruleMigration )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:722:7: lv_leftMig_14_0= ruleMigration
                            {

                            							markComposite(elementTypeProvider.getObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleObjectRef2184);
                            ruleMigration();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:732:4: (otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:733:5: otherlv_15= 'right' ( (lv_rightMig_16_0= ruleMigration ) )
                            {

                            					markLeaf();
                            				
                            otherlv_15=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleObjectRef2230); 

                            					doneLeaf(otherlv_15, elementTypeProvider.getObjectRef_RightKeyword_3_3_0ElementType());
                            				
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:740:5: ( (lv_rightMig_16_0= ruleMigration ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:741:6: (lv_rightMig_16_0= ruleMigration )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:741:6: (lv_rightMig_16_0= ruleMigration )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:742:7: lv_rightMig_16_0= ruleMigration
                            {

                            							markComposite(elementTypeProvider.getObjectRef_RightMigMigrationParserRuleCall_3_3_1_0ElementType());
                            						
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleObjectRef2267);
                            ruleMigration();

                            state._fsp--;


                            							doneComposite();
                            						

                            }


                            }


                            }
                            break;

                    }


                    				markLeaf();
                    			
                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleObjectRef2306); 

                    				doneLeaf(otherlv_17, elementTypeProvider.getObjectRef_RightCurlyBracketKeyword_3_4ElementType());
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:764:1: entryRuleBiSingleAssignment : ruleBiSingleAssignment EOF ;
    public final void entryRuleBiSingleAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:764:28: ( ruleBiSingleAssignment EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:765:2: ruleBiSingleAssignment EOF
            {
             markComposite(elementTypeProvider.getBiSingleAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2332);
            ruleBiSingleAssignment();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBiSingleAssignment2338); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:773:1: ruleBiSingleAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) ;
    public final void ruleBiSingleAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:773:23: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:774:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:774:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:775:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= '|' ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) ) otherlv_5= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:775:3: ( (lv_feature_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:776:4: (lv_feature_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:776:4: (lv_feature_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:777:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBiSingleAssignment2374); 

            					doneLeaf(lv_feature_0_0, elementTypeProvider.getBiSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBiSingleAssignment2399); 

            			doneLeaf(otherlv_1, elementTypeProvider.getBiSingleAssignment_EqualsSignKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:793:3: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:794:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:794:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:795:5: lv_leftValue_2_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getBiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2426);
            ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBiSingleAssignment2451); 

            			doneLeaf(otherlv_3, elementTypeProvider.getBiSingleAssignment_VerticalLineKeyword_3ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:811:3: ( (lv_rightValue_4_0= ruleSingleAssignmentValue ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:812:4: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:812:4: (lv_rightValue_4_0= ruleSingleAssignmentValue )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:813:5: lv_rightValue_4_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getBiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2478);
            ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBiSingleAssignment2503); 

            			doneLeaf(otherlv_5, elementTypeProvider.getBiSingleAssignment_SemicolonKeyword_5ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:833:1: entryRuleBiListAssignment : ruleBiListAssignment EOF ;
    public final void entryRuleBiListAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:833:26: ( ruleBiListAssignment EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:834:2: ruleBiListAssignment EOF
            {
             markComposite(elementTypeProvider.getBiListAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2523);
            ruleBiListAssignment();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBiListAssignment2529); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:842:1: ruleBiListAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:842:21: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:843:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:843:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:844:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )? otherlv_6= '|' ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )? otherlv_10= ']' otherlv_11= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:844:3: ( (lv_feature_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:845:4: (lv_feature_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:845:4: (lv_feature_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:846:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBiListAssignment2565); 

            					doneLeaf(lv_feature_0_0, elementTypeProvider.getBiListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBiListAssignment2590); 

            			doneLeaf(otherlv_1, elementTypeProvider.getBiListAssignment_EqualsSignKeyword_1ElementType());
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleBiListAssignment2604); 

            			doneLeaf(otherlv_2, elementTypeProvider.getBiListAssignment_LeftSquareBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:869:3: ( ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:870:4: ( (lv_leftValues_3_0= ruleListAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:870:4: ( (lv_leftValues_3_0= ruleListAssignmentValue ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:871:5: (lv_leftValues_3_0= ruleListAssignmentValue )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:871:5: (lv_leftValues_3_0= ruleListAssignmentValue )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:872:6: lv_leftValues_3_0= ruleListAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2639);
                    ruleListAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:881:4: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==30) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:882:5: otherlv_4= ',' ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBiListAssignment2676); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getBiListAssignment_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:889:5: ( (lv_leftValues_5_0= ruleListAssignmentValue ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:890:6: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:890:6: (lv_leftValues_5_0= ruleListAssignmentValue )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:891:7: lv_leftValues_5_0= ruleListAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2713);
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


            			markLeaf();
            		
            otherlv_6=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBiListAssignment2755); 

            			doneLeaf(otherlv_6, elementTypeProvider.getBiListAssignment_VerticalLineKeyword_4ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:909:3: ( ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:910:4: ( (lv_rightValues_7_0= ruleListAssignmentValue ) ) (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:910:4: ( (lv_rightValues_7_0= ruleListAssignmentValue ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:911:5: (lv_rightValues_7_0= ruleListAssignmentValue )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:911:5: (lv_rightValues_7_0= ruleListAssignmentValue )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:912:6: lv_rightValues_7_0= ruleListAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2790);
                    ruleListAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:921:4: (otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==30) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:922:5: otherlv_8= ',' ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleBiListAssignment2827); 

                    	    					doneLeaf(otherlv_8, elementTypeProvider.getBiListAssignment_CommaKeyword_5_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:929:5: ( (lv_rightValues_9_0= ruleListAssignmentValue ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:930:6: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:930:6: (lv_rightValues_9_0= ruleListAssignmentValue )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:931:7: lv_rightValues_9_0= ruleListAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2864);
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


            			markLeaf();
            		
            otherlv_10=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleBiListAssignment2906); 

            			doneLeaf(otherlv_10, elementTypeProvider.getBiListAssignment_RightSquareBracketKeyword_6ElementType());
            		

            			markLeaf();
            		
            otherlv_11=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBiListAssignment2920); 

            			doneLeaf(otherlv_11, elementTypeProvider.getBiListAssignment_SemicolonKeyword_7ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:960:1: entryRuleMonoSingleAssignment : ruleMonoSingleAssignment EOF ;
    public final void entryRuleMonoSingleAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:960:30: ( ruleMonoSingleAssignment EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:961:2: ruleMonoSingleAssignment EOF
            {
             markComposite(elementTypeProvider.getMonoSingleAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2940);
            ruleMonoSingleAssignment();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMonoSingleAssignment2946); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:969:1: ruleMonoSingleAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) ;
    public final void ruleMonoSingleAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:969:25: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:970:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:970:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:971:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) ) otherlv_3= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:971:3: ( (lv_feature_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:972:4: (lv_feature_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:972:4: (lv_feature_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:973:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2982); 

            					doneLeaf(lv_feature_0_0, elementTypeProvider.getMonoSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleMonoSingleAssignment3007); 

            			doneLeaf(otherlv_1, elementTypeProvider.getMonoSingleAssignment_EqualsSignKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:989:3: ( (lv_leftValue_2_0= ruleSingleAssignmentValue ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:990:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:990:4: (lv_leftValue_2_0= ruleSingleAssignmentValue )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:991:5: lv_leftValue_2_0= ruleSingleAssignmentValue
            {

            					markComposite(elementTypeProvider.getMonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());
            				
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment3034);
            ruleSingleAssignmentValue();

            state._fsp--;


            					doneComposite();
            				

            }


            }


            			markLeaf();
            		
            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMonoSingleAssignment3059); 

            			doneLeaf(otherlv_3, elementTypeProvider.getMonoSingleAssignment_SemicolonKeyword_3ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1011:1: entryRuleMonoListAssignment : ruleMonoListAssignment EOF ;
    public final void entryRuleMonoListAssignment() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1011:28: ( ruleMonoListAssignment EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1012:2: ruleMonoListAssignment EOF
            {
             markComposite(elementTypeProvider.getMonoListAssignmentElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment3079);
            ruleMonoListAssignment();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMonoListAssignment3085); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1020:1: ruleMonoListAssignment : ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) ;
    public final void ruleMonoListAssignment() throws RecognitionException {
        Token lv_feature_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1020:23: ( ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1021:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1021:2: ( ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1022:3: ( (lv_feature_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= '[' ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )? otherlv_6= ']' otherlv_7= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1022:3: ( (lv_feature_0_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1023:4: (lv_feature_0_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1023:4: (lv_feature_0_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1024:5: lv_feature_0_0= RULE_ID
            {

            					markLeaf();
            				
            lv_feature_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMonoListAssignment3121); 

            					doneLeaf(lv_feature_0_0, elementTypeProvider.getMonoListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleMonoListAssignment3146); 

            			doneLeaf(otherlv_1, elementTypeProvider.getMonoListAssignment_EqualsSignKeyword_1ElementType());
            		

            			markLeaf();
            		
            otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMonoListAssignment3160); 

            			doneLeaf(otherlv_2, elementTypeProvider.getMonoListAssignment_LeftSquareBracketKeyword_2ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1047:3: ( ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=34 && LA21_0<=35)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1048:4: ( (lv_leftValues_3_0= ruleAssignmentValue ) ) (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1048:4: ( (lv_leftValues_3_0= ruleAssignmentValue ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1049:5: (lv_leftValues_3_0= ruleAssignmentValue )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1049:5: (lv_leftValues_3_0= ruleAssignmentValue )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1050:6: lv_leftValues_3_0= ruleAssignmentValue
                    {

                    						markComposite(elementTypeProvider.getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment3195);
                    ruleAssignmentValue();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1059:4: (otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==30) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1060:5: otherlv_4= ',' ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    {

                    	    					markLeaf();
                    	    				
                    	    otherlv_4=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleMonoListAssignment3232); 

                    	    					doneLeaf(otherlv_4, elementTypeProvider.getMonoListAssignment_CommaKeyword_3_1_0ElementType());
                    	    				
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1067:5: ( (lv_leftValues_5_0= ruleAssignmentValue ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1068:6: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1068:6: (lv_leftValues_5_0= ruleAssignmentValue )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1069:7: lv_leftValues_5_0= ruleAssignmentValue
                    	    {

                    	    							markComposite(elementTypeProvider.getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment3269);
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


            			markLeaf();
            		
            otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleMonoListAssignment3311); 

            			doneLeaf(otherlv_6, elementTypeProvider.getMonoListAssignment_RightSquareBracketKeyword_4ElementType());
            		

            			markLeaf();
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMonoListAssignment3325); 

            			doneLeaf(otherlv_7, elementTypeProvider.getMonoListAssignment_SemicolonKeyword_5ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1098:1: entryRuleAssignmentValue : ruleAssignmentValue EOF ;
    public final void entryRuleAssignmentValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1098:25: ( ruleAssignmentValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1099:2: ruleAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3345);
            ruleAssignmentValue();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAssignmentValue3351); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1107:1: ruleAssignmentValue : ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1107:20: ( ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1108:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1108:2: ( ( (lv_value_0_0= RULE_STRING ) ) | ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? ) | ( (lv_newObject_7_0= ruleCreatedObject ) ) | ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) ) )
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

                if ( (LA24_2==RULE_FRAGMENT) ) {
                    alt24=4;
                }
                else if ( (LA24_2==EOF||LA24_2==19||(LA24_2>=30 && LA24_2<=31)) ) {
                    alt24=2;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1109:3: ( (lv_value_0_0= RULE_STRING ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1109:3: ( (lv_value_0_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1110:4: (lv_value_0_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1110:4: (lv_value_0_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1111:5: lv_value_0_0= RULE_STRING
                    {

                    					markLeaf();
                    				
                    lv_value_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAssignmentValue3387); 

                    					doneLeaf(lv_value_0_0, elementTypeProvider.getAssignmentValue_ValueSTRINGTerminalRuleCall_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1121:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1121:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1122:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1122:4: ( (otherlv_1= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1123:5: (otherlv_1= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1123:5: (otherlv_1= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1124:6: otherlv_1= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue3441); 

                    						doneLeaf(otherlv_1, elementTypeProvider.getAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1133:4: (otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )? )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1134:5: otherlv_2= '.' ( (lv_refFeature_3_0= RULE_ID ) ) (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            {

                            					markLeaf();
                            				
                            otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleAssignmentValue3478); 

                            					doneLeaf(otherlv_2, elementTypeProvider.getAssignmentValue_FullStopKeyword_1_1_0ElementType());
                            				
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1141:5: ( (lv_refFeature_3_0= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1142:6: (lv_refFeature_3_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1142:6: (lv_refFeature_3_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1143:7: lv_refFeature_3_0= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_refFeature_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue3515); 

                            							doneLeaf(lv_refFeature_3_0, elementTypeProvider.getAssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0ElementType());
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1152:5: (otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']' )?
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==29) ) {
                                alt22=1;
                            }
                            switch (alt22) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1153:6: otherlv_4= '[' ( (lv_refIndex_5_0= RULE_INT ) ) otherlv_6= ']'
                                    {

                                    						markLeaf();
                                    					
                                    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleAssignmentValue3558); 

                                    						doneLeaf(otherlv_4, elementTypeProvider.getAssignmentValue_LeftSquareBracketKeyword_1_1_2_0ElementType());
                                    					
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1160:6: ( (lv_refIndex_5_0= RULE_INT ) )
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1161:7: (lv_refIndex_5_0= RULE_INT )
                                    {
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1161:7: (lv_refIndex_5_0= RULE_INT )
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1162:8: lv_refIndex_5_0= RULE_INT
                                    {

                                    								markLeaf();
                                    							
                                    lv_refIndex_5_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleAssignmentValue3600); 

                                    								doneLeaf(lv_refIndex_5_0, elementTypeProvider.getAssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0ElementType());
                                    							

                                    }


                                    }


                                    						markLeaf();
                                    					
                                    otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleAssignmentValue3640); 

                                    						doneLeaf(otherlv_6, elementTypeProvider.getAssignmentValue_RightSquareBracketKeyword_1_1_2_2ElementType());
                                    					

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1182:3: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1182:3: ( (lv_newObject_7_0= ruleCreatedObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1183:4: (lv_newObject_7_0= ruleCreatedObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1183:4: (lv_newObject_7_0= ruleCreatedObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1184:5: lv_newObject_7_0= ruleCreatedObject
                    {

                    					markComposite(elementTypeProvider.getAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3695);
                    ruleCreatedObject();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1194:3: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1194:3: ( ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1195:4: ( (otherlv_8= RULE_ID ) ) ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1195:4: ( (otherlv_8= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1196:5: (otherlv_8= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1196:5: (otherlv_8= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1197:6: otherlv_8= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAssignmentValue3749); 

                    						doneLeaf(otherlv_8, elementTypeProvider.getAssignmentValue_ImportImportCrossReference_3_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1206:4: ( (lv_impFrag_9_0= RULE_FRAGMENT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1207:5: (lv_impFrag_9_0= RULE_FRAGMENT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1207:5: (lv_impFrag_9_0= RULE_FRAGMENT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1208:6: lv_impFrag_9_0= RULE_FRAGMENT
                    {

                    						markLeaf();
                    					
                    lv_impFrag_9_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3794); 

                    						doneLeaf(lv_impFrag_9_0, elementTypeProvider.getAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0ElementType());
                    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1222:1: entryRuleListAssignmentValue : ruleListAssignmentValue EOF ;
    public final void entryRuleListAssignmentValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1222:29: ( ruleListAssignmentValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1223:2: ruleListAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getListAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3832);
            ruleListAssignmentValue();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListAssignmentValue3838); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1231:1: ruleListAssignmentValue : ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1231:24: ( ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1232:2: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1232:2: ( ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1233:3: ( (lv_index_0_0= RULE_INT ) ) otherlv_1= ':' ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1233:3: ( (lv_index_0_0= RULE_INT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1234:4: (lv_index_0_0= RULE_INT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1234:4: (lv_index_0_0= RULE_INT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1235:5: lv_index_0_0= RULE_INT
            {

            					markLeaf();
            				
            lv_index_0_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue3874); 

            					doneLeaf(lv_index_0_0, elementTypeProvider.getListAssignmentValue_IndexINTTerminalRuleCall_0_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleListAssignmentValue3899); 

            			doneLeaf(otherlv_1, elementTypeProvider.getListAssignmentValue_ColonKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1251:3: ( (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' ) | ( (lv_value_5_0= RULE_STRING ) ) | ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? ) | ( (lv_newObject_12_0= ruleCreatedObject ) ) | ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) ) )
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

                if ( (LA27_3==EOF||LA27_3==19||LA27_3==28||(LA27_3>=30 && LA27_3<=31)) ) {
                    alt27=3;
                }
                else if ( (LA27_3==RULE_FRAGMENT) ) {
                    alt27=5;
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1252:4: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1252:4: (otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1253:5: otherlv_2= '[' ( (lv_refIndex_3_0= RULE_INT ) ) otherlv_4= ']'
                    {

                    					markLeaf();
                    				
                    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListAssignmentValue3926); 

                    					doneLeaf(otherlv_2, elementTypeProvider.getListAssignmentValue_LeftSquareBracketKeyword_2_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1260:5: ( (lv_refIndex_3_0= RULE_INT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1261:6: (lv_refIndex_3_0= RULE_INT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1261:6: (lv_refIndex_3_0= RULE_INT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1262:7: lv_refIndex_3_0= RULE_INT
                    {

                    							markLeaf();
                    						
                    lv_refIndex_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue3963); 

                    							doneLeaf(lv_refIndex_3_0, elementTypeProvider.getListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0ElementType());
                    						

                    }


                    }


                    					markLeaf();
                    				
                    otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleListAssignmentValue3998); 

                    					doneLeaf(otherlv_4, elementTypeProvider.getListAssignmentValue_RightSquareBracketKeyword_2_0_2ElementType());
                    				

                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1280:4: ( (lv_value_5_0= RULE_STRING ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1280:4: ( (lv_value_5_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1281:5: (lv_value_5_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1281:5: (lv_value_5_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1282:6: lv_value_5_0= RULE_STRING
                    {

                    						markLeaf();
                    					
                    lv_value_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleListAssignmentValue4045); 

                    						doneLeaf(lv_value_5_0, elementTypeProvider.getListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());
                    					

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1292:4: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1292:4: ( ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1293:5: ( (otherlv_6= RULE_ID ) ) (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1293:5: ( (otherlv_6= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1294:6: (otherlv_6= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1294:6: (otherlv_6= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1295:7: otherlv_6= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue4108); 

                    							doneLeaf(otherlv_6, elementTypeProvider.getListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1304:5: (otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )? )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==19) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1305:6: otherlv_7= '.' ( (lv_refFeature_8_0= RULE_ID ) ) (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            {

                            						markLeaf();
                            					
                            otherlv_7=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleListAssignmentValue4151); 

                            						doneLeaf(otherlv_7, elementTypeProvider.getListAssignmentValue_FullStopKeyword_2_2_1_0ElementType());
                            					
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1312:6: ( (lv_refFeature_8_0= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1313:7: (lv_refFeature_8_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1313:7: (lv_refFeature_8_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1314:8: lv_refFeature_8_0= RULE_ID
                            {

                            								markLeaf();
                            							
                            lv_refFeature_8_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue4193); 

                            								doneLeaf(lv_refFeature_8_0, elementTypeProvider.getListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0ElementType());
                            							

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1323:6: (otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']' )?
                            int alt25=2;
                            int LA25_0 = input.LA(1);

                            if ( (LA25_0==29) ) {
                                alt25=1;
                            }
                            switch (alt25) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1324:7: otherlv_9= '[' ( (lv_refIndex_10_0= RULE_INT ) ) otherlv_11= ']'
                                    {

                                    							markLeaf();
                                    						
                                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListAssignmentValue4242); 

                                    							doneLeaf(otherlv_9, elementTypeProvider.getListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0ElementType());
                                    						
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1331:7: ( (lv_refIndex_10_0= RULE_INT ) )
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1332:8: (lv_refIndex_10_0= RULE_INT )
                                    {
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1332:8: (lv_refIndex_10_0= RULE_INT )
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1333:9: lv_refIndex_10_0= RULE_INT
                                    {

                                    									markLeaf();
                                    								
                                    lv_refIndex_10_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleListAssignmentValue4289); 

                                    									doneLeaf(lv_refIndex_10_0, elementTypeProvider.getListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0ElementType());
                                    								

                                    }


                                    }


                                    							markLeaf();
                                    						
                                    otherlv_11=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleListAssignmentValue4334); 

                                    							doneLeaf(otherlv_11, elementTypeProvider.getListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2ElementType());
                                    						

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1353:4: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1353:4: ( (lv_newObject_12_0= ruleCreatedObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1354:5: (lv_newObject_12_0= ruleCreatedObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1354:5: (lv_newObject_12_0= ruleCreatedObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1355:6: lv_newObject_12_0= ruleCreatedObject
                    {

                    						markComposite(elementTypeProvider.getListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType());
                    					
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue4398);
                    ruleCreatedObject();

                    state._fsp--;


                    						doneComposite();
                    					

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1365:4: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1365:4: ( ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1366:5: ( (otherlv_13= RULE_ID ) ) ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1366:5: ( (otherlv_13= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1367:6: (otherlv_13= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1367:6: (otherlv_13= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1368:7: otherlv_13= RULE_ID
                    {

                    							markLeaf();
                    						
                    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListAssignmentValue4461); 

                    							doneLeaf(otherlv_13, elementTypeProvider.getListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType());
                    						

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1377:5: ( (lv_impFrag_14_0= RULE_FRAGMENT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1378:6: (lv_impFrag_14_0= RULE_FRAGMENT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1378:6: (lv_impFrag_14_0= RULE_FRAGMENT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1379:7: lv_impFrag_14_0= RULE_FRAGMENT
                    {

                    							markLeaf();
                    						
                    lv_impFrag_14_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue4513); 

                    							doneLeaf(lv_impFrag_14_0, elementTypeProvider.getListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0ElementType());
                    						

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1394:1: entryRuleSingleAssignmentValue : ruleSingleAssignmentValue EOF ;
    public final void entryRuleSingleAssignmentValue() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1394:31: ( ruleSingleAssignmentValue EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1395:2: ruleSingleAssignmentValue EOF
            {
             markComposite(elementTypeProvider.getSingleAssignmentValueElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue4559);
            ruleSingleAssignmentValue();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSingleAssignmentValue4565); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1403:1: ruleSingleAssignmentValue : ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) ;
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
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1403:26: ( ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1404:2: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1404:2: ( ( (lv_keyword_0_0= 'null' ) ) | ( (lv_value_1_0= RULE_STRING ) ) | ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? ) | ( (lv_newObject_8_0= ruleCreatedObject ) ) | ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) ) )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1405:3: ( (lv_keyword_0_0= 'null' ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1405:3: ( (lv_keyword_0_0= 'null' ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1406:4: (lv_keyword_0_0= 'null' )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1406:4: (lv_keyword_0_0= 'null' )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1407:5: lv_keyword_0_0= 'null'
                    {

                    					markLeaf();
                    				
                    lv_keyword_0_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleSingleAssignmentValue4601); 

                    					doneLeaf(lv_keyword_0_0, elementTypeProvider.getSingleAssignmentValue_KeywordNullKeyword_0_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1417:3: ( (lv_value_1_0= RULE_STRING ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1417:3: ( (lv_value_1_0= RULE_STRING ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1418:4: (lv_value_1_0= RULE_STRING )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1418:4: (lv_value_1_0= RULE_STRING )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1419:5: lv_value_1_0= RULE_STRING
                    {

                    					markLeaf();
                    				
                    lv_value_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue4647); 

                    					doneLeaf(lv_value_1_0, elementTypeProvider.getSingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0ElementType());
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1429:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1429:3: ( ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )? )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1430:4: ( (otherlv_2= RULE_ID ) ) (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1430:4: ( (otherlv_2= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1431:5: (otherlv_2= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1431:5: (otherlv_2= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1432:6: otherlv_2= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4701); 

                    						doneLeaf(otherlv_2, elementTypeProvider.getSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1441:4: (otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )? )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==19) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1442:5: otherlv_3= '.' ( (lv_refFeature_4_0= RULE_ID ) ) (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            {

                            					markLeaf();
                            				
                            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSingleAssignmentValue4738); 

                            					doneLeaf(otherlv_3, elementTypeProvider.getSingleAssignmentValue_FullStopKeyword_2_1_0ElementType());
                            				
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1449:5: ( (lv_refFeature_4_0= RULE_ID ) )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1450:6: (lv_refFeature_4_0= RULE_ID )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1450:6: (lv_refFeature_4_0= RULE_ID )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1451:7: lv_refFeature_4_0= RULE_ID
                            {

                            							markLeaf();
                            						
                            lv_refFeature_4_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4775); 

                            							doneLeaf(lv_refFeature_4_0, elementTypeProvider.getSingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0ElementType());
                            						

                            }


                            }

                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1460:5: (otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']' )?
                            int alt28=2;
                            int LA28_0 = input.LA(1);

                            if ( (LA28_0==29) ) {
                                alt28=1;
                            }
                            switch (alt28) {
                                case 1 :
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1461:6: otherlv_5= '[' ( (lv_refIndex_6_0= RULE_INT ) ) otherlv_7= ']'
                                    {

                                    						markLeaf();
                                    					
                                    otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSingleAssignmentValue4818); 

                                    						doneLeaf(otherlv_5, elementTypeProvider.getSingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0ElementType());
                                    					
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1468:6: ( (lv_refIndex_6_0= RULE_INT ) )
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1469:7: (lv_refIndex_6_0= RULE_INT )
                                    {
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1469:7: (lv_refIndex_6_0= RULE_INT )
                                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1470:8: lv_refIndex_6_0= RULE_INT
                                    {

                                    								markLeaf();
                                    							
                                    lv_refIndex_6_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4860); 

                                    								doneLeaf(lv_refIndex_6_0, elementTypeProvider.getSingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0ElementType());
                                    							

                                    }


                                    }


                                    						markLeaf();
                                    					
                                    otherlv_7=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleSingleAssignmentValue4900); 

                                    						doneLeaf(otherlv_7, elementTypeProvider.getSingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2ElementType());
                                    					

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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1490:3: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1490:3: ( (lv_newObject_8_0= ruleCreatedObject ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1491:4: (lv_newObject_8_0= ruleCreatedObject )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1491:4: (lv_newObject_8_0= ruleCreatedObject )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1492:5: lv_newObject_8_0= ruleCreatedObject
                    {

                    					markComposite(elementTypeProvider.getSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4955);
                    ruleCreatedObject();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1502:3: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1502:3: ( ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1503:4: ( (otherlv_9= RULE_ID ) ) ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1503:4: ( (otherlv_9= RULE_ID ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1504:5: (otherlv_9= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1504:5: (otherlv_9= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1505:6: otherlv_9= RULE_ID
                    {

                    						markLeaf();
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSingleAssignmentValue5009); 

                    						doneLeaf(otherlv_9, elementTypeProvider.getSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType());
                    					

                    }


                    }

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1514:4: ( (lv_impFrag_10_0= RULE_FRAGMENT ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1515:5: (lv_impFrag_10_0= RULE_FRAGMENT )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1515:5: (lv_impFrag_10_0= RULE_FRAGMENT )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1516:6: lv_impFrag_10_0= RULE_FRAGMENT
                    {

                    						markLeaf();
                    					
                    lv_impFrag_10_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue5054); 

                    						doneLeaf(lv_impFrag_10_0, elementTypeProvider.getSingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0ElementType());
                    					

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1530:1: entryRuleCreatedObject : ruleCreatedObject EOF ;
    public final void entryRuleCreatedObject() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1530:23: ( ruleCreatedObject EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1531:2: ruleCreatedObject EOF
            {
             markComposite(elementTypeProvider.getCreatedObjectElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject5092);
            ruleCreatedObject();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreatedObject5098); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1539:1: ruleCreatedObject : ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) ;
    public final void ruleCreatedObject() throws RecognitionException {
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1539:18: ( ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1540:2: ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1540:2: ( ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )? )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1541:3: ( ruleObjectNew | ruleObjectCopy ) ( (lv_name_2_0= RULE_ID ) )? (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1541:3: ( ruleObjectNew | ruleObjectCopy )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1542:4: ruleObjectNew
                    {

                    				markComposite(elementTypeProvider.getCreatedObject_ObjectNewParserRuleCall_0_0ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleObjectNew_in_ruleCreatedObject5125);
                    ruleObjectNew();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1550:4: ruleObjectCopy
                    {

                    				markComposite(elementTypeProvider.getCreatedObject_ObjectCopyParserRuleCall_0_1ElementType());
                    			
                    pushFollow(FollowSets000.FOLLOW_ruleObjectCopy_in_ruleCreatedObject5149);
                    ruleObjectCopy();

                    state._fsp--;


                    				doneComposite();
                    			

                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1558:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1559:4: (lv_name_2_0= RULE_ID )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1559:4: (lv_name_2_0= RULE_ID )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1560:5: lv_name_2_0= RULE_ID
                    {

                    					markLeaf();
                    				
                    lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreatedObject5181); 

                    					doneLeaf(lv_name_2_0, elementTypeProvider.getCreatedObject_NameIDTerminalRuleCall_1_0ElementType());
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1569:3: (otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==13) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1570:4: otherlv_3= '{' ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+ ( (lv_leftMig_6_0= ruleMigration ) )? otherlv_7= '}'
                    {

                    				markLeaf();
                    			
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCreatedObject5213); 

                    				doneLeaf(otherlv_3, elementTypeProvider.getCreatedObject_LeftCurlyBracketKeyword_2_0ElementType());
                    			
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1577:4: ( ( (lv_assignments_4_0= ruleMonoSingleAssignment ) ) | ( (lv_assignments_5_0= ruleMonoListAssignment ) ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=3;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_ID) ) {
                            int LA33_2 = input.LA(2);

                            if ( (LA33_2==27) ) {
                                int LA33_3 = input.LA(3);

                                if ( ((LA33_3>=RULE_ID && LA33_3<=RULE_STRING)||(LA33_3>=33 && LA33_3<=35)) ) {
                                    alt33=1;
                                }
                                else if ( (LA33_3==29) ) {
                                    alt33=2;
                                }


                            }


                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1578:5: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1578:5: ( (lv_assignments_4_0= ruleMonoSingleAssignment ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1579:6: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1579:6: (lv_assignments_4_0= ruleMonoSingleAssignment )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1580:7: lv_assignments_4_0= ruleMonoSingleAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getCreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject5254);
                    	    ruleMonoSingleAssignment();

                    	    state._fsp--;


                    	    							doneComposite();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1590:5: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1590:5: ( (lv_assignments_5_0= ruleMonoListAssignment ) )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1591:6: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    {
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1591:6: (lv_assignments_5_0= ruleMonoListAssignment )
                    	    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1592:7: lv_assignments_5_0= ruleMonoListAssignment
                    	    {

                    	    							markComposite(elementTypeProvider.getCreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0ElementType());
                    	    						
                    	    pushFollow(FollowSets000.FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject5316);
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

                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1602:4: ( (lv_leftMig_6_0= ruleMigration ) )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==36) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1603:5: (lv_leftMig_6_0= ruleMigration )
                            {
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1603:5: (lv_leftMig_6_0= ruleMigration )
                            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1604:6: lv_leftMig_6_0= ruleMigration
                            {

                            						markComposite(elementTypeProvider.getCreatedObject_LeftMigMigrationParserRuleCall_2_2_0ElementType());
                            					
                            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_ruleCreatedObject5370);
                            ruleMigration();

                            state._fsp--;


                            						doneComposite();
                            					

                            }


                            }
                            break;

                    }


                    				markLeaf();
                    			
                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCreatedObject5401); 

                    				doneLeaf(otherlv_7, elementTypeProvider.getCreatedObject_RightCurlyBracketKeyword_2_3ElementType());
                    			

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1625:1: entryRuleObjectNew : ruleObjectNew EOF ;
    public final void entryRuleObjectNew() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1625:19: ( ruleObjectNew EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1626:2: ruleObjectNew EOF
            {
             markComposite(elementTypeProvider.getObjectNewElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectNew_in_entryRuleObjectNew5427);
            ruleObjectNew();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectNew5433); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1634:1: ruleObjectNew : (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) ;
    public final void ruleObjectNew() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_impFrag_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1634:14: ( (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1635:2: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1635:2: (otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1636:3: otherlv_0= 'new' ( (otherlv_1= RULE_ID ) ) ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleObjectNew5456); 

            			doneLeaf(otherlv_0, elementTypeProvider.getObjectNew_NewKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1643:3: ( (otherlv_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1644:4: (otherlv_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1644:4: (otherlv_1= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1645:5: otherlv_1= RULE_ID
            {

            					markLeaf();
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectNew5483); 

            					doneLeaf(otherlv_1, elementTypeProvider.getObjectNew_ImportImportCrossReference_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1654:3: ( (lv_impFrag_2_0= RULE_FRAGMENT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1655:4: (lv_impFrag_2_0= RULE_FRAGMENT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1655:4: (lv_impFrag_2_0= RULE_FRAGMENT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1656:5: lv_impFrag_2_0= RULE_FRAGMENT
            {

            					markLeaf();
            				
            lv_impFrag_2_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectNew5521); 

            					doneLeaf(lv_impFrag_2_0, elementTypeProvider.getObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1669:1: entryRuleObjectCopy : ruleObjectCopy EOF ;
    public final void entryRuleObjectCopy() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1669:20: ( ruleObjectCopy EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1670:2: ruleObjectCopy EOF
            {
             markComposite(elementTypeProvider.getObjectCopyElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy5552);
            ruleObjectCopy();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectCopy5558); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1678:1: ruleObjectCopy : (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) ;
    public final void ruleObjectCopy() throws RecognitionException {
        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_fragment_2_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1678:15: ( (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1679:2: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1679:2: (otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1680:3: otherlv_0= 'copy' ( (otherlv_1= RULE_ID ) ) ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleObjectCopy5581); 

            			doneLeaf(otherlv_0, elementTypeProvider.getObjectCopy_CopyKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1687:3: ( (otherlv_1= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1688:4: (otherlv_1= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1688:4: (otherlv_1= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1689:5: otherlv_1= RULE_ID
            {

            					markLeaf();
            				
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectCopy5608); 

            					doneLeaf(otherlv_1, elementTypeProvider.getObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType());
            				

            }


            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1698:3: ( (lv_fragment_2_0= RULE_FRAGMENT ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1699:4: (lv_fragment_2_0= RULE_FRAGMENT )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1699:4: (lv_fragment_2_0= RULE_FRAGMENT )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1700:5: lv_fragment_2_0= RULE_FRAGMENT
            {

            					markLeaf();
            				
            lv_fragment_2_0=(Token)match(input,RULE_FRAGMENT,FollowSets000.FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy5646); 

            					doneLeaf(lv_fragment_2_0, elementTypeProvider.getObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0ElementType());
            				

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1713:1: entryRuleMigration : ruleMigration EOF ;
    public final void entryRuleMigration() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1713:19: ( ruleMigration EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1714:2: ruleMigration EOF
            {
             markComposite(elementTypeProvider.getMigrationElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleMigration_in_entryRuleMigration5677);
            ruleMigration();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMigration5683); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1722:1: ruleMigration : ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) ;
    public final void ruleMigration() throws RecognitionException {
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1722:14: ( ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1723:2: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1723:2: ( () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1724:3: () otherlv_1= 'migrate' ( (lv_first_2_0= ruleExecutable ) )? ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )? otherlv_7= ';'
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1724:3: ()
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1725:4: 
            {

            				precedeComposite(elementTypeProvider.getMigration_MigrationAction_0ElementType());
            				doneComposite();
            			

            }


            			markLeaf();
            		
            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleMigration5719); 

            			doneLeaf(otherlv_1, elementTypeProvider.getMigration_MigrateKeyword_1ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1737:3: ( (lv_first_2_0= ruleExecutable ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_STRING||LA36_0==18) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1738:4: (lv_first_2_0= ruleExecutable )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1738:4: (lv_first_2_0= ruleExecutable )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1739:5: lv_first_2_0= ruleExecutable
                    {

                    					markComposite(elementTypeProvider.getMigration_FirstExecutableParserRuleCall_2_0ElementType());
                    				
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration5746);
                    ruleExecutable();

                    state._fsp--;


                    					doneComposite();
                    				

                    }


                    }
                    break;

            }

            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1748:3: ( (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) ) | (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) ) )?
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1749:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1749:4: (otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1750:5: otherlv_3= 'as' ( (lv_asOp_4_0= ruleExecutable ) )
                    {

                    					markLeaf();
                    				
                    otherlv_3=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMigration5785); 

                    					doneLeaf(otherlv_3, elementTypeProvider.getMigration_AsKeyword_3_0_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1757:5: ( (lv_asOp_4_0= ruleExecutable ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1758:6: (lv_asOp_4_0= ruleExecutable )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1758:6: (lv_asOp_4_0= ruleExecutable )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1759:7: lv_asOp_4_0= ruleExecutable
                    {

                    							markComposite(elementTypeProvider.getMigration_AsOpExecutableParserRuleCall_3_0_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration5822);
                    ruleExecutable();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1770:4: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1770:4: (otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1771:5: otherlv_5= 'each' ( (lv_eachOp_6_0= ruleExecutable ) )
                    {

                    					markLeaf();
                    				
                    otherlv_5=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMigration5876); 

                    					doneLeaf(otherlv_5, elementTypeProvider.getMigration_EachKeyword_3_1_0ElementType());
                    				
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1778:5: ( (lv_eachOp_6_0= ruleExecutable ) )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1779:6: (lv_eachOp_6_0= ruleExecutable )
                    {
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1779:6: (lv_eachOp_6_0= ruleExecutable )
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1780:7: lv_eachOp_6_0= ruleExecutable
                    {

                    							markComposite(elementTypeProvider.getMigration_EachOpExecutableParserRuleCall_3_1_1_0ElementType());
                    						
                    pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_ruleMigration5913);
                    ruleExecutable();

                    state._fsp--;


                    							doneComposite();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            			markLeaf();
            		
            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMigration5954); 

            			doneLeaf(otherlv_7, elementTypeProvider.getMigration_SemicolonKeyword_4ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1802:1: entryRuleExecutable : ruleExecutable EOF ;
    public final void entryRuleExecutable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1802:20: ( ruleExecutable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1803:2: ruleExecutable EOF
            {
             markComposite(elementTypeProvider.getExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExecutable_in_entryRuleExecutable5974);
            ruleExecutable();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExecutable5980); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1811:1: ruleExecutable : ( ruleJavaExecutable | ruleExpressionExecutable ) ;
    public final void ruleExecutable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1811:15: ( ( ruleJavaExecutable | ruleExpressionExecutable ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1812:2: ( ruleJavaExecutable | ruleExpressionExecutable )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1812:2: ( ruleJavaExecutable | ruleExpressionExecutable )
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
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1813:3: ruleJavaExecutable
                    {

                    			markComposite(elementTypeProvider.getExecutable_JavaExecutableParserRuleCall_0ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleJavaExecutable_in_ruleExecutable6001);
                    ruleJavaExecutable();

                    state._fsp--;


                    			doneComposite();
                    		

                    }
                    break;
                case 2 :
                    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1821:3: ruleExpressionExecutable
                    {

                    			markComposite(elementTypeProvider.getExecutable_ExpressionExecutableParserRuleCall_1ElementType());
                    		
                    pushFollow(FollowSets000.FOLLOW_ruleExpressionExecutable_in_ruleExecutable6021);
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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1832:1: entryRuleJavaExecutable : ruleJavaExecutable EOF ;
    public final void entryRuleJavaExecutable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1832:24: ( ruleJavaExecutable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1833:2: ruleJavaExecutable EOF
            {
             markComposite(elementTypeProvider.getJavaExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable6041);
            ruleJavaExecutable();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJavaExecutable6047); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1841:1: ruleJavaExecutable : (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) ;
    public final void ruleJavaExecutable() throws RecognitionException {
        Token otherlv_0=null;
        Token lv_method_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1841:19: ( (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1842:2: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1842:2: (otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')' )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1843:3: otherlv_0= 'java' ( (lv_method_1_0= RULE_ID ) ) otherlv_2= '(' otherlv_3= ')'
            {

            			markLeaf();
            		
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJavaExecutable6070); 

            			doneLeaf(otherlv_0, elementTypeProvider.getJavaExecutable_JavaKeyword_0ElementType());
            		
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1850:3: ( (lv_method_1_0= RULE_ID ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1851:4: (lv_method_1_0= RULE_ID )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1851:4: (lv_method_1_0= RULE_ID )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1852:5: lv_method_1_0= RULE_ID
            {

            					markLeaf();
            				
            lv_method_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleJavaExecutable6097); 

            					doneLeaf(lv_method_1_0, elementTypeProvider.getJavaExecutable_MethodIDTerminalRuleCall_1_0ElementType());
            				

            }


            }


            			markLeaf();
            		
            otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleJavaExecutable6122); 

            			doneLeaf(otherlv_2, elementTypeProvider.getJavaExecutable_LeftParenthesisKeyword_2ElementType());
            		

            			markLeaf();
            		
            otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleJavaExecutable6136); 

            			doneLeaf(otherlv_3, elementTypeProvider.getJavaExecutable_RightParenthesisKeyword_3ElementType());
            		

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1879:1: entryRuleExpressionExecutable : ruleExpressionExecutable EOF ;
    public final void entryRuleExpressionExecutable() throws RecognitionException {
        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1879:30: ( ruleExpressionExecutable EOF )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1880:2: ruleExpressionExecutable EOF
            {
             markComposite(elementTypeProvider.getExpressionExecutableElementType()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable6156);
            ruleExpressionExecutable();

            state._fsp--;

             doneComposite(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpressionExecutable6162); 

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
    // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1888:1: ruleExpressionExecutable : ( (lv_exprstr_0_0= RULE_STRING ) ) ;
    public final void ruleExpressionExecutable() throws RecognitionException {
        Token lv_exprstr_0_0=null;

        try {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1888:25: ( ( (lv_exprstr_0_0= RULE_STRING ) ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1889:2: ( (lv_exprstr_0_0= RULE_STRING ) )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1889:2: ( (lv_exprstr_0_0= RULE_STRING ) )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1890:3: (lv_exprstr_0_0= RULE_STRING )
            {
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1890:3: (lv_exprstr_0_0= RULE_STRING )
            // ../../intellij/org.eclipse.xtext.core.idea.tests/src-gen/org/eclipse/xtext/parser/epatch/idea/parser/antlr/internal/PsiInternalEpatchTestLanguage.g:1891:4: lv_exprstr_0_0= RULE_STRING
            {

            				markLeaf();
            			
            lv_exprstr_0_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleExpressionExecutable6191); 

            				doneLeaf(lv_exprstr_0_0, elementTypeProvider.getExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0ElementType());
            			

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
        public static final BitSet FOLLOW_ruleEPatch_in_entryRuleEPatch54 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPatch60 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleEPatch83 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEPatch110 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleEPatch135 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_ruleImport_in_ruleEPatch162 = new BitSet(new long[]{0x000000000440C000L});
        public static final BitSet FOLLOW_ruleNamedResource_in_ruleEPatch201 = new BitSet(new long[]{0x0000000004404000L});
        public static final BitSet FOLLOW_ruleObjectRef_in_ruleEPatch240 = new BitSet(new long[]{0x0000000004004000L});
        public static final BitSet FOLLOW_14_in_ruleEPatch266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport286 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelImport_in_ruleImport313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaImport_in_ruleImport333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExtensionImport_in_ruleImport353 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModelImport_in_entryRuleModelImport373 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModelImport379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceImport_in_ruleModelImport400 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageImport_in_ruleModelImport420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleResourceImport_in_entryRuleResourceImport440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleResourceImport446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleResourceImport469 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleResourceImport496 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleResourceImport521 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleResourceImport548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEPackageImport_in_entryRuleEPackageImport579 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEPackageImport585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleEPackageImport608 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEPackageImport635 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleEPackageImport660 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEPackageImport687 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaImport_in_entryRuleJavaImport718 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJavaImport724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleJavaImport747 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJavaImport761 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport788 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleJavaImport819 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaImport851 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_ruleExtensionImport_in_entryRuleExtensionImport890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExtensionImport896 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleExtensionImport919 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleExtensionImport933 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport960 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_21_in_ruleExtensionImport991 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleExtensionImport1023 = new BitSet(new long[]{0x0000000000200002L});
        public static final BitSet FOLLOW_ruleNamedResource_in_entryRuleNamedResource1062 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNamedResource1068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleNamedResource1091 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleNamedResource1118 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleNamedResource1143 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleNamedResource1157 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_16_in_ruleNamedResource1184 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1221 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1283 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedResource1315 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleNamedResource1329 = new BitSet(new long[]{0x0000000C00010000L});
        public static final BitSet FOLLOW_16_in_ruleNamedResource1356 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleNamedResource1393 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleNamedResource1455 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleNamedResource1487 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleNamedResource1501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectRef_in_entryRuleObjectRef1521 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectRef1527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleObjectRef1550 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1577 = new BitSet(new long[]{0x0000000000800010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1633 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1685 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_23_in_ruleObjectRef1739 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1776 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1828 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleObjectRef1863 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectRef1900 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectRef1952 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleObjectRef1998 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleBiSingleAssignment_in_ruleObjectRef2039 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_ruleBiListAssignment_in_ruleObjectRef2101 = new BitSet(new long[]{0x0000000002804010L});
        public static final BitSet FOLLOW_23_in_ruleObjectRef2147 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2184 = new BitSet(new long[]{0x0000000002004000L});
        public static final BitSet FOLLOW_25_in_ruleObjectRef2230 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleObjectRef2267 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleObjectRef2306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBiSingleAssignment_in_entryRuleBiSingleAssignment2332 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBiSingleAssignment2338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBiSingleAssignment2374 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBiSingleAssignment2399 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2426 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleBiSingleAssignment2451 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleBiSingleAssignment2478 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleBiSingleAssignment2503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBiListAssignment_in_entryRuleBiListAssignment2523 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBiListAssignment2529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBiListAssignment2565 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleBiListAssignment2590 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleBiListAssignment2604 = new BitSet(new long[]{0x0000000010000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2639 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_30_in_ruleBiListAssignment2676 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2713 = new BitSet(new long[]{0x0000000050000000L});
        public static final BitSet FOLLOW_28_in_ruleBiListAssignment2755 = new BitSet(new long[]{0x0000000080000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2790 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleBiListAssignment2827 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_ruleBiListAssignment2864 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_31_in_ruleBiListAssignment2906 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleBiListAssignment2920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_entryRuleMonoSingleAssignment2940 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMonoSingleAssignment2946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMonoSingleAssignment2982 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMonoSingleAssignment3007 = new BitSet(new long[]{0x0000000E00010030L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_ruleMonoSingleAssignment3034 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMonoSingleAssignment3059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMonoListAssignment_in_entryRuleMonoListAssignment3079 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMonoListAssignment3085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMonoListAssignment3121 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMonoListAssignment3146 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleMonoListAssignment3160 = new BitSet(new long[]{0x0000000C80010030L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment3195 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_30_in_ruleMonoListAssignment3232 = new BitSet(new long[]{0x0000000C00010030L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_ruleMonoListAssignment3269 = new BitSet(new long[]{0x00000000C0000000L});
        public static final BitSet FOLLOW_31_in_ruleMonoListAssignment3311 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMonoListAssignment3325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAssignmentValue_in_entryRuleAssignmentValue3345 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentValue3351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAssignmentValue3387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3441 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleAssignmentValue3478 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3515 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleAssignmentValue3558 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleAssignmentValue3600 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleAssignmentValue3640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleAssignmentValue3695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAssignmentValue3749 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleAssignmentValue3794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListAssignmentValue_in_entryRuleListAssignmentValue3832 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListAssignmentValue3838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3874 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleListAssignmentValue3899 = new BitSet(new long[]{0x0000000C20010030L});
        public static final BitSet FOLLOW_29_in_ruleListAssignmentValue3926 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue3963 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleListAssignmentValue3998 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleListAssignmentValue4045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue4108 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleListAssignmentValue4151 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue4193 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleListAssignmentValue4242 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleListAssignmentValue4289 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleListAssignmentValue4334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleListAssignmentValue4398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListAssignmentValue4461 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleListAssignmentValue4513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSingleAssignmentValue_in_entryRuleSingleAssignmentValue4559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSingleAssignmentValue4565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleSingleAssignmentValue4601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSingleAssignmentValue4647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4701 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_19_in_ruleSingleAssignmentValue4738 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue4775 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_29_in_ruleSingleAssignmentValue4818 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleSingleAssignmentValue4860 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleSingleAssignmentValue4900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_ruleSingleAssignmentValue4955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSingleAssignmentValue5009 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleSingleAssignmentValue5054 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreatedObject_in_entryRuleCreatedObject5092 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreatedObject5098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectNew_in_ruleCreatedObject5125 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_ruleObjectCopy_in_ruleCreatedObject5149 = new BitSet(new long[]{0x0000000000002012L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreatedObject5181 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_13_in_ruleCreatedObject5213 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleMonoSingleAssignment_in_ruleCreatedObject5254 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_ruleMonoListAssignment_in_ruleCreatedObject5316 = new BitSet(new long[]{0x0000001000004010L});
        public static final BitSet FOLLOW_ruleMigration_in_ruleCreatedObject5370 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCreatedObject5401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectNew_in_entryRuleObjectNew5427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectNew5433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleObjectNew5456 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectNew5483 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectNew5521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectCopy_in_entryRuleObjectCopy5552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectCopy5558 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleObjectCopy5581 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectCopy5608 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_FRAGMENT_in_ruleObjectCopy5646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMigration_in_entryRuleMigration5677 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMigration5683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMigration5719 = new BitSet(new long[]{0x0000006001040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration5746 = new BitSet(new long[]{0x0000006001000000L});
        public static final BitSet FOLLOW_37_in_ruleMigration5785 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration5822 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_38_in_ruleMigration5876 = new BitSet(new long[]{0x0000000000040020L});
        public static final BitSet FOLLOW_ruleExecutable_in_ruleMigration5913 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMigration5954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExecutable_in_entryRuleExecutable5974 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExecutable5980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaExecutable_in_ruleExecutable6001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionExecutable_in_ruleExecutable6021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJavaExecutable_in_entryRuleJavaExecutable6041 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJavaExecutable6047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleJavaExecutable6070 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleJavaExecutable6097 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleJavaExecutable6122 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleJavaExecutable6136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpressionExecutable_in_entryRuleExpressionExecutable6156 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpressionExecutable6162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleExpressionExecutable6191 = new BitSet(new long[]{0x0000000000000002L});
    }


}